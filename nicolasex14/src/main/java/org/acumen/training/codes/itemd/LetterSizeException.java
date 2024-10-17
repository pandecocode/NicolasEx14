package org.acumen.training.codes.itemd;

public class LetterSizeException extends Exception {
	private static final long serialVersionUID = 1L;
	private String message = "Invalid size";
	
	public LetterSizeException() {}
	
	public LetterSizeException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return this.message;
	}

	public void printStackTrace() {
		System.err.println(this.message);
	}
}
