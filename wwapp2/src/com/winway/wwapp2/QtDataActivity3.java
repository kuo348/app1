//No.15041501 add xa59r and show animate after save,change,confirm  by cooper 15-04-15
//
//
package com.winway.wwapp2;

//import java.io.BufferedReader;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.DialogPreference;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

import com.winway.wwapp2.PullDownView.OnPullDownListener;

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
 * getInputData3 =>
 *
 */
public class QtDataActivity3 extends BaseFragment  {
	private Context context;//,
	private Bundle bundle;
	private View mView = null;
	private int ACTION_MESSAGE;
	private Button btnLoadPackageInfo17, btnLoadPackageInfo27;
	// FinePitch ProbeCard
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
	private RelativeLayout qttab2, qttab3;//20151222
	//private LinearLayout tab1, tab2;

	private LinearLayout tab3;
	private LinearLayout tab4;//20151214
	private LinearLayout tab5;//20151215

	//private Button b1, b2
	private Button b3;
    private Button b4;
    private Button b4_Edit, b4_Delete, b4_Save, b4_Cancel;
	private Button b5;
	private TextView l1, l2, l3, l4, l5, l6;
	//private RelativeLayout r1, r2
	private RelativeLayout r3;
	private RelativeLayout r4;
	private RelativeLayout r5;
	private Button btnEdit, btnSave, btnChange, btnConfirm;
    private Button btnCancel;//20151230
    private Button btnDelete;
	private Button btnAdd4, btnAdd5;
    private Button btnCallApqp, btnCallBom;
	private Button btnEdit_M1, btnSave_M1;
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
	private String QT_TYPE, QT_NO, QT_SEQ;//Key
	private String CURRENCY;
    private String M12_pos, M12_act;//
    private String M12_tmp_SEQ             ;//key
    private String M12_tmp_DETAIL_CLASS    ;
    private String M12_tmp_DETAIL_PARTNO   ;
    private String M12_tmp_DETAIL_NAME     ;
    private String M12_tmp_DETAIL_QTY      ;
    private String M12_tmp_DETAIL_UT_PRICE ;
    private String M12_tmp_DETAIL_PRICE    ;

	//private String M12_tmp_SUM             ;

	private String M11_pos, M11_act;//
	private String M11_tmp_SEQ         ;//key
	private String M11_tmp_QTY1        ;
	private String M11_tmp_QTY2        ;
	private String M11_tmp_UNIT        ;
	private String M11_tmp_LIST_PRICE  ;
	private String M11_tmp_SALE_PERCENT;
	private String M11_tmp_UNIT_PRICE  ;
	private String M11_tmp_TOTAL       ;

	//private String M11_tmp_SUM ;

	//-------------------------------------------------
	//QT Vars beg
	//-------------------------------------------------
	//WF_ORD02M1
	private EditText M1_QT_TYPE     ;//ed_M1_QT_TYPE
	private EditText M1_QT_NO       ;//ed_M1_QT_NO
	private EditText M1_QT_SEQ      ;//ed_M1_QT_SEQ
	private EditText AP_TYPE        ;//ed_AP_TYPE
	private EditText AP_NO          ;//ed_AP_NO
	private EditText DRAWING_REF    ;//ed_DRAWING_REF
	private EditText DESCRIPTION    ;//ed_DESCRIPTION
	private EditText APQP_NO        ;//ed_APQP_NO

	//WF_ORD02M12
	//private EditText M12_QT_TYPE    ;//ed_M12_QT_TYPE
	//private EditText M12_QT_NO      ;//ed_M12_QT_NO
	//private EditText M12_QT_SEQ     ;//ed_M12_QT_SEQ
	//private EditText M12_SEQ        ;//ed_M12_SEQ
	//private EditText DETAIL_CLASS   ;//ed_DETAIL_CLASS
	//private EditText DETAIL_PARTNO  ;//ed_DETAIL_PARTNO
	//private EditText DETAIL_NAME    ;//ed_DETAIL_NAME
	//private EditText DETAIL_QTY     ;//ed_DETAIL_QTY
	//private EditText DETAIL_UT_PRICE;//ed_DETAIL_UT_PRICE
	//private EditText DETAIL_PRICE   ;//ed_DETAIL_PRICE

	private TextView R99_lb_M12_SUM         ;//R99_lb_M12_SUM

	private EditText R01_M12_QT_TYPE        ;//ed_M12_QT_TYPE
	private EditText R01_M12_QT_NO          ;//ed_M12_QT_NO
	private EditText R01_M12_QT_SEQ         ;//ed_M12_QT_SEQ
	private EditText R01_M12_SEQ            ;//ed_M12_SEQ
	private EditText R01_M12_DETAIL_CLASS   ;//ed_M12_DETAIL_CLASS
	private EditText R01_M12_DETAIL_PARTNO  ;//ed_M12_DETAIL_PARTNO
	private EditText R01_M12_DETAIL_NAME    ;//ed_M12_DETAIL_NAME
	private EditText R01_M12_DETAIL_QTY     ;//ed_M12_DETAIL_QTY
	private EditText R01_M12_DETAIL_UT_PRICE;//ed_M12_DETAIL_UT_PRICE
	private EditText R01_M12_DETAIL_PRICE   ;//ed_M12_DETAIL_PRICE

	private EditText R02_M12_QT_TYPE        ;//ed_M12_QT_TYPE
	private EditText R02_M12_QT_NO          ;//ed_M12_QT_NO
	private EditText R02_M12_QT_SEQ         ;//ed_M12_QT_SEQ
	private EditText R02_M12_SEQ            ;//ed_M12_SEQ
	private EditText R02_M12_DETAIL_CLASS   ;//ed_M12_DETAIL_CLASS
	private EditText R02_M12_DETAIL_PARTNO  ;//ed_M12_DETAIL_PARTNO
	private EditText R02_M12_DETAIL_NAME    ;//ed_M12_DETAIL_NAME
	private EditText R02_M12_DETAIL_QTY     ;//ed_M12_DETAIL_QTY
	private EditText R02_M12_DETAIL_UT_PRICE;//ed_M12_DETAIL_UT_PRICE
	private EditText R02_M12_DETAIL_PRICE   ;//ed_M12_DETAIL_PRICE

	private EditText R03_M12_QT_TYPE        ;//ed_M12_QT_TYPE
	private EditText R03_M12_QT_NO          ;//ed_M12_QT_NO
	private EditText R03_M12_QT_SEQ         ;//ed_M12_QT_SEQ
	private EditText R03_M12_SEQ            ;//ed_M12_SEQ
	private EditText R03_M12_DETAIL_CLASS   ;//ed_M12_DETAIL_CLASS
	private EditText R03_M12_DETAIL_PARTNO  ;//ed_M12_DETAIL_PARTNO
	private EditText R03_M12_DETAIL_NAME    ;//ed_M12_DETAIL_NAME
	private EditText R03_M12_DETAIL_QTY     ;//ed_M12_DETAIL_QTY
	private EditText R03_M12_DETAIL_UT_PRICE;//ed_M12_DETAIL_UT_PRICE
	private EditText R03_M12_DETAIL_PRICE   ;//ed_M12_DETAIL_PRICE

	private EditText R04_M12_QT_TYPE        ;//ed_M12_QT_TYPE
	private EditText R04_M12_QT_NO          ;//ed_M12_QT_NO
	private EditText R04_M12_QT_SEQ         ;//ed_M12_QT_SEQ
	private EditText R04_M12_SEQ            ;//ed_M12_SEQ
	private EditText R04_M12_DETAIL_CLASS   ;//ed_M12_DETAIL_CLASS
	private EditText R04_M12_DETAIL_PARTNO  ;//ed_M12_DETAIL_PARTNO
	private EditText R04_M12_DETAIL_NAME    ;//ed_M12_DETAIL_NAME
	private EditText R04_M12_DETAIL_QTY     ;//ed_M12_DETAIL_QTY
	private EditText R04_M12_DETAIL_UT_PRICE;//ed_M12_DETAIL_UT_PRICE
	private EditText R04_M12_DETAIL_PRICE   ;//ed_M12_DETAIL_PRICE

	private EditText R05_M12_QT_TYPE        ;//ed_M12_QT_TYPE
	private EditText R05_M12_QT_NO          ;//ed_M12_QT_NO
	private EditText R05_M12_QT_SEQ         ;//ed_M12_QT_SEQ
	private EditText R05_M12_SEQ            ;//ed_M12_SEQ
	private EditText R05_M12_DETAIL_CLASS   ;//ed_M12_DETAIL_CLASS
	private EditText R05_M12_DETAIL_PARTNO  ;//ed_M12_DETAIL_PARTNO
	private EditText R05_M12_DETAIL_NAME    ;//ed_M12_DETAIL_NAME
	private EditText R05_M12_DETAIL_QTY     ;//ed_M12_DETAIL_QTY
	private EditText R05_M12_DETAIL_UT_PRICE;//ed_M12_DETAIL_UT_PRICE
	private EditText R05_M12_DETAIL_PRICE   ;//ed_M12_DETAIL_PRICE

	private EditText R06_M12_QT_TYPE        ;//ed_M12_QT_TYPE
	private EditText R06_M12_QT_NO          ;//ed_M12_QT_NO
	private EditText R06_M12_QT_SEQ         ;//ed_M12_QT_SEQ
	private EditText R06_M12_SEQ            ;//ed_M12_SEQ
	private EditText R06_M12_DETAIL_CLASS   ;//ed_M12_DETAIL_CLASS
	private EditText R06_M12_DETAIL_PARTNO  ;//ed_M12_DETAIL_PARTNO
	private EditText R06_M12_DETAIL_NAME    ;//ed_M12_DETAIL_NAME
	private EditText R06_M12_DETAIL_QTY     ;//ed_M12_DETAIL_QTY
	private EditText R06_M12_DETAIL_UT_PRICE;//ed_M12_DETAIL_UT_PRICE
	private EditText R06_M12_DETAIL_PRICE   ;//ed_M12_DETAIL_PRICE

    private EditText R99_M12_SUM            ;//ed_M12_SUM

	private TableRow    R01_M12_tr               ;
	private TableRow    R02_M12_tr               ;
	private TableRow    R03_M12_tr               ;
	private TableRow    R04_M12_tr               ;
	private TableRow    R05_M12_tr               ;
	private TableRow    R06_M12_tr               ;

    private TableRow    R99_M12_tr               ;//Footer


    //WF_ORD02M11
    private TextView R99_lb_M11_SUM         ;//R99_lb_M11_SUM
    private TextView R99_lb_M11_SUM_TOTAL   ;//R99_lb_M11_SUM_TOTAL

    private EditText R01_M11_QT_TYPE        ;//ed_M11_QT_TYPE
	private EditText R01_M11_QT_NO          ;//ed_M11_QT_NO
	private EditText R01_M11_QT_SEQ         ;//ed_M11_QT_SEQ
	private EditText R01_M11_SEQ            ;//ed_M11_SEQ
	private EditText R01_M11_QTY1           ;//ed_M11_QTY1
	private EditText R01_M11_QTY2           ;//ed_M11_QTY2
	private EditText R01_M11_UNIT           ;//ed_M11_UNIT
	private EditText R01_M11_LIST_PRICE     ;//ed_M11_LIST_PRICE
	private EditText R01_M11_SALE_PERCENT   ;//ed_M11_SALE_PERCENT
	private EditText R01_M11_UNIT_PRICE     ;//ed_M11_UNIT_PRICE
	private EditText R01_M11_TOTAL          ;//ed_M11_TOTAL

    private EditText R02_M11_QT_TYPE        ;//ed_M11_QT_TYPE
	private EditText R02_M11_QT_NO          ;//ed_M11_QT_NO
	private EditText R02_M11_QT_SEQ         ;//ed_M11_QT_SEQ
	private EditText R02_M11_SEQ            ;//ed_M11_SEQ
	private EditText R02_M11_QTY1   ;//ed_M11_QTY1
	private EditText R02_M11_QTY2  ;//ed_M11_QTY2
	private EditText R02_M11_UNIT    ;//ed_M11_UNIT
	private EditText R02_M11_LIST_PRICE     ;//ed_M11_LIST_PRICE
	private EditText R02_M11_SALE_PERCENT;//ed_M11_SALE_PERCENT
	private EditText R02_M11_UNIT_PRICE   ;//ed_M11_UNIT_PRICE
	private EditText R02_M11_TOTAL   ;//ed_M11_TOTAL

	private EditText R03_M11_QT_TYPE        ;//ed_M11_QT_TYPE
	private EditText R03_M11_QT_NO          ;//ed_M11_QT_NO
	private EditText R03_M11_QT_SEQ         ;//ed_M11_QT_SEQ
	private EditText R03_M11_SEQ     ;//ed_M11_SEQ
	private EditText R03_M11_QTY1   ;//ed_M11_QTY1
	private EditText R03_M11_QTY2  ;//ed_M11_QTY2
	private EditText R03_M11_UNIT    ;//ed_M11_UNIT
	private EditText R03_M11_LIST_PRICE     ;//ed_M11_LIST_PRICE
	private EditText R03_M11_SALE_PERCENT;//ed_M11_SALE_PERCENT
	private EditText R03_M11_UNIT_PRICE   ;//ed_M11_UNIT_PRICE
	private EditText R03_M11_TOTAL   ;//ed_M11_TOTAL

	private EditText R04_M11_QT_TYPE        ;//ed_M11_QT_TYPE
	private EditText R04_M11_QT_NO          ;//ed_M11_QT_NO
	private EditText R04_M11_QT_SEQ         ;//ed_M11_QT_SEQ
	private EditText R04_M11_SEQ     ;//ed_M11_SEQ
	private EditText R04_M11_QTY1   ;//ed_M11_QTY1
	private EditText R04_M11_QTY2  ;//ed_M11_QTY2
	private EditText R04_M11_UNIT    ;//ed_M11_UNIT
	private EditText R04_M11_LIST_PRICE     ;//ed_M11_LIST_PRICE
	private EditText R04_M11_SALE_PERCENT;//ed_M11_SALE_PERCENT
	private EditText R04_M11_UNIT_PRICE   ;//ed_M11_UNIT_PRICE
	private EditText R04_M11_TOTAL   ;//ed_M11_TOTAL

	private EditText R05_M11_QT_TYPE        ;//ed_M11_QT_TYPE
	private EditText R05_M11_QT_NO          ;//ed_M11_QT_NO
	private EditText R05_M11_QT_SEQ         ;//ed_M11_QT_SEQ
	private EditText R05_M11_SEQ     ;//ed_M11_SEQ
	private EditText R05_M11_QTY1           ;//ed_M11_QTY1
	private EditText R05_M11_QTY2           ;//ed_M11_QTY2
	private EditText R05_M11_UNIT           ;//ed_M11_UNIT
	private EditText R05_M11_LIST_PRICE     ;//ed_M11_LIST_PRICE
	private EditText R05_M11_SALE_PERCENT   ;//ed_M11_SALE_PERCENT
	private EditText R05_M11_UNIT_PRICE     ;//ed_M11_UNIT_PRICE
	private EditText R05_M11_TOTAL          ;//ed_M11_TOTAL

    private EditText R99_M11_SUM            ;//ed_M11_SUM
    private EditText R99_M11_SUM_TOTAL      ;//ed_M11_SUM_TOTAL

	private TableRow    R01_M11_tr               ;
	private TableRow    R02_M11_tr               ;
	private TableRow    R03_M11_tr               ;
	private TableRow    R04_M11_tr               ;
	private TableRow    R05_M11_tr               ;

    private TableRow    R99_M11_tr               ;//Footer


    private Button R01_M12_btnEdit   ;
    private Button R01_M12_btnDelete ;
    private Button R01_M12_btnSave   ;
    private Button R01_M12_btnCancel ;

    private Button R02_M12_btnEdit   ;
    private Button R02_M12_btnDelete ;
    private Button R02_M12_btnSave   ;
    private Button R02_M12_btnCancel ;

    private Button R03_M12_btnEdit   ;
    private Button R03_M12_btnDelete ;
    private Button R03_M12_btnSave   ;
    private Button R03_M12_btnCancel ;

    private Button R04_M12_btnEdit   ;
    private Button R04_M12_btnDelete ;
    private Button R04_M12_btnSave   ;
    private Button R04_M12_btnCancel ;

    private Button R05_M12_btnEdit   ;
    private Button R05_M12_btnDelete ;
    private Button R05_M12_btnSave   ;
    private Button R05_M12_btnCancel ;

    private Button R06_M12_btnEdit   ;
    private Button R06_M12_btnDelete ;
    private Button R06_M12_btnSave   ;
    private Button R06_M12_btnCancel ;

	private Button R01_M11_btnEdit   ;
	private Button R01_M11_btnDelete ;
	private Button R01_M11_btnSave   ;
	private Button R01_M11_btnCancel ;

	private Button R02_M11_btnEdit   ;
	private Button R02_M11_btnDelete ;
	private Button R02_M11_btnSave   ;
	private Button R02_M11_btnCancel ;

	private Button R03_M11_btnEdit   ;
	private Button R03_M11_btnDelete ;
	private Button R03_M11_btnSave   ;
	private Button R03_M11_btnCancel ;

	private Button R04_M11_btnEdit   ;
	private Button R04_M11_btnDelete ;
	private Button R04_M11_btnSave   ;
	private Button R04_M11_btnCancel ;

	private Button R05_M11_btnEdit   ;
	private Button R05_M11_btnDelete ;
	private Button R05_M11_btnSave   ;
	private Button R05_M11_btnCancel ;

	//private ArrayList<QtItem4> qtItems4;
	private int page = 1;

    private boolean bYes;
    private boolean bToQT4;//true:是新資料 N:從 QtList 點選
	//private QtListAdapter adapter2;
	//private QtListAdapter4 adapter4;
	//private PullDownView mPullDownView;
	//private TypedArray navMenuIcons;
	//private ListView lstQt;
	//-------------------------------------------------

	private OnEditorActionListener EditorListener = new OnEditorActionListener() {
		@Override
		public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {

			// TODO Auto-generated method stub
			return false;
		}
	};
	DatePickerDialog.OnDateSetListener mDateSetListener = new DatePickerDialog.OnDateSetListener() {

		public void onDateSet(DatePicker view, int year, int monthOfYear,
				int dayOfMonth) {

			mYear = year;
			mMonth = monthOfYear;
			mDay = dayOfMonth;
			mEdit.setText(String.format("%d%02d%02d", mYear, mMonth + 1, mDay));
		}
	};

