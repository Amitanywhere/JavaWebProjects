package com.student.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class InstituteModelTest {
	InstituteModel institute;
	StudentModel student;
	@Before
	public void initialize() {
		institute = new InstituteModel("Abc" , "Kolkata");
		student = new StudentModel("Abc" , "Amlan" , "kolkata" , 3456345632l);
		institute.addStudent(student);
	}
	
	@Test
	public void setInstituteNameTest() {
		String instituteName = "xyz";
		institute.setInstituteName(instituteName);
		String actualValue = institute.getInstituteName();
		String expectedValue = instituteName;
		assertEquals(expectedValue , actualValue);
	}
	
	@Test
	public void setInstituteCityTest() {
		String instituteCity = "Kalyani";
		institute.setInstituteCity(instituteCity);
		String actualValue = institute.getInstituteCity();
		String expectedValue = instituteCity;
		assertEquals(expectedValue , actualValue);
	}
	
	@Test
	public void getStudentbyIdTest() {
		int studentId = student.getStudentId();
		StudentModel student = institute.getStudentById(studentId);
		String actualValue = student.getStudentName();
		String expectedValue = "Amlan";
		assertEquals(expectedValue , actualValue);
	}
	
	@Test
	public void updateStudentByIdTest() {
		int studentId = student.getStudentId();
		String sName = "Amlan" , sCity = "Kolkata";
		long sNumber = 8797865432l;
		institute.updateStudentById(studentId, sName, sCity, sNumber);
		StudentModel stdnt = institute.getStudentById(studentId);
		long expectedValue = sNumber;
		long actualValue = stdnt.getStudentNumber();
		assertEquals(expectedValue , actualValue);
	}
	
	@Test
	public void deleteStudentTest() {
		int studentId = student.getStudentId();
		institute.removeStudentById(studentId);
		StudentModel actualValue = institute.getStudentById(studentId);
		StudentModel expectedValue = null;
		assertEquals(expectedValue , actualValue);
	}
}
