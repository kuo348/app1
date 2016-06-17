package com.winway.wwapp2;

public class MsgItem {
	
	private String title;
	private String msgkindtext;
	private int icon;
	private String desc;
	private String date ;
	private String msg_id;
	// boolean to set visiblity of the counter
	private boolean isCounterVisible = false;
	
	public MsgItem(){}

	public MsgItem(String id,String title,String desc,String date,int icon,String kind){
		this.msg_id= id;
		this.title = title;
		this.icon  = icon;
		this.desc  = desc;
		this.date  = date;
		if(kind.equals("A")){
			this.msgkindtext="Urgent";			
		}		
		else if(kind.equals("C"))
		{
			this.msgkindtext="Notifiy";
		}
		else if(kind.equals("D"))
		{
			this.msgkindtext="Message";
		}
		else if(kind.equals("E"))
		{
			this.msgkindtext="Log";
		}
		else 
		{
			this.msgkindtext="Normal";
		}
	}
	
	public MsgItem(String id,String title,String desc,String date,int icon,String kind, boolean isCounterVisible, String count){
		this.msg_id= id;
		this.title = title;
		this.icon = icon;
		this.desc =desc;
		this.date=date;
		this.isCounterVisible = isCounterVisible;
		if(kind.equals("A")){
			this.msgkindtext="Urgent";			
		}		
		else if(kind.equals("C"))
		{
			this.msgkindtext="Notifiy";
		}
		else if(kind.equals("D"))
		{
			this.msgkindtext="Message";
		}
		else if(kind.equals("E"))
		{
			this.msgkindtext="Record";
		}
		else 
		{
			this.msgkindtext="Normal";
		}
	}
	public String getMsgId(){
		return this.msg_id;
	}
	public String getTitle(){
		return this.title;
	}
	
	public int getIcon(){
		return this.icon;
	}
	
	public String getDesc(){
		return this.desc;
	}
	public String getMsgKindText(){
		return this.msgkindtext;
	}
	public void setMsgKindText(String msgkindtext){
		this.msgkindtext=msgkindtext;
	}
	public String getDate(){
		return this.date;
	}
	public boolean getCounterVisibility(){
		return this.isCounterVisible;
	}
	public void setMsgId(String id){
		this.msg_id = id;
	}
	public void setTitle(String title){
		this.title = title;
	}
	
	public void setIcon(int icon){
		this.icon = icon;
	}
	public void setDesc(String desc){
		this.desc = desc;
	}
	
	public void setDate(String date){
		this.date = date;
	}
	
	
	
	public void setCounterVisibility(boolean isCounterVisible){
		this.isCounterVisible = isCounterVisible;
	}
}
