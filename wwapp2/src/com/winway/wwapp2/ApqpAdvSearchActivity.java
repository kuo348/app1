package com.winway.wwapp2;

/**
 * Apqp 搜尋頁
 * 
 * 
 */
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnTouchListener;
import android.view.inputmethod.InputMethodManager;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SimpleAdapter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import android.view.MotionEvent;
import android.content.DialogInterface;

public class ApqpAdvSearchActivity extends BaseFragment {
	protected static final int REFRESH_DATA = 2;
	private static final int WHAT_DID_LOAD_DATA = 0;
	private static final int WHAT_DID_MORE = 5;
	private static final int WHAT_DID_REFRESH = 1;
	private int ACTION_MESSAGE;
	private EditText apqpno;
	private Button btnAdvSearch;
	private Button btnRetrunApqpList;
	private Context context;
	private EditText customer;
	private List<Map<String, Object>> items;
	private String[] mApqpType = { "Socket", "Duplication", "WLCSP", "ATC",
			"FinePitch ProbeCard", "Changeover Kit", "E-Flux" };
	private View mView;
	private int page;
	private SimpleAdapter simpleAdapter;
	private EditText xa005;
	private EditText xa010;
	private EditText xa058;
	private EditText xa053;
	private EditText xa593;
	private int pos = 0;

	// A
	public ApqpAdvSearchActivity() {

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
		// if (fragmentManager.findFragmentByTag("apqp_adv_search") != null)
		fragmentManager.beginTransaction().hide(this).commit();
	}

	// I
	private void initUI(View view) {

		this.apqpno = ((EditText) view.findViewById(R.id.apqpno));
		this.xa593 = ((EditText) view.findViewById(R.id.xa593));
		this.xa005 = ((EditText) view.findViewById(R.id.xa005));
		this.xa010 = ((EditText) view.findViewById(R.id.xa010));
		this.xa058 = ((EditText) view.findViewById(R.id.xa058));
		this.xa053 = ((EditText) view.findViewById(R.id.xa053));
		this.customer = ((EditText) view.findViewById(R.id.customer));
		this.xa593.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {

				xa593.setInputType(InputType.TYPE_NULL); // 關閉軟鍵盤
				return false;
			}

		});

		/*
		 * this.xa593.setOnClickListener(new OnClickListener(){
		 * 
		 * @Override public void onClick(View v){ showApqpTypeDialog(v);
		 * xa593.clearFocus(); } });
		 */
		this.xa593.setOnFocusChangeListener(new OnFocusChangeListener() {
			public void onFocusChange(View v, boolean hasFocus) {

				if (hasFocus) {
					InputMethodManager imm = (InputMethodManager) getActivity()
							.getSystemService(Context.INPUT_METHOD_SERVICE);
					imm.hideSoftInputFromWindow(xa593.getWindowToken(), 0);
					showApqpTypeDialog(v);
					xa593.clearFocus();
				}
			}
		});
		xa053.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				xa053.setInputType(InputType.TYPE_NULL); // 關閉軟鍵盤
				return false;
			}
		});
		xa053.setOnFocusChangeListener(new OnFocusChangeListener() {
			public void onFocusChange(View v, boolean hasFocus) {
				if (hasFocus) {
					InputMethodManager imm = (InputMethodManager) getActivity()
							.getSystemService(Context.INPUT_METHOD_SERVICE);
					imm.hideSoftInputFromWindow(xa053.getWindowToken(), 0);
					showSalesDialog(v);
					xa053.clearFocus();
				}
			}
		});
		this.btnAdvSearch = ((Button) view.findViewById(R.id.btnAdvSearch));
		this.btnAdvSearch.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				// ACTION_MESSAGE=WHAT_DID_LOAD_DATA;
				// queryData(ACTION_MESSAGE);
				showAdvSerchList();
			}
		});
		this.btnRetrunApqpList = ((Button) view
				.findViewById(R.id.btnReturnApqpList));
		this.btnRetrunApqpList.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				closeFragment();
			}
		});
	}

	private View initView(LayoutInflater inflater, ViewGroup container) {

		View view = inflater.inflate(R.layout.actapqp_adv_search, container,
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
				bundle.putString("apqpno", this.apqpno.getText().toString());
				bundle.putString("xa593", Integer.toString(pos + 1));
				bundle.putString("xa005", this.xa005.getText().toString());
				bundle.putString("xa010", this.xa010.getText().toString());
				bundle.putString("xa058", this.xa058.getText().toString());
				bundle.putString("xa053", this.xa053.getText().toString());
				bundle.putString("customer", this.customer.getText().toString());
				ApqpListSearchResultActivity activity = new ApqpListSearchResultActivity();
				activity.setArguments(bundle);
				activity.setParent(this);
				if (fragmentManager.findFragmentById(activity.getId()) == null)
					fragmentManager
							.beginTransaction()
							.add(R.id.content_frame, activity,
									"apqp_search_result").commit();
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

		String str = super.getWebServiceUrl() + "queryAPQP";
		JSONObject jsonObject = new JSONObject();
		JSONObject data = new JSONObject();
		try {
			data.accumulate("apqpno", this.apqpno.getText().toString());// 积累这个value到该key下，如果key存在，则该key的值为数组
			data.accumulate("xa593", pos + 1);
			data.accumulate("xa005", this.xa005.getText().toString());
			data.accumulate("xa010", this.xa010.getText().toString());
			data.accumulate("xa058", this.xa058.getText().toString());
			data.accumulate("customer", this.customer.getText().toString());
			data.accumulate("xa053", xa053.getText().toString());
			jsonObject.accumulate("userid", super.getLoginUser());
			jsonObject.accumulate("WWID", "13145774WWGlobal999988apqpquery999");
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
		SalesListActivity activity = new SalesListActivity();
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

		FragmentManager fragmentManager = getFragmentManager();
		Bundle bundle = new Bundle();
		bundle.putString("apqpno", apqpno.getText().toString());
		bundle.putString("xa593", Integer.toString(pos + 1));
		bundle.putString("xa005", xa005.getText().toString());
		bundle.putString("xa010", xa010.getText().toString());
		bundle.putString("xa058", xa058.getText().toString());
		bundle.putString("xa053", xa053.getText().toString());
		bundle.putString("customer", customer.getText().toString());
		ApqpListSearchResultActivity activity = new ApqpListSearchResultActivity();
		activity.setArguments(bundle);
		activity.setParent(this);
		if (fragmentManager.findFragmentById(activity.getId()) == null)
			fragmentManager.beginTransaction()
					.add(R.id.content_frame, activity, "apqp_search_result")
					.commit();
		hideFragment();
		fragmentManager.beginTransaction().show(activity).commit();

	}

	public void showApqpTypeDialog(View view) {

		AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity());
		dialog.setTitle("Apqp Type").setIcon(android.R.drawable.ic_dialog_info);
		dialog.setSingleChoiceItems(this.mApqpType, 0,
				new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						pos = which;
						// xa593.setText(mApqpType[which].toString());
						// xa593.clearFocus();
						// dialog.dismiss();
					}
				});
		dialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface d, int which) {

				xa593.setText(mApqpType[pos].toString());
				xa593.clearFocus();
				d.dismiss();
				d = null;
			}
		});
		dialog.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface d, int which) {

						// xa593.setText("");
						xa593.clearFocus();
						d.dismiss();
					}
				});
		dialog.show();
	}
}