package com.winway.wwapp2;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.ActionBar;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnKeyListener;
import android.view.View.OnTouchListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.SearchView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.TextView;

import com.winway.wwapp2.PullDownView.OnPullDownListener;

/* calssname:CustomerListActivity
 * desc:load Customer Data (Customer Name / Customer Code / Address / Contact......) to view / edit
 * create:15/05/21
 * auther:cooper
 * version : 1.0
 * modify  : 
 */
public class CustomerListActivity extends BaseFragment implements
		OnPullDownListener, OnItemClickListener, SearchView.OnQueryTextListener {
	private Context context;
	private Bundle bundle;
	private View mView = null;
	private int ACTION_MESSAGE;
	private CustomerListAdapter adapter2;
	private ArrayList<CustomerItem> customerItems;
	private PullDownView mPullDownView;
	protected static final int REFRESH_DATA = 0x00000002;
	private static final int WHAT_DID_LOAD_DATA = 0;
	private static final int WHAT_DID_REFRESH = 1;
	private static final int WHAT_DID_MORE = 5;
	public String level,contact,tel,occ22,occ04;
	private int page = 1;
	private ListView lstCust;
	private EditText editSearch;
	private Button btnReturnSale;
	private Button btn_cust_adv_search,btnOption;
	private RelativeLayout level_menu;
	private TextView my_a,my_b,my_c,my_all;
	// function B
	// function C
	private void closeFragment() {
		this.fragmentManager.beginTransaction().remove(this).commit();
		this.fragmentManager.beginTransaction().show(parent).commit();
	}
	// function D
	// function E
	// function G
	// function F
	// function H

	// function I
	private View initView(LayoutInflater inflater, ViewGroup container) {
		View view = inflater
				.inflate(R.layout.actcustomerlist, container, false);
		initUI(view);
		queryData(WHAT_DID_LOAD_DATA);
		return view;

	}

	private void initPullDownView(View view) {
		/*
		 * 1.使用PullDownView 2.設置OnPullDownListener 3.從mPullDownView里面獲取ListView
		 */

		mPullDownView = (PullDownView) view.findViewById(R.id.customerlistview);
		if (mPullDownView == null)
			return;
		mPullDownView.setOnPullDownListener(this);
		lstCust = mPullDownView.getListView();
		lstCust.setOnItemClickListener(this);
		lstCust.setDividerHeight(0);
		lstCust.setHeaderDividersEnabled(true);
		customerItems = new ArrayList<CustomerItem>();
		adapter2 = new CustomerListAdapter(context, customerItems);
		lstCust.setAdapter(adapter2);
		mPullDownView.enableAutoFetchMore(true, 1);
	}

	private void initUI(View v) {
		tel="";
		occ22="";
		occ04="";
		contact="";
		level="";
		context = v.getContext();
		btnOption=(Button)v.findViewById(R.id.btnOption);
		my_a=(TextView)v.findViewById(R.id.my_a);
		my_b=(TextView)v.findViewById(R.id.my_b);
		my_c=(TextView)v.findViewById(R.id.my_c);
		my_all=(TextView)v.findViewById(R.id.my_all);
		level_menu=(RelativeLayout)v.findViewById(R.id.level_menu);
		editSearch = (EditText) v.findViewById(R.id.editSearch);
		editSearch.setOnClickListener(new View.OnClickListener() {
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
					queryData(WHAT_DID_LOAD_DATA);
					return true;
				}
				return false;
			}
		});
		btnReturnSale = (Button) v.findViewById(R.id.btnReturnSale);
		btn_cust_adv_search=(Button) v.findViewById(R.id.btn_cust_adv_search);
		btn_cust_adv_search.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v){
				//顯示進階搜尋視窗
				showAdvSearchDialog();		
				
			}			
		});
		btnOption.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v){
				if(level_menu.getVisibility()==View.VISIBLE){
					level_menu.setVisibility(View.GONE);
					
				}else {
					level_menu.setVisibility(View.VISIBLE);
					
				}
				
			}			
		});
		my_a.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v){
				level="A";
				customerItems.clear();
				queryData(WHAT_DID_LOAD_DATA);
			}			
		});
		my_b.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v){
				level="B";
				customerItems.clear();
				queryData(WHAT_DID_LOAD_DATA);
			}			
		});
		my_c.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v){
				level="C";
				customerItems.clear();
				queryData(WHAT_DID_LOAD_DATA);
				
			}			
		});
		my_all.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v){
				level="";
				customerItems.clear();
				queryData(WHAT_DID_LOAD_DATA);
			}			
		});
		initPullDownView(v);

	}

	// Function L
	@Override
	public void loadData(Object result) {

		try {
			customerItems.clear();
			JSONObject jsonObject = new JSONObject((String) result);
			setCustomerItem(jsonObject);
			mPullDownView.notifyDidLoad();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void loadRefreshData(Object result) {
		try {
			JSONObject jsonObject = new JSONObject((String) result);
			customerItems.clear();
			setCustomerItem(jsonObject);
			page = 1;
			mPullDownView.notifyDidRefresh();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void loadMoreData(Object result) {
		try {
			JSONObject jsonObject = new JSONObject((String) result);
			setCustomerItem(jsonObject);
			JSONArray array = jsonObject.getJSONArray("data");
			if (array.length() == 0) {
				page = page - 1;
			}
			mPullDownView.notifyDidMore();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// function O
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		return initView(inflater, container);
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		// TODO Auto-generated method stub
		final CustomerItem item = (CustomerItem) customerItems.get(position);
		Bundle bundle = new Bundle();
		bundle.putString("occ01", item.getCustId());
		bundle.putString("occ02", item.getShortName());
		bundle.putString("occ18", item.getFullName());       
		adapter2.setSelectItem(position);
		adapter2.notifyDataSetInvalidated();
		 ((MainActivity) getActivity()).callCustomerDataActivity(bundle);
	}

	@Override
	public void onRefresh() {
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

				page += 1;
				queryData(WHAT_DID_MORE);

			}
		}).start();
	}

	@Override
	public boolean onQueryTextChange(String newText) {

		return true;
	}

	//
	@Override
	public boolean onQueryTextSubmit(String query) {
		return true;
	}

	// function Q
	private void queryData(int Message) {
		String json = "";
		String url = super.getWebServiceUrl() + "queryCustomers";
		JSONObject jsonObject = new JSONObject();
		JSONObject data = new JSONObject();
		try {

			if (editSearch.getText().toString() != "") {
				data.accumulate("queryValue", editSearch.getText());
			} else {
				data.accumulate("queryValue", "");
			}
			data.accumulate("OCC03",level);//客戶等級
			data.accumulate("OCC04",occ04);//負責業務員
	        data.accumulate("OCC22",occ22);//區域
	        data.accumulate("CONTACT",contact);//聯絡人
	        data.accumulate("TEL",tel);//電話;
			jsonObject.accumulate("userid", super.getLoginUser());
			jsonObject.accumulate("WWID", "13145774WWGlobal999988custquery999");
			jsonObject.accumulate("data", data);
			jsonObject.accumulate("page", page);
			super.postRequest(url, jsonObject, Message);

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// S
	private void setCustomerItem(JSONObject jsonObject) {
		try {
			JSONArray array = jsonObject.getJSONArray("data");
			if (array.length() > 0) {
				for (int i = 0; i < array.length(); i++) {
					JSONObject obj;
					obj = array.getJSONObject(i);
					customerItems.add(new CustomerItem(obj.getString("OCC01"),// cust no
							obj.getString("OCC02"),// cust name
							obj.getString("OCC03"),// category
							obj.getString("OCC18"),// full name
							obj.getString("OCC261"),// phone
							obj.getString("OCCUD04"),// email
							obj.getString("TA_GEN01")// contact
							));
				}
				adapter2.notifyDataSetChanged();
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	private void showAdvSearchDialog()
	{
		CustAdvSearchActivity activity=new CustAdvSearchActivity();
		activity.setParent(this);
		if(this.fragmentManager==null){
			this.fragmentManager=getFragmentManager();
		}
		activity.setFragmentManager(this.fragmentManager);
		Fragment fragment=(Fragment) activity;
		this.fragmentManager.beginTransaction().add(R.id.content_frame, fragment, "actcust_adv_search").commit();
	     fragment.setRetainInstance(true);
	     this.fragmentManager.beginTransaction()
	    .hide(this)
	     .commit();
	     this.fragmentManager.beginTransaction().show(fragment).commit();	
		
	}
}
