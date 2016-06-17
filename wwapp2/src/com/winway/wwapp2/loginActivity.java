package com.winway.wwapp2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.HTTP;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class loginActivity extends Activity {
	private Button b1;
	private EditText usrAccountText;
	private EditText usrPassText;
	private static String account;
	private static String passwd;
	//OTPW(one time password)
	//id+pw  =>   otpw (24hrs)
	//設定檔儲存
   /* public static void setConfig(Context context,String name,String key,String value) 
    {
         SharedPreferences settings =context.getSharedPreferences(name,0);
         SharedPreferences.Editor PE = settings.edit();
         PE.putString(key, value);
         PE.commit();
    }
     
    //設定檔讀取
    public static String getConfig(Context context , String name , String key , String def) 
    {
         SharedPreferences settings =context.getSharedPreferences(name,0);
         return settings.getString(key, def);
    }*/
    private boolean checkNetworkConnected() {
    	 boolean haveConnectedWifi = false;
          boolean haveConnectedMobile = false;
        ConnectivityManager CM = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);       
        if (CM == null) {
           return false;
        } else {
        	 NetworkInfo ni = CM.getActiveNetworkInfo();
        	/*NetworkInfo[] netInfo = CM.getAllNetworkInfo();
            for (NetworkInfo ni : netInfo) {
                if (ni.getTypeName().equalsIgnoreCase("WIFI"))
                    if (ni.isConnected())
                        haveConnectedWifi = true;
                if (ni.getTypeName().equalsIgnoreCase("MOBILE"))
                    if (ni.isConnected())
                        haveConnectedMobile = true;
                if (ni.getTypeName().equalsIgnoreCase("BLUETOOTH"))
                    if (ni.isConnected())
                        haveConnectedMobile = true;}*/
        	 if (ni!=null&&ni.isConnected())
                 haveConnectedMobile = true;
            CM=null;
            return haveConnectedWifi || haveConnectedMobile;
        }
     // return false;
    }
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_main);
		 b1=(Button)findViewById(R.id.loginBtn);
	     usrAccountText=(EditText) findViewById(R.id.usrAccountTxt);
	     usrPassText=(EditText) findViewById(R.id.usrPassTxt);
	     b1.setOnClickListener(new  OnClickListener(){
	        	@Override
	        	public void onClick(View v){     
	        		if(checkNetworkConnected()){
	        			 if(validate()){
	        				 	new HttpGetAsyncTask().execute(getResources().getString(R.string.WebServiceUrl)+"Login?id="+account+"&pwd="+ passwd);	        	
	        			 	}
	        		   }
	        		else{
	        				 
	        				 showDialog("Please check Network status!!!");
	        		}
	            			   	
	        	}
	        	
	        });
	}
	private boolean validate(){
		 account=usrAccountText.getText().toString();
		 passwd=usrPassText.getText().toString();
		if(account.equals("")){
			showDialog("The Account is Empty");
			return false;
		}
		else if(passwd.equals("")){
			showDialog("The Password is Incorrect");
			return false;
		}
		return true;
	}
	public void Forget(View v)
	{
		
		//Toast.makeText(MainActivity.this, "click it", Toast.LENGTH_SHORT).show();
		//String rs=POST("http://59.125.146.7:8080/APQPService/AppForgotpassword");
		//Toast.makeText(MainActivity.this, rs, Toast.LENGTH_SHORT).show(); 
		 account=usrAccountText.getText().toString();	
		 if(account.equals("")){
				showDialog("The Account is Empty");
				return ;
			}
			
		 new HttpAsyncTask().execute(getResources().getString(R.string.WebServiceUrl)+"AppForgotpassword");

	}
	private void showDialog(String msg){
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setMessage(msg)
		       .setCancelable(false)
		       .setPositiveButton("確定", new DialogInterface.OnClickListener() {
		           public void onClick(DialogInterface dialog, int id) {
		           }
		       })
		       .show();
		//AlertDialog alert = builder.create();
		//alert.show();
	}
	public static String POST(String url){
        InputStream inputStream = null;
        String result = "";
       
        try {

            // 1. create HttpClient
            HttpClient httpclient = new DefaultHttpClient();

            // 2. make POST request to the given URL
            HttpPost httpPost = new HttpPost(url);

            String json = "";

            // 3. build jsonObject
            JSONObject jsonObject = new JSONObject();
            jsonObject.accumulate("userid",account);
            jsonObject.accumulate("WWID", "13145774WWGlobal999988forgot999");
            //jsonObject.accumulate("twitter", person.getTwitter());

            // 4. convert JSONObject to JSON to String
            json = jsonObject.toString();

            // ** Alternative way to convert Person object to JSON string usin Jackson Lib 
            // ObjectMapper mapper = new ObjectMapper();
            // json = mapper.writeValueAsString(person); 

            // 5. set json to StringEntity
            StringEntity se = new StringEntity(json);
            //se.setContentType("application/json;charset=UTF-8");
            //se.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, "application/json;charset=UTF-8"));
            // 6. set httpPost Entity
            httpPost.setEntity(se);

            // 7. Set some headers to inform server about the type of the content   
            httpPost.setHeader("Accept", "application/json");
            httpPost.setHeader("Content-type", "application/json");

            // 8. Execute POST request to the given URL
            HttpResponse httpResponse = httpclient.execute(httpPost);

            // 9. receive response as inputStream
            inputStream = httpResponse.getEntity().getContent();

            // 10. convert inputstream to string
            if(inputStream != null)
                result = convertInputStreamToString(inputStream);
            else
                result = "Did not work!";

        } catch (Exception e) {
            Log.d("InputStream", e.getLocalizedMessage());
            result=e.toString();
        }

        // 11. return result
        return result;
    }
	 private static String convertInputStreamToString(InputStream inputStream) throws IOException{
	        BufferedReader bufferedReader = new BufferedReader( new InputStreamReader(inputStream));
	        String line = "";
	        String result = "";
	        while((line = bufferedReader.readLine()) != null)
	            result += line;

	        inputStream.close();
	        return result;

	    }   
	 public static String GET(String url){
	        InputStream inputStream = null;
	        String result = "";
	        try {
	        	/*HttpParams params = new BasicHttpParams();
	        	HttpProtocolParams.setVersion(params, HttpVersion.HTTP_1_1);
	        	HttpProtocolParams.setContentCharset(params, "utf-8");
	        	params.setBooleanParameter("http.protocol.expect-continue", false);*/

	            // create HttpClient
	            //HttpClient httpclient = new DefaultHttpClient(params);
	        	HttpClient httpclient = new DefaultHttpClient();
	            // make GET request to the given URL
	            HttpResponse httpResponse = httpclient.execute(new HttpGet(url));
	 
	            // receive response as inputStream
	            inputStream = httpResponse.getEntity().getContent();
	 
	            // convert inputstream to string
	            if(inputStream != null)
	                result = convertInputStreamToString(inputStream);
	            else
	                result = "Did not work!";
	 
	        } catch (Exception e) {
	            Log.d("InputStream", e.getLocalizedMessage());
	            result=e.toString();
	        }
	 
	        return result;
	    }

	   private class HttpAsyncTask extends AsyncTask<String, Void, String> {
	        protected String doInBackground(String... urls) {
	        	
	         //utilitys.getInstance().httpget(urls[0]);

	            return POST(urls[0]);
	        }
	        // onPostExecute displays the results of the AsyncTask.
	        @Override
	        protected void onPostExecute(String result) {
	           //JSONObject jsonObject = new JSONObject(result).getJSONObject("LoginResult");
		/*	if(result.equals(result))
			   Toast.makeText(MainActivity.this,"Login Successful", Toast.LENGTH_SHORT).show();
			else 
				Toast.makeText(MainActivity.this,"Login Failed",Toast.LENGTH_SHORT).show();*/
	        	if(result.equals("true")){
	        		showDialog("Has sent a message to admin will contact you later");
	        	}
	        	else {
	        		showDialog("Invaild User!!");
	        		
	        	}	       }
	    }
	   private class HttpGetAsyncTask extends AsyncTask<String, Void, String> {
	        protected String doInBackground(String... urls) {
	 
	            return GET(urls[0]);
	        }
	        // onPostExecute displays the results of the AsyncTask.
	        @Override
	        protected void onPostExecute(String result) {
	            JSONObject jsonObject;
	            String userID=null;
				try {
					
					jsonObject = new JSONObject(result).getJSONObject("LoginResult");
					userID=jsonObject.getString("userID");
					//showDialog(userID);
			    	if(userID.equals("null")){
						 //Toast.makeText(MainActivity.this,"Login Failed", Toast.LENGTH_SHORT).show();
			    	showDialog("The Acoount or Password is Incorrect");
			    	
			    	}
			        else
			        {
			        	SaveSharedPreference.setConfig(loginActivity.this,"Config","LoginUser",userID);
			        	Intent i=new Intent(loginActivity.this,MainActivity.class);
			        	startActivity(i);
			        	finish();
			        }
				  // Toast.makeText(MainActivity.this,"Login Sucessful", Toast.LENGTH_SHORT).show();
				} catch (JSONException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					//showDialog(e1.toString());
					showDialog("The Acoount or Password is Incorrect");
				}
				
				
				//Toast.makeText(MainActivity.this, result, Toast.LENGTH_LONG).show();
	        	//showDialog(result);

	        }
	    }


}

