package com.winway.wwapp2;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.inqbarna.tablefixheaders.TableFixHeaders;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
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
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class StockDetailActivity extends BaseFragment {
	private Context context;
	private Button btn_return;
	private Button btn_oeb_q, btn_pml_q, btn_pml_q3, btn_pmn_q;
	MatrixTableAdapter<String> table1, table2, table3, table4;
	protected TableFixHeaders tableFixHeaders1;
	private TextView stock_title;
	private OnClickListener onButtonClickListener;
	private String selectedTab = "0";

	// C
	public void closeFragment() {
		if (this.parent != null) {
			this.fragmentManager.beginTransaction().remove(this).commit();
			this.fragmentManager.beginTransaction().show(this.parent).commit();
		}
	}

	// H
	public void hideActionbar() {
		ActionBar bar = getActivity().getActionBar();
		if (bar.isShowing()) {
			bar.hide();
		}
	}

	// I
	private View initView(LayoutInflater inflater, ViewGroup container) {
		View view = inflater.inflate(R.layout.actstockdetail, container, false);
		context = view.getContext();
		initUI(view);
		Bundle b = this.getArguments();
		if (b != null && b.getString("ima01") != "") {
			stock_title.setText(b.getString("ima01"));
			queryData(WHAT_DID_LOAD_DATA);
		}
		return view;
	}

	protected void initUI(View view) {

		stock_title = (TextView) view.findViewById(R.id.stock_title_text);
		btn_oeb_q = (Button) view.findViewById(R.id.btn_oeb_q);
		btn_pml_q = (Button) view.findViewById(R.id.btn_pml_q);
		btn_pml_q3 = (Button) view.findViewById(R.id.btn_pml_q3);
		btn_pmn_q = (Button) view.findViewById(R.id.btn_pmn_q);
		btn_return = (Button) view.findViewById(R.id.btn_return);
		tableFixHeaders1 = (TableFixHeaders) view.findViewById(R.id.table1);
		
		onButtonClickListener = new OnClickListener() {
			public void onClick(View v) {
				btn_oeb_q.setBackgroundResource(R.drawable.stock_book_tab);
				btn_pml_q3.setBackgroundResource((R.drawable.stock_requisition_booking_tab));
				btn_pml_q.setBackgroundResource(R.drawable.stock_requisition_tab);
				btn_pmn_q.setBackgroundResource(R.drawable.stock_purchase_tab);
				/*if (selectedTab == "0")
					tableFixHeaders1.setVisibility(View.GONE);
				if (selectedTab == "1")
					tableFixHeaders2.setVisibility(View.GONE);
				if (selectedTab == "2")
					tableFixHeaders3.setVisibility(View.GONE);
				if (selectedTab == "3")
					tableFixHeaders4.setVisibility(View.GONE);*/
				switch (v.getId()) {
				case R.id.btn_oeb_q:
					selectedTab = "0";
					btn_oeb_q
							.setBackgroundResource(R.drawable.stock_book_tab_selected);
					break;
				case R.id.btn_pml_q3:
					selectedTab = "1";
					
					btn_pml_q3.setBackgroundResource((R.drawable.stock_requisition_booking_tab_selected));
					break;
				case R.id.btn_pml_q:
					selectedTab = "2";
					btn_pml_q.setBackgroundResource((R.drawable.stock_requisition_tab_selected));
					break;
				case R.id.btn_pmn_q:
					selectedTab = "3";
					btn_pmn_q.setBackgroundResource((R.drawable.stock_purchase_tab_selected));
					break;
				case R.id.btn_return:
					selectedTab = "";

					closeFragment();
					break;
				}
				if (selectedTab.equals("") == false) {
					queryData(WHAT_DID_LOAD_DATA);
				}
			}
		};
		btn_oeb_q.setOnClickListener(onButtonClickListener);
		btn_pml_q3.setOnClickListener(onButtonClickListener);
		btn_pml_q.setOnClickListener(onButtonClickListener);
		btn_pmn_q.setOnClickListener(onButtonClickListener);
		btn_return.setOnClickListener(onButtonClickListener);
		//
		table1 = new MatrixTableAdapter<String>(getActivity(),
				new String[][] { { "訂單單號", "客戶", "數量", }, });
		
		tableFixHeaders1.setAdapter(table1);
	
	}

	// L
	public void loadJSONData(JSONObject jsonObject) {
		JSONArray data;
		try {
			data = jsonObject.getJSONArray("data");
			if (selectedTab == "0") {
				table1.setInformation(setTable1Adapter(data));
			} else if (selectedTab == "1") {
				table1.setInformation(setTable2Adapter(data));			
			} else if (selectedTab == "2") {
				table1.setInformation(setTable3Adapter(data));				
			} else if (selectedTab == "3") {
				table1.setInformation(setTable4Adapter(data));
				
			}
			table1.notifyDataSetChanged();
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
	}

	@Override
	public void onPause() {
		super.onPause();
	}

	@Override
	public void onResume() {
		super.onResume();
		hideActionbar();
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

	// Q
	public void queryData(int Message) {
		String url = "";
		if (selectedTab == "0") {
			url = super.getWebServiceUrl() + "queryStock_Orderbook";
		} else if (selectedTab == "1") {
			url = super.getWebServiceUrl() + "queryStock_Requisitionbook";
		} else if (selectedTab == "2") {
			url = super.getWebServiceUrl() + "queryStock_Requisition";
		} else if (selectedTab == "3") {
			url = super.getWebServiceUrl() + "queryStock_Purchase";
		} else {
			return;
		}
		try {
			isLoading = 1;
			launchRingDialog(null);
			JSONObject jsonObject = new JSONObject();
			JSONObject data = new JSONObject();
			data.accumulate("PartNo", stock_title.getText().toString());

			jsonObject
					.accumulate("WWID", "13145774WWGlobal999988stockquery999");
			jsonObject.accumulate("userid", this.getLoginUser());
			jsonObject.accumulate("data", data);
			super.postRequest(url, jsonObject, new IDataReceiveListener() {
				public void onReceiveData(Object result) {
					try {
						JSONObject jsonObject = new JSONObject((String) result);
						if (!jsonObject.getString("success").equals("true")) {
							showDialog(jsonObject.getString("remark"));
							return;
						}
						loadJSONData(jsonObject);
						isLoading = 0;
					} catch (Exception ex) {

					}
				}
			}, false);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// S
	protected String[][] setTable1Adapter(JSONArray data) {
		String[][] table = new String[data.length() + 1][];
		table[0] = new String[] { "訂單單號", "客戶", "數量" };
		for (int i = 0; i < data.length(); i++) {
			try {
				JSONObject jsonObject = (JSONObject) data.getJSONObject(i);
				table[i + 1] = new String[] { jsonObject.getString("OEB01"),
						jsonObject.getString("OEA03"),
						jsonObject.getString("OEB_Q") };
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return table;

	}
	protected String[][] setTable2Adapter(JSONArray data) {
		String[][] table = new String[data.length() + 1][];
		table[0] = new String[] { "訂單單號", "請購單", "數量" };
		for (int i = 0; i < data.length(); i++) {
			try {
				JSONObject jsonObject = (JSONObject) data.getJSONObject(i);
				table[i + 1] = new String[] { jsonObject.getString("PML24"),
						jsonObject.getString("PML01"),
						jsonObject.getString("PML_Q3") };
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return table;

	}
	protected String[][] setTable3Adapter(JSONArray data) {
		String[][] table = new String[data.length() + 1][];
		table[0] = new String[] { "訂單單號", "請購單","項次", "請購數量"  };
		for (int i = 0; i < data.length(); i++) {
			try {
				JSONObject jsonObject = (JSONObject) data.getJSONObject(i);
				table[i + 1] = new String[] { jsonObject.getString("PML24"),
						jsonObject.getString("PML01"),jsonObject.getString("PML02"),
						jsonObject.getString("PML_Q") };
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return table;

	}
	protected String[][] setTable4Adapter(JSONArray data) {
		String[][] table = new String[data.length() + 1][];
		table[0] = new String[] { "採購單","項次", "請購單", "採購數量" };
		for (int i = 0; i < data.length(); i++) {
			try {
				JSONObject jsonObject = (JSONObject) data.getJSONObject(i);
				table[i + 1] = new String[] { jsonObject.getString("PMN01"),jsonObject.getString("PMN02"),
						jsonObject.getString("PMN24"),
						jsonObject.getString("PMN_Q") };
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return table;

	}
}
