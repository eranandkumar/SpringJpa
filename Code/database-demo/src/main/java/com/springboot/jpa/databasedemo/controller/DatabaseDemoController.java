package com.springboot.jpa.databasedemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.jpa.databasedemo.entity.Person;
import com.springboot.jpa.databasedemo.jdbc.PersonJdbcDAO;

@RestController
public class DatabaseDemoController {
	
	@Autowired
	PersonJdbcDAO personJdbcDao;
	
	@GetMapping("/hello")
	public String hello() {
		return "Hello DatabaseDemo";
	}
	
	@GetMapping("/details")
	public List<Person> getAll() {
		return personJdbcDao.findAll();
	}
	
	@GetMapping("/details/id/{id}")
	public Person getObjectById(@PathVariable int id) {
		return personJdbcDao.findById(id);
	}
	
	@DeleteMapping("/details/delete/{id}")
	public int deleteById(@PathVariable int id) {
		return personJdbcDao.deleteById(id);
	}
	
	@PostMapping("/details")
	public int addDetails(@RequestBody Person person) {
		return personJdbcDao.insert(person);
	}
	
	@PutMapping("/details/id/{id}")
	public int updatePersonDetails(@PathVariable int id, @RequestBody Person person) {
		person.setId(id);
		return personJdbcDao.update(person);
	}
}
