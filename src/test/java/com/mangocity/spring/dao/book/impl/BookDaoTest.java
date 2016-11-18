package com.mangocity.spring.dao.book.impl;

import static org.junit.Assert.fail;
import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mangocity.spring.domain.Book;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")  
public class BookDaoTest {
	@Autowired
	private BookDao bookDao;
	
	@Before
	public void before(){
		Assert.assertNotNull(bookDao);
	}

	@Test
	public void testFindById() {
		Book book = bookDao.findById(1L);
		System.out.println("book: " + book);
	}

	@Test
	public void testFindAll() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindByCondition() {
		fail("Not yet implemented");
	}

	@Test
	public void testInsertOne() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateOne() {
		Book book = new Book();
		book.setId(1L);
		book.setBookName("effective java");
		book.setBookType("Java");
		int row = this.bookDao.updateOne(book);
		System.out.println("影响行数: " + row);
	}

	@Test
	public void testDeleteOne() {
		fail("Not yet implemented");
	}

}
