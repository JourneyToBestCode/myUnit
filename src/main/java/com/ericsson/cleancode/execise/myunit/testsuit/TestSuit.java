package com.ericsson.cleancode.execise.myunit.testsuit;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import com.ericsson.cleancode.execise.myunit.annotations.Testcase;

public class TestSuit {
	List<TestCase> testCases;
	
	public TestSuit(){
		testCases = new ArrayList<TestCase>();
	}
	
	public TestSuit(Class<?> testclass){
		this();
		for(Method method:testclass.getDeclaredMethods()){
			if(method.getAnnotation(Testcase.class) != null){
				testCases.add(new TestCase(method.getName(),testclass));
			}
		}
	}
	
	public void addCase(TestCase testcase){
		testCases.add(testcase);
	}
	
	public List<TestCase> getCases(){
		return testCases;
	}
	
}
