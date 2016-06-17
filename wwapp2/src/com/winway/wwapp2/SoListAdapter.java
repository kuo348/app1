package com.winway.wwapp2;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class SoListAdapter extends BaseAdapter {
	
	private Context context;
	private ArrayList<SoItem> soItems;
	public SoListAdapter(Context context, ArrayList<SoItem> soItems)
	{		 
		this.context = context;
		this.soItems = soItems;
	}
	@Override
	public int getCount() {		 
		return this.soItems.size();
	}
	@Override
	public Object getItem(int position) {	
		return soItems.get(position);
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
            convertView = mInflater.inflate(R.layout.solist_item, null);
        }	
        TextView txtSoNo = (TextView) convertView.findViewById(R.id.sono);
        TextView txtCustomer = (TextView) convertView.findViewById(R.id.customer);
        TextView txtQty= (TextView) convertView.findViewById(R.id.qty);
        TextView txtProduct = (TextView) convertView.findViewById(R.id.product);
        txtSoNo.setText(soItems.get(position).getSoNo());
        txtCustomer.setText(soItems.get(position).getCustomerName());
        txtQty.setText(soItems.get(position).getQty());
        txtProduct.setText(soItems.get(position).getProductType());
        return convertView;
	}

}
