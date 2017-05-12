package com.psl.tdd.util;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.psl.tdd.constants.ConstantsUtil;
import com.psl.tdd.constants.MessageConstant;
import com.psl.tdd.exception.ReaderException;
import com.psl.tdd.test.BaseTest;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class FileReaderUtilIT extends BaseTest {
		
	@Test
	public void testNullDirectoryAsInput() throws ReaderException {
		System.out.println("testNullDirectoryAsInput. . .");
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
		
        List<String> list = FileReaderUtil.getSchemaFileListFromSchemasFolder(ConstantsUtil.SCHEMA_FOLDER_ABSOLUTE_PATH);
        assertTrue(list.size()>0);
	}
	
	@Test
	public void testIsFileExist() throws ReaderException, IOException {
		System.out.println("testIsFileExist. . .");
		thrown.expect(ReaderException.class);
		thrown.expectMessage(MessageConstant.EMPTY_DIRECTORY);
		File folder = testFolder.newFolder("FileReader_EmptyFolder");
		FileReaderUtil.getSchemaFileListFromSchemasFolder(folder.getAbsolutePath());
	}
	
	
	@Test
	public void testIsValidFile() throws IOException, ReaderException {
		System.out.println("testIsValidFile. . .");
		thrown.expect(ReaderException.class);
		thrown.expectMessage(MessageConstant.EMPTY_FILE);
		File emptyFile = testFolder.newFile("FileReader_EmptyFile");
		FileReaderUtil.isValidFile(emptyFile);
		
	}
	
	/*@Test
	public void testReadFilesFromDirectory() {
		System.out.println("testReadFilesFromDirectory. . .");
		// Combination of all above test cases
	}*/
}
