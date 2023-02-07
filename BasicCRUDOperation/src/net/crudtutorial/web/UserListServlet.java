package net.crudtutorial.web;

import java.io.PrintWriter;
import java.util.List;

import jakarta.servlet.http.*;
import net.crudtutorial.dao.UserDao;
import net.crudtutorial.model.User;

public class UserListServlet extends HttpServlet{
	
	public void doGet(HttpServletRequest req , HttpServletResponse res) {
		
		try {
			List<User> userList = UserDao.getUserList();
			
			PrintWriter pw = res.getWriter();
			pw.println("<h1>User List</h1>");
			pw.println("<table style = \"width : 100% \"> <tr><th>Name</th><th>Country</th><th>"
					+ "Edit</th><th>Delete</th></tr>");
			if(userList.isEmpty()) {
				pw.println("<tr>No user present</tr>");
			}
			else {
				for(User user : userList) {
					pw.println("<tr><td>" + user.getName() + "</td>" + "<td>" + user.getCountry() + "</td>" + "<td>"
				+ "<a href='updateUser?id=" + user.getId() +  " '>Edit</a></td>" + "<td><a href = 'deleteUser?id=" + user.getId() + 
				  "'>Delete</a></td>"+"</tr>");
				}
				pw.println("</table>");
			}
		}
		catch(Exception e) {
			e.getStackTrace();
		}
	}

}
