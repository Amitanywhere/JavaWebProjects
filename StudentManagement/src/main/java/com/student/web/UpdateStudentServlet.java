package com.student.web;

import java.io.IOException;
import java.io.PrintWriter;

import com.student.dao.InstituteDao;
import com.student.model.*;

import javax.servlet.http.*;

public class UpdateStudentServlet extends HttpServlet{
	
	public void doGet(HttpServletRequest req , HttpServletResponse res) throws IOException {
		
		res.setContentType("text/html");
		PrintWriter output = res.getWriter();
		try {
			
			HttpSession session = req.getSession(false);
			
			if(session == null) {
				res.sendRedirect("instituteLogin");
			}
			else {
			
			String id = req.getParameter("id");
			int studentId = Integer.parseInt(id);
			
			InstituteModel institute = (InstituteModel) session.getAttribute("institute");
			StudentModel student = InstituteDao.getStudent(institute.getInstituteName() , studentId);
			output.print("<html>");
			output.println("<title>Update Student</title>");
			output.println("<body>");
			output.println("<h1>Update Student</h1>");
			output.println("<form action='updateStudent' method='post'>");
			output.println("<input type='hidden' name='instname' value= " + institute.getInstituteName() + " >");
			output.println("<input type='hidden' name='sid' value= " + student.getStudentId() + " >");
			output.println("Student name   : <input type=\"text\" name=\"sname\" value= "+ student.getStudentName() + " ><br><br>");
			output.println("Student city   : <input type=\"text\" name=\"scity\" value= "+ student.getCity() + " ><br><br>");
			output.println("Student Number : <input type=\"text\" name=\"snumber\" value= "+ student.getStudentNumber() + " ><br><br>");
			output.println("<input type=\"submit\" value=\"Update Student\">");
			output.println("</form></body></html>");
			}
			
		}
		catch(Exception e) {
			e.getMessage();		}
	}
	
	public void doPost(HttpServletRequest req , HttpServletResponse res) throws IOException {
		res.setContentType("text/html");
		PrintWriter output = res.getWriter();
		try {
			String id = req.getParameter("sid");
			int studentId = Integer.parseInt(id);
			String instName = req.getParameter("instname");
			String studentName = req.getParameter("sname");
			String studentCity = req.getParameter("scity");
			String number = req.getParameter("snumber");
			

			long studentNumber = Long.parseLong(number);
			
			boolean isUpdated = InstituteDao.updateStudent(instName, studentId, studentName, studentCity, studentNumber);

			if(isUpdated) {
				res.sendRedirect("studentList");
			}
			else {
				output.println("updation failed");
			}
		}
		catch(Exception e) {
			e.getMessage();
		}
	}

}
