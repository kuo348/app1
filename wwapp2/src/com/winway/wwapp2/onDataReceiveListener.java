package com.winway.wwapp2;


public class onDataReceiveListener {

    private IDataReceiveListener mListener;

    public void setListener(IDataReceiveListener dataReceiveListener) {
        
		//System.out.println("==>"+new Throwable().getStackTrace()[0].getClassName()+" > "+new Throwable().getStackTrace()[0].getMethodName());
	  	//System.out.println("===>Line number: "+new Throwable().getStackTrace()[0].getLineNumber()); 

    	mListener = dataReceiveListener;
    }

    public void onReceive(Object obj) {
    	
		//System.out.println("==>"+new Throwable().getStackTrace()[0].getClassName()+" > "+new Throwable().getStackTrace()[0].getMethodName());
	  	//System.out.println("===>Line number: "+new Throwable().getStackTrace()[0].getLineNumber()); 

        if (mListener != null) {
            mListener.onReceiveData(obj);
        }
    }
}
