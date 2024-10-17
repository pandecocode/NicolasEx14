package org.acumen.training.codes.itemd;

public class ElementCharException extends Exception {
	private static final long serialVersionUID = 1L;
	private String message = "Invalid element value";
	
	public ElementCharException() {}
	
	public ElementCharException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return this.message;
	}

	public void printStackTrace() {
		System.err.println(this.message);
	}
}
