package com.springexperiment.dao;

import java.util.List;

import com.springexperiment.entities.Student;

public interface StudentDAO extends BaseDAO {

	public DAOStatus saveStudent(Student student);

	public DAOStatus deleteStudent(Student student);

	public DAOStatus modifyStudent(Student student);

	public List<Student> queryAll();

	public List<Student> query(String sno);

	public List<Student> queryFuzzy(Student student);
}
