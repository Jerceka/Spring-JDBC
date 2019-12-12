package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
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
	@RequestMapping("/back")
	public ModelAndView Here(@RequestParam int id) {
		ModelAndView MV = new ModelAndView("Here.jsp");
		Account a = repo.findById(id).orElse(new Account());
		MV.addObject(a);
		System.out.println(repo.findByName("Merve"));
		return MV;
	}
	@GetMapping("/accounts")
	public List<Account> getall() {
		return repo.findAll();
	}
	@RequestMapping("/accounts/{id}")
	public Optional<Account> getid(@PathVariable("id")int a) {
		return repo.findById(a);
	}
	@PostMapping("/create")
	public Account create(@RequestBody Account a) {
		repo.save(a);
		return a;
	}
	@DeleteMapping(path="/accounts/{id}",consumes= {"application/json"})
	public List<Account> delete(@PathVariable int id) {
		Account a = repo.getOne(id);
		repo.delete(a);
		return repo.findAll();
	}
	@PutMapping(path="/accounts")
	public List<Account> update(@RequestBody Account a){
		repo.save(a);
		return repo.findAll();
	}
}
