package com.epsilon.training.entity;

public class Employee {
	
	private int id;
	private String name;
	private double salary;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id)throws InvalidIdException {
		if(id <= 0 || id > 99999) {
			throw new InvalidIdException("Please enter id within 1 - 99999");
		}
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name)throws InvalidNameException{
		if(name == null || name.length() >15 || name.length() <3) {
			throw new InvalidNameException("Please enter id within 1 - 99999");
		}
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary)throws InvalidSalaryException {
		if(id <= 0 || id > 99999) {
			throw new InvalidIdException("Please enter id within 1 - 99999");
		}
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", toString()=" + super.toString()
				+ "]";
	}
	
	
}
