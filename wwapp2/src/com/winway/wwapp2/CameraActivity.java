package com.winway.wwapp2;
import com.winway.camera.*;
import com.winway.camera.CameraInterface.CamOpenOverCallback;
import com.winway.camera.CameraSurfaceView;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import android.media.FaceDetector;
import android.media.FaceDetector.Face;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.util.DisplayMetrics;
import android.util.Log;
import android.hardware.Camera.ShutterCallback;
import android.content.res.Configuration;
import com.winway.wwapp2.BaseFragment.ICallback;
import java.util.ArrayList;
import java.util.List;
public class CameraActivity extends BaseFragment  {
	private Context context;
	private ImageButton btn_shutter;
	private ImageButton btn_rotation;
	private TextView lb_camera_cancel;
	private TextView lb_so;
	private static final String TAG = "wwapp2";
	CameraSurfaceView surfaceView = null;
	FindFaceView mFindFaceView = null;
	float previewRate = -1f;
	protected CamOpenOverCallback mCallback;
	private SensorManager sm;
	private float[] accelerometer_values = null;
	private float[] magnitude_values = null;
	int mOrientation=1;
	private Bundle bundle;
	private boolean listen_status=true;
	SensorEventListener listener = new SensorEventListener() {
        public void onSensorChanged(SensorEvent event) {
        	if(!listen_status) return ;
            switch (event.sensor.getType()) {
                 
                case Sensor.TYPE_ACCELEROMETER:
                    accelerometer_values = event.values.clone();
                    //Landspace
                    if(accelerometer_values[0]>accelerometer_values[1])
                    {
                    	mOrientation = 2;
                    	LayoutParams p2 = btn_rotation.getLayoutParams();
                		p2.width = DisplayUtil.dip2px(getActivity(),18);
                		p2.height = DisplayUtil.dip2px(getActivity(), 24);
                		btn_rotation.setLayoutParams(p2);	
                		btn_rotation.setBackgroundResource(R.drawable.camera_2);
                		// String result="0:"+accelerometer_values[0]+",1:"+accelerometer_values[1]+",2:"+accelerometer_values[2];
                 		//Toast.makeText(getActivity(), result, Toast.LENGTH_LONG).show();
                    }
                    //portrait
                    else if(accelerometer_values[0]<3 && accelerometer_values[1]<3 &&accelerometer_values[2]>0){
                    	
                    	mOrientation = 2;                    	
                    	LayoutParams p2 = btn_rotation.getLayoutParams();
                    	p2.width = DisplayUtil.dip2px(getActivity(), 18);
                		p2.height = DisplayUtil.dip2px(getActivity(), 24);
                		btn_rotation.setLayoutParams(p2);                	
                		btn_rotation.setBackgroundResource(R.drawable.camera_3); 
                		// String result="0:"+accelerometer_values[0]+",1:"+accelerometer_values[1]+",2:"+accelerometer_values[2];
                 		//Toast.makeText(getActivity(), result, Toast.LENGTH_LONG).show();
                    }
                    else  {
                    	mOrientation = 1;
                    	LayoutParams p2 = btn_rotation.getLayoutParams();
                		p2.width = DisplayUtil.dip2px(getActivity(),24);
                		p2.height = DisplayUtil.dip2px(getActivity(), 18);
                		btn_rotation.setLayoutParams(p2);	
                		btn_rotation.setBackgroundResource(R.drawable.camera_1);
                    	
                    }
                   
                    break;
                case Sensor.TYPE_MAGNETIC_FIELD:
                    magnitude_values = event.values.clone();
                    break;
                default:
                    break;
            }

            if (magnitude_values == null || accelerometer_values == null) {
                return;
            }
           // getOrientation();
        }

        public void onAccuracyChanged(Sensor sensor, int accuracy) {
            // Called when the accuracy of a sensor has changed.
        }
    };
    private void getOrientation(){
    	   float[] SensorValues = new float[3];
    	   float[] R = new float[9];
    	   if (magnitude_values[0]!= 0 && accelerometer_values[2]!=0)
    	   {
    	      if (SensorManager.getRotationMatrix(R, null, accelerometer_values, magnitude_values))
    	         {
    	             SensorManager.getOrientation(R, SensorValues);
    	             float  mAngle = SensorValues[0]; //旋轉
    	             float  mPitch = SensorValues[1];  //拋擲
    	             float  mRoll = SensorValues[2];  //翻滾
    	             int angle = Math.round(mAngle * (float)(180.0f/Math.PI)  ) *-1;
    	             int pitch = Math.round(mPitch * (float)(180.0f/Math.PI)  ) *-1;
    	             int roll = Math.round(mRoll * (float)(180.0f/Math.PI)  ) *-1;
    	             //String result="angle:"+String.valueOf(angle)+",pitch:"+String.valueOf(pitch)+",roll:"+String.valueOf(roll);
              		 //Toast.makeText(getActivity(), result, Toast.LENGTH_LONG).show();
    	         }
    	    }
    	}

