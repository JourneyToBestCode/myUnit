package com.ericsson.cleancode.execise.myunit.testsuit;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import com.ericsson.cleancode.execise.myunit.annotations.Testafter;
import com.ericsson.cleancode.execise.myunit.annotations.Testbefore;
import com.ericsson.cleancode.execise.myunit.annotations.Testcase;;

public class TestCase { 
	private static final Logger logger = LoggerFactory.getLogger(TestCase.class);
	/**
	 * Test method name, it is used for creating test case. 
	 */
	private String name;
	/**
	 * Test class object, test case are created from the case.
	 */
	private Class<?> forclass;
	

	
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Class<?> getForclass() {
		return forclass;
	}
	public void setForclass(Class<?> forclass) {
		this.forclass = forclass;
	}
	
	public TestCase(String name,Class<?> forclass){
		this.name = name;
		this.forclass = forclass;
	}
	
	/**
	 * run this test case and return result
	 * @return
	 */
	public boolean run(){ 
		Object ins;
		boolean result = true;
		try {
			ins = forclass.newInstance();
			invokeBefore(ins);
			invokeCase(ins);
			invokeAfter(ins);
		} catch (InstantiationException e) {
			logger.info(e.toString());
			result = false;
		} catch (IllegalAccessException e) {
			logger.info(e.toString());
			result = false;
		} catch (IllegalArgumentException e) {
			logger.info(e.toString());
			result = false;
		} catch (InvocationTargetException e) {
			logger.info(e.toString());
			result = false;
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
		} catch (Exception e){
			result = false;
		}
		
		return result;
	}
	private void invokeAfter(Object ins) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {
		for(Method method:forclass.getDeclaredMethods()){
			if(method.getAnnotation(Testafter.class) != null){
				method.invoke(ins);
			}
		}
		
	}
	private void invokeCase(Object ins) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException, SecurityException, NoSuchMethodException {
		Method method = forclass.getDeclaredMethod(name, (Class[]) null);
		method.invoke(ins);

	}
	private void invokeBefore(Object ins) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {
		
		for(Method method:forclass.getDeclaredMethods()){
			if(method.getAnnotation(Testbefore.class) != null){
				method.invoke(ins);
			}
		}
	}
}
