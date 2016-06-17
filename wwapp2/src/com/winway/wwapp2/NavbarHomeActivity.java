package com.winway.wwapp2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.winway.wwapp2.BaseFragment.HttpGetAsyncTask;
import com.winway.wwapp2.PullDownView.OnPullDownListener;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class NavbarHomeActivity extends BaseFragment{
	private ListView lstMsg;
	private MsgListAdapter adapter2;
	private TypedArray navMenuIcons;
	private TypedArray navMenuIcons2;
	private ArrayList<MsgItem> msgItems;
	private Fragment fragmentCurrent = this;
	private SearchView mSearchView;
	private int ACTION_MESSAGE;
	protected static final int REFRESH_DATA = 0x00000002;
	private static final int WHAT_DID_LOAD_DATA = 0;
	private static final int WHAT_DID_REFRESH = 1;
	private static final int WHAT_DID_MORE = 5;
	private Context context ;
	private Button btnMsg;
	private RadioGroup group;
	private View mView;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		//System.out.println("==>"+new Throwable().getStackTrace()[0].getClassName()+" > "+new Throwable().getStackTrace()[0].getMethodName());
		//System.out.println("===>Line number: "+new Throwable().getStackTrace()[0].getLineNumber()); 

		return initView(inflater, container);
	}

	private View initView(LayoutInflater inflater, ViewGroup container) {
		//System.out.println("==>"+new Throwable().getStackTrace()[0].getClassName()+" > "+new Throwable().getStackTrace()[0].getMethodName());
		//System.out.println("===>Line number: "+new Throwable().getStackTrace()[0].getLineNumber()); 

		View view = inflater.inflate(R.layout.actnavbarhome, container, false);//圖1_2_2

		context = view.getContext();
		mView=view;
		loadUnreadMsgCount();//載入未讀的Message
		return view;
	}
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
	public void showActionbar()
	{
		//System.out.println("==>"+new Throwable().getStackTrace()[0].getClassName()+" > "+new Throwable().getStackTrace()[0].getMethodName());
		//System.out.println("===>Line number: "+new Throwable().getStackTrace()[0].getLineNumber()); 

	    ActionBar mActionBar=getActivity().getActionBar();
        if(mActionBar.isShowing()==false)mActionBar.show();
	}
	
	private void queryData(int Message)
	{
		//System.out.println("==>"+new Throwable().getStackTrace()[0].getClassName()+" > "+new Throwable().getStackTrace()[0].getMethodName());
		//System.out.println("===>Line number: "+new Throwable().getStackTrace()[0].getLineNumber()); 

		 String json="";		
		   //  String url="http://59.125.146.7:8080/APQPService/GetMsgList?USERID=mis&PAGE="+Integer.toString(page)+"&WWID=13145774WWGlobal999988msg";
			 String url=super.getWebServiceUrl()+"GetMSGes";
		     JSONObject jsonObject = new JSONObject();
		     JSONObject data=new JSONObject();
	         try {
	        	  data.accumulate("condition", "");
	          	   data.accumulate("readed", "false");
	   			   jsonObject.accumulate("userid",super.getLoginUser());
	   			   jsonObject.accumulate("WWID", "13145774WWGlobal999988msg");
	   			   jsonObject.accumulate("data", data);
	   			   jsonObject.accumulate("page", "1");
	   			
				   super.postRequest(url,jsonObject,Message);
				   
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		
	}
	@Override
	  public void loadData(Object result)
	  {
		//System.out.println("==>"+new Throwable().getStackTrace()[0].getClassName()+" > "+new Throwable().getStackTrace()[0].getMethodName());
		//System.out.println("===>Line number: "+new Throwable().getStackTrace()[0].getLineNumber()); 

		try {
			//super.showDialog((String)result);
			JSONObject jsonObject=new JSONObject((String)result);
			if(jsonObject.getString("success").equals("true")){
			  setMessageItems(jsonObject);
			}
			
			}
		catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			  
	  }
  private void setMessageItems(JSONObject result)
  {
	  //System.out.println("==>"+new Throwable().getStackTrace()[0].getClassName()+" > "+new Throwable().getStackTrace()[0].getMethodName());
	  //System.out.println("===>Line number: "+new Throwable().getStackTrace()[0].getLineNumber()); 

	  try {
  		JSONArray array=result.getJSONArray("data");
		navMenuIcons = getResources()
  				.obtainTypedArray(R.array.message_icons);
  		navMenuIcons2 = getResources()
  				.obtainTypedArray(R.array.message_read_icons);
  msgItems = new ArrayList<MsgItem>();
for(int i=0;i<array.length() ;i++){
          JSONObject jsonObject=array.getJSONObject(i);
          if(i>=3) break ;
          if(jsonObject.getString("MSG007").equals("A")){
				//if(jsonObject.getString("MSG012").equals("Y"))
				//		msgItems.add(new MsgItem(jsonObject.getString("MSG001"),jsonObject.getString("MSG004"),jsonObject.getString("MSG008"),jsonObject.getString("MSG005"), navMenuIcons.getResourceId(0, -1),"A"));	
				//else
					msgItems.add(new MsgItem(jsonObject.getString("MSG001"),jsonObject.getString("MSG004"),jsonObject.getString("MSG008"),jsonObject.getString("MSG005"), navMenuIcons2.getResourceId(0, -1),"A"));
			}
		else if(jsonObject.getString("MSG007").equals("B")){
				//	if(jsonObject.getString("MSG012").equals("Y")) 
							msgItems.add(new MsgItem(jsonObject.getString("MSG001"),jsonObject.getString("MSG004"),jsonObject.getString("MSG008"),jsonObject.getString("MSG005"), navMenuIcons.getResourceId(1, -1),"B"));	                	
					//else
					//		msgItems.add(new MsgItem(jsonObject.getString("MSG001"),jsonObject.getString("MSG004"),jsonObject.getString("MSG008"),jsonObject.getString("MSG005"), navMenuIcons2.getResourceId(1, -1),"B"));
			}
		else if(jsonObject.getString("MSG007").equals("C")){
				//if(jsonObject.getString("MSG012").equals("Y")) 
				//	msgItems.add(new MsgItem(jsonObject.getString("MSG001"),jsonObject.getString("MSG004"),jsonObject.getString("MSG008"),jsonObject.getString("MSG005"), navMenuIcons.getResourceId(2, -1),"C"));	                	
				//else
					msgItems.add(new MsgItem(jsonObject.getString("MSG001"),jsonObject.getString("MSG004"),jsonObject.getString("MSG008"),jsonObject.getString("MSG005"), navMenuIcons2.getResourceId(2, -1),"C"));
		}
		else if(jsonObject.getString("MSG007").equals("D")){
				//if(jsonObject.getString("MSG012").equals("Y")) 
				//	msgItems.add(new MsgItem(jsonObject.getString("MSG001"),jsonObject.getString("MSG004"),jsonObject.getString("MSG008"),jsonObject.getString("MSG005"), navMenuIcons.getResourceId(3, -1),"D"));	                	
			//	else
					msgItems.add(new MsgItem(jsonObject.getString("MSG001"),jsonObject.getString("MSG004"),jsonObject.getString("MSG008"),jsonObject.getString("MSG005"), navMenuIcons2.getResourceId(3, -1),"D"));
		}
		else if(jsonObject.getString("MSG007").equals("E")){
				//if(jsonObject.getString("MSG012").equals("Y")) 
				//	msgItems.add(new MsgItem(jsonObject.getString("MSG001"),jsonObject.getString("MSG004"),jsonObject.getString("MSG008"),jsonObject.getString("MSG005"), navMenuIcons.getResourceId(4, -1),"E"));	                	
				//else
					msgItems.add(new MsgItem(jsonObject.getString("MSG001"),jsonObject.getString("MSG004"),jsonObject.getString("MSG008"),jsonObject.getString("MSG005"), navMenuIcons2.getResourceId(4, -1),"E"));
			}
		else {	  					
				msgItems.add(new MsgItem(jsonObject.getString("MSG001"),jsonObject.getString("MSG004"),jsonObject.getString("MSG008"),jsonObject.getString("MSG005"), navMenuIcons2.getResourceId(4, -1),""));
		}

  	}

  // Recycle the typed array
  navMenuIcons.recycle();



  //ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.drawer_list_item, drawer_menu);
  adapter2 = new MsgListAdapter(context,msgItems);  
  lstMsg.setAdapter(adapter2);
  //Home,點選未讀Message的某一筆Message
  lstMsg.setOnItemClickListener(new AdapterView.OnItemClickListener() {
      @Override
      public void onItemClick(AdapterView<?> parent, final View view,int position, long id) {
      	
    		  
    	//System.out.println("==>"+new Throwable().getStackTrace()[0].getClassName()+" > "+new Throwable().getStackTrace()[0].getMethodName());
  		//System.out.println("===>Line number: "+new Throwable().getStackTrace()[0].getLineNumber()); 
  		
  		
    	  final MsgItem item = (MsgItem ) msgItems.get(position);//選擇第?條Message
		    Bundle bundle = new Bundle();
			bundle.putString("id", item.getMsgId());
        //Toast.makeText(getActivity().getApplicationContext(), item.getMsgId(), Toast.LENGTH_LONG).show();
		    Fragment fragment = null;
			fragment = new NavbarHomeDetailActivity();//home 的 message列表 =>message詳情
			fragment.setArguments(bundle);
			 FragmentManager fragmentManager = getFragmentManager();
		    
			 //如果找不到詳情的fragment
			 if(fragmentManager.findFragmentById(fragment.getId())==null)
		     {
		    	  fragmentManager.beginTransaction().add(R.id.content_frame, fragment,"homedetail").commit();
		     }
		    
		    fragmentManager.beginTransaction().hide(fragmentCurrent).commit();//隱藏目前的fragment
		    fragmentManager.beginTransaction().show(fragment).commit();//秀出下一個fragment
      }
    });

			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
			
		}
	  
  }

  @Override  
  public void onAttach(Activity activity) 
  {
	  //System.out.println("==>"+new Throwable().getStackTrace()[0].getClassName()+" > "+new Throwable().getStackTrace()[0].getMethodName());
	  //System.out.println("===>Line number: "+new Throwable().getStackTrace()[0].getLineNumber()); 

      super.onAttach(activity);  
      Log.d("NavbarHomeFragment ", "onAttach");  
  }  

  @Override  
  public void onCreate(Bundle savedInstanceState) 
  {
	  //System.out.println("==>"+new Throwable().getStackTrace()[0].getClassName()+" > "+new Throwable().getStackTrace()[0].getMethodName());
	  //System.out.println("===>Line number: "+new Throwable().getStackTrace()[0].getLineNumber()); 

      super.onCreate(savedInstanceState);  
      Log.d("NavbarHomeFragment", "onCreate");  
  }  

  @Override  
  public void onActivityCreated(Bundle savedInstanceState) 
  {
	  //System.out.println("==>"+new Throwable().getStackTrace()[0].getClassName()+" > "+new Throwable().getStackTrace()[0].getMethodName());
	  //System.out.println("===>Line number: "+new Throwable().getStackTrace()[0].getLineNumber()); 

      super.onActivityCreated(savedInstanceState);  
      Log.d("NavbarHomeFragment", "onActivityCreated");  
  }  

  @Override  
  public void onStart() {
	  //System.out.println("==>"+new Throwable().getStackTrace()[0].getClassName()+" > "+new Throwable().getStackTrace()[0].getMethodName());
	  //System.out.println("===>Line number: "+new Throwable().getStackTrace()[0].getLineNumber()); 

      super.onStart();  
      lstMsg=(ListView) mView.findViewById(R.id.lstmsg);
	    btnMsg=(Button) mView.findViewById(R.id.btnMsg);
		ACTION_MESSAGE=WHAT_DID_LOAD_DATA;
		//showActionbar();
	    queryData(ACTION_MESSAGE);
      Log.d("NavbarHomeFragment", "onStart");  
  }  

  @Override  
  public void onResume() {  
	  //System.out.println("==>"+new Throwable().getStackTrace()[0].getClassName()+" > "+new Throwable().getStackTrace()[0].getMethodName());
	  //System.out.println("===>Line number: "+new Throwable().getStackTrace()[0].getLineNumber()); 

	  super.onResume();  
      Log.d("NavbarHomeFragment", "onResume");  
  }  

  @Override  
  public void onPause() {  
	  //System.out.println("==>"+new Throwable().getStackTrace()[0].getClassName()+" > "+new Throwable().getStackTrace()[0].getMethodName());
	  //System.out.println("===>Line number: "+new Throwable().getStackTrace()[0].getLineNumber()); 

	  super.onPause();  
       Log.d("NavbarHomeFragment", "onPause");  
  }  

  @Override  
  public void onStop() {  
	  //System.out.println("==>"+new Throwable().getStackTrace()[0].getClassName()+" > "+new Throwable().getStackTrace()[0].getMethodName());
	  //System.out.println("===>Line number: "+new Throwable().getStackTrace()[0].getLineNumber()); 

	  super.onStop();  
      Log.d("NavbarHomeFragment", "onStop");  
  }  

  @Override  
  public void onDestroyView() {  
	  //System.out.println("==>"+new Throwable().getStackTrace()[0].getClassName()+" > "+new Throwable().getStackTrace()[0].getMethodName());
	  //System.out.println("===>Line number: "+new Throwable().getStackTrace()[0].getLineNumber()); 

	  super.onDestroyView();  
      Log.d("NavbarHomeFragment", "onDestroyView");  
  }  

  @Override  
  public void onDestroy() {  
	  //System.out.println("==>"+new Throwable().getStackTrace()[0].getClassName()+" > "+new Throwable().getStackTrace()[0].getMethodName());
	  //System.out.println("===>Line number: "+new Throwable().getStackTrace()[0].getLineNumber()); 

	  super.onDestroy();  
      Log.d("NavbarHomeFragment", "onDestroy");  
  }  

  @Override  
  public void onDetach() {  
	  //System.out.println("==>"+new Throwable().getStackTrace()[0].getClassName()+" > "+new Throwable().getStackTrace()[0].getMethodName());
	  //System.out.println("===>Line number: "+new Throwable().getStackTrace()[0].getLineNumber()); 

	  super.onDetach();  
      Log.d("NavbarHomeFragment", "onDetach");  
  }  
  
  //載入未讀的Message
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
}

