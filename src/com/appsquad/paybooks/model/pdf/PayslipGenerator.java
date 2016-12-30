package com.appsquad.paybooks.model.pdf;

import java.io.FileOutputStream;
import java.util.ArrayList;

import com.appsquad.paybooks.bean.GeneratePayslipBean;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfWriter;

public class PayslipGenerator {
	private String filePath;
	private Document document = null;
	private PdfWriter writer = null;
	
	public void getSlipDetails(String path, ArrayList<GeneratePayslipBean> employeePayBeanList,
			GeneratePayslipBean headerBean) throws Exception, DocumentException{
		
		filePath = path+"paySlip.pdf";
		System.out.println("My file path :: "+filePath);
		
		for(GeneratePayslipBean bean : employeePayBeanList){
			
			document = new Document(PageSize.A4, 2, 5, 30, 50);
			writer = PdfWriter.getInstance(document, new FileOutputStream(filePath));
			writer.setBoxSize("art", new Rectangle(36, 54, 900, 850));
			
			document.open();
			document.add(TableGenerator.createHeaderTable(headerBean));  // header table
			document.add(TableGenerator.gapTable());                     // gap between header and middle table
			document.add(TableGenerator.generateMiddleTable(headerBean));// middle table (employee details)  bean will be changed
			document.add(TableGenerator.gapTable());                     // gap between middle and salary table
			document.add(TableGenerator.earningDeductionLabel());        // earning and deduction label
			document.add(TableGenerator.generateSalaryTable(bean));		 // salary table bean will be from list
			document.add(TableGenerator.totalAmnt(bean));          		 // total amount earning and deduction
			document.add(TableGenerator.lastTable(headerBean));			 // last table(summary)
			document.add(TableGenerator.gapTable());                     // gap between middle and salary table
			document.add(TableGenerator.digitalStatment());				 // digital signature
			
			document.close();
		}
		//DownloadPdf.download(path, "payslip");
	}
	
}
