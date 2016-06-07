package com.mangocity.spring.domain;

import java.io.Serializable;
import java.util.Date;

import com.google.common.base.Objects;

/**
 * 书的实体类
 * @author mbr.yangjie
 */
public class Book implements Serializable {

	private static final long serialVersionUID = -6534686676032487188L;

	private Long id;

	private String bookName;

	private String desc;

	private String author;

	/**
	 * 发行日期
	 */
	private Date establishDate;

	/**
	 * 书类型
	 */
	private String bookType;
	
	public Book() {
		super();
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Date getEstablishDate() {
		return establishDate;
	}

	public void setEstablishDate(Date establishDate) {
		this.establishDate = establishDate;
	}

	public String getBookType() {
		return bookType;
	}

	public void setBookType(String bookType) {
		this.bookType = bookType;
	}

	@Override
	@SuppressWarnings("deprecation")
	public String toString() {
		return Objects.toStringHelper(this).add("id", id)
				.add("bookName", bookName).add("author", author)
				.add("establishDate", establishDate).add("bookType", bookType)
				.toString();
	}
}
