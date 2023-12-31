package shoppingsite.resources;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportsNG {

	
	public static ExtentReports getReportsObject() {

		String extent1 = System.getProperty("user.dir") + "//reports//index.html";
		ExtentSparkReporter extentsp = new ExtentSparkReporter(extent1);
		extentsp.config().setReportName("WebAutomtionREesults");
		extentsp.config().setDocumentTitle("Test Results Hehe");
		
		ExtentReports exreports = new ExtentReports();
		exreports.attachReporter(extentsp);
		exreports.setSystemInfo("tester", "Satya");
		
		return  exreports;
		
	}

}
