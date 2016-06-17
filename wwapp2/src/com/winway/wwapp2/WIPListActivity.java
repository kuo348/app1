package com.winway.wwapp2;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Fragment;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Path.Direction;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnKeyListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.inqbarna.tablefixheaders.TableFixHeaders;
import com.winway.widget.WWTextView;

public class WIPListActivity extends BaseFragment {
	protected TableFixHeaders tableFixHeaders;
	protected Context context;
	public int page = 1;
	protected final int REFRESH_DATA = 0x00000002;
	protected final int WHAT_DID_LOAD_DATA = 0;
	protected final int WHAT_DID_REFRESH = 1;
	protected final int WHAT_DID_MORE = 5;
	private ArrayList<WIPItem> wipItems;
	MatrixTableAdapter<String> matrixTableAdapter;
	private Button btnOnGoing, btnShipped, btnVPC, btnPreShipping;
	private OnClickListener onButtonClickListener;
	private EditText editSearch;
	private Button btn_wip_search;
	private Button btnReturnOrderInfo;
	public String selectedTab = "On-going";
	public String SCHDateStart = "Today";
	public String SCHDateEnd = "Today";
	public String CustName = "";
	public String CustPO = "";
	public String ContactUser="";
	public String SalesRep="";
	public String DeviceNO = "";
	public String ContactElement = "";
	public String ProductClass = "";
	public String ProductNo = "";
    public int isLoading;
	// C
	protected void closeFragment() {
		if (this.fragmentManager == null) {
			this.fragmentManager = getActivity().getFragmentManager();
		}
		if (this.parent != null) {
			this.fragmentManager.beginTransaction().remove(this).commit();
			this.fragmentManager.beginTransaction().show(this.parent).commit();
		}
	}