	/**
	 * Function C
	 */
	private void closeFragment() {
		//20151228 : 原寫法
		//if (this.parent != null) {
		//	this.fragmentManager.beginTransaction().remove(this).commit();
		//	this.fragmentManager.beginTransaction().show(parent).commit();
		//}

		//----------------------------------------
		//新寫法
		//Bundle bundle = new Bundle();
		//bundle.putString("action"        , "Delete");
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

		//----------------------------------------
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

	private JSONObject queryQT4(String QT_TYPE, String QT_NO) {

        hideRows_M12();//畫面清除

		JSONObject jsonObj = new JSONObject();
		try {

			JSONObject data = new JSONObject();

			//String[] qtno = getQtNo().split("-");
			//if (qtno.length == 2) {
				data.accumulate("M12_QT_TYPE", bundle.getString("M1_QT_TYPE"));
				data.accumulate("M12_QT_NO"  , bundle.getString("M1_QT_NO"));
                data.accumulate("M12_QT_SEQ" , bundle.getString("M1_QT_SEQ"));
			//}
            //QT_TYPE = bundle.getString("M1_QT_TYPE");
            //QT_NO   = bundle.getString("M1_QT_NO");
            //QT_SEQ  = bundle.getString("M1_QT_SEQ");


			jsonObj.accumulate("userid", super.getLoginUser());
			//jsonObj.accumulate("WWID", "13145774WWGlobal999988qt2999");
			jsonObj.accumulate("WWID", "13145774WWGlobal999988QTquery4999");
			jsonObj.accumulate("data", data);
			return jsonObj;
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;

	}

	private JSONObject queryQT5(String QT_TYPE, String QT_NO) {

		hideRows_M11();//畫面清除

		JSONObject jsonObj = new JSONObject();
		try {

			JSONObject data = new JSONObject();

			//String[] qtno = getQtNo().split("-");
			//if (qtno.length == 2) {
			data.accumulate("M11_QT_TYPE", bundle.getString("M1_QT_TYPE"));
			data.accumulate("M11_QT_NO"  , bundle.getString("M1_QT_NO"));
			data.accumulate("M11_QT_SEQ" , bundle.getString("M1_QT_SEQ"));
			//}
			//QT_TYPE = bundle.getString("M1_QT_TYPE");
			//QT_NO   = bundle.getString("M1_QT_NO");
			//QT_SEQ  = bundle.getString("M1_QT_SEQ");


			jsonObj.accumulate("userid", super.getLoginUser());
			//jsonObj.accumulate("WWID", "13145774WWGlobal999988qt2999");
			jsonObj.accumulate("WWID", "13145774WWGlobal999988QTquery5999");
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
	private JSONObject getInputData3(final String action) {
		try {
			JSONObject data = new JSONObject();
			JSONObject qt3 = new JSONObject();
			JSONObject jsonObj = new JSONObject();
			jsonObj.accumulate("userid", super.getLoginUser());
			jsonObj.accumulate("WWID", "13145774WWGlobal999988qt3999");
			//String[] qtno = this.getQtNo().split("-");
			//if (qtno.length <= 1)
			//	return data;

            if (AP_TYPE      .getText().toString()==null){AP_TYPE    .setText("");}
            if (AP_NO        .getText().toString()==null){AP_NO      .setText("");}
            if (DRAWING_REF  .getText().toString()==null){DRAWING_REF.setText("");}
            if (APQP_NO      .getText().toString()==null){APQP_NO    .setText("");}
            
            if (AP_NO.getText().toString() == "") {
                AP_TYPE.setText("");
            }
            else{
                AP_TYPE.setText("AP");
            }
			
			//String QT_TYPE = qtno[0];
			//String QT_NO = qtno[1];

			data.accumulate("QT_TYPE", QT_TYPE);
			data.accumulate("QT_NO"  , QT_NO  );
			data.accumulate("VERSION", VERSION);//20160112 : 還原過來
			//下面這一行尚未完成, 必須再修改
			data.accumulate("CONFIRM_CODE", btnChange.getTag().toString());

			data.accumulate("M1_QT_TYPE"      , M1_QT_TYPE .getText() );
			data.accumulate("M1_QT_NO"        , M1_QT_NO   .getText() );
			data.accumulate("M1_QT_SEQ"       , M1_QT_SEQ  .getText() );
            data.accumulate("AP_TYPE"         , AP_TYPE    .getText() );
            data.accumulate("AP_NO"           , AP_NO      .getText() );
			data.accumulate("DRAWING_REF"     , DRAWING_REF.getText() );
			data.accumulate("DESCRIPTION"     , DESCRIPTION.getText() );
			data.accumulate("APQP_NO"         , APQP_NO    .getText() );

			qt3.accumulate("action", action);
			qt3.accumulate("qt3", data);
			jsonObj.accumulate("data", qt3);
			return jsonObj;
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

    private JSONObject getInputData3_Delete(final String action) {
        try {
            JSONObject data = new JSONObject();
            JSONObject qt3 = new JSONObject();
            JSONObject jsonObj = new JSONObject();
            jsonObj.accumulate("userid", super.getLoginUser());
            jsonObj.accumulate("WWID", "13145774WWGlobal999988delqt3999");
            //String[] qtno = this.getQtNo().split("-");
            //if (qtno.length <= 1)
            //	return data;

            if (AP_TYPE      .getText().toString()==null){AP_TYPE    .setText("");}
            if (AP_NO        .getText().toString()==null){AP_NO      .setText("");}
            if (DRAWING_REF  .getText().toString()==null){DRAWING_REF.setText("");}
            if (APQP_NO      .getText().toString()==null){APQP_NO    .setText("");}

            if (AP_NO.getText().toString() == "") {
                AP_TYPE.setText("");
            }
            else{
                AP_TYPE.setText("AP");
            }


            //String QT_TYPE = qtno[0];
            //String QT_NO = qtno[1];

            data.accumulate("QT_TYPE", QT_TYPE);
            data.accumulate("QT_NO"  , QT_NO  );
            data.accumulate("VERSION", VERSION);//20160112 : 還原過來
            //下面這一行尚未完成, 必須再修改
            data.accumulate("CONFIRM_CODE", btnChange.getTag().toString());

            data.accumulate("M1_QT_TYPE"      , M1_QT_TYPE .getText() );
            data.accumulate("M1_QT_NO"        , M1_QT_NO   .getText() );
            data.accumulate("M1_QT_SEQ"       , M1_QT_SEQ  .getText() );
            data.accumulate("AP_TYPE"         , AP_TYPE    .getText() );
            data.accumulate("AP_NO"           , AP_NO      .getText() );
            data.accumulate("DRAWING_REF"     , DRAWING_REF.getText() );
            data.accumulate("DESCRIPTION"     , DESCRIPTION.getText() );
            data.accumulate("APQP_NO"         , APQP_NO    .getText() );

            qt3.accumulate("action", action);
            qt3.accumulate("qt3", data);
            jsonObj.accumulate("data", qt3);
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
		//暫時這樣寫
		return null;
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

	/**
	 * get webservice data　(getQT4 =>Package Information, Package Infor...)
	 * 
	 * @param obj
	 */

	private void loadData4(Object obj) {

		try {
			JSONObject jsonObject=new JSONObject((String) obj);
			if(jsonObject.getString("success").toString().equals("false"))
            {
                showDialog(jsonObject.getString("remark").toString());
                return ;
            }

            //if(jsonObject.getJSONArray("data").length()==0)
            //{
            //    showDialog("no data");
            //    return ;
            //}

            //20151224: 先清空畫面再將讀到的資料塞到畫面, 沒有塞到的欄位為空白, 新增資料時可以使用
            clearDetailData_QT4();
            //showButton_QT4();

            setQtItems4(new JSONObject((String) obj));

            if (btnChange.getTag().equals("Y")) {
                hideButton_QT4();
            }

            //if (qtItems4.size() == 0 && page > 1)
			//	page--;
			//20151214 : adapter4.notifyDataSetChanged();
            //20151214 : mPullDownView.notifyDidLoad();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			// Toast.makeText(NavbarHomeActivity.this,"recevie erroe:"+e.toString(),
			// Toast.LENGTH_SHORT).show();
		}

	}

	private void loadData5(Object obj) {

		try {
			JSONObject jsonObject=new JSONObject((String) obj);
			if(jsonObject.getString("success").toString().equals("false"))
			{
				showDialog(jsonObject.getString("remark").toString());
				return ;
			}
			//20151224: 先清空畫面再將讀到的資料塞到畫面, 沒有塞到的欄位為空白, 新增資料時可以使用
			clearDetailData_QT5();
			//showButton_QT5();

			setQtItems5(new JSONObject((String) obj));

            if (btnChange.getTag().equals("Y")) {
                hideButton_QT5();
            }

            //if (qtItems5.size() == 0 && page > 1)
			//	page--;
			//20151214 : adapter5.notifyDataSetChanged();
			//20151214 : mPullDownView.notifyDidLoad();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			// Toast.makeText(NavbarHomeActivity.this,"recevie erroe:"+e.toString(),
			// Toast.LENGTH_SHORT).show();
		}

	}

	private void setQtItems4(JSONObject object) throws JSONException {

		JSONArray array = object.getJSONArray("data");
		//navMenuIcons = getResources().obtainTypedArray(R.array.qpqp_list_icons);
		int icon;
		// 如果回傳資料大於零，而且頁數仍是1，則清空舊資料
		//if (array.length() > 0 && page == 1) {
		//	qtItems4.clear();
		//}
		// msgItems = new ArrayList<MsgItem>();

        b4.setText("Detail Price" + " ( " + object.getString("M12_COUNT") + " ) ");//M12_COUNT
        b5.setText("Qty Price"    + " ( " + object.getString("M11_COUNT") + " ) ");//M12_COUNT

		R99_M12_SUM      .setText(object.getString("M12_SUM"      )); //M12_SUM       //更新畫面 Footer
		R99_M11_SUM      .setText(object.getString("M11_SUM"      )); //M11_SUM       //更新畫面 Footer
		R99_M11_SUM_TOTAL.setText(object.getString("M11_SUM_TOTAL")); //M11_SUM_TOTAL //更新畫面 Footer

        if (array.length()>0) {
            R99_M12_tr.setVisibility(RelativeLayout.VISIBLE);
        }
        else{
            R99_M12_tr.setVisibility(RelativeLayout.GONE);
        }

        for (int i = 0; i < array.length(); i++) {
			JSONObject jsonObject = array.getJSONObject(i);
            /*
			qtItems4.add(new QtItem4
						   (
						    jsonObject.getString("M12_QT_TYPE"    )
						   ,jsonObject.getString("M12_QT_NO"      )
						   ,jsonObject.getString("M12_QT_SEQ"     )
						   ,jsonObject.getString("M12_SEQ" )
						   ,jsonObject.getString("DETAIL_CLASS"   )
						   ,jsonObject.getString("DETAIL_PARTNO"  )
						   ,jsonObject.getString("DETAIL_NAME"    )
						   ,jsonObject.getString("DETAIL_QTY"     )
						   ,jsonObject.getString("DETAIL_UT_PRICE")
						   ,jsonObject.getString("DETAIL_PRICE"   )
					       )
			            );
            */
			if (i==0) {
				R01_M12_tr              .setVisibility(RelativeLayout.VISIBLE);

				R01_M12_QT_TYPE         .setText(jsonObject.getString("M12_QT_TYPE")); //M12_QT_TYPE
				R01_M12_QT_NO           .setText(jsonObject.getString("M12_QT_NO")); //M12_QT_NO
				R01_M12_QT_SEQ          .setText(jsonObject.getString("M12_QT_SEQ")); //M12_QT_SEQ
				R01_M12_SEQ             .setText(jsonObject.getString("M12_SEQ"   )); //M12_SEQ
				R01_M12_DETAIL_CLASS    .setText(jsonObject.getString("M12_DETAIL_CLASS"   )); //M12_DETAIL_CLASS
				R01_M12_DETAIL_PARTNO   .setText(jsonObject.getString("M12_DETAIL_PARTNO"  )); //M12_DETAIL_PARTNO
				R01_M12_DETAIL_NAME     .setText(jsonObject.getString("M12_DETAIL_NAME"    )); //M12_DETAIL_NAME
				R01_M12_DETAIL_QTY      .setText(jsonObject.getString("M12_DETAIL_QTY"     )); //M12_DETAIL_QTY
				R01_M12_DETAIL_UT_PRICE .setText(jsonObject.getString("M12_DETAIL_UT_PRICE")); //M12_DETAIL_UT_PRICE
				R01_M12_DETAIL_PRICE    .setText(jsonObject.getString("M12_DETAIL_PRICE"   )); //M12_DETAIL_PRICE
			}
			if (i==1) {
				R02_M12_tr              .setVisibility(RelativeLayout.VISIBLE);

				R02_M12_QT_TYPE         .setText(jsonObject.getString("M12_QT_TYPE")); //M12_QT_TYPE
				R02_M12_QT_NO           .setText(jsonObject.getString("M12_QT_NO")); //M12_QT_NO
				R02_M12_QT_SEQ          .setText(jsonObject.getString("M12_QT_SEQ")); //M12_QT_SEQ
				R02_M12_SEQ             .setText(jsonObject.getString("M12_SEQ")); //M12_SEQ
				R02_M12_DETAIL_CLASS    .setText(jsonObject.getString("M12_DETAIL_CLASS")); //M12_DETAIL_CLASS
				R02_M12_DETAIL_PARTNO   .setText(jsonObject.getString("M12_DETAIL_PARTNO")); //M12_DETAIL_PARTNO
				R02_M12_DETAIL_NAME     .setText(jsonObject.getString("M12_DETAIL_NAME")); //M12_DETAIL_NAME
				R02_M12_DETAIL_QTY      .setText(jsonObject.getString("M12_DETAIL_QTY")); //M12_DETAIL_QTY
				R02_M12_DETAIL_UT_PRICE .setText(jsonObject.getString("M12_DETAIL_UT_PRICE")); //M12_DETAIL_UT_PRICE
				R02_M12_DETAIL_PRICE    .setText(jsonObject.getString("M12_DETAIL_PRICE")); //M12_DETAIL_PRICE
			}
			if (i==2) {
				R03_M12_tr              .setVisibility(RelativeLayout.VISIBLE);

				R03_M12_QT_TYPE         .setText(jsonObject.getString("M12_QT_TYPE")); //M12_QT_TYPE
				R03_M12_QT_NO           .setText(jsonObject.getString("M12_QT_NO")); //M12_QT_NO
				R03_M12_QT_SEQ          .setText(jsonObject.getString("M12_QT_SEQ")); //M12_QT_SEQ
				R03_M12_SEQ             .setText(jsonObject.getString("M12_SEQ")); //M12_SEQ
				R03_M12_DETAIL_CLASS    .setText(jsonObject.getString("M12_DETAIL_CLASS")); //M12_DETAIL_CLASS
				R03_M12_DETAIL_PARTNO   .setText(jsonObject.getString("M12_DETAIL_PARTNO")); //M12_DETAIL_PARTNO
				R03_M12_DETAIL_NAME     .setText(jsonObject.getString("M12_DETAIL_NAME")); //M12_DETAIL_NAME
				R03_M12_DETAIL_QTY      .setText(jsonObject.getString("M12_DETAIL_QTY")); //M12_DETAIL_QTY
				R03_M12_DETAIL_UT_PRICE .setText(jsonObject.getString("M12_DETAIL_UT_PRICE")); //M12_DETAIL_UT_PRICE
				R03_M12_DETAIL_PRICE    .setText(jsonObject.getString("M12_DETAIL_PRICE")); //M12_DETAIL_PRICE
			}
			if (i==3) {
				R04_M12_tr              .setVisibility(RelativeLayout.VISIBLE);

				R04_M12_QT_TYPE         .setText(jsonObject.getString("M12_QT_TYPE")); //M12_QT_TYPE
				R04_M12_QT_NO           .setText(jsonObject.getString("M12_QT_NO")); //M12_QT_NO
				R04_M12_QT_SEQ          .setText(jsonObject.getString("M12_QT_SEQ")); //M12_QT_SEQ
				R04_M12_SEQ             .setText(jsonObject.getString("M12_SEQ")); //M12_SEQ
				R04_M12_DETAIL_CLASS    .setText(jsonObject.getString("M12_DETAIL_CLASS")); //M12_DETAIL_CLASS
				R04_M12_DETAIL_PARTNO   .setText(jsonObject.getString("M12_DETAIL_PARTNO")); //M12_DETAIL_PARTNO
				R04_M12_DETAIL_NAME     .setText(jsonObject.getString("M12_DETAIL_NAME")); //M12_DETAIL_NAME
				R04_M12_DETAIL_QTY      .setText(jsonObject.getString("M12_DETAIL_QTY")); //M12_DETAIL_QTY
				R04_M12_DETAIL_UT_PRICE .setText(jsonObject.getString("M12_DETAIL_UT_PRICE")); //M12_DETAIL_UT_PRICE
				R04_M12_DETAIL_PRICE    .setText(jsonObject.getString("M12_DETAIL_PRICE")); //M12_DETAIL_PRICE
			}
			if (i==4) {
				R05_M12_tr              .setVisibility(RelativeLayout.VISIBLE);

				R05_M12_QT_TYPE         .setText(jsonObject.getString("M12_QT_TYPE")); //M12_QT_TYPE
				R05_M12_QT_NO           .setText(jsonObject.getString("M12_QT_NO")); //M12_QT_NO
				R05_M12_QT_SEQ          .setText(jsonObject.getString("M12_QT_SEQ")); //M12_QT_SEQ
				R05_M12_SEQ             .setText(jsonObject.getString("M12_SEQ")); //M12_SEQ
				R05_M12_DETAIL_CLASS    .setText(jsonObject.getString("M12_DETAIL_CLASS")); //M12_DETAIL_CLASS
				R05_M12_DETAIL_PARTNO   .setText(jsonObject.getString("M12_DETAIL_PARTNO")); //M12_DETAIL_PARTNO
				R05_M12_DETAIL_NAME     .setText(jsonObject.getString("M12_DETAIL_NAME")); //M12_DETAIL_NAME
				R05_M12_DETAIL_QTY      .setText(jsonObject.getString("M12_DETAIL_QTY")); //M12_DETAIL_QTY
				R05_M12_DETAIL_UT_PRICE .setText(jsonObject.getString("M12_DETAIL_UT_PRICE")); //M12_DETAIL_UT_PRICE
				R05_M12_DETAIL_PRICE    .setText(jsonObject.getString("M12_DETAIL_PRICE")); //M12_DETAIL_PRICE
			}
			if (i==5) {
				R06_M12_tr              .setVisibility(RelativeLayout.VISIBLE);

				R06_M12_QT_TYPE         .setText(jsonObject.getString("M12_QT_TYPE")); //M12_QT_TYPE
				R06_M12_QT_NO           .setText(jsonObject.getString("M12_QT_NO")); //M12_QT_NO
				R06_M12_QT_SEQ          .setText(jsonObject.getString("M12_QT_SEQ")); //M12_QT_SEQ
				R06_M12_SEQ             .setText(jsonObject.getString("M12_SEQ")); //M12_SEQ
				R06_M12_DETAIL_CLASS    .setText(jsonObject.getString("M12_DETAIL_CLASS")); //M12_DETAIL_CLASS
				R06_M12_DETAIL_PARTNO   .setText(jsonObject.getString("M12_DETAIL_PARTNO")); //M12_DETAIL_PARTNO
				R06_M12_DETAIL_NAME     .setText(jsonObject.getString("M12_DETAIL_NAME")); //M12_DETAIL_NAME
				R06_M12_DETAIL_QTY      .setText(jsonObject.getString("M12_DETAIL_QTY")); //M12_DETAIL_QTY
				R06_M12_DETAIL_UT_PRICE .setText(jsonObject.getString("M12_DETAIL_UT_PRICE")); //M12_DETAIL_UT_PRICE
				R06_M12_DETAIL_PRICE    .setText(jsonObject.getString("M12_DETAIL_PRICE")); //M12_DETAIL_PRICE
			}

		}

        // Recycle the typed array
		//20151211 : 暫時 remark
		//navMenuIcons.recycle();

	}

	private void setQtItems5(JSONObject object) throws JSONException {

		JSONArray array = object.getJSONArray("data");
		//navMenuIcons = getResources().obtainTypedArray(R.array.qpqp_list_icons);
		int icon;
		// 如果回傳資料大於零，而且頁數仍是1，則清空舊資料
		//if (array.length() > 0 && page == 1) {
		//	qtItems5.clear();
		//}
		// msgItems = new ArrayList<MsgItem>();

        b4.setText("Detail Price" + " ( " + object.getString("M12_COUNT") + " ) ");//M12_COUNT
        b5.setText("Qty Price"    + " ( " + object.getString("M11_COUNT") + " ) ");//M12_COUNT

		R99_M12_SUM      .setText(object.getString("M12_SUM"      )); //M12_SUM       //更新畫面 Footer
		R99_M11_SUM      .setText(object.getString("M11_SUM"      )); //M11_SUM       //更新畫面 Footer
		R99_M11_SUM_TOTAL.setText(object.getString("M11_SUM_TOTAL")); //M11_SUM_TOTAL //更新畫面 Footer

        if (array.length()>0) {
            R99_M11_tr.setVisibility(RelativeLayout.VISIBLE);
        }
        else{
            R99_M11_tr.setVisibility(RelativeLayout.GONE);
        }

		for (int i = 0; i < array.length(); i++) {
			JSONObject jsonObject = array.getJSONObject(i);
            /*
			qtItems5.add(new QtItem5
						   (
						    jsonObject.getString("M11_QT_TYPE"    )
						   ,jsonObject.getString("M11_QT_NO"      )
						   ,jsonObject.getString("M11_QT_SEQ"     )
						   ,jsonObject.getString("M11_SEQ" )
						   ,jsonObject.getString("QTY1"   )
						   ,jsonObject.getString("QTY2"  )
						   ,jsonObject.getString("UNIT"    )
						   ,jsonObject.getString("LIST_PRICE"     )
						   ,jsonObject.getString("SALE_PERCENT")
						   ,jsonObject.getString("DETAIL_PRICE"   )
						   ,jsonObject.getString("TOTAL"   )
					       )
			            );
            */

            if (i==0) {
                R01_M11_tr              .setVisibility(RelativeLayout.VISIBLE);

                R01_M11_QT_TYPE         .setText(jsonObject.getString("M11_QT_TYPE")); //M11_QT_TYPE
                R01_M11_QT_NO           .setText(jsonObject.getString("M11_QT_NO")); //M11_QT_NO
                R01_M11_QT_SEQ          .setText(jsonObject.getString("M11_QT_SEQ")); //M11_QT_SEQ
                R01_M11_SEQ             .setText(jsonObject.getString("M11_SEQ")); //M11_SEQ
                R01_M11_QTY1            .setText(jsonObject.getString("M11_QTY1")); //M11_QTY1
                R01_M11_QTY2            .setText(jsonObject.getString("M11_QTY2")); //M11_QTY2
                R01_M11_UNIT            .setText(jsonObject.getString("M11_UNIT")); //M11_UNIT
                R01_M11_LIST_PRICE      .setText(jsonObject.getString("M11_LIST_PRICE")); //M11_LIST_PRICE
                R01_M11_SALE_PERCENT    .setText(jsonObject.getString("M11_SALE_PERCENT")); //M11_SALE_PERCENT
                R01_M11_UNIT_PRICE      .setText(jsonObject.getString("M11_UNIT_PRICE")); //M11_UNIT_PRICE
                R01_M11_TOTAL           .setText(jsonObject.getString("M11_TOTAL")); //M11_TOTAL
            }
            if (i==1) {
                R02_M11_tr              .setVisibility(RelativeLayout.VISIBLE);

                R02_M11_QT_TYPE         .setText(jsonObject.getString("M11_QT_TYPE")); //M11_QT_TYPE
                R02_M11_QT_NO           .setText(jsonObject.getString("M11_QT_NO")); //M11_QT_NO
                R02_M11_QT_SEQ          .setText(jsonObject.getString("M11_QT_SEQ")); //M11_QT_SEQ
                R02_M11_SEQ             .setText(jsonObject.getString("M11_SEQ")); //M11_SEQ
                R02_M11_QTY1            .setText(jsonObject.getString("M11_QTY1")); //M11_QTY1
                R02_M11_QTY2            .setText(jsonObject.getString("M11_QTY2")); //M11_QTY2
                R02_M11_UNIT            .setText(jsonObject.getString("M11_UNIT")); //M11_UNIT
                R02_M11_LIST_PRICE      .setText(jsonObject.getString("M11_LIST_PRICE")); //M11_LIST_PRICE
                R02_M11_SALE_PERCENT    .setText(jsonObject.getString("M11_SALE_PERCENT")); //M11_SALE_PERCENT
                R02_M11_UNIT_PRICE      .setText(jsonObject.getString("M11_UNIT_PRICE")); //M11_UNIT_PRICE
                R02_M11_TOTAL           .setText(jsonObject.getString("M11_TOTAL")); //M11_TOTAL
            }
            if (i==2) {
                R03_M11_tr              .setVisibility(RelativeLayout.VISIBLE);

                R03_M11_QT_TYPE         .setText(jsonObject.getString("M11_QT_TYPE")); //M11_QT_TYPE
                R03_M11_QT_NO           .setText(jsonObject.getString("M11_QT_NO")); //M11_QT_NO
                R03_M11_QT_SEQ          .setText(jsonObject.getString("M11_QT_SEQ")); //M11_QT_SEQ
                R03_M11_SEQ             .setText(jsonObject.getString("M11_SEQ")); //M11_SEQ
                R03_M11_QTY1            .setText(jsonObject.getString("M11_QTY1")); //M11_QTY1
                R03_M11_QTY2            .setText(jsonObject.getString("M11_QTY2")); //M11_QTY2
                R03_M11_UNIT            .setText(jsonObject.getString("M11_UNIT")); //M11_UNIT
                R03_M11_LIST_PRICE      .setText(jsonObject.getString("M11_LIST_PRICE")); //M11_LIST_PRICE
                R03_M11_SALE_PERCENT    .setText(jsonObject.getString("M11_SALE_PERCENT")); //M11_SALE_PERCENT
                R03_M11_UNIT_PRICE      .setText(jsonObject.getString("M11_UNIT_PRICE")); //M11_UNIT_PRICE
                R03_M11_TOTAL           .setText(jsonObject.getString("M11_TOTAL")); //M11_TOTAL
            }
            if (i==3) {
                R04_M11_tr              .setVisibility(RelativeLayout.VISIBLE);

                R04_M11_QT_TYPE         .setText(jsonObject.getString("M11_QT_TYPE")); //M11_QT_TYPE
                R04_M11_QT_NO           .setText(jsonObject.getString("M11_QT_NO")); //M11_QT_NO
                R04_M11_QT_SEQ          .setText(jsonObject.getString("M11_QT_SEQ")); //M11_QT_SEQ
                R04_M11_SEQ             .setText(jsonObject.getString("M11_SEQ")); //M11_SEQ
                R04_M11_QTY1            .setText(jsonObject.getString("M11_QTY1")); //M11_QTY1
                R04_M11_QTY2            .setText(jsonObject.getString("M11_QTY2")); //M11_QTY2
                R04_M11_UNIT            .setText(jsonObject.getString("M11_UNIT")); //M11_UNIT
                R04_M11_LIST_PRICE      .setText(jsonObject.getString("M11_LIST_PRICE")); //M11_LIST_PRICE
                R04_M11_SALE_PERCENT    .setText(jsonObject.getString("M11_SALE_PERCENT")); //M11_SALE_PERCENT
                R04_M11_UNIT_PRICE      .setText(jsonObject.getString("M11_UNIT_PRICE")); //M11_UNIT_PRICE
                R04_M11_TOTAL           .setText(jsonObject.getString("M11_TOTAL")); //M11_TOTAL
            }
            if (i==4) {
                R05_M11_tr              .setVisibility(RelativeLayout.VISIBLE);

                R05_M11_QT_TYPE         .setText(jsonObject.getString("M11_QT_TYPE")); //M11_QT_TYPE
                R05_M11_QT_NO           .setText(jsonObject.getString("M11_QT_NO")); //M11_QT_NO
                R05_M11_QT_SEQ          .setText(jsonObject.getString("M11_QT_SEQ")); //M11_QT_SEQ
                R05_M11_SEQ             .setText(jsonObject.getString("M11_SEQ")); //M11_SEQ
                R05_M11_QTY1            .setText(jsonObject.getString("M11_QTY1")); //M11_QTY1
                R05_M11_QTY2            .setText(jsonObject.getString("M11_QTY2")); //M11_QTY2
                R05_M11_UNIT            .setText(jsonObject.getString("M11_UNIT")); //M11_UNIT
                R05_M11_LIST_PRICE      .setText(jsonObject.getString("M11_LIST_PRICE")); //M11_LIST_PRICE
                R05_M11_SALE_PERCENT    .setText(jsonObject.getString("M11_SALE_PERCENT")); //M11_SALE_PERCENT
                R05_M11_UNIT_PRICE      .setText(jsonObject.getString("M11_UNIT_PRICE")); //M11_UNIT_PRICE
                R05_M11_TOTAL           .setText(jsonObject.getString("M11_TOTAL")); //M11_TOTAL
            }

        }

        //更新畫面 Detail 筆數 Detail Price(xx)
        //b5.setText("Qty Price" + " ( " + String.valueOf(array.length()) + " ) ");//M1_COUNT

        // Recycle the typed array
		//20151211 : 暫時 remark
		//navMenuIcons.recycle();

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
		btnDelete  = (Button) view.findViewById(R.id.btn_qt_delete);
		btnAdd4    = (Button) view.findViewById(R.id.btn_qt_add4);
		btnAdd5    = (Button) view.findViewById(R.id.btn_qt_add5);
        btnCallApqp= (Button) view.findViewById(R.id.btnCallApqp);
        btnCallBom = (Button) view.findViewById(R.id.btnCallBom);

        //--------------------------------------------------------------
        R01_M12_btnEdit    = (Button) view.findViewById(R.id.R01_M12_btnEdit  );
        R01_M12_btnDelete  = (Button) view.findViewById(R.id.R01_M12_btnDelete);
        R01_M12_btnSave    = (Button) view.findViewById(R.id.R01_M12_btnSave  );
        R01_M12_btnCancel  = (Button) view.findViewById(R.id.R01_M12_btnCancel);

        R02_M12_btnEdit    = (Button) view.findViewById(R.id.R02_M12_btnEdit  );
        R02_M12_btnDelete  = (Button) view.findViewById(R.id.R02_M12_btnDelete);
        R02_M12_btnSave    = (Button) view.findViewById(R.id.R02_M12_btnSave  );
        R02_M12_btnCancel  = (Button) view.findViewById(R.id.R02_M12_btnCancel);

        R03_M12_btnEdit    = (Button) view.findViewById(R.id.R03_M12_btnEdit  );
        R03_M12_btnDelete  = (Button) view.findViewById(R.id.R03_M12_btnDelete);
        R03_M12_btnSave    = (Button) view.findViewById(R.id.R03_M12_btnSave  );
        R03_M12_btnCancel  = (Button) view.findViewById(R.id.R03_M12_btnCancel);

        R04_M12_btnEdit    = (Button) view.findViewById(R.id.R04_M12_btnEdit  );
        R04_M12_btnDelete  = (Button) view.findViewById(R.id.R04_M12_btnDelete);
        R04_M12_btnSave    = (Button) view.findViewById(R.id.R04_M12_btnSave  );
        R04_M12_btnCancel  = (Button) view.findViewById(R.id.R04_M12_btnCancel);

        R05_M12_btnEdit    = (Button) view.findViewById(R.id.R05_M12_btnEdit  );
        R05_M12_btnDelete  = (Button) view.findViewById(R.id.R05_M12_btnDelete);
        R05_M12_btnSave    = (Button) view.findViewById(R.id.R05_M12_btnSave  );
        R05_M12_btnCancel  = (Button) view.findViewById(R.id.R05_M12_btnCancel);

        R06_M12_btnEdit    = (Button) view.findViewById(R.id.R06_M12_btnEdit  );
        R06_M12_btnDelete  = (Button) view.findViewById(R.id.R06_M12_btnDelete);
        R06_M12_btnSave    = (Button) view.findViewById(R.id.R06_M12_btnSave  );
        R06_M12_btnCancel  = (Button) view.findViewById(R.id.R06_M12_btnCancel);

		R01_M12_btnEdit   .setText("");
		R01_M12_btnDelete .setText("");
		R01_M12_btnSave   .setText("");
		R01_M12_btnCancel .setText("");

		R02_M12_btnEdit   .setText("");
		R02_M12_btnDelete .setText("");
		R02_M12_btnSave   .setText("");
		R02_M12_btnCancel .setText("");

		R03_M12_btnEdit   .setText("");
		R03_M12_btnDelete .setText("");
		R03_M12_btnSave   .setText("");
		R03_M12_btnCancel .setText("");

		R04_M12_btnEdit   .setText("");
		R04_M12_btnDelete .setText("");
		R04_M12_btnSave   .setText("");
		R04_M12_btnCancel .setText("");

		R05_M12_btnEdit   .setText("");
		R05_M12_btnDelete .setText("");
		R05_M12_btnSave   .setText("");
		R05_M12_btnCancel .setText("");

		R06_M12_btnEdit   .setText("");
		R06_M12_btnDelete .setText("");
		R06_M12_btnSave   .setText("");
		R06_M12_btnCancel .setText("");

		R01_M12_btnEdit   .setTag("1-E");
		R01_M12_btnDelete .setTag("1-D");
		R01_M12_btnSave   .setTag("1-S");
		R01_M12_btnCancel .setTag("1-C");

		R02_M12_btnEdit   .setTag("2-E");
		R02_M12_btnDelete .setTag("2-D");
		R02_M12_btnSave   .setTag("2-S");
		R02_M12_btnCancel .setTag("2-C");

		R03_M12_btnEdit   .setTag("3-E");
		R03_M12_btnDelete .setTag("3-D");
		R03_M12_btnSave   .setTag("3-S");
		R03_M12_btnCancel .setTag("3-C");

		R04_M12_btnEdit   .setTag("4-E");
		R04_M12_btnDelete .setTag("4-D");
		R04_M12_btnSave   .setTag("4-S");
		R04_M12_btnCancel .setTag("4-C");

		R05_M12_btnEdit   .setTag("5-E");
		R05_M12_btnDelete .setTag("5-D");
		R05_M12_btnSave   .setTag("5-S");
		R05_M12_btnCancel .setTag("5-C");

		R06_M12_btnEdit   .setTag("6-E");
		R06_M12_btnDelete .setTag("6-D");
		R06_M12_btnSave   .setTag("6-S");
		R06_M12_btnCancel .setTag("6-C");

		//--------------------------------------------------------------
		R01_M11_btnEdit    = (Button) view.findViewById(R.id.R01_M11_btnEdit  );
		R01_M11_btnDelete  = (Button) view.findViewById(R.id.R01_M11_btnDelete);
		R01_M11_btnSave    = (Button) view.findViewById(R.id.R01_M11_btnSave  );
		R01_M11_btnCancel  = (Button) view.findViewById(R.id.R01_M11_btnCancel);

		R02_M11_btnEdit    = (Button) view.findViewById(R.id.R02_M11_btnEdit  );
		R02_M11_btnDelete  = (Button) view.findViewById(R.id.R02_M11_btnDelete);
		R02_M11_btnSave    = (Button) view.findViewById(R.id.R02_M11_btnSave  );
		R02_M11_btnCancel  = (Button) view.findViewById(R.id.R02_M11_btnCancel);

		R03_M11_btnEdit    = (Button) view.findViewById(R.id.R03_M11_btnEdit  );
		R03_M11_btnDelete  = (Button) view.findViewById(R.id.R03_M11_btnDelete);
		R03_M11_btnSave    = (Button) view.findViewById(R.id.R03_M11_btnSave  );
		R03_M11_btnCancel  = (Button) view.findViewById(R.id.R03_M11_btnCancel);

		R04_M11_btnEdit    = (Button) view.findViewById(R.id.R04_M11_btnEdit  );
		R04_M11_btnDelete  = (Button) view.findViewById(R.id.R04_M11_btnDelete);
		R04_M11_btnSave    = (Button) view.findViewById(R.id.R04_M11_btnSave  );
		R04_M11_btnCancel  = (Button) view.findViewById(R.id.R04_M11_btnCancel);

		R05_M11_btnEdit    = (Button) view.findViewById(R.id.R05_M11_btnEdit  );
		R05_M11_btnDelete  = (Button) view.findViewById(R.id.R05_M11_btnDelete);
		R05_M11_btnSave    = (Button) view.findViewById(R.id.R05_M11_btnSave  );
		R05_M11_btnCancel  = (Button) view.findViewById(R.id.R05_M11_btnCancel);


		R01_M11_btnEdit   .setText("");
		R01_M11_btnDelete .setText("");
		R01_M11_btnSave   .setText("");
		R01_M11_btnCancel .setText("");

		R02_M11_btnEdit   .setText("");
		R02_M11_btnDelete .setText("");
		R02_M11_btnSave   .setText("");
		R02_M11_btnCancel .setText("");

		R03_M11_btnEdit   .setText("");
		R03_M11_btnDelete .setText("");
		R03_M11_btnSave   .setText("");
		R03_M11_btnCancel .setText("");

		R04_M11_btnEdit   .setText("");
		R04_M11_btnDelete .setText("");
		R04_M11_btnSave   .setText("");
		R04_M11_btnCancel .setText("");

		R05_M11_btnEdit   .setText("");
		R05_M11_btnDelete .setText("");
		R05_M11_btnSave   .setText("");
		R05_M11_btnCancel .setText("");

		R01_M11_btnEdit   .setTag("1-E");
		R01_M11_btnDelete .setTag("1-D");
		R01_M11_btnSave   .setTag("1-S");
		R01_M11_btnCancel .setTag("1-C");

		R02_M11_btnEdit   .setTag("2-E");
		R02_M11_btnDelete .setTag("2-D");
		R02_M11_btnSave   .setTag("2-S");
		R02_M11_btnCancel .setTag("2-C");

		R03_M11_btnEdit   .setTag("3-E");
		R03_M11_btnDelete .setTag("3-D");
		R03_M11_btnSave   .setTag("3-S");
		R03_M11_btnCancel .setTag("3-C");

		R04_M11_btnEdit   .setTag("4-E");
		R04_M11_btnDelete .setTag("4-D");
		R04_M11_btnSave   .setTag("4-S");
		R04_M11_btnCancel .setTag("4-C");

		R05_M11_btnEdit   .setTag("5-E");
		R05_M11_btnDelete .setTag("5-D");
		R05_M11_btnSave   .setTag("5-S");
		R05_M11_btnCancel .setTag("5-C");

		//--------------------------------------------------------------
		//btnEdit_M1 = (Button) view.findViewById(R.id.btn_qt_edit_m1);
		//btnSave_M1 = (Button) view.findViewById(R.id.btn_qt_save_m1);

		//20151210 by daniel
		//Beg
		b3 = (Button) view.findViewById(R.id.b3);
		b4 = (Button) view.findViewById(R.id.b4);
		b5 = (Button) view.findViewById(R.id.b5);

		b3.setText("Detail");
		b4.setText("Detail Price");
		b5.setText("Qty Price");

        b3.setTag(0);
		b4.setTag(0);
		b5.setTag(0);

		b3.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {

                //btnSave 顯示時 不用再動作
                if (btnSave.getVisibility() == View.VISIBLE) {
                    return;
                }

                //20151211 : 改變顏色
                r3.setBackgroundColor(getResources().getColor(R.color.lightgreen));
                r4.setBackgroundColor(getResources().getColor(R.color.white));
                r5.setBackgroundColor(getResources().getColor(R.color.white));

                qttab2.setVisibility(RelativeLayout.GONE);
                qttab3.setVisibility(RelativeLayout.GONE);

                //20151221 改放 QT_SEQ vwSubTitle.setText(b3.getText());
                //if (tabbar != null)
                //	tabbar.setVisibility(RelativeLayout.GONE);

                if ((tab4 != null && tab4.getVisibility() == RelativeLayout.VISIBLE)
                        || (tab5 != null && tab5.getVisibility() == RelativeLayout.VISIBLE)) {

                    tab4.setVisibility(RelativeLayout.GONE);
                    tab5.setVisibility(RelativeLayout.GONE);

					btnEdit   .setVisibility(View.GONE);
					btnSave   .setVisibility(View.GONE);
					btnCancel .setVisibility(View.GONE);
					btnChange .setVisibility(View.GONE);
					btnConfirm.setVisibility(View.GONE);
					btnDelete .setVisibility(View.GONE);

					btnAdd4.setVisibility(View.GONE);
					btnAdd5.setVisibility(View.GONE);

                    //20160115
					if (btnChange.getTag().equals("Y")) {
						btnEdit.setVisibility(View.VISIBLE);
					} else {
						btnEdit  .setVisibility(View.VISIBLE);
						btnDelete.setVisibility(View.VISIBLE);
					}

                }

                //if (tab5 != null && tab5.getVisibility() == RelativeLayout.VISIBLE)
                //	tab5.setVisibility(RelativeLayout.GONE);
                //
                tab3.setVisibility(RelativeLayout.VISIBLE);
                //if (cmdbar != null && !cmdbar.isShown()) {
                //	cmdbar.setVisibility(RelativeLayout.VISIBLE);
                //}

                b3.setTag(2);

                queryData();

            }
        });


        //處理按鈕
        //b4_Edit.setOnClickListener(this);
        //new OnClickListener() {
        //    public void onClick(View v) {
        //
        //    }
        //
        //});

        R01_M12_btnEdit  .setOnClickListener(new OnClickListener() { public void onClick(View v) { onClick_M12(v); } });
        R01_M12_btnDelete.setOnClickListener(new OnClickListener() { public void onClick(View v) { onClick_M12(v); } });
        R01_M12_btnSave  .setOnClickListener(new OnClickListener() { public void onClick(View v) { onClick_M12(v); } });
        R01_M12_btnCancel.setOnClickListener(new OnClickListener() { public void onClick(View v) { onClick_M12(v); } });

        R02_M12_btnEdit  .setOnClickListener(new OnClickListener() { public void onClick(View v) { onClick_M12(v); } });
        R02_M12_btnDelete.setOnClickListener(new OnClickListener() { public void onClick(View v) { onClick_M12(v); } });
        R02_M12_btnSave  .setOnClickListener(new OnClickListener() { public void onClick(View v) { onClick_M12(v); } });
        R02_M12_btnCancel.setOnClickListener(new OnClickListener() { public void onClick(View v) { onClick_M12(v); } });

        R03_M12_btnEdit  .setOnClickListener(new OnClickListener() { public void onClick(View v) { onClick_M12(v); } });
        R03_M12_btnDelete.setOnClickListener(new OnClickListener() { public void onClick(View v) { onClick_M12(v); } });
        R03_M12_btnSave  .setOnClickListener(new OnClickListener() { public void onClick(View v) { onClick_M12(v); } });
        R03_M12_btnCancel.setOnClickListener(new OnClickListener() { public void onClick(View v) { onClick_M12(v); } });

        R04_M12_btnEdit  .setOnClickListener(new OnClickListener() { public void onClick(View v) { onClick_M12(v); } });
        R04_M12_btnDelete.setOnClickListener(new OnClickListener() { public void onClick(View v) { onClick_M12(v); } });
        R04_M12_btnSave  .setOnClickListener(new OnClickListener() { public void onClick(View v) { onClick_M12(v); } });
        R04_M12_btnCancel.setOnClickListener(new OnClickListener() { public void onClick(View v) { onClick_M12(v); } });

        R05_M12_btnEdit  .setOnClickListener(new OnClickListener() { public void onClick(View v) { onClick_M12(v); } });
        R05_M12_btnDelete.setOnClickListener(new OnClickListener() { public void onClick(View v) { onClick_M12(v); } });
        R05_M12_btnSave  .setOnClickListener(new OnClickListener() { public void onClick(View v) { onClick_M12(v); } });
        R05_M12_btnCancel.setOnClickListener(new OnClickListener() { public void onClick(View v) { onClick_M12(v); } });

        R06_M12_btnEdit  .setOnClickListener(new OnClickListener() { public void onClick(View v) { onClick_M12(v); } });
        R06_M12_btnDelete.setOnClickListener(new OnClickListener() { public void onClick(View v) { onClick_M12(v); } });
        R06_M12_btnSave  .setOnClickListener(new OnClickListener() { public void onClick(View v) { onClick_M12(v); } });
        R06_M12_btnCancel.setOnClickListener(new OnClickListener() { public void onClick(View v) { onClick_M12(v); } });

		b4.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
                //注意: 將 ... 
                b4_onClick(v);
                
//				//20151211 : 改變顏色
//				r3.setBackgroundColor(getResources().getColor(R.color.white));
//				r4.setBackgroundColor(getResources().getColor(R.color.lightgreen));
//				r5.setBackgroundColor(getResources().getColor(R.color.white));
//
//				qttab2.setVisibility(RelativeLayout.VISIBLE);
//                qttab3.setVisibility(RelativeLayout.GONE);
//
//				int tag = (Integer) v.getTag();
//                //20151221 改放 QT_SEQ vwSubTitle.setText(b4.getText());
//				//if (tabbar != null)
//				//	tabbar.setVisibility(RelativeLayout.GONE);
//				if ((tab3 != null && tab3.getVisibility() == RelativeLayout.VISIBLE)
//				 || (tab5 != null && tab5.getVisibility() == RelativeLayout.VISIBLE))
//				{
//
//					tab3.setVisibility(RelativeLayout.GONE);
//					tab5.setVisibility(RelativeLayout.GONE);
//
//					btnEdit.setVisibility(RelativeLayout.GONE);
//                    btnDelete.setVisibility(RelativeLayout.GONE);
//					btnAdd4.setVisibility(RelativeLayout.VISIBLE);
//					btnAdd5.setVisibility(RelativeLayout.GONE);
//
//					btnSave   .setVisibility(RelativeLayout.GONE);
//					btnChange .setVisibility(RelativeLayout.GONE);
//					btnConfirm.setVisibility(RelativeLayout.GONE);
//
//					showButton_QT4();
//				}
//
//				//if (tab3 != null && tab3.getVisibility() == RelativeLayout.VISIBLE)
//				//	tab3.setVisibility(RelativeLayout.GONE);
//				//if (tab5 != null && tab5.getVisibility() == RelativeLayout.VISIBLE)
//				//	tab5.setVisibility(RelativeLayout.GONE);
//                //
//				tab4.setVisibility(RelativeLayout.VISIBLE);
//
//				//if (cmdbar != null && !cmdbar.isShown()) {
//				//	cmdbar.setVisibility(RelativeLayout.VISIBLE);
//				//}
//				//if (tag != 2) {
//					b4.setTag(2);
//
//                    queryData((String) getWebServiceUrl() + "queryQT4",
//							queryQT4(QT_TYPE, QT_NO),
//							new IDataReceiveListener() {
//								public void onReceiveData(Object obj) {
//									//20151214 : 暫時 remark
//                                    loadData4(obj);
//									b4.setTag(2);
//								}
//							});
//
//				}
			}
		});


		R01_M11_btnEdit  .setOnClickListener(new OnClickListener() { public void onClick(View v) { onClick_M11(v); } });
		R01_M11_btnDelete.setOnClickListener(new OnClickListener() { public void onClick(View v) { onClick_M11(v); } });
		R01_M11_btnSave  .setOnClickListener(new OnClickListener() { public void onClick(View v) { onClick_M11(v); } });
		R01_M11_btnCancel.setOnClickListener(new OnClickListener() { public void onClick(View v) { onClick_M11(v); } });

		R02_M11_btnEdit  .setOnClickListener(new OnClickListener() { public void onClick(View v) { onClick_M11(v); } });
		R02_M11_btnDelete.setOnClickListener(new OnClickListener() { public void onClick(View v) { onClick_M11(v); } });
		R02_M11_btnSave  .setOnClickListener(new OnClickListener() { public void onClick(View v) { onClick_M11(v); } });
		R02_M11_btnCancel.setOnClickListener(new OnClickListener() { public void onClick(View v) { onClick_M11(v); } });

		R03_M11_btnEdit  .setOnClickListener(new OnClickListener() { public void onClick(View v) { onClick_M11(v); } });
		R03_M11_btnDelete.setOnClickListener(new OnClickListener() { public void onClick(View v) { onClick_M11(v); } });
		R03_M11_btnSave  .setOnClickListener(new OnClickListener() { public void onClick(View v) { onClick_M11(v); } });
		R03_M11_btnCancel.setOnClickListener(new OnClickListener() { public void onClick(View v) { onClick_M11(v); } });

		R04_M11_btnEdit  .setOnClickListener(new OnClickListener() { public void onClick(View v) { onClick_M11(v); } });
		R04_M11_btnDelete.setOnClickListener(new OnClickListener() { public void onClick(View v) { onClick_M11(v); } });
		R04_M11_btnSave  .setOnClickListener(new OnClickListener() { public void onClick(View v) { onClick_M11(v); } });
		R04_M11_btnCancel.setOnClickListener(new OnClickListener() { public void onClick(View v) { onClick_M11(v); } });

		R05_M11_btnEdit  .setOnClickListener(new OnClickListener() { public void onClick(View v) { onClick_M11(v); } });
		R05_M11_btnDelete.setOnClickListener(new OnClickListener() { public void onClick(View v) { onClick_M11(v); } });
		R05_M11_btnSave  .setOnClickListener(new OnClickListener() { public void onClick(View v) { onClick_M11(v); } });
		R05_M11_btnCancel.setOnClickListener(new OnClickListener() { public void onClick(View v) { onClick_M11(v); } });


		b5.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {

                //btnSave 顯示時 不可切換 到 QT5
                if (btnSave.getVisibility() == View.VISIBLE) {
                    return;
                }

                //20151211 : 改變顏色
				r3.setBackgroundColor(getResources().getColor(R.color.white));
				r4.setBackgroundColor(getResources().getColor(R.color.white));
				r5.setBackgroundColor(getResources().getColor(R.color.lightgreen));

                qttab2.setVisibility(RelativeLayout.GONE);
                qttab3.setVisibility(RelativeLayout.VISIBLE);

				int tag = (Integer) v.getTag();
                //20151221 改放 QT_SEQ vwSubTitle.setText(b5.getText());
				//if (tabbar != null)
				//	tabbar.setVisibility(RelativeLayout.GONE);
				if ((tab3 != null && tab3.getVisibility() == RelativeLayout.VISIBLE)
				 || (tab4 != null && tab4.getVisibility() == RelativeLayout.VISIBLE))
				{

					tab3.setVisibility(RelativeLayout.GONE);
					tab4.setVisibility(RelativeLayout.GONE);

					btnEdit   .setVisibility(View.GONE);
					btnSave   .setVisibility(View.GONE);
					btnCancel .setVisibility(View.GONE);
					btnChange .setVisibility(View.GONE);
					btnConfirm.setVisibility(View.GONE);
					btnDelete .setVisibility(View.GONE);

					btnAdd4.setVisibility(View.GONE);
					btnAdd5.setVisibility(View.GONE);

					//20150115
					if (btnChange.getTag().equals("Y")) {
						//btnAdd5.setVisibility(View.VISIBLE);
					} else {
						btnAdd5.setVisibility(View.VISIBLE);
					}


					showButton_QT5();
				}

				//if (tab3 != null && tab3.getVisibility() == RelativeLayout.VISIBLE)
				//	tab3.setVisibility(RelativeLayout.GONE);
				//if (tab4 != null && tab4.getVisibility() == RelativeLayout.VISIBLE)
				//	tab4.setVisibility(RelativeLayout.GONE);

				tab5.setVisibility(RelativeLayout.VISIBLE);

				//if (cmdbar != null && !cmdbar.isShown()) {
				//	cmdbar.setVisibility(RelativeLayout.VISIBLE);
				//}
				//if (tag != 2) {
					b5.setTag(2);

                    queryData((String) getWebServiceUrl() + "queryQT5",
							queryQT5(QT_TYPE, QT_NO),
							new IDataReceiveListener() {
								public void onReceiveData(Object obj) {
									//20151215 : 暫時 remark
                                    loadData5(obj);
									b5.setTag(2);
								}
							});

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
                btnDelete .setVisibility(View.GONE);

                btnAdd4.setVisibility(View.GONE);
                btnAdd5.setVisibility(View.GONE);

                //20160115
                if (btnChange.getTag().equals("Y")) {
                    btnChange.setVisibility(View.VISIBLE);
                    btnCancel.setVisibility(View.VISIBLE);
                } else {
                    btnSave.setVisibility(View.VISIBLE);
                    btnCancel.setVisibility(View.VISIBLE);
                }


			}
		});

        btnDelete.setOnClickListener(new OnClickListener() {
            @Override
            /**
             * Screenshot_20150410_12.jpg
             */
            public void onClick(View v) {

                showDialog("是否確定要刪除?",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id){
                                //true;//do no
                                deleteData3("Delete");
                            }

                        }
                        ,new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id){
                                //false;//do no
                            }

                        });

//                deleteData3("Delete");
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
                //20151215 : 注意:寫到 update 資料時這一段要修改
				if (tab3.getVisibility() == View.VISIBLE) {
					saveData3("Save");

				} else if (tab4.getVisibility() == View.VISIBLE) {
					saveData2("Save");
				}
				//v.setVisibility(View.GONE);
                btnSave.setVisibility(View.GONE);
                btnCancel.setVisibility(View.GONE);
				//btnConfirm.setVisibility(View.GONE);
				btnEdit.setVisibility(View.VISIBLE);
                btnDelete.setVisibility(View.VISIBLE);

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
                //v.setVisibility(View.GONE);

                btnCancel.setVisibility(View.GONE);
                //btnConfirm.setVisibility(View.GONE);
                btnEdit.setVisibility(View.VISIBLE);
                btnDelete.setVisibility(View.VISIBLE);
                btnSave.setVisibility(View.GONE);
                //btnChange.setVisibility(View.GONE);

                queryData();


            }
        });

        /**
         * Confirm的button,點擊觸發的action
         */
