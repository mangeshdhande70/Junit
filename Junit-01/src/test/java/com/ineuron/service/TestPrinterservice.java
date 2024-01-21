package com.ineuron.service;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.fail;

import org.junit.jupiter.api.Test;

public class TestPrinterservice {

	@Test
	public void testSingleTon() {

		System.out.println("TestPrinterservice.testSingleTon()");
		PrinterService p1 = PrinterService.getInstance();
		PrinterService p2 = PrinterService.getInstance();

//		assertNotNull(p1);
//		assertNotNull(p2);

		/** 
		 *  If we want to customize the msg if the values are null then use fail() and
         *  below lines of fail will not be executed if the fail() executed.
         */
		
		if (p1 == null || p2 == null) {
			fail("p1,p2 should not be null");
		}

		assertSame(p1, p2);

	}

}
