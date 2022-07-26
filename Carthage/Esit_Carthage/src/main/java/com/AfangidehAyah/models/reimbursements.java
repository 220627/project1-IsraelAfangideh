package com.AfangidehAyah.models;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Arrays;

public class reimbursements {
	private int reimb_id;
	private BigDecimal reimb_amount;
	private Timestamp reimb_submitted;
	private String reimb_description;
	private byte[] reimb_receipt;
	private int reimb_status;
	private int reimb_author;
	private int reimb_resolver;
	
	
	public reimbursements() {
		super();
		// TODO Auto-generated constructor stub
	}


	public reimbursements(int reimb_id, BigDecimal reimb_amount, Timestamp reimb_submitted, String reimb_description,
			byte[] reimb_receipt, int reimb_status, int reimb_author, int reimb_resolver) {
		super();
		this.reimb_id = reimb_id;
		this.reimb_amount = reimb_amount;
		this.reimb_submitted = reimb_submitted;
		this.reimb_description = reimb_description;
		this.reimb_receipt = reimb_receipt;
		this.reimb_status = reimb_status;
		this.reimb_author = reimb_author;
		this.reimb_resolver = reimb_resolver;
	}


	public reimbursements(BigDecimal reimb_amount, Timestamp reimb_submitted, String reimb_description,
			byte[] reimb_receipt, int reimb_status, int reimb_author, int reimb_resolver) {
		super();
		this.reimb_amount = reimb_amount;
		this.reimb_submitted = reimb_submitted;
		this.reimb_description = reimb_description;
		this.reimb_receipt = reimb_receipt;
		this.reimb_status = reimb_status;
		this.reimb_author = reimb_author;
		this.reimb_resolver = reimb_resolver;
	}

	//no receipt
public reimbursements(int reimb_id, BigDecimal reimb_amount, Timestamp reimb_submitted, String reimb_description,
			int reimb_status, int reimb_author, int reimb_resolver) {
		super();
		this.reimb_id = reimb_id;
		this.reimb_amount = reimb_amount;
		this.reimb_submitted = reimb_submitted;
		this.reimb_description = reimb_description;
		this.reimb_status = reimb_status;
		this.reimb_author = reimb_author;
		this.reimb_resolver = reimb_resolver;
	}


//no id, no description
	public reimbursements(BigDecimal reimb_amount, Timestamp reimb_submitted, byte[] reimb_receipt, int reimb_status,
			int reimb_author, int reimb_resolver) {
		super();
		this.reimb_amount = reimb_amount;
		this.reimb_submitted = reimb_submitted;
		this.reimb_receipt = reimb_receipt;
		this.reimb_status = reimb_status;
		this.reimb_author = reimb_author;
		this.reimb_resolver = reimb_resolver;
	}


	@Override
	public String toString() {
		return "reimbursements [reimb_id=" + reimb_id + ", reimb_amount=" + reimb_amount + ", reimb_submitted="
				+ reimb_submitted + ", reimb_description=" + reimb_description + ", reimb_receipt="
				+ Arrays.toString(reimb_receipt) + ", reimb_status=" + reimb_status + ", reimb_author=" + reimb_author
				+ ", reimb_resolver=" + reimb_resolver + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}


	public int getReimb_id() {
		return reimb_id;
	}


	public void setReimb_id(int reimb_id) {
		this.reimb_id = reimb_id;
	}


	public BigDecimal getReimb_amount() {
		return reimb_amount;
	}


	public void setReimb_amount(BigDecimal reimb_amount) {
		this.reimb_amount = reimb_amount;
	}


	public Timestamp getReimb_submitted() {
		return reimb_submitted;
	}


	public void setReimb_submitted(Timestamp reimb_submitted) {
		this.reimb_submitted = reimb_submitted;
	}


	public String getReimb_description() {
		return reimb_description;
	}


	public void setReimb_description(String reimb_description) {
		this.reimb_description = reimb_description;
	}


	public byte[] getReimb_receipt() {
		return reimb_receipt;
	}


	public void setReimb_receipt(byte[] reimb_receipt) {
		this.reimb_receipt = reimb_receipt;
	}


	public int getReimb_status() {
		return reimb_status;
	}


	public void setReimb_status(int reimb_status) {
		this.reimb_status = reimb_status;
	}


	public int getReimb_author() {
		return reimb_author;
	}


	public void setReimb_author(int reimb_author) {
		this.reimb_author = reimb_author;
	}


	public int getReimb_resolver() {
		return reimb_resolver;
	}


	public void setReimb_resolver(int reimb_resolver) {
		this.reimb_resolver = reimb_resolver;
	}

}
