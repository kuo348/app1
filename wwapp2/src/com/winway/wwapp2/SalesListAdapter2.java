package com.winway.wwapp2;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class SalesListAdapter2 extends BaseAdapter {

	private Context context;
	private ArrayList<SalesItem2> salesItems;
	public SalesListAdapter2(Context context, ArrayList<SalesItem2> salesItems)
	{		 
		this.context = context;
		this.salesItems = salesItems;
	}
	@Override
	public int getCount() {		 
		return this.salesItems.size();
	}
	@Override
	public Object getItem(int position) {	
		return salesItems.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if (convertView == null) {
            LayoutInflater mInflater = (LayoutInflater)
                    context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.saleslist_item2, null);
        }	
        TextView txtEmpNo = (TextView) convertView.findViewById(R.id.yd001);
        TextView txtEmpName = (TextView) convertView.findViewById(R.id.yd002);
        txtEmpNo.setText(salesItems.get(position).getEmpNo());
        txtEmpName.setText(salesItems.get(position).getEmpName());
        return convertView;
	}

}
