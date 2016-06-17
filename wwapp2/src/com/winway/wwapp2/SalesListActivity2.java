package com.winway.wwapp2;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnKeyListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.winway.wwapp2.PullDownView.OnPullDownListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SalesListActivity2 extends BaseFragment implements OnPullDownListener, OnItemClickListener {
	private Context context ;
	private Bundle bundle;
	private View mView=null;
	private int ACTION_MESSAGE;
	private SalesListAdapter2 adapter2;
	private ArrayList<SalesItem2> salesItems;
	private PullDownView mPullDownView;
    private List<Map<String,String>> mStrings = new ArrayList<Map<String,String>>();
	protected static final int REFRESH_DATA = 0x00000002;
	private static final int WHAT_DID_LOAD_DATA = 0;
	private static final int WHAT_DID_REFRESH = 1;
	private static final int WHAT_DID_MORE = 5;
	private Button btnCancel=null;
	private int page=1;
	private EditText editSearch;
	private ListView lstSales;
	private TextView lb_cancel;
	   //C
	   private void closeFragment() {
		   if(parent!=null){
		      this.fragmentManager.beginTransaction().remove(this).commit();
		      this.fragmentManager.beginTransaction().show(parent).commit();
		   }
	    }
        //I
		private View initView(LayoutInflater inflater, ViewGroup container) {
			View view = inflater.inflate(R.layout.actsaleslist2, container, false);
			context = view.getContext();
			initUI(view);
			page=1;
			bundle=this.getArguments();
			queryData(WHAT_DID_LOAD_DATA);
			return view;
		}
		private void initUI(View view)
		{
			lb_cancel=(TextView)view.findViewById(R.id.lb_cancel);
			lb_cancel.setOnClickListener(new OnClickListener(){
				@Override
				public void onClick(View v)
				{

					closeFragment();
				}

			});
			editSearch=(EditText)view.findViewById(R.id.editSearch);
			editSearch.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {

				}
			});
			editSearch.setOnTouchListener(new OnTouchListener() {
				@Override
				public boolean onTouch(View v, MotionEvent event) {
					if (event.getAction() == MotionEvent.ACTION_UP) {

					}
					return false;
				}
			});

			editSearch.setOnFocusChangeListener(new OnFocusChangeListener() {
				@Override
				public void onFocusChange(View v, boolean hasFocus) {

					if (hasFocus) {

					} else {

					}
				}
			});
			editSearch.setOnKeyListener(new OnKeyListener() {
				public boolean onKey(View v, int keyCode, KeyEvent event) {
					// If the event is a key-down event on the "enter" button
					if ((event.getAction() == 0) && (keyCode == 66)) {
						// Perform action on key press
						page = 1;
						salesItems.clear();
						queryData(WHAT_DID_LOAD_DATA);
						return true;
					}
					return false;
				}
			});
			btnCancel=(Button) view.findViewById(R.id.btn_cancel);
			if(btnCancel!=null){
				btnCancel.setOnClickListener(new OnClickListener() {
			         public void onClick(View v) {
                        closeFragment();
				        }
				    });
				
			}
			initPullDownView(view);
			
		}
		private void initPullDownView(View view)
		{
		/*
			 * 1.使用PullDownView
			 * 2.設置OnPullDownListener
			 * 3.從mPullDownView里面獲取ListView
			 */
		
			mPullDownView = (PullDownView) view.findViewById(R.id.saleslistview);
			if(mPullDownView==null) return ;
			mPullDownView.setOnPullDownListener(this);
			lstSales = mPullDownView.getListView();		
			lstSales.setOnItemClickListener(this);
			/*ColorDrawable cd=new ColorDrawable(R.color.red);
			lstSales.setDivider(cd);
			lstSales.setChoiceMode(ListView.CHOICE_MODE_SINGLE);*/
			lstSales.setDividerHeight(0);
			lstSales.setHeaderDividersEnabled(true);
			//adapter2 = new SimpleAdapter(context,mStrings,R.layout.pulldown_item,new String[]{"title","content"},new int[] {R.id.msg_title2,R.id.msg_content} );
		     salesItems = new ArrayList<SalesItem2>();
			 adapter2 = new SalesListAdapter2(context,salesItems);
			 lstSales.setAdapter(adapter2);
		     mPullDownView.enableAutoFetchMore(true, 1);
			
		}
		//L
		@Override
		public void loadData(Object result)
		  {
			try {
				JSONObject jsonObject=new JSONObject((String)result);
				setSalesItems(jsonObject);
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
			try {
				JSONObject jsonObject=new JSONObject((String)result);
				salesItems.clear();
				setSalesItems(jsonObject);
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
				try {
					JSONObject jsonObject=new JSONObject((String)result);
					setSalesItems(jsonObject);
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
		//O
		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) 
		{		
		           return initView(inflater, container);
		}
		@Override
	    public void onRefresh() {
         // TODO Auto-generated method stub
		new Thread(new Runnable() {
					@Override
					public void run() {
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
						//String result="";
						page+=1;
						queryData(WHAT_DID_MORE);    
					}
				}).start();
				
			}
		//Q
		private void queryData(int Message)
		{
					 String json="";		
					   //  String url="http://59.125.146.7:8080/APQPService/GetMsgList?USERID=mis&PAGE="+Integer.toString(page)+"&WWID=13145774WWGlobal999988msg";
						 String url=super.getWebServiceUrl()+"openWindow1CS";
					     JSONObject jsonObject = new JSONObject();
					     JSONObject data=new JSONObject();
				         try {
				        	   data.accumulate("condition", editSearch.getText().toString());
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
		//S
		private void setSalesItems(JSONObject jsonObject)
		{
		try {
				JSONArray array=jsonObject.getJSONArray("data");
				if(array.length()>0){
				for(int i=0;i<array.length() ;i++){
					JSONObject obj;
					obj = array.getJSONObject(i);	
					salesItems.add(new SalesItem2(obj.getString("YD001"),obj.getString("YD002")));
    		      }
				adapter2.notifyDataSetChanged();
				}
			   } catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	    @Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
					long id) {
		 final SalesItem2 item = (SalesItem2) salesItems.get(position);
		           FragmentManager fm=getFragmentManager();
				   Fragment fraagment=this.parent;
				   if(bundle!=null&&bundle.size()>0){
					   if(bundle.getString("controltype").equals("EditText"))
					   {
						   EditText editText=(EditText)fraagment.getView().findViewById(bundle.getInt("controlid"));
						   if(editText!=null){
							   editText.setText(item.getEmpNo());
						   }
					   }
					   else if(bundle.getString("controltype").equals("TextView"))
					   {
						   TextView textView=(TextView)fraagment.getView().findViewById(bundle.getInt("controlid"));
						   if(textView!=null){
							   textView.setText(item.getEmpNo());
						   }
					   }
				   }
				   closeFragment();			  
				
			}
		
}
