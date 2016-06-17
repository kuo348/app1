package com.winway.wwapp2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.winway.camera.CameraInterface;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.res.TypedArray;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class InventoryActivity extends BaseFragment {
    private Context context ;
	private ImageView btnBom;
	private ImageView btnGoods;
	private ImageView btnStock;
	//Function C
	private void closeFragment(){
		if(this.parent!=null){
			this.fragmentManager.beginTransaction().remove(this).commit();
			this.fragmentManager.beginTransaction().show(this.parent).commit();
			
		}
	}
	
	private void callBomActivity()
	{		
		BomActivity activity=new BomActivity();
		activity.parent =this;
		activity.fragmentManager=getFragmentManager();
		Fragment fragment=activity;	
		fragment.setRetainInstance(true);
	    activity.setParent(this);
	    if(this.fragmentManager.findFragmentByTag("bom")!=null){
	    	 this.fragmentManager.beginTransaction().remove(this.fragmentManager.findFragmentByTag("bom")).commit();	    	
	    }
        this.fragmentManager.beginTransaction().add(R.id.content_frame,fragment, "bom").commit();
        this.fragmentManager.beginTransaction().hide(this).commit();
	    this.fragmentManager.beginTransaction().show(fragment).commit();
	}
	private void callGoodsActivity()
	{		
		
		AlbumListActivity activity=new AlbumListActivity();
		activity.parent =this;
		activity.fragmentManager=getFragmentManager();
		Fragment fragment=activity;	
		fragment.setRetainInstance(true);
	    activity.setParent(this);
	    if(this.fragmentManager.findFragmentByTag("goods")!=null){
	    	 this.fragmentManager.beginTransaction().remove(this.fragmentManager.findFragmentByTag("goods")).commit();	    	
	    }
        this.fragmentManager.beginTransaction().add(R.id.content_frame,fragment, "goods").commit();
        this.fragmentManager.beginTransaction().hide(this).commit();
        hideActionbar();
	    this.fragmentManager.beginTransaction().show(fragment).commit();
	}
	private void callStockActivity()
	{		
		
		StockActivity activity=new StockActivity();
		activity.parent =this;
		activity.fragmentManager=getFragmentManager();
		Bundle b=new Bundle();
		b.putString("return_title","Inventory");
		b.putInt("frg_id",R.layout.actinventory);
		activity.setArguments(b);
		Fragment fragment=activity;	
		fragment.setRetainInstance(true);
	    activity.setParent(this);
	    if(this.fragmentManager.findFragmentByTag("stock")!=null){
	    	 this.fragmentManager.beginTransaction().remove(this.fragmentManager.findFragmentByTag("goods")).commit();	    	
	    }
        this.fragmentManager.beginTransaction().add(R.id.content_frame,fragment, "goods").commit();
        this.fragmentManager.beginTransaction().hide(this).commit();
        hideActionbar();
	    this.fragmentManager.beginTransaction().show(fragment).commit();
	}
	//H
	 public void hideActionbar() {
	  		ActionBar mActionBar = getActivity().getActionBar();
	  		if (mActionBar.isShowing())
	  			mActionBar.hide();
	  		
	  	}
	//Function I
	private View initView(LayoutInflater inflater, ViewGroup container) {
		View view = inflater.inflate(R.layout.actinventory, container, false);
		context = view.getContext();
		initUI(view);
		return view;
	}
	private void initUI(View v)
	{
		if(this.fragmentManager==null){
			this.fragmentManager= getFragmentManager();			
		}
		btnBom =(ImageView )v.findViewById(R.id.imgBom);
		btnBom.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View view)
			{
				callBomActivity();				
			}
		});
		btnStock =(ImageView )v.findViewById(R.id.imgStock2);
		btnStock.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View view)
			{
				callStockActivity();				
			}
		});
		btnGoods =(ImageView )v.findViewById(R.id.imgGoods);
		final String url=super.getWebServiceUrl()+ "CheckPrivilege";
		btnGoods.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View view)
			{		
				JSONObject jsonObject = new JSONObject();
				JSONObject data = new JSONObject();
				try {
					data.accumulate("SystemId", "AP0502");
					jsonObject.accumulate("userid", getLoginUser());
					jsonObject.accumulate("WWID", "13145774WWGlobal999988999");
					jsonObject.accumulate("data", data);
					queryData(url,
							jsonObject, new IDataReceiveListener() {
								public void onReceiveData(Object obj) {
									try {
										JSONObject rs = new JSONObject((String) obj);
										String remark = rs.getString("remark");
										String success = rs.getString("success");
										JSONObject privilege=rs.getJSONObject("data");									
										if (success.equals("true")) {
											if(privilege.getString("None").equals("false")) {
											   callGoodsActivity();	
											}
											else {
												showDialog("Permission denied");												
											}
										} else {
											showDialog("error", remark);
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
		});
	}
	//Function O
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		return initView(inflater, container);
	}
	  @Override
      public void onDestroyView() {
          super.onDestroyView();           
      }

      @Override
      public void onDestroy() {
          super.onDestroy();           
      }

      @Override
      public void onDetach() {
          super.onDetach();
          //sm.unregisterListener(listener);
      }

      @Override
      public void onPause() {
    	  super.onPause();
      }

      @Override
      public void onResume() {
          super.onResume();       
          showActionbar();
      }

      @Override
      public void onStart() {
          super.onStart();          
         
      }

      @Override
      public void onStop() {
          super.onStop();           
      }


      @Override
      public void onAttach(Activity activity) {          
          super.onAttach(activity);
      } 
      //Q
      private void queryData(String url, JSONObject jsonObject,
		IDataReceiveListener dataListener) {
	         super.postRequest(url, jsonObject, dataListener);
        }
      //Function S
      public void showActionbar() {
  		ActionBar mActionBar = getActivity().getActionBar();
  		if (mActionBar.isShowing() == false)
  			mActionBar.show();
  		
  	}
   
}
