package org.acumen.training.codes.itemd;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TrapArray {
	private int[] array;
	private final Scanner scan;
	private static final Logger LOGGER = LogManager.getLogger("LOGGERTRAP");

	public TrapArray() {
		this.scan = new Scanner(System.in);
	}

	public void arrayTransact() {
		LOGGER.info("TrapArray starts.");
		int size = 0;

		// Loop until a positive integer is entered
		while (size <= 0) {
			try {
				System.out.print("Enter the Array Size: ");
				String sizeInput = scan.nextLine();
				if (sizeInput.equalsIgnoreCase("E")) {
					System.out.println("Good Bye");
					return;
				}
				size = validateArraySize(sizeInput);
				array = new int[size];
				LOGGER.info("Array of {} integers created.", size); 
			} catch (NegativeArraySizeException | LetterSizeException | InvalidSizeException e) {
				LOGGER.error(e.getMessage());
			} catch (Exception e) {
				LOGGER.error("An unexpected error occurred: {}", e.getMessage());
			}
		}
		// Loop for each array element, check if input is valid integer
		for (int i = 0; i < size; i++) {
			boolean validInput = false;
			while (!validInput) {
				try {
					fillArray(i);
					validInput = true;
				} catch (ElementCharException | ElementDecimalException e) {
					LOGGER.error(e.getMessage());
				} catch (Exception e) {
					LOGGER.error("An unexpected error occurred: {}", e.getMessage());
				}
			}
		}
		// Ask index to view value, keep asking for valid index
		while (true) {
			try {
				System.out.print("Enter the Index that you want to view: ");
				String indexInput = scan.nextLine();

				if (indexInput.equalsIgnoreCase("E")) {
					System.out.println("Good Bye");
					break;
				}
				int index = validateIndex(indexInput, size);
				System.out.println(String.format("The Value in index %d is %d", index, array[index]));
			} catch (BadIndexException e) {
				LOGGER.error(e.getMessage());
			} catch (Exception e) {
				LOGGER.error("An unexpected error occurred: {}", e.getMessage()); 
			}
		}
	}
	
	private int validateArraySize(String sizeInput) throws LetterSizeException, InvalidSizeException, Exception {
		try {
			int size = Integer.parseInt(sizeInput);
			if (size <= 0) {
				throw new InvalidSizeException();
			}
			return size;
		} catch (NumberFormatException e) {
			throw new LetterSizeException();
		}
	}

	private void fillArray(int index) throws ElementCharException, ElementDecimalException, Exception {
		System.out.print("Enter the value: ");
		String elementInput = scan.nextLine();

		if (elementInput.equalsIgnoreCase("E")) {
			System.out.println("Good Bye");
			return; // Exit on "E"
		}

		try {
			int value = Integer.parseInt(elementInput);
			array[index] = value;
		} catch (NumberFormatException e) {
			if (elementInput.matches("[a-zA-Z]$")) {
				throw new ElementCharException("Invalid element value: [character]");
			} else if (elementInput.matches("[a-zA-Z]+")) {
				throw new ElementCharException("Invalid element value: [String]");
			} else if (elementInput.matches("-?\\d*\\.\\d+")) {
				throw new ElementDecimalException();
			} else {
				throw new ElementCharException();
			}
		}
	}

	private int validateIndex(String indexInput, int arrayLength) throws BadIndexException, Exception {
		try {
			int index = Integer.parseInt(indexInput);
			if (index < 0 || index >= arrayLength) {
				throw new BadIndexException();
			}
			return index;
		} catch (NumberFormatException e) {
			throw new BadIndexException();
		}
	}

}
