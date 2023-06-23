package com.simplilearn.spring.dependency.injection.constructor;

public class Employee {
	
	private int id;
	private String name;
	// Employee is dependent on address
	private Address address;
	
//	Constructor
	public Employee() {
		System.out.println("Constructor Injection...");
	}


	
	public Employee(int id, String name, Address address) {
//	super();
		this.id = id;
		this.name = name;
		this.address = address;
	}



	public void displayEmployeeInfor() {
		System.out.println("Employee id: " + id);
		System.out.println("Employee name: " + name);
		System.out.println("Employee address: " + address);
	}

}
