package com.zxjyTools.dao;

import java.util.List;

import com.zxjyTools.entity.Bug;

public interface BaseDao {

	List<Object> findAll();
	
	Object select(Long id);
	
	void delete(Long id);
	
	void update(Object obj);
	
	Long insert(Object obj);
}
