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
			pw.println("<html>");
			pw.println("<style>");
			pw.println("table , th , td{border : 1px solid black;}");
			pw.println("h1{text-align : center;  color : red;}");
			pw.println("</style>"); 
			pw.println("<body>");
			pw.println("<h1>User List</h1>");
			pw.println("<table style = \"width : 100% \">");
			pw.println("<tr>");
			pw.println("<th>Name</th>");
			pw.println("<th>Country</th>");
			pw.println("<th>Edit</th>");
			pw.println("<th>Delete</th>");
			pw.println("</tr>");
			if(userList.isEmpty()) {
				pw.println("<tr>No user present</tr>");
			}
			else {
				for(User user : userList) {
					pw.println("<tr>");
					pw.println("<td>" + user.getName() + "</td>");
					pw.println("<td>" + user.getCountry() + "</td>");
					pw.println("<td>");
					pw.println("<a href='updateUser?id=" + user.getId() +  " '>Edit</a>");
					pw.println("</td>");
					pw.println("<td>");
					pw.println("<a href='deleteUser?id=" + user.getId() +  " '>Delete</a>");
					pw.println("</td>");
					pw.println("</tr>");
				}
				pw.println("</table></body></html>");
			}
		}
		catch(Exception e) {
			e.getStackTrace();
		}
	}

}
