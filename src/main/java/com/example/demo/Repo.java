package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Repo extends JpaRepository<Account, Integer>{
	List<Account> findByName(String name);
}
