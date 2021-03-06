package com.zxjyTools.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zxjyTools.dao.InterfaceDao;
import com.zxjyTools.entity.Interface;
import com.zxjyTools.service.InterfaceService;
import com.zxjyTools.vo.InterfaceVo;

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

	public Interface select(Integer id) {
		return interfaceDao.findInterface(id);
	}

	public void delete(Integer id) {
		interfaceDao.deleteInterface(id);		
	}

	public List<?> findAll() {
		return interfaceDao.findAll();
	}

	public List<InterfaceVo> findAllInterfaceInfo() {		
		return interfaceDao.selectAllInterfaceInfo();
	}
}
