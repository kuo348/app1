//No.15041501 add xa59r and show animate after save,change,confirm  by cooper 15-04-15
//
//
package com.winway.wwapp2;

//import java.io.BufferedReader;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.InputType;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import com.winway.wwapp2.PullDownView.OnPullDownListener;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

//import java.io.InputStreamReader;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.Map;
//import org.apache.http.HttpResponse;
//import org.apache.http.client.HttpClient;
//import org.apache.http.client.methods.HttpGet;
//import org.apache.http.client.methods.HttpPost;
//import org.apache.http.entity.StringEntity;
//import org.apache.http.impl.client.DefaultHttpClient;
//import android.annotation.SuppressLint;
//import android.app.ActionBar;
//import android.app.Activity;
//import android.app.Dialog;
//import android.app.FragmentManager;
//import android.content.res.TypedArray;
//import android.graphics.drawable.ColorDrawable;
//import android.os.Build;
//import android.os.Handler;
//import android.os.Message;
//import android.text.Html;
//import android.text.Spanned;
//import android.util.DisplayMetrics;
//import android.util.Log;
//import android.view.Gravity;

/**
 * Screenshot_20150410_14.jpg qt詳情頁 loadData => setLayoutUI => saveData1 =>
 * getInputData1 =>
 *
 */
