package com.appsquad.paybooks.model.pdf;

import com.appsquad.paybooks.bean.ComponentMasterBean;
import com.appsquad.paybooks.bean.GeneratePayslipBean;
import com.appsquad.paybooks.model.utils.NumberToWord;
import com.itextpdf.text.Element;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;


public class TableGenerator {
	static PdfPCell cell;
	
	public static PdfPTable createHeaderTable(GeneratePayslipBean headerBean){
		
		float[] widths = {5,12};
		
		PdfPTable table = new PdfPTable(widths);
		
			cell = new PdfPCell();
			table.addCell(cell);
			
			table.addCell(createRHSinnerHeaderTable(headerBean));
		
		return table;
	}
	
	public static PdfPTable createRHSinnerHeaderTable(GeneratePayslipBean headerBean){
	
		PdfPTable table = new PdfPTable(1);
		
		Phrase companyName = new Phrase(headerBean.getCompanyName());
		cell = new PdfPCell(companyName);
		table.addCell(cell);
		
		Phrase companyAddress = new Phrase(headerBean.getCompanyAddress());
		cell = new PdfPCell(companyAddress);
		table.addCell(cell);
		
		Phrase others = new Phrase("Payslip for " + headerBean.getMonth() +"-"+headerBean.getYear());
		cell = new PdfPCell(others);
		table.addCell(cell);
		
		return table;
	}
	
	
	///////////
	public static PdfPTable generateMiddleTable(GeneratePayslipBean bean){
		
		float[] width = {5,1,5,5,1,5};
		PdfPTable table = new PdfPTable(width);
		
		//cell = new PdfPCell();
		table.addCell(generateMiddleTableLeft());
		
		//cell = new PdfPCell();
		table.addCell(createDottTable());
		
		//cell = new PdfPCell();
		table.addCell(generateMiddleTableLeft(bean));
		
		//cell = new PdfPCell();
		table.addCell(generateMiddleTableRight());
		
		//cell = new PdfPCell();
		table.addCell(createDottTable());
		
		//cell = new PdfPCell();
		table.addCell(generateMiddleTableRight(bean));
		
		
		return table;
		
	}
	
	public static PdfPTable generateMiddleTableLeft(){
		
		PdfPTable table = new PdfPTable(1);
		
		Phrase EmployeeName = new Phrase("Employee Name ");
		cell = new PdfPCell(EmployeeName);
		table.addCell(cell);
		
		Phrase EmployeeID = new Phrase("Employee ID ");
		cell = new PdfPCell(EmployeeID);
		table.addCell(cell);
		
		Phrase Designation = new Phrase("Designation ");
		cell = new PdfPCell(Designation);
		table.addCell(cell);
		
		Phrase Department = new Phrase("Department ");
		cell = new PdfPCell(Department);
		table.addCell(cell);
		
		Phrase doj = new Phrase("Date of Joining ");
		cell = new PdfPCell(doj);
		table.addCell(cell);
		
		Phrase ESINumber = new Phrase("ESI Number ");
		cell = new PdfPCell(ESINumber);
		table.addCell(cell);
		
		return table;
	}
	
	public static PdfPTable generateMiddleTableLeft(GeneratePayslipBean empdetBean){
		
		PdfPTable table = new PdfPTable(1);
		
		Phrase EmployeeName = new Phrase("Somnath Dutta");
		cell = new PdfPCell(EmployeeName);
		table.addCell(cell);
		
		Phrase EmployeeID = new Phrase("00008");
		cell = new PdfPCell(EmployeeID);
		table.addCell(cell);
		
		Phrase Designation = new Phrase("Programmer Analyst");
		cell = new PdfPCell(Designation);
		table.addCell(cell);
		
		Phrase Department = new Phrase(" ");
		cell = new PdfPCell(Department);
		table.addCell(cell);
		
		Phrase doj = new Phrase("31/08/2015");
		cell = new PdfPCell(doj);
		table.addCell(cell);
		
		Phrase ESINumber = new Phrase(" ");
		cell = new PdfPCell(ESINumber);
		table.addCell(cell);
		
		return table;
	}
	 
