package com.springboot.jpa.hibernatejpa.daoimpl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.springboot.jpa.hibernatejpa.dao.CourseDao;
import com.springboot.jpa.hibernatejpa.entity.Course;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CourseDaoImplTest {

	private  Logger  logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	CourseDao cdao;
	
	@Test
	public void contextLoads() {
		assertNotNull(cdao);
	}
	@Test
	public void findByIdTest() {
		Course c = cdao.findById(5);
		assertEquals("SpringBoot", c.getCourseName());
	}
	
	@Test
	@DirtiesContext
	public void deleteCourseByIdTest() {
		cdao.deleteCourseById(10);
		assertNull(cdao.findById(10));
	}

}
