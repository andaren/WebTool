package com.zxjyTools.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zxjyTools.dao.BugDao;
import com.zxjyTools.service.BugService;

@Service("bugService")
public class BugServiceImpl implements BugService{

	@Autowired
	private BugDao bugDao;

	public List<?> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer add(Object obj) {
		// TODO Auto-generated method stub
		return null;
	}

	public void update(Object obj) {
		// TODO Auto-generated method stub
		
	}

	public Object select(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}
	
	
}
