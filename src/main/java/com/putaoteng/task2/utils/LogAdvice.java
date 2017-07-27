package com.putaoteng.task2.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;

public class LogAdvice {
	public Object around(ProceedingJoinPoint pjp) throws Throwable{
		//获取执行的方法的标签
		Signature getSignature = pjp.getSignature();
		//记录执行前的时间
		long startTime = System.currentTimeMillis();
		
		Object obj = pjp.proceed();
		
		//记录执行后的时间
		long endTime = System.currentTimeMillis();
		Long times = endTime - startTime;
		Log.loggerCreate(LogLevel.WARN, "执行 "+ getSignature.toString() +" 用时: " + times.toString() + " ms");
		return obj;
	}
}
