package com.mangocity.spring.service.book.impl;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mangocity.spring.domain.Book;

public class ClassPathXmlApplicationContextTest {
	private ClassPathXmlApplicationContext cxt;

	@Before
	public void setUp() throws Exception {
		cxt = new ClassPathXmlApplicationContext("/applicationContext.xml");
	}

	@Test
	public void test() {
		Book book = cxt.getBean("book",Book.class);
		System.out.println(book.getBookName());
	}

}
