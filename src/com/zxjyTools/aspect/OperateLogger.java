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
 * 关于为什么要声明了Aspect组件之后，还要去声明Component组件
 * 1.声明Component组件是将组件给Spring代理管理
 * 2.声明Aspect组件是为了引用Logger2这个组件
 * 光声明是Component组件就不知道需要切面管理，而光声明Aspect组件就得不到该类的引用，也无法让切面工作 
 */
@Aspect
public class OperateLogger {
	
	public OperateLogger () {
		
	}

	//切入点表达式
	@Pointcut("within(com.zxjyTools.controller..*)")
	//切入点签名
	public void beforeLog() {
		
	}
	
	@Pointcut("within(com.zxjyTools.controller..*)")
	public void operateLog() {
		
	}
	
	/**
	 * 前置通知
	 */
	@Before("beforeLog()")
	public void doBeforeLog() {
		System.out.println("用户操作: ->");
	}
	
	@Around("operateLog()")
	public void doOperateLog(ProceedingJoinPoint proce) throws Throwable{
		//获取目标组件的类名                            //获得目标组件          获取Class对象     获取类名
		String clazzName = proce.getTarget().getClass().getName();
		//获取目标组件调用的方法名
		String method = proce.getSignature().getName();
		
		DateFormat df = new SimpleDateFormat("[yyyy-MM-dd HH:mm:ss]");
		String time = df.format(new Date());
		
		String msg = "用户在 " + time + "执行了 " + clazzName + "." + method;
		System.out.println(msg);
		//执行目标组件
		proce.proceed();
		
		System.out.println("执行目标组件之后 ");
	}
}
