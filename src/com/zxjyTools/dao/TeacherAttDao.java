package com.zxjyTools.dao;

import java.util.List;

import com.zxjyTools.annotation.MyBatisRepository;
import com.zxjyTools.entity.TeacherAtt;
import com.zxjyTools.entity.TimeSchedual;

@MyBatisRepository
public interface TeacherAttDao {

	public Integer saveTeacherAtt(TeacherAtt teacherAtt);
	
	public List<TimeSchedual> findAllSchedualTime(String schoolId);
}
