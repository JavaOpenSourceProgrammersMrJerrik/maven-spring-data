package com.mangocity.spring.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AspectTest {

	@Pointcut("execution(* *.test(..))")
	public void test() {
		System.out.println("test()");
	}

	@Before("test()")
	public void beforeTest() {
		System.out.println("beforeTest()");
	}

	@After("test()")
	public void afterTest() {
		System.out.println("afterTest()");
	}
	
	@Around("test()")
	public void aroundTest(ProceedingJoinPoint joinPoint){
		System.out.println("aroud begin{}");
		try {
			joinPoint.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		System.out.println("aroud end{}");
	}
}
