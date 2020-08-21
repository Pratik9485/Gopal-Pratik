package com.inn.foresight;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.inn.foresight.test.SpringJUnitRunner;

/**
 * Class to test code base.
 */
public class TestApp extends SpringJUnitRunner {

	private Logger logger = LoggerFactory.getLogger(TestApp.class);
	
	
	
	@Test
	public void testMyMethod()
	{
	  System.out.println("context up");
		logger.info("Test case");
	}

}