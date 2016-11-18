package com.mangocity.spring.proxy;

import java.util.Arrays;

public class HelloServiceImpl implements IHelloService {

	@Override
	public void sayHello(String[] hints) {
		System.out.println("HelloServiceImpl begin{}..." + Arrays.toString(hints));
	}

}
