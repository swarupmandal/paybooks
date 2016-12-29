package com.appsquad.paybooks.sql;

public class LoadAllListSql {

	public static final String loadEmployeeInfo = "select employee_info_id, employee_code, employee_name from em_employee_info where is_delete = 'N' ";
	
	public static final String loadAEmpInfoBySerch = "select employee_info_id, employee_code, employee_name from em_employee_info where is_delete = 'N' and employee_name Like ?  ";
	
	
}
