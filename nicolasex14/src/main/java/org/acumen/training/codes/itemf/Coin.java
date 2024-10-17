package org.acumen.training.codes.itemf;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Coin {

	private static final Logger logger = LogManager.getLogger("HTMLLOGGER");
	public static final int PENNY = 1;
	public static final int NICKEL = 5;
	public static final int DIME = 10;
	public static final int QUARTER = 25;
	public static final int HALFDOLLAR = 50;
	public static final int SILVERDOLLAR = 100;
	public static final int INVALID = 0;
	private int value;

	public Coin(String coin) {
		String toUpperCoin = coin.toUpperCase();
		logger.info("Creating a coin instance for: {}", toUpperCoin);
		if (toUpperCoin.equals("PENNY"))
			value = PENNY;
		else if (toUpperCoin.equals("NICKEL"))
			value = NICKEL;
		else if (toUpperCoin.equals("DIME"))
			value = DIME;
		else if (toUpperCoin.equals("QUARTER"))
			value = QUARTER;
		else if (toUpperCoin.equals("HALFDOLLAR"))
			value = HALFDOLLAR;
		else if (toUpperCoin.equals("SILVERDOLLAR"))
			value = SILVERDOLLAR;
		else
			value = INVALID;
		logger.info("Coin created with value: {}", value);
	}

	public int getValue() {
		return value;
	}

	public String toString() {
		return new String(Integer.toString(value));
	}

}
