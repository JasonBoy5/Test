package com.jason.exception;

/**
 * 重复预约异常
 */
public class RepeatAppointException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8165173291950571095L;

	public RepeatAppointException(String message) {
		super(message);
		System.out.println("repeat appoint aa");
	}

	public RepeatAppointException(String message, Throwable cause) {
		super(message, cause);
		System.out.println("repeat appoint cause");
	}
	
}
