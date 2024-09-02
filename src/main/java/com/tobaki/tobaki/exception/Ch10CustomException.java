package com.tobaki.tobaki.exception;

@SuppressWarnings("serial")
public class Ch10CustomException extends RuntimeException {
	
	public Ch10CustomException() {
		
	}
	public Ch10CustomException(String message) {
		super(message);
	}
}
