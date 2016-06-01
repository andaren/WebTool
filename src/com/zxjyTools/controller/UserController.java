package com.zxjyTools.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zxjyTools.entity.User;
import com.zxjyTools.service.UserService;

@Controller
@RequestMapping("/user")
//@Transactional
public class UserController {
	
	@Resource
	private UserService userService;

	@RequestMapping("/findUser.do")
	public String showAll(Model model) {
		@SuppressWarnings("unchecked")
		List<User> userList = (List<User>) userService.findAll();
		model.addAttribute(userList);
		return "user/userInfo";
	}
	
	@RequestMapping("/add.do")
	public String addUser(Model model, User user) {
		if (user != null && !"".equals(user)) {
			//�Ƿ������ͬ�û������û�
			String username = user.getUsername();
			User u = userService.findUser(username);
			if (u == null) {
				//����MD5���ܴ洢
				
				userService.insertUser(user);
				User user2 = new User();
				userService.insertUser(user2);
			} else {
				model.addAttribute("msg", "���û��Ѵ��ڣ�");
				return "user/addUser";
			}			
		}
		return "login/login";
	}
	
	@RequestMapping("/login.do")
	public String login(Model model, User user) {
		User newUser = userService.selectUser(user);
		System.out.println("!!");
		/*if (newUser == null) {
			String msg = "��������û����������벻��ȷ!";
			model.addAttribute("msg", msg);
			model.addAttribute("username", user.getUsername());
			return "login/login";
		} else {
			model.addAttribute("user", user);
		}*/
		return "mainTools";
	}
}
