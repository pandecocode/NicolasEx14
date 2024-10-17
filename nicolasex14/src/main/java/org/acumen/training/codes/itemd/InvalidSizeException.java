package org.acumen.training.codes.itemd;

public class InvalidSizeException extends Exception {
	private static final long serialVersionUID = 1L;
	private String message = "Array size cannot be negative";
	
	public InvalidSizeException() {}
	
	public InvalidSizeException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return this.message;
	}

	public void printStackTrace() {
		System.err.println(this.message);
	}
}
