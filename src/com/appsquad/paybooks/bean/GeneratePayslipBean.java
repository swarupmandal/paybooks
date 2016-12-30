package com.appsquad.paybooks.bean;

import java.util.ArrayList;
import java.util.Date;

public class GeneratePayslipBean {

	private Integer slNo;
	private boolean check;
	private Integer employeeId;
	private String employeeCode;
	private String employeeName;
	private String designation;
	private String emailId;
	
	private Date dojutil;
	private java.sql.Date dojSql;
	private String dojStr;
	
	private Integer presentDays;
	
	private Integer monthId;
	private String month;
	private String year;
	
	private String companyName;
	private String companyAddress;
	
	
	
	private ArrayList<ComponentMasterBean> componentList = new ArrayList<ComponentMasterBean>();
	
	
	public boolean isCheck() {
		return check;
	}
	public void setCheck(boolean check) {
		this.check = check;
	}
	public Integer getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeCode() {
		return employeeCode;
	}
	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public Integer getSlNo() {
		return slNo;
	}
	public void setSlNo(Integer slNo) {
		this.slNo = slNo;
	}
	public Integer getPresentDays() {
		return presentDays;
	}
	public void setPresentDays(Integer presentDays) {
		this.presentDays = presentDays;
	}
	public ArrayList<ComponentMasterBean> getComponentList() {
		return componentList;
	}
	public void setComponentList(ArrayList<ComponentMasterBean> componentList) {
		this.componentList = componentList;
	}
	public Integer getMonthId() {
		return monthId;
	}
	public void setMonthId(Integer monthId) {
		this.monthId = monthId;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getCompanyAddress() {
		return companyAddress;
	}
	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public Date getDojutil() {
		return dojutil;
	}
	public void setDojutil(Date dojutil) {
		this.dojutil = dojutil;
	}
	public java.sql.Date getDojSql() {
		return dojSql;
	}
	public void setDojSql(java.sql.Date dojSql) {
		this.dojSql = dojSql;
	}
	public String getDojStr() {
		return dojStr;
	}
	public void setDojStr(String dojStr) {
		this.dojStr = dojStr;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	
	
	
}
