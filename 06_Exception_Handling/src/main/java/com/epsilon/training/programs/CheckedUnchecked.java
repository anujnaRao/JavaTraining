package com.epsilon.training.programs;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CheckedUnchecked {

	public static void main(String[] args) {
		
		String str = "1234";
		int n1 = Integer.parseInt(str);
		
		String fn = "pom.xml";
		FileReader reader = null;
		try {
			reader = new FileReader(fn);
			log.debug("File founf");
		} catch (FileNotFoundException e) {
			log.warn("File not found ..");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				reader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		log.debug("n1 is {} ", n1);
		//Unchecked - arithmetic, numberformat - optional
		//Unchecked -- filenotfound, sql -- compulsory throws or try/catch -- both un/check for compiler
		
		
		
	}

}
