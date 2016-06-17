package com.winway.wwapp2;

public class SalesItem {
	
	private String empName;
	private String empNo;
	public SalesItem(){}

	public SalesItem(String empNo,String empName){	
		this.empNo  = empNo;
		this.empName  = empName;
	}
	
	public String getEmpNo(){
		return this.empNo;
	}
	public String getEmpName(){
        return this.empName;
	}

	public void setEmpNo(String empNo){
         this.empNo = empNo;
	}
	public void setEmpName(String empName){
	      this.empName = empName;
	}

}
