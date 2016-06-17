package com.winway.wwapp2;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.InputType;
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

public class StockActivity extends BaseFragment {
	private Context context;
	private EditText txt_partno;
	private RelativeLayout stock_r2_3;
	private Button btn_return,btn_detail;
	private ImageView stock_icon2,stock_icon3;
	private TextView ima02,ima021,imaud01,latest_pur,img10,sfa_q,pml_q,pmn_q,oeb24,oeb_q,img_q,img_q2,pml_q3,rvb_q;
	protected boolean isFound=false;
	protected Bundle bundle;
	//C
	public void closeFragment()
	{
		if(this.parent!=null)
		{
			this.fragmentManager.beginTransaction().remove(this).commit();
			this.fragmentManager.beginTransaction().show(this.parent).commit();
			if(bundle.getInt("frg_id")==R.layout.actinventory)
			{				
			    showActionbar();	
			}
		}	
		else {
			//回到Sale主畫面		
			   ((MainActivity) getActivity()).returnSale(null);	
		
		}
	}	
	 public void callStockDetailActivity(String content)
	    {
		    if(content=="") return;
	    	StockDetailActivity activity = new StockDetailActivity();
			activity.parent = this;
			if (this.fragmentManager == null) {
				this.fragmentManager = getFragmentManager();
			}
			activity.fragmentManager = this.fragmentManager;
			Bundle b = new Bundle();
			b.putInt("frg_id", this.getId());
			b.putString("ima01", content);
			activity.setArguments(b);
			activity.setParent(this);
			if (this.fragmentManager.findFragmentById(activity.getId()) == null) {
				this.fragmentManager.beginTransaction()
						.add(R.id.content_frame, activity, "stockdetail").commit();
			}
			this.fragmentManager.beginTransaction().hide(this).commit();
			this.fragmentManager.beginTransaction().show(activity).commit();

	    	
	    }
    //H
	public void hideActionbar()
	{
		ActionBar bar=getActivity().getActionBar();
		if(bar.isShowing())
		{
			bar.hide();			
		}
	}
	//I
    private View initView(LayoutInflater inflater, ViewGroup container) {
		View view = inflater.inflate(R.layout.actstockdata, container, false);
		context = view.getContext();
		bundle=this.getArguments();
		initUI(view);		
		if(bundle!=null){
			btn_return.setText(bundle.getString("return_title"));
			if(bundle.getString("ima01")!=null&&bundle.getString("ima01")!=""){
			  txt_partno.setText(bundle.getString("ima01"));	
			  queryData();
			}
		}
		return view;
	}
    protected void initUI(View view)
    {
    	//
    	stock_r2_3=(RelativeLayout) view.findViewById(R.id.stock_r2_3);
    	ima02 = (TextView) view.findViewById(R.id.ima02);
		ima021 = (TextView) view.findViewById(R.id.ima021);
		imaud01= (TextView) view.findViewById(R.id.imaud01);
		img10 = (TextView) view.findViewById(R.id.img10);
		sfa_q = (TextView) view.findViewById(R.id.sfa_q);
		pml_q = (TextView) view.findViewById(R.id.pml_q);
		pmn_q = (TextView) view.findViewById(R.id.pmn_q);
		oeb24 = (TextView) view.findViewById(R.id.oeb24);
		oeb_q = (TextView) view.findViewById(R.id.oeb_q);
		img_q = (TextView) view.findViewById(R.id.img_q);
		img_q2 = (TextView) view.findViewById(R.id.img_q2);
		pml_q3 = (TextView) view.findViewById(R.id.pml_q3);
		rvb_q = (TextView) view.findViewById(R.id.rvb_q);
		latest_pur = (TextView) view.findViewById(R.id.latest_pur);
		//
		txt_partno = (EditText) view.findViewById(R.id.txt_partno);
		stock_icon2=(ImageView) view.findViewById(R.id.stock_icon2);
		stock_icon3=(ImageView) view.findViewById(R.id.stock_icon3);
		btn_return=(Button) view.findViewById(R.id.btn_return);
		btn_detail=(Button) view.findViewById(R.id.btn_detail);
		btn_return.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				closeFragment();
			}
		});
		btn_detail.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				if(isFound) {
					callStockDetailActivity(txt_partno.getText().toString());
				}
			}
		});
		txt_partno.clearFocus();
		stock_icon2.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				txt_partno.requestFocus();
				InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(context.INPUT_METHOD_SERVICE);
				imm.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
			}
		});
		stock_icon3.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				if(view.getTag()=="up")
				{
					view.setTag("down");
					stock_icon3.setImageResource(R.drawable.stock_down_arraw);
					stock_r2_3.setVisibility(View.GONE);
				}
				else {
					view.setTag("up");
					stock_icon3.setImageResource(R.drawable.stock_up_arraw);
					stock_r2_3.setVisibility(View.VISIBLE);
					
				}
			}
		});
		// set Search Edit On Click Event
		txt_partno.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
			}
		});
		// set Search Edit OnTouch Event
		txt_partno.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View view, MotionEvent event) {
				// editSearch.setInputType(InputType.TYPE_NULL); // 關閉軟鍵盤
				return false;
			}
		});
		// set Search Edit Focus Event
		txt_partno.setOnFocusChangeListener(new OnFocusChangeListener() {
			@Override
			public void onFocusChange(View v, boolean hasFocus) {
				if (hasFocus) {

				}
			}

		});
		txt_partno.setOnKeyListener(new OnKeyListener() {
			@Override
			public boolean onKey(View view, int args, KeyEvent keyEvent) {
				if ((keyEvent.getAction() == 0) && (args == 66) 
						&&txt_partno.getText().toString().equals("")==false) {
					isFound=false;
					queryData();
					txt_partno.clearFocus();
				}
				return false;
			}
		});
    }
    //L
    public void loadJSONData(JSONObject jsonObject)
    {
    	JSONArray data;
		try {
			data = jsonObject.getJSONArray("data");
			if (data.length() == 0)
				return;		
			isFound=true;
			for (int i = 0; i < data.length(); i++) {
				JSONObject d = data.getJSONObject(i);
				ima02.setText(d.getString("IMA02"));
				ima021.setText(d.getString("IMA021"));
				imaud01.setText(d.getString("IMAUD01"));
				sfa_q.setText(d.getString("SFA_Q"));
				rvb_q.setText(d.getString("RVB_Q"));
				img10.setText(d.getString("IMG10"));
				pml_q.setText(d.getString("PML_Q"));
				pmn_q.setText(d.getString("PMN_Q"));
				pml_q3.setText(d.getString("PML_Q3"));
				oeb_q.setText(d.getString("OEB_Q"));
				oeb24.setText(d.getString("OEB24"));
				img_q2.setText(d.getString("IMG_Q2"));
				img_q.setText(d.getString("IMG_Q"));
				latest_pur.setText(d.getString("LATEST_PUR"));
			}

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    	
    }
    //O
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
	//Q
	public void queryData()
	{
		String url = super.getWebServiceUrl() + "queryStock";
		try {
			isLoading=1;
			launchRingDialog(null);		
			JSONObject jsonObject = new JSONObject();
			JSONObject data = new JSONObject();
			data.accumulate("PartNo", txt_partno.getText().toString());	
			jsonObject.accumulate("WWID", "13145774WWGlobal999988stockquery999");
			jsonObject.accumulate("userid", this.getLoginUser());
			jsonObject.accumulate("data", data);
			super.postRequest(url, jsonObject, new IDataReceiveListener() {
				public void onReceiveData(Object result) {
					try {
						JSONObject jsonObject = new JSONObject((String) result);
						if (!jsonObject.getString("success").equals("true")) {
							isLoading=0;
							showDialog(jsonObject.getString("remark"));
							return;
						}
						if(jsonObject.getJSONArray("data").length()==0)
						{
							isLoading=0;
							showDialog("Data not found!!!");
							return ;
						}
					    loadJSONData(jsonObject);
						isLoading=0;
					} catch (Exception ex) {

					}
				}
			}, false);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
   //S
	public void showActionbar()
	{
		ActionBar bar=getActivity().getActionBar();
		if(!bar.isShowing())
		{
			bar.show();		
		}
	}
	
}
