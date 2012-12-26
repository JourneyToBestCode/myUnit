package com.ericsson.cleancode.execise.myunit.testsuit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ericsson.cleancode.execise.myunit.testCases.NormalTestCases;

public class TestCaseTest {
	
	private TestCase testCase = null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testRunTrue() {
		testCase = new TestCase("testCase1",NormalTestCases.class);
		assertEquals("Run failed",true,testCase.run());
	}
	
	@Test
	public void testRunFalse() {
		testCase = new TestCase("testCaseFail",NormalTestCases.class);
		assertEquals("Run failed",false,testCase.run());
	}

}
