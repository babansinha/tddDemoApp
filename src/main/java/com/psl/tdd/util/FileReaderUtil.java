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

/**
 * This class will deal Files related util functionalities
 *
 */
public class FileReaderUtil {
	
	/**
	 * 
	 * This method is responsible to fetch and return all files of a given directory path
	 * 
	 * @param directoryPath
	 * @return List of file path
	 * @throws ReaderException
	 */
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
					try {
						if( isValidFile(file) ) {
							fileList.add(file.getAbsolutePath());
						}
					} catch (ReaderException re) {
						System.out.println("Reader Exception"+re.getMessage());
					}
				}
			}
			
			if(fileList.size()==0){
				throw new ReaderException(MessageConstant.EMPTY_DIRECTORY);
			}
		}

		return fileList;
	}
	
	/**
	 * This function is responsible to test whether given file is valid or not
	 * 
	 * @param file
	 * @return boolean
	 * @throws ReaderException
	 */
	public static boolean isValidFile(final File file) throws ReaderException {
		
		BufferedReader br = null;
		
		try {
			br = new BufferedReader(new FileReader(file));
			if (br.readLine()==null){
				throw new ReaderException(MessageConstant.EMPTY_FILE);
			}
			
		} catch (FileNotFoundException e) {
			throw new ReaderException(MessageConstant.FILE_NOT_FOUND);
		} catch (IOException e) {
			throw new ReaderException(MessageConstant.IO_EXCEPTION);
		} finally {
			try {
				if(br!=null) {
					br.close();
				}
			} catch (IOException e) {
				throw new ReaderException(MessageConstant.IO_EXCEPTION);
			}
		}
		
		return true;
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
