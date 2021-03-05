package com.epsilon.training.programs;

import java.io.IOException;

import com.epsilon.training.utils.XMLReader;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TryWithResourceDemo {

	public static void main(String[] args) {
		log.debug("Main start");
		try(XMLReader reader = new XMLReader()){
			log.debug("Using reader");
			reader.read();
		}
		catch (Exception e) {
			log.warn("There was an error");
		}
		log.debug("Main end");
	}
	public static void main1(String[] args) {
		XMLReader reader = null;
		
		try {
			log.debug("Initiating xml reader");
			reader = new XMLReader();
			
			log.debug("Using reader");
			reader.read();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
