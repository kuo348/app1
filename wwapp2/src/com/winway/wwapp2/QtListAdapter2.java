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
import android.widget.EditText;

import java.util.ArrayList;

/**
 * qt列表調適器
 * @author 
 *
 */
public class QtListAdapter2 extends BaseAdapter {

	private Context context;
	private ArrayList<QtItem2> qtItems2;
	private int selectItem=-1;

	public QtListAdapter2(Context context, ArrayList<QtItem2> qtItems2){
		this.context = context;
		this.qtItems2 = qtItems2;
	}

	@Override
	public int getCount() {
		
		//System.out.println("==>"+new Throwable().getStackTrace()[0].getClassName()+" > "+new Throwable().getStackTrace()[0].getMethodName());
		//System.out.println("===>Line number: "+new Throwable().getStackTrace()[0].getLineNumber()); 
   		
		return qtItems2.size();
	}

	@Override
	public Object getItem(int position) {
		
		//System.out.println("==>"+new Throwable().getStackTrace()[0].getClassName()+" > "+new Throwable().getStackTrace()[0].getMethodName());
		//System.out.println("===>Line number: "+new Throwable().getStackTrace()[0].getLineNumber()); 
   		
		return qtItems2.get(position);
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
            convertView = mInflater.inflate(R.layout.qtlist_item2, null);
        }
		//LinearLayout ln = (LinearLayout) convertView.findViewById(R.id.msg_ll);

		EditText M1_QT_TYPE  = (EditText) convertView.findViewById(R.id.ed_M1_QT_TYPE );
		EditText M1_QT_NO    = (EditText) convertView.findViewById(R.id.ed_M1_QT_NO   );
		EditText M1_QT_SEQ   = (EditText) convertView.findViewById(R.id.ed_M1_QT_SEQ  );
		EditText AP_TYPE     = (EditText) convertView.findViewById(R.id.ed_AP_TYPE    );
		EditText AP_NO       = (EditText) convertView.findViewById(R.id.ed_AP_NO      );
		EditText DRAWING_REF = (EditText) convertView.findViewById(R.id.ed_DRAWING_REF);
		EditText DESCRIPTION = (EditText) convertView.findViewById(R.id.ed_DESCRIPTION);
		EditText APQP_NO     = (EditText) convertView.findViewById(R.id.ed_APQP_NO    );

		M1_QT_TYPE .setText(qtItems2.get(position).getM1_QT_TYPE ());
		M1_QT_NO   .setText(qtItems2.get(position).getM1_QT_NO   ());
		M1_QT_SEQ  .setText(qtItems2.get(position).getM1_QT_SEQ  ());
		AP_TYPE    .setText(qtItems2.get(position).getAP_TYPE    ());
		AP_NO      .setText(qtItems2.get(position).getAP_NO      ());
		DRAWING_REF.setText(qtItems2.get(position).getDRAWING_REF());
		DESCRIPTION.setText(qtItems2.get(position).getDESCRIPTION());
		APQP_NO    .setText(qtItems2.get(position).getAPQP_NO    ());

		TextView tv_M1_QT_SEQ   = (TextView) convertView.findViewById(R.id.tv_M1_QT_SEQ  );
	  //TextView tv_AP_TYPE     = (TextView) convertView.findViewById(R.id.tv_AP_TYPE    );
	  //TextView tv_AP_NO       = (TextView) convertView.findViewById(R.id.tv_AP_NO      );
		TextView tv_DRAWING_REF = (TextView) convertView.findViewById(R.id.tv_DRAWING_REF);
		TextView tv_DESCRIPTION = (TextView) convertView.findViewById(R.id.tv_DESCRIPTION);
		TextView tv_APQP_NO     = (TextView) convertView.findViewById(R.id.tv_APQP_NO    );

	  //tv_M1_QT_TYPE .setText(qtItems2.get(position).getM1_QT_TYPE ());
	  //tv_M1_QT_NO   .setText(qtItems2.get(position).getM1_QT_NO   ());
		tv_M1_QT_SEQ  .setText(qtItems2.get(position).getM1_QT_SEQ  ());
	  //tv_AP_TYPE    .setText(qtItems2.get(position).getAP_TYPE    ());
	  //tv_AP_NO      .setText(qtItems2.get(position).getAP_NO      ());
		tv_DRAWING_REF.setText(qtItems2.get(position).getDRAWING_REF());
		tv_DESCRIPTION.setText(qtItems2.get(position).getDESCRIPTION());
		tv_APQP_NO    .setText(qtItems2.get(position).getAPQP_NO    ());

		//20160111 : 控制變顏色
		if(position==selectItem){
			//convertView.setBackgroundResource(R.drawable.customer_listitem);
			//convertView.setBackgroundColor(Color.LTGRAY);
			convertView.setBackgroundColor(Color.TRANSPARENT);
		}
		else{
			convertView.setBackgroundResource(Color.TRANSPARENT);

		}

		return convertView;
	}

}
