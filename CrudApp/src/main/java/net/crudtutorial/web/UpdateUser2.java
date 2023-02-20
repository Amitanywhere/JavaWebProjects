package net.crudtutorial.web;

import java.io.IOException;

import javax.servlet.http.*;
import net.crudtutorial.dao.UserDao;

public class UpdateUser2 extends HttpServlet{

		public void doPost(HttpServletRequest req , HttpServletResponse res) throws IOException {
			try {
			String uid = req.getParameter("uid");
			int id = Integer.parseInt(uid);
			String name = (String)req.getParameter("name");
			String email = (String)req.getParameter("email");
			String country = (String)req.getParameter("country");
			
			
			boolean isUpdated = UserDao.updateUserById(id, name, email, country);
			if(isUpdated) {
				res.sendRedirect("userList");
			}
			}
			catch(Exception e) {
				e.getStackTrace();
			}
		}
}
