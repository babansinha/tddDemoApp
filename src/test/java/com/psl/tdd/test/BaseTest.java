package com.psl.tdd.test;

import org.junit.Rule;
import org.junit.rules.ExpectedException;
import org.junit.rules.TemporaryFolder;

public abstract class BaseTest {
	
	@Rule
    public ExpectedException thrown = ExpectedException.none();

	
	@Rule
	public TemporaryFolder testFolder = new TemporaryFolder();
}
