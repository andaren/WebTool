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
import com.zxjyTools.entity.User;
import com.zxjyTools.service.InterfaceService;
import com.zxjyTools.service.UserService;
import com.zxjyTools.service.serviceImpl.InterfaceCategoryService;
import com.zxjyTools.vo.InterfaceVo;

/**
 * �ֻ��˽ӿڹ�����
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
	
	@Resource
	private UserService userService;
	
	public InterfaceController() {
		
	}	
	
	//�ӿ����͹���----------------------------------------
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
		//��װʵ������Ƿ���service���ڲ�...
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
	
	//�ӿڹ���-----------------------------------------------
	@RequestMapping("/addInfos")
	public String addInterfaceInfos(Model model) {
		//��ѯ�ӿ�����
		List<Map<String, String>> categoryList = new ArrayList<Map<String, String>>();
		@SuppressWarnings("unchecked")
		List<InterfaceCategory> list = (List<InterfaceCategory>) interfaceCategoryService.findAll();
		if (list != null && list.size() > 0) {
			for (InterfaceCategory category : list) {
				//����Ĭ��ҳ����ȫ�����Բ�Ϊ��...
				Map<String, String> newMap = new HashMap<String, String>();
				newMap.put("id", category.getId() + "");
				newMap.put("actionName", category.getActionName());
				newMap.put("type", category.getType());
				categoryList.add(newMap);
			}
		}
		//��ѯ�����û�(��ʱ�ǲ����е��û����Ժ����type����)
		List<Map<String, String>> usernameList = new ArrayList<Map<String, String>>();
		@SuppressWarnings("unchecked")
		List<User> userList = (List<User>) userService.findAll();
		if (userList != null && userList.size() > 0) {
			for (User user : userList) {
				//����Ĭ��ҳ����ȫ�����Բ�Ϊ��...
				Map<String, String> newMap = new HashMap<String, String>();
				newMap.put("id", user.getId() + "");
				newMap.put("username", user.getUsername());
				usernameList.add(newMap);
			}
		} 
		model.addAttribute("categoryList", categoryList);
		model.addAttribute("usernameList", usernameList);
		return "interface/addInterface";
	}
	
	@RequestMapping("/allInterface.do")
	public String getAllInterface(Model model) {
		//��ѯ���нӿ���Ϣ
		List<InterfaceVo> interfaceList = (List<InterfaceVo>) interfaceService.findAllInterfaceInfo();
		//���������ʽ
		for (InterfaceVo inter : interfaceList) {
			String args = inter.getInterfaceArgs();
			args = args.replace("#", ":  ");
			args = args.replace(",", "<br/>");
			if ("".equals(args.trim())) {
				args = "";
			}
			inter.setInterfaceArgs(args);
		}
		model.addAttribute("inferfaceList", interfaceList);
		return "interface/interface";
	}
	
	@RequestMapping("/save.do")
	public void saveInterface(HttpServletRequest req) {
		//---------------------------------------------
		String categoryId = req.getParameter("categoryId");
		String name = req.getParameter("name");		
		String path = req.getParameter("path");
		String submitter = req.getParameter("submitter");
		String description = req.getParameter("description");
		// ��������
		String argNum = req.getParameter("argNum");
		StringBuilder args = new StringBuilder();
		if (argNum != null && !"".equals(argNum)) {
			for (int i = 0; i < Integer.valueOf(argNum) + 1; i++) {
				args.append(req.getParameter("args" + i)).append("#").append(req.getParameter("argName" + i)).append(",");
			}
		}
		//---------------------------------------------
		Interface inter = new Interface();
		inter.setArgs(args.toString());
		inter.setCategoryId(Integer.valueOf(categoryId));
		inter.setName(name);
		inter.setPath(path);
		inter.setSubmitter(Integer.valueOf(submitter));
		inter.setDescription(description);
		int interfaceId = interfaceService.add(inter);
	}
	
	@RequestMapping("/delete.do")
	public void deleteInterface(HttpServletRequest req) {
		String interfaceId = req.getParameter("interfaceId");
		if (interfaceId != null && !"".equals(interfaceId)) {			
			interfaceService.delete(Integer.valueOf(interfaceId));
		}
	}
	
	@RequestMapping("/update.do")
	public void updateInterface() {
		
	}
	
	@RequestMapping("/testInterface.do")
	public String testInterface(HttpServletRequest req, Model model) {
		String interfaceId = req.getParameter("interfaceId");
		if (interfaceId != null && !"".equals(interfaceId)) {
			Interface inter = (Interface) interfaceService.select(Integer.valueOf(interfaceId));
			if (inter != null) {
				//��ȡ�ύ��IP
				int submitter =  inter.getSubmitter();
				User user = (User) userService.select(submitter);
				if (user.getIP() != null && !"".equals(user.getIP())) {
					model.addAttribute("IP", user.getIP());
				}
				//�ӿڲ�������
				List<Map<String, Object>> argsList = new ArrayList<Map<String, Object>>();
				int count = 0;//��¼��������
				for (String s : inter.getArgs().split(",")) {
					if (s != null && !"".equals(s)) {
						String[] array = s.split("#");
						Map<String, Object> newMap = new HashMap<String, Object>();
						newMap.put("count", count);
						newMap.put("argDes", array[1]);
						newMap.put("argName", array[0]);
						argsList.add(newMap);
						count++;
					}
				}
				model.addAttribute("argList", argsList);
				model.addAttribute("argCount", count);
				model.addAttribute("path", inter.getPath());
			}
		}
		return "interface/testInterface";
	}
}
