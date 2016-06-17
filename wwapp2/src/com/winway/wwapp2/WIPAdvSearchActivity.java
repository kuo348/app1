package com.winway.wwapp2;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.ActionBar;
import android.app.Activity;
import android.app.DatePickerDialog;
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
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import android.view.MotionEvent;
import android.content.DialogInterface;

public class WIPAdvSearchActivity extends BaseFragment {
	protected static final int REFRESH_DATA = 2;
	private static final int WHAT_DID_LOAD_DATA = 0;
	private static final int WHAT_DID_MORE = 5;
	private static final int WHAT_DID_REFRESH = 1;
	private Button btnAdvSearch;
	private Button btnRetrunWIPList;
	private Context context;
	private View mView;
	private int page;
	private EditText schdatestart;
	private EditText schdateend;
	private EditText custpo;
	private EditText deviceno;
	private EditText productno;
	private EditText productclass;
	private EditText custname;
	private EditText contactuser;
	private EditText contactelement;
	private EditText salesrep;
	private int pos = 0;
	private int mYear, mMonth, mDay;

	// A
	public WIPAdvSearchActivity() {
		this.page = 1;
	}

	// C
	private void closeFragment() {
		if (fragmentManager == null) {
			fragmentManager = getActivity().getFragmentManager();
		}
		if (this.parent != null) {
			fragmentManager.beginTransaction().remove(this).commit();
			fragmentManager.beginTransaction().show(this.parent).commit();
		}
	}

	// H
	public void hideActionbar() {
		ActionBar mActionBar = getActivity().getActionBar();
		if (mActionBar.isShowing())
			mActionBar.hide();
	}

