package com.student.dao;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.student.model.*;

public class InstituteDaoTest {
	
	InstituteModel institute;
	StudentModel student;
	@Before
	public void instituteInitialize() {
		institute = new InstituteModel("Abc" , "kolkata");
		InstituteDao.addInstitute(institute);
		student = new StudentModel("Abc" , "Akash" , "Kolkata" , 8765432345l);
	}
	
	@Test
	public void addInstituteWhenInstituteObjectNull() {
		institute = null;
		boolean actualValue = InstituteDao.addInstitute(institute);
		boolean expectedValue = false;
		assertEquals(expectedValue , actualValue);
	}
	
	@Test
	public void addInstituteWhenInstitueObjectNotNull() {
		
		boolean actualValue = InstituteDao.addInstitute(institute);
		boolean expectedValue = true;
		assertEquals(expectedValue , actualValue);
	}
	
	@Test
	public void loginInstituteWhenInstituteNameAndPasswordMatch() {
		String password = "admin123";
		InstituteDao.addInstitute(institute);
		InstituteModel institute = InstituteDao.loginInstitute("Abc", password);
		boolean actualValue = institute instanceof InstituteModel;
		boolean expectedValue = true;
		assertEquals(expectedValue , actualValue);
	}
	
	@Test
	public void loginInstituteWhenInstituteNameOrPasswordNotMatch() {
		String name = "abc" , password = "admin123";
		InstituteModel institute = InstituteDao.loginInstitute(name , password);
		boolean actualValue = institute instanceof InstituteModel;
		boolean expectedValue = false;
		assertEquals(expectedValue , actualValue);
	}
	
	@Test
	public void addStudentTestWhenInstitutePresent() {
		String instituteName = "Abc";
		InstituteDao.addInstitute(institute);
		boolean actualValue = InstituteDao.addStudent(instituteName, student);
		boolean expectedValue = true;
		assertEquals(expectedValue , actualValue);
	}
	
	@Test
	public void addStudentWhenInstituteNotPresent() {
		String instituteName = "abc";
		boolean actualValue = InstituteDao.addStudent(instituteName, student);
		boolean expectedValue = false;
		assertEquals(expectedValue , actualValue);
	}
	
	@Test
	public void addStudentWhenStudentObjectIsNull() {
		String instituteName = "Abc";
		InstituteDao.addInstitute(institute);
		student = null;
		boolean actualValue = InstituteDao.addStudent(instituteName, student);
		boolean expectedValue = false;
		assertEquals(expectedValue , actualValue);
	}
	
	@Test
	public void removeStudentWhenInstituteAndStudentMatch() {
		int studentId = student.getStudentId();
		InstituteDao.addStudent("Abc", student);
		String instituteName = "Abc";
		boolean actualValue = InstituteDao.removeStudent(instituteName, studentId);
		boolean expectedValue = true;
		assertEquals(expectedValue , actualValue);
	}
	
	@Test
	public void removeStudentWhenInstituteNotPresent(){
		int studentId = student.getStudentId();
		InstituteDao.addStudent("Abc", student);
		String instituteName = "abc";
		boolean actualValue = InstituteDao.removeStudent(instituteName, studentId);
		boolean expectedValue = false;
		assertEquals(expectedValue , actualValue);
	}
	
	@Test
	public void removeStudentWhenStudentIdNotPresent(){
		int studentId = 005;
		InstituteDao.addStudent("Abc", student);
		String instituteName = "Abc";
		boolean actualValue = InstituteDao.removeStudent(instituteName, studentId);
		boolean expectedValue = false;
		assertEquals(expectedValue , actualValue);
	}
	
	@Test
	public void getStudentWhenInstituteAndStudentMatch() {
		int studentId = student.getStudentId();
		InstituteDao.addStudent("Abc", student);
		String instituteName = "Abc";
		StudentModel studnt = InstituteDao.getStudent(instituteName, studentId);
		boolean actualValue = studnt instanceof StudentModel;
		boolean expectedValue = true;
		assertEquals(expectedValue , actualValue);
	}
	
	@Test
	public void getStudentWhenInstituteNotPresent(){
		int studentId = student.getStudentId();
		InstituteDao.addStudent("Abc", student);
		String instituteName = "abc";
		StudentModel studnt = InstituteDao.getStudent(instituteName, studentId);
		boolean actualValue = studnt instanceof StudentModel;
		boolean expectedValue = false;
		assertEquals(expectedValue , actualValue);
	}
	
	@Test
	public void getStudentWhenStudentIdNotPresent(){
		int studentId = 1005;
		InstituteDao.addStudent("Abc", student);
		String instituteName = "Abc";
		StudentModel studnt = InstituteDao.getStudent(instituteName, studentId);
		boolean actualValue = studnt instanceof StudentModel;
		boolean expectedValue = false;
		assertEquals(expectedValue , actualValue);
	}
	
}
