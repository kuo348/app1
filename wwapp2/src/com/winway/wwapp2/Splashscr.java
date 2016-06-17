/**
 * 當我們輸入使用者名稱、密碼之後會出現一個畫面，那就是Splash Screen，不會呈現出來，只是邏輯判斷該轉向MainActivity或者loginActivity
 */
package com.winway.wwapp2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;


public class Splashscr extends Activity {
	
	/** Called when the activity is first created. */
	 @Override
	 public void onCreate(Bundle savedInstanceState) {
			
			//System.out.println("==>"+new Throwable().getStackTrace()[0].getClassName()+" > "+new Throwable().getStackTrace()[0].getMethodName());
			//System.out.println("===>Line number: "+new Throwable().getStackTrace()[0].getLineNumber()); 

	  super.onCreate(savedInstanceState);
	  setContentView(R.layout.splash);
	 
	  new Thread(new Runnable(){

			@Override
			public void run() {
				
				
				//System.out.println("==>"+new Throwable().getStackTrace()[0].getClassName()+" > "+new Throwable().getStackTrace()[0].getMethodName());
				//System.out.println("===>Line number: "+new Throwable().getStackTrace()[0].getLineNumber()); 

				// TODO Auto-generated method stub
				/*
				try {


					//如果設定檔沒有帳號 密碼  會轉向登入畫面
					if(SaveSharedPreference.getConfig(Splashscr.this,"Config","LoginUser","").length() == 0)
					{
						Thread.sleep(1000);
					     // call Login Activity
						startActivity(new Intent().setClass(Splashscr.this, loginActivity.class));
					}
					else
					{//如果已經有登入資料
					     // Call Next Activity
						startActivity(new Intent().setClass(Splashscr.this, MainActivity.class));
					}
					startActivity(new Intent().setClass(Splashscr.this, MainActivity.class));
					finish();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	         	  */
				startActivity(new Intent().setClass(Splashscr.this, MainActivity.class));
				finish();
			}
			
		}).start();
	}

}