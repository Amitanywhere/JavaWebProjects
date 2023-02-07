package net.crudtutorial.dao;

import java.util.*;

import net.crudtutorial.model.User;

public class UserDao {
	
	private static List<User> userList = new ArrayList<>();
	
	public static boolean addUser(User user) {
		boolean created = false;
		try {
			userList.add(user);
			created = true;
		}
		catch(Exception e) {
			e.getStackTrace();
		}
		return created;
	}

	public static List<User> getUserList() {
		return userList;
	}

	public static User getUserById(int id) {
		User user = null;
		try {
			for(User u : userList) {
				if(u.getId() == id) {
					user = u;
					break;
				}
			}
		}
		catch(Exception e) {
			e.getStackTrace();
		}
		return user;
	}
	
	public static boolean updateUserById(int id , String name , String email , String country) {
		boolean isUpdated = false;
		try {
			for(User user : userList) {
				if(user.getId() == id) {
					user.setName(name);
					user.setEmail(email);
					user.setCountry(country);
					isUpdated = true;
				}
			}
		}
		catch(Exception e) {
			e.getStackTrace();
		}
		return isUpdated;
	}
	
	public static boolean deleteUserById(int id) {
		boolean isDeleted = false;
		try {
			for(User user : userList) {
				if(user.getId() == id) {
					userList.remove(user);
					isDeleted = true;
				}
				}
		}
		catch(Exception e) {
			e.getStackTrace();
		}
		return isDeleted;
	}
	
}
