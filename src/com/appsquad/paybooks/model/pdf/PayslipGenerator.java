package com.appsquad.paybooks.model.pdf;

import java.io.FileOutputStream;
import java.util.ArrayList;

import com.appsquad.paybooks.bean.GeneratePayslipBean;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfWriter;

public class PayslipGenerator {
	private String filePath;
	private Document document = null;
	private PdfWriter writer = null;
	
	Font normalFont = new Font(Font.FontFamily.HELVETICA, 10.7f, Font.NORMAL);
	Font earnDeductionLabelboldFont = new Font(Font.FontFamily.HELVETICA, 10, Font.BOLD);
	int tableoutLineWidth = 94;
	int cellpadding = 2;
	
	public void getSlipDetails(String path, ArrayList<GeneratePayslipBean> employeePayBeanList,
			GeneratePayslipBean headerBean) throws Exception, DocumentException{
		
		filePath = path+"paySlip.pdf";
		System.out.println("My file path :: "+filePath);
		
		for(GeneratePayslipBean bean : employeePayBeanList){
			
			document = new Document(PageSize.A4, 1, 1, 40, 50);
			writer = PdfWriter.getInstance(document, new FileOutputStream(filePath));
			writer.setBoxSize("art", new Rectangle(40, 58, 900, 850));
			
			document.open();
			document.add(TestTableGenerator.createHeaderTable(headerBean, tableoutLineWidth));  								// header table
			document.add(TestTableGenerator.gapTable(tableoutLineWidth));                     									// gap between header and middle table
			document.add(TestTableGenerator.generateMiddleTable(bean, tableoutLineWidth, normalFont, cellpadding));				// middle table (employee details)  bean will be changed
			document.add(TestTableGenerator.gapTable(tableoutLineWidth));                     									// gap between middle and salary table
			document.add(TestTableGenerator.earningDeductionLabel(earnDeductionLabelboldFont, tableoutLineWidth, cellpadding)); // earning and deduction label
			document.add(TestTableGenerator.generateSalaryTable(bean, tableoutLineWidth,normalFont, cellpadding ));		 		// salary table bean will be from list
			document.add(TestTableGenerator.totalAmnt(bean, earnDeductionLabelboldFont, tableoutLineWidth, cellpadding));       // total amount earning and deduction
			document.add(TestTableGenerator.lastTable(bean, earnDeductionLabelboldFont, tableoutLineWidth, cellpadding));		// last table(summary)
			document.add(TestTableGenerator.gapTable(tableoutLineWidth));                     									// gap between middle and salary table
			document.add(TestTableGenerator.digitalStatment(tableoutLineWidth));				 								// digital signature
			
			document.close();
			DownloadPdf.download(filePath, bean.getEmployeeName());
			
		}
		
	}
	
}
