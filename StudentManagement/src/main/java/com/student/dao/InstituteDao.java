package com.student.dao;

import java.io.Serializable;
import java.util.*;

import com.student.model.*;

public class InstituteDao implements Serializable{
	
	private static List<InstituteModel> instituteList = new ArrayList<>();
	
	public static boolean addInstitute(InstituteModel institute) {
		boolean isAdded = false;
		try {
			if(institute != null) {
			instituteList.add(institute);
			isAdded = true;
			}
		}
		catch(Exception e) {
			e.getStackTrace();
		}
		return isAdded;
	}
	public static InstituteModel loginInstitute(String instituteName , String password) {
		if(!password.equals("admin123")) {
			return null;
		}
		InstituteModel isLoginSuccess = null;
		try {
			for(InstituteModel institute : instituteList) {
				if(institute.getInstituteName().equals(instituteName)) {
					isLoginSuccess = institute;
					break;
				}
			}
		}
		catch(Exception e) {
			e.getStackTrace();
		}
		return isLoginSuccess;
	}
	@SuppressWarnings("finally")
	public static boolean addStudent(String instituteName , StudentModel student) {
		if(instituteName.equals("") || instituteName == null || student == null) {
			return false;
		}
		boolean isStudentAdded = false;
		try {
			for(InstituteModel institute : instituteList) {
				if(institute.getInstituteName().equals(instituteName)) {
					isStudentAdded = institute.addStudent(student);
					break;
				}
			}
		}
		catch(Exception e) {
			e.getStackTrace();
		}
		finally {
			return isStudentAdded;
		}
	}
	
	@SuppressWarnings("finally")
	public static boolean removeStudent(String instituteName , int studentId) {
		boolean isDeleted = false;
		try {
			for(InstituteModel institute : instituteList) {
				if(institute.getInstituteName().equals(instituteName)) {
					isDeleted = institute.removeStudentById(studentId);
					break;
				}
			}
		}
		catch(Exception e) {
			e.getStackTrace();
		}
		finally {
			return isDeleted;
		}
	}
	
	public static StudentModel getStudent(String instituteName , int studentId) {
		StudentModel student = null;
		try {
			for(InstituteModel institute : instituteList) {
				if(institute.getInstituteName().equals(instituteName)) {
					student = institute.getStudentById(studentId);
					break;
				}
			}
		}
		catch(Exception e) {
			e.getMessage();
		}
		return student;
	}
	
	public static boolean updateStudent(String instituteName , int studentId , String name , String city , long number) {
		boolean isUpdated = false;
		try {
			for(InstituteModel institute : instituteList) {
				if(institute.getInstituteName().equals(instituteName)) {
					isUpdated = institute.updateStudentById(studentId, name, city, number);
					break;
				}
			}
		}
		catch(Exception e) {
			e.getStackTrace();
		}
		return isUpdated;
	}
	
}
