package org.acumen.training.codes.itemf;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class VendingMachine {

	private static final Logger LOGGER = LogManager.getLogger(VendingMachine.class);
	private int totValue;
	private int currValue;
	private boolean enabled;
	private static final int COST = 75;

	public VendingMachine() {
		LOGGER.info("VendingMachine instance is created.");
		totValue = 0;
		currValue = 0;
		enabled = false;
	}

	public void insert(Coin coin) {
		LOGGER.info("Method insert started with coin: {}", coin);
		int value = coin.getValue();
		if (value == 0) {
			LOGGER.error("illegal value");
		} else {
			currValue += value;
			LOGGER.info("Current value = {}", currValue);
			if (currValue >= COST) {
				enabled = true;
				LOGGER.info(" (sufficient credit) ");
			} else
				LOGGER.info("");
		}
		LOGGER.info("Method insert ended.");
	}

	public void returnCoins() {
		LOGGER.info("Method returnCoins started.");
		if (currValue == 0) {
			LOGGER.error("no coins to return");
		} else {
			LOGGER.info("Take your coins");
			currValue = 0;
			enabled = false;
		}
		LOGGER.info("Method returnCoins ended.");
	}

	public void vend() throws Exception {
		LOGGER.info("Method vend started.");
		if (enabled) {
			LOGGER.info("Get your drink");
			totValue += COST;
			currValue -= COST;
			if (currValue == 0)
				enabled = false;
			LOGGER.info("Current value = {}", currValue);
		} else {
			LOGGER.warn("Not enough credit: add {}", (COST - currValue));
		}
		if (currValue < 0) {
			LOGGER.error("Error: negative credit!");
			throw new Exception("Error: negative credit!");
		}
		LOGGER.info("Method vend ended.");
	}
}
