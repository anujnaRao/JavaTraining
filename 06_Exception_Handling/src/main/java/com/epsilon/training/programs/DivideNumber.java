package com.epsilon.training.programs;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DivideNumber {

	public static void main(String[] args) {
		
		log.debug("Argument received {}", args.length);
		for (int i = 0; i < args.length; i++) {
			log.debug("args[{}] = {} of type {}", i, args[i], args[i].getClass().getName());
		}
		try {
			String input1 = args[0];
			String input2 = args[1];
			
			int neu = Integer.parseInt(input1);
			int den = Integer.parseInt(input2);
			
			int quo = neu/den;
			log.debug("{} /  {} = {}", neu, den, quo);
		}// Multiple catch statements
		
		catch(ArithmeticException e) {
			log.warn("No division by 0");
		}
		catch(ArrayIndexOutOfBoundsException | NumberFormatException e) {
			log.warn("No args");
		}
		
		// Throwable - Error, Exception -- Javadoc
		//Subclass of runtime exception --  unchecked exception along with runtime exception
		//Subclasses of exception -- checked exception including, throwable , Exception

	}

}
