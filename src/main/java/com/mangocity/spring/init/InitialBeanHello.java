package com.mangocity.spring.init;

import org.springframework.beans.factory.InitializingBean;

public class InitialBeanHello implements InitializingBean {

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("InitialBeanHello afterPropertiesSet()...");

	}
	
	public void hello(){
		System.out.println("hello()");
	}

}
