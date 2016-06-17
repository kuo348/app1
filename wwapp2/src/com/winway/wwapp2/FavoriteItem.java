package com.winway.wwapp2;


import android.graphics.Color;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.GridLayout;
import android.content.Context;
import android.widget.TextView;
import android.widget.ImageView;
import com.winway.camera.DisplayUtil;
/**
 * Created by kuo348 on 2016/1/8.
 */
public class FavoriteItem  {
        public final String text;
        public final int icon;
        public FavoriteItem(String text, Integer icon) {
            this.text = text;
            this.icon = icon;
        }
        @Override
        public String toString() {
            return text;
        }
        public LinearLayout getLayout(Context context)
        {
            LinearLayout layout=new LinearLayout(context);
           // GridLayout.LayoutParams rlp= new GridLayout.LayoutParams();
            LinearLayout.LayoutParams rlp= new LinearLayout.LayoutParams(DisplayUtil.dip2px(context,96)
                    ,DisplayUtil.dip2px(context,96));

           // layout.setWeightSum(1);
           // layout.setGravity(Gravity.FILL);
            layout.setOrientation(LinearLayout.VERTICAL);
            if(this.icon!=0) {
                ImageView img = new ImageView(context);
                LinearLayout.LayoutParams lp1 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, DisplayUtil.dip2px(context, 72));
                img.setImageResource(this.icon);
                img.setLayoutParams(lp1);
                layout.addView(img);
            }
            if(this.text.isEmpty()==false) {
                TextView tv = new TextView(context);
                LinearLayout.LayoutParams lp2 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT);
                tv.setGravity(Gravity.CENTER);
                tv.setLayoutParams(lp2);
                tv.setTextColor(Color.BLACK);
                tv.setText(this.text);

                layout.addView(tv);
            }
            layout.setLayoutParams(rlp);
            return layout;
        }

}
