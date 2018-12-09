package com.springboot.jpa.databasedemo.jdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springboot.jpa.databasedemo.entity.Person;

@Repository
public class PersonJdbcDAO {
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List<Person> findAll(){
		return jdbcTemplate.query("select * from person", new BeanPropertyRowMapper<Person>(Person.class));
	}
	
	public Person findById(int id) {
		return jdbcTemplate.queryForObject("select * from person where id=?", new Object[] { id },
				new BeanPropertyRowMapper<Person>(Person.class));
	}
	
	public int deleteById(int id) {
		return  jdbcTemplate.update("delete from person where id=?", new Object[] {id});
	}
	
	public int insert(Person person) {
		return jdbcTemplate.update("insert into person(id,first_name,last_name,location) values(?,?,?,?)",
				new Object [] {person.getId(),person.getFirst_name(),person.getLast_name(),person.getLocation()});
	}
	
	public int update(Person person) {
		return jdbcTemplate.update("update person set first_name=?,last_name=?,location=? where id=?", 
				new Object[] {person.getFirst_name(),person.getLast_name(),person.getLocation(),person.getId()});
	}
}
