package com.winway.wwapp2;
import java.util.ArrayList;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.text.ClipboardManager;
public class TreeViewAdapter extends BaseAdapter {
	/** 元素数据源 */
	private ArrayList<TreeElement> elementsData;
	/** 树中元素 */
	private ArrayList<TreeElement> elements;
	/** item的行首缩进基数 */
	private int indentionBase;
	private Context context;
	private int selectedPosition = -1;// 选中的位置

	public TreeViewAdapter(Context context, ArrayList<TreeElement> elements,
			ArrayList<TreeElement> elementsData) {
		this.elements = elements;
		this.elementsData = elementsData;
		this.context = context;
		indentionBase = 30;
	}

	public ArrayList<TreeElement> getElements() {
		return elements;
	}

	public ArrayList<TreeElement> getElementsData() {
		return elementsData;
	}

	@Override
	public int getCount() {
		return elements.size();
	}

	@Override
	public Object getItem(int position) {
		return elements.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	public void setSelectedPosition(int selectedPosition) {
		this.selectedPosition = selectedPosition;
	}
    private void ImageClick(View v,int position){
    	TreeElement element = elements.get(position);
    	//open
        if(element.isExpanded())
        {
        
				element.setExpanded(false);
				// 删除節點内部對應子節點數據，包括子節點的子節點...
				ArrayList<TreeElement> elementsToDel = new ArrayList<TreeElement>();
				for (int i = position + 1; i < elements.size(); i++) {
					if (element.getLevel() >= elements.get(i).getLevel())
						break;
					elementsToDel.add(elements.get(i));
				}
				elements.removeAll(elementsToDel);
        	
        }
        else {
        //close	
        	element.setExpanded(true);
			// 從資料中提取子節點數據添加進樹，注意这里只是添加了下一级子節點，為了簡化邏輯
			int i = 1;// 注意这里的計數器放在for外面才能保證計數有效
			for (TreeElement e : elementsData) {
				if ((element.getId()).equals(e.getParendId())) {
					e.setExpanded(false);
					elements.add(position + i, e);
					i++;
				}
			}
        	
        }
        this.notifyDataSetChanged();
    	
    }
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		final int pos=position;
		ViewHolder holder = null;
		if (convertView == null) {
			holder = new ViewHolder();
			convertView = View.inflate(context, R.layout.list_item_tree, null);
			holder.imageView = (ImageView) convertView
					.findViewById(R.id.display_imageview);
			holder.partno_cell= (TextView) convertView
					.findViewById(R.id.partno_cell);
			holder.partname_cell= (TextView) convertView
					.findViewById(R.id.partname_cell);
			holder.unit_cell= (TextView) convertView
					.findViewById(R.id.unit_cell);
			holder.qty_cell= (TextView) convertView
					.findViewById(R.id.qty_cell);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		TreeElement element = elements.get(position);
		int level = element.getLevel();
		holder.imageView.setPadding(indentionBase * level,
				holder.imageView.getPaddingTop(),
				holder.imageView.getPaddingRight(),
				holder.imageView.getPaddingBottom());
		String []items=element.getContentText().split(";");
		holder.partno_cell.setText(items[0].toString());
		holder.partname_cell.setText(items[1].toString());
		holder.unit_cell.setText(items[2].toString());
		holder.qty_cell.setText(items[3].toString());
		if (element.isHasChildren() && !element.isExpanded()) {
			holder.imageView.setImageResource(R.drawable.icon_close);
			holder.imageView.setVisibility(View.VISIBLE);
		} else if (element.isHasChildren() && element.isExpanded()) {
			holder.imageView.setImageResource(R.drawable.icon_open);
			holder.imageView.setVisibility(View.VISIBLE);
		} else if (!element.isHasChildren()) {
			holder.imageView.setImageResource(R.drawable.icon_close);
			holder.imageView.setVisibility(View.INVISIBLE);
		}
		holder.imageView.setOnClickListener(new OnClickListener() {
		    @Override
		    public void onClick(View v) {
		    	ImageClick(v,pos);
		    }
		});
		if (position == selectedPosition) {
			holder.partno_cell.setTextColor(Color.parseColor("#FF3F9FE0"));
			holder.partno_cell.setOnClickListener(new View.OnClickListener() {
			    @Override
			    public void onClick(View view) {
			        ClipboardManager cm = (ClipboardManager)context.getSystemService(Context.CLIPBOARD_SERVICE);
			        TextView txt=(TextView)view;
			        cm.setText(txt.getText());
			        Toast.makeText(context, "Copied to clipboard", Toast.LENGTH_SHORT).show();
			    }
			});
			holder.partname_cell.setTextColor(Color.parseColor("#FF3F9FE0"));
			holder.unit_cell.setTextColor(Color.parseColor("#FF3F9FE0"));
			holder.qty_cell.setTextColor(Color.parseColor("#FF3F9FE0"));
		} else {
			holder.partno_cell.setTextColor(Color.parseColor("#FF000000"));
			holder.partno_cell.setOnClickListener(new View.OnClickListener() {
			    @Override
			    public void onClick(View view) {
			        ClipboardManager cm = (ClipboardManager)context.getSystemService(Context.CLIPBOARD_SERVICE);
			        TextView txt=(TextView)view;
			        cm.setText(txt.getText());
			        Toast.makeText(context, "Copied to clipboard", Toast.LENGTH_SHORT).show();
			    }
			});
			holder.partname_cell.setTextColor(Color.parseColor("#FF000000"));
			holder.unit_cell.setTextColor(Color.parseColor("#FF000000"));
			holder.qty_cell.setTextColor(Color.parseColor("#FF000000"));
		}
		return convertView;
	}

	static class ViewHolder {
		ImageView imageView;
		TextView partno_cell;
		TextView partname_cell;
		TextView unit_cell;
		TextView qty_cell;
	}
}
