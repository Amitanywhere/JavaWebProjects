package com.student.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.*;

import com.student.dao.InstituteDao;
import com.student.model.InstituteModel;
import com.student.model.StudentModel;

public class AddStudentServlet extends HttpServlet {
	
	public void doPost(HttpServletRequest req , HttpServletResponse res) throws IOException {
		
		res.setContentType("text/html");
		PrintWriter output = res.getWriter();
		
		try {
			HttpSession session = req.getSession(false);
			if(session == null) {
				res.sendRedirect("instituteLogin");
			}
			else {
				String studentName = req.getParameter("sname");
				String studentCity = req.getParameter("scity");
				String number = req.getParameter("snumber");
				long studentNumber = Long.parseLong(number);
				InstituteModel institute = (InstituteModel) session.getAttribute("institute");
				String instituteName = institute.getInstituteName();
				boolean isAdded = InstituteDao.addStudent(instituteName, new StudentModel(instituteName , studentName , studentCity , studentNumber));
				if(isAdded) {
					res.sendRedirect("studentList");
				}
				else {
					output.println("Student not added");
					req.getRequestDispatcher("addStudent.html").include(req, res);
				}
			}
		}
		catch(Exception e) {
			output.println(e.getMessage());
		}
	}
	
}