	public void callApqpDataActivity(String content) {
		ApqpDataActivity activity = new ApqpDataActivity();
		activity.parent = this;
		if (this.fragmentManager == null) {
			this.fragmentManager = getFragmentManager();
		}
		activity.fragmentManager = this.fragmentManager;
		Bundle b = new Bundle();
		b.putInt("frg_id", this.getId());
		b.putString("return_title","WIP");
		b.putString("apqpno", content);
		activity.setArguments(b);
		activity.setParent(this);
		if (this.fragmentManager.findFragmentById(activity.getId()) == null) {
			this.fragmentManager.beginTransaction()
					.add(R.id.content_frame, activity, "apqpdata").commit();
		}
		this.fragmentManager.beginTransaction().hide(this).commit();
		this.fragmentManager.beginTransaction().show(activity).commit();

	}
    public void callStockActivity(String content)
    {
    	StockActivity activity = new StockActivity();
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
					.add(R.id.content_frame, activity, "stockdata").commit();
		}
		this.fragmentManager.beginTransaction().hide(this).commit();
		this.fragmentManager.beginTransaction().show(activity).commit();

    	
    }
	public void callBomListActivity(String content) {
		BomActivity activity = new BomActivity();
		activity.parent = this;
		if (this.fragmentManager == null) {
			this.fragmentManager = getFragmentManager();
		}
		activity.fragmentManager = this.fragmentManager;
		Bundle b = new Bundle();
		b.putInt("frg_id", this.getId());
		b.putString("bma01", content);
		activity.setArguments(b);
		activity.setParent(this);
		if (this.fragmentManager.findFragmentById(activity.getId()) == null) {
			this.fragmentManager.beginTransaction()
					.add(R.id.content_frame, activity, "bomdata").commit();
		}
		this.fragmentManager.beginTransaction().hide(this).commit();
		this.fragmentManager.beginTransaction().show(activity).commit();

	}

	public void callCustomerDataActivity(String content) {
		CustomerDataActivity activity = new CustomerDataActivity();
		activity.parent = this;
		if (this.fragmentManager == null) {
			this.fragmentManager = getFragmentManager();
		}
		activity.fragmentManager = this.fragmentManager;
		Bundle b = new Bundle();
		b.putInt("frg_id", this.getId());
		b.putString("occ01", content);
		activity.setArguments(b);
		activity.setParent(this);
		if (this.fragmentManager.findFragmentById(activity.getId()) == null) {
			this.fragmentManager.beginTransaction()
					.add(R.id.content_frame, activity, "custdata").commit();
		}
		this.fragmentManager.beginTransaction().hide(this).commit();
		this.fragmentManager.beginTransaction().show(activity).commit();

	}

	public void callWIPSearhActivity() {
		WIPAdvSearchActivity activity = new WIPAdvSearchActivity();
		activity.parent = this;
		activity.setFragmentManager(this.fragmentManager);
		Fragment fragment = activity;
		fragment.setRetainInstance(true);
		if (fragmentManager.findFragmentById(fragment.getId()) == null) {
			fragmentManager.beginTransaction()
					.add(R.id.content_frame, fragment, "wip_adv_search")
					.commit();
		}
		fragmentManager.beginTransaction().hide(this).commit();
		fragmentManager.beginTransaction().show(fragment).commit();

	}

	public String[][] convertWIPItmes(ArrayList<WIPItem> items) {
		String[][] table = new String[items.size() + 1][];
		if (selectedTab.equals("pre-shipping")) {
			table[0] = new String[] { "SO NO\nCustomer","Status", "Confirmed SOD",
					"Order\nType", "Rep. Sales", "APQP NO", "Customer PO#",
					"Prod Class", "Order\nQ'ty", "Products No", "Ship Via",
					"Express #", "Shipping#", "Remark" };
		} else {
			table[0] = new String[] { "SO NO\nCustomer", "ITEM\nGrade",
					"Cust SOD", "Confirmed\nSOD", "Order\nType", "Rep. Sales",
					"APQP NO", "Customer PO#", "Prod Class", "Order\nQ'ty",
					"Products Spec", "Products No", "Device No",
					"Modify \nShip Date", "Schedule\nDate", "Ship Via",
					"Customer\nP/N", "SO Issue", "PC Start\nDate",
					"ENG Engineer", "Contact Element P/N Code",
					"PIN/PCR Check", "Socket S/N" };

		}

		for (int i = 0; i < items.size(); i++) {
			WIPItem item = (WIPItem) items.get(i);
			if (item.getAPQPNO().contains("以上")) {
				String group_text = item.getAPQPNO();
				if (selectedTab.equals("pre-shipping")) {
					table[i + 1] = new String[] { group_text,group_text, group_text,
							group_text, group_text, group_text, group_text,
							group_text, group_text, group_text, group_text,
							group_text, group_text, group_text  };
				} else {
					table[i + 1] = new String[] { group_text, group_text,
							group_text, group_text, group_text, group_text,
							group_text, group_text, group_text, group_text,
							group_text, group_text, group_text, group_text,
							group_text, group_text, group_text, group_text,
							group_text, group_text, group_text, group_text,
							group_text };
				}
				continue;
			}
			if (selectedTab.equals("pre-shipping")) {
				table[i + 1] = new String[] {
						item.getSONO() + "\n" + item.getCustomer() + "\n"
								+ item.getCustomerNo(), item.getIconTag(),						
						item.getConfirmedSOD(),
						item.getOrderType(), item.getREpSales(),
						item.getAPQPNO()+"\n"+item.getNextShipDate(), item.getCustomerPO(),
						item.getProdClass(), item.getOrderQty(),
						item.getProductsNo(), item.getShipVia(),
						item.getExpress(), item.getShipping(), item.getRemark() };
			} else {
				table[i + 1] = new String[] {
						item.getSONO() + "\n" + item.getCustomer() + "\n"
								+ item.getCustomerNo(),
						item.getITEM() + "\n" + item.getGRADE(),
						item.getCustSODSalesReq(), item.getConfirmedSOD(),
						item.getOrderType(), item.getREpSales(),
						item.getAPQPNO(), item.getCustomerPO(),
						item.getProdClass(), item.getOrderQty(),
						item.getProductsSpec(), item.getProductsNo(),
						item.getDeviceNo(), item.getModifyShipDate(),
						item.getScheduleDate(), item.getShipVia(),
						item.getCustomerPN(), item.getSOIssue(),
						item.getPCStartDate(), item.getENGEngineer(),
						item.getContactElementPN(), item.getPINPCRCheck(),
						item.getSocketSN() };
			}
		}
		return table;
	}

	// L
	@Override
	public void loadData(Object result) {
		try {
			JSONObject jsonObject = new JSONObject((String) result);
			if (!jsonObject.getString("success").equals("true")) {
				this.showDialog(jsonObject.getString("remark"));
				return;
			}
			wipItems.clear();
			setWIPItems(jsonObject);
			// matrixTableAdapter = new
			// MatrixTableAdapter<String>(getActivity(),convertWIPItmes(wipItems));
			// tableFixHeaders.setAdapter(matrixTableAdapter);
			matrixTableAdapter.setInformation(convertWIPItmes(wipItems));
			matrixTableAdapter.notifyDataSetChanged();

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// H
	public void hideActionbar() {
		ActionBar mActionBar = getActivity().getActionBar();
		if (mActionBar.isShowing())
			mActionBar.hide();
	}

	// I
	private void InitUI(View view) {
		editSearch = (EditText) view.findViewById(R.id.search_text);
		btnOnGoing = (Button) view.findViewById(R.id.btnOnGoing);
		btnShipped = (Button) view.findViewById(R.id.btnShipped);
		btnVPC = (Button) view.findViewById(R.id.btnVPC);
		btnPreShipping = (Button) view.findViewById(R.id.btnPreShipping);
		btnReturnOrderInfo = (Button) view
				.findViewById(R.id.btnReturnOrderInfo);
		btnReturnOrderInfo.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				closeFragment();
			}
		});
		btn_wip_search = (Button) view.findViewById(R.id.btn_wip_search);
		btn_wip_search.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				editSearch.setText("");
				callWIPSearhActivity();
			}
		});
		SCHDateStart = "Today";
		SCHDateEnd = "Today";
		selectedTab = "On-going";
		btnOnGoing
				.setBackgroundResource(R.drawable.wip_on_going_tab_icon_selected);
		onButtonClickListener = new OnClickListener() {
			public void onClick(View v) {
				matrixTableAdapter.selectedIndex = -1;
				SCHDateStart = "Today";
				SCHDateEnd   = "Today";
				CustName = "";
				CustPO = "";
				DeviceNO = "";
				ContactElement = "";
				ProductClass = "";
				ProductNo = "";
				ContactUser="";
				SalesRep="";
				btnOnGoing
						.setBackgroundResource(R.drawable.wip_on_going_tab_icon);
				btnShipped
						.setBackgroundResource((R.drawable.wip_shipped_tab_icon));
				btnVPC.setBackgroundResource(R.drawable.wip_vpc_tab_icon);
				btnPreShipping
						.setBackgroundResource(R.drawable.wip_preshipping_tab_icon);
				switch (v.getId()) {
				case R.id.btnOnGoing:
					selectedTab = "On-going";
					btnOnGoing
							.setBackgroundResource(R.drawable.wip_on_going_tab_icon_selected);
					break;
				case R.id.btnShipped:
					selectedTab = "shipped";
					btnShipped
							.setBackgroundResource((R.drawable.wip_shiped_tab_icon_selected));
					break;
				case R.id.btnVPC:
					selectedTab = "vpc";
					btnVPC.setBackgroundResource((R.drawable.wip_vpc_tab_icon_selected));
					break;
				case R.id.btnPreShipping:
					selectedTab = "pre-shipping";
					btnPreShipping
							.setBackgroundResource((R.drawable.wip_preshipping_tab_icon_selected));
					break;
				}

				queryData(WHAT_DID_LOAD_DATA);
			}
		};
		btnOnGoing.setOnClickListener(onButtonClickListener);
		btnVPC.setOnClickListener(onButtonClickListener);
		btnShipped.setOnClickListener(onButtonClickListener);
		btnPreShipping.setOnClickListener(onButtonClickListener);
		editSearch.clearFocus();
		// set Search Edit On Click Event
		this.editSearch.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
			}
		});
		// set Search Edit OnTouch Event
		this.editSearch.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View view, MotionEvent event) {
				// editSearch.setInputType(InputType.TYPE_NULL); // 關閉軟鍵盤
				return false;
			}
		});
		// set Search Edit Focus Event
		this.editSearch.setOnFocusChangeListener(new OnFocusChangeListener() {
			@Override
			public void onFocusChange(View v, boolean hasFocus) {
				if (hasFocus) {

				}
			}

		});
		this.editSearch.setOnKeyListener(new OnKeyListener() {
			@Override
			public boolean onKey(View view, int args, KeyEvent keyEvent) {
				if ((keyEvent.getAction() == 0) && (args == 66)) {
					queryData(WHAT_DID_LOAD_DATA);
				}
				return false;
			}
		});
		tableFixHeaders = (TableFixHeaders) view.findViewById(R.id.table);
		wipItems = new ArrayList<WIPItem>();
		// MatrixTableAdapter<String>
		matrixTableAdapter = new MatrixTableAdapter<String>(getActivity(),
				new String[][] { { "SO NO\nCustomer", "ITEM\nGrade",
						"Cust SOD", "Confirmed SOD", "Order Type",
						"Rep. Sales", "APQP NO", "Customer PO#", "Prod Class",
						"Order Q'ty", "Products Spec", "Products No",
						"Device No", "Modify Ship Date", "Schedule Date",
						"Ship Via", "Customer P/N", "SO Issue",
						"PC Start Date", "ENG Engineer",
						"Contact Element P/N Code", "PIN/PCR Check",
						"Socket S/N" }, });
		matrixTableAdapter.setOnApqpnoClickListener(new OnClickListener() {
			public void onClick(View v) {
				TextView view = (TextView) v;
				String apqpNo = view.getText().toString().contains("\n") ?
						view.getText().toString().split("\n")[0] : view.getText().toString();
				// showDialog(content);
				callApqpDataActivity(apqpNo.trim());
			}
		});
		matrixTableAdapter.setOnPartnoClickListener(new OnClickListener() {
			public void onClick(View v) {
				TextView view = (TextView) v;
				String partNo = view.getText().toString();
				// showDialog(content);
				callBomListActivity(partNo);
			}
		});
		matrixTableAdapter.setOnCustomerClickListener(new OnClickListener() {
			public void onClick(View v) {
				TextView view = (TextView) v;
				// View parent = (View)view.getParent();
				// matrixTableAdapter.selectedIndex=Integer.parseInt(parent.getTag().toString());
				String custId;
				String[] tags = view.getTag().toString().split(":");
				if (tags.length > 1) {
					custId = tags[1];
					callCustomerDataActivity(custId);
				}
			}
		});
		matrixTableAdapter
				.setOnCellLongClickListener(new OnLongClickListener() {
					@Override
					public boolean onLongClick(View v) {
						WWTextView view = (WWTextView) v;

						try {	
							if(view.getRowIndex() > 0){
								if((selectedTab.equals("On-going")==true|| selectedTab.equals("vpc")==true) 
									&&view.getColIndex()==20)
								{
									String ch="";
									String part=""; 
								  if(view.getText().toString().contains(" ; "))
									{										
										   ch= " ; ";	
									}else if(view.getText().toString().contains(","))
									{
										ch=",";
									}
									
									else if(view.getText().toString().contains(" "))
									{										
									   ch= " ";	
									}
									if(ch!=""){
										String []parts=view.getText().toString().split(ch);
										showPartsDialog(v,parts);
									}
									else {
										if(view.getText().toString().equals(ch)==false)
										{
											part=view.getText().toString().replace("(替)","").trim();
											callStockActivity(part);
										}
									}
								   //showDialog(String.format("row=%d,col=%d",view.getRowIndex(),view.getColIndex()));
								}
							}
						
						} catch (Exception ex) {

						}

						return false;
					}
				});
		tableFixHeaders.setAdapter(matrixTableAdapter);

	}
	//L
	@Override
	public void launchRingDialog(View view) {

		final ProgressDialog ringProgressDialog = ProgressDialog.show(
				super.getActivity(), "Please wait ...", "Loading ...", true);
		ringProgressDialog.setCancelable(true);
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					// Here you should write your time consuming task...
					// Let the progress ring for 10 seconds...
					int i = 0;
					String msg="...";
					while (isLoading==1) {
						if(i>25) {
							isLoading=0;
							break;
						}
						//msg+=".";
						//ringProgressDialog.setMessage("Loading "+msg);
						Thread.sleep(1000);
						i++;
					}
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				ringProgressDialog.dismiss();
			}
		}).start();
	}

	@Override
	public void showDialog(String msg) {
		AlertDialog.Builder builder = new AlertDialog.Builder(
				this.getActivity());
		builder.setMessage(msg).setCancelable(false)
				.setPositiveButton("確定", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int id) {
					}
				}).show();

	}

	private View initView(LayoutInflater inflater, ViewGroup container) {

		View view = inflater.inflate(R.layout.actwiplist, container, false);
		context = view.getContext();
		InitUI(view);
		queryData(WHAT_DID_LOAD_DATA);
		return view;
	}

	// O
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return initView(inflater, container);
	}

	// Q
	public void queryData(int Message) {
		String url = super.getWebServiceUrl() + "queryWIP";
		try {
			isLoading=1;
			launchRingDialog(null);
			wipItems.clear();
			matrixTableAdapter.setInformation(convertWIPItmes(wipItems));
			matrixTableAdapter.notifyDataSetChanged();
			JSONObject jsonObject = new JSONObject();
			JSONObject data = new JSONObject();
			data.accumulate("SCHDateStart", this.SCHDateStart);
			data.accumulate("SCHDateEnd", this.SCHDateEnd);
			data.accumulate("Tab", this.selectedTab);
			data.accumulate("QueryValue", editSearch.getText().toString());
			data.accumulate("page", this.page);
			data.accumulate("CustName", this.CustName);
			data.accumulate("CustPO", this.CustPO);
			data.accumulate("DeviceNO", this.DeviceNO);
			data.accumulate("ContactElement", this.ContactElement);
			data.accumulate("ProductClass", this.ProductClass);
			data.accumulate("ProductNo", this.ProductNo);
			data.accumulate("ContactUser", this.ContactUser);
			data.accumulate("SalesRep", this.SalesRep);
			jsonObject.accumulate("WWID", "13145774WWGlobal999988WIPquery999");
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
						wipItems.clear();
						setWIPItems(jsonObject);
						// matrixTableAdapter = new
						// MatrixTableAdapter<String>(getActivity(),convertWIPItmes(wipItems));
						// tableFixHeaders.setAdapter(matrixTableAdapter);
						matrixTableAdapter.setInformation(convertWIPItmes(wipItems));
						matrixTableAdapter.notifyDataSetChanged();						
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

	// S
	private void setWIPItems(JSONObject jsonObject) {
		JSONArray data;
		try {
			data = jsonObject.getJSONArray("data");
			if (data.length() == 0)
				return;
			// String [][]src= new String[data.length()+1][0];
			for (int i = 0; i < data.length(); i++) {
				JSONObject d = data.getJSONObject(i);
				wipItems.add(
						new WIPItem(d.getString("APQPNO"), 
						d.getString("ConfirmedSOD"), 
						d.getString("ContactElementPN"), 
						d.getString("CustSODSalesReq"), 
						d.getString("Customer"),
						d.getString("CustomerNo"), 
						d.getString("CustomerPN"), 
						d.getString("CustomerPO"), 
				        d.getString("DeviceNo"), 
				        d.getString("ENGEngineer"),
						d.getString("GRADE"),
						d.getString("ITEM"), 
						d.getString("ModifyShipDate"), 
						d.getString("OrderQty"), 
						d.getString("OrderType"), 
						d.getString("PCStartDate"), 
						d.getString("PINPCRCheck"), 
						d.getString("ProdClass"), 
						d.getString("ProductsNo"), 
						d.getString("ProductsSpec"), 
						d.getString("REpSales"), 
						d.getString("SOIssue"),
						d.getString("SONO"), 
						d.getString("ScheduleDate"), 
						d.getString("ShipVia"), 
						d.getString("SocketSN"),
						d.getString("gFP_Status"), 
						d.getString("sLocation"),
						d.getString("sSO_NO"), 
						d.getString("sSO_TYPE"),
						d.getString("sTmp"), 
						d.getString("sTmpSEQ"),
						d.getString("Remark"), 
						d.getString("Shipping"),
						d.getString("Express"), 
						d.getString("NextShipDate"),
						d.getString("IconTag"))
						);

			}

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public void showPartsDialog(final View view,final String []parts) {

		AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity());
		dialog.setTitle("Parts").setIcon(
				android.R.drawable.ic_dialog_info);
		DialogInterface.OnClickListener okListener = new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface d, int which) {
				ListView lv = ((AlertDialog) d).getListView();
				Integer selected =0;
				if(lv.getTag()!=null&&lv.getTag().toString().equals("")==false)
				selected = Integer.parseInt(lv.getTag().toString());
				String part=parts[selected];
		        callStockActivity(part.replace("(替)", "").trim());
				d.dismiss();
				d = null;
			}
		};
		DialogInterface.OnClickListener cancelListener = new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface d, int which) {				
				d.dismiss();
				d = null;
			}
		};
	dialog.setSingleChoiceItems(parts, 0,
				new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface d, int which) {
						ListView lv = ((AlertDialog) d).getListView();
						lv.setTag(String.valueOf(which));
					}
				});
		dialog.setPositiveButton("Ok", okListener);
		dialog.setNegativeButton("Cancel", cancelListener);
		dialog.show();

	}
	// Other Class
	//

}
