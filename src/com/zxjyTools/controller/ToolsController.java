package com.zxjyTools.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 用户工具组件
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/tool")
public class ToolsController {

	@RequestMapping("/changeSql.do")
	public String changSql(Model model, String sql, String changedSqlInJsp, String changeType, String addAppendStr) {
		//处理SQL转换
		String changedSql = changedSqlInJsp;
		StringBuffer sqlSB = new StringBuffer();
//处理：将sql包装起来
		if ("1".equals(changeType)) {			
			String[] enterSplit = changedSqlInJsp.split("\r\n");
			for (String s : enterSplit) {
				if (!"".equals(s.trim())) {
					sqlSB.append(addAppendStr.trim()).append("(\"").append(s).append(" \");").append("\r\n");
				}
			}
			sql = sqlSB.toString();
			model.addAttribute("sql", sql);
		} else {
//处理：将sql解包装-append
			if (sql != null && !"".equals(sql)) {
				if (sql.contains("append")) {
					
					String[] leftSplit = sql.split("\\(\"");
					for (String s : leftSplit) {
						if (s.contains(");") && !"".equals(s)) {
							//组合格式（需要吗）
							s = s.split("\"\\);")[0];
							sqlSB.append(s).append("\n");
						}
					}
					changedSql = sqlSB.toString();
					model.addAttribute("changedSql", changedSql);
				} else if (sql.trim().startsWith("\"")) {
//处理：将sql解包装-""+
					sql = sql.replaceAll("\\+", "");					
					sql = sql.replaceAll("\\\\r\\\\n", "");
					String[] spaceSplit = sql.split("\"");
					for (String s : spaceSplit) {
						if (!"".equals(s.trim().replaceAll("\t", ""))) {							
							sqlSB.append(s).append("\r\n");
						}
					}
					String newSql = sqlSB.toString();
					newSql = newSql.replaceAll("\"", "");
					newSql = newSql.replaceAll("\\+", "");
					model.addAttribute("changedSql", newSql);
				} else {
//处理：暂不处理
					model.addAttribute("changedSql", sql);
				}		 	
			}		
		}		
		return "tool/changed";
	}
}
