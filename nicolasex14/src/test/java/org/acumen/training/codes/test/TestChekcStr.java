package org.acumen.training.codes.test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.acumen.training.codes.iteme.ChekcStr;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(OrderAnnotation.class)
public class TestChekcStr {

	    private ChekcStr check;

	    @BeforeEach
	    public void setup() {
	    	check = new ChekcStr();
	    }

	    @AfterEach
	    public void teardown() {
	        check = null;
	    }

	    @Order(1)
	    @Test
	    public void testBinarise() {
	    	String strInput = "0";
	    	String expectedVal = "000011";
	        int strValue = check.total(strInput);
	        String result = check.binarise(strValue);

	        assertAll(
	            () -> assertEquals(expectedVal, result),
	            () -> assertNotEquals("", result),
	            () -> assertFalse(result.contains("2"))
	        );
	    }

	    @Order(2)
	    @Test
	    public void testConvertAndTotal() {
	    	String strInput = "";
	    	int expectedTotal = 0;
	    	String expectedBinary = ""; 
	        String binaryString = check.convert(strInput);
	        int strValue = check.total(strInput);

	        assertAll(
	            () -> assertEquals(expectedTotal, strValue),
	            () -> assertEquals(expectedBinary, binaryString),
	            () -> assertNotEquals(-1, strValue),
	            () -> assertFalse(binaryString.contains("2"))
	        );
	    }

	    @Order(3)
	    @Test
	    public void testTotalWithNull() {
	        assertThrows(NullPointerException.class, () -> check.total(null));
	    }

	    @Order(4)
	    @Test
	    public void testTotalWithWhitespace() {
	        String strInput = " ";
	        int totalValue = check.total(strInput);
	        assertEquals(32, totalValue);
	        assertFalse(totalValue == 0);
	    }

	    @Order(5)
	    @Test
	    public void testBinariseInvalidValue() {
	        int invalidVal = -1;
	        String result = check.binarise(invalidVal);
	        assertEquals("", result);
	        assertFalse(result.contains("1"));
	    
	}

}
