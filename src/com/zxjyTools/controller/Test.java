package com.zxjyTools.controller;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("test")
public class Test {
	private PrintWriter pw = null;
	
	/**
	 * 第三阶段系统升级，首页广告接口
	 */
	@RequestMapping("/sysAdvertise")
	public void sysAdvertise(HttpServletRequest request,HttpServletResponse response) {
		System.out.println("------------");
		try {
			response.getWriter().write("1231232");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
