package com.huaweisoft.test;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.huaweisoft.daoImpl.UserDaoImpl;
import com.huaweisoft.domain.User;

/**
 * 
 * @author tangzh
 *s
 */
public class AopTest {
	@Test
	public void aopTest(){
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext("com.huaweisoft.daoImpl");
		UserDaoImpl imp= context.getBean(UserDaoImpl.class);
		//TestClass testClass=new TestClass();
		User user=imp.selectByPrimaryKey(1);
		Logger logger=LoggerFactory.getLogger(AopTest.class);
		logger.error("testtesttesttesttest");
		System.out.println(user);
	}	
}
