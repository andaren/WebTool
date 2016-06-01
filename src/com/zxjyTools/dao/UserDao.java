package com.zxjyTools.dao;

import java.util.List;

import com.zxjyTools.annotation.MyBatisRepository;
import com.zxjyTools.entity.User;

@MyBatisRepository
public interface UserDao {

	/**
	 * 查找所有用户信息
	 * @return
	 */
	List<User> findAll();
	
	Integer insertUser(User user);
	
	User selectUser(User user);
	
	User findUser(String username);

	User selectUserById(Integer id);
}
