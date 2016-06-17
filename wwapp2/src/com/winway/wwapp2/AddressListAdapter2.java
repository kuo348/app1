package com.winway.wwapp2;
import java.util.ArrayList;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
/**
 * 地址列表相關的調適器
 * @author 
 *
 */
public class AddressListAdapter2 extends BaseAdapter {
	private Context context;
	private ArrayList<AddressItem2> addressItems;
	public AddressListAdapter2(Context context, ArrayList<AddressItem2> addressItems){
		this.context = context;
		this.addressItems = addressItems;
	}
	@Override
	public int getCount() {	
		return addressItems.size();
	}

	@Override
	public Object getItem(int position) {
			return addressItems.get(position);
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
            convertView = mInflater.inflate(R.layout.addresslist_item2, null);//inflate 方法載入layout的xml
        }
        TextView txtAddress = (TextView) convertView.findViewById(R.id.address);
        txtAddress.setText(addressItems.get(position).getAddress());
        return convertView;
	}

}
