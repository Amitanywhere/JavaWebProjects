package com.student.web;

import javax.servlet.http.*;

import com.student.model.InstituteModel;
import com.student.model.StudentModel;


import javax.servlet.*;
import java.io.*;
import java.util.List;

public class StudentListServlet extends HttpServlet{
	
	public void doGet(HttpServletRequest req , HttpServletResponse res) throws IOException {
		res.setContentType("text/html");
		PrintWriter output = res.getWriter();
		try {
			HttpSession session = req.getSession(false);
			if(session == null) {

				res.sendRedirect("instituteLogin");
			}
			else {
				InstituteModel institute = (InstituteModel) session.getAttribute("institute");

				List<StudentModel> studentList = institute.getStudentList();
				output.println("<html>");
				output.println("<style>");
				output.println("table , th , td{border : 1px solid black;}");
				output.println("h1{text-align : center;  color : red;}");
				output.println("</style>"); 
				output.println("<body>");
				output.println("<a href='index.html'>Home</a>");
				output.println("<a href='logoutInstitute'>Logout</a>");
				output.println("<h1>" + institute.getInstituteName() + "</h1>");
				output.println("<h2>Student List</h2>");
				output.println("<table style = \"width : 100% \">");
				output.println("<tr>");
				output.println("<th>Id</th>");
				output.println("<th>Name</th>");
				output.println("<th>City</th>");
				output.println("<th>Number</th>");
				output.println("<th>Edit</th>");
				output.println("<th>Delete</th>");
				output.println("</tr>");
				
				if(studentList.isEmpty()) {
					output.println("<h2>No Student Present</h2>");
				}
				else {
					for(StudentModel student : studentList) {
						output.println("<tr>");
						output.println("<td>" + student.getStudentId() + "</td>");
						output.println("<td>" + student.getStudentName() + "</td>");
						output.println("<td>" + student.getCity() + "</td>");
						output.println("<td>" + student.getStudentNumber() + "</td>");
						output.println("<td>");
						output.println("<a href='updateStudent?id=" + student.getStudentId() + "&instname=" +  institute.getInstituteName() + " '>Edit</a>");
						output.println("</td>");
						output.println("<td>");
						output.println("<a href='deleteStudent?id=" + student.getStudentId() +  " '>Delete</a>");
						output.println("</td>");
						output.println("</tr>");
					}
				}
				output.println("</table>");
				output.println("<div><a href='addStudent.html'>Add Student</a></div>");
				output.println("</body></html>");
			}
		}
		catch(Exception e) {
			output.print(e.getMessage());
		}
		
	}
}
