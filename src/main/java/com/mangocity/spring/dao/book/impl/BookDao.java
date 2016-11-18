package com.mangocity.spring.dao.book.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.google.common.collect.Maps;
import com.mangocity.spring.common.exception.UtilException;
import com.mangocity.spring.common.util.NameParameterUtils;
import com.mangocity.spring.dao.book.IBookDao;
import com.mangocity.spring.domain.Book;

public class BookDao implements IBookDao {
	private static Logger LOGGER = Logger.getLogger(BookDao.class);

	@Resource(name = "jdbcTemplate")
	private JdbcTemplate jdbcTemplate;

	@Resource(name = "namedParameterJdbcTemplate")
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public Book findById(Long id) {
		return this.jdbcTemplate.queryForObject(
				"select * from t_book where id=?", new Object[] { id },
				new BeanPropertyRowMapper(Book.class));
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
		try {
			sb.append(NameParameterUtils.generateNameParameter(book));
			Map<String, Object> paramMap = Maps.newHashMap();
			return namedParameterJdbcTemplate.query(sb.toString(),
					NameParameterUtils.bean2Map(book), new RowMapper<Book>() {
						@Override
						public Book mapRow(ResultSet rs, int rowNum)
								throws SQLException {
							com.mangocity.spring.domain.Book books = new com.mangocity.spring.domain.Book();
							books.setAuthor(rs.getString(""));
							if (rs.next()) {
							}
							return null;
						}
					});
		} catch (UtilException e) {
			LOGGER.error(e.getMessage(), e);
		}
		return Collections.EMPTY_LIST;
	}

	@Override
	public int insertOne(Book t) {

		return 0;
	}

	@Override
	public int updateOne(Book t) {
		return this.jdbcTemplate.update(
				"update t_book b set b.book_name=?,b.book_type=? where b.id=?",
				new Object[] { t.getBookName(), t.getBookType(), t.getId() });
	}

	@Override
	public int deleteOne(Book t) {

		return 0;
	}

}
