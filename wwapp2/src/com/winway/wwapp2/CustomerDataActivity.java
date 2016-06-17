package com.winway.wwapp2;

import java.util.ArrayList;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.FragmentManager;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class CustomerDataActivity extends BaseFragment {
	private Context context;
	private Bundle bundle;
	private View mView = null;	
	// UI
	private TextView lb_custId,lb_custname;
	private TextView occ02,occ03,occ18,occ04,
	                 occ11,occ22,occ21,occ20,occ34,
	                 occ261,occ262,occ271,occ231,occ35,occ29,
	                 occ241,occud02,occud04,ta_occ03,occ233;
	private TextView occ42,occ08,occ41desc,occ45desc,occ44desc,occ48desc,occ68desc,occ69desc;
	  
	private TextView occ67desc;     //慣用科目類
	//慣用銷售分類
	private TextView occ43desc;
    //慣用交運方式
	private TextView occ47desc;
    //慣用運送終點
	private TextView occ49desc;
     //卸貨港
	private TextView occ50desc;
    //Ship Via
    private TextView ta_occ01;
    private TextView ta_occ02;//收款方式
    private TextView occud03desc;//快遞公司
    private TextView occ46;//慣用其它條件
    private TextView occ53;//慣用佣金率%
    private TextView occ32;//折扣率%
    private TextView occ51desc;//慣用FORWARDER
    private TextView occ52;//慣用NOTIFY
    private TextView occ38;//月結日
    private TextView occ701;//備註
    private TextView lb_custId2;
    private TextView lb_custname2;
    private TextView titleView;
    //private Button btn_condiction,btn_contact,btn_return,btn_return_customer_detail;
	// A
	// B
	// C
   private void closeFragment() 
    {
		this.fragmentManager.beginTransaction().remove(this).commit();
		this.fragmentManager.beginTransaction().show(parent).commit();
	}
	public void callCustomerContactAddressListActivity(Bundle bundle) {

		CustomerContactAddressListActivity activity = new CustomerContactAddressListActivity();
		if(this.fragmentManager==null)this.fragmentManager=getActivity().getFragmentManager();
		activity.parent=this;
		activity.setFragmentManager(this.fragmentManager);
		activity.setArguments(bundle);
		activity.setRetainInstance(true);
		fragmentManager.beginTransaction()
				.add(R.id.content_frame,activity, "customerdata_details2")
				.commit();
		if (fragmentManager.findFragmentByTag("customerdata_detail") != null) {
			activity.setParent(fragmentManager
					.findFragmentByTag("customerdata_detail"));
			fragmentManager
					.beginTransaction()
					.hide(this).commit();
		}
		fragmentManager.beginTransaction().show(activity).commit();

	}
	// D
	// E
	// F
	// G
	private String getCustId() {
		String rs = (bundle != null && bundle.getString("occ01") == null) ? ""
				: bundle.getString("occ01");
		return rs;
	}

	// I
	private View initView(LayoutInflater inflater, ViewGroup container) {
		View view = inflater.inflate(R.layout.actcustomer_detail, container,
				false);
		
		context=view.getContext();
		bundle = this.getArguments();
		mView=view;
		initUI(view);
		queryData();
		return view;

	}

	private void initUI(View v) {
		final Button btn_condiction,btn_contact,btn_return,btn_advance,btn_apqp;
		btn_return=(Button) v.findViewById(R.id.btn_return);
		btn_contact=(Button) v.findViewById(R.id.btn_contact);
		btn_condiction=(Button)v.findViewById(R.id.btn_condiction);
		btn_advance=(Button)v.findViewById(R.id.btn_advance);
		btn_apqp=(Button)v.findViewById(R.id.btn_apqp);
		titleView=(TextView)v.findViewById(R.id.cust_title_text);
		final RelativeLayout cust1_r1=(RelativeLayout)v.findViewById(R.id.cust_r2_1);
		final RelativeLayout cust1_r2=(RelativeLayout)v.findViewById(R.id.cust_r2_2);
		final RelativeLayout cust1_r3=(RelativeLayout)v.findViewById(R.id.cust_r2_3);
		final RelativeLayout cust1_r4=(RelativeLayout)v.findViewById(R.id.cust_r2_4);
		final RelativeLayout cust1_r5=(RelativeLayout)v.findViewById(R.id.cust_r2_5);
		final RelativeLayout cust1_r6=(RelativeLayout)v.findViewById(R.id.cust_r2_6);
		final RelativeLayout cust_r3=(RelativeLayout)v.findViewById(R.id.cust_r3);
		final RelativeLayout cust_r2=(RelativeLayout)v.findViewById(R.id.cust_r2);
		cust1_r2.setVisibility(View.GONE);
		lb_custId=(TextView)v.findViewById(R.id.lb_custid);
		lb_custname=(TextView) v.findViewById(R.id.lb_custname);
        occ02=(TextView)v.findViewById(R.id.occ02);//customer shortname
        occ03=(TextView)v.findViewById(R.id.occ03);//level abc
        occ04=(TextView)v.findViewById(R.id.occ04);//sales
        occ11=(TextView)v.findViewById(R.id.occ11);//uniform
        occ18=(TextView)v.findViewById(R.id.occ18);//fullname
        occ20=(TextView)v.findViewById(R.id.occ20);//area
       // occ21=(TextView)v.findViewById(R.id.occ21);//country
        occ22=(TextView)v.findViewById(R.id.occ22);//region
        occ29=(TextView)v.findViewById(R.id.occ29); // contact windiow
        occ34=(TextView)v.findViewById(R.id.occ34);//group code
        occ35=(TextView)v.findViewById(R.id.occ35);//post code
        occ231=(TextView)v.findViewById(R.id.occ231);//uniform address
        occ233=(TextView)v.findViewById(R.id.occ233);//NOTE
        occ241=(TextView)v.findViewById(R.id.occ241);//shipping address
        occ261=(TextView)v.findViewById(R.id.occ261);//tel1
        occ262=(TextView)v.findViewById(R.id.occ262);//tel2
        occ271=(TextView)v.findViewById(R.id.occ271);//fax1
        occud02=(TextView)v.findViewById(R.id.occud02); //sale area
        occud04=(TextView)v.findViewById(R.id.occud04); //email
        ta_occ03=(TextView)v.findViewById(R.id.ta_occ03);//對帳Email
        lb_custId2=(TextView)v.findViewById(R.id.lb_custid2);
	    lb_custname2=(TextView)v.findViewById(R.id.lb_custname2);  
		occ42=(TextView)v.findViewById(R.id.occ42);//慣用幣別
		occ41desc=(TextView)v.findViewById(R.id.occ41desc);//慣用稅別
		occ08=(TextView)v.findViewById(R.id.occ08);//發票別
		occ44desc=(TextView)v.findViewById(R.id.occ44desc);//慣用價格條件
		occ45desc=(TextView)v.findViewById(R.id.occ45desc);//慣用條件地點
		occ48desc=(TextView)v.findViewById(R.id.occ48desc);//慣用收款條件
		occ68desc=(TextView)v.findViewById(R.id.occ68desc);//慣用訂金條件
		occ69desc=(TextView)v.findViewById(R.id.occ69desc);//慣用尾款條件
		//----------------------------------------
		 occ67desc=(TextView)v.findViewById(R.id.occ67desc);     //慣用科目類
		//慣用銷售分類
		 occ43desc=(TextView)v.findViewById(R.id.occ43desc);
	    //慣用交運方式
		occ47desc=(TextView)v.findViewById(R.id.occ47desc);
	    //慣用運送終點
	    occ49desc=(TextView)v.findViewById(R.id.occ49desc);
	     //卸貨港
		occ50desc=(TextView)v.findViewById(R.id.occ50desc);
	    //Ship Via
	    ta_occ01=(TextView)v.findViewById(R.id.ta_occ01);
	    ta_occ02=(TextView)v.findViewById(R.id.ta_occ02);//收款方式
	    occud03desc=(TextView)v.findViewById(R.id.occud03desc);//快遞公司
	    occ46=(TextView)v.findViewById(R.id.occ46);//慣用其它條件
	    occ53=(TextView)v.findViewById(R.id.occ53);//慣用佣金率%
	    occ32=(TextView)v.findViewById(R.id.occ32);//折扣率%
	    occ51desc=(TextView)v.findViewById(R.id.occ51desc);//慣用FORWARDER
	    occ52=(TextView)v.findViewById(R.id.occ52);//慣用NOTIFY
	    occ38=(TextView)v.findViewById(R.id.occ38);//月結日
	    occ701=(TextView)v.findViewById(R.id.occ701);//備註
         btn_return.setOnClickListener(new OnClickListener(){
        	@Override
        	public void onClick(View v)
        	{
        		if(btn_return.getText().equals("Back")){
        			titleView.setText("基本資料");
        			btn_return.setText("");
        			cust1_r1.setVisibility(View.VISIBLE);
            		cust1_r2.setVisibility(View.GONE);
            		cust1_r3.setVisibility(View.VISIBLE);
            		cust1_r4.setVisibility(View.VISIBLE);
            		cust1_r5.setVisibility(View.VISIBLE);
            		cust1_r6.setVisibility(View.VISIBLE);
            		cust_r3.setVisibility(View.GONE);
            		cust_r2.setVisibility(View.VISIBLE);
        		}
        		else {
        		  if(parent!=null){
        		    	closeFragment();
        			
        		  }
        		}
        	}
        });
        btn_contact.setOnClickListener(new OnClickListener(){
        	@Override
        	public void onClick(View v)
        	{
        		 callCustomerContactAddressListActivity(bundle);
        	}
        });
        btn_condiction.setOnClickListener(new OnClickListener(){
        	@Override
        	public void onClick(View v)
        	{
        	    cust_r2.setVisibility(View.GONE);
        		cust_r3.setVisibility(View.VISIBLE);
        		btn_return.setText("Back");
        		titleView.setText(btn_condiction.getText());
        		
        	}
        });
        btn_apqp.setOnClickListener(new OnClickListener(){
        	@Override
        	public void onClick(View v)
        	{
        		showApqpWindow(v);        		
        	}
        });
        btn_advance.setOnClickListener(new OnClickListener(){
        	@Override
        	public void onClick(View v)
        	{
        		cust1_r1.setVisibility(View.GONE);
        		cust1_r2.setVisibility(View.VISIBLE);
        		cust1_r3.setVisibility(View.GONE);
        		cust1_r4.setVisibility(View.GONE);
        		cust1_r5.setVisibility(View.GONE);
        		cust1_r6.setVisibility(View.GONE);
        		btn_return.setText("Back");
        		titleView.setText(btn_advance.getText());
        		
        	}
        });
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
		    if(data.getString("OCC01")=="null") return;
			lb_custId.setText(data.getString("OCC01"));
			lb_custname.setText(data.getString("OCC02"));
			occ02.setText(data.getString("OCC02"));
			occ03.setText(data.getString("OCC03"));
			occ04.setText(data.getString("OCC04"));
            occ11.setText(data.getString("OCC11"));
            occ18.setText(data.getString("OCC18"));
            occ22.setText(data.getString("OCC22DESC"));
            //occ21.setText(data.getString("OCC21"));
            occ20.setText(data.getString("OCC20DESC"));
            occ34.setText(data.getString("OCC34"));
            occ261.setText(data.getString("OCC261"));
            occ262.setText(data.getString("OCC262"));
            occ271.setText(data.getString("OCC271"));
            occ231.setText(data.getString("OCC231"));
            occ233.setText(data.getString("OCC233"));
            occ35.setText(data.getString("OCC35"));
            occ29.setText(data.getString("OCC29"));
            occ241.setText(data.getString("OCC241"));
            occud02.setText(data.getString("OCCUD02DESC"));
            occud04.setText(data.getString("OCCUD04"));
            ta_occ03.setText(data.getString("TA_OCC03"));
            lb_custId2.setText(data.getString("OCC01"));
    	    lb_custname2.setText(data.getString("OCC02"));
    		occ08.setText(data.getString("OCC08"));
    		occ32.setText(data.getString("OCC32"));
    		occ38.setText(data.getString("OCC38"));
    		occ41desc.setText(data.getString("OCC41DESC"));
    		occ42.setText(data.getString("OCC42"));
    		occ43desc.setText(data.getString("OCC43DESC"));
    		occ44desc.setText(data.getString("OCC44DESC"));
    		occ45desc.setText(data.getString("OCC45DESC"));
    		occ46.setText(data.getString("OCC46"));
    		occ47desc.setText(data.getString("OCC47DESC"));
    		occ48desc.setText(data.getString("OCC48DESC"));
    		occ49desc.setText(data.getString("OCC49DESC"));
    		occ50desc.setText(data.getString("OCC50DESC"));
    		occ51desc.setText(data.getString("OCC51DESC"));
    		occ52.setText(data.getString("OCC52"));
    		occ53.setText(data.getString("OCC53"));
    		occ67desc.setText(data.getString("OCC67DESC"));
    		occ68desc.setText(data.getString("OCC68DESC"));
    		occ69desc.setText(data.getString("OCC69DESC"));
    		occ701.setText(data.getString("OCC701"));
    		occud03desc.setText(data.getString("OCCUD03DESC"));
    		ta_occ01.setText(data.getString("TA_OCC01"));
    		ta_occ02.setText(data.getString("TA_OCC02"));
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// M
	// N
	// O
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
        
		return initView(inflater, container);
	}
    // P
	// Q
	private void queryData() {
		//String json = "";
		String url = super.getWebServiceUrl() + "getCustomer";
		JSONObject jsonObject = new JSONObject();
		JSONObject data = new JSONObject();
		try {
			data.accumulate("OCC01", getCustId());
			jsonObject.accumulate("userid", super.getLoginUser());
			jsonObject.accumulate("WWID", "13145774WWGlobal999988cust999");
			jsonObject.accumulate("data", data);
			super.postRequest(url, jsonObject,0);

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	// R
	// S
    private void showApqpWindow(View v)
    {
    ApqpListActivity activity=new ApqpListActivity();	
       activity.parent = this;
       if(this.fragmentManager==null)
       {
    	   this.fragmentManager=getFragmentManager();    	   
       }
       activity.fragmentManager=this.fragmentManager;
       Bundle b= new Bundle();
       b.putString("customer", getCustId());      
       activity.setArguments(b);
       activity.setParent(this);
       if (this.fragmentManager.findFragmentById(activity.getId()) == null){
         this.fragmentManager.beginTransaction().add(R.id.content_frame, activity, "apqplist").commit();
       }
       this.fragmentManager.beginTransaction().hide(this).commit();
       this.fragmentManager.beginTransaction().show(activity).commit();
       
       
    	
    }	
    
    //

}
