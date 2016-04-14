package com.zxjyTools.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zxjyTools.dao.InterfaceDao;
import com.zxjyTools.entity.Interface;
import com.zxjyTools.service.InterfaceService;

@Service("interfaceService")
public class InterfaceServiceImpl implements InterfaceService{

	@Autowired
	private InterfaceDao interfaceDao;

	public Integer add(Object obj) {
		return interfaceDao.insertInterface((Interface)obj);
	}

	public void update(Object obj) {
		interfaceDao.updateInterface((Interface)obj);		
	}

	public Object select(Integer id) {
		return (Interface)interfaceDao.selectInterface(id);
	}

	public void delete(Integer id) {
		interfaceDao.deleteInterface(id);		
	}

	public List<?> findAll() {
		return interfaceDao.findAll();
	}
}
