package com.epsilon.training.programs;

import java.io.IOException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ReadFromKeyBoard {
	
	public static void main(String[] args) throws IOException {
		byte[] bytes = new byte[50];
		System.out.println("Enter the value: ");
		System.in.read(bytes);
		log.debug("You entered {}",bytes );
		String name = new String(bytes).trim();
		System.out.println("HEllo "+ name);
	}
	public static void main2(String[] args) throws IOException {
		System.out.println("Enter the value: ");
		int ch;
		String name = "";
		while((ch = System.in.read()) != '\n') {
			name += (char)ch;
		}
		log.debug("You entered {}: {}",ch, (char)ch );
	}
	
	public static void main1(String[] args) throws IOException {
		log.debug("Enter the value: ");
		int ch = System.in.read();
		log.debug("You entered {}: {}",ch, (char)ch );
	}
}
