package com.winway.wwapp2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.winway.wwapp2.PullDownView.OnPullDownListener;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.InputType;
import android.text.Editable.Factory;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnKeyListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
public class EndCustListActivity extends BaseFragment implements OnPullDownListener, OnItemClickListener,SearchView.OnQueryTextListener  {
	private Context context ;
	private Bundle bundle;
	private View mView=null;
	private int ACTION_MESSAGE;
	private CustListAdapter adapter2;
	private ArrayList<CustItem> custItems;
	private PullDownView mPullDownView;
	protected static final int REFRESH_DATA = 0x00000002;
	private static final int WHAT_DID_LOAD_DATA = 0;
	private static final int WHAT_DID_REFRESH = 1;
	private static final int WHAT_DID_MORE = 5;
	private Button btnCancel=null;
	private Button btnCancel2=null;
	private int page=1;
	private ListView lstCust;
	private SearchView sv ;
	private String strSearchText="";
	private EditText searchEdit;
	private RelativeLayout r1;
	private RelativeLayout r2;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		
		//System.out.println("==>"+new Throwable().getStackTrace()[0].getClassName()+" > "+new Throwable().getStackTrace()[0].getMethodName());
		//System.out.println("===>Line number: "+new Throwable().getStackTrace()[0].getLineNumber()); 
   		
