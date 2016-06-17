package com.winway.wwapp2;

import java.util.ArrayList;
import java.util.List;

import com.winway.camera.FileUtil;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

/* 改寫BaseAdapter自定義一ImageAdapter class */ 
public class ImageAdapter extends BaseAdapter { 
  /*聲明變量*/
  int mGalleryItemBackground;
  private Context mContext;
  /*ImageAdapter的構造器*/
  public ImageAdapter(Context c) {
    mContext = c;
    /*使用在res/values/attrs.xml中的< declare-styleable > 定義  
     * 的Gallery屬性.*/
    TypedArray a = c.obtainStyledAttributes(R.styleable.Gallery);
    /*取得Gallery屬性的Index id*/
    mGalleryItemBackground = a.getResourceId( R.styleable.Gallery_android_galleryItemBackground, 0);
    /*讓對象的styleable屬性能夠反複使用*/ 
    a.recycle();
    }
  /* 重寫的方法getCount,返回圖片數目*/ 
  public int getCount() {
    return ImageItems.size();
    }
  /* 重寫的方法getItemId,返回圖像的數組id */
  public Object getItem(int position) { 
    return position;
    }
  /* 重寫的方法getItemId,返回圖像的數組id */
  public long getItemId(int position) {
    return position;
    }
  /* 重寫的方法getView,返回一View對象*/
  public View getView(int position, View convertView, ViewGroup parent) {
    /*產生ImageView對象*/
    ImageView i = new ImageView(mContext);
    /*設置圖片給imageView對象*/ 
    //i.setImageResource(myImageIds[position]);
    Bitmap bitmap=FileUtil.getBitmapFromSDCard(ImageItems.get(position));
    i.setImageBitmap(bitmap);
    /*重新設置圖片的寬高*/
    i.setScaleType(ImageView.ScaleType.FIT_XY);
    /*重新設置Layout的寬高*/ 
    i.setLayoutParams(new Gallery.LayoutParams(128, 128));
    /*設置Gallery背景圖*/ 
    i.setBackgroundResource(Color.TRANSPARENT);
    /*返回imageView對象*/ 
    return i;
    }
  /*構建一Integer array並取得預加載Drawable的圖片id*/ 
  public List<String> ImageItems=new ArrayList<String>();
}

