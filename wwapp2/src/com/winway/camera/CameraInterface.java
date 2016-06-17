package com.winway.camera;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ImageFormat;
import android.graphics.Matrix;
import android.graphics.PixelFormat;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.YuvImage;
import android.hardware.Camera;
import android.hardware.Camera.AutoFocusCallback;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PictureCallback;
import android.hardware.Camera.PreviewCallback;
import android.hardware.Camera.ShutterCallback;
import android.hardware.Camera.Size;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.media.FaceDetector;
import android.media.FaceDetector.Face;
import android.view.SurfaceView;
import android.view.View;

@SuppressWarnings("deprecation")
public class CameraInterface {
	private static final String TAG = "wwapp2";
	private Camera mCamera;
	private Camera.Parameters mParams;
	private boolean isPreviewing = false;
	private float mPreviwRate = -1f;
	private static CameraInterface mCameraInterface;
	public int Orientation=1;
	public int FullScreen=1;
    private  String custDir;
    public PreviewCallback previewCallback;
	private FindFaceView mFindFaceView;
	protected FaceDetector.Face []mFace;
	protected FaceDetector mFaceDetect;
	public int numberOfFace=10;
	public int numberOfFaceDetected;
	protected PointF mPreMidPoint= new PointF();
	public interface CamOpenOverCallback{
		public void cameraHasOpened();
	}	
	public void setCustomFolder(String dir){
		custDir = dir;	
		FileUtil.setCustomFolder(custDir);
	}
	private CameraInterface(){
		mPreMidPoint.x=0;
		mPreMidPoint.y=0;
	}
	public static synchronized CameraInterface getInstance(){

		if(mCameraInterface == null){
			mCameraInterface = new CameraInterface();
		}
		return mCameraInterface;
	}
	protected void DrawRectOnFace() {
		if (numberOfFaceDetected != 0) {
			Face mFace1 = mFace[0];
			PointF midPoint = new PointF();
			mFace1.getMidPoint(midPoint);
			if ((Math.abs(mPreMidPoint.x-midPoint.x) < 50) && (Math.abs(mPreMidPoint.y-midPoint.y) < 50)) {
				Log.i("Harrison", "not draw Rect .");
				return ;
			}

			mPreMidPoint.x = midPoint.x;
			mPreMidPoint.y = midPoint.y;
			mFindFaceView.setVisibility(View.VISIBLE);

		} else {

			mPreMidPoint.x = 0;
			mPreMidPoint.y = 0;
			mFindFaceView.clearDraw();
			mFindFaceView.setVisibility(View.GONE);
			return;
		}
		mFindFaceView.drawRects(mFace, numberOfFaceDetected);
	}
	//调用API找人脸，需要import进软件包哦！
	protected void FindFacesInBitmap(Bitmap myBitmap) {
		mPreMidPoint.x=0;
		mPreMidPoint.y=0;
		int imageWidth = myBitmap.getWidth();
		int imageHeight = myBitmap.getHeight();
		Log.i("Harrison", "imageWidth="+imageWidth+",  imageHeight="+imageHeight);
		mFace = new FaceDetector.Face[numberOfFace];
		mFaceDetect = new FaceDetector(imageWidth, imageHeight, numberOfFace);
		numberOfFaceDetected = mFaceDetect.findFaces(myBitmap, mFace);
		Log.i("Harrison", "numberOfFaceDetected="+numberOfFaceDetected);

	}
	//处理图片格式，一般摄像头抓到的数据为ImageFormat.NV21，不同的格式，需要调整的。
	protected void decodeToBitMap(byte[] data) {
		Log.i(TAG, "decodeToBitMap");
		mCamera.setOneShotPreviewCallback(null);
		Size size = mCamera.getParameters().getPreviewSize();
		Bitmap myBitmap;
		Bitmap tmpScaleBmp=null;
		Bitmap tmpRotateBmp;
		//FileOutputStream outStream = null;
		try {

			YuvImage image = new YuvImage(data, ImageFormat.NV21, size.width, size.height, null);
			if (image != null) {

				ByteArrayOutputStream stream = new ByteArrayOutputStream();

				image.compressToJpeg(new Rect(0, 0, size.width, size.height), 80, stream);

//在我的手机上有两种预览模式，发现全屏模式时需要调整图片的大小才能正确定位。
				myBitmap=BitmapFactory.decodeByteArray(stream.toByteArray(), 0, stream.size());

				stream.close();

				if (FullScreen==1) { // fullscreen mode


//手机是竖屏横排是与其别的哦

					if (Orientation==1) {
                        tmpRotateBmp = ImageUtil.rotateBitmap(myBitmap);
						tmpScaleBmp = ImageUtil.scaleBitmap(tmpRotateBmp, mFindFaceView.getFaceViewWidth(), mFindFaceView.getFaceViewHeight());
						FindFacesInBitmap(tmpScaleBmp);
						if (tmpRotateBmp != null) {
							tmpRotateBmp.recycle();
							//tmpRotateBmp = null;
						}
					} else {
						FindFacesInBitmap(ImageUtil.scaleBitmap(myBitmap, mFindFaceView.getFaceViewWidth(), mFindFaceView.getFaceViewHeight()));
					}

					if (tmpScaleBmp != null) {
						tmpScaleBmp.recycle();
						//tmpScaleBmp = null;
					}

				} else { //normal mode
					FindFacesInBitmap(myBitmap);
				}

				DrawRectOnFace();

				if (myBitmap != null) {
					myBitmap.recycle();
					//myBitmap = null;

				}

			}

		} catch (Exception ex) {

			Log.e("Sys", "Error:" + ex.getMessage());

		}

		//mCamera.setPreviewCallback(mPreviewCallback);
		mCamera.setOneShotPreviewCallback(mPostPreviewCallBack);

	}
	public Parameters getParameters()
	{
		if(mCamera!=null){
			if(mParams==null)
				mParams=mCamera.getParameters();
			return mParams;			
		}	
		return null;
	}
	/**打開Camera
	 * @param callback
	 */
	public void doOpenCamera(CamOpenOverCallback callback){
		Log.i(TAG, "Camera open....");
		mCamera = Camera.open();
		Log.i(TAG, "Camera open over....");
		callback.cameraHasOpened();
	}
	public void doOneShotPreview(PreviewCallback callback)
	{
		if(mCamera!=null){
			 mCamera.setOneShotPreviewCallback(callback); 			
		}	
	}
	/**開啟預覽
	 * @param holder
	 * @param previewRate
	 */
	public void doStartPreview(FindFaceView faceView, float previewRate){
		mFindFaceView = faceView;
		SurfaceHolder holder;
		holder = mFindFaceView.getCameraPreviewSurfaceHolder();
		doStartPreview(holder,previewRate) ;
	}
	public void doStartPreview(SurfaceHolder holder, float previewRate){
		Log.i(TAG, "doStartPreview...");
		if(isPreviewing){
			mCamera.stopPreview();
			return;
		}
		if(mCamera != null){

			mParams = mCamera.getParameters();
			mParams.setPictureFormat(PixelFormat.JPEG);//設置拍照後存儲的圖片格式
			CamParaUtil.getInstance().printSupportPictureSize(mParams);
			CamParaUtil.getInstance().printSupportPreviewSize(mParams);
			//設置PreviewSize和PictureSize
			Size pictureSize = CamParaUtil.getInstance().getPropPictureSize(
					mParams.getSupportedPictureSizes(),previewRate, 800);
			mParams.setPictureSize(pictureSize.width, pictureSize.height);
			Size previewSize = CamParaUtil.getInstance().getPropPreviewSize(
					mParams.getSupportedPreviewSizes(), previewRate,800);
			mParams.setPreviewSize(previewSize.width, previewSize.height);

			mCamera.setDisplayOrientation(90);

			CamParaUtil.getInstance().printSupportFocusMode(mParams);
			List<String> focusModes = mParams.getSupportedFocusModes();
			if(focusModes.contains("continuous-video")){
				mParams.setFocusMode(Camera.Parameters.FOCUS_MODE_CONTINUOUS_VIDEO);
			}
			mCamera.setParameters(mParams);	

			try {
				mCamera.setPreviewDisplay(holder);
				mCamera.startPreview();//開啟預覽
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			isPreviewing = true;
			mPreviwRate = previewRate;

			mParams = mCamera.getParameters(); //重新get一次
			Log.i(TAG, "最終設置:PreviewSize--With = " + mParams.getPreviewSize().width
					+ "Height = " + mParams.getPreviewSize().height);
			Log.i(TAG, "最終設置:PictureSize--With = " + mParams.getPictureSize().width
					+ "Height = " + mParams.getPictureSize().height);
		}
	}
	/**
	 * 停止預覽，釋放Camera
	 */
	public void doStopCamera(){
		if(null != mCamera)
		{
			mCamera.setPreviewCallback(null);
			mCamera.setOneShotPreviewCallback(null);
			mCamera.stopPreview(); 
			isPreviewing = false; 
			mPreviwRate = -1f;
			mCamera.release();
			mCamera = null;     
		}
	}
	public void doAutoFocusAndPreview()
	{
	  if(mCamera!=null){
	    mCamera.autoFocus(mAutoFocusCallback);
	  }
	}
	/**
	 * 拍照
	 */
	public void doTakePicture(){
		if(isPreviewing && (mCamera != null)){
			mCamera.takePicture(mShutterCallback, null, mJpegPictureCallback);
		}
	}

	/*為了實現拍照的快門聲音及拍照保存照片需要下面三個回調變量*/
	ShutterCallback mShutterCallback = new ShutterCallback() 
	//快門按下的回調，在這裏我們可以設置類似播放“哢嚓”聲之類的操作。默認的就是哢嚓。
	{
		public void onShutter() {
			// TODO Auto-generated method stub
			Log.i(TAG, "myShutterCallback:onShutter...");
		}
	};
	PictureCallback mRawCallback = new PictureCallback() 
	// 拍攝的未壓縮原數據的回調,可以為null
	{

		public void onPictureTaken(byte[] data, Camera camera) {
			// TODO Auto-generated method stub
			Log.i(TAG, "myRawCallback:onPictureTaken...");

		}
	};
	PictureCallback mJpegPictureCallback = new PictureCallback() 
	//對jpeg圖像數據的回調,最重要的一個回調
	{
		public void onPictureTaken(byte[] data, Camera camera) {
			// TODO Auto-generated method stub
			Log.i(TAG, "myJpegCallback:onPictureTaken...");
			Bitmap b = null;
			if(null != data){
				b = BitmapFactory.decodeByteArray(data, 0, data.length);//data是字節數據，將其解析成位圖
				mCamera.stopPreview();
				isPreviewing = false;
			}
			//保存圖片到sdcard
			if(null != b)
			{
				//設置FOCUS_MODE_CONTINUOUS_VIDEO)之後，myParam.set("rotation", 90)失效。
				//圖片竟然不能旋轉了，故這裏要旋轉下
				float roation=0.0f;
				if(Orientation==1){
					roation = 90.0f;
				}
				Bitmap rotaBitmap = ImageUtil.getRotateBitmap(b,roation);
				if(!custDir.equals("")){
					FileUtil.setCustomFolder(custDir);
				}
				FileUtil.saveBitmap(rotaBitmap);
			}
			//再次進入預覽
			mCamera.startPreview();
			isPreviewing = true;
		}
	};
	private  final class PostPreviewCallback implements PreviewCallback {
		@Override
		public void onPreviewFrame(byte[] data, android.hardware.Camera camera) {
			decodeToBitMap(data);
		}
	}
	private PostPreviewCallback  mPostPreviewCallBack=new PostPreviewCallback();
	private AutoFocusCallback mAutoFocusCallback =  new AutoFocusCallback() {
        
        public void onAutoFocus(boolean success, Camera camera) {
			Log.i(TAG, "in AutoFocus");
            // TODO Auto-generated method stub
        	//取消autoFocus
        	mCamera.autoFocus(null);
            if(success)//success表示对焦成功
            {
                Log.i(TAG, "AutoFocusCallback: success...");
                if(previewCallback!=null) {
                  mCamera.setOneShotPreviewCallback(previewCallback);
				}
				else {
					mCamera.setOneShotPreviewCallback(mPostPreviewCallBack);
				}
                doAutoFocusAndPreview();           
               
            }
            else
            {
                //not focus
                Log.i(TAG, "myAutoFocusCallback: failure...");
                doAutoFocusAndPreview();
            }                
            
        }
    };


}