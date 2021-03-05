package com.epsilon.training.programs;

import com.epsilon.training.entity.Employee;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CreateEmployee {

	public static void main(String[] args) {
		Employee e1, e2;
		
		log.debug("Emp with default constructor");
		e1 = new Employee();
		
		log.debug("Emp with parameterized constructor");
		e2 = new Employee(123,"anu","adj","banglore",6235,"EP");
		
		log.debug("e1 is {}", e1);
		log.debug("e2 is {}", e2);
		
		e1.print();
		System.out.println("");
		e2.print();

	}

}
