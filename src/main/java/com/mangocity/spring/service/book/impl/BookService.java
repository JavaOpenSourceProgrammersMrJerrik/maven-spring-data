package com.mangocity.spring.service.book.impl;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;

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
	private IBookDao bookDao;
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
	
	public Book findById(Long id){
		LOGGER.info("BookService findById begin()..." + id);
		return this.bookDao.findById(id);
	}
	
	
	public int updateBook(Book book){
		LOGGER.info("BookService updateBook begin()..." + book);
		int row = this.bookDao.updateOne(book);
		int i = 1/0;
		return row;
	}

}
