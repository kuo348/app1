package com.winway.wwapp2;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.winway.wwapp2.PullDownView.OnPullDownListener;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.PaintDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class CustomerContactAddressListActivity extends BaseFragment  implements OnPullDownListener, OnItemClickListener
{
	private Context context;
	private Bundle bundle;
	private View mView = null;	
	private String strContactListUrl;
	private String strAddressListUrl;
	private ListView lstContact,lstAddress;
	private ContactListAdapter2 contactAdapter;
	private AddressListAdapter2 addressAdapter;
	private ArrayList<ContactItem2> contactItems;
	private ArrayList<AddressItem2> addressItems;
	private PullDownView mPullDownView,mPullDownView2;
	protected static final int REFRESH_DATA = 0x00000002;
	private static final int WHAT_DID_LOAD_DATA = 0;
	private static final int WHAT_DID_REFRESH = 1;
	private static final int WHAT_DID_MORE = 5;
	private int ACTION_MESSAGE;
	private  int addressPage = 1,contactPage=1;
	private TextView lb_contact,lb_address,lb_cust_title_text;
	private Button btn_return;
	private int activeTabIndex;
	// C
	   private void closeFragment() 
	    {
		   if(this.parent!=null){
			this.fragmentManager.beginTransaction().remove(this).commit();
			this.fragmentManager.beginTransaction().show(parent).commit();
			}
		}
    // G
	 private int getActiveTab()
	 {
		 return activeTabIndex;
	 }
	// I
	   
			private View initView(LayoutInflater inflater, ViewGroup container) {
				View view = inflater.inflate(R.layout.actcustomer_detail2, container,
						false);
				context=view.getContext();
				bundle = this.getArguments();
				mView=view;
				initUI(view);
				queryContactData();
				//queryAddressData();
				return view;

			}

			private void initUI(View v) {
				final RelativeLayout  r4,r5;
				activeTabIndex=0;
				strContactListUrl=super.getWebServiceUrl()+"queryContacts";
				strAddressListUrl=super.getWebServiceUrl()+"queryAddresses";
				lb_contact=(TextView )v.findViewById(R.id.lb_contact);
				lb_address=(TextView )v.findViewById(R.id.lb_address);
				r4=(RelativeLayout )v.findViewById(R.id.cust_detail2_r4);
				r5=(RelativeLayout )v.findViewById(R.id.cust_detail2_r5);
				btn_return=(Button)v.findViewById(R.id.btn_return);
				
				lb_cust_title_text=(TextView)v.findViewById(R.id.cust_title_text);
				//顯示客戶簡稱
				lb_cust_title_text.setText(bundle.getString("occ02"));
				//
				btn_return.setOnClickListener(new OnClickListener(){
					public void onClick(View v){
						closeFragment();
					}
					
				});
				lb_contact.setOnClickListener(new OnClickListener(){
					public void onClick(View v){
						activeTabIndex=0;
						lb_contact.setBackgroundColor(Color.BLACK);
						lb_address.setBackgroundColor(Color.GRAY);
						lb_contact.setTextColor(Color.BLUE);
						lb_address.setTextColor(Color.WHITE);
						r5.setVisibility(View.GONE);
						r4.setVisibility(View.VISIBLE);
						if(contactItems.size()==0){
							queryContactData();
						}
						
					}
					
				});
				lb_address.setOnClickListener(new OnClickListener(){
					public void onClick(View v){
						activeTabIndex=1;
						lb_contact.setBackgroundColor(Color.GRAY);
						lb_address.setBackgroundColor(Color.BLACK);
						lb_contact.setTextColor(Color.WHITE);
						lb_address.setTextColor(Color.BLUE);
						r4.setVisibility(View.GONE);
						r5.setVisibility(View.VISIBLE);
						if(addressItems.size()==0){
							queryAddressData();
						}
						
						
					}
					
				});
				initPullDownView(v);
				
			}
			//初始化下拉載入更多資料
			private void initPullDownView(View view)
			{
				/*
				 * 1.使用PullDownView
				 * 2.設置OnPullDownListener
				 * 3.從mPullDownView里面獲取ListView
				 */
			
				mPullDownView = (PullDownView) view.findViewById(R.id.contactlistview);
				if(mPullDownView==null) return ;
				mPullDownView.setOnPullDownListener(this);
				lstContact = mPullDownView.getListView();		
				lstContact.setOnItemClickListener(this);
				lstContact.setDividerHeight(0);
				lstContact.setHeaderDividersEnabled(true);
				 contactItems = new ArrayList<ContactItem2>();
				 contactAdapter = new ContactListAdapter2(context,contactItems);
				 lstContact.setAdapter(contactAdapter);
			     mPullDownView.enableAutoFetchMore(true, 1);
			     //address 
			 	mPullDownView2 = (PullDownView) view.findViewById(R.id.addresslistview);
				if(mPullDownView2==null) return ;
				mPullDownView2.setOnPullDownListener(this);
				lstAddress = mPullDownView2.getListView();		
				lstAddress.setOnItemClickListener(this);
				lstAddress.setDividerHeight(0);
				lstAddress.setHeaderDividersEnabled(true);
				addressItems = new ArrayList<AddressItem2>();
				addressAdapter = new AddressListAdapter2(context,addressItems);
				lstAddress.setAdapter(addressAdapter);
			    mPullDownView2.enableAutoFetchMore(true, 1);
			}
			// L
			@Override
			public void loadData(Object result) {
				try {
					JSONObject jsonObject = new JSONObject((String) result);
					if (!jsonObject.getString("success").equals("true")) {
						showDialog("error", jsonObject.getString("remark"));
						return;
					}				    
                    if(getActiveTab()==0){
                        setContactItems(jsonObject);
    					mPullDownView.notifyDidLoad();                    	
                    }
                    else {
                    	 setAddressItems(jsonObject);
     					mPullDownView2.notifyDidLoad();   
                    	
                    }
					
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}  
			
			@Override
			  public void loadRefreshData(Object result)
			  {
				try {					
					
					if(getActiveTab()==0){
						JSONObject jsonObject=new JSONObject((String)result);
					   contactItems.clear();
					   setContactItems(jsonObject);
					   mPullDownView.notifyDidRefresh();
					   contactPage=1;
					}
					else {
						JSONObject jsonObject=new JSONObject((String)result);
						   addressItems.clear();
						   setAddressItems(jsonObject);
						   mPullDownView2.notifyDidRefresh();	
						   addressPage=1;
					}
					
					
					}
				catch (JSONException e) {
					// TODO Auto-generated catch block
					if(getActiveTab()==0){
						mPullDownView.notifyDidRefresh();
					}
					else {						
						 mPullDownView2.notifyDidRefresh();	
					}
					e.printStackTrace();
				}
					  
			  }	
			
			//載入更多資料
			@Override
			  public void loadMoreData(Object result)
			  {
				//System.out.println("==>"+new Throwable().getStackTrace()[0].getClassName()+" > "+new Throwable().getStackTrace()[0].getMethodName());
				//System.out.println("===>Line number: "+new Throwable().getStackTrace()[0].getLineNumber()); 
		   		
					try {
						JSONObject jsonObject=new JSONObject((String)result);						
						JSONArray array=jsonObject.getJSONArray("data");
						
						if(getActiveTab()==0){
							if(array.length()==0){
								contactPage=contactPage-1;		
							}
							else {
							   setContactItems(jsonObject);
							}
							   mPullDownView.notifyDidMore();
							}
							else {
								if(array.length()==0){
									addressPage=addressPage-1;		
								}
								else {
								   setAddressItems(jsonObject);
								}
								   mPullDownView2.notifyDidMore();					
							}
						
						}
					catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					  
			  }
		
			// O
			@Override
			public View onCreateView(LayoutInflater inflater, ViewGroup container,
					Bundle savedInstanceState) {
		        
				return initView(inflater, container);
			}
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position,
					long id) {
				 Fragment fragment;
				 if(getActiveTab()==0){ 
					 ContactItem2 item=contactItems.get(position);
					 CustomerContactDataActivity activity=new CustomerContactDataActivity();
					 activity.parent=this;
					 if(this.fragmentManager==null)this.fragmentManager =getActivity().getFragmentManager();
					 activity.fragmentManager =this.fragmentManager;
					 fragment=(Fragment)activity;
					 Bundle b=new Bundle();
					 b.putString("occ02", bundle.getString("occ02"));
					 b.putString("oce01", bundle.getString("occ01"));
					 b.putString("oce03", item.getIndex());
					 b.putString("ta_oce03",item.getName());
					 fragment.setArguments(b);		
					 this.fragmentManager.beginTransaction().add(R.id.content_frame, fragment, "customerdata_details2_contact").commit();
				 }
				 else {
					 AddressItem2 item=addressItems.get(position);
					 CustomerAddressDataActivity activity=new CustomerAddressDataActivity();
					 activity.parent=this;
					 if(this.fragmentManager==null)this.fragmentManager =getActivity().getFragmentManager();
					 activity.fragmentManager =this.fragmentManager;
					 fragment=(Fragment)activity;
					 Bundle b=new Bundle();
					 b.putString("occ02", bundle.getString("occ02"));
					 b.putString("ocd01", bundle.getString("occ01"));
					 b.putString("ocd02", item.getIndex());
					 b.putString("id",item.getAddress());
					 b.putString("occ18",bundle.getString("occ18"));
					 fragment.setArguments(b);		
					
					 this.fragmentManager.beginTransaction().add(R.id.content_frame, fragment, "customerdata_details2_address").commit();
					 
				 }
				fragment.setRetainInstance(true);
				this.fragmentManager.beginTransaction()
				.hide(this)
				.commit();
				this.fragmentManager.beginTransaction().show(fragment).commit();
			}
			@Override
			public void onRefresh() {
				// TODO Auto-generated method stub
				//執行緒
		new Thread(new Runnable() {
					
					@Override
					public void run() {
			    		String result="";				
				        ACTION_MESSAGE=WHAT_DID_REFRESH;
				        if(getActiveTab()==0){
							contactPage=1;
							queryContactData();
						}
						else {
							addressPage=1;	
							queryAddressData();
						}
				        
					    
				      	     
						
					}
				}).start();
			}

			@Override
			public void onMore() {
				// TODO Auto-generated method stub
				//Runnable =>被處理的事件
				//Handler =>處理器		
		new Thread(new Runnable() {
					
					@Override
					public void run() {//需要背景作的事 //進入點
						String result="";
						 ACTION_MESSAGE=WHAT_DID_MORE;
						if(getActiveTab()==0){
							contactPage+=1;
							queryContactData();
						}
						else {
							addressPage+=1;	
							queryAddressData();
						}
						
				       
				       
					    
				      	     
						
					}
				}).start();
				
			}	
			//Q
			private void queryData() 
			{
				String url="";
				String wwid="";
				JSONObject jsonObject = new JSONObject();
				JSONObject data = new JSONObject();
				try {
					if(getActiveTab()==0){
						url=this.strContactListUrl;
						wwid="13145774WWGlobal999988contactquery999";
						data.accumulate("OCE01", "");
						data.accumulate("queryValue", "");
						jsonObject.accumulate("page", contactPage);
					}
					else {
						url=this.strAddressListUrl;
						wwid="13145774WWGlobal999988addressquery999";
						data.accumulate("OCD01", "");
						data.accumulate("queryValue", "");						
						jsonObject.accumulate("page", addressPage);
					}					
					jsonObject.accumulate("userid", super.getLoginUser());
					jsonObject.accumulate("WWID", wwid);
					jsonObject.accumulate("data", data);
					super.postRequest(url, jsonObject,ACTION_MESSAGE);

				} catch (JSONException e){
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
			private void queryData(String url,String wwid,JSONObject data,IDataReceiveListener listener) {
				//String json = "";
				JSONObject jsonObject = new JSONObject();
				try {
					//data.accumulate("OCC01", getCustId());
					jsonObject.accumulate("userid", super.getLoginUser());
					jsonObject.accumulate("WWID", wwid);
					jsonObject.accumulate("data", data);
					super.postRequest(url, jsonObject,listener);

				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
			private void queryContactData()
			{		
              try {		
					JSONObject data = new JSONObject();
					data.accumulate("OCE01", bundle.getString("occ01"));
					data.accumulate("queryValue", "");
				    queryData(strContactListUrl,
				    		  "13145774WWGlobal999988contactquery999",data,
				    		  new IDataReceiveListener(){
						       @Override
						        public void onReceiveData(Object result){
						    	   JSONObject jsonObject;
								try {
									 jsonObject = new JSONObject((String)result);
									 JSONArray array=jsonObject.getJSONArray("data");
									
								     if(ACTION_MESSAGE==WHAT_DID_REFRESH)
								     {
								    	 if(array.length() > 0){
								    		 contactItems.clear();
										     setContactItems(jsonObject);
										}
								    	 mPullDownView.notifyDidRefresh(); 
								     }
								     else if(ACTION_MESSAGE==WHAT_DID_MORE)
								     {
								    	 if(array.length() > 0){
										     setContactItems(jsonObject);
											 }
											 else {												 
												 contactPage-=1;
											 }
								    	 mPullDownView.notifyDidMore(); 
								     }
								     else {
								    	 if(array.length() > 0){
								            setContactItems(jsonObject);
										}
									    mPullDownView.notifyDidLoad();
								     }   
								} catch (JSONException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}						
									
						    		
							
						         }						
					          });
				

				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			private void queryAddressData()
			{
				 try {		
						JSONObject data = new JSONObject();
						data.accumulate("OCD01", bundle.getString("occ01"));
						data.accumulate("queryValue", "");
					    queryData(strAddressListUrl,
					    		  "13145774WWGlobal999988addressquery999",data,
					    		  new IDataReceiveListener(){
							       @Override
							        public void onReceiveData(Object result){
							    	   JSONObject jsonObject;
										try {
											 jsonObject = new JSONObject((String)result);
											 JSONArray array=jsonObject.getJSONArray("data");
											 
										     if(ACTION_MESSAGE==WHAT_DID_REFRESH)
										     {
										    	 if(array.length()>0) {
										    		 addressItems.clear();
													 setAddressItems(jsonObject);
												 }
										    	 mPullDownView2.notifyDidRefresh(); 
										     }
										     else if(ACTION_MESSAGE==WHAT_DID_MORE)
										     {
										    	 if(array.length()>0) {
													 setAddressItems(jsonObject);
												 }
												 else {												 
													 addressPage-=1;
												 }
										    	 mPullDownView2.notifyDidMore();
										    	 
										     }
										     else {
										    	 if(array.length() > 0){
											            setAddressItems(jsonObject);
													}
											    mPullDownView2.notifyDidLoad();
										     }
										} catch (JSONException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}				   
								
							         }						
						          });
					

					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
			//S
			private void setContactItems(JSONObject jsonObject)
			{
				try {
					if(jsonObject.getString("success") != null&& jsonObject.getString("success").equals("false")){
						return ;									
					}
					JSONArray array=jsonObject.getJSONArray("data");
					//如果回傳資料大於零，而且頁數仍是1，則清空舊資料
					if(array.length()>0&&contactPage==1){
						contactItems.clear();
					}
					for(int i=0;i<array.length();i++){
					 	JSONObject data=array.getJSONObject(i);
							contactItems.add(new ContactItem2(data.getString("TA_OCE01"),data.getString("OCE03")));	
						}
		
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
			private void setAddressItems(JSONObject jsonObject)
			{
				try {
					if(jsonObject.getString("success") != null&& jsonObject.getString("success").equals("false")){
						return ;									
					}
					JSONArray array=jsonObject.getJSONArray("data");
					//如果回傳資料大於零，而且頁數仍是1，則清空舊資料
					if(array.length()>0&&addressPage==1){
						addressItems.clear();
					}
					for(int i=0;i<array.length();i++){
					 	JSONObject data=array.getJSONObject(i);
							addressItems.add(new AddressItem2(data.getString("ADDRESS"),data.getString("OCD02"),data.getString("ID")));	
						}
		
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
}
