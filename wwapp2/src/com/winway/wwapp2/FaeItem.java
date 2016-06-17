package com.winway.wwapp2;
public class FaeItem {
	
	private String fae001;
	private String fae006;
	private String fae012;
	private String fae022;
	private int icon;
	public FaeItem(){}

	public FaeItem(String fae001,String fae006,String fae012,String fae022,int icon){
	
		//System.out.println("==>"+new Throwable().getStackTrace()[0].getClassName()+" > "+new Throwable().getStackTrace()[0].getMethodName());
		//System.out.println("===>Line number: "+new Throwable().getStackTrace()[0].getLineNumber()); 
		
	this.fae001=fae001;
	this.fae006=fae006;
	this.fae012=fae012;
	this.fae022=fae022;
	this.icon = icon;
	}
	
	public String getFAE001(){
		return this.fae001;
	}
	public String getFAE006(){
		return this.fae006;
	}
	public String getFAE012(){
		return this.fae012;
	}
	public String getFAE022(){
		return this.fae022;
	}
    public int getIcon()
	{
	   return this.icon;
	}
	public void setFAE001(String value){
		this.fae001=value;
	}
    public void setFAE006(String value){
		this.fae006=value;
	}
	public void setFAE012(String value){
		this.fae012=value;
	}
	public void setFAE022(String value){
		this.fae022=value;
	}
	public void setIcon(int value){
		this.icon=value;
	}
}
