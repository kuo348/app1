/**
 * Message列表的Adapter(接合器)
 * 
 * 
 */
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

public class MsgListAdapter extends BaseAdapter {

	private Context context;
	private ArrayList<MsgItem> msgItems;

	// 建構子
	public MsgListAdapter(Context context, ArrayList<MsgItem> msgItems) {

		this.context = context;
		this.msgItems = msgItems;
	}

	// 取得該用戶未讀的Message則數
	@Override
	public int getCount() {

		// System.out.println("==>"+new
		// Throwable().getStackTrace()[0].getClassName()+" > "+new
		// Throwable().getStackTrace()[0].getMethodName());

		return msgItems.size();
	}

	// 取得這position位置上的項目(item)
	@Override
	public Object getItem(int position) {

		// System.out.println("==>"+new
		// Throwable().getStackTrace()[0].getClassName()+" > "+new
		// Throwable().getStackTrace()[0].getMethodName());

		return msgItems.get(position);
	}

	// 取得這position位置上的項目(item)的id
	@Override
	public long getItemId(int position) {

		// System.out.println("==>"+new
		// Throwable().getStackTrace()[0].getClassName()+" > "+new
		// Throwable().getStackTrace()[0].getMethodName());

		return position;
	}

	// 通常會設定與回傳convertView作為顯示在這個position位置的項目(Item)的View
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		// System.out.println("==>"+new
		// Throwable().getStackTrace()[0].getClassName()+" > "+new
		// Throwable().getStackTrace()[0].getMethodName());

		// inflate =>重新排版
		if (convertView == null) {
			LayoutInflater mInflater = (LayoutInflater) context
					.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
			convertView = mInflater.inflate(R.layout.main_list_item, null);// (1)id(2)父布局
		}
		// LinearLayout ln = (LinearLayout)
		// convertView.findViewById(R.id.msg_ll);
		ImageView imgIcon = (ImageView) convertView.findViewById(R.id.msg_img);
		TextView txtTitle = (TextView) convertView.findViewById(R.id.msg_title);
		TextView txtDate = (TextView) convertView.findViewById(R.id.msg_date);
		TextView txtDesc = (TextView) convertView.findViewById(R.id.msg_desc);
		TextView txtMsgKindText = (TextView) convertView
				.findViewById(R.id.msg_kind_text);
		imgIcon.setImageResource(msgItems.get(position).getIcon());
		// ln.setBackgroundResource(msgItems.get(position).getIcon());
		txtTitle.setText(msgItems.get(position).getTitle());
		txtDesc.setText(msgItems.get(position).getDesc());
		txtDate.setText(msgItems.get(position).getDate());
		txtMsgKindText.setText(msgItems.get(position).getMsgKindText());

		return convertView;
	}

}
