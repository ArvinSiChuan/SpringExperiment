package com.springexperiment.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import com.springexperiment.dao.StudentDAO;
import com.springexperiment.entities.Student;

public class StudentDAOImpl extends JdbcDaoSupport implements StudentDAO, RowMapper<Student> {
	private JdbcTemplate templet = getJdbcTemplate();
	private String querySql = "select sno,sname,sdept from students where 1=1 ";

	public DAOStatus queryExist(Student student) {
		DAOStatus status = DAOStatus.notExist;
		templet = getJdbcTemplate();
		String queryExiest = "select count(*) as counter from students where sno=?";
		int existNum = templet.query(queryExiest, new CounterRowMapper(), student.getSno()).get(0);
		if (existNum > 0) {
			status = DAOStatus.alreadyExist;
		}
		return status;
	}

	@Transactional
	@Override
	public DAOStatus saveStudent(Student student) {
		DAOStatus status = DAOStatus.operationFailed;
		templet = getJdbcTemplate();
		if (queryExist(student) == DAOStatus.alreadyExist) {
			status = DAOStatus.alreadyExist;
		} else {
			String sql = "insert into students (sno,sname,sdept) values(?,?,?)";
			int r = templet.update(sql, student.getSno(), student.getSname(), student.getSdept());
			if (r == 1) {
				status = DAOStatus.saved;
			} else {
				status = DAOStatus.operationFailed;
			}
		}
		return status;
	}

	@Transactional
	@Override
	public DAOStatus deleteStudent(Student student) {
		DAOStatus status = DAOStatus.operationFailed;
		templet = getJdbcTemplate();
		if (queryExist(student) == DAOStatus.notExist) {
			status = DAOStatus.notExist;
		} else {
			String deleteSql = "delete from students where sno=?";
			int r = templet.update(deleteSql, student.getSno());
			status = r > 0 ? DAOStatus.deleted : DAOStatus.operationFailed;
		}
		return status;
	}

	@Transactional
	@Override
	public DAOStatus modifyStudent(Student student) {
		DAOStatus status = DAOStatus.operationFailed;
		templet = getJdbcTemplate();
		if (queryExist(student) == DAOStatus.notExist) {
			status = DAOStatus.notExist;
		} else {
			String modifySql = "update student set sname=?,sdept=? where sno=?";
			int r = templet.update(modifySql, student.getSname(), student.getSdept(), student.getSno());
			status = r == 0 ? DAOStatus.modified : DAOStatus.operationFailed;
		}
		return status;
	}

	public List<Student> queryAll() {
		templet = getJdbcTemplate();
		return templet.query(querySql, this);
	}

	public List<Student> queryFuzzy(Student student) {
		String snoKey = "%" + student.getSno() + "%";
		String snameKey = "%" + student.getSno() + "%";
		String sdeptKey = "%" + student.getSno() + "%";
		templet = getJdbcTemplate();
		return templet.query("select sno,sname,sdept from students where sno like ? or sname like ? or sdept like ?",
				this, snoKey, snameKey, sdeptKey);
	}

	public List<Student> query(String sno) {
		templet = getJdbcTemplate();
		return templet.query(querySql + "and sno=?", this, sno);
	}

	@Override
	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
		Student student = new Student();
		student.setSno(rs.getString("sno"));
		student.setSname(rs.getString("sname"));
		student.setSdept(rs.getString("sdept"));
		return student;
	}
}
