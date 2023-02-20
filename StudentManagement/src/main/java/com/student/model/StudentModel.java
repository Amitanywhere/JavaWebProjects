package com.student.model;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicInteger;

public class StudentModel implements Serializable {
	
	private static final AtomicInteger count = new AtomicInteger(1000);
	private String instituteName;
	private String studentName;
	private int studentId;
	private String city;
	private long studentNumber;
	
	public StudentModel(String instName , String name , String city , long number){
		this.studentId = count.incrementAndGet();
		this.instituteName = instName;
		this.studentName = name;
		this.city = city;
		this.studentNumber = number;
	}
	
	public String getInstituteName() {
		return instituteName;
	}

	public void setInstituteName(String instituteName) {
		this.instituteName = instituteName;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public int getStudentId() {
		return studentId;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public long getStudentNumber() {
		return studentNumber;
	}

	public void setStudentNumber(long studentNumber) {
		this.studentNumber = studentNumber;
	}

	public static AtomicInteger getCount() {
		return count;
	}

}
