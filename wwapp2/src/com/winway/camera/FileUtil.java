package com.winway.camera;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Environment;
import android.provider.ContactsContract.Directory;
import android.util.Log;

public class FileUtil {
	private static final String TAG = "FileUtil";
	private static final File parentPath = Environment.getExternalStorageDirectory();
	private static String storagePath = "";
	private static final String DST_FOLDER_NAME = "wwapp2";
	private static String custDir = "";
	public static void setCustomFolder(String dir) {
		custDir = dir;
	}

	public static String getMidaPath() {
	   return parentPath.getAbsolutePath() + "/" + DST_FOLDER_NAME;		
	}
	//讀取SDCard圖片，型態為Bitmap
	  public static Bitmap getBitmapFromSDCard(String file)
	   {
	      try 
	      {
	        // String sd = Environment.getExternalStorageDirectory().toString();
	    	 BitmapFactory.Options opts = new BitmapFactory.Options();
			 opts.inSampleSize = 2; //以 2 的平方為佳
			 Bitmap bitmap = BitmapFactory.decodeFile(file, opts);   
	        // Bitmap bitmap = BitmapFactory.decodeFile(file);
	         return bitmap;
	      } 
	      catch (Exception e) 
	      { 
	         e.printStackTrace(); 
	         return null; 
	      } 
	   }
	public static List<String> getAlbumList(String filePath) {
		List<String> list = new ArrayList<String>();
		File file = new File(filePath);
		if (file.isDirectory()) {
			if (!filePath.matches(".*\\\\$"))
				filePath += "/";			
			for (String fileName : file.list()) {
				File file2 = new File(filePath+fileName);
				if (file2.isDirectory()) {
				  list.add(fileName);
				}
			}		

		} 
		return list;
	}
	public static List<String> getAlbumImageList(String filePath) {
		List<String> list = new ArrayList<String>();
		File file = new File(filePath);
		if (file.isDirectory()) {
			if (!filePath.matches(".*\\\\$"))
				filePath += "/";			
			for (String fileName : file.list()) {
				File file2 = new File(filePath+fileName);
				if (!file2.isDirectory()) {
				  list.add(fileName);
				}
			}		

		} 
		return list;
	}
    public static void removeAblum(String so)
    {
    	String path=getMidaPath()+"/"+so;
  		File file = new File(path);
		if (file.isDirectory()) {
			if (!path.matches(".*\\\\$"))
				path += "/";			
			for (String fileName : file.list()) {
				File file2 = new File(path+fileName);
				if (!file2.isDirectory()) {
				   file2.delete();
				}
			}
			file.delete();
		} 
    	
    }
   
	/**
	 * 初始化保存路徑
	 * 
	 * @return
	 */
	private static String initPath() {
		if (storagePath.equals("")) {
			storagePath = parentPath.getAbsolutePath() + "/" + DST_FOLDER_NAME;
			File f = new File(storagePath);
			if (!f.exists()) {
				f.mkdir();
			}			
		}
		if (!custDir.equals("")) {
			storagePath = parentPath.getAbsolutePath() + "/"
					+ DST_FOLDER_NAME + "/" + custDir;
			File f1 = new File(storagePath);
			if (!f1.exists()) {
				f1.mkdir();
			}
		}
		return storagePath;
	}

	/**
	 * 保存Bitmap到sdcard
	 * 
	 * @param b
	 */
	public static void saveBitmap(Bitmap b) {

		String path = initPath();
		long dataTake = System.currentTimeMillis();
		String jpegName = path + "/" + dataTake + ".jpg";
		Log.i(TAG, "saveBitmap:jpegName = " + jpegName);
		try {
			FileOutputStream fout = new FileOutputStream(jpegName);
			BufferedOutputStream bos = new BufferedOutputStream(fout);
			b.compress(Bitmap.CompressFormat.JPEG, 100, bos);
			bos.flush();
			bos.close();
			Log.i(TAG, "saveBitmap成功");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			Log.i(TAG, "saveBitmap:失敗");
			e.printStackTrace();
		}
	}	
}