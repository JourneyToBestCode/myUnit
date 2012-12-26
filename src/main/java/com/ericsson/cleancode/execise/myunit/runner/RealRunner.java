package com.ericsson.cleancode.execise.myunit.runner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ericsson.cleancode.execise.myunit.testsuit.TestCase;
import com.ericsson.cleancode.execise.myunit.testsuit.TestSuit;

public class RealRunner extends Runner {
	private static final Logger logger = LoggerFactory.getLogger(RealRunner.class);

	@Override
	public void run(TestSuit testsuit) {
		for(TestCase testCase : testsuit.getCases()){
			logBefore(testCase);
			logCase(testCase);
			testCase.run();
			logAfter(testCase);
		}
	}
	
	public void logBefore(TestCase testCase){
		logger.info(testCase.getName()+"Before");
	}
	
	public void logAfter(TestCase testCase){
		logger.info(testCase.getName()+"After");
	}
	
	public void logCase(TestCase testCase){
		logger.info(testCase.getName());
	}

}