public class QtDataActivity extends BaseFragment implements
		OnPullDownListener, OnItemClickListener {
	private Context context;//,
	private Bundle bundle;
	private View mView = null;
	private int ACTION_MESSAGE;

	private Button btnLoadPackageInfo1a, btnLoadPackageInfo2a;
	private ImageView plugimage;

	private int mYear, mMonth, mDay;
	private EditText mEdit;
	private String[] mRegion = new String[] { "Canada", "USA", "China",
			"Taiwan", "S. Asia", "Phil", "Korea", "Japan", "EU", "Israel" };
	// private static final int DATE_DIALOG_ID = 0;
	// private Button btnReturnSaleList;
	private String VERSION, xa593;
	private Button btnLoadPackageInfo1, btnLoadPackageInfo2;
	private RelativeLayout tabbar, cmdbar;
	private LinearLayout tab1, tab2;
	private Button b1, b2, b3, b4, b5, b6;
	private TextView l1, l2, l3, l4, l5, l6;
	private RelativeLayout r1, r2, r3, r4, r5, r6;
	private Button btnEdit, btnSave, btnChange, btnConfirm;
	private Button btnCancel, btnPdf;
	private Button btnAdd2;
	private TextView vwSubTitle;
	private List<String> mApplication = new ArrayList<String>();
	private List<String> mApplicationValue = new ArrayList<String>();
	private List<String> mPlugType = new ArrayList<String>();
	private List<String> mPlugTypeValue = new ArrayList<String>();
	private List<String> mHandlerManu = new ArrayList<String>();
	private List<String> mHandlerManuValue = new ArrayList<String>();
	private List<String> mHandlerModel = new ArrayList<String>();
	private List<String> mHandlerModelValue = new ArrayList<String>();
	private List<String> mTesterManu = new ArrayList<String>();
	private List<String> mTesterManuValue = new ArrayList<String>();
	private List<String> mTesterModel = new ArrayList<String>();
	private List<String> mTesterModelValue = new ArrayList<String>();
	private List<String> mPoPLGATestType = new ArrayList<String>();
	private List<String> mPoPLGATestTypeValue = new ArrayList<String>();
	private List<String> mDigitalAppStd = new ArrayList<String>();
	private List<String> mDigitalAppStdValue = new ArrayList<String>();
	private List<String> mDigitalClass = new ArrayList<String>();
	private List<String> mDigitalClassValue = new ArrayList<String>();
	private List<String> mAnalogAppStd = new ArrayList<String>();
	private List<String> mAnalogAppStdValue = new ArrayList<String>();
	private List<String> mAnalogClass = new ArrayList<String>();
	private List<String> mAnalogClassValue = new ArrayList<String>();
	private List<String> mDevicePad = new ArrayList<String>();
	private List<String> mDevicePadValue = new ArrayList<String>();
	private List<String> mDocNeeded = new ArrayList<String>();
	private List<String> mDocNeededValue = new ArrayList<String>();
	//private String xa001, xa002;
	private String QT_TYPE, QT_NO;

	//-------------------------------------------------
	//QT Vars beg
	//-------------------------------------------------
    //WF_ORD02M
	private EditText QT_DATE        ;//ed_QT_DATE
	private EditText CREATOR        ;//ed_CREATOR
	private EditText CONFIRM_DATE   ;//ed_CONFIRM_DATE
	private EditText CONFIRM_USER_ID;//ed_CONFIRM_USER_ID
	private EditText QT_NO_MAIN     ;//ed_QT_NO_MAIN
	private EditText QT_SALES       ;//ed_QT_SALES
    private EditText CUST_NO        ;//ed_CUST_NO
	private EditText CUST_NO_X      ;//ed_CUST_NO_X
	private EditText CUST_NO_Y      ;//ed_CUST_NO_Y
	private EditText CUST_CONTACT   ;//ed_CUST_CONTACT
	private EditText TEL_NO         ;//ed_TEL_NO
	private EditText REMARK         ;//ed_REMARK
	private EditText CURRENCY       ;//ed_CURRENCY
    private EditText CURRENCY_X     ;//ed_CURRENCY_X
	private EditText SHIPPING_VIA   ;//ed_SHIPPING_VIA
	private EditText SHIPPING_VIA_X ;//ed_SHIPPING_VIA_X
	private EditText BANK_NO        ;//ed_BANK_NO
	private EditText BANK_NO_X      ;//ed_BANK_NO_X
	private EditText ACCOUNT_NO     ;//ed_ACCOUNT_NO
	private EditText COPY           ;//ed_COPY
	private EditText STATUS         ;//ed_STATUS
	private EditText STATUS_X       ;//ed_STATUS_X
	private EditText STATUS_NOTE    ;//ed_STATUS_NOTE
    private EditText CHANGE_REASON  ;//ed_CHANGE_REASON
	private EditText SHIPPING_TO    ;//ed_SHIPPING_TO
	private EditText PAYMENT_TYPE   ;//ed_PAYMENT_TYPE
	private EditText PAYMENT_TYPE_X ;//ed_PAYMENT_TYPE_X
	private EditText PAYMENT_COND   ;//ed_PAYMENT_COND
	private EditText PAYMENT_COND_X ;//ed_PAYMENT_COND_X
	private EditText PAYMENT_TIME   ;//ed_PAYMENT_TIME
	private EditText PAYMENT_TIME_X ;//ed_PAYMENT_TIME_X
	private EditText TERMS_OF_TRADE ;//ed_TERMS_OF_TRADE
    private EditText TERMS_OF_TRADE_X ;//ed_TERMS_OF_TRADE_X
	private EditText TAX_TYPE       ;//ed_TAX_TYPE
	private EditText TAX_TYPE_X     ;//ed_TAX_TYPE_X
	private EditText DELIVERY       ;//ed_DELIVERY
	private EditText DELIVERY_DAYS  ;//ed_DELIVERY_DAYS
	private EditText SHIP_CONTACT   ;//ed_SHIP_CONTACT
    //M1 COUNT
    private EditText M1_COUNT       ;//ed_M1_COUNT

	//WF_ORD02M1
	private EditText M1_QT_TYPE     ;//ed_M1_QT_TYPE
	private EditText M1_QT_NO       ;//ed_M1_QT_NO
	private EditText M1_QT_SEQ      ;//ed_M1_QT_SEQ
	private EditText AP_TYPE        ;//ed_AP_TYPE
	private EditText AP_NO          ;//ed_AP_NO
	private EditText DRAWING_REF    ;//ed_DRAWING_REF
	private EditText DESCRIPTION    ;//ed_DESCRIPTION
	private EditText APQP_NO        ;//ed_APQP_NO = AP_TYPE + AP_NO

	private TextView tv_M1_QT_SEQ   ;//tv_M1_QT_SEQ
  //private TextView AP_TYPE        ;//tv_AP_TYPE
  //private TextView AP_NO          ;//tv_AP_NO
	private TextView tv_DRAWING_REF ;//tv_DRAWING_REF
	private TextView tv_DESCRIPTION ;//tv_DESCRIPTION
	private TextView tv_APQP_NO     ;//tv_APQP_NO = AP_TYPE + AP_NO
	//WF_ORD02M11

	//WF_ORD02M12

	private ArrayList<QtItem2> qtItems2;
	private int page = 1;
	//private QtListAdapter adapter2;
	private QtListAdapter2 adapter2;
	private PullDownView mPullDownView;
	private TypedArray navMenuIcons;
	private ListView lstQt;

    private List<String> mPicker_Text = new ArrayList<String>();
    private List<String> mPicker_Value = new ArrayList<String>();
	private List<String> mPicker_Remark = new ArrayList<String>();

	//-------------------------------------------------

	private OnEditorActionListener EditorListener = new OnEditorActionListener() {
		@Override
		public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {

			// TODO Auto-generated method stub
			return false;
		}
	};

	/**
	 * Function C
	 */
	private void closeFragment() {
		if (this.parent != null) {
			this.fragmentManager.beginTransaction().remove(this).commit();
			this.fragmentManager.beginTransaction().show(parent).commit();
		}
	}

	/**
	 * Function G 取得Qt的編號,方便辨識哪一筆資料上傳到webservice
	 * 
	 * @return
	 */
	private String getQtNo() {

		String rs = (bundle != null && bundle.getString("qtno") == null) ?
				    "" : bundle.getString("qtno");
		return rs;
	}

	private JSONObject getQT2(String QT_TYPE, String QT_NO) {

		try {
			JSONObject jsonObj = new JSONObject();
			JSONObject data = new JSONObject();
			data.accumulate("QT_TYPE", QT_TYPE);
			data.accumulate("QT_NO", QT_NO);
			jsonObj.accumulate("userid", super.getLoginUser());
			jsonObj.accumulate("WWID", "13145774WWGlobal999988qt2999");
			jsonObj.accumulate("data", data);
			return jsonObj;
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	private JSONObject queryQT2(String QT_TYPE, String QT_NO) {

		/*
		String json = "";
		// String
		// url="http://59.125.146.7:8080/QTService/GetMsgList?USERID=mis&PAGE="+Integer.toString(page)+"&WWID=13145774WWGlobal999988msg";
		String url = super.getWebServiceUrl() + "queryQT2";
		JSONObject jsonObject = new JSONObject();
		JSONObject data = new JSONObject();
		try
		{
			//sTmp=this.editSearch.getText().toString().trim();

			data.accumulate("QT_TYPE", QT_TYPE);
			data.accumulate("QT_NO", QT_NO);

			jsonObject.accumulate("userid", super.getLoginUser());
			jsonObject.accumulate("WWID", "13145774WWGlobal999988QTquery2999");
			jsonObject.accumulate("data", data);
			jsonObject.accumulate("page", Integer.toString(page));
			// new HttpPostAsyncTask().execute(url,jsonObject.toString());
			//super.postRequest(url, jsonObject, Message);
			super.postRequest(url, jsonObject, 0);//

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        */
		// new HttpGetAsyncTask().execute(url);

        //-----------------------------------------------------------
		JSONObject jsonObj = new JSONObject();
		try {

			JSONObject data = new JSONObject();

			String[] qtno = getQtNo().split("-");
			if (qtno.length == 2) {
				data.accumulate("M1_QT_TYPE", qtno[0]);
				data.accumulate("M1_QT_NO", qtno[1]);
				//data.accumulate("QT_TYPE", QT_TYPE);
				//data.accumulate("QT_NO", QT_NO);
				// data.accumulate("QT_NO","140401005");
			}


			jsonObj.accumulate("userid", super.getLoginUser());
			//jsonObj.accumulate("WWID", "13145774WWGlobal999988qt2999");
			jsonObj.accumulate("WWID", "13145774WWGlobal999988QTquery2999");
			jsonObj.accumulate("data", data);
			return jsonObj;
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;

	}


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

	/**
	 * get QT =>TAB 1 =>Customer Infomations =>user input data
	 * 
	 * @param action
	 * @return
	 */
	private JSONObject getInputData1(final String action) {

		try {
			JSONObject data = new JSONObject();
			JSONObject qt1 = new JSONObject();
			JSONObject jsonObj = new JSONObject();
			jsonObj.accumulate("userid", super.getLoginUser());
			jsonObj.accumulate("WWID", "13145774WWGlobal999988qt1999");
			//String[] qtno = this.getQtNo().split("-");
			//if (qtno.length <= 1)
			//	return data;

			data.accumulate("QT_TYPE", QT_TYPE);
			data.accumulate("QT_NO"  , QT_NO  );
			data.accumulate("VERSION", VERSION);//20160112 : 還原回來
			//下面這一行尚未完成, 必須再修改
			data.accumulate("CONFIRM_CODE", btnChange.getTag().toString());

            data.accumulate("QT_DATE"         , QT_DATE         .getText() );
            data.accumulate("CREATOR"         , CREATOR         .getText() );
            data.accumulate("CONFIRM_DATE"    , CONFIRM_DATE    .getText() );
            data.accumulate("CONFIRM_USER_ID" , CONFIRM_USER_ID .getText() );
            data.accumulate("QT_NO_MAIN"      , QT_NO_MAIN      .getText() );
            data.accumulate("QT_SALES"        , QT_SALES        .getText() );
            data.accumulate("CUST_NO"         , CUST_NO         .getText() );
            data.accumulate("CUST_NO_X"       , CUST_NO_X       .getText() );
            data.accumulate("CUST_NO_Y"       , CUST_NO_Y       .getText() );
            data.accumulate("CUST_CONTACT"    , CUST_CONTACT    .getText() );
            data.accumulate("TEL_NO"          , TEL_NO          .getText() );
            data.accumulate("REMARK"          , REMARK          .getText() );

          //data.accumulate("CURRENCY"        , CURRENCY        .getText() );
          //data.accumulate("CURRENCY_X"      , CURRENCY_X      .getText() );
			data.accumulate("CURRENCY"          , CURRENCY      .getText() );//¥N¸¹
			data.accumulate("CURRENCY_X"        , CURRENCY      .getText() );//¦WºÙ

			//data.accumulate("SHIPPING_VIA"    , SHIPPING_VIA    .getText() );
			//data.accumulate("SHIPPING_VIA_X"  , SHIPPING_VIA_X  .getText() );
		    data.accumulate("SHIPPING_VIA"      , SHIPPING_VIA  .getTag()  );//¥N¸¹
		    data.accumulate("SHIPPING_VIA_X"    , SHIPPING_VIA  .getText() );//¦WºÙ

            data.accumulate("BANK_NO"         , BANK_NO         .getText() );
            data.accumulate("BANK_NO_X"       , BANK_NO_X       .getText() );
            data.accumulate("ACCOUNT_NO"      , ACCOUNT_NO      .getText() );
            data.accumulate("COPY"            , COPY            .getText() );
            //data.accumulate("STATUS"          , STATUS          .getText() );
            //data.accumulate("STATUS_X"        , STATUS_X        .getText() );
			data.accumulate("STATUS"            , STATUS        .getTag()  );//¥N¸¹
			data.accumulate("STATUS_X"          , STATUS        .getText() );//¦WºÙ

            data.accumulate("STATUS_NOTE"     , STATUS_NOTE     .getText() );
            data.accumulate("CHANGE_REASON"   , CHANGE_REASON   .getText() );
            data.accumulate("SHIPPING_TO"     , SHIPPING_TO     .getText() );

            //data.accumulate("PAYMENT_TYPE"    , PAYMENT_TYPE    .getText() );
            //data.accumulate("PAYMENT_TYPE_X"  , PAYMENT_TYPE_X  .getText() );
			data.accumulate("PAYMENT_TYPE"      , PAYMENT_TYPE  .getTag()  );//¥N¸¹
			data.accumulate("PAYMENT_TYPE_X"    , PAYMENT_TYPE  .getText() );//¦WºÙ

            //data.accumulate("PAYMENT_COND"    , PAYMENT_COND    .getText() );
            //data.accumulate("PAYMENT_COND_X"  , PAYMENT_COND_X  .getText());
			data.accumulate("PAYMENT_COND"      , PAYMENT_COND  .getTag()  );//¥N¸¹
			data.accumulate("PAYMENT_COND_X"    , PAYMENT_COND  .getText() );//¦WºÙ

            //data.accumulate("PAYMENT_TIME"    , PAYMENT_TIME    .getText() );
            //data.accumulate("PAYMENT_TIME_X"  , PAYMENT_TIME_X  .getText() );
			data.accumulate("PAYMENT_TIME"      , PAYMENT_TIME  .getTag()  );//¥N¸¹
			data.accumulate("PAYMENT_TIME_X"    , PAYMENT_TIME  .getText() );//¦WºÙ

            //data.accumulate("TERMS_OF_TRADE"  , TERMS_OF_TRADE  .getText() );
            //data.accumulate("TERMS_OF_TRADE_X", TERMS_OF_TRADE_X.getText() );
			data.accumulate("TERMS_OF_TRADE"    , TERMS_OF_TRADE.getTag()  );//¥N¸¹
			data.accumulate("TERMS_OF_TRADE_X"  , TERMS_OF_TRADE.getText() );//¦WºÙ

            //data.accumulate("TAX_TYPE"        , TAX_TYPE        .getText() );
            //data.accumulate("TAX_TYPE_X"      , TAX_TYPE_X      .getText() );
			data.accumulate("TAX_TYPE"          , TAX_TYPE      .getTag()  );//¥N¸¹
			data.accumulate("TAX_TYPE_X"        , TAX_TYPE      .getText() );//¦WºÙ

            data.accumulate("DELIVERY"        , DELIVERY        .getText() );
            data.accumulate("DELIVERY_DAYS"   , DELIVERY_DAYS   .getText() );
            data.accumulate("SHIP_CONTACT"    , SHIP_CONTACT    .getText() );
			data.accumulate("M1_COUNT"        , "0"                        );
            //M1 COUNT 不用寫回
          //data.accumulate("M1_COUNT"        , M1_COUNT        .getText() );

            //--------------------------------------------------------
            //注意:下面這一段處理 picker , 會複寫 前面的 程式碼
            //Beg
            //--------------------------------------------------------
          //data.accumulate("BANK_NO"           , BANK_NO       .getTag () );//¥N¸¹
          //data.accumulate("BANK_NO_X"         , BANK_NO       .getText() );//¦WºÙ
            //--------------------------------------------------------
            //End
            //--------------------------------------------------------

			qt1.accumulate("action", action);
			qt1.accumulate("qt1", data);
			jsonObj.accumulate("data", qt1);
			return jsonObj;
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * get QT =>TAB 2 =>Package Information =>user input data
	 * 
	 * @param action
	 * @return
	 */
	private JSONObject getInputData2(final String action) {

		try {
			JSONObject data = new JSONObject();
			JSONObject qt2 = new JSONObject();
			JSONObject jsonObj = new JSONObject();




			jsonObj.accumulate("userid", super.getLoginUser());
			jsonObj.accumulate("WWID", "13145774WWGlobal999988newqt2999");

			//data.accumulate("qttype",qtTypemap.get(qttypeString));//qt的類別ID
			data.accumulate("M1_QT_TYPE", QT_TYPE);
			data.accumulate("M1_QT_NO"  , QT_NO);

			jsonObj.accumulate("data", data);

			//System.out.println("===>jsonObjjsonObj=: "+jsonObj);


			return jsonObj;
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}


	// Function L
	private void loadEFPlugImage(String imaname) {
		// 建立一個AsyncTask執行緒進行圖片讀取動作，並帶入圖片連結網址路徑
		new AsyncTask<String, Void, Bitmap>() {
			@Override
			protected Bitmap doInBackground(String... params) {

				String url = params[0];
				return getBitmapFromURL(url);
			}

			// 背景工作處理完"後"須做的事情
			@Override
			protected void onPostExecute(Bitmap result) {

				plugimage.setImageBitmap(result);
				super.onPostExecute(result);
			}
		}.execute(String.format("%sPowerPlug_%s.jpg", getActivity()
				.getResources().getString(R.string.downloadImageUrl), imaname));

	}

	@Override
	/**
	 * get webservice data　(getQT1 =>Customer Infomations)
	 * @param obj
	 */
	public void loadData(Object result) {

		try {
			JSONObject jsonObject = new JSONObject((String) result);
			if (!jsonObject.getString("success").equals("true")) {
				showDialog("error", jsonObject.getString("remark"));
				return;
			}
			JSONObject data = jsonObject.getJSONObject("data");
			final String QT_TYPE = data.getString("QT_TYPE");
			final String QT_NO   = data.getString("QT_NO"  );

            //20151217 : 暫時 remark
			// if (data.getString("editable").equals("N")) {
			// btnEdit.setVisibility(View.GONE);
			// }

			btnEdit.setTag(data.getString("editable"));
			//if(data.getString("CONFIRM_CODE")!=null)
			btnChange.setTag(data.getString("CONFIRM_CODE"));

			VERSION = data.getString("VERSION");

            QT_DATE         .setText(data.getString("QT_DATE")); //QT_DATE
            CREATOR         .setText(data.getString("CREATOR")); //CREATOR
            CONFIRM_DATE    .setText(data.getString("CONFIRM_DATE")); //CONFIRM_DATE
            CONFIRM_USER_ID .setText(data.getString("CONFIRM_USER_ID")); //CONFIRM_USER_ID
            QT_NO_MAIN      .setText(data.getString("QT_NO_MAIN")); //QT_NO_MAIN
            QT_SALES        .setText(data.getString("QT_SALES")); //QT_SALES
            CUST_NO         .setText(data.getString("CUST_NO")); //CUST_NO
            CUST_NO_X       .setText(data.getString("CUST_NO_X")); //CUST_NO_X
            CUST_NO_Y       .setText(data.getString("CUST_NO_Y")); //CUST_NO_Y
            CUST_CONTACT    .setText(data.getString("CUST_CONTACT")); //CUST_CONTACT
            TEL_NO          .setText(data.getString("TEL_NO")); //TEL_NO
            REMARK          .setText(data.getString("REMARK")); //REMARK
            CURRENCY        .setText(data.getString("CURRENCY")); //CURRENCY
            CURRENCY_X      .setText(data.getString("CURRENCY_X")); //CURRENCY
            SHIPPING_VIA    .setText(data.getString("SHIPPING_VIA")); //SHIPPING_VIA
            SHIPPING_VIA_X  .setText(data.getString("SHIPPING_VIA_X")); //SHIPPING_VIA_X
            BANK_NO         .setText(data.getString("BANK_NO")); //BANK_NO
            BANK_NO_X       .setText(data.getString("BANK_NO_X")); //BANK_NO_X
            ACCOUNT_NO      .setText(data.getString("ACCOUNT_NO")); //ACCOUNT_NO
            COPY            .setText(data.getString("COPY")); //COPY
            STATUS          .setText(data.getString("STATUS")); //STATUS
            STATUS_X        .setText(data.getString("STATUS_X")); //STATUS_X
            STATUS_NOTE     .setText(data.getString("STATUS_NOTE")); //STATUS_NOTE
            CHANGE_REASON   .setText(data.getString("CHANGE_REASON")); //CHANGE_REASON
            SHIPPING_TO     .setText(data.getString("SHIPPING_TO")); //SHIPPING_TO
            PAYMENT_TYPE    .setText(data.getString("PAYMENT_TYPE")); //PAYMENT_TYPE
            PAYMENT_TYPE_X  .setText(data.getString("PAYMENT_TYPE_X")); //PAYMENT_TYPE_X
            PAYMENT_COND    .setText(data.getString("PAYMENT_COND")); //PAYMENT_COND
            PAYMENT_COND_X  .setText(data.getString("PAYMENT_COND_X")); //PAYMENT_COND_X
            PAYMENT_TIME    .setText(data.getString("PAYMENT_TIME")); //PAYMENT_TIME
            PAYMENT_TIME_X  .setText(data.getString("PAYMENT_TIME_X")); //PAYMENT_TIME_X
            TERMS_OF_TRADE  .setText(data.getString("TERMS_OF_TRADE")); //TERMS_OF_TRADE
            TERMS_OF_TRADE_X.setText(data.getString("TERMS_OF_TRADE_X")); //TERMS_OF_TRADE_X
            TAX_TYPE        .setText(data.getString("TAX_TYPE")); //TAX_TYPE
            TAX_TYPE_X      .setText(data.getString("TAX_TYPE_X")); //TAX_TYPE_X
            DELIVERY        .setText(data.getString("DELIVERY")); //DELIVERY
            DELIVERY_DAYS   .setText(data.getString("DELIVERY_DAYS")); //DELIVERY_DAYS
            SHIP_CONTACT    .setText(data.getString("SHIP_CONTACT")); //SHIP_CONTACT

            //注意: M1_COUNT 是用來暫放 M1 Detail 筆數
            M1_COUNT        .setText(data.getString("M1_COUNT")); //M1_COUNT
            b2.setText("Detail"+" ( "+data.getString("M1_COUNT")+" ) ");//M1_COUNT

            //--------------------------------------------------------
            //注意:下面這一段處理 picker , 會複寫 前面的 程式碼
            //Beg
            //--------------------------------------------------------
            CURRENCY        .setTag(data.getString("CURRENCY")); //代號
            CURRENCY        .setText(data.getString("CURRENCY_X")); //名稱
            SHIPPING_VIA    .setTag(data.getString("SHIPPING_VIA")); //代號
            SHIPPING_VIA    .setText(data.getString("SHIPPING_VIA_X")); //名稱
          //BANK_NO         .setTag (data.getString("BANK_NO"         )); //代號
          //BANK_NO         .setText(data.getString("BANK_NO_X"       )); //名稱
            STATUS          .setTag (data.getString("STATUS"          )); //代號
            STATUS          .setText(data.getString("STATUS_X"        )); //名稱
            PAYMENT_TYPE    .setTag (data.getString("PAYMENT_TYPE"    )); //代號
            PAYMENT_TYPE    .setText(data.getString("PAYMENT_TYPE_X"  )); //名稱
            PAYMENT_COND    .setTag (data.getString("PAYMENT_COND"    )); //代號
            PAYMENT_COND    .setText(data.getString("PAYMENT_COND_X"  )); //名稱
            PAYMENT_TIME    .setTag (data.getString("PAYMENT_TIME"    )); //代號
            PAYMENT_TIME    .setText(data.getString("PAYMENT_TIME_X"  )); //名稱
            TERMS_OF_TRADE  .setTag (data.getString("TERMS_OF_TRADE"  )); //代號
            TERMS_OF_TRADE  .setText(data.getString("TERMS_OF_TRADE_X")); //名稱
            TAX_TYPE        .setTag (data.getString("TAX_TYPE"        )); //代號
            TAX_TYPE        .setText(data.getString("TAX_TYPE_X"      )); //名稱
            //--------------------------------------------------------
            //End
            //--------------------------------------------------------

			if (btnEdit.getTag().equals("N")) {
				showDialog("Permission Denied",
						"Sorry, you don't have the permission to edit table.");
				return;
			}

			//20160107 : 這一段似乎是多餘的, 先 remark
			//20160112 : 本段還原
			btnEdit   .setVisibility(View.GONE);
			btnSave   .setVisibility(View.GONE);
			btnCancel .setVisibility(View.GONE);
			btnChange .setVisibility(View.GONE);
			btnConfirm.setVisibility(View.GONE);
			btnPdf    .setVisibility(View.GONE);

			if (btnChange.getTag().equals("Y")) {
				btnEdit   .setVisibility(View.VISIBLE);
				btnPdf    .setVisibility(View.VISIBLE);
			} else {
				btnEdit   .setVisibility(View.VISIBLE);
				btnConfirm.setVisibility(View.VISIBLE);
			}

			if (bundle.getString("func") == null) {
                //N/A
			}
			else{
				//因為非同步讀取資料的關係, 這一段必須放在 load data,
				//而且做完後要將 bundle 的 func 參數刪除, 以免被重覆執行
				if (bundle.getString("func").toString()=="newQT1") {

					bundle.remove("func");//執行過一次馬上移除,避免被重複執行

					btnEdit.setVisibility(View.GONE);
					btnSave.setVisibility(View.GONE);
					btnCancel.setVisibility(View.GONE);
					btnChange.setVisibility(View.GONE);
					btnConfirm.setVisibility(View.GONE);
					btnPdf.setVisibility(View.GONE);

					btnSave.setVisibility(View.VISIBLE);
					btnCancel.setVisibility(View.VISIBLE);
				}

			}


			// xa593(get Qt Type 1~7) =>畫面顯示哪一個TAB的辨識碼
			//setLayoutUI(Integer.parseInt(xa593));

			// Package Info
			//initTab2(mView);
			/*
			 * queryData((String) getWebServiceUrl() + "getQT2",
			 * getQT2(QT_TYPE, QT_NO), new IDataReceiveListener() { public
			 * void onReceiveData(Object obj) { loadData2(obj); } });
			*/

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * get webservice data　(getQT2 =>Package Information, Package Infor...)
	 * 
	 * @param obj
	 */
	private void loadData2(Object obj) {

		try {
			JSONObject jsonObject=new JSONObject((String) obj);
			if(jsonObject.getString("success").toString().equals("false"))
			{
				showDialog(jsonObject.getString("remark").toString());
				return ;
			}
			setQtItems(new JSONObject((String) obj));
			//20160112 : 這兩行 暫時還原
            if (qtItems2.size() == 0 && page > 1)
                page--;
			adapter2.notifyDataSetChanged();
			mPullDownView.notifyDidLoad();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			// Toast.makeText(NavbarHomeActivity.this,"recevie erroe:"+e.toString(),
			// Toast.LENGTH_SHORT).show();
		}


        /*
		try {
			JSONObject responeData = new JSONObject((String) obj);
			// 如果不是成功的呼叫，則返回
			if (!responeData.getString("success").equals("true")) {
				showDialog("error", responeData.getString("remark"));
				return;
			}
			JSONObject data = responeData.getJSONObject("data");
			btnEdit.setTag(data.getString("editable"));
			btnChange.setTag(data.getString("CONFIRM_CODE"));
			String QT_TYPE = data.getString("QT_TYPE");
			String QT_NO = data.getString("QT_NO");
			VERSION = data.getString("VERSION");
			xa593 = data.getString("xa593");
			// checkbox
			if (data.getString("xa092").equals("Y"))
				xa092.setChecked(true);
			if (data.getString("xa093").equals("Y"))
				xa093.setChecked(true);
			if (data.getString("xa087").equals("Y"))
				xa087.setChecked(true);
			if (data.getString("xa088").equals("Y"))
				xa088.setChecked(true);
			if (data.getString("xa089").equals("Y"))
				xa089.setChecked(true);
			if (data.getString("xa090").equals("Y"))
				xa090.setChecked(true);
			if (data.getString("xa094").equals("Y"))
				xa094.setChecked(true);
			if (data.getString("xa584").equals("Y"))
				xa584.setChecked(true);
			if (data.getString("xa585").equals("Y"))
				xa585.setChecked(true);
			if (data.getString("xa586").equals("Y"))
				xa586.setChecked(true);
			// edittext
			xa015.setText(data.getString("xa015"));
			xa091.setText(data.getString("xa091"));
			xa017.setText(data.getString("xa017"));
			xa016.setText(data.getString("xa016"));
			// xa518.setText(data.getString("xa518"));
			// xa104.setText(data.getString("xa104"));
			xa020.setText(data.getString("xa020"));
			xa021.setText(data.getString("xa021"));
			xa022.setText(data.getString("xa022"));
			xa023.setText(data.getString("xa023"));
			xa024.setText(data.getString("xa024"));
			xa025.setText(data.getString("xa025"));
			xa105.setText(data.getString("xa105"));
			xa106.setText(data.getString("xa106"));
			xa544.setText(data.getString("xa544text"));
			xa544.setTag(data.getString("xa544"));
			// checkbox
			if (data.getString("xa028").equals("Y"))
				xa028.setChecked(true);
			if (data.getString("xa029").equals("Y"))
				xa029.setChecked(true);
			if (data.getString("xa048").equals("Y"))
				xa048.setChecked(true);
			// edittext
			xa046.setText(data.getString("xa046"));
			xa047.setText(data.getString("xa047"));
			xa031.setText(data.getString("xa031"));
			xa130.setText(data.getString("xa130"));
			xa111.setText(data.getString("xa111"));
			// checkbox
			if (data.getString("xa033").equals("Y"))
				xa033.setChecked(true);
			if (data.getString("xa034").equals("Y"))
				xa034.setChecked(true);
			if (data.getString("xa598").equals("Y"))
				xa598.setChecked(true);
			if (data.getString("xa599").equals("Y"))
				xa599.setChecked(true);
			if (data.getString("xa59A").equals("Y"))
				xa59A.setChecked(true);
			if (data.getString("xa035").equals("Y"))
				xa035.setChecked(true);
			if (data.getString("xa112").equals("Y"))
				xa112.setChecked(true);
			if (data.getString("xa113").equals("Y"))
				xa113.setChecked(true);
			if (data.getString("xa036").equals("Y"))
				xa036Y.setChecked(true);
			if (data.getString("xa036").equals("N"))
				xa036N.setChecked(true);
			if (data.getString("xa116").equals("Y"))
				xa116.setChecked(true);
			if (data.getString("xa117").equals("Y"))
				xa117.setChecked(true);
			// edittext
			xa104.setText(data.getString("xa104text"));
			xa104.setTag(data.getString("xa104"));
			xa114.setText(data.getString("xa114"));
			xa115.setText(data.getString("xa115"));
			xa59S.setText(data.getString("xa59stext"));
			xa59S.setTag(data.getString("xa59s"));
			xa59T.setText(data.getString("xa59t"));
			xa107.setText(data.getString("xa107text"));
			xa108.setText(data.getString("xa108text"));
			xa109.setText(data.getString("xa109text"));
			xa110.setText(data.getString("xa110text"));
			xa107.setTag(data.getString("xa107"));
			xa108.setTag(data.getString("xa108"));
			xa109.setTag(data.getString("xa109"));
			xa110.setTag(data.getString("xa110"));
			// if(mApplication.size()==0){
			// loadAppicationData();
			// }
		*/
			/*
			 * queryData((String) getWebServiceUrl() + "getQT3",
			 * getQT3(QT_TYPE, QT_NO), new IDataReceiveListener() { public void
			 * onReceiveData(Object obj) { loadData3(obj); } });
			 */
        /*
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        */
	}

	private void setQtItems(JSONObject object) throws JSONException {

		JSONArray array = object.getJSONArray("data");
		//navMenuIcons = getResources().obtainTypedArray(R.array.qpqp_list_icons);
		int icon;
		// 如果回傳資料大於零，而且頁數仍是1，則清空舊資料
		//if (array.length() > 0 && page == 1) {
		//	qtItems2.clear();
		//}

        //20160112 : 修改如下
        // 如果回頁數仍是1，則清空舊資料
        if (page == 1) {
            qtItems2.clear();
        }

		int x = array.length();
		String s = Integer.toString(x);
		//if (array.length() > 0
		b2.setText("Detail"+" ( "+ s +" ) ");//M1_COUNT
		//String stringSum = Integer.toString(i);
		//sum_et.setText(stringSum);

		// msgItems = new ArrayList<MsgItem>();
		for (int i = 0; i < array.length(); i++) {
			JSONObject jsonObject = array.getJSONObject(i);
			//String qtno = String.format("%s-%s",
			//		jsonObject.getString("QT_TYPE"),
			//		jsonObject.getString("QT_NO")
			//String sQT_SEQ = jsonObject.getString("QT_SEQ");
			//);
			//if (jsonObject.getString("CONFIRM_CODE").equals("Y"))
			//	icon = navMenuIcons.getResourceId(0, -1);
			//else
			//	icon = navMenuIcons.getResourceId(1, -1);
			//String status=jsonObject.getString("status");
			qtItems2.add(new QtItem2
						   (
						     jsonObject.getString("M1_QT_TYPE" )
							,jsonObject.getString("M1_QT_NO"   )
							,jsonObject.getString("M1_QT_SEQ"  )
							,jsonObject.getString("AP_TYPE"    )
							,jsonObject.getString("AP_NO"      )
							,jsonObject.getString("DRAWING_REF")
							,jsonObject.getString("DESCRIPTION")
							,jsonObject.getString("APQP_NO"    )
					       )
			            );



		}

		//更新畫面 Detail 筆數 Detail(xx)
		b2.setText("Detail" + " ( " + String.valueOf(array.length()) + " ) ");//M1_COUNT

		// Recycle the typed array
		//20151211 : 暫時 remark
		//navMenuIcons.recycle();

	}


	private void loadPoPLGATestTypeData(final View v) {
		JSONObject jsonObject = new JSONObject();
		JSONObject data = new JSONObject();

		try {

			data.accumulate("pickerListType", "PoPLGATest");
			jsonObject.accumulate("userid", getLoginUser());
			jsonObject.accumulate("WWID", "13145774WWGlobal999988picklist999");
			jsonObject.accumulate("data", data);
			queryData((String) super.getWebServiceUrl() + "pickerlist",
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
									mPoPLGATestType.add(text.getString(i));
									mPoPLGATestTypeValue.add(value.getString(i));
								}
								if (v != null) {
									showPoPLGATestTypeDialog(v);
								}
								// showApplicationDialog(mView);
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

	private void loadApplicationData(final View v) {
		JSONObject jsonObject = new JSONObject();
		JSONObject data = new JSONObject();

		try {

			data.accumulate("pickerListType", "2Application");
			jsonObject.accumulate("userid", getLoginUser());
			jsonObject.accumulate("WWID", "13145774WWGlobal999988picklist999");
			jsonObject.accumulate("data", data);
			queryData((String) super.getWebServiceUrl() + "pickerlist",
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
									mApplication.add(text.getString(i));
									mApplicationValue.add(value.getString(i));
								}
								if (v != null) {
									showApplicationDialog(v);
								}
								// showApplicationDialog(mView);
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

	private void loadDocNeededData(final View v) {
		JSONObject jsonObject = new JSONObject();
		JSONObject data = new JSONObject();

		try {

			data.accumulate("pickerListType", "DocNeeded");
			jsonObject.accumulate("userid", getLoginUser());
			jsonObject.accumulate("WWID", "13145774WWGlobal999988picklist999");
			jsonObject.accumulate("data", data);
			queryData((String) super.getWebServiceUrl() + "pickerlist",
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
									mDocNeeded.add(text.getString(i));
									mDocNeededValue.add(value.getString(i));
								}
								if (v != null) {
									showDocNeededDialog(v);
								}
								// showApplicationDialog(mView);
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

	private void loadHandlerManuData(final View v) {
		JSONObject jsonObject = new JSONObject();
		JSONObject data = new JSONObject();

		try {

			data.accumulate("pickerListType", "3Handlermanufacturer");
			jsonObject.accumulate("userid", getLoginUser());
			jsonObject.accumulate("WWID", "13145774WWGlobal999988picklist999");
			jsonObject.accumulate("data", data);
			queryData((String) super.getWebServiceUrl() + "pickerlist",
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
									mHandlerManu.add(text.getString(i));
									mHandlerManuValue.add(value.getString(i));
								}
								if (v != null) {
									showHandlerManuDialog(v);
								}
								// showApplicationDialog(mView);
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

	private void loadHandlerModelData(final View v) {
		JSONObject jsonObject = new JSONObject();
		JSONObject data = new JSONObject();

		try {

			data.accumulate("pickerListType", "3Handlermodel");
			jsonObject.accumulate("userid", getLoginUser());
			jsonObject.accumulate("WWID", "13145774WWGlobal999988picklist999");
			jsonObject.accumulate("data", data);
			queryData((String) super.getWebServiceUrl() + "pickerlist",
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
									mHandlerModel.add(text.getString(i));
									mHandlerModelValue.add(value.getString(i));
								}
								if (v != null) {
									showHandlerModelDialog(v);
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

	private void loadTesterManuData(final View v) {
		JSONObject jsonObject = new JSONObject();
		JSONObject data = new JSONObject();

		try {

			data.accumulate("pickerListType", "3Testermanufacturer");
			jsonObject.accumulate("userid", getLoginUser());
			jsonObject.accumulate("WWID", "13145774WWGlobal999988picklist999");
			jsonObject.accumulate("data", data);
			queryData((String) super.getWebServiceUrl() + "pickerlist",
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
									mTesterManu.add(text.getString(i));
									mTesterManuValue.add(value.getString(i));
								}
								if (v != null) {
									showTesterManuDialog(v);
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

	private void loadTesterModelData(final View v) {
		JSONObject jsonObject = new JSONObject();
		JSONObject data = new JSONObject();

		try {

			data.accumulate("pickerListType", "3Testermodel");
			jsonObject.accumulate("userid", getLoginUser());
			jsonObject.accumulate("WWID", "13145774WWGlobal999988picklist999");
			jsonObject.accumulate("data", data);
			queryData((String) super.getWebServiceUrl() + "pickerlist",
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
									mTesterModel.add(text.getString(i));
									mTesterModelValue.add(value.getString(i));
								}
								if (v != null) {
									showTesterModelDialog(v);
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

	private void loadDigitalAppStdData(final View v) {
		JSONObject jsonObject = new JSONObject();
		JSONObject data = new JSONObject();

		try {

			data.accumulate("pickerListType", "DigitalAppStd");
			jsonObject.accumulate("userid", getLoginUser());
			jsonObject.accumulate("WWID", "13145774WWGlobal999988picklist999");
			jsonObject.accumulate("data", data);
			queryData((String) super.getWebServiceUrl() + "pickerlist",
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
									mDigitalAppStd.add(text.getString(i));
									mDigitalAppStdValue.add(value.getString(i));
								}
								if (v != null) {
									showDigitalAppStdDialog(v);
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

	private void loadDigitalClassData(final View v) {
		JSONObject jsonObject = new JSONObject();
		JSONObject data = new JSONObject();

		try {

			data.accumulate("pickerListType", "DigitalClass");
			jsonObject.accumulate("userid", getLoginUser());
			jsonObject.accumulate("WWID", "13145774WWGlobal999988picklist999");
			jsonObject.accumulate("data", data);
			queryData((String) super.getWebServiceUrl() + "pickerlist",
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
									mDigitalClass.add(text.getString(i));
									mDigitalClassValue.add(value.getString(i));
								}
								if (v != null) {
									showDigitalClassDialog(v);
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

	private void loadAnalogAppStdData(final View v) {
		JSONObject jsonObject = new JSONObject();
		JSONObject data = new JSONObject();

		try {

			data.accumulate("pickerListType", "AnalogAppStd");
			jsonObject.accumulate("userid", getLoginUser());
			jsonObject.accumulate("WWID", "13145774WWGlobal999988picklist999");
			jsonObject.accumulate("data", data);
			queryData((String) super.getWebServiceUrl() + "pickerlist",
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
									mAnalogAppStd.add(text.getString(i));
									mAnalogAppStdValue.add(value.getString(i));
								}
								if (v != null) {
									showAnalogAppStdDialog(v);
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

	private void loadAnalogClassData(final View v) {
		JSONObject jsonObject = new JSONObject();
		JSONObject data = new JSONObject();

		try {

			data.accumulate("pickerListType", "AnalogClass");
			jsonObject.accumulate("userid", getLoginUser());
			jsonObject.accumulate("WWID", "13145774WWGlobal999988picklist999");
			jsonObject.accumulate("data", data);
			queryData((String) super.getWebServiceUrl() + "pickerlist",
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
									mAnalogClass.add(text.getString(i));
									mAnalogClassValue.add(value.getString(i));
								}
								if (v != null) {
									showAnalogClassDialog(v);
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

	private void loadDevicePadData(final View v) {
		JSONObject jsonObject = new JSONObject();
		JSONObject data = new JSONObject();

		try {

			data.accumulate("pickerListType", "DevicePad");
			jsonObject.accumulate("userid", getLoginUser());
			jsonObject.accumulate("WWID", "13145774WWGlobal999988picklist999");
			jsonObject.accumulate("data", data);
			queryData((String) super.getWebServiceUrl() + "pickerlist",
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
									mDevicePad.add(text.getString(i));
									mDevicePadValue.add(value.getString(i));
								}
								if (v != null) {
									showDevicePadDialog(v);
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

	private void loadEFPlugData() {
		JSONObject jsonObject = new JSONObject();
		JSONObject data = new JSONObject();

		try {

			data.accumulate("pickerListType", "EFluxpowerplug");
			jsonObject.accumulate("userid", getLoginUser());
			jsonObject.accumulate("WWID", "13145774WWGlobal999988picklist999");
			jsonObject.accumulate("data", data);
			queryData((String) super.getWebServiceUrl() + "pickerlist",
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
									mPlugType.add(text.getString(i));
									mPlugTypeValue.add(value.getString(i));
								}
								// showApplicationDialog(mView);
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

	//
	/**
	 * Function I 初始化UI
	 * 
	 * @param view
	 */
	private void initUI(View view) {
		btnEdit    = (Button) view.findViewById(R.id.btn_qt_edit);
		btnSave    = (Button) view.findViewById(R.id.btn_qt_save);
		btnCancel  = (Button) view.findViewById(R.id.btn_qt_cancel);
		btnChange  = (Button) view.findViewById(R.id.btn_qt_change);
		btnConfirm = (Button) view.findViewById(R.id.btn_qt_confirm);
		btnPdf     = (Button) view.findViewById(R.id.btn_qt_pdf);
		btnAdd2    = (Button) view.findViewById(R.id.btn_qt_add2);

		//20151210 by daniel
		//Beg
		b1 = (Button) view.findViewById(R.id.b1);
		b2 = (Button) view.findViewById(R.id.b2);

		b1.setText("Customer");
		b2.setText("Detail");

		b2.setTag(0);

		b1.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				//20160107 : 改到下面執行
				b1_onClick(v);

//				//20151211 : 改變顏色
//				r1.setBackgroundColor(getResources().getColor(R.color.lightgreen));
//				r2.setBackgroundColor(getResources().getColor(R.color.white));
//				vwSubTitle.setText(b1.getText());
//
//				//if (tabbar != null)
//				//	tabbar.setVisibility(RelativeLayout.GONE);
//
//				if (tab2 != null
//                 && tab2.getVisibility() == RelativeLayout.VISIBLE) {
//
//                    tab2.setVisibility(RelativeLayout.GONE);
//
//                    btnEdit   .setVisibility(RelativeLayout.VISIBLE);
//                    btnAdd2   .setVisibility(RelativeLayout.GONE);
//
//                    btnSave   .setVisibility(RelativeLayout.GONE);
//                    btnChange .setVisibility(RelativeLayout.GONE);
//                    btnConfirm.setVisibility(RelativeLayout.GONE);
//
//                    queryData();//重讀資料
//
//                }
//
//				tab1.setVisibility(RelativeLayout.VISIBLE);
//				if (cmdbar != null && !cmdbar.isShown()) {
//					cmdbar.setVisibility(RelativeLayout.VISIBLE);
//				}
			}
		});
		b2.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {

				//btnSave 顯示時 不可切換 到 QT2
				if (btnSave.getVisibility() == View.VISIBLE) {
					return;
				}

				//20151211 : 改變顏色
				r1.setBackgroundColor(getResources().getColor(R.color.white));
				r2.setBackgroundColor(getResources().getColor(R.color.lightgreen));

				int tag = (Integer) v.getTag();
				//vwSubTitle.setText(b2.getText()+"("+M1_COUNT+")");
                vwSubTitle.setText("Detail");
                //b2.setText("Detail" + "("+M1_COUNT+")");

				//if (tabbar != null)
				//	tabbar.setVisibility(RelativeLayout.GONE);
				if (tab1 != null
				 && tab1.getVisibility() == RelativeLayout.VISIBLE) {

                    tab1.setVisibility(RelativeLayout.GONE);

					btnEdit   .setVisibility(View.GONE);
					btnSave   .setVisibility(View.GONE);
					btnCancel .setVisibility(View.GONE);
					btnChange .setVisibility(View.GONE);
					btnConfirm.setVisibility(View.GONE);
					btnPdf    .setVisibility(View.GONE);

					btnAdd2.setVisibility(View.GONE);

					//20160115
					if (btnChange.getTag().equals("Y")) {
						//btnAdd2.setVisibility(View.VISIBLE);
					} else {
						btnAdd2.setVisibility(View.VISIBLE);
					}

					//20151224 : 換到此頁時無條件重新讀取, 此判斷 remark
                    //if (tag != 2) {
                        queryData((String) getWebServiceUrl() + "queryQT2",
                                queryQT2(QT_TYPE, QT_NO),
                                new IDataReceiveListener() {
                                    public void onReceiveData(Object obj) {
                                        loadData2(obj);
                                        b2.setTag(2);
                                    }
                                });

                    //}
                }

				tab2.setVisibility(RelativeLayout.VISIBLE);

				//if (cmdbar != null && !cmdbar.isShown()) {
				//	cmdbar.setVisibility(RelativeLayout.VISIBLE);
				//}
			}
		});
		//End


		/**
		 * 
		 * Edit的button,點擊觸發的action
		 */
		btnEdit.setOnClickListener(new OnClickListener() {
			@Override
			/**
			 * Screenshot_20150410_12.jpg
			 */
			public void onClick(View v) {

				if (btnEdit.getTag().equals("N")) {
					showDialog("Permission Denied",
							"Sorry, you don't have the permission to edit table.");
					return;
				}
				btnEdit   .setVisibility(View.GONE);
				btnSave   .setVisibility(View.GONE);
				btnCancel .setVisibility(View.GONE);
				btnChange .setVisibility(View.GONE);
				btnConfirm.setVisibility(View.GONE);
				btnPdf    .setVisibility(View.GONE);

				btnAdd2   .setVisibility(View.GONE);

				if (btnChange.getTag().equals("Y")) {
					btnChange.setVisibility(View.VISIBLE);
					btnCancel.setVisibility(View.VISIBLE);
				} else {
					btnSave.setVisibility(View.VISIBLE);
					btnCancel.setVisibility(View.VISIBLE);
				}
			}
		});

		/**
		 * Save的button,點擊觸發的action
		 */
		btnSave.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				// No.15041501
				isLoading = 1;
				launchRingDialog(null);

				if (tab1.getVisibility() == View.VISIBLE) {
					saveData1("Save");

				//} else if (tab2.getVisibility() == View.VISIBLE) {
				//	saveData2("Save");
				}
				btnEdit   .setVisibility(View.GONE);
				btnSave   .setVisibility(View.GONE);
				btnCancel .setVisibility(View.GONE);
				btnChange .setVisibility(View.GONE);
				btnConfirm.setVisibility(View.GONE);
				btnPdf    .setVisibility(View.GONE);

				btnAdd2   .setVisibility(View.GONE);

				if (btnChange.getTag().equals("Y")) {
					btnEdit   .setVisibility(View.VISIBLE);
					btnPdf    .setVisibility(View.VISIBLE);
				} else {
					btnEdit   .setVisibility(View.VISIBLE);
					btnConfirm.setVisibility(View.VISIBLE);
				}


			}
		});

		/**
		 * Cancel的button,點擊觸發的action
		 */
		btnCancel.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				// No.15041501
				isLoading = 1;
				launchRingDialog(null);

				//20151215 : 注意:寫到 update 資料時這一段要修改
				//if (tab3.getVisibility() == View.VISIBLE) {
				//    saveData3("Save");
				//
				//} else if (tab4.getVisibility() == View.VISIBLE) {
				//    saveData2("Save");
				//}

				btnEdit   .setVisibility(View.GONE);
				btnSave   .setVisibility(View.GONE);
				btnCancel .setVisibility(View.GONE);
				btnChange .setVisibility(View.GONE);
				btnConfirm.setVisibility(View.GONE);
				btnPdf    .setVisibility(View.GONE);

				btnAdd2   .setVisibility(View.GONE);

				if (btnChange.getTag().equals("Y")) {
					btnEdit   .setVisibility(View.VISIBLE);
					btnPdf    .setVisibility(View.VISIBLE);
				} else {
					btnEdit   .setVisibility(View.VISIBLE);
					btnConfirm.setVisibility(View.VISIBLE);
				}

				queryData();

			}
		});

		/**
		 * Confirm的button,點擊觸發的action
		 */
		btnConfirm.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				// No.15041501
				isLoading = 1;
				launchRingDialog(null);
				if (tab1.getVisibility() == View.VISIBLE) {
					saveData1("Confirm");

				//} else if (tab2.getVisibility() == View.VISIBLE) {
				//	saveData2("Confirm");
				}
				btnEdit   .setVisibility(View.GONE);
				btnSave   .setVisibility(View.GONE);
				btnCancel .setVisibility(View.GONE);
				btnChange .setVisibility(View.GONE);
				btnConfirm.setVisibility(View.GONE);
				btnPdf    .setVisibility(View.GONE);

				btnAdd2   .setVisibility(View.GONE);

//				if (btnChange.getTag().equals("Y")) {
//					btnEdit   .setVisibility(View.VISIBLE);
//					btnPdf    .setVisibility(View.VISIBLE);
//				} else {
//					btnEdit   .setVisibility(View.VISIBLE);
//					btnConfirm.setVisibility(View.VISIBLE);
//				}

				//20160115 : 確認後一定是 Edit/PDF 兩個 button
				btnEdit   .setVisibility(View.VISIBLE);
				btnPdf    .setVisibility(View.VISIBLE);
			}
		});

		/**
		 * Change的button,點擊觸發的action
		 */
		btnChange.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				// No.15041501
				isLoading = 1;
				launchRingDialog(null);
				if (tab1.getVisibility() == View.VISIBLE) {
					saveData1("Change");

				//} else if (tab2.getVisibility() == View.VISIBLE) {
				//	saveData2("Change");
				}
				btnEdit   .setVisibility(View.GONE);
				btnSave   .setVisibility(View.GONE);
				btnCancel .setVisibility(View.GONE);
				btnChange .setVisibility(View.GONE);
				btnConfirm.setVisibility(View.GONE);
				btnPdf    .setVisibility(View.GONE);

				btnAdd2   .setVisibility(View.GONE);

				if (btnChange.getTag().equals("Y")) {
					btnEdit   .setVisibility(View.VISIBLE);
					btnPdf    .setVisibility(View.VISIBLE);
				} else {
					btnEdit   .setVisibility(View.VISIBLE);
					btnConfirm.setVisibility(View.VISIBLE);
				}

				//20160115 : Change 後一定是 Edit/PDF 兩個 button
				btnEdit.setVisibility(View.VISIBLE);
				btnPdf .setVisibility(View.VISIBLE);

			}
		});

		/**
		 * Change的button,點擊觸發的action
		 */
		btnPdf.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				Bundle bundle2 = new Bundle();
				bundle2.putString("QT_TYPE" , QT_TYPE);
				bundle2.putString("QT_NO"   , QT_NO  );
				//bundle2.putString("VERSION" , VERSION);

				//20160112
				callQtPdfActivity(bundle2);

			}
		});


		/**
		 * add2 的button,點擊觸發的action
		 */
		btnAdd2.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				// No.15041501
				isLoading = 1;
				launchRingDialog(null);

				if (tab2.getVisibility() == View.VISIBLE) {
					//saveData("Save");
					addNewQT2("Save");

					//20151224: 下面這段程式碼移動到 addNewQT2
					/*
					// TODO Auto-generated method stub
					Bundle bundle2 = new Bundle();
					bundle2.putString("M1_QT_TYPE" , QT_TYPE);
					bundle2.putString("M1_QT_NO"   , QT_NO);
					bundle2.putString("M1_QT_SEQ"  , "0001");
					bundle2.putString("AP_TYPE"    , "");
					bundle2.putString("AP_NO"      , "");
					bundle2.putString("DRAWING_REF", "");
					bundle2.putString("DESCRIPTION", "");
					bundle2.putString("APQP_NO"    , "");
					bundle2.putString("action"    , "addqt2");

					// 要跟其他Fragment溝通,需要用getActivity()回到Activity
					//((MainActivity) getActivity()).callQtDataActivity3(bundle2);

					//20151210暫時 remark
					callQt3DataActivity(bundle2);
                    */
				}
				//v.setVisibility(View.GONE);
				//btnConfirm.setVisibility(View.GONE);
				//btnEdit.setVisibility(View.VISIBLE);
			}
		});


		// Action bar(Back)
		Button btnReturnSale = (Button) view.findViewById(R.id.btnReturnSale);

		// Action bar(Search =>Back)
		Button btnReturnQtSearch = (Button) view
				.findViewById(R.id.btnReturnApqpSearch);

		/**
		 * Action bar(Back)點擊觸發的action
		 */
		btnReturnSale.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
					closeFragment();
			}
		});




		/**
		 * Action bar(Back)點擊觸發的action=>Back to List
		 */

		btnReturnQtSearch.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				// 執行父Activity的method=>onCancelQtClick,Add
				// QT成功後,進入新單的詳情頁,按下回列表,需呼叫該程式
				//((MainActivity) getActivity()).onCancelQtClick(v);


				closeFragment();

			}
		});

		// 判斷目前的頁面是否為搜尋結果
		/*if (this.parent == fragmentManager
				.findFragmentByTag("qt_search_result")) {
			if (btnReturnSale != null)
				btnReturnSale.setVisibility(View.GONE);
			if (btnReturnQtSearch != null) {
				btnReturnQtSearch.setVisibility(View.VISIBLE);
				btnReturnQtSearch.setText("Back");
			}
		}*/

		initTab1(view);// Customer Info
		initTab2(view);// Detail

	}

	private void initTab1(View view) {
        QT_DATE          = (EditText) view.findViewById(R.id.ed_QT_DATE         );
        CREATOR          = (EditText) view.findViewById(R.id.ed_CREATOR         );
        CONFIRM_DATE     = (EditText) view.findViewById(R.id.ed_CONFIRM_DATE    );
        CONFIRM_USER_ID  = (EditText) view.findViewById(R.id.ed_CONFIRM_USER_ID );
        QT_NO_MAIN       = (EditText) view.findViewById(R.id.ed_QT_NO_MAIN      );
        QT_SALES         = (EditText) view.findViewById(R.id.ed_QT_SALES        );
        CUST_NO          = (EditText) view.findViewById(R.id.ed_CUST_NO         );
        CUST_NO_X        = (EditText) view.findViewById(R.id.ed_CUST_NO_X       );
        CUST_NO_Y        = (EditText) view.findViewById(R.id.ed_CUST_NO_Y       );
        CUST_CONTACT     = (EditText) view.findViewById(R.id.ed_CUST_CONTACT    );
        TEL_NO           = (EditText) view.findViewById(R.id.ed_TEL_NO          );
        REMARK           = (EditText) view.findViewById(R.id.ed_REMARK          );
        CURRENCY         = (EditText) view.findViewById(R.id.ed_CURRENCY        );
        CURRENCY_X       = (EditText) view.findViewById(R.id.ed_CURRENCY_X      );
        SHIPPING_VIA     = (EditText) view.findViewById(R.id.ed_SHIPPING_VIA    );
        SHIPPING_VIA_X   = (EditText) view.findViewById(R.id.ed_SHIPPING_VIA_X  );
        BANK_NO          = (EditText) view.findViewById(R.id.ed_BANK_NO         );
        BANK_NO_X        = (EditText) view.findViewById(R.id.ed_BANK_NO_X       );
        ACCOUNT_NO       = (EditText) view.findViewById(R.id.ed_ACCOUNT_NO      );
        COPY             = (EditText) view.findViewById(R.id.ed_COPY            );
        STATUS           = (EditText) view.findViewById(R.id.ed_STATUS          );
        STATUS_X         = (EditText) view.findViewById(R.id.ed_STATUS_X        );
        STATUS_NOTE      = (EditText) view.findViewById(R.id.ed_STATUS_NOTE     );
        CHANGE_REASON    = (EditText) view.findViewById(R.id.ed_CHANGE_REASON   );
        SHIPPING_TO      = (EditText) view.findViewById(R.id.ed_SHIPPING_TO     );
        PAYMENT_TYPE     = (EditText) view.findViewById(R.id.ed_PAYMENT_TYPE    );
        PAYMENT_TYPE_X   = (EditText) view.findViewById(R.id.ed_PAYMENT_TYPE_X  );
        PAYMENT_COND     = (EditText) view.findViewById(R.id.ed_PAYMENT_COND    );
        PAYMENT_COND_X   = (EditText) view.findViewById(R.id.ed_PAYMENT_COND_X  );
        PAYMENT_TIME     = (EditText) view.findViewById(R.id.ed_PAYMENT_TIME    );
        PAYMENT_TIME_X   = (EditText) view.findViewById(R.id.ed_PAYMENT_TIME_X  );
        TERMS_OF_TRADE   = (EditText) view.findViewById(R.id.ed_TERMS_OF_TRADE  );
        TERMS_OF_TRADE_X = (EditText) view.findViewById(R.id.ed_TERMS_OF_TRADE_X);
        TAX_TYPE         = (EditText) view.findViewById(R.id.ed_TAX_TYPE        );
        TAX_TYPE_X       = (EditText) view.findViewById(R.id.ed_TAX_TYPE_X      );
        DELIVERY         = (EditText) view.findViewById(R.id.ed_DELIVERY        );
        DELIVERY_DAYS    = (EditText) view.findViewById(R.id.ed_DELIVERY_DAYS   );
        SHIP_CONTACT     = (EditText) view.findViewById(R.id.ed_SHIP_CONTACT    );

        //M1 COUNT
        M1_COUNT         = (EditText) view.findViewById(R.id.ed_M1_COUNT        );

		//qt = (TableLayout) view.findViewById(R.id.qt);
		//so = (TableLayout) view.findViewById(R.id.so);
		//po = (TableLayout) view.findViewById(R.id.po);
		// 設定元件鍵盤

        //---------------------------------
		//setupTab1EditKeyboard(view);
		//---------------------------------
        //-----------------------------------------------------------
		// QT_DATE (日期)
		// QT_DATE.setOnEditorActionListener(EditorListener);
        //-----------------------------------------------------------
		QT_DATE.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                QT_DATE.setInputType(InputType.TYPE_NULL); // 關閉軟鍵盤
                return false;
            }

        });
		QT_DATE.setOnFocusChangeListener(new OnFocusChangeListener() {
            public void onFocusChange(View v, boolean hasFocus) {

                // System.out.println("===>Line number: "+new
                // Throwable().getStackTrace()[0].getLineNumber());

                if (hasFocus) {
                    InputMethodManager imm = (InputMethodManager) getActivity()
                            .getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(QT_DATE.getWindowToken(), 0);
                    showDateDialog(v);
                }
            }
        });
        //---------------------------------
        // CUST_NO (開窗-dialog)
        // xa004.setOnEditorActionListener(EditorListener);//Cust NO
        //---------------------------------
        /*
        CUST_NO.setOnTouchListener(new OnTouchListener() {
            @SuppressLint("ClickableViewAccessibility")
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                CUST_NO.setInputType(InputType.TYPE_NULL); // 關閉軟鍵盤
                return false;
            }

        });
        CUST_NO.setOnFocusChangeListener(new OnFocusChangeListener(){
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus){
                    InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(CUST_NO.getWindowToken(), 0);
                    showCustDialog(v);
                }
            }
        });
        */

        CUST_NO.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                CUST_NO.setInputType(InputType.TYPE_NULL); // 關閉軟鍵盤
                return false;
            }

        });

        CUST_NO.setOnFocusChangeListener(new OnFocusChangeListener() {
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(CUST_NO.getWindowToken(), 0);
                    QT_showCustDialog(v);
                }
            }
        });


        //暫時用不到
        //CUST_NO_X.setOnEditorActionListener(EditorListener); // Cust Name
        //setEditTextReadOnly(CUST_NO_X);

        /*
        case ("CURRENCY"):
        sqlCMD = "Select AZI01, AZI01 From AZI_FILE Where 1=1 Order by AZI01";
        break;
        case ("SHIPPING_VIA"):
        sqlCMD = "Select GED01, GED02 From GED_FILE Where 1=1 Order by GED01";
        break;
        case ("BANK_NO"):
        sqlCMD = "Select NMA01, NMA04 From NMA_FILE Where 1=1 Order by NMA01";
        break;
        case ("STATUS"):
        sqlCMD = "Select XD002, XD003 From WF_COPXD Where XD001='AG4' AND XD003 is not NULL Order by XD002";
        break;
        case ("PAYMENT_TYPE"):
        sqlCMD = "Select XD002, XD003 From WF_COPXD Where XD001='A63' AND XD003 is not NULL Order by XD002";
        break;
        case ("PAYMENT_COND"):
        sqlCMD = "Select OAG01, OAG02 From OAG_FILE Where 1=1 Order by OAG01";
        break;
        case ("PAYMENT_TIME"):
        sqlCMD = "Select XD002, XD003 From WF_COPXD Where XD001='A41' AND XD003 is not NULL Order by XD002";
        break;
        case ("TERMS_OF_TRADE"):
        sqlCMD = "Select OAH01, OAH02 From OAH_FILE Where 1=1 Order by OAH01, OAH02";
        break;
        case ("TAX_TYPE"):
        sqlCMD = "Select XD002, XD003 From WF_COPXD Where XD001='AG5' AND XD003 is not NULL Order by XD002";
        break;
        */


        //---------------------------------
        // CURRENCY (Picker - dialog)
        //---------------------------------
        CURRENCY.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                CURRENCY.setInputType(InputType.TYPE_NULL); // 關閉軟鍵盤
                return false;
            }
        });
        CURRENCY.setOnFocusChangeListener(new OnFocusChangeListener() {
            public void onFocusChange(View v, boolean hasFocus) {

                // System.out.println("===>Line number: "+new
                // Throwable().getStackTrace()[0].getLineNumber());

                if (hasFocus) {
                    InputMethodManager imm = (InputMethodManager) getActivity()
                            .getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(CURRENCY.getWindowToken(), 0);

                    // 載入前先清除
                    mPicker_Text.clear();
                    mPicker_Value.clear();
					mPicker_Remark.clear();

                    // 載入
                    if (mPicker_Text.size() == 0) {
                        loadPickerData(v, "CURRENCY");
                    } else {
                        showPickerDialog(v, "CURRENCY");
                    }
                    CURRENCY.clearFocus();
                }
            }
        });
        //---------------------------------
        // SHIPPING_VIA (Picker - dialog)
        //---------------------------------
        SHIPPING_VIA.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                SHIPPING_VIA.setInputType(InputType.TYPE_NULL); // 關閉軟鍵盤
                return false;
            }
        });
        SHIPPING_VIA.setOnFocusChangeListener(new OnFocusChangeListener() {
            public void onFocusChange(View v, boolean hasFocus) {

                // System.out.println("===>Line number: "+new
                // Throwable().getStackTrace()[0].getLineNumber());

                if (hasFocus) {
                    InputMethodManager imm = (InputMethodManager) getActivity()
                            .getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(SHIPPING_VIA.getWindowToken(), 0);

                    // 載入前先清除
                    mPicker_Text.clear();
                    mPicker_Value.clear();
					mPicker_Remark.clear();

                    // 載入
                    if (mPicker_Text.size() == 0) {
                        loadPickerData(v, "SHIPPING_VIA");
                    } else {
                        showPickerDialog(v, "SHIPPING_VIA");
                    }
                    SHIPPING_VIA.clearFocus();
                }
            }
        });
        //---------------------------------
        // BANK_NO (Picker - dialog)
        //---------------------------------
        BANK_NO.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                BANK_NO.setInputType(InputType.TYPE_NULL); // 關閉軟鍵盤
                return false;
            }
        });
        BANK_NO.setOnFocusChangeListener(new OnFocusChangeListener() {
            public void onFocusChange(View v, boolean hasFocus) {

                // System.out.println("===>Line number: "+new
                // Throwable().getStackTrace()[0].getLineNumber());

                if (hasFocus) {
                    InputMethodManager imm = (InputMethodManager) getActivity()
                            .getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(BANK_NO.getWindowToken(), 0);

                    // 載入前先清除
                    mPicker_Text.clear();
                    mPicker_Value.clear();
					mPicker_Remark.clear();

                    // 載入
                    if (mPicker_Text.size() == 0) {
                        loadPickerData(v, "BANK_NO");
                    } else {
                        showPickerDialog(v, "BANK_NO");
                    }
                    BANK_NO.clearFocus();
                }
            }
        });
        //---------------------------------
        // STATUS (Picker - dialog)
        //---------------------------------
        STATUS.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                STATUS.setInputType(InputType.TYPE_NULL); // 關閉軟鍵盤
                return false;
            }
        });
        STATUS.setOnFocusChangeListener(new OnFocusChangeListener() {
            public void onFocusChange(View v, boolean hasFocus) {

                // System.out.println("===>Line number: "+new
                // Throwable().getStackTrace()[0].getLineNumber());

                if (hasFocus) {
                    InputMethodManager imm = (InputMethodManager) getActivity()
                            .getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(STATUS.getWindowToken(), 0);

                    // 載入前先清除
                    mPicker_Text.clear();
                    mPicker_Value.clear();
					mPicker_Remark.clear();

                    // 載入
                    if (mPicker_Text.size() == 0) {
                        loadPickerData(v, "STATUS");
                    } else {
                        showPickerDialog(v, "STATUS");
                    }
                    STATUS.clearFocus();
                }
            }
        });
        //---------------------------------
        // PAYMENT_TYPE (Picker - dialog)
        //---------------------------------
        PAYMENT_TYPE.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                PAYMENT_TYPE.setInputType(InputType.TYPE_NULL); // 關閉軟鍵盤
                return false;
            }
        });
        PAYMENT_TYPE.setOnFocusChangeListener(new OnFocusChangeListener() {
            public void onFocusChange(View v, boolean hasFocus) {

                // System.out.println("===>Line number: "+new
                // Throwable().getStackTrace()[0].getLineNumber());

                if (hasFocus) {
                    InputMethodManager imm = (InputMethodManager) getActivity()
                            .getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(PAYMENT_TYPE.getWindowToken(), 0);

                    // 載入前先清除
                    mPicker_Text.clear();
                    mPicker_Value.clear();
					mPicker_Remark.clear();

                    // 載入
                    if (mPicker_Text.size() == 0) {
                        loadPickerData(v, "PAYMENT_TYPE");
                    } else {
                        showPickerDialog(v, "PAYMENT_TYPE");
                    }
                    PAYMENT_TYPE.clearFocus();
                }
            }
        });
        //---------------------------------
        // PAYMENT_COND (Picker - dialog)
        //---------------------------------
        PAYMENT_COND.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                PAYMENT_COND.setInputType(InputType.TYPE_NULL); // 關閉軟鍵盤
                return false;
            }
        });
        PAYMENT_COND.setOnFocusChangeListener(new OnFocusChangeListener() {
            public void onFocusChange(View v, boolean hasFocus) {

                // System.out.println("===>Line number: "+new
                // Throwable().getStackTrace()[0].getLineNumber());

                if (hasFocus) {
                    InputMethodManager imm = (InputMethodManager) getActivity()
                            .getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(PAYMENT_COND.getWindowToken(), 0);

                    // 載入前先清除
                    mPicker_Text.clear();
                    mPicker_Value.clear();
					mPicker_Remark.clear();

                    // 載入
                    if (mPicker_Text.size() == 0) {
                        loadPickerData(v, "PAYMENT_COND");
                    } else {
                        showPickerDialog(v, "PAYMENT_COND");
                    }
                    PAYMENT_COND.clearFocus();
                }
            }
        });
        //---------------------------------
        // PAYMENT_TIME (Picker - dialog)
        //---------------------------------
        PAYMENT_TIME.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                PAYMENT_TIME.setInputType(InputType.TYPE_NULL); // 關閉軟鍵盤
                return false;
            }
        });
        PAYMENT_TIME.setOnFocusChangeListener(new OnFocusChangeListener() {
            public void onFocusChange(View v, boolean hasFocus) {

                // System.out.println("===>Line number: "+new
                // Throwable().getStackTrace()[0].getLineNumber());

                if (hasFocus) {
                    InputMethodManager imm = (InputMethodManager) getActivity()
                            .getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(PAYMENT_TIME.getWindowToken(), 0);

                    // 載入前先清除
                    mPicker_Text.clear();
                    mPicker_Value.clear();
					mPicker_Remark.clear();

                    // 載入
                    if (mPicker_Text.size() == 0) {
                        loadPickerData(v, "PAYMENT_TIME");
                    } else {
                        showPickerDialog(v, "PAYMENT_TIME");
                    }
                    PAYMENT_TIME.clearFocus();
                }
            }
        });
        //---------------------------------
        // TERMS_OF_TRADE (Picker - dialog)
        //---------------------------------
        TERMS_OF_TRADE.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                TERMS_OF_TRADE.setInputType(InputType.TYPE_NULL); // 關閉軟鍵盤
                return false;
            }
        });
        TERMS_OF_TRADE.setOnFocusChangeListener(new OnFocusChangeListener() {
            public void onFocusChange(View v, boolean hasFocus) {

                // System.out.println("===>Line number: "+new
                // Throwable().getStackTrace()[0].getLineNumber());

                if (hasFocus) {
                    InputMethodManager imm = (InputMethodManager) getActivity()
                            .getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(TERMS_OF_TRADE.getWindowToken(), 0);

                    // 載入前先清除
                    mPicker_Text.clear();
                    mPicker_Value.clear();
					mPicker_Remark.clear();

                    // 載入
                    if (mPicker_Text.size() == 0) {
                        loadPickerData(v, "TERMS_OF_TRADE");
                    } else {
                        showPickerDialog(v, "TERMS_OF_TRADE");
                    }
                    TERMS_OF_TRADE.clearFocus();
                }
            }
        });
        //---------------------------------
        // TAX_TYPE (Picker - dialog)
        //---------------------------------
        TAX_TYPE.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                TAX_TYPE.setInputType(InputType.TYPE_NULL); // 關閉軟鍵盤
                return false;
            }
        });
        TAX_TYPE.setOnFocusChangeListener(new OnFocusChangeListener() {
            public void onFocusChange(View v, boolean hasFocus) {

                // System.out.println("===>Line number: "+new
                // Throwable().getStackTrace()[0].getLineNumber());

                if (hasFocus) {
                    InputMethodManager imm = (InputMethodManager) getActivity()
                            .getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(TAX_TYPE.getWindowToken(), 0);

                    // 載入前先清除
                    mPicker_Text.clear();
                    mPicker_Value.clear();
					mPicker_Remark.clear();

                    // 載入
                    if (mPicker_Text.size() == 0) {
                        loadPickerData(v, "TAX_TYPE");
                    } else {
                        showPickerDialog(v, "TAX_TYPE");
                    }
                    TAX_TYPE.clearFocus();
                }
            }
        });

        //---------------------------------
        // CUST_CONTACT (Picker - dialog)
        //---------------------------------
        // Contact
        CUST_CONTACT.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                CUST_CONTACT.setInputType(InputType.TYPE_NULL); // 關閉軟鍵盤
                return false;
            }

        });
        CUST_CONTACT.setOnFocusChangeListener(new OnFocusChangeListener() {
            public void onFocusChange(View v, boolean hasFocus) {

                // System.out.println("===>Line number: "+new
                // Throwable().getStackTrace()[0].getLineNumber());

                if (hasFocus) {
                    InputMethodManager imm = (InputMethodManager) getActivity()
                            .getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(CUST_CONTACT.getWindowToken(), 0);
                    showContactDialog(v);
                }
            }
        });

	}

    private void loadPickerData(final View v, final String s ) {
        JSONObject jsonObject = new JSONObject();
        JSONObject data = new JSONObject();

        try {

            data.accumulate("pickerListType", s);//s="PAYMENT_TYPE"
            jsonObject.accumulate("userid", getLoginUser());
            jsonObject.accumulate("WWID", "13145774WWGlobal999988picklist999");
            jsonObject.accumulate("data", data);
            queryData((String) super.getWebServiceUrl() + "pickerlist",
                    jsonObject, new IDataReceiveListener() {
                        public void onReceiveData(Object obj) {

                            try {
                                JSONObject jsonObject = new JSONObject(
                                        (String) obj).getJSONObject("data");
                                JSONArray text = jsonObject
                                        .getJSONArray("text");
                                JSONArray value = jsonObject
                                        .getJSONArray("value");
								JSONArray remark = jsonObject
										.getJSONArray("remark");
                                for (int i = 0; i < text.length(); i++) {
                                    mPicker_Text  .add(text  .getString(i));
                                    mPicker_Value .add(value .getString(i));
									mPicker_Remark.add(remark.getString(i));
                                }
                                if (v != null) {
                                    showPickerDialog(v, s);
                                }
                                // showApplicationDialog(mView);
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

    public void showPickerDialog(final View view, final String s) {

        AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity());
        //dialog.setTitle("Handlermanuf...").setIcon(
        dialog.setTitle(s).setIcon(
                android.R.drawable.ic_dialog_info);
        DialogInterface.OnClickListener okListener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface d, int which) {

                // System.out.println("===>Line number: "+new
                // Throwable().getStackTrace()[0].getLineNumber());

                ListView lv = ((AlertDialog) d).getListView();
                Integer selected = (Integer) lv.getTag();
                if (selected != null) {
					if ((EditText) view == BANK_NO){
                        ACCOUNT_NO.setText(mPicker_Text  .get(selected));
                        BANK_NO   .setText(mPicker_Value .get(selected));
						BANK_NO_X .setText(mPicker_Remark.get(selected));
					}
					else {
						((EditText) view).setText(mPicker_Text.get(selected));
						((EditText) view).setTag(mPicker_Value.get(selected));
					}
                } else {
                    selected = 0;
					if ((EditText) view == BANK_NO){
                        ACCOUNT_NO.setText(mPicker_Text .get(selected));
                        BANK_NO   .setText(mPicker_Value.get(selected));
						BANK_NO_X .setText(mPicker_Remark.get(selected));
					}
					else {
						((EditText) view).setText(mPicker_Text.get(selected));
						((EditText) view).setTag(mPicker_Value.get(selected));
					}
                }

                ((EditText) view).clearFocus();
                d.dismiss();
                d = null;
            }
        };
        DialogInterface.OnClickListener cancelListener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface d, int which) {

                // System.out.println("===>Line number: "+new
                // Throwable().getStackTrace()[0].getLineNumber());

                ((EditText) view).clearFocus();
                d.dismiss();
                d = null;
            }
        };
        String[] mString = new String[mPicker_Text.size()];
        for (int i = 0; i < mPicker_Text.size(); i++) {
            mString[i] = mPicker_Text.get(i);
        }
        dialog.setSingleChoiceItems(mString, 0,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface d, int which) {

                        // System.out.println("===>Line number: "+new
                        // Throwable().getStackTrace()[0].getLineNumber());

                        ListView lv = ((AlertDialog) d).getListView();
                        lv.setTag(new Integer(which));
                    }
                });
        dialog.setPositiveButton("Ok", okListener);
        dialog.setNegativeButton("Cancel", cancelListener);
        dialog.show();

    }


    private void setupTab1EditKeyboard(View view) {
        //20151208 : 日期欄位開窗控制
		/*


		// IssueDate
		// xa003.setOnEditorActionListener(EditorListener);
		xa003.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {

				xa003.setInputType(InputType.TYPE_NULL); // 關閉軟鍵盤
				return false;
			}

		});
		xa003.setOnFocusChangeListener(new OnFocusChangeListener() {
			public void onFocusChange(View v, boolean hasFocus) {

				// System.out.println("===>Line number: "+new
				// Throwable().getStackTrace()[0].getLineNumber());

				if (hasFocus) {
					InputMethodManager imm = (InputMethodManager) getActivity()
							.getSystemService(Context.INPUT_METHOD_SERVICE);
					imm.hideSoftInputFromWindow(xa003.getWindowToken(), 0);
					showDateDialog(v);
				}
			}
		});
		// Creator, not editable
		CREATOR.setOnEditorActionListener(EditorListener);
		CREATOR.setEnabled(false);
		// ConfirmBy ,not editable
		xa067.setOnEditorActionListener(EditorListener);
		xa067.setEnabled(false);
		// ConfirmDate ,not editable
		xa066.setOnEditorActionListener(EditorListener);
		xa066.setEnabled(false);

		// Purpose
		xa560.setOnEditorActionListener(EditorListener);
		// CS
		xa517.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {

				xa517.setInputType(InputType.TYPE_NULL); // 關閉軟鍵盤
				return false;
			}

		});
		xa517.setOnFocusChangeListener(new OnFocusChangeListener() {
			public void onFocusChange(View v, boolean hasFocus) {

				// System.out.println("===>Line number: "+new
				// Throwable().getStackTrace()[0].getLineNumber());

				if (hasFocus) {
					InputMethodManager imm = (InputMethodManager) getActivity()
							.getSystemService(Context.INPUT_METHOD_SERVICE);
					imm.hideSoftInputFromWindow(xa517.getWindowToken(), 0);
					showCSDialog(v);
				}
			}
		});
		// xa59I.setOnEditorActionListener(EditorListener);
		xa59I.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {

				xa59I.setInputType(InputType.TYPE_NULL); // 關閉軟鍵盤
				return false;
			}

		});
		xa59I.setOnFocusChangeListener(new OnFocusChangeListener() {
			public void onFocusChange(View v, boolean hasFocus) {

				// System.out.println("===>Line number: "+new
				// Throwable().getStackTrace()[0].getLineNumber());

				if (hasFocus) {
					InputMethodManager imm = (InputMethodManager) getActivity()
							.getSystemService(Context.INPUT_METHOD_SERVICE);
					imm.hideSoftInputFromWindow(xa59I.getWindowToken(), 0);
					showDateDialog(v);
				}
			}
		});
		// xa004.setOnEditorActionListener(EditorListener);//Cust NO
		xa004.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {

				xa004.setInputType(InputType.TYPE_NULL); // 關閉軟鍵盤
				return false;
			}

		});
		xa004.setOnFocusChangeListener(new OnFocusChangeListener() {
			public void onFocusChange(View v, boolean hasFocus) {

				// System.out.println("===>Line number: "+new
				// Throwable().getStackTrace()[0].getLineNumber());

				if (hasFocus) {
					InputMethodManager imm = (InputMethodManager) getActivity()
							.getSystemService(Context.INPUT_METHOD_SERVICE);
					imm.hideSoftInputFromWindow(xa004.getWindowToken(), 0);
					showCustDialog(v);
				}
			}
		});
		xa004text.setOnEditorActionListener(EditorListener); // Cust Name
		setEditTextReadOnly(xa004text);
		// Contact
		xa005.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {

				xa005.setInputType(InputType.TYPE_NULL); // 關閉軟鍵盤
				return false;
			}

		});
		xa005.setOnFocusChangeListener(new OnFocusChangeListener() {
			public void onFocusChange(View v, boolean hasFocus) {

				// System.out.println("===>Line number: "+new
				// Throwable().getStackTrace()[0].getLineNumber());

				if (hasFocus) {
					InputMethodManager imm = (InputMethodManager) getActivity()
							.getSystemService(Context.INPUT_METHOD_SERVICE);
					imm.hideSoftInputFromWindow(xa005.getWindowToken(), 0);
					showContactDialog(v);
				}
			}
		});
		xa594.setOnEditorActionListener(EditorListener); // PID
		xa502.setOnEditorActionListener(EditorListener);// area code
		xa006.setOnEditorActionListener(EditorListener);// Phone num
		xa007.setOnEditorActionListener(EditorListener);// Phone ext
		xa008.setOnEditorActionListener(EditorListener); // Mobile
		xa503.setOnEditorActionListener(EditorListener); // Fax area
		xa009.setOnEditorActionListener(EditorListener);// Fax
		xa010.setOnEditorActionListener(EditorListener);// Email
		// Address
		xa012.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {

				xa012.setInputType(InputType.TYPE_NULL); // 關閉軟鍵盤
				return false;
			}

		});
		xa012.setOnFocusChangeListener(new OnFocusChangeListener() {
			public void onFocusChange(View v, boolean hasFocus) {

				// System.out.println("===>Line number: "+new
				// Throwable().getStackTrace()[0].getLineNumber());

				if (hasFocus) {
					InputMethodManager imm = (InputMethodManager) getActivity()
							.getSystemService(Context.INPUT_METHOD_SERVICE);
					imm.hideSoftInputFromWindow(xa012.getWindowToken(), 0);
					showAddressDialog(v);
				}
			}
		});
		// end customer
		xa551.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {

				xa551.setInputType(InputType.TYPE_NULL); // 關閉軟鍵盤
				return false;
			}

		});
		xa551.setOnFocusChangeListener(new OnFocusChangeListener() {
			public void onFocusChange(View v, boolean hasFocus) {

				// System.out.println("===>Line number: "+new
				// Throwable().getStackTrace()[0].getLineNumber());

				if (hasFocus) {
					InputMethodManager imm = (InputMethodManager) getActivity()
							.getSystemService(Context.INPUT_METHOD_SERVICE);
					imm.hideSoftInputFromWindow(xa551.getWindowToken(), 0);
					showEndCustDialog(v);
				}
			}
		});
		xa057.setOnEditorActionListener(EditorListener);
		// xa553.setOnEditorActionListener(EditorListener);//cust region
		xa553.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {

				xa553.setInputType(InputType.TYPE_NULL); // 關閉軟鍵盤
				return false;
			}

		});
		xa553.setOnFocusChangeListener(new OnFocusChangeListener() {
			public void onFocusChange(View v, boolean hasFocus) {

				// System.out.println("===>Line number: "+new
				// Throwable().getStackTrace()[0].getLineNumber());

				if (hasFocus) {
					InputMethodManager imm = (InputMethodManager) getActivity()
							.getSystemService(Context.INPUT_METHOD_SERVICE);
					imm.hideSoftInputFromWindow(xa553.getWindowToken(), 0);
					showRegionDialog(v);
				}
			}
		});

		// xa053.setEnabled(false);
		xa058.setOnEditorActionListener(EditorListener);// project name
		// xa053.setOnEditorActionListener(EditorListener);//Sales Rep
		xa054.setOnEditorActionListener(EditorListener);// Purchase Order
		xa054.setEnabled(false);
		xa055.setOnEditorActionListener(EditorListener);// Date Received
		xa055.setEnabled(false);
        */
        // tab2
		/*
		 * xa518.setOnTouchListener(new OnTouchListener() {
		 *
		 * @Override public boolean onTouch(View v, MotionEvent event) {
		 *
		 *
		 *
		 *
		 * xa518.setInputType(InputType.TYPE_NULL); // 關閉軟鍵盤 return false; }
		 *
		 * });
		 *
		 * xa518.setOnFocusChangeListener(new OnFocusChangeListener() { public
		 * void onFocusChange(View v, boolean hasFocus) {
		 *
		 * if(hasFocus){ InputMethodManager imm = (InputMethodManager)
		 * getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
		 * imm.hideSoftInputFromWindow(xa518.getWindowToken(), 0);
		 * showPackageTypeDialog(v); } } });
		 *
		 * //Applicaiton xa544.setOnTouchListener(new OnTouchListener() {
		 *
		 * @Override public boolean onTouch(View v, MotionEvent event) {
		 *
		 *
		 *
		 *
		 * xa544.setInputType(InputType.TYPE_NULL); // 關閉軟鍵盤 return false; } });
		 * xa544.setOnFocusChangeListener(new OnFocusChangeListener() { public
		 * void onFocusChange(View v, boolean hasFocus) { if(hasFocus){
		 * InputMethodManager imm = (InputMethodManager)
		 * getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
		 * imm.hideSoftInputFromWindow(xa544.getWindowToken(), 0);
		 * showApplicationDialog(v); xa544.clearFocus(); } } });
		 */

    }



    private void initTab2(View view) {
		M1_QT_TYPE  = (EditText) view.findViewById(R.id.ed_M1_QT_TYPE );
		M1_QT_NO    = (EditText) view.findViewById(R.id.ed_M1_QT_NO   );
		M1_QT_SEQ   = (EditText) view.findViewById(R.id.ed_M1_QT_SEQ  );
		AP_TYPE     = (EditText) view.findViewById(R.id.ed_AP_TYPE    );
		AP_NO       = (EditText) view.findViewById(R.id.ed_AP_NO      );
		DRAWING_REF = (EditText) view.findViewById(R.id.ed_DRAWING_REF);
		DESCRIPTION = (EditText) view.findViewById(R.id.ed_DESCRIPTION);
		APQP_NO     = (EditText) view.findViewById(R.id.ed_APQP_NO);

		tv_M1_QT_SEQ   = (TextView) view.findViewById(R.id.tv_M1_QT_SEQ  );
	  //tv_AP_TYPE     = (TextView) view.findViewById(R.id.tv_AP_TYPE    );
	  //tv_AP_NO       = (TextView) view.findViewById(R.id.tv_AP_NO      );
		tv_DRAWING_REF = (TextView) view.findViewById(R.id.tv_DRAWING_REF);
		tv_DESCRIPTION = (TextView) view.findViewById(R.id.tv_DESCRIPTION);
		tv_APQP_NO     = (TextView) view.findViewById(R.id.tv_APQP_NO);


		/*
		xa586 = (CheckBox) view.findViewById(R.id.xa586);
		xa544 = (EditText) view.findViewById(R.id.xa544);
		xa113 = (CheckBox) view.findViewById(R.id.xa113);
		xa036Y = (CheckBox) view.findViewById(R.id.xa036Y);
		xa036N = (CheckBox) view.findViewById(R.id.xa036N);
		// Button
		btnLoadPackageInfo1 = (Button) view
				.findViewById(R.id.btnLoadPackageInfo1);
		btnLoadPackageInfo2 = (Button) view
				.findViewById(R.id.btnLoadPackageInfo2);
		btnLoadPackageInfo1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				// 如果沒有輸入則不處理
				if (xa015.getText().length() == 0)
					return;
				//
				JSONObject jsonObject = new JSONObject();
				JSONObject data = new JSONObject();

				try {

					data.accumulate("partno", xa015.getText());
					jsonObject.accumulate("userid", getLoginUser());
					jsonObject.accumulate("WWID",
							"13145774WWGlobal999988loadPackageInfo999");
					jsonObject.accumulate("data", data);
					queryData((String) getWebServiceUrl() + "loadPackageInfo",
							jsonObject, new IDataReceiveListener() {
								public void onReceiveData(Object obj) {

									try {
										JSONObject jsonObject = new JSONObject(
												(String) obj);
										JSONObject data = jsonObject
												.getJSONObject("data");
										xa518.setText(data.getString("xa518"));
										xa020.setText(data.getString("xa020"));
										xa021.setText(data.getString("xa021"));
										xa022.setText(data.getString("xa022"));
										xa023.setText(data.getString("xa023"));
										xa024.setText(data.getString("xa024"));
										xa025.setText(data.getString("xa025"));
										showDialog(jsonObject
												.getString("remark"));

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
		});
		btnLoadPackageInfo2.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				// 如果沒有輸入則不處理
				if (xa091.getText().length() == 0)
					return;
				JSONObject jsonObject = new JSONObject();
				JSONObject data = new JSONObject();

				try {

					data.accumulate("partno", xa091.getText());
					jsonObject.accumulate("userid", getLoginUser());
					jsonObject.accumulate("WWID",
							"13145774WWGlobal999988loadPackageInfo999");
					jsonObject.accumulate("data", data);
					queryData((String) getWebServiceUrl() + "loadPackageInfo",
							jsonObject, new IDataReceiveListener() {
								public void onReceiveData(Object obj) {

									try {
										JSONObject jsonObject = new JSONObject(
												(String) obj);
										JSONObject data = jsonObject
												.getJSONObject("data");
										xa518.setText(data.getString("xa518"));
										xa020.setText(data.getString("xa020"));
										xa021.setText(data.getString("xa021"));
										xa022.setText(data.getString("xa022"));
										xa023.setText(data.getString("xa023"));
										xa024.setText(data.getString("xa024"));
										xa025.setText(data.getString("xa025"));
										showDialog(jsonObject
												.getString("remark"));

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
		});
		setupTab2EditKeyboard(mView);
		*/
	}

	/**
	 * 初始化Screenshot_20150410_14.jpg
	 * 
	 * @param inflater
	 * @param container
	 * @return
	 */
	private View initView(LayoutInflater inflater, ViewGroup container) {
		View view = inflater.inflate(R.layout.actqtdata, container, false);
		context = view.getContext();
		this.fragmentManager = getActivity().getFragmentManager();
		bundle = this.getArguments();

		String[] qtno = getQtNo().split("-");
		if (qtno.length == 2) {
			QT_TYPE = qtno[0];
			QT_NO   = qtno[1];
		}

		mView = view;
        //20151211
		initPullDownView(view);

		setTitle(view);
		tabbar = (RelativeLayout) mView.findViewById(R.id.qttab);

		cmdbar = (RelativeLayout) mView.findViewById(R.id.qt_editbar);
		tab1 = (LinearLayout) mView.findViewById(R.id.tab1);// Cust info
															// linearlayout
		tab2 = (LinearLayout) mView.findViewById(R.id.tab2);// Detail info
		r1 = (RelativeLayout) mView.findViewById(R.id.r1);//
		r2 = (RelativeLayout) mView.findViewById(R.id.r2);//

		vwSubTitle = (TextView) mView.findViewById(R.id.subtitle);
		Button img = (Button) view.findViewById(R.id.img_menu);
		img.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {

				// 如果qttab沒有顯示的話，則顯示
				if (tabbar != null && tabbar.isShown() == false) {
					tabbar.setVisibility(RelativeLayout.VISIBLE);
					// 如果subtitle有顯示的話，則隱藏
					//if (cmdbar != null)
					//	cmdbar.setVisibility(RelativeLayout.GONE);
				} else {
					// 如果qttab有顯示的話，則隱藏
					if (tabbar != null)
						tabbar.setVisibility(RelativeLayout.GONE);
					// 如果subtitle沒有顯示的話，則顯示
					//if (cmdbar != null && cmdbar.isShown() == false) {
					//	cmdbar.setVisibility(RelativeLayout.VISIBLE);
					//}
				}
			}// end of onClick
		});

		// 初始化介面
		initUI(mView);

		if (bundle.getString("func") == null) {

			//b1_onClick(b1);//取得資料
			queryData();

		}
		else{
			queryData();

//            //因為非同步讀取資料的關係, 這一段必須放在 load data,
//			//而且做完後要將 bundle 的 func 參數刪除, 以免被重覆執行
//			if (bundle.getString("func").toString()=="newQT1") {
//				//bundle.remove("func");//執行過一次馬上移除,避免被重複執行
//
//				//if (btnEdit.getTag().equals("N")) {
//				//	showDialog("Permission Denied",
//				//			"Sorry, you don't have the permission to edit table.");
//				//	return;
//				//}
//
//				btnEdit   .setVisibility(View.GONE);
//				btnSave   .setVisibility(View.GONE);
//				btnCancel .setVisibility(View.GONE);
//				btnChange .setVisibility(View.GONE);
//				btnConfirm.setVisibility(View.GONE);
//				btnPdf    .setVisibility(View.GONE);
//
//				btnSave   .setVisibility(View.VISIBLE);
//				btnCancel .setVisibility(View.VISIBLE);
//
//			}
		}

        //20160106 : 改寫在上面這段
		// 取得資料
		//queryData();

		return view;
	}

	// Function O
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return initView(inflater, container);
	}

	public void onCustEdit(View v) {
		mView = getView();
		((Button) v).setVisibility(View.GONE);
		//Button b = (Button) mView.findViewById(R.id.btn_change_cust);
		//b.setVisibility(View.VISIBLE);

	}

	public void onCustChange(View v) {
		mView = getView();
		((Button) v).setVisibility(View.GONE);
		Button b = (Button) mView.findViewById(R.id.btn_qt_edit);
		b.setVisibility(View.VISIBLE);
	}

	private void openDialog(Fragment fragment, String tagName) {
		// Fragment fragment= new CustListActivity();
		// FragmentManager fragmentManager = getFragmentManager();
		fragmentManager.beginTransaction()
				.hide(fragmentManager.findFragmentById(this.getId())).commit();
		fragmentManager.beginTransaction()
				.add(R.id.content_frame, fragment, tagName).commit();
		//fragmentManager.beginTransaction().addToBackStack(null);
		fragmentManager.beginTransaction().show(fragment).commit();

	}

	/**
	 * Function Q 取回webservice的資料
	 */
	private void queryData() {
		String json = "";
		// String
		// url="http://59.125.146.7:8080/QTService/GetMsgList?USERID=mis&PAGE="+Integer.toString(page)+"&WWID=13145774WWGlobal999988msg";
		// String url="http://59.125.146.7:8080/QTService/getQT1";
		String url = super.getWebServiceUrl() + "getQT1";
		JSONObject jsonObject = new JSONObject();
		JSONObject data = new JSONObject();

		try {
			String[] qtno = getQtNo().split("-");
			if (qtno.length == 2) {
				data.accumulate("QT_TYPE", qtno[0]);
				data.accumulate("QT_NO", qtno[1]);
				// data.accumulate("QT_NO","140401005");
			}
			jsonObject.accumulate("userid", super.getLoginUser());
			jsonObject.accumulate("WWID", "13145774WWGlobal999988qt1999");
			jsonObject.accumulate("data", data);
			super.postRequest(url, jsonObject);

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


	private void queryData(String url, JSONObject jsonObject,
			IDataReceiveListener dataListener) {
		super.postRequest(url, jsonObject, dataListener, true);
	}

	/**
	 * Function Q 取回webservice的資料
	 */
    private void queryDataPdf(Bundle b) {
        String json = "";
        // String
        // url="http://59.125.146.7:8080/QTService/GetMsgList?USERID=mis&PAGE="+Integer.toString(page)+"&WWID=13145774WWGlobal999988msg";
        // String url="http://59.125.146.7:8080/QTService/getQT1";
        String url = super.getWebServiceUrl() + "pdfQT1";
        JSONObject jsonObject = new JSONObject();
        JSONObject data = new JSONObject();

        try {
            //String[] qtno = getQtNo().split("-");
            //if (qtno.length == 2) {
				data.accumulate("QT_TYPE"       , QT_TYPE                      );
				data.accumulate("QT_NO"         , QT_NO                        );
				data.accumulate("PRICE"         , b.getString("PRICE"         ));
				data.accumulate("LANGUAGE"      , b.getString("LANGUAGE"      ));
				data.accumulate("DETAIL"        , b.getString("DETAIL"        ));
				data.accumulate("SHOW_BANK"     , b.getString("SHOW_BANK"     ));
				data.accumulate("SHOW_TOTAL"    , b.getString("SHOW_TOTAL"    ));
				data.accumulate("SHOW_PERCENT"  , b.getString("SHOW_PERCENT"  ));
				data.accumulate("SHOW_SIGNATURE", b.getString("SHOW_SIGNATURE"));
				data.accumulate("SHOW_STAMP"    , b.getString("SHOW_STAMP"    ));
            //}
            jsonObject.accumulate("userid", super.getLoginUser());
            jsonObject.accumulate("WWID", "13145774WWGlobal999988qtpdf999");
            jsonObject.accumulate("data", data);
            super.postRequest(url, jsonObject);

        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    /**
	 * Function S
	 * 
	 * @param v
	 */
	private void setTitle(View v) {
		TextView vwTitle = (TextView) v.findViewById(R.id.title_text);
		vwTitle.setText(getQtNo());
	}

	private void setupTab2EditKeyboard(View view) {
		/*
		xa518.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {

				xa518.setInputType(InputType.TYPE_NULL); // 關閉軟鍵盤
				return false;
			}
		});
		xa518.setOnFocusChangeListener(new OnFocusChangeListener() {
			public void onFocusChange(View v, boolean hasFocus) {

				// System.out.println("===>Line number: "+new
				// Throwable().getStackTrace()[0].getLineNumber());

				if (hasFocus) {
					InputMethodManager imm = (InputMethodManager) getActivity()
							.getSystemService(Context.INPUT_METHOD_SERVICE);
					imm.hideSoftInputFromWindow(xa518.getWindowToken(), 0);
					showPackageTypeDialog(v);
					xa518.clearFocus();
				}
			}
		});
		xa104.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {

				xa104.setInputType(InputType.TYPE_NULL); // 關閉軟鍵盤
				return false;
			}
		});
		xa104.setOnFocusChangeListener(new OnFocusChangeListener() {
			public void onFocusChange(View v, boolean hasFocus) {

				// System.out.println("===>Line number: "+new
				// Throwable().getStackTrace()[0].getLineNumber());

				if (hasFocus) {
					InputMethodManager imm = (InputMethodManager) getActivity()
							.getSystemService(Context.INPUT_METHOD_SERVICE);
					imm.hideSoftInputFromWindow(xa104.getWindowToken(), 0);
					if (mPoPLGATestType.size() == 0) {
						loadPoPLGATestTypeData(v);
					} else {
						showPoPLGATestTypeDialog(v);
					}
					xa104.clearFocus();
				}
			}
		});
		xa107.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {

				xa107.setInputType(InputType.TYPE_NULL); // 關閉軟鍵盤
				return false;
			}
		});
		xa107.setOnFocusChangeListener(new OnFocusChangeListener() {
			public void onFocusChange(View v, boolean hasFocus) {

				// System.out.println("===>Line number: "+new
				// Throwable().getStackTrace()[0].getLineNumber());

				if (hasFocus) {
					InputMethodManager imm = (InputMethodManager) getActivity()
							.getSystemService(Context.INPUT_METHOD_SERVICE);
					imm.hideSoftInputFromWindow(xa107.getWindowToken(), 0);
					// 載入
					if (mDigitalAppStd.size() == 0) {
						loadDigitalAppStdData(v);
					} else {
						showDigitalAppStdDialog(v);
					}
					xa107.clearFocus();
				}
			}
		});
		xa108.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {

				xa108.setInputType(InputType.TYPE_NULL); // 關閉軟鍵盤
				return false;
			}
		});
		xa108.setOnFocusChangeListener(new OnFocusChangeListener() {
			public void onFocusChange(View v, boolean hasFocus) {

				// System.out.println("===>Line number: "+new
				// Throwable().getStackTrace()[0].getLineNumber());

				if (hasFocus) {
					InputMethodManager imm = (InputMethodManager) getActivity()
							.getSystemService(Context.INPUT_METHOD_SERVICE);
					imm.hideSoftInputFromWindow(xa108.getWindowToken(), 0);
					// 載入
					if (mDigitalClass.size() == 0) {
						loadDigitalClassData(v);
					} else {
						showDigitalClassDialog(v);
					}
					xa108.clearFocus();
				}
			}
		});
		xa109.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {

				xa109.setInputType(InputType.TYPE_NULL); // 關閉軟鍵盤
				return false;
			}
		});
		xa109.setOnFocusChangeListener(new OnFocusChangeListener() {
			public void onFocusChange(View v, boolean hasFocus) {

				// System.out.println("===>Line number: "+new
				// Throwable().getStackTrace()[0].getLineNumber());

				if (hasFocus) {
					InputMethodManager imm = (InputMethodManager) getActivity()
							.getSystemService(Context.INPUT_METHOD_SERVICE);
					imm.hideSoftInputFromWindow(xa109.getWindowToken(), 0);
					// 載入
					if (mAnalogAppStd.size() == 0) {
						loadAnalogAppStdData(v);
					} else {
						showAnalogAppStdDialog(v);
					}
					xa109.clearFocus();
				}
			}
		});
		xa110.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {

				xa110.setInputType(InputType.TYPE_NULL); // 關閉軟鍵盤
				return false;
			}
		});
		xa110.setOnFocusChangeListener(new OnFocusChangeListener() {
			public void onFocusChange(View v, boolean hasFocus) {

				// System.out.println("===>Line number: "+new
				// Throwable().getStackTrace()[0].getLineNumber());

				if (hasFocus) {
					InputMethodManager imm = (InputMethodManager) getActivity()
							.getSystemService(Context.INPUT_METHOD_SERVICE);
					imm.hideSoftInputFromWindow(xa110.getWindowToken(), 0);
					// 載入
					if (mAnalogClass.size() == 0) {
						loadAnalogClassData(v);
					} else {
						showAnalogClassDialog(v);
					}
					xa110.clearFocus();
				}
			}
		});
		xa544.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {

				xa544.setInputType(InputType.TYPE_NULL); // 關閉軟鍵盤
				return false;
			}

		});
		xa544.setOnFocusChangeListener(new OnFocusChangeListener() {
			public void onFocusChange(View v, boolean hasFocus) {

				// System.out.println("===>Line number: "+new
				// Throwable().getStackTrace()[0].getLineNumber());

				if (hasFocus) {
					InputMethodManager imm = (InputMethodManager) getActivity()
							.getSystemService(Context.INPUT_METHOD_SERVICE);
					imm.hideSoftInputFromWindow(xa544.getWindowToken(), 0);
					if (mApplication.size() == 0) {
						loadApplicationData(v);
					} else {
						showApplicationDialog(v);

					}
					xa544.clearFocus();
				}
			}
		});
		xa111.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {

				xa111.setInputType(InputType.TYPE_NULL); // 關閉軟鍵盤
				return false;
			}

		});
		xa111.setOnFocusChangeListener(new OnFocusChangeListener() {
			public void onFocusChange(View v, boolean hasFocus) {

				// System.out.println("===>Line number: "+new
				// Throwable().getStackTrace()[0].getLineNumber());

				if (hasFocus) {
					InputMethodManager imm = (InputMethodManager) getActivity()
							.getSystemService(Context.INPUT_METHOD_SERVICE);
					imm.hideSoftInputFromWindow(xa111.getWindowToken(), 0);
					if (mDevicePad.size() == 0) {
						loadDevicePadData(v);
					} else {
						showDevicePadDialog(v);

					}
					xa111.clearFocus();
				}
			}
		});
		xa59S.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {

				xa59S.setInputType(InputType.TYPE_NULL); // 關閉軟鍵盤
				return false;
			}

		});
		xa59S.setOnFocusChangeListener(new OnFocusChangeListener() {
			public void onFocusChange(View v, boolean hasFocus) {

				// System.out.println("===>Line number: "+new
				// Throwable().getStackTrace()[0].getLineNumber());

				if (hasFocus) {
					InputMethodManager imm = (InputMethodManager) getActivity()
							.getSystemService(Context.INPUT_METHOD_SERVICE);
					imm.hideSoftInputFromWindow(xa59S.getWindowToken(), 0);
					if (mDocNeeded.size() == 0) {
						loadDocNeededData(v);
					} else {
						showDocNeededDialog(v);

					}
					xa59S.clearFocus();
				}
			}
		});
		xa59T.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {

				xa59T.setInputType(InputType.TYPE_NULL); // 關閉軟鍵盤
				return false;
			}

		});
		xa59T.setOnFocusChangeListener(new OnFocusChangeListener() {
			public void onFocusChange(View v, boolean hasFocus) {

				// System.out.println("===>Line number: "+new
				// Throwable().getStackTrace()[0].getLineNumber());

				if (hasFocus) {
					InputMethodManager imm = (InputMethodManager) getActivity()
							.getSystemService(Context.INPUT_METHOD_SERVICE);
					imm.hideSoftInputFromWindow(xa59T.getWindowToken(), 0);
					showDateDialog(v);
					xa59T.clearFocus();
				}
			}
		});
		*/
	}


	public static void setEditTextReadOnly(TextView view, Boolean readonly) {
		// view.setTextColor(R.color.read_only_color); //設置顏色，使其看起來像只讀模式
        if (readonly) {
            //if (view instanceof EditText) {
                view.setCursorVisible(false); // 設置光標不可見
                view.setFocusable(false); // 無焦點
                view.setFocusableInTouchMode(false); // 觸摸時也得不到焦點
        }
        else {
            view.setCursorVisible(true); // 設置光標可見
            view.setFocusable(true); // 焦點
            view.setFocusableInTouchMode(true); // 觸摸時得到焦點
        }


	}


    public void showCustDialog(View view)
    {

        //System.out.println("==>"+new Throwable().getStackTrace()[0].getClassName()+" > "+new Throwable().getStackTrace()[0].getMethodName());
        //System.out.println("===>Line number: "+new Throwable().getStackTrace()[0].getLineNumber());

        Fragment fragment= new CustListActivity2();
        ((CustListActivity2)fragment).setParent((Fragment)this);
        ((BaseFragment)fragment).setCallback(new BaseFragment.ICallback(){
            @Override
            public void doWork(Object object){
                Bundle b=(Bundle)object;
                CUST_NO.setText(b.getString("custId")+" " +b.getString("custName"));
                CUST_NO.setHint(b.getString("custId"));
            }

        });
        openDialog(fragment,"Cust");
    }

    //-------------------------------------------------------------
    // @Dialog
    //-------------------------------------------------------------
    public void QT_showCustDialog(View view) {
        Fragment fragment = new CustListActivity2();
        Bundle args = new Bundle();
        args.putString("parentId", "qtdata");
        fragment.setArguments(args);
        openDialog(fragment, "Cust");
    }

    public void showCSDialog(View view) {
		Fragment fragment = new CSListActivity();
		openDialog(fragment, "CS");
	}

	public void showEndCustDialog(View view) {
		Fragment fragment = new EndCustListActivity();
		openDialog(fragment, "EndCust");
	}


	public void showAddressDialog(View view) {
		Fragment fragment = new AddressListActivity();
		Bundle args = new Bundle();
		args.putString("cust_no", CUST_NO.getText().toString());
		fragment.setArguments(args);
		openDialog(fragment, "Address");
	}

	public void showContactDialog(View view) {
		Fragment fragment = new ContactListActivity3();
		Bundle args = new Bundle();
		args.putString("cust_no", CUST_NO.getText().toString());
        args.putString("parentId", "qtdata");

		fragment.setArguments(args);
		openDialog(fragment, "Contact");
	}


	public void showApplicationDialog(final View view) {

		AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity());
		dialog.setTitle("Application").setIcon(
				android.R.drawable.ic_dialog_info);
		DialogInterface.OnClickListener okListener = new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface d, int which) {

				// System.out.println("===>Line number: "+new
				// Throwable().getStackTrace()[0].getLineNumber());

				ListView lv = ((AlertDialog) d).getListView();
				Integer selected = (Integer) lv.getTag();
				if (selected != null) {
					((EditText) view).setText(mApplication.get(selected));
					((EditText) view).setTag(mApplicationValue.get(selected));
				} else {
					// default value
					selected = 0;
					((EditText) view).setText(mApplication.get(selected));
					((EditText) view).setTag(mApplicationValue.get(selected));

				}

				((EditText) view).clearFocus();
				d.dismiss();
				d = null;
			}
		};
		DialogInterface.OnClickListener cancelListener = new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface d, int which) {

				// System.out.println("===>Line number: "+new
				// Throwable().getStackTrace()[0].getLineNumber());

				((EditText) view).clearFocus();
				d.dismiss();
				d = null;
			}
		};
		String[] mString = new String[mApplication.size()];
		for (int i = 0; i < mApplication.size(); i++) {
			mString[i] = mApplication.get(i);
		}
		dialog.setSingleChoiceItems(mString, 0,
				new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface d, int which) {

						// System.out.println("===>Line number: "+new
						// Throwable().getStackTrace()[0].getLineNumber());

						ListView lv = ((AlertDialog) d).getListView();
						lv.setTag(new Integer(which));
					}
				});
		dialog.setPositiveButton("Ok", okListener);
		dialog.setNegativeButton("Cancel", cancelListener);
		dialog.show();

	}

	public void showDocNeededDialog(final View view) {

		AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity());
		dialog.setTitle("DocNeeded").setIcon(android.R.drawable.ic_dialog_info);
		DialogInterface.OnClickListener okListener = new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface d, int which) {

				// System.out.println("===>Line number: "+new
				// Throwable().getStackTrace()[0].getLineNumber());

				ListView lv = ((AlertDialog) d).getListView();
				Integer selected = (Integer) lv.getTag();
				if (selected != null) {
					((EditText) view).setText(mDocNeeded.get(selected));
					((EditText) view).setTag(mDocNeededValue.get(selected));
				} else {
					selected = 0;
					((EditText) view).setText(mDocNeeded.get(0));
					((EditText) view).setTag(mDocNeededValue.get(0));

				}
				((EditText) view).clearFocus();
				d.dismiss();
				d = null;
			}
		};
		DialogInterface.OnClickListener cancelListener = new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface d, int which) {

				// System.out.println("===>Line number: "+new
				// Throwable().getStackTrace()[0].getLineNumber());

				((EditText) view).clearFocus();
				d.dismiss();
				d = null;
			}
		};
		String[] mString = new String[mDocNeeded.size()];
		for (int i = 0; i < mDocNeeded.size(); i++) {
			mString[i] = mDocNeeded.get(i);
		}
		dialog.setSingleChoiceItems(mString, 0,
				new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface d, int which) {

						// System.out.println("===>Line number: "+new
						// Throwable().getStackTrace()[0].getLineNumber());

						ListView lv = ((AlertDialog) d).getListView();
						lv.setTag(new Integer(which));
					}
				});
		dialog.setPositiveButton("Ok", okListener);
		dialog.setNegativeButton("Cancel", cancelListener);
		dialog.show();

	}

	public void showHandlerManuDialog(final View view) {

		AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity());
		dialog.setTitle("Handlermanuf...").setIcon(
				android.R.drawable.ic_dialog_info);
		DialogInterface.OnClickListener okListener = new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface d, int which) {

				// System.out.println("===>Line number: "+new
				// Throwable().getStackTrace()[0].getLineNumber());

				ListView lv = ((AlertDialog) d).getListView();
				Integer selected = (Integer) lv.getTag();
				if (selected != null) {
					((EditText) view).setText(mHandlerManu.get(selected));
					((EditText) view).setTag(mHandlerManuValue.get(selected));
				} else {
					selected = 0;
					((EditText) view).setText(mHandlerManu.get(selected));
					((EditText) view).setTag(mHandlerManuValue.get(selected));

				}

				((EditText) view).clearFocus();
				d.dismiss();
				d = null;
			}
		};
		DialogInterface.OnClickListener cancelListener = new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface d, int which) {

				// System.out.println("===>Line number: "+new
				// Throwable().getStackTrace()[0].getLineNumber());

				((EditText) view).clearFocus();
				d.dismiss();
				d = null;
			}
		};
		String[] mString = new String[mHandlerManu.size()];
		for (int i = 0; i < mHandlerManu.size(); i++) {
			mString[i] = mHandlerManu.get(i);
		}
		dialog.setSingleChoiceItems(mString, 0,
				new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface d, int which) {

						// System.out.println("===>Line number: "+new
						// Throwable().getStackTrace()[0].getLineNumber());

						ListView lv = ((AlertDialog) d).getListView();
						lv.setTag(new Integer(which));
					}
				});
		dialog.setPositiveButton("Ok", okListener);
		dialog.setNegativeButton("Cancel", cancelListener);
		dialog.show();

	}

	public void showHandlerModelDialog(final View view) {

		AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity());
		dialog.setTitle("Handlermodel").setIcon(
				android.R.drawable.ic_dialog_info);
		DialogInterface.OnClickListener okListener = new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface d, int which) {

				// System.out.println("===>Line number: "+new
				// Throwable().getStackTrace()[0].getLineNumber());

				ListView lv = ((AlertDialog) d).getListView();
				Integer selected = (Integer) lv.getTag();
				if (selected != null) {
					((EditText) view).setText(mHandlerModel.get(selected));
					((EditText) view).setTag(mHandlerModelValue.get(selected));
				} else {
					selected = 0;
					((EditText) view).setText(mHandlerModel.get(0));
					((EditText) view).setTag(mHandlerModelValue.get(0));

				}
				((EditText) view).clearFocus();
				d.dismiss();
				d = null;
			}
		};
		DialogInterface.OnClickListener cancelListener = new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface d, int which) {

				// System.out.println("===>Line number: "+new
				// Throwable().getStackTrace()[0].getLineNumber());

				((EditText) view).clearFocus();
				d.dismiss();
				d = null;
			}
		};
		String[] mString = new String[mHandlerModel.size()];
		for (int i = 0; i < mHandlerModel.size(); i++) {
			mString[i] = mHandlerModel.get(i);
		}
		dialog.setSingleChoiceItems(mString, 0,
				new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface d, int which) {

						// System.out.println("===>Line number: "+new
						// Throwable().getStackTrace()[0].getLineNumber());

						ListView lv = ((AlertDialog) d).getListView();
						lv.setTag(new Integer(which));
					}
				});
		dialog.setPositiveButton("Ok", okListener);
		dialog.setNegativeButton("Cancel", cancelListener);
		dialog.show();

	}

	public void showTesterManuDialog(final View view) {

		AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity());
		dialog.setTitle("Testermanuf...").setIcon(
				android.R.drawable.ic_dialog_info);
		DialogInterface.OnClickListener okListener = new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface d, int which) {

				// System.out.println("===>Line number: "+new
				// Throwable().getStackTrace()[0].getLineNumber());

				ListView lv = ((AlertDialog) d).getListView();
				Integer selected = (Integer) lv.getTag();
				if (selected != null) {
					((EditText) view).setText(mTesterManu.get(selected));
					((EditText) view).setTag(mTesterManuValue.get(selected));
				} else {
					selected = 0;
					((EditText) view).setText(mTesterManu.get(selected));
					((EditText) view).setTag(mTesterManuValue.get(selected));
				}
				((EditText) view).clearFocus();
				d.dismiss();
				d = null;
			}
		};
		DialogInterface.OnClickListener cancelListener = new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface d, int which) {

				// System.out.println("===>Line number: "+new
				// Throwable().getStackTrace()[0].getLineNumber());

				((EditText) view).clearFocus();
				d.dismiss();
				d = null;
			}
		};
		String[] mString = new String[mTesterManu.size()];
		for (int i = 0; i < mTesterManu.size(); i++) {
			mString[i] = mTesterManu.get(i);
		}
		dialog.setSingleChoiceItems(mString, 0,
				new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface d, int which) {

						// System.out.println("===>Line number: "+new
						// Throwable().getStackTrace()[0].getLineNumber());

						ListView lv = ((AlertDialog) d).getListView();
						lv.setTag(new Integer(which));
					}
				});
		dialog.setPositiveButton("Ok", okListener);
		dialog.setNegativeButton("Cancel", cancelListener);
		dialog.show();

	}

	public void showTesterModelDialog(final View view) {

		AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity());
		dialog.setTitle("Testermodel").setIcon(
				android.R.drawable.ic_dialog_info);
		DialogInterface.OnClickListener okListener = new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface d, int which) {

				// System.out.println("===>Line number: "+new
				// Throwable().getStackTrace()[0].getLineNumber());

				ListView lv = ((AlertDialog) d).getListView();
				Integer selected = (Integer) lv.getTag();
				if (selected != null) {
					((EditText) view).setText(mTesterModel.get(selected));
					((EditText) view).setTag(mTesterModelValue.get(selected));
				} else {
					selected = 0;
					((EditText) view).setText(mTesterManu.get(selected));
					((EditText) view).setTag(mTesterManuValue.get(selected));
				}
				((EditText) view).clearFocus();
				d.dismiss();
				d = null;
			}
		};
		DialogInterface.OnClickListener cancelListener = new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface d, int which) {

				// System.out.println("===>Line number: "+new
				// Throwable().getStackTrace()[0].getLineNumber());

				((EditText) view).clearFocus();
				d.dismiss();
				d = null;
			}
		};
		String[] mString = new String[mTesterModel.size()];
		for (int i = 0; i < mTesterModel.size(); i++) {
			mString[i] = mTesterModel.get(i);
		}
		dialog.setSingleChoiceItems(mString, 0,
				new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface d, int which) {

						// System.out.println("===>Line number: "+new
						// Throwable().getStackTrace()[0].getLineNumber());

						ListView lv = ((AlertDialog) d).getListView();
						lv.setTag(new Integer(which));
					}
				});
		dialog.setPositiveButton("Ok", okListener);
		dialog.setNegativeButton("Cancel", cancelListener);
		dialog.show();

	}

	public void showDigitalAppStdDialog(final View view) {

		AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity());
		dialog.setTitle("Testermodel").setIcon(
				android.R.drawable.ic_dialog_info);
		DialogInterface.OnClickListener okListener = new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface d, int which) {

				// System.out.println("===>Line number: "+new
				// Throwable().getStackTrace()[0].getLineNumber());

				ListView lv = ((AlertDialog) d).getListView();
				Integer selected = (Integer) lv.getTag();
				if (selected != null) {
					((EditText) view).setText(mDigitalAppStd.get(selected));
					((EditText) view).setTag(mDigitalAppStdValue.get(selected));
				} else {
					selected = 0;
					((EditText) view).setText(mDigitalAppStd.get(selected));
					((EditText) view).setTag(mDigitalAppStdValue.get(selected));

				}
				((EditText) view).clearFocus();
				d.dismiss();
				d = null;
			}
		};
		DialogInterface.OnClickListener cancelListener = new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface d, int which) {

				// System.out.println("===>Line number: "+new
				// Throwable().getStackTrace()[0].getLineNumber());

				((EditText) view).clearFocus();
				d.dismiss();
				d = null;
			}
		};
		String[] mString = new String[mDigitalAppStd.size()];
		for (int i = 0; i < mDigitalAppStd.size(); i++) {
			mString[i] = mDigitalAppStd.get(i);
		}
		dialog.setSingleChoiceItems(mString, 0,
				new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface d, int which) {

						// System.out.println("===>Line number: "+new
						// Throwable().getStackTrace()[0].getLineNumber());

						ListView lv = ((AlertDialog) d).getListView();
						lv.setTag(new Integer(which));
					}
				});
		dialog.setPositiveButton("Ok", okListener);
		dialog.setNegativeButton("Cancel", cancelListener);
		dialog.show();

	}

	public void showAnalogAppStdDialog(final View view) {

		AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity());
		dialog.setTitle("AnalogAppStd").setIcon(
				android.R.drawable.ic_dialog_info);
		DialogInterface.OnClickListener okListener = new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface d, int which) {

				// System.out.println("===>Line number: "+new
				// Throwable().getStackTrace()[0].getLineNumber());

				ListView lv = ((AlertDialog) d).getListView();
				Integer selected = (Integer) lv.getTag();
				if (selected != null) {
					((EditText) view).setText(mAnalogAppStd.get(selected));
					((EditText) view).setTag(mAnalogAppStdValue.get(selected));
				} else {
					selected = 0;
					((EditText) view).setText(mAnalogAppStd.get(selected));
					((EditText) view).setTag(mAnalogAppStdValue.get(selected));
				}
				((EditText) view).clearFocus();
				d.dismiss();
				d = null;
			}
		};
		DialogInterface.OnClickListener cancelListener = new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface d, int which) {

				// System.out.println("===>Line number: "+new
				// Throwable().getStackTrace()[0].getLineNumber());

				((EditText) view).clearFocus();
				d.dismiss();
				d = null;
			}
		};
		String[] mString = new String[mAnalogAppStd.size()];
		for (int i = 0; i < mAnalogAppStd.size(); i++) {
			mString[i] = mAnalogAppStd.get(i);
		}
		dialog.setSingleChoiceItems(mString, 0,
				new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface d, int which) {

						// System.out.println("===>Line number: "+new
						// Throwable().getStackTrace()[0].getLineNumber());

						ListView lv = ((AlertDialog) d).getListView();
						lv.setTag(new Integer(which));
					}
				});
		dialog.setPositiveButton("Ok", okListener);
		dialog.setNegativeButton("Cancel", cancelListener);
		dialog.show();

	}

	public void showDigitalClassDialog(final View view) {

		AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity());
		dialog.setTitle("DigitalClass").setIcon(
				android.R.drawable.ic_dialog_info);
		DialogInterface.OnClickListener okListener = new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface d, int which) {

				// System.out.println("===>Line number: "+new
				// Throwable().getStackTrace()[0].getLineNumber());

				ListView lv = ((AlertDialog) d).getListView();
				Integer selected = (Integer) lv.getTag();
				if (selected != null) {
					((EditText) view).setText(mDigitalClass.get(selected));
					((EditText) view).setTag(mDigitalClassValue.get(selected));
				} else {
					selected = 0;
					((EditText) view).setText(mDigitalClass.get(selected));
					((EditText) view).setTag(mDigitalClassValue.get(selected));
				}
				((EditText) view).clearFocus();
				d.dismiss();
				d = null;
			}
		};
		DialogInterface.OnClickListener cancelListener = new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface d, int which) {

				// System.out.println("===>Line number: "+new
				// Throwable().getStackTrace()[0].getLineNumber());

				((EditText) view).clearFocus();
				d.dismiss();
				d = null;
			}
		};
		String[] mString = new String[mDigitalClass.size()];
		for (int i = 0; i < mDigitalClass.size(); i++) {
			mString[i] = mDigitalClass.get(i);
		}
		dialog.setSingleChoiceItems(mString, 0,
				new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface d, int which) {

						// System.out.println("===>Line number: "+new
						// Throwable().getStackTrace()[0].getLineNumber());

						ListView lv = ((AlertDialog) d).getListView();
						lv.setTag(new Integer(which));
					}
				});
		dialog.setPositiveButton("Ok", okListener);
		dialog.setNegativeButton("Cancel", cancelListener);
		dialog.show();

	}

	public void showAnalogClassDialog(final View view) {

		AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity());
		dialog.setTitle("AnalogClass").setIcon(
				android.R.drawable.ic_dialog_info);
		DialogInterface.OnClickListener okListener = new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface d, int which) {

				// System.out.println("===>Line number: "+new
				// Throwable().getStackTrace()[0].getLineNumber());

				ListView lv = ((AlertDialog) d).getListView();
				Integer selected = (Integer) lv.getTag();
				if (selected != null) {
					((EditText) view).setText(mAnalogClass.get(selected));
					((EditText) view).setTag(mAnalogClassValue.get(selected));
				} else {
					selected = 0;
					((EditText) view).setText(mAnalogClass.get(selected));
					((EditText) view).setTag(mAnalogClassValue.get(selected));
				}
				((EditText) view).clearFocus();
				d.dismiss();
				d = null;
			}
		};
		DialogInterface.OnClickListener cancelListener = new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface d, int which) {

				// System.out.println("===>Line number: "+new
				// Throwable().getStackTrace()[0].getLineNumber());

				((EditText) view).clearFocus();
				d.dismiss();
				d = null;
			}
		};
		String[] mString = new String[mAnalogClass.size()];
		for (int i = 0; i < mAnalogClass.size(); i++) {
			mString[i] = mAnalogClass.get(i);
		}
		dialog.setSingleChoiceItems(mString, 0,
				new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface d, int which) {

						// System.out.println("===>Line number: "+new
						// Throwable().getStackTrace()[0].getLineNumber());

						ListView lv = ((AlertDialog) d).getListView();
						lv.setTag(new Integer(which));
					}
				});
		dialog.setPositiveButton("Ok", okListener);
		dialog.setNegativeButton("Cancel", cancelListener);
		dialog.show();

	}

	public void showDevicePadDialog(final View view) {

		AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity());
		dialog.setTitle("DevicePad").setIcon(android.R.drawable.ic_dialog_info);
		DialogInterface.OnClickListener okListener = new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface d, int which) {

				// System.out.println("===>Line number: "+new
				// Throwable().getStackTrace()[0].getLineNumber());

				ListView lv = ((AlertDialog) d).getListView();
				Integer selected = (Integer) lv.getTag();
				if (selected != null) {
					((EditText) view).setText(mDevicePad.get(selected));
					((EditText) view).setTag(mDevicePadValue.get(selected));
				} else {
					selected = 0;
					((EditText) view).setText(mDevicePad.get(selected));
					((EditText) view).setTag(mDevicePadValue.get(selected));
				}
				((EditText) view).clearFocus();
				d.dismiss();
				d = null;
			}
		};
		DialogInterface.OnClickListener cancelListener = new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface d, int which) {

				// System.out.println("===>Line number: "+new
				// Throwable().getStackTrace()[0].getLineNumber());

				((EditText) view).clearFocus();
				d.dismiss();
				d = null;
			}
		};
		String[] mString = new String[mDevicePad.size()];
		for (int i = 0; i < mDevicePad.size(); i++) {
			mString[i] = mDevicePad.get(i);
		}
		dialog.setSingleChoiceItems(mString, 0,
				new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface d, int which) {

						// System.out.println("===>Line number: "+new
						// Throwable().getStackTrace()[0].getLineNumber());

						ListView lv = ((AlertDialog) d).getListView();
						lv.setTag(new Integer(which));
					}
				});
		dialog.setPositiveButton("Ok", okListener);
		dialog.setNegativeButton("Cancel", cancelListener);
		dialog.show();

	}

	public void showPoPLGATestTypeDialog(final View view) {

		AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity());
		dialog.setTitle("PoPLGATestType").setIcon(
				android.R.drawable.ic_dialog_info);
		DialogInterface.OnClickListener okListener = new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface d, int which) {

				// System.out.println("===>Line number: "+new
				// Throwable().getStackTrace()[0].getLineNumber());

				ListView lv = ((AlertDialog) d).getListView();
				Integer selected = (Integer) lv.getTag();
				if (selected != null) {
					((EditText) view).setText(mPoPLGATestType.get(selected));
					((EditText) view)
							.setTag(mPoPLGATestTypeValue.get(selected));
				} else {
					selected = 0;
					((EditText) view).setText(mPoPLGATestType.get(selected));
					((EditText) view)
							.setTag(mPoPLGATestTypeValue.get(selected));
				}
				((EditText) view).clearFocus();
				d.dismiss();
				d = null;
			}
		};
		DialogInterface.OnClickListener cancelListener = new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface d, int which) {

				// System.out.println("===>Line number: "+new
				// Throwable().getStackTrace()[0].getLineNumber());

				((EditText) view).clearFocus();
				d.dismiss();
				d = null;
			}
		};
		String[] mString = new String[mPoPLGATestType.size()];
		for (int i = 0; i < mPoPLGATestType.size(); i++) {
			mString[i] = mPoPLGATestType.get(i);
		}
		dialog.setSingleChoiceItems(mString, 0,
				new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface d, int which) {

						// System.out.println("===>Line number: "+new
						// Throwable().getStackTrace()[0].getLineNumber());

						ListView lv = ((AlertDialog) d).getListView();
						lv.setTag(new Integer(which));
					}
				});
		dialog.setPositiveButton("Ok", okListener);
		dialog.setNegativeButton("Cancel", cancelListener);
		dialog.show();

	}

	public void showPackageTypeDialog(final View view) {
		PackageListActivity activity = new PackageListActivity();
		activity.setParent(this);
		activity.setCallback(new ICallback() {
			@Override
			public void doWork(Object object) {
				PackageItem item = (PackageItem) object;
				if (view != null) {
					((EditText) view).setText(item.getPackage());
					((EditText) view).clearFocus();
				}

			}

		});
		openDialog((Fragment) activity, "PackageType");
	}

	/**
	 * 將FAE user編輯資料上傳到webservice
	 * 
	 * @param action
	 *            (Save,Confirm,Changes)
	 */
	private void saveData(final String action) {

		// System.out.println("===>Line number: "+new
		// Throwable().getStackTrace()[0].getLineNumber());

		HttpPostAsyncTask task1 = new HttpPostAsyncTask();
		JSONObject data = null;
		String func = "";
		if (tab1.getVisibility() == View.VISIBLE) {
			func = "updateQT1";
			data = getInputData1(action);

		//} else if (tab2.getVisibility() == View.VISIBLE) {
		//	func = "updateQT2";
		//	data = getInputData2(action);

		}
		/*
		 * queryData((String) getWebServiceUrl() + func, data, new
		 * IDataReceiveListener() { public void onReceiveData(Object obj) {
		 * 
		 * } });
		 */
		task1.setCallback(new ICallback() {

			@Override
			public void doWork(Object obj) {

				try {

					JSONObject jsonObject = new JSONObject((String) obj);
					if (jsonObject.getString("success").equals("0")) {
						//
						System.out.print("update failure");
					}

					// showApplicationDialog(mView);
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		});
		task1.execute((String) super.getWebServiceUrl() + func, data.toString());

	}

	/**
	 * 將QT =>TAB 1 =>Customer Infomations user編輯資料上傳到webservice
	 * 
	 * @param action
	 *            (Save,Confirm,Changes)
	 */
	private void saveData1(final String action) {

		// System.out.println("===>Line number: "+new
		// Throwable().getStackTrace()[0].getLineNumber());

		HttpPostAsyncTask task1 = new HttpPostAsyncTask();
		JSONObject data = null;
		String func = "";

		func = "updateQT1";
		data = getInputData1(action);// get data from user input
		task1.setCallback(new ICallback() {
			@Override
			public void doWork(Object obj) {

				try {

					JSONObject jsonObject = new JSONObject((String) obj);
					if (jsonObject.getString("success").equals("false")) {
						showDialog("error", jsonObject.getString("remark"));
					} else {
						JSONObject data = jsonObject.getJSONObject("data");
						btnEdit.setTag(data.getString("editable"));
						btnChange.setTag(data.getString("CONFIRM_CODE"));
						VERSION = data.getString("VERSION");
						//xa593 = data.getString("xa593");
						showDialog(action + " success");

					}
					// showApplicationDialog(mView);
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		});
		task1.execute((String) super.getWebServiceUrl() + func, data.toString());
        //20160112 : 測試 暫時改寫如下, 但必須 .67 的防火牆開 11079 port 才能測試
        //task1.execute("http://192.168.1.67:11079/APQPService/updateQT1", data.toString());

	}

	/**
	 * 將QT =>TAB 2 =>Package Information user編輯資料上傳到webservice
	 * 
	 * @param action
	 *            (Save,Confirm,Changes)
	 */
	private void saveData2(final String action) {
        return;
		/*
		// System.out.println("===>Line number: "+new
		// Throwable().getStackTrace()[0].getLineNumber());

		HttpPostAsyncTask task1 = new HttpPostAsyncTask();
		JSONObject data = null;
		String func = "";

		func = "updateQT2";
		data = getInputData2(action);
		task1.setCallback(new ICallback() {
			@Override
			public void doWork(Object obj) {

				try {

					JSONObject jsonObject = new JSONObject((String) obj);
					if (jsonObject.getString("success").equals("false")) {
						showDialog("error", jsonObject.getString("remark"));
					} else {
						JSONObject data = jsonObject.getJSONObject("data");
						btnEdit.setTag(data.getString("editable"));
						btnChange.setTag(data.getString("CONFIRM_CODE"));
						VERSION = data.getString("VERSION");
						//xa593 = data.getString("xa593");
						showDialog(action + " success");

					}

					// showApplicationDialog(mView);
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		});
		task1.execute((String) super.getWebServiceUrl() + func, data.toString());
        */
	}


	/**
	 * Screenshot_20150410_18.jpg
	 * 
	 * @param layoutid
	 */
	/*
	private void setLayoutUI(int layoutid) {

		// System.out.println("===>Line number: "+new
		// Throwable().getStackTrace()[0].getLineNumber());

		String[] qtno = getQtNo().split("-");
		QT_TYPE = qtno[0];
		QT_NO = qtno[1];
		tab1.setVisibility(View.VISIBLE);
		tab2.setVisibility(View.GONE);

		b1 = (Button) mView.findViewById(R.id.b1);
		b2 = (Button) mView.findViewById(R.id.b2);

		b1.setText("Customer");
		b2.setText("Detail");

		b2.setTag(0);

			b1.setOnClickListener(new OnClickListener() {
				public void onClick(View v) {

					vwSubTitle.setText(b1.getText());
					//if (tabbar != null)
					//	tabbar.setVisibility(RelativeLayout.GONE);
					if (tab2 != null
							&& tab2.getVisibility() == RelativeLayout.VISIBLE)
						tab2.setVisibility(RelativeLayout.GONE);

					tab1.setVisibility(RelativeLayout.VISIBLE);
					if (cmdbar != null && !cmdbar.isShown()) {
						cmdbar.setVisibility(RelativeLayout.VISIBLE);
					}
				}
			});
			b2.setOnClickListener(new OnClickListener() {
				public void onClick(View v) {

					int tag = (Integer) v.getTag();
					vwSubTitle.setText(b2.getText());
					//if (tabbar != null)
					//	tabbar.setVisibility(RelativeLayout.GONE);
					if (tab1 != null
							&& tab1.getVisibility() == RelativeLayout.VISIBLE)
						tab1.setVisibility(RelativeLayout.GONE);
					tab2.setVisibility(RelativeLayout.VISIBLE);

					//if (cmdbar != null && !cmdbar.isShown()) {
					//	cmdbar.setVisibility(RelativeLayout.VISIBLE);
					//}
					if (tag != 2) {
						queryData((String) getWebServiceUrl() + "queryQT2",
								queryQT2(QT_TYPE, QT_NO),
								new IDataReceiveListener() {
									public void onReceiveData(Object obj) {
										loadData2(obj);
										b2.setTag(2);
									}
								});
					}
				}
			});


	}
	*/

	@Override
	public void onMore() {
		// TODO Auto-generated method stub
		// Runnable =>被處理的事件
		// Handler =>處理器


	}
	@Override
	public void onRefresh() {
		// TODO Auto-generated method stub
		// Runnable =>被處理的事件
		// Handler =>處理器


	}

	private void initPullDownView(View view) {

		/*
		 * 1.使用PullDownView 2.設置OnPullDownListener 3.從mPullDownView里面獲取ListView
		 */

		mPullDownView = (PullDownView) view.findViewById(R.id.qtlistview2);
		if (mPullDownView == null)
			return;
		mPullDownView.setOnPullDownListener(this);
		lstQt = mPullDownView.getListView();
		lstQt.setOnItemClickListener(this);
		ColorDrawable cd = new ColorDrawable(R.color.list_divider);
		lstQt.setDivider(cd);
		lstQt.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
		lstQt.setDividerHeight(1);
		lstQt.setHeaderDividersEnabled(true);
		// adapter2 = new
		// SimpleAdapter(context,mStrings,R.layout.pulldown_item,new
		// String[]{"title","content"},new int[]
		// {R.id.msg_title2,R.id.msg_content} );
		qtItems2 = new ArrayList<QtItem2>();
		adapter2 = new QtListAdapter2(context, qtItems2);
		lstQt.setAdapter(adapter2);

        //20151211 : 暫時 remark
		//mPullDownView.enableAutoFetchMore(true, 1);

	}

	@Override
	/**
	 * 按下列表的某一列資料,觸發的action
	 */
	public void onItemClick(AdapterView<?> parent, View view, int position,
							long id) {

		// TODO Auto-generated method stub
		final QtItem2 item2 = (QtItem2) qtItems2.get(position);
		Bundle bundle2 = new Bundle();
		bundle2.putString("M1_QT_TYPE" , item2.getM1_QT_TYPE ());
		bundle2.putString("M1_QT_NO"   , item2.getM1_QT_NO   ());
		bundle2.putString("M1_QT_SEQ"  , item2.getM1_QT_SEQ  ());
		bundle2.putString("AP_TYPE"    , item2.getAP_TYPE    ());
		bundle2.putString("AP_NO"      , item2.getAP_NO());
		bundle2.putString("DRAWING_REF", item2.getDRAWING_REF());
		bundle2.putString("DESCRIPTION", item2.getDESCRIPTION());
		bundle2.putString("APQP_NO"    , item2.getAPQP_NO());
		bundle2.putString("CURRENCY"   , CURRENCY.getText().toString());

		//20160111 : 控制變顏色
		adapter2.setSelectItem(position);
		adapter2.notifyDataSetInvalidated();

		// 要跟其他Fragment溝通,需要用getActivity()回到Activity
		//((MainActivity) getActivity()).callQtDataActivity3(bundle2);

		//20151210暫時 remark
		callQt3DataActivity(bundle2);

	}

	private  void callQt3DataActivity(Bundle b)
	{
        //-----------------------------------------------
		//----------------------------
		//20151227 : 新寫法
		//FragmentManager fragmentManager = getFragmentManager();
		//fragmentManager.beginTransaction()
		//		.hide(fragmentManager.findFragmentById(this.getId())).commit();
		//fragmentManager.beginTransaction()
		//		.add(R.id.content_frame, activity, "act_qt_adv_search").commit();
		//fragmentManager.beginTransaction().addToBackStack(null);
		//fragmentManager.beginTransaction().show(activity).commit();


		//-----------------------------------------------

		QtDataActivity3 activity = new QtDataActivity3();
		activity.parent=this;
		activity.setCallback(new BaseFragment.ICallback() {
			@Override
			public void doWork(Object object) {
				//bundle_adv = (Bundle) object;
                queryData((String) getWebServiceUrl() + "queryQT2",
                        queryQT2(QT_TYPE, QT_NO),
                        new IDataReceiveListener() {
                            public void onReceiveData(Object obj) {
                                loadData2(obj);
                                b2.setTag(2);
                            }
                        });

			}

		});

		// disable next statement
		activity.setFragmentManager(fragmentManager) ;

		Fragment fragment = null;
		FragmentManager fragmentManager = getFragmentManager();

		fragment = (Fragment) activity;
		fragment.setRetainInstance(true);
		fragment.setArguments(b);
		fragmentManager.beginTransaction().add(R.id.content_frame, fragment).commit();
		fragmentManager.beginTransaction().hide(this).commit();
		fragmentManager.beginTransaction().show(fragment).commit();

        //FragmentManager fragmentManager = getFragmentManager();
        //fragmentManager.beginTransaction().hide(fragmentManager.findFragmentById(this.getId())).commit();
        //fragmentManager.beginTransaction().add(R.id.content_frame, activity, "act_qt_adv_search").commit();
        //fragmentManager.beginTransaction().addToBackStack(null);
        //fragmentManager.beginTransaction().show(activity).commit();
        
        
	}

	private void queryData(int Message) {

		String json = "";
		// String
		// url="http://59.125.146.7:8080/QTService/GetMsgList?USERID=mis&PAGE="+Integer.toString(page)+"&WWID=13145774WWGlobal999988msg";
		String url = super.getWebServiceUrl() + "queryQT";
		JSONObject jsonObject = new JSONObject();
		JSONObject data = new JSONObject();
		try
		{
			//sTmp=this.editSearch.getText().toString().trim();
			//data.accumulate("QueryValue", this.editSearch.getText().toString().trim());

			//data.accumulate("QueryValue", sTmp);
			data.accumulate("QueryValue", "");

			jsonObject.accumulate("userid", super.getLoginUser());
			jsonObject.accumulate("WWID", "13145774WWGlobal999988QTquery999");
			jsonObject.accumulate("data", data);
			jsonObject.accumulate("page", Integer.toString(page));
			// new HttpPostAsyncTask().execute(url,jsonObject.toString());
			super.postRequest(url, jsonObject, Message);

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// new HttpGetAsyncTask().execute(url);

	}

	//---------------------------------------------------------------------
	// QT_DATE Dialog Beg
	//---------------------------------------------------------------------
	//Date Listener 定義在 showDateDialog 中
	DatePickerDialog.OnDateSetListener mDateSetListener = new DatePickerDialog.OnDateSetListener() {

		public void onDateSet(DatePicker view, int year, int monthOfYear,
							  int dayOfMonth) {

			mYear = year;
			mMonth = monthOfYear;
			mDay = dayOfMonth;
			mEdit.setText(String.format("%d%02d%02d", mYear, mMonth + 1, mDay));
		}
	};

	public void showDateDialog(View view) {
		final Calendar c = Calendar.getInstance();
		mYear  = c.get(Calendar.YEAR        );
		mMonth = c.get(Calendar.MONTH       );
		mDay   = c.get(Calendar.DAY_OF_MONTH);
		// showDialog(DATE_DIALOG_ID);
		mEdit = (EditText) view;
		DatePickerDialog d = new DatePickerDialog(getActivity(),
				mDateSetListener, mYear, mMonth, mDay);

		d.show();

	}

	//---------------------------------------------------------------------
	// QT_DATE Dialog End
	//---------------------------------------------------------------------

	private void addNewQT2(final String action)
	{

		FragmentManager fragmentManager = getFragmentManager();


		BaseFragment.HttpPostAsyncTask task1 = new BaseFragment.HttpPostAsyncTask();
		JSONObject data = null;
		String func = "";


		func = "newQT2";
		data = getInputData2(action);//get data from user input
		task1.execute((String) getResources().getString(R.string.WebServiceUrl) + func, data.toString());//執行點

		task1.setCallback(new ICallback() {
			@Override
			public void doWork(Object obj) {

				//System.out.println("==>"+new Throwable().getStackTrace()[0].getClassName()+" > "+new Throwable().getStackTrace()[0].getMethodName());
				//System.out.println("===>Line number: "+new Throwable().getStackTrace()[0].getLineNumber());

				try {

					JSONObject jsonObject = new JSONObject((String) obj);
					if (jsonObject.getString("success").equals("false")) {


						//showDialog("error",jsonObject.getString("remark"));
					} else {//成功
						JSONObject data = jsonObject.getJSONObject("data");
//							//System.out.println("==================>success: "+data);

						//Bundle bundle = new Bundle();
						//bundle.putString("qtno", data.getString("QT_TYPE") + "-" + data.getString("QT_NO"));

						//20151224: 下面這段程式碼移動到 addNewQT2

   					    // TODO Auto-generated method stub
					    Bundle bundle2 = new Bundle();
					    bundle2.putString("M1_QT_TYPE" , QT_TYPE);
					    bundle2.putString("M1_QT_NO"   , QT_NO);
					    bundle2.putString("M1_QT_SEQ"  , data.getString("M1_QT_SEQ"));
					    bundle2.putString("AP_TYPE"    , "");
					    bundle2.putString("AP_NO"      , "");
					    bundle2.putString("DRAWING_REF", "");
					    bundle2.putString("DESCRIPTION", "");
					    bundle2.putString("APQP_NO"    , "");
                        bundle2.putString("CURRENCY"   , CURRENCY.getText().toString());
					    bundle2.putString("func"       , "newQT2");

    					// 要跟其他Fragment溝通,需要用getActivity()回到Activity
					    //((MainActivity) getActivity()).callQtDataActivity3(bundle2);

					    //20151210暫時 remark
					    callQt3DataActivity(bundle2);

					}
					// showApplicationDialog(mView);
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		});

	}

	public void b1_onClick(View v) {

		//btnSave 顯示時 不用再動作
		if (btnSave.getVisibility() == View.VISIBLE) {
			return;
		}

		//20151211 : 改變顏色
		r1.setBackgroundColor(getResources().getColor(R.color.lightgreen));
		r2.setBackgroundColor(getResources().getColor(R.color.white));
		vwSubTitle.setText(b1.getText());

		//if (tabbar != null)
		//	tabbar.setVisibility(RelativeLayout.GONE);

		if (tab2 != null
				&& tab2.getVisibility() == RelativeLayout.VISIBLE) {

			tab2.setVisibility(RelativeLayout.GONE);

			btnEdit   .setVisibility(View.GONE);
			btnSave   .setVisibility(View.GONE);
			btnCancel .setVisibility(View.GONE);
			btnChange .setVisibility(View.GONE);
			btnConfirm.setVisibility(View.GONE);
			btnPdf    .setVisibility(View.GONE);

			btnAdd2   .setVisibility(View.GONE);

			if (btnChange.getTag().equals("Y")) {
				btnEdit   .setVisibility(View.VISIBLE);
				btnPdf    .setVisibility(View.VISIBLE);
			} else {
				btnEdit   .setVisibility(View.VISIBLE);
				btnConfirm.setVisibility(View.VISIBLE);
			}

			queryData();//重讀資料

		}

		tab1.setVisibility(RelativeLayout.VISIBLE);
		if (cmdbar != null && !cmdbar.isShown()) {
			cmdbar.setVisibility(RelativeLayout.VISIBLE);
		}

	}

	private  void callQtPdfActivity(Bundle b)
	{
		//-----------------------------------------------
		QtPdfActivity activity = new QtPdfActivity();
		activity.parent=this;
		activity.setCallback(new BaseFragment.ICallback() {
			@Override
			public void doWork(Object object) {

				Bundle b=(Bundle)object;
//				//20160114
//				bundle.putString("Price"          , sPrice        );
//				bundle.putString("Language"       , sLanguage     );
//				bundle.putString("Detail"         , sDetail       );
//				bundle.putString("ShowBank"       , sShowBank     );
//				bundle.putString("ShowTotal"      , sShowTotal    );
//				bundle.putString("ShowPercent"    , sShowPercent  );
//				bundle.putString("ShowSignature"  , sShowSignature);
//				bundle.putString("ShowStamp"      , sShowStamp    );
//

				queryDataPdf(b);

			}

		});

		// disable next statement
		activity.setFragmentManager(fragmentManager) ;

		Fragment fragment = null;
		FragmentManager fragmentManager = getFragmentManager();

		fragment = (Fragment) activity;
		fragment.setRetainInstance(true);
		fragment.setArguments(b);
		fragmentManager.beginTransaction().add(R.id.content_frame, fragment).commit();
		fragmentManager.beginTransaction().hide(this).commit();
		fragmentManager.beginTransaction().show(fragment).commit();

	}


}
