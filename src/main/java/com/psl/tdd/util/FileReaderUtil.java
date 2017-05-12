package com.psl.tdd.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.psl.tdd.constants.ConstantsUtil;
import com.psl.tdd.constants.MessageConstant;
import com.psl.tdd.exception.ReaderException;

public class FileReaderUtil {
	
	public static List<String> getSchemaFileListFromSchemasFolder(String directoryPath) throws ReaderException {

		if(directoryPath==null) {
			throw new ReaderException(MessageConstant.INVALID_DIRECTORY_PATH);
		}
		
		List<String> fileList = new ArrayList<String>();

		File folder = new File(directoryPath);
		if ( !folder.exists() ) {
			throw new ReaderException(MessageConstant.INVALID_DIRECTORY_PATH);
		} else {
			for ( File file : folder.listFiles() ) {
				if ( file.isFile() && "csv".equals( getFileExtension( file.getName() ))) {
					
					BufferedReader br = null;
					
					try {
						br = new BufferedReader(new FileReader(file));
						if (br.readLine()==null){
							throw new ReaderException(MessageConstant.EMPTY_FILE);
						}
						
						fileList.add(file.getAbsolutePath());
						
					} catch (FileNotFoundException e) {
						throw new ReaderException(MessageConstant.FILE_NOT_FOUND);
					} catch (IOException e) {
						throw new ReaderException(MessageConstant.IO_EXCEPTION);
					} finally {
						try {
							if(br!=null){
								br.close();
							}
						} catch (IOException e) {
							throw new ReaderException(MessageConstant.IO_EXCEPTION);
						}
					}
					
				}
			}
			
			if(fileList.size()==0){
				throw new ReaderException(MessageConstant.EMPTY_DIRECTORY);
			}
		}

		return fileList.size()==0 ? null : fileList;
	}

	private static String getFileExtension(String fileName) {
		
		String extension = null;
		int i = fileName.lastIndexOf('.');
		if (i > 0) {
		    extension = fileName.substring(i+1);
		}
		return extension;
	}
	
	public static void main(String[] args) throws ReaderException {
		System.out.println(getSchemaFileListFromSchemasFolder(ConstantsUtil.SCHEMA_FOLDER_ABSOLUTE_PATH));
	}

}
