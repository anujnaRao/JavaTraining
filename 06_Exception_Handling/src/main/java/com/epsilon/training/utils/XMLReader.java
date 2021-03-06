package com.epsilon.training.utils;

import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.IOException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class XMLReader implements Closeable{
	
	public XMLReader() throws FileNotFoundException {
		log.debug("Instantiated");
		throw new FileNotFoundException("Unable to locate the file");
	}
	
	public void read() throws IOException {
		log.debug("Reading");
		throw new IOException("Unable to read XML file");
	}
	
	public void close() throws IOException {
		log.debug("Releasing any resources");
	}
}
