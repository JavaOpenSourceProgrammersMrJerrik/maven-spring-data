package com.mangocity.spring.proxy;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

public class HelloServiceAfterAdvice implements AfterReturningAdvice {

	public void afterReturning(Object result, Method method,
			Object[] parameter, Object target) throws Throwable {
		System.out.println("==============after return==============");
		System.out.println("result:" + result + ";method:" + method
				+ ";parameter:" + parameter + ";target:" + target);
	}

}
