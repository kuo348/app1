package com.winway.wwapp2;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.winway.wwapp2.BaseFragment.HttpPostAsyncTask;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.text.InputType;
import android.text.Layout.Alignment;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.widget.Toast;

public class FaeDataActivity extends BaseFragment {
	private Context context;
	private Bundle bundle;
	private View mView = null;
	private int ACTION_MESSAGE;
	private TextView txtInfo2;
	private LinearLayout lb1, lb2, lb3, lb4, lb5;
	private Button b1, b2, b3, b4, b5;
	private TextView l1, l2, l3, l4, l5;
	private ImageView menu;
	private RelativeLayout tabbar;
	private OnClickListener cmdbuttonOnClickListener;
	private TextView vwTitle;
	private Button btnReturnFaeList, btnReturnFaeResult, btnCancel, btnInsert,
			btnEdit, btnSave;
	private EditText fae034, fae036, fae040;
	private CheckBox fae004_001, fae004_002, fae004_003;
	private TextView fae001, fae002, fae015;
	private EditText fae006, fae008, fae009, fae010, fae012, fae013, fae014,
			fae017;
	private EditText fae022, fae023, fae024, fae028, fae035, fae038;
	private EditText fae031, fae032, fae019, fae021, fae026, mEdit;
	private RadioButton fae033a, fae033b, fae033c, fae029a, fae029b, fae029c,
			fae039a, fae039b, fae037a, fae037b, fae037c;
	private RadioGroup fae033, fae029, fae039, fae037;
	private String strfae019 = "";
	private TableLayout fae018, fae020, fae025, fae027;
	private List<String> mFaeUsersKey = new ArrayList<String>();
	private List<String> mFaeUsersValue = new ArrayList<String>();
	private List<String> mSalesKey = new ArrayList<String>();
	private List<String> mSalesValue = new ArrayList<String>();
	private int mYear, mMonth, mDay;
	private Button btnSign, btnDone, btnClear, btnSaveSign;
	private Button btn_edit_fae;
	private ImageButton btnfae018, btnfae020, btnfae025, btnfae027;
	private Hashtable<String, String> hashActionPlan;
	final String[] mTerritory = { "TW", "CN", "US", "Reps" };
	final String[] mActionPlan = { "Single case", "Need to Monitor",
			"No Further Action", "Quote to Customer", "Repairing",
			"Pass to RMA", "Other" };
	public boolean[] isProductSel = {};
	private List<String> mProduct = new ArrayList<String>();
	private List<String> mProductValue = new ArrayList<String>();
	public boolean[] isPackageSel = {};
	private List<String> mPackage = new ArrayList<String>();
	private List<String> mPackageValue = new ArrayList<String>();
	public boolean[] isIssueSel = {};
	private boolean loading = false;
	private List<String> mIssue = new ArrayList<String>();
	private List<String> mIssueValue = new ArrayList<String>();
	public boolean[] isIssueDetailSel = {};
	private List<String> mIssueDetail = new ArrayList<String>();
	private List<String> mIssueDetailValue = new ArrayList<String>();
	private LinearLayout root;
	private LinearLayout root2;
	private String fae100 = "";
	// private Hashtable<String, String> hashResult = new Hashtable<String,
	// String>();
	// private Hashtable<String, String> hashResultCause = new Hashtable<String,
	// String>();
	// private Hashtable<String, String> hashCharge = new Hashtable<String,
	// String>();
	// private Hashtable<String, String> hashCharge = new Hashtable<String,
	// String>();
	public static final int menuClear = 1;

	List<PointF> points = new ArrayList<PointF>();
	Panel mPanel, mPanel2;

	// Function C
	public void clearDraw() {
		points.clear();
		mPanel.invalidate();

	}

	public void clearDraw2() {
		mPanel2.setGraphics(null);
		mPanel2.invalidate();

	}

