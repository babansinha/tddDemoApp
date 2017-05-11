package com.psl.tdd.util;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.psl.tdd.constants.MessageConstant;
import com.psl.tdd.exception.ReaderException;
import com.psl.tdd.test.BaseTest;

//import static com.jayway.restassured.RestAssured.*;
//import static com.jayway.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.equalTo;

import java.util.List;

import static org.mockito.Mockito.*;

public class FileReaderUtilIT extends BaseTest {
	/*@Test
	public void firstEchoTest() {
		//get("/echo/hello").then().assertThat().body("message", equalTo("hello"));
		//get("/echo/hello").then().assertThat().body("message", equalTo("hello"));
	}*/
	
	@Before
	public void init() {
		System.out.println("Init. . .");
	}
	
	@After
	public void desptroy() {
		System.out.println("desptroy. . .");
	}
	
	
	@Test
	public void testNullDirectoryAsInput() {
		System.out.println("testNullDirectoryAsInput. . .");
		//1. Exception is expected
		thrown.expect(ReaderException.class);
        thrown.expectMessage(MessageConstant.INVALI_FILE_PATH);
        FileReaderUtil.getSchemaFileListFromSchemasFolder(null);
	}
	
	@Test
	public void testIsDirectoryExistWithInvalidPath() {
		System.out.println("testIsDirectoryExistWithInvalidPath. . .");
		thrown.expect(ReaderException.class);
        thrown.expectMessage(MessageConstant.INVALI_DIRECTORY_PATH);
        FileReaderUtil.getSchemaFileListFromSchemasFolder(ConstantsUtil.INVALID_SCHEMA_FOLDER_ABSOLUTE_PATH);
	}
	
	@Test
	public void testIsDirectoryExistWithValidPath() {
		System.out.println("testIsDirectoryExistWithValidPath. . .");
		//assertThat(FileReaderUtil.isValidDirectory("directoryPath"), is(false));
	}
	
	@Test
	public void testIsFileExist() {
		System.out.println("testIsFileExist. . .");
	}
	
	@Test
	public void testIsValidFile() {
		System.out.println("testIsValidFile. . .");
		//1. True or False is expected
		//assertThat(files.isEmpty(), is(false));
		//assertThat(files, hasSize(equalTo(1)));
	}
	
	@Test
	public void testReadFilesFromDirectory() {
		System.out.println("testReadFilesFromDirectory. . .");
		//Combination of all above test cases
	}
	
}
