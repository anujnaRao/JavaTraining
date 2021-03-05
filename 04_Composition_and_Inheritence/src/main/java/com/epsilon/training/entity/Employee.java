package com.epsilon.training.entity;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Employee extends Person {
	
	private int id;
	private double salary;
	private String department;
	
	public Employee() {
		//super(); //implicitly called
		log.debug("Employee() called");
	}
	
	public Employee(int id, String name, String email, String city,double salary,String department ) {
		super(name,email,city);
		this.id = id;
		this.salary = salary;
		this.department = department;
		log.debug("Employee() with parameters called");
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", salary=" + salary + ", department=" + department + ", toString()="
				+ super.toString() + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public static org.slf4j.Logger getLog() {
		return log;
	}
	
	//@Override -- to identify overriding function
	//super.funname();
	
	@Override
	public void print() {
		super.print();
		System.out.println("ID: "+ id);
		System.out.println("Salary: "+ salary);
		System.out.println("Department: "+ department);
	}
}
