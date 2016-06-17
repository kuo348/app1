package com.winway.wwapp2;

import java.util.ArrayList;

import com.winway.wwapp2.MsgItem;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MsgListAdapter2 extends BaseAdapter {

	private Context context;
	private ArrayList<MsgItem> msgItems;

	public MsgListAdapter2(Context context, ArrayList<MsgItem> msgItems) {

		this.context = context;
		this.msgItems = msgItems;
	}

	@Override
	public int getCount() {

		return msgItems.size();
	}

	@Override
	public Object getItem(int position) {

		return msgItems.get(position);
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
			convertView = mInflater.inflate(R.layout.main_list_item2, null);
		}
		// LinearLayout ln = (LinearLayout)
		// convertView.findViewById(R.id.msg_ll);
		ImageView imgIcon = (ImageView) convertView.findViewById(R.id.msg_img2);
		TextView txtTitle = (TextView) convertView
				.findViewById(R.id.msg_title2);
		TextView txtDate = (TextView) convertView.findViewById(R.id.msg_date2);
		TextView txtDesc = (TextView) convertView.findViewById(R.id.msg_desc2);
		TextView txtMsgKindText = (TextView) convertView
				.findViewById(R.id.msg_kind_text2);
		imgIcon.setImageResource(msgItems.get(position).getIcon());
		// ln.setBackgroundResource(msgItems.get(position).getIcon());
		txtTitle.setText(msgItems.get(position).getTitle());
		txtDesc.setText(msgItems.get(position).getDesc());
		txtDate.setText(msgItems.get(position).getDate());
		txtMsgKindText.setText(msgItems.get(position).getMsgKindText());

		return convertView;
	}

}
