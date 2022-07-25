package com.AfangidehAyah.controllers;

import com.AfangidehAyah.daos.reimbursement_statusDAO;
import com.AfangidehAyah.models.reimbursement_status;
import com.google.gson.Gson;

import io.javalin.http.Handler;

public class reimbursement_statusController {
	
	reimbursement_statusDAO rsDAO = new reimbursement_statusDAO();
	public Handler addNewReimbursementStatus = (ctx) -> {
		
		String body = ctx.body();
		
		Gson gson = new Gson();
		
		reimbursement_status newReimbursement = gson.fromJson(body, reimbursement_status.class);
		
		if (rsDAO.insertreimbursement_status(newReimbursement)) {
			ctx.status(202);
			
		}else {
			ctx.status(406);
		}
		
		
	};
	

	
		public Handler addNewReimbursementStatuswithid = (ctx) -> {
			
			String body = ctx.body();
			
			Gson gson = new Gson();
			
			reimbursement_status newReimbursement = gson.fromJson(body, reimbursement_status.class);
			
			if (rsDAO.insertreimbursement_statuswithid(newReimbursement)){
				ctx.status(202);
				
			}else {
				ctx.status(406);
			}
			
			
		};

}
