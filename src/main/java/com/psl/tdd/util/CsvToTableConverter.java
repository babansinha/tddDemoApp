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
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import com.opencsv.CSVReader;
import com.psl.tdd.constants.ConstantsUtil;
import com.psl.tdd.constants.MessageConstant;
import com.psl.tdd.exception.ReaderException;
import com.psl.tdd.modal.Column;
import com.psl.tdd.modal.Table;

public class CsvToTableConverter {
	
	public static Map<String, Table> getTablesMap(String directoryPath) throws ReaderException {
		
		List<String> filesPath =  FileReaderUtil.getSchemaFileListFromSchemasFolder(directoryPath);

		Map<String, Table> map = new HashMap<>();
        
		filesPath.forEach(csvFile -> {
			try {
				Table table = CsvToTableConverter.convertCsvToTable(csvFile);
				map.put(table.getTableName(), table);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
    	
		return map;
	}
	
	public static Table convertCsvToTable(String filePath) throws ReaderException {
		
		if (filePath==null || "".equals(filePath.trim())) {
			throw new ReaderException(MessageConstant.INVALID_INPUT);
		}
		
		CSVReader reader = null;
		File file = null;
		Set<Column> columns = new HashSet<>();
		List<String> errorMessages = new ArrayList<>();
		
		try {
				String[] line;
			    file = new File(filePath);
			    
			    if(!isValidTableName(file.getName())){
			    	throw new ReaderException(MessageConstant.INVALID_TABLE_NAME);
			    }
			    
				reader = new CSVReader(new FileReader(filePath));
				
				if(!isValidHeaderList(reader.readNext())) {
					throw new ReaderException(MessageConstant.INVALID_HEADERS_LIST);
				}
				
				while ((line = reader.readNext()) != null) {
					if (isValidColumn(line)) {
						
						Column column = new Column();
						
						for (int i = 0; i < line.length; i++) {
							switch (i) {
							case 0:
								column.setColumnName(line[i].trim());
								break;
							case 1:
								column.setType(line[i].trim());
								break;
							case 2:
								int length = Integer.parseInt(line[i].trim());
								column.setLength(length);
								break;
							case 3:
								boolean isAutoincrement = Boolean.parseBoolean(line[i].trim());
								column.setAutoIncrement(isAutoincrement);
								break;
							case 4:
								String constraints = line[i].trim();
								// not in use now
								break;
							}
						}

						columns.add(column);
						
						System.out.println("Table : " + file.getName().subSequence(0, file.getName().indexOf("."))
								+ " : Column [columnName= " + line[0] + ", type= " + line[1] + " , length=" + line[2]
								+ " , autoIncrement=" + line[3] + "]");
					} else {
						throw new ReaderException(MessageConstant.INVALID_DATA_IN_FILE_EXCEPTION);
						//errorMessages.add(Arrays.toString(line) + " -> is Invalid!!");
					}
				}
				
				if (columns.size()==0) {
					throw new ReaderException(MessageConstant.ROWS_NOT_PRESENT);
				}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (reader!=null) {
					reader.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
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
	
	
	private static boolean isValidHeaderList(String[] line) {
		
		for(String header : line){
			if(!ConstantsUtil.HEADER_SET.contains(header.trim().toUpperCase())){
				return false;
			}
		}
		
		return true;
	}

	private static boolean isValidTableName(final String tableName) {
		
		Pattern pattern = Pattern.compile("^(\\d+|-)(.*)");
		Matcher matcher = pattern.matcher(tableName);
		if(matcher.matches()){
			return false;
		} else if (tableName.contains("-")) {
			return false;
		}
		
		return true;
	}

	private static boolean isValidColumn(String[] line) {
		
		try {
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
					int length = Integer.parseInt(line[i].trim());
					break;
				case 3:
					boolean isAutoincrement = Boolean.parseBoolean(line[i].trim());
					break;
				case 4:
					String constraints = line[i].trim();
					break;
				}
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public static void main(String[] args) throws IOException, ReaderException {
		List<String> files = FileReaderUtil.getSchemaFileListFromSchemasFolder(ConstantsUtil.SCHEMA_FOLDER_ABSOLUTE_PATH);
		System.out.println("files :: " + files);
		System.out.println(getTablesMap(ConstantsUtil.SCHEMA_FOLDER_ABSOLUTE_PATH));		
		
	}

}
