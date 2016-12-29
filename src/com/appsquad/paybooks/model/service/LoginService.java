package com.appsquad.paybooks.model.service;

import org.zkoss.zul.Messagebox;

import com.appsquad.paybooks.bean.LoginBean;
import com.appsquad.paybooks.dao.LoginDao;

public class LoginService {

	public static boolean loginServ(LoginBean bean){
		boolean flag = false;
		flag = LoginDao.login(bean);
		return flag;
	}
	
	
	
	
	public static boolean loginValidation(LoginBean bean){
		if(bean.getUserId() != null){
			if(bean.getPassword() != null){
				return true;	
			}else {
				Messagebox.show("Enter Password", "Alert", Messagebox.OK, Messagebox.EXCLAMATION);
				return false;
			}
		}else {
			Messagebox.show("Enter Userid", "Alert", Messagebox.OK, Messagebox.EXCLAMATION);
			return false;
		}
		
	}
	
	
}
