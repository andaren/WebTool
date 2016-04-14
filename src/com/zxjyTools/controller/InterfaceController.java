package com.zxjyTools.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zxjyTools.entity.Interface;
import com.zxjyTools.entity.InterfaceCategory;
import com.zxjyTools.service.InterfaceService;
import com.zxjyTools.service.serviceImpl.InterfaceCategoryService;

/**
 * 手机端接口工具类
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/interface")
public class InterfaceController {

	@Resource
	private InterfaceService interfaceService;
	
	@Resource
	private InterfaceCategoryService interfaceCategoryService;
	
	public InterfaceController() {
		
	}	
	
	//接口类型管理----------------------------------------
	@RequestMapping("/allCategory.do")
	public String getAllInterfaceCategory(Model model) {
		List<InterfaceCategory> list = (List<InterfaceCategory>) interfaceCategoryService.findAll();
		model.addAttribute("InterfacecategoryList", list);
		return "";
	}
	
	@RequestMapping("/addCategory.do")
	public String addInterfaceCategory(HttpServletRequest req) {
		//---
		String parentId = req.getParameter("parentId");
		if (parentId == null && "".equals(parentId)) {
			parentId = "0";
		}
		String actionName = req.getParameter("ActionName");
		String type = req.getParameter("type");
		//---
		InterfaceCategory interCategory = new InterfaceCategory();
		interCategory.setActionName(actionName);
		interCategory.setParentId(Integer.valueOf(parentId));
		interCategory.setType(type);
		//组装实体最好是放在service层内部...
		interfaceCategoryService.add(interCategory);
		return null;
	}
	
	@RequestMapping("/deleteCategory.do")
	public String deleteInterfaceCategory() {
		return null;
	}
	
	@RequestMapping("/updateCategory.do")
	public String updateInterfaceCategory() {
		return null;
	}
	
	//接口管理-----------------------------------------------
	@RequestMapping("/allInterface.do")
	public String getAllInterface(Model model) {
		List<Interface> list = (List<Interface>) interfaceService.findAll();
		model.addAttribute("inferfaceList", list);
		return "";
	}
	
	@RequestMapping("/save.do")
	public void saveInterface(HttpServletRequest req) {
		//---
		String categoryId = req.getParameter("categoryId");
		String name = req.getParameter("name");
		String args = req.getParameter("args");
		String path = req.getParameter("path");
		String submitter = req.getParameter("submitter");
		//---
		Interface inter = new Interface();
		inter.setArgs(args);
		inter.setCategoryId(Integer.valueOf(categoryId));
		inter.setName(name);
		inter.setPath(path);
		inter.setSubmitter(Integer.valueOf(submitter));
		int interfaceId = interfaceService.add(inter);
	}
	
	@RequestMapping("/delete.do")
	public void deleteInterface() {
		
	}
	
	@RequestMapping("/update.do")
	public void updateInterface() {
		
	}
}
