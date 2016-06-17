package com.winway.wwapp2;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class PackageListAdapter extends BaseAdapter {
	
	private Context context;
	private ArrayList<PackageItem> packageItems;
	
	public PackageListAdapter(Context context, ArrayList<PackageItem> packageItems){
		
		//System.out.println("==>"+new Throwable().getStackTrace()[0].getClassName()+" > "+new Throwable().getStackTrace()[0].getMethodName());
		//System.out.println("===>Line number: "+new Throwable().getStackTrace()[0].getLineNumber()); 

		this.context = context;
		this.packageItems = packageItems;
	}

	@Override
	public int getCount() {
		
		
		//System.out.println("==>"+new Throwable().getStackTrace()[0].getClassName()+" > "+new Throwable().getStackTrace()[0].getMethodName());
		//System.out.println("===>Line number: "+new Throwable().getStackTrace()[0].getLineNumber()); 

		return this.packageItems.size();
	}

	@Override
	public Object getItem(int position) {
		
		//System.out.println("==>"+new Throwable().getStackTrace()[0].getClassName()+" > "+new Throwable().getStackTrace()[0].getMethodName());
		//System.out.println("===>Line number: "+new Throwable().getStackTrace()[0].getLineNumber()); 

		return packageItems.get(position);
	}

	@Override
	public long getItemId(int position) {
		
		//System.out.println("==>"+new Throwable().getStackTrace()[0].getClassName()+" > "+new Throwable().getStackTrace()[0].getMethodName());
		//System.out.println("===>Line number: "+new Throwable().getStackTrace()[0].getLineNumber()); 

		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		//System.out.println("==>"+new Throwable().getStackTrace()[0].getClassName()+" > "+new Throwable().getStackTrace()[0].getMethodName());
		//System.out.println("===>Line number: "+new Throwable().getStackTrace()[0].getLineNumber()); 

		if (convertView == null) {
            LayoutInflater mInflater = (LayoutInflater)
                    context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.packagetype_item, null);
        }
		//LinearLayout ln = (LinearLayout) convertView.findViewById(R.id.msg_ll);
     
        TextView txtPackageType = (TextView) convertView.findViewById(R.id.packtype_value);
      
        txtPackageType.setText(packageItems.get(position).getPackage());
       
        return convertView;
	}

}
