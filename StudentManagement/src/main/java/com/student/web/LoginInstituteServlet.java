package com.student.web;

import javax.servlet.http.*;

import com.student.dao.InstituteDao;
import com.student.model.InstituteModel;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.*;

public class LoginInstituteServlet extends HttpServlet{
	
	public void doGet(HttpServletRequest req , HttpServletResponse res) throws IOException {
		res.setContentType("text/html");
		PrintWriter output = res.getWriter();
		
		try {
			HttpSession session = req.getSession(false);

			if(session == null) {
				output.println("<html>");
				output.println("<title>Institute Login</title>");
				output.println("<body>");
				output.println("<h1>Institute Login<h1>");
				output.println("<form action='instituteLogin' method = 'post'>");
				output.println("<input type='text' name='name'><br><br>");
				output.println("<input type='text' name='password'><br><br>");
				output.println("<input type='submit' value='Login'>");
				output.println("<div><a href='registerInstitute.html'>Register Institute</a></div>");
				output.println("</form></body></html>");
			}
			else {
				res.sendRedirect("studentList");
			}
		}
		catch(Exception e) {
			output.println(e.getMessage());
		}
	}
	
	public void doPost(HttpServletRequest req , HttpServletResponse res) throws IOException {
		res.setContentType("text/html");
		PrintWriter output = res.getWriter();
		
		try {
			String name = req.getParameter("name");
			String password = req.getParameter("password");
			InstituteModel institute = InstituteDao.loginInstitute(name, password);
			if(institute == null) {
				output.println("Name or password is not correct or register the institute first <a href='index.html'>Home</a>");
			}
			else {
				HttpSession session = req.getSession();
				session.setAttribute("institute", institute);
				res.sendRedirect("studentList");
			}
		}
		catch(Exception e) {
			output.println(e.getMessage());
		}
	}

}
