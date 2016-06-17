package com.winway.wwapp2;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.winway.wwapp2.PullDownView.OnPullDownListener;

import android.app.ActionBar;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.InputType;
import android.view.Gravity;
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
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
public class ProjectFindActivity extends BaseFragment
{
	//Variables
	private ApqpListAdapter adapter;
	//private QtListAdapter adapter2;
	private ArrayList<ApqpItem> apqpItems;
	//private ArrayList<QtItem> qtItems;
	private boolean isFound=false;
	//UI
	private Button btn_return;
	private TypedArray navMenuIcons;
	private EditText txt_partno;
	private ListView lstqt;
	private Context context=null;
	private ImageView project_icon2;
	//private RelativeLayout apqp_panel;
	private TextView xa001_xa002,xa003,xa053,xa058,xa593,customer;
	private ImageView status;
	private TableLayout qt;
	private int qtSelectedIndex=-1;
	//C
	public void closeFragment()
	{
		if(this.parent!=null)
		{
			this.fragmentManager.beginTransaction().remove(this).commit();
			this.fragmentManager.beginTransaction().show(this.parent).commit();						
			showActionbar();	

		}	
		else {
			//回到Sale主畫面		
			   ((MainActivity) getActivity()).returnSale(null);	
		
		}
	}
	public void callApqpDataActivity(String apqpno) {

		/*
		 * Intent i=new Intent(MainActivity.this,ApqpDataActivity.class);
		 * i.putExtras(bundle); //將參數放入 startActivity(i);
		 */
		if(this.fragmentManager==null){
			this.fragmentManager = getFragmentManager();
		}
		Fragment fragment = null;
		
		ApqpDataActivity activity = new ApqpDataActivity();
        activity.setParent(this);
        activity.setFragmentManager(this.fragmentManager);
		fragment = (Fragment) activity;
		fragment.setRetainInstance(true);
		Bundle bundle = new Bundle();
		bundle.putString("apqpno",apqpno);
		bundle.putInt("frg_id", this.getId());
		bundle.putString("return_title","");
		bundle.putString("frg_name", "project_find");
		fragment.setArguments(bundle);
		this.fragmentManager.beginTransaction()
		.add(R.id.content_frame, fragment, "apqpdata").commit();
        this.fragmentManager.beginTransaction()
					.hide(this).commit();
		this.fragmentManager.beginTransaction().show(fragment).commit();
	}
	public void callQtDataActivity(String qtno) {

		/*
		 * Intent i=new Intent(MainActivity.this,ApqpDataActivity.class);
		 * i.putExtras(bundle); //將參數放入 startActivity(i);
		 */
		if(this.fragmentManager==null){
			this.fragmentManager = getFragmentManager();
		}
		Fragment fragment = null;

		QtDataActivity activity = new QtDataActivity();
		activity.setParent(this);
		activity.setFragmentManager(this.fragmentManager);
		fragment = (Fragment) activity;
		fragment.setRetainInstance(true);
		Bundle bundle = new Bundle();
		bundle.putString("qtno", qtno);
		//bundle.putInt("frg_id", this.getId());
		//bundle.putString("return_title","");
		//bundle.putString("frg_name", "project_find");
		fragment.setArguments(bundle);
		this.fragmentManager.beginTransaction()
				.add(R.id.content_frame, fragment, "qtdata").commit();
		this.fragmentManager.beginTransaction()
				.hide(this).commit();
		this.fragmentManager.beginTransaction().show(fragment).commit();
	}
	private void cleanTable(TableLayout table) {

		int childCount = table.getChildCount();

		// Remove all rows except the first one
		if (childCount > 1) {
			table.removeViews(1, childCount - 1);
		}
	}
	//D
	private void disableKeyobard(final EditText view,final ICallback callback)
	{
		view.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				view.setInputType(InputType.TYPE_NULL); // 關閉軟鍵盤
				return false;
			}
		});
		view.setOnFocusChangeListener(new OnFocusChangeListener() {
			public void onFocusChange(View v, boolean hasFocus) {
				if (hasFocus) {
					InputMethodManager imm = (InputMethodManager) getActivity()
							.getSystemService(Context.INPUT_METHOD_SERVICE);
					imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
					v.clearFocus();
					if(callback!=null){
						callback.doWork(null);
					}
				}
			}
		});
		
	}
	//E
	//G
	public static int getImageId(Context context, String imageName) {
		int imageId=context.getResources().getIdentifier("drawable/" + imageName, null, context.getPackageName());
		//Drawable drawable=getResources().getDrawable(drawId);
		return imageId;
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
		View view = inflater.inflate(R.layout.actprojectfind, container, false);
		context = view.getContext();
		initUI(view);
		Bundle bundle=this.getArguments();
		if(bundle!=null&&bundle.isEmpty()==false){
			if(bundle.getString("ima01").equals("")==false)
			{
				txt_partno.setText(bundle.getString("ima01"));
				btn_return.setText(bundle.getString("return_title"));
				queryData();
			}
		}
		return view;
     }
	public void initUI(View v)
	{
		qt=(TableLayout) v.findViewById(R.id.qt);
//		apqp_panel=(RelativeLayout) v.findViewById(R.id.apqp_panel);
		btn_return=(Button) v.findViewById(R.id.btn_return);
		btn_return.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				closeFragment();
			}
		});
		txt_partno=(EditText) v.findViewById(R.id.txt_partno);
