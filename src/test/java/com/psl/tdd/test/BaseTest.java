package com.psl.tdd.test;

import org.junit.Rule;
import org.junit.rules.ExpectedException;
import org.junit.rules.TemporaryFolder;

/**
 * This is base test abstract class which contains common re-usable code for all derived test classes
 *  
 * @author baban_sinha
 *
 */
public abstract class BaseTest {
	
	/**
	 * To test if any exception being thrown with messages
	 */
	@Rule
    public ExpectedException thrown = ExpectedException.none();

	/**
	 * To test Folders and Files related test assertions
	 */
	@Rule
	public TemporaryFolder testFolder = new TemporaryFolder();
}
