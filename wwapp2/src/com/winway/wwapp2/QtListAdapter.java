package com.winway.wwapp2;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * qt列表調適器
 * @author 
 *
 */
public class QtListAdapter extends BaseAdapter {

	private Context context;
	private ArrayList<QtItem> qtItems;
	private int selectItem=-1;

	public QtListAdapter(Context context, ArrayList<QtItem> qtItems){
		this.context = context;
		this.qtItems = qtItems;
	}

	@Override
	public int getCount() {
		
		//System.out.println("==>"+new Throwable().getStackTrace()[0].getClassName()+" > "+new Throwable().getStackTrace()[0].getMethodName());
		//System.out.println("===>Line number: "+new Throwable().getStackTrace()[0].getLineNumber()); 
   		
		return qtItems.size();
	}

	@Override
	public Object getItem(int position) {
		
		//System.out.println("==>"+new Throwable().getStackTrace()[0].getClassName()+" > "+new Throwable().getStackTrace()[0].getMethodName());
		//System.out.println("===>Line number: "+new Throwable().getStackTrace()[0].getLineNumber()); 
   		
		return qtItems.get(position);
	}

	@Override
	public long getItemId(int position) {
		
		//System.out.println("==>"+new Throwable().getStackTrace()[0].getClassName()+" > "+new Throwable().getStackTrace()[0].getMethodName());
		//System.out.println("===>Line number: "+new Throwable().getStackTrace()[0].getLineNumber()); 
   		
		return position;
	}

	//20160111 : 控制點選的 Item 用不同顏色顯示
	public void setSelectItem(int selectItem)
	{
		this.selectItem=selectItem;

	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		//System.out.println("==>"+new Throwable().getStackTrace()[0].getClassName()+" > "+new Throwable().getStackTrace()[0].getMethodName());
		//System.out.println("===>Line number: "+new Throwable().getStackTrace()[0].getLineNumber()); 
   		
		
		if (convertView == null) {
            LayoutInflater mInflater = (LayoutInflater)
                    context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.qtlist_item, null);
        }
		//LinearLayout ln = (LinearLayout) convertView.findViewById(R.id.msg_ll);
        ImageView imgIcon = (ImageView) convertView.findViewById(R.id.qt_icon);
        TextView txtQtNo = (TextView) convertView.findViewById(R.id.qtno);
        TextView txtCustomer = (TextView) convertView.findViewById(R.id.customer);
        ImageView statusIcon = (ImageView) convertView.findViewById(R.id.qt_status_icon);
        imgIcon.setImageResource(qtItems.get(position).getIcon());
		//20151112 status 不使用
        //if(qtItems.get(position).getStatus().equals("1")==true){
        //	statusIcon.setImageResource(R.drawable.apqp_status_quotation_1);
        //}
        //else if(qtItems.get(position).getStatus().equals("2")==true){
        //	statusIcon.setImageResource(R.drawable.apqp_status_order2);
        //}
        //else {
        //	statusIcon.setImageResource(0);
        //}
        
        //ln.setBackgroundResource(msgItems.get(position).getIcon());
        txtQtNo    .setText(qtItems.get(position).getQtNo());
        txtCustomer.setText(qtItems.get(position).getCusomter());

        //20160111 : 控制變顏色
        if(position==selectItem){
            //convertView.setBackgroundResource(R.drawable.customer_listitem);
            convertView.setBackgroundColor(Color.LTGRAY);
        }
        else{
            convertView.setBackgroundResource(Color.TRANSPARENT);

        }

        return convertView;
	}

}
