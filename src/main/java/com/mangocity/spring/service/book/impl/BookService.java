package com.mangocity.spring.service.book.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;

import static com.google.common.base.Preconditions.*;

import com.mangocity.spring.dao.book.IBookDao;
import com.mangocity.spring.domain.Book;
import com.mangocity.spring.service.base.IBaseService;
import com.mangocity.spring.service.book.IBookService;

/**
 * BookService
 * @author mbr.yangjie
 */
public class BookService extends IBaseService implements IBookService{

	private static Logger LOGGER = Logger.getLogger(BookService.class);
	
	@Resource(name = "bookDao")
	private IBookDao<Book> bookDao;
	/**
	 * 根据作者检索所有书籍
	 */
	public List<Book> findAllBookByAuthor(String authorName) {
		LOGGER.info("BookService findAllBookByAuthor begin()..." + authorName);
		checkNotNull(authorName, "authorName can't be empty.");
		Book book = new Book();
		book.setAuthor(authorName);
		return bookDao.findAll(book);
	}
	

}
