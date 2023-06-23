package com.simplilearn.spring.dependency.injection.autowiring.byconstructor;

public class Employee {
	private int id;
	private String name;
	
	public Employee(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public void employeeInfo() {
		System.out.println("Employee id: " + id);
		System.out.println("Employee name: " + name);
	}
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + "]";
	}
	
	

}
