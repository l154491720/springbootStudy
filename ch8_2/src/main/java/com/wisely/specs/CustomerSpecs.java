package com.wisely.specs;




import static com.google.common.collect.Iterables.toArray;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.ReflectionUtils;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.Attribute;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.SingularAttribute;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by qilin.liu on 2018/6/6.
 */
public class CustomerSpecs {
    /*
    1 定义一个返回值类型为Specification的方法byAuto,这里使用的是泛型，所以这个Specification可以用于任何实体类.
    它接受的参数是entityManager和当前的包含值作为查询条件的实体类对象。
     */
    public static <T> Specification<T> byAuto(final EntityManager entityManager,
                                              final T example){
        //2 获得当前实体类对象的类型
        final Class<T> type = (Class<T>) example.getClass();
        return new Specification<T>() {
            @Override
            public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder cb){
                //3 新建Predicate列表存储构造的查询条件
                List<Predicate> predicates=new ArrayList<>();
                //4 获得实体类的entityType，我们可以从EntityType获得实体类的属性
                EntityType<T> entity=entityManager.getMetamodel().entity(type);
                //5 对实体类的所有属性做循环。
                for (Attribute<T,?> attr: entity.getDeclaredAttributes()){
                    //6 获得当前实体类对象的某一个属性值
                    Object attrValue = getValue(example,attr);
                    if(attrValue!=null){
                        //7 当属性值为字符串类型的时候
                        if(attr.getJavaType()==String.class){
                            //8  当前字符串不为空值
                            if(!StringUtils.isEmpty(attrValue)){
                                //9 构造当前属性like(前后%)属性值查询条件，并添加到条件列表中
                                predicates.add(cb.like(root.get(attribute(entity,attr.getName(),String.class)),
                                       pattern((String) attrValue) ));
                            }
                        }else {
                            //10 其余情况下，构造属性和属性值equal查询条件，并添加到条件列表中
                            predicates.add(cb.equal(root.get(attribute(entity,attr.getName(),attr.getClass()))
                                    ,attrValue));
                        }
                    }
                }
                //11 将条件列表转换成Predicate
                return predicates.isEmpty() ? cb.conjunction():
                        cb.and(toArray(predicates,Predicate.class));
            }

            /**
             * 13 获得实体类当前属性的SingularAttribute,  SingularAttribute包含的是实体类的某个单独属性。
             */
            private <Y,T> SingularAttribute<T, Y> attribute(EntityType<T> entity, String name, Class<Y> fieldClass) {

                    return entity.getDeclaredSingularAttribute(name,fieldClass);

            }

            /**
             * 12 通过反射获得实体类对象对应属性的属性值
             */
            private <T> Object getValue(T example, Attribute<T,?> attr){
                return ReflectionUtils.getField((Field) attr.getJavaMember(), example);
            }

        };

    }

    /**
     * 14 构造like的查询模式，即前后加%
     */
    static private String pattern(String str){
        return "%"+str+"%";
    }
}
