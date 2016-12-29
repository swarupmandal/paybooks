package com.appsquad.paybooks.controller;

import java.util.ArrayList;

import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Session;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zul.Messagebox;

import com.appsquad.paybooks.bean.EmployeeMasterBean;
import com.appsquad.paybooks.model.service.EmployeeMasterService;

public class EmployeeMasterController {
	
	private EmployeeMasterBean employeeMasterBean = new EmployeeMasterBean();
	private EmployeeMasterBean existiingEmployeeMasterBean = new EmployeeMasterBean();
	
	
	private ArrayList<EmployeeMasterBean> employeeMasterBeanList = new ArrayList<EmployeeMasterBean>();
	
	Session session = null;

	private String userId;
	
	private Integer roleId;
	
	@AfterCompose
	public void initSetup(@ContextParam(ContextType.VIEW) Component view)
			throws Exception {

		Selectors.wireComponents(view, this, false);

		session = Sessions.getCurrent();
		userId = (String) session.getAttribute("userId");
		employeeMasterBeanList = EmployeeMasterService.loadEmpInfo();

	}

	@Command
	@NotifyChange("*")
	public void onClickSave(){
		int i =0;
		if(EmployeeMasterService.onEmpInfoValidation(employeeMasterBean)){
		i = EmployeeMasterService.employeeInfo(userId, employeeMasterBean);
		if(i>0){
			Messagebox.show("Saved Successfully", "Information", Messagebox.OK, Messagebox.INFORMATION);
			EmployeeMasterService.onEmpInfoClear(employeeMasterBean);
			employeeMasterBeanList = EmployeeMasterService.loadEmpInfo();
		}
		}
	}
	
	@Command
	@NotifyChange("*")
	public void onClickUpdate(@BindingParam("bean") EmployeeMasterBean bean){
		
	}
	
	
	
	
	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}







	public EmployeeMasterBean getEmployeeMasterBean() {
		return employeeMasterBean;
	}







	public void setEmployeeMasterBean(EmployeeMasterBean employeeMasterBean) {
		this.employeeMasterBean = employeeMasterBean;
	}

	public EmployeeMasterBean getExistiingEmployeeMasterBean() {
		return existiingEmployeeMasterBean;
	}

	public void setExistiingEmployeeMasterBean(
			EmployeeMasterBean existiingEmployeeMasterBean) {
		this.existiingEmployeeMasterBean = existiingEmployeeMasterBean;
	}

	public ArrayList<EmployeeMasterBean> getEmployeeMasterBeanList() {
		return employeeMasterBeanList;
	}

	public void setEmployeeMasterBeanList(
			ArrayList<EmployeeMasterBean> employeeMasterBeanList) {
		this.employeeMasterBeanList = employeeMasterBeanList;
	}
	

}
