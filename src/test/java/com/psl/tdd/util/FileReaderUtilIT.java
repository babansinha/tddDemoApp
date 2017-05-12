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

/**
 * This Class is responsible to test file reading functionalities
 *
 */
public class FileReaderUtilIT extends BaseTest {
		
	/**
	 * This function is responsible to test NULL value as a directory path
	 * This will throw ReaderException with {@link MessageConstant.INVALID_DIRECTORY_PATH} message
	 * 
	 * @throws ReaderException
	 */
	@Test
	public void testNullDirectoryAsInput() throws ReaderException {
		thrown.expect(ReaderException.class);
        thrown.expectMessage(MessageConstant.INVALID_DIRECTORY_PATH);
        FileReaderUtil.getSchemaFileListFromSchemasFolder(null);
	}
	
	/**
	 * This function is responsible to test 'INVALID' value as a directory path
	 * This will throw ReaderException with {@link MessageConstant.INVALID_DIRECTORY_PATH} message
	 * 
	 * @throws ReaderException
	 */
	@Test
	public void testIsDirectoryExistWithInvalidPath() throws ReaderException {
		thrown.expect(ReaderException.class);
        thrown.expectMessage(MessageConstant.INVALID_DIRECTORY_PATH);
        FileReaderUtil.getSchemaFileListFromSchemasFolder(ConstantsUtil.INVALID_SCHEMA_FOLDER_ABSOLUTE_PATH);
	}
	
	
	/**
	 * This function is responsible to test whether file exist or not of given Empty directory
	 * This will throw ReaderException with {@link MessageConstant.EMPTY_DIRECTORY} message
	 * 
	 * @throws ReaderException
	 */
	@Test
	public void testIsFileExistForEmptyDirectory() throws ReaderException, IOException {
		thrown.expect(ReaderException.class);
		thrown.expectMessage(MessageConstant.EMPTY_DIRECTORY);
		File folder = testFolder.newFolder("FileReader_EmptyFolder");
		FileReaderUtil.getSchemaFileListFromSchemasFolder(folder.getAbsolutePath());
	}
	
	
	/**
	 * This function is responsible to test whether file(it may be empty file) exist or not of given valid file path
	 * This will throw ReaderException with {@link MessageConstant.EMPTY_FILE} message
	 * 
	 * @throws IOException, ReaderException
	 */
	@Test
	public void testIsValidForEmptyFile() throws IOException, ReaderException {
		thrown.expect(ReaderException.class);
		thrown.expectMessage(MessageConstant.EMPTY_FILE);
		File emptyFile = testFolder.newFile("FileReader_EmptyFile");
		FileReaderUtil.isValidFile(emptyFile);
	}
	
	/**
	 * This function is responsible to test file reading method with all valid scenario 
	 * This will return list of file's absolute path
	 * 
	 * @throws ReaderException
	 */
	@Test
	public void testReadFileWithValidInput() throws ReaderException {
        List<String> list = FileReaderUtil.getSchemaFileListFromSchemasFolder(ConstantsUtil.SCHEMA_FOLDER_ABSOLUTE_PATH);
        assertTrue(list.size() > 0);
	}
	
}
