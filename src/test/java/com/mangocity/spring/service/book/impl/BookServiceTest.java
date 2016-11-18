package com.mangocity.spring.service.book.impl;

import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mangocity.spring.domain.Book;
import com.mangocity.spring.service.book.IBookService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class BookServiceTest {
	@Autowired
	private IBookService bookService;

	@Test
	public void testFindById() {
		Book book = this.bookService.findById(1L);
		System.out.println("book: " + book);
	}

	@Test
	public void testUpdateBook() {
		fail("Not yet implemented");
	}

	//有事务操作
	@Test
	public void testHandleBook() throws Exception {
		Book book = this.bookService.findById(1L);
		book.setBookName("999");
		book.setBookType("222");
		int row = this.bookService.updateBook(book);
		System.out.println(row);
	}

}
