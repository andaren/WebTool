package com.zxjyTools.dao;

import java.util.List;

import com.zxjyTools.annotation.MyBatisRepository;
import com.zxjyTools.entity.InterfaceCategory;

@MyBatisRepository
public interface InterfaceCategoryDao {

	List<InterfaceCategory> findAll();
	
	InterfaceCategory selectInterfaceCategory(Integer id);
	
	void deleteInterfaceCategory(Integer id);
	
	void updateInterfaceCategory(InterfaceCategory interfaceCategory);
	
	Integer insertInterfaceCategory(InterfaceCategory interfaceCategory);
}
