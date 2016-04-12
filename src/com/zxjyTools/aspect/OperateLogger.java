package com.zxjyTools.aspect;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
/**
 * ����ΪʲôҪ������Aspect���֮�󣬻�Ҫȥ����Component���
 * 1.����Component����ǽ������Spring�������
 * 2.����Aspect�����Ϊ������Logger2������
 * ��������Component����Ͳ�֪����Ҫ���������������Aspect����͵ò�����������ã�Ҳ�޷������湤�� 
 */
@Aspect
public class OperateLogger {
	
	public OperateLogger () {
		
	}

	//�������ʽ
	@Pointcut("within(com.zxjyTools.controller..*)")
	//�����ǩ��
	public void beforeLog() {
		
	}
	
	@Pointcut("within(com.zxjyTools.controller..*)")
	public void operateLog() {
		
	}
	
	/**
	 * ǰ��֪ͨ
	 */
	@Before("beforeLog()")
	public void doBeforeLog() {
		System.out.println("�û�����: ->");
	}
	
	@Around("operateLog()")
	public void doOperateLog(ProceedingJoinPoint proce) throws Throwable{
		//��ȡĿ�����������                            //���Ŀ�����          ��ȡClass����     ��ȡ����
		String clazzName = proce.getTarget().getClass().getName();
		//��ȡĿ��������õķ�����
		String method = proce.getSignature().getName();
		
		DateFormat df = new SimpleDateFormat("[yyyy-MM-dd HH:mm:ss]");
		String time = df.format(new Date());
		
		String msg = "�û��� " + time + "ִ���� " + clazzName + "." + method;
		System.out.println(msg);
		//ִ��Ŀ�����
		proce.proceed();
		
		System.out.println("ִ��Ŀ�����֮�� ");
	}
}
