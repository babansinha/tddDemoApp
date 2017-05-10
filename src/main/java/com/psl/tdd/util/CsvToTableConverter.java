package com.psl.tdd.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import com.opencsv.CSVReader;
import com.psl.tdd.modal.Column;
import com.psl.tdd.modal.Table;

public class CsvToTableConverter {

	public static Map<Integer, String> getMapFromCSVString(String csvString) {
        AtomicInteger integer = new AtomicInteger();
        return Arrays.stream(csvString.split(","))
                .collect(Collectors.toMap(splittedStr -> integer.getAndAdd(1), splittedStr -> splittedStr));
    }
	
	
	public static Map<String, Table> getTablesMap(String directoryPath) {
		
		//String csvFile = "/Users/mkyong/csv/country3.csv";
		List<String> filesPath =  FileReaderUtil.getFilepathFromSchemas();
		//csvFile = filesPath.get(0);

		Map<String, Table> map = new HashMap<>();
        	
    	for (String csvFile : filesPath) {
    		Table table = convertCsvToTable(csvFile);
    		map.put(table.getTableName(), table);
		}
           

		return map;
	}
	
	public static Table convertCsvToTable(String filePath) {
		CSVReader reader = null;
		File file = null;
		Set<Column> columns = new HashSet<>();
		
		try {
				String[] line;
			    file = new File(filePath);
				reader = new CSVReader(new FileReader(filePath));
				reader.readNext();
				while ((line = reader.readNext()) != null) {
					Column column = new Column();
					column.setColumnName(line[0]);
					column.setType(line[1]);
					column.setLength(Integer.parseInt(line[2].trim()));
					column.setAutoIncrement(Boolean.getBoolean(line[3]));
					columns.add(column);
					
					System.out.println("Table : " + file.getName().subSequence(0, file.getName().indexOf("."))
							+ " : Column [columnName= " + line[0] + ", type= " + line[1] + " , length=" + line[2]
							+ " , autoIncrement=" + line[3] + "]");
				}

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Table table = new Table();
		if (file != null) {
			String tableName = file.getName().subSequence(0, file.getName().lastIndexOf(".")).toString();
			table.setTableName(tableName);
		}
		
		table.setColumns(columns);
		table.setFilePath(filePath);
		
		return table;
	}
	
	public static boolean isValidCsvFile(String filePath) {
		
		
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		List<String> files = FileReaderUtil.getFilepathFromSchemas();
		System.out.println("files :: " + files);
		System.out.println(getTablesMap(""));		
		
	}

}
