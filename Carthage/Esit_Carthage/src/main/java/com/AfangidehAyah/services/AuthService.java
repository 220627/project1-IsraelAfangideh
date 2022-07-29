package com.AfangidehAyah.services;

import com.AfangidehAyah.daos.AuthDAO;
import com.AfangidehAyah.models.employees;

public class AuthService {
	
	

		AuthDAO aDAO = new AuthDAO();
		
		public employees login(String username, String password) {
			
			if(aDAO.login(username, password) != null) {
				return aDAO.login(username, password);
				//if the username and password return a User from the DAO, send the User back.
			}
			
			return null; //if login fails, return null
			
		}
		

}
