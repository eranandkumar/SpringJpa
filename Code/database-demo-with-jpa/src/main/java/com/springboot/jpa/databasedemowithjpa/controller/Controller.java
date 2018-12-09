package com.springboot.jpa.databasedemowithjpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.jpa.databasedemowithjpa.entity.Employee;
import com.springboot.jpa.databasedemowithjpa.jpa.EmployeeJpaRepository;

@RestController
public class Controller {
	@Autowired
	EmployeeJpaRepository empJpaRepo;
	
	@GetMapping("/hello")
	public String hello() {
		return "Hello DatabaseDemo with JPA";
	}
	
	@GetMapping("/employees/id/{id}")
	public Employee getEmployeeById(@PathVariable int id) {
		return empJpaRepo.findEmployeeById(id);
	}
	
	@PostMapping("/employees")
	public int addDetails(@RequestBody Employee emp) {
		Employee empployee = new Employee();
		empployee = (Employee)empJpaRepo.insertOrUpdate(emp);
		return empployee.getId();
	}
	@DeleteMapping("/employees/id/{id}")
	public void deleteById(@PathVariable int id) {
		empJpaRepo.deleteById(id);
	}
}
