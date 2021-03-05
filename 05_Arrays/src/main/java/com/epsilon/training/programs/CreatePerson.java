package com.epsilon.training.programs;

import com.epsilon.training.entity.Person;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CreatePerson {

	public static void main(String[] args) {
		Person[] people = new Person[3];
		
		//Other implementations
		
		log.debug("people is of type {}, ", people.getClass().getName());
		log.debug("people is of type {}, ", people.length);
		for (int i = 0; i < people.length; i++) {
			log.debug("people[{}] = {} ", i, people[i]);
		}
		
	}

}