//		lstqt=(ListView) v.findViewById(R.id.lstqt);
		project_icon2=(ImageView)v.findViewById(R.id.project_icon2);
		apqpItems=new ArrayList<ApqpItem>();
		//qtItems  =new ArrayList<QtItem>();
		adapter  =  new ApqpListAdapter(context, apqpItems);
		//adapter2 =  new QtListAdapter(context, qtItems);
		customer = (TextView) v.findViewById(R.id.customer);
		xa001_xa002 = (TextView) v.findViewById(R.id.xa001_xa002);
		xa001_xa002.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				String apqpno=((TextView) v).getText().toString();
				if(apqpno.equals("")==true){
					return ;
				}
				callApqpDataActivity(apqpno);

			}
		});
		xa003=(TextView)v.findViewById(R.id.xa003);
		xa053=(TextView)v.findViewById(R.id.xa053);
		xa058=(TextView)v.findViewById(R.id.xa058);
		xa593=(TextView)v.findViewById(R.id.xa593);
//		lstqt.setAdapter(adapter);
//		ColorDrawable cd = new ColorDrawable(getActivity().getResources().getColor(R.color.list_divider));
//		lstqt.setDivider(cd);
//		lstqt.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
//		lstqt.setDividerHeight(1);
//		lstqt.setHeaderDividersEnabled(true);
//		lstqt.setOnItemClickListener(this);
		//disableKeyobard(txt_partno,null);
		// set Search Edit On Click Event
		txt_partno.clearFocus();
		project_icon2.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				txt_partno.requestFocus();
				InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(context.INPUT_METHOD_SERVICE);
				imm.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
			}
		});
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
	public void loadData(Object object)
	{
		try {
			JSONObject jsonObject = new JSONObject((String) object);

			//apqpItems.clear();
			JSONArray data=jsonObject.getJSONArray("data");
			if(data.length() > 0)
			{
				JSONObject d=(JSONObject)data.get(0);
				xa001_xa002.setText(d.getString("xa001") +"-"+ d.getString("xa002"));
				xa003.setText(d.getString("xa003"));
				xa053.setText(d.getString("xa053"));
				xa058.setText(d.getString("xa058"));
				customer.setText(d.getString("customer"));
				String type =String.format("apqp_type_%s", d.getString("xa593"));
                xa593.setCompoundDrawablesWithIntrinsicBounds(getImageId(context, type), 0, 0, 0);
				JSONArray apqp1qt = d.getJSONArray("qtlist");
				if (apqp1qt.length() > 0) {
					for (int i = 0; i < apqp1qt.length(); i++) {
						JSONObject item = apqp1qt.getJSONObject(i);
						TableRow tableRow = new TableRow(context);
						tableRow.setTag(i);
						tableRow.setLayoutParams(new TableRow.LayoutParams(
								TableRow.LayoutParams.MATCH_PARENT,
								TableRow.LayoutParams.WRAP_CONTENT));
						TextView col1 = new TextView(context);
						col1.setText(item.getString("qt_type"));
						col1.setTextColor(Color.BLACK);
						col1.setLayoutParams(new TableRow.LayoutParams(
								TableRow.LayoutParams.WRAP_CONTENT,
								TableRow.LayoutParams.WRAP_CONTENT));
						col1.setGravity(Gravity.CENTER_HORIZONTAL);
						tableRow.addView(col1);

						TextView col2 = new TextView(context);
						col2.setText(item.getString("qt_no"));
						col2.setTextColor(Color.BLACK);
						col2.setLayoutParams(new TableRow.LayoutParams(
								TableRow.LayoutParams.WRAP_CONTENT,
								TableRow.LayoutParams.WRAP_CONTENT));
						col2.setGravity(Gravity.CENTER_HORIZONTAL);
						tableRow.addView(col2);
						TextView col3 = new TextView(context);
						col3.setText(item.getString("qt_upd_dt"));
						col3.setTextColor(Color.BLACK);
						col3.setLayoutParams(new TableRow.LayoutParams(
								TableRow.LayoutParams.WRAP_CONTENT,
								TableRow.LayoutParams.WRAP_CONTENT));
						col3.setGravity(Gravity.CENTER_HORIZONTAL);
						tableRow.addView(col3);
						tableRow.setClickable(true);  //allows you to select a specific row

						tableRow.setOnClickListener(new OnClickListener() {
							public void onClick(View v) {
								if(qtSelectedIndex>-1)
								{
									View row=qt.getChildAt(qtSelectedIndex);
									row.setBackgroundColor(Color.TRANSPARENT);
								}
								qtSelectedIndex=(int)v.getTag();
								v.setBackgroundColor(Color.LTGRAY);
								System.out.println("Row clicked: " + v.getId());
								//get the data you need
								//TableRow tablerow = (TableRow) v.getParent();
								TextView view1 = (TextView) ((TableRow)v).getChildAt(0);
								TextView view2 = (TextView) ((TableRow)v).getChildAt(1);
								String qtno = view1.getText().toString()+"-"+view2.getText().toString();
								//showDialog(qt_no);
								callQtDataActivity(qtno);
							}
						});
						qt.addView(tableRow, new TableLayout.LayoutParams(
								TableLayout.LayoutParams.MATCH_PARENT,
								TableLayout.LayoutParams.MATCH_PARENT));

					}
				}

			}



		} catch (Exception ex) {
			showDialog(ex.getMessage().toString());
		}
	}
	//O
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return initView(inflater, container);
	}
	@Override
    public void onResume()
    {
    	super.onResume();
    	hideActionbar();
    }
