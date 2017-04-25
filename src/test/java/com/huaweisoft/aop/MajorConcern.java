package com.huaweisoft.aop;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

@Component
public class MajorConcern {
    //不使用AOP
    public BigDecimal add(BigDecimal p1, BigDecimal p2){
	//次要关注点，日志记录
	System.out.println("call MajorConcern.add, p1="+p1.toString()+", p2="+p2.toString());
	//主要关注点，业务逻辑
	return p1.add(p2);
    }
    
  //不使用AOP
    public void voooid(){
	//次要关注点，日志记录
	System.out.println("call voooid");
    }
    
    //使用AOP
    @MyAnnotation //自定义的注解连接点
    public BigDecimal addAop(BigDecimal p1, BigDecimal p2){
	//次要关注点，移到切面
	//System.out.println("call MajorConcern.add, p1="+p1.toString()+", p2="+p2.toString());
	
	//主要关注点，业务逻辑
	return p1.add(p2);
    }
}
