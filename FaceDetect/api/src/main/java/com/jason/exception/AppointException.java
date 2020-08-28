package com.jason.exception;

/**
 * 预约业务异常
 */
public class AppointException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8845894709897855001L;

	public AppointException(String message) {
		super(message);
	}

	public AppointException(String message, Throwable cause) {
		super(message, cause);
	}
}
