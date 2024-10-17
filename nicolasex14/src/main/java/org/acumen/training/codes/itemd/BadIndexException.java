package org.acumen.training.codes.itemd;

public class BadIndexException extends Exception {
	private static final long serialVersionUID = 1L;
	private String message = "Bad Index";
	
	public BadIndexException() {}
	
	public BadIndexException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return this.message;
	}

	public void printStackTrace() {
		System.err.println(this.message);
	}
}
