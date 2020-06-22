package com.driver;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import com.utilities.*;

public class Driver {

	protected static ReadPropertyFile readProp;
	protected static String dataSheet;
	protected static JsonUtility jsonUtil = new JsonUtility();
	//protected Header requestHeader = new Header();

	protected static Map<String, String> output = new HashMap<String, String>();

	protected JavaUtility javaUtil = new JavaUtility();

	//File header = new File("./src/test/resources/Config/header.json");

	@BeforeTest
	public void prepareTestData() throws IOException {

		readProp = new ReadPropertyFile("uatConfiguration.properties");

		//System.out.println("ACK>> PRE-FILLING TEST DATA..");

		//TestDataFiller dataFiller = new TestDataFiller();

	//	dataFiller.fillTestDataInJson();

	//	System.out.println("ACK>> TEST DATA PRE-FILLED..");

	}

	@AfterMethod
	public void writeOutput() throws IOException {

		System.out.println("ACK>> WRITTING TEST DATA..\n");

		jsonUtil.writeDataIntoJson(output, "Output");

		System.out.println("ACK>> OUTPUT DATA HAS BEEN WRITTEN..\n");

	}

}
