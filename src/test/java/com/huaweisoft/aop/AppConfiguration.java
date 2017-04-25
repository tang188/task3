package com.huaweisoft.aop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;


//配置类
@Configuration
@EnableAspectJAutoProxy
public class AppConfiguration {
    
    //注入切面对象
//    @Bean
//    public AspectConcern initStringBuilderF1(){
//	return new AspectConcern();
//    }
    
}
