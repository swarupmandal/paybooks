package com.appsquad.paybooks.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Session;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zul.Messagebox;

import com.appsquad.paybooks.bean.GeneratePayslipBean;
import com.appsquad.paybooks.bean.MonthMasterBean;
import com.appsquad.paybooks.dao.LoadAllListDao;
import com.appsquad.paybooks.model.pdf.PayslipGenerator;
import com.appsquad.paybooks.model.service.GeneratePayslipService;
public class GeneratePayslipController {

	
	private MonthMasterBean monthMasterBean = new MonthMasterBean();
	private LoadAllListDao allListDao;
	private GeneratePayslipBean generatePayslipBean = new GeneratePayslipBean();
	private GeneratePayslipBean payslipHeaderBean = new GeneratePayslipBean();
	
	
	private ArrayList<GeneratePayslipBean> generatePayslipBeanList;
	private ArrayList<MonthMasterBean> monthist;
	
	private Session session = null;

	private String userId;
	
	
	@AfterCompose
	public void initSetup(@ContextParam(ContextType.VIEW) Component view)
			throws Exception {

		Selectors.wireComponents(view, this, false);

		session = Sessions.getCurrent();
		userId = (String) session.getAttribute("userId");
		allListDao = new LoadAllListDao();
		monthist = allListDao.loadmonths();
		
		generatePayslipBeanList = GeneratePayslipService.loadempSalDetails();
	}


	@Command
	@NotifyChange("*")
	public void onClickDetails(@BindingParam("bean") GeneratePayslipBean bean){
		System.out.println("EM -- >>> >> > " + bean.getEmployeeName());
	}
	
	
	
	@Command
	@NotifyChange("*")
	public void onCLickGeneratePayslip(){
		boolean checked = false;
		ArrayList<GeneratePayslipBean> checkedList = new ArrayList<GeneratePayslipBean>();
		for(GeneratePayslipBean bean : generatePayslipBeanList){
			if(bean.isCheck() && bean.getPresentDays() != null){
				checkedList.add(bean);
			}
		}
		
		if(checkedList.size()>0){
			payslipHeaderBean.setCompanyName("Appsquad Pvt. Ltd");
			payslipHeaderBean.setCompanyAddress("Martin Burn Ispace, Second Floor, Unit 2C1 Kolkata - 700156");
			payslipHeaderBean.setMonth(monthMasterBean.getMonth());
			payslipHeaderBean.setMonthId(monthMasterBean.getMonthId());
			payslipHeaderBean.setYear("2016");
			
			String path = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/");
			PayslipGenerator payslipGenerator = new PayslipGenerator();
			try {
				payslipGenerator.getSlipDetails(path, checkedList, payslipHeaderBean);
			
			} catch (Exception e) {
				
				e.printStackTrace();
			}
		}else {
			Messagebox.show("Please check at least one","Alert Information",Messagebox.OK,Messagebox.EXCLAMATION);
		}
	}
	
	
	/*Calendar now = Calendar.getInstance();
	int year = now.get(Calendar.YEAR);
	String yearInString = String.valueOf(year);
	
	 Calendar cal = Calendar.getInstance();
	 System.out.println(new SimpleDateFormat("MMM").format(cal.getTime()));
	
	*/
	
	
	public MonthMasterBean getMonthMasterBean() {
		return monthMasterBean;
	}


	public void setMonthMasterBean(MonthMasterBean monthMasterBean) {
		this.monthMasterBean = monthMasterBean;
	}


	public LoadAllListDao getAllListDao() {
		return allListDao;
	}


	public void setAllListDao(LoadAllListDao allListDao) {
		this.allListDao = allListDao;
	}


	public ArrayList<MonthMasterBean> getMonthist() {
		return monthist;
	}


	public void setMonthist(ArrayList<MonthMasterBean> monthist) {
		this.monthist = monthist;
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


	public GeneratePayslipBean getGeneratePayslipBean() {
		return generatePayslipBean;
	}


	public void setGeneratePayslipBean(GeneratePayslipBean generatePayslipBean) {
		this.generatePayslipBean = generatePayslipBean;
	}


	public ArrayList<GeneratePayslipBean> getGeneratePayslipBeanList() {
		return generatePayslipBeanList;
	}


	public void setGeneratePayslipBeanList(
			ArrayList<GeneratePayslipBean> generatePayslipBeanList) {
		this.generatePayslipBeanList = generatePayslipBeanList;
	}


	public GeneratePayslipBean getPayslipHeaderBean() {
		return payslipHeaderBean;
	}


	public void setPayslipHeaderBean(GeneratePayslipBean payslipHeaderBean) {
		this.payslipHeaderBean = payslipHeaderBean;
	}
	
}
