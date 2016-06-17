package com.winway.wwapp2;

import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class CustomerContactDataActivity extends BaseFragment {
	private Context context;
	private Bundle bundle;
	private View mView;	
	private Button btn_return_detail2;
	private TextView ta_oce03,ta_oce02,ta_oce04,oce02,oce04,oce07,
	oce08,oce05,oce06,ta_oceacti,oce03,lb_contactname;
	// C
	   private void closeFragment() 
	    {
		   if(this.parent!=null){
			this.fragmentManager.beginTransaction().remove(this).commit();
			this.fragmentManager.beginTransaction().show(parent).commit();
		   }
		}
	// I
	   
			private View initView(LayoutInflater inflater, ViewGroup container) {
				View view = inflater.inflate(R.layout.actcustomer_detail2_contact, container,
						false);
				context=view.getContext();
				bundle = this.getArguments();
				mView=view;
				initUI(view);
				queryData();
				return view;

			}

			private void initUI(View v) {
				btn_return_detail2=(Button)v.findViewById(R.id.btn_return_detail2);
				btn_return_detail2.setOnClickListener(new OnClickListener(){
					@Override
					public void onClick(View v){
							closeFragment();
						}
				});
				btn_return_detail2.setText(bundle.getString("occ02"));
				lb_contactname=(TextView)v.findViewById(R.id.lb_contactname);
				lb_contactname.setText(bundle.getString("ta_oce03"));
				oce03=(TextView)v.findViewById(R.id.oce03);//聯絡人代號
				ta_oce03=(TextView)v.findViewById(R.id.ta_oce03);//歸屬公司
				ta_oce02=(TextView)v.findViewById(R.id.ta_oce02);//分機/專線
				ta_oce04=(TextView)v.findViewById(R.id.ta_oce04);//部門
				oce02=(TextView)v.findViewById(R.id.oce02);//職務
				oce04=(TextView)v.findViewById(R.id.oce04);//TEL_NO(一）
				oce07=(TextView)v.findViewById(R.id.oce07);//TEL_NO(二）
				oce08=(TextView)v.findViewById(R.id.oce08);//FAX_NO
				oce05=(TextView)v.findViewById(R.id.oce05);//
				oce06=(TextView)v.findViewById(R.id.oce06);//
				ta_oceacti=(TextView)v.findViewById(R.id.ta_oceacti);
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
				String url = super.getWebServiceUrl() + "getContact";
				JSONObject jsonObject = new JSONObject();
				JSONObject data = new JSONObject();
				try {
					data.accumulate("OCE01", bundle.getString("oce01"));
					data.accumulate("OCE03", bundle.getString("oce03"));
					jsonObject.accumulate("userid", super.getLoginUser());
					jsonObject.accumulate("WWID", "13145774WWGlobal999988contact999");
					jsonObject.accumulate("data", data);
					super.postRequest(url, jsonObject,
							new IDataReceiveListener(){
					       		public void onReceiveData(Object result){
					       			try {
										JSONObject jsonObject=new JSONObject((String)result);
									    if(jsonObject.getString("success").equals("false")){
									    	return ;
									    }
									    JSONObject data=jsonObject.getJSONObject("data");
									    oce03.setText(data.getString("OCE03"));//聯絡人代號
										ta_oce03.setText(data.getString("TA_OCE03"));//歸屬公司
										ta_oce02.setText(data.getString("TA_OCE02"));//分機/專線
										ta_oce04.setText(data.getString("TA_OCE04"));//部門
										oce02.setText(data.getString("OCE02"));//職務
										oce04.setText(data.getString("OCE04"));//TEL_NO(一）
										oce07.setText(data.getString("OCE07"));//TEL_NO(二）
										oce08.setText(data.getString("OCE08"));//FAX_NO
										oce05.setText(data.getString("OCE05"));//FAX_NO
										oce06.setText(data.getString("OCE06"));//FAX_NO
										ta_oceacti.setText(data.getString("TA_OCEACTI"));;
					       			
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
