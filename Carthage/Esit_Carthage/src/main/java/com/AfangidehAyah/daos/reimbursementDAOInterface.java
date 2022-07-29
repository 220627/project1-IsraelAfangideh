package com.AfangidehAyah.daos;

import java.util.ArrayList;

import com.AfangidehAyah.models.reimbursements;

public interface reimbursementDAOInterface {
	
	public boolean insertReimbursement(reimbursements reimbursement, int employee_id);
	
//	public ArrayList<reimbursements> getReimbursementsbyAuthor(reimbursements reimbursement);
	
	public ArrayList<reimbursements> getAllReimbursements();

	ArrayList<reimbursements> getReimbursementsbyAuthor(int employee_id);
	
	public  boolean updateReimbursement (int reimb_status, int reimb_id);
}
