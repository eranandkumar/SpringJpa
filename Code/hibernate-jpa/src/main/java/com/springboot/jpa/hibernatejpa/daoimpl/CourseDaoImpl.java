package com.springboot.jpa.hibernatejpa.daoimpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.jpa.hibernatejpa.dao.CourseDao;
import com.springboot.jpa.hibernatejpa.entity.Course;

@Repository
@Transactional
public class CourseDaoImpl implements CourseDao {
	Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	EntityManager em;
	
	@Override
	public Course findById(long id) {
		return em.find(Course.class, id);
	}

	@Override
	public String addOrUpdateCourse(Course cou) {
		
		if(cou.getId() == null) {
			em.persist(cou);
			return String.format("Course is Added Successfully with id - %s", cou.getId());
		}else {
			em.merge(cou);
			return String.format("Course is Updated Successfully ");

		}
	}

	@Override
	public void deleteCourseById(int id) {
		Course c = findById(id);
		em.remove(c);
		
	}
	
	@Override
	public void playWithEntityManager() {
		LOGGER.info("*****************Inside PlayWithEntityManager() - Method Starts ********************");
		Course c1 = new Course();
		Course c2 = new Course();
		Course c3 = new Course();
		c1.setCourseName("Spring JS Created");
		c2.setCourseName("Java JS Created");
		c3.setCourseName("Angular JS Created");
		LOGGER.info("*****************setCourseName() Method Called ********************");

		em.persist(c1);
		LOGGER.info("*****************getFlushMode - {} ********************",em.getFlushMode());
		LOGGER.info("@@@@@@@@@@@@@@@@@@ **Before Flush** @@@@@@@@@@@@@@@@@@");
		em.flush();
		LOGGER.info("@@@@@@@@@@@@@@@@@@ **After Flush** @@@@@@@@@@@@@@@@@@");

		em.persist(c2);
		em.persist(c3);
		LOGGER.info("*****************Entity Manager Persists Method Called ********************");


		LOGGER.info("*****************Inside PlayWithEntityManager() - Method Ends ********************");

	}

	@Override
	public List<Course> findAllCourses() {
		//Query query = em.createQuery("select c from Course c");
		//List resultList = query.getResultList();
		
		//TypedQuery<Course> typedQuery = em.createQuery("select c from Course c ", Course.class);
		TypedQuery<Course> typedQuery = em.createNamedQuery("get_all_courses", Course.class);
		List<Course> resultList = typedQuery.getResultList();
		return resultList;
	}

	@Override
	public List<Course> findByCourseId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Course> findByCourseName() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
