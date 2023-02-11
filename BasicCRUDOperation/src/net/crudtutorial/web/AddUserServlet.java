package net.crudtutorial.web;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import net.crudtutorial.dao.UserDao;
import net.crudtutorial.model.User;

public class AddUserServlet extends HttpServlet{
	
	public void doPost(HttpServletRequest req , HttpServletResponse res) throws IOException, ServletException {
		
		res.setContentType("text/html");
		try {
			String name = req.getParameter("name");
			String email = (String)req.getParameter("email");
			String country = (String)req.getParameter("country");
			
			User newUser = new User(name , email, country);
			boolean isAdded = UserDao.addUser(newUser);
			
			PrintWriter output = res.getWriter();
			if(isAdded) {
				output.println("User added successfully");
				RequestDispatcher rd = req.getRequestDispatcher("registeruser.html");
				rd.include(req, res);
			}
			else {
				output.println("user registration failed");
				RequestDispatcher rd = req.getRequestDispatcher("registeruser.html");
				rd.include(req, res);
			}
		}
		catch(Exception e) {
			res.getWriter().println(e.getStackTrace());
			RequestDispatcher rd = req.getRequestDispatcher("registeruser.html");
			rd.include(req, res);
		}
	}
}
