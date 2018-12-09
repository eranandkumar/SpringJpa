package com.springboot.jpa.hibernatejpa.dao;

import java.util.List;

import com.springboot.jpa.hibernatejpa.entity.Course;

public interface CourseDao {
	public Course findById(long id);
	public String addOrUpdateCourse(Course cou);
	public void deleteCourseById(int id);
	public void playWithEntityManager();
	public List<Course> findAllCourses();
	public List<Course> findByCourseId();
	public List<Course> findByCourseName();
}
