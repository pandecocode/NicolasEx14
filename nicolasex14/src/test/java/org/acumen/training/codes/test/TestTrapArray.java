package org.acumen.training.codes.test;

import org.acumen.training.codes.itemd.TrapArray;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestTrapArray {
	TrapArray trap;
    
	@BeforeEach
	public void setUp() {
		trap = new TrapArray();
	}
	
	@AfterEach
	public void teardown() {
		trap = null;
	}
	
    @Test
    public void testArrayTransact() {
        trap.arrayTransact();
    }

}
