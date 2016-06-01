package com.zxjyTools.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zxjyTools.dao.UserDao;
import com.zxjyTools.entity.User;
import com.zxjyTools.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;
	
	public List<?> findAll() {
		return userDao.findAll();
	}

	public void update(Object obj) {
		
	}

	public User select(Integer id) {		
		return userDao.selectUserById(id);
	}

	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

	public User findUser(String username) {
		return userDao.findUser(username);
	}

	public Integer insertUser(User user) {
		return userDao.insertUser(user);
	}

	public Integer add(Object obj) {
		// TODO Auto-generated method stub
		return null;
	}

	public User selectUser(User user) {
		return userDao.selectUser(user);
	}

}
