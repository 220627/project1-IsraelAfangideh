package com.AfangidehAyah.controllers;

import com.AfangidehAyah.daos.EmployeeDAO;
import com.AfangidehAyah.models.employees;
import com.google.gson.Gson;

import io.javalin.http.Handler;

public class EmployeeController {
	EmployeeDAO eDAO = new EmployeeDAO();
	public Handler addEmployee = (ctx) -> {
		
		String body = ctx.body();
		
		Gson gson = new Gson();
		
		employees newemployee = gson.fromJson(body, employees.class);
		
		if (eDAO.insertEmployee(newemployee)) {
			ctx.status(202);
			
		}else {
			ctx.status(406);
		}
		
		
	};

}
