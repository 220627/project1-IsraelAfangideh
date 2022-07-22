CREATE TABLE employees(
employee_id serial PRIMARY KEY,
username varchar(25),
PASSWORD varchar(25),
first_name TEXT,
last_name TEXT, 
email varchar(25),
trust_score float,
employee_role TEXT,
admin_notes TEXT 
);

CREATE TABLE reimbursement_status (
status_id serial PRIMARY KEY, 
status varchar(8));

CREATE TABLE reimbursements(
reimb_id serial PRIMARY KEY, 
reimb_amount money, 
reimb_submitted timestamp, 
reimb_description varchar(250), 
reimb_receipt bytea, 
reimb_status int REFERENCES reimbursement_status (status_id),
reimb_author int REFERENCES employees (employee_id),
reimb_resolver int  REFERENCES employees (employee_id)
);