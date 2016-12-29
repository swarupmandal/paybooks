package com.appsquad.paybooks.model.service;

import java.util.ArrayList;

import com.appsquad.paybooks.bean.EmployeeMasterBean;
import com.appsquad.paybooks.dao.LoadAllListDao;

public class LoadAllListService {

	public ArrayList<EmployeeMasterBean> loadEmployeeInfo(){
		ArrayList<EmployeeMasterBean> list =new ArrayList<EmployeeMasterBean>();
		
		LoadAllListDao allListDao = new LoadAllListDao();
		list = allListDao.loadActiveEmployeeInfo();
		
		return list;
	}
	
	public ArrayList<EmployeeMasterBean> loadActvEmployeeInfoSearch(String name){
		ArrayList<EmployeeMasterBean> list =new ArrayList<EmployeeMasterBean>();
		
		LoadAllListDao allListDao = new LoadAllListDao();
		list = allListDao.loadActiveEmployeeInfoSearch(name);
		
		return list;
	}
	
	
}
