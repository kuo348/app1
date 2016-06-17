package com.winway.wwapp2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.HTTP;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Apqp 按下[add]Button後執行的動作 Add APQP頁面 Screenshot_20150410_19.jpg
 */
public class ApqpAddActivity extends BaseFragment {
	private Context context;
	private ListView lstApqpType;
	private WebView mWebView;
	private View mView;
	// private ArrayList<String> list=new ArrayList<String>();
	private SimpleAdapter simpleAdapter;
	private int mYear, mMonth, mDay;
	private EditText mEdit;
	private List<Map<String, Object>> items = new ArrayList<Map<String, Object>>();// 是定義一個List類型的變量，list裡面存放的是一個Map，而Map的key是一個String類型，Map的value是Object類型
	private String[] itemText = { "SOCKET", "Duplication", "WLCSP", "ATC",
			"FindPitch ProbeCard", "ChangeCover Kit", "E-Flux" };

	@Override
	/**
	 *建立視圖(Add APQP頁面)
	 */
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		// System.out.println("==>"+new
		// Throwable().getStackTrace()[0].getClassName()+" > "+new
		// Throwable().getStackTrace()[0].getMethodName());
		// System.out.println("===>Line number: "+new
		// Throwable().getStackTrace()[0].getLineNumber());

		return initView(inflater, container);
	}

	/**
	 * 秀出對話方塊:Apqp的類別
	 * 
	 * 
	 */
	public void showApqpTypeDialog(final View view) {
		// System.out.println("==>"+new
		// Throwable().getStackTrace()[0].getClassName()+" > "+new
		// Throwable().getStackTrace()[0].getMethodName());
		// System.out.println("===>Line number: "+new
		// Throwable().getStackTrace()[0].getLineNumber());

		AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity());
		dialog.setTitle("Type").setIcon(android.R.drawable.ic_dialog_info);

		// 對話方塊 =>按下確定
		DialogInterface.OnClickListener okListener = new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface d, int which) {
				((EditText) view).setText(itemText[which]);
				((EditText) view).clearFocus();
				d.dismiss();
				d = null;
			}
		};

		// 對話方塊 =>按下取消
		DialogInterface.OnClickListener cancelListener = new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface d, int which) {
				// 清空文字
				((EditText) view).setText("");
				((EditText) view).clearFocus();
				d.dismiss();
				d = null;
			}
		};

		dialog.setSingleChoiceItems(itemText, 0, okListener);
		dialog.setNegativeButton("Cancel", cancelListener);
		dialog.show();

	}

	/**
	 * 彈出日期選單
	 * 
	 * @param view
	 * @param format
	 */
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

	/**
	 * 初始化視圖(Add APQP頁面)
	 * 
	 * @param inflater
	 * @param container
	 * @return
	 */
	private View initView(LayoutInflater inflater, ViewGroup container) {

		// System.out.println("==>"+new
		// Throwable().getStackTrace()[0].getClassName()+" > "+new
		// Throwable().getStackTrace()[0].getMethodName());
		// System.out.println("===>Line number: "+new
		// Throwable().getStackTrace()[0].getLineNumber());

		// Add APQP頁面,先把view抓出來,再存入mView,方便任何一個method使用
		View view = inflater.inflate(R.layout.actapqpadd, container, false);
		context = view.getContext();
		mView = view;

		final EditText editApqpType = (EditText) view
				.findViewById(R.id.edit_apqptype);// apqp type 文字框
		final EditText editIssueDate = (EditText) view
				.findViewById(R.id.edit_issuedate);// issuedate 文字框

		// Save儲存Button
		final Button saveApqpBtn = (Button) view.findViewById(R.id.btnsave);

		editApqpType.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				editApqpType.setInputType(InputType.TYPE_NULL); // 關閉軟鍵盤
				return false;
			}

		});
		editApqpType.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				showApqpTypeDialog(v);// 彈出apqp類別對話選單
			}
		});
		editIssueDate.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				editIssueDate.setInputType(InputType.TYPE_NULL); // 關閉軟鍵盤
				return false;
			}

		});
		editIssueDate.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				showDateDialog(v, "%d%02d%02d");// 彈出日期選單
			}
		});

		/**
		 * Screenshot_20150410_11.jpg actapqpadd.xml 按下Button=>btnsave 觸發的Action
		 * 
		 * @param view
		 */
		saveApqpBtn.setOnClickListener(new Button.OnClickListener() {

			@Override
			public void onClick(View v) {
				// 按下Button=>btnsave 觸發的Action
				onSaveApqpClick();
			}

		});
		/*
		 * RelativeLayout r3=(RelativeLayout)view.findViewById(R.id.r3); WebView
		 * mWebView =(WebView) view.findViewById(R.id.webView1);
		 * mWebView.setWebViewClient(mWebViewClient);
		 * mWebView.getSettings().setJavaScriptEnabled(true);
		 * mWebView.addJavascriptInterface(new WebAppInterface(getActivity()),
		 * "Android"); mWebView.loadUrl("file:///android_asset/apqptype.html");
		 * r3.setVisibility(RelativeLayout.INVISIBLE); RelativeLayout
		 * r4=(RelativeLayout)view.findViewById(R.id.r4);
		 * r4.setVisibility(RelativeLayout.INVISIBLE);
		 */
		/*
		 * lstApqpType=(ListView)view.findViewById(R.id.lstapqptype); //
		 * ArrayAdapter<String> adapter=new
		 * ArrayAdapter<String>(getActivity(),android
		 * .R.layout.simple_expandable_list_item_1,getData()); simpleAdapter =
		 * new SimpleAdapter(getActivity(), getData(), R.layout.simple_item,new
		 * String[]{ "item","image"},new int[]{R.id.item,0});
		 * lstApqpType.setAdapter(simpleAdapter);
		 */

		return view;
	}

	// WebViewClient mWebViewClient = new WebViewClient() {
	// @Override
	// public boolean shouldOverrideUrlLoading(WebView view, String url) {
	//
	// //System.out.println("==>"+new
	// Throwable().getStackTrace()[0].getClassName()+" > "+new
	// Throwable().getStackTrace()[0].getMethodName());
	// //System.out.println("===>Line number: "+new
	// Throwable().getStackTrace()[0].getLineNumber());
	//
	// view.loadUrl(url);
	// return true;
	// }
	// };
	/**
	 * get apqp type選單資料
	 * 
	 * @return
	 */
	private List<Map<String, Object>> getData() {

		// System.out.println("==>"+new
		// Throwable().getStackTrace()[0].getClassName()+" > "+new
		// Throwable().getStackTrace()[0].getMethodName());
		// System.out.println("===>Line number: "+new
		// Throwable().getStackTrace()[0].getLineNumber());

		for (int i = 0; i < itemText.length; i++) {
			Map<String, Object> item = new HashMap<String, Object>();
			// item.put("image", 0);
			item.put("item", itemText[i]);
			item.put("image", 0);
			items.add(item);
		}
		return items;
	}

	// public class WebAppInterface {
	// Context mContext;
	//
	// /** Instantiate the interface and set the context */
	// WebAppInterface(Context c) {
	// mContext = c;
	// }
	//
	// /** Show a toast from the web page */
	// @JavascriptInterface
	// public void setApqpType(String value) {
	//
	// //System.out.println("==>"+new
	// Throwable().getStackTrace()[0].getClassName()+" > "+new
	// Throwable().getStackTrace()[0].getMethodName());
	// //System.out.println("===>Line number: "+new
	// Throwable().getStackTrace()[0].getLineNumber());
	//
	// EditText apqpType= (EditText )mView.findViewById(R.id.edit_apqptype);
	// apqpType.setText(value);
	//
	// }
	// @JavascriptInterface
	// public void showToast(String toast) {
	//
	// //System.out.println("==>"+new
	// Throwable().getStackTrace()[0].getClassName()+" > "+new
	// Throwable().getStackTrace()[0].getMethodName());
	// //System.out.println("===>Line number: "+new
	// Throwable().getStackTrace()[0].getLineNumber());
	//
	// //Toast.makeText(mContext, toast, Toast.LENGTH_SHORT).show();
	// //存入資料
	// SharedPreferences settings = mContext.getSharedPreferences("apqpadd", 0);
	// SharedPreferences.Editor editor = settings.edit();
	// editor.putString("ApqpType",toast);
	// editor.commit();//要記得加
	// }
	//
	// }

	/**
	 * Screenshot_20150410_11.jpg actapqpadd.xml 按下Button=>btnsave 觸發的Action
	 * 
	 * @param view
	 */
	public void onSaveApqpClick() {

		// System.out.println("==>"+new
		// Throwable().getStackTrace()[0].getClassName()+" > "+new
		// Throwable().getStackTrace()[0].getMethodName());
		// System.out.println("===>Line number: "+new
		// Throwable().getStackTrace()[0].getLineNumber());

		// //類別欄位
		// EditText apqptypeText = (EditText) this
		// .findViewById(R.id.edit_apqptype);
		//
		//
		// //日期欄位
		// EditText issuedateText = (EditText) this
		// .findViewById(R.id.edit_issuedate);
		//
		//
		//
		// DatePicker dp = (DatePicker) this.findViewById(R.id.datePicker1);
		// if (issuedateText != null) {
		//
		// //系統日期(NOW)
		// //System.out.println("===>~~~~ "+String.format("%d%02d%02d",
		// dp.getYear(),
		// dp.getMonth() + 1, dp.getDayOfMonth()));
		//
		// }
		//
		// if ( issuedateText!= null) {
		//
		// //用戶所選擇的日期
		// //System.out.println("===>~~~~ "+String.format("%s",
		// issuedateText.getText()
		// ));
		//
		// }
		//

		addNewAPQP("Save");

	}

	/**
	 * 將APQP =>TAB 1 =>Customer Infomations user編輯資料上傳到webservice
	 * 
	 * @param action
	 *            (Save,Confirm,Changes)
	 */
	private void addNewAPQP(final String action) {

		// System.out.println("==>"+new
		// Throwable().getStackTrace()[0].getClassName()+" > "+new
		// Throwable().getStackTrace()[0].getMethodName());
		// System.out.println("===>Line number: "+new
		// Throwable().getStackTrace()[0].getLineNumber());

		FragmentManager fragmentManager = getFragmentManager();

		HttpPostAsyncTask task1 = new HttpPostAsyncTask();
		JSONObject data = null;
		String func = "";

		func = "newAPQP";
		data = getInputData1(action);// get data from user input
		task1.setCallback(new BaseFragment.ICallback() {
			@Override
			public void doWork(Object obj) {

				// System.out.println("==>"+new
				// Throwable().getStackTrace()[0].getClassName()+" > "+new
				// Throwable().getStackTrace()[0].getMethodName());
				// System.out.println("===>Line number: "+new
				// Throwable().getStackTrace()[0].getLineNumber());

				try {

					JSONObject jsonObject = new JSONObject((String) obj);
					if (jsonObject.getString("success").equals("false")) {

						// showDialog("error",jsonObject.getString("remark"));
					} else {// 成功
						JSONObject data = jsonObject.getJSONObject("data");
						// //System.out.println("==================>success: "+data);

						Bundle bundle = new Bundle();
						bundle.putString("apqpno", data.getString("xa001")
								+ "-" + data.getString("xa002"));

						// MainActivity activity = (MainActivity)getActivity();
						// if(activity instanceof MainActivity){
						// MainActivity myactivity = (MainActivity) activity;
						// myactivity.callApqpDataActivity(bundle);
						// }
						//

						// 執行父Activity的method=>callApqpDataActivity
						((MainActivity) getActivity())
								.callApqpDataActivity(bundle);

						//
						// Fragment fragment = null;
						// fragment = new ApqpDataActivity();
						// fragment.setRetainInstance(true);
						// fragment.setArguments(bundle);
						// FragmentManager fragmentManager =
						// getFragmentManager();
						// if
						// (fragmentManager.findFragmentById(fragment.getId())
						// == null) {
						// fragmentManager.beginTransaction()
						// .add(R.id.content_frame, fragment,
						// "apqpdata2").commit();
						// }
						// if (fragmentManager.findFragmentByTag("apqpdata") !=
						// null) {
						// fragmentManager.beginTransaction()
						// .hide(fragmentManager.findFragmentByTag("apqpdata"))
						// .commit();
						// }
						//
						// fragmentManager.beginTransaction().show(fragment).commit();
						//
						//
						/*
						 * btnEdit.setTag(data.getString("editable"));
						 * btnIssue.setTag(data.getString("issuable"));
						 * btnChange.setTag(data.getString("xa068")); xa591 =
						 * data.getString("xa591"); xa593 =
						 * data.getString("xa593");
						 */
						// showDialog(action+" success");

					}
					// showApplicationDialog(mView);
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		});
		task1.execute((String) getResources().getString(R.string.WebServiceUrl)
				+ func, data.toString());// 執行點

	}

	/**
	 * 非同步任務(不需Thread就可完成後台操作，將結果返回UI)，参數(1)String=>啟動任務執行的輸入参數 参數(2)Progress
	 * 執行過程中，回傳給UI thread的資料(例如:後台任務執行的百分比) 参數(3)Result 傳回執行結果
	 * 
	 * @author
	 * 
	 */
	public class HttpPostAsyncTask extends AsyncTask<String, Void, String> {
		protected ICallback mCallback;

		/**
		 * 設定抽象類的接口
		 * 
		 * @param callback
		 */
		public void setCallback(ICallback callback) {

			// System.out.println("==>"+new
			// Throwable().getStackTrace()[0].getClassName()+" > "+new
			// Throwable().getStackTrace()[0].getMethodName());
			// System.out.println("===>Line number: "+new
			// Throwable().getStackTrace()[0].getLineNumber());

			this.mCallback = callback;

		}

		private void doWork(Object object) {

			// System.out.println("==>"+new
			// Throwable().getStackTrace()[0].getClassName()+" > "+new
			// Throwable().getStackTrace()[0].getMethodName());
			// System.out.println("===>Line number: "+new
			// Throwable().getStackTrace()[0].getLineNumber());

			if (this.mCallback != null) {
				this.mCallback.doWork(object);
			}
		}

		protected String doInBackground(String... urls) {

			// System.out.println("==>"+new
			// Throwable().getStackTrace()[0].getClassName()+" > "+new
			// Throwable().getStackTrace()[0].getMethodName());
			// System.out.println("===>Line number: "+new
			// Throwable().getStackTrace()[0].getLineNumber());

			return POST(urls[0], urls[1]);
		}

		// onPostExecute displays the results of the AsyncTask.
		@Override
		protected void onPostExecute(String result) {

			// System.out.println("==>"+new
			// Throwable().getStackTrace()[0].getClassName()+" > "+new
			// Throwable().getStackTrace()[0].getMethodName());
			// System.out.println("===>Line number: "+new
			// Throwable().getStackTrace()[0].getLineNumber());

			// ACTION_MESSAGE=WHAT_DID_LOAD_DATA;
			if (mCallback == null) {

			} else {
				doWork(result);
			}

		}

	}

	/**
	 * 跟webservice 溝通的靈魂程式
	 * 
	 * @param url
	 * @param json
	 * @return
	 */
	public static String POST(String url, String json) {

		// System.out.println("==>"+new
		// Throwable().getStackTrace()[0].getClassName()+" > "+new
		// Throwable().getStackTrace()[0].getMethodName());
		// System.out.println("===>Line number: "+new
		// Throwable().getStackTrace()[0].getLineNumber());

		InputStream inputStream = null;
		String result = "";

		try {

			// 1. create HttpClient
			HttpClient httpclient = new DefaultHttpClient();

			// 2. make POST request to the given URL
			HttpPost httpPost = new HttpPost(url);

			StringEntity se = new StringEntity(json, HTTP.UTF_8);

			httpPost.setEntity(se);

			// 7. Set some headers to inform server about the type of the
			// content
			httpPost.setHeader("Accept", "application/json");
			httpPost.setHeader("Content-type", "application/json");

			// 8. Execute POST request to the given URL
			HttpResponse httpResponse = httpclient.execute(httpPost);

			// 9. receive response as inputStream
			inputStream = httpResponse.getEntity().getContent();

			// 10. convert inputstream to string
			if (inputStream != null)
				result = convertInputStreamToString(inputStream);
			else
				result = "Did not work!";

		} catch (Exception e) {
			Log.d("InputStream", e.getLocalizedMessage());
			result = e.toString();
		}

		// 11. return result
		return result;
	}

	static InputStream is = null;

	private static String convertInputStreamToString(InputStream inputStream)
			throws IOException {
		// System.out.println("==>"+new
		// Throwable().getStackTrace()[0].getClassName()+" > "+new
		// Throwable().getStackTrace()[0].getMethodName());
		// System.out.println("===>Line number: "+new
		// Throwable().getStackTrace()[0].getLineNumber());

		BufferedReader bufferedReader = new BufferedReader(
				new InputStreamReader(inputStream));
		String line = "";
		String result = "";
		while ((line = bufferedReader.readLine()) != null)
			result += line;

		inputStream.close();
		return result;

	}

	/**
	 * get APQP =>TAB 1 =>Customer Infomations =>user input data
	 * 
	 * @param action
	 * @return
	 */
	private JSONObject getInputData1(final String action) {

		// System.out.println("==>"+new
		// Throwable().getStackTrace()[0].getClassName()+" > "+new
		// Throwable().getStackTrace()[0].getMethodName());
		// System.out.println("===>Line number: "+new
		// Throwable().getStackTrace()[0].getLineNumber());

		try {
			JSONObject data = new JSONObject();
			JSONObject apqp1 = new JSONObject();
			JSONObject jsonObj = new JSONObject();

			jsonObj.accumulate("userid", super.getLoginUser());
			jsonObj.accumulate("WWID", "13145774WWGlobal999988newapqp999");

			// 類別欄位
			EditText apqptypeText = (EditText) mView
					.findViewById(R.id.edit_apqptype);

			// 從UI取出user所選的類別名稱 begin
			String apqptypeString = "";
			apqptypeString = apqptypeText.getText().toString();
			// 從UI取出user所選的類別名稱 end

			// API要接收的apqptype為id,手動寫對照HashMap begin

			HashMap apqpTypemap = new HashMap();

			apqpTypemap.put("SOCKET", 1);
			apqpTypemap.put("Duplication", 2);
			apqpTypemap.put("WLCSP", 3);
			apqpTypemap.put("ATC", 4);
			apqpTypemap.put("FindPitch ProbeCard", 5);
			apqpTypemap.put("ChangeCover Kit", 6);
			apqpTypemap.put("E-Flux", 7);

			// API要接收的apqptype為id,手動寫對照HashMap end

			// System.out.println("===>apqptypeText_id==: "+apqpTypemap.get(apqptypeString));

			// 日期欄位
			EditText issuedateText = (EditText) mView
					.findViewById(R.id.edit_issuedate);

			// 系統日期
			DatePicker dp = (DatePicker) mView.findViewById(R.id.datePicker1);

			data.accumulate("apqptype", apqpTypemap.get(apqptypeString));// apqp的類別ID
			data.accumulate("issuedate", issuedateText.getText());

			jsonObj.accumulate("data", data);

			// System.out.println("===>jsonObjjsonObj=: "+jsonObj);

			return jsonObj;
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
