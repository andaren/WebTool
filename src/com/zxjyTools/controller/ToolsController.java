package com.zxjyTools.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * �û��������
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/tool")
public class ToolsController {

	@RequestMapping("/changeSql.do")
	public String changSql(Model model, String sql, String changedSqlInJsp, String changeType, String addAppendStr) {
		//����SQLת��
		String changedSql = changedSqlInJsp;
		StringBuffer sqlSB = new StringBuffer();
//������sql��װ����
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
//������sql���װ-append
			if (sql != null && !"".equals(sql)) {
				if (sql.contains("append")) {
					
					String[] leftSplit = sql.split("\\(\"");
					for (String s : leftSplit) {
						if (s.contains(");") && !"".equals(s)) {
							//��ϸ�ʽ����Ҫ��
							s = s.split("\"\\);")[0];
							sqlSB.append(s).append("\n");
						}
					}
					changedSql = sqlSB.toString();
					model.addAttribute("changedSql", changedSql);
				} else if (sql.trim().startsWith("\"")) {
//������sql���װ-""+
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
//�����ݲ�����
					model.addAttribute("changedSql", sql);
				}		 	
			}		
		}		
		return "tool/changed";
	}
}
