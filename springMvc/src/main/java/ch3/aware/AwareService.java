package ch3.aware;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * Created by qilin.liu on 2018/4/11.
 */
@Service
public class AwareService implements BeanNameAware,ResourceLoaderAware{ //1

    private String beanName;

    private ResourceLoader loader;


    @Override
    public void setBeanName(String name) { //3
        this.beanName = name;
    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) { //2
        this.loader = resourceLoader;
    }

    public void outputResult(){
//        System.out.println(System.getProperty("java.class.path"));
        System.out.println(System.getProperty("user.dir"));
        System.out.println("Bean的名称为:" + beanName);

        Resource resource = loader.getResource("classpath:src/main/ch3/aware/test.txt");
        try {
            System.out.println("ResourceLoader加载的内容为:" + IOUtils.toString(resource.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
//①实现BeanNameAware、ResourceLoaderAware接口，获得Bean名称和资源加载的服务
//②实现ResourceLoaderAware重写setResourceLoader。
//③实现BeanNameAware重写setBeanName方法。