//	public void onItemClick(AdapterView<?> parent, View view, int position,
//			long id) {
//
//		// TODO Auto-generated method stub
//		final ApqpItem item = (ApqpItem) apqpItems.get(position);
//
//		adapter.setSelectItem(position);
//		adapter.notifyDataSetInvalidated();
//		// 要跟其他Fragment溝通,需要用getActivity()回到Activity
//		//((MainActivity) getActivity()).callApqpDataActivity(bundle);
//		callApqpDataActivity(item.getApqpNo());
//	}
	//Q
	public void queryData()
	{
		String url = super.getWebServiceUrl() + "queryOriAPQP";
		try {
			isLoading=1;
			launchRingDialog(null);		
			JSONObject jsonObject = new JSONObject();
			JSONObject data = new JSONObject();
			data.accumulate("PartNo", txt_partno.getText().toString());	
			jsonObject.accumulate("WWID", "13145774WWGlobal999988oriAPQPquery999");
			jsonObject.accumulate("userid", this.getLoginUser());
			jsonObject.accumulate("data", data);
			super.postRequest(url, jsonObject, new IDataReceiveListener() {
				public void onReceiveData(Object result) {
					try {
						JSONObject jsonObject = new JSONObject((String) result);
						//apqpItems.clear();
						if (!jsonObject.getString("success").equals("true")) {
							isLoading=0;
							showDialog(jsonObject.getString("remark"));
							return;
						}
						if(jsonObject.getJSONArray("data").length()==0)
						{
							isLoading=0;
							showDialog("No Data  found!!!");
							return ;
						}
						isLoading=0;
						//reset UI
						xa001_xa002.setText("");
						xa003.setText("");
						xa053.setText("");
						xa058.setText("");
						customer.setText("");
						xa593.setCompoundDrawablesWithIntrinsicBounds(0,0,0,0);
						cleanTable(qt);
						//reload data to UI
                        loadData(result);
					    //setApqpItems(jsonObject);

					} catch (Exception ex) {
						showDialog(ex.getMessage().toString());
					}
				}
			}, false);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	//S
//	private void setApqpItems(JSONObject object) throws JSONException {
//
//		JSONArray array = object.getJSONArray("data");
//		navMenuIcons = getResources().obtainTypedArray(R.array.qpqp_list_icons);
//		int icon;
//		// 如果回傳資料大於零，而且頁數仍是1，則清空舊資料
//		if (array.length() > 0 ) {
//			apqpItems.clear();
//		}
//		// msgItems = new ArrayList<MsgItem>();
//		for (int i = 0; i < array.length(); i++) {
//			JSONObject jsonObject = array.getJSONObject(i);
//			String apqpno = String.format("%s-%s",
//					jsonObject.getString("xa001"),
//					jsonObject.getString("xa002"));
//			if (jsonObject.getString("xa068").equals("Y"))
//				icon = navMenuIcons.getResourceId(0, -1);
//			else
//				icon = navMenuIcons.getResourceId(1, -1);
//			String status=jsonObject.getString("status");
//			apqpItems.add(new ApqpItem(apqpno,
//					jsonObject.getString("customer"), icon,status,jsonObject.getString("xa593")));
//		}
//		// Recycle the typed array
//		navMenuIcons.recycle();
//		adapter.notifyDataSetChanged();
//	}

	public void showActionbar()
	{
		ActionBar bar=getActivity().getActionBar();
		if(!bar.isShowing())
		{
		  bar.show();	
		}
		
	}


}
