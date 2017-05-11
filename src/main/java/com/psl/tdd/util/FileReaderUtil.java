package com.psl.tdd.util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileReaderUtil {
	
	public static List<String> getSchemaFileListFromSchemasFolder(String directoryPath) {

		List<String> fileList = new ArrayList<String>();

		File folder = new File(directoryPath);
		if ( !folder.exists() ) {
			System.out.println("Error : Folder doesn't exist!!");
		} else {
			for ( File file : folder.listFiles() ) {
				if ( file.isFile() && "csv".equals( getFileExtension( file.getName() ))) {
					fileList.add(file.getAbsolutePath());
				}
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
	
	public static void main(String[] args) {
		System.out.println(getSchemaFileListFromSchemasFolder(ConstantsUtil.SCHEMA_FOLDER_ABSOLUTE_PATH));
	}

}
