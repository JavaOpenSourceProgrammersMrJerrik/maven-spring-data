package com.mangocity.spring.service.base;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.mangocity.spring.dao.book.IBookDao;

/**
 * 基础服务
 */
public class IBaseService {

	@Resource(name = "jdbcTemplate")
	protected JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
}
