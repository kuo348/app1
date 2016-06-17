package com.winway.wwapp2;
import java.util.ArrayList;
import android.annotation.SuppressLint;
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
public class CustomerListAdapter extends BaseAdapter {
	private Context context;
	private ArrayList<CustomerItem> CustomerItems;
	private int selectItem=-1;
	public CustomerListAdapter(Context context, ArrayList<CustomerItem> CustomerItems){
		this.context = context;
		this.CustomerItems = CustomerItems;
	}
	public void setSelectItem(int selectItem)
	{
		this.selectItem=selectItem;
		
	}
	@Override
	public int getCount() {		
   		
		return CustomerItems.size();
	}

	@Override
	public Object getItem(int position) {			
   		
		return CustomerItems.get(position);
	}

	@Override
	public long getItemId(int position) {
		   		
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {	
   		
		if (convertView == null) {
            LayoutInflater mInflater = (LayoutInflater)	context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.customerlist_item,null);
        }
		TextView lb_customer=(TextView) convertView.findViewById(R.id.lb_customer);
		TextView lb_sales=(TextView) convertView.findViewById(R.id.lb_sales);
		TextView lb_tel=(TextView) convertView.findViewById(R.id.lb_tel);
		ImageView level_icon=(ImageView)convertView.findViewById(R.id.level_icon);
		lb_customer.setText(CustomerItems.get(position).getCustId()+" "+CustomerItems.get(position).getShortName());
		lb_sales.setText(CustomerItems.get(position).getContact());
		lb_tel.setText(CustomerItems.get(position).getTel());
         if(CustomerItems.get(position).getCategory().toString().equals("A"))
         {
        	 level_icon.setImageResource(R.drawable.customer_level_a_6);
        	 
         }else if(CustomerItems.get(position).getCategory().toString().equals("B")){
        	 level_icon.setImageResource(R.drawable.customer_level_b_6);
         }
         else {
        	 level_icon.setImageResource(R.drawable.customer_level_c_6);
         }
         
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