	public static PdfPTable generateMiddleTableRight(){
		
		PdfPTable table = new PdfPTable(1);
		
		Phrase PFNo = new Phrase("PF No ");
		cell = new PdfPCell(PFNo);
		table.addCell(cell);
		
		Phrase uan = new Phrase("UAN ");
		cell = new PdfPCell(uan);
		table.addCell(cell);
		
		Phrase workLocation = new Phrase("Work Location ");
		cell = new PdfPCell(workLocation);
		table.addCell(cell);
		
		Phrase lopDays = new Phrase("LOP Days");
		cell = new PdfPCell(lopDays);
		table.addCell(cell);
		
		Phrase workedDays = new Phrase("Worked Days ");
		cell = new PdfPCell(workedDays);
		table.addCell(cell);
		
		Phrase bankacno = new Phrase("Bank A/c No ");
		cell = new PdfPCell(bankacno);
		table.addCell(cell);
		
		return table;
	}
	
	public static PdfPTable generateMiddleTableRight(GeneratePayslipBean empdetBean){
		
		PdfPTable table = new PdfPTable(1);
		
		Phrase PFNo = new Phrase(" ");
		cell = new PdfPCell(PFNo);
		table.addCell(cell);
		 
		Phrase uan = new Phrase(" ");
		cell = new PdfPCell(uan);
		table.addCell(cell);
		
		Phrase workLocation = new Phrase("Kolkata");
		cell = new PdfPCell(workLocation);
		table.addCell(cell);
		
		Phrase lopDays = new Phrase("0.00");
		cell = new PdfPCell(lopDays);
		table.addCell(cell);
		
		Phrase workedDays = new Phrase("20.0");
		cell = new PdfPCell(workedDays);
		table.addCell(cell);
		
		Phrase bankacno = new Phrase("30724970417");
		cell = new PdfPCell(bankacno);
		table.addCell(cell);
		
		return table;
	}
	
	public static PdfPTable createDottTable(){
		
		PdfPTable table = new PdfPTable(1);
		
		Phrase dot1 = new Phrase(":");
		cell = new PdfPCell(dot1);
		table.addCell(cell);
		 
		Phrase dot2 = new Phrase(":");
		cell = new PdfPCell(dot2);
		table.addCell(cell);
		
		Phrase dot3 = new Phrase(":");
		cell = new PdfPCell(dot3);
		table.addCell(cell);
		
		Phrase dot4 = new Phrase(":");
		cell = new PdfPCell(dot4);
		table.addCell(cell);
		
		Phrase dot5 = new Phrase(":");
		cell = new PdfPCell(dot5);
		table.addCell(cell);
		
		Phrase dot6 = new Phrase(":");
		cell = new PdfPCell(dot6);
		table.addCell(cell);
		
		return table;
	}
	
	////////////////////
	public static PdfPTable gapTable(){
		PdfPTable table = new PdfPTable(1);
		Phrase gap = new Phrase(" ");
		cell = new PdfPCell(gap);
		table.addCell(cell);
		
		return table;
	}
	
	//////////////////Earning and Deduction
	public static PdfPTable earningDeductionLabel(){
		
		float[] width = {4,4,4,4};
		PdfPTable table = new PdfPTable(width);
		
		Phrase earnings = new Phrase("Earnings");
		cell = new PdfPCell(earnings);
		table.addCell(cell);
		
		Phrase earnAmnt = new Phrase("Amount (Rs)");
		cell = new PdfPCell(earnAmnt);
		cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
		table.addCell(cell);
		
		Phrase deductions = new Phrase("Deductions");
		cell = new PdfPCell(deductions);
		table.addCell(cell);
		
		Phrase deductAmnt = new Phrase("Amount (Rs)");
		cell = new PdfPCell(deductAmnt);
		cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
		table.addCell(cell);
		
		
		return table;
	}
	
	////////////Salary Details
	public static PdfPTable generateSalaryTable(GeneratePayslipBean bean){
		
		float[] width = {5,5,5,5};
		PdfPTable table = new PdfPTable(width);
		
		table.addCell(addEarningComponents(bean));
		
		table.addCell(addEarningComponentsAmnt(bean));
		
		table.addCell(addDeductionComponents(bean));
		
		
		table.addCell(addDeductComponentsAmnt(bean));
		
		
		return table;
		
	}
	
	public static PdfPTable addEarningComponents(GeneratePayslipBean earningbean){
		
		PdfPTable table = new PdfPTable(1);
		
		for(ComponentMasterBean bean : earningbean.getComponentList()){
			if(bean.geteOrdId() == 1){
				
			Phrase deductAmnt = new Phrase(bean.getComponent());
			cell = new PdfPCell(deductAmnt);
			table.addCell(cell);
			}
		}
		return table;
	}
	
