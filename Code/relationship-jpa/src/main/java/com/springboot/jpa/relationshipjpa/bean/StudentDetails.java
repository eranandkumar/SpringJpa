package com.springboot.jpa.relationshipjpa.bean;

import com.springboot.jpa.relationshipjpa.entity.Passport;
import com.springboot.jpa.relationshipjpa.entity.Student;

public class StudentDetails {
	private Student stu;
	private Passport pass;
	public Student getStu() {
		return stu;
	}
	public void setStu(Student stu) {
		this.stu = stu;
	}
	public Passport getPass() {
		return pass;
	}
	public void setPass(Passport pass) {
		this.pass = pass;
	}
	
	
}
