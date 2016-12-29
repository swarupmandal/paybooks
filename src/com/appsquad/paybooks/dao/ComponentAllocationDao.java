package com.appsquad.paybooks.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;

import org.zkoss.zul.Messagebox;

import com.appsquad.paybooks.bean.ComponentMasterBean;
import com.appsquad.paybooks.database.DatabaseHandler;
import com.appsquad.paybooks.database.Pbpstm;
import com.appsquad.paybooks.sql.ComponentAllocationSql;

public class ComponentAllocationDao {

	public static ArrayList<ComponentMasterBean> loadComponent(int empId){
		ArrayList<ComponentMasterBean> list = new ArrayList<ComponentMasterBean>();
		if(list.size()>0){
			list.clear();
		}
		int count = 0;
		try {
			Connection connection = DatabaseHandler.createConnection();
			PreparedStatement preparedStatement = null;
			ResultSet resultSet = null;
			try {
				preparedStatement = Pbpstm.createQuery(connection, ComponentAllocationSql.loadSalaryComponentresectiveemployee, Arrays.asList(empId));
				resultSet = preparedStatement.executeQuery();
				while (resultSet.next()) {
					ComponentMasterBean bean = new ComponentMasterBean();
					count = count+1;
					bean.setSlNo(count);
					bean.setComponentId(resultSet.getInt("salary_components_id"));
					bean.setComponent(resultSet.getString("component_name"));
					bean.setChecked(false);
					
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
	
	public static boolean saveComonentwithEmployee(String userName ,ArrayList<ComponentMasterBean> list, Integer empId){
		boolean flag=false;
		try {
			Connection connection = DatabaseHandler.createConnection();
			PreparedStatement preparedStatement = null;
			try {
			preparedStatement = connection.prepareStatement(ComponentAllocationSql.insertComponentwithEmp);
			for(ComponentMasterBean bean: list){
				
				preparedStatement.setInt(1, empId);
				preparedStatement.setInt(2, bean.getComponentId());
				preparedStatement.setDouble(3, bean.getAmount());
				preparedStatement.setString(4, userName);
				preparedStatement.setString(5, userName);
				
				preparedStatement.addBatch();
				
			}
			int[] count = preparedStatement.executeBatch(); 
			if(count.length>0){
				flag = true; 
			}

			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	
	
}
