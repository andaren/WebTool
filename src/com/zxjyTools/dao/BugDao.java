package com.zxjyTools.dao;

import java.util.List;

import com.zxjyTools.annotation.MyBatisRepository;
import com.zxjyTools.entity.Bug;

@MyBatisRepository
public interface BugDao {

	List<Bug> findAll();
	
	Bug selectbug(Long id);
	
	void deleteBug(Long id);
	
	void updateBug(Bug bug);
	
	Long insertBug(Bug bug);
}
