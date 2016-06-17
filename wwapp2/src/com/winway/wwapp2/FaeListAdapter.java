package com.winway.wwapp2;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

public class FaeListAdapter extends BaseAdapter
{
  private ArrayList<FaeItem> FaeItems;
  private Context context;

  public FaeListAdapter(Context context, ArrayList<FaeItem> faeItems)
  {
    this.context =context;
    this.FaeItems = faeItems;
  }

  public int getCount()
  {
    return FaeItems.size();
  }

  public Object getItem(int position)
  {
    return FaeItems.get(position);
  }

  public long getItemId(int position)
  {
    return position;
  }

  public View getView(int position, View convertView, ViewGroup parent) {
		if (convertView == null) {
          LayoutInflater mInflater = (LayoutInflater)
                  context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
          convertView = mInflater.inflate(R.layout.faelist_item, null);
      }
    TextView vwFae001= (TextView)convertView.findViewById(R.id.fae001);
    TextView vwFae006= (TextView)convertView.findViewById(R.id.fae006);
    TextView vwFae012= (TextView)convertView.findViewById(R.id.fae012);
    TextView vwFae022 = (TextView)convertView.findViewById(R.id.fae022);
    ImageView iconView = (ImageView)convertView.findViewById(R.id.fae_icon);
    vwFae001.setText(FaeItems.get(position).getFAE001());
    vwFae006.setText(FaeItems.get(position).getFAE006());
    vwFae022.setText(FaeItems.get(position).getFAE022());
    vwFae012.setText(FaeItems.get(position).getFAE012());
    int resId=FaeItems.get(position).getIcon();
    iconView.setImageResource(resId);
    //iconView.setImageResource(R.drawable.fae_complete);
    return convertView;
  }
}