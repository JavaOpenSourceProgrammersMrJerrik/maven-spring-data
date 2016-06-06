package com.mangocity.spring.service.book.impl;

import java.util.List;

import com.mangocity.spring.domain.Book;

public interface IBookService{

	public List<Book> findAllBookByAuthor(String authorName);
	
}
