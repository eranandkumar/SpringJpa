package com.springboot.jpa.databasedemowithjpa.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.springboot.jpa.databasedemowithjpa.entity.Employee;

@Repository
@Transactional
public class EmployeeJpaRepository {

	@PersistenceContext
	EntityManager entityManager;
	
	public Employee findEmployeeById(int id){
		// entityManager.find(id, Employee.class); 
		return entityManager.find(Employee.class, id);
	}
	
	public Employee insertOrUpdate(Employee emp) {
		return (Employee)entityManager.merge(emp);
	}
	
	public void deleteById(int id) {
		Employee empObj = null;
		empObj = findEmployeeById(id);
		entityManager.remove(empObj);
	}
}
