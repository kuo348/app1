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
public class PackageListActivity extends BaseFragment implements OnPullDownListener, OnItemClickListener,SearchView.OnQueryTextListener  {
	private Context context ;
	private Bundle bundle;
	private View mView=null;
	private int ACTION_MESSAGE;
	private PackageListAdapter adapter2;
	private ArrayList<PackageItem> packageItems;
	private PullDownView mPullDownView;
	protected static final int REFRESH_DATA = 0x00000002;
	private static final int WHAT_DID_LOAD_DATA = 0;
	private static final int WHAT_DID_REFRESH = 1;
	private static final int WHAT_DID_MORE = 5;
	private Button btnCancel=null;
	private Button btnCancel2=null;
	private int page=1;
	private ListView lstPackage;
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

		View view = inflater.inflate(R.layout.actpackagelist, container, false);
		
		context = view.getContext();
		mView=view;
		btnCancel=(Button)view.findViewById(R.id.btn_cancel);
		btnCancel2=(Button)view.findViewById(R.id.btn_cancel2);
		r1=(RelativeLayout)view.findViewById(R.id.package_r1);
		r2=(RelativeLayout)view.findViewById(R.id.package_r2);
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
		        if ((event.getAction() == KeyEvent.ACTION_DOWN) &&
		            (keyCode == KeyEvent.KEYCODE_ENTER)) {
		          // Perform action on key press
		        	page=1;
			        strSearchText=searchEdit.getText().toString();
			    	queryData(WHAT_DID_LOAD_DATA);
		          return true;
		        }
		        return false;
		    }
		});
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
		 
		   //  String url="http://59.125.146.7:8080/APQPService/GetMsgList?USERID=mis&PAGE="+Integer.toString(page)+"&WWID=13145774WWGlobal999988msg"
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
				   super.postRequest((String)super.getWebServiceUrl()+"openWindow1PackageType",jsonObject,Message);
				   
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
			packageItems.clear();
			JSONObject jsonObject=new JSONObject((String)result);
			setPackageItem(jsonObject);
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
			packageItems.clear();
			setPackageItem(jsonObject);
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
				setPackageItem(jsonObject);
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
	private void setPackageItem(JSONObject jsonObject)
	{
		
						
			//System.out.println("==>"+new Throwable().getStackTrace()[0].getClassName()+" > "+new Throwable().getStackTrace()[0].getMethodName());
			//System.out.println("===>Line number: "+new Throwable().getStackTrace()[0].getLineNumber()); 

				
		try {
			JSONArray array=jsonObject.getJSONArray("data");
			if(array.length()>0){
			for(int i=0;i<array.length() ;i++){
				JSONObject obj;
				obj = array.getJSONObject(i);	
				packageItems.add(new PackageItem(obj.getString("PACKAGE_TYPE")));	
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
			
							
				//System.out.println("==>"+new Throwable().getStackTrace()[0].getClassName()+" > "+new Throwable().getStackTrace()[0].getMethodName());
				//System.out.println("===>Line number: "+new Throwable().getStackTrace()[0].getLineNumber()); 

				
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
		
			mPullDownView = (PullDownView) view.findViewById(R.id.packagelistview);
			if(mPullDownView==null) return ;
			mPullDownView.setOnPullDownListener(this);
			lstPackage = mPullDownView.getListView();		
			lstPackage.setOnItemClickListener(this);
		
			lstPackage.setDividerHeight(0);
			lstPackage.setHeaderDividersEnabled(true);
		    packageItems = new ArrayList<PackageItem>();
			 adapter2 = new PackageListAdapter(context,packageItems);
			 lstPackage.setAdapter(adapter2);
		     mPullDownView.enableAutoFetchMore(true, 1);
			
		}
		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			
							
				//System.out.println("==>"+new Throwable().getStackTrace()[0].getClassName()+" > "+new Throwable().getStackTrace()[0].getMethodName());
				//System.out.println("===>Line number: "+new Throwable().getStackTrace()[0].getLineNumber()); 

			   final PackageItem item = (PackageItem ) packageItems.get(position);
			   
			   FragmentManager fm=getFragmentManager();
			 //  Fragment fraagment=fm.findFragmentByTag("apqpdata2");
			 //  Fragment fraagment=this.parent;
			//   EditText xa518=(EditText)fraagment.getView().findViewById(R.id.xa518);
			  
			//   if(xa518!=null){
			//	   xa518.setText(item.getPackage());
			  // }
			   this.doWork(item);
			   closeFragment();
			   // Bundle bundle = new Bundle();
				//bundle.putString("xa517", item.getEmpNo());
			    //((MainActivity) getActivity()).callApqpDataActivity(bundle);
			
		}
		private void closeFragment()
		{
							
				//System.out.println("==>"+new Throwable().getStackTrace()[0].getClassName()+" > "+new Throwable().getStackTrace()[0].getMethodName());
				//System.out.println("===>Line number: "+new Throwable().getStackTrace()[0].getLineNumber()); 

			 FragmentManager fm=getFragmentManager();
        	 fm.beginTransaction().remove(fm.findFragmentByTag("PackageType")).commit();
        	 fm.popBackStack();
        	 fm.beginTransaction().show(this.parent).commit();  
			
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
	    	InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE); 
	        imm.hideSoftInputFromWindow(sv.getWindowToken(), 0);
	        searchEdit.clearFocus();
	        return true;
	    }

}
