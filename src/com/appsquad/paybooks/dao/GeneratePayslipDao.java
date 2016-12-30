package com.appsquad.paybooks.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;

import org.zkoss.zul.Messagebox;

import com.appsquad.paybooks.bean.ComponentMasterBean;
import com.appsquad.paybooks.bean.GeneratePayslipBean;
import com.appsquad.paybooks.database.DatabaseHandler;
import com.appsquad.paybooks.database.Pbpstm;
import com.appsquad.paybooks.sql.GeneratePayslipSql;

public class GeneratePayslipDao {

	public static ArrayList<GeneratePayslipBean> loadEmpSalDetails(){
		ArrayList<GeneratePayslipBean> list = new ArrayList<GeneratePayslipBean>();
		if(list.size()>0){
			list.clear();
		}
		int count =0;
		try {
			Connection connection = DatabaseHandler.createConnection();
			PreparedStatement preparedStatement = null;
			ResultSet resultSet = null;
			try {
				preparedStatement = Pbpstm.createQuery(connection, GeneratePayslipSql.loadEmployee, null);
				resultSet = preparedStatement.executeQuery();
				while (resultSet.next()) {
					GeneratePayslipBean bean = new GeneratePayslipBean();
					count = count+1;
					bean.setSlNo(count);
					bean.setCheck(false);
					bean.setEmployeeId(resultSet.getInt("employee_info_id"));
					bean.setEmployeeCode(resultSet.getString("employee_code"));
					bean.setEmployeeName(resultSet.getString("employee_name"));
					bean.setDesignation(resultSet.getString("designation"));
					bean.setEmailId(resultSet.getString("email_id"));
					//bean.setDojStr(resultSet.getString("date_of_joining"));
					bean.setDojStr("31/8/15");
					bean.setComponentList(GeneratePayslipDao.loadComponents(connection, bean.getEmployeeId()));
					
					list.add(bean);
					
				}
			} catch (Exception e) {
				e.printStackTrace();
				Messagebox.show(e.getMessage(), "Error", Messagebox.OK, Messagebox.ERROR);
			}finally{
				if(preparedStatement != null){
					preparedStatement.close();
				}if(resultSet != null){
					resultSet.close();
				}if(connection != null){
					connection.close();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
		
		
	}
	
	public static ArrayList<ComponentMasterBean> loadComponents(Connection connection, int empId){
		ArrayList<ComponentMasterBean> list = new ArrayList<ComponentMasterBean>();
		if(list.size()>0){
			list.clear();
		}
		
		
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = Pbpstm.createQuery(connection, GeneratePayslipSql.loadEmployeeSalaryComponents, Arrays.asList(empId));
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				ComponentMasterBean bean = new ComponentMasterBean();
				bean.setComponentId(resultSet.getInt("salary_components_id"));
				bean.setComponent(resultSet.getString("component_name"));
				bean.setAmount(resultSet.getDouble("amount"));
				bean.seteOrdId(resultSet.getInt("e_or_d_id"));
				
				list.add(bean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	
}
