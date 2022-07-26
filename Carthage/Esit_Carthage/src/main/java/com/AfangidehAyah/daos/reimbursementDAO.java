package com.AfangidehAyah.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.AfangidehAyah.models.reimbursements;
import com.AfangidehAyah.util.ConnectionsUtil;

public class reimbursementDAO implements reimbursementDAOInterface {

	@Override
	public boolean insertReimbursement(reimbursements reimbursement) {
try(Connection conn =  ConnectionsUtil.getConnection()){
			
			String sql = "insert into reimbursements(reimb_amount, reimb_submitted, reimb_description, reimb_status, reimb_author, reimb_resolver) values (?, ?, ?, ?, ?, ?);";
				
			
			PreparedStatement ps = conn.prepareStatement(sql);
				
			
			ps.setBigDecimal(1, reimbursement.getReimb_amount()); 
			ps.setTimestamp(2, reimbursement.getReimb_submitted());
			ps.setString(3, reimbursement.getReimb_description());  
			ps.setInt(4, reimbursement.getReimb_status());					   
			ps.setInt(5, reimbursement.getReimb_author());
			ps.setInt(6, reimbursement.getReimb_resolver());
		
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
	public ArrayList<reimbursements> getAllReimbursements(reimbursements reimbursement) {
try(Connection conn = ConnectionsUtil.getConnection()){
			
			
			String sql = "select * from reimbursements where reimb_author = ?;";
			
			PreparedStatement ps = conn.prepareStatement(sql); 
			
			ps.setInt(1, reimbursement.getReimb_author());
			
			ResultSet rs = ps.executeQuery();
			
			ArrayList<reimbursements> reimbList = new ArrayList<>();
			
			while(rs.next()) {
				
				reimbursements r = new reimbursements (
						rs.getInt("reimb_id"),
						rs.getBigDecimal("reimb_amount"),
						rs.getTimestamp("reimb_submitted"),
						rs.getString("reimb_description"),
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
}
