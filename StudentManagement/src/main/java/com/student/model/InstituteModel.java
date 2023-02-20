package com.student.model;

import java.io.Serializable;
import java.util.*;

public class InstituteModel implements Serializable{
	
	private String instituteName;
	private String instituteCity;
	private List<StudentModel> studentList = new ArrayList<>();
	
	public InstituteModel(String instituteName, String instituteCity) {
		super();
		this.instituteName = instituteName;
		this.instituteCity = instituteCity;
	}
	
	public boolean addStudent(StudentModel student) {
		boolean isAdded = false;
		try {
			this.studentList.add(student);
			isAdded = true;
		}
		catch(Exception e) {
			e.getStackTrace();
		}
		return isAdded;
	}

	public String getInstituteName() {
		return instituteName;
	}

	public void setInstituteName(String instituteName) {
		this.instituteName = instituteName;
	}

	public String getInstituteCity() {
		return instituteCity;
	}

	public void setInstituteCity(String instituteCity) {
		this.instituteCity = instituteCity;
	}

	public boolean removeStudentById(int id) {
		boolean isRemoved = false;
		try {
			for(StudentModel student : studentList) {
				if(student.getStudentId() == id) {
					this.studentList.remove(student);
					isRemoved = true;
					break;
				}
			}
		}
		catch(Exception e) {
			e.getStackTrace();
		}
		return isRemoved;
	}
	
	public StudentModel getStudentById(int id) {
		StudentModel student = null;
		try {
			for(StudentModel stdnt : studentList) {
				if(stdnt.getStudentId() == id) {
					student = stdnt;
					break;
				}
			}
		}
		catch(Exception e) {
			e.getMessage();
		}
		return student;
	}
	
	public boolean updateStudentById(int id , String name , String city , long number) {
		boolean isUpdated = false;
		try {
			for(StudentModel student : studentList) {
				if(student.getStudentId() == id) {
					student.setCity(city);
					student.setStudentName(name);
					student.setStudentNumber(number);
					isUpdated = true;
					break;
				}
			}
		}
		catch(Exception e) {
			e.getStackTrace();
		}
		return isUpdated;
	}
	
	public List<StudentModel> getStudentList(){
		return studentList;
	}
	
	
}
