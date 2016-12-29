package com.appsquad.paybooks.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Arrays;

import org.zkoss.zul.Messagebox;

import com.appsquad.paybooks.bean.LoginBean;
import com.appsquad.paybooks.database.DatabaseHandler;
import com.appsquad.paybooks.database.Pbpstm;
import com.appsquad.paybooks.sql.LoginSql;

public class LoginDao {

	public static boolean login(LoginBean bean){
		boolean flag = false;
		try {
			
			PreparedStatement preparedStatement = null;
			Connection connection = DatabaseHandler.createConnection();
			ResultSet resultSet = null;
			try {
				preparedStatement = Pbpstm.createQuery(connection, LoginSql.loginSql, Arrays.asList(bean.getUserId(), bean.getPassword()));
				resultSet = preparedStatement.executeQuery();
				if(resultSet.next()){
					flag = true;
				}
			} catch (Exception e) {
				e.printStackTrace();
				Messagebox.show(e.getMessage(), "Error", Messagebox.OK, Messagebox.ERROR);
			}finally{
				if(resultSet != null){
					resultSet.close();
				}
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
		return flag;
	}
	
	
}
