package com.storm.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class TestRun {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("testBeans.xml");
	//	testPrototype ts = (testPrototype) context.getBean("testPrototype");
	//	ts.create();
		
	/*	StaticLoadTableDetails ts1 = (StaticLoadTableDetails) context.getBean("loadtable");
		StaticLoadTableDetails.readfiles();
		StaticLoadTableDetails.populateTable();
		
		System.out.println(StaticLoadTableDetails.getMapping("INFY_Google"));
		System.out.println(StaticLoadTableDetails.getMapping("hdfc_yahoo"));*/
		
		
		LoadTableDetails ts = (LoadTableDetails) context.getBean("loadtable");
		ts.readfiles();
		ts.populateTable();
		
		System.out.println(ts.getMapping("IND_Google"));
		System.out.println(ts.getMapping("IND_NSE"));
	//	System.out.println(ts.getMapping("hdfc_yahoo"));
		
	/*	Proto pt = (Proto) context.getBean("Proto");
		pt.CreateProto();*/
		
	}

}
