package com.appsquad.paybooks.sql;

public class ComponentAllocationSql {

	public static final String loadSalaryComponentresectiveemployee = "select salary_components_id, component_name from em_salary_component_master "
																	  + " where is_delete = 'N' and salary_components_id not in(select salary_components_id from em_component_allocation where employee_info_id = ?) ";
	
	
	public static final String insertComponentwithEmp = "insert into em_component_allocation (employee_info_id, salary_components_id, amount, created_by, updated_by) values(?,?,?,?,?) ";
	
	
}
