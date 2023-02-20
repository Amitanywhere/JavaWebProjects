package com.student.web;

import javax.servlet.http.*;

public class LogoutServlet extends HttpServlet{
	
	public void doGet(HttpServletRequest req , HttpServletResponse res) {
		try {
			HttpSession session = req.getSession(false);
			if(session != null) {
				session.invalidate();
				res.sendRedirect("index.html");
			}
		}
		catch(Exception e) {
			e.getMessage();
		}
	}
}
