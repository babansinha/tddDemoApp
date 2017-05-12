package com.psl.tdd.constants;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ConstantsUtil {
	
	public static final String SCHEMA_FOLDER_ABSOLUTE_PATH = System.getProperty("user.dir")+"/src/test/resource/data"; 
	public static final String INVALID_SCHEMA_FOLDER_ABSOLUTE_PATH = "D:\\projects1\\healthcare\\workshop\\data"; 

	
	public static final Set<String> HEADER_SET = new HashSet<String>(Arrays.asList("COLUMNNAME", "TYPE", "LENGTH", "AUTOINCREMENT", "CONSTRAINTS"));
}