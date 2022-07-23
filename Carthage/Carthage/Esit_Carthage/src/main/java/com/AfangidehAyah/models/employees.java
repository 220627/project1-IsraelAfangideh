package com.AfangidehAyah.models;

public class employees {
	private int employee_id;
	private String username;
	private String password;
	private String first_name;
	private String last_name;
	private String email;
	private float trust_score;
	private String employee_role;
	private String admin_notes;
	
	
	public employees() {
		super();
		// TODO Auto-generated constructor stub
	}


	public employees(int employee_id, String username, String password, String first_name, String last_name,
			String email, float trust_score, String employee_role, String admin_notes) {
		super();
		this.employee_id = employee_id;
		this.username = username;
		this.password = password;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.trust_score = trust_score;
		this.employee_role = employee_role;
		this.admin_notes = admin_notes;
	}


	public employees(String username, String password, String first_name, String last_name, String email,
			float trust_score, String employee_role, String admin_notes) {
		super();
		this.username = username;
		this.password = password;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.trust_score = trust_score;
		this.employee_role = employee_role;
		this.admin_notes = admin_notes;
		
	}
	
	


	public employees(String username, String password, String first_name, String last_name, String email,
			String employee_role, String admin_notes) {
		super();
		this.username = username;
		this.password = password;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.employee_role = employee_role;
		this.admin_notes = admin_notes;
	}


	public int getEmployee_id() {
		return employee_id;
	}


	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getFirst_name() {
		return first_name;
	}


	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}


	public String getLast_name() {
		return last_name;
	}


	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public float getTrust_score() {
		return trust_score;
	}


	public void setTrust_score(float trust_score) {
		this.trust_score = trust_score;
	}


	public String getEmployee_role() {
		return employee_role;
	}


	public void setEmployee_role(String employee_role) {
		this.employee_role = employee_role;
	}


	public String getAdmin_notes() {
		return admin_notes;
	}


	public void setAdmin_notes(String admin_notes) {
		this.admin_notes = admin_notes;
	}


	@Override
	public String toString() {
		return "employees [employee_id=" + employee_id + ", username=" + username + ", password=" + password
				+ ", first_name=" + first_name + ", last_name=" + last_name + ", email=" + email + ", trust_score="
				+ trust_score + ", employee_role=" + employee_role + ", admin_notes=" + admin_notes
				+ ", getEmployee_id()=" + getEmployee_id() + ", getUsername()=" + getUsername() + ", getPassword()="
				+ getPassword() + ", getFirst_name()=" + getFirst_name() + ", getLast_name()=" + getLast_name()
				+ ", getEmail()=" + getEmail() + ", getTrust_score()=" + getTrust_score() + ", getEmployee_role()="
				+ getEmployee_role() + ", getAdmin_notes()=" + getAdmin_notes() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	

}
