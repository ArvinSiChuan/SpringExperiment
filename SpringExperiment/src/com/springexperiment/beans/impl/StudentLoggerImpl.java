package com.springexperiment.beans.impl;

import java.util.ArrayList;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

import com.springexperiment.beans.MyLogger;
import com.springexperiment.dao.BaseDAO.DAOStatus;
import com.springexperiment.entities.Student;

@Service
@Aspect
public class StudentLoggerImpl implements MyLogger {

	@Pointcut("execution(* com.springexperiment.dao.impl.StudentDAOImpl.*Student(..))")
	public void PCExpression() {

	}

	@Pointcut("execution(* com.springexperiment.dao.impl.StudentDAOImpl.query*()) || execution(* com.springexperiment.dao.impl.StudentDAOImpl.query*(..)))")
	public void PCExpressionQuery() {

	}

	@Override
	public void beforeLogger(JoinPoint joinPoint, Object retValue) {
		Object arg0 = joinPoint.getArgs()[0];
		String info = parseINFO(arg0);
		System.out.println("Before Op, MSG: sno is " + info + " - " + joinPoint.getSignature().getName());
	}

	@AfterReturning(returning = "retValue", pointcut = "PCExpressionQuery()")
	@Override
	public void afterLogger(JoinPoint joinPoint, Object retValue) {
		String info = "";
		Object[] args = joinPoint.getArgs();
		if (args.length > 0) {
			info = parseINFO(args[0]);
		}
		System.out.println("querying - " + joinPoint.getSignature().getName() + info);
	}

	// @Around("PCExpression()")
	@Override
	public Object aroundLogger(ProceedingJoinPoint joinPoint) {
		Object[] args = joinPoint.getArgs();
		System.out
				.println("before Op,  MSG: sno is " + parseINFO(args[0]) + " - " + joinPoint.getSignature().getName());
		DAOStatus status = DAOStatus.operationFailed;
		try {
			status = (DAOStatus) joinPoint.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		System.out.println("*****  after  *****  MSG:" + status);
		return status;
	}

	private String parseINFO(Object arg0) {
		String info = "";
		System.out.println(arg0);
		if (arg0 instanceof ArrayList) {
			ArrayList<Student> students = (ArrayList<Student>) arg0;
			for (Student student : students) {
				info += " " + student.getSno();
			}
		} else if (arg0 instanceof Student) {
			info = ((Student) arg0).getSno();
		} else if (arg0 instanceof String) {
			info = arg0.toString();
		}
		return ": " + info;
	}

}
