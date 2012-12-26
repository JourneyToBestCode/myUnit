package com.ericsson.cleancode.execise.myunit.testCases;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ericsson.cleancode.execise.myunit.annotations.Testafter;
import com.ericsson.cleancode.execise.myunit.annotations.Testbefore;
import com.ericsson.cleancode.execise.myunit.annotations.Testcase;
import com.ericsson.cleancode.execise.myunit.runner.RealRunner;

public class NormalTestCases {
	private static final Logger logger = LoggerFactory.getLogger(RealRunner.class);
	
	@Testbefore
	public void testBefore(){
		logger.debug("Before executed");
	}
	
	@Testafter
	public void testAfter(){
		logger.debug("After executed");
	}
	
	@Testcase
	public void testCase1(){
		logger.debug("Case1 executed");
	}
	
	@Testcase
	public void testCaseFail() throws Exception{
		throw new Exception("test failed");
	}

}
