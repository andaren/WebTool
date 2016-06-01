package com.zxjyTools.dao;

import java.util.List;

import com.zxjyTools.annotation.MyBatisRepository;
import com.zxjyTools.entity.Interface;
import com.zxjyTools.vo.InterfaceVo;

@MyBatisRepository
public interface InterfaceDao {
	
	List<InterfaceVo> selectAllInterfaceInfo();
	
	List<Interface> findAll();
	
	Interface findInterface(Integer id);
	
	void deleteInterface(Integer id);
	
	void updateInterface(Interface inter);
	
	Integer insertInterface(Interface inter);
}
