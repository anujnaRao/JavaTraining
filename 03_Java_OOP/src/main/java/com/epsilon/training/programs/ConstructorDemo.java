package com.epsilon.training.programs;

import com.epsilon.training.entity.Book;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ConstructorDemo {

	public static void main(String[] args) {
		
		Book b1 = new Book();
		b1.print();
		
		log.info("Info");
		
		//A class is loaded into JVM in diff ways
		//1. When obj is created
		//2. By manually loading Class.forName("Name of class")
		//Static variables - no memory in heap or stack, initiated when the class is created.
		//whenever you have a utility class without any memebr variables, make all functions static, class as final
		//no argument constructor as private..
		//Mark the fucntion as static , if the function does not use the member of static
	}

}
