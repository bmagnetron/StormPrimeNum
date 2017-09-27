package com.storm.json;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class jsontest {
	
	
	public void jsonConvert()
	{
			
	ObjectMapper mapper = new ObjectMapper();
	String jsonInString = "'{'name' : 'mkyong'}'";

	// JSON from file to Object
	// GAPI_JSON obj = mapper.readValue(new File("c:\\file.json"),
	// GAPI_JSON.class);

	// JSON from URL to Object
	
	// JSON from String to Object
	try
	{
		 GAPI_JSON obj = mapper.readValue(new URL("https://finance.google.com/finance/info?client=ig&q=NSE:INFY"),GAPI_JSON.class);
		 System.out.println(obj.toString());
	//	GAPI_JSON obj = mapper.readValue(jsonInString, GAPI_JSON.class);
	}catch(	IOException e)
	{
		e.printStackTrace();
	}
	}
	public static void main(String args[])
	{
		jsontest jt = new jsontest();
		//GAPI_JSON  gj = new GAPI_JSON();
		jt.jsonConvert();
		
	}
	
}