	//Function C
	private void closeFragment() {
		if (this.parent != null) {
			this.fragmentManager.beginTransaction().remove(this).commit();
			this.fragmentManager.beginTransaction().show(this.parent).commit();
			//reload album
			AlbumListActivity act=(AlbumListActivity)this.parent;
			act.reloadAlbum();
			
		}
	}	
  //Function H
	public void hideActionbar() {
		ActionBar mActionBar = getActivity().getActionBar();
		if (mActionBar.isShowing())
		{
			mActionBar.hide();
		}
	}
	// Function I
	private View initView(LayoutInflater inflater, ViewGroup container) {
		View view = inflater.inflate(R.layout.activity_camera, container, false);
		context = view.getContext();
		bundle=this.getArguments();
		mCallback = new CamOpenOverCallback(){
			@Override
			public void cameraHasOpened() {
				// TODO Auto-generated method stub
				SurfaceHolder holder = surfaceView.getSurfaceHolder();
				mFindFaceView.setCameraPreviewSurfaceHolder(holder);
				CameraInterface.getInstance().setCustomFolder(lb_so.getText().toString());
				//CameraInterface.getInstance().doStartPreview(holder, previewRate);
				if(mFindFaceView!=null) {
					CameraInterface.getInstance().doStartPreview(mFindFaceView, previewRate);
				}
				else {
					CameraInterface.getInstance().doStartPreview(holder, previewRate);
				}
			}		
		};
		
		initUI(view);
		initViewParams();
		return view;
	}

	private void initUI(View v) {	
		if (this.fragmentManager == null) {
			this.fragmentManager = getFragmentManager();
		}
		//sm = (SensorManager) getActivity().getSystemService(Context.SENSOR_SERVICE); 
		//SetSensor();
       /* mSensor = sm.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);  */
		lb_so=(TextView)v.findViewById(R.id.lb_so);
		if(bundle!=null&&bundle.get("so")!=""){
			lb_so.setText(String.valueOf(bundle.get("so")));			
		}
		lb_camera_cancel=(TextView)v.findViewById(R.id.lb_camera_cancel);
		btn_rotation = (ImageButton)v.findViewById(R.id.btnRotation);
		btn_shutter = (ImageButton)v.findViewById(R.id.btnShutter);
		surfaceView = (CameraSurfaceView)v.findViewById(R.id.camera_surfaceview);
		mFindFaceView = (FindFaceView)v.findViewById(R.id.faces_rectangle);
		btn_shutter.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				switch(v.getId()){
					case R.id.btnShutter:
						// int orientation=((MainActivity)getActivity()).getOrientation();
						 CameraInterface.getInstance().Orientation=mOrientation;
						 CameraInterface.getInstance().setCustomFolder(lb_so.getText().toString());
						 CameraInterface.getInstance().doTakePicture();
					     break;
						default:break;
					}
				}

		});
		lb_camera_cancel.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View v) {
				closeFragment();				
			}
			
		});
		 hideActionbar();
	}
	private void initViewParams(){
		LayoutParams params = surfaceView.getLayoutParams();
		Point p = DisplayUtil.getScreenMetrics(this.context);
		params.width = p.x;
		params.height = p.y;
		previewRate = DisplayUtil.getScreenRate(this.context); //默認全屏的比例預覽
		//surfaceView.setLayoutParams(params);

		//手動設置拍照ImageButton的大小為120dip×120dip,原圖片大小是64×64
	    /*LayoutParams p2 = btn_shutter.getLayoutParams();
	    
	    p2.width  = DisplayUtil.dip2px(this.context, 120);
		p2.height = DisplayUtil.dip2px(this.context, 120);
		btn_shutter.setLayoutParams(p2);*/	
	

	}
	//Function O
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return initView(inflater, container);
	}

	  
	    @Override
        public void onDestroyView() {
            super.onDestroyView();           
        }

        @Override
        public void onDestroy() {
            super.onDestroy();           
        }

        @Override
        public void onDetach() {
            super.onDetach();
            //sm.unregisterListener(listener);
        }

        @Override
        public void onPause() {
        	listen_status=false;
        	sm.unregisterListener(listener);
            CameraInterface.getInstance().doStopCamera();
            super.onPause();            
            
        }

        @Override
        public void onResume() {
            super.onResume();
            if(mCallback==null)Toast.makeText(context,"resume", Toast.LENGTH_LONG).show();
            if(sm==null){            	
            	sm = (SensorManager) getActivity().getSystemService(Context.SENSOR_SERVICE); 
            }
            	boolean enable = sm.registerListener(listener,
	                sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
	                SensorManager.SENSOR_DELAY_UI)
	                &&
	                sm.registerListener(listener,
	                        sm.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD),
	                        SensorManager.SENSOR_DELAY_UI);
	        if (!enable) {
	            sm.unregisterListener(listener);	
	            return ;
	        }
	        Thread openThread = new Thread(){
    			@Override
    			public void run() {
    				// TODO Auto-generated method stub
    				listen_status=true;
    				CameraInterface.getInstance().doOpenCamera(mCallback);
    			}
    		};
    		openThread.start();
           
        }

        @Override
        public void onStart() {
            super.onStart();          
            /*if(sm==null){            	
            	sm = (SensorManager) getActivity().getSystemService(Context.SENSOR_SERVICE); 
            }
            	boolean enable = sm.registerListener(listener,
	                sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
	                SensorManager.SENSOR_DELAY_UI)
	                &&
	                sm.registerListener(listener,
	                        sm.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD),
	                        SensorManager.SENSOR_DELAY_UI);
	        if (!enable) {
	            sm.unregisterListener(listener);	            
	        }*/
        }

        @Override
        public void onStop() {
            super.onStop();           
        }


        @Override
        public void onAttach(Activity activity) {          
            super.onAttach(activity);
        }

	}
