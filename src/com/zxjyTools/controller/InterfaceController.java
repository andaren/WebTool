package com.zxjyTools.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zxjyTools.entity.Interface;
import com.zxjyTools.entity.InterfaceCategory;
import com.zxjyTools.service.InterfaceService;
import com.zxjyTools.service.serviceImpl.InterfaceCategoryService;
import com.zxjyTools.vo.InterfaceVo;

/**
 * 手机端接口工具类
 * @author Administrator
 *
 */
@Controller
@RequestMapping("interface")
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
		@SuppressWarnings("unchecked")
		List<InterfaceCategory> list = (List<InterfaceCategory>) interfaceCategoryService.findAll();
		model.addAttribute("interfacecategoryList", list);
		return "interface/interfaceCategory";
	}
	
	@RequestMapping("/addCategory.do")
	public void addInterfaceCategory(HttpServletRequest req) {
		//---
		String parentId = req.getParameter("parentId");
		if (parentId == null && "".equals(parentId)) {
			parentId = "0";
		}
		String actionName = req.getParameter("actionName");
		String type = req.getParameter("type");
		//---
		InterfaceCategory interCategory = new InterfaceCategory();
		interCategory.setActionName(actionName);
		interCategory.setParentId(Integer.valueOf(parentId));
		interCategory.setType(type);
		//组装实体最好是放在service层内部...
		interfaceCategoryService.add(interCategory);
		//return //"interface/interfaceCategory";
	}
	
	@RequestMapping("/deleteCategory.do")
	public void deleteInterfaceCategory(HttpServletRequest req) {
		String categoryId = req.getParameter("categoryId");
		interfaceCategoryService.delete(Integer.valueOf(categoryId));
	}
	
	@RequestMapping("/updateCategory.do")
	public String updateInterfaceCategory() {
		return null;
	}
	
	//接口管理-----------------------------------------------
	@RequestMapping("/addInfos")
	public String addInterfaceInfos(Model model) {
		//查询接口类型
		List<Map<String, String>> categoryList = new ArrayList<Map<String, String>>();
		@SuppressWarnings("unchecked")
		List<InterfaceCategory> list = (List<InterfaceCategory>) interfaceCategoryService.findAll();
		if (list != null && list.size() > 0) {
			for (InterfaceCategory category : list) {
				//首先默认页面上全部属性不为空...
				Map<String, String> newMap = new HashMap<String, String>();
				newMap.put("id", category.getId() + "");
				newMap.put("actionName", category.getActionName());
				newMap.put("type", category.getType());
				categoryList.add(newMap);
			}
		}
		model.addAttribute("categoryList", categoryList);
		return "interface/addInterface";
	}
	
	@RequestMapping("/allInterface.do")
	public String getAllInterface(Model model) {
		//查询所有接口信息
		List<InterfaceVo> interfaceList = (List<InterfaceVo>) interfaceService.findAllInterfaceInfo();
		for (InterfaceVo inter : interfaceList) {
			String args = inter.getInterfaceArgs();
			args = args.replace(",", "\n");
			inter.setInterfaceArgs(args);
		}
		model.addAttribute("inferfaceList", interfaceList);
		return "interface/interface";
	}
	
	@RequestMapping("/save.do")
	public void saveInterface(HttpServletRequest req) {
		//---
		String categoryId = req.getParameter("categoryId");
		String name = req.getParameter("name");
		String args = req.getParameter("args");
		String path = req.getParameter("path");
		String submitter = req.getParameter("submitter");
		String description = req.getParameter("description");
		//---
		Interface inter = new Interface();
		inter.setArgs(args);
		inter.setCategoryId(Integer.valueOf(categoryId));
		inter.setName(name);
		inter.setPath(path);
		inter.setSubmitter(Integer.valueOf(submitter));
		inter.setDescription(description);
		int interfaceId = interfaceService.add(inter);
	}
	
	@RequestMapping("/delete.do")
	public void deleteInterface() {
		
	}
	
	@RequestMapping("/update.do")
	public void updateInterface() {
		
	}
}
