package com.winway.wwapp2;public class ContactItem {		private String name;	private String ext;	private String cellphone;	private String email;		public ContactItem(){				//System.out.println("==>"+new Throwable().getStackTrace()[0].getClassName()+" > "+new Throwable().getStackTrace()[0].getMethodName());		//System.out.println("===>Line number: "+new Throwable().getStackTrace()[0].getLineNumber());    			}	public ContactItem(String name,String ext,String cellphone,String email){				//System.out.println("==>"+new Throwable().getStackTrace()[0].getClassName()+" > "+new Throwable().getStackTrace()[0].getMethodName());		//System.out.println("===>Line number: "+new Throwable().getStackTrace()[0].getLineNumber());    				this.name  = name;		this.ext  = ext;			this.cellphone=cellphone;		this.email=email;	}	public String getName(){				//System.out.println("==>"+new Throwable().getStackTrace()[0].getClassName()+" > "+new Throwable().getStackTrace()[0].getMethodName());		//System.out.println("===>Line number: "+new Throwable().getStackTrace()[0].getLineNumber());    				return this.name;	}	public String getExt(){				//System.out.println("==>"+new Throwable().getStackTrace()[0].getClassName()+" > "+new Throwable().getStackTrace()[0].getMethodName());		//System.out.println("===>Line number: "+new Throwable().getStackTrace()[0].getLineNumber());    				return this.ext;	}	public String getCellphone(){				//System.out.println("==>"+new Throwable().getStackTrace()[0].getClassName()+" > "+new Throwable().getStackTrace()[0].getMethodName());		//System.out.println("===>Line number: "+new Throwable().getStackTrace()[0].getLineNumber());    				return this.cellphone;	}	public String getEmail(){				//System.out.println("==>"+new Throwable().getStackTrace()[0].getClassName()+" > "+new Throwable().getStackTrace()[0].getMethodName());		//System.out.println("===>Line number: "+new Throwable().getStackTrace()[0].getLineNumber());    				return this.email;	}	public void setEmail(String email){				//System.out.println("==>"+new Throwable().getStackTrace()[0].getClassName()+" > "+new Throwable().getStackTrace()[0].getMethodName());		//System.out.println("===>Line number: "+new Throwable().getStackTrace()[0].getLineNumber());    				this.email = email;	}	public void setName(String name){				//System.out.println("==>"+new Throwable().getStackTrace()[0].getClassName()+" > "+new Throwable().getStackTrace()[0].getMethodName());		//System.out.println("===>Line number: "+new Throwable().getStackTrace()[0].getLineNumber());    				this.name =name;	}	public void setExt(String ext){				//System.out.println("==>"+new Throwable().getStackTrace()[0].getClassName()+" > "+new Throwable().getStackTrace()[0].getMethodName());		//System.out.println("===>Line number: "+new Throwable().getStackTrace()[0].getLineNumber());    				this.ext = ext;	}	public void setCellphone(String cellphone){				//System.out.println("==>"+new Throwable().getStackTrace()[0].getClassName()+" > "+new Throwable().getStackTrace()[0].getMethodName());		//System.out.println("===>Line number: "+new Throwable().getStackTrace()[0].getLineNumber());    				this.cellphone =cellphone;	}}