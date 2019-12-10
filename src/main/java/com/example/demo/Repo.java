package com.example.demo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface Repo extends CrudRepository<Account, Integer>{
	List<Account> findByName(String name);
}
