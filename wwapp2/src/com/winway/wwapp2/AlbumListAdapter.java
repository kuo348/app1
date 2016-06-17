package com.winway.wwapp2;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.winway.camera.FileUtil;
import com.winway.wwapp2.BaseFragment.ICallback;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.Gallery;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class AlbumListAdapter extends BaseAdapter {
	private Context context;
	private ArrayList<AlbumItem> albumItems;
	public OnClickListener onShutterClickListener;
	public OnClickListener onDeleteClickListener;
	public OnClickListener onUploadClickListener;
	public AlbumListAdapter(Context context, ArrayList<AlbumItem> albumItems) {
		this.context = context;
		this.albumItems = albumItems;
	}

	@Override
	public int getCount() {
		return albumItems.size();
	}

	@Override
	public Object getItem(int position) {
		return albumItems.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if (convertView == null) {
			LayoutInflater mInflater = (LayoutInflater) context
					.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
			convertView = mInflater.inflate(R.layout.album_item, null);// inflate
																		// 方法載入layout的xml
		}
		TextView so = (TextView) convertView.findViewById(R.id.albumname);
		/*final LinearLayout sv = (LinearLayout) convertView
				.findViewById(R.id.sv);*/
		Gallery gallery=(Gallery) convertView.findViewById(R.id.gallery1);
		ImageButton btn_edit = (ImageButton) convertView
				.findViewById(R.id.btn_album_edit);
		final RelativeLayout r1 = (RelativeLayout) convertView
				.findViewById(R.id.album_actionbar);
		final int pos = position;
		// final View v=convertView;
		btn_edit.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				if (r1.getVisibility() == View.VISIBLE) {
					r1.setVisibility(View.GONE);
				} else {
					r1.setVisibility(View.VISIBLE);
				}
			}
		});
		ImageButton btn_cancel=(ImageButton)convertView.findViewById(R.id.item_cancel);
		ImageButton btn_upload=(ImageButton)convertView.findViewById(R.id.item_upload);
		ImageButton btn_shutter=(ImageButton)convertView.findViewById(R.id.item_shutter);
		ImageButton btn_del=(ImageButton)convertView.findViewById(R.id.item_del);
		btn_cancel.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v){
				if (r1.getVisibility() == View.VISIBLE) {
					r1.setVisibility(View.GONE);
				} 				
			}
		});
		if(onUploadClickListener!=null){
			   btn_upload.setTag(pos);
			   btn_upload.setOnClickListener(onUploadClickListener);
			}
		if(onDeleteClickListener!=null){
		   btn_del.setTag(pos);
		   btn_del.setOnClickListener(onDeleteClickListener);
		}
		if(onShutterClickListener!=null){
		   btn_shutter.setTag(pos);
		   btn_shutter.setOnClickListener(onShutterClickListener);
		}
		so.setText(((AlbumItem) albumItems.get(position)).getName());
		List<String> imageList = FileUtil
				.getAlbumImageList(((AlbumItem) albumItems.get(pos))
						.getFolder());
		String path=((AlbumItem) albumItems.get(pos))
				.getFolder();
		ImageAdapter adapter=new ImageAdapter(context);
		for (int i = 0; i < imageList.size(); i++) {
		  adapter.ImageItems.add(path+"/"+imageList.get(i));			
		}		
		 gallery.setAdapter(adapter);
		 if(imageList.size()>4){
			  gallery.setSelection(2);
		 }
		return convertView;
	}

	public void backgroundType(Context c, ImageView image) {
		/*
		 * 使用在res/values/attrs.xml中的< declare-styleable > 定義 的Gallery屬性.
		 */
		TypedArray a = c.obtainStyledAttributes(R.styleable.Gallery);
		/* 取得Gallery屬性的Index id */
		int mGalleryItemBackground = a.getResourceId(
				R.styleable.Gallery_android_galleryItemBackground, 0);
		/* 讓對象的styleable屬性能夠反複使用 */
		a.recycle();
		image.setBackgroundResource(mGalleryItemBackground);
	}
	
}
