//No.15041501 add xa59r and show animate after save,change,confirm  by cooper 15-04-15
//
//
package com.winway.wwapp2;

//import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
//import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
//import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
//import java.util.Date;
//import java.util.HashMap;
import java.util.List;
//import java.util.Map;

//import org.apache.http.HttpResponse;
//import org.apache.http.client.HttpClient;
//import org.apache.http.client.methods.HttpGet;
//import org.apache.http.client.methods.HttpPost;
//import org.apache.http.entity.StringEntity;
//import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.winway.camera.DisplayUtil;
import com.winway.wwapp2.BaseFragment.HttpGetAsyncTask;

import android.app.ActionBar;
//import android.annotation.SuppressLint;
//import android.app.ActionBar;
//import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
//import android.app.Dialog;
import android.app.Fragment;
//import android.app.FragmentManager;
import android.content.Context;
import android.content.DialogInterface;
//import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Point;
//import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
//import android.os.Build;
import android.os.Bundle;
//import android.os.Handler;
//import android.os.Message;
//import android.text.Html;
import android.text.InputType;
//import android.text.Spanned;
//import android.util.DisplayMetrics;
//import android.util.Log;
//import android.view.Gravity;
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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.widget.Toast;

/**
 * Screenshot_20150410_14.jpg apqp詳情頁 loadData => setLayoutUI => saveData1 =>
 * getInputData1 =>
 * 
 */
public class ApqpDataActivity extends BaseFragment {
	private Context context;
	private Bundle bundle;
	private View mView = null;
	private int ACTION_MESSAGE;
	private EditText xa003, xa066, xa067, xa517, CREATOR, xa560, xa59I;
	private CheckBox xa595, xa59G, xa59H;
	private EditText xa004, xa004text, xa594, xa005, xa502, xa006, xa007,
			xa008, xa503, xa009, xa010, xa012;
	private EditText xa057, xa551, xa553, xa058;
	private EditText xa053, xa054, xa055;
	private EditText xa095, xa00U, xa00Utext, xa00K, xa00L, xa59U, xa00R,
			xa00S;
	// Package info
	private CheckBox xa092, xa093, xa087, xa088, xa089, xa090, xa094, xa584,
			xa585, xa586;
	private EditText xa015, xa091, xa017, xa016, xa518, xa104, xa020, xa021,
			xa022, xa023, xa024, xa025, xa105, xa106, xa544, xa544text;
	private CheckBox xa028, xa029, xa048;
	private EditText xa046, xa047, xa031, xa130, xa111;
	private CheckBox xa033, xa034, xa598, xa599, xa59A, xa035, xa112, xa113,
			xa036Y, xa036N, xa116, xa117;
	private EditText xa114, xa115, xa59S, xa59T, xa107, xa108, xa109, xa110;
	// handler page
	private EditText xa037, xa038, xa039, xa040, xa042, xa59B, xa59C;
	private CheckBox xa073, xa074, xa075, xa076, xa077;
	// Socket Application Info...
	private CheckBox xa043, xa061, xa062, xa044, xa063, xa064, xa065, xa097,
			xa118, xa121, xa122, xa124, xa125, xa126, xa128, xa129, xa051a,
			xa051b, xa051c;
	private EditText xa102, xa119, xa120, xa123, xa050, xa127;
	// Duplication
	private CheckBox xa235, xa236, xa237, xa238, xa239, xa240, xa246, xa249;
	private CheckBox xa252, xa253, xa254, xa255, xa256, xa258, xa260;
	private CheckBox xa201, xa202, xa203, xa204, xa205, xa206, xa207, xa208,
			xa210;
	private CheckBox xa216, xa217, xa218, xa219, xa222, xa223, xa224, xa225,
			xa226, xa229, xa230, xa231, xa232, xa233;
	private CheckBox xa262, xa263, xa264, xa265, xa266, xa267, xa289;
	private CheckBox xa2a8, xa2a9, xa279, xa29v, xa29w, xa29x, xa29z, xa2a0,
			xa2a1, xa2a2, xa292, xa293, xa294, xa295, xa2a3, xa2a4, xa29y,
			xa29dY, xa29dN;
	private EditText xa296, xa2a5, xa2a6, xa59sa, xa59ta;
	private EditText xa241, xa242, xa243, xa244, xa245, xa247, xa248, xa250,
			xa251, xa257, xa259, xa261;
	private EditText xa209, xa29n, xa215;
	private EditText xa220, xa221, xa227, xa228, xa234, xa29k, xa29l, xa268;
	private EditText xa518a, xa2a7, xa020a, xa021a, xa022a, xa023a, xa024a,
			xa025a, xa019a, xa276, xa29p, xa280, xa29q, xa29r, xa29s, xa29t,
			xa277, xa278, xa282, xa29m, xa29u;
	// wclsp
	private CheckBox wlcsp_xa092, wlcsp_xa087, wlcsp_xa088, wlcsp_xa089,
			wlcsp_xa090, wlcsp_xa093;
	private EditText wlcsp_xa091, wlcsp_xa015;
	private EditText xa305, xa306, xa307, xa308, xa314, xa318;
	private CheckBox xa309, xa310, xa311, xa312, xa313, xa315, xa316, xa317;
	private CheckBox xa320, xa321, xa322, xa326, xa327, xa328, xa341, xa344,
			xa330, xa346, xa347, xa331, xa332, xa334, xa336Y, xa336N, xa348;
	private EditText xa337, xa338, xa319, xa339, xa323, xa324, xa325, xa340,
			xa342, xa343, xa329, xa345, xa333, xa335;
	// atc
	private CheckBox atc_xa092, atc_xa087, atc_xa088, atc_xa089, atc_xa090,
			atc_xa093;
	private EditText atc_xa091, atc_xa015, xa462, xa463, xa464, xa465;
	private CheckBox xa439, xa440, xa442;
	private EditText atc_xa518, atc_xa020, atc_xa021, atc_xa022, atc_xa023,
			atc_xa024, atc_xa025, atc_xa019, xa443;
	private EditText xa404, xa441, xa444, xa445, xa446, xa405, xa406, xa407,
			xa408, xa421, xa423, xa424, xa449, xa450;
	private CheckBox xa451, xa452, xa409, xa410, xa411, xa412, xa413, xa414,
			xa455, xa456, xa457, xa415, xa416, xa417, xa418, xa419, xa420,
			xa422;
	private CheckBox xa425, xa426, xa428, xa429, xa430Y, xa430N, xa431, xa433,
			xa435, xa437, xa447, xa448, xa458Y, xa458N, xa459Y, xa459N;
	private EditText xa427, xa432, xa434, xa436, xa438, xa466;
	private Button btnLoadPackageInfo17, btnLoadPackageInfo27;
	// FinePitch ProbeCard
	private CheckBox pb_xa092, xa601, pb_xa093, pb_xa087, pb_xa088, pb_xa090;
	private EditText xa602, pb_xa015, pb_xa091, pb_xa024, xa683;
	private CheckBox xa606, xa607, xa608, xa609, xa615, xa616, xa617, xa618,
			xa678, xa679, xa680, xa681, xa682;
	private EditText xa603, xa604, xa605, xa610, xa611, xa612, xa613, xa614,
			xa619, xa620, xa621, xa622, xa623;
	private CheckBox xa624, xa626, xa628, xa674Y, xa674N;
	private EditText xa625, xa627, xa629, xa630, xa673, xa631, xa632, xa633;
	private CheckBox xa634, xa635, xa636, xa637, xa638, xa645, xa646, xa647,
			xa648, xa639, xa640, xa641, xa642, xa643, xa644, xa666, xa677,
			xa652, xa651, xa653, xa667, xa668, xa669, xa670, xa671, xa672,
			xa663, xa664, xa655, xa654, xa658;
	private EditText xa675, xa676, xa649, xa650, xa656, xa657, xa659;
	private CheckBox xa660, xa661, xa662, xa665Y, xa665N, xa00t1, xa00t2;
	// Changeover kit
	private CheckBox ck_xa092, ck_xa093, ck_xa087, ck_xa088, ck_xa090, xa701,
			xa702, xa703, xa704, xa705, xa706Y, xa706N, xa707Y, xa707N, xa712,
			xa713, xa714, xa715, xa716;
	private EditText ck_xa015, xa717, xa718, xa719, xa708, xa709, xa710, xa711,
			ck_xa091, ck_xa518, ck_xa020, ck_xa021, ck_xa022, ck_xa023,
			ck_xa024, ck_xa025, ck_xa019, xa722, xa723, xa724, xa725, xa726,xa727,xa728,xa729,xa730;
	// EFlux
	private CheckBox ef_xa092, ef_xa093, ef_xa087, ef_xa088, xa825, xa826,
			xa828, xa829, xa831, xa830Y, xa830N, ef_xa089, ef_xa090, xa839,
			xa840, xa842, xa851, xa852, xa809, xa811, xa815, xa822, xa810,
			xa813, xa861, xa862;
	private EditText ef_xa015, ef_xa091, ef_xa518, ef_xa020, ef_xa021,
			ef_xa022, ef_xa023, ef_xa024, ef_xa025, xa841, xa843, xa804, xa844,
			xa845, xa846, xa805, xa806, xa807, xa808, xa824, xa849, xa850,
			xa853, xa827, xa832, xa856, xa857, xa858, xa859, xa860;
	private Button btnLoadPackageInfo1a, btnLoadPackageInfo2a, btn_fae,
			btn_sale;
	private TextView tabr_l1;
	private ImageView plugimage;
	//
	private EditText xa59v, xa00i, xa59w, xa59x, xa00a, xa00b, xa00c, xa00d,
			xa00e, xa00f, xa00g, xa00h, xa59z;

	private EditText xa59d, xa59e, xa59f, xa049, xa59r; // No.15041501
	private TableLayout qt, po, so;
	private int mYear, mMonth, mDay;
	private EditText mEdit;
	private String[] mRegion = new String[] { "Canada", "USA", "China",
			"Taiwan", "S. Asia", "Phil", "Korea", "Japan", "EU", "Israel" };
	// private static final int DATE_DIALOG_ID = 0;
	// private Button btnReturnSaleList;
	private String xa591, xa593;
	private Button btnLoadPackageInfo1, btnLoadPackageInfo2;
	private RelativeLayout tabbar, tabb, cmdbar;
	private LinearLayout tab1, tab2, tab3, tab4, tab5, tab6, tab7, tab8, tab9,
			taba, tabd;
	private Button b1, b2, b3, b4, b5, b6;
	private TextView l1, l2, l3, l4, l5, l6;
	private RelativeLayout r1, r2, r3, r4, r5, r6, commentbar;
	private Button btnEdit, btnSave, btnChange, btnConfirm, btnIssue;
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
	private List<String> mFAEUsers = new ArrayList<String>();
	private List<String> mFAEUsersValue = new ArrayList<String>();
	private List<String> mProductsCategory = new ArrayList<String>();
	private List<String> mContactElementType = new ArrayList<String>();
	private List<String> mTestingMethodology = new ArrayList<String>();
	//private String xa001, xa002;
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
		if (parent != null) {
			this.fragmentManager.beginTransaction().remove(this).commit();
			this.fragmentManager.beginTransaction().show(parent).commit();
			if (bundle != null && bundle.size() > 0
					&& bundle.getInt("frg_id") > 0) {
				hideActionbar();
			}
		}
	}

	/**
	 * Function G 取得Apqp的編號,方便辨識哪一筆資料上傳到webservice
	 * 
	 * @return
	 */
	private String getApqpNo() {

		String rs = (bundle != null && bundle.getString("apqpno") == null) ? ""
				: bundle.getString("apqpno");
		return rs;
	}

	private JSONObject getAPQP1(String xa001, String xa002) {

		try {
			JSONObject jsonObj = new JSONObject();
			JSONObject data = new JSONObject();
			data.accumulate("xa001", xa001);
			data.accumulate("xa002", xa002);
			jsonObj.accumulate("userid", super.getLoginUser());
			jsonObj.accumulate("WWID", "13145774WWGlobal999988apqp1999");
			jsonObj.accumulate("data", data);
			return jsonObj;
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;

	}

	private JSONObject getAPQP2(String xa001, String xa002) {

		try {
			JSONObject jsonObj = new JSONObject();
			JSONObject data = new JSONObject();
			data.accumulate("xa001", xa001);
			data.accumulate("xa002", xa002);
			jsonObj.accumulate("userid", super.getLoginUser());
			jsonObj.accumulate("WWID", "13145774WWGlobal999988apqp2999");
			jsonObj.accumulate("data", data);
			return jsonObj;
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;

	}

	private JSONObject getAPQP3(String xa001, String xa002) {

		try {
			JSONObject jsonObj = new JSONObject();
			JSONObject data = new JSONObject();
			data.accumulate("xa001", xa001);
			data.accumulate("xa002", xa002);
			jsonObj.accumulate("userid", super.getLoginUser());
			jsonObj.accumulate("WWID", "13145774WWGlobal999988apqp3999");
			jsonObj.accumulate("data", data);
			return jsonObj;
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;

	}

	/**
	 * 
	 * @param xa001
	 * @param xa002
	 * @return
	 */
	private JSONObject getAPQP4(String xa001, String xa002) {

		try {
			JSONObject jsonObj = new JSONObject();
			JSONObject data = new JSONObject();
			data.accumulate("xa001", xa001);
			data.accumulate("xa002", xa002);
			jsonObj.accumulate("userid", super.getLoginUser());
			jsonObj.accumulate("WWID", "13145774WWGlobal999988apqp4999");
			jsonObj.accumulate("data", data);
			return jsonObj;
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;

	}

	/**
	 * 
	 * @param xa001
	 * @param xa002
	 * @return
	 */
	private JSONObject getAPQP5(String xa001, String xa002) {

		try {
			JSONObject jsonObj = new JSONObject();
			JSONObject data = new JSONObject();
			data.accumulate("xa001", xa001);
			data.accumulate("xa002", xa002);
			jsonObj.accumulate("userid", super.getLoginUser());
			jsonObj.accumulate("WWID", "13145774WWGlobal999988apqp5999");
			jsonObj.accumulate("data", data);
			return jsonObj;
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;

	}

	private JSONObject getAPQP6(String xa001, String xa002) {

		try {
			JSONObject jsonObj = new JSONObject();
			JSONObject data = new JSONObject();
			data.accumulate("xa001", xa001);
			data.accumulate("xa002", xa002);
			jsonObj.accumulate("userid", super.getLoginUser());
			jsonObj.accumulate("WWID", "13145774WWGlobal999988apqp6999");
			jsonObj.accumulate("data", data);
			return jsonObj;
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;

	}

	private JSONObject getAPQP7(String xa001, String xa002) {

		try {
			JSONObject jsonObj = new JSONObject();
			JSONObject data = new JSONObject();
			data.accumulate("xa001", xa001);
			data.accumulate("xa002", xa002);
			jsonObj.accumulate("userid", super.getLoginUser());
			jsonObj.accumulate("WWID", "13145774WWGlobal999988apqp7999");
			jsonObj.accumulate("data", data);
			return jsonObj;
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;

	}

	private JSONObject getAPQP8(String xa001, String xa002) {

		try {
			JSONObject jsonObj = new JSONObject();
			JSONObject data = new JSONObject();
			data.accumulate("xa001", xa001);
			data.accumulate("xa002", xa002);
			jsonObj.accumulate("userid", super.getLoginUser());
			jsonObj.accumulate("WWID", "13145774WWGlobal999988apqp8999");
			jsonObj.accumulate("data", data);
			return jsonObj;
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;

	}

	private JSONObject getAPQP9(String xa001, String xa002) {

		try {
			JSONObject jsonObj = new JSONObject();
			JSONObject data = new JSONObject();
			data.accumulate("xa001", xa001);
			data.accumulate("xa002", xa002);
			jsonObj.accumulate("userid", super.getLoginUser());
			jsonObj.accumulate("WWID", "13145774WWGlobal999988apqp9999");
			jsonObj.accumulate("data", data);
			return jsonObj;
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;

	}

	private JSONObject getAPQPA(String xa001, String xa002) {

		try {
			JSONObject jsonObj = new JSONObject();
			JSONObject data = new JSONObject();
			data.accumulate("xa001", xa001);
			data.accumulate("xa002", xa002);
			jsonObj.accumulate("userid", super.getLoginUser());
			jsonObj.accumulate("WWID", "13145774WWGlobal999988apqpA999");
			jsonObj.accumulate("data", data);
			return jsonObj;
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;

	}

	private JSONObject getAPQPB(String xa001, String xa002) {

		try {
			JSONObject jsonObj = new JSONObject();
			JSONObject data = new JSONObject();
			data.accumulate("xa001", xa001);
			data.accumulate("xa002", xa002);
			jsonObj.accumulate("userid", super.getLoginUser());
			jsonObj.accumulate("WWID", "13145774WWGlobal999988apqpB999");
			jsonObj.accumulate("data", data);
			return jsonObj;
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;

	}

	private JSONObject getAPQPD(String xa001, String xa002) {

		try {
			JSONObject jsonObj = new JSONObject();
			JSONObject data = new JSONObject();
			data.accumulate("xa001", xa001);
			data.accumulate("xa002", xa002);

			jsonObj.accumulate("userid", super.getLoginUser());
			jsonObj.accumulate("WWID", "13145774WWGlobal999988apqpD999");
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
	 * get APQP =>TAB 1 =>Customer Infomations =>user input data
	 * 
	 * @param action
	 * @return
	 */
	private JSONObject getInputData1(final String action) {

		try {
			JSONObject data = new JSONObject();
			JSONObject apqp1 = new JSONObject();
			JSONObject jsonObj = new JSONObject();
			jsonObj.accumulate("userid", super.getLoginUser());
			jsonObj.accumulate("WWID", "13145774WWGlobal999988apqp1999");
			String[] apqpno = this.getApqpNo().split("-");
			if (apqpno.length <= 1)
				return data;
			final String xa001 = apqpno[0];
			final String xa002 = apqpno[1];
			data.accumulate("xa001", xa001);
			data.accumulate("xa002", xa002);
			data.accumulate("xa068", btnChange.getTag().toString());
			data.accumulate("xa591", xa591);
			data.accumulate("xa593", xa593);
			data.accumulate("CREATOR", CREATOR.getText());// Creator
			data.accumulate("xa003", xa003.getText());// IssueDate
			data.accumulate("xa004", xa004.getText()); // Cust NO
			data.accumulate("xa004text", xa004text.getText()); // Cust Name
			data.accumulate("xa005", xa005.getText()); // Contact
			data.accumulate("xa006", xa006.getText()); // Phone num
			data.accumulate("xa007", xa007.getText());// Phone num
			data.accumulate("xa008", xa008.getText()); // Mobile
			data.accumulate("xa009", xa009.getText()); // Fax
			data.accumulate("xa010", xa010.getText());// Email
			data.accumulate("xa012", xa012.getText());// Address
			data.accumulate("xa053", xa053.getText());// Sales Rep
			data.accumulate("xa054", xa054.getText());// Purchase Order
			data.accumulate("xa055", xa055.getText());// Date Received
			data.accumulate("xa057", xa057.getText());
			data.accumulate("xa058", xa058.getText());// project name
			data.accumulate("xa066", xa066.getText()); // ConfirmDate
			data.accumulate("xa067", xa067.getText()); // Confirm By
			data.accumulate("xa502", xa502.getText()); // Phone num
			data.accumulate("xa503", xa503.getText()); // Fax
			data.accumulate("xa517", xa517.getText()); // CS
			data.accumulate("xa551", xa551.getText());// end customer
			data.accumulate("xa552", xa553.getTag());
			data.accumulate("xa553", xa553.getText());// cust region
			data.accumulate("xa560", xa560.getText()); // Purpose
			// data.accumulate("xa592", xa592.getText());
			data.accumulate("xa594", xa594.getText()); // PID
			data.accumulate("xa595", xa595.isChecked() ? "Y" : "N");// rfq
			data.accumulate("xa59G", xa59G.isChecked() ? "Y" : "N");// 24h
			data.accumulate("xa59H", xa59H.isChecked() ? "Y" : "N");// eng
			data.accumulate("xa59I", xa59I.getText());
			// 20150918
			data.accumulate("xa00Utext", xa00Utext.getText());
			data.accumulate("xa00U", xa00U.getText());
			data.accumulate("xa00Ltext", xa00L.getText());
			data.accumulate("xa00L", xa00L.getTag());
			data.accumulate("xa00Ktext", xa00K.getText());
			data.accumulate("xa00K", xa00K.getTag());
			data.accumulate("xa59Utext", xa59U.getText());
			data.accumulate("xa59U", xa59U.getTag());
			data.accumulate("xa00Stext", xa00S.getText());
			data.accumulate("xa00S", xa00S.getTag());
			data.accumulate("xa00Rtext", xa00R.getText());
			data.accumulate("xa00R", xa00R.getTag());
			apqp1.accumulate("action", action);
			apqp1.accumulate("apqp1", data);
			jsonObj.accumulate("data", apqp1);
			return jsonObj;
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * get APQP =>TAB 2 =>Package Information =>user input data
	 * 
	 * @param action
	 * @return
	 */
	private JSONObject getInputData2(final String action) {

		try {
			JSONObject data = new JSONObject();
			JSONObject apqp2 = new JSONObject();
			JSONObject jsonObj = new JSONObject();
			jsonObj.accumulate("userid", super.getLoginUser());
			jsonObj.accumulate("WWID", "13145774WWGlobal999988apqp2999");
			String[] apqpno = this.getApqpNo().split("-");
			if (apqpno.length <= 1)
				return data;
			final String xa001 = apqpno[0];
			final String xa002 = apqpno[1];
			data.accumulate("xa001", xa001);
			data.accumulate("xa002", xa002);
			data.accumulate("xa591", xa591);
			data.accumulate("xa593", xa593);
			data.accumulate("xa068", btnChange.getTag().toString());
			data.accumulate("xa015", xa015.getText());
			data.accumulate("xa016", xa016.getText());
			data.accumulate("xa017", xa017.getText());
			data.accumulate("xa020", xa020.getText());
			data.accumulate("xa021", xa021.getText());
			data.accumulate("xa022", xa022.getText());
			data.accumulate("xa023", xa023.getText());
			data.accumulate("xa024", xa024.getText());
			data.accumulate("xa025", xa025.getText());
			data.accumulate("xa028", xa028.isChecked() ? "Y" : "N");
			data.accumulate("xa029", xa029.isChecked() ? "Y" : "N");
			data.accumulate("xa031", xa031.getText());
			data.accumulate("xa033", xa033.isChecked() ? "Y" : "N");
			data.accumulate("xa034", xa034.isChecked() ? "Y" : "N");
			data.accumulate("xa035", xa035.isChecked() ? "Y" : "N");
			if (xa036Y.isChecked()) {
				data.accumulate("xa036", "Y");
			} else if (xa036N.isChecked()) {
				data.accumulate("xa036", "N");
			} else {
				data.accumulate("xa036", "");
			}
			// edittext
			data.accumulate("xa046", xa046.getText());
			data.accumulate("xa047", xa047.getText());
			data.accumulate("xa048", xa048.isChecked() ? "Y" : "N");

			data.accumulate("xa087", xa087.isChecked() ? "Y" : "N");
			data.accumulate("xa088", xa088.isChecked() ? "Y" : "N");
			data.accumulate("xa089", xa089.isChecked() ? "Y" : "N");
			data.accumulate("xa090", xa090.isChecked() ? "Y" : "N");
			data.accumulate("xa091", xa091.getText());
			data.accumulate("xa092", xa092.isChecked() ? "Y" : "N");
			data.accumulate("xa093", xa093.isChecked() ? "Y" : "N");
			data.accumulate("xa094", xa094.isChecked() ? "Y" : "N");
			data.accumulate("xa104", xa104.getTag());
			data.accumulate("xa104text", xa104.getText());
			data.accumulate("xa105", xa105.getText());
			data.accumulate("xa106", xa106.getText());
			data.accumulate("xa107", xa107.getTag());
			data.accumulate("xa107text", xa107.getText());
			data.accumulate("xa108", xa108.getTag());
			data.accumulate("xa108text", xa108.getText());
			data.accumulate("xa109", xa109.getTag());
			data.accumulate("xa109text", xa109.getText());
			data.accumulate("xa110", xa110.getTag());
			data.accumulate("xa110text", xa110.getText());
			data.accumulate("xa111", xa111.getText());
			data.accumulate("xa112", xa112.isChecked() ? "Y" : "N");
			data.accumulate("xa113", xa113.isChecked() ? "Y" : "N");
			data.accumulate("xa114", xa114.getText());
			data.accumulate("xa115", xa115.getText());
			data.accumulate("xa116", xa116.isChecked() ? "Y" : "N");
			data.accumulate("xa117", xa117.isChecked() ? "Y" : "N");
			data.accumulate("xa130", xa130.getText());
			data.accumulate("xa518", xa518.getText());
			data.accumulate("xa544", xa544.getTag());
			data.accumulate("xa544text", xa544.getText());
			data.accumulate("xa584", xa584.isChecked() ? "Y" : "N");
			data.accumulate("xa585", xa585.isChecked() ? "Y" : "N");
			data.accumulate("xa586", xa586.isChecked() ? "Y" : "N");
			data.accumulate("xa598", xa598.isChecked() ? "Y" : "N");
			data.accumulate("xa599", xa599.isChecked() ? "Y" : "N");
			data.accumulate("xa59A", xa59A.isChecked() ? "Y" : "N");
			data.accumulate("xa59s", xa59S.getTag());
			data.accumulate("xa59stext", xa59S.getText());
			data.accumulate("xa59t", xa59T.getText());

			apqp2.accumulate("action", action);
			apqp2.accumulate("apqp2", data);
			jsonObj.accumulate("data", apqp2);
			return jsonObj;
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * get APQP =>TAB 3 =>Hander(Apqp Type 1) =>user input data
	 * 
	 * @param action
	 * @return
	 */
	private JSONObject getInputData3(final String action) {

		try {
			JSONObject data = new JSONObject();
			JSONObject apqp3 = new JSONObject();
			JSONObject jsonObj = new JSONObject();
			jsonObj.accumulate("userid", super.getLoginUser());
			jsonObj.accumulate("WWID", "13145774WWGlobal999988apqp3999");
			String[] apqpno = this.getApqpNo().split("-");
			if (apqpno.length <= 1)
				return data;
			final String xa001 = apqpno[0];
			final String xa002 = apqpno[1];
			data.accumulate("xa001", xa001);
			data.accumulate("xa002", xa002);
			data.accumulate("xa068", btnChange.getTag().toString());
			data.accumulate("xa591", xa591);
			data.accumulate("xa593", xa593);
			data.accumulate("xa037", xa037.getTag());
			data.accumulate("xa037text", xa037.getText());
			data.accumulate("xa038", xa038.getTag());
			data.accumulate("xa038text", xa038.getText());
			data.accumulate("xa039", xa039.getTag());
			data.accumulate("xa039text", xa039.getText());
			data.accumulate("xa040", xa040.getTag());
			data.accumulate("xa040text", xa040.getText());
			data.accumulate("xa042", xa042.getText());
			data.accumulate("xa073", xa073.isChecked() ? "Y" : "N");
			data.accumulate("xa074", xa074.isChecked() ? "Y" : "N");
			data.accumulate("xa075", xa075.isChecked() ? "Y" : "N");
			data.accumulate("xa076", xa076.isChecked() ? "Y" : "N");
			data.accumulate("xa077", xa077.isChecked() ? "Y" : "N");
			data.accumulate("xa59B", xa59B.getText());
			data.accumulate("xa59C", xa59C.getText());

			apqp3.accumulate("action", action);
			apqp3.accumulate("apqp3", data);
			jsonObj.accumulate("data", apqp3);

			return jsonObj;
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * get APQP =>TAB 4 =>Socket Application Information =>user input data
	 * 
	 * @param action
	 * @return
	 */
	private JSONObject getInputData4(final String action) {

		try {
			JSONObject data = new JSONObject();
			JSONObject apqp4 = new JSONObject();
			JSONObject jsonObj = new JSONObject();
			jsonObj.accumulate("userid", super.getLoginUser());
			jsonObj.accumulate("WWID", "13145774WWGlobal999988apqp4999");
			String[] apqpno = this.getApqpNo().split("-");
			if (apqpno.length <= 1)
				return data;
			final String xa001 = apqpno[0];
			final String xa002 = apqpno[1];
			data.accumulate("xa001", xa001);
			data.accumulate("xa002", xa002);
			data.accumulate("xa068", btnChange.getTag().toString());
			data.accumulate("xa591", xa591);
			data.accumulate("xa593", xa593);
			data.accumulate("xa043", xa043.isChecked() ? "Y" : "N");
			data.accumulate("xa044", xa044.isChecked() ? "Y" : "N");
			data.accumulate("xa050", xa050.getText());
			if (xa051a.isChecked())
				data.accumulate("xa051", "1");
			else if (xa051b.isChecked())
				data.accumulate("xa051", "2");
			else if (xa051c.isChecked())
				data.accumulate("xa051", "3");
			else
				data.accumulate("xa051", "");
			data.accumulate("xa061", xa061.isChecked() ? "Y" : "N");
			data.accumulate("xa062", xa062.isChecked() ? "Y" : "N");
			data.accumulate("xa063", xa063.isChecked() ? "Y" : "N");
			data.accumulate("xa064", xa064.isChecked() ? "Y" : "N");
			data.accumulate("xa065", xa065.isChecked() ? "Y" : "N");
			data.accumulate("xa097", xa097.isChecked() ? "Y" : "N");
			data.accumulate("xa102", xa102.getText());
			data.accumulate("xa118", xa118.isChecked() ? "Y" : "N");
			data.accumulate("xa119", xa119.getText());
			data.accumulate("xa120", xa120.getText());
			data.accumulate("xa121", xa121.isChecked() ? "Y" : "N");
			data.accumulate("xa122", xa122.isChecked() ? "Y" : "N");
			data.accumulate("xa123", xa123.getText());
			data.accumulate("xa124", xa124.isChecked() ? "Y" : "N");
			data.accumulate("xa126", xa126.isChecked() ? "Y" : "N");
			data.accumulate("xa127", xa127.getText());
			data.accumulate("xa128", xa128.isChecked() ? "Y" : "N");
			data.accumulate("xa043", xa129.isChecked() ? "Y" : "N");
			apqp4.accumulate("action", action);
			apqp4.accumulate("apqp4", data);
			jsonObj.accumulate("data", apqp4);
			return jsonObj;
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * get APQP =>TAB 5 => Duplicationt(Apqp Type 2) =>user input data
	 * (Screenshot_20150410_17.jpg)
	 * 
	 * @param action
	 * @return
	 */
	private JSONObject getInputData5(final String action) {

		try {
			JSONObject data = new JSONObject();
			JSONObject apqp5 = new JSONObject();
			JSONObject jsonObj = new JSONObject();
			jsonObj.accumulate("userid", super.getLoginUser());
			jsonObj.accumulate("WWID", "13145774WWGlobal999988apqp5999");
			String[] apqpno = this.getApqpNo().split("-");
			if (apqpno.length <= 1)
				return data;
			final String xa001 = apqpno[0];
			final String xa002 = apqpno[1];
			data.accumulate("xa001", xa001);
			data.accumulate("xa002", xa002);
			data.accumulate("xa068", btnChange.getTag().toString());
			data.accumulate("xa591", xa591);
			data.accumulate("xa593", xa593);
			data.accumulate("xa018", xa518a.getTag());
			data.accumulate("xa020", xa020a.getText());
			data.accumulate("xa021", xa021a.getText());
			data.accumulate("xa022", xa022a.getText());
			data.accumulate("xa023", xa023a.getText());
			data.accumulate("xa024", xa024a.getText());
			data.accumulate("xa025", xa025a.getText());
			data.accumulate("xa201", xa201.isChecked() ? "Y" : "N");
			data.accumulate("xa202", xa202.isChecked() ? "Y" : "N");
			data.accumulate("xa203", xa203.isChecked() ? "Y" : "N");
			data.accumulate("xa204", xa204.isChecked() ? "Y" : "N");
			data.accumulate("xa205", xa205.isChecked() ? "Y" : "N");
			data.accumulate("xa206", xa206.isChecked() ? "Y" : "N");
			data.accumulate("xa207", xa207.isChecked() ? "Y" : "N");
			data.accumulate("xa208", xa208.isChecked() ? "Y" : "N");
			data.accumulate("xa209", xa209.getText());
			data.accumulate("xa210", xa210.isChecked() ? "Y" : "N");
			data.accumulate("xa215", xa215.getText());
			data.accumulate("xa216", xa216.isChecked() ? "Y" : "N");
			data.accumulate("xa217", xa217.isChecked() ? "Y" : "N");
			data.accumulate("xa218", xa218.isChecked() ? "Y" : "N");
			data.accumulate("xa219", xa219.isChecked() ? "Y" : "N");
			data.accumulate("xa220text", xa220.getText());
			data.accumulate("xa220", xa220.getTag());
			data.accumulate("xa221text", xa221.getText());
			data.accumulate("xa221", xa221.getTag());
			data.accumulate("xa222", xa222.isChecked() ? "Y" : "N");
			data.accumulate("xa223", xa223.isChecked() ? "Y" : "N");
			data.accumulate("xa224", xa224.isChecked() ? "Y" : "N");
			data.accumulate("xa225", xa225.isChecked() ? "Y" : "N");
			data.accumulate("xa226", xa226.isChecked() ? "Y" : "N");
			data.accumulate("xa227text", xa227.getText());
			data.accumulate("xa227", xa227.getTag());
			data.accumulate("xa228text", xa228.getText());
			data.accumulate("xa228", xa228.getTag());
			data.accumulate("xa229", xa229.isChecked() ? "Y" : "N");
			data.accumulate("xa230", xa230.isChecked() ? "Y" : "N");
			data.accumulate("xa231", xa231.isChecked() ? "Y" : "N");
			data.accumulate("xa232", xa232.isChecked() ? "Y" : "N");
			data.accumulate("xa233", xa233.isChecked() ? "Y" : "N");
			data.accumulate("xa234", xa234.getText());
			data.accumulate("xa235", xa235.isChecked() ? "Y" : "N");
			data.accumulate("xa236", xa236.isChecked() ? "Y" : "N");
			data.accumulate("xa237", xa237.isChecked() ? "Y" : "N");
			data.accumulate("xa238", xa238.isChecked() ? "Y" : "N");
			data.accumulate("xa239", xa239.isChecked() ? "Y" : "N");
			data.accumulate("xa240", xa240.isChecked() ? "Y" : "N");
			data.accumulate("xa241", xa241.getText());
			data.accumulate("xa242", xa242.getText());
			data.accumulate("xa243", xa243.getText());
			data.accumulate("xa244", xa244.getText());
			data.accumulate("xa245", xa245.getText());
			data.accumulate("xa246", xa246.isChecked() ? "Y" : "N");
			data.accumulate("xa247", xa247.getText());
			data.accumulate("xa248", xa248.getText());
			data.accumulate("xa249", xa249.isChecked() ? "Y" : "N");
			data.accumulate("xa250", xa250.getText());
			data.accumulate("xa251", xa251.getText());
			data.accumulate("xa252", xa252.isChecked() ? "Y" : "N");
			data.accumulate("xa253", xa253.isChecked() ? "Y" : "N");
			data.accumulate("xa254", xa254.isChecked() ? "Y" : "N");
			data.accumulate("xa255", xa255.isChecked() ? "Y" : "N");
			data.accumulate("xa256", xa256.isChecked() ? "Y" : "N");
			data.accumulate("xa257", xa257.getText());
			data.accumulate("xa258", xa258.isChecked() ? "Y" : "N");
			data.accumulate("xa259", xa259.getText());
			data.accumulate("xa260", xa260.isChecked() ? "Y" : "N");
			data.accumulate("xa261", xa261.getText());
			data.accumulate("xa262", xa262.isChecked() ? "Y" : "N");
			data.accumulate("xa263", xa263.isChecked() ? "Y" : "N");
			data.accumulate("xa264", xa264.isChecked() ? "Y" : "N");
			data.accumulate("xa265", xa265.isChecked() ? "Y" : "N");
			data.accumulate("xa266", xa266.isChecked() ? "Y" : "N");
			data.accumulate("xa267", xa267.isChecked() ? "Y" : "N");
			data.accumulate("xa268", xa268.getText());
			data.accumulate("xa276", xa276.getText());
			data.accumulate("xa277", xa277.getText());
			data.accumulate("xa278", xa278.getText());
			data.accumulate("xa279", xa279.isChecked() ? "Y" : "N");
			data.accumulate("xa280", xa280.getTag());
			data.accumulate("xa280text", xa280.getText());
			data.accumulate("xa282", xa282.getText());
			data.accumulate("xa289", xa289.isChecked() ? "Y" : "N");
			data.accumulate("xa292", xa292.isChecked() ? "Y" : "N");
			data.accumulate("xa293", xa293.isChecked() ? "Y" : "N");
			data.accumulate("xa294", xa294.isChecked() ? "Y" : "N");
			data.accumulate("xa295", xa295.isChecked() ? "Y" : "N");
			data.accumulate("xa296", xa296.getText());
			if (xa29dY.isChecked())
				data.accumulate("xa29d", "Y");
			else if (xa29dN.isChecked())
				data.accumulate("xa29d", "N");
			else
				data.accumulate("xa29d", "");
			data.accumulate("xa29k", xa29k.getText());
			data.accumulate("xa29l", xa29l.getText());
			data.accumulate("xa29m", xa29m.getText());
			data.accumulate("xa29n", xa29n.getText());
			data.accumulate("xa29p", xa29p.getText());
			data.accumulate("xa29qtext", xa29q.getText());
			data.accumulate("xa29q", xa29q.getTag());
			data.accumulate("xa29rtext", xa29r.getText());
			data.accumulate("xa29r", xa29r.getTag());
			data.accumulate("xa29stext", xa29s.getText());
			data.accumulate("xa29s", xa29s.getTag());
			data.accumulate("xa29ttext", xa29t.getText());
			data.accumulate("xa29t", xa29t.getTag());
			data.accumulate("xa29utext", xa29u.getText());
			data.accumulate("xa29u", xa29u.getTag());
			if (xa29v.isChecked())
				data.accumulate("xa29v", "Y");
			else
				data.accumulate("xa29v", "N");
			if (xa29w.isChecked())
				data.accumulate("xa29w", "Y");
			else
				data.accumulate("xa29w", "N");
			if (xa29x.isChecked())
				data.accumulate("xa29x", "Y");
			else
				data.accumulate("xa29x", "N");
			if (xa29y.isChecked())
				data.accumulate("xa29y", "Y");
			else
				data.accumulate("xa29y", "N");
			if (xa29z.isChecked())
				data.accumulate("xa29z", "Y");
			else
				data.accumulate("xa29z", "N");
			if (xa2a0.isChecked())
				data.accumulate("xa2a0", "Y");
			else
				data.accumulate("xa2a0", "N");
			if (xa2a1.isChecked())
				data.accumulate("xa2a1", "Y");
			else
				data.accumulate("xa2a1", "N");
			if (xa2a2.isChecked())
				data.accumulate("xa2a2", "Y");
			else
				data.accumulate("xa2a2", "N");
			if (xa2a3.isChecked())
				data.accumulate("xa2a3", "Y");
			else
				data.accumulate("xa2a3", "N");
			if (xa2a4.isChecked())
				data.accumulate("xa2a4", "Y");
			else
				data.accumulate("xa2a4", "N");
			data.accumulate("xa2a5", xa2a5.getText());
			data.accumulate("xa2a6", xa2a6.getText());
			data.accumulate("xa2a7text", xa2a7.getText());
			data.accumulate("xa2a7", xa2a7.getTag());
			if (xa2a8.isChecked())
				data.accumulate("xa2a8", "Y");
			else
				data.accumulate("xa2a8", "N");
			if (xa2a9.isChecked())
				data.accumulate("xa2a9", "Y");
			else
				data.accumulate("xa2a9", "N");
			data.accumulate("xa518", xa518a.getText());
			data.accumulate("xa59stext", xa59sa.getText());
			data.accumulate("xa59s", xa59sa.getTag());
			data.accumulate("xa59t", xa59ta.getText());
			apqp5.accumulate("action", action);
			apqp5.accumulate("apqp5", data);
			jsonObj.accumulate("data", apqp5);
			return jsonObj;
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * get APQP =>TAB 6 => WLCSP(Apqp Type 3) =>user input data
	 * 
	 * @param action
	 * @return
	 */
	private JSONObject getInputData6(final String action) {

		try {
			JSONObject data = new JSONObject();
			JSONObject apqp6 = new JSONObject();
			JSONObject jsonObj = new JSONObject();
			jsonObj.accumulate("userid", super.getLoginUser());
			jsonObj.accumulate("WWID", "13145774WWGlobal999988apqp6999");
			String[] apqpno = this.getApqpNo().split("-");
			if (apqpno.length <= 1)
				return data;
			final String xa001 = apqpno[0];
			final String xa002 = apqpno[1];
			data.accumulate("xa001", xa001);
			data.accumulate("xa002", xa002);
			data.accumulate("xa068", btnChange.getTag().toString());
			data.accumulate("xa591", xa591);
			data.accumulate("xa593", xa593);
			data.accumulate("xa015", wlcsp_xa015.getText());
			data.accumulate("xa018", "1077");
			data.accumulate("xa020", xa020.getText());
			data.accumulate("xa021", xa021.getText());
			data.accumulate("xa024", xa024.getText());
			data.accumulate("xa025", xa025.getText());
			if (wlcsp_xa087.isChecked())
				data.accumulate("xa087", "Y");
			else
				data.accumulate("xa087", "N");
			if (wlcsp_xa088.isChecked())
				data.accumulate("xa088", "Y");
			else
				data.accumulate("xa088", "N");
			if (wlcsp_xa089.isChecked())
				data.accumulate("xa089", "Y");
			else
				data.accumulate("xa089", "N");
			if (wlcsp_xa090.isChecked())
				data.accumulate("xa090", "Y");
			else
				data.accumulate("xa090", "N");
			data.accumulate("xa091", wlcsp_xa091.getText());
			if (wlcsp_xa092.isChecked())
				data.accumulate("xa092", "Y");
			else
				data.accumulate("xa092", "N");
			if (wlcsp_xa093.isChecked())
				data.accumulate("xa093", "Y");
			else
				data.accumulate("xa093", "N");
			data.accumulate("xa305", xa305.getText());
			data.accumulate("xa306", xa306.getText());
			data.accumulate("xa307", xa307.getText());
			data.accumulate("xa308", xa308.getText());
			if (xa309.isChecked())
				data.accumulate("xa309", "Y");
			else
				data.accumulate("xa309", "N");
			if (xa310.isChecked())
				data.accumulate("xa310", "Y");
			else
				data.accumulate("xa310", "N");
			if (xa311.isChecked())
				data.accumulate("xa311", "Y");
			else
				data.accumulate("xa311", "N");
			if (xa312.isChecked())
				data.accumulate("xa312", "Y");
			else
				data.accumulate("xa312", "N");
			if (xa313.isChecked())
				data.accumulate("xa313", "Y");
			else
				data.accumulate("xa313", "N");
			data.accumulate("xa314", xa314.getText());
			if (xa315.isChecked())
				data.accumulate("xa315", "Y");
			else
				data.accumulate("xa315", "N");
			if (xa316.isChecked())
				data.accumulate("xa316", "Y");
			else
				data.accumulate("xa316", "N");
			if (xa317.isChecked())
				data.accumulate("xa317", "Y");
			else
				data.accumulate("xa317", "N");
			data.accumulate("xa318", xa318.getText());
			data.accumulate("xa319", xa319.getText());
			if (xa320.isChecked())
				data.accumulate("xa320", "Y");
			else
				data.accumulate("xa320", "N");
			if (xa321.isChecked())
				data.accumulate("xa321", "Y");
			else
				data.accumulate("xa321", "N");
			if (xa322.isChecked())
				data.accumulate("xa322", "Y");
			else
				data.accumulate("xa322", "N");
			data.accumulate("xa323", xa323.getText());
			data.accumulate("xa323", xa323.getText());
			data.accumulate("xa324", xa324.getText());
			data.accumulate("xa325", xa325.getText());
			if (xa326.isChecked())
				data.accumulate("xa326", "Y");
			else
				data.accumulate("xa326", "N");
			if (xa327.isChecked())
				data.accumulate("xa327", "Y");
			else
				data.accumulate("xa327", "N");
			if (xa328.isChecked())
				data.accumulate("xa328", "Y");
			else
				data.accumulate("xa328", "N");
			data.accumulate("xa329", xa329.getText());
			if (xa330.isChecked())
				data.accumulate("xa330", "Y");
			else
				data.accumulate("xa330", "N");
			if (xa331.isChecked())
				data.accumulate("xa331", "Y");
			else
				data.accumulate("xa331", "N");
			if (xa332.isChecked())
				data.accumulate("xa332", "Y");
			else
				data.accumulate("xa332", "N");
			data.accumulate("xa333", xa333.getText());
			if (xa334.isChecked())
				data.accumulate("xa334", "Y");
			else
				data.accumulate("xa334", "N");
			data.accumulate("xa335", xa335.getText());
			if (xa336Y.isChecked())
				data.accumulate("xa336", "Y");
			else if (xa336N.isChecked())
				data.accumulate("xa336", "N");
			data.accumulate("xa337", xa337.getText());
			data.accumulate("xa338", xa338.getText());
			data.accumulate("xa339", xa339.getText());
			data.accumulate("xa340", xa340.getText());
			if (xa341.isChecked())
				data.accumulate("xa341", "Y");
			else
				data.accumulate("xa341", "N");
			data.accumulate("xa342", xa342.getText());
			data.accumulate("xa343", xa343.getText());
			if (xa344.isChecked())
				data.accumulate("xa344", "Y");
			else
				data.accumulate("xa344", "N");
			data.accumulate("xa345", xa345.getText());
			if (xa346.isChecked())
				data.accumulate("xa346", "Y");
			else
				data.accumulate("xa346", "N");
			if (xa347.isChecked())
				data.accumulate("xa347", "Y");
			else
				data.accumulate("xa347", "N");

			if (xa348.isChecked())
				data.accumulate("xa348", "Y");
			else
				data.accumulate("xa348", "N");
			apqp6.accumulate("action", action);
			apqp6.accumulate("apqp6", data);
			jsonObj.accumulate("data", apqp6);
			return jsonObj;
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * get APQP =>TAB 7 => ATC(Apqp Type 4) =>user input data
	 * 
	 * @param action
	 * @return
	 */
	private JSONObject getInputData7(final String action) {

		try {
			JSONObject data = new JSONObject();
			JSONObject apqp7 = new JSONObject();
			JSONObject jsonObj = new JSONObject();
			jsonObj.accumulate("userid", super.getLoginUser());
			jsonObj.accumulate("WWID", "13145774WWGlobal999988apqp7999");
			String[] apqpno = this.getApqpNo().split("-");
			if (apqpno.length <= 1)
				return data;
			final String xa001 = apqpno[0];
			final String xa002 = apqpno[1];
			data.accumulate("xa001", xa001);
			data.accumulate("xa002", xa002);
			data.accumulate("xa068", btnChange.getTag().toString());
			data.accumulate("xa591", xa591);
			data.accumulate("xa593", xa593);
			data.accumulate("xa015", atc_xa015.getText());
			data.accumulate("xa018", atc_xa518.getTag());
			data.accumulate("xa019", atc_xa019.getText());
			data.accumulate("xa020", atc_xa020.getText());
			data.accumulate("xa021", atc_xa021.getText());
			data.accumulate("xa022", atc_xa022.getText());
			data.accumulate("xa023", atc_xa023.getText());
			data.accumulate("xa024", atc_xa024.getText());
			data.accumulate("xa025", atc_xa025.getText());
			if (atc_xa087.isChecked())
				data.accumulate("xa087", "Y");
			else
				data.accumulate("xa087", "N");
			if (atc_xa088.isChecked())
				data.accumulate("xa088", "Y");
			else
				data.accumulate("xa088", "N");
			if (atc_xa089.isChecked())
				data.accumulate("xa089", "Y");
			else
				data.accumulate("xa089", "N");
			if (atc_xa090.isChecked())
				data.accumulate("xa090", "Y");
			else
				data.accumulate("xa090", "N");
			data.accumulate("xa091", atc_xa091.getText());
			if (atc_xa092.isChecked())
				data.accumulate("xa092", "Y");
			else
				data.accumulate("xa092", "N");
			if (atc_xa093.isChecked())
				data.accumulate("xa093", "Y");
			else
				data.accumulate("xa093", "N");
			data.accumulate("xa404", xa404.getText());
			data.accumulate("xa405", xa405.getText());
			data.accumulate("xa406", xa406.getText());
			data.accumulate("xa407", xa407.getText());
			data.accumulate("xa408", xa408.getText());
			if (xa409.isChecked())
				data.accumulate("xa409", "Y");
			else
				data.accumulate("xa409", "N");
			if (xa410.isChecked())
				data.accumulate("xa410", "Y");
			else
				data.accumulate("xa410", "N");
			if (xa411.isChecked())
				data.accumulate("xa411", "Y");
			else
				data.accumulate("xa411", "N");
			if (xa412.isChecked())
				data.accumulate("xa412", "Y");
			else
				data.accumulate("xa412", "N");
			if (xa413.isChecked())
				data.accumulate("xa413", "Y");
			else
				data.accumulate("xa413", "N");
			if (xa414.isChecked())
				data.accumulate("xa414", "Y");
			else
				data.accumulate("xa414", "N");
			if (xa415.isChecked())
				data.accumulate("xa415", "Y");
			else
				data.accumulate("xa415", "N");
			if (xa416.isChecked())
				data.accumulate("xa416", "Y");
			else
				data.accumulate("xa416", "N");
			if (xa417.isChecked())
				data.accumulate("xa417", "Y");
			else
				data.accumulate("xa417", "N");
			if (xa418.isChecked())
				data.accumulate("xa418", "Y");
			else
				data.accumulate("xa418", "N");
			if (xa419.isChecked())
				data.accumulate("xa419", "Y");
			else
				data.accumulate("xa419", "N");
			if (xa420.isChecked())
				data.accumulate("xa420", "Y");
			else
				data.accumulate("xa420", "N");
			data.accumulate("xa421", xa421.getText());
			if (xa422.isChecked())
				data.accumulate("xa422", "Y");
			else
				data.accumulate("xa422", "N");
			data.accumulate("xa423", xa423.getText());
			data.accumulate("xa424", xa424.getText());
			if (xa425.isChecked())
				data.accumulate("xa425", "Y");
			else
				data.accumulate("xa425", "N");
			if (xa426.isChecked())
				data.accumulate("xa426", "Y");
			else
				data.accumulate("xa426", "N");
			data.accumulate("xa427", xa427.getText());
			if (xa428.isChecked())
				data.accumulate("xa428", "Y");
			else
				data.accumulate("xa428", "N");
			if (xa429.isChecked())
				data.accumulate("xa429", "Y");
			else
				data.accumulate("xa429", "N");
			if (xa430Y.isChecked()) {
				data.accumulate("xa430", "Y");
			} else if (xa430N.isChecked()) {
				data.accumulate("xa430", "Y");
			} else {
				data.accumulate("xa430", "");
			}
			if (xa431.isChecked())
				data.accumulate("xa431", "Y");
			else
				data.accumulate("xa431", "N");
			data.accumulate("xa432", xa432.getText());
			if (xa433.isChecked())
				data.accumulate("xa433", "Y");
			else
				data.accumulate("xa433", "N");
			data.accumulate("xa434", xa434.getText());
			if (xa435.isChecked())
				data.accumulate("xa435", "Y");
			else
				data.accumulate("xa435", "N");
			data.accumulate("xa436", xa436.getText());
			if (xa437.isChecked())
				data.accumulate("xa437", "Y");
			else
				data.accumulate("xa437", "N");
			data.accumulate("xa438", xa438.getText());
			if (xa439.isChecked())
				data.accumulate("xa439", "Y");
			else
				data.accumulate("xa439", "N");
			if (xa440.isChecked())
				data.accumulate("xa440", "Y");
			else
				data.accumulate("xa440", "N");
			data.accumulate("xa441", xa441.getText());
			if (xa442.isChecked())
				data.accumulate("xa442", "Y");
			else
				data.accumulate("xa442", "N");
			data.accumulate("xa443", xa443.getText());
			data.accumulate("xa444", xa444.getText());
			data.accumulate("xa445", xa445.getText());
			data.accumulate("xa446", xa446.getText());
			if (xa447.isChecked())
				data.accumulate("xa447", "Y");
			else
				data.accumulate("xa447", "N");
			if (xa448.isChecked())
				data.accumulate("xa448", "Y");
			else
				data.accumulate("xa448", "N");
			data.accumulate("xa449", xa449.getText());
			data.accumulate("xa450", xa450.getText());
			if (xa451.isChecked())
				data.accumulate("xa451", "Y");
			else
				data.accumulate("xa451", "N");
			if (xa452.isChecked())
				data.accumulate("xa452", "Y");
			else
				data.accumulate("xa452", "N");

			if (xa459Y.isChecked())
				data.accumulate("xa459", "Y");

			if (xa459N.isChecked())
				data.accumulate("xa459", "N");
			data.accumulate("xa462", xa462.getText());
			data.accumulate("xa463", xa463.getText());
			data.accumulate("xa464", xa464.getText());
			data.accumulate("xa465", xa465.getText());
			data.accumulate("xa466", xa466.getText());
			/*
			 * 停用 if (xa453.isChecked()) data.accumulate("xa453", "Y"); else
			 * data.accumulate("xa453", "N"); if (xa454.isChecked())
			 * data.accumulate("xa454", "Y"); else data.accumulate("xa454",
			 * "N");
			 */
			if (xa455.isChecked())
				data.accumulate("xa455", "Y");
			else
				data.accumulate("xa455", "N");
			if (xa456.isChecked())
				data.accumulate("xa456", "Y");
			else
				data.accumulate("xa456", "N");
			if (xa457.isChecked())
				data.accumulate("xa457", "Y");
			else
				data.accumulate("xa457", "N");
			if (xa458Y.isChecked()) {
				data.accumulate("xa458", "Y");
			} else if (xa458N.isChecked()) {
				data.accumulate("xa458", "Y");
			} else {
				data.accumulate("xa458", "");
			}
			data.accumulate("xa518", atc_xa518.getText());

			apqp7.accumulate("action", action);
			apqp7.accumulate("apqp7", data);
			jsonObj.accumulate("data", apqp7);
			return jsonObj;
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * get APQP =>TAB 8 => FinePitch ProbeCard(Apqp Type 5) =>user input data
	 * 
	 * @param action
	 * @return
	 */
	private JSONObject getInputData8(final String action) {

		try {
			JSONObject data = new JSONObject();
			JSONObject apqp8 = new JSONObject();
			JSONObject jsonObj = new JSONObject();
			jsonObj.accumulate("userid", super.getLoginUser());
			jsonObj.accumulate("WWID", "13145774WWGlobal999988apqp8999");
			String[] apqpno = this.getApqpNo().split("-");
			if (apqpno.length <= 1)
				return data;
			final String xa001 = apqpno[0];
		    final String xa002 = apqpno[1];
			data.accumulate("xa001", xa001);
			data.accumulate("xa002", xa002);
			data.accumulate("xa068", btnChange.getTag().toString());
			data.accumulate("xa591", xa591);
			data.accumulate("xa593", xa593);
			data.accumulate("xa015", pb_xa015.getText());
			if (pb_xa087.isChecked())
				data.accumulate("xa087", "Y");
			else
				data.accumulate("xa087", "N");
			if (pb_xa088.isChecked())
				data.accumulate("xa088", "Y");
			else
				data.accumulate("xa088", "N");
			if (pb_xa090.isChecked())
				data.accumulate("xa090", "Y");
			else
				data.accumulate("xa090", "N");
			data.accumulate("xa091", pb_xa091.getText());
			if (pb_xa092.isChecked())
				data.accumulate("xa092", "Y");
			else
				data.accumulate("xa092", "N");
			if (pb_xa093.isChecked())
				data.accumulate("xa093", "Y");
			else
				data.accumulate("xa093", "N");
			if (xa601.isChecked())
				data.accumulate("xa601", "Y");
			else
				data.accumulate("xa601", "N");
			data.accumulate("xa602", xa602.getText());
			data.accumulate("xa603", xa603.getText());
			data.accumulate("xa604", xa604.getText());
			data.accumulate("xa605", xa605.getText());
			if (xa606.isChecked())
				data.accumulate("xa606", "Y");
			else
				data.accumulate("xa606", "N");
			if (xa607.isChecked())
				data.accumulate("xa607", "Y");
			else
				data.accumulate("xa607", "N");
			if (xa608.isChecked())
				data.accumulate("xa608", "Y");
			else
				data.accumulate("xa608", "N");
			if (xa609.isChecked())
				data.accumulate("xa609", "Y");
			else
				data.accumulate("xa609", "N");
			data.accumulate("xa610", xa610.getText());
			data.accumulate("xa611", xa611.getText());
			data.accumulate("xa612", xa612.getText());
			data.accumulate("xa613", xa613.getText());
			data.accumulate("xa614", xa614.getText());
			if (xa615.isChecked())
				data.accumulate("xa615", "Y");
			else
				data.accumulate("xa615", "N");
			if (xa616.isChecked())
				data.accumulate("xa616", "Y");
			else
				data.accumulate("xa616", "N");
			if (xa617.isChecked())
				data.accumulate("xa617", "Y");
			else
				data.accumulate("xa617", "N");
			if (xa618.isChecked())
				data.accumulate("xa618", "Y");
			else
				data.accumulate("xa618", "N");
			data.accumulate("xa619", xa619.getText());
			data.accumulate("xa620", xa620.getText());
			data.accumulate("xa621", xa621.getText());
			data.accumulate("xa622", xa622.getText());
			data.accumulate("xa623", xa623.getText());
			if (xa624.isChecked())
				data.accumulate("xa624", "Y");
			else
				data.accumulate("xa624", "N");
			data.accumulate("xa625", xa625.getText());
			if (xa626.isChecked())
				data.accumulate("xa626", "Y");
			else
				data.accumulate("xa626", "N");
			data.accumulate("xa627", xa627.getText());
			if (xa628.isChecked())
				data.accumulate("xa628", "Y");
			else
				data.accumulate("xa628", "N");
			data.accumulate("xa629", xa629.getText());
			data.accumulate("xa630", xa630.getText());
			data.accumulate("xa631", xa631.getText());
			data.accumulate("xa632", xa632.getText());
			data.accumulate("xa633", xa633.getText());
			if (xa634.isChecked())
				data.accumulate("xa634", "Y");
			else
				data.accumulate("xa634", "N");
			if (xa635.isChecked())
				data.accumulate("xa635", "Y");
			else
				data.accumulate("xa635", "N");
			if (xa636.isChecked())
				data.accumulate("xa636", "Y");
			else
				data.accumulate("xa636", "N");
			if (xa637.isChecked())
				data.accumulate("xa637", "Y");
			else
				data.accumulate("xa637", "N");
			if (xa638.isChecked())
				data.accumulate("xa638", "Y");
			else
				data.accumulate("xa638", "N");
			if (xa639.isChecked())
				data.accumulate("xa639", "Y");
			else
				data.accumulate("xa639", "N");
			if (xa640.isChecked())
				data.accumulate("xa640", "Y");
			else
				data.accumulate("xa640", "N");
			if (xa641.isChecked())
				data.accumulate("xa641", "Y");
			else
				data.accumulate("xa641", "N");
			if (xa642.isChecked())
				data.accumulate("xa642", "Y");
			else
				data.accumulate("xa642", "N");
			if (xa643.isChecked())
				data.accumulate("xa643", "Y");
			else
				data.accumulate("xa643", "N");
			if (xa644.isChecked())
				data.accumulate("xa644", "Y");
			else
				data.accumulate("xa644", "N");
			if (xa645.isChecked())
				data.accumulate("xa645", "Y");
			else
				data.accumulate("xa645", "N");
			if (xa646.isChecked())
				data.accumulate("xa646", "Y");
			else
				data.accumulate("xa646", "N");
			if (xa647.isChecked())
				data.accumulate("xa647", "Y");
			else
				data.accumulate("xa647", "N");
			if (xa648.isChecked())
				data.accumulate("xa648", "Y");
			else
				data.accumulate("xa648", "N");
			data.accumulate("xa649", xa649.getText());
			data.accumulate("xa650", xa650.getText());
			if (xa651.isChecked())
				data.accumulate("xa651", "Y");
			else
				data.accumulate("xa651", "N");
			if (xa652.isChecked())
				data.accumulate("xa652", "Y");
			else
				data.accumulate("xa652", "N");
			if (xa653.isChecked())
				data.accumulate("xa653", "Y");
			else
				data.accumulate("xa653", "N");
			if (xa654.isChecked())
				data.accumulate("xa654", "Y");
			else
				data.accumulate("xa654", "N");
			if (xa655.isChecked())
				data.accumulate("xa655", "Y");
			else
				data.accumulate("xa655", "N");
			data.accumulate("xa656", xa656.getText());
			data.accumulate("xa657", xa657.getText());
			if (xa658.isChecked())
				data.accumulate("xa658", "Y");
			else
				data.accumulate("xa658", "N");
			data.accumulate("xa659", xa659.getText());
			if (xa660.isChecked())
				data.accumulate("xa660", "Y");
			else
				data.accumulate("xa660", "N");
			if (xa661.isChecked())
				data.accumulate("xa661", "Y");
			else
				data.accumulate("xa661", "N");
			if (xa662.isChecked())
				data.accumulate("xa662", "Y");
			else
				data.accumulate("xa662", "N");
			if (xa663.isChecked())
				data.accumulate("xa663", "Y");
			else
				data.accumulate("xa663", "N");
			if (xa664.isChecked())
				data.accumulate("xa664", "Y");
			else
				data.accumulate("xa664", "N");
			if (xa665Y.isChecked()) {
				data.accumulate("xa665", "Y");
			} else if (xa665N.isChecked()) {
				data.accumulate("xa665", "Y");
			} else {
				data.accumulate("xa665", "");
			}
			if (xa666.isChecked())
				data.accumulate("xa666", "Y");
			else
				data.accumulate("xa666", "N");
			if (xa667.isChecked())
				data.accumulate("xa667", "Y");
			else
				data.accumulate("xa667", "N");
			if (xa668.isChecked())
				data.accumulate("xa668", "Y");
			else
				data.accumulate("xa668", "N");
			if (xa669.isChecked())
				data.accumulate("xa669", "Y");
			else
				data.accumulate("xa669", "N");
			if (xa670.isChecked())
				data.accumulate("xa670", "Y");
			else
				data.accumulate("xa670", "N");
			if (xa671.isChecked())
				data.accumulate("xa671", "Y");
			else
				data.accumulate("xa671", "N");
			if (xa672.isChecked())
				data.accumulate("xa672", "Y");
			else
				data.accumulate("xa672", "N");
			data.accumulate("xa673", xa673.getText());

			if (xa674Y.isChecked()) {
				data.accumulate("xa674", "Y");
			} else if (xa674N.isChecked()) {
				data.accumulate("xa674", "Y");
			} else {
				data.accumulate("xa674", "");
			}
			data.accumulate("xa675", xa675.getText());
			data.accumulate("xa676", xa676.getText());
			if (xa677.isChecked())
				data.accumulate("xa677", "Y");
			else
				data.accumulate("xa677", "N");
			// 150924 add
			data.accumulate(
					"xa00t",
					(xa00t1.isChecked() ? "1" : (xa00t2.isChecked() ? "2" : "")));
			data.accumulate("xa678", xa678.isChecked() ? "Y" : "N");
			data.accumulate("xa679", xa679.isChecked() ? "Y" : "N");
			data.accumulate("xa680", xa680.isChecked() ? "Y" : "N");
			data.accumulate("xa681", xa681.isChecked() ? "Y" : "N");
			data.accumulate("xa682", xa682.isChecked() ? "Y" : "N");
			data.accumulate("xa683", xa683.getText());
			data.accumulate("xa024", pb_xa024.getText());
			// end
			apqp8.accumulate("action", action);
			apqp8.accumulate("apqp8", data);
			jsonObj.accumulate("data", apqp8);
			return jsonObj;
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * get APQP =>TAB 9 => Changeover Kit(Apqp Type 6) =>user input data
	 * 
	 * @param action
	 * @return
	 */
	private JSONObject getInputData9(final String action) {

		try {
			JSONObject data = new JSONObject();
			JSONObject apqp9 = new JSONObject();
			JSONObject jsonObj = new JSONObject();
			jsonObj.accumulate("userid", super.getLoginUser());
			jsonObj.accumulate("WWID", "13145774WWGlobal999988apqp9999");
			String[] apqpno = this.getApqpNo().split("-");
			if (apqpno.length <= 1)
				return data;
			final String xa001 = apqpno[0];
			final String xa002 = apqpno[1];
			data.accumulate("xa001", xa001);
			data.accumulate("xa002", xa002);
			data.accumulate("xa068", btnChange.getTag().toString());
			data.accumulate("xa591", xa591);
			data.accumulate("xa593", xa593);
			data.accumulate("xa015", ck_xa015.getText());
			data.accumulate("xa018", ck_xa518.getTag());
			data.accumulate("xa019", ck_xa019.getText());
			data.accumulate("xa020", ck_xa020.getText());
			data.accumulate("xa021", ck_xa021.getText());
			data.accumulate("xa022", ck_xa022.getText());
			data.accumulate("xa023", ck_xa023.getText());
			data.accumulate("xa024", ck_xa024.getText());
			data.accumulate("xa025", ck_xa025.getText());
			if (ck_xa087.isChecked())
				data.accumulate("xa087", "Y");
			else
				data.accumulate("xa087", "N");
			if (ck_xa088.isChecked())
				data.accumulate("xa088", "Y");
			else
				data.accumulate("xa088", "N");
			if (ck_xa090.isChecked())
				data.accumulate("xa090", "Y");
			else
				data.accumulate("xa090", "N");
			data.accumulate("xa091", ck_xa091.getText());
			if (ck_xa092.isChecked())
				data.accumulate("xa092", "Y");
			else
				data.accumulate("xa092", "N");
			if (ck_xa093.isChecked())
				data.accumulate("xa093", "Y");
			else
				data.accumulate("xa093", "N");
			data.accumulate("xa518", ck_xa518.getText());
			if (xa701.isChecked())
				data.accumulate("xa701", "Y");
			else
				data.accumulate("xa701", "N");
			if (xa702.isChecked())
				data.accumulate("xa702", "Y");
			else
				data.accumulate("xa702", "N");
			if (xa703.isChecked())
				data.accumulate("xa703", "Y");
			else
				data.accumulate("xa703", "N");
			if (xa704.isChecked())
				data.accumulate("xa704", "Y");
			else
				data.accumulate("xa704", "N");
			if (xa705.isChecked())
				data.accumulate("xa705", "Y");
			else
				data.accumulate("xa705", "N");
			if (xa706Y.isChecked()) {
				data.accumulate("xa706", "Y");
			} else if (xa706N.isChecked()) {
				data.accumulate("xa706", "Y");
			} else {
				data.accumulate("xa706", "");
			}
			if (xa707Y.isChecked()) {
				data.accumulate("xa707", "Y");
			} else if (xa707N.isChecked()) {
				data.accumulate("xa707", "Y");
			} else {
				data.accumulate("xa707", "");
			}
			data.accumulate("xa708", xa708.getText());
			data.accumulate("xa709", xa709.getText());
			data.accumulate("xa710", xa710.getText());
			data.accumulate("xa711", xa711.getText());
			data.accumulate("xa722", xa722.getText());
			data.accumulate("xa723", xa723.getText());
			data.accumulate("xa724", xa724.getText());
			data.accumulate("xa725", xa725.getText());
			data.accumulate("xa726", xa726.getText());
			data.accumulate("xa727", xa727.getText());
			data.accumulate("xa728", xa728.getText());
			data.accumulate("xa729", xa729.getText());
			data.accumulate("xa730", xa730.getText());

			if (xa712.isChecked())
				data.accumulate("xa712", "Y");
			else
				data.accumulate("xa712", "N");
			if (xa713.isChecked())
				data.accumulate("xa713", "Y");
			else
				data.accumulate("xa713", "N");
			if (xa714.isChecked())
				data.accumulate("xa714", "Y");
			else
				data.accumulate("xa714", "N");
			if (xa715.isChecked())
				data.accumulate("xa715", "Y");
			else
				data.accumulate("xa715", "N");
			if (xa716.isChecked())
				data.accumulate("xa716", "Y");
			else
				data.accumulate("xa716", "N");
			data.accumulate("xa717", xa717.getText());
			data.accumulate("xa718", xa718.getText());
			data.accumulate("xa719", xa719.getText());

			apqp9.accumulate("action", action);
			apqp9.accumulate("apqp9", data);
			jsonObj.accumulate("data", apqp9);
			return jsonObj;
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * get APQP =>TAB A => E-Flux(Apqp Type 7) =>user input data
	 * 
	 * @param action
	 * @return
	 */
	private JSONObject getInputDataA(final String action) {

		try {
			JSONObject data = new JSONObject();
			JSONObject apqpA = new JSONObject();
			JSONObject jsonObj = new JSONObject();
			jsonObj.accumulate("userid", super.getLoginUser());
			jsonObj.accumulate("WWID", "13145774WWGlobal999988apqpA999");
			String[] apqpno = this.getApqpNo().split("-");
			if (apqpno.length <= 1)
				return data;
			final String xa001 = apqpno[0];
			final String xa002 = apqpno[1];
			data.accumulate("xa001", xa001);
			data.accumulate("xa002", xa002);
			data.accumulate("xa068", btnChange.getTag().toString());
			data.accumulate("xa591", xa591);
			data.accumulate("xa593", xa593);
			data.accumulate("xa015", ef_xa015.getText());
			data.accumulate("xa018", ef_xa518.getTag());
			data.accumulate("xa020", ef_xa020.getText());
			data.accumulate("xa021", ef_xa021.getText());
			data.accumulate("xa022", ef_xa022.getText());
			data.accumulate("xa023", ef_xa023.getText());
			data.accumulate("xa024", ef_xa024.getText());
			data.accumulate("xa025", ef_xa025.getText());
			if (ef_xa087.isChecked())
				data.accumulate("xa087", "Y");
			else
				data.accumulate("xa087", "N");
			if (ef_xa088.isChecked())
				data.accumulate("xa088", "Y");
			else
				data.accumulate("xa088", "N");
			if (ef_xa089.isChecked())
				data.accumulate("xa089", "Y");
			else
				data.accumulate("xa089", "N");
			if (ef_xa090.isChecked())
				data.accumulate("xa090", "Y");
			else
				data.accumulate("xa090", "N");
			data.accumulate("xa091", ef_xa091.getText());
			if (ef_xa092.isChecked())
				data.accumulate("xa092", "Y");
			else
				data.accumulate("xa092", "N");
			if (ef_xa093.isChecked())
				data.accumulate("xa093", "Y");
			else
				data.accumulate("xa093", "N");
			data.accumulate("xa518", ef_xa518.getText());
			data.accumulate("xa804", xa804.getText());
			data.accumulate("xa805", xa805.getText());
			data.accumulate("xa806", xa806.getText());
			data.accumulate("xa807", xa807.getText());
			data.accumulate("xa808", xa808.getText());
			if (xa809.isChecked())
				data.accumulate("xa809", "Y");
			else
				data.accumulate("xa809", "N");
			if (xa810.isChecked())
				data.accumulate("xa810", "Y");
			else
				data.accumulate("xa810", "N");
			if (xa811.isChecked())
				data.accumulate("xa811", "Y");
			else
				data.accumulate("xa811", "N");
			if (xa813.isChecked())
				data.accumulate("xa813", "Y");
			else
				data.accumulate("xa813", "N");
			if (xa815.isChecked())
				data.accumulate("xa815", "Y");
			else
				data.accumulate("xa815", "N");
			if (xa822.isChecked())
				data.accumulate("xa822", "Y");
			else
				data.accumulate("xa822", "N");
			data.accumulate("xa824", xa824.getText());
			if (xa825.isChecked())
				data.accumulate("xa825", "Y");
			else
				data.accumulate("xa825", "N");
			if (xa826.isChecked())
				data.accumulate("xa826", "Y");
			else
				data.accumulate("xa826", "N");
			data.accumulate("xa827", xa827.getText());
			if (xa828.isChecked())
				data.accumulate("xa828", "Y");
			else
				data.accumulate("xa828", "N");
			if (xa829.isChecked())
				data.accumulate("xa829", "Y");
			else
				data.accumulate("xa829", "N");
			if (xa830Y.isChecked()) {
				data.accumulate("xa830", "Y");
			} else if (xa830N.isChecked()) {
				data.accumulate("xa30", "Y");
			} else {
				data.accumulate("xa830", "");
			}
			if (xa831.isChecked())
				data.accumulate("xa831", "Y");
			else
				data.accumulate("xa831", "N");
			data.accumulate("xa832", xa832.getText());
			if (xa839.isChecked())
				data.accumulate("xa839", "Y");
			else
				data.accumulate("xa839", "N");
			if (xa840.isChecked())
				data.accumulate("xa840", "Y");
			else
				data.accumulate("xa840", "N");
			data.accumulate("xa841", xa841.getText());
			if (xa842.isChecked())
				data.accumulate("xa842", "Y");
			else
				data.accumulate("xa842", "N");
			data.accumulate("xa843", xa843.getText());
			data.accumulate("xa844", xa844.getText());
			data.accumulate("xa845", xa845.getText());
			data.accumulate("xa846", xa846.getText());
			data.accumulate("xa849text", xa849.getText());
			data.accumulate("xa849", xa849.getTag());
			data.accumulate("xa850", xa850.getText());
			if (xa851.isChecked())
				data.accumulate("xa851", "Y");
			else
				data.accumulate("xa851", "N");
			if (xa852.isChecked())
				data.accumulate("xa852", "Y");
			else
				data.accumulate("xa852", "N");
			data.accumulate("xa853", xa853.getText());
			// 150924 add
			data.accumulate("xa856", xa856.getText());
			data.accumulate("xa857", xa857.getText());
			data.accumulate("xa858", xa858.getText());
			data.accumulate("xa859", xa859.getText());
			data.accumulate("xa860", xa860.getText());
			data.accumulate("xa861", xa861.isChecked() ? "Y" : "N");
			data.accumulate("xa862", xa862.isChecked() ? "Y" : "N");
			// end
			apqpA.accumulate("action", action);
			apqpA.accumulate("apqpA", data);
			jsonObj.accumulate("data", apqpA);
			return jsonObj;
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * get APQP =>TAB B => Comment(Apqp Type 1~9) =>user input data
	 * 
	 * @param action
	 * @return
	 */
	private JSONObject getInputDataB(final String action) {

		try {
			JSONObject data = new JSONObject();
			JSONObject apqpB = new JSONObject();
			JSONObject jsonObj = new JSONObject();
			jsonObj.accumulate("userid", super.getLoginUser());
			jsonObj.accumulate("WWID", "13145774WWGlobal999988apqpB999");
			String[] apqpno = this.getApqpNo().split("-");
			if (apqpno.length <= 1)
				return data;
			final String xa001 = apqpno[0];
			final String xa002 = apqpno[1];
			data.accumulate("xa001", xa001);
			data.accumulate("xa002", xa002);
			data.accumulate("xa068", btnChange.getTag().toString());
			data.accumulate("xa591", xa591);
			data.accumulate("xa593", xa593);
			data.accumulate("xa049", xa049.getText());
			data.accumulate("xa59r", xa59r.getText());// No.15041501
			apqpB.accumulate("action", action);
			apqpB.accumulate("apqpB", data);
			jsonObj.accumulate("data", apqpB);
			return jsonObj;
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * get APQP =>TAB D => Forecast(Apqp Type 1~9) =>user input data
	 * 
	 * @param action
	 * @return
	 */
	private JSONObject getInputDataD(final String action) {

		try {
			JSONObject data = new JSONObject();
			JSONObject apqpD = new JSONObject();
			JSONObject jsonObj = new JSONObject();
			jsonObj.accumulate("userid", super.getLoginUser());
			jsonObj.accumulate("WWID", "13145774WWGlobal999988apqpD999");
			String[] apqpno = this.getApqpNo().split("-");
			if (apqpno.length <= 1)
				return data;
			final String xa001 = apqpno[0];
			final String xa002 = apqpno[1];
			data.accumulate("xa001", xa001);
			data.accumulate("xa002", xa002);
			data.accumulate("xa068", btnChange.getTag().toString());
			data.accumulate("xa591", xa591);
			data.accumulate("xa593", xa593);
			data.accumulate("xa59d", xa59d.getText().toString());
			data.accumulate("xa59e", xa59e.getText().toString());
			data.accumulate("xa59f", xa59f.getText().toString());
			data.accumulate("xa59v", xa59v.getText().toString());
			data.accumulate("xa00i", xa00i.getText().toString());
			data.accumulate("xa59w", xa59w.getText().toString());
			data.accumulate("xa59x", xa59x.getText().toString());
			data.accumulate("xa00a", xa00a.getText().toString());
			data.accumulate("xa00b", xa00b.getText().toString());
			data.accumulate("xa00c", xa00c.getText().toString());
			data.accumulate("xa00d", xa00d.getText().toString());
			data.accumulate("xa00e", xa00e.getText().toString());
			data.accumulate("xa00f", xa00f.getText().toString());
			data.accumulate("xa00g", xa00g.getText().toString());
			data.accumulate("xa00h", xa00h.getText().toString());
			data.accumulate("xa59z", xa59z.getText().toString());
			apqpD.accumulate("action", action);
			apqpD.accumulate("apqpD", data);
			jsonObj.accumulate("data", apqpD);
			return jsonObj;
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	// H
	public void hideActionbar() {
		ActionBar mActionBar = getActivity().getActionBar();
		if (mActionBar.isShowing())
			mActionBar.hide();
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
	 * get webservice data　(getAPQP1 =>Customer Infomations)
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
			//final String xa001 = data.getString("xa001");
			//final String xa002 = data.getString("xa002");
			// if (data.getString("editable").equals("N")) {
			// btnEdit.setVisibility(View.GONE);
			// }
			btnEdit.setTag(data.getString("editable"));
			btnIssue.setTag(data.getString("issuable"));
			btnChange.setTag(data.getString("xa068"));
			xa591 = data.getString("xa591");
			xa593 = data.getString("xa593");
			setLayoutUI(Integer.parseInt(xa593));
			xa003.setText(data.getString("xa003")); // IssueDate
			CREATOR.setText(data.getString("CREATOR"));// Creator
			xa004.setText(data.getString("xa004")); // Cust NO
			xa004text.setText(data.getString("xa004text")); // Cust Name
			xa005.setText(data.getString("xa005")); // Contact
			xa006.setText(data.getString("xa006")); // Phone num
			xa007.setText(data.getString("xa007"));// Phone num
			xa008.setText(data.getString("xa008")); // Mobile
			xa009.setText(data.getString("xa009")); // Fax
			xa010.setText(data.getString("xa010"));// Email
			xa012.setText(data.getString("xa012"));// Address
			xa053.setText(data.getString("xa053"));// Sales Rep
			xa054.setText(data.getString("xa054"));// Purchase Order
			xa055.setText(data.getString("xa055"));// Date Received
			xa057.setText(data.getString("xa057"));// project name
			xa058.setText(data.getString("xa058"));// project name
			xa066.setText(data.getString("xa066")); // ConfirmDate
			xa067.setText(data.getString("xa067")); // Confirm By
			xa502.setText(data.getString("xa502")); // Phone num
			xa503.setText(data.getString("xa503")); // Fax
			xa517.setText(data.getString("xa517")); // CS
			xa551.setText(data.getString("xa551"));// end customer
			xa553.setTag(data.getString("xa552"));// cust region
			xa553.setText(data.getString("xa553"));// cust region
			xa560.setText(data.getString("xa560")); // Purpose
			xa594.setText(data.getString("xa594")); // PID
			// 2015/09/17 add
			xa00U.setText(data.getString("xa00U"));
			xa00Utext.setText(data.getString("xa00Utext"));
			xa00K.setText(data.getString("xa00Ktext"));
			xa00K.setTag(data.getString("xa00K"));
			xa00L.setText(data.getString("xa00Ktext"));
			xa00L.setTag(data.getString("xa00K"));
			xa59U.setText(data.getString("xa59Utext"));
			xa59U.setTag(data.getString("xa59U"));
			xa00S.setText(data.getString("xa00Stext"));
			xa00S.setTag(data.getString("xa00S"));
			xa00R.setText(data.getString("xa00Rtext"));
			xa00R.setTag(data.getString("xa00R"));
			// end of add
			xa595.setChecked((data.getString("xa595").equals("Y") ? true
					: false));// rfq
			xa59G.setChecked((data.getString("xa59G").equals("Y") ? true
					: false));// 24h
			xa59H.setChecked((data.getString("xa59H").equals("Y") ? true
					: false));// eng
			if (xa59H.isChecked()) {
				xa59I.setEnabled(true);
				xa59I.setBackgroundResource(R.drawable.border);
			}
			xa59I.setText(data.getString("xa59I"));
			JSONArray apqp1qt = data.getJSONArray("apqp1qt");
			JSONArray apqp1so = data.getJSONArray("apqp1so");
			JSONArray apqp1po = data.getJSONArray("apqp1po");
			if (apqp1qt.length() > 0) {
				for (int i = 0; i < apqp1qt.length(); i++) {
					JSONObject item = apqp1qt.getJSONObject(i);
					TableRow tableRow = new TableRow(context);
					tableRow.setLayoutParams(new TableRow.LayoutParams(
							TableRow.LayoutParams.MATCH_PARENT,
							TableRow.LayoutParams.WRAP_CONTENT));
					TextView col1 = new TextView(context);
					col1.setText(item.getString("qt_type"));
					col1.setTextColor(Color.BLACK);
					col1.setLayoutParams(new TableRow.LayoutParams(
							TableRow.LayoutParams.WRAP_CONTENT,
							TableRow.LayoutParams.WRAP_CONTENT));
					tableRow.addView(col1);

					TextView col2 = new TextView(context);
					col2.setText(item.getString("qt_no"));
					col2.setTextColor(Color.BLACK);
					col2.setLayoutParams(new TableRow.LayoutParams(
							TableRow.LayoutParams.WRAP_CONTENT,
							TableRow.LayoutParams.WRAP_CONTENT));
					tableRow.addView(col2);
					TextView col3 = new TextView(context);
					col3.setText(item.getString("qt_upd_dt"));
					col3.setTextColor(Color.BLACK);
					col3.setLayoutParams(new TableRow.LayoutParams(
							TableRow.LayoutParams.WRAP_CONTENT,
							TableRow.LayoutParams.WRAP_CONTENT));
					tableRow.addView(col3);
					qt.addView(tableRow, new TableLayout.LayoutParams(
							TableLayout.LayoutParams.MATCH_PARENT,
							TableLayout.LayoutParams.MATCH_PARENT));

				}
			}
			if (apqp1po.length() > 0) {
				for (int i = 0; i < apqp1po.length(); i++) {
					JSONObject item = apqp1po.getJSONObject(i);
					TableRow tableRow = new TableRow(context);
					tableRow.setLayoutParams(new TableRow.LayoutParams(
							TableRow.LayoutParams.MATCH_PARENT,
							TableRow.LayoutParams.WRAP_CONTENT));
					TextView col1 = new TextView(context);
					col1.setText(item.getString("po_no"));
					col1.setTextColor(Color.BLACK);
					col1.setLayoutParams(new TableRow.LayoutParams(
							TableRow.LayoutParams.WRAP_CONTENT,
							TableRow.LayoutParams.WRAP_CONTENT));
					tableRow.addView(col1);

					TextView col2 = new TextView(context);
					col2.setText(item.getString("po_date"));
					col2.setTextColor(Color.BLACK);
					col2.setLayoutParams(new TableRow.LayoutParams(
							TableRow.LayoutParams.WRAP_CONTENT,
							TableRow.LayoutParams.WRAP_CONTENT));
					tableRow.addView(col2);
					TextView col3 = new TextView(context);
					col3.setText(item.getString("so_no"));
					col3.setTextColor(Color.BLACK);
					col3.setLayoutParams(new TableRow.LayoutParams(
							TableRow.LayoutParams.WRAP_CONTENT,
							TableRow.LayoutParams.WRAP_CONTENT));
					tableRow.addView(col3);
					po.addView(tableRow, new TableLayout.LayoutParams(
							TableLayout.LayoutParams.MATCH_PARENT,
							TableLayout.LayoutParams.MATCH_PARENT));
				}
			}
			if (apqp1so.length() > 0) {
				for (int i = 0; i < apqp1po.length(); i++) {
					JSONObject item = apqp1so.getJSONObject(i);
					TableRow tableRow = new TableRow(context);
					tableRow.setLayoutParams(new TableRow.LayoutParams(
							TableRow.LayoutParams.MATCH_PARENT,
							TableRow.LayoutParams.WRAP_CONTENT));
					TextView col1 = new TextView(context);
					col1.setText(item.getString("so_no"));
					col1.setTextColor(Color.BLACK);
					col1.setLayoutParams(new TableRow.LayoutParams(
							TableRow.LayoutParams.WRAP_CONTENT,
							TableRow.LayoutParams.WRAP_CONTENT));
					tableRow.addView(col1);

					TextView col2 = new TextView(context);
					col2.setText(item.getString("qt_upd"));
					col2.setTextColor(Color.BLACK);
					col2.setLayoutParams(new TableRow.LayoutParams(
							TableRow.LayoutParams.WRAP_CONTENT,
							TableRow.LayoutParams.WRAP_CONTENT));
					tableRow.addView(col2);

					so.addView(tableRow, new TableLayout.LayoutParams(
							TableLayout.LayoutParams.MATCH_PARENT,
							TableLayout.LayoutParams.MATCH_PARENT));

				}

			}
			

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * get webservice data　(getAPQP2 =>Package Information, Package Infor...)
	 * 
	 * @param obj
	 */
	private void loadData2(Object obj) {

		try {
			JSONObject responeData = new JSONObject((String) obj);
			// 如果不是成功的呼叫，則返回
			if (!responeData.getString("success").equals("true")) {
				showDialog("error", responeData.getString("remark"));
				return;
			}
			JSONObject data = responeData.getJSONObject("data");
			btnEdit.setTag(data.getString("editable"));
			btnIssue.setTag(data.getString("issuable"));
			btnChange.setTag(data.getString("xa068"));
			//String xa001 = data.getString("xa001");
			//String xa002 = data.getString("xa002");
			xa591 = data.getString("xa591");
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
			/*
			 * queryData((String) getWebServiceUrl() + "getAPQP3",
			 * getAPQP3(xa001, xa002), new IDataReceiveListener() { public void
			 * onReceiveData(Object obj) { loadData3(obj); } });
			 */

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * get webservice data　(getAPQP3 =>Hander)
	 * 
	 * @param obj
	 */
	private void loadData3(Object obj) {

		try {
			JSONObject responeData = new JSONObject((String) obj);
			// 如果不是成功的呼叫，則返回
			if (!responeData.getString("success").equals("true")) {
				showDialog("error", responeData.getString("remark"));
				return;
			}
			JSONObject data = responeData.getJSONObject("data");
			//String xa001 = data.getString("xa001");
			//String xa002 = data.getString("xa002");
			xa591 = data.getString("xa591");
			xa593 = data.getString("xa593");			
			btnEdit.setTag(data.getString("editable"));
			btnIssue.setTag(data.getString("issuable"));
			btnChange.setTag(data.getString("xa068"));
			// Handler manufacturer
			xa037.setText(data.getString("xa037text"));
			xa037.setTag(data.getString("xa037"));
			// Handler model
			xa038.setText(data.getString("xa038text"));
			xa038.setTag(data.getString("xa038"));
			// Tester manufacturer
			xa039.setText(data.getString("xa039text"));
			xa039.setTag(data.getString("xa039"));
			// Tester model
			xa040.setText(data.getString("xa040text"));
			xa040.setTag(data.getString("xa040"));
			//
			if (data.getString("xa073").equals("Y"))
				xa073.setChecked(true);
			if (data.getString("xa074").equals("Y"))
				xa074.setChecked(true);
			if (data.getString("xa075").equals("Y"))
				xa075.setChecked(true);
			if (data.getString("xa076").equals("Y"))
				xa076.setChecked(true);
			if (data.getString("xa077").equals("Y"))
				xa077.setChecked(true);
			if (xa077.isChecked()) {
				xa042.setBackgroundResource(R.drawable.border);
			}
			xa042.setText(data.getString("xa042"));
			xa59B.setText(data.getString("xa59B"));
			xa59C.setText(data.getString("xa59C"));
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void loadData4(Object obj) {

		try {
			JSONObject responeData = new JSONObject((String) obj);
			// 如果不是成功的呼叫，則返回
			if (!responeData.getString("success").equals("true")) {
				showDialog("error", responeData.getString("remark"));
				return;
			}
			JSONObject data = responeData.getJSONObject("data");
			//String xa001 = data.getString("xa001");
			//String xa002 = data.getString("xa002");
			btnEdit.setTag(data.getString("editable"));
			btnIssue.setTag(data.getString("issuable"));
			btnChange.setTag(data.getString("xa068"));
			xa591 = data.getString("xa591");
			xa593 = data.getString("xa593");			
			if (data.getString("xa043").equals("Y"))
				xa043.setChecked(true);
			if (data.getString("xa061").equals("Y"))
				xa061.setChecked(true);
			if (data.getString("xa062").equals("Y"))
				xa062.setChecked(true);
			if (data.getString("xa044").equals("Y"))
				xa044.setChecked(true);
			if (data.getString("xa063").equals("Y"))
				xa063.setChecked(true);
			if (data.getString("xa064").equals("Y"))
				xa064.setChecked(true);
			if (data.getString("xa065").equals("Y"))
				xa065.setChecked(true);
			if (data.getString("xa097").equals("Y"))
				xa097.setChecked(true);
			if (data.getString("xa118").equals("Y"))
				xa118.setChecked(true);
			if (data.getString("xa121").equals("Y"))
				xa121.setChecked(true);
			if (data.getString("xa122").equals("Y"))
				xa122.setChecked(true);
			if (data.getString("xa124").equals("Y"))
				xa124.setChecked(true);
			if (data.getString("xa125").equals("Y"))
				xa125.setChecked(true);
			if (data.getString("xa126").equals("Y"))
				xa126.setChecked(true);
			if (data.getString("xa128").equals("Y"))
				xa128.setChecked(true);
			if (data.getString("xa129").equals("Y"))
				xa129.setChecked(true);
			if (data.getString("xa051").equals("1"))
				xa051a.setChecked(true);
			if (data.getString("xa051").equals("2"))
				xa051b.setChecked(true);
			if (data.getString("xa051").equals("3"))
				xa051c.setChecked(true);
			xa102.setText(data.getString("xa102"));
			xa119.setText(data.getString("xa119"));
			xa120.setText(data.getString("xa120"));
			xa123.setText(data.getString("xa123"));
			xa050.setText(data.getString("xa050"));
			xa127.setText(data.getString("xa127"));	
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			showDialog("error", e.getMessage());
		}

	}

	/**
	 * get webservice data　(getAPQP5 =>Duplicationt)
	 * 
	 * @param obj
	 */
	private void loadData5(Object obj) {

		try {
			JSONObject responeData = new JSONObject((String) obj);
			// 如果不是成功的呼叫，則返回
			if (!responeData.getString("success").equals("true")) {
				showDialog("error", responeData.getString("remark"));
				return;
			}
			JSONObject data = responeData.getJSONObject("data");
			//final String xa001 = data.getString("xa001");
			//final String xa002 = data.getString("xa002");
			btnEdit.setTag(data.getString("editable"));
			btnIssue.setTag(data.getString("issuable"));
			btnChange.setTag(data.getString("xa068"));
			xa591 = data.getString("xa591");
			xa593 = data.getString("xa593");
			xa518a.setTag(data.getString("xa018"));
			xa020a.setText(data.getString("xa020"));
			xa021a.setText(data.getString("xa021"));
			xa022a.setText(data.getString("xa022"));
			xa023a.setText(data.getString("xa023"));
			xa024a.setText(data.getString("xa024"));
			xa025a.setText(data.getString("xa025"));
			if (data.getString("xa201").equals("Y"))
				xa201.setChecked(true);
			if (data.getString("xa202").equals("Y"))
				xa202.setChecked(true);
			if (data.getString("xa203").equals("Y"))
				xa203.setChecked(true);
			if (data.getString("xa204").equals("Y"))
				xa204.setChecked(true);
			if (data.getString("xa205").equals("Y"))
				xa205.setChecked(true);
			if (data.getString("xa206").equals("Y"))
				xa206.setChecked(true);
			if (data.getString("xa207").equals("Y"))
				xa207.setChecked(true);
			if (data.getString("xa208").equals("Y"))
				xa208.setChecked(true);
			xa209.setText(data.getString("xa209"));
			if (data.getString("xa210").equals("Y"))
				xa210.setChecked(true);
			xa215.setText(data.getString("xa215"));
			if (data.getString("xa216").equals("Y"))
				xa216.setChecked(true);
			if (data.getString("xa217").equals("Y"))
				xa217.setChecked(true);
			if (data.getString("xa218").equals("Y"))
				xa218.setChecked(true);
			if (data.getString("xa219").equals("Y"))
				xa219.setChecked(true);
			xa220.setText(data.getString("xa220"));
			xa220.setText(data.getString("xa220"));
			xa221.setText(data.getString("xa221"));
			xa221.setText(data.getString("xa221"));
			if (data.getString("xa222").equals("Y"))
				xa222.setChecked(true);
			if (data.getString("xa223").equals("Y"))
				xa223.setChecked(true);
			if (data.getString("xa224").equals("Y"))
				xa224.setChecked(true);
			if (data.getString("xa225").equals("Y"))
				xa225.setChecked(true);
			if (data.getString("xa226").equals("Y"))
				xa226.setChecked(true);
			xa227.setText(data.getString("xa227"));
			xa227.setText(data.getString("xa227"));
			xa228.setText(data.getString("xa228"));
			xa228.setText(data.getString("xa228"));
			if (data.getString("xa229").equals("Y"))
				xa229.setChecked(true);
			if (data.getString("xa230").equals("Y"))
				xa230.setChecked(true);
			if (data.getString("xa231").equals("Y"))
				xa231.setChecked(true);
			if (data.getString("xa232").equals("Y"))
				xa232.setChecked(true);
			if (data.getString("xa233").equals("Y"))
				xa233.setChecked(true);
			xa234.setText(data.getString("xa234"));
			if (data.getString("xa235").equals("Y"))
				xa235.setChecked(true);
			if (data.getString("xa236").equals("Y"))
				xa236.setChecked(true);
			if (data.getString("xa237").equals("Y"))
				xa237.setChecked(true);
			if (data.getString("xa238").equals("Y"))
				xa238.setChecked(true);
			if (data.getString("xa239").equals("Y"))
				xa239.setChecked(true);
			if (data.getString("xa240").equals("Y"))
				xa240.setChecked(true);
			xa241.setText(data.getString("xa241"));
			xa242.setText(data.getString("xa242"));
			xa243.setText(data.getString("xa243"));
			xa244.setText(data.getString("xa244"));
			xa245.setText(data.getString("xa245"));
			if (data.getString("xa246").equals("Y"))
				xa246.setChecked(true);
			xa247.setText(data.getString("xa247"));
			xa248.setText(data.getString("xa248"));
			if (data.getString("xa249").equals("Y"))
				xa249.setChecked(true);
			xa250.setText(data.getString("xa250"));
			xa251.setText(data.getString("xa251"));
			if (data.getString("xa252").equals("Y"))
				xa252.setChecked(true);
			if (data.getString("xa253").equals("Y"))
				xa253.setChecked(true);
			if (data.getString("xa254").equals("Y"))
				xa254.setChecked(true);
			if (data.getString("xa255").equals("Y"))
				xa255.setChecked(true);
			if (data.getString("xa256").equals("Y"))
				xa256.setChecked(true);
			xa257.setText(data.getString("xa257"));
			if (data.getString("xa258").equals("Y"))
				xa258.setChecked(true);
			xa259.setText(data.getString("xa259"));
			if (data.getString("xa260").equals("Y"))
				xa260.setChecked(true);
			xa261.setText(data.getString("xa261"));
			if (data.getString("xa262").equals("Y"))
				xa262.setChecked(true);
			if (data.getString("xa263").equals("Y"))
				xa263.setChecked(true);
			if (data.getString("xa264").equals("Y"))
				xa264.setChecked(true);
			if (data.getString("xa265").equals("Y"))
				xa265.setChecked(true);
			if (data.getString("xa266").equals("Y"))
				xa266.setChecked(true);
			if (data.getString("xa267").equals("Y"))
				xa267.setChecked(true);
			xa268.setText(data.getString("xa268"));
			xa276.setText(data.getString("xa276"));
			xa277.setText(data.getString("xa277"));
			xa278.setText(data.getString("xa278"));
			if (data.getString("xa279").equals("Y"))
				xa279.setChecked(true);
			xa280.setText(data.getString("xa280"));
			xa280.setText(data.getString("xa280"));
			xa282.setText(data.getString("xa282"));
			if (data.getString("xa289").equals("Y"))
				xa289.setChecked(true);
			if (data.getString("xa292").equals("Y"))
				xa292.setChecked(true);
			if (data.getString("xa293").equals("Y"))
				xa293.setChecked(true);
			if (data.getString("xa294").equals("Y"))
				xa294.setChecked(true);
			if (data.getString("xa295").equals("Y"))
				xa295.setChecked(true);
			xa296.setText(data.getString("xa296"));
			if (data.getString("xa29d").equals("Y"))
				xa29dY.setChecked(true);
			else if (data.getString("xa29d").equals("Y"))
				xa29dN.setChecked(true);
			xa29k.setText(data.getString("xa29k"));
			xa29l.setText(data.getString("xa29l"));
			xa29m.setText(data.getString("xa29m"));
			xa29n.setText(data.getString("xa29n"));
			xa29p.setText(data.getString("xa29p"));
			xa29q.setText(data.getString("xa29qtext"));
			xa29q.setTag(data.getString("xa29q"));
			xa29r.setText(data.getString("xa29rtext"));
			xa29r.setTag(data.getString("xa29r"));
			xa29s.setText(data.getString("xa29stext"));
			xa29s.setTag(data.getString("xa29s"));
			xa29t.setText(data.getString("xa29ttext"));
			xa29t.setTag(data.getString("xa29t"));
			xa29u.setText(data.getString("xa29utext"));
			xa29u.setTag(data.getString("xa29u"));
			if (data.getString("xa29v").equals("Y"))
				xa29v.setChecked(true);
			if (data.getString("xa29w").equals("Y"))
				xa29w.setChecked(true);
			if (data.getString("xa29x").equals("Y"))
				xa29x.setChecked(true);
			if (data.getString("xa29y").equals("Y"))
				xa29y.setChecked(true);
			if (data.getString("xa29z").equals("Y"))
				xa29z.setChecked(true);
			if (data.getString("xa2a0").equals("Y"))
				xa2a0.setChecked(true);
			if (data.getString("xa2a1").equals("Y"))
				xa2a1.setChecked(true);
			if (data.getString("xa2a2").equals("Y"))
				xa2a2.setChecked(true);
			if (data.getString("xa2a3").equals("Y"))
				xa2a3.setChecked(true);
			if (data.getString("xa2a4").equals("Y"))
				xa2a4.setChecked(true);
			xa2a5.setText(data.getString("xa2a5"));
			xa2a6.setText(data.getString("xa2a6"));
			xa2a7.setText(data.getString("xa2a7"));
			xa2a7.setText(data.getString("xa2a7"));
			if (data.getString("xa2a8").equals("Y"))
				xa2a8.setChecked(true);
			if (data.getString("xa2a9").equals("Y"))
				xa2a9.setChecked(true);
			xa518a.setText(data.getString("xa518"));
			xa59sa.setText(data.getString("xa59stext"));
			xa59sa.setTag(data.getString("xa59s"));
			xa59ta.setText(data.getString("xa59t"));

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * get webservice data　(getAPQP6 =>WLCSP)
	 * 
	 * @param obj
	 */
	private void loadData6(Object obj) {

		try {
			JSONObject responeData = new JSONObject((String) obj);
			// 如果不是成功的呼叫，則返回
			if (!responeData.getString("success").equals("true")) {
				showDialog("error", responeData.getString("remark"));
				return;
			}
			JSONObject data = responeData.getJSONObject("data");
			//final String xa001 = data.getString("xa001");
			//final String xa002 = data.getString("xa002");
			btnEdit.setTag(data.getString("editable"));
			btnIssue.setTag(data.getString("issuable"));
			btnChange.setTag(data.getString("xa068"));
			xa591 = data.getString("xa591");
			xa593 = data.getString("xa593");
			if (data.getString("xa092").equals("Y"))
				wlcsp_xa092.setChecked(true);
			if (data.getString("xa087").equals("Y"))
				wlcsp_xa087.setChecked(true);
			if (data.getString("xa088").equals("Y"))
				wlcsp_xa088.setChecked(true);
			if (data.getString("xa089").equals("Y"))
				wlcsp_xa089.setChecked(true);
			if (data.getString("xa090").equals("Y"))
				wlcsp_xa090.setChecked(true);
			if (data.getString("xa093").equals("Y"))
				wlcsp_xa093.setChecked(true);
			if (data.getString("xa309").equals("Y"))
				xa309.setChecked(true);
			if (data.getString("xa310").equals("Y"))
				xa310.setChecked(true);
			if (data.getString("xa311").equals("Y"))
				xa311.setChecked(true);
			if (data.getString("xa312").equals("Y"))
				xa312.setChecked(true);
			if (data.getString("xa313").equals("Y"))
				xa313.setChecked(true);
			if (data.getString("xa315").equals("Y"))
				xa315.setChecked(true);
			if (data.getString("xa316").equals("Y"))
				xa316.setChecked(true);
			if (data.getString("xa317").equals("Y"))
				xa317.setChecked(true);
			if (data.getString("xa320").equals("Y"))
				xa320.setChecked(true);
			if (data.getString("xa321").equals("Y"))
				xa321.setChecked(true);
			if (data.getString("xa322").equals("Y"))
				xa322.setChecked(true);
			if (data.getString("xa326").equals("Y"))
				xa326.setChecked(true);
			if (data.getString("xa327").equals("Y"))
				xa327.setChecked(true);
			if (data.getString("xa328").equals("Y"))
				xa328.setChecked(true);
			if (data.getString("xa341").equals("Y"))
				xa341.setChecked(true);
			if (data.getString("xa344").equals("Y"))
				xa344.setChecked(true);
			if (data.getString("xa330").equals("Y"))
				xa330.setChecked(true);
			if (data.getString("xa346").equals("Y"))
				xa346.setChecked(true);
			if (data.getString("xa347").equals("Y"))
				xa347.setChecked(true);
			if (data.getString("xa331").equals("Y"))
				xa331.setChecked(true);
			if (data.getString("xa332").equals("Y"))
				xa332.setChecked(true);
			if (data.getString("xa334").equals("Y"))
				xa334.setChecked(true);
			if (data.getString("xa336").equals("Y"))
				xa336Y.setChecked(true);
			if (data.getString("xa336").equals("N"))
				xa336N.setChecked(true);
			if (data.getString("xa348").equals("Y"))
				xa348.setChecked(true);
			wlcsp_xa091.setText(data.getString("xa091"));
			wlcsp_xa015.setText(data.getString("xa015"));
			xa305.setText(data.getString("xa305"));
			xa306.setText(data.getString("xa306"));
			xa307.setText(data.getString("xa307"));
			xa308.setText(data.getString("xa308"));
			xa314.setText(data.getString("xa314"));
			xa318.setText(data.getString("xa318"));
			xa337.setText(data.getString("xa337"));
			xa338.setText(data.getString("xa338"));
			xa319.setText(data.getString("xa319"));
			xa339.setText(data.getString("xa339"));
			xa323.setText(data.getString("xa323text"));
			xa323.setTag(data.getString("xa323"));
			xa324.setText(data.getString("xa324"));
			xa325.setText(data.getString("xa325"));
			xa340.setText(data.getString("xa340"));
			xa342.setText(data.getString("xa342"));
			xa343.setText(data.getString("xa343"));
			xa329.setText(data.getString("xa329"));
			xa345.setText(data.getString("xa345"));
			xa333.setText(data.getString("xa333"));
			xa335.setText(data.getString("xa335"));
			/*
			 * queryData((String) getWebServiceUrl() + "getAPQPB",
			 * getAPQPB(xa001, xa002), new IDataReceiveListener() { public void
			 * onReceiveData(Object obj) { loadDataB(obj); } });
			 */
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * get webservice data　(getAPQP7 =>ATC)
	 * 
	 * @param obj
	 */
	private void loadData7(Object obj) {

		try {
			JSONObject responeData = new JSONObject((String) obj);
			// 如果不是成功的呼叫，則返回
			if (!responeData.getString("success").equals("true")) {
				showDialog("error", responeData.getString("remark"));
				return;
			}
			JSONObject data = responeData.getJSONObject("data");
			//final String xa001 = data.getString("xa001");
			//final String xa002 = data.getString("xa002");
			btnEdit.setTag(data.getString("editable"));
			btnIssue.setTag(data.getString("issuable"));
			btnChange.setTag(data.getString("xa068"));
			xa591 = data.getString("xa591");
			xa593 = data.getString("xa593");
			if (data.getString("xa092").equals("Y"))
				atc_xa092.setChecked(true);
			if (data.getString("xa087").equals("Y"))
				atc_xa087.setChecked(true);
			if (data.getString("xa088").equals("Y"))
				atc_xa088.setChecked(true);
			if (data.getString("xa089").equals("Y"))
				atc_xa089.setChecked(true);
			if (data.getString("xa090").equals("Y"))
				atc_xa090.setChecked(true);
			if (data.getString("xa093").equals("Y"))
				atc_xa093.setChecked(true);
			if (data.getString("xa439").equals("Y"))
				xa439.setChecked(true);
			if (data.getString("xa440").equals("Y"))
				xa440.setChecked(true);
			if (data.getString("xa442").equals("Y"))
				xa442.setChecked(true);
			if (data.getString("xa451").equals("Y"))
				xa451.setChecked(true);
			if (data.getString("xa452").equals("Y"))
				xa452.setChecked(true);
			if (data.getString("xa409").equals("Y"))
				xa409.setChecked(true);
			if (data.getString("xa410").equals("Y"))
				xa410.setChecked(true);
			if (data.getString("xa411").equals("Y"))
				xa411.setChecked(true);
			if (data.getString("xa412").equals("Y"))
				xa412.setChecked(true);
			if (data.getString("xa413").equals("Y"))
				xa413.setChecked(true);
			if (data.getString("xa414").equals("Y"))
				xa414.setChecked(true);
			if (data.getString("xa455").equals("Y"))
				xa455.setChecked(true);
			if (data.getString("xa456").equals("Y"))
				xa456.setChecked(true);
			if (data.getString("xa457").equals("Y"))
				xa457.setChecked(true);
			if (data.getString("xa415").equals("Y"))
				xa415.setChecked(true);
			if (data.getString("xa416").equals("Y"))
				xa416.setChecked(true);
			if (data.getString("xa417").equals("Y"))
				xa417.setChecked(true);
			if (data.getString("xa418").equals("Y"))
				xa418.setChecked(true);
			// 停用
			// if (data.getString("xa453").equals("Y"))
			// xa453.setChecked(true);
			// if (data.getString("xa454").equals("Y"))
			// xa454.setChecked(true);
			// add 150921
			if (data.getString("xa459").equals("Y"))
				xa459Y.setChecked(true);
			if (data.getString("xa459").equals("N"))
				xa459N.setChecked(true);
			xa462.setText(data.getString("xa462").replace("null", ""));
			xa463.setText(data.getString("xa463").replace("null", ""));
			xa464.setText(data.getString("xa464").replace("null", ""));
			xa465.setText(data.getString("xa465").replace("null", ""));
			xa466.setText(data.getString("xa466").replace("null", ""));
			// end of add
			if (data.getString("xa419").equals("Y"))
				xa419.setChecked(true);
			if (data.getString("xa420").equals("Y"))
				xa420.setChecked(true);
			if (data.getString("xa422").equals("Y"))
				xa422.setChecked(true);
			if (data.getString("xa425").equals("Y"))
				xa425.setChecked(true);
			if (data.getString("xa426").equals("Y"))
				xa426.setChecked(true);
			if (data.getString("xa428").equals("Y"))
				xa428.setChecked(true);
			if (data.getString("xa429").equals("Y"))
				xa429.setChecked(true);
			if (data.getString("xa430").equals("Y"))
				xa430Y.setChecked(true);
			if (data.getString("xa430").equals("Y"))
				xa430N.setChecked(true);
			if (data.getString("xa431").equals("Y"))
				xa431.setChecked(true);
			if (data.getString("xa433").equals("Y"))
				xa433.setChecked(true);
			if (data.getString("xa435").equals("Y"))
				xa435.setChecked(true);
			if (data.getString("xa437").equals("Y"))
				xa437.setChecked(true);
			atc_xa091.setText(data.getString("xa091").replace("null", ""));
			atc_xa015.setText(data.getString("xa015").replace("null", ""));
			atc_xa518.setText(data.getString("xa518").replace("null", ""));
			atc_xa518.setTag(data.getString("xa018").replace("null", ""));
			atc_xa020.setText(data.getString("xa020").replace("null", ""));
			atc_xa021.setText(data.getString("xa021").replace("null", ""));
			atc_xa022.setText(data.getString("xa022").replace("null", ""));
			atc_xa023.setText(data.getString("xa023").replace("null", ""));
			atc_xa024.setText(data.getString("xa024").replace("null", ""));
			atc_xa025.setText(data.getString("xa025").replace("null", ""));
			atc_xa019.setText(data.getString("xa019").replace("null", ""));
			xa443.setText(data.getString("xa443").replace("null", ""));
			xa404.setText(data.getString("xa404").replace("null", ""));
			xa444.setText(data.getString("xa444").replace("null", ""));
			xa445.setText(data.getString("xa445").replace("null", ""));
			xa446.setText(data.getString("xa446").replace("null", ""));
			xa405.setText(data.getString("xa405").replace("null", ""));
			xa406.setText(data.getString("xa406").replace("null", ""));
			xa407.setText(data.getString("xa407").replace("null", ""));
			xa408.setText(data.getString("xa408").replace("null", ""));
			xa421.setText(data.getString("xa421").replace("null", ""));
			xa423.setText(data.getString("xa423").replace("null", ""));
			xa424.setText(data.getString("xa424").replace("null", ""));
			xa449.setText(data.getString("xa449").replace("null", ""));
			xa450.setText(data.getString("xa450").replace("null", ""));
			xa427.setText(data.getString("xa427").replace("null", ""));
			xa432.setText(data.getString("xa432").replace("null", ""));
			xa434.setText(data.getString("xa434").replace("null", ""));
			xa436.setText(data.getString("xa436").replace("null", ""));
			xa438.setText(data.getString("xa438").replace("null", ""));
			/*
			 * queryData((String) getWebServiceUrl() + "getAPQPB",
			 * getAPQPB(xa001, xa002), new IDataReceiveListener() { public void
			 * onReceiveData(Object obj) { loadDataB(obj); } });
			 */
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * get webservice data　(getAPQP8 =>FinePitch ProbeCard)
	 * 
	 * @param obj
	 */
	private void loadData8(Object obj) {
		try {
			JSONObject responeData = new JSONObject((String) obj);
			// 如果不是成功的呼叫，則返回
			if (!responeData.getString("success").equals("true")) {
				showDialog("error", responeData.getString("remark"));
				return;
			}
			JSONObject data = responeData.getJSONObject("data");
			//final String xa001 = data.getString("xa001");
			//final String xa002 = data.getString("xa002");
			btnEdit.setTag(data.getString("editable"));
			btnIssue.setTag(data.getString("issuable"));
			btnChange.setTag(data.getString("xa068"));
			xa591 = data.getString("xa591");
			xa593 = data.getString("xa593");
			pb_xa015.setText(data.getString("xa015"));
			if (data.getString("xa087").equals("Y"))
				pb_xa087.setChecked(true);
			if (data.getString("xa088").equals("Y"))
				pb_xa088.setChecked(true);
			if (data.getString("xa090").equals("Y"))
				pb_xa090.setChecked(true);
			pb_xa091.setText(data.getString("xa091"));
			if (data.getString("xa092").equals("Y"))
				pb_xa092.setChecked(true);
			if (data.getString("xa093").equals("Y"))
				pb_xa093.setChecked(true);
			if (data.getString("xa601").equals("Y"))
				xa601.setChecked(true);
			xa602.setText(data.getString("xa602"));
			xa603.setText(data.getString("xa603"));
			xa604.setText(data.getString("xa604"));
			xa605.setText(data.getString("xa605"));
			if (data.getString("xa606").equals("Y"))
				xa606.setChecked(true);
			if (data.getString("xa607").equals("Y"))
				xa607.setChecked(true);
			if (data.getString("xa608").equals("Y"))
				xa608.setChecked(true);
			if (data.getString("xa609").equals("Y"))
				xa609.setChecked(true);
			xa610.setText(data.getString("xa610"));
			xa611.setText(data.getString("xa611"));
			xa612.setText(data.getString("xa612"));
			xa613.setText(data.getString("xa613"));
			xa614.setText(data.getString("xa614"));
			if (data.getString("xa615").equals("Y"))
				xa615.setChecked(true);
			if (data.getString("xa616").equals("Y"))
				xa616.setChecked(true);
			if (data.getString("xa617").equals("Y"))
				xa617.setChecked(true);
			if (data.getString("xa618").equals("Y"))
				xa618.setChecked(true);
			xa619.setText(data.getString("xa619"));
			xa620.setText(data.getString("xa620"));
			xa621.setText(data.getString("xa621"));
			xa622.setText(data.getString("xa622"));
			xa623.setText(data.getString("xa623"));
			if (data.getString("xa624").equals("Y"))
				xa624.setChecked(true);
			xa625.setText(data.getString("xa625"));
			if (data.getString("xa626").equals("Y"))
				xa626.setChecked(true);
			xa627.setText(data.getString("xa627"));
			if (data.getString("xa628").equals("Y"))
				xa628.setChecked(true);
			xa629.setText(data.getString("xa629"));
			xa630.setText(data.getString("xa630"));
			xa631.setText(data.getString("xa631"));
			xa632.setText(data.getString("xa632"));
			xa633.setText(data.getString("xa633"));
			if (data.getString("xa634").equals("Y"))
				xa634.setChecked(true);
			if (data.getString("xa635").equals("Y"))
				xa635.setChecked(true);
			if (data.getString("xa636").equals("Y"))
				xa636.setChecked(true);
			if (data.getString("xa637").equals("Y"))
				xa637.setChecked(true);
			if (data.getString("xa638").equals("Y"))
				xa638.setChecked(true);
			if (data.getString("xa639").equals("Y"))
				xa639.setChecked(true);
			if (data.getString("xa640").equals("Y"))
				xa640.setChecked(true);
			if (data.getString("xa641").equals("Y"))
				xa641.setChecked(true);
			if (data.getString("xa642").equals("Y"))
				xa642.setChecked(true);
			if (data.getString("xa643").equals("Y"))
				xa643.setChecked(true);
			if (data.getString("xa644").equals("Y"))
				xa644.setChecked(true);
			if (data.getString("xa645").equals("Y"))
				xa645.setChecked(true);
			if (data.getString("xa646").equals("Y"))
				xa646.setChecked(true);
			if (data.getString("xa647").equals("Y"))
				xa647.setChecked(true);
			if (data.getString("xa648").equals("Y"))
				xa648.setChecked(true);
			xa649.setText(data.getString("xa649"));
			xa650.setText(data.getString("xa650"));
			if (data.getString("xa651").equals("Y"))
				xa651.setChecked(true);
			if (data.getString("xa652").equals("Y"))
				xa652.setChecked(true);
			if (data.getString("xa653").equals("Y"))
				xa653.setChecked(true);
			if (data.getString("xa654").equals("Y"))
				xa654.setChecked(true);
			if (data.getString("xa655").equals("Y"))
				xa655.setChecked(true);
			xa656.setText(data.getString("xa656"));
			xa657.setText(data.getString("xa657"));
			if (data.getString("xa658").equals("Y"))
				xa658.setChecked(true);
			xa659.setText(data.getString("xa659"));
			if (data.getString("xa660").equals("Y"))
				xa660.setChecked(true);
			if (data.getString("xa661").equals("Y"))
				xa661.setChecked(true);
			if (data.getString("xa662").equals("Y"))
				xa662.setChecked(true);
			if (data.getString("xa663").equals("Y"))
				xa663.setChecked(true);
			if (data.getString("xa664").equals("Y"))
				xa664.setChecked(true);
			if (data.getString("xa665").equals("Y"))
				xa665Y.setChecked(true);
			if (data.getString("xa665").equals("N"))
				xa665N.setChecked(true);
			if (data.getString("xa666").equals("Y"))
				xa666.setChecked(true);
			if (data.getString("xa667").equals("Y"))
				xa667.setChecked(true);
			if (data.getString("xa668").equals("Y"))
				xa668.setChecked(true);
			if (data.getString("xa669").equals("Y"))
				xa669.setChecked(true);
			if (data.getString("xa670").equals("Y"))
				xa670.setChecked(true);
			if (data.getString("xa671").equals("Y"))
				xa671.setChecked(true);
			if (data.getString("xa672").equals("Y"))
				xa672.setChecked(true);
			xa673.setText(data.getString("xa673"));
			if (data.getString("xa674").equals("Y"))
				xa674Y.setChecked(true);
			if (data.getString("xa674").equals("N"))
				xa674N.setChecked(true);
			xa675.setText(data.getString("xa675"));
			xa676.setText(data.getString("xa676"));
			if (data.getString("xa677").equals("Y"))
				xa677.setChecked(true);
			// 150924 add
			xa00t1.setChecked(data.getString("xa00t").equals("1") ? true
					: false);
			xa00t2.setChecked(data.getString("xa00t").equals("2") ? true
					: false);
			if (data.getString("xa678").equals("Y"))
				xa678.setChecked(true);
			if (data.getString("xa679").equals("Y"))
				xa679.setChecked(true);
			if (data.getString("xa680").equals("Y"))
				xa680.setChecked(true);
			if (data.getString("xa681").equals("Y"))
				xa681.setChecked(true);
			if (data.getString("xa682").equals("Y"))
				xa682.setChecked(true);
			xa683.setText(data.getString("xa683"));
			pb_xa024.setText(data.getString("xa024"));
			/*
			 * queryData((String) getWebServiceUrl() + "getAPQPB",
			 * getAPQPB(xa001, xa002), new IDataReceiveListener() { public void
			 * onReceiveData(Object obj) { loadDataB(obj); } });
			 */
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * get webservice data　(getAPQP9 =>Changeover Kit)
	 * 
	 * @param obj
	 */
	private void loadData9(Object obj) {

		try {
			JSONObject responeData = new JSONObject((String) obj);
			// 如果不是成功的呼叫，則返回
			if (!responeData.getString("success").equals("true")) {
				showDialog("error", responeData.getString("remark"));
				return;
			}
			JSONObject data = responeData.getJSONObject("data");
			//final String xa001 = data.getString("xa001");
			//final String xa002 = data.getString("xa002");
			btnEdit.setTag(data.getString("editable"));
			btnIssue.setTag(data.getString("issuable"));
			btnChange.setTag(data.getString("xa068"));
			xa591 = data.getString("xa591");
			xa593 = data.getString("xa593");
			if (data.getString("xa092").equals("Y"))
				ck_xa092.setChecked(true);
			if (data.getString("xa093").equals("Y"))
				ck_xa093.setChecked(true);
			ck_xa015.setText(data.getString("xa015"));
			if (data.getString("xa087").equals("Y"))
				ck_xa087.setChecked(true);
			if (data.getString("xa088").equals("Y"))
				ck_xa088.setChecked(true);
			if (data.getString("xa090").equals("Y"))
				ck_xa090.setChecked(true);
			ck_xa091.setText(data.getString("xa091"));
			ck_xa518.setText(data.getString("xa518"));
			ck_xa518.setTag(data.getString("xa018"));
			ck_xa020.setText(data.getString("xa020"));
			ck_xa021.setText(data.getString("xa021"));
			ck_xa022.setText(data.getString("xa022"));
			ck_xa023.setText(data.getString("xa023"));
			ck_xa024.setText(data.getString("xa024"));
			ck_xa025.setText(data.getString("xa025"));
			ck_xa019.setText(data.getString("xa019"));
			if (data.getString("xa701").equals("Y"))
				xa701.setChecked(true);
			if (data.getString("xa702").equals("Y"))
				xa702.setChecked(true);
			if (data.getString("xa703").equals("Y"))
				xa703.setChecked(true);
			if (data.getString("xa704").equals("Y"))
				xa704.setChecked(true);
			if (data.getString("xa705").equals("Y"))
				xa705.setChecked(true);
			if (data.getString("xa706").equals("Y"))
				xa706Y.setChecked(true);
			if (data.getString("xa706").equals("N"))
				xa706N.setChecked(true);
			if (data.getString("xa707").equals("Y"))
				xa707Y.setChecked(true);
			if (data.getString("xa707").equals("N"))
				xa707N.setChecked(true);
			xa708.setText(data.getString("xa708text"));
			xa709.setText(data.getString("xa709text"));
			xa710.setText(data.getString("xa710text"));
			xa711.setText(data.getString("xa711text"));
			xa722.setText(data.getString("xa722"));
			xa723.setText(data.getString("xa723"));
			xa724.setText(data.getString("xa724"));
			xa725.setText(data.getString("xa725"));
			xa726.setText(data.getString("xa726"));
			xa708.setTag(data.getString("xa708"));
			xa709.setTag(data.getString("xa709"));
			xa710.setTag(data.getString("xa710"));
			xa711.setTag(data.getString("xa711"));
			if (data.getString("xa712").equals("Y"))
				xa712.setChecked(true);
			if (data.getString("xa713").equals("Y"))
				xa713.setChecked(true);
			if (data.getString("xa714").equals("Y"))
				xa714.setChecked(true);
			if (data.getString("xa715").equals("Y"))
				xa715.setChecked(true);
			if (data.getString("xa716").equals("Y")) {
				xa716.setChecked(true);
				xa717.setBackgroundResource(R.drawable.border);
			}
			xa717.setText(data.getString("xa717"));
			xa718.setText(data.getString("xa718"));
			xa719.setText(data.getString("xa719"));
			/*
			 * queryData((String) getWebServiceUrl() + "getAPQPB",
			 * getAPQPB(xa001, xa002), new IDataReceiveListener() { public void
			 * onReceiveData(Object obj) { loadDataB(obj); } });
			 */
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * get webservice data　(getAPQPA =>E-Flux)
	 * 
	 * @param obj
	 */
	private void loadDataA(Object obj) {

		try {
			JSONObject responeData = new JSONObject((String) obj);
			// 如果不是成功的呼叫，則返回
			if (!responeData.getString("success").equals("true")) {
				showDialog("error", responeData.getString("remark"));
				return;
			}
			JSONObject data = responeData.getJSONObject("data");
			//final String xa001 = data.getString("xa001");
			//final String xa002 = data.getString("xa002");
			btnEdit.setTag(data.getString("editable"));
			btnIssue.setTag(data.getString("issuable"));
			btnChange.setTag(data.getString("xa068"));
			xa591 = data.getString("xa591");
			xa593 = data.getString("xa593");
			ef_xa015.setText(data.getString("xa015"));
			ef_xa020.setText(data.getString("xa020"));
			ef_xa021.setText(data.getString("xa021"));
			ef_xa022.setText(data.getString("xa022"));
			ef_xa023.setText(data.getString("xa023"));
			ef_xa024.setText(data.getString("xa024"));
			ef_xa025.setText(data.getString("xa025"));
			if (data.getString("xa090").equals("Y"))
				ef_xa090.setChecked(true);
			if (data.getString("xa087").equals("Y"))
				ef_xa087.setChecked(true);
			if (data.getString("xa088").equals("Y"))
				ef_xa088.setChecked(true);
			if (data.getString("xa089").equals("Y"))
				ef_xa089.setChecked(true);
			ef_xa091.setText(data.getString("xa091"));
			if (data.getString("xa092").equals("Y"))
				ef_xa092.setChecked(true);
			if (data.getString("xa093").equals("Y"))
				ef_xa093.setChecked(true);
			ef_xa518.setText(data.getString("xa518"));
			ef_xa518.setTag(data.getString("xa018"));
			xa804.setText(data.getString("xa804"));
			xa805.setText(data.getString("xa805"));
			xa806.setText(data.getString("xa806"));
			xa807.setText(data.getString("xa807"));
			xa808.setText(data.getString("xa808"));
			if (data.getString("xa809").equals("Y"))
				xa809.setChecked(true);
			if (data.getString("xa810").equals("Y"))
				xa810.setChecked(true);
			if (data.getString("xa811").equals("Y"))
				xa811.setChecked(true);
			if (data.getString("xa813").equals("Y"))
				xa813.setChecked(true);
			if (data.getString("xa815").equals("Y"))
				xa815.setChecked(true);
			if (data.getString("xa822").equals("Y"))
				xa822.setChecked(true);
			xa824.setText(data.getString("xa824"));
			if (data.getString("xa825").equals("Y"))
				xa825.setChecked(true);
			if (data.getString("xa826").equals("Y"))
				xa826.setChecked(true);
			xa827.setText(data.getString("xa827"));
			if (data.getString("xa828").equals("Y"))
				xa828.setChecked(true);
			if (data.getString("xa829").equals("Y"))
				xa829.setChecked(true);
			if (data.getString("xa830").equals("Y"))
				xa830Y.setChecked(true);
			if (data.getString("xa830").equals("N"))
				xa830N.setChecked(true);
			if (data.getString("xa831").equals("Y"))
				xa831.setChecked(true);
			xa832.setText(data.getString("xa832"));
			if (data.getString("xa839").equals("Y"))
				xa839.setChecked(true);
			if (data.getString("xa840").equals("Y"))
				xa840.setChecked(true);
			xa841.setText(data.getString("xa841"));
			if (data.getString("xa842").equals("Y"))
				xa842.setChecked(true);
			xa843.setText(data.getString("xa843"));
			xa844.setText(data.getString("xa844"));
			xa845.setText(data.getString("xa845"));
			xa846.setText(data.getString("xa846"));
			xa849.setText(data.getString("xa849text"));
			xa849.setTag(data.getString("xa849"));
			xa850.setText(data.getString("xa850"));
			if (data.getString("xa851").equals("Y"))
				xa851.setChecked(true);
			if (data.getString("xa852").equals("Y"))
				xa852.setChecked(true);
			xa853.setText(data.getString("xa853"));
			// if value is not empty ,Load Image
			if (xa849.getTag().equals("") == false) {
				loadEFPlugImage(data.getString("xa849"));
			}
			// 150924 add
			xa856.setText(data.getString("xa856"));
			xa857.setText(data.getString("xa857"));
			xa858.setText(data.getString("xa858"));
			xa859.setText(data.getString("xa859"));
			xa860.setText(data.getString("xa860"));
			if (data.getString("xa861").equals("Y"))
				xa861.setChecked(true);
			if (data.getString("xa862").equals("Y"))
				xa862.setChecked(true);
			// end
			/*
			 * queryData((String) getWebServiceUrl() + "getAPQPB",
			 * getAPQPB(xa001, xa002), new IDataReceiveListener() { public void
			 * onReceiveData(Object obj) { loadDataB(obj); } });
			 */

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * get webservice data　(getAPQPB =>Comment)
	 * 
	 * @param obj
	 */
	private void loadDataB(Object obj) {

		try {
			JSONObject responeData = new JSONObject((String) obj);
			// 如果不是成功的呼叫，則返回
			if (!responeData.getString("success").equals("true")) {
				showDialog("error", responeData.getString("remark"));
				return;
			}
			JSONObject data = responeData.getJSONObject("data");
			//String xa001 = data.getString("xa001");
			//String xa002 = data.getString("xa002");
			btnEdit.setTag(data.getString("editable"));
			btnIssue.setTag(data.getString("issuable"));
			btnChange.setTag(data.getString("xa068"));
			xa591 = data.getString("xa591");
			xa593 = data.getString("xa593");
			xa049.setText(data.getString("xa049"));
			xa59r.setText(data.getString("xa59r"));// No.15041501

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * get webservice data　(getAPQPD =>Forecast)
	 * 
	 * @param obj
	 */
	private void loadDataD(Object obj) {

		try {
			JSONObject responeData = new JSONObject((String) obj);
			// 如果不是成功的呼叫，則返回
			if (!responeData.getString("success").equals("true")) {
				showDialog("error", responeData.getString("remark"));
				return;
			}
			JSONObject data = responeData.getJSONObject("data");
			//String xa001 = data.getString("xa001");
			//String xa002 = data.getString("xa002");
			btnEdit.setTag(data.getString("editable"));
			btnIssue.setTag(data.getString("issuable"));
			btnChange.setTag(data.getString("xa068"));
			xa591 = data.getString("xa591");
			xa593 = data.getString("xa593");
			xa59d.setText(data.getString("xa59d").replace("null", ""));
			xa59e.setText(data.getString("xa59e").replace("null", ""));
			xa59f.setText(data.getString("xa59f").replace("null", ""));
			xa59v.setText(data.getString("xa59v").replace("null", ""));
			xa00i.setText(data.getString("xa00i").replace("null", ""));
			xa59w.setText(data.getString("xa59w").replace("null", ""));
			xa59x.setText(data.getString("xa00x").replace("null", ""));
			xa00a.setText(data.getString("xa00a").replace("null", ""));
			xa00b.setText(data.getString("xa00b").replace("null", ""));
			xa00c.setText(data.getString("xa00c").replace("null", ""));
			xa00d.setText(data.getString("xa00d").replace("null", ""));
			xa00e.setText(data.getString("xa00e").replace("null", ""));
			xa00f.setText(data.getString("xa00f").replace("null", ""));
			xa00g.setText(data.getString("xa00g").replace("null", ""));
			xa00h.setText(data.getString("xa00h").replace("null", ""));
			xa59z.setText(data.getString("xa59z").replace("null", ""));
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

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

	private void loadFAEData(final View v) {
		if (mFAEUsers.size() > 0) {
			if (v != null) {
				showFAEUserDialog(v);
			}
		} else {
			JSONObject jsonObject = new JSONObject();
			JSONObject data = new JSONObject();

			try {

				data.accumulate("pickerListType", "APQPFAE");
				jsonObject.accumulate("userid", getLoginUser());
				jsonObject.accumulate("WWID",
						"13145774WWGlobal999988picklist999");
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
										mFAEUsers.add(text.getString(i));
										mFAEUsersValue.add(value.getString(i));
									}
									if (v != null) {
										showFAEUserDialog(v);
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

	private void loadEFPlugData(final View v) {
		if (mPlugType.size() > 0) {
			showPlugTypeDialog(v);

		} else {
			JSONObject jsonObject = new JSONObject();
			JSONObject data = new JSONObject();

			try {

				data.accumulate("pickerListType", "EFluxpowerplug");
				jsonObject.accumulate("userid", getLoginUser());
				jsonObject.accumulate("WWID",
						"13145774WWGlobal999988picklist999");
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
									showPlugTypeDialog(v);

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
	}

	private void loadProductsCategoryData(final View v) {
		JSONObject jsonObject = new JSONObject();
		JSONObject data = new JSONObject();

		try {
			data.accumulate("pickerListType", "XA00A");
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
								for (int i = 0; i < text.length(); i++) {
									mProductsCategory.add(text.getString(i));
								}
								if (v != null) {
									showProductsCategoryDialog(v);
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

	private void loadTestingMethodologyData(final View v) {
		JSONObject jsonObject = new JSONObject();
		JSONObject data = new JSONObject();

		try {
			data.accumulate("pickerListType", "XA00B");
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
								for (int i = 0; i < text.length(); i++) {
									mTestingMethodology.add(text.getString(i));
								}
								if (v != null) {
									showTestingMethodologyDialog(v);
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

	private void loadContactElementTypeData(final View v) {
		JSONObject jsonObject = new JSONObject();
		JSONObject data = new JSONObject();

		try {
			data.accumulate("pickerListType", "XA00C");
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
								for (int i = 0; i < text.length(); i++) {
									mContactElementType.add(text.getString(i));
								}
								if (v != null) {
									showContactElementTypeDialog(v);
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

	//
	/**
	 * Function I 初始化UI
	 * 
	 * @param view
	 */
	private void initUI(View view) {
		btnEdit = (Button) view.findViewById(R.id.btn_apqp_edit);
		btnSave = (Button) view.findViewById(R.id.btn_apqp_save);
		btnChange = (Button) view.findViewById(R.id.btn_apqp_change);
		btnConfirm = (Button) view.findViewById(R.id.btn_apqp_confirm);
		btnIssue = (Button) view.findViewById(R.id.btn_apqp_issue);
		btnEdit.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				if (btnEdit.getTag().equals("N")) {
					showDialog("Permission Denied",
							"Sorry, you don't have the permission to edit table.");
					return;
				}
				v.setVisibility(View.GONE);
				btnIssue.setVisibility(View.GONE);
				if (btnChange.getTag().equals("Y")) {
					btnChange.setVisibility(View.VISIBLE);
				} else {
					btnSave.setVisibility(View.VISIBLE);
					btnConfirm.setVisibility(View.VISIBLE);
				}
				// No.15041501
				if (tabb.getVisibility() == View.VISIBLE) {
					xa59r.setVisibility(View.VISIBLE);
				}
			}
		});

		btnIssue.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				if (btnIssue.getTag().equals("N")) {
					showDialog("Issue Denied",
							"Sorry, you can't issue this apqp");
					return;
				}
				// send issue request
				/**
				 * 溝通webservice,把資料上傳
				 */
				String[] apqpno = getApqpNo().split("-");
				if (apqpno.length <= 1)
					return;
				issueData(apqpno[0], apqpno[1]);
			}
		});


		btnSave.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				// No.15041501
				isLoading = 1;
				launchRingDialog(null);

				if (tab1.getVisibility() == View.VISIBLE) {
					saveData1("Save");

				} else if (tab2.getVisibility() == View.VISIBLE) {
					saveData2("Save");

				} else if (tab3.getVisibility() == View.VISIBLE) {
					saveData3("Save");

				} else if (tab4.getVisibility() == View.VISIBLE) {
					saveData4("Save");

				} else if (tab5.getVisibility() == View.VISIBLE) {
					saveData5("Save");

				} else if (tab6.getVisibility() == View.VISIBLE) {
					saveData6("Save");

				} else if (tab7.getVisibility() == View.VISIBLE) {
					saveData7("Save");

				} else if (tab8.getVisibility() == View.VISIBLE) {
					saveData8("Save");
				} else if (tab9.getVisibility() == View.VISIBLE) {
					saveData9("Save");

				} else if (taba.getVisibility() == View.VISIBLE) {
					saveDataA("Save");

				} else if (tabb.getVisibility() == View.VISIBLE) {
					saveDataB("Save");
					xa59r.setVisibility(View.GONE);// No.15041501

				} else if (tabd.getVisibility() == View.VISIBLE) {
					saveDataD("Save");

				}
				v.setVisibility(View.GONE);
				btnConfirm.setVisibility(View.GONE);
				btnEdit.setVisibility(View.VISIBLE);
				btnIssue.setVisibility(View.VISIBLE);

			}
		});


		btnConfirm.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				// No.15041501
				isLoading = 1;
				launchRingDialog(null);
				if (tab1.getVisibility() == View.VISIBLE) {
					saveData1("Confirm");

				} else if (tab2.getVisibility() == View.VISIBLE) {
					saveData2("Confirm");

				} else if (tab3.getVisibility() == View.VISIBLE) {
					saveData3("Confirm");

				} else if (tab4.getVisibility() == View.VISIBLE) {
					saveData4("Confirm");

				} else if (tab5.getVisibility() == View.VISIBLE) {
					saveData5("Confirm");

				} else if (tab6.getVisibility() == View.VISIBLE) {
					saveData6("Confirm");

				} else if (tab7.getVisibility() == View.VISIBLE) {
					saveData7("Confirm");

				} else if (tab8.getVisibility() == View.VISIBLE) {
					saveData8("Confirm");
				} else if (tab9.getVisibility() == View.VISIBLE) {
					saveData9("Confirm");

				} else if (taba.getVisibility() == View.VISIBLE) {
					saveDataA("Confirm");

				} else if (tabb.getVisibility() == View.VISIBLE) {
					saveDataB("Confirm");
					xa59r.setVisibility(View.GONE);// No.15041501

				} else if (tabd.getVisibility() == View.VISIBLE) {
					saveDataD("Confirm");

				}
				v.setVisibility(View.GONE);
				btnSave.setVisibility(View.GONE);
				btnEdit.setVisibility(View.VISIBLE);
				btnIssue.setVisibility(View.VISIBLE);
			}
		});

	
		btnChange.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				// No.15041501
				isLoading = 1;
				launchRingDialog(null);
				if (tab1.getVisibility() == View.VISIBLE) {
					saveData1("Change");

				} else if (tab2.getVisibility() == View.VISIBLE) {
					saveData2("Change");

				} else if (tab3.getVisibility() == View.VISIBLE) {
					saveData3("Change");

				} else if (tab4.getVisibility() == View.VISIBLE) {
					saveData4("Change");

				} else if (tab5.getVisibility() == View.VISIBLE) {
					saveData5("Change");

				} else if (tab6.getVisibility() == View.VISIBLE) {
					saveData6("Change");

				} else if (tab7.getVisibility() == View.VISIBLE) {
					saveData7("Change");

				} else if (tab8.getVisibility() == View.VISIBLE) {
					saveData8("Change");
				} else if (tab9.getVisibility() == View.VISIBLE) {
					saveData9("Change");

				} else if (taba.getVisibility() == View.VISIBLE) {
					saveDataA("Change");

				} else if (tabb.getVisibility() == View.VISIBLE) {
					saveDataB("Change");
					xa59r.setVisibility(View.GONE);// No.15041501

				} else if (tabd.getVisibility() == View.VISIBLE) {
					saveDataD("Change");

				}
				v.setVisibility(View.GONE);
				btnEdit.setVisibility(View.VISIBLE);
				btnIssue.setVisibility(View.VISIBLE);
			}
		});
		// Action bar(Back)
		Button btnReturnSale = (Button) view.findViewById(R.id.btnReturnSale);
		if (bundle != null && bundle.size() > 0 && bundle.getInt("frg_id") > 0) {
			btnReturnSale.setText(bundle.getString("return_title"));

		}
		// Action bar(Search =>Back)
		Button btnReturnApqpSearch = (Button) view
				.findViewById(R.id.btnReturnApqpSearch);


		btnReturnSale.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				if (parent != null) {
					closeFragment();
				}
			}
		});

		btnReturnApqpSearch.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				// 執行父Activity的method=>onCancelApqpClick,Add
				// APQP成功後,進入新單的詳情頁,按下回列表,需呼叫該程式
				// ((MainActivity) getActivity()).onCancelApqpClick(v);

				if (parent != null) {
					closeFragment();
				}
			}
		});

		// 判斷目前的頁面是否為搜尋結果
		if (this.parent == fragmentManager
				.findFragmentByTag("apqp_search_result")) {
			if (btnReturnSale != null)
				btnReturnSale.setVisibility(View.GONE);
			if (btnReturnApqpSearch != null) {
				btnReturnApqpSearch.setVisibility(View.VISIBLE);
				btnReturnApqpSearch.setText("Back");
			}
		}
		

	}

	private void initTab1(View view) {
		// IssueDate
		xa003 = (EditText) view.findViewById(R.id.xa003);
		// Creator, not editable
		CREATOR = (EditText) view.findViewById(R.id.CREATOR);
		// ConfirmBy ,not editable
		xa067 = (EditText) view.findViewById(R.id.xa067);
		// ConfirmDate ,not editable
		xa066 = (EditText) view.findViewById(R.id.xa066);
		// Purpose
		xa560 = (EditText) view.findViewById(R.id.xa560);
		// CS
		xa517 = (EditText) view.findViewById(R.id.xa517);
		// RFA xa595
		xa595 = (CheckBox) view.findViewById(R.id.cbxa595);
		// 24H
		xa59G = (CheckBox) view.findViewById(R.id.cbxa59G);
		// ENG
		xa59H = (CheckBox) view.findViewById(R.id.cbxa59H);
		xa59H.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				CheckBox cb = (CheckBox) v;
				// TODO Auto-generated method stub
				xa59I.setEnabled(cb.isChecked());
				if (cb.isChecked() == true) {
					// xa59I.setBackgroundColor(getActivity().getResources().getColor(R.color.white));
					xa59I.setBackgroundResource(R.drawable.border);
				} else {
					// xa59I.setBackgroundColor(R.color.lightgray);
					xa59I.setBackgroundColor(getActivity().getResources()
							.getColor(R.color.lightgray));
				}
			}
		});
		xa59I = (EditText) view.findViewById(R.id.xa59I);
		// cust no
		xa004 = (EditText) view.findViewById(R.id.xa004);
		xa004text = (EditText) view.findViewById(R.id.xa004text);
		// pid
		xa594 = (EditText) view.findViewById(R.id.xa594);
		// contact name
		xa005 = (EditText) view.findViewById(R.id.xa005);
		// phone
		xa502 = (EditText) view.findViewById(R.id.xa502);
		xa006 = (EditText) view.findViewById(R.id.xa006);
		xa007 = (EditText) view.findViewById(R.id.xa007);// ext
		// mobile
		xa008 = (EditText) view.findViewById(R.id.xa008);
		// fax
		xa503 = (EditText) view.findViewById(R.id.xa503);
		xa009 = (EditText) view.findViewById(R.id.xa009);
		// address
		xa010 = (EditText) view.findViewById(R.id.xa010);
		// email
		xa012 = (EditText) view.findViewById(R.id.xa012);
		// End Customer
		xa551 = (EditText) view.findViewById(R.id.xa551);
		xa057 = (EditText) view.findViewById(R.id.xa057);
		// Customer Region-
		xa553 = (EditText) view.findViewById(R.id.xa553);
		// Project Name
		xa058 = (EditText) view.findViewById(R.id.xa058);
		// Sale Rep
		xa053 = (EditText) view.findViewById(R.id.xa053);
		// purchase Order
		xa054 = (EditText) view.findViewById(R.id.xa054);
		// Date Receive
		xa055 = (EditText) view.findViewById(R.id.xa055);
		qt = (TableLayout) view.findViewById(R.id.qt);
		so = (TableLayout) view.findViewById(R.id.so);
		po = (TableLayout) view.findViewById(R.id.po);
		// End Customer 2
		xa00U = (EditText) view.findViewById(R.id.xa00U); // Id
		xa00Utext = (EditText) view.findViewById(R.id.xa00Utext); // Name
		// FAE 1
		xa00K = (EditText) view.findViewById(R.id.xa00K);
		// FAE2
		xa00L = (EditText) view.findViewById(R.id.xa00L);
		// OSAT
		xa59U = (EditText) view.findViewById(R.id.xa59U); // Name
		xa00R = (EditText) view.findViewById(R.id.xa00R);
		xa00S = (EditText) view.findViewById(R.id.xa00S);
		// 設定元件鍵盤
		setupTab1EditKeyboard(view);
	}

	private void initTab2(View view) {
		xa092 = (CheckBox) view.findViewById(R.id.xa092);
		xa093 = (CheckBox) view.findViewById(R.id.xa093);
		xa087 = (CheckBox) view.findViewById(R.id.xa087);
		xa088 = (CheckBox) view.findViewById(R.id.xa088);
		xa089 = (CheckBox) view.findViewById(R.id.xa089);
		xa090 = (CheckBox) view.findViewById(R.id.xa090);
		xa094 = (CheckBox) view.findViewById(R.id.xa094);
		xa584 = (CheckBox) view.findViewById(R.id.xa584);
		xa585 = (CheckBox) view.findViewById(R.id.xa585);
		xa586 = (CheckBox) view.findViewById(R.id.xa586);
		xa015 = (EditText) view.findViewById(R.id.xa015);
		xa091 = (EditText) view.findViewById(R.id.xa091);
		xa017 = (EditText) view.findViewById(R.id.xa017);
		xa016 = (EditText) view.findViewById(R.id.xa016);
		xa518 = (EditText) view.findViewById(R.id.xa518);
		xa104 = (EditText) view.findViewById(R.id.xa104);
		xa020 = (EditText) view.findViewById(R.id.xa020);
		xa021 = (EditText) view.findViewById(R.id.xa021);
		xa022 = (EditText) view.findViewById(R.id.xa022);
		xa023 = (EditText) view.findViewById(R.id.xa023);
		xa024 = (EditText) view.findViewById(R.id.xa024);
		xa025 = (EditText) view.findViewById(R.id.xa025);
		xa105 = (EditText) view.findViewById(R.id.xa105);
		xa106 = (EditText) view.findViewById(R.id.xa106);
		xa544 = (EditText) view.findViewById(R.id.xa544);
		xa028 = (CheckBox) view.findViewById(R.id.xa028);
		xa029 = (CheckBox) view.findViewById(R.id.xa029);
		xa048 = (CheckBox) view.findViewById(R.id.xa048);
		xa046 = (EditText) view.findViewById(R.id.xa046);
		xa047 = (EditText) view.findViewById(R.id.xa047);
		xa031 = (EditText) view.findViewById(R.id.xa031);
		xa130 = (EditText) view.findViewById(R.id.xa130);
		xa111 = (EditText) view.findViewById(R.id.xa111);
		xa033 = (CheckBox) view.findViewById(R.id.xa033);
		xa034 = (CheckBox) view.findViewById(R.id.xa034);
		xa598 = (CheckBox) view.findViewById(R.id.xa598);
		xa599 = (CheckBox) view.findViewById(R.id.xa599);
		xa59A = (CheckBox) view.findViewById(R.id.xa59A);
		xa035 = (CheckBox) view.findViewById(R.id.xa035);
		xa112 = (CheckBox) view.findViewById(R.id.xa112);
		xa113 = (CheckBox) view.findViewById(R.id.xa113);
		xa036Y = (CheckBox) view.findViewById(R.id.xa036Y);
		xa036N = (CheckBox) view.findViewById(R.id.xa036N);
		xa116 = (CheckBox) view.findViewById(R.id.xa116);
		xa117 = (CheckBox) view.findViewById(R.id.xa117);
		xa114 = (EditText) view.findViewById(R.id.xa114);
		xa115 = (EditText) view.findViewById(R.id.xa115);
		xa59S = (EditText) view.findViewById(R.id.xa59S);
		xa59T = (EditText) view.findViewById(R.id.xa59T);
		xa107 = (EditText) view.findViewById(R.id.xa107);
		xa108 = (EditText) view.findViewById(R.id.xa108);
		xa109 = (EditText) view.findViewById(R.id.xa109);
		xa110 = (EditText) view.findViewById(R.id.xa110);
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
	}

	private void initTab3(View view) {
		xa037 = (EditText) view.findViewById(R.id.xa037);// Handler manufacturer
		xa038 = (EditText) view.findViewById(R.id.xa038);// Handler model
		xa039 = (EditText) view.findViewById(R.id.xa039);// Tester manufacturer
		xa040 = (EditText) view.findViewById(R.id.xa040);// Tster model
		xa073 = (CheckBox) view.findViewById(R.id.xa073); // single site
		xa074 = (CheckBox) view.findViewById(R.id.xa074); // single site
		xa075 = (CheckBox) view.findViewById(R.id.xa075); // single site
		xa076 = (CheckBox) view.findViewById(R.id.xa076); // single site
		xa077 = (CheckBox) view.findViewById(R.id.xa077); // single site
		xa042 = (EditText) view.findViewById(R.id.xa042);// Other description
		xa59B = (EditText) view.findViewById(R.id.xa59B);
		xa59C = (EditText) view.findViewById(R.id.xa59C);

		xa073.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				CheckBox cb = (CheckBox) v;
				if (cb.isChecked()) {
					if (xa074.isChecked())
						xa074.setChecked(false);
					if (xa075.isChecked())
						xa075.setChecked(false);
					if (xa076.isChecked())
						xa076.setChecked(false);
					if (xa077.isChecked()) {
						xa077.setChecked(false);
						xa042.setText("");
						xa042.setBackgroundColor(getActivity().getResources()
								.getColor(R.color.lightgray));
					}
				}
			}
		});
		xa074.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				CheckBox cb = (CheckBox) v;
				if (cb.isChecked()) {
					if (xa073.isChecked())
						xa073.setChecked(false);
					if (xa075.isChecked())
						xa075.setChecked(false);
					if (xa076.isChecked())
						xa076.setChecked(false);
					if (xa077.isChecked()) {
						xa077.setChecked(false);
						xa042.setText("");
						xa042.setBackgroundColor(getActivity().getResources()
								.getColor(R.color.lightgray));
					}
				}
			}
		});
		xa075.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				CheckBox cb = (CheckBox) v;
				if (cb.isChecked()) {
					if (xa074.isChecked())
						xa074.setChecked(false);
					if (xa073.isChecked())
						xa073.setChecked(false);
					if (xa076.isChecked())
						xa076.setChecked(false);
					if (xa077.isChecked()) {
						xa077.setChecked(false);
						xa042.setText("");
						xa042.setBackgroundColor(getActivity().getResources()
								.getColor(R.color.lightgray));
					}
				}
			}
		});
		xa076.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				CheckBox cb = (CheckBox) v;
				if (cb.isChecked()) {
					if (xa074.isChecked())
						xa074.setChecked(false);
					if (xa075.isChecked())
						xa075.setChecked(false);
					if (xa073.isChecked())
						xa073.setChecked(false);
					if (xa077.isChecked()) {
						xa077.setChecked(false);
						xa042.setText("");
						xa042.setBackgroundColor(getActivity().getResources()
								.getColor(R.color.lightgray));
					}
				}
			}
		});
		xa077.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				CheckBox cb = (CheckBox) v;
				// TODO Auto-generated method stub
				xa042.setEnabled(cb.isChecked());
				if (cb.isChecked() == true) {
					xa042.setBackgroundResource(R.drawable.border);
					if (xa074.isChecked())
						xa074.setChecked(false);
					if (xa073.isChecked())
						xa073.setChecked(false);
					if (xa075.isChecked())
						xa075.setChecked(false);
					if (xa076.isChecked())
						xa076.setChecked(false);
				} else {
					xa042.setBackgroundColor(getActivity().getResources()
							.getColor(R.color.lightgray));
				}

			}
		});
		setupTab3EditKeyboard(mView);
	}

	private void initTab4(View view) {
		xa043 = (CheckBox) view.findViewById(R.id.xa043);
		xa061 = (CheckBox) view.findViewById(R.id.xa061);
		xa062 = (CheckBox) view.findViewById(R.id.xa062);
		xa044 = (CheckBox) view.findViewById(R.id.xa044);
		xa063 = (CheckBox) view.findViewById(R.id.xa063);
		xa064 = (CheckBox) view.findViewById(R.id.xa064);
		xa065 = (CheckBox) view.findViewById(R.id.xa065);
		xa097 = (CheckBox) view.findViewById(R.id.xa097);
		xa118 = (CheckBox) view.findViewById(R.id.xa118);
		xa121 = (CheckBox) view.findViewById(R.id.xa121);
		xa122 = (CheckBox) view.findViewById(R.id.xa122);
		xa124 = (CheckBox) view.findViewById(R.id.xa124);
		xa125 = (CheckBox) view.findViewById(R.id.xa125);
		xa126 = (CheckBox) view.findViewById(R.id.xa126);
		xa128 = (CheckBox) view.findViewById(R.id.xa128);
		xa129 = (CheckBox) view.findViewById(R.id.xa129);
		xa051a = (CheckBox) view.findViewById(R.id.xa051a);
		xa051b = (CheckBox) view.findViewById(R.id.xa051b);
		xa051c = (CheckBox) view.findViewById(R.id.xa051c);
		/*
		 * xa061.setEnabled(false); xa062.setEnabled(false);
		 * xa063.setEnabled(false); xa064.setEnabled(false);
		 * xa065.setEnabled(false);
		 */

		xa043.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				CheckBox cb = (CheckBox) v;
				if (cb.isChecked()) {
					// xa061.setEnabled(true);
					// xa062.setEnabled(true);
				} else {
					// xa061.setEnabled(false);
					// xa062.setEnabled(false);
					if (xa061.isChecked()) {
						xa061.setChecked(false);
					}
					if (xa062.isChecked()) {
						xa062.setChecked(false);
					}
				}
			}
		});
		xa061.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				CheckBox cb = (CheckBox) v;
				if (cb.isChecked()) {
					if (xa062.isChecked())
						xa062.setChecked(false);
				}
			}
		});
		xa062.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				CheckBox cb = (CheckBox) v;
				if (cb.isChecked()) {
					if (xa061.isChecked())
						xa061.setChecked(false);
				}
			}
		});
		xa044.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				CheckBox cb = (CheckBox) v;
				if (cb.isChecked()) {
					/*
					 * xa063.setEnabled(true); xa064.setEnabled(true);
					 * xa065.setEnabled(true);
					 */
				} else {

					if (xa063.isChecked()) {
						xa063.setChecked(false);
					}
					if (xa064.isChecked()) {
						xa064.setChecked(false);
					}
					if (xa065.isChecked()) {
						xa065.setChecked(false);
					}
				}
			}
		});
		xa063.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				CheckBox cb = (CheckBox) v;
				if (cb.isChecked()) {
					if (xa064.isChecked())
						xa064.setChecked(false);
					if (xa065.isChecked())
						xa065.setChecked(false);
				}
			}
		});
		xa064.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				CheckBox cb = (CheckBox) v;
				if (cb.isChecked()) {
					if (xa063.isChecked())
						xa063.setChecked(false);
					if (xa065.isChecked())
						xa065.setChecked(false);
				}
			}
		});
		xa065.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				CheckBox cb = (CheckBox) v;
				if (cb.isChecked()) {
					if (xa064.isChecked())
						xa064.setChecked(false);
					if (xa063.isChecked())
						xa063.setChecked(false);
				}
			}
		});
		xa051a.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				boolean checked = ((CheckBox) v).isChecked();
				if (checked && xa051b.isChecked()) {
					xa051b.setChecked(false);
				}
				if (checked && xa051c.isChecked()) {
					xa051c.setChecked(false);
				}
			}
		});
		xa051b.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				boolean checked = ((CheckBox) v).isChecked();
				if (checked && xa051a.isChecked()) {
					xa051a.setChecked(false);
				}
				if (checked && xa051c.isChecked()) {
					xa051c.setChecked(false);
				}
			}
		});
		xa051c.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				boolean checked = ((CheckBox) v).isChecked();
				if (checked && xa051b.isChecked()) {
					xa051b.setChecked(false);
				}
				if (checked && xa051a.isChecked()) {
					xa051a.setChecked(false);
				}
			}
		});
		xa124.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				CheckBox cb = (CheckBox) v;
				if (cb.isChecked()) {
					if (xa125.isChecked())
						xa125.setChecked(false);
					if (xa126.isChecked())
						xa126.setChecked(false);
				}
			}
		});
		xa125.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				CheckBox cb = (CheckBox) v;
				if (cb.isChecked()) {
					if (xa124.isChecked())
						xa124.setChecked(false);
					if (xa126.isChecked())
						xa126.setChecked(false);
				}
			}
		});
		xa126.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				CheckBox cb = (CheckBox) v;
				if (cb.isChecked()) {
					if (xa125.isChecked())
						xa125.setChecked(false);
					if (xa124.isChecked())
						xa124.setChecked(false);

				}
			}
		});
		xa102 = (EditText) view.findViewById(R.id.xa102);
		xa119 = (EditText) view.findViewById(R.id.xa119);
		xa120 = (EditText) view.findViewById(R.id.xa120);
		xa123 = (EditText) view.findViewById(R.id.xa123);
		xa050 = (EditText) view.findViewById(R.id.xa050);
		xa127 = (EditText) view.findViewById(R.id.xa127);
	}

	private void initTab5(View view) {
		// xa018=(EditText )view.findViewById(R.id.xa018);
		xa020a = (EditText) view.findViewById(R.id.xa020a);
		xa021a = (EditText) view.findViewById(R.id.xa021a);
		xa022a = (EditText) view.findViewById(R.id.xa022a);
		xa023a = (EditText) view.findViewById(R.id.xa023a);
		xa024a = (EditText) view.findViewById(R.id.xa024a);
		xa025a = (EditText) view.findViewById(R.id.xa025a);
		xa201 = (CheckBox) view.findViewById(R.id.xa201);
		xa202 = (CheckBox) view.findViewById(R.id.xa202);
		xa203 = (CheckBox) view.findViewById(R.id.xa203);
		xa204 = (CheckBox) view.findViewById(R.id.xa204);
		xa205 = (CheckBox) view.findViewById(R.id.xa205);
		xa206 = (CheckBox) view.findViewById(R.id.xa206);
		xa207 = (CheckBox) view.findViewById(R.id.xa207);
		xa208 = (CheckBox) view.findViewById(R.id.xa208);
		xa209 = (EditText) view.findViewById(R.id.xa209);
		xa210 = (CheckBox) view.findViewById(R.id.xa210);
		xa215 = (EditText) view.findViewById(R.id.xa215);
		xa216 = (CheckBox) view.findViewById(R.id.xa216);
		xa217 = (CheckBox) view.findViewById(R.id.xa217);
		xa218 = (CheckBox) view.findViewById(R.id.xa218);
		xa219 = (CheckBox) view.findViewById(R.id.xa219);
		xa220 = (EditText) view.findViewById(R.id.xa220);
		xa220 = (EditText) view.findViewById(R.id.xa220);
		xa221 = (EditText) view.findViewById(R.id.xa221);
		xa221 = (EditText) view.findViewById(R.id.xa221);
		xa222 = (CheckBox) view.findViewById(R.id.xa222);
		xa223 = (CheckBox) view.findViewById(R.id.xa223);
		xa224 = (CheckBox) view.findViewById(R.id.xa224);
		xa225 = (CheckBox) view.findViewById(R.id.xa225);
		xa226 = (CheckBox) view.findViewById(R.id.xa226);
		xa227 = (EditText) view.findViewById(R.id.xa227);
		xa227 = (EditText) view.findViewById(R.id.xa227);
		xa228 = (EditText) view.findViewById(R.id.xa228);
		xa228 = (EditText) view.findViewById(R.id.xa228);
		xa229 = (CheckBox) view.findViewById(R.id.xa229);
		xa230 = (CheckBox) view.findViewById(R.id.xa230);
		xa231 = (CheckBox) view.findViewById(R.id.xa231);
		xa232 = (CheckBox) view.findViewById(R.id.xa232);
		xa233 = (CheckBox) view.findViewById(R.id.xa233);
		xa234 = (EditText) view.findViewById(R.id.xa234);
		xa235 = (CheckBox) view.findViewById(R.id.xa235);
		xa236 = (CheckBox) view.findViewById(R.id.xa236);
		xa237 = (CheckBox) view.findViewById(R.id.xa237);
		xa238 = (CheckBox) view.findViewById(R.id.xa238);
		xa239 = (CheckBox) view.findViewById(R.id.xa239);
		xa240 = (CheckBox) view.findViewById(R.id.xa240);
		xa241 = (EditText) view.findViewById(R.id.xa241);
		xa242 = (EditText) view.findViewById(R.id.xa242);
		xa243 = (EditText) view.findViewById(R.id.xa243);
		xa244 = (EditText) view.findViewById(R.id.xa244);
		xa245 = (EditText) view.findViewById(R.id.xa245);
		xa246 = (CheckBox) view.findViewById(R.id.xa246);
		xa247 = (EditText) view.findViewById(R.id.xa247);
		xa248 = (EditText) view.findViewById(R.id.xa248);
		xa249 = (CheckBox) view.findViewById(R.id.xa249);
		xa250 = (EditText) view.findViewById(R.id.xa250);
		xa251 = (EditText) view.findViewById(R.id.xa251);
		xa252 = (CheckBox) view.findViewById(R.id.xa252);
		xa253 = (CheckBox) view.findViewById(R.id.xa253);
		xa254 = (CheckBox) view.findViewById(R.id.xa254);
		xa255 = (CheckBox) view.findViewById(R.id.xa255);
		xa256 = (CheckBox) view.findViewById(R.id.xa256);
		xa257 = (EditText) view.findViewById(R.id.xa257);
		xa258 = (CheckBox) view.findViewById(R.id.xa258);
		xa259 = (EditText) view.findViewById(R.id.xa259);
		xa260 = (CheckBox) view.findViewById(R.id.xa260);
		xa261 = (EditText) view.findViewById(R.id.xa261);
		xa262 = (CheckBox) view.findViewById(R.id.xa262);
		xa263 = (CheckBox) view.findViewById(R.id.xa263);
		xa264 = (CheckBox) view.findViewById(R.id.xa264);
		xa265 = (CheckBox) view.findViewById(R.id.xa265);
		xa266 = (CheckBox) view.findViewById(R.id.xa266);
		xa267 = (CheckBox) view.findViewById(R.id.xa267);
		xa268 = (EditText) view.findViewById(R.id.xa268);
		xa276 = (EditText) view.findViewById(R.id.xa276);
		xa277 = (EditText) view.findViewById(R.id.xa277);
		xa278 = (EditText) view.findViewById(R.id.xa278);
		xa279 = (CheckBox) view.findViewById(R.id.xa279);
		xa280 = (EditText) view.findViewById(R.id.xa280);
		xa280 = (EditText) view.findViewById(R.id.xa280);
		xa282 = (EditText) view.findViewById(R.id.xa282);
		xa289 = (CheckBox) view.findViewById(R.id.xa289);
		xa292 = (CheckBox) view.findViewById(R.id.xa292);
		xa293 = (CheckBox) view.findViewById(R.id.xa293);
		xa294 = (CheckBox) view.findViewById(R.id.xa294);
		xa295 = (CheckBox) view.findViewById(R.id.xa295);
		xa296 = (EditText) view.findViewById(R.id.xa296);
		xa29dY = (CheckBox) view.findViewById(R.id.xa29DY);
		xa29dN = (CheckBox) view.findViewById(R.id.xa29DN);
		xa29k = (EditText) view.findViewById(R.id.xa29K);
		xa29l = (EditText) view.findViewById(R.id.xa29L);
		xa29m = (EditText) view.findViewById(R.id.xa29M);
		xa29n = (EditText) view.findViewById(R.id.xa29N);
		xa29p = (EditText) view.findViewById(R.id.xa29P);
		xa29q = (EditText) view.findViewById(R.id.xa29Q);
		// xa29q=(EditText )view.findViewById(R.id.xa29q);
		xa29r = (EditText) view.findViewById(R.id.xa29R);
		// xa29r=(EditText )view.findViewById(R.id.xa29r);
		xa29s = (EditText) view.findViewById(R.id.xa29S);
		// xa29s=(EditText )view.findViewById(R.id.xa29s);
		xa29t = (EditText) view.findViewById(R.id.xa29T);
		// xa29t=(EditText )view.findViewById(R.id.xa29t);
		xa29u = (EditText) view.findViewById(R.id.xa29U);
		// xa29u=(EditText )view.findViewById(R.id.xa29u);
		xa29v = (CheckBox) view.findViewById(R.id.xa29V);
		xa29w = (CheckBox) view.findViewById(R.id.xa29W);
		xa29x = (CheckBox) view.findViewById(R.id.xa29X);
		xa29y = (CheckBox) view.findViewById(R.id.xa29Y);
		xa29z = (CheckBox) view.findViewById(R.id.xa29Z);
		xa2a0 = (CheckBox) view.findViewById(R.id.xa2A0);
		xa2a1 = (CheckBox) view.findViewById(R.id.xa2A1);
		xa2a2 = (CheckBox) view.findViewById(R.id.xa2A2);
		xa2a3 = (CheckBox) view.findViewById(R.id.xa2A3);
		xa2a4 = (CheckBox) view.findViewById(R.id.xa2A4);
		xa2a5 = (EditText) view.findViewById(R.id.xa2A5);
		xa2a6 = (EditText) view.findViewById(R.id.xa2A6);
		xa2a7 = (EditText) view.findViewById(R.id.xa2A7);
		xa2a7 = (EditText) view.findViewById(R.id.xa2A7);
		xa2a8 = (CheckBox) view.findViewById(R.id.xa2A8);
		xa2a9 = (CheckBox) view.findViewById(R.id.xa2A9);
		xa518a = (EditText) view.findViewById(R.id.xa518a);
		xa59sa = (EditText) view.findViewById(R.id.xa59Sa);
		xa59ta = (EditText) view.findViewById(R.id.xa59Ta);

		xa201.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				boolean checked = ((CheckBox) v).isChecked();
				if (checked) {
					xa202.setEnabled(true);
					xa203.setEnabled(true);
				} else {
					xa202.setChecked(false);
					xa203.setChecked(false);
					xa202.setEnabled(false);
					xa203.setEnabled(false);
				}

			}
		});
		xa204.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				boolean checked = ((CheckBox) v).isChecked();
				if (checked) {
					xa205.setEnabled(true);
					xa206.setEnabled(true);
					xa207.setEnabled(true);
				} else {
					xa205.setChecked(false);
					xa206.setChecked(false);
					xa207.setChecked(false);
					xa205.setEnabled(false);
					xa206.setEnabled(false);
					xa207.setEnabled(false);
				}

			}
		});
		xa216.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				CheckBox cb = (CheckBox) v;
				if (cb.isChecked()) {
					xa217.setChecked(false);
					xa218.setChecked(false);
					xa219.setChecked(false);
					xa220.setText("");
					xa220.setTag("");
				}

			}
		});
		xa217.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				CheckBox cb = (CheckBox) v;
				if (cb.isChecked()) {
					xa216.setChecked(false);
					xa218.setChecked(false);
					xa219.setChecked(false);
					xa220.setText("");
					xa220.setTag("");
				}

			}
		});
		xa218.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				CheckBox cb = (CheckBox) v;
				if (cb.isChecked()) {
					xa217.setChecked(false);
					xa216.setChecked(false);
					xa219.setChecked(false);
					xa220.setText("");
					xa220.setTag("");
				}

			}
		});
		xa219.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				CheckBox cb = (CheckBox) v;
				if (cb.isChecked()) {
					xa217.setChecked(false);
					xa218.setChecked(false);
					xa216.setChecked(false);
				} else {
					xa220.setText("");
					xa220.setTag("");
				}

			}
		});
		xa222.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				CheckBox cb = (CheckBox) v;
				if (cb.isChecked()) {
					xa223.setChecked(false);
					xa224.setChecked(false);
					xa225.setChecked(false);
					xa226.setChecked(false);
					xa227.setText("");
					xa227.setTag("");
				}

			}
		});
		xa223.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				CheckBox cb = (CheckBox) v;
				if (cb.isChecked()) {
					xa222.setChecked(false);
					xa224.setChecked(false);
					xa225.setChecked(false);
					xa226.setChecked(false);
					xa227.setText("");
					xa227.setTag("");
				}

			}
		});
		xa224.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				CheckBox cb = (CheckBox) v;
				if (cb.isChecked()) {
					xa223.setChecked(false);
					xa222.setChecked(false);
					xa225.setChecked(false);
					xa226.setChecked(false);
					xa227.setText("");
					xa227.setTag("");
				}

			}
		});
		xa225.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				CheckBox cb = (CheckBox) v;
				if (cb.isChecked()) {
					xa223.setChecked(false);
					xa222.setChecked(false);
					xa226.setChecked(false);
					xa224.setChecked(false);
					xa227.setText("");
					xa227.setTag("");
				}

			}
		});
		xa226.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				CheckBox cb = (CheckBox) v;
				if (cb.isChecked()) {
					xa223.setChecked(false);
					xa224.setChecked(false);
					xa225.setChecked(false);
					xa222.setChecked(false);

				} else {
					xa227.setText("");
					xa227.setTag("");
				}

			}
		});
		xa229.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				CheckBox cb = (CheckBox) v;
				if (cb.isChecked()) {
					xa230.setChecked(false);
					xa231.setChecked(false);
					xa232.setChecked(false);
					xa233.setChecked(false);
					xa234.setText("");
					xa234.setTag("");
					xa234.setBackgroundColor(getActivity().getResources()
							.getColor(R.color.lightgray));
				}

			}
		});
		xa230.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				CheckBox cb = (CheckBox) v;
				if (cb.isChecked()) {
					xa230.setChecked(false);
					xa231.setChecked(false);
					xa232.setChecked(false);
					xa233.setChecked(false);
					xa234.setText("");
					xa234.setTag("");
					xa234.setBackgroundColor(getActivity().getResources()
							.getColor(R.color.lightgray));
				}

			}
		});
		xa231.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				CheckBox cb = (CheckBox) v;
				if (cb.isChecked()) {
					xa230.setChecked(false);
					xa229.setChecked(false);
					xa232.setChecked(false);
					xa233.setChecked(false);
					xa234.setText("");
					xa234.setTag("");
					xa234.setBackgroundColor(getActivity().getResources()
							.getColor(R.color.lightgray));
				}

			}
		});
		xa232.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				CheckBox cb = (CheckBox) v;
				if (cb.isChecked()) {
					xa230.setChecked(false);
					xa231.setChecked(false);
					xa229.setChecked(false);
					xa233.setChecked(false);
					xa234.setText("");
					xa234.setTag("");
					xa234.setBackgroundColor(getActivity().getResources()
							.getColor(R.color.lightgray));
				}

			}
		});
		xa233.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				CheckBox cb = (CheckBox) v;
				if (cb.isChecked()) {
					xa230.setChecked(false);
					xa231.setChecked(false);
					xa232.setChecked(false);
					xa229.setChecked(false);
					xa234.setBackgroundColor(Color.WHITE);

				} else {
					xa234.setText("");
					xa234.setTag("");
					xa234.setBackgroundColor(getActivity().getResources()
							.getColor(R.color.lightgray));
				}

			}
		});
		xa237.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				boolean checked = ((CheckBox) v).isChecked();
				if (checked) {

				} else {
					xa238.setChecked(false);
					xa239.setChecked(false);
					xa240.setChecked(false);
					xa241.setText("");
				}

			}
		});
		xa238.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				CheckBox cb = (CheckBox) v;
				if (cb.isChecked()) {
					if (xa239.isChecked())
						xa239.setChecked(false);
					if (xa240.isChecked()) {
						xa240.setChecked(false);
						xa241.setText("");
					}
				}
			}
		});
		xa239.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				CheckBox cb = (CheckBox) v;
				if (cb.isChecked()) {
					if (xa238.isChecked())
						xa238.setChecked(false);
					if (xa240.isChecked()) {
						xa240.setChecked(false);
						xa241.setText("");
					}
				}
			}
		});
		xa240.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				CheckBox cb = (CheckBox) v;
				if (cb.isChecked()) {
					if (xa238.isChecked())
						xa238.setChecked(false);
					if (xa239.isChecked())
						xa239.setChecked(false);

				} else {
					xa241.setText("");
				}
			}
		});
		xa246.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				CheckBox cb = (CheckBox) v;
				if (cb.isChecked()) {
					xa247.setEnabled(true);
					xa248.setEnabled(true);

				} else {
					xa247.setEnabled(false);
					xa248.setEnabled(false);
					xa247.setText("");
					xa248.setText("");
				}
			}
		});
		xa249.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				CheckBox cb = (CheckBox) v;
				if (cb.isChecked()) {
					/*
					 * xa250.setEnabled(true); xa251.setEnabled(true);
					 * xa252.setEnabled(true); xa253.setEnabled(true);
					 * xa254.setEnabled(true); xa255.setEnabled(true);
					 * xa256.setEnabled(true); xa257.setEnabled(true);
					 * xa258.setEnabled(true); xa259.setEnabled(true);
					 */

				} else {
					// xa250.setEnabled(false);
					// xa251.setEnabled(false);
					xa250.setText("");
					xa251.setText("");
					/*
					 * xa250.setEnabled(false); xa251.setEnabled(false);
					 * xa252.setEnabled(false); xa253.setEnabled(false);
					 * xa254.setEnabled(false); xa255.setEnabled(false);
					 * xa256.setEnabled(false); xa257.setEnabled(false);
					 */
					xa257.setText("");
					/*
					 * xa258.setEnabled(false); xa259.setEnabled(false);
					 */
					xa259.setText("");
				}
			}
		});
		xa252.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				CheckBox cb = (CheckBox) v;
				if (cb.isChecked()) {
					xa253.setChecked(false);
					xa254.setChecked(false);
					xa255.setChecked(false);
					xa256.setChecked(false);
					xa257.setText("");
					xa258.setChecked(false);
					xa259.setText("");
				}
			}
		});
		xa253.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				CheckBox cb = (CheckBox) v;
				if (cb.isChecked()) {
					xa252.setChecked(false);
					xa254.setChecked(false);
					xa255.setChecked(false);
					xa256.setChecked(false);
					xa257.setText("");
					xa258.setChecked(false);
					xa259.setText("");
				}
			}
		});
		xa254.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				CheckBox cb = (CheckBox) v;
				if (cb.isChecked()) {
					xa253.setChecked(false);
					xa252.setChecked(false);
					xa255.setChecked(false);
					xa256.setChecked(false);
					xa257.setText("");
					xa258.setChecked(false);
					xa259.setText("");
				}
			}
		});
		xa255.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				CheckBox cb = (CheckBox) v;
				if (cb.isChecked()) {
					xa253.setChecked(false);
					xa254.setChecked(false);
					xa252.setChecked(false);
					xa256.setChecked(false);
					xa257.setText("");
					xa258.setChecked(false);
					xa259.setText("");
				}
			}
		});
		xa256.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				CheckBox cb = (CheckBox) v;
				if (cb.isChecked()) {
					xa253.setChecked(false);
					xa254.setChecked(false);
					xa255.setChecked(false);
					xa252.setChecked(false);
					// xa257.setText("");
					xa258.setChecked(false);
					xa259.setText("");
				} else {
					xa257.setText("");
				}
			}
		});
		xa258.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				CheckBox cb = (CheckBox) v;
				if (cb.isChecked()) {
					xa253.setChecked(false);
					xa254.setChecked(false);
					xa255.setChecked(false);
					xa256.setChecked(false);
					xa257.setText("");
					xa252.setChecked(false);
				} else {
					xa259.setText("");

				}
			}
		});
		/*
		 * xa29z.setEnabled(false); xa2a0.setEnabled(false);
		 * xa2a1.setEnabled(false);
		 */
		xa29y.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				boolean checked = ((CheckBox) v).isChecked();
				if (checked) {
					/*
					 * xa29z.setEnabled(true); xa2A0.setEnabled(true);
					 * xa2A1.setEnabled(true);
					 */
				} else {
					xa29z.setChecked(false);
					xa2a0.setChecked(false);
					xa2a1.setChecked(false);
					/*
					 * xa29z.setEnabled(false); xa2A0.setEnabled(false);
					 * xa2A1.setEnabled(false);
					 */
				}

			}
		});
		xa29dY.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				boolean checked = ((CheckBox) v).isChecked();
				if (checked && xa29dN.isChecked()) {
					xa29dN.setChecked(false);
				}

			}
		});
		xa29dN.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				boolean checked = ((CheckBox) v).isChecked();
				if (checked && xa29dY.isChecked()) {
					xa29dY.setChecked(false);
				}
			}
		});
		xa292.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				CheckBox cb = (CheckBox) v;
				if (cb.isChecked()) {
					xa293.setChecked(false);
					xa294.setChecked(false);
					xa295.setChecked(false);
					xa296.setText("");
				}
			}
		});
		xa293.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				CheckBox cb = (CheckBox) v;
				if (cb.isChecked()) {
					xa292.setChecked(false);
					xa294.setChecked(false);
					xa295.setChecked(false);
					xa296.setText("");
				}
			}
		});
		xa294.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				CheckBox cb = (CheckBox) v;
				if (cb.isChecked()) {
					xa293.setChecked(false);
					xa292.setChecked(false);
					xa295.setChecked(false);
					xa296.setText("");
				}
			}
		});
		xa295.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				CheckBox cb = (CheckBox) v;
				if (cb.isChecked()) {
					xa293.setChecked(false);
					xa294.setChecked(false);
					xa292.setChecked(false);
				} else {
					xa296.setText("");
				}
			}
		});

		setupTab5EditKeyboard(mView);
	}

	private void initTab6(View view) {
		wlcsp_xa092 = (CheckBox) view.findViewById(R.id.wlcsp_xa092);
		wlcsp_xa087 = (CheckBox) view.findViewById(R.id.wlcsp_xa087);
		wlcsp_xa088 = (CheckBox) view.findViewById(R.id.wlcsp_xa088);
		wlcsp_xa089 = (CheckBox) view.findViewById(R.id.wlcsp_xa089);
		wlcsp_xa090 = (CheckBox) view.findViewById(R.id.wlcsp_xa090);
		wlcsp_xa093 = (CheckBox) view.findViewById(R.id.wlcsp_xa093);
		xa309 = (CheckBox) view.findViewById(R.id.xa309);
		xa310 = (CheckBox) view.findViewById(R.id.xa310);
		xa311 = (CheckBox) view.findViewById(R.id.xa311);
		xa312 = (CheckBox) view.findViewById(R.id.xa312);
		xa313 = (CheckBox) view.findViewById(R.id.xa313);
		xa315 = (CheckBox) view.findViewById(R.id.xa315);
		xa316 = (CheckBox) view.findViewById(R.id.xa316);
		xa317 = (CheckBox) view.findViewById(R.id.xa317);
		xa320 = (CheckBox) view.findViewById(R.id.xa320);
		xa321 = (CheckBox) view.findViewById(R.id.xa321);
		xa322 = (CheckBox) view.findViewById(R.id.xa322);
		xa326 = (CheckBox) view.findViewById(R.id.xa326);
		xa327 = (CheckBox) view.findViewById(R.id.xa327);
		xa328 = (CheckBox) view.findViewById(R.id.xa328);
		xa341 = (CheckBox) view.findViewById(R.id.xa341);
		xa344 = (CheckBox) view.findViewById(R.id.xa344);
		xa330 = (CheckBox) view.findViewById(R.id.xa330);
		xa346 = (CheckBox) view.findViewById(R.id.xa346);
		xa347 = (CheckBox) view.findViewById(R.id.xa347);
		xa348 = (CheckBox) view.findViewById(R.id.xa348);
		xa331 = (CheckBox) view.findViewById(R.id.xa331);
		xa332 = (CheckBox) view.findViewById(R.id.xa332);
		xa334 = (CheckBox) view.findViewById(R.id.xa334);
		xa336Y = (CheckBox) view.findViewById(R.id.xa336Y);
		xa336N = (CheckBox) view.findViewById(R.id.xa336N);

		wlcsp_xa091 = (EditText) view.findViewById(R.id.xa091);
		wlcsp_xa015 = (EditText) view.findViewById(R.id.wlcsp_xa015);
		xa305 = (EditText) view.findViewById(R.id.xa305);
		xa306 = (EditText) view.findViewById(R.id.xa306);
		xa307 = (EditText) view.findViewById(R.id.xa307);
		xa308 = (EditText) view.findViewById(R.id.xa308);
		xa314 = (EditText) view.findViewById(R.id.xa314);
		xa318 = (EditText) view.findViewById(R.id.xa318);
		xa337 = (EditText) view.findViewById(R.id.xa337);
		xa338 = (EditText) view.findViewById(R.id.xa338);
		xa319 = (EditText) view.findViewById(R.id.xa319);
		xa339 = (EditText) view.findViewById(R.id.xa339);
		xa323 = (EditText) view.findViewById(R.id.xa323);
		xa324 = (EditText) view.findViewById(R.id.xa324);
		xa325 = (EditText) view.findViewById(R.id.xa325);
		xa340 = (EditText) view.findViewById(R.id.xa340);
		xa342 = (EditText) view.findViewById(R.id.xa342);
		xa343 = (EditText) view.findViewById(R.id.xa343);
		xa329 = (EditText) view.findViewById(R.id.xa329);
		xa345 = (EditText) view.findViewById(R.id.xa345);
		xa333 = (EditText) view.findViewById(R.id.xa333);
		xa335 = (EditText) view.findViewById(R.id.xa335);
		xa309.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				CheckBox cb = (CheckBox) v;
				if (cb.isChecked()) {
					xa310.setChecked(false);
					xa311.setChecked(false);
					xa312.setChecked(false);
					xa313.setChecked(false);
					xa314.setText("");
					xa314.setBackgroundColor(getActivity().getResources()
							.getColor(R.color.lightgray));
				}
			}
		});
		xa310.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				CheckBox cb = (CheckBox) v;
				if (cb.isChecked()) {
					xa309.setChecked(false);
					xa311.setChecked(false);
					xa312.setChecked(false);
					xa313.setChecked(false);
					xa314.setText("");
					xa314.setBackgroundColor(getActivity().getResources()
							.getColor(R.color.lightgray));
				}
			}
		});
		xa311.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				CheckBox cb = (CheckBox) v;
				if (cb.isChecked()) {
					xa310.setChecked(false);
					xa309.setChecked(false);
					xa312.setChecked(false);
					xa313.setChecked(false);
					xa314.setText("");
					xa314.setBackgroundColor(getActivity().getResources()
							.getColor(R.color.lightgray));
				}
			}
		});
		xa312.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				CheckBox cb = (CheckBox) v;
				if (cb.isChecked()) {
					xa310.setChecked(false);
					xa311.setChecked(false);
					xa309.setChecked(false);
					xa313.setChecked(false);
					xa314.setText("");
					xa314.setBackgroundColor(getActivity().getResources()
							.getColor(R.color.lightgray));
				}
			}
		});
		xa313.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				CheckBox cb = (CheckBox) v;
				if (cb.isChecked()) {
					xa310.setChecked(false);
					xa311.setChecked(false);
					xa312.setChecked(false);
					xa309.setChecked(false);
					xa314.setBackgroundColor(Color.WHITE);

				} else {
					xa314.setText("");
					xa314.setBackgroundColor(getActivity().getResources()
							.getColor(R.color.lightgray));
				}
			}
		});
		xa315.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				CheckBox cb = (CheckBox) v;
				if (cb.isChecked()) {
					xa316.setChecked(false);
					xa317.setChecked(false);
					xa318.setText("");
					xa318.setBackgroundColor(getActivity().getResources()
							.getColor(R.color.lightgray));
				}
			}
		});
		xa316.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				CheckBox cb = (CheckBox) v;
				if (cb.isChecked()) {
					xa315.setChecked(false);
					xa317.setChecked(false);
					xa318.setText("");
					xa318.setBackgroundColor(getActivity().getResources()
							.getColor(R.color.lightgray));
				}
			}
		});
		xa317.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				CheckBox cb = (CheckBox) v;
				if (cb.isChecked()) {
					xa315.setChecked(false);
					xa317.setChecked(false);
					xa318.setBackgroundColor(Color.WHITE);
				} else {
					xa318.setText("");
					xa318.setBackgroundColor(getActivity().getResources()
							.getColor(R.color.lightgray));
				}
			}
		});
		xa336Y.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				boolean checked = ((CheckBox) v).isChecked();
				if (checked && xa336N.isChecked()) {
					xa336N.setChecked(false);
				}

			}
		});
		xa336N.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				boolean checked = ((CheckBox) v).isChecked();
				if (checked && xa336Y.isChecked()) {
					xa336Y.setChecked(false);
				}
			}
		});
		setupTab6EditKeyboard(mView);
	}

	private void initTab7(View view) {
		atc_xa092 = (CheckBox) view.findViewById(R.id.atc_xa092);
		atc_xa087 = (CheckBox) view.findViewById(R.id.atc_xa087);
		atc_xa088 = (CheckBox) view.findViewById(R.id.atc_xa088);
		atc_xa089 = (CheckBox) view.findViewById(R.id.atc_xa089);
		atc_xa090 = (CheckBox) view.findViewById(R.id.atc_xa090);
		atc_xa093 = (CheckBox) view.findViewById(R.id.atc_xa093);
		xa439 = (CheckBox) view.findViewById(R.id.xa439);
		xa440 = (CheckBox) view.findViewById(R.id.xa440);
		xa442 = (CheckBox) view.findViewById(R.id.xa442);
		xa451 = (CheckBox) view.findViewById(R.id.xa451);
		xa452 = (CheckBox) view.findViewById(R.id.xa452);
		xa409 = (CheckBox) view.findViewById(R.id.xa409);
		xa410 = (CheckBox) view.findViewById(R.id.xa410);
		xa411 = (CheckBox) view.findViewById(R.id.xa411);
		xa412 = (CheckBox) view.findViewById(R.id.xa412);
		xa413 = (CheckBox) view.findViewById(R.id.xa413);
		xa414 = (CheckBox) view.findViewById(R.id.xa414);
		xa455 = (CheckBox) view.findViewById(R.id.xa455);
		xa456 = (CheckBox) view.findViewById(R.id.xa456);
		xa457 = (CheckBox) view.findViewById(R.id.xa457);
		xa415 = (CheckBox) view.findViewById(R.id.xa415);
		xa416 = (CheckBox) view.findViewById(R.id.xa416);
		xa417 = (CheckBox) view.findViewById(R.id.xa417);
		xa418 = (CheckBox) view.findViewById(R.id.xa418);
		// 停用
		// xa453 = (CheckBox) view.findViewById(R.id.xa453);
		// xa454 = (CheckBox) view.findViewById(R.id.xa454);
		// add 150921
		xa459Y = (CheckBox) view.findViewById(R.id.xa459Y);
		xa459N = (CheckBox) view.findViewById(R.id.xa459N);
		xa462 = (EditText) view.findViewById(R.id.xa462);
		xa463 = (EditText) view.findViewById(R.id.xa463);
		xa464 = (EditText) view.findViewById(R.id.xa464);
		xa465 = (EditText) view.findViewById(R.id.xa465);
		xa466 = (EditText) view.findViewById(R.id.xa466);
		// end of add
		xa419 = (CheckBox) view.findViewById(R.id.xa419);
		xa420 = (CheckBox) view.findViewById(R.id.xa420);
		xa422 = (CheckBox) view.findViewById(R.id.xa422);
		xa425 = (CheckBox) view.findViewById(R.id.xa425);
		xa426 = (CheckBox) view.findViewById(R.id.xa426);
		xa428 = (CheckBox) view.findViewById(R.id.xa428);
		xa429 = (CheckBox) view.findViewById(R.id.xa429);
		xa430Y = (CheckBox) view.findViewById(R.id.xa430Y);
		xa430N = (CheckBox) view.findViewById(R.id.xa430N);
		xa458Y = (CheckBox) view.findViewById(R.id.xa430Y);
		xa458N = (CheckBox) view.findViewById(R.id.xa430N);
		xa431 = (CheckBox) view.findViewById(R.id.xa431);
		xa433 = (CheckBox) view.findViewById(R.id.xa433);
		xa435 = (CheckBox) view.findViewById(R.id.xa435);
		xa437 = (CheckBox) view.findViewById(R.id.xa437);
		xa447 = (CheckBox) view.findViewById(R.id.xa447);
		xa448 = (CheckBox) view.findViewById(R.id.xa448);
		atc_xa091 = (EditText) view.findViewById(R.id.atc_xa091);
		atc_xa015 = (EditText) view.findViewById(R.id.atc_xa015);
		atc_xa518 = (EditText) view.findViewById(R.id.atc_xa518);
		atc_xa020 = (EditText) view.findViewById(R.id.atc_xa020);
		atc_xa021 = (EditText) view.findViewById(R.id.atc_xa021);
		atc_xa022 = (EditText) view.findViewById(R.id.atc_xa022);
		atc_xa023 = (EditText) view.findViewById(R.id.atc_xa023);
		atc_xa024 = (EditText) view.findViewById(R.id.atc_xa024);
		atc_xa025 = (EditText) view.findViewById(R.id.atc_xa025);
		atc_xa019 = (EditText) view.findViewById(R.id.atc_xa019);
		xa441 = (EditText) view.findViewById(R.id.xa443);
		xa443 = (EditText) view.findViewById(R.id.xa443);
		xa404 = (EditText) view.findViewById(R.id.xa404);
		xa444 = (EditText) view.findViewById(R.id.xa444);
		xa445 = (EditText) view.findViewById(R.id.xa445);
		xa446 = (EditText) view.findViewById(R.id.xa446);
		xa405 = (EditText) view.findViewById(R.id.xa405);
		xa406 = (EditText) view.findViewById(R.id.xa406);
		xa407 = (EditText) view.findViewById(R.id.xa407);
		xa408 = (EditText) view.findViewById(R.id.xa408);
		xa421 = (EditText) view.findViewById(R.id.xa421);
		xa423 = (EditText) view.findViewById(R.id.xa423);
		xa424 = (EditText) view.findViewById(R.id.xa424);
		xa449 = (EditText) view.findViewById(R.id.xa449);
		xa450 = (EditText) view.findViewById(R.id.xa450);
		xa427 = (EditText) view.findViewById(R.id.xa427);
		xa432 = (EditText) view.findViewById(R.id.xa432);
		xa434 = (EditText) view.findViewById(R.id.xa434);
		xa436 = (EditText) view.findViewById(R.id.xa436);
		xa438 = (EditText) view.findViewById(R.id.xa438);
		xa416.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				boolean checked = ((CheckBox) v).isChecked();
				if (checked) {
					xa417.setChecked(false);
					xa418.setChecked(false);
				}
			}
		});
		xa417.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				boolean checked = ((CheckBox) v).isChecked();
				if (checked) {
					xa416.setChecked(false);
					xa418.setChecked(false);
				}
			}
		});
		xa418.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				boolean checked = ((CheckBox) v).isChecked();
				if (checked) {
					xa417.setChecked(false);
					xa416.setChecked(false);
				}
			}
		});
		/*
		 * 停用 xa453.setOnClickListener(new OnClickListener() {
		 * 
		 * @Override public void onClick(View v) {
		 * 
		 * boolean checked = ((CheckBox) v).isChecked(); if (checked) {
		 * xa454.setChecked(false);
		 * 
		 * } } }); xa454.setOnClickListener(new OnClickListener() {
		 * 
		 * @Override public void onClick(View v) {
		 * 
		 * boolean checked = ((CheckBox) v).isChecked(); if (checked) {
		 * 
		 * xa420.setChecked(false); } } });
		 */
		xa419.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				boolean checked = ((CheckBox) v).isChecked();
				if (checked) {
					xa420.setChecked(false);

				}
			}
		});
		xa420.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				boolean checked = ((CheckBox) v).isChecked();
				if (checked) {
					xa419.setChecked(false);
				}
			}
		});
		xa447.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				boolean checked = ((CheckBox) v).isChecked();
				if (checked) {
					xa448.setChecked(false);

				}
			}
		});
		xa448.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				boolean checked = ((CheckBox) v).isChecked();
				if (checked) {
					xa447.setChecked(false);
				}
			}
		});
		xa430Y.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				boolean checked = ((CheckBox) v).isChecked();
				if (checked && xa430N.isChecked()) {
					xa430N.setChecked(false);
				}
			}
		});
		xa430N.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				boolean checked = ((CheckBox) v).isChecked();
				if (checked && xa430Y.isChecked()) {
					xa430Y.setChecked(false);
				}
			}
		});
		xa458Y.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				boolean checked = ((CheckBox) v).isChecked();
				if (checked && xa458N.isChecked()) {
					xa458N.setChecked(false);
				}
			}
		});
		xa458N.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				boolean checked = ((CheckBox) v).isChecked();
				if (checked && xa458Y.isChecked()) {
					xa458Y.setChecked(false);
				}
			}
		});
		xa431.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				boolean checked = ((CheckBox) v).isChecked();
				if (checked) {
					xa432.setEnabled(true);
				} else {
					xa432.setText("");
					xa432.setEnabled(false);
				}
			}
		});
		xa433.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				boolean checked = ((CheckBox) v).isChecked();
				if (checked) {
					xa434.setEnabled(true);
				} else {
					xa434.setText("");
					xa434.setEnabled(false);
				}
			}
		});
		xa435.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				boolean checked = ((CheckBox) v).isChecked();
				if (checked) {
					xa436.setEnabled(true);
				} else {
					xa436.setText("");
					xa436.setEnabled(false);
				}
			}
		});
		xa437.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				boolean checked = ((CheckBox) v).isChecked();
				if (checked) {
					xa438.setEnabled(true);
				} else {
					xa438.setText("");
					xa438.setEnabled(false);
				}
			}
		});
		btnLoadPackageInfo17 = (Button) view
				.findViewById(R.id.btnLoadPackageInfo17);
		btnLoadPackageInfo27 = (Button) view
				.findViewById(R.id.btnLoadPackageInfo27);
		btnLoadPackageInfo17.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				// 如果沒有輸入則不處理
				if (ef_xa015.getText().length() == 0)
					return;
				//
				JSONObject jsonObject = new JSONObject();
				JSONObject data = new JSONObject();

				try {

					data.accumulate("partno", atc_xa015.getText());
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
										atc_xa518.setText(data
												.getString("xa518"));
										atc_xa020.setText(data
												.getString("xa020"));
										atc_xa021.setText(data
												.getString("xa021"));
										atc_xa022.setText(data
												.getString("xa022"));
										atc_xa023.setText(data
												.getString("xa023"));
										atc_xa024.setText(data
												.getString("xa024"));
										atc_xa025.setText(data
												.getString("xa025"));
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
		btnLoadPackageInfo27.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				// 如果沒有輸入則不處理
				if (atc_xa091.getText().length() == 0)
					return;
				JSONObject jsonObject = new JSONObject();
				JSONObject data = new JSONObject();

				try {

					data.accumulate("partno", atc_xa091.getText());
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
										atc_xa518.setText(data
												.getString("xa518"));
										atc_xa020.setText(data
												.getString("xa020"));
										atc_xa021.setText(data
												.getString("xa021"));
										atc_xa022.setText(data
												.getString("xa022"));
										atc_xa023.setText(data
												.getString("xa023"));
										atc_xa024.setText(data
												.getString("xa024"));
										atc_xa025.setText(data
												.getString("xa025"));
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
		setupTab7EditKeyboard(mView);
	}

	private void initTab8(View view) {
		pb_xa015 = (EditText) view.findViewById(R.id.pb_xa015);
		pb_xa087 = (CheckBox) view.findViewById(R.id.pb_xa087);
		pb_xa088 = (CheckBox) view.findViewById(R.id.pb_xa088);
		pb_xa090 = (CheckBox) view.findViewById(R.id.pb_xa090);
		pb_xa091 = (EditText) view.findViewById(R.id.pb_xa091);
		pb_xa092 = (CheckBox) view.findViewById(R.id.pb_xa092);
		pb_xa093 = (CheckBox) view.findViewById(R.id.pb_xa093);
		xa601 = (CheckBox) view.findViewById(R.id.xa601);
		xa602 = (EditText) view.findViewById(R.id.xa602);
		xa603 = (EditText) view.findViewById(R.id.xa603);
		xa604 = (EditText) view.findViewById(R.id.xa604);
		xa605 = (EditText) view.findViewById(R.id.xa605);
		xa606 = (CheckBox) view.findViewById(R.id.xa606);
		xa607 = (CheckBox) view.findViewById(R.id.xa607);
		xa608 = (CheckBox) view.findViewById(R.id.xa608);
		xa609 = (CheckBox) view.findViewById(R.id.xa609);
		xa610 = (EditText) view.findViewById(R.id.xa610);
		xa611 = (EditText) view.findViewById(R.id.xa611);
		xa612 = (EditText) view.findViewById(R.id.xa612);
		xa613 = (EditText) view.findViewById(R.id.xa613);
		xa614 = (EditText) view.findViewById(R.id.xa614);
		xa615 = (CheckBox) view.findViewById(R.id.xa615);
		xa616 = (CheckBox) view.findViewById(R.id.xa616);
		xa617 = (CheckBox) view.findViewById(R.id.xa617);
		xa618 = (CheckBox) view.findViewById(R.id.xa618);
		xa619 = (EditText) view.findViewById(R.id.xa619);
		xa620 = (EditText) view.findViewById(R.id.xa620);
		xa621 = (EditText) view.findViewById(R.id.xa621);
		xa622 = (EditText) view.findViewById(R.id.xa622);
		xa623 = (EditText) view.findViewById(R.id.xa623);
		xa624 = (CheckBox) view.findViewById(R.id.xa624);
		xa625 = (EditText) view.findViewById(R.id.xa625);
		xa626 = (CheckBox) view.findViewById(R.id.xa626);
		xa627 = (EditText) view.findViewById(R.id.xa627);
		xa628 = (CheckBox) view.findViewById(R.id.xa628);
		xa629 = (EditText) view.findViewById(R.id.xa629);
		xa630 = (EditText) view.findViewById(R.id.xa630);
		xa631 = (EditText) view.findViewById(R.id.xa631);
		xa632 = (EditText) view.findViewById(R.id.xa632);
		xa633 = (EditText) view.findViewById(R.id.xa633);
		xa634 = (CheckBox) view.findViewById(R.id.xa634);
		xa635 = (CheckBox) view.findViewById(R.id.xa635);
		xa636 = (CheckBox) view.findViewById(R.id.xa636);
		xa637 = (CheckBox) view.findViewById(R.id.xa637);
		xa638 = (CheckBox) view.findViewById(R.id.xa638);
		xa639 = (CheckBox) view.findViewById(R.id.xa639);
		xa640 = (CheckBox) view.findViewById(R.id.xa640);
		xa641 = (CheckBox) view.findViewById(R.id.xa641);
		xa642 = (CheckBox) view.findViewById(R.id.xa642);
		xa643 = (CheckBox) view.findViewById(R.id.xa643);
		xa644 = (CheckBox) view.findViewById(R.id.xa644);
		xa645 = (CheckBox) view.findViewById(R.id.xa645);
		xa646 = (CheckBox) view.findViewById(R.id.xa646);
		xa647 = (CheckBox) view.findViewById(R.id.xa647);
		xa648 = (CheckBox) view.findViewById(R.id.xa648);
		xa649 = (EditText) view.findViewById(R.id.xa649);
		xa650 = (EditText) view.findViewById(R.id.xa650);
		xa651 = (CheckBox) view.findViewById(R.id.xa651);
		xa652 = (CheckBox) view.findViewById(R.id.xa652);
		xa653 = (CheckBox) view.findViewById(R.id.xa653);
		xa654 = (CheckBox) view.findViewById(R.id.xa654);
		xa655 = (CheckBox) view.findViewById(R.id.xa655);
		xa656 = (EditText) view.findViewById(R.id.xa656);
		xa657 = (EditText) view.findViewById(R.id.xa657);
		xa658 = (CheckBox) view.findViewById(R.id.xa658);
		xa659 = (EditText) view.findViewById(R.id.xa659);
		xa660 = (CheckBox) view.findViewById(R.id.xa660);
		xa661 = (CheckBox) view.findViewById(R.id.xa661);
		xa662 = (CheckBox) view.findViewById(R.id.xa662);
		xa663 = (CheckBox) view.findViewById(R.id.xa663);
		xa664 = (CheckBox) view.findViewById(R.id.xa664);
		xa665Y = (CheckBox) view.findViewById(R.id.xa665Y);
		xa665N = (CheckBox) view.findViewById(R.id.xa665N);
		xa666 = (CheckBox) view.findViewById(R.id.xa666);
		xa667 = (CheckBox) view.findViewById(R.id.xa667);
		xa668 = (CheckBox) view.findViewById(R.id.xa668);
		xa669 = (CheckBox) view.findViewById(R.id.xa669);
		xa670 = (CheckBox) view.findViewById(R.id.xa670);
		xa671 = (CheckBox) view.findViewById(R.id.xa671);
		xa672 = (CheckBox) view.findViewById(R.id.xa672);
		xa673 = (EditText) view.findViewById(R.id.xa673);
		xa674Y = (CheckBox) view.findViewById(R.id.xa674Y);
		xa674N = (CheckBox) view.findViewById(R.id.xa674N);
		xa675 = (EditText) view.findViewById(R.id.xa675);
		xa676 = (EditText) view.findViewById(R.id.xa676);
		xa677 = (CheckBox) view.findViewById(R.id.xa677);
		// 150924 add
		xa00t1 = (CheckBox) view.findViewById(R.id.xa00t1);
		xa00t2 = (CheckBox) view.findViewById(R.id.xa00t2);
		xa678 = (CheckBox) view.findViewById(R.id.xa678);
		xa679 = (CheckBox) view.findViewById(R.id.xa679);
		xa680 = (CheckBox) view.findViewById(R.id.xa680);
		xa681 = (CheckBox) view.findViewById(R.id.xa681);
		xa682 = (CheckBox) view.findViewById(R.id.xa682);
		xa683 = (EditText) view.findViewById(R.id.xa683);
		OnClickListener siteListener = new OnClickListener() {
			@Override
			public void onClick(View v) {
				boolean checked = ((CheckBox) v).isChecked();
				xa678.setChecked(false);
				xa679.setChecked(false);
				xa680.setChecked(false);
				xa681.setChecked(false);
				xa682.setChecked(false);
				if (checked) {
					((CheckBox) v).setChecked(checked);
				}
			}
		};
		xa678.setOnClickListener(siteListener);
		xa679.setOnClickListener(siteListener);
		xa680.setOnClickListener(siteListener);
		xa681.setOnClickListener(siteListener);
		xa682.setOnClickListener(siteListener);
		pb_xa024 = (EditText) view.findViewById(R.id.pb_xa024);
		xa645.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				boolean checked = ((CheckBox) v).isChecked();
				if (checked && xa646.isChecked()) {
					xa646.setChecked(false);
				}
			}
		});
		xa646.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				boolean checked = ((CheckBox) v).isChecked();
				if (checked && xa645.isChecked()) {
					xa645.setChecked(false);
				}
			}
		});
		xa647.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				boolean checked = ((CheckBox) v).isChecked();
				if (checked && xa648.isChecked()) {
					xa648.setChecked(false);
				}
			}
		});
		xa648.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				boolean checked = ((CheckBox) v).isChecked();
				if (checked && xa647.isChecked()) {
					xa647.setChecked(false);
				}
			}
		});
		xa641.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				boolean checked = ((CheckBox) v).isChecked();
				if (checked && xa642.isChecked()) {
					xa642.setChecked(false);
				}
			}
		});
		xa642.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				boolean checked = ((CheckBox) v).isChecked();
				if (checked && xa641.isChecked()) {
					xa641.setChecked(false);
				}
			}
		});
		xa643.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				boolean checked = ((CheckBox) v).isChecked();
				if (checked && xa644.isChecked()) {
					xa644.setChecked(false);
				}
			}
		});
		xa644.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				boolean checked = ((CheckBox) v).isChecked();
				if (checked && xa643.isChecked()) {
					xa643.setChecked(false);
				}
			}
		});
		xa667.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				boolean checked = ((CheckBox) v).isChecked();
				if (checked && xa668.isChecked()) {
					xa668.setChecked(false);
					xa669.setChecked(false);
					xa670.setChecked(false);
					xa671.setChecked(false);
					xa672.setChecked(false);
				}
			}
		});
		xa668.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				boolean checked = ((CheckBox) v).isChecked();
				if (checked && xa667.isChecked()) {
					xa667.setChecked(false);
				}
			}
		});
		xa665Y.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				boolean checked = ((CheckBox) v).isChecked();
				if (checked && xa665Y.isChecked()) {
					xa665Y.setChecked(false);
				}
			}
		});
		xa665N.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				boolean checked = ((CheckBox) v).isChecked();
				if (checked && xa665Y.isChecked()) {
					xa665Y.setChecked(false);
				}
			}
		});
		xa674Y.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				boolean checked = ((CheckBox) v).isChecked();
				if (checked && xa674N.isChecked()) {
					xa674N.setChecked(false);
				}
			}
		});
		xa674N.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				boolean checked = ((CheckBox) v).isChecked();
				if (checked && xa674Y.isChecked()) {
					xa674Y.setChecked(false);
				}
			}
		});
	}

	private void initTab9(View view) {
		ck_xa092 = (CheckBox) view.findViewById(R.id.ck_xa092);
		ck_xa093 = (CheckBox) view.findViewById(R.id.ck_xa093);
		ck_xa015 = (EditText) view.findViewById(R.id.ck_xa015);
		ck_xa087 = (CheckBox) view.findViewById(R.id.ck_xa087);
		ck_xa088 = (CheckBox) view.findViewById(R.id.ck_xa088);
		ck_xa090 = (CheckBox) view.findViewById(R.id.ck_xa090);
		ck_xa091 = (EditText) view.findViewById(R.id.ck_xa091);
		ck_xa518 = (EditText) view.findViewById(R.id.ck_xa518);
		ck_xa020 = (EditText) view.findViewById(R.id.ck_xa020);
		ck_xa021 = (EditText) view.findViewById(R.id.ck_xa021);
		ck_xa022 = (EditText) view.findViewById(R.id.ck_xa022);
		ck_xa023 = (EditText) view.findViewById(R.id.ck_xa023);
		ck_xa024 = (EditText) view.findViewById(R.id.ck_xa024);
		ck_xa025 = (EditText) view.findViewById(R.id.ck_xa025);
		ck_xa019 = (EditText) view.findViewById(R.id.ck_xa019);
		xa722 = (EditText) view.findViewById(R.id.xa722);
		xa723 = (EditText) view.findViewById(R.id.xa723);
		xa724 = (EditText) view.findViewById(R.id.xa724);
		xa725 = (EditText) view.findViewById(R.id.xa725);
		xa726 = (EditText) view.findViewById(R.id.xa726);
		xa727 = (EditText) view.findViewById(R.id.xa727);
		xa728 = (EditText) view.findViewById(R.id.xa728);
		xa729 = (EditText) view.findViewById(R.id.xa729);
		xa730 = (EditText) view.findViewById(R.id.xa730);
		xa701 = (CheckBox) view.findViewById(R.id.xa701);
		xa702 = (CheckBox) view.findViewById(R.id.xa702);
		xa703 = (CheckBox) view.findViewById(R.id.xa703);
		xa704 = (CheckBox) view.findViewById(R.id.xa704);
		xa705 = (CheckBox) view.findViewById(R.id.xa705);
		xa706Y = (CheckBox) view.findViewById(R.id.xa706Y);
		xa706Y.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				boolean checked = ((CheckBox) v).isChecked();
				if (checked && xa706N.isChecked()) {
					xa706N.setChecked(false);
				}
			}
		});
		xa706N = (CheckBox) view.findViewById(R.id.xa706N);
		xa706N.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				boolean checked = ((CheckBox) v).isChecked();
				if (checked && xa706Y.isChecked()) {
					xa706Y.setChecked(false);
				}
			}
		});
		xa707Y = (CheckBox) view.findViewById(R.id.xa707Y);
		xa707Y.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				boolean checked = ((CheckBox) v).isChecked();
				if (checked && xa707Y.isChecked()) {
					xa707Y.setChecked(false);
				}
			}
		});
		xa707N = (CheckBox) view.findViewById(R.id.xa707N);
		xa707N.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				boolean checked = ((CheckBox) v).isChecked();
				if (checked && xa707Y.isChecked()) {
					xa707Y.setChecked(false);
				}
			}
		});
		xa708 = (EditText) view.findViewById(R.id.xa708);
		xa709 = (EditText) view.findViewById(R.id.xa709);
		xa710 = (EditText) view.findViewById(R.id.xa710);
		xa711 = (EditText) view.findViewById(R.id.xa711);
		xa712 = (CheckBox) view.findViewById(R.id.xa712);
		xa713 = (CheckBox) view.findViewById(R.id.xa713);
		xa714 = (CheckBox) view.findViewById(R.id.xa714);
		xa715 = (CheckBox) view.findViewById(R.id.xa715);
		xa716 = (CheckBox) view.findViewById(R.id.xa716);
		xa717 = (EditText) view.findViewById(R.id.xa717);
		xa718 = (EditText) view.findViewById(R.id.xa718);
		xa719 = (EditText) view.findViewById(R.id.xa719);
		xa712.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				boolean checked = ((CheckBox) v).isChecked();
				if (checked) {
					xa713.setChecked(false);
					xa714.setChecked(false);
					xa715.setChecked(false);
					xa716.setChecked(false);
					xa717.setText("");
				}
			}
		});
		xa713.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				boolean checked = ((CheckBox) v).isChecked();
				if (checked) {
					xa712.setChecked(false);
					xa714.setChecked(false);
					xa715.setChecked(false);
					xa716.setChecked(false);
					xa717.setText("");
				}
			}
		});
		xa714.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				boolean checked = ((CheckBox) v).isChecked();
				if (checked) {
					xa713.setChecked(false);
					xa712.setChecked(false);
					xa715.setChecked(false);
					xa716.setChecked(false);
					xa717.setText("");
				}
			}
		});
		xa715.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				boolean checked = ((CheckBox) v).isChecked();
				if (checked) {
					xa713.setChecked(false);
					xa714.setChecked(false);
					xa712.setChecked(false);
					xa716.setChecked(false);
					xa717.setText("");
				}
			}
		});
		xa716.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				boolean checked = ((CheckBox) v).isChecked();
				if (checked) {
					xa713.setChecked(false);
					xa714.setChecked(false);
					xa715.setChecked(false);
					xa712.setChecked(false);
					xa717.setBackgroundResource(R.drawable.border);
				} else {
					xa717.setText("");
					xa717.setBackgroundColor(getResources().getColor(
							R.color.lightgray));
				}
			}
		});
		setupTab9EditKeyboard(mView);
	}

	private void initTabA(View view) {
		ef_xa015 = (EditText) view.findViewById(R.id.ef_xa015);
		ef_xa020 = (EditText) view.findViewById(R.id.ef_xa020);
		ef_xa021 = (EditText) view.findViewById(R.id.ef_xa021);
		ef_xa022 = (EditText) view.findViewById(R.id.ef_xa022);
		ef_xa023 = (EditText) view.findViewById(R.id.ef_xa023);
		ef_xa024 = (EditText) view.findViewById(R.id.ef_xa024);
		ef_xa025 = (EditText) view.findViewById(R.id.ef_xa025);
		ef_xa090 = (CheckBox) view.findViewById(R.id.ef_xa090);
		ef_xa087 = (CheckBox) view.findViewById(R.id.ef_xa087);
		ef_xa088 = (CheckBox) view.findViewById(R.id.ef_xa088);
		ef_xa089 = (CheckBox) view.findViewById(R.id.ef_xa089);
		ef_xa091 = (EditText) view.findViewById(R.id.ef_xa091);
		ef_xa092 = (CheckBox) view.findViewById(R.id.ef_xa092);
		ef_xa093 = (CheckBox) view.findViewById(R.id.ef_xa093);
		ef_xa518 = (EditText) view.findViewById(R.id.ef_xa518);
		xa804 = (EditText) view.findViewById(R.id.xa804);
		xa805 = (EditText) view.findViewById(R.id.xa805);
		xa806 = (EditText) view.findViewById(R.id.xa806);
		xa807 = (EditText) view.findViewById(R.id.xa807);
		xa808 = (EditText) view.findViewById(R.id.xa808);
		xa809 = (CheckBox) view.findViewById(R.id.xa809);
		xa810 = (CheckBox) view.findViewById(R.id.xa810);
		xa811 = (CheckBox) view.findViewById(R.id.xa811);
		xa813 = (CheckBox) view.findViewById(R.id.xa813);
		xa815 = (CheckBox) view.findViewById(R.id.xa815);
		xa822 = (CheckBox) view.findViewById(R.id.xa822);
		xa824 = (EditText) view.findViewById(R.id.xa824);
		xa825 = (CheckBox) view.findViewById(R.id.xa825);
		xa826 = (CheckBox) view.findViewById(R.id.xa826);
		xa827 = (EditText) view.findViewById(R.id.xa827);
		xa828 = (CheckBox) view.findViewById(R.id.xa828);
		xa829 = (CheckBox) view.findViewById(R.id.xa829);
		xa830Y = (CheckBox) view.findViewById(R.id.xa830Y);
		// 150924 add
		xa856 = (EditText) view.findViewById(R.id.xa856);
		xa857 = (EditText) view.findViewById(R.id.xa857);
		xa858 = (EditText) view.findViewById(R.id.xa858);
		xa859 = (EditText) view.findViewById(R.id.xa859);
		xa860 = (EditText) view.findViewById(R.id.xa860);
		xa861 = (CheckBox) view.findViewById(R.id.xa861);
		xa862 = (CheckBox) view.findViewById(R.id.xa862);
		// end
		xa830Y.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				boolean checked = ((CheckBox) v).isChecked();
				if (checked && xa830Y.isChecked()) {
					xa830Y.setChecked(false);
				}
			}
		});
		xa830N = (CheckBox) view.findViewById(R.id.xa830N);
		xa830N.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				boolean checked = ((CheckBox) v).isChecked();
				if (checked && xa830Y.isChecked()) {
					xa830Y.setChecked(false);
				}
			}
		});
		xa809.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				boolean checked = ((CheckBox) v).isChecked();
				if (checked) {
					xa811.setChecked(false);
					xa815.setChecked(false);
				}
			}
		});
		xa811.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				boolean checked = ((CheckBox) v).isChecked();
				if (checked) {
					xa809.setChecked(false);
					xa815.setChecked(false);
				}
			}
		});
		xa815.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				boolean checked = ((CheckBox) v).isChecked();
				if (checked) {
					xa811.setChecked(false);
					xa809.setChecked(false);
				}
			}
		});
		xa822.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				boolean checked = ((CheckBox) v).isChecked();
				if (checked) {
					xa810.setChecked(false);
					xa813.setChecked(false);
				}
			}
		});
		xa810.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				boolean checked = ((CheckBox) v).isChecked();
				if (checked) {
					xa822.setChecked(false);
					xa813.setChecked(false);
				}
			}
		});
		xa813.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				boolean checked = ((CheckBox) v).isChecked();
				if (checked) {
					xa822.setChecked(false);
					xa810.setChecked(false);
				}
			}
		});
		xa831 = (CheckBox) view.findViewById(R.id.xa831);
		xa832 = (EditText) view.findViewById(R.id.xa832);
		xa832.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				showDateDialog(v);
			}
		});
		xa839 = (CheckBox) view.findViewById(R.id.xa839);
		xa840 = (CheckBox) view.findViewById(R.id.xa840);
		xa841 = (EditText) view.findViewById(R.id.xa841);
		xa842 = (CheckBox) view.findViewById(R.id.xa842);
		xa843 = (EditText) view.findViewById(R.id.xa843);
		xa844 = (EditText) view.findViewById(R.id.xa844);
		xa845 = (EditText) view.findViewById(R.id.xa845);
		xa846 = (EditText) view.findViewById(R.id.xa846);
		xa849 = (EditText) view.findViewById(R.id.xa849);
		xa850 = (EditText) view.findViewById(R.id.xa850);
		xa851 = (CheckBox) view.findViewById(R.id.xa851);
		xa852 = (CheckBox) view.findViewById(R.id.xa852);
		xa853 = (EditText) view.findViewById(R.id.xa853);

		plugimage = (ImageView) view.findViewById(R.id.plugimage);

		btnLoadPackageInfo1a = (Button) view
				.findViewById(R.id.btnLoadPackageInfo1a);
		btnLoadPackageInfo2a = (Button) view
				.findViewById(R.id.btnLoadPackageInfo2a);
		btnLoadPackageInfo1a.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				// 如果沒有輸入則不處理
				if (ef_xa015.getText().length() == 0)
					return;
				//
				JSONObject jsonObject = new JSONObject();
				JSONObject data = new JSONObject();

				try {

					data.accumulate("partno", ef_xa015.getText());
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
										ef_xa518.setText(data
												.getString("xa518"));
										ef_xa020.setText(data
												.getString("xa020"));
										ef_xa021.setText(data
												.getString("xa021"));
										ef_xa022.setText(data
												.getString("xa022"));
										ef_xa023.setText(data
												.getString("xa023"));
										ef_xa024.setText(data
												.getString("xa024"));
										ef_xa025.setText(data
												.getString("xa025"));
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
		btnLoadPackageInfo2a.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				// 如果沒有輸入則不處理
				if (ef_xa091.getText().length() == 0)
					return;
				JSONObject jsonObject = new JSONObject();
				JSONObject data = new JSONObject();

				try {

					data.accumulate("partno", ef_xa091.getText());
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
										ef_xa518.setText(data
												.getString("xa518"));
										ef_xa020.setText(data
												.getString("xa020"));
										ef_xa021.setText(data
												.getString("xa021"));
										ef_xa022.setText(data
												.getString("xa022"));
										ef_xa023.setText(data
												.getString("xa023"));
										ef_xa024.setText(data
												.getString("xa024"));
										ef_xa025.setText(data
												.getString("xa025"));
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
		setupTabAEditKeyboard(mView);
	}

	/**
	 * 5.Comment頁面
	 * 
	 * @param view
	 */
	private void initTabB(View view) {
		xa049 = (EditText) view.findViewById(R.id.xa049);
		xa59r = (EditText) view.findViewById(R.id.xa59r);// No.15041501
	}

	/**
	 * 3.Handler =>Forecast
	 * 
	 * @param view
	 */
	private void initTabD(View view) {
		xa59d = (EditText) view.findViewById(R.id.xa59d);// Expected order qty
		xa59e = (EditText) view.findViewById(R.id.xa59e);// Requested SOD
		xa59f = (EditText) view.findViewById(R.id.xa59f);// Customer target unit
															// price
		xa59v = (EditText) view.findViewById(R.id.xa59v);
		xa00i = (EditText) view.findViewById(R.id.xa59i);
		xa59w = (EditText) view.findViewById(R.id.xa59w);
		xa59x = (EditText) view.findViewById(R.id.xa59x);
		xa00a = (EditText) view.findViewById(R.id.xa00a);
		xa00b = (EditText) view.findViewById(R.id.xa00b);
		xa00c = (EditText) view.findViewById(R.id.xa00c);
		xa00d = (EditText) view.findViewById(R.id.xa00d);
		xa00e = (EditText) view.findViewById(R.id.xa00e);
		xa00f = (EditText) view.findViewById(R.id.xa00f);
		xa00g = (EditText) view.findViewById(R.id.xa00g);
		xa00h = (EditText) view.findViewById(R.id.xa00h);
		xa59z = (EditText) view.findViewById(R.id.xa59z);
		setupTabDEditKeyboard(mView);
	}

	/**
	 * 初始化Screenshot_20150410_14.jpg
	 * 
	 * @param inflater
	 * @param container
	 * @return
	 */
	private View initView(LayoutInflater inflater, ViewGroup container) {
		View view = inflater.inflate(R.layout.actapqpdata, container, false);
		context = view.getContext();
		this.fragmentManager = getActivity().getFragmentManager();
		bundle = this.getArguments();
		mView = view;
		setTitle(view);
		tabbar = (RelativeLayout) mView.findViewById(R.id.apqptab);
		cmdbar = (RelativeLayout) mView.findViewById(R.id.apqp_editbar);
		tab1 = (LinearLayout) mView.findViewById(R.id.tab1);// Cust info
															// linearlayout
		tab2 = (LinearLayout) mView.findViewById(R.id.tab2);// Package info
		tab3 = (LinearLayout) mView.findViewById(R.id.tab3);// Handler
		tab4 = (LinearLayout) mView.findViewById(R.id.tab4);// Socket
		tab5 = (LinearLayout) mView.findViewById(R.id.tab5);// Duplication
		tab6 = (LinearLayout) mView.findViewById(R.id.tab6);// WLCSP
		tab7 = (LinearLayout) mView.findViewById(R.id.tab7);// ATC
		tab8 = (LinearLayout) mView.findViewById(R.id.tab8);// FinePitch
															// ProbeCard
		tab9 = (LinearLayout) mView.findViewById(R.id.tab9);// changeover kit
		taba = (LinearLayout) mView.findViewById(R.id.tabA);// e-flux
		tabb = (RelativeLayout) mView.findViewById(R.id.tabB);// Comment
		commentbar = (RelativeLayout) mView.findViewById(R.id.tabB_commentbar);
		tabr_l1 = (TextView) mView.findViewById(R.id.tabr_l1);
		btn_fae = (Button) mView.findViewById(R.id.fae_comment);
		btn_sale = (Button) mView.findViewById(R.id.sale_comment);
		final RelativeLayout tabb_r2 = (RelativeLayout) mView
				.findViewById(R.id.tabb_r2);
		final RelativeLayout tabb_r4 = (RelativeLayout) mView
				.findViewById(R.id.tabb_r4);
		final RelativeLayout tabb_r5 = (RelativeLayout) mView
				.findViewById(R.id.tabb_r5);
		tabr_l1.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				if (tabr_l1.getTag().equals("0") == false) {
					return;
				}
				xa59r.setVisibility(View.VISIBLE);
			}
		});
		btn_fae.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				btn_fae.setBackgroundColor(Color.DKGRAY);
				btn_sale.setBackgroundColor(Color.BLACK);
				tabb_r2.setVisibility(View.GONE);
				tabb_r4.setVisibility(View.VISIBLE);
				tabb_r5.setVisibility(View.GONE);
				tabr_l1.setTag(1);
				tabr_l1.setText(btn_fae.getText().toString());

			}
		});
		btn_sale.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				btn_sale.setBackgroundColor(Color.DKGRAY);
				btn_fae.setBackgroundColor(Color.BLACK);
				tabb_r2.setVisibility(View.GONE);
				tabb_r4.setVisibility(View.GONE);
				tabb_r5.setVisibility(View.VISIBLE);
				tabr_l1.setTag(2);
				tabr_l1.setText(btn_sale.getText().toString());
			}
		});
		tabd = (LinearLayout) mView.findViewById(R.id.tabD);// Forecast
		vwSubTitle = (TextView) mView.findViewById(R.id.subtitle);
		Button img = (Button) view.findViewById(R.id.img_menu);
		img.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {

				// 如果apqptab沒有顯示的話，則顯示
				if (tabbar != null && tabbar.isShown() == false) {
					tabbar.setVisibility(RelativeLayout.VISIBLE);
				} else {
					if (tabbar != null)
						tabbar.setVisibility(RelativeLayout.GONE);

				}
			}// end of onClick
		});
		// 初始化介面
		initUI(mView);
		// 取得資料
		if (bundle != null && bundle.size() > 0 && bundle.getInt("frg_id") > 0) {
			
			String[] apqpno = getApqpNo().split("-");
			final String xa001=apqpno[0];
			final String xa002=apqpno[1];
			queryData((String) getWebServiceUrl() + "getAPQPB",
					getAPQPB(xa001, xa002), new IDataReceiveListener() {
						public void onReceiveData(Object obj) {							
							try {
								JSONObject responeData = new JSONObject(
										(String) obj);
								JSONObject data = responeData
										.getJSONObject("data");
								xa593 = data.getString("xa593");
								setLayoutUI(Integer.parseInt(xa593));								
								tab1.setVisibility(View.GONE);
								tabb.setVisibility(View.VISIBLE);
								vwSubTitle.setText("Comment");
								loadDataB(obj);
							} catch (Exception ex) {

							}
						}
					});
		} else {
			queryData();
		}


		return view;
	}

	private void issueData(final String xa001, final String xa002) {
		HttpPostAsyncTask task1 = new HttpPostAsyncTask();
		String func = "";

		func = "issueAPQP";

		try {
			JSONObject data = new JSONObject();
			JSONObject jsonObj = new JSONObject();
			jsonObj.accumulate("userid", super.getLoginUser());
			jsonObj.accumulate("WWID", "13145774WWGlobal999988issue999");
			data.accumulate("xa001", xa001);
			data.accumulate("xa002", xa002);
			data.accumulate("operatingOrg", "wwtw"); // 營運中心
			data.accumulate("tiptopZone", "TOPTEST");
			jsonObj.accumulate("data", data);

			task1.setCallback(new BaseFragment.ICallback() {
				@Override
				/**
				 * implement  abstract的function =>doWork()
				 */
				public void doWork(Object obj) {

					try {
						JSONObject jsonObject = new JSONObject((String) obj);
						if (jsonObject.getString("success").equals("false")) {
							showDialog("error", jsonObject.getString("remark"));
						} else {
							showDialog("Issue success");
						}

					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						showDialog("Issue error", e.getMessage());
					}

				}

			});

			// execute() is AsyncTask's method
			// (1)func =>updateAPQP1,updateAPQP2,updateAPQP3...
			// (2)jsonObj => new JSONObject();
			// jsonObj.accumulate("userid", super.getLoginUser());
			// jsonObj.accumulate("WWID", "13145774WWGlobal999988issue999");
			// 會執行 protected String doInBackground(String... urls) {
			// return POST(urls[0],urls[1]); }
			task1.execute((String) super.getWebServiceUrl() + func,
					jsonObj.toString());
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
	}

	// Function O
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return initView(inflater, container);
	}

	/*
	 * public void onCustEdit(View v) { mView = getView(); ((Button)
	 * v).setVisibility(View.GONE); Button b = (Button)
	 * mView.findViewById(R.id.btn_change_cust); b.setVisibility(View.VISIBLE);
	 * 
	 * }
	 */

	public void onCustChange(View v) {
		mView = getView();
		((Button) v).setVisibility(View.GONE);
		Button b = (Button) mView.findViewById(R.id.btn_apqp_edit);
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
		// url="http://59.125.146.7:8080/APQPService/GetMsgList?USERID=mis&PAGE="+Integer.toString(page)+"&WWID=13145774WWGlobal999988msg";
		// String url="http://59.125.146.7:8080/APQPService/getAPQP1";
		String url = super.getWebServiceUrl() + "getAPQP1";		

		try {
			String[] apqpno = getApqpNo().split("-");
			JSONObject jsonObject =getAPQP1(apqpno[0],apqpno[1]);
			super.postRequest(url, jsonObject);

		} catch (Exception e) {
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
		vwTitle.setText(getApqpNo());
	}

	private void setupTab1EditKeyboard(View view) {
		// IssueDate
		// xa003.setOnEditorActionListener(EditorListener);
		xa003.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {

				xa003.setInputType(InputType.TYPE_NULL); // 關閉軟鍵盤
				return v.performClick();
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
				return v.performClick();
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
				return v.performClick();
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
				return v.performClick();
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
				return v.performClick();
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
				return v.performClick();
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
				return v.performClick();
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
					showEndCustDialog(v, new ICallback() {
						public void doWork(Object object) {
							CustItem item = (CustItem) object;
							xa551.setText(item.getCustId());
							xa057.setText(item.getCustName());
						}
					});
				}
			}
		});
		xa057.setOnEditorActionListener(EditorListener);
		// xa553.setOnEditorActionListener(EditorListener);//cust region
		xa553.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {

				xa553.setInputType(InputType.TYPE_NULL); // 關閉軟鍵盤
				return v.performClick();
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
		//
		xa00U.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {

				xa00U.setInputType(InputType.TYPE_NULL); // 關閉軟鍵盤
				return v.performClick();
			}

		});
		xa00U.setOnFocusChangeListener(new OnFocusChangeListener() {
			public void onFocusChange(View v, boolean hasFocus) {
				if (hasFocus) {
					InputMethodManager imm = (InputMethodManager) getActivity()
							.getSystemService(Context.INPUT_METHOD_SERVICE);
					imm.hideSoftInputFromWindow(xa00U.getWindowToken(), 0);
					// Open Dialog
					showEndCustDialog(v, new ICallback() {
						public void doWork(Object object) {
							CustItem item = (CustItem) object;
							xa00U.setText(item.getCustId());
							xa00Utext.setText(item.getCustName());
						}
					});
				}
			}
		});
		xa00Utext.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				xa00Utext.setInputType(InputType.TYPE_NULL); // 關閉軟鍵盤
				return v.performClick();
			}

		});
		//
		xa00Utext.setOnEditorActionListener(EditorListener);//
		xa00K.setOnFocusChangeListener(new OnFocusChangeListener() {
			public void onFocusChange(View v, boolean hasFocus) {

				// System.out.println("===>Line number: "+new
				// Throwable().getStackTrace()[0].getLineNumber());

				if (hasFocus) {
					InputMethodManager imm = (InputMethodManager) getActivity()
							.getSystemService(Context.INPUT_METHOD_SERVICE);
					imm.hideSoftInputFromWindow(xa00K.getWindowToken(), 0);
					// Open Dialog
					loadFAEData(v);
				}
			}
		});
		xa00K.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {

				xa00K.setInputType(InputType.TYPE_NULL); // 關閉軟鍵盤
				return v.performClick();
			}

		});
		xa00L.setOnFocusChangeListener(new OnFocusChangeListener() {
			public void onFocusChange(View v, boolean hasFocus) {

				// System.out.println("===>Line number: "+new
				// Throwable().getStackTrace()[0].getLineNumber());

				if (hasFocus) {
					InputMethodManager imm = (InputMethodManager) getActivity()
							.getSystemService(Context.INPUT_METHOD_SERVICE);
					imm.hideSoftInputFromWindow(xa00L.getWindowToken(), 0);
					// Open Dialog
					loadFAEData(v);
				}
			}
		});
		xa00L.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {

				xa00L.setInputType(InputType.TYPE_NULL); // 關閉軟鍵盤
				return v.performClick();
			}

		});
		xa59U.setOnFocusChangeListener(new OnFocusChangeListener() {
			public void onFocusChange(View v, boolean hasFocus) {
				if (hasFocus) {
					InputMethodManager imm = (InputMethodManager) getActivity()
							.getSystemService(Context.INPUT_METHOD_SERVICE);
					imm.hideSoftInputFromWindow(xa59U.getWindowToken(), 0);
					// Open Dialog
					showOSATDialog(v, new ICallback() {
						public void doWork(Object object) {
							OSATItem item = (OSATItem) object;
							xa59U.setText(item.getOSATName());
							xa59U.setTag(item.getOSATNo());
						}
					});
				}
			}
		});
		xa59U.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {

				xa59U.setInputType(InputType.TYPE_NULL); // 關閉軟鍵盤
				return v.performClick();
			}

		});
		xa00R.setOnFocusChangeListener(new OnFocusChangeListener() {
			public void onFocusChange(View v, boolean hasFocus) {
				if (hasFocus) {
					InputMethodManager imm = (InputMethodManager) getActivity()
							.getSystemService(Context.INPUT_METHOD_SERVICE);
					imm.hideSoftInputFromWindow(xa00R.getWindowToken(), 0);
					// Open Dialog
					showOSATDialog(v, new ICallback() {
						public void doWork(Object object) {
							OSATItem item = (OSATItem) object;
							xa00R.setText(item.getOSATName());
							xa00R.setTag(item.getOSATNo());
						}
					});
				}
			}
		});
		xa00R.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {

				xa00R.setInputType(InputType.TYPE_NULL); // 關閉軟鍵盤
				return v.performClick();
			}

		});
		xa00S.setOnFocusChangeListener(new OnFocusChangeListener() {
			public void onFocusChange(View v, boolean hasFocus) {
				if (hasFocus) {
					InputMethodManager imm = (InputMethodManager) getActivity()
							.getSystemService(Context.INPUT_METHOD_SERVICE);
					imm.hideSoftInputFromWindow(xa00S.getWindowToken(), 0);
					// Open Dialog
					showOSATDialog(v, new ICallback() {
						public void doWork(Object object) {
							OSATItem item = (OSATItem) object;
							xa00S.setText(item.getOSATName());
							xa00S.setTag(item.getOSATNo());
						}
					});
				}
			}
		});
		xa00S.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {

				xa00S.setInputType(InputType.TYPE_NULL); // 關閉軟鍵盤
				return v.performClick();
			}

		});
	}

	private void setupTab2EditKeyboard(View view) {
		xa518.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {

				xa518.setInputType(InputType.TYPE_NULL); // 關閉軟鍵盤
				return v.performClick();
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
				return v.performClick();
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
				return v.performClick();
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
				return v.performClick();
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
				return v.performClick();
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
				return v.performClick();
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
				return v.performClick();
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
				return v.performClick();
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
				return v.performClick();
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
				return v.performClick();
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
	}

	private void setupTab3EditKeyboard(View view) {
		xa037.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {

				xa037.setInputType(InputType.TYPE_NULL); // 關閉軟鍵盤
				return v.performClick();
			}
		});
		xa037.setOnFocusChangeListener(new OnFocusChangeListener() {
			public void onFocusChange(View v, boolean hasFocus) {

				// System.out.println("===>Line number: "+new
				// Throwable().getStackTrace()[0].getLineNumber());

				if (hasFocus) {
					InputMethodManager imm = (InputMethodManager) getActivity()
							.getSystemService(Context.INPUT_METHOD_SERVICE);
					imm.hideSoftInputFromWindow(xa037.getWindowToken(), 0);
					// 載入
					if (mHandlerManu.size() == 0) {
						loadHandlerManuData(v);
					} else {
						showHandlerManuDialog(v);
					}
					xa037.clearFocus();
				}
			}
		});
		xa038.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {

				xa038.setInputType(InputType.TYPE_NULL); // 關閉軟鍵盤
				return v.performClick();
			}
		});
		xa038.setOnFocusChangeListener(new OnFocusChangeListener() {
			public void onFocusChange(View v, boolean hasFocus) {

				// System.out.println("===>Line number: "+new
				// Throwable().getStackTrace()[0].getLineNumber());

				if (hasFocus) {
					InputMethodManager imm = (InputMethodManager) getActivity()
							.getSystemService(Context.INPUT_METHOD_SERVICE);
					imm.hideSoftInputFromWindow(xa038.getWindowToken(), 0);
					// 載入
					if (mHandlerModel.size() == 0) {
						loadHandlerModelData(v);
					} else {
						showHandlerModelDialog(v);
					}
					xa038.clearFocus();
				}
			}
		});
		xa039.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {

				xa039.setInputType(InputType.TYPE_NULL); // 關閉軟鍵盤
				return v.performClick();
			}
		});
		xa039.setOnFocusChangeListener(new OnFocusChangeListener() {
			public void onFocusChange(View v, boolean hasFocus) {

				// System.out.println("===>Line number: "+new
				// Throwable().getStackTrace()[0].getLineNumber());

				if (hasFocus) {
					InputMethodManager imm = (InputMethodManager) getActivity()
							.getSystemService(Context.INPUT_METHOD_SERVICE);
					imm.hideSoftInputFromWindow(xa039.getWindowToken(), 0);
					// 載入
					if (mTesterManu.size() == 0) {
						loadTesterManuData(v);
					} else {
						showTesterManuDialog(v);
					}
					xa039.clearFocus();
				}
			}
		});
		xa040.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {

				xa040.setInputType(InputType.TYPE_NULL); // 關閉軟鍵盤
				return v.performClick();
			}
		});
		xa040.setOnFocusChangeListener(new OnFocusChangeListener() {
			public void onFocusChange(View v, boolean hasFocus) {

				// System.out.println("===>Line number: "+new
				// Throwable().getStackTrace()[0].getLineNumber());

				if (hasFocus) {
					InputMethodManager imm = (InputMethodManager) getActivity()
							.getSystemService(Context.INPUT_METHOD_SERVICE);
					imm.hideSoftInputFromWindow(xa040.getWindowToken(), 0);
					// 載入
					if (mTesterModel.size() == 0) {
						loadTesterModelData(v);
					} else {
						showTesterModelDialog(v);
					}
					xa040.clearFocus();
				}
			}
		});
	}

	private void setupTab4EditKeyboard(View view) {

	}

	private void setupTab5EditKeyboard(View view) {
		xa518a.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {

				xa518a.setInputType(InputType.TYPE_NULL); // 關閉軟鍵盤
				return false;
			}
		});
		xa518a.setOnFocusChangeListener(new OnFocusChangeListener() {
			public void onFocusChange(View v, boolean hasFocus) {

				// System.out.println("===>Line number: "+new
				// Throwable().getStackTrace()[0].getLineNumber());

				if (hasFocus) {
					InputMethodManager imm = (InputMethodManager) getActivity()
							.getSystemService(Context.INPUT_METHOD_SERVICE);
					imm.hideSoftInputFromWindow(xa518a.getWindowToken(), 0);
					showPackageTypeDialog(v);
					xa518a.clearFocus();
				}
			}
		});
		xa2a7.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {

				xa2a7.setInputType(InputType.TYPE_NULL); // 關閉軟鍵盤
				return false;
			}
		});
		xa2a7.setOnFocusChangeListener(new OnFocusChangeListener() {
			public void onFocusChange(View v, boolean hasFocus) {

				// System.out.println("===>Line number: "+new
				// Throwable().getStackTrace()[0].getLineNumber());

				if (hasFocus) {
					InputMethodManager imm = (InputMethodManager) getActivity()
							.getSystemService(Context.INPUT_METHOD_SERVICE);
					imm.hideSoftInputFromWindow(xa2a7.getWindowToken(), 0);
					if (mPoPLGATestType.size() == 0) {
						loadPoPLGATestTypeData(v);
					} else {
						showPoPLGATestTypeDialog(v);
					}
					xa2a7.clearFocus();
				}
			}
		});
		xa220.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {

				xa220.setInputType(InputType.TYPE_NULL); // 關閉軟鍵盤
				return false;
			}
		});
		xa220.setOnFocusChangeListener(new OnFocusChangeListener() {
			public void onFocusChange(View v, boolean hasFocus) {

				// System.out.println("===>Line number: "+new
				// Throwable().getStackTrace()[0].getLineNumber());

				if (hasFocus) {
					InputMethodManager imm = (InputMethodManager) getActivity()
							.getSystemService(Context.INPUT_METHOD_SERVICE);
					imm.hideSoftInputFromWindow(xa220.getWindowToken(), 0);
					// 載入
					if (mHandlerManu.size() == 0) {
						loadHandlerManuData(v);
					} else {
						showHandlerManuDialog(v);
					}
					xa220.clearFocus();
				}
			}
		});
		xa221.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {

				xa221.setInputType(InputType.TYPE_NULL); // 關閉軟鍵盤
				return false;
			}
		});
		xa221.setOnFocusChangeListener(new OnFocusChangeListener() {
			public void onFocusChange(View v, boolean hasFocus) {

				// System.out.println("===>Line number: "+new
				// Throwable().getStackTrace()[0].getLineNumber());

				if (hasFocus) {
					InputMethodManager imm = (InputMethodManager) getActivity()
							.getSystemService(Context.INPUT_METHOD_SERVICE);
					imm.hideSoftInputFromWindow(xa221.getWindowToken(), 0);
					// 載入
					if (mHandlerModel.size() == 0) {
						loadHandlerModelData(v);
					} else {
						showHandlerModelDialog(v);
					}
					xa221.clearFocus();
				}
			}
		});
		xa227.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {

				xa227.setInputType(InputType.TYPE_NULL); // 關閉軟鍵盤
				return false;
			}
		});
		xa227.setOnFocusChangeListener(new OnFocusChangeListener() {
			public void onFocusChange(View v, boolean hasFocus) {

				// System.out.println("===>Line number: "+new
				// Throwable().getStackTrace()[0].getLineNumber());

				if (hasFocus) {
					InputMethodManager imm = (InputMethodManager) getActivity()
							.getSystemService(Context.INPUT_METHOD_SERVICE);
					imm.hideSoftInputFromWindow(xa227.getWindowToken(), 0);
					// 載入
					if (mTesterManu.size() == 0) {
						loadTesterManuData(v);
					} else {
						showTesterManuDialog(v);
					}
					xa227.clearFocus();
				}
			}
		});
		xa228.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {

				xa228.setInputType(InputType.TYPE_NULL); // 關閉軟鍵盤
				return false;
			}
		});
		xa228.setOnFocusChangeListener(new OnFocusChangeListener() {
			public void onFocusChange(View v, boolean hasFocus) {

				// System.out.println("===>Line number: "+new
				// Throwable().getStackTrace()[0].getLineNumber());

				if (hasFocus) {
					InputMethodManager imm = (InputMethodManager) getActivity()
							.getSystemService(Context.INPUT_METHOD_SERVICE);
					imm.hideSoftInputFromWindow(xa228.getWindowToken(), 0);
					// 載入
					if (mTesterModel.size() == 0) {
						loadTesterModelData(v);
					} else {
						showTesterModelDialog(v);
					}
					xa228.clearFocus();
				}
			}
		});
		xa280.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {

				xa280.setInputType(InputType.TYPE_NULL); // 關閉軟鍵盤
				return false;
			}

		});
		xa280.setOnFocusChangeListener(new OnFocusChangeListener() {
			public void onFocusChange(View v, boolean hasFocus) {

				// System.out.println("===>Line number: "+new
				// Throwable().getStackTrace()[0].getLineNumber());

				if (hasFocus) {
					InputMethodManager imm = (InputMethodManager) getActivity()
							.getSystemService(Context.INPUT_METHOD_SERVICE);
					imm.hideSoftInputFromWindow(xa280.getWindowToken(), 0);
					if (mApplication.size() == 0) {
						loadApplicationData(v);
					} else {
						showApplicationDialog(v);

					}
					xa280.clearFocus();
				}
			}
		});
		xa29q.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {

				xa29q.setInputType(InputType.TYPE_NULL); // 關閉軟鍵盤
				return false;
			}

		});
		xa29q.setOnFocusChangeListener(new OnFocusChangeListener() {
			public void onFocusChange(View v, boolean hasFocus) {

				// System.out.println("===>Line number: "+new
				// Throwable().getStackTrace()[0].getLineNumber());

				if (hasFocus) {
					InputMethodManager imm = (InputMethodManager) getActivity()
							.getSystemService(Context.INPUT_METHOD_SERVICE);
					imm.hideSoftInputFromWindow(xa29q.getWindowToken(), 0);
					if (mDigitalAppStd.size() == 0) {
						loadDigitalAppStdData(v);
					} else {
						showDigitalAppStdDialog(v);

					}
					xa29q.clearFocus();
				}
			}
		});
		xa29r.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {

				xa29r.setInputType(InputType.TYPE_NULL); // 關閉軟鍵盤
				return false;
			}

		});
		xa29r.setOnFocusChangeListener(new OnFocusChangeListener() {
			public void onFocusChange(View v, boolean hasFocus) {

				// System.out.println("===>Line number: "+new
				// Throwable().getStackTrace()[0].getLineNumber());

				if (hasFocus) {
					InputMethodManager imm = (InputMethodManager) getActivity()
							.getSystemService(Context.INPUT_METHOD_SERVICE);
					imm.hideSoftInputFromWindow(xa29r.getWindowToken(), 0);
					if (mDigitalClass.size() == 0) {
						loadDigitalClassData(v);
					} else {
						showDigitalClassDialog(v);

					}
					xa29r.clearFocus();
				}
			}
		});
		xa29s.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {

				xa29s.setInputType(InputType.TYPE_NULL); // 關閉軟鍵盤
				return false;
			}

		});
		xa29s.setOnFocusChangeListener(new OnFocusChangeListener() {
			public void onFocusChange(View v, boolean hasFocus) {

				// System.out.println("===>Line number: "+new
				// Throwable().getStackTrace()[0].getLineNumber());

				if (hasFocus) {
					InputMethodManager imm = (InputMethodManager) getActivity()
							.getSystemService(Context.INPUT_METHOD_SERVICE);
					imm.hideSoftInputFromWindow(xa29s.getWindowToken(), 0);
					if (mAnalogAppStd.size() == 0) {
						loadAnalogAppStdData(v);
					} else {
						showAnalogAppStdDialog(v);

					}
					xa29s.clearFocus();
				}
			}
		});
		xa29t.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {

				xa29t.setInputType(InputType.TYPE_NULL); // 關閉軟鍵盤
				return false;
			}

		});
		xa29t.setOnFocusChangeListener(new OnFocusChangeListener() {
			public void onFocusChange(View v, boolean hasFocus) {

				// System.out.println("===>Line number: "+new
				// Throwable().getStackTrace()[0].getLineNumber());

				if (hasFocus) {
					InputMethodManager imm = (InputMethodManager) getActivity()
							.getSystemService(Context.INPUT_METHOD_SERVICE);
					imm.hideSoftInputFromWindow(xa29t.getWindowToken(), 0);
					if (mAnalogClass.size() == 0) {
						loadAnalogClassData(v);
					} else {
						showAnalogClassDialog(v);

					}
					xa29t.clearFocus();
				}
			}
		});
		xa29u.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {

				xa29u.setInputType(InputType.TYPE_NULL); // 關閉軟鍵盤
				return false;
			}

		});
		xa29u.setOnFocusChangeListener(new OnFocusChangeListener() {
			public void onFocusChange(View v, boolean hasFocus) {

				// System.out.println("===>Line number: "+new
				// Throwable().getStackTrace()[0].getLineNumber());

				if (hasFocus) {
					InputMethodManager imm = (InputMethodManager) getActivity()
							.getSystemService(Context.INPUT_METHOD_SERVICE);
					imm.hideSoftInputFromWindow(xa29u.getWindowToken(), 0);
					if (mDevicePad.size() == 0) {
						loadDevicePadData(v);
					} else {
						showDevicePadDialog(v);

					}
					xa29u.clearFocus();
				}
			}
		});
		xa59sa.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {

				xa59sa.setInputType(InputType.TYPE_NULL); // 關閉軟鍵盤
				return false;
			}

		});
		xa59sa.setOnFocusChangeListener(new OnFocusChangeListener() {
			public void onFocusChange(View v, boolean hasFocus) {

				// System.out.println("===>Line number: "+new
				// Throwable().getStackTrace()[0].getLineNumber());

				if (hasFocus) {
					InputMethodManager imm = (InputMethodManager) getActivity()
							.getSystemService(Context.INPUT_METHOD_SERVICE);
					imm.hideSoftInputFromWindow(xa59sa.getWindowToken(), 0);
					if (mDocNeeded.size() == 0) {
						loadDocNeededData(v);
					} else {
						showDocNeededDialog(v);

					}
					xa59sa.clearFocus();
				}
			}
		});
		xa59ta.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {

				xa59ta.setInputType(InputType.TYPE_NULL); // 關閉軟鍵盤
				return false;
			}

		});
		xa59ta.setOnFocusChangeListener(new OnFocusChangeListener() {
			public void onFocusChange(View v, boolean hasFocus) {

				// System.out.println("===>Line number: "+new
				// Throwable().getStackTrace()[0].getLineNumber());

				if (hasFocus) {
					InputMethodManager imm = (InputMethodManager) getActivity()
							.getSystemService(Context.INPUT_METHOD_SERVICE);
					imm.hideSoftInputFromWindow(xa59ta.getWindowToken(), 0);
					showDateDialog(v);
					xa59ta.clearFocus();
				}
			}
		});
	}

	private void setupTab6EditKeyboard(View view) {
		xa323.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {

				xa323.setInputType(InputType.TYPE_NULL); // 關閉軟鍵盤
				return false;
			}

		});
		xa323.setOnFocusChangeListener(new OnFocusChangeListener() {
			public void onFocusChange(View v, boolean hasFocus) {

				// System.out.println("===>Line number: "+new
				// Throwable().getStackTrace()[0].getLineNumber());

				if (hasFocus) {
					InputMethodManager imm = (InputMethodManager) getActivity()
							.getSystemService(Context.INPUT_METHOD_SERVICE);
					imm.hideSoftInputFromWindow(xa323.getWindowToken(), 0);
					if (mApplication.size() == 0) {
						loadApplicationData(v);
					} else {
						showApplicationDialog(v);

					}
					xa323.clearFocus();
				}
			}
		});
		xa333.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {

				xa333.setInputType(InputType.TYPE_NULL); // 關閉軟鍵盤
				return false;
			}

		});
		xa333.setOnFocusChangeListener(new OnFocusChangeListener() {
			public void onFocusChange(View v, boolean hasFocus) {

				// System.out.println("===>Line number: "+new
				// Throwable().getStackTrace()[0].getLineNumber());

				if (hasFocus) {
					InputMethodManager imm = (InputMethodManager) getActivity()
							.getSystemService(Context.INPUT_METHOD_SERVICE);
					imm.hideSoftInputFromWindow(xa333.getWindowToken(), 0);
					showDateDialog(v);
					xa333.clearFocus();
				}
			}
		});
		xa335.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {

				xa335.setInputType(InputType.TYPE_NULL); // 關閉軟鍵盤
				return false;
			}

		});
		xa335.setOnFocusChangeListener(new OnFocusChangeListener() {
			public void onFocusChange(View v, boolean hasFocus) {

				// System.out.println("===>Line number: "+new
				// Throwable().getStackTrace()[0].getLineNumber());

				if (hasFocus) {
					InputMethodManager imm = (InputMethodManager) getActivity()
							.getSystemService(Context.INPUT_METHOD_SERVICE);
					imm.hideSoftInputFromWindow(xa335.getWindowToken(), 0);
					showDateDialog(v);
					xa335.clearFocus();
				}
			}
		});
	}

	private void setupTab7EditKeyboard(View view) {
		atc_xa518.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {

				atc_xa518.setInputType(InputType.TYPE_NULL); // 關閉軟鍵盤
				return false;
			}
		});
		atc_xa518.setOnFocusChangeListener(new OnFocusChangeListener() {
			public void onFocusChange(View v, boolean hasFocus) {

				// System.out.println("===>Line number: "+new
				// Throwable().getStackTrace()[0].getLineNumber());

				if (hasFocus) {
					InputMethodManager imm = (InputMethodManager) getActivity()
							.getSystemService(Context.INPUT_METHOD_SERVICE);
					imm.hideSoftInputFromWindow(atc_xa518.getWindowToken(), 0);

					showPackageTypeDialog(v);
					atc_xa518.clearFocus();
				}
			}
		});
		xa432.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {

				xa432.setInputType(InputType.TYPE_NULL); // 關閉軟鍵盤
				return false;
			}
		});
		xa434.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {

				xa434.setInputType(InputType.TYPE_NULL); // 關閉軟鍵盤
				return false;
			}
		});
		xa436.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {

				xa436.setInputType(InputType.TYPE_NULL); // 關閉軟鍵盤
				return false;
			}
		});
		xa432.setOnFocusChangeListener(new OnFocusChangeListener() {
			public void onFocusChange(View v, boolean hasFocus) {

				// System.out.println("===>Line number: "+new
				// Throwable().getStackTrace()[0].getLineNumber());

				if (hasFocus) {
					InputMethodManager imm = (InputMethodManager) getActivity()
							.getSystemService(Context.INPUT_METHOD_SERVICE);
					imm.hideSoftInputFromWindow(xa432.getWindowToken(), 0);
					showDateDialog(v);
					xa432.clearFocus();
				}
			}
		});
		xa434.setOnFocusChangeListener(new OnFocusChangeListener() {
			public void onFocusChange(View v, boolean hasFocus) {

				// System.out.println("===>Line number: "+new
				// Throwable().getStackTrace()[0].getLineNumber());

				if (hasFocus) {
					InputMethodManager imm = (InputMethodManager) getActivity()
							.getSystemService(Context.INPUT_METHOD_SERVICE);
					imm.hideSoftInputFromWindow(xa434.getWindowToken(), 0);
					showDateDialog(v);
					xa432.clearFocus();
				}
			}
		});
		xa436.setOnFocusChangeListener(new OnFocusChangeListener() {
			public void onFocusChange(View v, boolean hasFocus) {

				// System.out.println("===>Line number: "+new
				// Throwable().getStackTrace()[0].getLineNumber());

				if (hasFocus) {
					InputMethodManager imm = (InputMethodManager) getActivity()
							.getSystemService(Context.INPUT_METHOD_SERVICE);
					imm.hideSoftInputFromWindow(xa436.getWindowToken(), 0);
					showDateDialog(v);
					xa432.clearFocus();
				}
			}
		});
	}

	private void setupTab9EditKeyboard(View view) {
		ck_xa518.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {

				ck_xa518.setInputType(InputType.TYPE_NULL); // 關閉軟鍵盤
				return false;
			}
		});
		ck_xa518.setOnFocusChangeListener(new OnFocusChangeListener() {
			public void onFocusChange(View v, boolean hasFocus) {

				// System.out.println("===>Line number: "+new
				// Throwable().getStackTrace()[0].getLineNumber());

				if (hasFocus) {
					InputMethodManager imm = (InputMethodManager) getActivity()
							.getSystemService(Context.INPUT_METHOD_SERVICE);
					imm.hideSoftInputFromWindow(ck_xa518.getWindowToken(), 0);

					showPackageTypeDialog(v);
					ck_xa518.clearFocus();
				}
			}
		});
		xa708.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {

				xa708.setInputType(InputType.TYPE_NULL); // 關閉軟鍵盤
				return false;
			}
		});
		xa708.setOnFocusChangeListener(new OnFocusChangeListener() {
			public void onFocusChange(View v, boolean hasFocus) {

				// System.out.println("===>Line number: "+new
				// Throwable().getStackTrace()[0].getLineNumber());

				if (hasFocus) {
					InputMethodManager imm = (InputMethodManager) getActivity()
							.getSystemService(Context.INPUT_METHOD_SERVICE);
					imm.hideSoftInputFromWindow(xa708.getWindowToken(), 0);
					// 載入
					if (mHandlerManu.size() == 0) {
						loadHandlerManuData(v);
					} else {
						showHandlerManuDialog(v);
					}
					xa708.clearFocus();
				}
			}
		});
		xa709.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {

				xa709.setInputType(InputType.TYPE_NULL); // 關閉軟鍵盤
				return false;
			}
		});
		xa709.setOnFocusChangeListener(new OnFocusChangeListener() {
			public void onFocusChange(View v, boolean hasFocus) {

				// System.out.println("===>Line number: "+new
				// Throwable().getStackTrace()[0].getLineNumber());

				if (hasFocus) {
					InputMethodManager imm = (InputMethodManager) getActivity()
							.getSystemService(Context.INPUT_METHOD_SERVICE);
					imm.hideSoftInputFromWindow(xa709.getWindowToken(), 0);
					// 載入
					if (mHandlerModel.size() == 0) {
						loadHandlerModelData(v);
					} else {
						showHandlerModelDialog(v);
					}
					xa709.clearFocus();
				}
			}
		});
		xa710.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {

				xa710.setInputType(InputType.TYPE_NULL); // 關閉軟鍵盤
				return false;
			}
		});
		xa710.setOnFocusChangeListener(new OnFocusChangeListener() {
			public void onFocusChange(View v, boolean hasFocus) {

				// System.out.println("===>Line number: "+new
				// Throwable().getStackTrace()[0].getLineNumber());

				if (hasFocus) {
					InputMethodManager imm = (InputMethodManager) getActivity()
							.getSystemService(Context.INPUT_METHOD_SERVICE);
					imm.hideSoftInputFromWindow(xa710.getWindowToken(), 0);
					// 載入
					if (mTesterManu.size() == 0) {
						loadTesterManuData(v);
					} else {
						showTesterManuDialog(v);
					}
					xa710.clearFocus();
				}
			}
		});
		xa711.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {

				xa711.setInputType(InputType.TYPE_NULL); // 關閉軟鍵盤
				return false;
			}
		});
		xa711.setOnFocusChangeListener(new OnFocusChangeListener() {
			public void onFocusChange(View v, boolean hasFocus) {

				// System.out.println("===>Line number: "+new
				// Throwable().getStackTrace()[0].getLineNumber());

				if (hasFocus) {
					InputMethodManager imm = (InputMethodManager) getActivity()
							.getSystemService(Context.INPUT_METHOD_SERVICE);
					imm.hideSoftInputFromWindow(xa711.getWindowToken(), 0);
					// 載入
					if (mTesterModel.size() == 0) {
						loadTesterModelData(v);
					} else {
						showTesterModelDialog(v);
					}
					xa711.clearFocus();
				}
			}
		});
	}

	private void setupTabAEditKeyboard(View view) {
		ef_xa518.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {

				ef_xa518.setInputType(InputType.TYPE_NULL); // 關閉軟鍵盤
				return false;
			}
		});
		ef_xa518.setOnFocusChangeListener(new OnFocusChangeListener() {
			public void onFocusChange(View v, boolean hasFocus) {

				// System.out.println("===>Line number: "+new
				// Throwable().getStackTrace()[0].getLineNumber());

				if (hasFocus) {
					InputMethodManager imm = (InputMethodManager) getActivity()
							.getSystemService(Context.INPUT_METHOD_SERVICE);
					imm.hideSoftInputFromWindow(ef_xa518.getWindowToken(), 0);
					showPackageTypeDialog(v);
					ef_xa518.clearFocus();
				}
			}
		});
		// PlugType
		xa832.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {

				xa832.setInputType(InputType.TYPE_NULL); // 關閉軟鍵盤
				return false;
			}
		});
		xa832.setOnFocusChangeListener(new OnFocusChangeListener() {
			public void onFocusChange(View v, boolean hasFocus) {

				// System.out.println("===>Line number: "+new
				// Throwable().getStackTrace()[0].getLineNumber());

				if (hasFocus) {
					InputMethodManager imm = (InputMethodManager) getActivity()
							.getSystemService(Context.INPUT_METHOD_SERVICE);
					imm.hideSoftInputFromWindow(xa832.getWindowToken(), 0);
					showDateDialog(v);
					xa832.clearFocus();
				}
			}
		});

		// PlugType
		xa849.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {

				xa849.setInputType(InputType.TYPE_NULL); // 關閉軟鍵盤
				return false;
			}
		});
		xa849.setOnFocusChangeListener(new OnFocusChangeListener() {
			public void onFocusChange(View v, boolean hasFocus) {
				if (hasFocus) {
					InputMethodManager imm = (InputMethodManager) getActivity()
							.getSystemService(Context.INPUT_METHOD_SERVICE);
					imm.hideSoftInputFromWindow(xa849.getWindowToken(), 0);
					loadEFPlugData(v);
					xa849.clearFocus();
				}
			}
		});

	}

	private void setupTabDEditKeyboard(View view) {
		xa00a.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {

				xa00a.setInputType(InputType.TYPE_NULL); // 關閉軟鍵盤
				return false;
			}
		});
		xa00a.setOnFocusChangeListener(new OnFocusChangeListener() {
			public void onFocusChange(View v, boolean hasFocus) {

				// System.out.println("===>Line number: "+new
				// Throwable().getStackTrace()[0].getLineNumber());

				if (hasFocus) {
					InputMethodManager imm = (InputMethodManager) getActivity()
							.getSystemService(Context.INPUT_METHOD_SERVICE);
					imm.hideSoftInputFromWindow(xa00a.getWindowToken(), 0);
					if (mProductsCategory.size() == 0) {
						loadProductsCategoryData(v);
					} else {
						showProductsCategoryDialog(v);
					}
					xa00a.clearFocus();
				}
			}
		});
		xa00b.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {

				xa00b.setInputType(InputType.TYPE_NULL); // 關閉軟鍵盤
				return false;
			}
		});
		xa00b.setOnFocusChangeListener(new OnFocusChangeListener() {
			public void onFocusChange(View v, boolean hasFocus) {

				// System.out.println("===>Line number: "+new
				// Throwable().getStackTrace()[0].getLineNumber());

				if (hasFocus) {
					InputMethodManager imm = (InputMethodManager) getActivity()
							.getSystemService(Context.INPUT_METHOD_SERVICE);
					imm.hideSoftInputFromWindow(xa00b.getWindowToken(), 0);
					if (mTestingMethodology.size() == 0) {
						loadTestingMethodologyData(v);
					} else {
						showTestingMethodologyDialog(v);
					}
					xa00b.clearFocus();
				}
			}
		});
		xa00c.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {

				xa00c.setInputType(InputType.TYPE_NULL); // 關閉軟鍵盤
				return false;
			}
		});
		xa00c.setOnFocusChangeListener(new OnFocusChangeListener() {
			public void onFocusChange(View v, boolean hasFocus) {

				// System.out.println("===>Line number: "+new
				// Throwable().getStackTrace()[0].getLineNumber());

				if (hasFocus) {
					InputMethodManager imm = (InputMethodManager) getActivity()
							.getSystemService(Context.INPUT_METHOD_SERVICE);
					imm.hideSoftInputFromWindow(xa00c.getWindowToken(), 0);
					if (mContactElementType.size() == 0) {
						loadContactElementTypeData(v);
					} else {
						showContactElementTypeDialog(v);
					}
					xa00c.clearFocus();
				}
			}
		});
	}

	public static void setEditTextReadOnly(TextView view) {
		// view.setTextColor(R.color.read_only_color); //設置顏色，使其看起來像只讀模式
		if (view instanceof android.widget.EditText) {
			view.setCursorVisible(false); // 設置光標不可見
			view.setFocusable(false); // 無焦點
			view.setFocusableInTouchMode(false); // 觸摸時也得不到焦點
		}
	}

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
		// showDialog(DATE_DIALOG_ID);
		mEdit = (EditText) view;
		DatePickerDialog d = new DatePickerDialog(getActivity(),
				mDateSetListener, mYear, mMonth, mDay);
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

	public void showCSDialog(View view) {
		Fragment fragment = new CSListActivity();
		openDialog(fragment, "CS");
	}

	public void showCustDialog(View view) {
		Fragment fragment = new CustListActivity();
		openDialog(fragment, "Cust");
	}

	public void showEndCustDialog(View view) {
		EndCustListActivity activity = new EndCustListActivity();
		openDialog((Fragment) activity, "EndCust");
	}

	public void showEndCustDialog(View view, ICallback callback) {
		EndCustListActivity activity = new EndCustListActivity();
		activity.setCallback(callback);
		openDialog((Fragment) activity, "EndCust");
	}

	public void showOSATDialog(View view, ICallback callback) {
		if (xa004.getText().toString().equals("") == true) {
			return;
		}
		OSATListActivity activity = new OSATListActivity();
		activity.setCallback(callback);
		Bundle b = new Bundle();
		b.putString("XD003", xa004.getText().toString());
		activity.setArguments(b);
		activity.parent = this;
		openDialog((Fragment) activity, "OSAT");
	}

	public void showAddressDialog(View view) {
		Fragment fragment = new AddressListActivity();
		Bundle args = new Bundle();
		args.putString("cust_no", xa004.getText().toString());
		fragment.setArguments(args);
		openDialog(fragment, "Address");
	}

	public void showContactDialog(View view) {
		Fragment fragment = new ContactListActivity();
		Bundle args = new Bundle();
		args.putString("cust_no", xa004.getText().toString());
		fragment.setArguments(args);
		openDialog(fragment, "Contact");
	}

	public void showRegionDialog(final View view) {
		AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity());
		dialog.setTitle("Region").setIcon(android.R.drawable.ic_dialog_info);
		DialogInterface.OnClickListener okListener = new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface d, int which) {

				// System.out.println("===>Line number: "+new
				// Throwable().getStackTrace()[0].getLineNumber());

				xa553.setText(mRegion[which]);
				((EditText) view).clearFocus();
				d.dismiss();
			}
		};
		DialogInterface.OnClickListener cancelListener = new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface d, int which) {

				// System.out.println("===>Line number: "+new
				// Throwable().getStackTrace()[0].getLineNumber());

				((EditText) view).clearFocus();
				d.dismiss();
			}
		};
		dialog.setSingleChoiceItems(mRegion, 0, okListener);
		dialog.setNegativeButton("Cancel", cancelListener);
		dialog.show();

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

	public void showPlugTypeDialog(final View view) {

		AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity());
		dialog.setTitle("EFluxpowerplug").setIcon(
				android.R.drawable.ic_dialog_info);
		DialogInterface.OnClickListener okListener = new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface d, int which) {
				ListView lv = ((AlertDialog) d).getListView();
				Integer selected = (Integer) lv.getTag();
				if (selected != null) {
					((EditText) view).setText(mPlugType.get(selected));
					((EditText) view).setTag(mPlugTypeValue.get(selected));
					loadEFPlugImage(mPlugTypeValue.get(selected));
				} else {
					selected = 0;
					((EditText) view).setText(mPlugType.get(selected));
					((EditText) view).setTag(mPlugTypeValue.get(selected));
					loadEFPlugImage(mPlugTypeValue.get(selected));
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
		String[] mString = new String[mPlugType.size()];
		for (int i = 0; i < mPlugType.size(); i++) {
			mString[i] = mPlugType.get(i);
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

	public void showFAEUserDialog(final View view) {
		AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity());
		dialog.setTitle("FAE User").setIcon(android.R.drawable.ic_dialog_info);
		DialogInterface.OnClickListener okListener = new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface d, int which) {
				ListView lv = ((AlertDialog) d).getListView();
				Integer selected = (Integer) lv.getTag();
				if (selected != null) {
					((EditText) view).setText(mFAEUsers.get(selected));
					((EditText) view).setTag(mFAEUsers.get(selected));
				} else {
					selected = 0;
					((EditText) view).setText(mFAEUsers.get(selected));
					((EditText) view).setTag(mFAEUsersValue.get(selected));
				}
				((EditText) view).clearFocus();
				d.dismiss();
				d = null;
			}
		};
		DialogInterface.OnClickListener cancelListener = new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface d, int which) {
				((EditText) view).clearFocus();
				d.dismiss();
				d = null;
			}
		};
		String[] mString = new String[mFAEUsers.size()];
		for (int i = 0; i < mFAEUsers.size(); i++) {
			mString[i] = mFAEUsers.get(i);
		}
		dialog.setSingleChoiceItems(mString, 0,
				new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface d, int which) {
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
		activity.setCallback(new BaseFragment.ICallback() {
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

	public void showProductsCategoryDialog(final View view) {
		AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity());
		dialog.setTitle("Product Category").setIcon(
				android.R.drawable.ic_dialog_info);
		DialogInterface.OnClickListener okListener = new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface d, int which) {
				ListView lv = ((AlertDialog) d).getListView();
				Integer selected = (Integer) lv.getTag();
				if (selected != null) {
					((EditText) view).setText(mProductsCategory.get(selected));

				} else {
					selected = 0;
					((EditText) view).setText(mProductsCategory.get(selected));
				}
				((EditText) view).clearFocus();
				d.dismiss();
				d = null;
			}
		};
		DialogInterface.OnClickListener cancelListener = new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface d, int which) {
				((EditText) view).clearFocus();
				d.dismiss();
				d = null;
			}
		};
		String[] mString = new String[mProductsCategory.size()];
		for (int i = 0; i < mProductsCategory.size(); i++) {
			mString[i] = mProductsCategory.get(i);
		}
		dialog.setSingleChoiceItems(mString, 0,
				new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface d, int which) {
						ListView lv = ((AlertDialog) d).getListView();
						lv.setTag(new Integer(which));
					}
				});
		dialog.setPositiveButton("Ok", okListener);
		dialog.setNegativeButton("Cancel", cancelListener);
		dialog.show();

	}

	public void showTestingMethodologyDialog(final View view) {
		AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity());
		dialog.setTitle("TestingMethodology").setIcon(
				android.R.drawable.ic_dialog_info);
		DialogInterface.OnClickListener okListener = new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface d, int which) {
				ListView lv = ((AlertDialog) d).getListView();
				Integer selected = (Integer) lv.getTag();
				if (selected != null) {
					((EditText) view)
							.setText(mTestingMethodology.get(selected));

				} else {
					selected = 0;
					((EditText) view)
							.setText(mTestingMethodology.get(selected));
				}
				((EditText) view).clearFocus();
				d.dismiss();
				d = null;
			}
		};
		DialogInterface.OnClickListener cancelListener = new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface d, int which) {
				((EditText) view).clearFocus();
				d.dismiss();
				d = null;
			}
		};
		String[] mString = new String[mTestingMethodology.size()];
		for (int i = 0; i < mTestingMethodology.size(); i++) {
			mString[i] = mTestingMethodology.get(i);
		}
		dialog.setSingleChoiceItems(mString, 0,
				new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface d, int which) {
						ListView lv = ((AlertDialog) d).getListView();
						lv.setTag(new Integer(which));
					}
				});
		dialog.setPositiveButton("Ok", okListener);
		dialog.setNegativeButton("Cancel", cancelListener);
		dialog.show();

	}

	public void showContactElementTypeDialog(final View view) {
		AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity());
		dialog.setTitle("ContactElementType").setIcon(
				android.R.drawable.ic_dialog_info);
		DialogInterface.OnClickListener okListener = new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface d, int which) {
				ListView lv = ((AlertDialog) d).getListView();
				Integer selected = (Integer) lv.getTag();
				if (selected != null) {
					((EditText) view)
							.setText(mContactElementType.get(selected));

				} else {
					selected = 0;
					((EditText) view)
							.setText(mContactElementType.get(selected));
				}
				((EditText) view).clearFocus();
				d.dismiss();
				d = null;
			}
		};
		DialogInterface.OnClickListener cancelListener = new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface d, int which) {
				((EditText) view).clearFocus();
				d.dismiss();
				d = null;
			}
		};
		String[] mString = new String[mContactElementType.size()];
		for (int i = 0; i < mContactElementType.size(); i++) {
			mString[i] = mContactElementType.get(i);
		}
		dialog.setSingleChoiceItems(mString, 0,
				new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface d, int which) {
						ListView lv = ((AlertDialog) d).getListView();
						lv.setTag(new Integer(which));
					}
				});
		dialog.setPositiveButton("Ok", okListener);
		dialog.setNegativeButton("Cancel", cancelListener);
		dialog.show();

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
			func = "updateAPQP1";
			data = getInputData1(action);

		} else if (tab2.getVisibility() == View.VISIBLE) {
			func = "updateAPQP2";
			data = getInputData2(action);

		} else if (tab3.getVisibility() == View.VISIBLE) {
			func = "updateAPQP3";
			data = getInputData3(action);

		} else if (tab4.getVisibility() == View.VISIBLE) {
			func = "updateAPQP4";
			data = getInputData4(action);

		} else if (tab5.getVisibility() == View.VISIBLE) {
			func = "updateAPQP5";
			data = getInputData5(action);

		} else if (tab6.getVisibility() == View.VISIBLE) {
			func = "updateAPQP6";
			data = getInputData6(action);

		} else if (tab7.getVisibility() == View.VISIBLE) {
			func = "updateAPQP7";
			data = getInputData7(action);

		} else if (tab8.getVisibility() == View.VISIBLE) {
			func = "updateAPQP8";
			data = getInputData8(action);
		} else if (tab9.getVisibility() == View.VISIBLE) {
			func = "updateAPQP9";
			data = getInputData9(action);

		} else if (taba.getVisibility() == View.VISIBLE) {
			func = "updateAPQPA";
			data = getInputDataA(action);

		} else if (tabb.getVisibility() == View.VISIBLE) {
			func = "updateAPQPB";
			data = getInputDataB(action);

		} else if (tabd.getVisibility() == View.VISIBLE) {
			func = "updateAPQPD";
			data = getInputDataD(action);

		}
		/*
		 * queryData((String) getWebServiceUrl() + func, data, new
		 * IDataReceiveListener() { public void onReceiveData(Object obj) {
		 * 
		 * } });
		 */
		task1.setCallback(new BaseFragment.ICallback() {

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
	 * 將APQP =>TAB 1 =>Customer Infomations user編輯資料上傳到webservice
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

		func = "updateAPQP1";
		data = getInputData1(action);// get data from user input
		task1.setCallback(new BaseFragment.ICallback() {
			@Override
			public void doWork(Object obj) {

				try {

					JSONObject jsonObject = new JSONObject((String) obj);
					if (jsonObject.getString("success").equals("false")) {
						showDialog("error", jsonObject.getString("remark"));
					} else {
						JSONObject data = jsonObject.getJSONObject("data");
						btnEdit.setTag(data.getString("editable"));
						btnIssue.setTag(data.getString("issuable"));
						btnChange.setTag(data.getString("xa068"));
						xa591 = data.getString("xa591");
						xa593 = data.getString("xa593");
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
	 * 將APQP =>TAB 2 =>Package Information user編輯資料上傳到webservice
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

		func = "updateAPQP2";
		data = getInputData2(action);
		task1.setCallback(new BaseFragment.ICallback() {
			@Override
			public void doWork(Object obj) {

				try {

					JSONObject jsonObject = new JSONObject((String) obj);
					if (jsonObject.getString("success").equals("false")) {
						showDialog("error", jsonObject.getString("remark"));
					} else {
						JSONObject data = jsonObject.getJSONObject("data");
						btnEdit.setTag(data.getString("editable"));
						btnIssue.setTag(data.getString("issuable"));
						btnChange.setTag(data.getString("xa068"));
						xa591 = data.getString("xa591");
						xa593 = data.getString("xa593");
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
	 * 將APQP =>TAB 3 =>Hander user編輯資料上傳到webservice
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

		func = "updateAPQP3";
		data = getInputData3(action);
		task1.setCallback(new BaseFragment.ICallback() {
			@Override
			public void doWork(Object obj) {

				try {

					JSONObject jsonObject = new JSONObject((String) obj);
					if (jsonObject.getString("success").equals("false")) {
						showDialog("error", jsonObject.getString("remark"));
					} else {
						JSONObject data = jsonObject.getJSONObject("data");
						btnEdit.setTag(data.getString("editable"));
						btnIssue.setTag(data.getString("issuable"));
						btnChange.setTag(data.getString("xa068"));
						xa591 = data.getString("xa591");
						xa593 = data.getString("xa593");
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
	 * 將APQP =>TAB 4 =>Socket Application Information編輯資料上傳到webservice
	 * 
	 * @param action
	 *            (Save,Confirm,Changes)
	 */
	private void saveData4(final String action) {

		// System.out.println("===>Line number: "+new
		// Throwable().getStackTrace()[0].getLineNumber());

		HttpPostAsyncTask task1 = new HttpPostAsyncTask();
		JSONObject data = null;
		String func = "";
		func = "updateAPQP4";
		data = getInputData4(action);
		task1.setCallback(new BaseFragment.ICallback() {
			@Override
			public void doWork(Object obj) {

				try {

					JSONObject jsonObject = new JSONObject((String) obj);
					if (jsonObject.getString("success").equals("false")) {
						showDialog("error", jsonObject.getString("remark"));
					} else {
						JSONObject data = jsonObject.getJSONObject("data");
						btnEdit.setTag(data.getString("editable"));
						btnIssue.setTag(data.getString("issuable"));
						btnChange.setTag(data.getString("xa068"));
						xa591 = data.getString("xa591");
						xa593 = data.getString("xa593");
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
	 * 將APQP =>TAB 5 => Duplicationt user編輯資料上傳到webservice
	 * 
	 * @param action
	 *            (Save,Confirm,Changes)
	 */
	private void saveData5(final String action) {

		// System.out.println("===>Line number: "+new
		// Throwable().getStackTrace()[0].getLineNumber());

		HttpPostAsyncTask task1 = new HttpPostAsyncTask();
		JSONObject data = null;
		String func = "";
		func = "updateAPQP5";
		data = getInputData5(action);
		task1.setCallback(new BaseFragment.ICallback() {
			@Override
			public void doWork(Object obj) {

				try {

					JSONObject jsonObject = new JSONObject((String) obj);
					if (jsonObject.getString("success").equals("false")) {
						showDialog("error", jsonObject.getString("remark"));
					} else {
						JSONObject data = jsonObject.getJSONObject("data");
						btnEdit.setTag(data.getString("editable"));
						btnIssue.setTag(data.getString("issuable"));
						btnChange.setTag(data.getString("xa068"));
						xa591 = data.getString("xa591");
						xa593 = data.getString("xa593");
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
	 * 將APQP =>TAB 6 => WLCSP user編輯資料上傳到webservice
	 * 
	 * @param action
	 *            (Save,Confirm,Changes)
	 */
	private void saveData6(final String action) {

		// System.out.println("===>Line number: "+new
		// Throwable().getStackTrace()[0].getLineNumber());

		HttpPostAsyncTask task1 = new HttpPostAsyncTask();
		JSONObject data = null;
		String func = "";
		func = "updateAPQP6";
		data = getInputData6(action);
		task1.setCallback(new BaseFragment.ICallback() {
			@Override
			public void doWork(Object obj) {

				try {

					JSONObject jsonObject = new JSONObject((String) obj);
					if (jsonObject.getString("success").equals("false")) {
						showDialog("error", jsonObject.getString("remark"));
					} else {
						JSONObject data = jsonObject.getJSONObject("data");
						btnEdit.setTag(data.getString("editable"));
						btnIssue.setTag(data.getString("issuable"));
						btnChange.setTag(data.getString("xa068"));
						xa591 = data.getString("xa591");
						xa593 = data.getString("xa593");
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
	 * 將APQP =>TAB 7 => ATC user編輯資料上傳到webservice
	 * 
	 * @param action
	 *            (Save,Confirm,Changes)
	 */
	private void saveData7(final String action) {

		// System.out.println("===>Line number: "+new
		// Throwable().getStackTrace()[0].getLineNumber());

		HttpPostAsyncTask task1 = new HttpPostAsyncTask();
		JSONObject data = null;
		String func = "";
		func = "updateAPQP7";
		data = getInputData7(action);

		task1.setCallback(new BaseFragment.ICallback() {
			@Override
			public void doWork(Object obj) {

				try {

					JSONObject jsonObject = new JSONObject((String) obj);
					if (jsonObject.getString("success").equals("false")) {
						showDialog("error", jsonObject.getString("remark"));
					} else {
						JSONObject data = jsonObject.getJSONObject("data");
						btnEdit.setTag(data.getString("editable"));
						btnIssue.setTag(data.getString("issuable"));
						btnChange.setTag(data.getString("xa068"));
						xa591 = data.getString("xa591");
						xa593 = data.getString("xa593");
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
	 * 將APQP =>TAB 8 => FinePitch ProbeCard user編輯資料上傳到webservice
	 * 
	 * @param action
	 *            (Save,Confirm,Changes)
	 */
	private void saveData8(final String action) {

		// System.out.println("===>Line number: "+new
		// Throwable().getStackTrace()[0].getLineNumber());

		HttpPostAsyncTask task1 = new HttpPostAsyncTask();
		JSONObject data = null;
		String func = "";
		func = "updateAPQP8";
		data = getInputData8(action);
		task1.setCallback(new BaseFragment.ICallback() {
			@Override
			public void doWork(Object obj) {

				try {

					JSONObject jsonObject = new JSONObject((String) obj);
					if (jsonObject.getString("success").equals("false")) {
						showDialog("error", jsonObject.getString("remark"));
					} else {
						JSONObject data = jsonObject.getJSONObject("data");
						btnEdit.setTag(data.getString("editable"));
						btnIssue.setTag(data.getString("issuable"));
						btnChange.setTag(data.getString("xa068"));
						xa591 = data.getString("xa591");
						xa593 = data.getString("xa593");
						xa049.setText(data.getString("xa049"));
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
	 * 將APQP =>TAB 9 => Changeover Kit user編輯資料上傳到webservice
	 * 
	 * @param action
	 *            (Save,Confirm,Changes)
	 */
	private void saveData9(final String action) {

		// System.out.println("===>Line number: "+new
		// Throwable().getStackTrace()[0].getLineNumber());

		HttpPostAsyncTask task1 = new HttpPostAsyncTask();
		JSONObject data = null;
		String func = "";
		func = "updateAPQP9";
		data = getInputData9(action);
		task1.setCallback(new BaseFragment.ICallback() {
			@Override
			public void doWork(Object obj) {

				try {

					JSONObject jsonObject = new JSONObject((String) obj);
					if (jsonObject.getString("success").equals("false")) {
						showDialog("error", jsonObject.getString("remark"));
					} else {
						JSONObject data = jsonObject.getJSONObject("data");
						btnEdit.setTag(data.getString("editable"));
						btnIssue.setTag(data.getString("issuable"));
						btnChange.setTag(data.getString("xa068"));
						xa591 = data.getString("xa591");
						xa593 = data.getString("xa593");
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
	 * 將APQP =>TAB A => E-Flux user編輯資料上傳到webservice
	 * 
	 * @param action
	 *            (Save,Confirm,Changes)
	 */
	private void saveDataA(final String action) {

		// System.out.println("===>Line number: "+new
		// Throwable().getStackTrace()[0].getLineNumber());

		HttpPostAsyncTask task1 = new HttpPostAsyncTask();
		JSONObject data = null;
		String func = "";
		func = "updateAPQPA";
		data = getInputDataA(action);
		task1.setCallback(new BaseFragment.ICallback() {
			@Override
			public void doWork(Object obj) {

				try {

					JSONObject jsonObject = new JSONObject((String) obj);
					if (jsonObject.getString("success").equals("false")) {
						showDialog("error", jsonObject.getString("remark"));
					} else {
						JSONObject data = jsonObject.getJSONObject("data");
						btnEdit.setTag(data.getString("editable"));
						btnIssue.setTag(data.getString("issuable"));
						btnChange.setTag(data.getString("xa068"));
						xa591 = data.getString("xa591");
						xa593 = data.getString("xa593");
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
	 * 將APQP =>TAB B => Comment user編輯資料上傳到webservice
	 * 
	 * @param action
	 *            (Save,Confirm,Changes)
	 */
	private void saveDataB(final String action) {

		// System.out.println("===>Line number: "+new
		// Throwable().getStackTrace()[0].getLineNumber());

		HttpPostAsyncTask task1 = new HttpPostAsyncTask();
		JSONObject data = null;
		String func = "";
		func = "updateAPQPB";
		data = getInputDataB(action);
		task1.setCallback(new BaseFragment.ICallback() {
			@Override
			public void doWork(Object obj) {

				try {

					JSONObject jsonObject = new JSONObject((String) obj);
					if (jsonObject.getString("success").equals("false")) {
						showDialog("error", jsonObject.getString("remark"));
					} else {
						JSONObject data = jsonObject.getJSONObject("data");
						btnEdit.setTag(data.getString("editable"));
						btnIssue.setTag(data.getString("issuable"));
						btnChange.setTag(data.getString("xa068"));
						xa591 = data.getString("xa591");
						xa593 = data.getString("xa593");
						//xa001 = data.getString("xa001");
						//xa002 = data.getString("xa002");
						xa59r.setText(data.getString("xa59r"));
						xa049.setText(data.getString("xa049"));
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
	 * 將APQP =>TAB D => Forecast user編輯資料上傳到webservice
	 * 
	 * @param action
	 *            (Save,Confirm,Changes)
	 */
	private void saveDataD(final String action) {

		// System.out.println("===>Line number: "+new
		// Throwable().getStackTrace()[0].getLineNumber());

		HttpPostAsyncTask task1 = new HttpPostAsyncTask();
		JSONObject data = null;
		String func = "";
		func = "updateAPQPD";
		data = getInputDataD(action);
		task1.setCallback(new BaseFragment.ICallback() {
			@Override
			public void doWork(Object obj) {

				try {

					JSONObject jsonObject = new JSONObject((String) obj);
					if (jsonObject.getString("success").equals("false")) {
						showDialog("error", jsonObject.getString("remark"));
					} else {
						JSONObject data = jsonObject.getJSONObject("data");
						btnEdit.setTag(data.getString("editable"));
						btnIssue.setTag(data.getString("issuable"));
						btnChange.setTag(data.getString("xa068"));
						xa591 = data.getString("xa591");
						xa593 = data.getString("xa593");
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

	private void setLayout1UI(final String xa001,final String xa002)
	{		
		l2.setText("2.");
		b2.setText("Package");
		l5.setText("B.");
		b5.setText("Comment");
		l4.setText("4.");
		b4.setText("Socket App");
		//b1.setTag("0");
		b1.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				int tag = Integer.parseInt(v.getTag().toString());
				vwSubTitle.setText(b1.getText());
				// if (tabbar != null)
				// tabbar.setVisibility(RelativeLayout.GONE);
				if (tab2 != null
						&& tab2.getVisibility() == RelativeLayout.VISIBLE)
					tab2.setVisibility(RelativeLayout.GONE);
				if (tab3 != null
						&& tab3.getVisibility() == RelativeLayout.VISIBLE)
					tab3.setVisibility(RelativeLayout.GONE);
				if (tab4 != null
						&& tab4.getVisibility() == RelativeLayout.VISIBLE)
					tab4.setVisibility(RelativeLayout.GONE);
				if (tabb != null
						&& tabb.getVisibility() == RelativeLayout.VISIBLE)
					tabb.setVisibility(RelativeLayout.GONE);
				if (tabd != null
						&& tabd.getVisibility() == RelativeLayout.VISIBLE)
					tabd.setVisibility(RelativeLayout.GONE);
				tab1.setVisibility(RelativeLayout.VISIBLE);
				if (cmdbar != null && !cmdbar.isShown()) {
					cmdbar.setVisibility(RelativeLayout.VISIBLE);
				}
				if (tag != 1) {
					queryData((String) getWebServiceUrl() + "getAPQP1",
							getAPQP1(xa001, xa002),
							new IDataReceiveListener() {
								public void onReceiveData(Object obj) {
									loadData(obj);
									b1.setTag(1);
								}
							});
				}
			}
		});
		b2.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {

				int tag = Integer.parseInt(v.getTag().toString());
				vwSubTitle.setText(b2.getText());
				// if (tabbar != null)
				// tabbar.setVisibility(RelativeLayout.GONE);
				if (tab1 != null
						&& tab1.getVisibility() == RelativeLayout.VISIBLE)
					tab1.setVisibility(RelativeLayout.GONE);
				if (tab3 != null
						&& tab3.getVisibility() == RelativeLayout.VISIBLE)
					tab3.setVisibility(RelativeLayout.GONE);
				if (tab4 != null
						&& tab4.getVisibility() == RelativeLayout.VISIBLE)
					tab4.setVisibility(RelativeLayout.GONE);
				if (tabb != null
						&& tabb.getVisibility() == RelativeLayout.VISIBLE) {
					tabb.setVisibility(RelativeLayout.GONE);
					commentbar.setVisibility(RelativeLayout.GONE);
				}
				if (tabd != null
						&& tabd.getVisibility() == RelativeLayout.VISIBLE) {
					tabd.setVisibility(RelativeLayout.GONE);
				}
				tab2.setVisibility(RelativeLayout.VISIBLE);
				if (cmdbar != null && !cmdbar.isShown()) {
					cmdbar.setVisibility(RelativeLayout.VISIBLE);
				}
				if (tag != 2) {
					queryData((String) getWebServiceUrl() + "getAPQP2",
							getAPQP2(xa001, xa002),
							new IDataReceiveListener() {
								public void onReceiveData(Object obj) {
									loadData2(obj);
									b2.setTag(2);
								}
							});
				}
			}
		});
		b3.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {

				int tag = Integer.parseInt(v.getTag().toString());
				vwSubTitle.setText(b3.getText());
				// if (tabbar != null)
				// tabbar.setVisibility(RelativeLayout.GONE);
				if (tab2 != null
						&& tab2.getVisibility() == RelativeLayout.VISIBLE)
					tab2.setVisibility(RelativeLayout.GONE);
				if (tab1 != null
						&& tab1.getVisibility() == RelativeLayout.VISIBLE)
					tab1.setVisibility(RelativeLayout.GONE);
				if (tab4 != null
						&& tab4.getVisibility() == RelativeLayout.VISIBLE)
					tab4.setVisibility(RelativeLayout.GONE);
				if (tabb != null
						&& tabb.getVisibility() == RelativeLayout.VISIBLE) {
					tabb.setVisibility(RelativeLayout.GONE);
					commentbar.setVisibility(RelativeLayout.GONE);
				}
				if (tabd != null
						&& tabd.getVisibility() == RelativeLayout.VISIBLE)
					tabd.setVisibility(RelativeLayout.GONE);
				tab3.setVisibility(RelativeLayout.VISIBLE);
				if (cmdbar != null && !cmdbar.isShown()) {
					cmdbar.setVisibility(RelativeLayout.VISIBLE);
				}
				if (tag != 3) {
					queryData((String) getWebServiceUrl() + "getAPQP3",
							getAPQP3(xa001, xa002),
							new IDataReceiveListener() {
								public void onReceiveData(Object obj) {
									loadData3(obj);
									b3.setTag(3);
								}
							});
				}
			}
		});
		b4.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {

				int tag = Integer.parseInt(v.getTag().toString());
				vwSubTitle.setText(b4.getText());
				// if (tabbar != null)
				// tabbar.setVisibility(RelativeLayout.GONE);
				if (tab2 != null
						&& tab2.getVisibility() == RelativeLayout.VISIBLE)
					tab2.setVisibility(RelativeLayout.GONE);
				if (tab3 != null
						&& tab3.getVisibility() == RelativeLayout.VISIBLE)
					tab3.setVisibility(RelativeLayout.GONE);
				if (tab1 != null
						&& tab1.getVisibility() == RelativeLayout.VISIBLE)
					tab1.setVisibility(RelativeLayout.GONE);
				if (tabb != null
						&& tabb.getVisibility() == RelativeLayout.VISIBLE) {
					tabb.setVisibility(RelativeLayout.GONE);
					commentbar.setVisibility(RelativeLayout.GONE);
				}
				if (tabd != null
						&& tabd.getVisibility() == RelativeLayout.VISIBLE)
					tabd.setVisibility(RelativeLayout.GONE);
				tab4.setVisibility(RelativeLayout.VISIBLE);
				if (cmdbar != null && !cmdbar.isShown()) {
					cmdbar.setVisibility(RelativeLayout.VISIBLE);
				}
				if (tag != 4) {
					queryData((String) getWebServiceUrl() + "getAPQP4",
							getAPQP4(xa001, xa002),
							new IDataReceiveListener() {
								public void onReceiveData(Object obj) {
									loadData4(obj);
									b4.setTag(4);
								}
							});
				}
			}
		});
		b5.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {

				int tag = (Integer) v.getTag();
				vwSubTitle.setText(b5.getText());
				// if (tabbar != null)
				// tabbar.setVisibility(RelativeLayout.GONE);
				if (tab2 != null
						&& tab2.getVisibility() == RelativeLayout.VISIBLE)
					tab2.setVisibility(RelativeLayout.GONE);
				if (tab3 != null
						&& tab3.getVisibility() == RelativeLayout.VISIBLE)
					tab3.setVisibility(RelativeLayout.GONE);
				if (tab4 != null
						&& tab4.getVisibility() == RelativeLayout.VISIBLE)
					tab4.setVisibility(RelativeLayout.GONE);
				if (tab1 != null
						&& tab1.getVisibility() == RelativeLayout.VISIBLE)
					tab1.setVisibility(RelativeLayout.GONE);
				if (tabd != null
						&& tabd.getVisibility() == RelativeLayout.VISIBLE)
					tabd.setVisibility(RelativeLayout.GONE);
				tabb.setVisibility(RelativeLayout.VISIBLE);
				commentbar.setVisibility(RelativeLayout.VISIBLE);
				btn_sale.setBackgroundColor(Color.BLACK);
				btn_fae.setBackgroundColor(Color.BLACK);
				final RelativeLayout tabb_r2 = (RelativeLayout) mView
						.findViewById(R.id.tabb_r2);
				final RelativeLayout tabb_r4 = (RelativeLayout) mView
						.findViewById(R.id.tabb_r4);
				final RelativeLayout tabb_r5 = (RelativeLayout) mView
						.findViewById(R.id.tabb_r5);
				tabb_r2.setVisibility(View.VISIBLE);
				tabb_r4.setVisibility(View.GONE);
				tabb_r5.setVisibility(View.GONE);
				tabr_l1.setTag("0");
				tabr_l1.setText("Add New Comments:");
				if (xa59r.getVisibility() == View.VISIBLE) {
					xa59r.setVisibility(View.GONE);
				}
				if (cmdbar != null && !cmdbar.isShown()) {
					cmdbar.setVisibility(RelativeLayout.VISIBLE);
				}
				if (tag != 11) {
					queryData((String) getWebServiceUrl() + "getAPQPB",
							getAPQPB(xa001, xa002),
							new IDataReceiveListener() {
								public void onReceiveData(Object obj) {
									loadDataB(obj);
									b5.setTag(11);
								}
							});
				}
			}
		});
		b6.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {

				int tag = (Integer) v.getTag();
				vwSubTitle.setText(b6.getText());
				// if (tabbar != null)
				// tabbar.setVisibility(RelativeLayout.GONE);
				if (tab2 != null
						&& tab2.getVisibility() == RelativeLayout.VISIBLE)
					tab2.setVisibility(RelativeLayout.GONE);
				if (tab3 != null
						&& tab3.getVisibility() == RelativeLayout.VISIBLE)
					tab3.setVisibility(RelativeLayout.GONE);
				if (tab4 != null
						&& tab4.getVisibility() == RelativeLayout.VISIBLE)
					tab4.setVisibility(RelativeLayout.GONE);
				if (tabb != null
						&& tabb.getVisibility() == RelativeLayout.VISIBLE) {
					tabb.setVisibility(RelativeLayout.GONE);
					commentbar.setVisibility(RelativeLayout.GONE);
				}
				if (tab1 != null
						&& tab1.getVisibility() == RelativeLayout.VISIBLE)
					tab1.setVisibility(RelativeLayout.GONE);
				tabd.setVisibility(RelativeLayout.VISIBLE);
				if (cmdbar != null && !cmdbar.isShown()) {
					cmdbar.setVisibility(RelativeLayout.VISIBLE);
				}
				if (tag != 13) {
					queryData((String) getWebServiceUrl() + "getAPQPD",
							getAPQPD(xa001, xa002),
							new IDataReceiveListener() {
								public void onReceiveData(Object obj) {
									loadDataD(obj);
									b6.setTag(13);
								}
							});
				}
			}
		});

	}
	private void setLayout2UI(final String xa001,final String xa002)
	{	
		l5.setVisibility(View.GONE);
		l6.setVisibility(View.GONE);
		b5.setVisibility(View.GONE);
		b6.setVisibility(View.GONE);
		r5.setBackgroundColor(Color.WHITE);
		r6.setBackgroundColor(Color.WHITE);
		l2.setText("5.");
		b2.setText("Duplication");
		b1.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
                int tag=Integer.parseInt(v.getTag().toString());
                vwSubTitle.setText(b1.getText());
				// if (tabbar != null)
				// tabbar.setVisibility(RelativeLayout.GONE);
				if (tab5 != null
						&& tab5.getVisibility() == RelativeLayout.VISIBLE)
					tab5.setVisibility(RelativeLayout.GONE);
				if (tabb != null
						&& tabb.getVisibility() == RelativeLayout.VISIBLE) {
					tabb.setVisibility(RelativeLayout.GONE);
					commentbar.setVisibility(RelativeLayout.GONE);
				}
				if (tabd != null
						&& tabd.getVisibility() == RelativeLayout.VISIBLE)
					tabd.setVisibility(RelativeLayout.GONE);
				tab1.setVisibility(RelativeLayout.VISIBLE);
				if (cmdbar != null && !cmdbar.isShown()) {
					cmdbar.setVisibility(RelativeLayout.VISIBLE);
				}
				if (tag !=1) {
					queryData((String) getWebServiceUrl() + "getAPQP1",
							getAPQP1(xa001, xa002), new IDataReceiveListener() {
								public void onReceiveData(Object obj) {
									loadData(obj);
									b1.setTag(1);
								}
							});
				}
			}
		});
		b2.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				int tag = (Integer) v.getTag();
				vwSubTitle.setText(b2.getText());
				// if (tabbar != null)
				// tabbar.setVisibility(RelativeLayout.GONE);
				if (tab1 != null
						&& tab1.getVisibility() == RelativeLayout.VISIBLE)
					tab1.setVisibility(RelativeLayout.GONE);
				if (tabd != null
						&& tabd.getVisibility() == RelativeLayout.VISIBLE)
					tabd.setVisibility(RelativeLayout.GONE);
				if (tabb != null
						&& tabb.getVisibility() == RelativeLayout.VISIBLE) {
					tabb.setVisibility(RelativeLayout.GONE);
					commentbar.setVisibility(RelativeLayout.GONE);
				}
				tab5.setVisibility(RelativeLayout.VISIBLE);
				if (cmdbar != null && !cmdbar.isShown()) {
					cmdbar.setVisibility(RelativeLayout.VISIBLE);
				}
				if (tag != 5) {
					queryData((String) getWebServiceUrl() + "getAPQP5",
							getAPQP5(xa001, xa002),
							new IDataReceiveListener() {
								public void onReceiveData(Object obj) {
									loadData5(obj);
									b2.setTag(5);
								}
							});
				}
			}
		});
		l3.setText("B.");
		b3.setText("Comment");
		///b3.setTag("0");
		l4.setText("D.");
		b4.setText("Forecast");
		b4.setTextSize(14.0f);
		//b4.setTag("0");
		b3.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				int tag = Integer.parseInt(v.getTag().toString());
				vwSubTitle.setText(b3.getText());
				// if (tabbar != null)
				// tabbar.setVisibility(RelativeLayout.GONE);
				if (tab1 != null
						&& tab1.getVisibility() == RelativeLayout.VISIBLE)
					tab1.setVisibility(RelativeLayout.GONE);
				if (tab2 != null
						&& tab2.getVisibility() == RelativeLayout.VISIBLE)
					tab2.setVisibility(RelativeLayout.GONE);
				if (tab3 != null
						&& tab3.getVisibility() == RelativeLayout.VISIBLE)
					tab3.setVisibility(RelativeLayout.GONE);
				if (tab4 != null
						&& tab4.getVisibility() == RelativeLayout.VISIBLE)
					tab4.setVisibility(RelativeLayout.GONE);
				if (tab5 != null
						&& tab5.getVisibility() == RelativeLayout.VISIBLE)
					tab5.setVisibility(RelativeLayout.GONE);
				if (tab6 != null
						&& tab6.getVisibility() == RelativeLayout.VISIBLE)
					tab6.setVisibility(RelativeLayout.GONE);
				if (tab7 != null
						&& tab7.getVisibility() == RelativeLayout.VISIBLE)
					tab7.setVisibility(RelativeLayout.GONE);
				if (tab8 != null
						&& tab8.getVisibility() == RelativeLayout.VISIBLE)
					tab8.setVisibility(RelativeLayout.GONE);
				if (tab9 != null
						&& tab9.getVisibility() == RelativeLayout.VISIBLE)
					tab9.setVisibility(RelativeLayout.GONE);
				if (taba != null
						&& taba.getVisibility() == RelativeLayout.VISIBLE)
					taba.setVisibility(RelativeLayout.GONE);
				if (tabd != null
						&& tabd.getVisibility() == RelativeLayout.VISIBLE)
					tabd.setVisibility(RelativeLayout.GONE);
				tabb.setVisibility(RelativeLayout.VISIBLE);
				commentbar.setVisibility(RelativeLayout.VISIBLE);
				// LinearLayout.LayoutParams
				// params=(LinearLayout.LayoutParams)tabb.getLayoutParams();
				// Point p=DisplayUtil.getScreenMetrics(context);
				// params.height=p.y-commentbar.getHeight()-tabbar.getHeight()-cmdbar.getHeight()-100;
				// tabb.setLayoutParams(params);
				btn_sale.setBackgroundColor(Color.BLACK);
				btn_fae.setBackgroundColor(Color.BLACK);
				tabr_l1.setTag("0");
				tabr_l1.setText("Add New Comments:");
				final RelativeLayout tabb_r2 = (RelativeLayout) mView
						.findViewById(R.id.tabb_r2);
				final RelativeLayout tabb_r4 = (RelativeLayout) mView
						.findViewById(R.id.tabb_r4);
				final RelativeLayout tabb_r5 = (RelativeLayout) mView
						.findViewById(R.id.tabb_r5);
				tabb_r2.setVisibility(View.VISIBLE);
				tabb_r4.setVisibility(View.GONE);
				tabb_r5.setVisibility(View.GONE);
				if (xa59r.getVisibility() == View.VISIBLE) {
					xa59r.setVisibility(View.GONE);
				}
				if (cmdbar != null && !cmdbar.isShown()) {
					cmdbar.setVisibility(RelativeLayout.VISIBLE);
				}
				if (tag != 11) {
					queryData((String) getWebServiceUrl() + "getAPQPB",
							getAPQPB(xa001, xa002),
							new IDataReceiveListener() {
								public void onReceiveData(Object obj) {
									loadDataB(obj);
									b3.setTag(11);
								}
							});
				}
			}
		});
		b4.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				int tag = Integer.parseInt(v.getTag().toString());
				vwSubTitle.setText(b4.getText());
				// if (tabbar != null)
				// tabbar.setVisibility(RelativeLayout.GONE);
				if (tab1 != null
						&& tab1.getVisibility() == RelativeLayout.VISIBLE)
					tab1.setVisibility(RelativeLayout.GONE);
				if (tab2 != null
						&& tab2.getVisibility() == RelativeLayout.VISIBLE)
					tab2.setVisibility(RelativeLayout.GONE);
				if (tab3 != null
						&& tab3.getVisibility() == RelativeLayout.VISIBLE)
					tab3.setVisibility(RelativeLayout.GONE);
				if (tab4 != null
						&& tab4.getVisibility() == RelativeLayout.VISIBLE)
					tab4.setVisibility(RelativeLayout.GONE);
				if (tab5 != null
						&& tab5.getVisibility() == RelativeLayout.VISIBLE)
					tab5.setVisibility(RelativeLayout.GONE);
				if (tab6 != null
						&& tab6.getVisibility() == RelativeLayout.VISIBLE)
					tab6.setVisibility(RelativeLayout.GONE);
				if (tab7 != null
						&& tab7.getVisibility() == RelativeLayout.VISIBLE)
					tab7.setVisibility(RelativeLayout.GONE);
				if (tab8 != null
						&& tab8.getVisibility() == RelativeLayout.VISIBLE)
					tab8.setVisibility(RelativeLayout.GONE);
				if (tab9 != null
						&& tab9.getVisibility() == RelativeLayout.VISIBLE)
					tab9.setVisibility(RelativeLayout.GONE);
				if (taba != null
						&& taba.getVisibility() == RelativeLayout.VISIBLE)
					taba.setVisibility(RelativeLayout.GONE);
				if (tabb != null
						&& tabb.getVisibility() == RelativeLayout.VISIBLE) {
					tabb.setVisibility(RelativeLayout.GONE);
					commentbar.setVisibility(RelativeLayout.GONE);
				}
				tabd.setVisibility(RelativeLayout.VISIBLE);
				if (cmdbar != null && !cmdbar.isShown()) {
					cmdbar.setVisibility(RelativeLayout.VISIBLE);
				}
				if (tag != 13) {
				queryData((String) getWebServiceUrl() + "getAPQPD",
						getAPQPD(xa001, xa002), new IDataReceiveListener() {
							public void onReceiveData(Object obj) {
								loadDataD(obj);
								b4.setTag("13");
							}
						});
				}
			}

		});

	
	}
	private void setLayout3UI(final String xa001,final String xa002)
	{	
		l5.setVisibility(View.GONE);
		l6.setVisibility(View.GONE);
		b5.setVisibility(View.GONE);
		b6.setVisibility(View.GONE);
		r5.setBackgroundColor(Color.WHITE);
		r6.setBackgroundColor(Color.WHITE);
		l2.setText("6.");
		b2.setText("WLCSP");
		b1.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
                int tag=Integer.parseInt(v.getTag().toString());
				vwSubTitle.setText("Customer Infor...");
				// if (tabbar != null)
				// tabbar.setVisibility(RelativeLayout.GONE);
				if (tab6 != null
						&& tab6.getVisibility() == RelativeLayout.VISIBLE)
					tab6.setVisibility(RelativeLayout.GONE);
				if (tabb != null
						&& tabb.getVisibility() == RelativeLayout.VISIBLE)
					tabb.setVisibility(RelativeLayout.GONE);
				if (tabd != null
						&& tabd.getVisibility() == RelativeLayout.VISIBLE)
					tabd.setVisibility(RelativeLayout.GONE);
				tab1.setVisibility(RelativeLayout.VISIBLE);
				if (cmdbar != null && !cmdbar.isShown()) {
					cmdbar.setVisibility(RelativeLayout.VISIBLE);
				}
				if (tag !=1) {
					queryData((String) getWebServiceUrl() + "getAPQP1",
							getAPQP1(xa001, xa002), new IDataReceiveListener() {
								public void onReceiveData(Object obj) {
									loadData(obj);
									b1.setTag(1);
								}
							});
				}
			}
		});
		b2.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				int tag = Integer.parseInt(v.getTag().toString());
				vwSubTitle.setText(b2.getText());
				// if (tabbar != null)
				// tabbar.setVisibility(RelativeLayout.GONE);
				if (tab1 != null
						&& tab1.getVisibility() == RelativeLayout.VISIBLE)
					tab1.setVisibility(RelativeLayout.GONE);
				if (tabd != null
						&& tabd.getVisibility() == RelativeLayout.VISIBLE)
					tabd.setVisibility(RelativeLayout.GONE);
				if (tabb != null
						&& tabb.getVisibility() == RelativeLayout.VISIBLE) {
					tabb.setVisibility(RelativeLayout.GONE);
					commentbar.setVisibility(RelativeLayout.GONE);
				}
				tab6.setVisibility(RelativeLayout.VISIBLE);
				if (cmdbar != null && !cmdbar.isShown()) {
					cmdbar.setVisibility(RelativeLayout.VISIBLE);
				}
				if (tag != 6) {
					queryData((String) getWebServiceUrl() + "getAPQP6",
							getAPQP6(xa001, xa002),
							new IDataReceiveListener() {
								public void onReceiveData(Object obj) {
									loadData6(obj);
									b2.setTag(6);
								}
							});
				}
			}
		});
		l3.setText("B.");
		b3.setText("Comment");
		///b3.setTag("0");
		l4.setText("D.");
		b4.setText("Forecast");
		b4.setTextSize(14.0f);
		//b4.setTag("0");
		b3.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				int tag = Integer.parseInt(v.getTag().toString());
				vwSubTitle.setText(b3.getText());
				// if (tabbar != null)
				// tabbar.setVisibility(RelativeLayout.GONE);
				if (tab1 != null
						&& tab1.getVisibility() == RelativeLayout.VISIBLE)
					tab1.setVisibility(RelativeLayout.GONE);
				if (tab2 != null
						&& tab2.getVisibility() == RelativeLayout.VISIBLE)
					tab2.setVisibility(RelativeLayout.GONE);
				if (tab3 != null
						&& tab3.getVisibility() == RelativeLayout.VISIBLE)
					tab3.setVisibility(RelativeLayout.GONE);
				if (tab4 != null
						&& tab4.getVisibility() == RelativeLayout.VISIBLE)
					tab4.setVisibility(RelativeLayout.GONE);
				if (tab5 != null
						&& tab5.getVisibility() == RelativeLayout.VISIBLE)
					tab5.setVisibility(RelativeLayout.GONE);
				if (tab6 != null
						&& tab6.getVisibility() == RelativeLayout.VISIBLE)
					tab6.setVisibility(RelativeLayout.GONE);
				if (tab7 != null
						&& tab7.getVisibility() == RelativeLayout.VISIBLE)
					tab7.setVisibility(RelativeLayout.GONE);
				if (tab8 != null
						&& tab8.getVisibility() == RelativeLayout.VISIBLE)
					tab8.setVisibility(RelativeLayout.GONE);
				if (tab9 != null
						&& tab9.getVisibility() == RelativeLayout.VISIBLE)
					tab9.setVisibility(RelativeLayout.GONE);
				if (taba != null
						&& taba.getVisibility() == RelativeLayout.VISIBLE)
					taba.setVisibility(RelativeLayout.GONE);
				if (tabd != null
						&& tabd.getVisibility() == RelativeLayout.VISIBLE)
					tabd.setVisibility(RelativeLayout.GONE);
				tabb.setVisibility(RelativeLayout.VISIBLE);
				commentbar.setVisibility(RelativeLayout.VISIBLE);
				// LinearLayout.LayoutParams
				// params=(LinearLayout.LayoutParams)tabb.getLayoutParams();
				// Point p=DisplayUtil.getScreenMetrics(context);
				// params.height=p.y-commentbar.getHeight()-tabbar.getHeight()-cmdbar.getHeight()-100;
				// tabb.setLayoutParams(params);
				btn_sale.setBackgroundColor(Color.BLACK);
				btn_fae.setBackgroundColor(Color.BLACK);
				tabr_l1.setTag("0");
				tabr_l1.setText("Add New Comments:");
				final RelativeLayout tabb_r2 = (RelativeLayout) mView
						.findViewById(R.id.tabb_r2);
				final RelativeLayout tabb_r4 = (RelativeLayout) mView
						.findViewById(R.id.tabb_r4);
				final RelativeLayout tabb_r5 = (RelativeLayout) mView
						.findViewById(R.id.tabb_r5);
				tabb_r2.setVisibility(View.VISIBLE);
				tabb_r4.setVisibility(View.GONE);
				tabb_r5.setVisibility(View.GONE);
				if (xa59r.getVisibility() == View.VISIBLE) {
					xa59r.setVisibility(View.GONE);
				}
				if (cmdbar != null && !cmdbar.isShown()) {
					cmdbar.setVisibility(RelativeLayout.VISIBLE);
				}
				if (tag != 11) {
					queryData((String) getWebServiceUrl() + "getAPQPB",
							getAPQPB(xa001, xa002),
							new IDataReceiveListener() {
								public void onReceiveData(Object obj) {
									loadDataB(obj);
									b3.setTag(11);
								}
							});
				}
			}
		});
		b4.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				int tag = Integer.parseInt(v.getTag().toString());
				vwSubTitle.setText(b4.getText());
				// if (tabbar != null)
				// tabbar.setVisibility(RelativeLayout.GONE);
				if (tab1 != null
						&& tab1.getVisibility() == RelativeLayout.VISIBLE)
					tab1.setVisibility(RelativeLayout.GONE);
				if (tab2 != null
						&& tab2.getVisibility() == RelativeLayout.VISIBLE)
					tab2.setVisibility(RelativeLayout.GONE);
				if (tab3 != null
						&& tab3.getVisibility() == RelativeLayout.VISIBLE)
					tab3.setVisibility(RelativeLayout.GONE);
				if (tab4 != null
						&& tab4.getVisibility() == RelativeLayout.VISIBLE)
					tab4.setVisibility(RelativeLayout.GONE);
				if (tab5 != null
						&& tab5.getVisibility() == RelativeLayout.VISIBLE)
					tab5.setVisibility(RelativeLayout.GONE);
				if (tab6 != null
						&& tab6.getVisibility() == RelativeLayout.VISIBLE)
					tab6.setVisibility(RelativeLayout.GONE);
				if (tab7 != null
						&& tab7.getVisibility() == RelativeLayout.VISIBLE)
					tab7.setVisibility(RelativeLayout.GONE);
				if (tab8 != null
						&& tab8.getVisibility() == RelativeLayout.VISIBLE)
					tab8.setVisibility(RelativeLayout.GONE);
				if (tab9 != null
						&& tab9.getVisibility() == RelativeLayout.VISIBLE)
					tab9.setVisibility(RelativeLayout.GONE);
				if (taba != null
						&& taba.getVisibility() == RelativeLayout.VISIBLE)
					taba.setVisibility(RelativeLayout.GONE);
				if (tabb != null
						&& tabb.getVisibility() == RelativeLayout.VISIBLE) {
					tabb.setVisibility(RelativeLayout.GONE);
					commentbar.setVisibility(RelativeLayout.GONE);
				}
				tabd.setVisibility(RelativeLayout.VISIBLE);
				if (cmdbar != null && !cmdbar.isShown()) {
					cmdbar.setVisibility(RelativeLayout.VISIBLE);
				}
				if (tag != 13) {
				queryData((String) getWebServiceUrl() + "getAPQPD",
						getAPQPD(xa001, xa002), new IDataReceiveListener() {
							public void onReceiveData(Object obj) {
								loadDataD(obj);
								b4.setTag("13");
							}
						});
				}
			}

		});

	
	}
	private void setLayout4UI(final String xa001,final String xa002)
	{		
		l5.setVisibility(View.GONE);
		l6.setVisibility(View.GONE);
		b5.setVisibility(View.GONE);
		b6.setVisibility(View.GONE);
		r5.setBackgroundColor(Color.WHITE);
		r6.setBackgroundColor(Color.WHITE);
		l2.setText("7.");
		b2.setText("ATC");
		b1.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
                int tag=Integer.parseInt(v.getTag().toString());
                vwSubTitle.setText(b1.getText());
				// if (tabbar != null)
				// tabbar.setVisibility(RelativeLayout.GONE);
				if (tab5 != null
						&& tab7.getVisibility() == RelativeLayout.VISIBLE)
					tab7.setVisibility(RelativeLayout.GONE);
				if (tabb != null
						&& tabb.getVisibility() == RelativeLayout.VISIBLE) {
					tabb.setVisibility(RelativeLayout.GONE);
					commentbar.setVisibility(RelativeLayout.GONE);
				}
				if (tabd != null
						&& tabd.getVisibility() == RelativeLayout.VISIBLE)
					tabd.setVisibility(RelativeLayout.GONE);
				tab1.setVisibility(RelativeLayout.VISIBLE);
				if (cmdbar != null && !cmdbar.isShown()) {
					cmdbar.setVisibility(RelativeLayout.VISIBLE);
				}
				if (tag !=1) {
					queryData((String) getWebServiceUrl() + "getAPQP1",
							getAPQP1(xa001, xa002), new IDataReceiveListener() {
								public void onReceiveData(Object obj) {
									loadData(obj);
									b1.setTag(1);
								}
							});
				}
			}
		});
		b2.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				int tag = Integer.parseInt(v.getTag().toString());
				vwSubTitle.setText(b2.getText());
				// if (tabbar != null)
				// tabbar.setVisibility(RelativeLayout.GONE);
				if (tab1 != null
						&& tab1.getVisibility() == RelativeLayout.VISIBLE)
					tab1.setVisibility(RelativeLayout.GONE);
				if (tabd != null
						&& tabd.getVisibility() == RelativeLayout.VISIBLE)
					tabd.setVisibility(RelativeLayout.GONE);
				if (tabb != null
						&& tabb.getVisibility() == RelativeLayout.VISIBLE) {
					tabb.setVisibility(RelativeLayout.GONE);
					commentbar.setVisibility(RelativeLayout.GONE);
				}
				tab7.setVisibility(RelativeLayout.VISIBLE);
				if (cmdbar != null && !cmdbar.isShown()) {
					cmdbar.setVisibility(RelativeLayout.VISIBLE);
				}
				if (tag != 7) {
					queryData((String) getWebServiceUrl() + "getAPQP7",
							getAPQP7(xa001, xa002),
							new IDataReceiveListener() {
								public void onReceiveData(Object obj) {
									loadData7(obj);
									b2.setTag(7);
								}
							});
				}
			}
		});
		l3.setText("B.");
		b3.setText("Comment");
		///b3.setTag("0");
		l4.setText("D.");
		b4.setText("Forecast");
		b4.setTextSize(14.0f);
		//b4.setTag("0");
		b3.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				int tag = Integer.parseInt(v.getTag().toString());
				vwSubTitle.setText(b3.getText());
				// if (tabbar != null)
				// tabbar.setVisibility(RelativeLayout.GONE);
				if (tab1 != null
						&& tab1.getVisibility() == RelativeLayout.VISIBLE)
					tab1.setVisibility(RelativeLayout.GONE);
				if (tab2 != null
						&& tab2.getVisibility() == RelativeLayout.VISIBLE)
					tab2.setVisibility(RelativeLayout.GONE);
				if (tab3 != null
						&& tab3.getVisibility() == RelativeLayout.VISIBLE)
					tab3.setVisibility(RelativeLayout.GONE);
				if (tab4 != null
						&& tab4.getVisibility() == RelativeLayout.VISIBLE)
					tab4.setVisibility(RelativeLayout.GONE);
				if (tab5 != null
						&& tab5.getVisibility() == RelativeLayout.VISIBLE)
					tab5.setVisibility(RelativeLayout.GONE);
				if (tab6 != null
						&& tab6.getVisibility() == RelativeLayout.VISIBLE)
					tab6.setVisibility(RelativeLayout.GONE);
				if (tab7 != null
						&& tab7.getVisibility() == RelativeLayout.VISIBLE)
					tab7.setVisibility(RelativeLayout.GONE);
				if (tab8 != null
						&& tab8.getVisibility() == RelativeLayout.VISIBLE)
					tab8.setVisibility(RelativeLayout.GONE);
				if (tab9 != null
						&& tab9.getVisibility() == RelativeLayout.VISIBLE)
					tab9.setVisibility(RelativeLayout.GONE);
				if (taba != null
						&& taba.getVisibility() == RelativeLayout.VISIBLE)
					taba.setVisibility(RelativeLayout.GONE);
				if (tabd != null
						&& tabd.getVisibility() == RelativeLayout.VISIBLE)
					tabd.setVisibility(RelativeLayout.GONE);
				tabb.setVisibility(RelativeLayout.VISIBLE);
				commentbar.setVisibility(RelativeLayout.VISIBLE);
				// LinearLayout.LayoutParams
				// params=(LinearLayout.LayoutParams)tabb.getLayoutParams();
				// Point p=DisplayUtil.getScreenMetrics(context);
				// params.height=p.y-commentbar.getHeight()-tabbar.getHeight()-cmdbar.getHeight()-100;
				// tabb.setLayoutParams(params);
				btn_sale.setBackgroundColor(Color.BLACK);
				btn_fae.setBackgroundColor(Color.BLACK);
				tabr_l1.setTag("0");
				tabr_l1.setText("Add New Comments:");
				final RelativeLayout tabb_r2 = (RelativeLayout) mView
						.findViewById(R.id.tabb_r2);
				final RelativeLayout tabb_r4 = (RelativeLayout) mView
						.findViewById(R.id.tabb_r4);
				final RelativeLayout tabb_r5 = (RelativeLayout) mView
						.findViewById(R.id.tabb_r5);
				tabb_r2.setVisibility(View.VISIBLE);
				tabb_r4.setVisibility(View.GONE);
				tabb_r5.setVisibility(View.GONE);
				if (xa59r.getVisibility() == View.VISIBLE) {
					xa59r.setVisibility(View.GONE);
				}
				if (cmdbar != null && !cmdbar.isShown()) {
					cmdbar.setVisibility(RelativeLayout.VISIBLE);
				}
				if (tag != 11) {
					queryData((String) getWebServiceUrl() + "getAPQPB",
							getAPQPB(xa001, xa002),
							new IDataReceiveListener() {
								public void onReceiveData(Object obj) {
									loadDataB(obj);
									b3.setTag(11);
								}
							});
				}
			}
		});
		b4.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				int tag = Integer.parseInt(v.getTag().toString());
				vwSubTitle.setText(b4.getText());
				// if (tabbar != null)
				// tabbar.setVisibility(RelativeLayout.GONE);
				if (tab1 != null
						&& tab1.getVisibility() == RelativeLayout.VISIBLE)
					tab1.setVisibility(RelativeLayout.GONE);
				if (tab2 != null
						&& tab2.getVisibility() == RelativeLayout.VISIBLE)
					tab2.setVisibility(RelativeLayout.GONE);
				if (tab3 != null
						&& tab3.getVisibility() == RelativeLayout.VISIBLE)
					tab3.setVisibility(RelativeLayout.GONE);
				if (tab4 != null
						&& tab4.getVisibility() == RelativeLayout.VISIBLE)
					tab4.setVisibility(RelativeLayout.GONE);
				if (tab5 != null
						&& tab5.getVisibility() == RelativeLayout.VISIBLE)
					tab5.setVisibility(RelativeLayout.GONE);
				if (tab6 != null
						&& tab6.getVisibility() == RelativeLayout.VISIBLE)
					tab6.setVisibility(RelativeLayout.GONE);
				if (tab7 != null
						&& tab7.getVisibility() == RelativeLayout.VISIBLE)
					tab7.setVisibility(RelativeLayout.GONE);
				if (tab8 != null
						&& tab8.getVisibility() == RelativeLayout.VISIBLE)
					tab8.setVisibility(RelativeLayout.GONE);
				if (tab9 != null
						&& tab9.getVisibility() == RelativeLayout.VISIBLE)
					tab9.setVisibility(RelativeLayout.GONE);
				if (taba != null
						&& taba.getVisibility() == RelativeLayout.VISIBLE)
					taba.setVisibility(RelativeLayout.GONE);
				if (tabb != null
						&& tabb.getVisibility() == RelativeLayout.VISIBLE) {
					tabb.setVisibility(RelativeLayout.GONE);
					commentbar.setVisibility(RelativeLayout.GONE);
				}
				tabd.setVisibility(RelativeLayout.VISIBLE);
				if (cmdbar != null && !cmdbar.isShown()) {
					cmdbar.setVisibility(RelativeLayout.VISIBLE);
				}
				if (tag != 13) {
				queryData((String) getWebServiceUrl() + "getAPQPD",
						getAPQPD(xa001, xa002), new IDataReceiveListener() {
							public void onReceiveData(Object obj) {
								loadDataD(obj);
								b4.setTag("13");
							}
						});
				}
			}

		});

	
	}
	private void setLayout5UI(final String xa001,final String xa002)
	{
		l5.setVisibility(View.GONE);
		l6.setVisibility(View.GONE);
		b5.setVisibility(View.GONE);
		b6.setVisibility(View.GONE);
		r5.setBackgroundColor(Color.WHITE);
		r6.setBackgroundColor(Color.WHITE);
		l2.setText("8.");
		b2.setText("FinePitch\nProbeCard");
		b1.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
                int tag=Integer.parseInt(v.getTag().toString());
                vwSubTitle.setText(b1.getText());
				// if (tabbar != null)
				// tabbar.setVisibility(RelativeLayout.GONE);
				if (tab8 != null
						&& tab8.getVisibility() == RelativeLayout.VISIBLE)
					tab8.setVisibility(RelativeLayout.GONE);
				if (tabb != null
						&& tabb.getVisibility() == RelativeLayout.VISIBLE) {
					tabb.setVisibility(RelativeLayout.GONE);
					commentbar.setVisibility(RelativeLayout.GONE);
				}
				if (tabd != null
						&& tabd.getVisibility() == RelativeLayout.VISIBLE)
					tabd.setVisibility(RelativeLayout.GONE);
				tab1.setVisibility(RelativeLayout.VISIBLE);
				if (cmdbar != null && !cmdbar.isShown()) {
					cmdbar.setVisibility(RelativeLayout.VISIBLE);
				}
				if (tag !=1) {
					queryData((String) getWebServiceUrl() + "getAPQP1",
							getAPQP1(xa001, xa002), new IDataReceiveListener() {
								public void onReceiveData(Object obj) {
									loadData(obj);
									b1.setTag(1);
								}
							});
				}
			}
		});
		b2.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				int tag = Integer.parseInt(v.getTag().toString());
				vwSubTitle.setText(b2.getText());
				// if (tabbar != null)
				// tabbar.setVisibility(RelativeLayout.GONE);
				if (tab1 != null
						&& tab1.getVisibility() == RelativeLayout.VISIBLE)
					tab1.setVisibility(RelativeLayout.GONE);
				if (tabd != null
						&& tabd.getVisibility() == RelativeLayout.VISIBLE)
					tabd.setVisibility(RelativeLayout.GONE);
				if (tabb != null
						&& tabb.getVisibility() == RelativeLayout.VISIBLE) {
					tabb.setVisibility(RelativeLayout.GONE);
					commentbar.setVisibility(RelativeLayout.GONE);
				}
				tab8.setVisibility(RelativeLayout.VISIBLE);
				if (cmdbar != null && !cmdbar.isShown()) {
					cmdbar.setVisibility(RelativeLayout.VISIBLE);
				}
				if (tag != 8) {
					queryData((String) getWebServiceUrl() + "getAPQP8",
							getAPQP8(xa001, xa002),
							new IDataReceiveListener() {
								public void onReceiveData(Object obj) {
									loadData8(obj);
									b2.setTag(8);
								}
							});
				}
			}
		});
		l3.setText("B.");
		b3.setText("Comment");
		///b3.setTag("0");
		l4.setText("D.");
		b4.setText("Forecast");
		b4.setTextSize(14.0f);
		//b4.setTag("0");
		b3.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				int tag = Integer.parseInt(v.getTag().toString());
				vwSubTitle.setText(b3.getText());
				// if (tabbar != null)
				// tabbar.setVisibility(RelativeLayout.GONE);
				if (tab1 != null
						&& tab1.getVisibility() == RelativeLayout.VISIBLE)
					tab1.setVisibility(RelativeLayout.GONE);
				if (tab2 != null
						&& tab2.getVisibility() == RelativeLayout.VISIBLE)
					tab2.setVisibility(RelativeLayout.GONE);
				if (tab3 != null
						&& tab3.getVisibility() == RelativeLayout.VISIBLE)
					tab3.setVisibility(RelativeLayout.GONE);
				if (tab4 != null
						&& tab4.getVisibility() == RelativeLayout.VISIBLE)
					tab4.setVisibility(RelativeLayout.GONE);
				if (tab5 != null
						&& tab5.getVisibility() == RelativeLayout.VISIBLE)
					tab5.setVisibility(RelativeLayout.GONE);
				if (tab6 != null
						&& tab6.getVisibility() == RelativeLayout.VISIBLE)
					tab6.setVisibility(RelativeLayout.GONE);
				if (tab7 != null
						&& tab7.getVisibility() == RelativeLayout.VISIBLE)
					tab7.setVisibility(RelativeLayout.GONE);
				if (tab8 != null
						&& tab8.getVisibility() == RelativeLayout.VISIBLE)
					tab8.setVisibility(RelativeLayout.GONE);
				if (tab9 != null
						&& tab9.getVisibility() == RelativeLayout.VISIBLE)
					tab9.setVisibility(RelativeLayout.GONE);
				if (taba != null
						&& taba.getVisibility() == RelativeLayout.VISIBLE)
					taba.setVisibility(RelativeLayout.GONE);
				if (tabd != null
						&& tabd.getVisibility() == RelativeLayout.VISIBLE)
					tabd.setVisibility(RelativeLayout.GONE);
				tabb.setVisibility(RelativeLayout.VISIBLE);
				commentbar.setVisibility(RelativeLayout.VISIBLE);
				// LinearLayout.LayoutParams
				// params=(LinearLayout.LayoutParams)tabb.getLayoutParams();
				// Point p=DisplayUtil.getScreenMetrics(context);
				// params.height=p.y-commentbar.getHeight()-tabbar.getHeight()-cmdbar.getHeight()-100;
				// tabb.setLayoutParams(params);
				btn_sale.setBackgroundColor(Color.BLACK);
				btn_fae.setBackgroundColor(Color.BLACK);
				tabr_l1.setTag("0");
				tabr_l1.setText("Add New Comments:");
				final RelativeLayout tabb_r2 = (RelativeLayout) mView
						.findViewById(R.id.tabb_r2);
				final RelativeLayout tabb_r4 = (RelativeLayout) mView
						.findViewById(R.id.tabb_r4);
				final RelativeLayout tabb_r5 = (RelativeLayout) mView
						.findViewById(R.id.tabb_r5);
				tabb_r2.setVisibility(View.VISIBLE);
				tabb_r4.setVisibility(View.GONE);
				tabb_r5.setVisibility(View.GONE);
				if (xa59r.getVisibility() == View.VISIBLE) {
					xa59r.setVisibility(View.GONE);
				}
				if (cmdbar != null && !cmdbar.isShown()) {
					cmdbar.setVisibility(RelativeLayout.VISIBLE);
				}
				if (tag != 11) {
					queryData((String) getWebServiceUrl() + "getAPQPB",
							getAPQPB(xa001, xa002),
							new IDataReceiveListener() {
								public void onReceiveData(Object obj) {
									loadDataB(obj);
									b3.setTag(11);
								}
							});
				}
			}
		});
		b4.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				int tag = Integer.parseInt(v.getTag().toString());
				vwSubTitle.setText(b4.getText());
				// if (tabbar != null)
				// tabbar.setVisibility(RelativeLayout.GONE);
				if (tab1 != null
						&& tab1.getVisibility() == RelativeLayout.VISIBLE)
					tab1.setVisibility(RelativeLayout.GONE);
				if (tab2 != null
						&& tab2.getVisibility() == RelativeLayout.VISIBLE)
					tab2.setVisibility(RelativeLayout.GONE);
				if (tab3 != null
						&& tab3.getVisibility() == RelativeLayout.VISIBLE)
					tab3.setVisibility(RelativeLayout.GONE);
				if (tab4 != null
						&& tab4.getVisibility() == RelativeLayout.VISIBLE)
					tab4.setVisibility(RelativeLayout.GONE);
				if (tab5 != null
						&& tab5.getVisibility() == RelativeLayout.VISIBLE)
					tab5.setVisibility(RelativeLayout.GONE);
				if (tab6 != null
						&& tab6.getVisibility() == RelativeLayout.VISIBLE)
					tab6.setVisibility(RelativeLayout.GONE);
				if (tab7 != null
						&& tab7.getVisibility() == RelativeLayout.VISIBLE)
					tab7.setVisibility(RelativeLayout.GONE);
				if (tab8 != null
						&& tab8.getVisibility() == RelativeLayout.VISIBLE)
					tab8.setVisibility(RelativeLayout.GONE);
				if (tab9 != null
						&& tab9.getVisibility() == RelativeLayout.VISIBLE)
					tab9.setVisibility(RelativeLayout.GONE);
				if (taba != null
						&& taba.getVisibility() == RelativeLayout.VISIBLE)
					taba.setVisibility(RelativeLayout.GONE);
				if (tabb != null
						&& tabb.getVisibility() == RelativeLayout.VISIBLE) {
					tabb.setVisibility(RelativeLayout.GONE);
					commentbar.setVisibility(RelativeLayout.GONE);
				}
				tabd.setVisibility(RelativeLayout.VISIBLE);
				if (cmdbar != null && !cmdbar.isShown()) {
					cmdbar.setVisibility(RelativeLayout.VISIBLE);
				}
				if (tag != 13) {
				queryData((String) getWebServiceUrl() + "getAPQPD",
						getAPQPD(xa001, xa002), new IDataReceiveListener() {
							public void onReceiveData(Object obj) {
								loadDataD(obj);
								b4.setTag("13");
							}
						});
				}
			}

		});

	
	}
	private void setLayout6UI(final String xa001,final String xa002)
	{	
		l5.setVisibility(View.GONE);
		l6.setVisibility(View.GONE);
		b5.setVisibility(View.GONE);
		b6.setVisibility(View.GONE);
		r5.setBackgroundColor(Color.WHITE);
		r6.setBackgroundColor(Color.WHITE);
		l2.setText("9.");
		b2.setText("Changeover\nKit");
		b1.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
                int tag=Integer.parseInt(v.getTag().toString());
				vwSubTitle.setText(b1.getText());
				// if (tabbar != null)
				// tabbar.setVisibility(RelativeLayout.GONE);
				if (tab9 != null
						&& tab5.getVisibility() == RelativeLayout.VISIBLE)
					tab9.setVisibility(RelativeLayout.GONE);
				if (tabb != null
						&& tabb.getVisibility() == RelativeLayout.VISIBLE) {
					tabb.setVisibility(RelativeLayout.GONE);
					commentbar.setVisibility(RelativeLayout.GONE);
				}
				if (tabd != null
						&& tabd.getVisibility() == RelativeLayout.VISIBLE)
					tabd.setVisibility(RelativeLayout.GONE);
				tab1.setVisibility(RelativeLayout.VISIBLE);
				if (cmdbar != null && !cmdbar.isShown()) {
					cmdbar.setVisibility(RelativeLayout.VISIBLE);
				}
				if (tag !=1) {
					queryData((String) getWebServiceUrl() + "getAPQP1",
							getAPQP1(xa001, xa002), new IDataReceiveListener() {
								public void onReceiveData(Object obj) {
									loadData(obj);
									b1.setTag(1);
								}
							});
				}
			}
		});
		b2.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				int tag = Integer.parseInt(v.getTag().toString());
				vwSubTitle.setText(b2.getText());
				// if (tabbar != null)
				// tabbar.setVisibility(RelativeLayout.GONE);
				if (tab1 != null
						&& tab1.getVisibility() == RelativeLayout.VISIBLE)
					tab1.setVisibility(RelativeLayout.GONE);
				if (tabd != null
						&& tabd.getVisibility() == RelativeLayout.VISIBLE)
					tabd.setVisibility(RelativeLayout.GONE);
				if (tabb != null
						&& tabb.getVisibility() == RelativeLayout.VISIBLE) {
					tabb.setVisibility(RelativeLayout.GONE);
					commentbar.setVisibility(RelativeLayout.GONE);
				}
				tab9.setVisibility(RelativeLayout.VISIBLE);
				if (cmdbar != null && !cmdbar.isShown()) {
					cmdbar.setVisibility(RelativeLayout.VISIBLE);
				}
				if (tag != 9) {
					queryData((String) getWebServiceUrl() + "getAPQP9",
							getAPQP9(xa001, xa002),
							new IDataReceiveListener() {
								public void onReceiveData(Object obj) {
									loadData9(obj);
									b2.setTag(9);
								}
							});
				}
			}
		});
		l3.setText("B.");
		b3.setText("Comment");
		///b3.setTag("0");
		l4.setText("D.");
		b4.setText("Forecast");
		b4.setTextSize(14.0f);
		//b4.setTag("0");
		b3.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				int tag = Integer.parseInt(v.getTag().toString());
				vwSubTitle.setText(b3.getText());
				// if (tabbar != null)
				// tabbar.setVisibility(RelativeLayout.GONE);
				if (tab1 != null
						&& tab1.getVisibility() == RelativeLayout.VISIBLE)
					tab1.setVisibility(RelativeLayout.GONE);
				if (tab2 != null
						&& tab2.getVisibility() == RelativeLayout.VISIBLE)
					tab2.setVisibility(RelativeLayout.GONE);
				if (tab3 != null
						&& tab3.getVisibility() == RelativeLayout.VISIBLE)
					tab3.setVisibility(RelativeLayout.GONE);
				if (tab4 != null
						&& tab4.getVisibility() == RelativeLayout.VISIBLE)
					tab4.setVisibility(RelativeLayout.GONE);
				if (tab5 != null
						&& tab5.getVisibility() == RelativeLayout.VISIBLE)
					tab5.setVisibility(RelativeLayout.GONE);
				if (tab6 != null
						&& tab6.getVisibility() == RelativeLayout.VISIBLE)
					tab6.setVisibility(RelativeLayout.GONE);
				if (tab7 != null
						&& tab7.getVisibility() == RelativeLayout.VISIBLE)
					tab7.setVisibility(RelativeLayout.GONE);
				if (tab8 != null
						&& tab8.getVisibility() == RelativeLayout.VISIBLE)
					tab8.setVisibility(RelativeLayout.GONE);
				if (tab9 != null
						&& tab9.getVisibility() == RelativeLayout.VISIBLE)
					tab9.setVisibility(RelativeLayout.GONE);
				if (taba != null
						&& taba.getVisibility() == RelativeLayout.VISIBLE)
					taba.setVisibility(RelativeLayout.GONE);
				if (tabd != null
						&& tabd.getVisibility() == RelativeLayout.VISIBLE)
					tabd.setVisibility(RelativeLayout.GONE);
				tabb.setVisibility(RelativeLayout.VISIBLE);
				commentbar.setVisibility(RelativeLayout.VISIBLE);
				// LinearLayout.LayoutParams
				// params=(LinearLayout.LayoutParams)tabb.getLayoutParams();
				// Point p=DisplayUtil.getScreenMetrics(context);
				// params.height=p.y-commentbar.getHeight()-tabbar.getHeight()-cmdbar.getHeight()-100;
				// tabb.setLayoutParams(params);
				btn_sale.setBackgroundColor(Color.BLACK);
				btn_fae.setBackgroundColor(Color.BLACK);
				tabr_l1.setTag("0");
				tabr_l1.setText("Add New Comments:");
				final RelativeLayout tabb_r2 = (RelativeLayout) mView
						.findViewById(R.id.tabb_r2);
				final RelativeLayout tabb_r4 = (RelativeLayout) mView
						.findViewById(R.id.tabb_r4);
				final RelativeLayout tabb_r5 = (RelativeLayout) mView
						.findViewById(R.id.tabb_r5);
				tabb_r2.setVisibility(View.VISIBLE);
				tabb_r4.setVisibility(View.GONE);
				tabb_r5.setVisibility(View.GONE);
				if (xa59r.getVisibility() == View.VISIBLE) {
					xa59r.setVisibility(View.GONE);
				}
				if (cmdbar != null && !cmdbar.isShown()) {
					cmdbar.setVisibility(RelativeLayout.VISIBLE);
				}
				if (tag != 11) {
					queryData((String) getWebServiceUrl() + "getAPQPB",
							getAPQPB(xa001, xa002),
							new IDataReceiveListener() {
								public void onReceiveData(Object obj) {
									loadDataB(obj);
									b3.setTag(11);
								}
							});
				}
			}
		});
		b4.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				int tag = Integer.parseInt(v.getTag().toString());
				vwSubTitle.setText(b4.getText());
				// if (tabbar != null)
				// tabbar.setVisibility(RelativeLayout.GONE);
				if (tab1 != null
						&& tab1.getVisibility() == RelativeLayout.VISIBLE)
					tab1.setVisibility(RelativeLayout.GONE);
				if (tab2 != null
						&& tab2.getVisibility() == RelativeLayout.VISIBLE)
					tab2.setVisibility(RelativeLayout.GONE);
				if (tab3 != null
						&& tab3.getVisibility() == RelativeLayout.VISIBLE)
					tab3.setVisibility(RelativeLayout.GONE);
				if (tab4 != null
						&& tab4.getVisibility() == RelativeLayout.VISIBLE)
					tab4.setVisibility(RelativeLayout.GONE);
				if (tab5 != null
						&& tab5.getVisibility() == RelativeLayout.VISIBLE)
					tab5.setVisibility(RelativeLayout.GONE);
				if (tab6 != null
						&& tab6.getVisibility() == RelativeLayout.VISIBLE)
					tab6.setVisibility(RelativeLayout.GONE);
				if (tab7 != null
						&& tab7.getVisibility() == RelativeLayout.VISIBLE)
					tab7.setVisibility(RelativeLayout.GONE);
				if (tab8 != null
						&& tab8.getVisibility() == RelativeLayout.VISIBLE)
					tab8.setVisibility(RelativeLayout.GONE);
				if (tab9 != null
						&& tab9.getVisibility() == RelativeLayout.VISIBLE)
					tab9.setVisibility(RelativeLayout.GONE);
				if (taba != null
						&& taba.getVisibility() == RelativeLayout.VISIBLE)
					taba.setVisibility(RelativeLayout.GONE);
				if (tabb != null
						&& tabb.getVisibility() == RelativeLayout.VISIBLE) {
					tabb.setVisibility(RelativeLayout.GONE);
					commentbar.setVisibility(RelativeLayout.GONE);
				}
				tabd.setVisibility(RelativeLayout.VISIBLE);
				if (cmdbar != null && !cmdbar.isShown()) {
					cmdbar.setVisibility(RelativeLayout.VISIBLE);
				}
				if (tag != 13) {
				queryData((String) getWebServiceUrl() + "getAPQPD",
						getAPQPD(xa001, xa002), new IDataReceiveListener() {
							public void onReceiveData(Object obj) {
								loadDataD(obj);
								b4.setTag("13");
							}
						});
				}
			}

		});

	}
	private void setLayout7UI(final String xa001,final String xa002)
	{		
		l5.setVisibility(View.GONE);
		l6.setVisibility(View.GONE);
		b5.setVisibility(View.GONE);
		b6.setVisibility(View.GONE);
		r5.setBackgroundColor(Color.WHITE);
		r6.setBackgroundColor(Color.WHITE);
		l2.setText("A.");
		b2.setText("E-Flux");
		b1.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				int tag = (Integer) v.getTag();
				vwSubTitle.setText(b1.getText());
				// if (tabbar != null)
				// tabbar.setVisibility(RelativeLayout.GONE);
				if (taba != null
						&& taba.getVisibility() == RelativeLayout.VISIBLE)
					taba.setVisibility(RelativeLayout.GONE);
				if (tabb != null
						&& tabb.getVisibility() == RelativeLayout.VISIBLE) {
					tabb.setVisibility(RelativeLayout.GONE);
					commentbar.setVisibility(RelativeLayout.GONE);
				}
				if (tabd != null
						&& tabd.getVisibility() == RelativeLayout.VISIBLE)
					tabd.setVisibility(RelativeLayout.GONE);
				tab1.setVisibility(RelativeLayout.VISIBLE);
				if (cmdbar != null && !cmdbar.isShown()) {
					cmdbar.setVisibility(RelativeLayout.VISIBLE);
				}
				if (tag !=1) {
					queryData((String) getWebServiceUrl() + "getAPQP1",
							getAPQP1(xa001, xa002), new IDataReceiveListener() {
								public void onReceiveData(Object obj) {
									loadData(obj);
									b1.setTag(1);
								}
							});
				}
			}
		});
		b2.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				int tag = Integer.parseInt(v.getTag().toString());
				vwSubTitle.setText(b2.getText());
				// if (tabbar != null)
				// tabbar.setVisibility(RelativeLayout.GONE);
				if (tab1 != null
						&& tab1.getVisibility() == RelativeLayout.VISIBLE)
					tab1.setVisibility(RelativeLayout.GONE);
				if (tabd != null
						&& tabd.getVisibility() == RelativeLayout.VISIBLE)
					tabd.setVisibility(RelativeLayout.GONE);
				if (tabb != null
						&& tabb.getVisibility() == RelativeLayout.VISIBLE) {
					tabb.setVisibility(RelativeLayout.GONE);
					commentbar.setVisibility(RelativeLayout.GONE);
				}
				taba.setVisibility(RelativeLayout.VISIBLE);
				if (cmdbar != null && !cmdbar.isShown()) {
					cmdbar.setVisibility(RelativeLayout.VISIBLE);
				}
				if (tag != 10) {
					queryData((String) getWebServiceUrl() + "getAPQPA",
							getAPQPA(xa001, xa002),
							new IDataReceiveListener() {
								public void onReceiveData(Object obj) {
									loadDataA(obj);
									b2.setTag(10);
								}
							});
				}
			}
		});
		l3.setText("B.");
		b3.setText("Comment");
		///b3.setTag("0");
		l4.setText("D.");
		b4.setText("Forecast");
		b4.setTextSize(14.0f);
		//b4.setTag("0");
		b3.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				int tag = Integer.parseInt(v.getTag().toString());
				vwSubTitle.setText(b3.getText());
				// if (tabbar != null)
				// tabbar.setVisibility(RelativeLayout.GONE);
				if (tab1 != null
						&& tab1.getVisibility() == RelativeLayout.VISIBLE)
					tab1.setVisibility(RelativeLayout.GONE);
				if (tab2 != null
						&& tab2.getVisibility() == RelativeLayout.VISIBLE)
					tab2.setVisibility(RelativeLayout.GONE);
				if (tab3 != null
						&& tab3.getVisibility() == RelativeLayout.VISIBLE)
					tab3.setVisibility(RelativeLayout.GONE);
				if (tab4 != null
						&& tab4.getVisibility() == RelativeLayout.VISIBLE)
					tab4.setVisibility(RelativeLayout.GONE);
				if (tab5 != null
						&& tab5.getVisibility() == RelativeLayout.VISIBLE)
					tab5.setVisibility(RelativeLayout.GONE);
				if (tab6 != null
						&& tab6.getVisibility() == RelativeLayout.VISIBLE)
					tab6.setVisibility(RelativeLayout.GONE);
				if (tab7 != null
						&& tab7.getVisibility() == RelativeLayout.VISIBLE)
					tab7.setVisibility(RelativeLayout.GONE);
				if (tab8 != null
						&& tab8.getVisibility() == RelativeLayout.VISIBLE)
					tab8.setVisibility(RelativeLayout.GONE);
				if (tab9 != null
						&& tab9.getVisibility() == RelativeLayout.VISIBLE)
					tab9.setVisibility(RelativeLayout.GONE);
				if (taba != null
						&& taba.getVisibility() == RelativeLayout.VISIBLE)
					taba.setVisibility(RelativeLayout.GONE);
				if (tabd != null
						&& tabd.getVisibility() == RelativeLayout.VISIBLE)
					tabd.setVisibility(RelativeLayout.GONE);
				tabb.setVisibility(RelativeLayout.VISIBLE);
				commentbar.setVisibility(RelativeLayout.VISIBLE);
				// LinearLayout.LayoutParams
				// params=(LinearLayout.LayoutParams)tabb.getLayoutParams();
				// Point p=DisplayUtil.getScreenMetrics(context);
				// params.height=p.y-commentbar.getHeight()-tabbar.getHeight()-cmdbar.getHeight()-100;
				// tabb.setLayoutParams(params);
				btn_sale.setBackgroundColor(Color.BLACK);
				btn_fae.setBackgroundColor(Color.BLACK);
				tabr_l1.setTag("0");
				tabr_l1.setText("Add New Comments:");
				final RelativeLayout tabb_r2 = (RelativeLayout) mView
						.findViewById(R.id.tabb_r2);
				final RelativeLayout tabb_r4 = (RelativeLayout) mView
						.findViewById(R.id.tabb_r4);
				final RelativeLayout tabb_r5 = (RelativeLayout) mView
						.findViewById(R.id.tabb_r5);
				tabb_r2.setVisibility(View.VISIBLE);
				tabb_r4.setVisibility(View.GONE);
				tabb_r5.setVisibility(View.GONE);
				if (xa59r.getVisibility() == View.VISIBLE) {
					xa59r.setVisibility(View.GONE);
				}
				if (cmdbar != null && !cmdbar.isShown()) {
					cmdbar.setVisibility(RelativeLayout.VISIBLE);
				}
				if (tag != 11) {
					queryData((String) getWebServiceUrl() + "getAPQPB",
							getAPQPB(xa001, xa002),
							new IDataReceiveListener() {
								public void onReceiveData(Object obj) {
									loadDataB(obj);
									b3.setTag(11);
								}
							});
				}
			}
		});
		b4.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				int tag = Integer.parseInt(v.getTag().toString());
				vwSubTitle.setText(b4.getText());
				// if (tabbar != null)
				// tabbar.setVisibility(RelativeLayout.GONE);
				if (tab1 != null
						&& tab1.getVisibility() == RelativeLayout.VISIBLE)
					tab1.setVisibility(RelativeLayout.GONE);
				if (tab2 != null
						&& tab2.getVisibility() == RelativeLayout.VISIBLE)
					tab2.setVisibility(RelativeLayout.GONE);
				if (tab3 != null
						&& tab3.getVisibility() == RelativeLayout.VISIBLE)
					tab3.setVisibility(RelativeLayout.GONE);
				if (tab4 != null
						&& tab4.getVisibility() == RelativeLayout.VISIBLE)
					tab4.setVisibility(RelativeLayout.GONE);
				if (tab5 != null
						&& tab5.getVisibility() == RelativeLayout.VISIBLE)
					tab5.setVisibility(RelativeLayout.GONE);
				if (tab6 != null
						&& tab6.getVisibility() == RelativeLayout.VISIBLE)
					tab6.setVisibility(RelativeLayout.GONE);
				if (tab7 != null
						&& tab7.getVisibility() == RelativeLayout.VISIBLE)
					tab7.setVisibility(RelativeLayout.GONE);
				if (tab8 != null
						&& tab8.getVisibility() == RelativeLayout.VISIBLE)
					tab8.setVisibility(RelativeLayout.GONE);
				if (tab9 != null
						&& tab9.getVisibility() == RelativeLayout.VISIBLE)
					tab9.setVisibility(RelativeLayout.GONE);
				if (taba != null
						&& taba.getVisibility() == RelativeLayout.VISIBLE)
					taba.setVisibility(RelativeLayout.GONE);
				if (tabb != null
						&& tabb.getVisibility() == RelativeLayout.VISIBLE) {
					tabb.setVisibility(RelativeLayout.GONE);
					commentbar.setVisibility(RelativeLayout.GONE);
				}
				tabd.setVisibility(RelativeLayout.VISIBLE);
				if (cmdbar != null && !cmdbar.isShown()) {
					cmdbar.setVisibility(RelativeLayout.VISIBLE);
				}
				if (tag != 13) {
				queryData((String) getWebServiceUrl() + "getAPQPD",
						getAPQPD(xa001, xa002), new IDataReceiveListener() {
							public void onReceiveData(Object obj) {
								loadDataD(obj);
								b4.setTag("13");
							}
						});
				}
			}

		});
	}	
	private void setLayoutUI(int layoutid) {
		String[] apqpno = getApqpNo().split("-");
		final String xa001 = apqpno[0];
		final String xa002 = apqpno[1];
		//default
		tab1.setVisibility(View.VISIBLE);
		tab2.setVisibility(View.GONE);
		tab3.setVisibility(View.GONE);
		tab4.setVisibility(View.GONE);
		tab5.setVisibility(View.GONE);
		tab6.setVisibility(View.GONE);
		tab7.setVisibility(View.GONE);
		tab8.setVisibility(View.GONE);
		tab9.setVisibility(View.GONE);
		taba.setVisibility(View.GONE);
		tabb.setVisibility(View.GONE);
		tabd.setVisibility(View.GONE);
		b1 = (Button) mView.findViewById(R.id.b1);
		b2 = (Button) mView.findViewById(R.id.b2);
		b3 = (Button) mView.findViewById(R.id.b3);
		b4 = (Button) mView.findViewById(R.id.b4);
		b5 = (Button) mView.findViewById(R.id.b5);
		b6 = (Button) mView.findViewById(R.id.b6);
		// APQP Type:SOCKET
		b1.setText("Customer");
		b2.setText("Package");
		b3.setText("Handler");
		b4.setText("Socket App");
		// b4.setTextSize(10.0f);
		b5.setText("Comment");
		b6.setText("Forecast");
		b1.setTag(0);
		b2.setTag(0);
		b3.setTag(0);
		b4.setTag(0);
		b5.setTag(0);
		b6.setTag(0);
		l1 = (TextView) mView.findViewById(R.id.l1);
		l2 = (TextView) mView.findViewById(R.id.l2);
		l3 = (TextView) mView.findViewById(R.id.l3);
		l4 = (TextView) mView.findViewById(R.id.l4);
		l5 = (TextView) mView.findViewById(R.id.l5);
		l6 = (TextView) mView.findViewById(R.id.l6);
		r1 = (RelativeLayout) mView.findViewById(R.id.r1);
		r2 = (RelativeLayout) mView.findViewById(R.id.r2);
		r3 = (RelativeLayout) mView.findViewById(R.id.r3);
		r4 = (RelativeLayout) mView.findViewById(R.id.r4);
		r5 = (RelativeLayout) mView.findViewById(R.id.r5);
		r6 = (RelativeLayout) mView.findViewById(R.id.r6);
		initTab1(mView);
		initTabB(mView);		
		initTabD(mView);
		if (layoutid == 2) {
			// Duplication
			initTab5(mView);
			setLayout2UI(xa001,xa002);
		} else if (layoutid == 3) {
			// wlcsp
			initTab6(mView);
			setLayout3UI(xa001,xa002);
		} else if (layoutid == 4) {
			// atc
			initTab7(mView);
			setLayout4UI(xa001,xa002);
		} else if (layoutid == 5) {
			// FinePitch ProbeCard
			initTab8(mView);
			setLayout5UI(xa001,xa002);
		} else if (layoutid  == 6) {
			// changeover kit
			initTab9(mView);	
			setLayout6UI(xa001,xa002);
		} else if (layoutid  == 7) {
			// eflux
			initTabA(mView);
			setLayout7UI(xa001,xa002);
		} else {			
			// Package Info
			initTab2(mView);
			// Handler
			initTab3(mView);
			// Socket info
			initTab4(mView);
			setLayout1UI(xa001,xa002);
		}		
	}

}
