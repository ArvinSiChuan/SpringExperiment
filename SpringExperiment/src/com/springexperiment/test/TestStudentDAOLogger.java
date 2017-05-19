package com.springexperiment.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springexperiment.dao.StudentDAO;
import com.springexperiment.entities.Student;

public class TestStudentDAOLogger {

	public static void main(String[] args) {
		// use web container to load the applicationContext.xml file
		// WebApplicationContext applicationContext =
		// ContextLoader.getCurrentWebApplicationContext();

		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		StudentDAO studentDAO = applicationContext.getBean("studentDAO", StudentDAO.class);
		System.out.println(studentDAO.saveStudent(new Student("20141973", "Harry", "0001")));

		System.out.println(applicationContext.getBean("student", Student.class).getSname());
	}

}
