package com.AfangidehAyah;

import java.sql.Connection;
import java.sql.SQLException;

import com.AfangidehAyah.controllers.AuthController;
import com.AfangidehAyah.controllers.EmployeeController;
import com.AfangidehAyah.controllers.reimbursementController;
import com.AfangidehAyah.controllers.reimbursement_statusController;
import com.AfangidehAyah.util.ConnectionsUtil;

import io.javalin.Javalin;

//When we talk about a reimbursement manager, we are really talking about Trust & Trustworthiness
//We are talking about a way to manage drivers based on Trustworthiness
//And when we ask/tell drivers to spend money, and that we will reimburse them for their expenses
//We are asking them to trust us
//Managers need a way to track trustworthiness
//Employees need a system that maintains and increments Trust
//This is what we are now going to build


public class Launcher {
	
	public static void main(String [] args) {
		try(Connection conn = ConnectionsUtil.getConnection()){
			System.out.println("CONNECTION SUCCESSFUL :)");
		} catch (SQLException e) {
			//if the connection fails to open, catch the resulting SQLException and print the stack trace (error log)
			System.out.println("connection failed...");
			e.printStackTrace();
		} //end of the connection test
			
		
		//Typical Javalin syntax to CREATE a javalin object 
		Javalin app = Javalin.create(
				
				//the config lambda lets us specify certain configurations for our Javalin app.
				config -> {
					config.enableCorsForAllOrigins(); //this lets us process HTTP requests from any origin
				}
				
				).start(7171); 
	EmployeeController ec = new EmployeeController ();
	reimbursement_statusController rsc = new reimbursement_statusController ();
	reimbursementController rc = new reimbursementController ();
	AuthController ac = new AuthController ();
		app.get("/reimbursements", rc.getReimbursementsHandler);
		app.get("/reimbursementsbyauthor/:eid", rc.getReimbursementsAuthHandler);
		app.post("/register", ec.addEmployee);
		app.post("/login", ac.loginHandler);
		app.post("/addstatus", rsc.addNewReimbursementStatus);
		app.post("/addstatuswithid", rsc.addNewReimbursementStatuswithid);
		app.post("/addreimbursement", rc.addReimbursement);
//		app.patch(path, rc.updatereimbursement);
		app.put("/reimbursements/:id", rc.updatereimbursement);
		
	
	}
	

}
