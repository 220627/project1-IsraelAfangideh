package com.AfangidehAyah.controllers;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.AfangidehAyah.daos.reimbursementDAO;
import com.AfangidehAyah.models.reimbursements;
import com.google.gson.Gson;

import io.javalin.http.Handler;

public class reimbursementController {
	public static Logger log = LogManager.getLogger();
	reimbursementDAO rDAO = new reimbursementDAO();
	public Handler addReimbursement = (ctx) -> {
		
		String body = ctx.body();
		
		Gson gson = new Gson();
		
		reimbursements newreimb = gson.fromJson(body, reimbursements.class);
		reimbursements reimbursement = newreimb;
	int employee_id = Integer.parseInt(ctx.cookie("employeeid"));
		if (rDAO.insertReimbursement(reimbursement, employee_id)) {
			log.info("New reimbursement inserted");
			ctx.status(202);
			
		}else {
			ctx.status(406);
			log.info("Failed to insert new reimbursement");
		}
		
		
	};
	
	public Handler getReimbursementsHandler = (ctx) -> {
		reimbursementDAO rDAO = new reimbursementDAO();
		
		//what is ctx? it's the Context object! 
		//This object contains a bunch of method that we can use to take in HTTP Requests and send HTTP Responses
		
		if(AuthController.ses != null) { //if the user is logged in, they can access this functionality
		
		//We need an ArrayList of Employees, courtesy of our EmployeeDAO
		ArrayList<reimbursements> reimbursement = rDAO.getAllReimbursements();
		log.info("Got all Reimbursements");
		//create a GSON object, which has methods to convert our Java object into JSON
		Gson gson = new Gson();
		
		//use the GSON .toJson() method to turn our Java into JSON String (JSON is always in String format on the Java side)
		String JSONemployees = gson.toJson(reimbursement); //employees is the ArrayList of our employee data
		
		//use ctx to provide an HTTP response containing our JSON string of employees (which is what was requested)
		
		ctx.result(JSONemployees); //ctx.result() sends a response back (this is where our data goes)
		
		ctx.status(200); //ctx.status() sets the HTTP status code. 200 stands for "OK", the generic success code.
		
		} else { //if the user is NOT logged in (aka AuthController.ses wil be null)
			ctx.result("YOU ARE NOT LOGGED IN!! *SMACK*");
			ctx.status(401); //"forbidden" access code
			log.info("Failed to get Reimbursements");
		}
		
	};
	
	public Handler getReimbursementsAuthHandler = (ctx) -> {
		reimbursementDAO rDAO = new reimbursementDAO();
		
		//what is ctx? it's the Context object! 
		//This object contains a bunch of method that we can use to take in HTTP Requests and send HTTP Responses
		
		if(AuthController.ses != null) { //if the user is logged in, they can access this functionality
		int employee_id = Integer.parseInt(ctx.cookie("employeeid"));
			
		//We need an ArrayList of Employees, courtesy of our EmployeeDAO
		ArrayList<reimbursements> reimbursement = rDAO.getReimbursementsbyAuthor(employee_id);
		
		//create a GSON object, which has methods to convert our Java object into JSON
		Gson gson = new Gson();
		
		//use the GSON .toJson() method to turn our Java into JSON String (JSON is always in String format on the Java side)
		String JSONemployees = gson.toJson(reimbursement); //employees is the ArrayList of our employee data
		
		//use ctx to provide an HTTP response containing our JSON string of employees (which is what was requested)
		
		ctx.result(JSONemployees); //ctx.result() sends a response back (this is where our data goes)
		
		ctx.status(200); //ctx.status() sets the HTTP status code. 200 stands for "OK", the generic success code.
		
		} else { //if the user is NOT logged in (aka AuthController.ses wil be null)
			ctx.result("YOU ARE NOT LOGGED IN!! *SMACK*");
			ctx.status(401); //"forbidden" access code
		}
		
	};

public Handler updatereimbursement = (ctx) -> {
	
	
	int id = Integer.parseInt(ctx.pathParam("id"));
	int reimb_id = id; //pathParam() gives us the value the user sends in as a path parameter
	//in this case, our Launcher endpoint handler calls it "title", so this is what we need to call here
	
	//int to hold the new Role salary, which the user will include in the BODY of the HTTP Request
	int reimb_status = Integer.parseInt(ctx.body()); //we need to use parseInt here, because ctx.body() returns a String
	//in postman, no need to make a JSON object, we can just input whatever number we want.
	
	//if the update DAO method returns true (which means successful)..
	if(rDAO.updateReimbursement(reimb_status, reimb_id)) {
		ctx.status(202); //202 stands for "accepted"
		
		System.out.println(reimb_id);
	} else {
		ctx.status(406); //406 stands for "not acceptable"
	}
	
};
	
};