	// I
	private void initUI(View view) {
		 final WIPListActivity activity=(WIPListActivity )this.parent;
		schdatestart = ((EditText) view.findViewById(R.id.schdatestart));
		schdateend = ((EditText) view.findViewById(R.id.schdateend));
		custpo = ((EditText) view.findViewById(R.id.custpo));
		deviceno = ((EditText) view.findViewById(R.id.deviceno));
		productno = ((EditText) view.findViewById(R.id.productno));
		productclass = ((EditText) view.findViewById(R.id.productclass));
		custname = ((EditText) view.findViewById(R.id.custname));
		contactelement = ((EditText) view.findViewById(R.id.contactelement));
		contactuser= ((EditText) view.findViewById(R.id.contactuser));
		salesrep= ((EditText) view.findViewById(R.id.salesrep));
		salesrep.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				salesrep.setInputType(InputType.TYPE_NULL); // 關閉軟鍵盤
				return false;
			}
		});
		salesrep.setOnFocusChangeListener(new OnFocusChangeListener() {
			public void onFocusChange(View v, boolean hasFocus) {
				if (hasFocus) {
					InputMethodManager imm = (InputMethodManager) getActivity()
							.getSystemService(Context.INPUT_METHOD_SERVICE);
					imm.hideSoftInputFromWindow(salesrep.getWindowToken(), 0);
					showSalesDialog(v);
					salesrep.clearFocus();
				}
			}
		});
        if(activity.selectedTab.equals("pre-shipping"))
        {
        	TextView schedule_date=(TextView)view.findViewById(R.id.schedule_date);
        	schedule_date.setText("Shipping Date:");        	
        }
		this.schdatestart.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				schdatestart.setInputType(InputType.TYPE_NULL); // 關閉軟鍵盤
				return false;
			}
		});
		this.schdatestart.setOnFocusChangeListener(new OnFocusChangeListener() {
			public void onFocusChange(View v, boolean hasFocus) {

				if (hasFocus) {
					InputMethodManager imm = (InputMethodManager) getActivity()
							.getSystemService(Context.INPUT_METHOD_SERVICE);
					imm.hideSoftInputFromWindow(schdatestart.getWindowToken(),
							0);
					showDateDialog(v);
					schdatestart.clearFocus();
				}
			}
		});
		schdateend.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				schdateend.setInputType(InputType.TYPE_NULL); // 關閉軟鍵盤
				return false;
			}
		});
		schdateend.setOnFocusChangeListener(new OnFocusChangeListener() {
			public void onFocusChange(View v, boolean hasFocus) {
				if (hasFocus) {
					InputMethodManager imm = (InputMethodManager) getActivity()
							.getSystemService(Context.INPUT_METHOD_SERVICE);
					imm.hideSoftInputFromWindow(schdateend.getWindowToken(), 0);
					showDateDialog(v);
					schdateend.clearFocus();
				}
			}
		});
		this.btnAdvSearch = ((Button) view.findViewById(R.id.btnAdvSearch));
		this.btnAdvSearch.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				activity.page=1;
				activity.SCHDateStart =schdatestart.getText().toString(); 
				activity.SCHDateEnd =schdateend.getText().toString(); 
				activity.ProductClass=productclass.getText().toString();
				activity.CustName=custname.getText().toString();
				activity.CustPO=custpo.getText().toString();
				activity.ProductNo=productno.getText().toString();
				activity.DeviceNO=deviceno.getText().toString();
				activity.ContactElement=contactelement.getText().toString();
				activity.ContactUser=contactuser.getText().toString();
				activity.SalesRep=salesrep.getText().toString();
				activity.queryData(WHAT_DID_LOAD_DATA);
				closeFragment();
				
			}
		});
		this.btnRetrunWIPList = ((Button) view
				.findViewById(R.id.btnReturnWIPList));
		this.btnRetrunWIPList.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				closeFragment();
			}
		});
	}

	private View initView(LayoutInflater inflater, ViewGroup container) {

		View view = inflater.inflate(R.layout.actwip_adv_search, container,
				false);
		this.context = view.getContext();
		initUI(view);
		return view;
	}

	// L
	public void loadData(Object result) {

	}

	// O
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle paramBundle) {

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
		// sm.unregisterListener(listener);
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

	}

	// S
	public void showDateDialog(final View view) {
		final Calendar c = Calendar.getInstance();
		String sDate = ((EditText) view).getText().toString();
		if (sDate.equals("") == true) {
			mYear = c.get(Calendar.YEAR);
			mMonth = c.get(Calendar.MONTH);
			mDay = c.get(Calendar.DAY_OF_MONTH);
		} else {
			mYear = Integer.parseInt(((EditText) view).getText()
					.subSequence(0, 4).toString());
			mMonth = Integer.parseInt(((EditText) view).getText()
					.subSequence(4, 6).toString()) - 1;
			mDay = Integer.parseInt(((EditText) view).getText()
					.subSequence(6, 8).toString());

		}
		DatePickerDialog d = new DatePickerDialog(getActivity(),
				new DatePickerDialog.OnDateSetListener() {
					public void onDateSet(DatePicker v, int year,
							int monthOfYear, int dayOfMonth) {
						mYear = year;
						mMonth = monthOfYear;
						mDay = dayOfMonth;
						((EditText) view).setText(String.format("%d%02d%02d",
								mYear, mMonth + 1, mDay));
					}
				}, mYear, mMonth, mDay);
		d.setButton(DialogInterface.BUTTON_NEGATIVE, "Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {
						if (which == DialogInterface.BUTTON_NEGATIVE) {
							dialog.dismiss();
							((EditText) view).setText("");
						}
					}
				});
		d.show();

	}
	public void showSalesDialog(View view) {
		SalesListActivity activity = new SalesListActivity();
		activity.parent = this;
		activity.setFragmentManager(getFragmentManager());
		Bundle b = new Bundle();
		b.putString("controltype", "EditText");
		b.putInt("controlid", view.getId());
		b.putInt("frg_id", this.getId());
		b.putString("func_name","openWindowSalesRep");
		Fragment f = activity;
		f.setArguments(b);
		openDialog(f, "Sales Rep");
	}
}