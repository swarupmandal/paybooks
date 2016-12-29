package com.appsquad.paybooks.sql;

public class EmployeeMasterSql {

	public static final String employeeinsertsql = "insert into em_employee_info (employee_code, employee_name,created_by,updated_by) values (?,?,?,?) ";
	
	public static final String loadEmployeeInfosql = "select employee_info_id,employee_code,employee_name,is_delete from em_employee_info; ";
	
	
}
