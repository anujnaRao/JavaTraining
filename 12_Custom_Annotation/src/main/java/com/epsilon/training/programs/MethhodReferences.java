package com.epsilon.training.programs;

import java.util.Arrays;
import java.util.List;

public class MethhodReferences {

	public static void main(String[] args) {
		List<String> names = Arrays.asList("Anujna", "Anjali","Ajith","Mangala","Bhushan", "Prabhakar","Manjula");

		for(String s : names) {
			System.out.println(s);
		}
		System.out.println();

		names
		.stream()
		.forEach(name-> System.out.println(name));
		
		System.out.println();
		
		names
		.stream()
		.forEach(System.out::println);
		
		System.out.println();
		
		names.stream().map(name->name.toUpperCase()).forEach(System.out::println);
		System.out.println();
		
		names.stream().map(String::toUpperCase).forEach(System.out::println);
		System.out.println();
		
		names.stream().filter(name->name.startsWith("Ma")).map(String::toUpperCase).forEach(System.out::println);
		System.out.println();
		
		

	}

}
