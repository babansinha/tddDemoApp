package com.psl.tdd.util;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import com.psl.tdd.constants.ConstantsUtil;
import com.psl.tdd.constants.MessageConstant;
import com.psl.tdd.exception.ReaderException;
import com.psl.tdd.test.BaseTest;

import java.io.File;
import java.io.IOException;

public class CsvToTableConverterTest extends BaseTest {
	
	
	@Rule
	public TemporaryFolder testFolder = new TemporaryFolder();
	
	@Test
	public void testValidTableName() throws IOException {
		// to test table name has no special characters which are not allowed like -,. 
		// to test table name has start from number
		File file = testFolder.newFile("123A-B.csv");
		thrown.expect(ReaderException.class);
		thrown.expectMessage(MessageConstant.INVALID_TABLE_NAME);
		CsvToTableConverter.convertCsvToTable(file.getAbsolutePath());
	}
	
	/*@Test
	public void testValidColumn(){
		// check the headers for the table are in the set only like {columnName, type, length, autoincrement, constraints} Anything else would fail the testcase.
		
		thrown.expect(ReaderException.class);
		thrown.expectMessage(MessageConstant.INVALID_HEADERS_LIST);
		CsvToTableConverter.convertCsvToTable(ConstantsUtil.SCHEMA_FOLDER_ABSOLUTE_PATH);
	}
	
	@Test
	public void testForInvalidInput(){
		// to test the input for the method is not ArrayList<String> with size >0
		// input may be null
		// input may be list of size = 0
		
		thrown.expect(ReaderException.class);
		thrown.expectMessage(MessageConstant.INVALID_TABLE_NAME);
		CsvToTableConverter.convertCsvToTable(ConstantsUtil.SCHEMA_FOLDER_ABSOLUTE_PATH);
	}
	
	@Test
	public void testForValidInput(){
		// to test by passing valid input, output would be correct
		
		thrown.expect(ReaderException.class);
		thrown.expectMessage(MessageConstant.INVALID_TABLE_NAME);
		CsvToTableConverter.convertCsvToTable(ConstantsUtil.SCHEMA_FOLDER_ABSOLUTE_PATH);
	}
	
	@Test
	public void testTableWithNoHeader(){
		// to vaildate the file with no columnheaders
		
		thrown.expect(ReaderException.class);
		thrown.expectMessage(MessageConstant.INVALID_TABLE_NAME);
		CsvToTableConverter.convertCsvToTable(ConstantsUtil.SCHEMA_FOLDER_ABSOLUTE_PATH);
		
	}
	
	@Test
	public void testTableWithMoreThanDesiredHeader(){
		//to test the column with the number not more than 5 
		
		thrown.expect(ReaderException.class);
		thrown.expectMessage(MessageConstant.INVALID_TABLE_NAME);
		CsvToTableConverter.convertCsvToTable(ConstantsUtil.SCHEMA_FOLDER_ABSOLUTE_PATH);
	}
	
	@Test
	public void testTableWithHeaderOnly(){
		//test the file with one row only
		
		thrown.expect(ReaderException.class);
		thrown.expectMessage(MessageConstant.INVALID_TABLE_NAME);
		CsvToTableConverter.convertCsvToTable(ConstantsUtil.SCHEMA_FOLDER_ABSOLUTE_PATH);
	}
	
	@Test
	public void testTableWithColumnNameOnly(){
		// test the file with only 1 headers as columnName
		// test should pass with the default value
		
		thrown.expect(ReaderException.class);
		thrown.expectMessage(MessageConstant.INVALID_TABLE_NAME);
		CsvToTableConverter.convertCsvToTable(ConstantsUtil.SCHEMA_FOLDER_ABSOLUTE_PATH);
	}
	
	@Test
	public void testTableWithColumnNameTypeOnly(){
		// test the file with only 2 headers as columnName and type
		// test should pass with the default value
		
		thrown.expect(ReaderException.class);
		thrown.expectMessage(MessageConstant.INVALID_TABLE_NAME);
		CsvToTableConverter.convertCsvToTable(ConstantsUtil.SCHEMA_FOLDER_ABSOLUTE_PATH);
	}
	
	@Test
	public void testTableWithColumnNameTypeLengthOnly(){
		// test the file with only 3 headers as columnName, type and Length
		// test should pass with the default value
		
		thrown.expect(ReaderException.class);
		thrown.expectMessage(MessageConstant.INVALID_TABLE_NAME);
		CsvToTableConverter.convertCsvToTable(ConstantsUtil.SCHEMA_FOLDER_ABSOLUTE_PATH);
	}
	
	@Test
	public void testTableWithColumnNameTypeLengthAutoincrementOnly(){
		// test the file with only 4 headers as columnName, type, length and autoincrement
		// test should pass with the default value
		
		thrown.expect(ReaderException.class);
		thrown.expectMessage(MessageConstant.INVALID_TABLE_NAME);
		CsvToTableConverter.convertCsvToTable(ConstantsUtil.SCHEMA_FOLDER_ABSOLUTE_PATH);
	}
	
	@Test
	public void testForValidInputToGetValidOutput(){
		// test should pass
		
		thrown.expect(ReaderException.class);
		thrown.expectMessage(MessageConstant.INVALID_TABLE_NAME);
		CsvToTableConverter.convertCsvToTable(ConstantsUtil.SCHEMA_FOLDER_ABSOLUTE_PATH);
	}
*/
}
