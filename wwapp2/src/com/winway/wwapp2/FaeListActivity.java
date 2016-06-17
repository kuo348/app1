package com.winway.wwapp2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.R.string;
import android.app.ActionBar;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnKeyListener;
import android.view.View.OnTouchListener;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.SimpleAdapter;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.TextView.OnEditorActionListener;

import com.winway.wwapp2.PullDownView.OnPullDownListener;

public class FaeListActivity extends BaseFragment implements OnPullDownListener, OnItemClickListener{
	private ListView lstView;
	//private SimpleAdapter adapter2;
	private FaeListAdapter adapter2;
	private TypedArray navMenuIcons;
	private TypedArray navMenuIcons2;
	private ArrayList<FaeItem> faeItems;
	private Context context ;
	private PullDownView mPullDownView;
    private List<Map<String,String>> mStrings = new ArrayList<Map<String,String>>();
	protected static final int REFRESH_DATA = 0x00000002;
	private static final int WHAT_DID_LOAD_DATA = 0;
	private static final int WHAT_DID_REFRESH = 1;
	private static final int WHAT_DID_MORE = 5;
	private int ACTION_MESSAGE;
	private  int page = 1;
	private Bundle bundle;	
	private EditText editSearch;
	private Button btnAdvSearch,btnReturnFae;
	private Button btnCancel,btnAddFae;
	private String strSearchText="";
	private RelativeLayout r1;
	private RelativeLayout r2;
	private RelativeLayout r3;
	private RadioGroup radioGroup;
	private RadioButton tabSheet;
	private RadioButton tabFae;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		return initView(inflater, container);
	}

	private View initView(LayoutInflater inflater, ViewGroup container) {
		 fragmentManager = getFragmentManager();
		View view = inflater.inflate(R.layout.actfaelist, container, false);
		context = view.getContext();		  
		 bundle=this.getArguments();
		 InitUI(view);
		//View view2 = inflater.inflate(R.layout.pulldown, container, false);
		initPullDownView(view);
		ACTION_MESSAGE=WHAT_DID_LOAD_DATA;
		page=1;
		if(faeItems.size()==0)		
	   queryData(WHAT_DID_LOAD_DATA);
		return view;
	}
	private void showAdvSearchDialog()
	{
		   
		     Fragment fragment=new FaeAdvSearchActivity();
		     ((BaseFragment)fragment).setParent((Fragment)this);
			fragment.setRetainInstance(true);
		  if(fragmentManager.findFragmentById(fragment.getId())==null)
		     {
		    	  fragmentManager.beginTransaction().add(R.id.content_frame, fragment,"fae_adv_search").commit();
		     }
		    if(fragmentManager.findFragmentByTag("faelist")!=null){
		    	 fragmentManager.beginTransaction().hide(fragmentManager.findFragmentByTag("faelist")).commit();    	
		    }
		   
		    fragmentManager.beginTransaction().show(fragment).commit();
		
	}
	private void backToCustService()
	{
		//CustServiceActivity activity = new CustServiceActivity();
		//activity.setRetainInstance(true);
		//this.fragmentManager.beginTransaction().replace(R.id.content_frame, activity).commit();
		 MainActivity activity=(MainActivity)getActivity();
	     activity.selectItem(2);
	}
	private void showNewFaeDialog()
	{
		     //fragmentManager = getFragmentManager();
		     FaeDataActivity activity=new FaeDataActivity();
		     activity.setParent(this);
			 activity.setRetainInstance(true);
		  if(fragmentManager.findFragmentById(activity.getId())==null)
		     {
		    	  fragmentManager.beginTransaction().add(R.id.content_frame, activity,"fae_data").commit();
		     }
             fragmentManager.beginTransaction().hide(this).commit();    	
		     fragmentManager.beginTransaction().show(activity).commit();
		
	}
	private void InitUI(View view)
	{
		   this.r1 = ((RelativeLayout)view.findViewById(R.id.fae_r1));
		    this.r2 = ((RelativeLayout)view.findViewById(R.id.fae_r2));
		    this.r3= ((RelativeLayout)view.findViewById(R.id.fae_r3));
		    this.radioGroup =(RadioGroup)view.findViewById(R.id.radiogroup1);
		    this.btnAdvSearch=(Button)view.findViewById(R.id.btn_fae_adv_search);
		    this.btnCancel=(Button)view.findViewById(R.id.btn_fae_cancel);
		    this.btnReturnFae=(Button)view.findViewById(R.id.btnReturnFAE);
		    this.btnAddFae=(Button)view.findViewById(R.id.btnAddFae);
		    this.tabSheet=(RadioButton)view.findViewById(R.id.tabSheet);
		    this.tabFae=(RadioButton)view.findViewById(R.id.tabFae);
		    this.editSearch = (EditText)view.findViewById(R.id.search_text);
		    btnReturnFae.setOnClickListener(new OnClickListener(){
		    	@Override
		    	public void onClick(View v){
		    		backToCustService();
		    	}	    	
		    });
		    btnAddFae.setOnClickListener(new OnClickListener(){
		    	@Override
		    	public void onClick(View v){
		    		showNewFaeDialog();
		    	}	    	
		    });
		    btnAdvSearch.setOnClickListener(new OnClickListener(){
		    	@Override
		    	public void onClick(View v){
		    		showAdvSearchDialog();
		    	}	    	
		    });
		    tabSheet.setOnClickListener(new OnClickListener(){
		    	@Override
		    	public void onClick(View v){
		    		tabSheet.setTextColor(getActivity().getApplication().getResources().getColor(R.color.red));
		    		tabFae.setTextColor(getActivity().getApplication().getResources().getColor(R.color.white));
		    	}	    	
		    });
		    tabFae.setOnClickListener(new OnClickListener(){
		    	@Override
		    	public void onClick(View v){
		    		tabSheet.setTextColor(getActivity().getApplication().getResources().getColor(R.color.white));
		    		tabFae.setTextColor(getActivity().getApplication().getResources().getColor(R.color.red));
		    		
		    	}	    	
		    });
		    btnCancel.setOnClickListener(new OnClickListener(){
		    	@Override
		    	public void onClick(View v){
		    		strSearchText ="";
		    		  if(btnAdvSearch.getVisibility()!=View.VISIBLE){
	   	    		   btnAdvSearch.setVisibility(View.VISIBLE);
		    		   }  
	   	    	if(btnCancel.getVisibility()==View.VISIBLE){
	   	    		   btnCancel.setVisibility(View.GONE);
		    		   }
	   	    	 if(r3.getVisibility()==View.VISIBLE){
	   	    		   r3.setVisibility(View.GONE);	    	    		 
	   	    	 }
	   	 	 if(r1.getVisibility()!=View.VISIBLE){
	  		      r1.setVisibility(View.VISIBLE);	    	    		 
	  	      }
	   	    	
		    		
		    	}	    	
		    });
		   	    editSearch.clearFocus();
		    //set Search Edit On Click Event
		    this.editSearch.setOnClickListener(new OnClickListener(){
		    	   @Override
		    	   public void onClick(View view)
		    	   {
		    		   //((MainActivity)getActivity()).hideActionbar();
		    	   }
		      });
		    //set Search Edit OnTouch Event
		    this.editSearch.setOnTouchListener(new OnTouchListener(){
		    	   @Override
		    	   public boolean onTouch(View view, MotionEvent event)
		    	   {
		    		   //editSearch.setInputType(InputType.TYPE_NULL); // 關閉軟鍵盤
		    	     return false;
		    	   }
		      });
		    //set Search Edit Focus Event
		    this.editSearch.setOnFocusChangeListener(new OnFocusChangeListener(){
		    	@Override
		    	 public void onFocusChange(View v, boolean hasFocus)
		    	  {
		    	    if (hasFocus)
		    	    {
		    	    	//InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE); 
		            	//imm.hideSoftInputFromWindow(editSearch.getWindowToken(), 0);	
		    	    	 // ((MainActivity)getActivity()).hideActionbar(); 
		    	    	if(btnAdvSearch.getVisibility()==View.VISIBLE){
		    	    		   btnAdvSearch.setVisibility(View.GONE);
			    		   }  
		    	    	if(btnCancel.getVisibility()!=View.VISIBLE){
		    	    		   btnCancel.setVisibility(View.VISIBLE);
			    		   }
		    	    	 if(r3.getVisibility()!=View.VISIBLE){
		    	    		   r3.setVisibility(View.VISIBLE);	    	    		 
		    	    	 }
		    	    	 if(r1.getVisibility()==View.VISIBLE){
		    	    		   r1.setVisibility(View.GONE);	    	    		 
		    	    	 }
		    	    }
		    	  }
		    	
		    });
		    this.editSearch.setOnKeyListener(new OnKeyListener(){
		    	@Override
		    	 public boolean onKey(View view, int args, KeyEvent keyEvent)
		    	  {	    	
		    			if ((keyEvent.getAction() == 0) && (args== 66))
		    				{
		    				     int rid=radioGroup.getCheckedRadioButtonId();
		    				     if( rid==R.id.tabSheet)
		    				     {
		    				    	  strSearchText = "fae001:"+editSearch.getText().toString();
		    				     }
		    				     else {
		    				    	  strSearchText = "fae012:"+ editSearch.getText().toString();    				    	 
		    				     }
		    	               
		    	                 bundle.clear();
		    	                 page=1;
		    	                 ACTION_MESSAGE=WHAT_DID_LOAD_DATA;
		    	                  faeItems.clear();
		    					  queryData(ACTION_MESSAGE);
		    				}	    
		    				return false;
		    	  }			
		    });
		    this.editSearch.setOnEditorActionListener(new OnEditorActionListener() {
		        public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
		            if ((event != null && ((event.getKeyCode() == KeyEvent.KEYCODE_ENTER)) || 
		            		(actionId == EditorInfo.IME_ACTION_DONE)||(actionId == EditorInfo.IME_ACTION_SEARCH))) {
		          
		            	 int rid=radioGroup.getCheckedRadioButtonId();
    				     if( rid==R.id.tabSheet)
    				     {
    				    	  strSearchText = "fae001:"+editSearch.getText().toString();
    				     }
    				     else {
    				    	  strSearchText = "fae012:"+ editSearch.getText().toString();    				    	 
    				     }
    	               
    	               //  bundle.clear();
    	                 page=1;
    	                 ACTION_MESSAGE=WHAT_DID_LOAD_DATA;
    	                  faeItems.clear();
    					  queryData(ACTION_MESSAGE);
						  editSearch.clearFocus();	
		            }    
		            return false;
		        }
		    });
		
	}
	public void showActionbar()
	{
	    ActionBar mActionBar=getActivity().getActionBar();
        if(mActionBar!=null&&mActionBar.isShowing()==false)mActionBar.show();
	}
	private void initPullDownView(View view)
	{
		/*
		 * 1.使用PullDownView
		 * 2.設置OnPullDownListener
		 * 3.從mPullDownView里面獲取ListView
		 */
	
		mPullDownView = (PullDownView) view.findViewById(R.id.faelistview);
		if(mPullDownView==null) return ;
		mPullDownView.setOnPullDownListener(this);
		lstView = mPullDownView.getListView();		
		lstView.setOnItemClickListener(this);
		ColorDrawable cd=new ColorDrawable(R.color.list_divider);
		lstView.setDivider(cd);
		lstView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
		lstView.setDividerHeight(1);
		lstView.setHeaderDividersEnabled(true);
		//adapter2 = new SimpleAdapter(context,mStrings,R.layout.pulldown_item,new String[]{"title","content"},new int[] {R.id.msg_title2,R.id.msg_content} );
		faeItems = new ArrayList<FaeItem>();
		 adapter2 = new FaeListAdapter(context,faeItems);
		 lstView.setAdapter(adapter2);
	    mPullDownView.enableAutoFetchMore(true, 1);
		
	}
	private void setFaeItems(JSONObject  object) throws JSONException
	{
		JSONArray array=object.getJSONArray("data");
		navMenuIcons = getResources().obtainTypedArray(R.array.fae_list_icons);
		int icon;
		//如果回傳資料大於零，而且頁數仍是1，則清空舊資料
		if(array.length()>0&&page==1){
			faeItems.clear();
		}
		//msgItems = new ArrayList<MsgItem>();
		for(int i=0;i<array.length() ;i++){
			JSONObject jsonObject=array.getJSONObject(i);
			String fae001= jsonObject.getString("fae001");
			String fae006=(jsonObject.getString("fae006").length()>12) ?String.format("%s...",jsonObject.getString("fae006").substring(0,12)):jsonObject.getString("fae006"); 
			String fae012=(jsonObject.getString("fae012").length()>12) ?String.format("%s...",jsonObject.getString("fae012").substring(0,12)):jsonObject.getString("fae012"); 
			String fae022=(jsonObject.getString("fae022").length()>12) ? String.format("%s...",jsonObject.getString("fae022").substring(0,12)):jsonObject.getString("fae022"); 
       if(jsonObject.getString("fae029").equals("RB01")){
        	 icon=navMenuIcons.getResourceId(0, -1);	
       }
        else   if(jsonObject.getString("fae029").equals("RB02")){
            	 icon=navMenuIcons.getResourceId(1, -1);	               
		}
		else {
			 icon=navMenuIcons.getResourceId(2, -1);	               
			
		}
		faeItems.add(new FaeItem(fae001,fae006,fae012,fae022,icon));	
		}
		// Recycle the typed array
		navMenuIcons.recycle();		
	}
	@Override
	public void loadData(Object obj)
	{
		try {   
    	    setFaeItems(new JSONObject((String)obj));
    		 if(faeItems.size()==0&&page>1)page--;
    		 adapter2.notifyDataSetChanged();
    		 mPullDownView.notifyDidLoad();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//Toast.makeText(NavbarHomeActivity.this,"recevie erroe:"+e.toString(), Toast.LENGTH_SHORT).show();
		}
		
	}
	@Override
	public void loadMoreData(Object obj){
		try {    	
    	    setFaeItems(new JSONObject((String)obj));
    		 if(faeItems.size()==0&&page>1)page--;
    		 adapter2.notifyDataSetChanged();
    			mPullDownView.notifyDidMore();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//Toast.makeText(NavbarHomeActivity.this,"recevie erroe:"+e.toString(), Toast.LENGTH_SHORT).show();
		}
	
	}
	@Override
	public void loadRefreshData(Object obj){
		try {    	
    	    setFaeItems(new JSONObject((String)obj));
    		 if(faeItems.size()==0&&page>1)page--;
    		 adapter2.notifyDataSetChanged();
    		 mPullDownView.notifyDidRefresh();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//Toast.makeText(NavbarHomeActivity.this,"recevie erroe:"+e.toString(), Toast.LENGTH_SHORT).show();
		}
		
	}
	@SuppressWarnings("deprecation")
	private void queryData(int Message)
	{
		 String json="";		
	   //  String url="http://59.125.146.7:8080/APQPService/GetMsgList?USERID=mis&PAGE="+Integer.toString(page)+"&WWID=13145774WWGlobal999988msg";
		 String url=super.getWebServiceUrl()+"queryFAE";
	     JSONObject jsonObject = new JSONObject();
	     JSONObject data=new JSONObject();
         try {
        	 if(bundle==null||bundle.size()==0){
        		   if(strSearchText.length()>0 ){
       			    String sKey=strSearchText.split(":")[0];
       			    String sValue=strSearchText.split(":")[1];
       			 	data.accumulate(sKey,sValue);        
        			   
        		   }else {
        			   			Calendar calendar = Calendar.getInstance();
        			   			data.accumulate("fae001",calendar.get(Calendar.YEAR));
        			   			data.accumulate("fae006","");
        			   			data.accumulate("fae012","");
        			   			data.accumulate("fae017","");
        			   			data.accumulate("fae022","");
        			   			data.accumulate("fae023","");
        		   }
        		}
        	 else {
        			Set<String> keys = bundle.keySet();
        			for (String key : keys) {
        					try {
        							data.accumulate(key, bundle.get(key));
        					} 
        					catch(JSONException e) {  }
        				}        		 
        	 }
			   jsonObject.accumulate("userid",super.getLoginUser());
			   jsonObject.accumulate("WWID", "13145774WWGlobal999988faequery999");
			   jsonObject.accumulate("data", data);
			   jsonObject.accumulate("page", Integer.toString(page));
			   //new HttpPostAsyncTask().execute(url,jsonObject.toString());
			   super.postRequest(url, jsonObject,Message);
			   
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      
	    // new HttpGetAsyncTask().execute(url);
		
	}
	
	public void setTitle(CharSequence title) {
        getActivity().getActionBar().setTitle(title);
    }
  public void callAdvSearch(Bundle b)
  {	  
	    page=1;
	    ACTION_MESSAGE=WHAT_DID_LOAD_DATA;	   
	     bundle=b;
	     queryData(ACTION_MESSAGE);	  
  }
	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		// TODO Auto-generated method stub
		 final FaeItem item= (FaeItem) faeItems.get(position);
		    Bundle bundle = new Bundle();
	    	bundle.putString("fae001", item.getFAE001());
            ((MainActivity) getActivity()).callFaeDataActivity(bundle);
      
		   
	}

	@Override
	public void onRefresh() {
		// TODO Auto-generated method stub
new Thread(new Runnable() {
			
			@Override
			public void run() {
				String result="";				
		        ACTION_MESSAGE=WHAT_DID_REFRESH;
			    queryData(ACTION_MESSAGE);
		      	     
				
			}
		}).start();
	}

	@Override
	public void onMore() {
		// TODO Auto-generated method stub
new Thread(new Runnable() {
			
			@Override
			public void run() {
				String result="";
				page+=1;
		        ACTION_MESSAGE=WHAT_DID_MORE;
			    queryData(ACTION_MESSAGE);
		      	     
				
			}
		}).start();
		
	}	
}
