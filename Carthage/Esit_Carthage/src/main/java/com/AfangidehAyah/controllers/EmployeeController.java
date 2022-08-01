package com.AfangidehAyah.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.AfangidehAyah.daos.EmployeeDAO;
import com.AfangidehAyah.models.employees;
import com.google.gson.Gson;

import io.javalin.http.Handler;
import org.apache.logging.log4j.Logger;
public class EmployeeController {
	EmployeeDAO eDAO = new EmployeeDAO();
	public Handler addEmployee = (ctx) -> {
		  Logger log = LogManager.getLogger();
		String body = ctx.body();
		
		Gson gson = new Gson();
		
		employees newemployee = gson.fromJson(body, employees.class);
		
		if (eDAO.insertEmployee(newemployee)) {
			ctx.status(202);
			
			log.info("New Employee Added");
		}else {
			ctx.status(406);
			log.info("Failed to add employee");
		}
		
		
	};
	public Handler getAddEmployee() {
		return addEmployee;
	}
	public void setAddEmployee(Handler addEmployee) {
		this.addEmployee = addEmployee;
	}

}
