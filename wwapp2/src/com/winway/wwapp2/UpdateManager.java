/* 檢查並自動更新該app的最新版本
<init>
checkUpdate 檢查
isUpdate 
getVersionCode 獲取版本code
 * */
package com.winway.wwapp2;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class UpdateManager {
	/* 下載中 */
	private static final int DOWNLOAD = 1;
	/* 下載結束 */
	private static final int DOWNLOAD_FINISH = 2;
	/* 保存解析的XML信息 */
	HashMap<String, String> mHashMap;
	/* 下載保存路徑 */
	private String mSavePath;
	/* 記錄進度條數量 */
	private int progress;
	/* 是否取消更新 */
	private boolean cancelUpdate = false;

	private Context mContext;
	/* 更新進度條 */
	private ProgressBar mProgress;
	private TextView mProgressTitle;
	private Dialog mDownloadDialog;
	private int versionCode;
	private int serviceCode;
	private String mPath ;
	// 提示語(有新的版本可下載)
	private String updateMsg = "There is a new version available!!!!";
	private Handler mHandler = new Handler() {
		public void handleMessage(Message msg) {

			switch (msg.what) {
			// 正在下載
			case DOWNLOAD:
				// 設置進度條位置
				mProgress.setProgress(progress);
				mProgressTitle.setText(String.format("%d", progress + 1) + "%");
				break;
			case DOWNLOAD_FINISH:
				// 安裝文件
				installApk();
				break;
			default:
				break;
			}
		};
	};

	public UpdateManager(Context context) {

		this.mContext = context;
	}

	/**
	 * 檢測軟件更新
	 */
	public void checkUpdate() {

		if (isUpdate()) {
			// 顯示提示對話框
			showNoticeDialog();
		}
		/*
		 * else { Toast.makeText(mContext, R.string.soft_update_no,
		 * Toast.LENGTH_LONG).show(); }
		 */
	}

	/**
	 * 檢查軟件是否有更新版本
	 * 
	 * @return
	 */
	private boolean isUpdate() {

		// 獲取當前軟件版本
	    versionCode = getVersionCode(mContext);
		// 把version.xml放到網络上，然後獲取文件信息
		// InputStream inStream =
		// ParseXmlService.class.getClassLoader().getResourceAsStream("version.xml");
		// 解析XML文件。 由於XML文件比較小，因此使用DOM方式進行解析
		ParseXmlService service = new ParseXmlService();
		try {

			if(mContext.getString(R.string.area_code).equals("cn")){
				mPath = "https://app.winwayglobal.com/android_cn";
			}
			else {
				mPath = "https://app.winwayglobal.com/android";
			}
			URL url = new URL(mPath+"/version.xml");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setReadTimeout(5 * 1000);
			conn.setRequestMethod("GET");
			if (conn.getContentLength() == 0) {
				return false;
			}
			InputStream inStream = conn.getInputStream();

			mHashMap = service.parseXml(inStream);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (null != mHashMap) {
			 serviceCode = Integer.valueOf(mHashMap.get("version"));
			// 版本判斷
			if (serviceCode > versionCode) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 獲取軟件版本號
	 * 
	 * @param context
	 * @return
	 */
	private int getVersionCode(Context context) {

		int versionCode = 0;
		try {
			// 獲取軟件版本號，對應AndroidManifest.xml下android:versionCode
			versionCode = context.getPackageManager().getPackageInfo(
					"com.winway.wwapp2", 0).versionCode;
		} catch (NameNotFoundException e) {
			e.printStackTrace();
		}
		return versionCode;
	}

	/**
	 * 顯示軟件更新對話框
	 */
	public void showNoticeDialog() {

		// 構造對話框
		AlertDialog.Builder builder = new Builder(mContext);
		builder.setTitle("APP update");
		updateMsg=String.format("current version is %d\nplease update to %d", versionCode,serviceCode).toString();
		builder.setMessage(updateMsg);
		// 更新
		builder.setPositiveButton("Update", new OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				dialog.dismiss();
				// 顯示下載對話框
				showDownloadDialog();
			}
		});
		// 稍後更新
		builder.setNegativeButton("Later", new OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				dialog.dismiss();
			}
		});
		Dialog noticeDialog = builder.create();
		noticeDialog.show();
	}

	/**
	 * 顯示軟件下載對話框
	 */
	private void showDownloadDialog() {

		// 構造軟件下載對話框
		AlertDialog.Builder builder = new Builder(mContext);
		builder.setTitle("APP download");
		// 给下載對話框增加進度條
		final LayoutInflater inflater = LayoutInflater.from(mContext);
		View v = inflater.inflate(R.layout.progress, null);
		mProgress = (ProgressBar) v.findViewById(R.id.progress);// 動態進度條
		mProgressTitle = (TextView) v.findViewById(R.id.progress_title);
		builder.setView(v);
		// 取消更新
		builder.setNegativeButton("Cancel", new OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				dialog.dismiss();
				// 設置取消狀態
				cancelUpdate = true;
			}
		});
		mDownloadDialog = builder.create();
		mDownloadDialog.show();
		// 現在文件
		downloadApk();
	}

	/**
	 * 下載apk文件
	 */
	private void downloadApk() {

		// 启動新線程下載軟件
		new downloadApkThread().start();
	}

	/**
	 * 下載文件線程
	 */
	private class downloadApkThread extends Thread {

		@Override
		public void run() {

			try {
				// 判斷SD卡是否存在，並且是否具有讀寫權限
				if (!Environment.getExternalStorageState().equals(
						Environment.MEDIA_REMOVED)) {
					// 獲得存儲卡的路徑
					String sdpath = Environment.getExternalStorageDirectory()
							.toString() + "/";
					mSavePath = sdpath + "download";
					URL url = new URL(mHashMap.get("url"));
					// 創建連接
					HttpURLConnection conn = (HttpURLConnection) url
							.openConnection();
					conn.connect();
					// 獲取文件大小
					int length = conn.getContentLength();
					// 創建輸入流
					InputStream is = conn.getInputStream();

					File file = new File(mSavePath);
					// 判斷文件目錄是否存在
					if (!file.exists()) {
						file.mkdir();
					}
					File apkFile = new File(mSavePath, mHashMap.get("name"));
					FileOutputStream fos = new FileOutputStream(apkFile);
					int count = 0;
					// 緩存
					byte buf[] = new byte[1024];
					// 寫入到文件中
					do {
						int numread = is.read(buf);
						count += numread;
						// 計算進度條位置
						progress = (int) (((float) count / length) * 100);
						// 更新進度
						mHandler.sendEmptyMessage(DOWNLOAD);
						if (numread <= 0) {
							// 下載完成
							mHandler.sendEmptyMessage(DOWNLOAD_FINISH);
							break;
						}
						// 寫入文件
						fos.write(buf, 0, numread);
					} while (!cancelUpdate);// 點擊取消就停止下載.
					fos.close();
					is.close();
				}
			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			// 取消下載對話框顯示
			mDownloadDialog.dismiss();
		}
	};

	/**
	 * 安裝APK文件
	 */
	private void installApk() {

		File apkfile = new File(mSavePath, mHashMap.get("name"));
		if (!apkfile.exists()) {
			return;
		}
		// 通過Intent安裝APK文件
		Intent i = new Intent(Intent.ACTION_VIEW);
		i.setDataAndType(Uri.parse("file://" + apkfile.toString()),
				"application/vnd.android.package-archive");
		mContext.startActivity(i);
	}
}
