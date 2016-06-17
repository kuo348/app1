package com.winway.wwapp2;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ContactListAdapter2 extends BaseAdapter {
	private Context context;
	private ArrayList<ContactItem2> contactItems;
	public ContactListAdapter2(Context context, ArrayList<ContactItem2> contactItems){
		this.context = context;
		this.contactItems = contactItems;
	}
	@Override
	public int getCount() {	
		return contactItems.size();
	}

	@Override
	public Object getItem(int position) {	
		return contactItems.get(position);
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
            convertView = mInflater.inflate(R.layout.contactlist_item2, null);
        }
        TextView txtName = (TextView) convertView.findViewById(R.id.ta_oce01);
        txtName.setText(contactItems.get(position).getName());
        return convertView;
	}

}
