package com.zxjyTools.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zxjyTools.dao.UserDao;
import com.zxjyTools.entity.User;

@Controller
@RequestMapping("/user")
//@Transactional
public class UserController {
	
	@Resource
	private UserDao userDao;

	@RequestMapping("/findUser.do")
	public String showAll(Model model) {
		List<User> userList = userDao.findAll();
		model.addAttribute(userList);
		return "user/userInfo";
	}
	
	@RequestMapping("/add.do")
	public String addUser(Model model, User user) {
		if (user != null && !"".equals(user)) {
			//是否存在相同用户名的用户
			String username = user.getUsername();
			User u = userDao.findUser(username);
			if (u == null) {
				//加入MD5加密存储
				
				userDao.insertUser(user);
				User user2 = new User();
				userDao.insertUser(user2);
			} else {
				model.addAttribute("msg", "该用户已存在！");
				return "user/addUser";
			}			
		}
		return "login/login";
	}
	
	@RequestMapping("/login.do")
	public String login(Model model, User user) {
		User newUser = userDao.selectUser(user);
		System.out.println("!!");
		/*if (newUser == null) {
			String msg = "您输入的用户名或者密码不正确!";
			model.addAttribute("msg", msg);
			model.addAttribute("username", user.getUsername());
			return "login/login";
		} else {
			model.addAttribute("user", user);
		}*/
		return "mainTools";
	}
}
