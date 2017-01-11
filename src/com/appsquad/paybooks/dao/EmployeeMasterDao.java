package com.appsquad.paybooks.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;

import org.zkoss.zul.Messagebox;

import com.appsquad.paybooks.bean.EmployeeMasterBean;
import com.appsquad.paybooks.database.DatabaseHandler;
import com.appsquad.paybooks.database.Pbpstm;
import com.appsquad.paybooks.sql.EmployeeMasterSql;

public class EmployeeMasterDao {

	public static int saveEmployeeInfo(String userName, EmployeeMasterBean bean){
		int id =0;
		
		try {
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			try {
				connection = DatabaseHandler.createConnection();
				connection.setAutoCommit(false);
				preparedStatement = Pbpstm.createQuery(connection, EmployeeMasterSql.employeeinsertsql, Arrays.asList(bean.getEmployeeCode().trim(), bean.getEmployeeName().trim(), 
																															userName, userName));
				id = preparedStatement.executeUpdate();
				connection.commit();
			} catch (Exception e) {
				e.printStackTrace();
				if(e.getMessage().startsWith("ERROR: duplicate key")){
					Messagebox.show("["+bean.getEmployeeCode()+"] Already Exist" , "Error", Messagebox.OK, Messagebox.ERROR);
				}else {
					Messagebox.show(e.getMessage(), "Error", Messagebox.OK, Messagebox.ERROR);
				}
				connection.rollback();
			}finally{
				if(preparedStatement != null){
					preparedStatement.close();
				}
				if(connection != null){
					connection.close();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return id;
	}
	
	public static ArrayList<EmployeeMasterBean> loadEmployeeInfo(){
		int count = 0;
		ArrayList<EmployeeMasterBean> list = new ArrayList<EmployeeMasterBean>();
		if(list.size()>0){
			list.clear();
		}
		
		try {
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			ResultSet resultSet = null;
			try {
				connection = DatabaseHandler.createConnection();
				preparedStatement = Pbpstm.createQuery(connection, EmployeeMasterSql.loadEmployeeInfosql, null);
				resultSet = preparedStatement.executeQuery();
				while (resultSet.next()) {
					EmployeeMasterBean bean = new EmployeeMasterBean();
					count = count+1;
					bean.setSlNo(count);
					bean.setEmployeeId(resultSet.getInt("employee_info_id"));
					bean.setEmployeeCode(resultSet.getString("employee_code"));
					bean.setEmployeeName(resultSet.getString("employee_name"));
					
					if(resultSet.getString("is_delete").equalsIgnoreCase("N")){
						bean.setCurentEmployee("YES");
					}else {
						bean.setCurentEmployee("NO");
					}
					list.add(bean);
				}
			} catch (Exception e) {
				e.printStackTrace();
				Messagebox.show(e.getMessage(), "Error", Messagebox.OK, Messagebox.ERROR);
				
			}finally{
				if(preparedStatement != null){
					preparedStatement.close();
				}
				if(connection != null){
					connection.close();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
}
