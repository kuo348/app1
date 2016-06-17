package com.winway.camera;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Paint.Style;
import android.graphics.PixelFormat;
import android.graphics.PorterDuffXfermode;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.graphics.PointF;
import android.media.FaceDetector;
import android.media.FaceDetector.Face;

public class FindFaceView extends SurfaceView implements SurfaceHolder.Callback{

    protected SurfaceHolder sh;
    private  SurfaceHolder mCameraSh;
    private int mWidth;
    private int mHeight;
    private float mEyesDistance;

    public FindFaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
        // TODO Auto-generated constructor stub
        sh = getHolder();
        sh.addCallback(this);
        sh.setFormat(PixelFormat.TRANSPARENT);
        setZOrderOnTop(true);
    }

    public void surfaceChanged(SurfaceHolder arg0, int arg1, int w, int h) {
        // TODO Auto-generated method stub
        mWidth = w;
        mHeight = h;
    }

    public void surfaceCreated(SurfaceHolder arg0) {
        // TODO Auto-generated method stub

    }

    public void surfaceDestroyed(SurfaceHolder arg0) {
        // TODO Auto-generated method stub

    }

    public void setCameraPreviewSurfaceHolder(SurfaceHolder  sh) {
        mCameraSh = sh;
    }
    public SurfaceHolder getCameraPreviewSurfaceHolder() {
        return mCameraSh ;
    }
    public int getFaceViewWidth() {
        return mWidth;
    }
    public int getFaceViewHeight() {
        return mHeight;
    }

    void clearDraw() {
        Canvas canvas = sh.lockCanvas();
        Paint clipPaint = new Paint();
        clipPaint.setAntiAlias(true);
        clipPaint.setStyle(Paint.Style.STROKE);
        clipPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        canvas.drawPaint(clipPaint);
        sh.unlockCanvasAndPost(canvas);
    }

    public void drawRects(FaceDetector.Face[] mFace, int numberOfFaceDetected) {
        Canvas canvas = sh.lockCanvas();

        Paint clipPaint = new Paint();
        clipPaint.setAntiAlias(true);
        clipPaint.setStyle(Paint.Style.STROKE);
        clipPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        canvas.drawPaint(clipPaint);

        canvas.drawColor(Color.TRANSPARENT);
        Paint p = new Paint();
        p.setAntiAlias(true);
        p.setColor(Color.RED);
        p.setStyle(Style.STROKE);

        for (int i = 0; i < numberOfFaceDetected; i++) {
            //  if (0 == i) {
            //   p.setColor(Color.WHITE);
            //  } else {
            //   p.setColor(Color.GRAY);
            //  }
            Face face = mFace[i];
            PointF myMidPoint = new PointF();
            face.getMidPoint(myMidPoint);
            mEyesDistance = face.eyesDistance();
            Log.i("Harrison", "i="+i+"("+myMidPoint.x+", "+myMidPoint.y+")");
            canvas.drawRect((int)(myMidPoint.x-mEyesDistance),
                    (int)(myMidPoint.y-mEyesDistance),
                    (int)(myMidPoint.x+mEyesDistance),
                    (int)(myMidPoint.y+mEyesDistance),
                    p);
        }
        sh.unlockCanvasAndPost(canvas);
    }

    //測試兩個View是否錯移
    public void drawBitmap(Bitmap myBitmap) {
        Canvas canvas = sh.lockCanvas();
        canvas.drawBitmap(myBitmap, 0, 0, null);
        sh.unlockCanvasAndPost(canvas);
        // mImage.setImageBitmap(myBitmap);
        // mImage.invalidate();
    }
    public void doDraw() {
        Canvas canvas = sh.lockCanvas();
        canvas.drawColor(Color.TRANSPARENT);// 這裏是繪制背景
        Paint p = new Paint(); // 筆觸
        p.setAntiAlias(true); // 反鋸齒
        p.setColor(Color.RED);
        p.setStyle(Style.STROKE);
        canvas.drawLine(mWidth/2 - 100, 0, mWidth/2 - 100, mHeight, p);
        canvas.drawLine(mWidth/2 + 100, 0, mWidth/2 + 100, mHeight, p);
        // ------------------------
        // 畫邊框---------------------
        Rect rec = canvas.getClipBounds();
        rec.bottom--;
        rec.right--;
        p.setColor(Color.GRAY);
        // 顏色
        p.setStrokeWidth(5);
        canvas.drawRect(rec, p);
        // 提交繪制
        sh.unlockCanvasAndPost(canvas);
    }
}