/**
 * 
 */
package com.tutorials.spring.AOP.aspectbean;

import java.util.List;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.tutorials.spring.AOP.bean.Employee;

/**
 * @author Siddhant sahu
 *
 */
@Aspect
@Component
public class LoggingBean {
	private static final Logger LOGGER = Logger.getLogger(LoggingBean.class);

	/*@Before(value = "execution(* *(..))")
	public void beforeLogging(JoinPoint point) {
		System.out.println("Entering Method :" + point.getSignature().getName());
		LOGGER.trace("Entering Method :" + point.getSignature().getName());
	}
	
	@After(value = "execution(* *(..))")
	public void afterLogging(JoinPoint point) {
		System.out.println("After Method :" + point.getSignature().getName());
		LOGGER.trace("After Method :" + point.getSignature().getName());
	}
	
	@AfterThrowing(value = "execution(* *(..))", throwing = "ex")
	public void afterThrowingLogging(JoinPoint point, RuntimeException ex) {
		System.out.println("After Method :" + point.getSignature().getName());
		System.out.println("After throwing Method :--->" + ex);
		LOGGER.trace("After throwing Method :--->" + ex);
	}
	
	@AfterReturning(value = "execution(* *(..))")
	public void afterReturningLogging(JoinPoint point) {
		System.out.println("After Returning Method :" + point.getSignature().getName());
		LOGGER.trace("After Returning Method :" + point.getSignature().getName());
	}*/

	/*@Around(value = "execution(* *(..))")*/
	@Around(value = "execution(* *..*.*Service(..))")
	public Object aroundLogging(ProceedingJoinPoint point) throws Throwable {
		System.out.println("Before Around Method :" + point.getSignature().getName());
		try {
			return point.proceed();
		} catch (Exception e) {
			System.err.println("Throwing error in the method :" + point.getSignature()
					+ " and the Error is :" + e);
			throw e;
		} finally {
			System.out.println("After completing Around Method :" + point.getSignature().getName());
			LOGGER.trace("After completing Around Method :" + point.getSignature().getName());
		}
	}
}
