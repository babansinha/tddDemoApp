package com.psl.tdd.util;

import org.junit.Test;

import com.psl.tdd.exception.ReaderException;

//import static com.jayway.restassured.RestAssured.*;
//import static com.jayway.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.equalTo;

import java.util.List;

import static org.mockito.Mockito.*;

public class FileReaderUtilIT {
	/*@Test
	public void firstEchoTest() {
		//get("/echo/hello").then().assertThat().body("message", equalTo("hello"));
		//get("/echo/hello").then().assertThat().body("message", equalTo("hello"));
	}*/
	
	@Test//(expected=ReaderException.class)
	public void testNullDirectoryAsInput() {
		//1. Exception is expected
		
	}
	
	@Test
	public void testIsDirectoryExist() {
		/*testNullDirectoryAsInput();
		//Throw Exception
		List<String> filesWithInvalidDirectory = FileReaderUtil.getFilepathFromSchemas();
		
		// Return Object of List
		List<String> filesWithValidDirectory = FileReaderUtil.getFilepathFromSchemas();*/
		
	}
	
	@Test
	public void testIsFileExist() {
		/*List<String> filesWithInvalidDirectory = FileReaderUtil.getFilepathFromSchemas();
		
		List<String> filesWithValidDirectory = FileReaderUtil.getFilepathFromSchemas();*/
	}
	
	@Test
	public void testIsValidFile() {
		//1. True or False is expected
		//assertThat(files.isEmpty(), is(false));
		//assertThat(files, hasSize(equalTo(1)));
	}
	
	@Test
	public void testReadFilesFromDirectory() {
		testIsDirectoryExist();
		testIsFileExist();		
		testIsValidFile();
	}
	
}
