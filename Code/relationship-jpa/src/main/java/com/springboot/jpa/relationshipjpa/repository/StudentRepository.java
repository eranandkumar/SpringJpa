package com.springboot.jpa.relationshipjpa.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.jpa.relationshipjpa.bean.StudentDetails;
import com.springboot.jpa.relationshipjpa.entity.Passport;
import com.springboot.jpa.relationshipjpa.entity.Student;

@Repository

public class StudentRepository {
	@Autowired
	EntityManager em;
	
	
	public List findAllStudent() {
		Query query = em.createQuery("select s from Student s");
		List resultList = query.getResultList();
		
		//Student st = em.find(Student.class, 4L);
		//Passport p = st.getPassport();
		//System.out.println(p);
		return resultList;
	}
	
	@Transactional
	public void saveStudentWithPasssport(StudentDetails details) {
		Student stu = new Student();
		stu.setPassport(details.getPass());
		stu.setName(details.getStu().getName());
		em.persist(stu.getPassport());
		em.persist(stu);
		
	}
}
