package com.winway.wwapp2;

public class PackageItem {
	
	private String packageType;
	
	public PackageItem(){}

	public PackageItem (String packageType){
		
		//System.out.println("==>"+new Throwable().getStackTrace()[0].getClassName()+" > "+new Throwable().getStackTrace()[0].getMethodName());
	  	//System.out.println("===>Line number: "+new Throwable().getStackTrace()[0].getLineNumber()); 

		this.packageType  = packageType;

		
	}
	
	
	public String getPackage(){
		
		//System.out.println("==>"+new Throwable().getStackTrace()[0].getClassName()+" > "+new Throwable().getStackTrace()[0].getMethodName());
	  	//System.out.println("===>Line number: "+new Throwable().getStackTrace()[0].getLineNumber()); 

		return this.packageType;
	}

	public void setPackage(String packageType){
		
		//System.out.println("==>"+new Throwable().getStackTrace()[0].getClassName()+" > "+new Throwable().getStackTrace()[0].getMethodName());
	  	//System.out.println("===>Line number: "+new Throwable().getStackTrace()[0].getLineNumber()); 

		this.packageType=packageType;
	}

	
	

}