package com.appsquad.paybooks.model.service;

import java.util.ArrayList;

import com.appsquad.paybooks.bean.GeneratePayslipBean;
import com.appsquad.paybooks.dao.GeneratePayslipDao;

public class GeneratePayslipService {

	public static ArrayList<GeneratePayslipBean> loadempSalDetails(){
		ArrayList<GeneratePayslipBean> list = new ArrayList<GeneratePayslipBean>();
		list = GeneratePayslipDao.loadEmpSalDetails();
		return list;
	}
	
}
