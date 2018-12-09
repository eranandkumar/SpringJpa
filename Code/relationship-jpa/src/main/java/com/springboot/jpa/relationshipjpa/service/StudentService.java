package com.springboot.jpa.relationshipjpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.jpa.relationshipjpa.bean.StudentDetails;
import com.springboot.jpa.relationshipjpa.entity.Passport;
import com.springboot.jpa.relationshipjpa.entity.Student;
import com.springboot.jpa.relationshipjpa.repository.StudentRepository;

@Service
public class StudentService {
	@Autowired
	private StudentRepository studentRepository;
	
	public StudentDetails getAllStudents() {
		StudentDetails studetails = new StudentDetails();
		List studentDetailList = studentRepository.findAllStudent();
		
		for(Object studentDetail : studentDetailList) {
			Student st = (Student)studentDetail;
			studetails.setStu(st);
			Passport pass = st.getPassport();
			studetails.setPass(pass);
		}
		return studetails;
	}
	
	public void saveDetails(StudentDetails details) {
		studentRepository.saveStudentWithPasssport(details);
	}
}
