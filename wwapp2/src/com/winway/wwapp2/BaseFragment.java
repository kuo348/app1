package com.winway.wwapp2;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ResponseHandler;
//import org.apache.http.entity.ContentType;
//import org.apache.http.entity.mime.HttpMultipartMode;
//import org.apache.http.entity.mime.MultipartEntityBuilder;
//import org.apache.http.entity.mime.content.ContentBody;
//import org.apache.http.entity.mime.content.FileBody;
//import org.apache.http.entity.mime.content.InputStreamBody;
//import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.HTTP;
import org.json.JSONException;
import org.json.JSONObject;

import android.R.string;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

public class BaseFragment extends Fragment {
	private int ACTION_MESSAGE;
	private View mView = null;
	protected static final int REFRESH_DATA = 0x00000002;
	protected static final int WHAT_DID_LOAD_DATA = 0;
	protected static final int WHAT_DID_REFRESH = 1;
	protected static final int WHAT_DID_MORE = 5;
	protected static final int WHAT_USER_CALLBACK = 6;
	private ProgressDialog barProgressDialog;
	private Handler updateBarHandler;
	private ArrayList<onDataReceiveListener> myList = new ArrayList<onDataReceiveListener>();
	private string sUser;
	private onDataReceiveListener _onDataReceiveListener = null;
	// private CharSequence _webServiceUrl;
	protected FragmentManager fragmentManager;
	protected Fragment parent = null;
	protected ICallback mCallback;
	public boolean isUploadFile;
	/**
	 * 建立公用的doWork 允許把要執行的 function放在一個物件內，把物件當参數丟進去
	 * (相當於丟一個function進去，實現callback)
	 * 
	 * @author
	 * 
	 */
	public interface ICallback {
		public abstract void doWork(Object object);
	}

	public void setParent(Fragment f) {

		this.parent = f;

	}

	// 把function當成callback物件，可丟來丟去，為了很好的實現callback
	/*
	 * 範例: task1.setCallback(new BaseFragment.ICallback() {
	 * 
	 * @Override public void doWork(Object obj) {
	 * 
	 * 
	 * try { //我要執行的code
	 * 
	 * } catch (JSONException e) {
	 * 
	 * }
	 * 
	 * }
	 * 
	 * });
	 */
	public void setCallback(ICallback callback) {

		this.mCallback = callback;

	}

	public void doWork(Object object) {

		if (this.mCallback != null) {
			this.mCallback.doWork(object);
		}
	}

	// 偵測是否有連到網路上
	private boolean checkNetworkConnected() {

		boolean result = false;
		ConnectivityManager CM = (ConnectivityManager) getActivity()
				.getSystemService(Context.CONNECTIVITY_SERVICE);
		if (CM == null) {
			result = false;
		} else {
			NetworkInfo info = CM.getActiveNetworkInfo();
			if (info != null && info.isConnected()) {
				if (!info.isAvailable()) {
					result = false;
				} else {
					result = true;
				}
				Log.d("connect", "[目前連線方式]" + info.getTypeName());
				Log.d("connect", "[目前連線狀態]" + info.getState());
				Log.d("connect", "[目前網路是否可使用]" + info.isAvailable());
				Log.d("connect", "[網路是否已連接]" + info.isConnected());
				Log.d("connect",
						"[網路是否已連接 或 連線中]" + info.isConnectedOrConnecting());
				Log.d("connect", "[網路目前是否有問題 ]" + info.isFailover());
				Log.d("connect", "[網路目前是否在漫遊中]" + info.isRoaming());
			}
		}
		return result;
	}

	// 設定FragmentManager
	public void setFragmentManager(FragmentManager fragmentManager) {

		this.fragmentManager = fragmentManager;
	}
	// 取得webservice的網址
	public CharSequence getWebServiceUrl() {

		return getResources().getString(R.string.WebServiceUrl);
	}

	// 設定檔儲存
	public static void setConfig(Context context, String name, String key,
			String value) {

		SharedPreferences settings = context.getSharedPreferences(name, 0);
		SharedPreferences.Editor PE = settings.edit();
		PE.putString(key, value);
		PE.commit();
	}

	// 設定檔讀取
	public static String getConfig(Context context, String name, String key,
			String def) {

		SharedPreferences settings = context.getSharedPreferences(name, 0);
		return settings.getString(key, def);
	}

