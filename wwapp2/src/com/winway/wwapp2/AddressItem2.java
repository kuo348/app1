package com.winway.wwapp2;

public class AddressItem2 {
	private String address;
	private String ocd02;
	public AddressItem2(){}

	public AddressItem2(String  address,String index,String id){
		this.address  = address;		
		if(address.equals(" ") ||address.trim()==""){
			this.address="NA";
		}
		this.ocd02=index;
	}
	public String getAddress(){
		return this.address;
	}
	public void setAddress(String address){
		this.address = address;
	}
	public String getIndex(){
		return this.ocd02;
	}
	public void setIndex(String index){
		this.ocd02 = index;
	}
}
