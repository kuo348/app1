package com.winway.wwapp2;

import java.util.List;

import com.inqbarna.tablefixheaders.adapters.BaseTableAdapter;
import com.winway.camera.DisplayUtil;
import com.winway.widget.WWTextView;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.TextPaint;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MatrixTableAdapter<T> extends BaseTableAdapter {

	private final static int WIDTH_DIP = 110;
	private final static int HEIGHT_DIP = 32;
	private final LayoutInflater inflater;
	private final Context context;

	private T[][] table;

	private final int width;
	private final int height;
    private int []widths;
    private int []heights;
    private OnClickListener onApqpnoClickListener=null;
    private OnClickListener onPartnoClickListener=null;
    private OnClickListener onCustomerClickListener=null;
    private OnLongClickListener onCellLongClickListener=null;
    public int selectedIndex=-1;
    public void setOnApqpnoClickListener(OnClickListener listener){
    	onApqpnoClickListener=listener;
    	}
    public void setOnPartnoClickListener(OnClickListener listener)
    {
    	onPartnoClickListener=listener;
    }
    public void setOnCustomerClickListener(OnClickListener listener)
    {
    	onCustomerClickListener=listener;
    }
    public void setOnCellLongClickListener(OnLongClickListener listener)
    {
    	onCellLongClickListener=listener;
    }
	public MatrixTableAdapter(Context context) {
		this(context, null);
	}

	public MatrixTableAdapter(Context context, T[][] table) {
		this.context = context;
		inflater = LayoutInflater.from(context);
		Resources r = context.getResources();

		width = Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, WIDTH_DIP, r.getDisplayMetrics()));
		height = Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, HEIGHT_DIP, r.getDisplayMetrics()))+20;
		
        setInformation(table);
	}
	public LayoutInflater getInflater() {
		return inflater;
	}
	public void setInformation(T[][] table) {
		this.table = table;
		//initWidthAndHeights();
	}
    public void initWidthAndHeights()
    {  	
    	//heights=new int[table.length-1];
    	widths=new int[getColumnCount()];
    	Paint paint=new Paint();
    	for(int i=0;i<widths.length;i++){
    		widths[i] = (int)paint.measureText(table[i][1].toString());
    	}
    	
    }
	@Override
	public int getRowCount() {
		return table.length - 1;
	}

	@Override
	public int getColumnCount() {
		return table[0].length - 1;
	}

	@Override
	public View getView(int row, int column, View convertView, ViewGroup parent) {
		if (convertView == null) {
		  convertView = inflater.inflate(getLayoutResource(row, column), parent, false);
		}
				
		WWTextView text1=null;
		text1=(WWTextView) convertView.findViewById(R.id.text1);
		if(text1!=null){	
			text1.setRowIndex(row + 1);
			text1.setColIndex(column + 1);
		    text1.setText(table[row + 1][column + 1].toString());
		    text1.setTag(row + 1);
		    text1.setCompoundDrawables(null, null, null, null);	
		     if(row>0&&column+1>=0&&table[row + 1][column + 1].toString().contains("以上"))
				{
		    	 String value=table[row + 1][column + 1].toString();
		    	  try{
		    	    int w=Integer.parseInt(value.substring(value.length()-2,value.length()));
		    	    value="W"+String.valueOf(w);
		    	  }
		    	  catch(Exception ex){
		    		  value="";		    		  
		    	  }
		    	 if(column + 1==1){		    	  
		    	     text1.setText(value);		    	  
		    	 }
		    	 else if(column + 1==0){
		    		 text1.setText(table[row + 1][column + 1].toString().replace(value,""));	
		    	 }
		    	 else
		    	  text1.setText("");		    	  
		    	  text1.setOnClickListener(null);
		    	  text1.setOnLongClickListener(null);
		    	  text1.setCompoundDrawables(null, null, null, null);
		    	  return convertView;
				}
		     if(text1.getText().equals("")==false&&row+1>=0&&table[0][column + 1].toString().startsWith("APQP")){
		    	 //LinearLayout.LayoutParams params=(LinearLayout.LayoutParams)convertView.getLayoutParams();
		    	 //params.gravity=Gravity.CENTER;
		    	 //convertView.setLayoutParams(params);
		    	 text1.setOnClickListener(onApqpnoClickListener);		    	 
		    	 text1.setOnLongClickListener(null);

		     }
		     else if(text1.getText().equals("")==false&&row+1>0&&table[0][column + 1].toString().startsWith("Status")){
		    	 String tag=text1.getText().toString();
		    	 text1.setOnClickListener(null);		    	 
		    	 text1.setOnLongClickListener(null);
		    	 text1.setText("");
		    	
		    	 if(tag.equals("22")){
		    		 final Drawable drawable = this.context.getResources().getDrawable(R.drawable.icon_tag_22);
			    	 drawable.setBounds(0, 0, 48, 48);
			    	 text1.setCompoundDrawables(drawable, null, null, null);	    		 
		    	 }
		    	 else if(tag.equals("24")){
		    		 final Drawable drawable = this.context.getResources().getDrawable(R.drawable.icon_tag_24);
			    	 drawable.setBounds(0, 0, 48, 48);
			    	 text1.setCompoundDrawables(drawable, null, null, null);		    		 
		    	 }
		    	 else if(tag.equals("25")){
		    		 final Drawable drawable = this.context.getResources().getDrawable(R.drawable.icon_tag_25);
			    	 drawable.setBounds(0, 0, 48, 48);
			    	 text1.setCompoundDrawables(drawable, null, null, null);			    		 
		    	 }
		    	 else if(tag.equals("26")){
		    		final Drawable drawable = this.context.getResources().getDrawable(R.drawable.icon_tag_26);
			    	 drawable.setBounds(0, 0, 48, 48);
			    	 text1.setCompoundDrawables(drawable, null, null, null);			    		 
		    	 }
		    	 else if(tag.equals("27")){
		    		 final Drawable drawable = this.context.getResources().getDrawable(R.drawable.icon_tag_27);
			    	 drawable.setBounds(0, 0, 48, 48);
			    	 text1.setCompoundDrawables(drawable, null, null, null);			    		 
		    	 }
		    	 else if(tag.equals("43")){
		    		 final Drawable drawable = this.context.getResources().getDrawable(R.drawable.icon_tag_43);
			    	 drawable.setBounds(0, 0, 48, 48);
			    	 text1.setCompoundDrawables(drawable, null, null, null);			    		 
		    	 }
		     }
		     else if(text1.getText().equals("")==false&&row+1>=0&&table[0][column + 1].toString().startsWith("Products No")){
		    	 text1.setOnClickListener(onPartnoClickListener);
		    	 text1.setOnLongClickListener(null);
		    	 
		     }
		     else if(text1.getText().equals("")==false&&row+1>0&&table[0][column + 1].toString().startsWith("SO")){
		    	 String []temp=text1.getText().toString().split("\n");
		    	 if(temp.length >=3){
		    		 text1.setText(temp[0]+"\n"+temp[1]);
		    		// text1.setGravity(Gravity.LEFT);		    		 
		    		 text1.setTag(String.valueOf(row+1)+":"+temp[2]);
		    		 text1.setOnClickListener(onCustomerClickListener);
		    		 text1.setOnLongClickListener(null);
		    		 
		    	 }
		    	 else {
		    		// text1.setGravity(Gravity.LEFT);
		    		 text1.setOnClickListener(null);
		    		 text1.setOnLongClickListener(null);
		    		 
		    	 }
		     }
		     else if(text1.getText().equals("")==false&&row+1>=0&&column + 1 > 0){
		    	 if(onCellLongClickListener!=null){
		    	    text1.setOnLongClickListener(onCellLongClickListener);
		    	    text1.setOnClickListener(null);
		    	    
		    	 }
		     }
		    
		     else {
		    	 //text1.setGravity(Gravity.LEFT);
		    	 text1.setCompoundDrawables(null, null, null, null);
		    	 text1.setOnClickListener(null);
		    	 text1.setOnLongClickListener(null);
		     }
		    }
          
	
		return convertView;
	}
	
	@Override
	public int getHeight(int row) {
		return height;
	}

	@Override
	public int getWidth(int column) {
  		String title=table[0][column + 1].toString();
  		TextView textView=new TextView(context);
  		TextPaint paint = textView.getPaint();
  		if(title.startsWith("ITEM")){ 
  			title="ITEMA";
  			return (int) paint.measureText(title);
  		}
  		if(title.startsWith("Status")){ 
  			//title="Satus";
  			return (int) paint.measureText(title);
  		}
  		if(title.endsWith("Type")){
  			title="Upgrade";  
  			return (int) (paint.measureText(title)*1.2);
  		}
  		if(title.equals("Products No")){  			  
  			return (int) (width*1.2);
  		}
  		if(title.endsWith("Q'ty")){
   			return (int) paint.measureText(title);
  		}  		
  		if(title.endsWith("Date")||title.endsWith("Issue")){
  			title="Schedule d"; 
   			return (int) paint.measureText(title);
  		}
  		if(title.endsWith("Spec")){
  			title="Product     Spec"; 
   			return (int) paint.measureText(title);
  		}
  		if(title.endsWith("SOD")){
  			title="Confrimed";  
  			return (int) paint.measureText(title);
  		}
  		if(title.endsWith("S/N")){  			
   			return (int)( paint.measureText(title)*2);
  		}
		/*if(column==-1) return DisplayUtil.dip2px(context,120);
		if(column==0) return DisplayUtil.dip2px(context,50);
		if(column==7) return DisplayUtil.dip2px(context,250);
		if(column==8) return DisplayUtil.dip2px(context,150);
		if(column==9) return DisplayUtil.dip2px(context,200);
		if(column==19) return DisplayUtil.dip2px(context,200);
		if(column==21) return DisplayUtil.dip2px(context,175);*/
		//if(column==1) return 120;
  		
	    return  width;
	}

	@Override
	public int getItemViewType(int row, int column) {
		if((row + 1>=0)&&(column + 1>=0)&&table[row + 1][column + 1].toString().contains("以上")){
			return 2;
		}
		if(row<0){
			return 0;
		}
		else if(row+1>=1&&column+1>=1){
			return 3;			
		}
		else{
			return 1;
		}
		
	}

	@Override
	public int getViewTypeCount() {
		return 4;
	}
	public int getLayoutResource(int row, int column) {
		final int layoutResource;
		switch (getItemViewType(row, column)) {
			case 0:
				layoutResource = R.layout.item_table1_header;
			break;
			case 1:
				layoutResource = R.layout.item_table1;
			break;
			case 2:
				layoutResource = R.layout.item_table2;
			break;
			case 3:
				if(this.selectedIndex>=0&&(row-1)==this.selectedIndex)
				{					
					layoutResource = R.layout.item_table4;
				}
				else
				{
					layoutResource = R.layout.item_table3;
				}
			break;
			default:
				throw new RuntimeException("wtf?");
		}
		return layoutResource;
	}

}
