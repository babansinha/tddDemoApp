package com.psl.tdd.exception;

public class ReaderException extends Exception{

	/**
	 * @author : ankit_jha,
	 * Reader custom exception class to handle file reading exceptions from source folder.
	 */
	private static final long serialVersionUID = -5670884360046183246L;
	
	public ReaderException(String message) {
		super(message);
	}

}
