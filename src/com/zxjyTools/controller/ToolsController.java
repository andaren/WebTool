package com.zxjyTools.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zxjyTools.dao.TeacherAttDao;
import com.zxjyTools.entity.TeacherAtt;
import com.zxjyTools.entity.TimeSchedual;

/**
 * �û��������
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/tool")
public class ToolsController {

	@Resource
	private TeacherAttDao teacherAttDao;
	
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
	
	/**
	 * �����ݿ���д��һ���µĲ�������
	 * @param model
	 * @param username
	 * @param schoolId
	 * @return
	 */
	@RequestMapping("/writeTestAttData.do")
	public String writeDefaultAtt(Model model, String teacherId, String username, String schoolId, String date) throws Exception {
		//��ȡ���еĿ���ʱ���
		List<TimeSchedual> timeSchedualList = teacherAttDao.findAllSchedualTime(schoolId);
		// ��ʼ������
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		DateFormat dfD = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		//���µ�һ��
		Date rquestDate = df.parse(date + "-01");//2016-5-01
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(rquestDate);  
        //�õ������������ 
        int MaxDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        for (int i = 1; i < MaxDay + 1; i++) {
        	calendar.set(Calendar.DAY_OF_MONTH, i);
        	String timeStr = df.format(calendar.getTime());
        	if (timeSchedualList != null && timeSchedualList.size() > 0) {
        		for (TimeSchedual timeSchedual : timeSchedualList) {
        			//--------------------------------------------------
        			TeacherAtt teacherAtt = new TeacherAtt();
        			teacherAtt.setCheckId(timeSchedual.getId() + "");
        			teacherAtt.setCheckName(timeSchedual.getCheckName());
        			teacherAtt.setCheckTime(timeStr + " 00:00:00");
        			teacherAtt.setUsername(username);
        			teacherAtt.setIsReader("0");
        			teacherAtt.setTeacherId(teacherId + "");
        			teacherAtt.setSchoolId(schoolId);
        			//����״̬��δǩ����δǩ��
        			teacherAtt.setStatus("3");
        			teacherAttDao.saveTeacherAtt(teacherAtt);
        			teacherAtt.setStatus("6");
        			teacherAttDao.saveTeacherAtt(teacherAtt);
        			//---------------------------------------------------
        			/*TeacherAtt xTeacherAtt = new TeacherAtt();
        			xTeacherAtt.setCheckId(timeSchedual.getId() + "");
        			xTeacherAtt.setCheckName(timeSchedual.getCheckName());
        			xTeacherAtt.setCheckTime(date + "00:00:00");
        			xTeacherAtt.setUsername(username);
        			xTeacherAtt.setIsReader("0");
        			xTeacherAtt.setTeacherId(teacherId + "");
        			xTeacherAtt.setSchoolId(schoolId);
        			//����״̬��δǩ����δǩ��
        			teacherAtt.setStatus("6");*/
        		}
        	}
        }
		
        //�������Ŀ�������
		return null;
	}
}
