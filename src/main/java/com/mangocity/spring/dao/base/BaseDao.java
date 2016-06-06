package com.mangocity.spring.dao.base;

import java.util.List;

/**
 * BaseDao
 * @author mbr.yangjie
 */
public interface BaseDao<T> {

	public T findById(Long id);

	public List<T> findAll(T t);
	
	public List<T> findByCondition(T t);

	public int insertOne(T t);

	public int updateOne(T t);

	public int deleteOne(T t);
}
