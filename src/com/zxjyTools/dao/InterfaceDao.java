package com.zxjyTools.dao;

import java.util.List;

import com.zxjyTools.annotation.MyBatisRepository;
import com.zxjyTools.entity.Interface;

@MyBatisRepository
public interface InterfaceDao {
	
	List<Interface> findAll();
	
	InterfaceDao selectInterface(Integer id);
	
	void deleteInterface(Integer id);
	
	void updateInterface(Interface inter);
	
	Integer insertInterface(Interface inter);
}
