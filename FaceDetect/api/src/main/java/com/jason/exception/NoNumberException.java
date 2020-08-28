package com.jason.exception;

/**
 * 库存不足异常
 */
public class NoNumberException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4943278425872296557L;

	public NoNumberException(String message) {
		super(message);
	}

	public NoNumberException(String message, Throwable cause) {
		super(message, cause);
	}
}
