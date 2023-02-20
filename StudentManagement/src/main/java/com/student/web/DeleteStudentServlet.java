package com.student.web;

import javax.servlet.http.*;
import java.io.*;

import com.student.dao.InstituteDao;
import com.student.model.InstituteModel;

public class DeleteStudentServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req , HttpServletResponse res) throws IOException {
		
		PrintWriter output = res.getWriter();
		try {
			HttpSession session = req.getSession(false);
			if(session == null) {
				res.sendRedirect("instituteLogin");
			}
			else {
			InstituteModel institute = (InstituteModel) session.getAttribute("institute");
			
			String id = req.getParameter("id");
			int studentId = Integer.parseInt(id);
			
			boolean isRemoved = InstituteDao.removeStudent(institute.getInstituteName(), studentId);
			
			if(isRemoved) {
				res.sendRedirect("studentList");
			}
			else {
				output.print("student deletion failed");
			}
			}
		}
		catch(Exception e) {
			e.getMessage();
		}
	}
}
