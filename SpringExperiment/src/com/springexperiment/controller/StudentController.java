package com.springexperiment.controller;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import com.google.gson.GsonBuilder;
import com.springexperiment.dao.StudentDAO;
import com.springexperiment.entities.Student;

@Controller
@RequestMapping("/student")
public class StudentController {
	private WebApplicationContext applicationContext = ContextLoader.getCurrentWebApplicationContext();

	@Resource(name = "studentDAO")
	private StudentDAO studentDAO;

	@RequestMapping(value = "/studetails", method = RequestMethod.DELETE)
	public @ResponseBody String deleteStudent(@RequestBody Student student) {
		studentDAO.deleteStudent(student);
		String allStu = new GsonBuilder().create().toJson(studentDAO.queryAll());
		return allStu;

	}

	@RequestMapping(value = "/stunew", method = RequestMethod.POST)
	public @ResponseBody String newJsonStudent(@RequestBody Student student) {
		System.out.println(student.getSname());
		System.out.println(studentDAO.saveStudent(student));
		ArrayList<Student> list = (ArrayList<Student>) studentDAO.queryAll();
		String stuGson = new GsonBuilder().create().toJson(list);
		return stuGson;
	}

	@RequestMapping(value = "/studetails", method = RequestMethod.GET)
	public @ResponseBody String jsonPractice(@ModelAttribute("students") String students) {
		ArrayList<Student> list = (ArrayList<Student>) studentDAO.queryAll();
		String stuGson = new GsonBuilder().create().toJson(list);
		return stuGson;
	}

	@RequestMapping(value = "/stufilter", method = RequestMethod.GET)
	public @ResponseBody String filteStu(Student student) {
		ArrayList<Student> list = (ArrayList<Student>) studentDAO.queryFuzzy(student);
		String stuGson = new GsonBuilder().create().toJson(list);
		return stuGson;
	}

	@RequestMapping(value = "/stuview", method = RequestMethod.GET)
	public String getJsonView() {
		return "studentINFO";
	}
}
