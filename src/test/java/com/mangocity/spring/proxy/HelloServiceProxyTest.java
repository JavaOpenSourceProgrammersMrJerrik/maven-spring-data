package com.mangocity.spring.proxy;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloServiceProxyTest {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext cxt = new ClassPathXmlApplicationContext("/applicationContext.xml");
		System.out.println(cxt.getBean("&helloProxy"));
		IHelloService helloService = (IHelloService) cxt.getBean("helloProxy");
		helloService.sayHello(new String[]{"good","girl"});
	}
}
