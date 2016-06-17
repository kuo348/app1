package com.winway.wwapp2;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class CustomerAddressDataActivity extends BaseFragment{
	private Context context;
	private Bundle bundle;
	private View mView ;	
	TextView lb_fullname,lb_add1,lb_add2;
	TextView ocd02,ocd221,ocd222,ocd228,ocd224,ocd226,ocd04,ta_ocdacti;
     Button btn_return_detail2;
     private OnClickListener onShowAddr1MapListener=new OnClickListener(){
		@Override
	    public void onClick(View v){
			if(ocd221.getText().toString()==""||ocd221.getText().toString().length()==0)
			{
				return ;				
			}
			callMapActivity("address",ocd221.getText().toString());		
		}
	  };
	  private OnClickListener onShowAddr2MapListener=new OnClickListener(){
			@Override
		    public void onClick(View v){
				if(ocd222.getText().toString()==""||ocd222.getText().toString().length()==0)
				{
					return ;				
				}
				callMapActivity("address",ocd222.getText().toString());
			}	
		  };
	//C
	   private void callMapActivity(String key,String value)
	   {   		   
		    Fragment fragment;
		     MapActivity activity=new MapActivity();
			 activity.parent=this;
			 activity.fragmentManager =getFragmentManager();
			 fragment=(Fragment)activity;
			 Bundle b=new Bundle();
			 b.putString(key,value);
			 b.putString("company", bundle.getString("occ18"));
			 fragment.setArguments(b);	
			 this.fragmentManager.beginTransaction().add(R.id.content_frame, fragment, "customerdata_details2_map").commit();
		     fragment.setRetainInstance(true);
		     this.fragmentManager.beginTransaction()
		    .hide(this)
		     .commit();
		     this.fragmentManager.beginTransaction().show(fragment).commit();	
	   }
	   private void closeFragment() 
	    {
			this.fragmentManager.beginTransaction().remove(this).commit();
			this.fragmentManager.beginTransaction().show(parent).commit();
		}
	// I
	   
		private View initView(LayoutInflater inflater, ViewGroup container) {
			View view = inflater.inflate(R.layout.actcustomer_detail2_address, container,
					false);
			context=view.getContext();
			bundle = this.getArguments();
			mView=view;
			initUI(view);
			queryData();
			return view;

		}

		private void initUI(View v) {
			btn_return_detail2=(Button) v.findViewById(R.id.btn_return_detail2);
			lb_fullname=(TextView) v.findViewById(R.id.lb_fullname);
			lb_add1=(TextView) v.findViewById(R.id.lb_add1);
			lb_add2=(TextView) v.findViewById(R.id.lb_add2);
			ocd02=(TextView) v.findViewById(R.id.ocd02);
			ocd02.setText(bundle.getString("ocd02"));//
			ocd221=(TextView) v.findViewById(R.id.ocd221);
			ocd222=(TextView) v.findViewById(R.id.ocd222);
			ocd228=(TextView) v.findViewById(R.id.ocd228);
			ocd224=(TextView) v.findViewById(R.id.ocd224);
			ocd226=(TextView) v.findViewById(R.id.ocd226);
			ocd04=(TextView) v.findViewById(R.id.ocd04);
			ta_ocdacti=(TextView) v.findViewById(R.id.ta_ocdacti);
			//
			btn_return_detail2.setText(bundle.getString("occ02"));
			lb_fullname.setText(bundle.getString("occ18"));
			btn_return_detail2.setOnClickListener(new OnClickListener(){
				@Override
			    public void onClick(View v){
					if(parent!=null){
						closeFragment();						
					}					
				}	
			});
			lb_add1.setOnClickListener(onShowAddr1MapListener);
			lb_add2.setOnClickListener(onShowAddr2MapListener);			
		    ocd221.setOnClickListener(onShowAddr1MapListener);
		    ocd222.setOnClickListener(onShowAddr2MapListener);
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
			    JSONObject data = jsonObject.getJSONObject("data");

				
			} catch (JSONException e) {
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
		//Q
		private void queryData() {
			//String json = "";
			String url = super.getWebServiceUrl() + "getAddress";
			JSONObject jsonObject = new JSONObject();
			JSONObject data = new JSONObject();
			try {
				data.accumulate("OCD01",bundle.getString("ocd01"));
				data.accumulate("OCD02",bundle.getString("ocd02"));
				jsonObject.accumulate("userid", super.getLoginUser());
				jsonObject.accumulate("WWID", "13145774WWGlobal999988address999");
				jsonObject.accumulate("data", data);
				super.postRequest(url, jsonObject,
						new IDataReceiveListener(){
				       		public void onReceiveData(Object result){
				       			try {
									JSONObject jsonObject=new JSONObject((String)result);
								    if(jsonObject.getString("success").equals("false")){
								    	return ;
								    }
								    JSONObject d=jsonObject.getJSONObject("data");
								   
									ocd04.setText(d.getString("OCD04"));//
									ocd221.setText(d.getString("OCD221"));//
									ocd222.setText(d.getString("OCD222"));//
									ocd224.setText(d.getString("OCD224"));//
									ocd226.setText(d.getString("OCD226"));//
									ocd228.setText(d.getString("OCD228"));//
									ta_ocdacti.setText(d.getString("TA_OCDACTI"));//
									ocd02.setText(d.getString("OCD02"));//
				       			
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
}
