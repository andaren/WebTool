package com.zxjyTools.service;

import java.util.List;

/**
 * Service»ùÀà
 * @author Administrator
 *
 */
public interface BaseService {

	public List<?> findAll();
	
	public Integer add(Object obj);
	
	public void update(Object obj);
	
	public Object select(Integer id);
	
	public void delete(Integer id);
	
	
}
