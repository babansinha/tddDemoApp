package com.psl.tdd.util;

import static org.junit.Assert.assertTrue;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import com.psl.tdd.constants.ConstantsUtil;
import com.psl.tdd.constants.MessageConstant;
import com.psl.tdd.exception.ReaderException;
import com.psl.tdd.modal.Table;
import com.psl.tdd.test.BaseTest;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class CsvToTableConverterTest extends BaseTest {
	
	/**
	 * This method is responsible to verify valid table name
	 *  - will test table name has no special characters which are not allowed like -,. 
	 *  - will test table name has start from number
	 * 
	 * @throws IOException
	 * @throws ReaderException
	 */
	@Test
	public void testValidTableName() throws IOException, ReaderException {
		// to test table name has no special characters which are not allowed like -,. 
		// to test table name has start from number
		File file = testFolder.newFile("123A-B.csv");
		thrown.expect(ReaderException.class);
		thrown.expectMessage(MessageConstant.INVALID_TABLE_NAME);
		CsvToTableConverter.convertCsvToTable(file.getAbsolutePath());
	}
	
	/**
	 * To test the input for the method is not ArrayList<String> with size >0
	 *  - input may be null
	 *  - input may be list of size = 0
	 *  
	 * @throws ReaderException
	 */
	@Test
	public void testForInvalidInput() throws ReaderException{
		// to test the input for the method is not ArrayList<String> with size >0
		// input may be null
		// input may be list of size = 0
		
		thrown.expect(ReaderException.class);
		thrown.expectMessage(MessageConstant.INVALID_INPUT);
		CsvToTableConverter.convertCsvToTable(null);
		CsvToTableConverter.convertCsvToTable("");
	}
	
	/**
	 * To test by passing valid input, output would be correct
	 * 
	 * @throws ReaderException
	 */
	@Test
	public void testForValidInput() throws ReaderException {
		// to test by passing valid input, output would be correct

		Table table = CsvToTableConverter.convertCsvToTable(ConstantsUtil.SCHEMA_FOLDER_ABSOLUTE_PATH+"/Employee.csv");
		assertTrue(table!=null && !"".equals(table.getTableName().trim()));
	}
	
	/**
	 * Test the file with one row only i.e. header
	 * 
	 * @throws ReaderException
	 */
	@Test
	public void testTableWithHeaderOnly() throws ReaderException{
		//test the file with one row only
		
		thrown.expect(ReaderException.class);
		thrown.expectMessage(MessageConstant.ROWS_NOT_PRESENT);
		CsvToTableConverter.convertCsvToTable(ConstantsUtil.SCHEMA_FOLDER_ABSOLUTE_PATH+"/HeaderOnlyEmployee.csv");
	}
	

	/**
	 * Check the headers for the table are in the set only like {columnName, type, length, autoincrement, constraints}
	 * Anything else would fail the testcase.
	 * 
	 * @throws ReaderException
	 */
	@Test
	public void testForValidInputToGetValidOutput() throws ReaderException{
		// check the headers for the table are in the set only like {columnName, type, length, autoincrement, constraints} 
		// Anything else would fail the testcase.
		
		thrown.expect(ReaderException.class);
		thrown.expectMessage(MessageConstant.INVALID_HEADERS_LIST);
		CsvToTableConverter.convertCsvToTable(ConstantsUtil.SCHEMA_FOLDER_ABSOLUTE_PATH+"/InvalidColumnEmployee.csv");
	}
	
}