//		btnConfirm.setOnClickListener(new OnClickListener() {
//			@Override
//			public void onClick(View v) {
//
//				// No.15041501
//				isLoading = 1;
//				launchRingDialog(null);
//				if (tab3.getVisibility() == View.VISIBLE) {
//					saveData3("Confirm");
//
//				} else if (tab4.getVisibility() == View.VISIBLE) {
//					saveData2("Confirm");
//				}
//				v.setVisibility(View.GONE);
//				btnSave.setVisibility(View.GONE);
//                btnCancel.setVisibility(View.GONE);
//				btnEdit.setVisibility(View.VISIBLE);
//                btnDelete.setVisibility(View.VISIBLE);
//			}
//		});

		/**
		 * Change的button,點擊觸發的action
		 */
		btnChange.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				// No.15041501
				isLoading = 1;
				launchRingDialog(null);
				if (tab3.getVisibility() == View.VISIBLE) {
					saveData3("Change");
				}
                btnEdit   .setVisibility(View.GONE);
                btnSave   .setVisibility(View.GONE);
                btnCancel .setVisibility(View.GONE);
                btnChange .setVisibility(View.GONE);
                btnConfirm.setVisibility(View.GONE);
                btnDelete .setVisibility(View.GONE);

                btnAdd4.setVisibility(View.GONE);
                btnAdd5.setVisibility(View.GONE);

                //20160115
                btnEdit.setVisibility(View.VISIBLE);
			}
		});

		/**
		 * add2 的button,點擊觸發的action
		 */
		btnAdd4.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

                //btnAdd4.setEnabled(false); 
                btnAdd4.setVisibility(View.GONE); 
                
				// No.15041501
				isLoading = 1;
				launchRingDialog(null);

				if (tab4.getVisibility() == View.VISIBLE) {
					//20151224:呼叫 WebService
					addNewQT4("New");//呼叫 WebService 及 回傳值都在 這裡處理

					//20151224: 下面這段程式碼移動到 addNewQT4
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


        btnAdd5.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                //btnAdd5.setEnabled(false); 
                btnAdd5.setVisibility(View.GONE);

                // No.15041501
                isLoading = 1;
                launchRingDialog(null);

                if (tab5.getVisibility() == View.VISIBLE) {
                    //20151224:呼叫 WebService
                    addNewQT5("New");//呼叫 WebService 及 回傳值都在 這裡處理

                    //20151224: 下面這段程式碼移動到 addNewQT5
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

        btnCallApqp.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                //AP_NO.getText().toString()
//                ed_AP_NO.
//                TextView view = (TextView) v;
//                String apqpNo = view.getText().toString().contains("\n") ?
//                        view.getText().toString().split("\n")[0] : view.getText().toString();
//                // showDialog(content);
                callApqpDataActivity("AP"+"-"+AP_NO.getText().toString());
//
//
//                callApqpDataActivity();//                //btnAdd4.setEnabled(false);
//				callBomListActivity(partNo);

            }
        });

        btnCallBom.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                //AP_NO.getText().toString()
//                ed_AP_NO.
//                TextView view = (TextView) v;
//                String apqpNo = view.getText().toString().contains("\n") ?
//                        view.getText().toString().split("\n")[0] : view.getText().toString();
//                // showDialog(content);
                callBomListActivity(DRAWING_REF.getText().toString());
