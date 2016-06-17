/*
 * onCreate
GET
initActionBar
setSearchViewVisibility
initDrawer 初始化滑動側邊攔
initDrawerList 初始化滑動側邊攔列表
selectItem
setTitle
showActionbar
onPostExecute
onCreateOptionsMenu
 */
package com.winway.wwapp2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;

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

import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseInstallation;
import com.parse.ParsePush;
import com.parse.SaveCallback;
import com.winway.wwapp2.BaseFragment.HttpPostAsyncTask;
import com.winway.wwapp2.BaseFragment.ICallback;

import android.app.ListFragment;
import android.util.Log;
import android.app.Activity;
import android.opengl.Visibility;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Message;
import android.os.StrictMode;
import android.app.ActionBar;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
//import android.app.ActionBar.LayoutParams;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentManager.BackStackEntry;
import android.app.SearchManager;
import android.app.SearchableInfo;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.hardware.SensorEventListener;
//import android.graphics.drawable.ColorDrawable;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.SearchView;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
//import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.WindowManager;
import android.webkit.WebView;
//import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.EditText;
import android.widget.DatePicker;
//import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View.OnClickListener;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

public class MainActivity extends Activity {
	private DrawerLayout layDrawer;// 側邊MENU
	private ListView lstDrawer;
	private ListView lstMsg;
	private ActionBarDrawerToggle drawerToggle;
	private CharSequence mDrawerTitle;
	private CharSequence mTitle;
	// private String[] drawer_menu;
	private NavDrawerListAdapter adapter;
	private MsgListAdapter adapter2;
	private String[] navMenuTitles;
	private TypedArray navMenuIcons;
	private ArrayList<MsgItem> msgItems;
	private ArrayList<NavDrawerItem> navDrawerItems;
	private View mCustomView;
	private SearchView mSearchView;
	private Fragment fragmentHome = null;
	private Fragment fragmentAnnounce = null;// new NavbarAnnounceActivity();
	private Fragment fragmentMessage = null;// new NavbarMessageActivity();
	private Fragment fragmentFavorite = null;// new NavbarFavoriteActivity();
	private Fragment fragmentCurrent = null;
	// private MagicLenGCM gcm;
	private UpdateManager mUpdateManager;
	private String regId;
	private static Boolean isExit = false;
	private static Boolean hasTask = false;
	private SensorManager sm;
	private Sensor mAccelerometer;
	private float[] accelerometer_values = null;
	private float[] magnitude_values = null;
	private int mOrientation = 1;
	private static int push_state = 0;
	Timer tExit = new Timer();
	TimerTask task = new TimerTask() {
		@Override
		public void run() {

			isExit = false;
			hasTask = true;
		}
	};

	/*
	 * SensorEventListener listener = new SensorEventListener() { public void
	 * onSensorChanged(SensorEvent event) { switch (event.sensor.getType()) {
	 * case Sensor.TYPE_ACCELEROMETER: accelerometer_values =
	 * event.values.clone(); //Landspace
	 * if(accelerometer_values[0]>accelerometer_values[1]) { mOrientation = 2;
	 * 
	 * } //portrait else if(accelerometer_values[0]<accelerometer_values[1]){
	 * mOrientation = 1; }
	 * 
	 * break; case Sensor.TYPE_MAGNETIC_FIELD: magnitude_values =
	 * event.values.clone(); break; default: break; }
	 * 
	 * if (magnitude_values == null || accelerometer_values == null) { return; }
	 * 
	 * }
	 * 
	 * public void onAccuracyChanged(Sensor sensor, int accuracy) { // Called
	 * when the accuracy of a sensor has changed. } };
	 */
	/**
	 * Function C
	 */
	private void centerActionBarTitle() {

		int titleId = 0;
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			titleId = getResources().getIdentifier("action_bar_title", "id",
					"android");
		} else {
			// This is the id is from your app's generated R class when
			// ActionBarActivity is used
			// for SupportActionBar
			titleId = R.id.action_bar_title;
		}

