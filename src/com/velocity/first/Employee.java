package com.velocity.first;

public class Employee {
	private int id;
	private String name;
	private String password;
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getPassword() {
		return password;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", password=" + password + "]";
	}
	
	
}
