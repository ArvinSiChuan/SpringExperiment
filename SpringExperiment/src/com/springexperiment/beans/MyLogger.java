package com.springexperiment.beans;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public interface MyLogger {
	public void beforeLogger(JoinPoint joinPoint, Object retValue);

	public void afterLogger(JoinPoint joinPoint, Object retValue);

	public Object aroundLogger(ProceedingJoinPoint proceedingJoinPoint);
}
