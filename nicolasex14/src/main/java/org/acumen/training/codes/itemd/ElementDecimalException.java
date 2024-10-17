package org.acumen.training.codes.itemd;

public class ElementDecimalException extends Exception {
	private static final long serialVersionUID = 1L;
	private String message = "Invalid element value: [floating-point]";
	
	public ElementDecimalException() {}
	
	public ElementDecimalException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return this.message;
	}

	public void printStackTrace() {
		System.err.println(this.message);
	}
}
