package com.wisely.support;

import com.wisely.support.impl.CustomerRepositoryImpl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactoryBean;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.core.RepositoryInformation;
import org.springframework.data.repository.core.RepositoryMetadata;
import org.springframework.data.repository.core.support.RepositoryFactorySupport;

import javax.persistence.EntityManager;
import java.io.Serializable;

/**
 * Created by qilin.liu on 2018/6/7.
 */
public class CustomerRepositoryFactoryBean<T extends JpaRepository<S, ID>,S,ID extends Serializable> extends
        JpaRepositoryFactoryBean<T,S,ID>{

    public CustomerRepositoryFactoryBean(Class<? extends T> repositoryInterface) {
        super(repositoryInterface);
    }

    @Override
    protected RepositoryFactorySupport createRepositoryFactory(EntityManager entityManager){
        return new CustomerRepositoryFactory(entityManager);
    }

    private static class CustomerRepositoryFactory extends JpaRepositoryFactory{

        public CustomerRepositoryFactory(EntityManager entityManager) {
            super(entityManager);
        }

        @Override
        @SuppressWarnings("unchecked")
        protected <T , ID extends Serializable> SimpleJpaRepository<?,?> getTargetRepository(
                RepositoryInformation information, EntityManager entityManager){
            return new CustomerRepositoryImpl<T,ID>((Class<T>)information.getDomainType(),entityManager);
        }

        @Override
        protected Class<?> getRepositoryBaseClass(RepositoryMetadata metadata){
                    return CustomerRepositoryImpl.class;
        }

    }

}
