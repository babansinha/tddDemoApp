package com.psl.tdd.util;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.psl.tdd.constants.ConstantsUtil;
import com.psl.tdd.constants.MessageConstant;
import com.psl.tdd.exception.ReaderException;
import com.psl.tdd.test.BaseTest;

public class FileReaderUtilIT extends BaseTest {
	@BeforeClass
	public void setup(){
		// need to create all type of folders that can be used along with files.
	}
	
	@AfterClass
	public void teardown(){
		// need to create all type of folders that can be used along with files.
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
		//assertThat(FileReaderUtil.isValidDirectory(ConstantsUtil.SCHEMA_FOLDER_ABSOLUTE_PATH), is(false));
	}
	
	@Test
	public void testIsFileExist() {
		System.out.println("testIsFileExist. . .");
		thrown.expect(ReaderException.class);
		thrown.expectMessage(MessageConstant.EMPTY_FILE);
		FileReaderUtil.getSchemaFileListFromSchemasFolder(ConstantsUtil.SCHEMA_FOLDER_ABSOLUTE_PATH);
	}
	
	
	@Test
	public void testIsValidFile() {
		System.out.println("testIsValidFile. . .");
		//1. True or False is expected
		//assertThat(files.isEmpty(), is(false));
		//assertThat(files, hasSize(equalTo(1)));
		
		// to test wether the file has data or not
		thrown.expect(ReaderException.class);
		thrown.expectMessage(MessageConstant.EMPTY_FILE);
		FileReaderUtil.getSchemaFileListFromSchemasFolder(ConstantsUtil.SCHEMA_FOLDER_ABSOLUTE_PATH);
	}
	
	@Test
	public void testReadFilesFromDirectory() {
		System.out.println("testReadFilesFromDirectory. . .");
		//Combination of all above test cases
	}
	
}
