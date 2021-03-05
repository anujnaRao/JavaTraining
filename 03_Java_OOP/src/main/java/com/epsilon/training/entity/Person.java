package com.epsilon.training.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
//3 ways to do toString, lambok, own writing ot eclipse

public class Person {
	
	private String firstname;
	private String lastname;
	private String email;
	private String address;
}
