package com.appsquad.paybooks.model.service;

import java.util.ArrayList;

import org.zkoss.zul.Messagebox;

import com.appsquad.paybooks.bean.EmployeeMasterBean;
import com.appsquad.paybooks.dao.EmployeeMasterDao;

public class EmployeeMasterService {

	public static int employeeInfo(String userName, EmployeeMasterBean bean){
		int i= 0;
		i = EmployeeMasterDao.saveEmployeeInfo(userName, bean);
		return i;
	}
	
	public static ArrayList<EmployeeMasterBean> loadEmpInfo(){
		ArrayList<EmployeeMasterBean> list = new ArrayList<EmployeeMasterBean>();
		list = EmployeeMasterDao.loadEmployeeInfo();
		return list;
	}
	
	
	
	
	
	
	
	
	
	
	public static boolean onEmpInfoValidation(EmployeeMasterBean bean){
		if(bean.getEmployeeCode() != null && bean.getEmployeeCode().trim().length()>0){
			if(bean.getEmployeeName() != null){
					return true;
				}else {
					Messagebox.show("Enter Employee Name", "Alert", Messagebox.OK, Messagebox.EXCLAMATION);return false;
				}
			}else {
		 Messagebox.show("Enter Employee Code", "Alert", Messagebox.OK, Messagebox.EXCLAMATION);return false;
			
		}
	}
	
	public static void onEmpInfoClear(EmployeeMasterBean bean){
		bean.setEmployeeCode(null);
		bean.setEmployeeName(null);
	}
	
	
}
