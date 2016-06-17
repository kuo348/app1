package com.winway.wwapp2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.winway.wwapp2.BaseFragment.HttpGetAsyncTask;
import com.winway.wwapp2.BaseFragment.HttpPostAsyncTask;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Date;
public class NavbarDetailActivity extends BaseFragment
{
    private String MsgId;
	private Context context ;
	private View contentView;
	private TypedArray navMenuIcons;
	private TypedArray navMenuIcons2;
	private Button btnMsg;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		
		//System.out.println("==>"+new Throwable().getStackTrace()[0].getClassName()+" > "+new Throwable().getStackTrace()[0].getMethodName());
		//System.out.println("===>Line number: "+new Throwable().getStackTrace()[0].getLineNumber()); 
		
		
		return initView(inflater, container);
	}
   
	private View initView(LayoutInflater inflater, ViewGroup container) {
		
		//System.out.println("==>"+new Throwable().getStackTrace()[0].getClassName()+" > "+new Throwable().getStackTrace()[0].getMethodName());
		//System.out.println("===>Line number: "+new Throwable().getStackTrace()[0].getLineNumber()); 
		
		
		/*View view = inflater.inflate(R.layout.actnavbardetail, container, false);
		contentView=view;
		context = view.getContext();
		Bundle arguments = getArguments();
	    MsgId=arguments.getString("id");
		setTitle("Detial");
		loadMsgData();
		ActionBar mActionBar=getActivity().getActionBar();
           mActionBar.hide();
		return view;*/
		View view = inflater.inflate(R.layout.actnavbardetail, container, false);
	    contentView = view;
	    context = view.getContext();
	    btnMsg = ((Button)view.findViewById(R.id.btnMsg));
	    MsgId = getArguments().getString("id");
	    setMsgRead(MsgId);
	    loadUnreadMsgCount();
	    setTitle("Detial");
		Button btnAdd       =(Button)getActivity().findViewById(R.id.btn_favorite_add);
		Button btnSearch       =(Button)getActivity().findViewById(R.id.btn_search);
		if(btnSearch!=null&&btnSearch.getVisibility()== View.VISIBLE)
		{
			btnSearch.setVisibility(View.GONE);

		}
		if(btnAdd!=null&&btnAdd.getVisibility()== View.VISIBLE)
		{
			btnAdd.setVisibility(View.GONE);

		}
	    queryData(super.getWebServiceUrl() + "GetMSGDetail?USERID=" + super.getLoginUser() + "&MSG001=" + this.MsgId + "&WWID=13145774WWGlobal999988msg");
	    
	    getActivity().getActionBar().hide();
	    return view;
	}

	@SuppressLint("SimpleDateFormat")
	public void setMsgRead(final String msgId) 
	{	
		
		//System.out.println("==>"+new Throwable().getStackTrace()[0].getClassName()+" > "+new Throwable().getStackTrace()[0].getMethodName());
		//System.out.println("===>Line number: "+new Throwable().getStackTrace()[0].getLineNumber()); 
		
		
		try {
	   HttpPutAsyncTask task1=new HttpPutAsyncTask();
	   JSONObject data =new  JSONObject();
	   SimpleDateFormat sdFormat = new SimpleDateFormat("yyyyMMddHHmm");
	    Date current=new Date();
	    data.accumulate("MSG010",sdFormat.format(current));
	    data.accumulate("MSG012", "Y");
		task1.setCallback(new BaseFragment.ICallback() {
				@Override
				public void doWork(Object obj) {
					try {
						
						JSONObject jsonObject = new JSONObject((String) obj);
						if(jsonObject.getString("success").equals("0")){
						  //							 
						   System.out.print("update failure");
						}
						
						// showApplicationDialog(mView);
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					

				}

			});
		task1.execute((String)super.getWebServiceUrl()+ "MSGStatusUpdate/"+MsgId,data.toString());  
	} catch (JSONException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	public void loadUnreadMsgCount(){
		
		//System.out.println("==>"+new Throwable().getStackTrace()[0].getClassName()+" > "+new Throwable().getStackTrace()[0].getMethodName());
		//System.out.println("===>Line number: "+new Throwable().getStackTrace()[0].getLineNumber()); 
		
		
		HttpGetAsyncTask task1=new HttpGetAsyncTask();
		task1.setCallback(new BaseFragment.ICallback() {
				@Override
				public void doWork(Object obj) {
					try
	    	    		{
	    	    			int cc = Integer.parseInt(new JSONObject((String)obj).getString("GetMSGUnreadCountResult"));
	    	    			initBadge(btnMsg,cc);
	    	    		}
	    	    	catch (JSONException e)
	    	    			{
	    	     		    	        e.printStackTrace();
	    	    			}
					

				}

			});
		task1.execute((String)super.getWebServiceUrl()+ "GetMSGUnreadCount?USERID=" + super.getLoginUser() + "&WWID=13145774WWGlobal999988msg");    
		
	}
	public void setTitle(CharSequence title) {
		
		//System.out.println("==>"+new Throwable().getStackTrace()[0].getClassName()+" > "+new Throwable().getStackTrace()[0].getMethodName());
		//System.out.println("===>Line number: "+new Throwable().getStackTrace()[0].getLineNumber()); 
		
		
        getActivity().getActionBar().setTitle(title);
    }
	/*private void loadMsgData()
	{
	     String url=super.getWebServiceUrl()+"GetMSGDetail?USERID="+super.getLoginUser()+"&MSG001="+MsgId+"&WWID=13145774WWGlobal999988msg";
		super.getRequest(url);
		
	}*/
	 private void initBadge(Button button, int count)
	  {
		//System.out.println("==>"+new Throwable().getStackTrace()[0].getClassName()+" > "+new Throwable().getStackTrace()[0].getMethodName());
		//System.out.println("===>Line number: "+new Throwable().getStackTrace()[0].getLineNumber()); 
			
			
	    if (button != null)
	    {
	    	if(count>0){
	    		   BadgeView badge1 = new BadgeView(this.getActivity(), button);// 創建一個BadgeView物件，view為你需要顯示提醒的控制項
	    			badge1.setText(Integer.toString(count)); // 需要顯示的提醒類容
	    			badge1.setBadgePosition(BadgeView.POSITION_TOP_RIGHT);// 顯示的位置.右上角,BadgeView.POSITION_BOTTOM_LEFT,下左，還有其他幾個屬性
	    			badge1.setTextColor(Color.WHITE); // 文本顏色
	    			badge1.setBadgeBackgroundColor(Color.GRAY); //提醒資訊的背景顏色，自己設置
	    			badge1.setTextSize(18); // 文本大小
	    			badge1.setBadgeMargin(60, 5); // 水準和豎直方向的間距
	    			//badge1.setBadgeMargin(30); //各邊間隔
	    			// badge1.toggle(); //顯示效果，如果已經顯示，則隱藏，如果隱藏，則顯示
	    			badge1.show();// 只有顯示
	    	}
	    }
	  }
	 public void queryData(String url, IDataReceiveListener DataReceiveListener)
	  {
		//System.out.println("==>"+new Throwable().getStackTrace()[0].getClassName()+" > "+new Throwable().getStackTrace()[0].getMethodName());
		//System.out.println("===>Line number: "+new Throwable().getStackTrace()[0].getLineNumber()); 
			
	    super.getRequest(url, DataReceiveListener);
	  }
	 public void queryData(String url)
	  {
		//System.out.println("==>"+new Throwable().getStackTrace()[0].getClassName()+" > "+new Throwable().getStackTrace()[0].getMethodName());
		//System.out.println("===>Line number: "+new Throwable().getStackTrace()[0].getLineNumber()); 
			
	    super.getRequest(url);
	  }
	 @Override
	 public void loadData(Object result)
	  {
		 //System.out.println("==>"+new Throwable().getStackTrace()[0].getClassName()+" > "+new Throwable().getStackTrace()[0].getMethodName());
		 //System.out.println("===>Line number: "+new Throwable().getStackTrace()[0].getLineNumber()); 
			
			
			try {
    		    navMenuIcons = getResources().obtainTypedArray(R.array.message_read_icons);
    		   // navMenuIcons2 = getResources().obtainTypedArray(R.array.message_read_icons);
    		    ImageView imgIcon = (ImageView) contentView.findViewById(R.id.msg_img3);	
    	        TextView txtTitle = (TextView)  contentView.findViewById(R.id.msg_title3);
    	        TextView txtDate  = (TextView)  contentView.findViewById(R.id.msg_date3);
    	        TextView txtDesc  = (TextView)  contentView.findViewById(R.id.msg_desc3);
    	        TextView txtMsgKindText = (TextView) contentView.findViewById(R.id.msg_kind_text3);
    	        WebView  Content = (WebView) contentView.findViewById(R.id.msg_content);
    	        Content.getSettings().setDefaultTextEncodingName("utf-8");
    		JSONObject jsonObject=new JSONObject((String)result).getJSONObject("GetMSGDetailResult");
    		 txtTitle.setText(jsonObject.getString("MSG004"));
 	         txtDesc.setText(jsonObject.getString("MSG008"));
 	         txtDate.setText(jsonObject.getString("MSG005"));
 	         //txtContent.setText(jsonObject.getString("MSG009"));
 	         String body=jsonObject.getString("MSG009");
 	         Content.loadData(body, "text/html; charset=UTF-8", null);
    			if(jsonObject.getString("MSG007").equals("A")){
    				txtMsgKindText.setText("Urgent");
                	imgIcon.setImageResource(navMenuIcons.getResourceId(0, -1));	
                		
                	
                }
                else if(jsonObject.getString("MSG007").equals("B")){
                	txtMsgKindText.setText("Normal");
                    imgIcon.setImageResource(navMenuIcons.getResourceId(1, -1));		                	
                	
                }
                else if(jsonObject.getString("MSG007").equals("C")){
                	txtMsgKindText.setText("Notifiy");
                    imgIcon.setImageResource(navMenuIcons.getResourceId(3, -1));		                	
                	
                }
                else if(jsonObject.getString("MSG007").equals("D")){
                	txtMsgKindText.setText("Message");
                    imgIcon.setImageResource(navMenuIcons.getResourceId(4, -1));	
                	
                }
                else if(jsonObject.getString("MSG007").equals("E")){
                	txtMsgKindText.setText("Log");
                    imgIcon.setImageResource(navMenuIcons.getResourceId(4, -1));	
                	
                }
    	
    		// Recycle the typed array
    		navMenuIcons.recycle();
    	//	navMenuIcons2.recycle();
    		 /* queryData(super.getWebServiceUrl() + "GetMSGUnreadCount?USERID=" + super.getLoginUser() + "&WWID=13145774WWGlobal999988msg", new IDataReceiveListener(){
  		    	@Override
  		    	public void onReceiveData(Object result)
  		    	  {
  		    	    	try
  		    	    		{
  		    	    			int cc = Integer.parseInt(new JSONObject((String)result).getString("GetMSGUnreadCountResult"));
  		    	    			initBadge(btnMsg,cc);
  		    	    		}
  		    	    	catch (JSONException e)
  		    	    			{
  		    	     		    	        e.printStackTrace();
  		    	    			}
  		    	  }
  		    });*/
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//Toast.makeText(NavbarHomeActivity.this,"recevie erroe:"+e.toString(), Toast.LENGTH_SHORT).show();
		}
	  }
}