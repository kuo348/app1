package com.winway.wwapp2;

import java.io.ByteArrayOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ImageFormat;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.YuvImage;
import android.hardware.Camera;
import android.hardware.Camera.Size;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnKeyListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.EncodeHintType;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.PlanarYUVLuminanceSource;
import com.google.zxing.RGBLuminanceSource;
import com.google.zxing.Result;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.winway.camera.CamParaUtil;
import com.winway.camera.CameraInterface;
import com.winway.camera.CameraSurfaceView;
import com.winway.camera.DisplayUtil;
import com.winway.camera.FileUtil;
import com.winway.camera.ImageUtil;
import com.winway.camera.CameraInterface.CamOpenOverCallback;
import com.winway.wwapp2.PullDownView.OnPullDownListener;

import android.hardware.Camera.PreviewCallback;

import javax.crypto.Mac;

public class PreShippingActivity extends BaseFragment implements
		OnPullDownListener, OnItemClickListener {
	private Context context;
	CameraSurfaceView surfaceView = null;
	float previewRate = -1f;
	protected CamOpenOverCallback mCallback;
	protected PreviewCallback mPreviewCallback;
	private Button btnReturn;
	private int TabIndex = 0;
	private TextView lb_So;
	private TextView lb_Barcode;
	private RelativeLayout r, r1;
	private FrameLayout r2;
	private View topView, bottomView, centerView;
	private int width;
	private int height;
	private int dstLeft, dstTop, dstWidth, dstHeight;
	private int page;
	private ImageView imgView;
	private EditText editSearch;
	private SoListAdapter adapter2;
	private ArrayList<SoItem> soItems;
	private PullDownView mPullDownView;
	private ListView lstSo;

	// B
	private class BarcodeTask extends AsyncTask<Void, Void, Void> {

		private byte[] mData;

		// 构造函数
		BarcodeTask(byte[] d) {
			this.mData = d;
		}

		@Override
		protected Void doInBackground(Void... params) {
			// TODO Auto-generated method stub
			final Bitmap bmp = BitmapFactory.decodeByteArray(mData, 0,
					mData.length);
			final Bitmap b = ImageUtil.getRotateBitmap(bmp, 90.0f);
			getActivity().runOnUiThread(new Runnable() {
				public void run() {
					if (b != null) {						
						// 得到影像長寬
						width = b.getWidth();
						height = b.getHeight();
						// 取得可見視窗範圍
						dstLeft = centerView.getLeft()
								* width
								/ getActivity().getWindowManager()
										.getDefaultDisplay().getWidth();
						dstTop = centerView.getTop()
								* height
								/ getActivity().getWindowManager()
										.getDefaultDisplay().getHeight();
						dstWidth = (centerView.getRight() - centerView
								.getLeft())
								* width
								/ getActivity().getWindowManager()
										.getDefaultDisplay().getWidth();
						dstHeight = (centerView.getBottom() - centerView
								.getTop())
								* height
								/ getActivity().getWindowManager()
										.getDefaultDisplay().getHeight();
						Bitmap b1 = ImageCrop(b, dstLeft, dstTop, dstWidth,
								dstHeight);
						// 轉灰階
						b1 = ImageUtil.toGrayscale(b1);
						imgView.setImageBitmap(b1);
						MultiFormatReader reader = new MultiFormatReader();
						try {
							int[] intArray = new int[b1.getWidth()
									* b1.getHeight()];
							// copy pixel data from the Bitmap into the
							// 'intArray' array
							b1.getPixels(intArray, 0, b1.getWidth(), 0, 0,
									b1.getWidth(), b1.getHeight());
							LuminanceSource source = new RGBLuminanceSource(b1
									.getWidth(), b1.getHeight(), intArray);
							BinaryBitmap bitmap = new BinaryBitmap(
									new HybridBinarizer(source));
							//先以Barcode解碼，如果失敗再用QR Code
							Result result = reader.decode(bitmap);
							final String strResult = result.getText();
							// showDialog(strResult);
							if (!strResult.equals("")) {
								showDialog(strResult);
								callCameraActivity(strResult);
								
							} else {
								//判斷是否為QR code
								//Map hintMap = new HashMap();
								//hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
								//result = reader.decode(bitmap,hintMap);
								//if (strResult.equals("")) {
								//	showDialog(strResult);
								//	callCameraActivity(strResult);
								//}
								//else {
									showDialog(strResult);
									FileUtil.saveBitmap(b1);
								//}
							}
						} catch (Exception e) {
							showDialog("辨識失敗");
							FileUtil.saveBitmap(b1);
							e.printStackTrace();
						}
					}
				}
			});
			// doSomethingNeeded(bmp); //自己定义的实时分析预览帧视频的算法

			return null;
		}

	}

	private class CameraTask extends AsyncTask<Void, Void, Void> {
		@Override
		protected Void doInBackground(Void... params) {
			CameraInterface.getInstance().doOpenCamera(mCallback);
			return null;
		}
	}

	// Function C

	private void closeFragment() {
		if (this.parent != null) {
			this.fragmentManager.beginTransaction().remove(this).commit();
			this.fragmentManager.beginTransaction().show(this.parent).commit();
		}

	}

	private void callCameraActivity(String so) {
		CameraActivity activity = new CameraActivity();
		Bundle bundle = new Bundle();
		SimpleDateFormat sdFormat = new SimpleDateFormat("yyyyMMdd");
		bundle.putString("so",
				String.format("%s_%s", sdFormat.format(new Date()), so));
		activity.fragmentManager = getFragmentManager();
		Fragment fragment = activity;
		fragment.setArguments(bundle);
		fragment.setRetainInstance(true);
		activity.setParent(this.parent);
		if (this.fragmentManager.findFragmentByTag("camera") != null) {
			this.fragmentManager.beginTransaction()
					.remove(this.fragmentManager.findFragmentByTag("camera"))
					.commit();
		}
		this.fragmentManager.beginTransaction()
				.add(R.id.content_frame, fragment, "camera").commit();
		this.fragmentManager.beginTransaction().remove(this).commit();
		hideActionbar();
		this.fragmentManager.beginTransaction().show(fragment).commit();
	}

	public static Bitmap ImageCrop(Bitmap bitmap, int dstL, int dstT, int dstW,
			int dstH) {
		// int w = bitmap.getWidth(); // 得到图片的宽，高
		// int h = bitmap.getHeight();
		// int wh = w > h ? h : w;// 裁切后所取的正方形区域边长
		// int retX = w > h ? (w - h) / 2 : 0;//基于原图，取正方形左上角x坐标
		// int retY = w > h ? 0 : (h - w) / 2;
		// 下面这句是关键
		// return Bitmap.createBitmap(bitmap, retX, retY, wh, wh, null, false);
		return Bitmap.createBitmap(bitmap, dstL, dstT, dstW, dstH, null, false);
	}

	// Function H
	public void hideActionbar() {
		ActionBar mActionBar = getActivity().getActionBar();
		if (mActionBar.isShowing()) {
			mActionBar.hide();
		}
	}

	// L

	@Override
	public void loadData(Object result) {
		try {
			JSONObject jsonObject = new JSONObject((String) result);
			setSoItems(jsonObject);
			mPullDownView.notifyDidLoad();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void loadRefreshData(Object result) {
		try {
			JSONObject jsonObject = new JSONObject((String) result);
			soItems.clear();
			setSoItems(jsonObject);
			page = 1;
			mPullDownView.notifyDidRefresh();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void loadMoreData(Object result) {
		try {
			JSONObject jsonObject = new JSONObject((String) result);
			setSoItems(jsonObject);
			JSONArray array = jsonObject.getJSONArray("data");
			if (array.length() == 0) {
				page = page - 1;
			}
			mPullDownView.notifyDidMore();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// Function I
	private View initView(LayoutInflater inflater, ViewGroup container) {
		View view = inflater.inflate(R.layout.actpreshipping, container, false);
		context = view.getContext();
		mCallback = new CamOpenOverCallback() {
			@Override
			public void cameraHasOpened() {
				// TODO Auto-generated method stub
				// CameraInterface.getInstance().doAutoFocusAndPreview();
				// CameraInterface.getInstance().previewCallback =
				// mPreviewCallback;
				SurfaceHolder holder = surfaceView.getSurfaceHolder();
				CameraInterface.getInstance().doStartPreview(holder,
						previewRate);
				// CameraInterface.getInstance().doAutoFocusAndPreview();
				// CameraInterface.getInstance().previewCallback =
				// mPreviewCallback;
			}
		};
		mPreviewCallback = new Camera.PreviewCallback() {
			@Override
			public void onPreviewFrame(byte[] data, Camera camera) {
				// camera.setPreviewCallback(null);
				// 取得指定範圍的幀的資料
				/*
				 * PlanarYUVLuminanceSource source = new
				 * PlanarYUVLuminanceSource(data, width, height, dstLeft,
				 * dstTop, dstWidth, dstHeight, false); BinaryBitmap bitmap =
				 * new BinaryBitmap(new HybridBinarizer(source));
				 * MultiFormatReader reader = new MultiFormatReader(); try {
				 * Result result = reader.decode(bitmap); String strResult =
				 * result.getText(); showDialog(strResult); } catch (Exception
				 * e) {
				 * 
				 * }
				 */
				if (data != null) {
					try {
						Camera.Parameters param = CameraInterface.getInstance()
								.getParameters();
						Size size = param.getPreviewSize();
						YuvImage yuv_image = new YuvImage(data,
								param.getPreviewFormat(), size.width,
								size.height, null);
						Rect rect = new Rect(0, 0, size.width, size.height);
						ByteArrayOutputStream output_stream = new ByteArrayOutputStream();
						yuv_image.compressToJpeg(rect, 80, output_stream);
						byte[] tmp = output_stream.toByteArray();
						parseBarcode(tmp);
						//BarcodeTask barcodeTask = new BarcodeTask(tmp);
						//barcodeTask.execute((Void) null);
					} catch (Exception e) {
						e.printStackTrace();
					}

				}
			}
		};
		initUI(view);
		initViewParams();
		getActivity().runOnUiThread(new Runnable() {
			public void run() {
				queryData(WHAT_DID_LOAD_DATA);

			}
		});
		return view;
	}
    private void parseBarcode(byte []Data)
    {
    	final Bitmap bmp = BitmapFactory.decodeByteArray(Data, 0,
				Data.length);
		final Bitmap b = ImageUtil.getRotateBitmap(bmp, 90.0f);
				if (b != null) {
					// 得到影像長寬
					width = b.getWidth();
					height = b.getHeight();
					// 取得可見視窗範圍
					dstLeft = centerView.getLeft()
							* width
							/ getActivity().getWindowManager()
									.getDefaultDisplay().getWidth();
					dstTop = centerView.getTop()
							* height
							/ getActivity().getWindowManager()
									.getDefaultDisplay().getHeight();
					dstWidth = (centerView.getRight() - centerView
							.getLeft())
							* width
							/ getActivity().getWindowManager()
									.getDefaultDisplay().getWidth();
					dstHeight = (centerView.getBottom() - centerView
							.getTop())
							* height
							/ getActivity().getWindowManager()
									.getDefaultDisplay().getHeight();
					Bitmap b1 = ImageCrop(b, dstLeft, dstTop, dstWidth,
							dstHeight);
					// 轉灰階
					b1 = ImageUtil.toGrayscale(b1);
					imgView.setImageBitmap(b1);
					MultiFormatReader reader = new MultiFormatReader();
					try {
						int[] intArray = new int[b1.getWidth()
								* b1.getHeight()];
						// copy pixel data from the Bitmap into the
						// 'intArray' array
						b1.getPixels(intArray, 0, b1.getWidth(), 0, 0,
								b1.getWidth(), b1.getHeight());
						LuminanceSource source = new RGBLuminanceSource(b1
								.getWidth(), b1.getHeight(), intArray);
						BinaryBitmap bitmap = new BinaryBitmap(
								new HybridBinarizer(source));
						Result result = reader.decode(bitmap);
						final String strResult = result.getText();
						// showDialog(strResult);
						if (!strResult.equals("")) {
							//showDialog(strResult);
							CameraInterface.getInstance().doStopCamera();
							callCameraActivity(strResult);
							
						} else {
							showDialog("辨識失敗！！！");
							//debug
							//FileUtil.saveBitmap(b1);
						}
					} catch (Exception e) {
						showDialog("辨識失敗");
						//debug
						//FileUtil.saveBitmap(b1);
						e.printStackTrace();
					}
				}
    }
	private void initUI(View v) {
		page = 1;
		if (this.fragmentManager == null) {
			this.fragmentManager = getFragmentManager();
		}
		r = (RelativeLayout) v.findViewById(R.id.camera_r1);
		r1 = (RelativeLayout) v.findViewById(R.id.camera_r2);
		r2 = (FrameLayout) v.findViewById(R.id.camera_r3);
		imgView = (ImageView) v.findViewById(R.id.ImageView01);
		topView = (View) v.findViewById(R.id.topView);
		bottomView = (View) v.findViewById(R.id.bottomView);
		centerView = (View) v.findViewById(R.id.centerView);
		lb_So = (TextView) v.findViewById(R.id.lb_so);
		editSearch = (EditText) v.findViewById(R.id.editSearch);
		lb_Barcode = (TextView) v.findViewById(R.id.lb_barcode);
		editSearch.setOnTouchListener(new OnTouchListener() {
		    @Override
		    public boolean onTouch(View v, MotionEvent event) {
               if (event.getAction() == MotionEvent.ACTION_UP) {
		            
		        }
		        return false;
		    }
		});

		editSearch.setOnFocusChangeListener(new OnFocusChangeListener() {
		    @Override
		    public void onFocusChange(View v, boolean hasFocus) {
		        if (hasFocus) {
		        	
		         }
		    }
		});
		editSearch.setOnKeyListener(new OnKeyListener() {
		    public boolean onKey(View v, int keyCode, KeyEvent event) {
		   	if ((event.getAction() == 0) && (keyCode== 66))
				{
		          // Perform action on key press
		        	page=1;		
		        	soItems.clear();
			    	queryData(WHAT_DID_LOAD_DATA);
		        // return true;
		        }
		        return false;
		    }
		});
		surfaceView = (CameraSurfaceView) v
				.findViewById(R.id.camera_surfaceview2);
		btnReturn = (Button) v.findViewById(R.id.btn_return);
		btnReturn.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				if(parent!=null) {
					closeFragment();
				}
				else {
					((MainActivity) getActivity()).returnInventory(null);

				}
			}
		});
		lb_So.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				if (TabIndex != 0)
					TabIndex = 0;
				if (r2.getVisibility() == View.VISIBLE) {
					r2.setVisibility(View.GONE);
					CameraInterface.getInstance().previewCallback = null;
					CameraInterface.getInstance().doStopCamera();
				}
				if (r1.getVisibility() == View.GONE) {
					r1.setVisibility(View.VISIBLE);
					lb_So.setBackgroundColor(getActivity().getResources()
							.getColor(R.color.black));
					lb_So.setTextColor(getActivity().getResources().getColor(
							R.color.blue));
					lb_Barcode.setBackgroundColor(getActivity().getResources()
							.getColor(R.color.lightgray));
					lb_Barcode.setTextColor(getActivity().getResources()
							.getColor(R.color.white));
				}

				// 顯示輸入SO視窗
				showDialog();
			}

		});
		lb_Barcode.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				if (TabIndex != 1)
					TabIndex = 1;
				if (r1.getVisibility() == View.VISIBLE) {
					r1.setVisibility(View.GONE);
				}
				if (r2.getVisibility() == View.GONE) {
					r2.setVisibility(View.VISIBLE);
					lb_So.setTextColor(getActivity().getResources().getColor(
							R.color.white));
					lb_So.setBackgroundColor(getActivity().getResources()
							.getColor(R.color.lightgray));
					lb_Barcode.setBackgroundColor(getActivity().getResources()
							.getColor(R.color.black));
					lb_Barcode.setTextColor(getActivity().getResources()
							.getColor(R.color.blue));
					// 解決點選Barcode，無法即時預覽的問題
					CameraTask cameraTask = new CameraTask();
					cameraTask.execute((Void) null);
				}
				imgView.setImageBitmap(null);
			}

		});
		centerView.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				CameraInterface.getInstance()
						.doOneShotPreview(mPreviewCallback);
			}
		});
		// //CameraInterface.getInstance().doStopCamera();

		hideActionbar();
		initPullDownView(v);
	}

	private void initViewParams() {
		LayoutParams params = surfaceView.getLayoutParams();
		// LayoutParams params2 = r.getLayoutParams();
		LayoutParams params3 = centerView.getLayoutParams();
		LayoutParams params4 = topView.getLayoutParams();
		LayoutParams params5 = bottomView.getLayoutParams();
		Point p = DisplayUtil.getScreenMetrics(this.context);
		params.width = p.x;
		params.height = p.y;
		params4.height = ((params.height - DisplayUtil.dip2px(context, 120)) - params3.height) / 2;
		params5.height = params4.height;
		previewRate = params.height / params.width; // 默認全屏的比例預覽
		previewRate = DisplayUtil.getScreenRate(this.context);

	}

	private void initPullDownView(View view) {
		/*
		 * 1.使用PullDownView 2.設置OnPullDownListener 3.從mPullDownView里面獲取ListView
		 */

		mPullDownView = (PullDownView) view.findViewById(R.id.solistview);
		if (mPullDownView == null)
			return;
		mPullDownView.setOnPullDownListener(this);
		lstSo = mPullDownView.getListView();
		lstSo.setOnItemClickListener(this);
		/*
		 * ColorDrawable cd=new ColorDrawable(R.color.red);
		 * lstSales.setDivider(cd);
		 * lstSales.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
		 */
		lstSo.setDividerHeight(0);
		lstSo.setHeaderDividersEnabled(true);
		// adapter2 = new
		// SimpleAdapter(context,mStrings,R.layout.pulldown_item,new
		// String[]{"title","content"},new int[]
		// {R.id.msg_title2,R.id.msg_content} );
		soItems = new ArrayList<SoItem>();
		adapter2 = new SoListAdapter(context, soItems);
		lstSo.setAdapter(adapter2);
		mPullDownView.enableAutoFetchMore(true, 1);

	}

	// Function O
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

	}

	@Override
	public void onPause() {
		super.onPause();
		if (TabIndex == 1) {
			CameraInterface.getInstance().doStopCamera();
			// mTimer.cancel();
			// mTimer = new Timer();
		}
	}

	@Override
	public void onResume() {
		super.onResume();
		if (TabIndex == 1) {
			CameraTask cameraTask = new CameraTask();
			cameraTask.execute((Void) null);

		}

	}

	@Override
	public void onStart() {
		super.onStart();

	}

	@Override
	public void onStop() {
		super.onStop();
	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		SoItem item = soItems.get(position);
		callCameraActivity(item.getSoNo());

	}

	@Override
	public void onRefresh() {
		// TODO Auto-generated method stub
		new Thread(new Runnable() {
			@Override
			public void run() {
				queryData(WHAT_DID_REFRESH);

			}
		}).start();
	}

	@Override
	public void onMore() {
		// TODO Auto-generated method stub
		new Thread(new Runnable() {
			@Override
			public void run() {
				// String result="";
				page += 1;
				queryData(WHAT_DID_MORE);
			}
		}).start();

	}

	// R
	public Bitmap renderCroppedGreyscaleBitmap(byte[] yuvData, int dataWidth,
			int dataHeight, int left, int top, int width, int height) {
		// int width = getWidth();
		// int height = getHeight();
		byte[] yuv = yuvData;
		int[] pixels = new int[width * height];
		int inputOffset = top * dataWidth + left;
		for (int y = 0; y < height; y++) {
			int outputOffset = y * width;
			for (int x = 0; x < width; x++) {
				int grey = yuv[inputOffset + x] & 0xff;
				pixels[outputOffset + x] = 0xFF000000 | (grey * 0x00010101);
			}
			inputOffset += dataWidth;
		}

		Bitmap bitmap = Bitmap.createBitmap(width, height,
				Bitmap.Config.RGB_565);
		bitmap.setPixels(pixels, 0, width, 0, 0, width, height);
		return bitmap;
	}

	// Q
	public void queryData(int Message) {
		String json = "";
		// String url="http://59.125.146.7:8080/APQPService/queryPreShinpping";
		String url = super.getWebServiceUrl() + "queryPreShinpping";
		JSONObject jsonObject = new JSONObject();
		JSONObject data = new JSONObject();
		try {
			data.accumulate("SONO", editSearch.getText().toString());
			jsonObject.accumulate("userid", this.getLoginUser());
			jsonObject.accumulate("WWID",
					"13145774WWGlobal999988shippingquery999");
			jsonObject.accumulate("data", data);
			jsonObject.accumulate("page", page);
			super.postRequest(url, jsonObject, Message);

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// S
	private void setSoItems(JSONObject jsonObject) {
		try {
			JSONArray array = jsonObject.getJSONArray("data");
			if (array.length() > 0) {
				for (int i = 0; i < array.length(); i++) {
					JSONObject obj;
					obj = array.getJSONObject(i);
					soItems.add(new SoItem(obj.getString("SP01"), obj
							.getString("SP02"), obj.getString("SP03"), obj
							.getString("SP04"), obj.getString("SP05"), obj
							.getString("SP06"), obj.getString("SP07"), obj
							.getString("SP08"), obj.getString("SP09"), obj
							.getString("SP10"), obj.getString("SP11")));
				}
				adapter2.notifyDataSetChanged();
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void showDialog() {
		final EditText input = new EditText(context);
		new AlertDialog.Builder(context)
				.setTitle("輸入")
				.setMessage("請輸入SO")
				.setView(input)
				.setPositiveButton("OK", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int whichButton) {
						// 在此處理 input
						if (!input.getText().toString().equals("")) {
							callCameraActivity(input.getText().toString());
						}
						dialog.dismiss();
					}
				})
				.setNegativeButton("Cancel",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog,
									int whichButton) {
								dialog.dismiss();
							}
						}).show();
	}

}
