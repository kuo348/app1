package com.winway.wwapp2;
import java.util.ArrayList;

import com.winway.wwapp2.MsgItem;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
/**
 * apqp列表調適器
 * @author 
 *
 */
public class ApqpListAdapter extends BaseAdapter {
	
	private Context context;
	private ArrayList<ApqpItem> apqpItems;
	private int selectItem=-1;
	public ApqpListAdapter(Context context, ArrayList<ApqpItem> apqpItems){
		this.context = context;
		this.apqpItems = apqpItems;
	}

	@Override
	public int getCount() {
		
		//System.out.println("==>"+new Throwable().getStackTrace()[0].getClassName()+" > "+new Throwable().getStackTrace()[0].getMethodName());
		//System.out.println("===>Line number: "+new Throwable().getStackTrace()[0].getLineNumber()); 
   		
		return apqpItems.size();
	}

	@Override
	public Object getItem(int position) {
		
		//System.out.println("==>"+new Throwable().getStackTrace()[0].getClassName()+" > "+new Throwable().getStackTrace()[0].getMethodName());
		//System.out.println("===>Line number: "+new Throwable().getStackTrace()[0].getLineNumber()); 
   		
		return apqpItems.get(position);
	}

	@Override
	public long getItemId(int position) {
		
		//System.out.println("==>"+new Throwable().getStackTrace()[0].getClassName()+" > "+new Throwable().getStackTrace()[0].getMethodName());
		//System.out.println("===>Line number: "+new Throwable().getStackTrace()[0].getLineNumber()); 
   		
		return position;
	}
	public void setSelectItem(int selectItem)
	{
		this.selectItem=selectItem;
		
	}
	public static int getImageId(Context context, String imageName) {
	    return context.getResources().getIdentifier("drawable/" + imageName, null, context.getPackageName());
	}
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		//System.out.println("==>"+new Throwable().getStackTrace()[0].getClassName()+" > "+new Throwable().getStackTrace()[0].getMethodName());
		//System.out.println("===>Line number: "+new Throwable().getStackTrace()[0].getLineNumber()); 
   		
		
		if (convertView == null) {
            LayoutInflater mInflater = (LayoutInflater)
                    context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.apqplist_item, null);
        }
		//LinearLayout ln = (LinearLayout) convertView.findViewById(R.id.msg_ll);
        ImageView imgIcon = (ImageView) convertView.findViewById(R.id.apqp_icon);	
        TextView txtApqpNo = (TextView) convertView.findViewById(R.id.apqpno);
        TextView txtCustomer = (TextView) convertView.findViewById(R.id.customer);
        ImageView statusIcon = (ImageView) convertView.findViewById(R.id.apqp_status_icon);	
        ImageView typeIcon = (ImageView) convertView.findViewById(R.id.apqp_type_icon);	
        imgIcon.setImageResource(apqpItems.get(position).getIcon()); 
        if(apqpItems.get(position).getStatus().equals("1")==true){
        	statusIcon.setImageResource(R.drawable.apqp_status_quotation_1); 
        }
        else if(apqpItems.get(position).getStatus().equals("2")==true){
        	statusIcon.setImageResource(R.drawable.apqp_status_order2); 
        }
        else {
        	statusIcon.setImageResource(0); 
        }
        if(apqpItems.get(position).getType().equals("")==false)
        {
        	typeIcon.setImageResource(getImageId(context,apqpItems.get(position).getType())); 
        }
        //ln.setBackgroundResource(msgItems.get(position).getIcon());
        txtApqpNo.setText(apqpItems.get(position).getApqpNo());
        txtCustomer.setText(apqpItems.get(position).getCusomter());
        if(position==selectItem){
       	 //convertView.setBackgroundResource(R.drawable.customer_listitem);
       	 convertView.setBackgroundColor(Color.LTGRAY);
        }
        else{
       	 //convertView.setBackgroundResource(Color.TRANSPARENT);
			convertView.setBackgroundColor(Color.TRANSPARENT);
        }
        return convertView;
	}

}
