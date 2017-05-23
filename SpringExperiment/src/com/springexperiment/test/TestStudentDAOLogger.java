package com.springexperiment.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springexperiment.entities.Student;

public class TestStudentDAOLogger {

	public static void main(String[] args) {
		// use web container to load the applicationContext.xml file
		// WebApplicationContext applicationContext =
		// ContextLoader.getCurrentWebApplicationContext();

		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		System.out.println(applicationContext.getBean("student", Student.class).getSname());
	}

}
