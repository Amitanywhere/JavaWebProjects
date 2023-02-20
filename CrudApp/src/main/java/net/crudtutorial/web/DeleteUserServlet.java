package net.crudtutorial.web;

import java.io.IOException;

import javax.servlet.http.*;
import net.crudtutorial.dao.UserDao;

public class DeleteUserServlet extends HttpServlet{
	
	public void doGet(HttpServletRequest req , HttpServletResponse res) throws IOException {
		
		try {
		int id = Integer.parseInt(req.getParameter("id"));
		
		boolean isDeleted = UserDao.deleteUserById(id);
		
		if(isDeleted) {
			res.sendRedirect("userList");
		}
		}
		catch(Exception e) {
			e.getStackTrace();
		}
		
	}
}
