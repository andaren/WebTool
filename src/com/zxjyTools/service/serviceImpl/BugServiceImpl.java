package com.zxjyTools.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zxjyTools.dao.BugDao;
import com.zxjyTools.service.BugService;

@Service("bugService")
public class BugServiceImpl implements BugService{

	@Autowired
	private BugDao bugDao;
	
	
}
