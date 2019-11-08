package com.example.demo;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public class StudentJDBCTemplate implements StudentDAO {
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	@Override
	public void setDataSource(DataSource ds) {
		this.dataSource = ds;
		this.jdbcTemplateObject = new JdbcTemplate(ds);
	}

	@Override
	public void create(String Name, int Age) {
		jdbcTemplateObject.update("insert into student(Name,Age)values(?,?)",Name,Age);
		return;
	}
	@Override
	public List<Student> listStudents() {
		List <Student> student = jdbcTemplateObject.query("select * from Student",new StudentMapper());
		return null;
	}

}
