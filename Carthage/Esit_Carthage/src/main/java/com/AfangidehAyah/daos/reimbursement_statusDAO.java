package com.AfangidehAyah.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.AfangidehAyah.models.reimbursement_status;
import com.AfangidehAyah.util.ConnectionsUtil;

public class reimbursement_statusDAO {
	
	public boolean insertreimbursement_status(reimbursement_status status) {
		
	try(Connection conn =  ConnectionsUtil.getConnection()){
			
			String sql = "insert into reimbursement_status(status) values (?);";
				
			
			PreparedStatement ps = conn.prepareStatement(sql);
				
			
			ps.setString(1, status.getStatus()); 
		
			System.out.println(ps);
			
			ps.executeUpdate(); 
			
			//Tell the user the insert was successful
			System.out.println("New Status " + status.getStatus() + " " + "with status id: " + status.getStatus_id() + " has been added!");
			
			return true;
				
			} catch (SQLException e) { 
				System.out.println("Failed to add " +  status.getStatus()); 
				e.printStackTrace(); 
			}
			
			return false;
	}
	
	//addNewReimbursementStatusWithId
	

	public boolean insertreimbursement_statuswithid(reimbursement_status statuswithid) {
		
	try(Connection conn =  ConnectionsUtil.getConnection()){
			
			String sql = "insert into reimbursement_status(status_id, status) values (?, ?);";
				
			
			PreparedStatement ps = conn.prepareStatement(sql);
				
			
			ps.setInt(1, statuswithid.getStatus_id()); 
			ps.setString(2, statuswithid.getStatus()); 
		
			System.out.println(ps);
			
			ps.executeUpdate(); 
			
			//Tell the user the insert was successful
			System.out.println("New Status " + statuswithid.getStatus() + " " + "with status id: " + statuswithid.getStatus_id() + ", has been added!");
			
			return true;
				
			} catch (SQLException e) { 
				System.out.println("Failed to add " +  statuswithid.getStatus()); 
				e.printStackTrace(); 
			}
			
			return false;
	}

}
