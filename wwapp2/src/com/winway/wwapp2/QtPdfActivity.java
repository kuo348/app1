package com.winway.wwapp2;

/**
 * Qt 搜尋頁
 * 
 * 
 */

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SimpleAdapter;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class QtPdfActivity extends BaseFragment {
	protected static final int REFRESH_DATA = 2;
	private static final int WHAT_DID_LOAD_DATA = 0;
	private static final int WHAT_DID_MORE = 5;
	private static final int WHAT_DID_REFRESH = 1;
	private int ACTION_MESSAGE;
	private EditText qtno;
//	private Button btnAdvSearch;
	private Button btnOk;
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

	private CheckBox chk01, chk02, chk03, chk04, chk05, chk06;
	private CheckBox chk07, chk08, chk09, chk10, chk11, chk12;

	private RadioGroup rg_Price       ;//= (CheckBox) view.findViewById(R.id.Price_1);
	private RadioGroup rg_Language    ;//= (CheckBox) view.findViewById(R.id.Price_1);
	private RadioGroup rg_Detail      ;//= (CheckBox) view.findViewById(R.id.Price_1);
	private RadioButton Price_1       ;//= (CheckBox) view.findViewById(R.id.Price_1);
	private RadioButton Price_2       ;//= (CheckBox) view.findViewById(R.id.Price_2);
	private RadioButton Language_1    ;//= (CheckBox) view.findViewById(R.id.Language_1);
	private RadioButton Language_2    ;//= (CheckBox) view.findViewById(R.id.Language_2);
	private RadioButton Detail_1      ;//= (CheckBox) view.findViewById(R.id.Detail_1);
	private RadioButton Detail_2      ;//= (CheckBox) view.findViewById(R.id.Detail_2);
	private RadioButton Detail_3      ;//= (CheckBox) view.findViewById(R.id.Detail_3);
	private CheckBox ShowBank      ;//= (CheckBox) view.findViewById(R.id.ShowBank);
	private CheckBox ShowTotal     ;//= (CheckBox) view.findViewById(R.id.ShowTotal);
	private CheckBox ShowPercent   ;//= (CheckBox) view.findViewById(R.id.ShowPercent);
	private CheckBox ShowSignature ;//= (CheckBox) view.findViewById(R.id.ShowSignature);
	private CheckBox ShowStamp     ;//= (CheckBox) view.findViewById(R.id.ShowStamp);

	// A
	public QtPdfActivity() {

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

//		this.qtno         = ((EditText) view.findViewById(R.id.qtno));
//		this.CUST_CONTACT = ((EditText) view.findViewById(R.id.CUST_CONTACT));
//		this.QT_SALES     = ((EditText) view.findViewById(R.id.QT_SALES));
//		this.customer     = ((EditText) view.findViewById(R.id.customer));
//		this.DESCRIPTION  = ((EditText) view.findViewById(R.id.ed_DESCRIPTION));

		rg_Price      = (RadioGroup) view.findViewById(R.id.rg_Price);
		rg_Language   = (RadioGroup) view.findViewById(R.id.rg_Language);
		rg_Detail     = (RadioGroup) view.findViewById(R.id.rg_Detail);

		Price_1       = (RadioButton) view.findViewById(R.id.Price_1);
		Price_2       = (RadioButton) view.findViewById(R.id.Price_2);
		Language_1    = (RadioButton) view.findViewById(R.id.Language_1);
		Language_2    = (RadioButton) view.findViewById(R.id.Language_2);
		Detail_1      = (RadioButton) view.findViewById(R.id.Detail_1);
		Detail_2      = (RadioButton) view.findViewById(R.id.Detail_2);
		Detail_3      = (RadioButton) view.findViewById(R.id.Detail_3);
		ShowBank      = (CheckBox) view.findViewById(R.id.ShowBank);
		ShowTotal     = (CheckBox) view.findViewById(R.id.ShowTotal);
		ShowPercent   = (CheckBox) view.findViewById(R.id.ShowPercent);
		ShowSignature = (CheckBox) view.findViewById(R.id.ShowSignature);
		ShowStamp     = (CheckBox) view.findViewById(R.id.ShowStamp);

//		this.btnQtSales   = ((Button) view.findViewById(R.id.btnQtSales));
//		this.btnQtSales.setOnClickListener(new OnClickListener() {
//			@Override
//			public void onClick(View v) {
//
//				//注意 : btnQtSales onClick 真正要處理的是 QT_SALES 開窗
//				showSalesDialog(QT_SALES);//showSalesDialog(v);//
//			}
//		});

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

		this.btnOk = ((Button) view.findViewById(R.id.btnOk));
		this.btnOk.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				returnToParent();
				// ACTION_MESSAGE=WHAT_DID_LOAD_DATA;
				// queryData(ACTION_MESSAGE);
				//showAdvSerchList();
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

		View view = inflater.inflate(R.layout.actqt_pdf, container,
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

	private void returnToParent() {

		Bundle bundle = new Bundle();

		String sPrice         = "1";
		String sLanguage      = "1";
		String sDetail        = "1";
		String sShowBank      = "Y";
		String sShowTotal     = "Y";
		String sShowPercent   = "Y";
		String sShowSignature = "Y";
		String sShowStamp     = "N";

		if      (Price_1.isChecked())       {sPrice="1";}
		else                                {sPrice="2";}

		if      (Language_1.isChecked())    {sLanguage="1";}
		else                                {sLanguage="2";}

		if      (Detail_1.isChecked())      {sDetail="1";}
		else if (Detail_2.isChecked())      {sDetail="2";}
		else if (Detail_3.isChecked())      {sDetail="3";}

		if      (ShowBank.isChecked())      {sShowBank="Y";}
		else                                {sShowBank="N";}

		if      (ShowTotal.isChecked())     {sShowTotal="Y";}
		else                                {sShowTotal="N";}

		if      (ShowPercent.isChecked())   {sShowPercent="Y";}
		else                                {sShowPercent="N";}

		if      (ShowSignature.isChecked()) {sShowSignature="Y";}
		else                                {sShowSignature="N";}

		if      (ShowStamp.isChecked())     {sShowStamp="Y";}
		else                                {sShowStamp="N";}

		//20160114
		bundle.putString("PRICE"           , sPrice        );
		bundle.putString("LANGUAGE"        , sLanguage     );
		bundle.putString("DETAIL"          , sDetail       );
		bundle.putString("SHOW_BANK"       , sShowBank     );
		bundle.putString("SHOW_TOTAL"      , sShowTotal    );
		bundle.putString("SHOW_PERCENT"    , sShowPercent  );
		bundle.putString("SHOW_SIGNATURE"  , sShowSignature);
		bundle.putString("SHOW_STAMP"      , sShowStamp    );

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


	}


}