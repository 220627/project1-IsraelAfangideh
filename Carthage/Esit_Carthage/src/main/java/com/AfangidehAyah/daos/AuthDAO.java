package com.AfangidehAyah.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.AfangidehAyah.models.employees;
import com.AfangidehAyah.util.ConnectionsUtil;

public class AuthDAO {

public employees login(String username, String password) {
		
		try(Connection conn = ConnectionsUtil.getConnection()){
			
		String sql = "select * from employees where username = ? and password = ?;";
			
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setString(1, username);
		ps.setString(2, password);
		
		ResultSet rs = ps.executeQuery();
		
		//if anything gets returned at all, we know a user exists with that username/password pair. 
		//so we can create a new User object to send to the front end
		if(rs.next()) {
			
			employees employee = new employees(
					rs.getInt("employee_id"),
					rs.getString("username"),
					rs.getString("first_name"),
					rs.getString("last_name"),
					rs.getString("email"),
					rs.getFloat("trust_score"),
					rs.getString("employee_role")
					);
			
			return employee;
			
			
			
		}
		
		} catch (SQLException e) {
			System.out.println("LOGIN FAILED");
			e.printStackTrace();
		}
		
		return null; //if no user is returned, return null. We will do a null check in the service layer.
		
	}


}
