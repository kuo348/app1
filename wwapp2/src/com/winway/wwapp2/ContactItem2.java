package com.winway.wwapp2;

public class ContactItem2 {
	
	private String ta_oce01;
	private String  oce03;
	
	public ContactItem2(){
		
		
   		
	}

	public ContactItem2(String name,String index){
		this.ta_oce01=name;
		if(this.ta_oce01==" "||this.ta_oce01.trim()==""){
			 this.ta_oce01="NA";
		}
		this.oce03 = index;
	}
	public String getName(){
		   		
		return this.ta_oce01;
	}
	public void setName(String name){
   		
		this.ta_oce01=name;
	}
	public String getIndex(){
   		
		return this.oce03;
	}
	public void setIndex(String index){
   		
		this.oce03=index;
	}
}
