package com.winway.widget;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Path;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.widget.TextView;
public class WWTextView extends TextView {
	private int _row;
	private int _col;
	public WWTextView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);		
	}
	
	public WWTextView(Context context, AttributeSet attrs) {
		super(context, attrs);	
	}
	
	public WWTextView(Context context) {
		super(context);
	}

   public int getRowIndex()
   {
	   return _row;	   
   }
   public int getColIndex()
   {
	   return _col;	   
   }
   public void setRowIndex(int value)
   {
	   _row=value;	   
   }
   public void setColIndex(int value)
   {
	   _col=value;	   
   }
   @Override
   protected void onDraw(Canvas canvas) {
	   super.onDraw(canvas);
	   /*final ColorStateList csl = getTextColors();
       final int color = csl.getDefaultColor();
       final int paddingBottom = getPaddingBottom();
       final int paddingTop = getPaddingTop();
       final int viewWidth = getWidth();
       final int viewHeight = getHeight();
       final TextPaint paint = getPaint();
       paint.setColor(color);
       final float bottom = viewWidth * 9.0f / 11.0f;
       Path p = new Path();
       p.moveTo(bottom, viewHeight - paddingBottom - paddingTop);
       p.lineTo(bottom, paddingTop);
       canvas.drawTextOnPath(getText().toString(), p, 0, 0, paint);*/
   }
}