	// Function G
	// 讀取網路圖片，型態為Bitmap
	private static Bitmap getBitmapFromURL(String imageUrl) {
		try {
			URL url = new URL(imageUrl);
			HttpURLConnection connection = (HttpURLConnection) url
					.openConnection();
			connection.setDoInput(true);
			connection.connect();
			InputStream input = connection.getInputStream();
			Bitmap bitmap = BitmapFactory.decodeStream(input);
			return bitmap;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	private String getProductSel() {
		String rs = "";
		for (int i = 0; i < isProductSel.length; i++) {
			boolean sel = isProductSel[i];
			if (sel) {
				rs += "1";
			} else {
				rs += "0";
			}
		}
		return rs;
	}

	private String getPackageSel() {
		String rs = "";
		for (int i = 0; i < isPackageSel.length; i++) {
			boolean sel = isPackageSel[i];
			if (sel) {
				rs += "1";
			} else {
				rs += "0";
			}
		}
		return rs;
	}

	private String getIssueSel() {
		String rs = "";
		for (int i = 0; i < isIssueSel.length; i++) {
			boolean sel = isIssueSel[i];
			if (sel) {
				rs += "1";
			} else {
				rs += "0";
			}
		}
		return rs;
	}

	private String getIssueDetailSel() {
		String rs = "";
		for (int i = 0; i < isIssueDetailSel.length; i++) {
			boolean sel = isIssueDetailSel[i];
			if (sel) {
				rs += "1";
			} else {
				rs += "0";
			}
		}
		return rs;
	}

	private int getMode() {
		int mode = 0;
		if (fragmentManager.findFragmentByTag("fae_search_result") != null
				&& bundle != null) {
			mode = 2; // result mode

		} else if (fragmentManager.findFragmentByTag("faelist") != null
				&& bundle != null) {

			mode = 1; // list mode
		} else {
			mode = 0;// insert mode
		}
		return mode;
	}

	private String getProduct(int ix) {
		String product = mProduct.get(ix);
		return product;
	}

	private String getPackage(int ix) {
		return mPackage.get(ix);
	}

	private String getIssue(int ix) {
		return mIssue.get(ix);
	}

	private String getIssueDetail(int ix) {
		return mIssueDetail.get(ix);
	}

	// Function I
	private void insertData() {
		JSONObject jsonObject = new JSONObject();
		JSONObject data = new JSONObject();
		try {

			data.accumulate("action", "Insert");
			data.accumulate("faeitem", getInputData());
			jsonObject.accumulate("userid", getLoginUser());
			jsonObject.accumulate("WWID", "13145774WWGlobal999988fae999");
			jsonObject.accumulate("data", data);
			queryData((String) super.getWebServiceUrl() + "updateFAE",
					jsonObject, new IDataReceiveListener() {
						public void onReceiveData(Object obj) {
							try {
								JSONObject rs = new JSONObject((String) obj);
								String remark = rs.getString("remark");
								String success = rs.getString("success");
								if (success.equals("true")) {
									showDialog("Success", "Save sucess");
								} else {
									showDialog("Error", remark);
								}

							} catch (JSONException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}

					});
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private View initView(LayoutInflater inflater, ViewGroup container) {
		View view = inflater.inflate(R.layout.actfaedata, container, false);
		context = view.getContext();
		/*
		 * hashActionPlan.clear(); hashActionPlan.put("Single case","RB01");
		 * hashActionPlan.put("Need to Monitor","RB02");
		 * hashActionPlan.put("No Further Action","RB03");
		 * hashActionPlan.put("Quote to Customer","RB04");
		 * hashActionPlan.put("Repairing","RB05");
		 * hashActionPlan.put("Pass to RMA","RB06");
		 * hashActionPlan.put("Other","RB07");
		 */
		if (fragmentManager == null)
			fragmentManager = getActivity().getFragmentManager();
		// load basic data
		loadProduct(null);
		loadPackage(null);
		loadIssue(null);
		loadIssueDetail(null);
		// 取得參數
		bundle = this.getArguments();
		// get UI
		initUI(view);
		int mode = this.getMode();
		// load data
		if (mode > 0 && bundle != null) {
			vwTitle.setText(bundle.getString("fae001"));
			queryData();
		}
		if (mode == 0) {
			btnCancel.setVisibility(View.VISIBLE);

		}

		return view;
	}

	private void initUI(View view) {
		// title
		vwTitle = (TextView) view.findViewById(R.id.title_text);
		btnReturnFaeList = (Button) view.findViewById(R.id.btnReturnFaeList);
		// btn_edit_fae = (Button) view.findViewById(R.id.btn_edit_fae);
		btnReturnFaeList.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if (parent != null) {
					closeFragment();
				}
			}
		});
		btnReturnFaeResult = (Button) view
				.findViewById(R.id.btnReturnFaeResult);
		btnReturnFaeResult.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if (parent != null) {
					closeFragment();
				}
			}
		});
		btnCancel = (Button) view.findViewById(R.id.btnCancel);
		btnCancel.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if (parent != null) {
					closeFragment();
				}
			}
		});
		btnInsert = (Button) view.findViewById(R.id.btn_insert_fae);
		if (btnInsert != null) {
			btnInsert.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					insertData();
				}
			});
		}
		btnEdit = (Button) view.findViewById(R.id.btn_edit_fae);
		btnEdit.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Button btn = (Button) v;
				if (btn.getTag().equals("N")) {
					showDialog("Oops", "permission denied");
					return;
				}
				btn.setVisibility(View.GONE);
				btnSave.setVisibility(View.VISIBLE);
			}
		});
		btnSave = (Button) view.findViewById(R.id.btn_save_fae);
		btnSave.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				saveData();
			}
		});
		// 設定Button可見狀態
		setButtonStatus(getMode());
		// linearLayout
		lb1 = (LinearLayout) view.findViewById(R.id.lb1); // for basic info
		lb2 = (LinearLayout) view.findViewById(R.id.lb2); // for prod issue
		lb3 = (LinearLayout) view.findViewById(R.id.lb3); // for action result
															// info
		lb4 = (LinearLayout) view.findViewById(R.id.lb4); // for singture view
		lb5 = (LinearLayout) view.findViewById(R.id.lb5); // for attach file
															// view
		// default
		lb1.setVisibility(View.VISIBLE);
		lb2.setVisibility(View.GONE);
		lb3.setVisibility(View.GONE);
		lb4.setVisibility(View.GONE);
		lb5.setVisibility(View.GONE);
		/*
		 * l1=(TextView)view.findViewById(R.id.fae_basic_info);
		 * l2=(TextView)view.findViewById(R.id.fae_prod_issue);
		 * l3=(TextView)view.findViewById(R.id.fae_action_result_info);
		 * l4=(TextView)view.findViewById(R.id.fae_attach_file_info);
		 * l5=(TextView)view.findViewById(R.id.fae_signature_info);
		 */
		// Button
		b1 = (Button) view.findViewById(R.id.b1);
		b2 = (Button) view.findViewById(R.id.b2);
		b3 = (Button) view.findViewById(R.id.b3);
		b4 = (Button) view.findViewById(R.id.b4);
		b5 = (Button) view.findViewById(R.id.b5);
		// 標籤文字
		b1.setText("Basic Info");
		b2.setText("Prod &\n Issue");
		b3.setText("Action &\n Result");
		b4.setText("Attach File");
		b5.setText("Signature");
		root = (LinearLayout) view.findViewById(R.id.root);
		root2 = (LinearLayout) view.findViewById(R.id.root2);
		mPanel = new Panel(getActivity());
		mPanel2 = new Panel(getActivity());
		root.addView(mPanel, new LinearLayout.LayoutParams(
				LinearLayout.LayoutParams.MATCH_PARENT,
				LinearLayout.LayoutParams.MATCH_PARENT));
		root2.addView(mPanel2, new LinearLayout.LayoutParams(
				LinearLayout.LayoutParams.MATCH_PARENT,
				LinearLayout.LayoutParams.MATCH_PARENT));
		mPanel.setTitle("Press signature to start sign");
		mPanel.setEnabled(false);
		mPanel2.setTitle("");
		mPanel2.setEnabled(false);
		// mPanel2.setEnabled(false);
		btnSign = (Button) view.findViewById(R.id.btn_signature);
		btnClear = (Button) view.findViewById(R.id.btn_clear);
		btnDone = (Button) view.findViewById(R.id.btn_done);
		btnSaveSign = (Button) view.findViewById(R.id.btn_save_sign);
		btnClear.setEnabled(false);
		btnDone.setEnabled(false);
		btnSaveSign.setEnabled(false);
		btnSign.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				mPanel.setEnabled(true);
				mPanel.setTitle("");
				btnSign.setEnabled(false);
				btnSign.setTextColor(getActivity().getResources().getColor(
						R.color.lightgray));
				btnClear.setEnabled(true);
				btnClear.setTextColor(getActivity().getResources().getColor(
						R.color.blue));
				btnDone.setEnabled(true);
				btnDone.setTextColor(getActivity().getResources().getColor(
						R.color.blue));
				if (root2.getVisibility() == View.VISIBLE) {
					clearDraw2();
					root2.setVisibility(View.GONE);
				}
				mPanel.invalidate();
				btnSign.invalidate();
				btnDone.invalidate();
				btnClear.invalidate();

			}
		});
		btnClear.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				clearDraw();
			}
		});
		btnDone.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if (points.size() > 0) {
					root2.setVisibility(View.VISIBLE);
					// mPanel2.setVisibility(View.VISIBLE);
					// mPanel2.setEnabled(true);
					Bitmap bmp = mPanel.getGraphics();
					mPanel2.setGraphics(bmp);
					mPanel2.invalidate();
					btnSaveSign.setEnabled(true);
					btnSaveSign.setTextColor(getActivity().getResources()
							.getColor(R.color.blue));
				}

				mPanel.setTitle("Press signature to start sign");
				mPanel.setEnabled(false);
				clearDraw();
				btnSign.setEnabled(true);
				btnClear.setEnabled(false);
				btnDone.setEnabled(false);
				btnSign.setTextColor(getActivity().getResources().getColor(
						R.color.blue));
				btnClear.setTextColor(getActivity().getResources().getColor(
						R.color.lightgray));
				btnDone.setTextColor(getActivity().getResources().getColor(
						R.color.lightgray));
				mPanel.invalidate();
				btnSign.invalidate();
				btnDone.invalidate();
				btnClear.invalidate();

			}
		});
		btnSaveSign.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				String path = Environment.getExternalStoragePublicDirectory(
						Environment.DIRECTORY_PICTURES).toString();
				String file = "sign.png";
				saveImage(mPanel2.getGraphics(), path, file);
				ImageUploaderTask uploader = new ImageUploaderTask();
				HashMap<String, String> datas = new HashMap<String, String>();
				datas.put("userid", getLoginUser());
				datas.put("fae100", fae100);
				datas.put("FAENO", fae001.getText().toString());
				datas.put("WWID", "13145774WWGlobalfiles999");
				HashMap<String, String> files = new HashMap<String, String>();
				files.put("files", path + "/" + file);
				uploader.execute(
						getActivity().getResources().getString(
								R.string.uploadFileUrl), datas, files);
				clearDraw();
				btnSaveSign.setEnabled(false);
				btnSaveSign.setTextColor(getActivity().getResources().getColor(
						R.color.lightgray));
				mPanel.setTitle("Press signature to start sign");
				mPanel.setEnabled(false);
				btnSign.setEnabled(true);
				btnClear.setEnabled(false);
				btnDone.setEnabled(false);
				btnSign.setTextColor(getActivity().getResources().getColor(
						R.color.blue));
				btnClear.setTextColor(getActivity().getResources().getColor(
						R.color.lightgray));
				btnDone.setTextColor(getActivity().getResources().getColor(
						R.color.lightgray));
				mPanel2.invalidate();
				mPanel.invalidate();
				btnSign.invalidate();
				btnDone.invalidate();
				btnClear.invalidate();
				// mPanel2.setVisibility(View.GONE);
				root2.setVisibility(View.GONE);
				root2.invalidate();
			}
		});
		cmdbuttonOnClickListener = new OnClickListener() {
			@Override
			public void onClick(View v) {
				switch (v.getId()) {
				case R.id.b1:
					showLayout(lb1);
					break;
				case R.id.b2:
					showLayout(lb2);
					break;
				case R.id.b3:
					showLayout(lb3);
					break;
				case R.id.b4:
					showLayout(lb4);
					break;
				case R.id.b5:
					showLayout(lb5);
					break;
				}
			}
		};
		// add listener for button
		if (b1 != null) {
			b1.setOnClickListener(cmdbuttonOnClickListener);
		}
		if (b2 != null) {
			b2.setOnClickListener(cmdbuttonOnClickListener);
		}
		if (b3 != null) {
			b3.setOnClickListener(cmdbuttonOnClickListener);
		}
		if (b4 != null) {
			b4.setOnClickListener(cmdbuttonOnClickListener);
		}
		if (b5 != null) {
			b5.setOnClickListener(cmdbuttonOnClickListener);
		}
		txtInfo2 = (TextView) view.findViewById(R.id.fae_info2);
		// 設定顯示頁籤功能
		tabbar = (RelativeLayout) view.findViewById(R.id.faetab);
		menu = (ImageView) view.findViewById(R.id.img_menu);
		menu.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if (tabbar.getVisibility() == View.VISIBLE) {
					tabbar.setVisibility(View.GONE);
				} else {
					tabbar.setVisibility(View.VISIBLE);
				}

			}
		});
		// Basic info
		fae001 = (TextView) view.findViewById(R.id.fae001);
		fae002 = (TextView) view.findViewById(R.id.fae002);
		fae001.setText("");
		fae002.setText("");
		// customer
		fae006 = (EditText) view.findViewById(R.id.fae006);// 可開窗選擇
		this.fae006.setOnTouchListener(new OnTouchListener() {
			@SuppressLint("ClickableViewAccessibility")
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				fae006.setInputType(InputType.TYPE_NULL); // 關閉軟鍵盤
				return false;
			}

		});
		this.fae006.setOnFocusChangeListener(new OnFocusChangeListener() {
			@Override
			public void onFocusChange(View v, boolean hasFocus) {
				if (hasFocus) {
					InputMethodManager imm = (InputMethodManager) getActivity()
							.getSystemService(Context.INPUT_METHOD_SERVICE);
					imm.hideSoftInputFromWindow(fae006.getWindowToken(), 0);
					showCustDialog(v);
				}
			}
		});
		// end customer
		fae008 = (EditText) view.findViewById(R.id.fae008);// 可開窗選擇
		this.fae008.setOnTouchListener(new OnTouchListener() {
			@SuppressLint("ClickableViewAccessibility")
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				fae008.setInputType(InputType.TYPE_NULL); // 關閉軟鍵盤
				return false;
			}

		});
		this.fae008.setOnFocusChangeListener(new OnFocusChangeListener() {
			@Override
			public void onFocusChange(View v, boolean hasFocus) {

				if (hasFocus) {
					InputMethodManager imm = (InputMethodManager) getActivity()
							.getSystemService(Context.INPUT_METHOD_SERVICE);
					imm.hideSoftInputFromWindow(fae008.getWindowToken(), 0);
					showCustDialog(v);
				}
			}
		});
		fae009 = (EditText) view.findViewById(R.id.fae009);
		fae010 = (EditText) view.findViewById(R.id.fae010);
		// FAE
		fae012 = (EditText) view.findViewById(R.id.fae012);// 可開窗選擇
		this.fae012.setOnTouchListener(new OnTouchListener() {
			@SuppressLint("ClickableViewAccessibility")
			@Override
			public boolean onTouch(View v, MotionEvent event) {

				fae012.setInputType(InputType.TYPE_NULL); // 關閉軟鍵盤
				return false;
			}

		});
		this.fae012.setOnFocusChangeListener(new OnFocusChangeListener() {
			@Override
			public void onFocusChange(View v, boolean hasFocus) {

				if (hasFocus) {
					InputMethodManager imm = (InputMethodManager) getActivity()
							.getSystemService(Context.INPUT_METHOD_SERVICE);
					imm.hideSoftInputFromWindow(fae012.getWindowToken(), 0);
					showFaeUsersDialog(v);
				}
			}
		});
		// Terrtory
		fae013 = (EditText) view.findViewById(R.id.fae013);// 可開窗選擇
		this.fae013.setOnTouchListener(new OnTouchListener() {
			@SuppressLint("ClickableViewAccessibility")
			@Override
			public boolean onTouch(View v, MotionEvent event) {

				fae013.setInputType(InputType.TYPE_NULL); // 關閉軟鍵盤
				return false;
			}

		});
		this.fae013.setOnFocusChangeListener(new OnFocusChangeListener() {
			@Override
			public void onFocusChange(View v, boolean hasFocus) {

				if (hasFocus) {
					InputMethodManager imm = (InputMethodManager) getActivity()
							.getSystemService(Context.INPUT_METHOD_SERVICE);
					imm.hideSoftInputFromWindow(fae013.getWindowToken(), 0);
					showTerritoryDialog(v);
				}
			}
		});
		// On site service
		fae014 = (EditText) view.findViewById(R.id.fae014);// 可開窗選擇
		this.fae014.setOnTouchListener(new OnTouchListener() {
			@SuppressLint("ClickableViewAccessibility")
			@Override
			public boolean onTouch(View v, MotionEvent event) {

				fae014.setInputType(InputType.TYPE_NULL); // 關閉軟鍵盤
				return false;
			}

		});
		this.fae014.setOnFocusChangeListener(new OnFocusChangeListener() {
			@Override
			public void onFocusChange(View v, boolean hasFocus) {

				if (hasFocus) {
					InputMethodManager imm = (InputMethodManager) getActivity()
							.getSystemService(Context.INPUT_METHOD_SERVICE);
					imm.hideSoftInputFromWindow(fae014.getWindowToken(), 0);
					showDateDialog(v, "%d-%02d-%02d");
				}
			}
		});
		fae015 = (TextView) view.findViewById(R.id.fae015);
		// Winway Sales
		fae017 = (EditText) view.findViewById(R.id.fae017);// 可開窗選擇
		this.fae017.setOnTouchListener(new OnTouchListener() {
			@SuppressLint("ClickableViewAccessibility")
			@Override
			public boolean onTouch(View v, MotionEvent event) {

				fae017.setInputType(InputType.TYPE_NULL); // 關閉軟鍵盤
				return false;
			}

		});
		this.fae017.setOnFocusChangeListener(new OnFocusChangeListener() {
			@Override
			public void onFocusChange(View v, boolean hasFocus) {

				if (hasFocus) {
					InputMethodManager imm = (InputMethodManager) getActivity()
							.getSystemService(Context.INPUT_METHOD_SERVICE);
					imm.hideSoftInputFromWindow(fae017.getWindowToken(), 0);
					showSalesDialog(v);
				}
			}
		});
		fae004_001 = (CheckBox) view.findViewById(R.id.fae004_001);
		fae004_002 = (CheckBox) view.findViewById(R.id.fae004_002);
		fae004_003 = (CheckBox) view.findViewById(R.id.fae004_003);
		// Prod & Issue
		fae018 = (TableLayout) view.findViewById(R.id.fae018);
		fae018.setTag("00000000000000000");
		btnfae018 = (ImageButton) view.findViewById(R.id.button1);
		btnfae018.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				showProductDialog(v);
			}
		});
		fae020 = (TableLayout) view.findViewById(R.id.fae020);
		fae020.setTag("00000000000");
		btnfae020 = (ImageButton) view.findViewById(R.id.button2);
		btnfae020.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				showPackageDialog(v);
			}
		});
		fae025 = (TableLayout) view.findViewById(R.id.fae025);
		fae025.setTag("0000000");
		btnfae025 = (ImageButton) view.findViewById(R.id.button3);
		btnfae025.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				showIssueDialog(v);
			}
		});
		fae027 = (TableLayout) view.findViewById(R.id.fae027);
		fae027.setTag("000000000000000000000000000");
		btnfae027 = (ImageButton) view.findViewById(R.id.button4);
		btnfae027.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				showIssueDetailDialog(v);
			}
		});
		fae022 = (EditText) view.findViewById(R.id.fae022);
		fae023 = (EditText) view.findViewById(R.id.fae023);
		fae024 = (EditText) view.findViewById(R.id.fae024);
		fae028 = (EditText) view.findViewById(R.id.fae028);
		fae029 = (RadioGroup) view.findViewById(R.id.fae029);
		fae029a = (RadioButton) view.findViewById(R.id.fae029a);
		fae029b = (RadioButton) view.findViewById(R.id.fae029b);
		fae029c = (RadioButton) view.findViewById(R.id.fae029c);
		fae031 = (EditText) view.findViewById(R.id.fae031);
		fae032 = (EditText) view.findViewById(R.id.fae032);
		fae033 = (RadioGroup) view.findViewById(R.id.fae033);
		fae033.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {

				if (checkedId == fae033c.getId()) {
					fae034.setEnabled(true);
					// fae034.setBackgroundResource(R.drawable.border);
					fae034.setBackground(getActivity().getResources()
							.getDrawable(R.drawable.border));
					// fae034.setBackgroundResource(getActivity().getResources().getColor(R.color.white));

				} else {
					fae034.setEnabled(false);
					fae034.setText("");
					fae034.setBackgroundColor(getActivity().getResources()
							.getColor(R.color.lightgray));
					// fae034.setBackgroundResource(0);
					// fae034.setBackgroundColor(R.color.lightgray);
					fae034.clearFocus();
				}
			}
		});
		fae033a = (RadioButton) view.findViewById(R.id.fae033a);
		fae033b = (RadioButton) view.findViewById(R.id.fae033b);
		fae033c = (RadioButton) view.findViewById(R.id.fae033c);
		fae034 = (EditText) view.findViewById(R.id.fae034);
		fae035 = (EditText) view.findViewById(R.id.fae035);
		/*
		 * fae035.setOnClickListener(new OnClickListener(){
		 * 
		 * @Override public void onClick(View v){ showActionPlanDialog(v); } });
		 */
		fae035.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {

				fae035.setInputType(InputType.TYPE_NULL); // 關閉軟鍵盤
				return false;
			}
		});
		fae035.setOnFocusChangeListener(new OnFocusChangeListener() {
			public void onFocusChange(View v, boolean hasFocus) {

				if (hasFocus) {
					InputMethodManager imm = (InputMethodManager) getActivity()
							.getSystemService(Context.INPUT_METHOD_SERVICE);
					imm.hideSoftInputFromWindow(fae035.getWindowToken(), 0);

					showActionPlanDialog(v);
					// fae035.clearFocus();
				}
			}
		});
		fae036 = (EditText) view.findViewById(R.id.fae036);
		fae037 = (RadioGroup) view.findViewById(R.id.fae037);
		fae037.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {

				if (checkedId == fae037c.getId()) {
					fae038.setEnabled(true);
					// fae038.setBackgroundResource(getActivity().getResources().getColor(R.color.white));
					// fae038.setBackgroundResource(R.drawable.border);
					fae038.setBackground(getActivity().getResources()
							.getDrawable(R.drawable.border));
				} else {
					fae038.setEnabled(false);
					fae038.setText("");
					// fae038.setBackgroundResource(getActivity().getResources().getColor(R.color.lightgray));
					// fae038.setBackgroundResource(0);
					// fae038.setBackgroundColor(R.color.lightgray);
					fae038.setBackgroundColor(getActivity().getResources()
							.getColor(R.color.lightgray));
					fae038.clearFocus();
				}
			}
		});
		fae037a = (RadioButton) view.findViewById(R.id.fae037a);
		fae037b = (RadioButton) view.findViewById(R.id.fae037b);
		fae037c = (RadioButton) view.findViewById(R.id.fae037c);
		fae038 = (EditText) view.findViewById(R.id.fae038);

		// Action & Result
		fae039a = (RadioButton) view.findViewById(R.id.fae039a);
		fae039b = (RadioButton) view.findViewById(R.id.fae039b);

		fae040 = (EditText) view.findViewById(R.id.fae040);
	}

	// Function L

	String url;

	@Override
	public void loadData(Object result) {

		try {
			JSONObject jsonObject = new JSONObject((String) result);
			if (jsonObject.getString("success").equals("true")) {
				JSONObject data = jsonObject.getJSONObject("data");
				btnEdit.setTag(data.getString("editable"));

				fae001.setText(data.getString("fae001"));
				fae002.setText(data.getString("fae002"));
				fae006.setText(data.getString("fae006"));
				fae006.setHint(data.getString("fae005"));
				// data.getString("fae003");
				if (data.getString("fae004").substring(0, 1).equals("1")) {
					fae004_001.setChecked(true);
				}
				if (data.getString("fae004").substring(1, 2).equals("1")) {
					fae004_002.setChecked(true);
				}
				if (data.getString("fae004").substring(2, 3).equals("1")) {
					fae004_003.setChecked(true);
				}
				fae008.setText(data.getString("fae008"));
				fae008.setHint(data.getString("fae007"));
				fae009.setText(data.getString("fae009"));
				fae010.setText(data.getString("fae010"));
				fae012.setText(data.getString("fae012"));
				fae012.setHint(data.getString("fae011"));
				if (!data.getString("fae013").isEmpty()) {
					int ix = Integer.parseInt(data.getString("fae013")
							.substring(2, 4));
					fae013.setText(mTerritory[ix - 1]);
					fae013.setHint(data.getString("fae013"));
				}

				fae014.setText(data.getString("fae014"));
				fae015.setText(data.getString("fae015"));
				fae017.setText(data.getString("fae017"));
				fae018.setTag(data.getString("fae018"));
				strfae019 = data.getString("fae019");
				setProductSel(data.getString("fae018"));
				showProducts(data.getString("fae018"), data.getString("fae019"));
				setPackageSel(data.getString("fae020"));
				showPackage(data.getString("fae020"), data.getString("fae021"));

				fae017.setHint(data.getString("fae016"));
				fae022.setText(data.getString("fae022"));
				fae023.setText(data.getString("fae023"));
				fae024.setText(data.getString("fae024"));
				setIssueSel(data.getString("fae025"));
				showIssue(data.getString("fae025"), data.getString("fae026"));
				fae028.setText(data.getString("fae028"));
				setIssueDetailSel(data.getString("fae027"));
				showIssueDetail(data.getString("fae027"));
				fae031.setText(data.getString("fae031"));
				fae032.setText(data.getString("fae032"));
				if (data.getString("fae033").equals("RB01")) {
					fae033a.setChecked(true);
				} else if (data.getString("fae033").equals("RB02")) {
					fae033b.setChecked(true);
				} else if (data.getString("fae033").equals("RB03")) {
					fae033c.setChecked(true);
					fae034.setEnabled(true);
					// fae034.setBackgroundColor(getActivity().getResources().getR);
					fae034.setBackground(getActivity().getResources()
							.getDrawable(R.drawable.border));
				}
				fae034.setText(data.getString("fae034"));
				if (data.getString("fae035") != "") {
					fae035.setText(mActionPlan[Integer.parseInt(data.getString(
							"fae035").substring(2, 4)) - 1]);
					fae035.setHint(data.getString("fae035"));
				}
				fae036.setText(data.getString("fae036"));
				if (data.getString("fae036") != ""
						&& fae036.getText().length() > 0) {
					fae036.setEnabled(true);
					fae036.setBackground(getActivity().getResources()
							.getDrawable(R.drawable.border));
					// fae036.setBackgroundColor(R.color.white);
					// fae036.setBackgroundColor(getActivity().getResources().getColor(R.color.white));
				} else {
					fae036.setBackgroundResource(0);
					fae036.setBackgroundColor(getActivity().getResources()
							.getColor(R.color.lightgray));

				}
				if (data.getString("fae037").equals("RB01")) {
					fae037a.setChecked(true);
				}
				if (data.getString("fae037").equals("RB02")) {
					fae037b.setChecked(true);
				}
				if (data.getString("fae037").equals("RB03")) {
					fae037c.setChecked(true);
					fae038.setEnabled(true);
					// fae034.setBackgroundColor(getActivity().getResources().getR);
					fae038.setBackground(getActivity().getResources()
							.getDrawable(R.drawable.border));
				}
				fae038.setText(data.getString("fae038"));

				fae040.setText(data.getString("fae040"));
				if (data.getString("fae029").equals("RB01")) {
					fae029a.setChecked(true);
				}
				if (data.getString("fae029").equals("RB02")) {
					fae029b.setChecked(true);
				}
				if (data.getString("fae029").equals("RB03")) {
					fae029c.setChecked(true);
				}

				if (data.getString("fae039").equals("RB01")) {
					fae039a.setChecked(true);
				}
				if (data.getString("fae039").equals("RB01")) {
					fae039b.setChecked(true);
				}
				fae100 = data.getString("fae100");
				loadSignatureImage(fae100, fae001.getText().toString());
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void loadProduct(final View v) {

		JSONObject jsonObject = new JSONObject();
		JSONObject data = new JSONObject();
		try {

			data.accumulate("type", "productChkList");
			jsonObject.accumulate("userid", getLoginUser());
			jsonObject.accumulate("WWID", "13145774WWGlobal999988faeList999");
			jsonObject.accumulate("data", data);
			/*
			 * queryData((String)super.getWebServiceUrl()+ "faeList",
			 * jsonObject, productListener);
			 */
			HttpPostAsyncTask task1 = new HttpPostAsyncTask();
			task1.setCallback(new BaseFragment.ICallback() {
				@Override
				public void doWork(Object obj) {

					try {

						JSONObject jsonObject = new JSONObject((String) obj)
								.getJSONObject("data");
						JSONArray text = jsonObject.getJSONArray("text");
						JSONArray value = jsonObject.getJSONArray("value");
						isProductSel = new boolean[text.length()];
						for (int i = 0; i < text.length(); i++) {
							mProduct.add(text.getString(i));
							mProductValue.add(value.getString(i));
							isProductSel[i] = false;
						}

						// showApplicationDialog(mView);
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}

			});
			task1.execute((String) super.getWebServiceUrl() + "faeList",
					jsonObject.toString());

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void loadIssue(final View v) {

		JSONObject jsonObject = new JSONObject();
		JSONObject data = new JSONObject();
		try {

			data.accumulate("type", "issueChkList");
			jsonObject.accumulate("userid", getLoginUser());
			jsonObject.accumulate("WWID", "13145774WWGlobal999988faeList999");
			jsonObject.accumulate("data", data);
			/*
			 * queryData((String)super.getWebServiceUrl()+ "faeList",
			 * jsonObject, productListener);
			 */
			HttpPostAsyncTask task1 = new HttpPostAsyncTask();
			task1.setCallback(new BaseFragment.ICallback() {
				@Override
				public void doWork(Object obj) {

					try {

						JSONObject jsonObject = new JSONObject((String) obj)
								.getJSONObject("data");
						JSONArray text = jsonObject.getJSONArray("text");
						JSONArray value = jsonObject.getJSONArray("value");
						isIssueSel = new boolean[text.length()];
						for (int i = 0; i < text.length(); i++) {
							mIssue.add(text.getString(i));
							mIssueValue.add(value.getString(i));
							isIssueSel[i] = false;
						}

						// showApplicationDialog(mView);
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}

			});
			task1.execute((String) super.getWebServiceUrl() + "faeList",
					jsonObject.toString());

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void loadPackage(final View v) {

		JSONObject jsonObject = new JSONObject();
		JSONObject data = new JSONObject();
		try {

			data.accumulate("type", "packageChkList");
			jsonObject.accumulate("userid", getLoginUser());
			jsonObject.accumulate("WWID", "13145774WWGlobal999988faeList999");
			jsonObject.accumulate("data", data);
			/*
			 * queryData((String)super.getWebServiceUrl()+ "faeList",
			 * jsonObject, productListener);
			 */
			HttpPostAsyncTask task1 = new HttpPostAsyncTask();
			task1.setCallback(new BaseFragment.ICallback() {
				@Override
				public void doWork(Object obj) {

					try {

						JSONObject jsonObject = new JSONObject((String) obj)
								.getJSONObject("data");
						JSONArray text = jsonObject.getJSONArray("text");
						JSONArray value = jsonObject.getJSONArray("value");
						isPackageSel = new boolean[text.length()];
						for (int i = 0; i < text.length(); i++) {
							mPackage.add(text.getString(i));
							mPackageValue.add(value.getString(i));
							isPackageSel[i] = false;
						}

						// showApplicationDialog(mView);
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}

			});
			task1.execute((String) super.getWebServiceUrl() + "faeList",
					jsonObject.toString());

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void loadIssueDetail(final View v) {

		JSONObject jsonObject = new JSONObject();
		JSONObject data = new JSONObject();
		try {

			data.accumulate("type", "issueDetailChkList");
			jsonObject.accumulate("userid", getLoginUser());
			jsonObject.accumulate("WWID", "13145774WWGlobal999988faeList999");
			jsonObject.accumulate("data", data);
			/*
			 * queryData((String)super.getWebServiceUrl()+ "faeList",
			 * jsonObject, productListener);
			 */
			HttpPostAsyncTask task1 = new HttpPostAsyncTask();
			task1.setCallback(new BaseFragment.ICallback() {
				@Override
				public void doWork(Object obj) {

					try {

						JSONObject jsonObject = new JSONObject((String) obj)
								.getJSONObject("data");
						JSONArray text = jsonObject.getJSONArray("text");
						JSONArray value = jsonObject.getJSONArray("value");
						isIssueDetailSel = new boolean[text.length()];
						for (int i = 0; i < text.length(); i++) {
							mIssueDetail.add(text.getString(i));
							mIssueDetailValue.add(value.getString(i));
							isIssueDetailSel[i] = false;
						}

						// showApplicationDialog(mView);
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}

			});
			task1.execute((String) super.getWebServiceUrl() + "faeList",
					jsonObject.toString());

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void loadSignatureImage(String folder, String faeno) {

		// 建立一個AsyncTask執行緒進行圖片讀取動作，並帶入圖片連結網址路徑
		new AsyncTask<String, Void, Bitmap>() {
			@Override
			protected Bitmap doInBackground(String... params) {
				String url = params[0];
				return getBitmapFromURL(url);
			}

			@Override
			protected void onPostExecute(Bitmap result) {
				// plugimage.setImageBitmap(result);
				if (root2.getVisibility() != View.VISIBLE) {
					root2.setVisibility(View.VISIBLE);
				}
				mPanel2.setGraphics(result);
				mPanel2.invalidate();
				super.onPostExecute(result);
			}
		}.execute(String.format("%s?folder=%s&faeno=%s", getActivity()
				.getResources().getString(R.string.downloadSignImageUrl),
				folder, faeno));

	}

	private void loadFaeUsers(final View v) {

		JSONObject jsonObject = new JSONObject();
		JSONObject data = new JSONObject();
		try {

			data.accumulate("type", "respFAEList");
			jsonObject.accumulate("userid", super.getLoginUser());
			jsonObject.accumulate("WWID", "13145774WWGlobal999988faeList999");
			jsonObject.accumulate("data", data);
			queryData((String) super.getWebServiceUrl() + "faeList",
					jsonObject, new IDataReceiveListener() {
						public void onReceiveData(Object obj) {
							try {
								JSONObject jsonObject = new JSONObject(
										(String) obj).getJSONObject("data");
								JSONArray text = jsonObject
										.getJSONArray("text");
								JSONArray value = jsonObject
										.getJSONArray("value");
								for (int i = 0; i < text.length(); i++) {
									mFaeUsersKey.add(text.getString(i));
									mFaeUsersValue.add(value.getString(i));
								}
								showFaeUsersDialog(v);
								// showApplicationDialog(mView);
								// loadSales();
							} catch (JSONException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}

					});
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void loadSales(final View v) {

		JSONObject jsonObject = new JSONObject();
		JSONObject data = new JSONObject();
		try {

			data.accumulate("type", "wwSalesList");
			jsonObject.accumulate("userid", getLoginUser());
			jsonObject.accumulate("WWID", "13145774WWGlobal999988faeList999");
			jsonObject.accumulate("data", data);
			queryData((String) super.getWebServiceUrl() + "faeList",
					jsonObject, new IDataReceiveListener() {
						public void onReceiveData(Object obj) {
							try {
								JSONObject jsonObject = new JSONObject(
										(String) obj).getJSONObject("data");
								JSONArray text = jsonObject
										.getJSONArray("text");
								JSONArray value = jsonObject
										.getJSONArray("value");
								for (int i = 0; i < text.length(); i++) {
									mSalesKey.add(text.getString(i));
									mSalesValue.add(value.getString(i));
								}
								showSalesDialog(v);
							} catch (JSONException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}

					});
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// Function O
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		// loadFaeUsers();
		// loadSales();

		return initView(inflater, container);
	}

	// Function S
	private void setProductSel(String code) {

		if (isProductSel.length == 0)
			return;
		for (int i = 0; i < code.length(); i++) {
			if (code.substring(i, i + 1).equals("1")) {
				isProductSel[i] = true;
			} else {
				isProductSel[i] = false;
			}
		}

	}

	private void setPackageSel(String code) {

		for (int i = 0; i < isPackageSel.length; i++) {
			if (code.substring(i, i + 1).equals("1")) {
				isPackageSel[i] = true;
			} else {
				isPackageSel[i] = false;
			}
		}

	}

	private void setIssueSel(String code) {

		for (int i = 0; i < isIssueSel.length; i++) {
			if (code.substring(i, i + 1).equals("1")) {
				isIssueSel[i] = true;
			} else {
				isIssueSel[i] = false;
			}
		}

	}

	private void setIssueDetailSel(String code) {

		for (int i = 0; i < isIssueDetailSel.length; i++) {
			if (code.substring(i, i + 1).equals("1")) {
				isIssueDetailSel[i] = true;
			} else {
				isIssueDetailSel[i] = false;
			}
		}

	}

	public void showActionPlanDialog(final View view) {

		AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity());
		dialog.setTitle("Action Plan").setIcon(
				android.R.drawable.ic_dialog_info);
		DialogInterface.OnClickListener okListener = new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface d, int which) {

				EditText edit = (EditText) view;
				edit.setText(mActionPlan[which]);
				edit.setHint(String.format("RB%02d", which + 1));
				if (which == mActionPlan.length - 1) {
					fae036.setEnabled(true);
					fae036.setBackgroundResource(R.drawable.border);

					// fae036.setBackgroundResource(getActivity().getResources().getColor(R.color.white));
					// fae036.setBackgroundResource(getActivity().getResources().getColor(R.color.white));
				} else {
					fae036.setText("");
					fae036.setEnabled(false);
					fae036.setBackgroundResource(0);
					fae036.setBackgroundColor(getActivity().getResources()
							.getColor(R.color.lightgray));
					// fae036.setBackgroundResource(getActivity().getResources().getColor(R.color.lightgray));
					// fae036.setBackgroundResource(getActivity().getResources().getColor(R.color.lightgray));
				}
				edit.clearFocus();
				d.dismiss();
			}
		};
		DialogInterface.OnClickListener cancelListener = new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface d, int which) {

				d.dismiss();
			}
		};
		dialog.setSingleChoiceItems(mActionPlan, 0, okListener);
		// dialog.setPositiveButton("Cancel", okListener);
		dialog.setNegativeButton("Cancel", cancelListener);
		dialog.show();

	}

	public void showProductDialog(final View view) {

		AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity());
		dialog.setTitle("Products").setIcon(android.R.drawable.ic_dialog_info);
		DialogInterface.OnMultiChoiceClickListener multiListener = new DialogInterface.OnMultiChoiceClickListener() {
			@Override
			public void onClick(DialogInterface d, int which, boolean isChecked) {

				mProductValue.set(which, (isChecked ? "1" : "0"));
			}
		};
		DialogInterface.OnClickListener okListener = new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface d, int which) {

				d.dismiss();
				view.clearFocus();
				showProducts(getProductSel(), "");
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
		String[] mProducts = {};
		mProducts = (String[]) (mProduct.toArray(mProducts));
		dialog.setMultiChoiceItems(mProducts, isProductSel, multiListener);
		dialog.setNegativeButton("Cancel", cancelListener);
		dialog.setPositiveButton("Ok", okListener);
		dialog.show();

	}

	public void showPackageDialog(final View view) {

		AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity());
		dialog.setTitle("Package").setIcon(android.R.drawable.ic_dialog_info);
		DialogInterface.OnMultiChoiceClickListener multiListener = new DialogInterface.OnMultiChoiceClickListener() {
			@Override
			public void onClick(DialogInterface d, int which, boolean isChecked) {

				isPackageSel[which] = isChecked;
			}
		};
		DialogInterface.OnClickListener okListener = new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface d, int which) {

				d.dismiss();
				view.clearFocus();
				showPackage(getPackageSel(), "");
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
		String[] mPackages = {};
		mPackages = (String[]) (mPackage.toArray(mPackages));
		dialog.setMultiChoiceItems(mPackages, isPackageSel, multiListener);
		dialog.setNegativeButton("Cancel", cancelListener);
		dialog.setPositiveButton("Ok", okListener);
		dialog.show();

	}

	public void showIssueDialog(final View view) {

		AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity());
		dialog.setTitle("Issue").setIcon(android.R.drawable.ic_dialog_info);
		DialogInterface.OnMultiChoiceClickListener multiListener = new DialogInterface.OnMultiChoiceClickListener() {
			@Override
			public void onClick(DialogInterface d, int which, boolean isChecked) {

				isIssueSel[which] = isChecked;
			}
		};
		DialogInterface.OnClickListener okListener = new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface d, int which) {

				d.dismiss();
				view.clearFocus();
				showIssue(getIssueSel(), "");
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
		String[] mIssues = {};
		mIssues = (String[]) (mIssue.toArray(mIssues));
		dialog.setMultiChoiceItems(mIssues, isIssueSel, multiListener);
		dialog.setNegativeButton("Cancel", cancelListener);
		dialog.setPositiveButton("Ok", okListener);
		dialog.show();

	}

	public void showIssueDetailDialog(final View view) {

		AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity());
		dialog.setTitle("Issue Detail").setIcon(
				android.R.drawable.ic_dialog_info);
		DialogInterface.OnMultiChoiceClickListener multiListener = new DialogInterface.OnMultiChoiceClickListener() {
			@Override
			public void onClick(DialogInterface d, int which, boolean isChecked) {

				isIssueDetailSel[which] = isChecked;
			}
		};
		DialogInterface.OnClickListener okListener = new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface d, int which) {

				d.dismiss();
				view.clearFocus();
				showIssueDetail(getIssueDetailSel());
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
		String[] mIssueDetails = {};
		mIssueDetails = (String[]) (mIssueDetail.toArray(mIssueDetails));
		dialog.setMultiChoiceItems(mIssueDetails, isIssueDetailSel,
				multiListener);
		dialog.setNegativeButton("Cancel", cancelListener);
		dialog.setPositiveButton("Ok", okListener);
		dialog.show();

	}

	public void showFaeUsersDialog(final View view) {

		if (mFaeUsersKey.size() == 0) {
			loadFaeUsers(view);
			return;
		}
		AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity());
		dialog.setTitle("Fae Users").setIcon(android.R.drawable.ic_dialog_info);
		DialogInterface.OnClickListener okListener = new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface d, int which) {

				((EditText) view).setText(mFaeUsersKey.get(which));
				((EditText) view).setHint(mFaeUsersValue.get(which));
				d.dismiss();
				view.clearFocus();
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
		String[] mString = new String[mFaeUsersKey.size()];
		for (int i = 0; i < mFaeUsersKey.size(); i++) {
			mString[i] = mFaeUsersKey.get(i);

		}
		dialog.setSingleChoiceItems(mString, 0, okListener);
		dialog.setNegativeButton("Cancel", cancelListener);
		dialog.show();

	}

	public void showTerritoryDialog(final View view) {

		AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity());
		dialog.setTitle("Territory").setIcon(android.R.drawable.ic_dialog_info);
		DialogInterface.OnClickListener okListener = new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface d, int which) {

				((EditText) view).setText(mTerritory[which]);
				((EditText) view).setHint(String.format("CT%02d", which + 1));

				d.dismiss();
				view.clearFocus();
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

		dialog.setSingleChoiceItems(mTerritory, -1, okListener);
		dialog.setNegativeButton("Cancel", cancelListener);
		dialog.show();

	}

	public void showSalesDialog(final View view) {
		if (mSalesKey.size() == 0) {
			loadSales(view);
			return;
		}
		AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity());
		dialog.setTitle("Sales").setIcon(android.R.drawable.ic_dialog_info);
		DialogInterface.OnClickListener okListener = new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface d, int which) {

				((EditText) view).setText(mSalesKey.get(which));
				((EditText) view).setHint(mSalesValue.get(which));
				d.dismiss();
				d = null;
				view.clearFocus();
			}
		};
		DialogInterface.OnClickListener cancelListener = new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface d, int which) {

				d.dismiss();
				d = null;
				view.clearFocus();
			}
		};
		String[] mString = (String[]) mSalesKey.toString().split(",");

		dialog.setSingleChoiceItems(mString, 0, okListener);
		dialog.setNegativeButton("Cancel", cancelListener);
		dialog.show();

	}

	public void showDateDialog(final View view, final String format) {

		final Calendar c = Calendar.getInstance();
		mYear = c.get(Calendar.YEAR);
		mMonth = c.get(Calendar.MONTH);
		mDay = c.get(Calendar.DAY_OF_MONTH);
		// showDialog(DATE_DIALOG_ID);
		mEdit = (EditText) view;
		DatePickerDialog d = new DatePickerDialog(getActivity(),
				new DatePickerDialog.OnDateSetListener() {
					@Override
					public void onDateSet(DatePicker view, int year,
							int monthOfYear, int dayOfMonth) {

						mYear = year;
						mMonth = monthOfYear + 1;
						mDay = dayOfMonth;
						mEdit.setText(String
								.format(format, mYear, mMonth, mDay));
					}
				}, mYear, mMonth, mDay);
		  d.setButton(DialogInterface.BUTTON_NEGATIVE, "Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {
						if (which == DialogInterface.BUTTON_NEGATIVE) {
							dialog.dismiss();
							((EditText)view).setText("");							
						}
					}
				});
		d.show();

	}

	private void queryData(String url, JSONObject jsonObject,
			IDataReceiveListener dataListener) {

		super.postRequest(url, jsonObject, dataListener);
	}

	private void showIssue(String code, String other) {

		String s = code;
		fae025.removeAllViews();
		fae025.setTag(code);
		for (int i = 0; i < s.length(); i++) {
			// String s=code.substring(i, i);
			if (s.substring(i, i + 1).equals("1")) {
				TableRow tableRow = new TableRow(context);
				tableRow.setLayoutParams(new TableRow.LayoutParams(
						TableRow.LayoutParams.WRAP_CONTENT,
						TableRow.LayoutParams.WRAP_CONTENT));
				ImageView picture = new ImageView(context);
				picture.setImageResource(R.drawable.gogo);
				picture.setLayoutParams(new TableRow.LayoutParams(0,
						TableRow.LayoutParams.WRAP_CONTENT, 1f));
				tableRow.addView(picture);
				TextView col1 = new TextView(context);
				col1.setText(getIssue(i));
				col1.setTextColor(Color.BLACK);
				col1.setLayoutParams(new TableRow.LayoutParams(0,
						TableRow.LayoutParams.WRAP_CONTENT, 5f));
				tableRow.addView(col1);
				fae025.addView(tableRow, new TableLayout.LayoutParams(
						TableLayout.LayoutParams.MATCH_PARENT,
						TableLayout.LayoutParams.MATCH_PARENT));
				if (i == s.length() - 1) {
					TableRow row = new TableRow(context);
					fae026 = new EditText(context);

					fae026.setBackgroundResource(R.drawable.border);
					fae026.setTextColor(android.graphics.Color.BLACK);
					fae026.setText(other);
					fae026.setLayoutParams(new TableRow.LayoutParams(0,
							TableRow.LayoutParams.WRAP_CONTENT, 5f));
					TextView col2 = new TextView(context);
					col2.setText("");
					// col2.setTextColor(Color.BLACK);
					col2.setLayoutParams(new TableRow.LayoutParams(0,
							TableRow.LayoutParams.WRAP_CONTENT, 1f));
					row.addView(col2);
					row.addView(fae026);
					fae025.addView(row, new TableLayout.LayoutParams(
							TableLayout.LayoutParams.MATCH_PARENT,
							TableLayout.LayoutParams.MATCH_PARENT));

				}
			}
		}
	}

	private void showIssueDetail(String code) {

		String s = code;
		fae027.removeAllViews();
		fae027.setTag(code);
		for (int i = 0; i < s.length(); i++) {
			// String s=code.substring(i, i);
			if (s.substring(i, i + 1).equals("1")) {
				TableRow tableRow = new TableRow(context);
				tableRow.setLayoutParams(new TableRow.LayoutParams(
						TableRow.LayoutParams.WRAP_CONTENT,
						TableRow.LayoutParams.WRAP_CONTENT));
				ImageView picture = new ImageView(context);

				picture.setImageResource(R.drawable.gogo);
				picture.setLayoutParams(new TableRow.LayoutParams(0,
						TableRow.LayoutParams.WRAP_CONTENT, 1f));
				tableRow.addView(picture);
				TextView col1 = new TextView(context);
				col1.setText(getIssueDetail(i));
				col1.setTextColor(Color.BLACK);
				col1.setLayoutParams(new TableRow.LayoutParams(0,
						TableRow.LayoutParams.WRAP_CONTENT, 5f));
				tableRow.addView(col1);
				fae027.addView(tableRow, new TableLayout.LayoutParams(
						TableLayout.LayoutParams.MATCH_PARENT,
						TableLayout.LayoutParams.MATCH_PARENT));

			}
		}
	}

	private void showPackage(String code, String other) {

		String s = code;
		fae020.removeAllViews();
		fae020.setTag(code);
		for (int i = 0; i < s.length(); i++) {
			// String s=code.substring(i, i);
			if (s.substring(i, i + 1).equals("1")) {
				TableRow tableRow = new TableRow(context);
				tableRow.setLayoutParams(new TableRow.LayoutParams(
						TableRow.LayoutParams.WRAP_CONTENT,
						TableRow.LayoutParams.WRAP_CONTENT));
				ImageView picture = new ImageView(context);
				picture.setImageResource(R.drawable.gogo);
				picture.setLayoutParams(new TableRow.LayoutParams(0,
						TableRow.LayoutParams.WRAP_CONTENT, 1f));
				tableRow.addView(picture);
				TextView col1 = new TextView(context);
				col1.setText(getPackage(i));
				col1.setTextColor(Color.BLACK);
				col1.setLayoutParams(new TableRow.LayoutParams(0,
						TableRow.LayoutParams.WRAP_CONTENT, 5f));
				tableRow.addView(col1);
				fae020.addView(tableRow, new TableLayout.LayoutParams(
						TableLayout.LayoutParams.MATCH_PARENT,
						TableLayout.LayoutParams.MATCH_PARENT));
				if (i == s.length() - 1) {
					TableRow row = new TableRow(context);
					fae021 = new EditText(context);

					fae021.setBackgroundResource(R.drawable.border);
					fae021.setTextColor(android.graphics.Color.BLACK);
					fae021.setText(other);
					fae021.setLayoutParams(new TableRow.LayoutParams(0,
							TableRow.LayoutParams.WRAP_CONTENT, 5f));
					TextView col2 = new TextView(context);
					col2.setText("");
					// col2.setTextColor(Color.BLACK);
					col2.setLayoutParams(new TableRow.LayoutParams(0,
							TableRow.LayoutParams.WRAP_CONTENT, 1f));
					row.addView(col2);
					row.addView(fae021);
					fae020.addView(row, new TableLayout.LayoutParams(
							TableLayout.LayoutParams.MATCH_PARENT,
							TableLayout.LayoutParams.MATCH_PARENT));

				}
			}
		}
	}

	private void showProducts(String code, String other) {

		String s = code;
		fae018.removeAllViews();
		fae018.setTag(code);
		for (int i = 0; i < s.length(); i++) {
			// String s=code.substring(i, i);
			if (s.substring(i, i + 1).equals("1")) {
				TableRow tableRow = new TableRow(context);
				tableRow.setLayoutParams(new TableRow.LayoutParams(
						TableRow.LayoutParams.WRAP_CONTENT,
						TableRow.LayoutParams.WRAP_CONTENT));
				ImageView picture = new ImageView(context);
				picture.setImageResource(R.drawable.gogo);
				picture.setLayoutParams(new TableRow.LayoutParams(0,
						TableRow.LayoutParams.WRAP_CONTENT, 1f));
				tableRow.addView(picture);
				TextView col1 = new TextView(context);
				col1.setText(getProduct(i));
				col1.setTextColor(Color.BLACK);
				col1.setLayoutParams(new TableRow.LayoutParams(0,
						TableRow.LayoutParams.WRAP_CONTENT, 5f));
				tableRow.addView(col1);
				fae018.addView(tableRow, new TableLayout.LayoutParams(
						TableLayout.LayoutParams.MATCH_PARENT,
						TableLayout.LayoutParams.MATCH_PARENT));
				if (i == s.length() - 1) {
					TableRow row = new TableRow(context);
					fae019 = new EditText(context);
					fae019.setBackgroundResource(R.drawable.border);
					fae019.setTextColor(android.graphics.Color.BLACK);
					fae019.setText(other);
					fae019.setLayoutParams(new TableRow.LayoutParams(0,
							TableRow.LayoutParams.WRAP_CONTENT, 5f));
					TextView col2 = new TextView(context);
					col2.setText("");
					// col2.setTextColor(Color.BLACK);
					col2.setLayoutParams(new TableRow.LayoutParams(0,
							TableRow.LayoutParams.WRAP_CONTENT, 1f));
					row.addView(col2);
					row.addView(fae019);
					fae018.addView(row, new TableLayout.LayoutParams(
							TableLayout.LayoutParams.MATCH_PARENT,
							TableLayout.LayoutParams.MATCH_PARENT));

				}
			}
		}

	}

	private void queryData() {

		String url = super.getWebServiceUrl() + "getFAE";
		JSONObject jsonObject = new JSONObject();
		JSONObject data = new JSONObject();
		try {

			if (bundle != null && bundle.size() > 0) {
				data.accumulate("fae001", bundle.getString("fae001"));
				jsonObject.accumulate("userid", super.getLoginUser());
				jsonObject.accumulate("WWID", "13145774WWGlobal999988fae999");
				jsonObject.accumulate("data", data);
				// url,jsonObjet會顯示Loading icon
				super.postRequest(url, jsonObject);
			}

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void setButtonStatus(int mode) {

		if (mode == 2) {
			btnReturnFaeResult.setVisibility(View.VISIBLE);
			btnReturnFaeList.setVisibility(View.GONE);
		} else if (mode == 1) {
			btnReturnFaeResult.setVisibility(View.GONE);
			btnReturnFaeList.setVisibility(View.VISIBLE);
		} else {
			if (bundle == null || bundle.size() == 0) {
				btnReturnFaeList.setVisibility(View.GONE);
				btnReturnFaeResult.setVisibility(View.GONE);
				btnCancel.setVisibility(View.VISIBLE);
				btnEdit.setVisibility(View.GONE);
				btnInsert.setVisibility(View.VISIBLE);
				vwTitle.setText("New FAE");

			}
		}

	}

	private void closeFragment() {

		fragmentManager.beginTransaction().remove(this).commit();
		fragmentManager.beginTransaction().show(parent).commit();
	}

	private JSONObject getInputData() {

		try {
			JSONObject item = new JSONObject();
			item.accumulate("fae001", fae001.getText());
			String fae004 = String.format("%d%d%d",
					((fae004_001.isChecked() == true) ? 1 : 0),
					((fae004_002.isChecked() == true) ? 1 : 0),
					((fae004_003.isChecked() == true) ? 1 : 0));
			item.accumulate("fae004", fae004);
			item.accumulate("fae005", fae006.getHint());
			item.accumulate("fae006", fae006.getText());
			item.accumulate("fae007", fae008.getHint());
			item.accumulate("fae008", fae008.getText());
			item.accumulate("fae009", fae009.getText());
			item.accumulate("fae010", fae010.getText());
			item.accumulate("fae011", fae012.getHint());
			item.accumulate("fae012", fae012.getText());
			item.accumulate("fae013", fae013.getHint());
			item.accumulate("fae014", fae014.getText());
			item.accumulate("fae016", fae017.getHint());
			item.accumulate("fae017", fae017.getText());
			item.accumulate("fae018", fae018.getTag());
			if (fae019 == null) {
				item.accumulate("fae019", "");
			} else {
				item.accumulate("fae019", fae019.getText());
			}
			item.accumulate("fae020", fae020.getTag());
			if (fae021 == null) {
				item.accumulate("fae021", "");
			} else {
				item.accumulate("fae021", fae021.getText());
			}
			item.accumulate("fae022", fae022.getText());
			item.accumulate("fae023", fae023.getText());
			item.accumulate("fae024", fae024.getText());
			item.accumulate("fae025", fae025.getTag());
			if (fae026 == null) {
				item.accumulate("fae026", "");
			} else {
				item.accumulate("fae026", fae026.getText());
			}
			item.accumulate("fae027", fae027.getTag());
			item.accumulate("fae028", fae028.getText());
			if (fae029a.isChecked() == true) {
				item.accumulate("fae029", "RB01");
			} else if (fae029b.isChecked() == true) {
				item.accumulate("fae029", "RB02");
			} else if (fae029c.isChecked() == true) {
				item.accumulate("fae029", "RB03");
			} else {
				item.accumulate("fae029", "");
			}
			item.accumulate("fae030", "");
			item.accumulate("fae031", fae031.getText());
			item.accumulate("fae032", fae032.getText());
			// item.accumulate("fae033",fae033.getTag());
			if (fae033a.isChecked() == true) {
				item.accumulate("fae033", "RB01");
			} else if (fae033b.isChecked() == true) {
				item.accumulate("fae033", "RB02");
			} else if (fae033c.isChecked() == true) {
				item.accumulate("fae033", "RB03");
			} else {
				item.accumulate("fae033", "");
			}
			item.accumulate("fae034", fae034.getText());
			item.accumulate("fae035", fae035.getHint());
			item.accumulate("fae036", fae036.getText());
			// item.accumulate("fae037",fae037.getTag());
			if (fae037a.isChecked() == true) {
				item.accumulate("fae037", "RB01");
			} else if (fae037b.isChecked() == true) {
				item.accumulate("fae037", "RB02");
			} else if (fae037c.isChecked() == true) {
				item.accumulate("fae037", "RB03");
			} else {
				item.accumulate("fae037", "");
			}
			item.accumulate("fae038", fae038.getText());
			// item.accumulate("fae039",fae039.getTag());
			if (fae039a.isChecked() == true) {
				item.accumulate("fae039", "RB01");
			} else if (fae039b.isChecked() == true) {
				item.accumulate("fae039", "RB02");
			} else {
				item.accumulate("fae039", "");
			}
			item.accumulate("fae040", fae040.getText());
			return item;
		} catch (JSONException e) {
		}
		return null;
	}

	private void saveData() {

		JSONObject jsonObject = new JSONObject();
		JSONObject data = new JSONObject();
		try {

			data.accumulate("action", "Save");
			data.accumulate("faeitem", getInputData());
			jsonObject.accumulate("userid", getLoginUser());
			jsonObject.accumulate("WWID", "13145774WWGlobal999988fae999");
			jsonObject.accumulate("data", data);
			queryData((String) super.getWebServiceUrl() + "updateFAE",
					jsonObject, new IDataReceiveListener() {
						public void onReceiveData(Object obj) {
							try {
								JSONObject rs = new JSONObject((String) obj);
								String remark = rs.getString("remark");
								String success = rs.getString("success");
								if (success.equals("true")) {
									showDialog("Success", "Save sucess");
								} else {
									showDialog("Error", remark);
								}
							} catch (JSONException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}

					});
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void showCustDialog(final View view) {

		CustListActivity activity = new CustListActivity();
		activity.parent = this;
		activity.setCallback(new BaseFragment.ICallback() {
			@Override
			public void doWork(Object object) {
				Bundle b = (Bundle) object;
				((EditText) view).setText(b.getString("custId") + " "
						+ b.getString("custName"));
				((EditText) view).setHint(b.getString("custId"));
			}

		});
		openDialog((Fragment) activity, "Cust");
	}

	private void openDialog(Fragment fragment, String tagName) {

		// Fragment fragment= new CustListActivity();
		FragmentManager fragmentManager = getFragmentManager();
		fragmentManager.beginTransaction()
				.hide(fragmentManager.findFragmentById(this.getId())).commit();
		fragmentManager.beginTransaction()
				.add(R.id.content_frame, fragment, tagName).commit();
		fragmentManager.beginTransaction().addToBackStack(null);
		fragmentManager.beginTransaction().show(fragment).commit();

	}

	private void showLayout(View v) {

		// make other layout to be gone
		if (v.getId() != lb1.getId() && lb1.getVisibility() == View.VISIBLE)
			lb1.setVisibility(View.GONE);
		if (v.getId() != lb2.getId() && lb2.getVisibility() == View.VISIBLE)
			lb2.setVisibility(View.GONE);
		if (v.getId() != lb3.getId() && lb3.getVisibility() == View.VISIBLE)
			lb3.setVisibility(View.GONE);
		if (v.getId() != lb4.getId() && lb4.getVisibility() == View.VISIBLE)
			lb4.setVisibility(View.GONE);
		if (v.getId() != lb5.getId() && lb5.getVisibility() == View.VISIBLE)
			lb5.setVisibility(View.GONE);
		// set sub title
		String title = "";
		if (v.getId() == lb1.getId())
			title = b1.getText().toString().replace('\n', ' ');
		if (v.getId() == lb2.getId())
			title = b2.getText().toString().replace('\n', ' ');
		if (v.getId() == lb3.getId())
			title = b3.getText().toString().replace('\n', ' ');
		if (v.getId() == lb4.getId())
			title = b4.getText().toString().replace('\n', ' ');
		if (v.getId() == lb5.getId())
			title = b5.getText().toString();
		txtInfo2.setText(title);
		// make current layout to be visible
		if (v.getVisibility() != View.VISIBLE) {
			v.setVisibility(View.VISIBLE);
		}
		// if (tabbar.getVisibility() == View.VISIBLE) {
		// tabbar.setVisibility(View.GONE);
		// }
	}

	public void saveImage(Bitmap bitmap, String path, String filename) {

		try {
			FileOutputStream fos = new FileOutputStream(path + "/" + filename);
			bitmap.compress(Bitmap.CompressFormat.PNG, 90, fos);
			fos.close();
		} catch (FileNotFoundException e) {
			Log.d("error", "File not found: " + e.getMessage());
		} catch (IOException e) {
			Log.d("error", "Error accessing file: " + e.getMessage());
		}
		// create a file to write bitmap data
		/*
		 * File f = new File(path, filename); try { f.createNewFile();
		 * 
		 * // Convert bitmap to byte array ByteArrayOutputStream bos = new
		 * ByteArrayOutputStream(); bitmap.compress(Bitmap.CompressFormat.PNG, 0
		 * , bos); byte[] bitmapdata = bos.toByteArray(); // write the bytes in
		 * file FileOutputStream fos = new FileOutputStream(f);
		 * fos.write(bitmapdata); fos.flush(); fos.close(); } catch (IOException
		 * e) { // TODO Auto-generated catch block e.printStackTrace(); }
		 */
	}

	@SuppressLint("ClickableViewAccessibility")
	class Panel extends View {
		private Bitmap mBitmap;
		Paint mPaint = new Paint();
		private String mTitle;

		public Panel(Context context) {
			super(context);
			mPaint.setColor(Color.BLACK);
			mPaint.setStyle(Paint.Style.STROKE);
			mPaint.setStrokeWidth(3);
			mTitle = "";
			mBitmap = null;
		}

		public String getTitle() {
			return mTitle;
		}

		public void setTitle(String value) {
			mTitle = value;
		}

		public Bitmap getGraphics() {

			Bitmap bmp;
			if (mBitmap == null) {
				bmp = Bitmap.createBitmap(this.getWidth(), this.getHeight(),
						Bitmap.Config.ARGB_8888);
				Canvas canvas = new Canvas(bmp);
				Paint mypaint = new Paint();
				mypaint.setColor(Color.BLACK);
				mypaint.setStyle(Paint.Style.STROKE);
				mypaint.setStrokeWidth(3);
				for (int i = 1; i < points.size(); i++) {
					PointF p1 = points.get(i - 1);
					PointF p2 = points.get(i);
					if (Math.abs(p1.x - p2.x) < 20
							&& Math.abs(p1.y - p2.y) < 20) {
						canvas.drawLine(p1.x, p1.y, p2.x, p2.y, mypaint);
					}
				}
			} else {
				bmp = mBitmap;

			}
			return bmp;
		}

		public void setGraphics(Bitmap bmp) {

			mBitmap = bmp;
			this.invalidate();
		}

		@SuppressLint("DrawAllocation")
		@Override
		public void onDraw(Canvas canvas) {

			super.onDraw(canvas);
			/*
			 * if(this.isEnabled()==false){ return ; }
			 */
			if (mBitmap != null) {
				canvas.drawBitmap(mBitmap, 0, 0, null);
			}
			if (mTitle != "") {
				Paint mypaint = new Paint();
				mypaint.setTextSize(24);// 設定字體大小
				mypaint.setColor(Color.BLACK);// 設定字體顏色
				canvas.drawText(mTitle, 0, this.getHeight() / 2, mypaint);//
			}
			for (int i = 1; i < points.size(); i++) {
				PointF p1 = points.get(i - 1);
				PointF p2 = points.get(i);
				if (Math.abs(p1.x - p2.x) < 20 && Math.abs(p1.y - p2.y) < 20) {
					canvas.drawLine(p1.x, p1.y, p2.x, p2.y, mPaint);
				}
			}
		}

		@Override
		public boolean onTouchEvent(android.view.MotionEvent event) {
			if (this.isEnabled() == false) {
				return true;
			}
			for (int i = 0; i < event.getHistorySize(); i++) {
				points.add(new PointF(event.getHistoricalX(i), event
						.getHistoricalY(i)));
			}
			Panel.this.invalidate();
			return true; // 代表該事件已被處理，不再向上傳遞了。
		};
	}
}