package com.psl.tdd.test;

import org.junit.Rule;
import org.junit.rules.ExpectedException;

public abstract class BaseTest {
	@Rule
    public ExpectedException thrown = ExpectedException.none();
}
