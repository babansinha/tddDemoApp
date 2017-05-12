package com.psl.tdd.util;

import org.junit.Test;

import com.psl.tdd.constants.ConstantsUtil;
import com.psl.tdd.constants.MessageConstant;
import com.psl.tdd.exception.ReaderException;
import com.psl.tdd.test.BaseTest;

public class FileReaderUtilIT extends BaseTest {
		
	@Test
	public void testNullDirectoryAsInput() throws ReaderException {
		System.out.println("testNullDirectoryAsInput. . .");
		//1. Exception is expected
		thrown.expect(ReaderException.class);
        thrown.expectMessage(MessageConstant.INVALID_DIRECTORY_PATH);
        FileReaderUtil.getSchemaFileListFromSchemasFolder(null);
	}
	
	@Test
	public void testIsDirectoryExistWithInvalidPath() throws ReaderException {
		System.out.println("testIsDirectoryExistWithInvalidPath. . .");
		thrown.expect(ReaderException.class);
        thrown.expectMessage(MessageConstant.INVALID_DIRECTORY_PATH);
        FileReaderUtil.getSchemaFileListFromSchemasFolder(ConstantsUtil.INVALID_SCHEMA_FOLDER_ABSOLUTE_PATH);
	}
	
	@Test
	public void testIsDirectoryExistWithValidPath() throws ReaderException {
		System.out.println("testIsDirectoryExistWithValidPath. . .");
		thrown.expect(ReaderException.class);
        thrown.expectMessage(MessageConstant.INVALID_DIRECTORY_PATH);
        FileReaderUtil.getSchemaFileListFromSchemasFolder(ConstantsUtil.INVALID_SCHEMA_FOLDER_ABSOLUTE_PATH);
	}
	
	@Test
	public void testIsFileExist() throws ReaderException {
		System.out.println("testIsFileExist. . .");
		thrown.expect(ReaderException.class);
		thrown.expectMessage(MessageConstant.EMPTY_DIRECTORY);
		FileReaderUtil.getSchemaFileListFromSchemasFolder(ConstantsUtil.SCHEMA_FOLDER_ABSOLUTE_PATH);
	}
	
	
	@Test
	public void testIsValidFile() {
		System.out.println("testIsValidFile. . .");
		//1. True or False is expected
		//assertThat(files.isEmpty(), is(false));
		//assertThat(files, hasSize(equalTo(1)));
		
		// to test whether the file has data or not
		thrown.expect(ReaderException.class);
		thrown.expectMessage(MessageConstant.EMPTY_FILE);
		//FileReaderUtil.isValidFile("FilePath");
	}
	
	@Test
	public void testReadFilesFromDirectory() {
		System.out.println("testReadFilesFromDirectory. . .");
		// Combination of all above test cases
	}
}
