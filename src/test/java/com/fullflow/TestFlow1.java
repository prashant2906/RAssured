package com.fullflow;

import java.io.IOException;
import org.testng.annotations.Test;
import com.driver.Driver;
import com.utilities.ExtentReportUtility;
import RelatedApi.API1;
import RelatedApi.API2;

public class TestFlow1 extends Driver{
	
	// The below two lines provides the value of current class name
		String fullClassName = this.getClass().getName();
		String scenarioName = fullClassName.substring(fullClassName.lastIndexOf('.') + 1);
		
	// Calling Extend Reports 
		ExtentReportUtility testReportObj = new ExtentReportUtility(scenarioName);

		
		@Test(priority = 1)
		public void TestCase1() throws IOException {

			testReportObj.logger("Test Case To Refresh ");

			System.out.println("====================================================");
			System.out.println("STEP 1: ==========(DAILY-CACHE-REFRESH)============");
			System.out.println("====================================================");

			API1 ob1 = new API1();

			ob1.test_GetParameters_PAPERLESS_APP_1();

		}
		

		@Test(priority = 2)
		public void TestCase2() throws IOException {

			testReportObj.logger("Test Case To Refresh ");

			System.out.println("====================================================");
			System.out.println("STEP 1: ==========(DAILY-CACHE-REFRESH)============");
			System.out.println("====================================================");

			API2 ob2 = new API2();

			ob2.test_WizardProperties();

		}
}