		return initView(inflater, container);
	}

	private View initView(LayoutInflater inflater, ViewGroup container) {
		
		//System.out.println("==>"+new Throwable().getStackTrace()[0].getClassName()+" > "+new Throwable().getStackTrace()[0].getMethodName());
		//System.out.println("===>Line number: "+new Throwable().getStackTrace()[0].getLineNumber()); 
   		
		View view = inflater.inflate(R.layout.actcustlist, container, false);
		
		context = view.getContext();
		mView=view;
		btnCancel=(Button)view.findViewById(R.id.btn_cancel);
		btnCancel2=(Button)view.findViewById(R.id.btn_cancel2);
		r1=(RelativeLayout)view.findViewById(R.id.cust_r1);
		r2=(RelativeLayout)view.findViewById(R.id.cust_r2);
		searchEdit=(EditText)view.findViewById(R.id.search_text);
		btnCancel.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v){
				
				//System.out.println("==>"+new Throwable().getStackTrace()[0].getClassName()+" > "+new Throwable().getStackTrace()[0].getMethodName());
				//System.out.println("===>Line number: "+new Throwable().getStackTrace()[0].getLineNumber()); 
		   		
				closeFragment();
			}
		});
		btnCancel2.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v){
				
				//System.out.println("==>"+new Throwable().getStackTrace()[0].getClassName()+" > "+new Throwable().getStackTrace()[0].getMethodName());
				//System.out.println("===>Line number: "+new Throwable().getStackTrace()[0].getLineNumber()); 
		   		
				if(r1.getVisibility()!=View.VISIBLE)
				{
					r1.setVisibility(View.VISIBLE);					
				}
				if(btnCancel2.getVisibility()==View.VISIBLE)
				{
					btnCancel2.setVisibility(View.GONE);
					searchEdit.setFocusable(false);
					searchEdit.setFocusableInTouchMode(false);
					searchEdit.setClickable(false);
				}
			}
		});
		searchEdit.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v){
				
				//System.out.println("==>"+new Throwable().getStackTrace()[0].getClassName()+" > "+new Throwable().getStackTrace()[0].getMethodName());
				//System.out.println("===>Line number: "+new Throwable().getStackTrace()[0].getLineNumber()); 
		   		
				if(btnCancel2.getVisibility()!=View.VISIBLE)
				{
					btnCancel2.setVisibility(View.VISIBLE);	
					searchEdit.setFocusable(true);
					searchEdit.setFocusableInTouchMode(true);
					searchEdit.setClickable(true);
				}
				if(r1.getVisibility()==View.VISIBLE)
				{
					r1.setVisibility(View.GONE);					
				}
			}
		});
		searchEdit.setOnTouchListener(new OnTouchListener() {
		    @Override
		    public boolean onTouch(View v, MotionEvent event) {
		    	
		    	//System.out.println("==>"+new Throwable().getStackTrace()[0].getClassName()+" > "+new Throwable().getStackTrace()[0].getMethodName());
				//System.out.println("===>Line number: "+new Throwable().getStackTrace()[0].getLineNumber()); 
		   		
		        if (event.getAction() == MotionEvent.ACTION_UP) {
		            
		        }
		        return false;
		    }
		});

		searchEdit.setOnFocusChangeListener(new OnFocusChangeListener() {

		    @Override
		    public void onFocusChange(View v, boolean hasFocus) {
		    	
		    	//System.out.println("==>"+new Throwable().getStackTrace()[0].getClassName()+" > "+new Throwable().getStackTrace()[0].getMethodName());
				//System.out.println("===>Line number: "+new Throwable().getStackTrace()[0].getLineNumber()); 
		   		
		        if (hasFocus) {
		           
		        } else {
		           
		        }
		    }
		});
		searchEdit.setOnKeyListener(new OnKeyListener() {
		    public boolean onKey(View v, int keyCode, KeyEvent event) {
		    	
		    	//System.out.println("==>"+new Throwable().getStackTrace()[0].getClassName()+" > "+new Throwable().getStackTrace()[0].getMethodName());
				//System.out.println("===>Line number: "+new Throwable().getStackTrace()[0].getLineNumber()); 
		   		
		        // If the event is a key-down event on the "enter" button
		        if ((event.getAction() == 0) && (keyCode== 66))
			     {
		          // Perform action on key press
		        	page=1;
			        strSearchText=searchEdit.getText().toString();
			    	queryData(WHAT_DID_LOAD_DATA);
		          
		        }
		        return false;
		    }
		});
		
		/*
		    sv = (SearchView) view.findViewById(R.id.search_custview);
		   //設置該SearchView默認是否自動縮小為圖標
	        sv.setIconifiedByDefault(false);
	        //為該SearchView組件設置事件監聽器
	        sv.setOnQueryTextListener(this);
	        //設置該SearchView顯示搜索按鈕
	        sv.setSubmitButtonEnabled(true);
	        //設置該SearchView內默認顯示的提示文本
	        sv.setQueryHint("search");
	        int searchSrcTextId = getResources().getIdentifier("android:id/search_src_text", null, null);  
	        EditText searchEditText = (EditText) sv.findViewById(searchSrcTextId);  
	        searchEditText.setTextColor(Color.BLACK);  
	        searchEditText.setHintTextColor(Color.LTGRAY);  
		   // searchEditText.setBackgroundColor(Color.LTGRAY);
		    int searchImgId = getResources().getIdentifier("android:id/search_mag_icon", null, null);
		    ImageView v = (ImageView)sv.findViewById(searchImgId);
		    v.setImageResource(R.drawable.ic_action_search); */
		   
		initPullDownView(view);
		queryData(WHAT_DID_LOAD_DATA);
 
		return view;
	}
	/*private String getLoginUser()
	{
		return super.getConfig(getActivity(),"Config","LoginUser","");		
	}*/

	private void queryData(int Message)
	{
		
		//System.out.println("==>"+new Throwable().getStackTrace()[0].getClassName()+" > "+new Throwable().getStackTrace()[0].getMethodName());
		//System.out.println("===>Line number: "+new Throwable().getStackTrace()[0].getLineNumber()); 
   		
		 String json="";		
		   //  String url="http://59.125.146.7:8080/APQPService/GetMsgList?USERID=mis&PAGE="+Integer.toString(page)+"&WWID=13145774WWGlobal999988msg";
			 String url="http://59.125.146.7:8080/APQPService/openWindow1CustNo";
		     JSONObject jsonObject = new JSONObject();
		     JSONObject data=new JSONObject();
	         try {
	        	   
	        	   if(strSearchText.isEmpty()==false){
	        		   data.accumulate("condition", strSearchText);
	        	   }
	        	   else {
	        		   data.accumulate("condition", "");  
	        	   }
				   jsonObject.accumulate("userid",this.getLoginUser());
				   jsonObject.accumulate("WWID", "13145774WWGlobal999988owquery999");
				   jsonObject.accumulate("data", data);
				   jsonObject.accumulate("page",page);
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
			custItems.clear();
			JSONObject jsonObject=new JSONObject((String)result);
			setCustItem(jsonObject);
			mPullDownView.notifyDidLoad();
			}
		catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			  
	  }
	@Override
	  public void loadRefreshData(Object result)
	  {
		
		//System.out.println("==>"+new Throwable().getStackTrace()[0].getClassName()+" > "+new Throwable().getStackTrace()[0].getMethodName());
		//System.out.println("===>Line number: "+new Throwable().getStackTrace()[0].getLineNumber()); 
   		
		try {
			JSONObject jsonObject=new JSONObject((String)result);
			custItems.clear();
			setCustItem(jsonObject);
			page=1;
			mPullDownView.notifyDidRefresh();
			}
		catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			  
	  }	
	@Override
	  public void loadMoreData(Object result)
	  {
		
		//System.out.println("==>"+new Throwable().getStackTrace()[0].getClassName()+" > "+new Throwable().getStackTrace()[0].getMethodName());
		//System.out.println("===>Line number: "+new Throwable().getStackTrace()[0].getLineNumber()); 
   		
			try {
				JSONObject jsonObject=new JSONObject((String)result);
				setCustItem(jsonObject);
				JSONArray array=jsonObject.getJSONArray("data");
				if(array.length()==0){
					page=page-1;		
				}
				mPullDownView.notifyDidMore();
				}
			catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			  
	  }
	private void setCustItem(JSONObject jsonObject)
	{
		
		//System.out.println("==>"+new Throwable().getStackTrace()[0].getClassName()+" > "+new Throwable().getStackTrace()[0].getMethodName());
		//System.out.println("===>Line number: "+new Throwable().getStackTrace()[0].getLineNumber()); 
   		
		try {
			JSONArray array=jsonObject.getJSONArray("data");
			if(array.length()>0){
			for(int i=0;i<array.length() ;i++){
				JSONObject obj;
				obj = array.getJSONObject(i);	
				custItems.add(new CustItem(obj.getString("OCC01"),//cust no
						                   obj.getString("OCC02"),//cust name
						                   obj.getString("OCC29"),//contact
						                   "",//area code
						                   obj.getString("OCC261"),//phone
						                   "",//ext
						                   "",//fax area code
						                   obj.getString("OCC271"),//fax
						                   obj.getString("OCC262"),//mobile
						                   obj.getString("OCC241"),//address
						                    obj.getString("OCCUD04")//email
						                   ));	
		      }
			adapter2.notifyDataSetChanged();
			}
		   } catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	  @Override
		public void onRefresh() {
		  
		  //System.out.println("==>"+new Throwable().getStackTrace()[0].getClassName()+" > "+new Throwable().getStackTrace()[0].getMethodName());
			//System.out.println("===>Line number: "+new Throwable().getStackTrace()[0].getLineNumber()); 
	   		
			// TODO Auto-generated method stub
	new Thread(new Runnable() {
				@Override
				public void run() {
					
					//System.out.println("==>"+new Throwable().getStackTrace()[0].getClassName()+" > "+new Throwable().getStackTrace()[0].getMethodName());
					//System.out.println("===>Line number: "+new Throwable().getStackTrace()[0].getLineNumber()); 
			   		
					//String result="";				
					queryData(WHAT_DID_REFRESH);    
					
				}
			}).start();
		}

		@Override
		public void onMore() {
			// TODO Auto-generated method stub
	new Thread(new Runnable() {		
				@Override
				public void run() {
					
					//System.out.println("==>"+new Throwable().getStackTrace()[0].getClassName()+" > "+new Throwable().getStackTrace()[0].getMethodName());
					//System.out.println("===>Line number: "+new Throwable().getStackTrace()[0].getLineNumber()); 
			   		
					//String result="";
					page+=1;
					queryData(WHAT_DID_MORE);    
			      	     
					
				}
			}).start();
			
		}
		private void initPullDownView(View view)
		{
			//System.out.println("==>"+new Throwable().getStackTrace()[0].getClassName()+" > "+new Throwable().getStackTrace()[0].getMethodName());
			//System.out.println("===>Line number: "+new Throwable().getStackTrace()[0].getLineNumber()); 
	   		
			/*
			 * 1.使用PullDownView
			 * 2.設置OnPullDownListener
			 * 3.從mPullDownView里面獲取ListView
			 */
		
			mPullDownView = (PullDownView) view.findViewById(R.id.custlistview);
			if(mPullDownView==null) return ;
			mPullDownView.setOnPullDownListener(this);
			lstCust = mPullDownView.getListView();		
			lstCust.setOnItemClickListener(this);
			/*ColorDrawable cd=new ColorDrawable(R.color.red);
			lstCust.setDivider(cd);
			lstCust.setChoiceMode(ListView.CHOICE_MODE_SINGLE);*/
			lstCust.setDividerHeight(0);
			lstCust.setHeaderDividersEnabled(true);
			//adapter2 = new SimpleAdapter(context,mStrings,R.layout.pulldown_item,new String[]{"title","content"},new int[] {R.id.msg_title2,R.id.msg_content} );
		     custItems = new ArrayList<CustItem>();
			 adapter2 = new CustListAdapter(context,custItems);
			 lstCust.setAdapter(adapter2);
		     mPullDownView.enableAutoFetchMore(true, 1);
			
		}
		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			
			
			//System.out.println("==>"+new Throwable().getStackTrace()[0].getClassName()+" > "+new Throwable().getStackTrace()[0].getMethodName());
			//System.out.println("===>Line number: "+new Throwable().getStackTrace()[0].getLineNumber()); 
	   		
			   final CustItem item = (CustItem ) custItems.get(position);
			   doWork(item);			   
			   closeFragment();
			  
			
		}
		private void closeFragment()
		{
			
			//System.out.println("==>"+new Throwable().getStackTrace()[0].getClassName()+" > "+new Throwable().getStackTrace()[0].getMethodName());
			//System.out.println("===>Line number: "+new Throwable().getStackTrace()[0].getLineNumber()); 
	   		
			 FragmentManager fm=getFragmentManager();
        	 fm.beginTransaction().remove(fm.findFragmentByTag("EndCust")).commit();
        	 fm.popBackStack();
        	 fm.beginTransaction().show(fm.findFragmentByTag("apqpdata")).commit();  
			
		}
		
	    @Override
	    public boolean onQueryTextChange(String newText) {
	    	
	    	//System.out.println("==>"+new Throwable().getStackTrace()[0].getClassName()+" > "+new Throwable().getStackTrace()[0].getMethodName());
			//System.out.println("===>Line number: "+new Throwable().getStackTrace()[0].getLineNumber()); 
	   		
	        // TODO Auto-generated method stub
	    	
	        return true;
	    }
	     //
	    @Override
	    public boolean onQueryTextSubmit(String query) {
	    	
	    	//System.out.println("==>"+new Throwable().getStackTrace()[0].getClassName()+" > "+new Throwable().getStackTrace()[0].getMethodName());
			//System.out.println("===>Line number: "+new Throwable().getStackTrace()[0].getLineNumber()); 
	   		
	        // TODO Auto-generated method stub
	    	page=1;
	    	 strSearchText=query;
	    	queryData(WHAT_DID_LOAD_DATA);
	        return true;
	    }

}
