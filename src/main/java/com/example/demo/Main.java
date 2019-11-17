package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Main {
	@Autowired
	Repo repo;
	@RequestMapping("/")
	public String Home() {
		return "Home.jsp";
	}
	@RequestMapping("/Make")
	public String Make(Account a) {
		repo.save(a);
		return "Home.jsp";
	}
}
