package com.zxjyTools.dao;

import java.util.List;

import com.zxjyTools.annotation.MyBatisRepository;
import com.zxjyTools.entity.User;

@MyBatisRepository
public interface UserDao {

	/**
	 * ���������û���Ϣ
	 * @return
	 */
	List<User> findAll();
	
	void insertUser(User user);
	
	User selectUser(User user);
	
	User findUser(String username);
}