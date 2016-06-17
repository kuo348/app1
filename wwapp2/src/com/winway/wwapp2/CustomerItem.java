package com.winway.wwapp2;
public class CustomerItem {	
	public CustomerItem(){}
	private String occ01;
	private String occ02;
	private String occ03;
	private String occ18;
	private String occ261;
	private String occud04;
	private String ta_gen01;
	public CustomerItem(String occ01,String occ02,String occ03,String occ18,String occ261,String occud04,String ta_gen01)
	{
		this.occ01  = occ01;
		this.occ02  = occ02;
		this.occ03  = occ03;		
		this.occ18  = occ18;
        this.occ261 = occ261;
		this.occud04= occud04;		
		this.ta_gen01=ta_gen01;	
	}
	
	public String getCustId(){
		return this.occ01;
	}
	public String getShortName(){
		return this.occ02;
	}
	public String getCategory(){
		return this.occ03;
	}
	public String getFullName()
	{
		return this.occ18;
	}
	public String getTel()
	{
		return this.occ261;
	}
	public String getEmail()
	{
		return this.occud04;
	}
	public String getContact()
	{
		return this.ta_gen01;
		
	}
	
	public void setCustId(String value)
	{
	     this.occ01=value;
	}
	public void setShortName(String value){
		 this.occ02=value;
	}
	public void setCategory(String value)
	{
		 this.occ03=value;
	}
	public void setFullName(String value)
	{
		 this.occ18=value;
	}
	public void setTel(String value)
	{
		this.occ261=value;
	}
	public void setEmail(String value)
	{
		this.occud04=value;
	}
	public void setContact(String value)
	{
	   this.ta_gen01=value;		
	}
}