//
//
//                callApqpDataActivity();//                //btnAdd4.setEnabled(false);
//				callBomListActivity(partNo);

            }
        });


        /**
         *
         * Edit的button,點擊觸發的action
         */
        /*
		btnEdit_M1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				//if (btnEdit_M1.getTag().equals("N")) {
				//	showDialog("Permission Denied",
				//			"Sorry, you don't have the permission to edit table.");
				//	return;
				//}
				v.setVisibility(View.GONE);
				btnSave_M1.setVisibility(View.VISIBLE);
			}
		});
        */

		/**
		 * Save的button,點擊觸發的action
		 */
        /*
		btnSave_M1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				// No.15041501
				isLoading = 1;
				launchRingDialog(null);
				//20151215 : 注意:寫到 update 資料時這一段要修改
				if (tab3.getVisibility() == View.VISIBLE) {
					saveData3("Save");
				}
				v.setVisibility(View.GONE);
				btnEdit_M1.setVisibility(View.VISIBLE);

			}
		});
        */
        
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

		initTab3(view);// Customer Info
		initTab4(view);// Detail
		initTab5(view);// Detail

	}

	private void initTab3(View view) {
        //M1
        M1_QT_TYPE  = (EditText) view.findViewById(R.id.ed_M1_QT_TYPE );
        M1_QT_NO    = (EditText) view.findViewById(R.id.ed_M1_QT_NO   );
        M1_QT_SEQ   = (EditText) view.findViewById(R.id.ed_M1_QT_SEQ  );
        AP_TYPE     = (EditText) view.findViewById(R.id.ed_AP_TYPE    );
        AP_NO       = (EditText) view.findViewById(R.id.ed_AP_NO      );
        DRAWING_REF = (EditText) view.findViewById(R.id.ed_DRAWING_REF);
        DESCRIPTION = (EditText) view.findViewById(R.id.ed_DESCRIPTION);
		APQP_NO     = (EditText) view.findViewById(R.id.ed_APQP_NO    );

		// 設定元件鍵盤
		//setupTab3EditKeyboard(view);
	}

	private void initTab4(View view) {
        // 20151214: 暫時 remark
        //M12
        /*
        M12_QT_TYPE     = (EditText) view.findViewById(R.id.ed_M12_QT_TYPE    );
        M12_QT_NO       = (EditText) view.findViewById(R.id.ed_M12_QT_NO      );
        M12_QT_SEQ      = (EditText) view.findViewById(R.id.ed_M12_QT_SEQ     );
        M12_SEQ  = (EditText) view.findViewById(R.id.ed_M12_SEQ );
        DETAIL_CLASS    = (EditText) view.findViewById(R.id.ed_DETAIL_CLASS   );
        DETAIL_PARTNO   = (EditText) view.findViewById(R.id.ed_DETAIL_PARTNO  );
        DETAIL_NAME     = (EditText) view.findViewById(R.id.ed_DETAIL_NAME    );
        DETAIL_QTY      = (EditText) view.findViewById(R.id.ed_DETAIL_QTY     );
        DETAIL_UT_PRICE = (EditText) view.findViewById(R.id.ed_DETAIL_UT_PRICE);
        DETAIL_PRICE    = (EditText) view.findViewById(R.id.ed_DETAIL_PRICE   );
        */

		R01_M12_QT_TYPE         = (EditText) view.findViewById(R.id.R01_ed_M12_QT_TYPE        );
		R01_M12_QT_NO           = (EditText) view.findViewById(R.id.R01_ed_M12_QT_NO          );
		R01_M12_QT_SEQ          = (EditText) view.findViewById(R.id.R01_ed_M12_QT_SEQ         );
		R01_M12_SEQ             = (EditText) view.findViewById(R.id.R01_ed_M12_SEQ     );
		R01_M12_DETAIL_CLASS    = (EditText) view.findViewById(R.id.R01_ed_M12_DETAIL_CLASS   );
		R01_M12_DETAIL_PARTNO   = (EditText) view.findViewById(R.id.R01_ed_M12_DETAIL_PARTNO  );
		R01_M12_DETAIL_NAME     = (EditText) view.findViewById(R.id.R01_ed_M12_DETAIL_NAME    );
		R01_M12_DETAIL_QTY      = (EditText) view.findViewById(R.id.R01_ed_M12_DETAIL_QTY     );
		R01_M12_DETAIL_UT_PRICE = (EditText) view.findViewById(R.id.R01_ed_M12_DETAIL_UT_PRICE);
		R01_M12_DETAIL_PRICE    = (EditText) view.findViewById(R.id.R01_ed_M12_DETAIL_PRICE   );

		R02_M12_QT_TYPE         = (EditText) view.findViewById(R.id.R02_ed_M12_QT_TYPE        );
		R02_M12_QT_NO           = (EditText) view.findViewById(R.id.R02_ed_M12_QT_NO          );
		R02_M12_QT_SEQ          = (EditText) view.findViewById(R.id.R02_ed_M12_QT_SEQ         );
		R02_M12_SEQ             = (EditText) view.findViewById(R.id.R02_ed_M12_SEQ     );
		R02_M12_DETAIL_CLASS    = (EditText) view.findViewById(R.id.R02_ed_M12_DETAIL_CLASS   );
		R02_M12_DETAIL_PARTNO   = (EditText) view.findViewById(R.id.R02_ed_M12_DETAIL_PARTNO  );
		R02_M12_DETAIL_NAME     = (EditText) view.findViewById(R.id.R02_ed_M12_DETAIL_NAME    );
		R02_M12_DETAIL_QTY      = (EditText) view.findViewById(R.id.R02_ed_M12_DETAIL_QTY     );
		R02_M12_DETAIL_UT_PRICE = (EditText) view.findViewById(R.id.R02_ed_M12_DETAIL_UT_PRICE);
		R02_M12_DETAIL_PRICE    = (EditText) view.findViewById(R.id.R02_ed_M12_DETAIL_PRICE   );

		R03_M12_QT_TYPE         = (EditText) view.findViewById(R.id.R03_ed_M12_QT_TYPE        );
		R03_M12_QT_NO           = (EditText) view.findViewById(R.id.R03_ed_M12_QT_NO          );
		R03_M12_QT_SEQ          = (EditText) view.findViewById(R.id.R03_ed_M12_QT_SEQ         );
		R03_M12_SEQ             = (EditText) view.findViewById(R.id.R03_ed_M12_SEQ     );
		R03_M12_DETAIL_CLASS    = (EditText) view.findViewById(R.id.R03_ed_M12_DETAIL_CLASS   );
		R03_M12_DETAIL_PARTNO   = (EditText) view.findViewById(R.id.R03_ed_M12_DETAIL_PARTNO  );
		R03_M12_DETAIL_NAME     = (EditText) view.findViewById(R.id.R03_ed_M12_DETAIL_NAME    );
		R03_M12_DETAIL_QTY      = (EditText) view.findViewById(R.id.R03_ed_M12_DETAIL_QTY     );
		R03_M12_DETAIL_UT_PRICE = (EditText) view.findViewById(R.id.R03_ed_M12_DETAIL_UT_PRICE);
		R03_M12_DETAIL_PRICE    = (EditText) view.findViewById(R.id.R03_ed_M12_DETAIL_PRICE   );

		R04_M12_QT_TYPE         = (EditText) view.findViewById(R.id.R04_ed_M12_QT_TYPE        );
		R04_M12_QT_NO           = (EditText) view.findViewById(R.id.R04_ed_M12_QT_NO          );
		R04_M12_QT_SEQ          = (EditText) view.findViewById(R.id.R04_ed_M12_QT_SEQ         );
		R04_M12_SEQ             = (EditText) view.findViewById(R.id.R04_ed_M12_SEQ     );
		R04_M12_DETAIL_CLASS    = (EditText) view.findViewById(R.id.R04_ed_M12_DETAIL_CLASS   );
		R04_M12_DETAIL_PARTNO   = (EditText) view.findViewById(R.id.R04_ed_M12_DETAIL_PARTNO  );
		R04_M12_DETAIL_NAME     = (EditText) view.findViewById(R.id.R04_ed_M12_DETAIL_NAME    );
		R04_M12_DETAIL_QTY      = (EditText) view.findViewById(R.id.R04_ed_M12_DETAIL_QTY     );
		R04_M12_DETAIL_UT_PRICE = (EditText) view.findViewById(R.id.R04_ed_M12_DETAIL_UT_PRICE);
		R04_M12_DETAIL_PRICE    = (EditText) view.findViewById(R.id.R04_ed_M12_DETAIL_PRICE   );

		R05_M12_QT_TYPE         = (EditText) view.findViewById(R.id.R05_ed_M12_QT_TYPE        );
		R05_M12_QT_NO           = (EditText) view.findViewById(R.id.R05_ed_M12_QT_NO          );
		R05_M12_QT_SEQ          = (EditText) view.findViewById(R.id.R05_ed_M12_QT_SEQ         );
		R05_M12_SEQ             = (EditText) view.findViewById(R.id.R05_ed_M12_SEQ     );
		R05_M12_DETAIL_CLASS    = (EditText) view.findViewById(R.id.R05_ed_M12_DETAIL_CLASS   );
		R05_M12_DETAIL_PARTNO   = (EditText) view.findViewById(R.id.R05_ed_M12_DETAIL_PARTNO  );
		R05_M12_DETAIL_NAME     = (EditText) view.findViewById(R.id.R05_ed_M12_DETAIL_NAME    );
		R05_M12_DETAIL_QTY      = (EditText) view.findViewById(R.id.R05_ed_M12_DETAIL_QTY     );
		R05_M12_DETAIL_UT_PRICE = (EditText) view.findViewById(R.id.R05_ed_M12_DETAIL_UT_PRICE);
		R05_M12_DETAIL_PRICE    = (EditText) view.findViewById(R.id.R05_ed_M12_DETAIL_PRICE   );

		R06_M12_QT_TYPE         = (EditText) view.findViewById(R.id.R06_ed_M12_QT_TYPE        );
		R06_M12_QT_NO           = (EditText) view.findViewById(R.id.R06_ed_M12_QT_NO          );
		R06_M12_QT_SEQ          = (EditText) view.findViewById(R.id.R06_ed_M12_QT_SEQ         );
		R06_M12_SEQ             = (EditText) view.findViewById(R.id.R06_ed_M12_SEQ     );
		R06_M12_DETAIL_CLASS    = (EditText) view.findViewById(R.id.R06_ed_M12_DETAIL_CLASS   );
		R06_M12_DETAIL_PARTNO   = (EditText) view.findViewById(R.id.R06_ed_M12_DETAIL_PARTNO  );
		R06_M12_DETAIL_NAME     = (EditText) view.findViewById(R.id.R06_ed_M12_DETAIL_NAME    );
		R06_M12_DETAIL_QTY      = (EditText) view.findViewById(R.id.R06_ed_M12_DETAIL_QTY     );
		R06_M12_DETAIL_UT_PRICE = (EditText) view.findViewById(R.id.R06_ed_M12_DETAIL_UT_PRICE);
		R06_M12_DETAIL_PRICE    = (EditText) view.findViewById(R.id.R06_ed_M12_DETAIL_PRICE   );

        R99_M12_SUM             = (EditText) view.findViewById(R.id.R99_ed_M12_SUM            );

        R01_M12_tr = (TableRow) view.findViewById(R.id.R01_M12_tr);
		R02_M12_tr = (TableRow) view.findViewById(R.id.R02_M12_tr);
		R03_M12_tr = (TableRow) view.findViewById(R.id.R03_M12_tr);
		R04_M12_tr = (TableRow) view.findViewById(R.id.R04_M12_tr);
		R05_M12_tr = (TableRow) view.findViewById(R.id.R05_M12_tr);
		R06_M12_tr = (TableRow) view.findViewById(R.id.R06_M12_tr);

        R99_M12_tr = (TableRow) view.findViewById(R.id.R99_M12_tr);

		R01_M12_tr .setVisibility(RelativeLayout.GONE);
		R02_M12_tr .setVisibility(RelativeLayout.GONE);
		R03_M12_tr .setVisibility(RelativeLayout.GONE);
		R04_M12_tr .setVisibility(RelativeLayout.GONE);
		R05_M12_tr .setVisibility(RelativeLayout.GONE);
		R06_M12_tr .setVisibility(RelativeLayout.GONE);


	}

	private void initTab5(View view) {
		// 20151215: 暫時 remark
		//M11
        /*
        */
		R01_M11_QT_TYPE      = (EditText) view.findViewById(R.id.R01_ed_M11_QT_TYPE     );
		R01_M11_QT_NO        = (EditText) view.findViewById(R.id.R01_ed_M11_QT_NO       );
		R01_M11_QT_SEQ       = (EditText) view.findViewById(R.id.R01_ed_M11_QT_SEQ      );
		R01_M11_SEQ          = (EditText) view.findViewById(R.id.R01_ed_M11_SEQ  );
		R01_M11_QTY1         = (EditText) view.findViewById(R.id.R01_ed_M11_QTY1        );
		R01_M11_QTY2         = (EditText) view.findViewById(R.id.R01_ed_M11_QTY2        );
		R01_M11_UNIT         = (EditText) view.findViewById(R.id.R01_ed_M11_UNIT        );
		R01_M11_LIST_PRICE   = (EditText) view.findViewById(R.id.R01_ed_M11_LIST_PRICE  );
		R01_M11_SALE_PERCENT = (EditText) view.findViewById(R.id.R01_ed_M11_SALE_PERCENT);
		R01_M11_UNIT_PRICE   = (EditText) view.findViewById(R.id.R01_ed_M11_UNIT_PRICE  );
		R01_M11_TOTAL        = (EditText) view.findViewById(R.id.R01_ed_M11_TOTAL       );

		R02_M11_QT_TYPE      = (EditText) view.findViewById(R.id.R02_ed_M11_QT_TYPE     );
		R02_M11_QT_NO        = (EditText) view.findViewById(R.id.R02_ed_M11_QT_NO       );
		R02_M11_QT_SEQ       = (EditText) view.findViewById(R.id.R02_ed_M11_QT_SEQ      );
		R02_M11_SEQ          = (EditText) view.findViewById(R.id.R02_ed_M11_SEQ  );
		R02_M11_QTY1         = (EditText) view.findViewById(R.id.R02_ed_M11_QTY1        );
		R02_M11_QTY2         = (EditText) view.findViewById(R.id.R02_ed_M11_QTY2        );
		R02_M11_UNIT         = (EditText) view.findViewById(R.id.R02_ed_M11_UNIT        );
		R02_M11_LIST_PRICE   = (EditText) view.findViewById(R.id.R02_ed_M11_LIST_PRICE  );
		R02_M11_SALE_PERCENT = (EditText) view.findViewById(R.id.R02_ed_M11_SALE_PERCENT);
		R02_M11_UNIT_PRICE   = (EditText) view.findViewById(R.id.R02_ed_M11_UNIT_PRICE  );
		R02_M11_TOTAL        = (EditText) view.findViewById(R.id.R02_ed_M11_TOTAL       );

		R03_M11_QT_TYPE      = (EditText) view.findViewById(R.id.R03_ed_M11_QT_TYPE     );
		R03_M11_QT_NO        = (EditText) view.findViewById(R.id.R03_ed_M11_QT_NO       );
		R03_M11_QT_SEQ       = (EditText) view.findViewById(R.id.R03_ed_M11_QT_SEQ      );
		R03_M11_SEQ          = (EditText) view.findViewById(R.id.R03_ed_M11_SEQ  );
		R03_M11_QTY1         = (EditText) view.findViewById(R.id.R03_ed_M11_QTY1        );
		R03_M11_QTY2         = (EditText) view.findViewById(R.id.R03_ed_M11_QTY2        );
		R03_M11_UNIT         = (EditText) view.findViewById(R.id.R03_ed_M11_UNIT        );
		R03_M11_LIST_PRICE   = (EditText) view.findViewById(R.id.R03_ed_M11_LIST_PRICE  );
		R03_M11_SALE_PERCENT = (EditText) view.findViewById(R.id.R03_ed_M11_SALE_PERCENT);
		R03_M11_UNIT_PRICE   = (EditText) view.findViewById(R.id.R03_ed_M11_UNIT_PRICE  );
		R03_M11_TOTAL        = (EditText) view.findViewById(R.id.R03_ed_M11_TOTAL       );

		R04_M11_QT_TYPE      = (EditText) view.findViewById(R.id.R04_ed_M11_QT_TYPE     );
		R04_M11_QT_NO        = (EditText) view.findViewById(R.id.R04_ed_M11_QT_NO       );
		R04_M11_QT_SEQ       = (EditText) view.findViewById(R.id.R04_ed_M11_QT_SEQ      );
		R04_M11_SEQ          = (EditText) view.findViewById(R.id.R04_ed_M11_SEQ  );
		R04_M11_QTY1         = (EditText) view.findViewById(R.id.R04_ed_M11_QTY1        );
		R04_M11_QTY2         = (EditText) view.findViewById(R.id.R04_ed_M11_QTY2        );
		R04_M11_UNIT         = (EditText) view.findViewById(R.id.R04_ed_M11_UNIT        );
		R04_M11_LIST_PRICE   = (EditText) view.findViewById(R.id.R04_ed_M11_LIST_PRICE  );
		R04_M11_SALE_PERCENT = (EditText) view.findViewById(R.id.R04_ed_M11_SALE_PERCENT);
		R04_M11_UNIT_PRICE   = (EditText) view.findViewById(R.id.R04_ed_M11_UNIT_PRICE  );
		R04_M11_TOTAL        = (EditText) view.findViewById(R.id.R04_ed_M11_TOTAL       );

		R05_M11_QT_TYPE      = (EditText) view.findViewById(R.id.R05_ed_M11_QT_TYPE     );
		R05_M11_QT_NO        = (EditText) view.findViewById(R.id.R05_ed_M11_QT_NO       );
		R05_M11_QT_SEQ       = (EditText) view.findViewById(R.id.R05_ed_M11_QT_SEQ      );
		R05_M11_SEQ          = (EditText) view.findViewById(R.id.R05_ed_M11_SEQ  );
		R05_M11_QTY1         = (EditText) view.findViewById(R.id.R05_ed_M11_QTY1        );
		R05_M11_QTY2         = (EditText) view.findViewById(R.id.R05_ed_M11_QTY2        );
		R05_M11_UNIT         = (EditText) view.findViewById(R.id.R05_ed_M11_UNIT        );
		R05_M11_LIST_PRICE   = (EditText) view.findViewById(R.id.R05_ed_M11_LIST_PRICE  );
		R05_M11_SALE_PERCENT = (EditText) view.findViewById(R.id.R05_ed_M11_SALE_PERCENT);
		R05_M11_UNIT_PRICE   = (EditText) view.findViewById(R.id.R05_ed_M11_UNIT_PRICE  );
		R05_M11_TOTAL        = (EditText) view.findViewById(R.id.R05_ed_M11_TOTAL       );

        R99_M11_SUM             = (EditText) view.findViewById(R.id.R99_ed_M11_SUM            );
        R99_M11_SUM_TOTAL       = (EditText) view.findViewById(R.id.R99_ed_M11_SUM_TOTAL      );

		R01_M11_tr = (TableRow) view.findViewById(R.id.R01_M11_tr);
		R02_M11_tr = (TableRow) view.findViewById(R.id.R02_M11_tr);
		R03_M11_tr = (TableRow) view.findViewById(R.id.R03_M11_tr);
		R04_M11_tr = (TableRow) view.findViewById(R.id.R04_M11_tr);
		R05_M11_tr = (TableRow) view.findViewById(R.id.R05_M11_tr);

		R01_M11_tr .setVisibility(RelativeLayout.GONE);
		R02_M11_tr .setVisibility(RelativeLayout.GONE);
		R03_M11_tr .setVisibility(RelativeLayout.GONE);
		R04_M11_tr .setVisibility(RelativeLayout.GONE);
		R05_M11_tr .setVisibility(RelativeLayout.GONE);

        R99_M11_tr = (TableRow) view.findViewById(R.id.R99_M11_tr);

	}

	/**
	 * 初始化Screenshot_20150410_14.jpg
	 * 
	 * @param inflater
	 * @param container
	 * @return
	 */
	private View initView(LayoutInflater inflater, ViewGroup container) {
		View view = inflater.inflate(R.layout.actqtdata3, container, false);
		context = view.getContext();
		this.fragmentManager = getActivity().getFragmentManager();
		bundle = this.getArguments();
		QT_TYPE = bundle.getString("M1_QT_TYPE");
		QT_NO   = bundle.getString("M1_QT_NO");
		QT_SEQ  = bundle.getString("M1_QT_SEQ");
		CURRENCY= bundle.getString("CURRENCY");

		R99_lb_M12_SUM = (TextView) view.findViewById(R.id.R99_lb_M12_SUM);
		R99_lb_M11_SUM = (TextView) view.findViewById(R.id.R99_lb_M11_SUM);
		R99_lb_M11_SUM_TOTAL = (TextView) view.findViewById(R.id.R99_lb_M11_SUM_TOTAL);
		if (CURRENCY!=null){

		}
		else{

		}
        R99_lb_M12_SUM.setText("("+CURRENCY.toString()+")  " + "Sub Total:  ");

        R99_lb_M11_SUM.setText("("+CURRENCY.toString()+")  " + "Sub Total:  ");

        R99_lb_M11_SUM_TOTAL.setText("("+CURRENCY.toString()+")  " + "Total:  ");

        mView = view;
        //20151211
		//initPullDownView(view);
		TextView vwTitle = (TextView) view.findViewById(R.id.title_text);

		//20151215 : setTitle(view); //由下面這一行取代
		vwTitle.setText(QT_TYPE+"-"+QT_NO);

		tabbar = (RelativeLayout) mView.findViewById(R.id.qttab);
		qttab2 = (RelativeLayout) mView.findViewById(R.id.qttab2);
        qttab3 = (RelativeLayout) mView.findViewById(R.id.qttab3);

		qttab2.setVisibility(RelativeLayout.GONE);
        qttab3.setVisibility(RelativeLayout.GONE);

		cmdbar = (RelativeLayout) mView.findViewById(R.id.qt_editbar);

		tab3 = (LinearLayout) mView.findViewById(R.id.tab3);// Detail(M1)
		tab4 = (LinearLayout) mView.findViewById(R.id.tab4);// Detail(M12)
		tab5 = (LinearLayout) mView.findViewById(R.id.tab5);// Detail(M11)
		r3 = (RelativeLayout) mView.findViewById(R.id.r3);//
		r4 = (RelativeLayout) mView.findViewById(R.id.r4);//
		r5 = (RelativeLayout) mView.findViewById(R.id.r5);//

		vwSubTitle = (TextView) mView.findViewById(R.id.subtitle);
		vwSubTitle.setText(QT_SEQ);

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
		// 取得資料
        //M1
        bToQT4=false;

		if (bundle.getString("func") == null) {

            bToQT4=true;
			//讀取第一頁資料並切到 QT4
            queryData();
            //b4_onClick(b4);
		}
		else{
            queryData();

    		if (bundle.getString("func").toString()=="newQT2") {

                //if (btnEdit.getTag().equals("N")) {
                //	showDialog("Permission Denied",
                //			"Sorry, you don't have the permission to edit table.");
                //	return;
                //}
                btnEdit.setVisibility(View.GONE);
                btnDelete.setVisibility(View.GONE);
                btnSave.setVisibility(View.VISIBLE);
                btnCancel.setVisibility(View.VISIBLE);

				R99_M12_tr.setVisibility(View.GONE);
                //if (btnChange.getTag().equals("Y")) {
                //	btnChange.setVisibility(View.VISIBLE);
                //} else {
                //	btnSave.setVisibility(View.VISIBLE);
                //	btnConfirm.setVisibility(View.VISIBLE);
                //}

		    }	
		}
		
		/*
        //M12
        queryData((String) getWebServiceUrl() + "queryQT4",
                queryQT4(QT_TYPE, QT_NO),
                new IDataReceiveListener() {
                    public void onReceiveData(Object obj) {
                        //20151214 : 暫時 remark
                        loadData4(obj);
                        //b4.setTag(2);
                    }
                });
		//M11
		queryData((String) getWebServiceUrl() + "queryQT5",
				queryQT5(QT_TYPE, QT_NO),
				new IDataReceiveListener() {
					public void onReceiveData(Object obj) {
						//20151214 : 暫時 remark
						loadData5(obj);
						//b4.setTag(2);
					}
				});
		*/

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
		fragmentManager.beginTransaction().addToBackStack(null);
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
		String url = super.getWebServiceUrl() + "getQT3";
		JSONObject jsonObject = new JSONObject();
		JSONObject data = new JSONObject();

		try {
			//String[] qtno = getQtNo().split("-");
			//if (qtno.length == 2) {
				data.accumulate("M1_QT_TYPE", QT_TYPE);//qtno[0]
				data.accumulate("M1_QT_NO"  , QT_NO);
                data.accumulate("M1_QT_SEQ" , QT_SEQ);
			//}
			jsonObject.accumulate("userid", super.getLoginUser());
			jsonObject.accumulate("WWID", "13145774WWGlobal999988qt3999");
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
	 * Function S
	 * 
	 * @param v
	 */
	private void setTitle(View v) {
		TextView vwTitle = (TextView) v.findViewById(R.id.title_text);
		vwTitle.setText(getQtNo());
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
    /*
	public static void setEditTextReadOnly(TextView view) {
		// view.setTextColor(R.color.read_only_color); //設置顏色，使其看起來像只讀模式
		if (view instanceof EditText) {
			view.setCursorVisible(false); // 設置光標不可見
			view.setFocusable(false); // 無焦點
			view.setFocusableInTouchMode(false); // 觸摸時也得不到焦點
		}
	}
    */

	/**
	 * 將FAE user編輯資料上傳到webservice
	 * 
	 * @param action
	 *            (Save,Confirm,Changes)
	 */
	private void saveData(final String action) {

        return;
        /* 20151212 : 暫不使用
		// System.out.println("===>Line number: "+new
		// Throwable().getStackTrace()[0].getLineNumber());

		HttpPostAsyncTask task1 = new HttpPostAsyncTask();
		JSONObject data = null;
		String func = "";
		if (tab3.getVisibility() == View.VISIBLE) {
			func = "updateQT3";
			data = getInputData3(action);

		} else if (tab4.getVisibility() == View.VISIBLE) {
			func = "updateQT4";
			data = getInputData2(action);

		}
		//
		//  queryData((String) getWebServiceUrl() + func, data, new
		//  IDataReceiveListener() { public void onReceiveData(Object obj) {
		//
		//  } });
		//
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
        */
	}

	/**
	 * 將QT =>TAB 1 =>Customer Infomations user編輯資料上傳到webservice
	 * 
	 * @param action
	 *            (Save,Confirm,Changes)
	 */
	private void saveData3(final String action) {

		// System.out.println("===>Line number: "+new
		// Throwable().getStackTrace()[0].getLineNumber());

		HttpPostAsyncTask task1 = new HttpPostAsyncTask();
		JSONObject data = null;
		String func = "";

		func = "updateQT3";
		data = getInputData3(action);// get data from user input
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

                        //成功不用show msg
						//showDialog(action + " success");

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

    private void saveData4(final String action) {

        // System.out.println("===>Line number: "+new
        // Throwable().getStackTrace()[0].getLineNumber());

        HttpPostAsyncTask task1 = new HttpPostAsyncTask();
        JSONObject data = null;
        String func = "";

        func = "updateQT4";
        data = getInputData4_Update(action);// get data from user input
        task1.execute((String) super.getWebServiceUrl() + func, data.toString());

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
						//showDialog(action + " success");
                        //重讀資料, 在最後一筆 進入修改模式
                        queryData((String) getWebServiceUrl() + "queryQT4",
                                queryQT4(QT_TYPE, QT_NO),
                                new IDataReceiveListener() {
                                    public void onReceiveData(Object obj) {
                                        //20151214 : 暫時 remark
                                        loadData4(obj);
                                        b4.setTag(2);

                                        showButton_QT4();
                                    }
                                });

                        //showButton_QT4();//20151225


					}
					// showApplicationDialog(mView);
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		});

    }

	private void saveData5(final String action) {

		// System.out.println("===>Line number: "+new
		// Throwable().getStackTrace()[0].getLineNumber());

		HttpPostAsyncTask task1 = new HttpPostAsyncTask();
		JSONObject data = null;
		String func = "";

		func = "updateQT5";
		data = getInputData5_Update(action);// get data from user input
		task1.execute((String) super.getWebServiceUrl() + func, data.toString());

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
						//showDialog(action + " success");
						//---------------------------------
						//重讀資料, 在最後一筆 進入修改模式
						queryData((String) getWebServiceUrl() + "queryQT5",
								queryQT5(QT_TYPE, QT_NO),
								new IDataReceiveListener() {
									public void onReceiveData(Object obj) {
										//20151214 : 暫時 remark
										loadData5(obj);
										b5.setTag(2);

										showButton_QT5();
									}
								});
						//---------------------------------
						
                        //showButton_QT5();//20151225
					}
					// showApplicationDialog(mView);
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		});

	}

    private void deleteData3(final String action) {

        // System.out.println("===>Line number: "+new
        // Throwable().getStackTrace()[0].getLineNumber());

        HttpPostAsyncTask task1 = new HttpPostAsyncTask();
        JSONObject data = null;
        String func = "";

        func = "deleteQT3";
        data = getInputData3_Delete(action);// get data from user input
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

                        //成功不用 show msg
                        //showDialog(action + " success");

                        //重讀資料
                        //queryData();
                        closeFragment();

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

    private void deleteData4(final String action) {

        // System.out.println("===>Line number: "+new
        // Throwable().getStackTrace()[0].getLineNumber());

        HttpPostAsyncTask task1 = new HttpPostAsyncTask();
        JSONObject data = null;
        String func = "";

        func = "deleteQT4";
        data = getInputData4_Delete(action);// get data from user input
        task1.execute((String) super.getWebServiceUrl() + func, data.toString());

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
                        //showDialog(action + " success");

                        //重讀資料, 在最後一筆 進入修改模式
                        queryData((String) getWebServiceUrl() + "queryQT4",
                                queryQT4(QT_TYPE, QT_NO),
                                new IDataReceiveListener() {
                                    public void onReceiveData(Object obj) {
                                        //20151214 : 暫時 remark
                                        loadData4(obj);
                                        b4.setTag(2);

                                        showButton_QT4();
                                    }
                                });

                    }
                    // showApplicationDialog(mView);
                } catch (JSONException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }

        });

    }

	private void deleteData5(final String action) {

		// System.out.println("===>Line number: "+new
		// Throwable().getStackTrace()[0].getLineNumber());

		HttpPostAsyncTask task1 = new HttpPostAsyncTask();
		JSONObject data = null;
		String func = "";

		func = "deleteQT5";
		data = getInputData5_Delete(action);// get data from user input
		task1.execute((String) super.getWebServiceUrl() + func, data.toString());

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
						//showDialog(action + " success");

						//重讀資料, 在最後一筆 進入修改模式
						queryData((String) getWebServiceUrl() + "queryQT5",
                                queryQT5(QT_TYPE, QT_NO),
                                new IDataReceiveListener() {
                                    public void onReceiveData(Object obj) {
                                        //20151214 : 暫時 remark
                                        loadData5(obj);
                                        b5.setTag(2);

                                        showButton_QT5();
									}
								});

					}
					// showApplicationDialog(mView);
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		});

	}

	/**
	 * 將QT =>TAB 2 =>Package Information user編輯資料上傳到webservice
	 * 
	 * @param action
	 *            (Save,Confirm,Changes)
	 */
	private void saveData2(final String action) {

		// System.out.println("===>Line number: "+new
		// Throwable().getStackTrace()[0].getLineNumber());

		HttpPostAsyncTask task1 = new HttpPostAsyncTask();
		JSONObject data = null;
		String func = "";

		func = "updateQT4";
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
		tab3.setVisibility(View.VISIBLE);
		tab4.setVisibility(View.GONE);

		b3 = (Button) mView.findViewById(R.id.b3);
		b4 = (Button) mView.findViewById(R.id.b4);

		b3.setText("Customer");
		b4.setText("Detail");

		b4.setTag(0);

			b3.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {

                    vwSubTitle.setText(b3.getText());
                    //if (tabbar != null)
                    //	tabbar.setVisibility(RelativeLayout.GONE);
                    if (tab4 != null
                            && tab4.getVisibility() == RelativeLayout.VISIBLE)
                        tab4.setVisibility(RelativeLayout.GONE);

                    tab3.setVisibility(RelativeLayout.VISIBLE);
                    if (cmdbar != null && !cmdbar.isShown()) {
                        cmdbar.setVisibility(RelativeLayout.VISIBLE);
                    }
                }
            });
			b4.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {

                    int tag = (Integer) v.getTag();
                    vwSubTitle.setText(b4.getText());
                    //if (tabbar != null)
                    //	tabbar.setVisibility(RelativeLayout.GONE);
                    if (tab3 != null
                            && tab3.getVisibility() == RelativeLayout.VISIBLE)
                        tab3.setVisibility(RelativeLayout.GONE);
                    tab4.setVisibility(RelativeLayout.VISIBLE);

                    //if (cmdbar != null && !cmdbar.isShown()) {
                    //	cmdbar.setVisibility(RelativeLayout.VISIBLE);
                    //}
                    if (tag != 2) {
                        queryData((String) getWebServiceUrl() + "queryQT4",
                                queryQT4(QT_TYPE, QT_NO),
                                new IDataReceiveListener() {
                                    public void onReceiveData(Object obj) {
                                        loadData4(obj);
                                        b4.setTag(2);
                                    }
                                });
                    }
                }
            });


	}
    */
    /*
	@Override
	public void onMore() {
		// TODO Auto-generated method stub
		// Runnable =>被處理的事件
		// Handler =>處理器


	}
	*/
	/*
	@Override
	public void onRefresh() {
		// TODO Auto-generated method stub
		// Runnable =>被處理的事件
		// Handler =>處理器


	}
	*/
    /*
	private void initPullDownView(View view) {

		//
		//  1.使用PullDownView 2.設置OnPullDownListener 3.從mPullDownView里面獲取ListView
		//

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
		// adapter4 = new
		// SimpleAdapter(context,mStrings,R.layout.pulldown_item,new
		// String[]{"title","content"},new int[]
		// {R.id.msg_title2,R.id.msg_content} );
		qtItems4 = new ArrayList<QtItem4>();
		adapter4 = new QtListAdapter4(context, qtItems4);
		lstQt.setAdapter(adapter4);

        //20151211 : 暫時 remark
		//mPullDownView.enableAutoFetchMore(true, 1);

	}
    */

	//@Override
	/**
	 * 按下列表的某一列資料,觸發的action
	 */
    /*
	public void onItemClick(AdapterView<?> parent, View view, int position,
							long id) {
        //return;

        //onItemClick 不用實做
		// TODO Auto-generated method stub
		final QtItem4 item4 = (QtItem4) qtItems4.get(position);
		Bundle bundle2 = new Bundle();
		bundle2.putString("M1_QT_TYPE", item4.getM1_QT_TYPE());
		bundle2.putString("M1_QT_NO", item4.getM1_QT_NO());
		bundle2.putString("M1_QT_SEQ"  , item4.getM1_QT_SEQ  ());
		bundle2.putString("AP_TYPE"    , item4.getAP_TYPE    ());
		bundle2.putString("AP_NO"      , item4.getAP_NO      ());
		bundle2.putString("DRAWING_REF", item4.getDRAWING_REF());
		bundle2.putString("DESCRIPTION", item4.getDESCRIPTION());

		// 要跟其他Fragment溝通,需要用getActivity()回到Activity
		//((MainActivity) getActivity()).callQtDataActivity(bundle);

		//20151210暫時 remark
		//callQt4DataActivity(bundle);

	}
    */

	private  void callQt4DataActivity(Bundle b)
	{
		Fragment fragment = null;
		FragmentManager fragmentManager = getFragmentManager();
		QtDataActivity3 activity = new QtDataActivity3();
		activity.parent=this;
		// disable next statement
		activity.setFragmentManager(fragmentManager) ;
		fragment = (Fragment) activity;
		fragment.setRetainInstance(true);
		fragment.setArguments(b);
		fragmentManager.beginTransaction()
				.add(R.id.content_frame, fragment).commit();
		fragmentManager.beginTransaction()
				.hide(this)
                .commit();
		fragmentManager.beginTransaction()
				.show(fragment)
				.commit();

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
			super.postRequest(url, jsonObject);

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// new HttpGetAsyncTask().execute(url);

	}

    @Override
    /**
     * get webservice data　(getQT1 =>Customer Infomations)
     * @param obj
     */
    public void loadData(Object result) {

        try {
			isLoading=0;
            JSONObject jsonObject = new JSONObject((String) result);
            if (!jsonObject.getString("success").equals("true")) {
                showDialog("error", jsonObject.getString("remark"));
                return;
            }
            JSONObject data = jsonObject.getJSONObject("data");
            final String QT_TYPE = data.getString("QT_TYPE");
            final String QT_NO = data.getString("QT_NO");
            // if (data.getString("editable").equals("N")) {
            // btnEdit.setVisibility(View.GONE);
            // }
            btnEdit.setTag(data.getString("editable"));
            //if(data.getString("CONFIRM_CODE")!=null)
            btnChange.setTag(data.getString("CONFIRM_CODE"));

            VERSION = data.getString("VERSION");

            M1_QT_TYPE .setText(data.getString("M1_QT_TYPE" )); //M1_QT_TYPE
            M1_QT_NO   .setText(data.getString("M1_QT_NO"   )); //M1_QT_NO
            M1_QT_SEQ  .setText(data.getString("M1_QT_SEQ"  )); //M1_QT_SEQ
            AP_TYPE    .setText(data.getString("AP_TYPE"    )); //AP_TYPE
            AP_NO      .setText(data.getString("AP_NO"      )); //AP_NO
            DRAWING_REF.setText(data.getString("DRAWING_REF")); //DRAWING_REF
            DESCRIPTION.setText(data.getString("DESCRIPTION")); //DESCRIPTION
			APQP_NO    .setText(data.getString("APQP_NO"    )); //APQP_NO

            // xa593(get Qt Type 1~7) =>畫面顯示哪一個TAB的辨識碼
            //setLayoutUI(Integer.parseInt(xa593));
            //20160112 : 本段還原
            btnEdit   .setVisibility(View.GONE);
            btnSave   .setVisibility(View.GONE);
            btnCancel .setVisibility(View.GONE);
            btnChange .setVisibility(View.GONE);
            btnConfirm.setVisibility(View.GONE);
            btnDelete .setVisibility(View.GONE);

            btnAdd4.setVisibility(View.GONE);
            btnAdd5.setVisibility(View.GONE);

            //20160115
            if (btnChange.getTag().equals("Y")) {
                btnEdit   .setVisibility(View.VISIBLE);
            } else {
                btnEdit   .setVisibility(View.VISIBLE);
                btnDelete .setVisibility(View.VISIBLE);
            }

            //讀取第一頁資料並切到 QT4
            if (bToQT4==true) {

                bToQT4 = false;

                //切到 QT4
                b4_onClick(b4);
            }

        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

	private void addNewQT4(final String action)
	{

		FragmentManager fragmentManager = getFragmentManager();


		BaseFragment.HttpPostAsyncTask task1 = new BaseFragment.HttpPostAsyncTask();
		JSONObject data = null;
		String func = "";


		func = "newQT4";
		data = getInputData4_Insert(action);//get data from user input
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

                        //重讀資料, 在最後一筆 進入修改模式
                        queryData((String) getWebServiceUrl() + "queryQT4",
                                queryQT4(QT_TYPE, QT_NO),
                                new IDataReceiveListener() {
                                    public void onReceiveData(Object obj) {
                                        //20151214 : 暫時 remark
                                        loadData4(obj);
                                        b4.setTag(2);

                                        if (R06_M12_tr.getVisibility() == RelativeLayout.VISIBLE) {
                                            onClick_M12(R06_M12_btnEdit);
                                        } else if (R05_M12_tr.getVisibility() == RelativeLayout.VISIBLE) {
                                            onClick_M12(R05_M12_btnEdit);
                                        } else if (R04_M12_tr.getVisibility() == RelativeLayout.VISIBLE) {
                                            onClick_M12(R04_M12_btnEdit);
                                        } else if (R03_M12_tr.getVisibility() == RelativeLayout.VISIBLE) {
                                            onClick_M12(R03_M12_btnEdit);
                                        } else if (R02_M12_tr.getVisibility() == RelativeLayout.VISIBLE) {
                                            onClick_M12(R02_M12_btnEdit);
                                        } else if (R01_M12_tr.getVisibility() == RelativeLayout.VISIBLE) {
                                            onClick_M12(R01_M12_btnEdit);
                                        }

                                        //showButton_QT4();

                                    }
                                });





                        //20151224: 下面這段程式碼移動到 addNewQT2

						// TODO Auto-generated method stub
						//Bundle bundle2 = new Bundle();
						//bundle2.putString("M12_QT_TYPE"     , QT_TYPE                         );
						//bundle2.putString("M12_QT_NO"       , QT_NO                           );
						//bundle2.putString("M12_QT_SEQ"      , QT_SEQ                          );
						//bundle2.putString("M12_SEQ"  , data.getString("M12_SEQ"));
						//bundle2.putString("func"       , "newQT4");

						// 要跟其他Fragment溝通,需要用getActivity()回到Activity
						//((MainActivity) getActivity()).callQtDataActivity3(bundle2);

						//20151210暫時 remark
						//callQt3DataActivity(bundle2);


					}
					// showApplicationDialog(mView);
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		});

	}

	private void addNewQT5(final String action)
	{

		FragmentManager fragmentManager = getFragmentManager();


		BaseFragment.HttpPostAsyncTask task1 = new BaseFragment.HttpPostAsyncTask();
		JSONObject data = null;
		String func = "";


		func = "newQT5";
		data = getInputData5_Insert(action);//get data from user input
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

						//重讀資料, 在最後一筆 進入修改模式
						queryData((String) getWebServiceUrl() + "queryQT5",
                                queryQT5(QT_TYPE, QT_NO),
                                new IDataReceiveListener() {
                                    public void onReceiveData(Object obj) {
                                        //20151214 : 暫時 remark
                                        loadData5(obj);
                                        b5.setTag(2);

                                        if (R05_M11_tr.getVisibility() == RelativeLayout.VISIBLE) {
                                            onClick_M11(R05_M11_btnEdit);
                                        } else if (R04_M11_tr.getVisibility() == RelativeLayout.VISIBLE) {
                                            onClick_M11(R04_M11_btnEdit);
                                        } else if (R03_M11_tr.getVisibility() == RelativeLayout.VISIBLE) {
                                            onClick_M11(R03_M11_btnEdit);
                                        } else if (R02_M11_tr.getVisibility() == RelativeLayout.VISIBLE) {
                                            onClick_M11(R02_M11_btnEdit);
                                        } else if (R01_M11_tr.getVisibility() == RelativeLayout.VISIBLE) {
                                            onClick_M11(R01_M11_btnEdit);
                                        }
                                        //showButton_QT5();

									}
								});





						//20151224: 下面這段程式碼移動到 addNewQT2

						// TODO Auto-generated method stub
						//Bundle bundle2 = new Bundle();
						//bundle2.putString("M11_QT_TYPE"     , QT_TYPE                         );
						//bundle2.putString("M11_QT_NO"       , QT_NO                           );
						//bundle2.putString("M11_QT_SEQ"      , QT_SEQ                          );
						//bundle2.putString("M11_SEQ"  , data.getString("M11_SEQ"));
						//bundle2.putString("func"       , "newQT5");

						// 要跟其他Fragment溝通,需要用getActivity()回到Activity
						//((MainActivity) getActivity()).callQtDataActivity3(bundle2);

						//20151210暫時 remark
						//callQt3DataActivity(bundle2);


					}
					// showApplicationDialog(mView);
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		});

	}


	/*
    http://59.125.146.7:8080/APQPService/newQT4

    http://localhost:11079/APQPService/newQT4

    {    "WWID" : "13145774WWGlobal999988newqt4999",
            "userid" : "mis",
            "data" :{
        "M12_QT_TYPE" : "QT"
                ,"M12_QT_NO"   : "1601310010"
                ,"M12_QT_SEQ"  : "0001"
    }

  }


//輸出結果
//第 1 次
    {
        "remark": "",
            "success": true,
            "data": {
        "M12_QT_NO": "1601310010",
                "M12_QT_SEQ": "0001",
                "M12_SEQ": "1",
                "M12_QT_TYPE": "QT"
    }
    }
    */
	private JSONObject getInputData4_Insert(final String action) {
        
		try {
			JSONObject data = new JSONObject();
			JSONObject jsonObj = new JSONObject();
            String sTmp;

			jsonObj.accumulate("userid", super.getLoginUser());
            jsonObj.accumulate("WWID", "13145774WWGlobal999988newqt4999");

			data.accumulate("M12_QT_TYPE"    , QT_TYPE);
			data.accumulate("M12_QT_NO"      , QT_NO  );
			data.accumulate("M12_QT_SEQ"     , QT_SEQ );

			jsonObj.accumulate("data", data);

			//System.out.println("===>jsonObjjsonObj=: "+jsonObj);

			return jsonObj;
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
            return null;
		}

	}

	/*
    http://59.125.146.7:8080/APQPService/newQT5

    http://localhost:11079/APQPService/newQT5

    {    "WWID" : "13145774WWGlobal999988newqt5999",
            "userid" : "mis",
            "data" :{
        "M11_QT_TYPE" : "QT"
                ,"M11_QT_NO"   : "1601310010"
                ,"M11_QT_SEQ"  : "0001"
    }

  }


//輸出結果
//第 1 次
    {
        "remark": "",
            "success": true,
            "data": {
        "M11_QT_NO": "1601310010",
                "M11_QT_SEQ": "0001",
                "M11_SEQ": "1",
                "M11_QT_TYPE": "QT"
    }
    }
    */
	private JSONObject getInputData5_Insert(final String action) {

		try {
			JSONObject data = new JSONObject();
			JSONObject jsonObj = new JSONObject();
			String sTmp;

			jsonObj.accumulate("userid", super.getLoginUser());
			jsonObj.accumulate("WWID", "13145774WWGlobal999988newqt5999");

			data.accumulate("M11_QT_TYPE"    , QT_TYPE);
			data.accumulate("M11_QT_NO"      , QT_NO  );
			data.accumulate("M11_QT_SEQ"     , QT_SEQ );

			jsonObj.accumulate("data", data);

			//System.out.println("===>jsonObjjsonObj=: "+jsonObj);

			return jsonObj;
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}



	/*
    //-----------------------------------------------------
    // QT4  - Update
    //-----------------------------------------------------
    http://59.125.146.7:8080/APQPService/updateQT4

    http://localhost:11079/APQPService/updateQT4

    {       "WWID"   : "13145774WWGlobal999988qt4999",
            "userid" : "mis",
            "data" :{
                     "action" : "Save"
                     ,"qt4"    :{

                     "QT_TYPE"             : "QT"
                    ,"QT_NO"               : "1601310010"
                    ,"VERSION"             : "0000"
                    ,"editable"            : "Y"
                    ,"CONFIRM_CODE"        : "N"
                    ,"M12_QT_TYPE"         : "QT"
                    ,"M12_QT_NO"           : "1601310010"
                    ,"M12_QT_SEQ"          : "0001"
                    ,"M12_SEQ"      : "1"
                    ,"M12_DETAIL_CLASS"    : "1"
                    ,"M12_DETAIL_PARTNO"   : "2"
                    ,"M12_DETAIL_NAME"     : "3"
                    ,"M12_DETAIL_QTY"      : "4"
                    ,"M12_DETAIL_UT_PRICE" : "5"
                    ,"M12_DETAIL_PRICE"    : "6"
        }
    }

    }
    */
    private JSONObject getInputData4_Update(final String action) {

        try {
            JSONObject data = new JSONObject();
            JSONObject qt4 = new JSONObject();
            JSONObject jsonObj = new JSONObject();
            jsonObj.accumulate("userid", super.getLoginUser());
            jsonObj.accumulate("WWID", "13145774WWGlobal999988qt4999");

            data.accumulate("action", action);

            qt4.accumulate("QT_TYPE", QT_TYPE);
            qt4.accumulate("QT_NO"  , QT_NO  );
            qt4.accumulate("VERSION", VERSION);//20160112 : 還原過來
            //下面這一行尚未完成, 必須再修改
            qt4.accumulate("editable", "Y");
            qt4.accumulate("CONFIRM_CODE", btnChange.getTag().toString());

            qt4.accumulate("M12_QT_TYPE"         , QT_TYPE);
            qt4.accumulate("M12_QT_NO"           , QT_NO  );
            qt4.accumulate("M12_QT_SEQ"          , QT_SEQ );
            qt4.accumulate("M12_SEQ"             , M12_tmp_SEQ       );
            qt4.accumulate("M12_DETAIL_CLASS"    , M12_tmp_DETAIL_CLASS     );
            qt4.accumulate("M12_DETAIL_PARTNO"   , M12_tmp_DETAIL_PARTNO    );
            qt4.accumulate("M12_DETAIL_NAME"     , M12_tmp_DETAIL_NAME      );
            qt4.accumulate("M12_DETAIL_QTY"      , M12_tmp_DETAIL_QTY       );
            qt4.accumulate("M12_DETAIL_UT_PRICE" , M12_tmp_DETAIL_UT_PRICE  );
            qt4.accumulate("M12_DETAIL_PRICE"    , M12_tmp_DETAIL_PRICE     );

            data.accumulate("qt4", qt4);
            jsonObj.accumulate("data", data);
            return jsonObj;
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }

    }

	/*
    //-----------------------------------------------------
    // QT5  - Update
    //-----------------------------------------------------
    http://59.125.146.7:8080/APQPService/updateQT5

    http://localhost:11079/APQPService/updateQT5

    {       "WWID"   : "13145774WWGlobal999988qt5999",
            "userid" : "mis",
            "data" :{
                     "action" : "Save"
                     ,"qt5"    :{

                     "QT_TYPE"             : "QT"
                    ,"QT_NO"               : "1601310010"
                    ,"VERSION"             : "0000"
                    ,"editable"            : "Y"
                    ,"CONFIRM_CODE"        : "N"
                    ,"M11_QT_TYPE"         : "QT"
                    ,"M11_QT_NO"           : "1601310010"
                    ,"M11_QT_SEQ"          : "0001"
                    ,"M11_SEQ"      : "1"
                    ,"M11_DETAIL_CLASS"    : "1"
                    ,"M11_DETAIL_PARTNO"   : "2"
                    ,"M11_DETAIL_NAME"     : "3"
                    ,"M11_DETAIL_QTY"      : "4"
                    ,"M11_DETAIL_UT_PRICE" : "5"
                    ,"M11_DETAIL_PRICE"    : "6"
        }
    }

    }
    */
    private JSONObject getInputData5_Update(final String action) {

        try {
            JSONObject data = new JSONObject();
            JSONObject qt5 = new JSONObject();
            JSONObject jsonObj = new JSONObject();
            jsonObj.accumulate("userid", super.getLoginUser());
            jsonObj.accumulate("WWID", "13145774WWGlobal999988qt5999");

            data.accumulate("action", action);

            qt5.accumulate("QT_TYPE", QT_TYPE);
            qt5.accumulate("QT_NO"  , QT_NO  );
            qt5.accumulate("VERSION", VERSION);//20160112 : 還原過來
            //下面這一行尚未完成, 必須再修改
            qt5.accumulate("editable", "Y");
            qt5.accumulate("CONFIRM_CODE", btnChange.getTag().toString());

            qt5.accumulate("M11_QT_TYPE"         , QT_TYPE);
            qt5.accumulate("M11_QT_NO"           , QT_NO  );
            qt5.accumulate("M11_QT_SEQ"          , QT_SEQ );
            qt5.accumulate("M11_SEQ"             , M11_tmp_SEQ       );
            qt5.accumulate("M11_QTY1"            , M11_tmp_QTY1             );
            qt5.accumulate("M11_QTY2"            , M11_tmp_QTY2             );
            qt5.accumulate("M11_UNIT"            , M11_tmp_UNIT             );
            qt5.accumulate("M11_LIST_PRICE"      , M11_tmp_LIST_PRICE       );
            qt5.accumulate("M11_SALE_PERCENT"    , M11_tmp_SALE_PERCENT     );
            qt5.accumulate("M11_UNIT_PRICE"      , M11_tmp_UNIT_PRICE       );
            qt5.accumulate("M11_TOTAL"           , M11_tmp_TOTAL            );

            data.accumulate("qt5", qt5);
            jsonObj.accumulate("data", data);
            return jsonObj;
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }

    }


    private JSONObject getInputData4_Delete(final String action) {

        try {
            JSONObject data = new JSONObject();
            JSONObject qt4 = new JSONObject();
            JSONObject jsonObj = new JSONObject();
            jsonObj.accumulate("userid", super.getLoginUser());
            jsonObj.accumulate("WWID", "13145774WWGlobal999988delqt4999");

            data.accumulate("action", action);

            qt4.accumulate("QT_TYPE", QT_TYPE);
            qt4.accumulate("QT_NO"  , QT_NO  );
            qt4.accumulate("VERSION", VERSION);//20160112 : 還原過來
            //下面這一行尚未完成, 必須再修改
            qt4.accumulate("editable", "Y");
            qt4.accumulate("CONFIRM_CODE", btnChange.getTag().toString());

            qt4.accumulate("M12_QT_TYPE"         , QT_TYPE);
            qt4.accumulate("M12_QT_NO"           , QT_NO  );
            qt4.accumulate("M12_QT_SEQ"          , QT_SEQ );
            qt4.accumulate("M12_SEQ"             , M12_tmp_SEQ       );
            qt4.accumulate("M12_DETAIL_CLASS"    , M12_tmp_DETAIL_CLASS     );
            qt4.accumulate("M12_DETAIL_PARTNO"   , M12_tmp_DETAIL_PARTNO    );
            qt4.accumulate("M12_DETAIL_NAME"     , M12_tmp_DETAIL_NAME      );
            qt4.accumulate("M12_DETAIL_QTY"      , M12_tmp_DETAIL_QTY       );
            qt4.accumulate("M12_DETAIL_UT_PRICE" , M12_tmp_DETAIL_UT_PRICE  );
            qt4.accumulate("M12_DETAIL_PRICE"    , M12_tmp_DETAIL_PRICE     );

            data.accumulate("qt4", qt4);
            jsonObj.accumulate("data", data);
            return jsonObj;
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }

    }

    private JSONObject getInputData5_Delete(final String action) {

        try {
            JSONObject data = new JSONObject();
            JSONObject qt5 = new JSONObject();
            JSONObject jsonObj = new JSONObject();
            jsonObj.accumulate("userid", super.getLoginUser());
            jsonObj.accumulate("WWID", "13145774WWGlobal999988delqt5999");

            data.accumulate("action", action);

            qt5.accumulate("QT_TYPE", QT_TYPE);
            qt5.accumulate("QT_NO"  , QT_NO  );
            qt5.accumulate("VERSION", VERSION);//20160112 : 還原過來
            //下面這一行尚未完成, 必須再修改
            qt5.accumulate("editable", "Y");
            //qt5.accumulate("CONFIRM_CODE", btnChange.getTag().toString());
            qt5.accumulate("CONFIRM_CODE", btnChange.getTag().toString());

            qt5.accumulate("M11_QT_TYPE"          , QT_TYPE);
            qt5.accumulate("M11_QT_NO"            , QT_NO  );
            qt5.accumulate("M11_QT_SEQ"           , QT_SEQ );
            qt5.accumulate("M11_SEQ"              , M11_tmp_SEQ       );
            qt5.accumulate("M11_QTY1"             , M11_tmp_QTY1             );
            qt5.accumulate("M11_QTY2"             , M11_tmp_QTY2             );
            qt5.accumulate("M11_UNIT"             , M11_tmp_UNIT             );
            qt5.accumulate("M11_LIST_PRICE"       , M11_tmp_LIST_PRICE       );
            qt5.accumulate("M11_SALE_PERCENT"     , M11_tmp_SALE_PERCENT     );
            qt5.accumulate("M11_UNIT_PRICE"       , M11_tmp_UNIT_PRICE       );
            qt5.accumulate("M11_TOTAL"            , M11_tmp_TOTAL            );

            data.accumulate("qt5", qt5);
            jsonObj.accumulate("data", data);
            return jsonObj;
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }

    }

    private void clearDetailData_QT4()
    {
		R01_M12_tr .setVisibility(RelativeLayout.GONE);
		R02_M12_tr .setVisibility(RelativeLayout.GONE);
		R03_M12_tr .setVisibility(RelativeLayout.GONE);
		R04_M12_tr .setVisibility(RelativeLayout.GONE);
		R05_M12_tr .setVisibility(RelativeLayout.GONE);
		R06_M12_tr .setVisibility(RelativeLayout.GONE);

        R01_M12_QT_TYPE         .setText("");
        R01_M12_QT_NO           .setText("");
        R01_M12_QT_SEQ          .setText("");
        R01_M12_SEQ             .setText("");
        R01_M12_DETAIL_CLASS    .setText("");
        R01_M12_DETAIL_PARTNO   .setText("");
        R01_M12_DETAIL_NAME     .setText("");
        R01_M12_DETAIL_QTY      .setText("");
        R01_M12_DETAIL_UT_PRICE .setText("");
        R01_M12_DETAIL_PRICE    .setText("");

        R02_M12_QT_TYPE         .setText("");
        R02_M12_QT_NO           .setText("");
        R02_M12_QT_SEQ          .setText("");
        R02_M12_SEQ             .setText("");
        R02_M12_DETAIL_CLASS    .setText("");
        R02_M12_DETAIL_PARTNO   .setText("");
        R02_M12_DETAIL_NAME     .setText("");
        R02_M12_DETAIL_QTY      .setText("");
        R02_M12_DETAIL_UT_PRICE .setText("");
        R02_M12_DETAIL_PRICE    .setText("");

        R03_M12_QT_TYPE         .setText("");
        R03_M12_QT_NO           .setText("");
        R03_M12_QT_SEQ          .setText("");
        R03_M12_SEQ             .setText("");
        R03_M12_DETAIL_CLASS    .setText("");
        R03_M12_DETAIL_PARTNO   .setText("");
        R03_M12_DETAIL_NAME     .setText("");
        R03_M12_DETAIL_QTY      .setText("");
        R03_M12_DETAIL_UT_PRICE .setText("");
        R03_M12_DETAIL_PRICE    .setText("");

        R04_M12_QT_TYPE         .setText("");
        R04_M12_QT_NO           .setText("");
        R04_M12_QT_SEQ          .setText("");
        R04_M12_SEQ             .setText("");
        R04_M12_DETAIL_CLASS    .setText("");
        R04_M12_DETAIL_PARTNO   .setText("");
        R04_M12_DETAIL_NAME     .setText("");
        R04_M12_DETAIL_QTY      .setText("");
        R04_M12_DETAIL_UT_PRICE .setText("");
        R04_M12_DETAIL_PRICE    .setText("");

        R05_M12_QT_TYPE         .setText("");
        R05_M12_QT_NO           .setText("");
        R05_M12_QT_SEQ          .setText("");
        R05_M12_SEQ             .setText("");
        R05_M12_DETAIL_CLASS    .setText("");
        R05_M12_DETAIL_PARTNO   .setText("");
        R05_M12_DETAIL_NAME     .setText("");
        R05_M12_DETAIL_QTY      .setText("");
        R05_M12_DETAIL_UT_PRICE .setText("");
        R05_M12_DETAIL_PRICE    .setText("");

        R06_M12_QT_TYPE         .setText("");
        R06_M12_QT_NO           .setText("");
        R06_M12_QT_SEQ          .setText("");
        R06_M12_SEQ             .setText("");
        R06_M12_DETAIL_CLASS    .setText("");
        R06_M12_DETAIL_PARTNO   .setText("");
        R06_M12_DETAIL_NAME     .setText("");
        R06_M12_DETAIL_QTY      .setText("");
        R06_M12_DETAIL_UT_PRICE .setText("");
        R06_M12_DETAIL_PRICE    .setText("");

        setEditTextReadOnly(R01_M12_QT_TYPE, true);
        setEditTextReadOnly(R01_M12_QT_NO           ,true);
        setEditTextReadOnly(R01_M12_QT_SEQ          ,true);
        setEditTextReadOnly(R01_M12_SEQ             ,true);
        setEditTextReadOnly(R01_M12_DETAIL_CLASS    ,true);
        setEditTextReadOnly(R01_M12_DETAIL_PARTNO   ,true);
        setEditTextReadOnly(R01_M12_DETAIL_NAME     ,true);
        setEditTextReadOnly(R01_M12_DETAIL_QTY      ,true);
        setEditTextReadOnly(R01_M12_DETAIL_UT_PRICE ,true);
        setEditTextReadOnly(R01_M12_DETAIL_PRICE    ,true);

        setEditTextReadOnly(R02_M12_QT_TYPE         ,true);
        setEditTextReadOnly(R02_M12_QT_NO           ,true);
        setEditTextReadOnly(R02_M12_QT_SEQ          ,true);
        setEditTextReadOnly(R02_M12_SEQ             ,true);
        setEditTextReadOnly(R02_M12_DETAIL_CLASS    ,true);
        setEditTextReadOnly(R02_M12_DETAIL_PARTNO   ,true);
        setEditTextReadOnly(R02_M12_DETAIL_NAME     ,true);
        setEditTextReadOnly(R02_M12_DETAIL_QTY      ,true);
        setEditTextReadOnly(R02_M12_DETAIL_UT_PRICE ,true);
        setEditTextReadOnly(R02_M12_DETAIL_PRICE    ,true);

        setEditTextReadOnly(R03_M12_QT_TYPE         ,true);
        setEditTextReadOnly(R03_M12_QT_NO           ,true);
        setEditTextReadOnly(R03_M12_QT_SEQ          ,true);
        setEditTextReadOnly(R03_M12_SEQ             ,true);
        setEditTextReadOnly(R03_M12_DETAIL_CLASS    ,true);
        setEditTextReadOnly(R03_M12_DETAIL_PARTNO   ,true);
        setEditTextReadOnly(R03_M12_DETAIL_NAME     ,true);
        setEditTextReadOnly(R03_M12_DETAIL_QTY      ,true);
        setEditTextReadOnly(R03_M12_DETAIL_UT_PRICE ,true);
        setEditTextReadOnly(R03_M12_DETAIL_PRICE    ,true);

        setEditTextReadOnly(R04_M12_QT_TYPE         ,true);
        setEditTextReadOnly(R04_M12_QT_NO           ,true);
        setEditTextReadOnly(R04_M12_QT_SEQ          ,true);
        setEditTextReadOnly(R04_M12_SEQ             ,true);
        setEditTextReadOnly(R04_M12_DETAIL_CLASS    ,true);
        setEditTextReadOnly(R04_M12_DETAIL_PARTNO   ,true);
        setEditTextReadOnly(R04_M12_DETAIL_NAME     ,true);
        setEditTextReadOnly(R04_M12_DETAIL_QTY      ,true);
        setEditTextReadOnly(R04_M12_DETAIL_UT_PRICE ,true);
        setEditTextReadOnly(R04_M12_DETAIL_PRICE    ,true);

        setEditTextReadOnly(R05_M12_QT_TYPE         ,true);
        setEditTextReadOnly(R05_M12_QT_NO           ,true);
        setEditTextReadOnly(R05_M12_QT_SEQ          ,true);
        setEditTextReadOnly(R05_M12_SEQ             ,true);
        setEditTextReadOnly(R05_M12_DETAIL_CLASS    ,true);
        setEditTextReadOnly(R05_M12_DETAIL_PARTNO   ,true);
        setEditTextReadOnly(R05_M12_DETAIL_NAME     ,true);
        setEditTextReadOnly(R05_M12_DETAIL_QTY      ,true);
        setEditTextReadOnly(R05_M12_DETAIL_UT_PRICE ,true);
        setEditTextReadOnly(R05_M12_DETAIL_PRICE    ,true);

        setEditTextReadOnly(R06_M12_QT_TYPE         ,true);
        setEditTextReadOnly(R06_M12_QT_NO           ,true);
        setEditTextReadOnly(R06_M12_QT_SEQ          ,true);
        setEditTextReadOnly(R06_M12_SEQ             ,true);
        setEditTextReadOnly(R06_M12_DETAIL_CLASS    ,true);
        setEditTextReadOnly(R06_M12_DETAIL_PARTNO   ,true);
        setEditTextReadOnly(R06_M12_DETAIL_NAME     ,true);
        setEditTextReadOnly(R06_M12_DETAIL_QTY      ,true);
        setEditTextReadOnly(R06_M12_DETAIL_UT_PRICE ,true);
        setEditTextReadOnly(R06_M12_DETAIL_PRICE    ,true);

        R01_M12_QT_TYPE        .setBackgroundColor(getResources().getColor(R.color.transparent));
        R01_M12_QT_NO          .setBackgroundColor(getResources().getColor(R.color.transparent));
        R01_M12_QT_SEQ         .setBackgroundColor(getResources().getColor(R.color.transparent));
        R01_M12_SEQ            .setBackgroundColor(getResources().getColor(R.color.transparent));
        R01_M12_DETAIL_CLASS   .setBackgroundColor(getResources().getColor(R.color.transparent));
        R01_M12_DETAIL_PARTNO  .setBackgroundColor(getResources().getColor(R.color.transparent));
        R01_M12_DETAIL_NAME    .setBackgroundColor(getResources().getColor(R.color.transparent));
        R01_M12_DETAIL_QTY     .setBackgroundColor(getResources().getColor(R.color.transparent));
        R01_M12_DETAIL_UT_PRICE.setBackgroundColor(getResources().getColor(R.color.transparent));
        R01_M12_DETAIL_PRICE   .setBackgroundColor(getResources().getColor(R.color.transparent));

        R02_M12_QT_TYPE        .setBackgroundColor(getResources().getColor(R.color.transparent));
        R02_M12_QT_NO          .setBackgroundColor(getResources().getColor(R.color.transparent));
        R02_M12_QT_SEQ         .setBackgroundColor(getResources().getColor(R.color.transparent));
        R02_M12_SEQ            .setBackgroundColor(getResources().getColor(R.color.transparent));
        R02_M12_DETAIL_CLASS   .setBackgroundColor(getResources().getColor(R.color.transparent));
        R02_M12_DETAIL_PARTNO  .setBackgroundColor(getResources().getColor(R.color.transparent));
        R02_M12_DETAIL_NAME    .setBackgroundColor(getResources().getColor(R.color.transparent));
        R02_M12_DETAIL_QTY     .setBackgroundColor(getResources().getColor(R.color.transparent));
        R02_M12_DETAIL_UT_PRICE.setBackgroundColor(getResources().getColor(R.color.transparent));
        R02_M12_DETAIL_PRICE   .setBackgroundColor(getResources().getColor(R.color.transparent));

        R03_M12_QT_TYPE        .setBackgroundColor(getResources().getColor(R.color.transparent));
        R03_M12_QT_NO          .setBackgroundColor(getResources().getColor(R.color.transparent));
        R03_M12_QT_SEQ         .setBackgroundColor(getResources().getColor(R.color.transparent));
        R03_M12_SEQ            .setBackgroundColor(getResources().getColor(R.color.transparent));
        R03_M12_DETAIL_CLASS   .setBackgroundColor(getResources().getColor(R.color.transparent));
        R03_M12_DETAIL_PARTNO  .setBackgroundColor(getResources().getColor(R.color.transparent));
        R03_M12_DETAIL_NAME    .setBackgroundColor(getResources().getColor(R.color.transparent));
        R03_M12_DETAIL_QTY     .setBackgroundColor(getResources().getColor(R.color.transparent));
        R03_M12_DETAIL_UT_PRICE.setBackgroundColor(getResources().getColor(R.color.transparent));
        R03_M12_DETAIL_PRICE   .setBackgroundColor(getResources().getColor(R.color.transparent));

        R04_M12_QT_TYPE        .setBackgroundColor(getResources().getColor(R.color.transparent));
        R04_M12_QT_NO          .setBackgroundColor(getResources().getColor(R.color.transparent));
        R04_M12_QT_SEQ         .setBackgroundColor(getResources().getColor(R.color.transparent));
        R04_M12_SEQ            .setBackgroundColor(getResources().getColor(R.color.transparent));
        R04_M12_DETAIL_CLASS   .setBackgroundColor(getResources().getColor(R.color.transparent));
        R04_M12_DETAIL_PARTNO  .setBackgroundColor(getResources().getColor(R.color.transparent));
        R04_M12_DETAIL_NAME    .setBackgroundColor(getResources().getColor(R.color.transparent));
        R04_M12_DETAIL_QTY     .setBackgroundColor(getResources().getColor(R.color.transparent));
        R04_M12_DETAIL_UT_PRICE.setBackgroundColor(getResources().getColor(R.color.transparent));
        R04_M12_DETAIL_PRICE   .setBackgroundColor(getResources().getColor(R.color.transparent));

        R05_M12_QT_TYPE        .setBackgroundColor(getResources().getColor(R.color.transparent));
        R05_M12_QT_NO          .setBackgroundColor(getResources().getColor(R.color.transparent));
        R05_M12_QT_SEQ         .setBackgroundColor(getResources().getColor(R.color.transparent));
        R05_M12_SEQ            .setBackgroundColor(getResources().getColor(R.color.transparent));
        R05_M12_DETAIL_CLASS   .setBackgroundColor(getResources().getColor(R.color.transparent));
        R05_M12_DETAIL_PARTNO  .setBackgroundColor(getResources().getColor(R.color.transparent));
        R05_M12_DETAIL_NAME    .setBackgroundColor(getResources().getColor(R.color.transparent));
        R05_M12_DETAIL_QTY     .setBackgroundColor(getResources().getColor(R.color.transparent));
        R05_M12_DETAIL_UT_PRICE.setBackgroundColor(getResources().getColor(R.color.transparent));
        R05_M12_DETAIL_PRICE   .setBackgroundColor(getResources().getColor(R.color.transparent));

        R06_M12_QT_TYPE        .setBackgroundColor(getResources().getColor(R.color.transparent));
        R06_M12_QT_NO          .setBackgroundColor(getResources().getColor(R.color.transparent));
        R06_M12_QT_SEQ         .setBackgroundColor(getResources().getColor(R.color.transparent));
        R06_M12_SEQ            .setBackgroundColor(getResources().getColor(R.color.transparent));
        R06_M12_DETAIL_CLASS   .setBackgroundColor(getResources().getColor(R.color.transparent));
        R06_M12_DETAIL_PARTNO  .setBackgroundColor(getResources().getColor(R.color.transparent));
        R06_M12_DETAIL_NAME    .setBackgroundColor(getResources().getColor(R.color.transparent));
        R06_M12_DETAIL_QTY     .setBackgroundColor(getResources().getColor(R.color.transparent));
        R06_M12_DETAIL_UT_PRICE.setBackgroundColor(getResources().getColor(R.color.transparent));
        R06_M12_DETAIL_PRICE   .setBackgroundColor(getResources().getColor(R.color.transparent));

    }

	private void clearDetailData_QT5()
	{
		R01_M11_tr .setVisibility(RelativeLayout.GONE);
		R02_M11_tr .setVisibility(RelativeLayout.GONE);
		R03_M11_tr .setVisibility(RelativeLayout.GONE);
		R04_M11_tr .setVisibility(RelativeLayout.GONE);
		R05_M11_tr .setVisibility(RelativeLayout.GONE);

		R01_M11_QT_TYPE         .setText("");
		R01_M11_QT_NO           .setText("");
		R01_M11_QT_SEQ          .setText("");
		R01_M11_SEQ             .setText("");
		R01_M11_QTY1            .setText("");
		R01_M11_QTY2            .setText("");
		R01_M11_UNIT            .setText("");
		R01_M11_LIST_PRICE      .setText("");
		R01_M11_SALE_PERCENT    .setText("");
		R01_M11_UNIT_PRICE      .setText("");
		R01_M11_TOTAL           .setText("");

		R02_M11_QT_TYPE         .setText("");
		R02_M11_QT_NO           .setText("");
		R02_M11_QT_SEQ          .setText("");
		R02_M11_SEQ             .setText("");
		R02_M11_QTY1            .setText("");
		R02_M11_QTY2            .setText("");
		R02_M11_UNIT            .setText("");
		R02_M11_LIST_PRICE      .setText("");
		R02_M11_SALE_PERCENT    .setText("");
		R02_M11_UNIT_PRICE      .setText("");
		R02_M11_TOTAL           .setText("");

		R03_M11_QT_TYPE         .setText("");
		R03_M11_QT_NO           .setText("");
		R03_M11_QT_SEQ          .setText("");
		R03_M11_SEQ             .setText("");
		R03_M11_QTY1            .setText("");
		R03_M11_QTY2            .setText("");
		R03_M11_UNIT            .setText("");
		R03_M11_LIST_PRICE      .setText("");
		R03_M11_SALE_PERCENT    .setText("");
		R03_M11_UNIT_PRICE      .setText("");
		R03_M11_TOTAL           .setText("");

		R04_M11_QT_TYPE         .setText("");
		R04_M11_QT_NO           .setText("");
		R04_M11_QT_SEQ          .setText("");
		R04_M11_SEQ             .setText("");
		R04_M11_QTY1            .setText("");
		R04_M11_QTY2            .setText("");
		R04_M11_UNIT            .setText("");
		R04_M11_LIST_PRICE      .setText("");
		R04_M11_SALE_PERCENT    .setText("");
		R04_M11_UNIT_PRICE      .setText("");
		R04_M11_TOTAL           .setText("");

		R05_M11_QT_TYPE         .setText("");
		R05_M11_QT_NO           .setText("");
		R05_M11_QT_SEQ          .setText("");
		R05_M11_SEQ             .setText("");
		R05_M11_QTY1            .setText("");
		R05_M11_QTY2            .setText("");
		R05_M11_UNIT            .setText("");
		R05_M11_LIST_PRICE      .setText("");
		R05_M11_SALE_PERCENT    .setText("");
		R05_M11_UNIT_PRICE      .setText("");
		R05_M11_TOTAL           .setText("");

        setEditTextReadOnly(R01_M11_QT_TYPE      ,true);
        setEditTextReadOnly(R01_M11_QT_NO        ,true);
        setEditTextReadOnly(R01_M11_QT_SEQ       ,true);
        setEditTextReadOnly(R01_M11_SEQ          ,true);
        setEditTextReadOnly(R01_M11_QTY1         ,true);
        setEditTextReadOnly(R01_M11_QTY2         ,true);
        setEditTextReadOnly(R01_M11_UNIT         ,true);
        setEditTextReadOnly(R01_M11_LIST_PRICE   ,true);
        setEditTextReadOnly(R01_M11_SALE_PERCENT ,true);
        setEditTextReadOnly(R01_M11_UNIT_PRICE   ,true);
        setEditTextReadOnly(R01_M11_TOTAL        ,true);

        setEditTextReadOnly(R02_M11_QT_TYPE      ,true);
        setEditTextReadOnly(R02_M11_QT_NO        ,true);
        setEditTextReadOnly(R02_M11_QT_SEQ       ,true);
        setEditTextReadOnly(R02_M11_SEQ          ,true);
        setEditTextReadOnly(R02_M11_QTY1         ,true);
        setEditTextReadOnly(R02_M11_QTY2         ,true);
        setEditTextReadOnly(R02_M11_UNIT         ,true);
        setEditTextReadOnly(R02_M11_LIST_PRICE   ,true);
        setEditTextReadOnly(R02_M11_SALE_PERCENT ,true);
        setEditTextReadOnly(R02_M11_UNIT_PRICE   ,true);
        setEditTextReadOnly(R02_M11_TOTAL        ,true);

        setEditTextReadOnly(R03_M11_QT_TYPE      ,true);
        setEditTextReadOnly(R03_M11_QT_NO        ,true);
        setEditTextReadOnly(R03_M11_QT_SEQ       ,true);
        setEditTextReadOnly(R03_M11_SEQ          ,true);
        setEditTextReadOnly(R03_M11_QTY1         ,true);
        setEditTextReadOnly(R03_M11_QTY2         ,true);
        setEditTextReadOnly(R03_M11_UNIT         ,true);
        setEditTextReadOnly(R03_M11_LIST_PRICE   ,true);
        setEditTextReadOnly(R03_M11_SALE_PERCENT ,true);
        setEditTextReadOnly(R03_M11_UNIT_PRICE   ,true);
        setEditTextReadOnly(R03_M11_TOTAL        ,true);

        setEditTextReadOnly(R04_M11_QT_TYPE      ,true);
        setEditTextReadOnly(R04_M11_QT_NO        ,true);
        setEditTextReadOnly(R04_M11_QT_SEQ       ,true);
        setEditTextReadOnly(R04_M11_SEQ          ,true);
        setEditTextReadOnly(R04_M11_QTY1         ,true);
        setEditTextReadOnly(R04_M11_QTY2         ,true);
        setEditTextReadOnly(R04_M11_UNIT         ,true);
        setEditTextReadOnly(R04_M11_LIST_PRICE   ,true);
        setEditTextReadOnly(R04_M11_SALE_PERCENT ,true);
        setEditTextReadOnly(R04_M11_UNIT_PRICE   ,true);
        setEditTextReadOnly(R04_M11_TOTAL        ,true);

        setEditTextReadOnly(R05_M11_QT_TYPE      ,true);
        setEditTextReadOnly(R05_M11_QT_NO        ,true);
        setEditTextReadOnly(R05_M11_QT_SEQ       ,true);
        setEditTextReadOnly(R05_M11_SEQ          ,true);
        setEditTextReadOnly(R05_M11_QTY1         ,true);
        setEditTextReadOnly(R05_M11_QTY2         ,true);
        setEditTextReadOnly(R05_M11_UNIT         ,true);
        setEditTextReadOnly(R05_M11_LIST_PRICE   ,true);
        setEditTextReadOnly(R05_M11_SALE_PERCENT ,true);
        setEditTextReadOnly(R05_M11_UNIT_PRICE   ,true);
        setEditTextReadOnly(R05_M11_TOTAL        ,true);

        R01_M11_QT_TYPE     .setBackgroundColor(getResources().getColor(R.color.transparent));
        R01_M11_QT_NO       .setBackgroundColor(getResources().getColor(R.color.transparent));
        R01_M11_QT_SEQ      .setBackgroundColor(getResources().getColor(R.color.transparent));
        R01_M11_SEQ         .setBackgroundColor(getResources().getColor(R.color.transparent));
        R01_M11_QTY1        .setBackgroundColor(getResources().getColor(R.color.transparent));
        R01_M11_QTY2        .setBackgroundColor(getResources().getColor(R.color.transparent));
        R01_M11_UNIT        .setBackgroundColor(getResources().getColor(R.color.transparent));
        R01_M11_LIST_PRICE  .setBackgroundColor(getResources().getColor(R.color.transparent));
        R01_M11_SALE_PERCENT.setBackgroundColor(getResources().getColor(R.color.transparent));
        R01_M11_UNIT_PRICE  .setBackgroundColor(getResources().getColor(R.color.transparent));
        R01_M11_TOTAL       .setBackgroundColor(getResources().getColor(R.color.transparent));

        R02_M11_QT_TYPE     .setBackgroundColor(getResources().getColor(R.color.transparent));
        R02_M11_QT_NO       .setBackgroundColor(getResources().getColor(R.color.transparent));
        R02_M11_QT_SEQ      .setBackgroundColor(getResources().getColor(R.color.transparent));
        R02_M11_SEQ         .setBackgroundColor(getResources().getColor(R.color.transparent));
        R02_M11_QTY1        .setBackgroundColor(getResources().getColor(R.color.transparent));
        R02_M11_QTY2        .setBackgroundColor(getResources().getColor(R.color.transparent));
        R02_M11_UNIT        .setBackgroundColor(getResources().getColor(R.color.transparent));
        R02_M11_LIST_PRICE  .setBackgroundColor(getResources().getColor(R.color.transparent));
        R02_M11_SALE_PERCENT.setBackgroundColor(getResources().getColor(R.color.transparent));
        R02_M11_UNIT_PRICE  .setBackgroundColor(getResources().getColor(R.color.transparent));
        R02_M11_TOTAL       .setBackgroundColor(getResources().getColor(R.color.transparent));

        R03_M11_QT_TYPE     .setBackgroundColor(getResources().getColor(R.color.transparent));
        R03_M11_QT_NO       .setBackgroundColor(getResources().getColor(R.color.transparent));
        R03_M11_QT_SEQ      .setBackgroundColor(getResources().getColor(R.color.transparent));
        R03_M11_SEQ         .setBackgroundColor(getResources().getColor(R.color.transparent));
        R03_M11_QTY1        .setBackgroundColor(getResources().getColor(R.color.transparent));
        R03_M11_QTY2        .setBackgroundColor(getResources().getColor(R.color.transparent));
        R03_M11_UNIT        .setBackgroundColor(getResources().getColor(R.color.transparent));
        R03_M11_LIST_PRICE  .setBackgroundColor(getResources().getColor(R.color.transparent));
        R03_M11_SALE_PERCENT.setBackgroundColor(getResources().getColor(R.color.transparent));
        R03_M11_UNIT_PRICE  .setBackgroundColor(getResources().getColor(R.color.transparent));
        R03_M11_TOTAL       .setBackgroundColor(getResources().getColor(R.color.transparent));

        R04_M11_QT_TYPE     .setBackgroundColor(getResources().getColor(R.color.transparent));
        R04_M11_QT_NO       .setBackgroundColor(getResources().getColor(R.color.transparent));
        R04_M11_QT_SEQ      .setBackgroundColor(getResources().getColor(R.color.transparent));
        R04_M11_SEQ         .setBackgroundColor(getResources().getColor(R.color.transparent));
        R04_M11_QTY1        .setBackgroundColor(getResources().getColor(R.color.transparent));
        R04_M11_QTY2        .setBackgroundColor(getResources().getColor(R.color.transparent));
        R04_M11_UNIT        .setBackgroundColor(getResources().getColor(R.color.transparent));
        R04_M11_LIST_PRICE  .setBackgroundColor(getResources().getColor(R.color.transparent));
        R04_M11_SALE_PERCENT.setBackgroundColor(getResources().getColor(R.color.transparent));
        R04_M11_UNIT_PRICE  .setBackgroundColor(getResources().getColor(R.color.transparent));
        R04_M11_TOTAL       .setBackgroundColor(getResources().getColor(R.color.transparent));

        R05_M11_QT_TYPE     .setBackgroundColor(getResources().getColor(R.color.transparent));
        R05_M11_QT_NO       .setBackgroundColor(getResources().getColor(R.color.transparent));
        R05_M11_QT_SEQ      .setBackgroundColor(getResources().getColor(R.color.transparent));
        R05_M11_SEQ         .setBackgroundColor(getResources().getColor(R.color.transparent));
        R05_M11_QTY1        .setBackgroundColor(getResources().getColor(R.color.transparent));
        R05_M11_QTY2        .setBackgroundColor(getResources().getColor(R.color.transparent));
        R05_M11_UNIT        .setBackgroundColor(getResources().getColor(R.color.transparent));
        R05_M11_LIST_PRICE  .setBackgroundColor(getResources().getColor(R.color.transparent));
        R05_M11_SALE_PERCENT.setBackgroundColor(getResources().getColor(R.color.transparent));
        R05_M11_UNIT_PRICE  .setBackgroundColor(getResources().getColor(R.color.transparent));
        R05_M11_TOTAL       .setBackgroundColor(getResources().getColor(R.color.transparent));

    }

	private void hideButton_QT4()
    {
        R01_M12_btnEdit   .setVisibility(RelativeLayout.GONE);
        R01_M12_btnDelete .setVisibility(RelativeLayout.GONE);
        R01_M12_btnSave   .setVisibility(RelativeLayout.GONE);
        R01_M12_btnCancel .setVisibility(RelativeLayout.GONE);

        R02_M12_btnEdit   .setVisibility(RelativeLayout.GONE);
        R02_M12_btnDelete .setVisibility(RelativeLayout.GONE);
        R02_M12_btnSave   .setVisibility(RelativeLayout.GONE);
        R02_M12_btnCancel .setVisibility(RelativeLayout.GONE);

        R03_M12_btnEdit   .setVisibility(RelativeLayout.GONE);
        R03_M12_btnDelete .setVisibility(RelativeLayout.GONE);
        R03_M12_btnSave   .setVisibility(RelativeLayout.GONE);
        R03_M12_btnCancel .setVisibility(RelativeLayout.GONE);

        R04_M12_btnEdit   .setVisibility(RelativeLayout.GONE);
        R04_M12_btnDelete .setVisibility(RelativeLayout.GONE);
        R04_M12_btnSave   .setVisibility(RelativeLayout.GONE);
        R04_M12_btnCancel .setVisibility(RelativeLayout.GONE);

        R05_M12_btnEdit   .setVisibility(RelativeLayout.GONE);
        R05_M12_btnDelete .setVisibility(RelativeLayout.GONE);
        R05_M12_btnSave   .setVisibility(RelativeLayout.GONE);
        R05_M12_btnCancel .setVisibility(RelativeLayout.GONE);

        R06_M12_btnEdit   .setVisibility(RelativeLayout.GONE);
        R06_M12_btnDelete .setVisibility(RelativeLayout.GONE);
        R06_M12_btnSave   .setVisibility(RelativeLayout.GONE);
        R06_M12_btnCancel .setVisibility(RelativeLayout.GONE);
        
    }

	private void hideButton_QT5()
	{
		R01_M11_btnEdit   .setVisibility(RelativeLayout.GONE);
		R01_M11_btnDelete .setVisibility(RelativeLayout.GONE);
		R01_M11_btnSave   .setVisibility(RelativeLayout.GONE);
		R01_M11_btnCancel .setVisibility(RelativeLayout.GONE);

		R02_M11_btnEdit   .setVisibility(RelativeLayout.GONE);
		R02_M11_btnDelete .setVisibility(RelativeLayout.GONE);
		R02_M11_btnSave   .setVisibility(RelativeLayout.GONE);
		R02_M11_btnCancel .setVisibility(RelativeLayout.GONE);

		R03_M11_btnEdit   .setVisibility(RelativeLayout.GONE);
		R03_M11_btnDelete .setVisibility(RelativeLayout.GONE);
		R03_M11_btnSave   .setVisibility(RelativeLayout.GONE);
		R03_M11_btnCancel .setVisibility(RelativeLayout.GONE);

		R04_M11_btnEdit   .setVisibility(RelativeLayout.GONE);
		R04_M11_btnDelete .setVisibility(RelativeLayout.GONE);
		R04_M11_btnSave   .setVisibility(RelativeLayout.GONE);
		R04_M11_btnCancel .setVisibility(RelativeLayout.GONE);

		R05_M11_btnEdit   .setVisibility(RelativeLayout.GONE);
		R05_M11_btnDelete .setVisibility(RelativeLayout.GONE);
		R05_M11_btnSave   .setVisibility(RelativeLayout.GONE);
		R05_M11_btnCancel .setVisibility(RelativeLayout.GONE);

	}

	private void showButton_QT4()
    {
        R01_M12_btnEdit   .setVisibility(RelativeLayout.VISIBLE);
        R01_M12_btnDelete .setVisibility(RelativeLayout.VISIBLE);
        R01_M12_btnSave   .setVisibility(RelativeLayout.GONE);
        R01_M12_btnCancel .setVisibility(RelativeLayout.GONE);

        R02_M12_btnEdit   .setVisibility(RelativeLayout.VISIBLE);
        R02_M12_btnDelete .setVisibility(RelativeLayout.VISIBLE);
        R02_M12_btnSave   .setVisibility(RelativeLayout.GONE);
        R02_M12_btnCancel .setVisibility(RelativeLayout.GONE);

        R03_M12_btnEdit   .setVisibility(RelativeLayout.VISIBLE);
        R03_M12_btnDelete .setVisibility(RelativeLayout.VISIBLE);
        R03_M12_btnSave   .setVisibility(RelativeLayout.GONE);
        R03_M12_btnCancel .setVisibility(RelativeLayout.GONE);

        R04_M12_btnEdit   .setVisibility(RelativeLayout.VISIBLE);
        R04_M12_btnDelete .setVisibility(RelativeLayout.VISIBLE);
        R04_M12_btnSave   .setVisibility(RelativeLayout.GONE);
        R04_M12_btnCancel .setVisibility(RelativeLayout.GONE);

        R05_M12_btnEdit   .setVisibility(RelativeLayout.VISIBLE);
        R05_M12_btnDelete .setVisibility(RelativeLayout.VISIBLE);
        R05_M12_btnSave   .setVisibility(RelativeLayout.GONE);
        R05_M12_btnCancel .setVisibility(RelativeLayout.GONE);

        R06_M12_btnEdit   .setVisibility(RelativeLayout.VISIBLE);
        R06_M12_btnDelete .setVisibility(RelativeLayout.VISIBLE);
        R06_M12_btnSave   .setVisibility(RelativeLayout.GONE);
        R06_M12_btnCancel .setVisibility(RelativeLayout.GONE);

    }

	private void showButton_QT5()
	{
		R01_M11_btnEdit   .setVisibility(RelativeLayout.VISIBLE);
		R01_M11_btnDelete .setVisibility(RelativeLayout.VISIBLE);
		R01_M11_btnSave   .setVisibility(RelativeLayout.GONE);
		R01_M11_btnCancel .setVisibility(RelativeLayout.GONE);

		R02_M11_btnEdit   .setVisibility(RelativeLayout.VISIBLE);
		R02_M11_btnDelete .setVisibility(RelativeLayout.VISIBLE);
		R02_M11_btnSave   .setVisibility(RelativeLayout.GONE);
		R02_M11_btnCancel .setVisibility(RelativeLayout.GONE);

		R03_M11_btnEdit   .setVisibility(RelativeLayout.VISIBLE);
		R03_M11_btnDelete .setVisibility(RelativeLayout.VISIBLE);
		R03_M11_btnSave   .setVisibility(RelativeLayout.GONE);
		R03_M11_btnCancel .setVisibility(RelativeLayout.GONE);

		R04_M11_btnEdit   .setVisibility(RelativeLayout.VISIBLE);
		R04_M11_btnDelete .setVisibility(RelativeLayout.VISIBLE);
		R04_M11_btnSave   .setVisibility(RelativeLayout.GONE);
		R04_M11_btnCancel .setVisibility(RelativeLayout.GONE);

		R05_M11_btnEdit   .setVisibility(RelativeLayout.VISIBLE);
		R05_M11_btnDelete .setVisibility(RelativeLayout.VISIBLE);
		R05_M11_btnSave   .setVisibility(RelativeLayout.GONE);
		R05_M11_btnCancel .setVisibility(RelativeLayout.GONE);

	}

    public void onClick_M12(View view) {
        
        Button btn;
        btn = (Button) view;

        //M12_pos = btn.getTag().toString();
        //M12_act = btn.getText().toString();

        String[] array = btn.getTag().toString().split("-");
        if (array.length==2) {
            M12_pos = array[0].toString();
            M12_act = array[1].toString();
        }

        M12_tmp_SEQ             = "";
        M12_tmp_DETAIL_CLASS    = "";
        M12_tmp_DETAIL_PARTNO   = "";
        M12_tmp_DETAIL_NAME     = "";
        M12_tmp_DETAIL_QTY      = "";
        M12_tmp_DETAIL_UT_PRICE = "";
        M12_tmp_DETAIL_PRICE    = "";

        //R01_M12_DETAIL_CLASS.setBackgroundColor(getResources().getColor(R.color.transparent));
        //R01_M12_DETAIL_CLASS.setBackgroundResource(R.drawable.edit_border);

        if (M12_act.equals("E")){

            //20151228
            btnAdd4.setVisibility(View.GONE);//按下修改 要隱藏

            hideButton_QT4();

            if (M12_pos.equals("1")){ R01_M12_btnSave.setVisibility(RelativeLayout.VISIBLE); R01_M12_btnCancel.setVisibility(RelativeLayout.VISIBLE); }
            if (M12_pos.equals("2")){ R02_M12_btnSave.setVisibility(RelativeLayout.VISIBLE); R02_M12_btnCancel.setVisibility(RelativeLayout.VISIBLE); }
            if (M12_pos.equals("3")){ R03_M12_btnSave.setVisibility(RelativeLayout.VISIBLE); R03_M12_btnCancel.setVisibility(RelativeLayout.VISIBLE); }
            if (M12_pos.equals("4")){ R04_M12_btnSave.setVisibility(RelativeLayout.VISIBLE); R04_M12_btnCancel.setVisibility(RelativeLayout.VISIBLE); }
            if (M12_pos.equals("5")){ R05_M12_btnSave.setVisibility(RelativeLayout.VISIBLE); R05_M12_btnCancel.setVisibility(RelativeLayout.VISIBLE); }
            if (M12_pos.equals("6")){ R06_M12_btnSave.setVisibility(RelativeLayout.VISIBLE); R06_M12_btnCancel.setVisibility(RelativeLayout.VISIBLE); }

            if (M12_pos.equals("1")){
                setEditTextReadOnly(R01_M12_QT_TYPE         ,false);
                setEditTextReadOnly(R01_M12_QT_NO           ,false);
                setEditTextReadOnly(R01_M12_QT_SEQ          ,false);
                setEditTextReadOnly(R01_M12_SEQ             ,false);
                setEditTextReadOnly(R01_M12_DETAIL_CLASS    ,false);
                setEditTextReadOnly(R01_M12_DETAIL_PARTNO   ,false);
                setEditTextReadOnly(R01_M12_DETAIL_NAME     ,false);
                setEditTextReadOnly(R01_M12_DETAIL_QTY      ,false);
                setEditTextReadOnly(R01_M12_DETAIL_UT_PRICE , false);
              //setEditTextReadOnly(R01_M12_DETAIL_PRICE    , false);
			  //注意:DETAIL_PRICE 為 readonly, 不開放輸入
            }
            if (M12_pos.equals("2")){
                setEditTextReadOnly(R02_M12_QT_TYPE         ,false);
                setEditTextReadOnly(R02_M12_QT_NO           ,false);
                setEditTextReadOnly(R02_M12_QT_SEQ          ,false);
                setEditTextReadOnly(R02_M12_SEQ             ,false);
                setEditTextReadOnly(R02_M12_DETAIL_CLASS    ,false);
                setEditTextReadOnly(R02_M12_DETAIL_PARTNO   ,false);
                setEditTextReadOnly(R02_M12_DETAIL_NAME     ,false);
                setEditTextReadOnly(R02_M12_DETAIL_QTY      ,false);
                setEditTextReadOnly(R02_M12_DETAIL_UT_PRICE ,false);
              //setEditTextReadOnly(R02_M12_DETAIL_PRICE    ,false);
			  //注意:DETAIL_PRICE 為 readonly, 不開放輸入
            }
            if (M12_pos.equals("3")){
                setEditTextReadOnly(R03_M12_QT_TYPE         ,false);
                setEditTextReadOnly(R03_M12_QT_NO           ,false);
                setEditTextReadOnly(R03_M12_QT_SEQ          ,false);
                setEditTextReadOnly(R03_M12_SEQ             ,false);
                setEditTextReadOnly(R03_M12_DETAIL_CLASS    ,false);
                setEditTextReadOnly(R03_M12_DETAIL_PARTNO   ,false);
                setEditTextReadOnly(R03_M12_DETAIL_NAME     ,false);
                setEditTextReadOnly(R03_M12_DETAIL_QTY      ,false);
                setEditTextReadOnly(R03_M12_DETAIL_UT_PRICE , false);
                //setEditTextReadOnly(R03_M12_DETAIL_PRICE    , false);
				//注意:DETAIL_PRICE 為 readonly, 不開放輸入
            }
            if (M12_pos.equals("4")){
                setEditTextReadOnly(R04_M12_QT_TYPE         ,false);
                setEditTextReadOnly(R04_M12_QT_NO           ,false);
                setEditTextReadOnly(R04_M12_QT_SEQ          ,false);
                setEditTextReadOnly(R04_M12_SEQ             ,false);
                setEditTextReadOnly(R04_M12_DETAIL_CLASS    ,false);
                setEditTextReadOnly(R04_M12_DETAIL_PARTNO   ,false);
                setEditTextReadOnly(R04_M12_DETAIL_NAME     ,false);
                setEditTextReadOnly(R04_M12_DETAIL_QTY      ,false);
                setEditTextReadOnly(R04_M12_DETAIL_UT_PRICE , false);
                //setEditTextReadOnly(R04_M12_DETAIL_PRICE    , false);
				//注意:DETAIL_PRICE 為 readonly, 不開放輸入
            }
            if (M12_pos.equals("5")){
                setEditTextReadOnly(R05_M12_QT_TYPE         ,false);
                setEditTextReadOnly(R05_M12_QT_NO           ,false);
                setEditTextReadOnly(R05_M12_QT_SEQ          ,false);
                setEditTextReadOnly(R05_M12_SEQ             ,false);
                setEditTextReadOnly(R05_M12_DETAIL_CLASS    ,false);
                setEditTextReadOnly(R05_M12_DETAIL_PARTNO   ,false);
                setEditTextReadOnly(R05_M12_DETAIL_NAME     ,false);
                setEditTextReadOnly(R05_M12_DETAIL_QTY      ,false);
                setEditTextReadOnly(R05_M12_DETAIL_UT_PRICE , false);
                //setEditTextReadOnly(R05_M12_DETAIL_PRICE    , false);
				//注意:DETAIL_PRICE 為 readonly, 不開放輸入
            }
            if (M12_pos.equals("6")){
                setEditTextReadOnly(R06_M12_QT_TYPE         ,false);
                setEditTextReadOnly(R06_M12_QT_NO           ,false);
                setEditTextReadOnly(R06_M12_QT_SEQ          ,false);
                setEditTextReadOnly(R06_M12_SEQ             ,false);
                setEditTextReadOnly(R06_M12_DETAIL_CLASS    ,false);
                setEditTextReadOnly(R06_M12_DETAIL_PARTNO   ,false);
                setEditTextReadOnly(R06_M12_DETAIL_NAME     ,false);
                setEditTextReadOnly(R06_M12_DETAIL_QTY      ,false);
                setEditTextReadOnly(R06_M12_DETAIL_UT_PRICE , false);
                //setEditTextReadOnly(R06_M12_DETAIL_PRICE    , false);
				//注意:DETAIL_PRICE 為 readonly, 不開放輸入
            }

            if (M12_pos.equals("1")) {
                R01_M12_QT_TYPE        .setBackgroundResource(R.drawable.edit_border);
                R01_M12_QT_NO          .setBackgroundResource(R.drawable.edit_border);
                R01_M12_QT_SEQ         .setBackgroundResource(R.drawable.edit_border);
                R01_M12_SEQ            .setBackgroundResource(R.drawable.edit_border);
                R01_M12_DETAIL_CLASS   .setBackgroundResource(R.drawable.edit_border);
                R01_M12_DETAIL_PARTNO  .setBackgroundResource(R.drawable.edit_border);
                R01_M12_DETAIL_NAME    .setBackgroundResource(R.drawable.edit_border);
                R01_M12_DETAIL_QTY     .setBackgroundResource(R.drawable.edit_border);
                R01_M12_DETAIL_UT_PRICE.setBackgroundResource(R.drawable.edit_border);
                //R01_M12_DETAIL_PRICE   .setBackgroundResource(R.drawable.edit_border);
            }
            if (M12_pos.equals("2")) {
                R02_M12_QT_TYPE        .setBackgroundResource(R.drawable.edit_border);
                R02_M12_QT_NO          .setBackgroundResource(R.drawable.edit_border);
                R02_M12_QT_SEQ         .setBackgroundResource(R.drawable.edit_border);
                R02_M12_SEQ            .setBackgroundResource(R.drawable.edit_border);
                R02_M12_DETAIL_CLASS   .setBackgroundResource(R.drawable.edit_border);
                R02_M12_DETAIL_PARTNO  .setBackgroundResource(R.drawable.edit_border);
                R02_M12_DETAIL_NAME    .setBackgroundResource(R.drawable.edit_border);
                R02_M12_DETAIL_QTY     .setBackgroundResource(R.drawable.edit_border);
                R02_M12_DETAIL_UT_PRICE.setBackgroundResource(R.drawable.edit_border);
                //R02_M12_DETAIL_PRICE   .setBackgroundResource(R.drawable.edit_border);
            }
            if (M12_pos.equals("3")) {
                R03_M12_QT_TYPE        .setBackgroundResource(R.drawable.edit_border);
                R03_M12_QT_NO          .setBackgroundResource(R.drawable.edit_border);
                R03_M12_QT_SEQ         .setBackgroundResource(R.drawable.edit_border);
                R03_M12_SEQ            .setBackgroundResource(R.drawable.edit_border);
                R03_M12_DETAIL_CLASS   .setBackgroundResource(R.drawable.edit_border);
                R03_M12_DETAIL_PARTNO  .setBackgroundResource(R.drawable.edit_border);
                R03_M12_DETAIL_NAME    .setBackgroundResource(R.drawable.edit_border);
                R03_M12_DETAIL_QTY     .setBackgroundResource(R.drawable.edit_border);
                R03_M12_DETAIL_UT_PRICE.setBackgroundResource(R.drawable.edit_border);
                //R03_M12_DETAIL_PRICE   .setBackgroundResource(R.drawable.edit_border);
            }

            if (M12_pos.equals("4")) {
                R04_M12_QT_TYPE        .setBackgroundResource(R.drawable.edit_border);
                R04_M12_QT_NO          .setBackgroundResource(R.drawable.edit_border);
                R04_M12_QT_SEQ         .setBackgroundResource(R.drawable.edit_border);
                R04_M12_SEQ            .setBackgroundResource(R.drawable.edit_border);
                R04_M12_DETAIL_CLASS   .setBackgroundResource(R.drawable.edit_border);
                R04_M12_DETAIL_PARTNO  .setBackgroundResource(R.drawable.edit_border);
                R04_M12_DETAIL_NAME    .setBackgroundResource(R.drawable.edit_border);
                R04_M12_DETAIL_QTY     .setBackgroundResource(R.drawable.edit_border);
                R04_M12_DETAIL_UT_PRICE.setBackgroundResource(R.drawable.edit_border);
                //R04_M12_DETAIL_PRICE   .setBackgroundResource(R.drawable.edit_border);
            }

            if (M12_pos.equals("5")) {
                R05_M12_QT_TYPE        .setBackgroundResource(R.drawable.edit_border);
                R05_M12_QT_NO          .setBackgroundResource(R.drawable.edit_border);
                R05_M12_QT_SEQ         .setBackgroundResource(R.drawable.edit_border);
                R05_M12_SEQ            .setBackgroundResource(R.drawable.edit_border);
                R05_M12_DETAIL_CLASS   .setBackgroundResource(R.drawable.edit_border);
                R05_M12_DETAIL_PARTNO  .setBackgroundResource(R.drawable.edit_border);
                R05_M12_DETAIL_NAME    .setBackgroundResource(R.drawable.edit_border);
                R05_M12_DETAIL_QTY     .setBackgroundResource(R.drawable.edit_border);
                R05_M12_DETAIL_UT_PRICE.setBackgroundResource(R.drawable.edit_border);
                //R05_M12_DETAIL_PRICE   .setBackgroundResource(R.drawable.edit_border);
            }

            if (M12_pos.equals("6")) {
                R06_M12_QT_TYPE        .setBackgroundResource(R.drawable.edit_border);
                R06_M12_QT_NO          .setBackgroundResource(R.drawable.edit_border);
                R06_M12_QT_SEQ         .setBackgroundResource(R.drawable.edit_border);
                R06_M12_SEQ            .setBackgroundResource(R.drawable.edit_border);
                R06_M12_DETAIL_CLASS   .setBackgroundResource(R.drawable.edit_border);
                R06_M12_DETAIL_PARTNO  .setBackgroundResource(R.drawable.edit_border);
                R06_M12_DETAIL_NAME    .setBackgroundResource(R.drawable.edit_border);
                R06_M12_DETAIL_QTY     .setBackgroundResource(R.drawable.edit_border);
                R06_M12_DETAIL_UT_PRICE.setBackgroundResource(R.drawable.edit_border);
                //R06_M12_DETAIL_PRICE   .setBackgroundResource(R.drawable.edit_border);
            }

        }
        else if (M12_act.equals("D")){

            showDialog("是否確定要刪除?",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int id){
                            //true;//do no
                            if (M12_pos.equals("1")){ M12_tmp_SEQ = R01_M12_SEQ.getText().toString();}
                            if (M12_pos.equals("2")){ M12_tmp_SEQ = R02_M12_SEQ.getText().toString();}
                            if (M12_pos.equals("3")){ M12_tmp_SEQ = R03_M12_SEQ.getText().toString();}
                            if (M12_pos.equals("4")){ M12_tmp_SEQ = R04_M12_SEQ.getText().toString();}
                            if (M12_pos.equals("5")){ M12_tmp_SEQ = R05_M12_SEQ.getText().toString();}
                            if (M12_pos.equals("6")){ M12_tmp_SEQ = R06_M12_SEQ.getText().toString();}

                            deleteData4("Delete");
                            showButton_QT4();

                        }

                    }
                    ,new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int id){
                            //false;//do no
                        }

                    });

