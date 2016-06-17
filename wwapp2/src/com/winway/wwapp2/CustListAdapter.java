package com.winway.wwapp2;import java.util.ArrayList;import android.app.Activity;import android.content.Context;import android.view.LayoutInflater;import android.view.View;import android.view.ViewGroup;import android.widget.BaseAdapter;import android.widget.ImageView;import android.widget.LinearLayout;import android.widget.TextView;public class CustListAdapter extends BaseAdapter {	private Context context;	private ArrayList<CustItem> custItems;	public CustListAdapter(Context context, ArrayList<CustItem> custItems){		this.context = context;		this.custItems = custItems;	}	@Override	public int getCount() {				//System.out.println("==>"+new Throwable().getStackTrace()[0].getClassName()+" > "+new Throwable().getStackTrace()[0].getMethodName());		//System.out.println("===>Line number: "+new Throwable().getStackTrace()[0].getLineNumber());    				return custItems.size();	}	@Override	public Object getItem(int position) {					//System.out.println("==>"+new Throwable().getStackTrace()[0].getClassName()+" > "+new Throwable().getStackTrace()[0].getMethodName());		//System.out.println("===>Line number: "+new Throwable().getStackTrace()[0].getLineNumber());    				return custItems.get(position);	}	@Override	public long getItemId(int position) {				//System.out.println("==>"+new Throwable().getStackTrace()[0].getClassName()+" > "+new Throwable().getStackTrace()[0].getMethodName());		//System.out.println("===>Line number: "+new Throwable().getStackTrace()[0].getLineNumber());    				return position;	}	@Override	public View getView(int position, View convertView, ViewGroup parent) {				//System.out.println("==>"+new Throwable().getStackTrace()[0].getClassName()+" > "+new Throwable().getStackTrace()[0].getMethodName());		//System.out.println("===>Line number: "+new Throwable().getStackTrace()[0].getLineNumber());    				if (convertView == null) {            LayoutInflater mInflater = (LayoutInflater)                    context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);            convertView = mInflater.inflate(R.layout.custlist_item, null);        }        TextView txtContact = (TextView) convertView.findViewById(R.id.occ29);        TextView txtId = (TextView) convertView.findViewById(R.id.occ01);        TextView txtName = (TextView) convertView.findViewById(R.id.occ02);        txtContact.setText(custItems.get(position).getContact());        txtId.setText(custItems.get(position).getCustId());        txtName.setText(custItems.get(position).getCustName());               return convertView;	}}