package com.AfangidehAyah.daos;

import java.util.ArrayList;

import com.AfangidehAyah.models.reimbursements;

public interface reimbursementDAOInterface {
	
	public boolean insertReimbursement(reimbursements reimbursement);
	
	public ArrayList<reimbursements> getAllReimbursements(reimbursements reimbursement);

}
