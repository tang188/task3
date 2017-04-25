package com.huaweisoft.aop;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

public class AopInterceptor {
	public static Logger logger=(Logger) LoggerFactory.getLogger(AopInterceptor.class);
    @Pointcut("execution(* com.huaweisoft.aop.*(..))")  
    private void anyMethod(){}//定义一个切入点  
    
    @Before("anyMethod()")  
    public void doAccessCheck(String name){    
        logger.error("前置通知"); 
        System.out.println("iiiiiiii");
    }  
    
      
    @AfterReturning("anyMethod()")  
    public void doAfter(){  
       logger.error("后置通知");  
    }  
      
    @After("anyMethod()")  
    public void after(){  
    	logger.error("最终通知");  
    }  
      
    @AfterThrowing("anyMethod()")  
    public void doAfterThrow(){  
    	logger.info("例外通知");  
    }  
      
    @Around("anyMethod()")  
    public Object doBasicProfiling(ProceedingJoinPoint pjp) throws Throwable{  
    	logger.info("进入环绕通知");  
        Object object = pjp.proceed();//执行该方法  
        logger.info("退出方法");  
        return object;  
    }
}
