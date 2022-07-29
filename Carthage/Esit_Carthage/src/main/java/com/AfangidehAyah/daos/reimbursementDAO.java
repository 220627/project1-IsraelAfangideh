package com.AfangidehAyah.daos;


import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.AfangidehAyah.controllers.AuthController;
import com.AfangidehAyah.controllers.EmployeeController;
import com.AfangidehAyah.models.employees;
import com.AfangidehAyah.models.reimbursements;
import com.AfangidehAyah.services.AuthService;
import com.AfangidehAyah.util.ConnectionsUtil;
import com.google.gson.Gson;

import io.javalin.http.Context;
import io.javalin.http.Handler;

public class reimbursementDAO implements reimbursementDAOInterface {

	@Override
	public boolean insertReimbursement(reimbursements reimbursement, int employee_id) {
try(Connection conn =  ConnectionsUtil.getConnection()){
//	AuthController ac = new AuthController ();
//	AuthDAO aDAO = new AuthDAO();
	
//	employees eid = aDAO.rs; 
//	int employeeid = ac.getcollectedKeys();
//	Context ctx = new Context ();
	String sql = "insert into reimbursements(reimb_amount, reimb_submitted, reimb_description, reimb_receipt, reimb_author) values (?, ?, ?, ?, ?);";
	
	
	PreparedStatement ps = conn.prepareStatement(sql);
		
	
	ps.setDouble(1, reimbursement.getReimb_amount()); 
	ps.setString(2, reimbursement.getReimb_submitted());
	ps.setString(3, reimbursement.getReimb_description());
	ps.setBytes(4, reimbursement.getReimb_receipt());
	ps.setInt(5, employee_id);
//	ps.setInt
	
		
			
		
			System.out.println(ps);
			
			
			
			
			ps.executeUpdate(); 
			
			//Tell the user the insert was successful
			System.out.println("Reimbursement for  " + reimbursement.getReimb_description() + " has been submitted and will be reviewed very soon");
			
			return true;
				
			} catch (SQLException e) { 
				System.out.println("Failed to add " + "reimbursement for  " + reimbursement.getReimb_description()); 
				e.printStackTrace(); 
			}
			
			return false;
			
		}

	@Override
	public ArrayList<reimbursements> getReimbursementsbyAuthor(int employee_id) {
try(Connection conn = ConnectionsUtil.getConnection()){
AuthController ac = new AuthController ();
AuthService as = new AuthService ();
EmployeeController ec = new EmployeeController ();

	
			
			String sql = "select * from reimbursements where reimb_author = ?;";
			
			PreparedStatement ps = conn.prepareStatement(sql); 
			
			ps.setInt(1, employee_id);
			
			ResultSet rs = ps.executeQuery();
			
			ArrayList<reimbursements> reimbList = new ArrayList<>();
			
			while(rs.next()) {
				
				reimbursements r = new reimbursements (
						rs.getInt("reimb_id"),
						rs.getInt("reimb_amount"),
						rs.getString("reimb_submitted"),
						rs.getString("reimb_description"),
						rs.getBytes("reimb_receipt"),
						rs.getInt("reimb_status"),
						rs.getInt("reimb_author"),
						rs.getInt("reimb_resolver")
						
						);
				
				reimbList.add(r);
			}
			
	return reimbList;
	} catch (SQLException e) {
		System.out.println("Unable to get reimbursements :( Try again"); //tell the console it failed
		e.printStackTrace(); //print the error log for debugging
	
	

}
return null;
	
}

	@Override
	public ArrayList<reimbursements> getAllReimbursements() {
try(Connection conn = ConnectionsUtil.getConnection()){
			
			
			String sql = "select * from reimbursements;";
			
			
			Statement s = conn.createStatement(); 
		
			
			ResultSet rs = s.executeQuery(sql);
			
			ArrayList<reimbursements> reimbList = new ArrayList<>();
			
			while(rs.next()) {
				
				reimbursements r = new reimbursements (
						rs.getInt("reimb_id"),
						rs.getDouble("reimb_amount"),
						rs.getString("reimb_submitted"),
						rs.getString("reimb_description"),
						rs.getBytes("reimb_receipt"),
						rs.getInt("reimb_status"),
						rs.getInt("reimb_author"),
						rs.getInt("reimb_resolver")
						
						);
				
				reimbList.add(r);
			}
			
	return reimbList;
	} catch (SQLException e) {
		System.out.println("Unable to get reimbursements :( Try again"); //tell the console it failed
		e.printStackTrace(); //print the error log for debugging
	
	

}
return null;
	
}

	@Override
	public boolean updateReimbursement(int reimb_status, int reimb_id) {
		try(Connection con = ConnectionsUtil.getConnection()){
			
			//SQL String for our UPDATE command
			String sql = "update reimbursements set reimb_status = ? where reimb_id = ?;";
			
			//create our PreparedStatement to fill in the variables
			PreparedStatement ps = con.prepareStatement(sql);
			
			//input the appropriate values into our PreparedStatement
			ps.setInt(1, reimb_status);
			ps.setInt(2, reimb_id);
			
			//execute the update!
			ps.executeUpdate();
			
			//tell the console the update was successfully 
			System.out.println("reimbursement number:" + reimb_id + "'s Status Has been successfully modified");
			
			//if it succeeds, return true
			return true;
			
		} catch (SQLException e) {
			System.out.println("FAILED TO Modify reimbursement Status");
			e.printStackTrace();
		}
		return false;
}
}
