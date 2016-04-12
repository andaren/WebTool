package com.zxjyTools.jUnitTest;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.support.BindingAwareModelMap;

import com.zxjyTools.controller.UserController;
import com.zxjyTools.dao.UserDao;
import com.zxjyTools.entity.User;

public class TestCase {

	@Test
	public void testFindUser() {
		String conf = "applicationContext.xml";
		ApplicationContext app = new ClassPathXmlApplicationContext(conf);
		UserController uc = app.getBean("userController", UserController.class);
		BindingAwareModelMap model = new BindingAwareModelMap();
		uc.showAll(model);
	}
}
