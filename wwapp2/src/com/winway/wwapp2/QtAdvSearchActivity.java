package com.winway.wwapp2;

/**
 * Qt 搜尋頁
 * 
 * 
 */

import android.app.AlertDialog.Builder;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SimpleAdapter;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class QtAdvSearchActivity extends BaseFragment {
	protected static final int REFRESH_DATA = 2;
	private static final int WHAT_DID_LOAD_DATA = 0;
	private static final int WHAT_DID_MORE = 5;
	private static final int WHAT_DID_REFRESH = 1;
	private int ACTION_MESSAGE;
	private EditText qtno;
	private Button btnAdvSearch;
	private Button btnRetrunQtList;
	private Button btnQtSales;
	private Context context;
	private EditText customer;
	private List<Map<String, Object>> items;
	private String[] mQtType = { "Socket", "Duplication", "WLCSP", "ATC",
			"FinePitch ProbeCard", "Changeover Kit", "E-Flux" };
	private View mView;
	private int page;
	private SimpleAdapter simpleAdapter;
	private EditText CUST_CONTACT;
	private EditText QT_SALES;
	private EditText DESCRIPTION;
	private int pos = 0;

	// A
	public QtAdvSearchActivity() {

		this.items = new ArrayList();
		this.page = 1;
	}

	// C
	private void closeFragment() {

		FragmentManager fragmentManager = getFragmentManager();
		fragmentManager.beginTransaction().remove(this).commit();
		fragmentManager.popBackStack();
		fragmentManager.beginTransaction().show(this.parent).commit();
	}

	// H
	private void hideFragment() {

		FragmentManager fragmentManager = getFragmentManager();
		// if (fragmentManager.findFragmentByTag("qt_adv_search") != null)
		fragmentManager.beginTransaction().hide(this).commit();
	}

	// I
	private void initUI(View view) {

		this.qtno         = ((EditText) view.findViewById(R.id.qtno));
		this.CUST_CONTACT = ((EditText) view.findViewById(R.id.CUST_CONTACT));
		this.QT_SALES     = ((EditText) view.findViewById(R.id.QT_SALES));
		this.customer     = ((EditText) view.findViewById(R.id.customer));
		this.DESCRIPTION  = ((EditText) view.findViewById(R.id.ed_DESCRIPTION));

		this.btnQtSales   = ((Button) view.findViewById(R.id.btnQtSales));
		this.btnQtSales.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				//注意 : btnQtSales onClick 真正要處理的是 QT_SALES 開窗
				showSalesDialog(QT_SALES);//showSalesDialog(v);//
			}
		});

