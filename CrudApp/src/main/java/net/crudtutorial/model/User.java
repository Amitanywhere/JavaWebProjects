package net.crudtutorial.model;

import java.util.concurrent.atomic.AtomicInteger;

public class User {
	
	private static final AtomicInteger count = new AtomicInteger(1000);
	private int id = 1001;
	private String name , email , country;
	

	public User(String name, String email, String country) {
		super();
		this.id = count.incrementAndGet();
		this.name = name;
		this.email = email;
		this.country = country;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	
}
