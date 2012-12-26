package com.ericsson.cleancode.execise.myunit.annotations;

import static org.junit.Assert.assertEquals;

import java.lang.reflect.Method;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class testTestAnnotations {
	final static Logger logger = LoggerFactory.getLogger(testTestAnnotations.class);

	@Testcase
	@Test
	public void testAnnotationTypeCase() {
		try {
			Method method = this.getClass().getMethod("testAnnotationTypeCase");
			assertEquals("Annotation are useless",true,method.isAnnotationPresent(Testcase.class)); 			
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Testbefore
	@Test
	public void testAnnotationTypeBefore() {
		try {
			Method method = this.getClass().getMethod("testAnnotationTypeBefore");
			assertEquals("Annotation are useless",true,method.isAnnotationPresent(Testbefore.class)); 			
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Testafter
	@Test
	public void testAnnotationTypeAfter() {
		try {
			Method method = this.getClass().getMethod("testAnnotationTypeAfter");
			assertEquals("Annotation are useless",true,method.isAnnotationPresent(Testafter.class)); 			
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
