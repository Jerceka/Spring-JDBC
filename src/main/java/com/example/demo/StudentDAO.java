package com.example.demo;

import java.util.List;

import javax.sql.DataSource;

public interface StudentDAO {
	public void setDataSource(DataSource ds);
	public void create(String Name,int Age);
//	public void getStudent(int ID);
	public List<Student> listStudents();
}
