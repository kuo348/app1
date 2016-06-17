package com.winway.wwapp2;

public class SoItem {
	
	private String sp01,sp02,sp03,sp04,sp05,sp06,sp07,sp08,sp09,sp10,sp11;
	public SoItem(){}

	public SoItem(String shippingNote,String orderType,String customerName,
			String salesName,String soNo,String shippingDate,
			String sp07,String productType,String qty,String partNo,String sp11 ){	
		this.sp01  = shippingNote;
		this.sp02  = orderType;
		this.sp03  = customerName;
		this.sp04  = salesName;
		this.sp05  = soNo;
		this.sp06  = shippingDate;
		this.sp07  = sp07;
		this.sp08  = productType;
		this.sp09  = qty;
		this.sp10  = partNo;
		this.sp11  = sp11;
	}
	
	public String getShippingNote(){
		return this.sp01;
	}
	public void setShippingNote(String value){
		this.sp01=value;
	}
	public String getOrderType(){
        return this.sp02;
	}
	public void setOrderType(String value){
         this.sp02=value;
	}
	public String getCustomerName(){
        return this.sp03;
	}
	public void setCustomerName(String value){
	      this.sp03 = value;
	}
	public String getSalesName(){
        return this.sp04;
	}
	public void setSalesName(String value){
	      this.sp04 = value;
	}
	public String getSoNo(){
        return this.sp05;
	}
	public void setSoNo(String value){
	      this.sp05 = value;
	}
	public String getShippingDate(){
        return this.sp06;
	}
	public void setShippingDate(String value){
	      this.sp06 = value;
	}
	public String getSP07(){
        return this.sp07;
	}
	public void setSP07(String value){
	      this.sp07 = value;
	}
	public String getProductType(){
        return this.sp08;
	}
	public void setProductType(String value){
	      this.sp08 = value;
	}
	public String getQty(){
        return this.sp09;
	}
	public void setQty(String value){
	      this.sp09 = value;
	}
	public String getPartNo(){
        return this.sp10;
	}
	public void setPartNo(String value){
	      this.sp10 = value;
	}
	public String getSP11(){
        return this.sp11;
	}
	public void setS11(String value){
	      this.sp11 = value;
	}
	
}
