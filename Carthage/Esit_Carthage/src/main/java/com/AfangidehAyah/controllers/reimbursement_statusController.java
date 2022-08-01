package com.AfangidehAyah.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.AfangidehAyah.daos.reimbursement_statusDAO;
import com.AfangidehAyah.models.reimbursement_status;
import com.google.gson.Gson;

import io.javalin.http.Handler;

public class reimbursement_statusController {
	
	reimbursement_statusDAO rsDAO = new reimbursement_statusDAO();
	public Handler addNewReimbursementStatus = (ctx) -> {
		 Logger log = LogManager.getLogger();
		String body = ctx.body();
		
		Gson gson = new Gson();
		
		reimbursement_status newReimbursement = gson.fromJson(body, reimbursement_status.class);
		
		if (rsDAO.insertreimbursement_status(newReimbursement)) {
			ctx.status(202);
			
		log.info("New Reimbursement Status Added");
			
		}else {
			ctx.status(406);
			log.info("New Reimbursement Status Failed to Add");
		}
		
		
	};
	

	
		public Handler addNewReimbursementStatuswithid = (ctx) -> {
			 Logger log = LogManager.getLogger();
			String body = ctx.body();
			
			Gson gson = new Gson();
			
			reimbursement_status newReimbursement = gson.fromJson(body, reimbursement_status.class);
			
			if (rsDAO.insertreimbursement_statuswithid(newReimbursement)){
				ctx.status(202);
				log.info("New Reimbursement Status Added With reimbursement id");
				
			}else {
				ctx.status(406);
				log.info("Failed to add New Reimbursement Status with reimbursement id");
			}
			
			
		};

}
