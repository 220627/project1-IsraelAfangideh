package com.AfangidehAyah.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.AfangidehAyah.models.employees;
import com.AfangidehAyah.util.ConnectionsUtil;

public class EmployeeDAO implements EmployeeDAOInterface{

	@Override
	public boolean insertEmployee(employees employees) {
		try(Connection conn =  ConnectionsUtil.getConnection()){
			
			String sql = "insert into employees(username, password, first_name, last_name, email, employee_role, admin_notes) values (?, ?, ?, ?, ?, ?, ?);";
				
			
			PreparedStatement ps = conn.prepareStatement(sql);
				
			
			ps.setString(1, employees.getUsername()); 
			ps.setString(2, employees.getPassword());
			ps.setString(3, employees.getFirst_name());  
			ps.setString(4, employees.getLast_name());					   
			ps.setString(5, employees.getEmail());
			ps.setString(6, employees.getEmployee_role());
			ps.setString(7, employees.getAdmin_notes());
			System.out.println(ps);
			
			
			
			
			ps.executeUpdate(); 
			
			//Tell the user the insert was successful
			System.out.println("Employee " + employees.getFirst_name() + " " + employees.getLast_name() + " has been added!");
			
			return true;
				
			} catch (SQLException e) { 
				System.out.println("Failed to add " +  employees.getFirst_name() + " " + employees.getLast_name()); 
				e.printStackTrace(); 
			}
			
			return false;
			
		}
	
	

}