//            if (M12_pos.equals("1")){ M12_tmp_SEQ = R01_M12_SEQ.getText().toString();}
//            if (M12_pos.equals("2")){ M12_tmp_SEQ = R02_M12_SEQ.getText().toString();}
//            if (M12_pos.equals("3")){ M12_tmp_SEQ = R03_M12_SEQ.getText().toString();}
//            if (M12_pos.equals("4")){ M12_tmp_SEQ = R04_M12_SEQ.getText().toString();}
//            if (M12_pos.equals("5")){ M12_tmp_SEQ = R05_M12_SEQ.getText().toString();}
//            if (M12_pos.equals("6")){ M12_tmp_SEQ = R06_M12_SEQ.getText().toString();}
//
//            deleteData4("Delete");
//            showButton_QT4();
        }
        else if (M12_act.equals("S")){

            if (M12_pos.equals("1")){
                M12_tmp_SEQ             = R01_M12_SEQ            .getText().toString();
                M12_tmp_DETAIL_CLASS    = R01_M12_DETAIL_CLASS   .getText().toString();
                M12_tmp_DETAIL_PARTNO   = R01_M12_DETAIL_PARTNO  .getText().toString();
                M12_tmp_DETAIL_NAME     = R01_M12_DETAIL_NAME    .getText().toString();
                M12_tmp_DETAIL_QTY      = R01_M12_DETAIL_QTY     .getText().toString();
                M12_tmp_DETAIL_UT_PRICE = R01_M12_DETAIL_UT_PRICE.getText().toString();
                M12_tmp_DETAIL_PRICE    = R01_M12_DETAIL_PRICE   .getText().toString();
            }
            if (M12_pos.equals("2")){
                M12_tmp_SEQ             = R02_M12_SEQ            .getText().toString();
                M12_tmp_DETAIL_CLASS    = R02_M12_DETAIL_CLASS   .getText().toString();
                M12_tmp_DETAIL_PARTNO   = R02_M12_DETAIL_PARTNO  .getText().toString();
                M12_tmp_DETAIL_NAME     = R02_M12_DETAIL_NAME    .getText().toString();
                M12_tmp_DETAIL_QTY      = R02_M12_DETAIL_QTY     .getText().toString();
                M12_tmp_DETAIL_UT_PRICE = R02_M12_DETAIL_UT_PRICE.getText().toString();
                M12_tmp_DETAIL_PRICE    = R02_M12_DETAIL_PRICE   .getText().toString();
            }
            if (M12_pos.equals("3")){
                M12_tmp_SEQ             = R03_M12_SEQ            .getText().toString();
                M12_tmp_DETAIL_CLASS    = R03_M12_DETAIL_CLASS   .getText().toString();
                M12_tmp_DETAIL_PARTNO   = R03_M12_DETAIL_PARTNO  .getText().toString();
                M12_tmp_DETAIL_NAME     = R03_M12_DETAIL_NAME    .getText().toString();
                M12_tmp_DETAIL_QTY      = R03_M12_DETAIL_QTY     .getText().toString();
                M12_tmp_DETAIL_UT_PRICE = R03_M12_DETAIL_UT_PRICE.getText().toString();
                M12_tmp_DETAIL_PRICE    = R03_M12_DETAIL_PRICE   .getText().toString();
            }
            if (M12_pos.equals("4")){
                M12_tmp_SEQ             = R04_M12_SEQ            .getText().toString();
                M12_tmp_DETAIL_CLASS    = R04_M12_DETAIL_CLASS   .getText().toString();
                M12_tmp_DETAIL_PARTNO   = R04_M12_DETAIL_PARTNO  .getText().toString();
                M12_tmp_DETAIL_NAME     = R04_M12_DETAIL_NAME    .getText().toString();
                M12_tmp_DETAIL_QTY      = R04_M12_DETAIL_QTY     .getText().toString();
                M12_tmp_DETAIL_UT_PRICE = R04_M12_DETAIL_UT_PRICE.getText().toString();
                M12_tmp_DETAIL_PRICE    = R04_M12_DETAIL_PRICE   .getText().toString();
            }
            if (M12_pos.equals("5")){
                M12_tmp_SEQ             = R05_M12_SEQ            .getText().toString();
                M12_tmp_DETAIL_CLASS    = R05_M12_DETAIL_CLASS   .getText().toString();
                M12_tmp_DETAIL_PARTNO   = R05_M12_DETAIL_PARTNO  .getText().toString();
                M12_tmp_DETAIL_NAME     = R05_M12_DETAIL_NAME    .getText().toString();
                M12_tmp_DETAIL_QTY      = R05_M12_DETAIL_QTY     .getText().toString();
                M12_tmp_DETAIL_UT_PRICE = R05_M12_DETAIL_UT_PRICE.getText().toString();
                M12_tmp_DETAIL_PRICE    = R05_M12_DETAIL_PRICE   .getText().toString();
            }
            if (M12_pos.equals("6")){
                M12_tmp_SEQ             = R06_M12_SEQ            .getText().toString();
                M12_tmp_DETAIL_CLASS    = R06_M12_DETAIL_CLASS   .getText().toString();
                M12_tmp_DETAIL_PARTNO   = R06_M12_DETAIL_PARTNO  .getText().toString();
                M12_tmp_DETAIL_NAME     = R06_M12_DETAIL_NAME    .getText().toString();
                M12_tmp_DETAIL_QTY      = R06_M12_DETAIL_QTY     .getText().toString();
                M12_tmp_DETAIL_UT_PRICE = R06_M12_DETAIL_UT_PRICE.getText().toString();
                M12_tmp_DETAIL_PRICE    = R06_M12_DETAIL_PRICE   .getText().toString();
            }

            saveData4("Save");//saveQT4(M12_pos);
            //showButton_QT4();

            //20151228
            btnAdd4.setVisibility(View.VISIBLE);//放棄存檔 要回復 

            if (M12_pos.equals("1")){
                setEditTextReadOnly(R01_M12_QT_TYPE         ,true);
                setEditTextReadOnly(R01_M12_QT_NO           ,true);
                setEditTextReadOnly(R01_M12_QT_SEQ          ,true);
                setEditTextReadOnly(R01_M12_SEQ             ,true);
                setEditTextReadOnly(R01_M12_DETAIL_CLASS    ,true);
                setEditTextReadOnly(R01_M12_DETAIL_PARTNO   ,true);
                setEditTextReadOnly(R01_M12_DETAIL_NAME     ,true);
                setEditTextReadOnly(R01_M12_DETAIL_QTY      ,true);
                setEditTextReadOnly(R01_M12_DETAIL_UT_PRICE ,true);
                setEditTextReadOnly(R01_M12_DETAIL_PRICE    ,true);
            }
            if (M12_pos.equals("2")){
                setEditTextReadOnly(R02_M12_QT_TYPE         ,true);
                setEditTextReadOnly(R02_M12_QT_NO           ,true);
                setEditTextReadOnly(R02_M12_QT_SEQ          ,true);
                setEditTextReadOnly(R02_M12_SEQ             ,true);
                setEditTextReadOnly(R02_M12_DETAIL_CLASS    ,true);
                setEditTextReadOnly(R02_M12_DETAIL_PARTNO   ,true);
                setEditTextReadOnly(R02_M12_DETAIL_NAME     ,true);
                setEditTextReadOnly(R02_M12_DETAIL_QTY      ,true);
                setEditTextReadOnly(R02_M12_DETAIL_UT_PRICE ,true);
                setEditTextReadOnly(R02_M12_DETAIL_PRICE    ,true);
            }
            if (M12_pos.equals("3")){
                setEditTextReadOnly(R03_M12_QT_TYPE         ,true);
                setEditTextReadOnly(R03_M12_QT_NO           ,true);
                setEditTextReadOnly(R03_M12_QT_SEQ          ,true);
                setEditTextReadOnly(R03_M12_SEQ             ,true);
                setEditTextReadOnly(R03_M12_DETAIL_CLASS    ,true);
                setEditTextReadOnly(R03_M12_DETAIL_PARTNO   ,true);
                setEditTextReadOnly(R03_M12_DETAIL_NAME     ,true);
                setEditTextReadOnly(R03_M12_DETAIL_QTY      ,true);
                setEditTextReadOnly(R03_M12_DETAIL_UT_PRICE ,true);
                setEditTextReadOnly(R03_M12_DETAIL_PRICE    ,true);
            }
            if (M12_pos.equals("4")){
                setEditTextReadOnly(R04_M12_QT_TYPE         ,true);
                setEditTextReadOnly(R04_M12_QT_NO           ,true);
                setEditTextReadOnly(R04_M12_QT_SEQ          ,true);
                setEditTextReadOnly(R04_M12_SEQ             ,true);
                setEditTextReadOnly(R04_M12_DETAIL_CLASS    ,true);
                setEditTextReadOnly(R04_M12_DETAIL_PARTNO   ,true);
                setEditTextReadOnly(R04_M12_DETAIL_NAME     ,true);
                setEditTextReadOnly(R04_M12_DETAIL_QTY      ,true);
                setEditTextReadOnly(R04_M12_DETAIL_UT_PRICE ,true);
                setEditTextReadOnly(R04_M12_DETAIL_PRICE    ,true);
            }
            if (M12_pos.equals("5")){
                setEditTextReadOnly(R05_M12_QT_TYPE         ,true);
                setEditTextReadOnly(R05_M12_QT_NO           ,true);
                setEditTextReadOnly(R05_M12_QT_SEQ          ,true);
                setEditTextReadOnly(R05_M12_SEQ             ,true);
                setEditTextReadOnly(R05_M12_DETAIL_CLASS    ,true);
                setEditTextReadOnly(R05_M12_DETAIL_PARTNO   ,true);
                setEditTextReadOnly(R05_M12_DETAIL_NAME     ,true);
                setEditTextReadOnly(R05_M12_DETAIL_QTY      ,true);
                setEditTextReadOnly(R05_M12_DETAIL_UT_PRICE ,true);
                setEditTextReadOnly(R05_M12_DETAIL_PRICE    ,true);
            }
            if (M12_pos.equals("6")){
                setEditTextReadOnly(R06_M12_QT_TYPE         ,true);
                setEditTextReadOnly(R06_M12_QT_NO           ,true);
                setEditTextReadOnly(R06_M12_QT_SEQ          ,true);
                setEditTextReadOnly(R06_M12_SEQ             ,true);
                setEditTextReadOnly(R06_M12_DETAIL_CLASS    ,true);
                setEditTextReadOnly(R06_M12_DETAIL_PARTNO   ,true);
                setEditTextReadOnly(R06_M12_DETAIL_NAME     ,true);
                setEditTextReadOnly(R06_M12_DETAIL_QTY      ,true);
                setEditTextReadOnly(R06_M12_DETAIL_UT_PRICE ,true);
                setEditTextReadOnly(R06_M12_DETAIL_PRICE    ,true);
            }



        }
        else if (M12_act.equals("C")){

            //20151228
            btnAdd4.setVisibility(View.VISIBLE);//放棄修改 要回復 

            showButton_QT4();

            if (M12_pos.equals("1")){
                setEditTextReadOnly(R01_M12_QT_TYPE         ,true);
                setEditTextReadOnly(R01_M12_QT_NO           ,true);
                setEditTextReadOnly(R01_M12_QT_SEQ          ,true);
                setEditTextReadOnly(R01_M12_SEQ             ,true);
                setEditTextReadOnly(R01_M12_DETAIL_CLASS    ,true);
                setEditTextReadOnly(R01_M12_DETAIL_PARTNO   ,true);
                setEditTextReadOnly(R01_M12_DETAIL_NAME     ,true);
                setEditTextReadOnly(R01_M12_DETAIL_QTY      ,true);
                setEditTextReadOnly(R01_M12_DETAIL_UT_PRICE ,true);
                setEditTextReadOnly(R01_M12_DETAIL_PRICE    ,true);
            }
            if (M12_pos.equals("2")){
                setEditTextReadOnly(R02_M12_QT_TYPE         ,true);
                setEditTextReadOnly(R02_M12_QT_NO           ,true);
                setEditTextReadOnly(R02_M12_QT_SEQ          ,true);
                setEditTextReadOnly(R02_M12_SEQ             ,true);
                setEditTextReadOnly(R02_M12_DETAIL_CLASS    ,true);
                setEditTextReadOnly(R02_M12_DETAIL_PARTNO   ,true);
                setEditTextReadOnly(R02_M12_DETAIL_NAME     ,true);
                setEditTextReadOnly(R02_M12_DETAIL_QTY      ,true);
                setEditTextReadOnly(R02_M12_DETAIL_UT_PRICE ,true);
                setEditTextReadOnly(R02_M12_DETAIL_PRICE    ,true);
            }
            if (M12_pos.equals("3")){
                setEditTextReadOnly(R03_M12_QT_TYPE         ,true);
                setEditTextReadOnly(R03_M12_QT_NO           ,true);
                setEditTextReadOnly(R03_M12_QT_SEQ          ,true);
                setEditTextReadOnly(R03_M12_SEQ             ,true);
                setEditTextReadOnly(R03_M12_DETAIL_CLASS    ,true);
                setEditTextReadOnly(R03_M12_DETAIL_PARTNO   ,true);
                setEditTextReadOnly(R03_M12_DETAIL_NAME     ,true);
                setEditTextReadOnly(R03_M12_DETAIL_QTY      ,true);
                setEditTextReadOnly(R03_M12_DETAIL_UT_PRICE ,true);
                setEditTextReadOnly(R03_M12_DETAIL_PRICE    ,true);
            }
            if (M12_pos.equals("4")){
                setEditTextReadOnly(R04_M12_QT_TYPE         ,true);
                setEditTextReadOnly(R04_M12_QT_NO           ,true);
                setEditTextReadOnly(R04_M12_QT_SEQ          ,true);
                setEditTextReadOnly(R04_M12_SEQ             ,true);
                setEditTextReadOnly(R04_M12_DETAIL_CLASS    ,true);
                setEditTextReadOnly(R04_M12_DETAIL_PARTNO   ,true);
                setEditTextReadOnly(R04_M12_DETAIL_NAME     ,true);
                setEditTextReadOnly(R04_M12_DETAIL_QTY      ,true);
                setEditTextReadOnly(R04_M12_DETAIL_UT_PRICE ,true);
                setEditTextReadOnly(R04_M12_DETAIL_PRICE    ,true);
            }
            if (M12_pos.equals("5")){
                setEditTextReadOnly(R05_M12_QT_TYPE         ,true);
                setEditTextReadOnly(R05_M12_QT_NO           ,true);
                setEditTextReadOnly(R05_M12_QT_SEQ          ,true);
                setEditTextReadOnly(R05_M12_SEQ             ,true);
                setEditTextReadOnly(R05_M12_DETAIL_CLASS    ,true);
                setEditTextReadOnly(R05_M12_DETAIL_PARTNO   ,true);
                setEditTextReadOnly(R05_M12_DETAIL_NAME     ,true);
                setEditTextReadOnly(R05_M12_DETAIL_QTY      ,true);
                setEditTextReadOnly(R05_M12_DETAIL_UT_PRICE ,true);
                setEditTextReadOnly(R05_M12_DETAIL_PRICE    ,true);
            }
            if (M12_pos.equals("6")){
                setEditTextReadOnly(R06_M12_QT_TYPE         ,true);
                setEditTextReadOnly(R06_M12_QT_NO           ,true);
                setEditTextReadOnly(R06_M12_QT_SEQ          ,true);
                setEditTextReadOnly(R06_M12_SEQ             ,true);
                setEditTextReadOnly(R06_M12_DETAIL_CLASS    ,true);
                setEditTextReadOnly(R06_M12_DETAIL_PARTNO   ,true);
                setEditTextReadOnly(R06_M12_DETAIL_NAME     ,true);
                setEditTextReadOnly(R06_M12_DETAIL_QTY      ,true);
                setEditTextReadOnly(R06_M12_DETAIL_UT_PRICE ,true);
                setEditTextReadOnly(R06_M12_DETAIL_PRICE    ,true);
            }

            queryData((String) getWebServiceUrl() + "queryQT4",
                    queryQT4(QT_TYPE, QT_NO),
                    new IDataReceiveListener() {
                        public void onReceiveData(Object obj) {
                            //20151214 : 暫時 remark
                            loadData4(obj);
                            b4.setTag(2);
                        }
                    });
        }

    }

    public void onClick_M11(View view) {

        Button btn;
        btn = (Button) view;

        //M11_pos = btn.getTag().toString();
        //M11_act = btn.getText().toString();

        String[] array = btn.getTag().toString().split("-");
        if (array.length==2) {
            M11_pos = array[0].toString();
            M11_act = array[1].toString();
        }

        M11_tmp_SEQ             = "";
        M11_tmp_QTY1            = "";
        M11_tmp_QTY2            = "";
        M11_tmp_UNIT            = "";
        M11_tmp_LIST_PRICE      = "";
        M11_tmp_SALE_PERCENT    = "";
        M11_tmp_UNIT_PRICE      = "";
        M11_tmp_TOTAL           = "";

        if (M11_act.equals("E")){

            //20151228
            btnAdd5.setVisibility(View.GONE);//«ö¤U­×§ï ­nÁôÂÃ 

            hideButton_QT5();

            if (M11_pos.equals("1")){ R01_M11_btnSave.setVisibility(RelativeLayout.VISIBLE); R01_M11_btnCancel.setVisibility(RelativeLayout.VISIBLE); }
            if (M11_pos.equals("2")){ R02_M11_btnSave.setVisibility(RelativeLayout.VISIBLE); R02_M11_btnCancel.setVisibility(RelativeLayout.VISIBLE); }
            if (M11_pos.equals("3")){ R03_M11_btnSave.setVisibility(RelativeLayout.VISIBLE); R03_M11_btnCancel.setVisibility(RelativeLayout.VISIBLE); }
            if (M11_pos.equals("4")){ R04_M11_btnSave.setVisibility(RelativeLayout.VISIBLE); R04_M11_btnCancel.setVisibility(RelativeLayout.VISIBLE); }
            if (M11_pos.equals("5")){ R05_M11_btnSave.setVisibility(RelativeLayout.VISIBLE); R05_M11_btnCancel.setVisibility(RelativeLayout.VISIBLE); }

            if (M11_pos.equals("1")){
                setEditTextReadOnly(R01_M11_QT_TYPE      ,false);
                setEditTextReadOnly(R01_M11_QT_NO        ,false);
                setEditTextReadOnly(R01_M11_QT_SEQ       ,false);
                setEditTextReadOnly(R01_M11_SEQ          ,false);
                setEditTextReadOnly(R01_M11_QTY1         ,false);
                setEditTextReadOnly(R01_M11_QTY2         ,false);
                setEditTextReadOnly(R01_M11_UNIT         ,false);
                setEditTextReadOnly(R01_M11_LIST_PRICE   ,false);
                setEditTextReadOnly(R01_M11_SALE_PERCENT ,false);
                setEditTextReadOnly(R01_M11_UNIT_PRICE, false);
              //setEditTextReadOnly(R01_M11_TOTAL, false);
			  //注意: TOTAL 為 readonly, 不開放輸入
            }
            if (M11_pos.equals("2")){
                setEditTextReadOnly(R02_M11_QT_TYPE      ,false);
                setEditTextReadOnly(R02_M11_QT_NO        ,false);
                setEditTextReadOnly(R02_M11_QT_SEQ       ,false);
                setEditTextReadOnly(R02_M11_SEQ          ,false);
                setEditTextReadOnly(R02_M11_QTY1         ,false);
                setEditTextReadOnly(R02_M11_QTY2         ,false);
                setEditTextReadOnly(R02_M11_UNIT         ,false);
                setEditTextReadOnly(R02_M11_LIST_PRICE   ,false);
                setEditTextReadOnly(R02_M11_SALE_PERCENT ,false);
                setEditTextReadOnly(R02_M11_UNIT_PRICE, false);
              //setEditTextReadOnly(R02_M11_TOTAL, false);
			  //注意: TOTAL 為 readonly, 不開放輸入
            }
            if (M11_pos.equals("3")){
                setEditTextReadOnly(R03_M11_QT_TYPE      ,false);
                setEditTextReadOnly(R03_M11_QT_NO        ,false);
                setEditTextReadOnly(R03_M11_QT_SEQ       ,false);
                setEditTextReadOnly(R03_M11_SEQ          ,false);
                setEditTextReadOnly(R03_M11_QTY1         ,false);
                setEditTextReadOnly(R03_M11_QTY2         ,false);
                setEditTextReadOnly(R03_M11_UNIT         ,false);
                setEditTextReadOnly(R03_M11_LIST_PRICE   ,false);
                setEditTextReadOnly(R03_M11_SALE_PERCENT ,false);
                setEditTextReadOnly(R03_M11_UNIT_PRICE, false);
                //setEditTextReadOnly(R03_M11_TOTAL, false);
				//注意: TOTAL 為 readonly, 不開放輸入
            }
            if (M11_pos.equals("4")){
                setEditTextReadOnly(R04_M11_QT_TYPE      ,false);
                setEditTextReadOnly(R04_M11_QT_NO        ,false);
                setEditTextReadOnly(R04_M11_QT_SEQ       ,false);
                setEditTextReadOnly(R04_M11_SEQ          ,false);
                setEditTextReadOnly(R04_M11_QTY1         ,false);
                setEditTextReadOnly(R04_M11_QTY2         ,false);
                setEditTextReadOnly(R04_M11_UNIT         ,false);
                setEditTextReadOnly(R04_M11_LIST_PRICE   ,false);
                setEditTextReadOnly(R04_M11_SALE_PERCENT ,false);
                setEditTextReadOnly(R04_M11_UNIT_PRICE, false);
                //setEditTextReadOnly(R04_M11_TOTAL, false);
				//注意: TOTAL 為 readonly, 不開放輸入
            }
            if (M11_pos.equals("5")){
                setEditTextReadOnly(R05_M11_QT_TYPE      ,false);
                setEditTextReadOnly(R05_M11_QT_NO        ,false);
                setEditTextReadOnly(R05_M11_QT_SEQ       ,false);
                setEditTextReadOnly(R05_M11_SEQ          ,false);
                setEditTextReadOnly(R05_M11_QTY1         ,false);
                setEditTextReadOnly(R05_M11_QTY2         ,false);
                setEditTextReadOnly(R05_M11_UNIT         ,false);
                setEditTextReadOnly(R05_M11_LIST_PRICE   ,false);
                setEditTextReadOnly(R05_M11_SALE_PERCENT ,false);
                setEditTextReadOnly(R05_M11_UNIT_PRICE   , false);
                //setEditTextReadOnly(R05_M11_TOTAL        , false);
				//注意: TOTAL 為 readonly, 不開放輸入
            }
            
            if (M11_pos.equals("1")) {
                R01_M11_QT_TYPE     .setBackgroundResource(R.drawable.edit_border);
                R01_M11_QT_NO       .setBackgroundResource(R.drawable.edit_border);
                R01_M11_QT_SEQ      .setBackgroundResource(R.drawable.edit_border);
                R01_M11_SEQ         .setBackgroundResource(R.drawable.edit_border);
                R01_M11_QTY1        .setBackgroundResource(R.drawable.edit_border);
                R01_M11_QTY2        .setBackgroundResource(R.drawable.edit_border);
                R01_M11_UNIT        .setBackgroundResource(R.drawable.edit_border);
                R01_M11_LIST_PRICE  .setBackgroundResource(R.drawable.edit_border);
                R01_M11_SALE_PERCENT.setBackgroundResource(R.drawable.edit_border);
                R01_M11_UNIT_PRICE  .setBackgroundResource(R.drawable.edit_border);
                //R01_M11_TOTAL       .setBackgroundResource(R.drawable.edit_border);
            }
            if (M11_pos.equals("2")) {
                R02_M11_QT_TYPE     .setBackgroundResource(R.drawable.edit_border);
                R02_M11_QT_NO       .setBackgroundResource(R.drawable.edit_border);
                R02_M11_QT_SEQ      .setBackgroundResource(R.drawable.edit_border);
                R02_M11_SEQ         .setBackgroundResource(R.drawable.edit_border);
                R02_M11_QTY1        .setBackgroundResource(R.drawable.edit_border);
                R02_M11_QTY2        .setBackgroundResource(R.drawable.edit_border);
                R02_M11_UNIT        .setBackgroundResource(R.drawable.edit_border);
                R02_M11_LIST_PRICE  .setBackgroundResource(R.drawable.edit_border);
                R02_M11_SALE_PERCENT.setBackgroundResource(R.drawable.edit_border);
                R02_M11_UNIT_PRICE  .setBackgroundResource(R.drawable.edit_border);
                //R02_M11_TOTAL       .setBackgroundResource(R.drawable.edit_border);
            }
            if (M11_pos.equals("3")) {
                R03_M11_QT_TYPE     .setBackgroundResource(R.drawable.edit_border);
                R03_M11_QT_NO       .setBackgroundResource(R.drawable.edit_border);
                R03_M11_QT_SEQ      .setBackgroundResource(R.drawable.edit_border);
                R03_M11_SEQ         .setBackgroundResource(R.drawable.edit_border);
                R03_M11_QTY1        .setBackgroundResource(R.drawable.edit_border);
                R03_M11_QTY2        .setBackgroundResource(R.drawable.edit_border);
                R03_M11_UNIT        .setBackgroundResource(R.drawable.edit_border);
                R03_M11_LIST_PRICE  .setBackgroundResource(R.drawable.edit_border);
                R03_M11_SALE_PERCENT.setBackgroundResource(R.drawable.edit_border);
                R03_M11_UNIT_PRICE  .setBackgroundResource(R.drawable.edit_border);
                //R03_M11_TOTAL       .setBackgroundResource(R.drawable.edit_border);
            }
            if (M11_pos.equals("4")) {
                R04_M11_QT_TYPE     .setBackgroundResource(R.drawable.edit_border);
                R04_M11_QT_NO       .setBackgroundResource(R.drawable.edit_border);
                R04_M11_QT_SEQ      .setBackgroundResource(R.drawable.edit_border);
                R04_M11_SEQ         .setBackgroundResource(R.drawable.edit_border);
                R04_M11_QTY1        .setBackgroundResource(R.drawable.edit_border);
                R04_M11_QTY2        .setBackgroundResource(R.drawable.edit_border);
                R04_M11_UNIT        .setBackgroundResource(R.drawable.edit_border);
                R04_M11_LIST_PRICE  .setBackgroundResource(R.drawable.edit_border);
                R04_M11_SALE_PERCENT.setBackgroundResource(R.drawable.edit_border);
                R04_M11_UNIT_PRICE  .setBackgroundResource(R.drawable.edit_border);
                //R04_M11_TOTAL       .setBackgroundResource(R.drawable.edit_border);
            }
            if (M11_pos.equals("5")) {
                R05_M11_QT_TYPE     .setBackgroundResource(R.drawable.edit_border);
                R05_M11_QT_NO       .setBackgroundResource(R.drawable.edit_border);
                R05_M11_QT_SEQ      .setBackgroundResource(R.drawable.edit_border);
                R05_M11_SEQ         .setBackgroundResource(R.drawable.edit_border);
                R05_M11_QTY1        .setBackgroundResource(R.drawable.edit_border);
                R05_M11_QTY2        .setBackgroundResource(R.drawable.edit_border);
                R05_M11_UNIT        .setBackgroundResource(R.drawable.edit_border);
                R05_M11_LIST_PRICE  .setBackgroundResource(R.drawable.edit_border);
                R05_M11_SALE_PERCENT.setBackgroundResource(R.drawable.edit_border);
                R05_M11_UNIT_PRICE  .setBackgroundResource(R.drawable.edit_border);
                //R05_M11_TOTAL       .setBackgroundResource(R.drawable.edit_border);
            }

        }
        else if (M11_act.equals("D")){

            showDialog("是否確定要刪除?",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int id){
                            //true;//do no
                            if (M11_pos.equals("1")){ M11_tmp_SEQ = R01_M11_SEQ.getText().toString();}
                            if (M11_pos.equals("2")){ M11_tmp_SEQ = R02_M11_SEQ.getText().toString();}
                            if (M11_pos.equals("3")){ M11_tmp_SEQ = R03_M11_SEQ.getText().toString();}
                            if (M11_pos.equals("4")){ M11_tmp_SEQ = R04_M11_SEQ.getText().toString();}
                            if (M11_pos.equals("5")){ M11_tmp_SEQ = R05_M11_SEQ.getText().toString();}

                            deleteData5("Delete");
                            showButton_QT5();

                        }

                    }
                    ,new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int id){
                            //false;//do no
                        }

                    });


        }
        else if (M11_act.equals("S")){

            if (M11_pos.equals("1")){
                M11_tmp_SEQ             = R01_M11_SEQ            .getText().toString();
                M11_tmp_QTY1            = R01_M11_QTY1           .getText().toString();
                M11_tmp_QTY2            = R01_M11_QTY2           .getText().toString();
                M11_tmp_UNIT            = R01_M11_UNIT           .getText().toString();
                M11_tmp_LIST_PRICE      = R01_M11_LIST_PRICE     .getText().toString();
                M11_tmp_SALE_PERCENT    = R01_M11_SALE_PERCENT   .getText().toString();
                M11_tmp_UNIT_PRICE      = R01_M11_UNIT_PRICE     .getText().toString();
                M11_tmp_TOTAL           = R01_M11_TOTAL          .getText().toString();
            }
            if (M11_pos.equals("2")){
                M11_tmp_SEQ             = R02_M11_SEQ            .getText().toString();
                M11_tmp_QTY1            = R02_M11_QTY1           .getText().toString();
                M11_tmp_QTY2            = R02_M11_QTY2           .getText().toString();
                M11_tmp_UNIT            = R02_M11_UNIT           .getText().toString();
                M11_tmp_LIST_PRICE      = R02_M11_LIST_PRICE     .getText().toString();
                M11_tmp_SALE_PERCENT    = R02_M11_SALE_PERCENT   .getText().toString();
                M11_tmp_UNIT_PRICE      = R02_M11_UNIT_PRICE     .getText().toString();
                M11_tmp_TOTAL           = R02_M11_TOTAL          .getText().toString();
            }
            if (M11_pos.equals("3")){
                M11_tmp_SEQ             = R03_M11_SEQ            .getText().toString();
                M11_tmp_QTY1            = R03_M11_QTY1           .getText().toString();
                M11_tmp_QTY2            = R03_M11_QTY2           .getText().toString();
                M11_tmp_UNIT            = R03_M11_UNIT           .getText().toString();
                M11_tmp_LIST_PRICE      = R03_M11_LIST_PRICE     .getText().toString();
                M11_tmp_SALE_PERCENT    = R03_M11_SALE_PERCENT   .getText().toString();
                M11_tmp_UNIT_PRICE      = R03_M11_UNIT_PRICE     .getText().toString();
                M11_tmp_TOTAL           = R03_M11_TOTAL          .getText().toString();
            }
            if (M11_pos.equals("4")){
                M11_tmp_SEQ             = R04_M11_SEQ            .getText().toString();
                M11_tmp_QTY1            = R04_M11_QTY1           .getText().toString();
                M11_tmp_QTY2            = R04_M11_QTY2           .getText().toString();
                M11_tmp_UNIT            = R04_M11_UNIT           .getText().toString();
                M11_tmp_LIST_PRICE      = R04_M11_LIST_PRICE     .getText().toString();
                M11_tmp_SALE_PERCENT    = R04_M11_SALE_PERCENT   .getText().toString();
                M11_tmp_UNIT_PRICE      = R04_M11_UNIT_PRICE     .getText().toString();
                M11_tmp_TOTAL           = R04_M11_TOTAL          .getText().toString();
            }
            if (M11_pos.equals("5")){
                M11_tmp_SEQ             = R05_M11_SEQ            .getText().toString();
                M11_tmp_QTY1            = R05_M11_QTY1           .getText().toString();
                M11_tmp_QTY2            = R05_M11_QTY2           .getText().toString();
                M11_tmp_UNIT            = R05_M11_UNIT           .getText().toString();
                M11_tmp_LIST_PRICE      = R05_M11_LIST_PRICE     .getText().toString();
                M11_tmp_SALE_PERCENT    = R05_M11_SALE_PERCENT   .getText().toString();
                M11_tmp_UNIT_PRICE      = R05_M11_UNIT_PRICE     .getText().toString();
                M11_tmp_TOTAL           = R05_M11_TOTAL          .getText().toString();
            }

            saveData5("Save");//saveQT5(M11_pos);
            //showButton_QT5();

            //20151228
            btnAdd5.setVisibility(View.VISIBLE);//©ñ±ó¦sÀÉ ­n¦^´_ 

            if (M11_pos.equals("1")){
                setEditTextReadOnly(R01_M11_QT_TYPE      ,true);
                setEditTextReadOnly(R01_M11_QT_NO        ,true);
                setEditTextReadOnly(R01_M11_QT_SEQ       ,true);
                setEditTextReadOnly(R01_M11_SEQ          ,true);
                setEditTextReadOnly(R01_M11_QTY1         ,true);
                setEditTextReadOnly(R01_M11_QTY2         ,true);
                setEditTextReadOnly(R01_M11_UNIT         ,true);
                setEditTextReadOnly(R01_M11_LIST_PRICE   ,true);
                setEditTextReadOnly(R01_M11_SALE_PERCENT ,true);
                setEditTextReadOnly(R01_M11_UNIT_PRICE   ,true);
                setEditTextReadOnly(R01_M11_TOTAL        ,true);
            }
            if (M11_pos.equals("2")){
                setEditTextReadOnly(R02_M11_QT_TYPE      ,true);
                setEditTextReadOnly(R02_M11_QT_NO        ,true);
                setEditTextReadOnly(R02_M11_QT_SEQ       ,true);
                setEditTextReadOnly(R02_M11_SEQ          ,true);
                setEditTextReadOnly(R02_M11_QTY1         ,true);
                setEditTextReadOnly(R02_M11_QTY2         ,true);
                setEditTextReadOnly(R02_M11_UNIT         ,true);
                setEditTextReadOnly(R02_M11_LIST_PRICE   ,true);
                setEditTextReadOnly(R02_M11_SALE_PERCENT ,true);
                setEditTextReadOnly(R02_M11_UNIT_PRICE   ,true);
                setEditTextReadOnly(R02_M11_TOTAL        ,true);
            }
            if (M11_pos.equals("3")){
                setEditTextReadOnly(R03_M11_QT_TYPE      ,true);
                setEditTextReadOnly(R03_M11_QT_NO        ,true);
                setEditTextReadOnly(R03_M11_QT_SEQ       ,true);
                setEditTextReadOnly(R03_M11_SEQ          ,true);
                setEditTextReadOnly(R03_M11_QTY1         ,true);
                setEditTextReadOnly(R03_M11_QTY2         ,true);
                setEditTextReadOnly(R03_M11_UNIT         ,true);
                setEditTextReadOnly(R03_M11_LIST_PRICE   ,true);
                setEditTextReadOnly(R03_M11_SALE_PERCENT ,true);
                setEditTextReadOnly(R03_M11_UNIT_PRICE   ,true);
                setEditTextReadOnly(R03_M11_TOTAL        ,true);
            }
            if (M11_pos.equals("4")){
                setEditTextReadOnly(R04_M11_QT_TYPE      ,true);
                setEditTextReadOnly(R04_M11_QT_NO        ,true);
                setEditTextReadOnly(R04_M11_QT_SEQ       ,true);
                setEditTextReadOnly(R04_M11_SEQ          ,true);
                setEditTextReadOnly(R04_M11_QTY1         ,true);
                setEditTextReadOnly(R04_M11_QTY2         ,true);
                setEditTextReadOnly(R04_M11_UNIT         ,true);
                setEditTextReadOnly(R04_M11_LIST_PRICE   ,true);
                setEditTextReadOnly(R04_M11_SALE_PERCENT ,true);
                setEditTextReadOnly(R04_M11_UNIT_PRICE   ,true);
                setEditTextReadOnly(R04_M11_TOTAL        ,true);
            }
            if (M11_pos.equals("5")){
                setEditTextReadOnly(R05_M11_QT_TYPE      ,true);
                setEditTextReadOnly(R05_M11_QT_NO        ,true);
                setEditTextReadOnly(R05_M11_QT_SEQ       ,true);
                setEditTextReadOnly(R05_M11_SEQ          ,true);
                setEditTextReadOnly(R05_M11_QTY1         ,true);
                setEditTextReadOnly(R05_M11_QTY2         ,true);
                setEditTextReadOnly(R05_M11_UNIT         ,true);
                setEditTextReadOnly(R05_M11_LIST_PRICE   ,true);
                setEditTextReadOnly(R05_M11_SALE_PERCENT ,true);
                setEditTextReadOnly(R05_M11_UNIT_PRICE   ,true);
                setEditTextReadOnly(R05_M11_TOTAL        ,true);
            }

        }
        else if (M11_act.equals("C")){
            //20151228
            btnAdd5.setVisibility(View.VISIBLE);//©ñ±ó¦sÀÉ ­n¦^´_ 

            showButton_QT5();

            if (M11_pos.equals("1")){
                setEditTextReadOnly(R01_M11_QT_TYPE      ,true);
                setEditTextReadOnly(R01_M11_QT_NO        ,true);
                setEditTextReadOnly(R01_M11_QT_SEQ       ,true);
                setEditTextReadOnly(R01_M11_SEQ          ,true);
                setEditTextReadOnly(R01_M11_QTY1         ,true);
                setEditTextReadOnly(R01_M11_QTY2         ,true);
                setEditTextReadOnly(R01_M11_UNIT         ,true);
                setEditTextReadOnly(R01_M11_LIST_PRICE   ,true);
                setEditTextReadOnly(R01_M11_SALE_PERCENT ,true);
                setEditTextReadOnly(R01_M11_UNIT_PRICE   ,true);
                setEditTextReadOnly(R01_M11_TOTAL        ,true);
            }
            if (M11_pos.equals("2")){
                setEditTextReadOnly(R02_M11_QT_TYPE      ,true);
                setEditTextReadOnly(R02_M11_QT_NO        ,true);
                setEditTextReadOnly(R02_M11_QT_SEQ       ,true);
                setEditTextReadOnly(R02_M11_SEQ          ,true);
                setEditTextReadOnly(R02_M11_QTY1         ,true);
                setEditTextReadOnly(R02_M11_QTY2         ,true);
                setEditTextReadOnly(R02_M11_UNIT         ,true);
                setEditTextReadOnly(R02_M11_LIST_PRICE   ,true);
                setEditTextReadOnly(R02_M11_SALE_PERCENT ,true);
                setEditTextReadOnly(R02_M11_UNIT_PRICE   ,true);
                setEditTextReadOnly(R02_M11_TOTAL        ,true);
            }
            if (M11_pos.equals("3")){
                setEditTextReadOnly(R03_M11_QT_TYPE      ,true);
                setEditTextReadOnly(R03_M11_QT_NO        ,true);
                setEditTextReadOnly(R03_M11_QT_SEQ       ,true);
                setEditTextReadOnly(R03_M11_SEQ          ,true);
                setEditTextReadOnly(R03_M11_QTY1         ,true);
                setEditTextReadOnly(R03_M11_QTY2         ,true);
                setEditTextReadOnly(R03_M11_UNIT         ,true);
                setEditTextReadOnly(R03_M11_LIST_PRICE   ,true);
                setEditTextReadOnly(R03_M11_SALE_PERCENT ,true);
                setEditTextReadOnly(R03_M11_UNIT_PRICE   ,true);
                setEditTextReadOnly(R03_M11_TOTAL        ,true);
            }
            if (M11_pos.equals("4")){
                setEditTextReadOnly(R04_M11_QT_TYPE      ,true);
                setEditTextReadOnly(R04_M11_QT_NO        ,true);
                setEditTextReadOnly(R04_M11_QT_SEQ       ,true);
                setEditTextReadOnly(R04_M11_SEQ          ,true);
                setEditTextReadOnly(R04_M11_QTY1         ,true);
                setEditTextReadOnly(R04_M11_QTY2         ,true);
                setEditTextReadOnly(R04_M11_UNIT         ,true);
                setEditTextReadOnly(R04_M11_LIST_PRICE   ,true);
                setEditTextReadOnly(R04_M11_SALE_PERCENT ,true);
                setEditTextReadOnly(R04_M11_UNIT_PRICE   ,true);
                setEditTextReadOnly(R04_M11_TOTAL        ,true);
            }
            if (M11_pos.equals("5")){
                setEditTextReadOnly(R05_M11_QT_TYPE      ,true);
                setEditTextReadOnly(R05_M11_QT_NO        ,true);
                setEditTextReadOnly(R05_M11_QT_SEQ       ,true);
                setEditTextReadOnly(R05_M11_SEQ          ,true);
                setEditTextReadOnly(R05_M11_QTY1         ,true);
                setEditTextReadOnly(R05_M11_QTY2         ,true);
                setEditTextReadOnly(R05_M11_UNIT         ,true);
                setEditTextReadOnly(R05_M11_LIST_PRICE   ,true);
                setEditTextReadOnly(R05_M11_SALE_PERCENT ,true);
                setEditTextReadOnly(R05_M11_UNIT_PRICE   ,true);
                setEditTextReadOnly(R05_M11_TOTAL        ,true);
            }

            queryData((String) getWebServiceUrl() + "queryQT5",
                    queryQT5(QT_TYPE, QT_NO),
                    new IDataReceiveListener() {
                        public void onReceiveData(Object obj) {
                            //20151215 : 暫時 remark
                            loadData5(obj);
                            b5.setTag(2);
                        }
                    });

        }

    }

    public void hideRows_M12() {
		R01_M12_tr .setVisibility(RelativeLayout.GONE);
		R02_M12_tr .setVisibility(RelativeLayout.GONE);
		R03_M12_tr .setVisibility(RelativeLayout.GONE);
		R04_M12_tr .setVisibility(RelativeLayout.GONE);
		R05_M12_tr .setVisibility(RelativeLayout.GONE);
		R06_M12_tr .setVisibility(RelativeLayout.GONE);

        R99_M12_tr .setVisibility(RelativeLayout.GONE);
	}

	public void hideRows_M11() {
		R01_M11_tr .setVisibility(RelativeLayout.GONE);
		R02_M11_tr .setVisibility(RelativeLayout.GONE);
		R03_M11_tr .setVisibility(RelativeLayout.GONE);
		R04_M11_tr .setVisibility(RelativeLayout.GONE);
		R05_M11_tr .setVisibility(RelativeLayout.GONE);

        R99_M11_tr .setVisibility(RelativeLayout.GONE);

	}

    public void b4_onClick(View v) {

        //btnSave/btnChange 顯示時 QT4 不可切換
        if ((btnSave.getVisibility() == View.VISIBLE) ||
			(btnChange.getVisibility() == View.VISIBLE)) {
            return;
        }

            //20151211 : 改變顏色
        r3.setBackgroundColor(getResources().getColor(R.color.white));
        r4.setBackgroundColor(getResources().getColor(R.color.lightgreen));
        r5.setBackgroundColor(getResources().getColor(R.color.white));

        qttab2.setVisibility(RelativeLayout.VISIBLE);
        qttab3.setVisibility(RelativeLayout.GONE);

        int tag = (Integer) v.getTag();
        //20151221 改放 QT_SEQ vwSubTitle.setText(b4.getText());
        //if (tabbar != null)
        //	tabbar.setVisibility(RelativeLayout.GONE);
        if ((tab3 != null && tab3.getVisibility() == RelativeLayout.VISIBLE)
                || (tab5 != null && tab5.getVisibility() == RelativeLayout.VISIBLE))
        {

            tab3.setVisibility(RelativeLayout.GONE);
            tab5.setVisibility(RelativeLayout.GONE);

			btnEdit   .setVisibility(View.GONE);
			btnSave   .setVisibility(View.GONE);
			btnCancel .setVisibility(View.GONE);
			btnChange .setVisibility(View.GONE);
			btnConfirm.setVisibility(View.GONE);
			btnDelete .setVisibility(View.GONE);

			btnAdd4.setVisibility(View.GONE);
			btnAdd5.setVisibility(View.GONE);

			//20150115
			if (btnChange.getTag().equals("Y")) {
				//btnAdd4.setVisibility(View.VISIBLE);
			} else {
				btnAdd4.setVisibility(View.VISIBLE);
			}

            showButton_QT4();
        }

        //if (tab3 != null && tab3.getVisibility() == RelativeLayout.VISIBLE)
        //	tab3.setVisibility(RelativeLayout.GONE);
        //if (tab5 != null && tab5.getVisibility() == RelativeLayout.VISIBLE)
        //	tab5.setVisibility(RelativeLayout.GONE);
        //
        tab4.setVisibility(RelativeLayout.VISIBLE);

        //if (cmdbar != null && !cmdbar.isShown()) {
        //	cmdbar.setVisibility(RelativeLayout.VISIBLE);
        //}
        //if (tag != 2) {
        b4.setTag(2);

        queryData((String) getWebServiceUrl() + "queryQT4",
                queryQT4(QT_TYPE, QT_NO),
                new IDataReceiveListener() {
                    public void onReceiveData(Object obj) {
                        //20151214 : 暫時 remark
                        loadData4(obj);
                        b4.setTag(2);
                    }
                });

        //}

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










}
