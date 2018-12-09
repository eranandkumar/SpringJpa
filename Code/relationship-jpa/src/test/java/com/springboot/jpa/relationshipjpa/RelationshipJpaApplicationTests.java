package com.springboot.jpa.relationshipjpa;

import javax.persistence.EntityManager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.jpa.relationshipjpa.entity.Student;
import com.springboot.jpa.relationshipjpa.repository.StudentRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RelationshipJpaApplicationTests {
	@Autowired
	StudentRepository stuRepo;
	
	@Autowired
	EntityManager em;
	
	/*@Test
	public void contextLoads() {
	}*/

	@Test
	@Transactional
	public void getPassportUsingStudent() {
		Student st = em.find(Student.class, 4L);
	}
}
