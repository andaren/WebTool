package com.zxjyTools.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zxjyTools.service.BugService;

@Controller
@RequestMapping("/bug")
public class BugController {

	@Autowired
	private BugService bugService;
	
	@RequestMapping("/bugSubmit")
	public String submitBug(Model model) {
		
		return "submit";
	}
}
