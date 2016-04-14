package com.zxjyTools.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zxjyTools.dao.InterfaceCategoryDao;
import com.zxjyTools.entity.InterfaceCategory;

@Service("interfaceCategoryService")
public class InterfaceCategoryServiceImpl implements InterfaceCategoryService{

	@Autowired
	private InterfaceCategoryDao interfaceCategoryDao;
	
	public InterfaceCategoryServiceImpl() {
		
	}
	
	public Integer add(Object obj) {
		return interfaceCategoryDao.insertInterfaceCategory((InterfaceCategory)obj);
	}

	public void update(Object obj) {
		interfaceCategoryDao.updateInterfaceCategory((InterfaceCategory)obj);
	}

	public Object select(Integer id) {
		return interfaceCategoryDao.selectInterfaceCategory(id);
	}

	public void delete(Integer id) {
		interfaceCategoryDao.deleteInterfaceCategory(id);
	}

	public List<InterfaceCategory> findAll() {		
		return interfaceCategoryDao.findAll();
	}

}
