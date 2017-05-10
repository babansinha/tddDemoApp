package com.psl.tdd.util;

import org.junit.Test;

import static com.jayway.restassured.RestAssured.*;
import static com.jayway.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.equalTo;

import java.util.List;

public class FileReaderUtilIT {
	@Test
	public void firstEchoTest() {
		//get("/echo/hello").then().assertThat().body("message", equalTo("hello"));
		//get("/echo/hello").then().assertThat().body("message", equalTo("hello"));
		/*List<String> files = FileReaderUtil.getFilepathFromSchemas();
		
		assertThat(files.isEmpty(), is(false));
		assertThat(files, hasSize(equalTo(1)));*/

		
	}
	
	public void testNullDirectoryAsInput() {
		
	}
	
	public void testIsDirectoryExist() {
		/*testNullDirectoryAsInput();
		//Throw Exception
		List<String> filesWithInvalidDirectory = FileReaderUtil.getFilepathFromSchemas();
		
		// Return Object of List
		List<String> filesWithValidDirectory = FileReaderUtil.getFilepathFromSchemas();*/
		
	}
	
	public void testIsFileExist() {
		/*List<String> filesWithInvalidDirectory = FileReaderUtil.getFilepathFromSchemas();
		
		List<String> filesWithValidDirectory = FileReaderUtil.getFilepathFromSchemas();*/
	}
	
	public void testReadFilesFromDirectory() {
		testIsDirectoryExist();
		testIsFileExist();		
	}
	
}
