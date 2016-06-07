package com.mangocity.spring.test;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mangocity.spring.dao.book.IBookDao;


public class NameParameterJdbcTemplateTest {

	@Test
	public void testA(){
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		IBookDao bookDao = (IBookDao) applicationContext.getBean("bookDao");
		System.out.println(bookDao);
	}
}
