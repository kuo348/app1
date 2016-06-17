package com.winway.wwapp2;

public class ApqpItem {

	private String apqpno;
	private String customer;
	private int icon;
	// boolean to set visiblity of the counter
	private boolean isCounterVisible = false;
	private String status;
    private String type;
	public ApqpItem() {
	}

	public ApqpItem(String apqpno, String customer, int icon, String status) {
		this.icon = icon;
		this.customer = customer;
		this.apqpno = apqpno;
		this.status = status;
	}
	public ApqpItem(String apqpno, String customer, int icon, String status,String type) {
		this.icon = icon;
		this.customer = customer;
		this.apqpno = apqpno;
		this.status = status;
		this.type   = String.format("apqp_type_%s", type);
	}
	/*public ApqpItem(String apqpno, String customer, int icon,
			boolean isCounterVisible, String count, int status) {
		this.icon = icon;
		this.customer = customer;
		this.apqpno = apqpno;
		this.isCounterVisible = isCounterVisible;
		this.status = status;
	}*/

	public String getApqpNo() {
		return this.apqpno;
	}

	public String getCusomter() {
		return this.customer;
	}

	public int getIcon() {
		return this.icon;
	}
	public String getStatus() {
		return this.status;
	}
	public String getType() {
		return this.type;
	}
	public boolean getCounterVisibility() {
		return this.isCounterVisible;
	}

	public void setApqpNo(String apqpno) {
		this.apqpno = apqpno;
	}

	public void setCustomer(String customer) {

		this.customer = customer;
	}

	public void setIcon(int icon) {
		this.icon = icon;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	public void setType(String type) {
		this.type = String.format("apqp_type_%s",type);
	}
	public void setCounterVisibility(boolean isCounterVisible) {
		this.isCounterVisible = isCounterVisible;
	}
}
