package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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
	@RequestMapping("back")
	public ModelAndView Here(@RequestParam int Id) {
		ModelAndView MV = new ModelAndView("Here.jsp");
		Account a = repo.findById(Id).orElse(new Account());
		MV.addObject(a);
		System.out.println(repo.findByName("Merve"));
		return MV;
	}
}