//		QT_SALES.setOnTouchListener(new OnTouchListener() {
//			@Override
//			public boolean onTouch(View v, MotionEvent event) {
//				QT_SALES.setInputType(InputType.TYPE_NULL); // 關閉軟鍵盤
//				return false;
//			}
//		});
//		QT_SALES.setOnFocusChangeListener(new OnFocusChangeListener() {
//			public void onFocusChange(View v, boolean hasFocus) {
//				if (hasFocus) {
//					InputMethodManager imm = (InputMethodManager) getActivity()
//							.getSystemService(Context.INPUT_METHOD_SERVICE);
//					imm.hideSoftInputFromWindow(QT_SALES.getWindowToken(), 0);
//					showSalesDialog(v);
//					QT_SALES.clearFocus();
//				}
//			}
//		});

		this.btnAdvSearch = ((Button) view.findViewById(R.id.btnAdvSearch));
		this.btnAdvSearch.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				// ACTION_MESSAGE=WHAT_DID_LOAD_DATA;
				// queryData(ACTION_MESSAGE);
				showAdvSerchList();
			}
		});
		this.btnRetrunQtList = ((Button) view
				.findViewById(R.id.btnReturnQtList));
		this.btnRetrunQtList.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				closeFragment();
			}
		});
	}

	private View initView(LayoutInflater inflater, ViewGroup container) {

		View view = inflater.inflate(R.layout.actqt_adv_search, container,
				false);
		this.context = view.getContext();
		initUI(view);
		return view;
	}

	// L
	public void loadData(Object result) {

		try {
			if (new JSONObject((String) result).getJSONArray("data").length() == 0) {
				super.showDialog("找不到資料");
			} else {
				FragmentManager fragmentManager = getFragmentManager();
				Bundle bundle = new Bundle();
				bundle.putString("qtno"        , this.qtno        .getText().toString());
				bundle.putString("CUST_CONTACT", this.CUST_CONTACT.getText().toString());
				bundle.putString("QT_SALES"    , this.QT_SALES    .getText().toString());
				bundle.putString("customer"    , this.customer    .getText().toString());
				bundle.putString("DESCRIPTION" , this.DESCRIPTION .getText().toString());
				QtListSearchResultActivity activity = new QtListSearchResultActivity();
				activity.setArguments(bundle);
				activity.setParent(this);
				if (fragmentManager.findFragmentById(activity.getId()) == null)
					fragmentManager
							.beginTransaction()
							.add(R.id.content_frame, activity,
									"qt_search_result").commit();
				hideFragment();
				fragmentManager.beginTransaction().show(activity).commit();
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

	// O
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle paramBundle) {

		return initView(inflater, container);
	}

	private void openDialog(Fragment fragment, String tagName) {
		if (fragmentManager == null) {
			fragmentManager = getFragmentManager();
		}
		fragmentManager.beginTransaction()
				.add(R.id.content_frame, fragment, tagName).commit();
		fragmentManager.beginTransaction()
				.hide(fragmentManager.findFragmentById(this.getId())).commit();

		fragmentManager.beginTransaction().addToBackStack(null);
		fragmentManager.beginTransaction().show(fragment).commit();

	}

	// Q
	private void queryData(int Message) {

		String str = super.getWebServiceUrl() + "queryQT";
		JSONObject jsonObject = new JSONObject();
		JSONObject data = new JSONObject();
		try {
			data.accumulate("qtno"        , this.qtno        .getText().toString());// 积累这个value到该key下，如果key存在，则该key的值为数组
			data.accumulate("CUST_CONTACT", this.CUST_CONTACT.getText().toString());
			data.accumulate("customer"    , this.customer    .getText().toString());
			data.accumulate("QT_SALES"    , QT_SALES         .getText().toString());
			data.accumulate("DESCRIPTION" , DESCRIPTION      .getText().toString());
			jsonObject.accumulate("userid", super.getLoginUser());
			jsonObject.accumulate("WWID", "13145774WWGlobal999988qtquery999");
			jsonObject.accumulate("data", data);
			jsonObject.accumulate("page", Integer.toString(this.page));
			super.postRequest(str, jsonObject, Message);
			return;
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

	// S
	public void showSalesDialog(View view) {
		SalesListActivity2 activity = new SalesListActivity2();
		activity.parent = this;
		activity.setFragmentManager(getFragmentManager());
		Bundle b = new Bundle();
		b.putString("controltype", "EditText");
		b.putInt("controlid", view.getId());
		Fragment f = activity;
		f.setArguments(b);
		openDialog(f, "Sales Rep");
	}

	private void showAdvSerchList() {

		Bundle bundle = new Bundle();
		bundle.putString("qtno"        , qtno        .getText().toString());
		bundle.putString("CUST_CONTACT", CUST_CONTACT.getText().toString());
		bundle.putString("QT_SALES"    , QT_SALES    .getText().toString());
		bundle.putString("customer"    , customer    .getText().toString());
		bundle.putString("DESCRIPTION" , DESCRIPTION .getText().toString());
		//-------------------------------------------------
        //20151227 : 新寫法
		this.doWork((Object)bundle);

		FragmentManager fm=getFragmentManager();
		//fm.beginTransaction().remove(fm.findFragmentByTag("Cust")).commit();
		fm.beginTransaction().remove(this).commit();
		fm.popBackStack();
		if(this.parent!=null){
			fm.beginTransaction().show(this.parent).commit();
		}
        		
        //-------------------------------------------------
		/*20151227 此段改寫如上
		FragmentManager fragmentManager = getFragmentManager();
		QtListSearchResultActivity activity = new QtListSearchResultActivity();
		activity.setArguments(bundle);
		activity.setParent(this);
		if (fragmentManager.findFragmentById(activity.getId()) == null)
			fragmentManager.beginTransaction()
					.add(R.id.content_frame, activity, "qt_search_result")
					.commit();
		hideFragment();
		fragmentManager.beginTransaction().show(activity).commit();
		*/

	}


}