
package com.winway.wwapp2;

import org.json.JSONObject;

public class utilitys {

	private static utilitys instance = null;
	public utilitys(){
		
		//System.out.println("==>"+new Throwable().getStackTrace()[0].getClassName()+" > "+new Throwable().getStackTrace()[0].getMethodName());
		//System.out.println("===>Line number: "+new Throwable().getStackTrace()[0].getLineNumber()); 

		instance=new utilitys();
	}
	public  static utilitys  getInstance(){
		
		
		//System.out.println("==>"+new Throwable().getStackTrace()[0].getClassName()+" > "+new Throwable().getStackTrace()[0].getMethodName());
		//System.out.println("===>Line number: "+new Throwable().getStackTrace()[0].getLineNumber()); 

		return instance;
	}
	public JSONObject httpget(String URL){
		JSONObject test=new JSONObject();
		return test;
	}
	
	
	
}
