package com.mangocity.spring.dao.book.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import static com.google.common.base.Preconditions.*;
import com.mangocity.spring.dao.book.IBookDao;

public class BookDao<Book> implements IBookDao<Book> {
	
	@Resource(name = "jdbcTemplate")
	private JdbcTemplate jdbcTemplate;
	
	@Resource(name = "namedParameterJdbcTemplate")
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;   
  
	@Override
	public Book findById(Long id) {

		return null;
	}

	@Override
	public List<Book> findAll(Book t) {
		String sql = "select * from t_book b";
		namedParameterJdbcTemplate.query(sql, new RowMapper<Book>() {

			@Override
			public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				return null;
			}
		});
		return null;
	}
	
	@Override
	public List<Book> findByCondition(Book book) {
		String sql = "select * from t_book b where 1 = 1";
		StringBuilder sb = new StringBuilder(sql);
		namedParameterJdbcTemplate.query(sql, new RowMapper<Book>() {

			@Override
			public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				return null;
			}
		});
		return null;
	}

	@Override
	public int insertOne(Book t) {

		return 0;
	}

	@Override
	public int updateOne(Book t) {

		return 0;
	}

	@Override
	public int deleteOne(Book t) {

		return 0;
	}

}
