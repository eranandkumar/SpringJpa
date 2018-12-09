package com.springboot.jpa.hibernatejpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.jpa.hibernatejpa.dao.CourseDao;
import com.springboot.jpa.hibernatejpa.entity.Course;

@RestController
@RequestMapping("/hibernatejpa")
public class DatabaseController {
	
	@Autowired
	CourseDao courseDao;
	
	@GetMapping("/hello")
	public String hello() {
		return "Hello From Hibernate-Jpa-Application";
	}
	
	@GetMapping("/courses/{id}")
	public Course getCourseById(@PathVariable long id) {
		return courseDao.findById(id);
	}
	
	@PostMapping("/courses")
	public String addCourses(@RequestBody Course co) {
		return courseDao.addOrUpdateCourse(co);
	}
	
	@PutMapping("/courses/{id}")
	public String addCourses(@PathVariable long id, @RequestBody Course co) {
		co.setId(id);
		return  courseDao.addOrUpdateCourse(co);
	}
	@DeleteMapping("/courses/{id}")
	public String deleteCourseById(@PathVariable int id) {
		courseDao.deleteCourseById(id);
		return String.format("Course is Deleted Successfully");
	}
	
	@GetMapping("/courses/aboutEntityManager")
	public String moreAboutEntityManager() {
		courseDao.playWithEntityManager();
		return "Check the LOG";
	}
	
	@GetMapping("/courses")
	public List<Course> findAllCourses(){
		return courseDao.findAllCourses();
	}
}