	public static PdfPTable addEarningComponentsAmnt(GeneratePayslipBean earningbean){
		
		PdfPTable table = new PdfPTable(1);
		for(ComponentMasterBean bean : earningbean.getComponentList()){
			if(bean.geteOrdId() == 1){
			Phrase deductAmnt = new Phrase(""+bean.getAmount());
			cell = new PdfPCell(deductAmnt);
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			table.addCell(cell);
			}
		}
		return table;
	}
	
	public static PdfPTable addDeductionComponents(GeneratePayslipBean earningbean){
		
		PdfPTable table = new PdfPTable(1);
		for(ComponentMasterBean bean : earningbean.getComponentList()){
			if(bean.geteOrdId() == 2){
			Phrase deductAmnt = new Phrase(bean.getComponent());
			cell = new PdfPCell(deductAmnt);
			table.addCell(cell);
			}
		}
		return table;
	}
	
	public static PdfPTable addDeductComponentsAmnt(GeneratePayslipBean earningbean){
		
		PdfPTable table = new PdfPTable(1);
		for(ComponentMasterBean bean : earningbean.getComponentList()){
			if(bean.geteOrdId() == 2){
			Phrase deductAmnt = new Phrase(""+bean.getAmount());
			cell = new PdfPCell(deductAmnt);
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			table.addCell(cell);
			}
		}
		return table;
	} 
	
	////////////////total amount and total deduction
	public static PdfPTable totalAmnt(GeneratePayslipBean bean){
		
		float[] width = {4,4,4,4};
		PdfPTable table = new PdfPTable(width);
		
		Phrase earnings = new Phrase(" ");
		cell = new PdfPCell(earnings);
		table.addCell(cell);
		
		Phrase earnAmnt = new Phrase(""+bean.getTotalEarningAmnt());
		cell = new PdfPCell(earnAmnt);
		cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
		table.addCell(cell);
		
		Phrase deductions = new Phrase(" ");
		cell = new PdfPCell(deductions);
		table.addCell(cell);
		
		Phrase deductAmnt = new Phrase(""+bean.getTotalDeductionAmnt());
		cell = new PdfPCell(deductAmnt);
		cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
		table.addCell(cell);
		
		return table;
		
	}
	
	///////////last table(summary)
	public static PdfPTable lastTable(GeneratePayslipBean bean){
		float[] width = {5,1,12};
		PdfPTable table = new PdfPTable(width);
		
		
		table.addCell(summaryCellCompo());
		
		
		table.addCell(summuryDotCell());
		
		
		table.addCell(summaryCellCompo(bean));
		
		return table;
		
	}
	
	public static PdfPTable summaryCellCompo(){
		PdfPTable table = new PdfPTable(1);
		
		Phrase netpay = new Phrase("Net Pay");
		cell = new PdfPCell(netpay);
		table.addCell(cell);
		
		Phrase amntinwords = new Phrase("Amount in Words");
		cell = new PdfPCell(amntinwords);
		table.addCell(cell);
		
		Phrase ModeofPayment = new Phrase("Mode of Payment");
		cell = new PdfPCell(ModeofPayment);
		table.addCell(cell);
		
		return table;
		
	}
	
	public static PdfPTable summuryDotCell(){

		PdfPTable table = new PdfPTable(1);
		
		Phrase netpaydot = new Phrase(":");
		cell = new PdfPCell(netpaydot);
		table.addCell(cell);
		
		Phrase amntinwordsdot = new Phrase(":");
		cell = new PdfPCell(amntinwordsdot);
		table.addCell(cell);
		
		Phrase ModeofPaymentdot = new Phrase(":");
		cell = new PdfPCell(ModeofPaymentdot);
		table.addCell(cell);
		
		return table;
		
	}
	
	public static PdfPTable summaryCellCompo(GeneratePayslipBean bean){
		PdfPTable table = new PdfPTable(1);
		
		//double netpayment = bean.getTotalEarningAmnt()-bean.getTotalDeductionAmnt();
		double netpayment = 20140.00;
		String amountString = NumberToWord.numToStr(netpayment);
		
		
		Phrase netpay = new Phrase(""+netpayment);
		cell = new PdfPCell(netpay);
		table.addCell(cell);
		
		Phrase amntinwords = new Phrase(amountString);
		cell = new PdfPCell(amntinwords);
		table.addCell(cell);
		
		Phrase ModeofPayment = new Phrase(bean.getTransferMode());
		cell = new PdfPCell(ModeofPayment);
		table.addCell(cell);
		
		return table;
		
	}
	
	
	
	
	
}
