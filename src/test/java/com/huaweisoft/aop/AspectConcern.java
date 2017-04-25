package com.huaweisoft.aop;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect
@Component
public class AspectConcern {
    public final static Logger logger=LoggerFactory.getLogger(AspectConcern.class);
    
	/**
	 * 处理UserController的请求
	 */
	@Pointcut("execution(public * com.huaweisoft.daoImpl.UserDaoImpl.*(..))")
	public void userLog() {
	}
	
	/**
	 * 处理ContactBook的请求
	 */
	//@Pointcut("execution(public * com.huaweisoft.controller.ContactBookController.*(..))")
	@Pointcut("execution(public * com.huaweisoft.daoImpl.ContactBookDaoImpl.*(..))")
	public void contactBookLog() {
	}
    
    @Before("userLog")
    public void doBeforeUser(JoinPoint point){
    	ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
		HttpServletRequest httpServletRequest = servletRequestAttributes.getRequest();
		String id = httpServletRequest.getParameter("id");
		String name = httpServletRequest.getParameter("name");
		String sex = httpServletRequest.getParameter("sex");
		logger.info("id: " + id);
		logger.info("name: " + name);
		logger.info("sex: " + sex);
    }

	/**
	 * 打印返回值
	 * @param object
	 */
	@AfterReturning(returning = "object", pointcut = "userLog()")
	public void doAfterRetruningUser(Object object) {
		logger.info("response={}", object);
	}
    
	/**
	 * 打印传入的参数
	 * @param joinPoint
	 */
	@Before("contactBookLog()")
	public void doBeforeContactBook(JoinPoint joinPoint) {
		ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
		HttpServletRequest httpServletRequest = servletRequestAttributes.getRequest();
		String id = httpServletRequest.getParameter("id");
		String userId = httpServletRequest.getParameter("userId");
		String type = httpServletRequest.getParameter("type");
		String contact = httpServletRequest.getParameter("contact");
		logger.info("id: " + id);
		logger.info("userId: " + userId);
		logger.info("type: " + type);
		logger.info("contact: " + contact);
	}
	
	/**
	 * 打印返回值
	 * @param object
	 */
	@AfterReturning(returning = "object", pointcut = "contactBookLog()")
	public void doAfterRetruningContactBook(Object object) {
		logger.info("response={}", object);
	}
	
//    @Before("@annotation(com.huaweisoft.aop.MyAnnotation)")
//    public void logParamsByAnnotation(JoinPoint point){	
//	//连接点所在的类名、连接点方法
//	String fullJoinPointMethod = point.getSignature().getDeclaringTypeName()+point.getSignature().getName();	
//	System.out.println("Annotation PointCut: call "+fullJoinPointMethod+","+Arrays.toString(point.getArgs()));
//    }
}
