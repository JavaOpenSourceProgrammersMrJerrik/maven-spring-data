package com.mangocity.spring.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.common.collect.Lists;
import com.mangocity.spring.domain.Book;

@Controller
@RequestMapping("/book")
public class BookController {
	private static final Logger LOGGER = Logger.getLogger(BookController.class);

	@ResponseBody
	@RequestMapping(value = "/list.action")
	public List<Book> queryAllBooks() {
		LOGGER.info("queryAllBooks begin()...");
		List<Book> bookList = Lists.newArrayList();
		Book book = new Book();
		book.setId(10L);
		book.setBookName("java并发");
		book.setAuthor("Doug lea");
		book.setDesc("非常透彻");
		bookList.add(book);
		return bookList;
	}
}
