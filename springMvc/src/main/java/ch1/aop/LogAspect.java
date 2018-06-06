package ch1.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * Created by qilin.liu on 2018/4/10.
 */
@Aspect //1通过Aspect注解声明一个切面
@Component //2 让此切面成为Spring容器管理的Bean
public class LogAspect {

    @Pointcut("@annotation(ch1.aop.Action)") //3 通过PointCut声明切点
    public void annotationPointCut(){};

    @After("annotationPointCut()") //4 通过@After注解声明一个建言,并使用@PointCut定义的切点
    public void after(JoinPoint joinPoint){
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        Action action = method.getAnnotation(Action.class);
        System.out.println("注解式拦截"+action.name()); //5 通过反射可获得注解上的属性，然后做日志相关的操作
    }

    @Before("execution(* ch1.aop.DemoMethodService.*(..))") //6 通过Before注解声明一个建言，此建言直接使用拦截规则做参数
    public void before(JoinPoint joinPoint){
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        System.out.println("方法规则拦截"+method.getName());
    }
}
