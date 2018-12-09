package com.springboot.jpa.relationshipjpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.jpa.relationshipjpa.bean.StudentDetails;
import com.springboot.jpa.relationshipjpa.service.StudentService;

@RestController
public class Controller {
	@Autowired
	private StudentService studentService;
	
	@GetMapping("/relationshiphello")
	public String hello() {
		return "Hellow from RelationShip JPA";
	}
	
	@GetMapping("/students")
	public StudentDetails getAllStudents() {
		return studentService.getAllStudents();
	}
	
	@PostMapping("/students")
	public String saveDetails(@RequestBody StudentDetails students) {
		studentService.saveDetails(students);
		return "Details Persisted to DB";
	}
}
