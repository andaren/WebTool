package com.zxjyTools.service;

import com.zxjyTools.entity.User;

public interface UserService extends BaseService{

	User findUser(String userName);
	
	Integer insertUser(User user);
	
	User selectUser(User user);
}
