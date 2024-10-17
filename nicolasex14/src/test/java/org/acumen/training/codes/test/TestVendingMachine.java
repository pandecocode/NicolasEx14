package org.acumen.training.codes.test;

import org.acumen.training.codes.itemf.Coin;
import org.acumen.training.codes.itemf.VendingMachine;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestVendingMachine {
	private static final Logger LOGGER = LogManager.getLogger(TestVendingMachine.class);
	VendingMachine vm;
	
	@BeforeEach
	public void setUp() {
		vm = new VendingMachine();
	}
	
	@AfterEach
	public void teardown() {
		vm = null;
	}
	
	@Test
	public void testVendingMachine() {
		LOGGER.info("TestVendingMachine started...");
		
		Coin penny = new Coin("Penny");
		Coin nickle = new Coin("Nickle");
		Coin invalid = new Coin("RandomInvalidCoin");

		vm.insert(penny);
		vm.insert(nickle);
		vm.insert(invalid);

		try {
			vm.vend();
		} catch (Exception e) {
			LOGGER.error("Caught exception in vend: {}", e);
		}

		vm.returnCoins();
		LOGGER.info("TestVendingMachine ended...");
	}

}
