package com.huaweisoft.domain;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.huaweisoft.aop.MyAnnotation;

/**
 * 
 * @author tangzh
 *
 */
public class AopTest {
	@Test
	public void aopTest(){
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext("com.huaweisoft.aop");
		show();
	}
	@MyAnnotation
	public void show(){
		System.out.println("hello");
	}
	
}
