/*
存取設定檔
*/
package com.winway.wwapp2;
import android.preference.PreferenceManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
public class SaveSharedPreference 
{
    static final String PREF_USER_NAME= "LoginUser";//登入的USER

    static SharedPreferences getSharedPreferences(Context ctx) {
        return PreferenceManager.getDefaultSharedPreferences(ctx);
    }

    public static void setUserName(Context ctx, String userName) 
    {
    	//System.out.println("==>"+new Throwable().getStackTrace()[0].getClassName()+" > "+new Throwable().getStackTrace()[0].getMethodName());
		//System.out.println("===>Line number: "+new Throwable().getStackTrace()[0].getLineNumber()); 

        Editor editor = getSharedPreferences(ctx).edit();
        editor.putString(PREF_USER_NAME, userName);
        editor.commit();
    }

    public static String getUserName(Context ctx)
    {
		
		//System.out.println("==>"+new Throwable().getStackTrace()[0].getClassName()+" > "+new Throwable().getStackTrace()[0].getMethodName());
		//System.out.println("===>Line number: "+new Throwable().getStackTrace()[0].getLineNumber()); 

        return getSharedPreferences(ctx).getString(PREF_USER_NAME, "");
    }
    //設定檔=>設定
    public static void setConfig(Context context,String name,String key,String value) 
    {
		
		//System.out.println("==>"+new Throwable().getStackTrace()[0].getClassName()+" > "+new Throwable().getStackTrace()[0].getMethodName());
		//System.out.println("===>Line number: "+new Throwable().getStackTrace()[0].getLineNumber()); 

         SharedPreferences settings =context.getSharedPreferences(name,0);
         SharedPreferences.Editor PE = settings.edit();
         PE.putString(key, value);
         PE.commit();
    }
     
    //設定檔=>讀取
    public static String getConfig(Context context , String name , String key , String def) 
    {
         SharedPreferences settings =context.getSharedPreferences(name,0);
         return settings.getString(key, def);
    }
}
