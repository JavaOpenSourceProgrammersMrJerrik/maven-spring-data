package com.mangocity.spring.postprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class HelloPostProcessor implements BeanPostProcessor {

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName)
			throws BeansException {
		System.out.println("HelloPostProcessor post before()" + beanName + "调用初始化方法之前的数据： "
				+ bean.toString());
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) {
		System.out.println("HelloPostProcessor post after()" + beanName + "调用初始化方法之后的数据："
				+ bean.toString());
		return bean;
	}

}
