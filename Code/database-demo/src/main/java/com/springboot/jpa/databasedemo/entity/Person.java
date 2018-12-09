package com.springboot.jpa.databasedemo.entity;

public class Person {
	private int id;
	private String first_name;
	private String last_name;
	private String location;
	
	protected Person() {
		
	}
	
	public Person(int id, String first_name, String last_name, String location) {
		super();
		this.id = id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.location = location;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getFirst_name() {
		return first_name;
	}


	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}


	public String getLast_name() {
		return last_name;
	}


	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}
	
	
}
