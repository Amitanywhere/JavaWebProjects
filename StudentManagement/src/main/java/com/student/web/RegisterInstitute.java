package com.student.web;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import com.student.dao.InstituteDao;
import com.student.model.InstituteModel;

public class RegisterInstitute extends HttpServlet{
	
	public void doPost(HttpServletRequest req , HttpServletResponse res) throws IOException , ServletException {
		
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		
		try {
			String instName = req.getParameter("name");
			String instCity = req.getParameter("city");
			
			if(instName.equals("") || instName ==  null || instCity.equals("") || instCity == null) {
				out.println("provide valid name and city for institute");
			}
			else {
			InstituteDao.addInstitute(new InstituteModel(instName , instCity));
			RequestDispatcher rDispatcher = req.getRequestDispatcher("instituteLogin");
			out.println("Institute Register successfully <a href='index.html'>Home</a>");
			rDispatcher.include(req, res);
			}
		}
		catch(Exception e) {
			out.print(e.getMessage());
		}
	}
}
