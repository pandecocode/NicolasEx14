package org.acumen.training.codes.iteme;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ChekcStr {

	private static final Logger logger = LogManager.getLogger("CHECKSTR");

	public ChekcStr() {
		logger.info("ChekcStr – Instantiated");
	}

	public String convert(String str) {
		logger.info("Start of convert() execution");
		String result = binarise(total(str));
		logger.info("Return value of convert() before return: {}", result);
		logger.info("End of convert() execution");
		return result;
	}

	public int total(String str) {
		logger.info("Start of total() execution with input: {}", str);
		if (str == null) {
			logger.error("ChekcStr – Invalid Value: str is null");
			throw new NullPointerException("Input string is null");
		}
		if (str.equals("")) {
			logger.info("Return value of total() before return: 0");
			logger.info("End of total() execution");
			return 0;
		}
		int result = ((int) str.charAt(0)) + total(str.substring(1));
		logger.info("Return value of total() before return: {}", result);
		logger.info("End of total() execution");
		return result;
	}

	public String binarise(int givenstrvalue) {
		logger.info("Start of binarise() execution with input: {}", givenstrvalue);
		if (givenstrvalue < 0) {
			logger.error("ChekcStr – Invalid Value: givenstrvalue is less than 0");
			logger.info("Return value of binarise() before return: ''");
			logger.info("End of binarise() execution");
			return "";
		}
		if (givenstrvalue == 0) {
			logger.info("Return value of binarise() before return: ''");
			logger.info("End of binarise() execution");
			return "";
		}
		String result;
		if (givenstrvalue % 2 == 1) {
			result = "1" + binarise(givenstrvalue / 2);
		} else {
			result = "0" + binarise(givenstrvalue / 2);
		}
		logger.info("Return value of binarise() before return: {}", result);
		logger.info("End of binarise() execution");
		return result;

	}

}
