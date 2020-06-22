package com.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertyFile {

	String configurationFile;

	public ReadPropertyFile(String configFile) {
		
		this.configurationFile = configFile;
	}

	/**
	 * This method is used read property file
	 * 
	 * @param key
	 *            KEY whose value you have to fetch.
	 * @return Return the value of the KEY; if the passed KEY is present in the
	 *         property file else return NULL.
	 * @throws IOException
	 * 
	 */
	
	public String getConfig(String key) {

		ClassLoader classloader=getClass().getClassLoader();
		
		File configfile =new File(classloader.getResource("configurationFile").getFile());
		String path= configfile.getAbsolutePath();
		
		Properties prop = new Properties();

		try {

//			FileInputStream fis = new FileInputStream(
//					"./src/test/resources/TestData/" + configurationFile);
			FileInputStream fis = new FileInputStream(path);
			prop.load(fis);

			return prop.getProperty(key);
		}

		catch (IOException e) {

		}
		return null;

	}

}
