package com.example.demo;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public class StudentJDBCTemplate {
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	public void setDataSource(DataSource ds) {
		this.dataSource = ds;
		this.jdbcTemplateObject = new JdbcTemplate(ds);
	}

	public void create(String Name, int Age) {
		jdbcTemplateObject.update("insert into student(Name,Age)values(?,?)",Name,Age);
		return;
	}
//	public List<Student> listStudents() {
//		List <Student> student = jdbcTemplateObject.query("select * from Student",new StudentMapper());
//		return null;
//	}
}
