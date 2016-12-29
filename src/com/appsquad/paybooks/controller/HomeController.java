package com.appsquad.paybooks.controller;


import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Session;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.select.Selectors;

public class HomeController {

	Session session = null;

	private String userId;
	
	private Integer roleId;
	
	@AfterCompose
	public void initSetup(@ContextParam(ContextType.VIEW) Component view)
			throws Exception {

		Selectors.wireComponents(view, this, false);

		session = Sessions.getCurrent();
		userId = (String) session.getAttribute("userId");
		userId = "Welcome " + userId;

	}

	
	@Command
	@NotifyChange("*")
	public void onClickChangePassword(){
		
	}
	
	@Command
	@NotifyChange("*")
	public void onClickLogout(){
		System.out.println("Signiing out...");
		if(session!=null){
			session.removeAttribute("userId");
			session=null;
			Executions.sendRedirect("/welcome.zul");
			System.out.println("--- -- - >>> >> >");
		}
	}
	
	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	
}
