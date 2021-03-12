package com.epsilon.trainig.programs;

import java.util.HashSet;
import java.util.Set;

import com.epsilon.trainig.entity.Person;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UsingSet {
	
	static void printInfo(String varName, Set<?> set) {
		log.debug("Output: ");
		
	}
	public static void main(String[] args) {
		Set<Person> people = new HashSet<>();
		
		Person p1 =  new Person(1,"Anu", "Rao", 23, 60);
		Person p2 =  new Person(1,"Anu", "Rao", 23, 60);
		
		log.debug("Output: ");
		people.add(p1);
		people.add(p2);
		people.add(new Person(2,"Anjali","Bhat", 56, 50));
		
		printInfo("People ", people);
	}
	
	
}
