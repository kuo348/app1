package com.winway.wwapp2;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.winway.wwapp2.BaseFragment.HttpPostAsyncTask;

import android.app.AlertDialog;
import android.app.Fragment;
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
import android.view.inputmethod.InputMethodManager;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class CustAdvSearchActivity extends BaseFragment {
	private EditText occ04, occ22, tel, contact, level;
	private Button btn_cust_adv_search2,btnReturnCustList;
	private List<String> mArea = new ArrayList<String>();
	private List<String> mAreaValue = new ArrayList<String>();
    private String[] mLevel={"A","B","C"};
    int pos;
    // C
	public void closeFragment() {
		if (this.parent != null) {
			this.fragmentManager.beginTransaction().remove(this).commit();
			this.fragmentManager.beginTransaction().show(this.parent).commit();
		}
	}

	// I
	private View initView(LayoutInflater inflater, ViewGroup container) {
		View view = inflater.inflate(R.layout.actcust_adv_search, container,
				false);
		initUI(view);
		loadAreaList(null);
		return view;

	}

	private void initUI(View v) {
		btnReturnCustList=(Button)v.findViewById(R.id.btnReturnCustList);
		occ04 = (EditText) v.findViewById(R.id.occ04);
		occ22 = (EditText) v.findViewById(R.id.occ22);
		tel = (EditText) v.findViewById(R.id.tel);
		contact = (EditText) v.findViewById(R.id.contact);
		level = (EditText) v.findViewById(R.id.level);
		btn_cust_adv_search2 = (Button) v
				.findViewById(R.id.btn_cust_adv_search2);
		occ04.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				((EditText) v).setInputType(InputType.TYPE_NULL); // 關閉軟鍵盤
				return false;
			}

		});
		occ22.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				((EditText) v).setInputType(InputType.TYPE_NULL); // 關閉軟鍵盤
				return false;
			}

		});
		level.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				((EditText) v).setInputType(InputType.TYPE_NULL); // 關閉軟鍵盤
				return false;
			}

		});
		occ04.setOnFocusChangeListener(new OnFocusChangeListener() {
			public void onFocusChange(View v, boolean hasFocus) {
				if (hasFocus) {
					InputMethodManager imm = (InputMethodManager) getActivity()
							.getSystemService(Context.INPUT_METHOD_SERVICE);
					imm.hideSoftInputFromWindow(
							((EditText) v).getWindowToken(), 0);
					showSalesDialog(v);
					((EditText) v).clearFocus();
				}
			}
		});
		occ22.setOnFocusChangeListener(new OnFocusChangeListener() {
			public void onFocusChange(View v, boolean hasFocus) {
				if (hasFocus) {
					InputMethodManager imm = (InputMethodManager) getActivity()
							.getSystemService(Context.INPUT_METHOD_SERVICE);
					imm.hideSoftInputFromWindow(
							((EditText) v).getWindowToken(), 0);
					showAreaDialog(v);
					((EditText) v).clearFocus();
				}
			}
		});
		level.setOnFocusChangeListener(new OnFocusChangeListener() {
			public void onFocusChange(View v, boolean hasFocus) {
				if (hasFocus) {
					InputMethodManager imm = (InputMethodManager) getActivity()
							.getSystemService(Context.INPUT_METHOD_SERVICE);
					imm.hideSoftInputFromWindow(
							((EditText) v).getWindowToken(), 0);
					showLevelDialog(v);
					((EditText) v).clearFocus();
				}
			}
		});
		btnReturnCustList.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				closeFragment();
			}
		});
		btn_cust_adv_search2.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if(occ04.getText().toString()==""&&occ22.getText().toString()==""&&
				   tel.getText().toString()==""&&contact.getText().toString()==""&&level.getText().toString()=="")
				{
				   closeFragment();
				}
				else {
				   queryData(0);					
				}
			}
		});
	}

	//L
	public void loadAreaList(final View v) {
		JSONObject jsonObject = new JSONObject();
		JSONObject data = new JSONObject();
		try {

			data.accumulate("pickerListType", "Area");
			jsonObject.accumulate("userid", getLoginUser());
			jsonObject.accumulate("WWID", "13145774WWGlobal999988picklist999");
			jsonObject.accumulate("data", data);
			HttpPostAsyncTask task1 = new HttpPostAsyncTask();
			task1.setCallback(new BaseFragment.ICallback() {
				@Override
				public void doWork(Object obj) {

					try {

						JSONObject jsonObject = new JSONObject((String) obj)
								.getJSONObject("data");
						JSONArray text = jsonObject.getJSONArray("text");
						JSONArray value = jsonObject.getJSONArray("value");
						for (int i = 0; i < text.length(); i++) {
							mArea.add(text.getString(i));
							mAreaValue.add(value.getString(i));
						}

					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}

			});
			task1.execute((String) super.getWebServiceUrl() + "pickerList",
					jsonObject.toString());

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
    @Override
    public void loadData(Object result)
    {    	
    	((CustomerListActivity)this.parent).loadData(result);
    	 closeFragment();
    }
	// O
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

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		return initView(inflater, container);
	}
    //Q
	// function Q
		private void queryData(int Message) {
			String json = "";
			String url = super.getWebServiceUrl() + "queryCustomers";
			JSONObject jsonObject = new JSONObject();
			JSONObject data = new JSONObject();
			try {
				((CustomerListActivity)this.parent).level=level.getText().toString();
				((CustomerListActivity)this.parent).contact=contact.getText().toString();
				((CustomerListActivity)this.parent).tel=tel.getText().toString();
				((CustomerListActivity)this.parent).occ04=occ04.getText().toString();
				((CustomerListActivity)this.parent).occ22=occ22.getText().toString();
				data.accumulate("OCC03",level.getText().toString());//客戶等級
				data.accumulate("OCC04",occ04.getText().toString());//負責業務員
		        data.accumulate("OCC22",occ22.getText().toString());//區域
		        data.accumulate("CONTACT",contact.getText().toString());//聯絡人
		        data.accumulate("TEL",tel.getText().toString());//電話;
				jsonObject.accumulate("userid", super.getLoginUser());
				jsonObject.accumulate("WWID", "13145774WWGlobal999988custquery999");
				jsonObject.accumulate("data", data);
				jsonObject.accumulate("page", 1);
				super.postRequest(url, jsonObject, Message);

			} catch (JSONException e) {
				// TODO Auto-generated catch block
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

	public void showAreaDialog(final View v) {
         if(mArea.size()==0)
         {        	 
        	loadAreaList(v); 
         }		
		String[] mString = new String[mArea.size()];
		for (int i = 0; i < mArea.size(); i++) {
			mString[i] = mArea.get(i);

		}
		AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity());
		dialog.setTitle("").setIcon(android.R.drawable.ic_dialog_info);
		dialog.setSingleChoiceItems(mString, 0,
				new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						pos = which;						
					}
				});
		dialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface d, int which) {
				((EditText)v).setText(mArea.get(pos).toString());
				((EditText)v).setHint(mAreaValue.get(pos).toString());
				((EditText)v).clearFocus();
				d.dismiss();
				d = null;
			}
		});
		dialog.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface d, int which) {
						v.clearFocus();
						d.dismiss();
					}
				});
		dialog.show();

	}

	public void showLevelDialog(final View v) {
        pos=0;
		AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity());
		dialog.setTitle("").setIcon(android.R.drawable.ic_dialog_info);
		dialog.setSingleChoiceItems(mLevel, 0,
				new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						pos = which;
			  	}
				});
		dialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface d, int which) {
	    		((EditText)v).setText(mLevel[pos].toString());
				v.clearFocus();
				d.dismiss();
				d = null;
			}
		});
		dialog.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface d, int which) {
						v.clearFocus();
						d.dismiss();
					}
				});
		dialog.show();

	}

}
