package com.winway.wwapp2;

public class QtItem {

	private String qtno;
	private String customer;
	private int icon;
	// boolean to set visiblity of the counter
	private boolean isCounterVisible = false;
	//private String status;

	public QtItem() {
	}

	public QtItem(String qtno, String customer, int icon) {
		this.icon = icon;
		this.customer = customer;
		this.qtno = qtno;
		//this.status = status;
	}

	/*public QtItem(String qtno, String customer, int icon,
			boolean isCounterVisible, String count, int status) {
		this.icon = icon;
		this.customer = customer;
		this.qtno = qtno;
		this.isCounterVisible = isCounterVisible;
		this.status = status;
	}*/

	public String getQtNo() {
		return this.qtno;
	}

	public String getCusomter() {
		return this.customer;
	}

	public int getIcon() {
		return this.icon;
	}
	//public String getStatus() {
	//	return this.status;
	//}
	public boolean getCounterVisibility() {
		return this.isCounterVisible;
	}

	public void setQtNo(String qtno) {
		this.qtno = qtno;
	}

	public void setCustomer(String customer) {

		this.customer = customer;
	}

	public void setIcon(int icon) {
		this.icon = icon;
	}

	//public void setStatus(String status) {
	//	this.status = status;
	//}

	public void setCounterVisibility(boolean isCounterVisible) {
		this.isCounterVisible = isCounterVisible;
	}
}
