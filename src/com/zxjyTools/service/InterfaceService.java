package com.zxjyTools.service;

import java.util.List;

import com.zxjyTools.entity.Interface;
import com.zxjyTools.vo.InterfaceVo;

public interface InterfaceService extends BaseService{

	List<InterfaceVo> findAllInterfaceInfo();
}
