package com.student.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class StudentModelTest {
	
	StudentModel student;
	@Before
	public void studentInitialize() {
		student = new StudentModel("Abc" , "Subho" , "Barrakpore" , 4567896545l);
	}
	
	@Test
	public void getInstituteNameMethodsTest() {
		String actualValue = student.getInstituteName();
		String expectedValue = "Abc";
		assertEquals(expectedValue , actualValue);
	}
	
	@Test
	public void getStudentNameMethodsTest() {
		String actualValue = student.getStudentName();
		String expectedValue = "Subho";
		assertEquals(expectedValue , actualValue);
	}
	
	@Test
	public void getStudentCityMethodsTest() {
		String actualValue = student.getCity();
		String expectedValue = "Barrakpore";
		assertEquals(expectedValue , actualValue);
	}
	
	@Test
	public void getStudentNumberMethodsTest() {
		long actualValue = student.getStudentNumber();
		long expectedValue = 4567896545l;
		assertEquals(expectedValue , actualValue);
	}
	
	@Test
	public void setInstituteNameMethodsTest() {
		String instituteName ="xyz";
		student.setInstituteName(instituteName);
		String actualValue = student.getInstituteName();
		String expectedValue = instituteName;
		assertEquals(expectedValue , actualValue);
	}
	
	@Test
	public void setStudentNameMethodsTest() {
		String studentName = "Avi";
		student.setStudentName(studentName);
		String actualValue = student.getStudentName();
		String expectedValue = studentName;
		assertEquals(expectedValue , actualValue);
	}
	
	@Test
	public void setStudentCityMethodsTest() {
		String studentCity = "Palta";
		student.setCity(studentCity);
		String actualValue = student.getCity();
		String expectedValue = studentCity;
		assertEquals(expectedValue , actualValue);
	}
	
	@Test
	public void setStudentNumberMethodsTest() {
		long studentNumber = 76543212345l;
		student.setStudentNumber(studentNumber);
		long actualValue = student.getStudentNumber();
		long expectedValue = studentNumber;
		assertEquals(expectedValue , actualValue);
	}
}
