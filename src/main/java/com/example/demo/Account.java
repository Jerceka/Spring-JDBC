package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Account {
	@Id
	private String Firstname;
	private String Lastname;
	private int Age;
	public String getFirstname() {
		return Firstname;
	}
	public void setFirstname(String firstname) {
		Firstname = firstname;
	}
	public String getLastname() {
		return Lastname;
	}
	public void setLastname(String lastname) {
		Lastname = lastname;
	}
	public int getAge() {
		return Age;
	}
	public void setAge(int age) {
		Age = age;
	}
}
