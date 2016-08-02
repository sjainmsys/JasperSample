package com.jaspersample;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRXlsExporter;

public class JasperReportFill {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		//enter the path of complied jasper report template
		String sourceFileName = "c://Shritek/jasper_report_template.jasper";
	    	         
		String printFileName = null;
		DataBeanList DataBeanList = new DataBeanList();
		ArrayList<DataBean> dataList = DataBeanList.getDataBeanList();
		JRBeanCollectionDataSource beanColDataSource =
				new JRBeanCollectionDataSource(dataList);

		Map parameters = new HashMap();
		try 
		{
			printFileName = JasperFillManager.fillReportToFile(sourceFileName,
            parameters, beanColDataSource);
			if (printFileName != null) 
			{
				/**
				 * 1- export to PDF
				 */
				JasperExportManager.exportReportToPdfFile(printFileName,
	               "C://Shritek/sample_report.pdf");


				/**
				 * 2- export to Excel sheet
				 */
				JRXlsExporter exporter = new JRXlsExporter();

				exporter.setParameter(JRExporterParameter.INPUT_FILE_NAME,
						printFileName);
				exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME,
						"C://Shritek/sample_report.xls");

				exporter.exportReport();
			}
		} catch (JRException e) 
		  {
				e.printStackTrace();
	      }
	}
}
