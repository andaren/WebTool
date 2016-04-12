package com.zxjyTools.aspect;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ExceptionLogger {

	@AfterThrowing(pointcut="within(com.zxjyTools.controller..*)", throwing="e")
	public void log(Exception e) {
		StackTraceElement[] eles = e.getStackTrace();
		//记录异常信息
		System.out.println(eles[0].toString());
	}
}
