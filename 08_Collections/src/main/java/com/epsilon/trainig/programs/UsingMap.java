package com.epsilon.trainig.programs;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UsingMap {

	public static void main(String[] args) {
		Map<Integer, String> people =  new HashMap<>();
		people.put(11, "Anu");
		people.put(22, "Anjali");
		people.put(33, "Ajith");
		people.put(44, "Bhushan");
		people.put(11, "Anujna");
		
		log.debug("Enteries in the people: {}", people.size());
		log.debug("Value of key {} is {} ", 11, people.get(11));
		log.debug("Value of key {} is {} ", 66, people.get(66));
		
		log.debug("Keys: ");
		for(Integer key: people.keySet()) {
			log.debug("{}", key);
		}
		
		log.debug("Values: ");
		for(String val: people.values()) {
			log.debug("{}", val);
		}
		
		log.debug("Entries: ");
		for(Entry<Integer, String> en: people.entrySet()) {
			log.debug("Key: {}, Values: {}", en.getKey(), en.getValue());
		}
	}

}
