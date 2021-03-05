package com.epsilon.training.programs;

import com.epsilon.training.entity.Employee;
import com.epsilon.training.entity.Person;
import com.epsilon.training.entity.Student;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PolymorphismDemo {

	public static void main(String[] args) {
		Employee e1 = new Employee(111,"Emp","emp@av.com","Banglore",2324,"Manager");
		Student s1 = new Student(101,"Stu","stu@ac.com","Mysore","CS",9.1);
		
		log.debug("e1 is an instance of Employee is {}", e1 instanceof Employee);
		log.debug("e1 is an instance of Person is {}", e1 instanceof Person);
		log.debug("e1 is an instance of Object is {}", e1 instanceof Object);
		
		log.debug("s1 is an instance of Employee is {}", s1 instanceof Student);
		log.debug("s1 is an instance of Person is {}", s1 instanceof Person);
		log.debug("s1 is an instance of Object is {}", s1 instanceof Object);
		
		Person p1;
		
		System.out.println();
		p1 = e1;
		p1.print();
		
		log.debug("p1 is an instance of Employee is {}", p1 instanceof Employee);
		log.debug("p1 is an instance of Employee is {}", p1 instanceof Student);
		
		System.out.println();
		p1 = s1;
		p1.print();
		
		log.debug("p1 is an instance of Employee is {}", p1 instanceof Employee);
		log.debug("p1 is an instance of Employee is {}", p1 instanceof Student);

	}

}