		// Final check for non-zero invalid id
		if (titleId > 0) {
			TextView titleTextView = (TextView) findViewById(titleId);

			DisplayMetrics metrics = getResources().getDisplayMetrics();

			// Fetch layout parameters of titleTextView
			// (LinearLayout.LayoutParams : Info from HierarchyViewer)
			LinearLayout.LayoutParams txvPars = (android.widget.LinearLayout.LayoutParams) titleTextView
					.getLayoutParams();
			txvPars.gravity = Gravity.CENTER_HORIZONTAL;
			txvPars.width = metrics.widthPixels;
			titleTextView.setLayoutParams(txvPars);
			titleTextView.setGravity(Gravity.CENTER);
		}
	}

	/**
	 * APQP List導覽列按下+(=>進入Add APQP)
	 * 
	 * @param view
	 */
	public void createAPQP(View view) {

		FragmentManager fragmentManager = getFragmentManager();
		BaseFragment fragment = new ApqpAddActivity();
		fragmentManager.beginTransaction()
				.replace(R.id.content_frame, fragment, "apqpadd").commit();
		// hideActionbar();

	}

	/**
	 * 
	 * @param bundle
	 */
	/*
	 * public void callApqpPackageActivity(Bundle bundle) { Fragment fragment =
	 * null; fragment = new ApqpDataActivity2();
	 * fragment.setRetainInstance(true); fragment.setArguments(bundle);
	 * FragmentManager fragmentManager = getFragmentManager(); if
	 * (fragmentManager.findFragmentById(fragment.getId()) == null) {
	 * fragmentManager.beginTransaction() .add(R.id.content_frame, fragment,
	 * "apqpdata2").commit(); } if
	 * (fragmentManager.findFragmentByTag("apqpdata") != null) {
	 * fragmentManager.beginTransaction()
	 * .hide(fragmentManager.findFragmentByTag("apqpdata")) .commit(); }
	 * 
	 * fragmentManager.beginTransaction().show(fragment).commit(); }
	 */

	public void callCustomerDataActivity(Bundle bundle) {

		CustomerDataActivity activity = new CustomerDataActivity();
		FragmentManager fragmentManager = getFragmentManager();
		activity.fragmentManager = fragmentManager;
		Fragment fragment = (Fragment) activity;
		fragment.setRetainInstance(true);
		fragment.setArguments(bundle);
		fragmentManager.beginTransaction()
				.add(R.id.content_frame, fragment, "customerdata_detail")
				.commit();
		if (fragmentManager.findFragmentByTag("customerlist") != null) {
			activity.setParent(fragmentManager
					.findFragmentByTag("customerlist"));
			fragmentManager.beginTransaction()
					.hide(fragmentManager.findFragmentByTag("customerlist"))
					.commit();
		}
		fragmentManager.beginTransaction().show(fragment).commit();

	}

	public void callCustomerContactAddressListActivity(Bundle bundle) {

		CustomerContactAddressListActivity activity = new CustomerContactAddressListActivity();
		FragmentManager fragmentManager = getFragmentManager();
		activity.fragmentManager = fragmentManager;
		Fragment fragment = (Fragment) activity;
		fragment.setRetainInstance(true);
		fragment.setArguments(bundle);
		fragmentManager.beginTransaction()
				.add(R.id.content_frame, fragment, "customerdata_details2")
				.commit();
		if (fragmentManager.findFragmentByTag("customerdata_detail") != null) {
			activity.setParent(fragmentManager
					.findFragmentByTag("customerdata_detail"));
			fragmentManager
					.beginTransaction()
					.hide(fragmentManager
							.findFragmentByTag("customerdata_detail")).commit();
		}
		fragmentManager.beginTransaction().show(fragment).commit();

	}

	/**
	 * 在apqp list的Fragment,按下列表得某一列,觸發的ACTION,要轉向相對應的apqp data詳情頁
	 * 
	 * @param bundle
	 */
	public void callApqpDataActivity(Bundle bundle) {

		/*
		 * Intent i=new Intent(MainActivity.this,ApqpDataActivity.class);
		 * i.putExtras(bundle); //將參數放入 startActivity(i);
		 */
		Fragment fragment = null;
		FragmentManager fragmentManager = getFragmentManager();
		ApqpDataActivity activity = new ApqpDataActivity();
		// disable next statement
		// activity.setFragmentManager(fragmentManager) ;
		fragment = (Fragment) activity;
		fragment.setRetainInstance(true);
		fragment.setArguments(bundle);

		// 檢查資apapdata頁面使否存在，如果不存在則add
		if (fragmentManager.findFragmentById(fragment.getId()) == null) {
			fragmentManager.beginTransaction()
					.add(R.id.content_frame, fragment, "apqpdata").commit();
		} // 檢查進階搜尋頁面是否已載入，如果已載入則將其隱藏
		if (fragmentManager.findFragmentByTag("apqp_search_result") != null) {
			activity.setParent(fragmentManager
					.findFragmentByTag("apqp_search_result"));
			fragmentManager
					.beginTransaction()
					.hide(fragmentManager
							.findFragmentByTag("apqp_search_result")).commit();
		} // 檢查進清單頁面是否已載入，如果已載入則將其隱藏
		else if (fragmentManager.findFragmentByTag("apqplist") != null) {
			activity.setParent(fragmentManager.findFragmentByTag("apqplist"));
			fragmentManager.beginTransaction()
					.hide(fragmentManager.findFragmentByTag("apqplist"))
					.commit();

		}

		fragmentManager.beginTransaction().show(fragment).commit();
	}

	/**
	 * 在fae list的Fragment,按下列表得某一列,觸發的ACTION,要轉向相對應的fae data詳情頁
	 * 
	 * @param bundle
	 */
	public void callFaeDataActivity(Bundle bundle) {

		Fragment fragment = null;
		FaeDataActivity activity = new FaeDataActivity();
		fragment = activity;
		fragment.setRetainInstance(true);
		fragment.setArguments(bundle);
		FragmentManager fragmentManager = getFragmentManager();
		// FaeDataActivity activity=(FaeDataActivity )fragment ;
		if (fragmentManager.findFragmentById(fragment.getId()) == null) {

			fragmentManager.beginTransaction()
					.add(R.id.content_frame, fragment, "faedata").commit();
		}
		if (fragmentManager.findFragmentByTag("fae_search_result") != null) {

			// 頁面轉到fae搜尋結果
			activity.parent = fragmentManager
					.findFragmentByTag("fae_search_result");
			fragmentManager
					.beginTransaction()
					.hide(fragmentManager
							.findFragmentByTag("fae_search_result")).commit();
		}
		if (fragmentManager.findFragmentByTag("faelist") != null) {
			activity.parent = fragmentManager.findFragmentByTag("faelist");
			fragmentManager.beginTransaction()
					.hide(fragmentManager.findFragmentByTag("faelist"))
					.commit();

		}

		fragmentManager.beginTransaction().show(fragment).commit();
	}

	public void clearFragments() {

		if (getFragmentManager().findFragmentByTag("customerdata_details2")  != null) {
			getFragmentManager().beginTransaction()
					.remove(getFragmentManager().findFragmentByTag("customerdata_details2"))
					.commit();
		}
		if (getFragmentManager().findFragmentByTag("customerdata_details") != null) {
			getFragmentManager().beginTransaction()
					.remove(getFragmentManager().findFragmentByTag("customerdata_details"))
					.commit();
		}
		if (getFragmentManager().findFragmentByTag("customerdatalist") != null) {
			getFragmentManager().beginTransaction()
					.remove(getFragmentManager().findFragmentByTag("customerdatalist"))
					.commit();
		}
		if (getFragmentManager().findFragmentByTag("apqp_search_result")  != null) {
			getFragmentManager().beginTransaction()
					.remove(getFragmentManager().findFragmentByTag("apqp_search_result"))
					.commit();
		}
		if (getFragmentManager().findFragmentByTag("act_apqp_adv_search")  !=null) {
			getFragmentManager().beginTransaction()
					.remove(getFragmentManager().findFragmentByTag("act_apqp_adv_search"))
					.commit();
		}
		if (getFragmentManager().findFragmentByTag("apqpdata")  != null) {
			getFragmentManager().beginTransaction()
					.remove(getFragmentManager().findFragmentByTag("apqpdata"))
					.commit();
		}
		if (getFragmentManager().findFragmentByTag("apqpadd")  != null) {
			getFragmentManager().beginTransaction()
					.remove(getFragmentManager().findFragmentByTag("apqpadd"))
					.commit();
		}
		if (getFragmentManager().findFragmentByTag("apqplist")  != null) {
			getFragmentManager().beginTransaction()
					.remove(getFragmentManager().findFragmentByTag("apqplist"))
					.commit();
		}
		if (getFragmentManager().findFragmentByTag("camera") != null) {
			getFragmentManager()
					.beginTransaction()
					.remove(getFragmentManager()
							.findFragmentByTag("camera")).commit();
		}
		if (getFragmentManager().findFragmentByTag("preshipping") != null) {
			getFragmentManager()
					.beginTransaction()
					.remove(getFragmentManager()
							.findFragmentByTag("preshipping")).commit();
		}
		if(getFragmentManager().findFragmentByTag("goods")!=null){
			getFragmentManager().beginTransaction().remove(getFragmentManager().findFragmentByTag("goods")).commit();
		}
		if (getFragmentManager().findFragmentByTag("bom") != null) {
			getFragmentManager().beginTransaction()
					.remove(getFragmentManager().findFragmentByTag("bom"))
					.commit();
		}
		if (getFragmentManager().findFragmentByTag("stock") != null) {
			getFragmentManager().beginTransaction()
					.remove(getFragmentManager().findFragmentByTag("stock"))
					.commit();
		}
		if (getFragmentManager().findFragmentByTag("faedata")  != null) {
			getFragmentManager().beginTransaction()
					.remove(getFragmentManager().findFragmentByTag("faedata"))
					.commit();
	}
		if (getFragmentManager().findFragmentByTag("fae_search_result") != null) {
			getFragmentManager().beginTransaction()
					.remove(getFragmentManager().findFragmentByTag("fae_search_result"))
					.commit();

		}
		if (getFragmentManager().findFragmentByTag("faelist") != null) {
			getFragmentManager().beginTransaction()
					.remove(getFragmentManager().findFragmentByTag("faelist"))
					.commit();

		}
	}

	/**
	 * Function D
	 * 
	 * @author
	 * 
	 */
	private class DrawerItemClickListener implements
			ListView.OnItemClickListener {
		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {

			selectItem(position);
		}
	}

	/**
	 * Function E 左側選單點選Logout執行的動作 =>離開程式
	 */
	private void exitApp() {

		// 清空帳號密碼
		SaveSharedPreference.setConfig(MainActivity.this, "Config",
				"LoginUser", "");

		// 終止流程 離開程式
		android.os.Process.killProcess(android.os.Process.myPid());
		finish();
		System.exit(0);
	}

	/**
	 * 簡易測試網路是否可連線 Function G
	 * 
	 * @param url
	 * @return
	 */
	public static String GET(String url) {

		InputStream inputStream = null;
		String result = "";
		try {

			// create HttpClient
			HttpClient httpclient = new DefaultHttpClient();

			// make GET request to the given URL
			HttpResponse httpResponse = httpclient.execute(new HttpGet(url));

			// receive response as inputStream
			inputStream = httpResponse.getEntity().getContent();

			// convert inputstream to string
			if (inputStream != null)
				result = convertInputStreamToString(inputStream);
			else
				result = "Did not work!";

		} catch (Exception e) {
			Log.d("InputStream", e.getLocalizedMessage());
			result = e.toString();
		}

		return result;
	}

	public int getOrientation() {
		return mOrientation;
	}

	/**
	 * function H
	 * 
	 * @param view
	 */
	public void home_announce_click(View view) {

		// Fragment fragment = null;
		FragmentManager fragmentManager = getFragmentManager();
		if (fragmentManager.findFragmentByTag("homedetail") != null) {
			fragmentManager.beginTransaction()
					.remove(fragmentManager.findFragmentByTag("homedetail"))
					.commit();
		}
		if (fragmentAnnounce == null) {
			fragmentAnnounce = new NavbarAnnounceActivity();
		}

		if (fragmentManager.findFragmentById(fragmentAnnounce.getId()) == null) {
			fragmentManager.beginTransaction()
					.add(R.id.content_frame, fragmentAnnounce, "announce")
					.commit();
		}
		if (fragmentManager.findFragmentByTag("detail") != null
				&& fragmentCurrent == fragmentMessage) {
			fragmentCurrent = fragmentManager.findFragmentByTag("detail");
		}

		if (fragmentCurrent != null)
			fragmentManager.beginTransaction().hide(fragmentCurrent).commit();
		fragmentManager.beginTransaction().show(fragmentAnnounce).commit();
		// ((NavbarAnnounceActivity)fragmentAnnounce).showActionbar();
		fragmentCurrent = fragmentAnnounce;
		setSearchViewVisibility(View.GONE);
		showActionbar();
		setTitle("Announce");
		// fragmentManager.beginTransaction().replace(R.id.content_frame,
		// fragmentAnnounce).commit();
		// setSearchViewVisibility(View.GONE);
	}

	/**
	 * 
	 * @param view
	 */
	public void home_message_click(View view) {

		// Fragment fragment = null;
		if (fragmentMessage == null) {
			fragmentMessage = new NavbarMessageActivity();
			fragmentMessage.setRetainInstance(true);
		}
		// if(fragmentCurrent!=null&&fragmentMessage.getId()==fragmentCurrent.getId())return
		// ;
		FragmentManager fragmentManager = getFragmentManager();

		if (fragmentManager.findFragmentById(fragmentMessage.getId()) == null) {
			fragmentManager.beginTransaction()
					.add(R.id.content_frame, fragmentMessage, "message")
					.commit();
		}

		if (fragmentCurrent != null)
			fragmentManager.beginTransaction().hide(fragmentCurrent).commit();
		if (fragmentManager.findFragmentByTag("detail") == null) {
			if (fragmentManager.findFragmentByTag("homedetail") != null) {
				fragmentManager.beginTransaction()
						.show(fragmentManager.findFragmentByTag("homedetail"))
						.commit();
				hideActionbar();
			} else {
				fragmentManager.beginTransaction().show(fragmentMessage)
						.commit();
				showActionbar();
				setSearchViewVisibility(View.VISIBLE);
				fragmentCurrent = fragmentMessage;
			}
		} else {
			fragmentManager.beginTransaction()
					.show(fragmentManager.findFragmentByTag("detail")).commit();
			fragmentCurrent = fragmentManager.findFragmentByTag("detail");
			hideActionbar();
		}
		setTitle("Message");
		// fragmentManager.beginTransaction().replace(R.id.content_frame,
		// fragmentMessage).commit();
		// setSearchViewVisibility(View.VISIBLE);
	}

	/**
	 * 首頁按下tab =>Favorite
	 * 
	 * @param view
	 */
	public void home_favorite_click(View view) {

		FragmentManager fragmentManager = getFragmentManager();
		if (fragmentManager.findFragmentByTag("homedetail") != null) {
			fragmentManager.beginTransaction()
					.remove(fragmentManager.findFragmentByTag("homedetail"))
					.commit();
		}
		if (fragmentFavorite == null) {
			fragmentFavorite = new NavbarFavoriteActivity();
			fragmentFavorite.setRetainInstance(true);
		}

		if (fragmentManager.findFragmentById(fragmentFavorite.getId()) == null) {

			fragmentManager.beginTransaction()
					.add(R.id.content_frame, fragmentFavorite).commit();
		}
		if (fragmentManager.findFragmentByTag("detail") != null
				&& fragmentCurrent == fragmentMessage) {
			fragmentCurrent = fragmentManager.findFragmentByTag("detail");
		}

		if (fragmentCurrent != null)
			fragmentManager.beginTransaction().hide(fragmentCurrent).commit();
		fragmentManager.beginTransaction().show(fragmentFavorite).commit();
		// ((NavbarFavoriteActivity)fragmentFavorite).showActionbar();
		fragmentCurrent = fragmentFavorite;
		// fragmentManager.beginTransaction().replace(R.id.content_frame,
		// fragmentFavorite).commit();
		setSearchViewVisibility(View.GONE);
		showActionbar();
		setTitle("Favorite");

	}

	/**
	 * 隱藏Action Bar
	 */
	public void hideActionbar() {

		ActionBar mActionBar = getActionBar();
		if (mActionBar.isShowing())
			mActionBar.hide();
	}

	/**
	 * 初始化ActionBar Function I
	 */
	private void initActionBar() {

		ActionBar bar = getActionBar();
		/*
		 * bar.setDisplayHomeAsUpEnabled(true); bar.setHomeButtonEnabled(true);
		 * bar.setIcon(getResources().getDrawable(R.drawable.menu)); //ß
		 * bar.setIcon(new
		 * ColorDrawable(getResources().getColor(android.R.color.transparent)));
		 * bar
		 * .setBackgroundDrawable(getResources().getDrawable(R.drawable.actionbar_bg
		 * ));
		 * 
		 * centerActionBarTitle();
		 */
		bar.setHomeButtonEnabled(true);
		//
		bar.setBackgroundDrawable(getResources().getDrawable(
				R.drawable.actionbar_bg));
		bar.setIcon(new ColorDrawable(getResources().getColor(
				android.R.color.transparent)));
		bar.setDisplayShowTitleEnabled(true);
		bar.setDisplayHomeAsUpEnabled(true);
		bar.setDisplayUseLogoEnabled(true);

		// getActionBar().setIcon(R.drawable.ic_navigation_drawer);

		LayoutInflater mInflater = LayoutInflater.from(this);

		mCustomView = mInflater.inflate(R.layout.actionbar, null);// 加載actionbar布局:圖1_2_1

		TextView mTitleTextView = (TextView) mCustomView
				.findViewById(R.id.title_text);// 取出mCustomView的TextView
		mTitle = "Home";
		mTitleTextView.setText(mTitle);// 設定TextView(標題)

		ImageView imgView = (ImageView) mCustomView.findViewById(R.id.imgmenu);
		MarginLayoutParams marginParams = new MarginLayoutParams(
				imgView.getLayoutParams());
		marginParams.setMargins(30, 0, 0, 0);
		RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(
				marginParams);
		imgView.setLayoutParams(layoutParams);
		imgView.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View view) {

				boolean drawerOpen = layDrawer.isDrawerOpen(lstDrawer);
				if (drawerOpen) {
					layDrawer.closeDrawer(Gravity.LEFT);
				} else {
					layDrawer.openDrawer(Gravity.LEFT);
				}

			}
		});

		bar.setCustomView(mCustomView);
		bar.setDisplayShowCustomEnabled(true);
		setSearchViewVisibility(View.GONE);
	}

	/**
	 * 初始化Navigation Drawer "導覽抽屜"(隱藏式側選單)一個從螢幕左邊轉換而來的面板， 用來顯示 App 主要的導覽選項。(1)
	 */
	private void initDrawer() {

		setContentView(R.layout.drawer);// 側邊攔的XML

		layDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);
		lstDrawer = (ListView) findViewById(R.id.left_drawer);

		layDrawer
				.setDrawerShadow(R.drawable.drawer_shadow, GravityCompat.START);

		mTitle = mDrawerTitle = getTitle();

		// 該Activity有actiobbar,因此使用ActionBarDrawerToggle來監聽
		drawerToggle = new ActionBarDrawerToggle(this,/* host Activity */
		layDrawer,/* DrawerLayout object */
		android.R.color.transparent,/* 透明 nav drawer image to replace 'UP' creat */
		R.string.drawer_open,/* open drawer 描述 */
		R.string.drawer_close/* close drawer 描述 */
		) {

			@Override
			public void onDrawerClosed(View view) {
				super.onDrawerClosed(view);
				setTitle(mTitle);
				// getActionBar().setTitle(mTitle);
			}

			@Override
			public void onDrawerOpened(View drawerView) {
				super.onDrawerOpened(drawerView);
				setTitle(mTitle);
			}
		};
		drawerToggle.syncState();

		/*
		 * 監聽左側Menu展開或隱藏 public void onDrawerClosed(View view) public void
		 * onDrawerOpened(View drawerView) {
		 */
		layDrawer.setDrawerListener(drawerToggle);

	}

	/**
	 * 初始化Navigation Drawer "導覽抽屜"(隱藏式側選單)一個從螢幕左邊轉換而來的面板， 用來顯示 App 主要的導覽選項。(2)
	 */
	private void initDrawerList() {

		// load slide menu items
		navMenuTitles = getResources().getStringArray(R.array.nav_drawer_items);

		// nav drawer icons from resources
		navMenuIcons = getResources()
				.obtainTypedArray(R.array.nav_drawer_icons);
		navDrawerItems = new ArrayList<NavDrawerItem>();
		// drawer_menu =
		// this.getResources().getStringArray(R.array.nav_drawer_items);
		// adding nav drawer items to array
		// Home
		navDrawerItems.add(new NavDrawerItem(navMenuTitles[0], navMenuIcons
				.getResourceId(0, -1)));
		// Sale
		navDrawerItems.add(new NavDrawerItem(navMenuTitles[1], navMenuIcons
				.getResourceId(1, -1)));
		// Customer Service
		navDrawerItems.add(new NavDrawerItem(navMenuTitles[2], navMenuIcons
				.getResourceId(2, -1)));
		// CRM
		navDrawerItems.add(new NavDrawerItem(navMenuTitles[3], navMenuIcons
				.getResourceId(3, -1)));
		// Inventory
		navDrawerItems.add(new NavDrawerItem(navMenuTitles[4], navMenuIcons
				.getResourceId(4, -1)));
		// Calendar
		navDrawerItems.add(new NavDrawerItem(navMenuTitles[5], navMenuIcons
				.getResourceId(5, -1)));
		// Setting
		navDrawerItems.add(new NavDrawerItem(navMenuTitles[6], navMenuIcons
				.getResourceId(6, -1)));
		// Help
		// navDrawerItems.add(new NavDrawerItem(navMenuTitles[7], navMenuIcons
		// .getResourceId(7, -1)));
		// about
		// navDrawerItems.add(new NavDrawerItem(navMenuTitles[8], navMenuIcons
		// .getResourceId(8, -1)));
		// Logout
		navDrawerItems.add(new NavDrawerItem(navMenuTitles[7], navMenuIcons
				.getResourceId(7, -1)));

		// Recycle the typed array
		navMenuIcons.recycle();

		// ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
		// R.layout.drawer_list_item, drawer_menu);
		adapter = new NavDrawerListAdapter(getApplicationContext(),
				navDrawerItems);

		lstDrawer.setAdapter(adapter);
		lstDrawer.setOnItemClickListener(new DrawerItemClickListener());
	}

	/**
	 * 
	 * @return
	 */
	protected boolean isAlwaysExpanded() {
		return false;
	}

	// Function O
	/**
	 * 整個app的進入點!!
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {

		// 下列語法可排除Network Exception的錯誤
		StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
				.detectDiskReads().detectDiskWrites().detectNetwork()
				.penaltyLog().build());
		StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()
				.detectLeakedSqlLiteObjects().penaltyLog().penaltyDeath()
				.build());
		// end
		super.onCreate(savedInstanceState);
		/* 先去檢查app是否有更新的版本 begin */
		mUpdateManager = new UpdateManager(this);
		mUpdateManager.checkUpdate();

		/* 先去檢查app是否有更新的版本 end */
		/*
		 * 大陸無法使用GCM gcm = new MagicLenGCM(this); gcm.openGCM(); regId =
		 * gcm.getRegistrationId(); new HttpGetAsyncTask() .execute(
		 * "http://eip2test.winway.com.tw/SaveAndroidRegisID.ashx?RegistrationID="
		 * + regId);
		 */
		if (push_state == 0) {
			// Parse.initialize(this,
			// "wuSs4itQyq4b4RigOte19kgx8Gp3JapNhlbe47YB",
			// "0oCBHmybhRYDicaD9MxIMcq2CsJ6NVShYfiUcLO2");
			Parse.initialize(this, "rI8E6TrPVzFdco5tNmcrGOgYUxNiApVtVhpSatzC",
					"ZllPIihagnw0AdpWTVWzHQzdgZwbEM8Dagt2w0LD");
			ParsePush.subscribeInBackground("", new SaveCallback() {
		        @Override
		        public void done(ParseException e) {
		            if (e == null) {
		                Log.d("com.parse.push", "successfully subscribed to the broadcast channel.");
		            } else {
		                Log.e("com.parse.push", "failed to subscribe for push", e);
		            }
		        }
		    });
			ParseInstallation.getCurrentInstallation().saveInBackground();
			push_state = 1;
		}
		Intent intent = this.getIntent();
		if (intent != null) {
			try {
				Bundle extras = intent.getExtras();
				if (extras != null && !extras.isEmpty()) {
					JSONObject json = new JSONObject(
							extras.getString("com.parse.Data"));
					if (json.getString("action").equals("app_update")) {
						mUpdateManager.showNoticeDialog();
					}
					// if(json.getString("alert")!=null)
					// {
					// showDialog(extras.getString("alert"));
					// }
				}

			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		initActionBar();
		initDrawer();
		initDrawerList();

		if (savedInstanceState == null) {
			selectItem(0);
		}
		// sm = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		// home
		if (drawerToggle.onOptionsItemSelected(item)) {
			return true;
		}

		// action buttons
		switch (item.getItemId()) {

		default:
			break;
		}

		return super.onOptionsItemSelected(item);
	}

	@Override
	/**
	 * 利用覆寫onCreateOptionsMenu, onOptionsItemSelected這二個方法來建立選單。
	 */
	public boolean onCreateOptionsMenu(Menu menu) {

		// getMenuInflater().inflate(R.menu.main, menu);
		super.onCreateOptionsMenu(menu);
		/*
		 * MenuInflater inflater = getMenuInflater();
		 * inflater.inflate(R.menu.main, menu); MenuItem searchItem =
		 * menu.findItem(R.id.action_search); mSearchView = (SearchView)
		 * searchItem.getActionView(); setupSearchView(searchItem);
		 */
		return true;

	}

	/*
	 * @Override public boolean onQueryTextChange(String newText) {
	 * 
	 * // TODO Auto-generated method stub // mStatusView.setText("SEARCH = " +
	 * newText); return false; }
	 * 
	 * @Override public boolean onQueryTextSubmit(String query) {
	 * 
	 * // TODO Auto-generated method stub // mStatusView.setText("SEARCH = " +
	 * query + " : submitted"); return false; }
	 */
	/**
	 * 
	 * @return
	 */
	public boolean onClose() {

		// mStatusView.setText("Closed!");
		return false;
	}

	/**
	 * Screenshot_20150410_10.jpg actapqpadd.xml 取消button被按下後的action
	 * 
	 * @param view
	 */
	public void onCancelApqpClick(View view) {

		FragmentManager fragmentManager = getFragmentManager();
		Fragment fragment = new ApqpListActivity();
		// 回到apqp列表
		fragmentManager.beginTransaction()
				.replace(R.id.content_frame, fragment, "apqplist").commit();
		hideActionbar();

	}

	/**
	 * Screenshot_20150410_16.jpg
	 * 
	 * @param view
	 */
	public void onApqpClick(View view) {

		FragmentManager fragmentManager = getFragmentManager();
		Fragment fragment = new ApqpListActivity();
		// 進入apqp列表
		fragmentManager.beginTransaction()
				.replace(R.id.content_frame, fragment, "apqplist").commit();
		hideActionbar();
	}

	// func :onCustClick
	// xml :actsale.xml
	// desc :由Sale頁面呼叫客戶清單頁面
	// create:15/05/20
	// auther:cooper
	public void onCustClick(View view) {
		FragmentManager fragmentManager = getFragmentManager();
		Fragment fragment = new CustomerListActivity();
		// 進入Customer列表
		fragmentManager.beginTransaction()
				.replace(R.id.content_frame, fragment, "customerlist").commit();
		hideActionbar();
	}

	public void onOrderClick(View view) {
		FragmentManager fragmentManager = getFragmentManager();
		OrderInfoActivity activity = new OrderInfoActivity();
		activity.setFragmentManager(fragmentManager);
		// activity.setParent((Fragment) MainActivity.this);
		Fragment fragment = activity;
		// 進入Customer列表
		fragmentManager.beginTransaction()
				.replace(R.id.content_frame, fragment, "orderlist").commit();
		hideActionbar();
	}
    public void onProjectClick(View view)
    {
    	FragmentManager fragmentManager = getFragmentManager();
		ProjectFindActivity activity = new ProjectFindActivity();
		activity.setFragmentManager(fragmentManager);
		Bundle b = new Bundle();
		if (view.getId() == R.id.imgStock) {
			b.putInt("frg_id", R.layout.actsale);
			b.putString("return_title", "Sale");
		}
		activity.setArguments(b);
		Fragment fragment = activity;
		fragmentManager.beginTransaction()
				.replace(R.id.content_frame, fragment, "projectfind").commit();
		//hideActionbar();
    	
    }
	public void onStockClick(View view) {
		FragmentManager fragmentManager = getFragmentManager();
		StockActivity activity = new StockActivity();
		Bundle b = new Bundle();
		if (view.getId() == R.id.imgStock2) {
			b.putInt("frg_id", R.layout.actinventory);
			b.putString("return_title", "Inventory");
		}
		if (view.getId() == R.id.imgStock) {
			b.putInt("frg_id", R.layout.actsale);
			b.putString("return_title", "Sale");
		}
		activity.setArguments(b);
		activity.setFragmentManager(fragmentManager);
		Fragment fragment = activity;
		fragmentManager.beginTransaction()
				.replace(R.id.content_frame, fragment, "stock").commit();
		hideActionbar();
	}

	/**
	 * Screenshot_20150410_15.jpg
	 * 
	 * @param view
	 */
	public void onFAEClick(View view) {

		FragmentManager fragmentManager = getFragmentManager();
		Fragment fragment = new FaeListActivity();

		// 進入fae列表
		fragmentManager.beginTransaction()
				.replace(R.id.content_frame, fragment, "faelist").commit();
		hideActionbar();
	}

	/**
	 * actapqpadd.xml EditText =>edit_apqptype被按下觸發的Action
	 * 
	 * @param view
	 */
	public void onApqpTypeClick(View view) {

		// setContentView(R.layout.actapqpadd);
		RelativeLayout r3 = (RelativeLayout) this.findViewById(R.id.r3);
		RelativeLayout r4 = (RelativeLayout) this.findViewById(R.id.r4);
		if (r4 != null && r4.isShown()) {
			r4.setVisibility(RelativeLayout.GONE);
			// r4.getLayoutParams().height=0;

		}
		if (r3 != null && r3.isShown() == false) {
			r3.setVisibility(RelativeLayout.VISIBLE);
			// r3.getLayoutParams().height=200;
			// WebView mWebView =(WebView) view.findViewById(R.id.webView1);
			// mWebView.setWebViewClient(mWebViewClient);
			// mWebView.getSettings().setJavaScriptEnabled(true);
			// mWebView.loadUrl("file:///android_asset/apqptype.html");
		}

	}

	/**
	 * actapqpadd.xml Button=>apaptype_cancel 按下觸發的Action
	 * 
	 * @param view
	 */
	public void onApqpTypeCancelClick(View view) {

		// setContentView(R.layout.actapqpadd);
		RelativeLayout r3 = (RelativeLayout) this.findViewById(R.id.r3);
		if (r3 != null && r3.isShown()) {
			r3.setVisibility(RelativeLayout.GONE);

		}

	}

	/**
	 * 
	 * @param view
	 */
	public void onApqpTypeOKClick(View view) {

		EditText apqpText = (EditText) this.findViewById(R.id.xa593);

		RelativeLayout r3 = (RelativeLayout) this.findViewById(R.id.r3);
		if (apqpText != null) {
			// 取得資料
			String PREFS_NAME = "apqpadd";// 一個標籤 可以設定為代表此APP的String Tag
			int getInt;
			SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
			apqpText.setText(settings.getString("ApqpType", "SOCKET"));// settings.getInt(所對應的key,如果抓不到對應的值要給什麼預設值)
		}
		if (r3 != null && r3.isShown()) {
			r3.setVisibility(RelativeLayout.GONE);

		}

	}

	public void onAdvSearch(View v) {

		FragmentManager fragmentManager = getFragmentManager();
		Fragment fragment = new ApqpAdvSearchActivity();
		fragment.setRetainInstance(true);
		if (fragmentManager.findFragmentById(fragment.getId()) == null) {
			fragmentManager.beginTransaction()
					.add(R.id.content_frame, fragment, "act_apqp_adv_search")
					.commit();
		}
		if (fragmentManager.findFragmentByTag("apqplist") != null) {
			fragmentManager.beginTransaction()
					.hide(fragmentManager.findFragmentByTag("apqplist"))
					.commit();
		}

		fragmentManager.beginTransaction().show(fragment).commit();

	}

	/**
	 * actapqpadd.xml Button=>issuedate_cancel 按下觸發的Action
	 * 
	 * @param view
	 */
	public void onIssueDateCancelClick(View view) {

		// 日期選單消失
		RelativeLayout r4 = (RelativeLayout) this.findViewById(R.id.r4);
		if (r4 != null && r4.isShown()) {
			r4.setVisibility(RelativeLayout.GONE);

		}

	}

	/**
	 * actapqpadd.xml Button=>issuedate_ok觸發的action
	 * 
	 * @param view
	 */
	public void onIssueDateOKClick(View view) {

		RelativeLayout r4 = (RelativeLayout) this.findViewById(R.id.r4);
		EditText issuedateText = (EditText) this
				.findViewById(R.id.edit_issuedate);
		DatePicker dp = (DatePicker) this.findViewById(R.id.datePicker1);
		if (issuedateText != null) {
			issuedateText.setText(String.format("%d%02d%02d", dp.getYear(),
					dp.getMonth() + 1, dp.getDayOfMonth()));

		}
		if (r4 != null && r4.isShown()) {
			r4.setVisibility(RelativeLayout.GONE);

		}

	}

	/**
	 * actapqpadd.xml EditText=>edit_issuedate觸發的action
	 * 
	 * @param view
	 */
	public void onIssueDateClick(View view) {

		// setContentView(R.layout.actapqpadd);

		RelativeLayout r3 = (RelativeLayout) this.findViewById(R.id.r3);
		RelativeLayout r4 = (RelativeLayout) this.findViewById(R.id.r4);
		if (r3 != null && r3.isShown()) {
			r3.setVisibility(RelativeLayout.GONE);
			// r3.getLayoutParams().height=0;
		}
		if (r4 != null && r4.isShown() == false) {
			r4.setVisibility(RelativeLayout.VISIBLE);
			// r4.getLayoutParams().height=200;
		}
	}

	/**
	 * 
	 * @param v
	 */
	/*
	 * public void onCustEdit(View v) {
	 * 
	 * // mView=getView(); ((Button) v).setVisibility(View.GONE); Button b =
	 * (Button) this.findViewById(R.id.btn_change_cust);
	 * b.setVisibility(View.VISIBLE);
	 * 
	 * }
	 */

	/**
	 * 
	 * @param v
	 */
	public void onCustChange(View v) {

		// mView=getView();
		((Button) v).setVisibility(View.GONE);
		Button b = (Button) this.findViewById(R.id.btn_apqp_edit);
		b.setVisibility(View.VISIBLE);
	}

	/**
	 * 螢幕旋轉時觸發之事件
	 */
	@Override
	public void onConfigurationChanged(Configuration newConfig) {

		// TODO Auto-generated method stub
		Toast.makeText(this, "系統螢幕發生變化", Toast.LENGTH_SHORT).show();
		super.onConfigurationChanged(newConfig);
		Log.d("onConfigurationChanged", "ConfigurationChanged");
		if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
			// do anything you want
		} else {
			// do anything you want
		}
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();

		Log.d("onDestroy", "onDestroy");
	}

	@Override
	protected void onResume() {
		super.onResume();
		FragmentManager fm = getFragmentManager();
		if (fm.findFragmentByTag("inventory") == null
				&& fm.findFragmentByTag("home") == null
				&& fm.findFragmentByTag("message") == null
				&& fm.findFragmentByTag("announce") == null
				&& fm.findFragmentByTag("cust_service") == null
				&& fm.findFragmentByTag("sale") == null
				&&fm.findFragmentByTag("wip") == null) {
			final Timer timer = new java.util.Timer(true);
			timer.schedule(new TimerTask() {
				@Override
				public void run() {
					hideActionbar();
				}
			},500);
		}

	}

	@Override
	protected void onPause() {
		super.onPause();

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
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
		super.onRestoreInstanceState(savedInstanceState);
		Log.d("onRestoreInstanceState", "onRestoreInstanceState");
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		Log.d("onSaveInstanceState", "onSaveInstanceState");
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {

		// System.out.println("");
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			return true;
		}
		return super.onKeyDown(keyCode, event);

	}

	/**
	 * Function P
	 * 
	 * @param view
	 */
	public void PopBackStack(View view) {

		FragmentManager fragmentManager = getFragmentManager();
		Fragment fragment = fragmentManager.findFragmentByTag("detail");
		fragmentManager.beginTransaction().remove(fragment).commit();
		fragmentManager.beginTransaction().show(fragmentMessage).commit();
		showActionbar();
		fragmentCurrent = fragmentMessage;
		// fragmentManager.popBackStackImmediate();

	}

	/**
	 * Function S 側邊攔被選取的是哪一列
	 * 
	 * @param position
	 */
	public void selectItem(int position) {
		Button btnAdd       =(Button)this.findViewById(R.id.btn_favorite_add);
		Button btnSearch       =(Button)this.findViewById(R.id.btn_search);
		btnSearch.setVisibility(View.GONE);
		btnAdd.setVisibility(View.GONE);

		Fragment fragment = null;
		String tagName = "";
		FragmentManager fragmentManager = getFragmentManager();

		switch (position) {
		case 0:// Home
			//tagName = "home";
			//fragment = new NavbarHomeActivity();
			tagName = "camera";
			fragment = new CameraActivity();
			fragment.setRetainInstance(true);
			break;
		case 1:// Sale
			tagName = "sale";
			fragment = new SaleActivity();
			fragment.setRetainInstance(true);
			break;
		case 2:// Customer Service
			tagName = "cust_service";
			fragment = new CustServiceActivity();
			fragment.setRetainInstance(true);
			break;
		case 4:// inventory
			tagName = "inventory";
			fragment = new InventoryActivity();
			fragment.setRetainInstance(true);
			break;
		case 7:// Logout
			exitApp();
			break;
		default:
			// fragment = new NavbarHomeActivity();
			return;
		}
		if (fragment == null)
			return;
		if (fragmentCurrent != null) {
			fragmentManager.beginTransaction().remove(fragmentCurrent).commit();
			fragmentCurrent = null;
		}
		if (fragmentManager.findFragmentByTag(tagName) != null) {
			fragmentManager.beginTransaction()
					.remove(fragmentManager.findFragmentByTag(tagName))
					.commit();
		}
		clearFragments();
		fragmentCurrent = fragment;
		fragmentManager.beginTransaction()
				.replace(R.id.content_frame, fragment, tagName).commit();
		lstDrawer.setItemChecked(position, true);
		// setTitle(drawer_menu[position]);
		setTitle(navMenuTitles[position]);
		layDrawer.closeDrawer(lstDrawer);
		// setSearchViewVisibility(View.GONE);
		// if(getActionBar().isShowing()==false){
		showActionbar();
		// }
		// loadMsgData();
	}

	static InputStream is = null;

	private static String convertInputStreamToString(InputStream inputStream)
			throws IOException {

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
	 * AsyncTask 非同步任務 在多執行序的情況下, 提供了更多的優點和更容易處理UI 元件, AsyncTask
	 * 已經幫我們定義處理前、後、中都可以去更新 UI 介面的方法, 也定義好在各狀態下傳送資料的參數.
	 * 
	 * @author
	 * 
	 */
	private class HttpGetAsyncTask extends AsyncTask<String, Void, String> {
		protected String doInBackground(String... urls) {

			return GET(urls[0]);
		}

		// onPostExecute displays the results of the AsyncTask.
		// AsyncTask => 非同步 ---背景工作處理完"後"需作的事
		@Override
		protected void onPostExecute(String result) {

		}
	}

	/**
	 * 
	 * @param view
	 */
	public void showApqpTab(View view) {

		LinearLayout l = (LinearLayout) view.findViewById(R.id.titlebar);
		RelativeLayout r = (RelativeLayout) l.findViewById(R.id.apqptab);
		RelativeLayout r3 = (RelativeLayout) l.findViewById(R.id.apqp_editbar);
		if (r != null && r.isShown() == false) {
			r.setVisibility(RelativeLayout.VISIBLE);
		} else {
			if (r != null)
				r.setVisibility(RelativeLayout.GONE);
		}
		if (r3 != null && r3.isShown() == false) {
			r3.setVisibility(RelativeLayout.VISIBLE);
		} else {
			if (r3 != null)
				r3.setVisibility(RelativeLayout.GONE);
		}
	}

	@Override
	/**
	 * 設定標題
	 */
	public void setTitle(CharSequence title) {

		Button btnAdd  =(Button)this.findViewById(R.id.btn_favorite_add);
		if(btnAdd.getVisibility()== View.VISIBLE)
		{
			btnAdd.setVisibility(View.GONE);
		}
		Button btnSearch  =(Button)this.findViewById(R.id.btn_search);
		if(btnSearch.getVisibility()== View.VISIBLE)
		{
			btnSearch.setVisibility(View.GONE);
		}
		mTitle = title;
		TextView mTitleTextView = (TextView) mCustomView
				.findViewById(R.id.title_text);
		mTitleTextView.setText(title);
		if(title.equals("Message"))
		{
			btnSearch.setVisibility(View.VISIBLE);
		}
		else if(title.equals("Favorite"))
		{
			btnAdd.setVisibility(View.VISIBLE);
		}
	}


	/**
	 * 設定副標
	 * 
	 * @param title
	 */
	public void setSubTitle(CharSequence title) {

		mTitle = title;
		TextView mTitleTextView = (TextView) mCustomView
				.findViewById(R.id.subtitle_text);
		if (mTitleTextView.getVisibility() != View.VISIBLE) {
			mTitleTextView.setVisibility(View.VISIBLE);
		}
		mTitleTextView.setText(title);
	}

	/**
	 * 載入搜尋畫面
	 * 
	 * @param searchItem
	 */
	/*
	 * private void setupSearchView(MenuItem searchItem) {
	 * 
	 * if (isAlwaysExpanded()) { mSearchView.setIconifiedByDefault(false); }
	 * else { searchItem.setShowAsActionFlags(MenuItem.SHOW_AS_ACTION_IF_ROOM |
	 * MenuItem.SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW); }
	 * 
	 * SearchManager searchManager = (SearchManager)
	 * getSystemService(Context.SEARCH_SERVICE); if (searchManager != null) {
	 * List<SearchableInfo> searchables = searchManager
	 * .getSearchablesInGlobalSearch();
	 * 
	 * SearchableInfo info = searchManager
	 * .getSearchableInfo(getComponentName()); for (SearchableInfo inf :
	 * searchables) { if (inf.getSuggestAuthority() != null &&
	 * inf.getSuggestAuthority().startsWith("applications")) { info = inf; } }
	 * mSearchView.setSearchableInfo(info); }
	 * 
	 * mSearchView.setOnQueryTextListener(this); }
	 */
	/**
	 * 顯示Actionbar
	 */

	public void showActionbar() {

		ActionBar mActionBar = getActionBar();
		if (mActionBar.isShowing() == false)
			mActionBar.show();
		Button btnCancel = ((Button) mCustomView.findViewById(R.id.btn_cancel));
		// hide Cancel Button,if show
		if (btnCancel != null && btnCancel.isShown()) {
			btnCancel.setVisibility(View.GONE);
		}
		Button btnSearch = ((Button) mCustomView.findViewById(R.id.btn_search));
		// hide Cancel Button,if show
		if (btnSearch != null && btnSearch.isShown()) {
			btnSearch.setVisibility(View.GONE);
		}
	}

	/**
	 * Function R 返回首頁
	 * 
	 * @param view
	 */
	public void returnHome(View view) {

		FragmentManager fragmentManager = getFragmentManager();
		// Fragment fragment = fragmentManager.findFragmentByTag("homedetail");
		if (fragmentManager.findFragmentByTag("homedetail") != null) {
			fragmentManager.beginTransaction()
					.remove(fragmentManager.findFragmentByTag("homedetail"))
					.commit();
		} else if (fragmentManager.findFragmentByTag("detail") != null) {
			fragmentManager.beginTransaction()
					.remove(fragmentManager.findFragmentByTag("detail"))
					.commit();
		}
		fragmentHome = fragmentManager.findFragmentByTag("home");
		if (fragmentHome != null) {
			fragmentManager.beginTransaction().show(fragmentHome).commit();
		} else {
			fragmentHome = new NavbarHomeActivity();
			fragmentManager.beginTransaction()
					.replace(R.id.content_frame, fragmentHome, "home").commit();
		}
		fragmentCurrent = fragmentHome;
		showActionbar();
		// fragmentManager.popBackStackImmediate();

	}

	/**
	 * 
	 * @param view
	 */
	public void returnApqpListActivity(View view) {

		/*
		 * Intent i=new Intent(MainActivity.this,ApqpDataActivity.class);
		 * i.putExtras(bundle); //將參數放入 startActivity(i);
		 */
		// Fragment fragment = null;
		// fragment = new ApqpListActivity();
		FragmentManager fragmentManager = getFragmentManager();
		if (fragmentManager.findFragmentByTag("apqpdata") != null) {
			fragmentManager.beginTransaction()
					.remove(fragmentManager.findFragmentByTag("apqpdata"))
					.commit();
		}
		if (fragmentManager.findFragmentByTag("apqpdata2") != null) {
			fragmentManager.beginTransaction()
					.remove(fragmentManager.findFragmentByTag("apqpdata2"))
					.commit();
		}

		if (fragmentManager.findFragmentByTag("apqplist") != null) {
			fragmentManager.beginTransaction()
					.show(fragmentManager.findFragmentByTag("apqplist"))
					.commit();
		}
		// fragmentManager.beginTransaction().show(fragment).commit();
	}

	/**
	 * 
	 * @param view
	 */
	public void returnApqpResultActivity(View view) {

		FragmentManager fragmentManager = getFragmentManager();
		if (fragmentManager.findFragmentByTag("apqpdata") != null) {
			fragmentManager.beginTransaction()
					.remove(fragmentManager.findFragmentByTag("apqpdata"))
					.commit();
		}
		if (fragmentManager.findFragmentByTag("apqpdata2") != null) {
			fragmentManager.beginTransaction()
					.remove(fragmentManager.findFragmentByTag("apqpdata2"))
					.commit();
		}
		if (fragmentManager.findFragmentByTag("apqp_search_result") != null) {
			fragmentManager
					.beginTransaction()
					.show(fragmentManager
							.findFragmentByTag("apqp_search_result")).commit();
		}

		// fragmentManager.beginTransaction().show(fragment).commit();
	}

	/**
	 * 
	 * @param view
	 */
	public void returnSale(View view) {

		FragmentManager fragmentManager = getFragmentManager();
		Fragment fragment = new SaleActivity();
		fragmentManager.beginTransaction()
				.replace(R.id.content_frame, fragment, "sale").commit();
		setTitle("Sale");
		showActionbar();
	}
	public void returnInventory(View view) {

		FragmentManager fragmentManager = getFragmentManager();
		Fragment fragment = new InventoryActivity();
		fragmentManager.beginTransaction()
				.replace(R.id.content_frame, fragment, "Inventory").commit();
		setTitle("Inventory");
		showActionbar();
	}
	/**
	 * 
	 * @param view
	 */
	public void returnResult(View view) {

		FragmentManager fragmentManager = getFragmentManager();
		if (fragmentManager.findFragmentByTag("apqpdata2") != null) {
			fragmentManager.beginTransaction()
					.remove(fragmentManager.findFragmentByTag("apqpdata2"))
					.commit();
		}
		if (fragmentManager.findFragmentByTag("apqpdata") != null) {
			fragmentManager.beginTransaction()
					.remove(fragmentManager.findFragmentByTag("apqpdata"))
					.commit();

		}
		fragmentManager.beginTransaction()
				.show(fragmentManager.findFragmentByTag("apqp_search_result"))
				.commit();
	}

	/**
	 * 設定搜尋是否可見
	 * 
	 * @param v
	 */
	private void setSearchViewVisibility(int v) {

		// TextView mSearchTextView = (TextView)
		// mCustomView.findViewById(R.id.search_text);
		Button btnSearch = (Button) mCustomView.findViewById(R.id.btn_search);
		if (btnSearch != null && btnSearch.getVisibility() != v)
			btnSearch.setVisibility(v);

	}

	public void showDialog(String msg) {
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setMessage(msg).setCancelable(false)
				.setPositiveButton("確定", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int id) {
					}
				}).show();

	}

	//------------------------------------------------------------------------- */
	// 下面是 QT Function Beg                                                                         */
	//------------------------------------------------------------------------- */
	public void createQT(View view) {

		FragmentManager fragmentManager = getFragmentManager();
		Fragment fragment = new QtAddActivity();
		fragmentManager.beginTransaction()
				.replace(R.id.content_frame, fragment,  "qtadd").commit();
		// hideActionbar();

	}


	// 20151115 OK
	// actqtlist.xml -> btnAddQt -> onClick="createQT"
	//
	/**
	 * QT List導覽列按下+(=>進入Add QT)
	 *
	 * @param view
	 */
	/* createQT 改用 actqtlist_btnAddQt_onClick
	public void createQT(View view) {

		FragmentManager fragmentManager = getFragmentManager();
		Fragment fragment = new QtAddActivity();
		fragmentManager.beginTransaction()
				.replace(R.id.content_frame, fragment, "qtadd").commit();
		// hideActionbar();

	}
    */
	public void actqtlist_btnAddQt_onClick(View view) {

		FragmentManager fragmentManager = getFragmentManager();
		Fragment fragment = new QtAddActivity();
		fragmentManager.beginTransaction()
				.replace(R.id.content_frame, fragment, "qtadd").commit();
		// hideActionbar();

	}

	/**
	 *
	 * @param bundle
	 */
	public void callQtDataActivity3(Bundle bundle) {

		/*
		 * Intent i=new Intent(MainActivity.this,QtDataActivity.class);
		 * i.putExtras(bundle); //將參數放入 startActivity(i);
		 */
		Fragment fragment = null;
		fragment = new QtDataActivity3();
		fragment.setRetainInstance(true);
		fragment.setArguments(bundle);
		FragmentManager fragmentManager = getFragmentManager();
		if (fragmentManager.findFragmentById(fragment.getId()) == null) {
			fragmentManager.beginTransaction()
					.add(R.id.content_frame, fragment, "qtdata3").commit();
		}
		if (fragmentManager.findFragmentByTag("qtdata") != null) {
			fragmentManager.beginTransaction()
					.hide(fragmentManager.findFragmentByTag("qtdata"))
					.commit();
		}

		fragmentManager.beginTransaction().show(fragment).commit();
	}

	/**
	 * 在qt list的Fragment,按下列表得某一列,觸發的ACTION,要轉向相對應的qt data詳情頁
	 *
	 * @param bundle
	 */
	public void callQtDataActivity(Bundle bundle) {

		/*
		 * Intent i=new Intent(MainActivity.this,QtDataActivity.class);
		 * i.putExtras(bundle); //將參數放入 startActivity(i);
		 */
		Fragment fragment = null;
		FragmentManager fragmentManager = getFragmentManager();
		QtDataActivity activity = new QtDataActivity();
		// disable next statement
		// activity.setFragmentManager(fragmentManager) ;
		fragment = (Fragment) activity;
		fragment.setRetainInstance(true);
		fragment.setArguments(bundle);

		// 檢查資apapdata頁面使否存在，如果不存在則add
		if (fragmentManager.findFragmentById(fragment.getId()) == null) {
			fragmentManager.beginTransaction()
					.add(R.id.content_frame, fragment, "qtdata").commit();
		} // 檢查進階搜尋頁面是否已載入，如果已載入則將其隱藏
		if (fragmentManager.findFragmentByTag("qt_search_result") != null) {
			activity.setParent(fragmentManager
					.findFragmentByTag("qt_search_result"));
			fragmentManager
					.beginTransaction()
					.hide(fragmentManager
							.findFragmentByTag("qt_search_result")).commit();
		} // 檢查進清單頁面是否已載入，如果已載入則將其隱藏
		else if (fragmentManager.findFragmentByTag("qtlist") != null) {
			activity.setParent(fragmentManager.findFragmentByTag("qtlist"));
			fragmentManager.beginTransaction()
					.hide(fragmentManager.findFragmentByTag("qtlist"))
					.commit();

		}

		fragmentManager.beginTransaction().show(fragment).commit();
	}

	/**
	 * Screenshot_20150410_10.jpg actqtadd.xml 取消button被按下後的action
	 *
	 * @param view
	 */
	public void onCancelQtClick(View view) {

		FragmentManager fragmentManager = getFragmentManager();
		Fragment fragment = new QtListActivity();
		// 回到qt列表
		fragmentManager.beginTransaction()
				.replace(R.id.content_frame, fragment, "qtlist").commit();
		hideActionbar();

	}

	/**
	 * Screenshot_20150410_16.jpg
	 *
	 * @param view
	 */
	public void onQtClick(View view) {

		FragmentManager fragmentManager = getFragmentManager();
		Fragment fragment = new QtListActivity();
		// 進入qt列表
		fragmentManager.beginTransaction()
				.replace(R.id.content_frame, fragment, "qtlist").commit();
		hideActionbar();
	}

	/**
	 * actqtadd.xml EditText =>edit_qttype被按下觸發的Action
	 *
	 * @param view
	 */
	public void onQtTypeClick(View view) {

		// setContentView(R.layout.actqtadd);
		RelativeLayout r3 = (RelativeLayout) this.findViewById(R.id.r3);
		RelativeLayout r4 = (RelativeLayout) this.findViewById(R.id.r4);
		if (r4 != null && r4.isShown()) {
			r4.setVisibility(RelativeLayout.GONE);
			// r4.getLayoutParams().height=0;

		}
		if (r3 != null && r3.isShown() == false) {
			r3.setVisibility(RelativeLayout.VISIBLE);
			// r3.getLayoutParams().height=200;
			// WebView mWebView =(WebView) view.findViewById(R.id.webView1);
			// mWebView.setWebViewClient(mWebViewClient);
			// mWebView.getSettings().setJavaScriptEnabled(true);
			// mWebView.loadUrl("file:///android_asset/qttype.html");
		}

	}

	/**
	 * actqtadd.xml Button=>apaptype_cancel 按下觸發的Action
	 *
	 * @param view
	 */
	public void onQtTypeCancelClick(View view) {

		// setContentView(R.layout.actqtadd);
		RelativeLayout r3 = (RelativeLayout) this.findViewById(R.id.r3);
		if (r3 != null && r3.isShown()) {
			r3.setVisibility(RelativeLayout.GONE);

		}

	}

	/**
	 *
	 * @param view
	 */
	public void onQtTypeOKClick(View view) {

		EditText qtText = (EditText) this.findViewById(R.id.xa593);

		RelativeLayout r3 = (RelativeLayout) this.findViewById(R.id.r3);
		if (qtText != null) {
			// 取得資料
			String PREFS_NAME = "qtadd";// 一個標籤 可以設定為代表此APP的String Tag
			int getInt;
			SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
			qtText.setText(settings.getString("QtType", "SOCKET"));// settings.getInt(所對應的key,如果抓不到對應的值要給什麼預設值)
		}
		if (r3 != null && r3.isShown()) {
			r3.setVisibility(RelativeLayout.GONE);

		}

	}

	//20151111 onAdvSearch -> onQtAdvSearch
	public void onQtAdvSearch(View v) {

		FragmentManager fragmentManager = getFragmentManager();
		Fragment fragment = new QtAdvSearchActivity();
		fragment.setRetainInstance(true);
		if (fragmentManager.findFragmentById(fragment.getId()) == null) {
			fragmentManager.beginTransaction()
					.add(R.id.content_frame, fragment, "act_qt_adv_search")
					.commit();
		}
		if (fragmentManager.findFragmentByTag("qtlist") != null) {
			fragmentManager.beginTransaction()
					.hide(fragmentManager.findFragmentByTag("qtlist"))
					.commit();
		}

		fragmentManager.beginTransaction().show(fragment).commit();

	}

	/**
	 * actqtadd.xml Button=>issuedate_cancel 按下觸發的Action
	 *
	 * @param view
	 */
        /* 20151111 by daniel 下面 function 為 APQP / QT 共用
	public void onIssueDateCancelClick(View view) {

		// 日期選單消失
		RelativeLayout r4 = (RelativeLayout) this.findViewById(R.id.r4);
		if (r4 != null && r4.isShown()) {
			r4.setVisibility(RelativeLayout.GONE);

		}

	}
        */

	/**
	 * actqtadd.xml Button=>issuedate_ok觸發的action
	 *
	 * @param view
	 */
        /* 20151111 by daniel 下面 function 為 APQP / QT 共用
	public void onIssueDateOKClick(View view) {

		RelativeLayout r4 = (RelativeLayout) this.findViewById(R.id.r4);
		EditText issuedateText = (EditText) this
				.findViewById(R.id.edit_issuedate);
		DatePicker dp = (DatePicker) this.findViewById(R.id.datePicker1);
		if (issuedateText != null) {
			issuedateText.setText(String.format("%d%02d%02d", dp.getYear(),
					dp.getMonth() + 1, dp.getDayOfMonth()));

		}
		if (r4 != null && r4.isShown()) {
			r4.setVisibility(RelativeLayout.GONE);

		}

	}
        */


	/**
	 * actqtadd.xml EditText=>edit_issuedate觸發的action
	 *
	 * @param view
	 */
        /* 20151111 by daniel 下面 function 為 APQP / QT 共用
	public void onIssueDateClick(View view) {

		// setContentView(R.layout.actqtadd);

		RelativeLayout r3 = (RelativeLayout) this.findViewById(R.id.r3);
		RelativeLayout r4 = (RelativeLayout) this.findViewById(R.id.r4);
		if (r3 != null && r3.isShown()) {
			r3.setVisibility(RelativeLayout.GONE);
			// r3.getLayoutParams().height=0;
		}
		if (r4 != null && r4.isShown() == false) {
			r4.setVisibility(RelativeLayout.VISIBLE);
			// r4.getLayoutParams().height=200;
		}
	}
        */

	/**
	 *
	 * @param v
	 */
	//20151111 by daniel onCustChange -> onQtCustChange
	public void onQtCustChange(View v) {

		// mView=getView();
		((Button) v).setVisibility(View.GONE);
		Button b = (Button) this.findViewById(R.id.btn_qt_edit);
		b.setVisibility(View.VISIBLE);
	}

	/**
	 *
	 * @param view
	 */
	public void showQtTab(View view) {

		LinearLayout l = (LinearLayout) view.findViewById(R.id.titlebar);
		RelativeLayout r = (RelativeLayout) l.findViewById(R.id.qttab);
		RelativeLayout r3 = (RelativeLayout) l.findViewById(R.id.qt_editbar);
		if (r != null && r.isShown() == false) {
			r.setVisibility(RelativeLayout.VISIBLE);
		} else {
			if (r != null)
				r.setVisibility(RelativeLayout.GONE);
		}
		if (r3 != null && r3.isShown() == false) {
			r3.setVisibility(RelativeLayout.VISIBLE);
		} else {
			if (r3 != null)
				r3.setVisibility(RelativeLayout.GONE);
		}
	}

	/**
	 *
	 * @param view
	 */
	public void returnQtListActivity(View view) {

		/*
		 * Intent i=new Intent(MainActivity.this,QtDataActivity.class);
		 * i.putExtras(bundle); //將參數放入 startActivity(i);
		 */
		// Fragment fragment = null;
		// fragment = new QtListActivity();
		FragmentManager fragmentManager = getFragmentManager();
		if (fragmentManager.findFragmentByTag("qtdata") != null) {
			fragmentManager.beginTransaction()
					.remove(fragmentManager.findFragmentByTag("qtdata"))
					.commit();
		}
		if (fragmentManager.findFragmentByTag("qtdata2") != null) {
			fragmentManager.beginTransaction()
					.remove(fragmentManager.findFragmentByTag("qtdata2"))
					.commit();
		}

		if (fragmentManager.findFragmentByTag("qtlist") != null) {
			fragmentManager.beginTransaction()
					.show(fragmentManager.findFragmentByTag("qtlist"))
					.commit();
		}
		// fragmentManager.beginTransaction().show(fragment).commit();
	}

	/**
	 *
	 * @param view
	 */
	public void returnQtResultActivity(View view) {

		FragmentManager fragmentManager = getFragmentManager();
		if (fragmentManager.findFragmentByTag("qtdata") != null) {
			fragmentManager.beginTransaction()
					.remove(fragmentManager.findFragmentByTag("qtdata"))
					.commit();
		}
		if (fragmentManager.findFragmentByTag("qtdata2") != null) {
			fragmentManager.beginTransaction()
					.remove(fragmentManager.findFragmentByTag("qtdata2"))
					.commit();
		}
		if (fragmentManager.findFragmentByTag("qt_search_result") != null) {
			fragmentManager
					.beginTransaction()
					.show(fragmentManager
							.findFragmentByTag("qt_search_result")).commit();
		}

		// fragmentManager.beginTransaction().show(fragment).commit();
	}

	/**
	 *
	 * @param view
	 */
	//20151111 returnResult -> returnQtResult
	public void returnQtResult(View view) {

		FragmentManager fragmentManager = getFragmentManager();
		if (fragmentManager.findFragmentByTag("qtdata2") != null) {
			fragmentManager.beginTransaction()
					.remove(fragmentManager.findFragmentByTag("qtdata2"))
					.commit();
		}
		if (fragmentManager.findFragmentByTag("qtdata") != null) {
			fragmentManager.beginTransaction()
					.remove(fragmentManager.findFragmentByTag("qtdata"))
					.commit();

		}
		fragmentManager.beginTransaction()
				.show(fragmentManager.findFragmentByTag("qt_search_result"))
				.commit();
	}

    /*------------------------------------------------------------------------- */
	/* 上面是 QT Function End                                                                         */
    /*------------------------------------------------------------------------- */

}