	public String getLoginUser() {

		return getConfig(this.getActivity(), "Config", "LoginUser", "");
	}

	public int isLoading = 0;
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
					while (isLoading == 1) {
						if (i > 3)
							break;
						Thread.sleep(1000);
						i++;
					}
				} catch (Exception e) {

				}
				ringProgressDialog.dismiss();
			}
		}).start();
	}

	public static String PUT(String url, String json) {

		InputStream inputStream = null;
		String result = "";

		try {

			// 1. create HttpClient
			HttpClient httpclient = new DefaultHttpClient();

			// 2. make PUT request to the given URL
			HttpPut httpPut = new HttpPut(url);

			StringEntity se = new StringEntity(json, HTTP.UTF_8);

			httpPut.setEntity(se);

			// . Set some headers to inform server about the type of the content
			httpPut.setHeader("Accept", "application/json");
			httpPut.setHeader("Content-type", "application/json");
			// 3. Execute PUT request to the given URL
			HttpResponse httpResponse = httpclient.execute(httpPut);

			// 4. receive response as inputStream
			inputStream = httpResponse.getEntity().getContent();

			// 5. convert inputstream to string
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

	/**
	 * 跟webservice 溝通的靈魂程式
	 * 
	 * @param url
	 * @param json
	 * @return
	 */
	public static String POST(String url, String json) {

		InputStream inputStream = null;
		String result = "";

		try {

			// 1. create HttpClient
			HttpClient httpclient = new DefaultHttpClient();
			//HttpClient.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, 6000);
			//HttpClient.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT, 10000);


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

	public static String uploadFile(String urlAddress,
			Map<String, String> datas, Map<String, String> files) {

		// TODO Auto-generated method stub
		String result = "";
		String end = "\r\n";
		String twoHyphens = "--";
		String boundary = "*****";
		try {
			URL url = new URL(urlAddress);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			/* 允許Input、Output，不使用Cache */
			con.setDoInput(true);
			con.setDoOutput(true);
			con.setUseCaches(false);
			/* 設置傳送的method=POST */
			con.setRequestMethod("POST");
			/* setRequestProperty */
			con.setRequestProperty("Connection", "Keep-Alive");
			con.setRequestProperty("Charset", "UTF-8");
			con.setRequestProperty("Content-Type",
					"multipart/form-data;boundary=" + boundary);
			/* 設置DataOutputStream */
			DataOutputStream ds = new DataOutputStream(con.getOutputStream());
			// 文字
			if (datas != null) {

				Iterator iterator = datas.entrySet().iterator();
				// add data
				while (iterator.hasNext()) {
					@SuppressWarnings("unchecked")
					Map.Entry<String, String> entry = (Map.Entry<String, String>) iterator
							.next();
					ds.writeBytes(twoHyphens + boundary + end);
					ds.writeBytes("Content-Disposition: form-data; name=\""
							+ entry.getKey() + "\"" + end);
					ds.writeBytes(end);
					ds.writeBytes(entry.getValue());
					ds.writeBytes(end);
				}
			}

			// 發送的文件
			if (files != null) {
				Iterator iterator = files.entrySet().iterator();
				while (iterator.hasNext()) {
					@SuppressWarnings("unchecked")
					Map.Entry<String, String> entry = (Map.Entry<String, String>) iterator
							.next();
					File f = new File(entry.getValue());

					ds.writeBytes(twoHyphens + boundary + end);
					ds.writeBytes("Content-Disposition: form-data; "
							+ "name=\"" + entry.getKey() + "\";filename=\""
							+ f.getName() + "\"" + end);
					ds.writeBytes(end);
					/* 取得文件的FileInputStream */
					FileInputStream fStream = new FileInputStream(f);
					/* 設置每次寫入1024bytes */
					int bufferSize = 1024;
					byte[] buffer = new byte[bufferSize];
					int length = -1;
					/* 從文件讀取數據至緩衝區 */
					while ((length = fStream.read(buffer)) != -1) {
						/* 將資料寫入DataOutputStream中 */
						ds.write(buffer, 0, length);
					}
					ds.writeBytes(end);
					ds.writeBytes(twoHyphens + boundary + twoHyphens + end);
					/* close streams */
					fStream.close();
				}
			}
			ds.flush();
			/* 關閉DataOutputStream */
			ds.close();
			/* 取得Response內容 */
			InputStream inputStream = con.getInputStream();
			if (inputStream != null)
				result = convertInputStreamToString(inputStream);
			else
				result = "Did not work!";

		} catch (Exception e) {
			result = "{\"success\":\"false\", \"remark\":\"" + e.toString()
					+ "\"}";
		}
		return result;
	}

	/*
	 * public static String uploadFile(String url, Map<String, String> datas,
	 * Map<String, String> files){ // TODO Auto-generated method stub String
	 * result = "";
	 * 
	 * // Client-side HTTP transport library HttpClient httpClient = new
	 * DefaultHttpClient();
	 * 
	 * // using POST method HttpPost httpPostRequest = new HttpPost(url);
	 * Iterator iterator=null; try { MultipartEntityBuilder
	 * multiPartEntityBuilder = MultipartEntityBuilder.create();
	 * multiPartEntityBuilder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
	 * multiPartEntityBuilder.setCharset(Charset.forName(HTTP.UTF_8));
	 * if(datas!=null){ iterator = datas.entrySet().iterator(); //add data while
	 * (iterator.hasNext()) {
	 * 
	 * @SuppressWarnings("unchecked") Map.Entry<String, String> entry =
	 * (Map.Entry<String, String>) iterator.next();
	 * multiPartEntityBuilder.addTextBody(entry.getKey(),
	 * entry.getValue(),ContentType.MULTIPART_FORM_DATA); //
	 * multiPartEntityBuilder.addPart(entry.getKey(), new
	 * StringBody(entry.getValue(), ContentType.MULTIPART_FORM_DATA)); } } //
	 * 發送的文件 if (files != null) { iterator = files.entrySet().iterator(); while
	 * (iterator.hasNext()) {
	 * 
	 * @SuppressWarnings("unchecked") Map.Entry<String, String> entry =
	 * (Map.Entry<String, String>) iterator.next(); String path =
	 * entry.getValue(); //if ("".equals(path) || path == null) continue; File
	 * file = new File(entry.getValue()); //ContentBody cb=new FileBody(file);
	 * String filename=file.getName(); //
	 * multiPartEntityBuilder.addPart(entry.getKey(),new FileBody(file,
	 * ContentType.MULTIPART_FORM_DATA)); //
	 * multiPartEntityBuilder.addBinaryBody(entry.getKey(), file,
	 * ContentType.MULTIPART_FORM_DATA,filename);
	 * multiPartEntityBuilder.addBinaryBody(entry.getKey(),file); } }
	 * //multiPartEntityBuilder.addPart("file", bin);
	 * 
	 * HttpEntity entity=multiPartEntityBuilder.build();
	 * httpPostRequest.setEntity(entity);
	 * 
	 * // Execute POST request to the given URL HttpResponse httpResponse =
	 * null; httpResponse = httpClient.execute(httpPostRequest);
	 * 
	 * // receive response as inputStream InputStream inputStream = null;
	 * inputStream = httpResponse.getEntity().getContent();
	 * 
	 * if (inputStream != null) result =
	 * convertInputStreamToString(inputStream); else result = "Did not work!";
	 * return result; } catch (Exception e) {
	 * 
	 * return null; }
	 * 
	 * 
	 * }
	 */
	// 圖片上傳(非同步)
	public class ImageUploaderTask extends AsyncTask<Object, Void, String> {
		protected String doInBackground(Object... params) {
			String url = (String) params[0];
			@SuppressWarnings("unchecked")
			Map<String, String> datas = (Map<String, String>) params[1];
			@SuppressWarnings("unchecked")
			Map<String, String> files = (Map<String, String>) params[2];
			return uploadFile(url, datas, files);
			// return result;
		}

		// 在execute被調用後，立刻執行，一般用在背景任務前，對UI前台做一些標記(例如:回到UI線程，給一些進度圖示，告知已在進行中)
		@Override
		protected void onPreExecute() {

			// TODO Auto-generated method stub
			super.onPreExecute();			
		}

		// 當背景程式操作結束，此方法被調用，計算結果將作為参數傳遞到此方法中，直接將結果顯示在UI上
		@Override
		protected void onPostExecute(String result) {

			// TODO Auto-generated method stub
			super.onPostExecute(result);
			isUploadFile=false;
			// showDialog("upload", result);
			// uploadStatus.setText(result);
		}

	}

	public class HttpPutAsyncTask extends AsyncTask<String, Void, String> {
		protected ICallback mCallback;

		public void setCallback(ICallback callback) {

			this.mCallback = callback;

		}

		private void doWork(Object object) {

			if (this.mCallback != null) {
				this.mCallback.doWork(object);
			}
		}

		protected String doInBackground(String... urls) {

			return PUT(urls[0], urls[1]);
		}

		// onPostExecute displays the results of the AsyncTask.
		@Override
		protected void onPostExecute(String result) {

			// ACTION_MESSAGE=WHAT_DID_LOAD_DATA;
			if (this.mCallback == null) {
				Message msg = mUIHandler.obtainMessage(ACTION_MESSAGE);
				msg.obj = result;
				msg.sendToTarget();
			} else {
				doWork(result);
			}
		}
	}

	public class HttpGetAsyncTask extends AsyncTask<String, Void, String> {
		protected ICallback mCallback = null;

		public void setCallback(ICallback callback) {

			this.mCallback = callback;
		}

		private void doWork(Object object) {

			if (this.mCallback != null) {
				this.mCallback.doWork(object);
			}
		}

		protected String doInBackground(String... urls) {

			return GET(urls[0]);
		}

		// onPostExecute displays the results of the AsyncTask.
		// 步驟4:當後台計算結束時，調用UI線程，後台計算結果作為一個参數傳遞到這步
		@Override
		protected void onPostExecute(String result) {

			// ACTION_MESSAGE=WHAT_DID_LOAD_DATA;
			if (this.mCallback == null) {
				Message msg = mUIHandler.obtainMessage(ACTION_MESSAGE);
				msg.obj = result;
				msg.sendToTarget();
			} else {
				doWork(result);
			}
		}
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

			this.mCallback = callback;

		}

		private void doWork(Object object) {

			if (this.mCallback != null) {
				this.mCallback.doWork(object);
			}
		}

		protected String doInBackground(String... urls) {

			return POST(urls[0], urls[1]);
		}

		// onPostExecute displays the results of the AsyncTask.
		@Override
		protected void onPostExecute(String result) {

			// ACTION_MESSAGE=WHAT_DID_LOAD_DATA;
			if (mCallback == null) {
				//if(isLoading==1)isLoading = 0;
				Message msg = mUIHandler.obtainMessage(ACTION_MESSAGE);
				msg.obj = result;
				msg.sendToTarget();
			} else {
				doWork(result);
			}

		}

	}

	private Handler mUIHandler = new Handler() {

		@Override
		public void handleMessage(Message msg) {

			switch (msg.what) {
			case WHAT_DID_LOAD_DATA: {
				if (msg.obj != null) {
					loadData(msg.obj);
				}
			}
				break;
			case WHAT_DID_REFRESH: {
				if (msg.obj != null) {
					loadRefreshData(msg.obj);
				}
			}
				break;
			case WHAT_DID_MORE: {
				if (msg.obj != null) {
					loadMoreData(msg.obj);
				}
			}
				break;
			case WHAT_USER_CALLBACK: {
				if (msg.obj != null) {
					// if(isLoading==1){
					isLoading = 0;
					// }
					_onDataReceiveListener.onReceive(msg.obj);
				}
			}
				break;
			}
		}

	};

	public void loadData(Object data) {

	}

	public void loadMoreData(Object data) {

	}

	public void loadRefreshData(Object data) {

	}

	public void postRequest(String url, JSONObject jsonObject) {

		// TODO Auto-generated method stub
		isLoading = 1;
		launchRingDialog(null);
		ACTION_MESSAGE = WHAT_DID_LOAD_DATA;
		new HttpPostAsyncTask().execute(url, jsonObject.toString());// 調用該方法，觸發非同步任務的執行
	}

	public void postRequest(String url, JSONObject jsonObject, int Message) {

		// TODO Auto-generated method stub
		// isLoading=1;
		// launchRingDialog(null);
		ACTION_MESSAGE = Message;
		new HttpPostAsyncTask().execute(url, jsonObject.toString());
	}

	public void postRequest(String url, JSONObject jsonObject,
			IDataReceiveListener DataReceiveListener) {

		ACTION_MESSAGE = WHAT_USER_CALLBACK;
		if (_onDataReceiveListener == null) {
			_onDataReceiveListener = new onDataReceiveListener();
		}
		_onDataReceiveListener.setListener(DataReceiveListener);
		new HttpPostAsyncTask().execute(url, jsonObject.toString());
	}

	public void postRequest(String url, JSONObject jsonObject,
			IDataReceiveListener DataReceiveListener, boolean showLoading) {

		ACTION_MESSAGE = WHAT_USER_CALLBACK;
		if (showLoading == true) {
			isLoading = 1;
			launchRingDialog(null);
		}
		else
		{
			isLoading =0;
		}
		if (_onDataReceiveListener == null) {
			_onDataReceiveListener = new onDataReceiveListener();
		}
		_onDataReceiveListener.setListener(DataReceiveListener);
		new HttpPostAsyncTask().execute(url, jsonObject.toString());
	}

	public void getRequest(String url, IDataReceiveListener DataReceiveListener) {

		ACTION_MESSAGE = WHAT_USER_CALLBACK;
		if (_onDataReceiveListener == null) {
			_onDataReceiveListener = new onDataReceiveListener();
		}
		_onDataReceiveListener.setListener(DataReceiveListener);
		new HttpGetAsyncTask().execute(url);
	}

	public void getRequest(String url,
			IDataReceiveListener DataReceiveListener, boolean showLoading) {
		if (showLoading == true) {
			isLoading = 1;
			launchRingDialog(null);
		}
		ACTION_MESSAGE = WHAT_USER_CALLBACK;
		if (_onDataReceiveListener == null) {
			_onDataReceiveListener = new onDataReceiveListener();
		}
		_onDataReceiveListener.setListener(DataReceiveListener);
		new HttpGetAsyncTask().execute(url);
	}

	public void getRequest(String url) {
		ACTION_MESSAGE = WHAT_DID_LOAD_DATA;
		new HttpGetAsyncTask().execute(url);
	}
	public void showDialog(String msg,
						   DialogInterface.OnClickListener onOkListener,
						   DialogInterface.OnClickListener onCancelListener) {
		AlertDialog.Builder builder = new AlertDialog.Builder(
				this.getActivity());
		builder.setMessage(msg).setCancelable(false);
		if(onOkListener!=null){
			builder.setPositiveButton("確定", onOkListener);
		}
		if(onCancelListener!=null){
			builder.setNegativeButton("取消", onCancelListener);
		}
		builder.show();

	}
	public void showDialog(String msg) {
		AlertDialog.Builder builder = new AlertDialog.Builder(
				this.getActivity());
		builder.setMessage(msg).setCancelable(false)
				.setPositiveButton("確定", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int id) {
					}
				}).show();

	}

	public void showDialog(String title, String msg) {
		AlertDialog.Builder builder = new AlertDialog.Builder(
				this.getActivity());
		builder.setMessage(msg).setTitle(title).setCancelable(false)
				.setPositiveButton("確定", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int id) {
					}
				}).show();

	}

	public ProgressDialog progressDialog=null;

	public void showProgressDialog(final int max) {
		this.getActivity().runOnUiThread(new Runnable(){
			@Override
			public void run() {
				progressDialog = new ProgressDialog(getActivity());
				progressDialog
						.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
				// progressDialog.setIcon(R.drawable.alert_dialog_icon);
				progressDialog.setMessage("Uploading...");
				progressDialog.setMax(max);
				progressDialog.setCancelable(false);
				progressDialog.show();
			}
		});

	}

	public void hideProgressDialog() {
		// ProgressDialog
		if (progressDialog != null) {
			progressDialog.dismiss();
		}
		
	}
	public  void showConfirmDeleteDialog(final String msg,DialogInterface.OnClickListener onOkClickListener,DialogInterface.OnClickListener onCancelClickListener)
	{
	
		AlertDialog.Builder builder = new AlertDialog.Builder(
				this.getActivity());
		builder.setMessage(msg).setCancelable(false)
				.setPositiveButton("確定", onOkClickListener).
				setNegativeButton("取消",onCancelClickListener).show();
			
		
	}
	public void updateProgressDialog(final int progress) {
		// ProgressDialog
		this.getActivity().runOnUiThread(new Runnable(){
			@Override
			public void run() {
					if (progressDialog != null) {
							progressDialog.setProgress(progress);
						}
			}});
	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// retain this fragment when activity is re-initialized
		setRetainInstance(true);
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
}
