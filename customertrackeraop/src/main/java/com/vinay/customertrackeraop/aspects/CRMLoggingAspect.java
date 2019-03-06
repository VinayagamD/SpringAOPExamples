package com.vinay.customertrackeraop.aspects;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CRMLoggingAspect {
//	setup logger
	private Logger logger = Logger.getLogger(getClass().getName());
	
//	setup pointcut declarations
	@Pointcut("execution(* com.vinay.customertrackeraop.controller.*.*(..))")
	private void forControllerPackage() {
		
	}
	
//	do the same for the services
	@Pointcut("execution(* com.vinay.customertrackeraop.service.*.*(..))")
	private void forServicePackage() {
		
	}
	
	
	@Pointcut("execution(* com.vinay.customertrackeraop.dao.*.*(..))")
	private void forDAOPackage() {
		
	}
	
	@Pointcut("forControllerPackage() || forServicePackage() || forDAOPackage()")
	private void forAppFlow() {
		
	}
	
	
//	add @Before advice
	@Before("forAppFlow()")
	public void before(JoinPoint joinPoint) {
//		 display the method calling
		String method = joinPoint.getSignature().toShortString();
		logger.info("=========>>> in @Before: calling method: " + method);
		
//		display the arguments to the method
		
//		get the arguments 
		Object[] args = joinPoint.getArgs();
		
//		loop through and display the arguments
		Consumer<Object> argConsumer = (arg) -> logger.info("==========>  argument: " + arg);
		
		Arrays.asList(args).forEach(argConsumer);
					
	}
	
	
//	add @AfterReturning advice
	@AfterReturning(pointcut = "forAppFlow()",
					returning= "result")
	public void afterReturning(JoinPoint joinPoint, Object result) {
//		display method we are returning from
		String method = joinPoint.getSignature().toShortString();
		logger.info("=========>>> in @AfterReturning: from method: " + method);
		
//		display the data returned
		logger.info("=========>>> result: " + result);
		
	}
	
}
