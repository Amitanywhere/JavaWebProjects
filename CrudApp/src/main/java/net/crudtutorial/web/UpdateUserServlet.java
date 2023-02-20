package net.crudtutorial.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.*;
import net.crudtutorial.dao.UserDao;
import net.crudtutorial.model.User;

public class UpdateUserServlet extends HttpServlet{
	
	
	public void doGet(HttpServletRequest req , HttpServletResponse res) throws IOException {
		res.setContentType("text/html");
		try {
		int id = Integer.parseInt(req.getParameter("id"));
		
		User user = UserDao.getUserById(id);
		
		PrintWriter pw = res.getWriter();
		pw.println("<form action='updateUser2'method='post'>");
		pw.println("<input type='hidden' value=" + id + " name='uid'>");
		pw.println("Name : <input type='text' name='name' value=" + user.getName() + "><br><br>Email :<input type= 'email' name='email' value=" + user.getEmail() + "><br><br>");
		pw.println("Country: <input type='text' name = 'country' value=" + user.getCountry() + "><br><br><input type='submit' value='Update'></form>");
	}
	catch(Exception e) {
		e.getStackTrace();
	}
	}
	

}

