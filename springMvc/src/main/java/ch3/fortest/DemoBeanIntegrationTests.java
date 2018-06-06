package ch3.fortest;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by qilin.liu on 2018/4/12.
 */
@RunWith(SpringJUnit4ClassRunner.class) //1
@ContextConfiguration(classes = {TestConfig.class}) //2
@ActiveProfiles("prod") //3
public class DemoBeanIntegrationTests {
    @Autowired //4
    private TestBean testBean;

    @Test //5
    public void prodBeanShoudInject(){
        String expected = "from production Profile";
        String actual =  testBean.getContent();
        Assert.assertEquals(expected,actual);
    }
}

//1 SpringJUnit4ClassRunner在Junit环境下提供Spring TestContent Framework的功能
//2 @ContextConfiguration用来加载配置ApplicationContext,其中class属性用来加载配置类
//3 ActiveProfile用来声明活动的profile
//4 可使用普通的@Autowrite注入Bean
//5 测试代码，通过Junit的Assert类来校验结果是否和预期的一样