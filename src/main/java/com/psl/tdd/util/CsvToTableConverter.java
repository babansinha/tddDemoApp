package com.psl.tdd.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import com.opencsv.CSVReader;
import com.psl.tdd.constants.ConstantsUtil;
import com.psl.tdd.modal.Column;
import com.psl.tdd.modal.Table;

public class CsvToTableConverter {

	
	public static Map<String, Table> getTablesMap(String directoryPath) {
		
		List<String> filesPath =  FileReaderUtil.getSchemaFileListFromSchemasFolder(directoryPath);

		Map<String, Table> map = new HashMap<>();
        
           
    	/*Map<String, Table> collect = filesPath.stream()
    			.
    			.collect(Collectors.toMap(p -> p.getKey(), p -> p.getValue()));*/
    	filesPath.forEach(csvFile -> {
    		try {
					Table table = CsvToTableConverter.convertCsvToTable(csvFile);
					map.put(table.getTableName(), table);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	});
    	
    	/*filesPath.stream()
    	.filter(csvFile -> !"mkyong".equals(csvFile))
    	.forEach(CsvToTableConverter::convertCsvToTable)
    	;*/

    	
		return map;
	}
	
	public static Table convertCsvToTable(String filePath) {
		CSVReader reader = null;
		File file = null;
		Set<Column> columns = new HashSet<>();
		List<String> errorMessages = new ArrayList<>();
		
		try {
				String[] line;
			    file = new File(filePath);
				reader = new CSVReader(new FileReader(filePath));
				reader.readNext();
				while ((line = reader.readNext()) != null) {
					if (isValidColumn(line)) {
						Column column = new Column();
						column.setColumnName(line[0]);
						column.setType(line[1]);
						column.setLength(Integer.parseInt(line[2].trim()));
						column.setAutoIncrement(Boolean.getBoolean(line[3]));
						columns.add(column);
						
						System.out.println("Table : " + file.getName().subSequence(0, file.getName().indexOf("."))
								+ " : Column [columnName= " + line[0] + ", type= " + line[1] + " , length=" + line[2]
								+ " , autoIncrement=" + line[3] + "]");
					} else {
						errorMessages.add(Arrays.toString(line) + " -> is Invalid!!");
					}
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
	
	
	private static boolean isValidColumn(String[] line) {
		for (int i = 0; i < line.length; i++) {
			switch (i) {
			case 0:
				String columnName = line[i].trim();
				if (columnName.isEmpty() || columnName.length() < 1) {
					return false;
				}
				break;
			case 1:
				String type = line[i].trim();
				//type.matches("-?\\d+(\\.\\d+)?") 
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
			}
		}
		
		return true;
	}

	public static void main(String[] args) throws IOException {
		List<String> files = FileReaderUtil.getSchemaFileListFromSchemasFolder(ConstantsUtil.SCHEMA_FOLDER_ABSOLUTE_PATH);
		System.out.println("files :: " + files);
		System.out.println(getTablesMap(ConstantsUtil.SCHEMA_FOLDER_ABSOLUTE_PATH));		
		
	}

}
