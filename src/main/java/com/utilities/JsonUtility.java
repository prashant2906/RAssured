package com.utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import org.apache.commons.collections4.map.HashedMap;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class JsonUtility {

	String path = "./src/test/resources/TestData/";
	JSONParser parser = new JSONParser();

	ObjectMapper mapper = new ObjectMapper();
	Map<String,String> map=new HashedMap<String, String>();
	
	// Creating Json using HashMap
	public void writeDataIntoJson(Map<String, String> inputData, String fileName) {

		
		/**
		 * Convert Map to JSON and write to a file
		 */
		try {
			mapper.writeValue(new File(path + fileName + ".json"), inputData);

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	public String readDataFromTheJson(String key, String fileName) {

		String value = null;

		try {
			Object obj = null;
			try {
			//	map=	mapper.readValue(new FileReader(path + fileName + ".json"),new TypeReference<Map<String,Object>>(){});
				obj = parser.parse(new FileReader(path + fileName + ".json"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//value =map.get(key);
			JSONObject jsonObject = (JSONObject) obj;

			value = (String) jsonObject.get(key);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return value;
	}
 
	public static String ReadEntireJson(String path) throws IOException
	{
		return new String( Files.readAllBytes(Paths.get(path)));
		
	}
	
	public static JsonPath rawToJSON(Response r)
	{
		String response=r.asString();
		JsonPath jp=new JsonPath(response);
		return jp;
	}
}
