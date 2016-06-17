package com.winway.wwapp2;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.winway.camera.FileUtil;
import com.winway.wwapp2.BaseFragment.ImageUploaderTask;
import com.winway.wwapp2.PullDownView.OnPullDownListener;

import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Fragment;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import java.util.Calendar;

public class AlbumListActivity extends BaseFragment implements
		OnItemClickListener {
	private Context context;
	private Button btn_back;
	private ImageButton btn_upload;
	private ImageButton btn_delall;
	private ImageButton btn_preshipping;
	private AlbumListAdapter adapter;
	private ArrayList<AlbumItem> albumItems;
	private ListView lstAlbum;
	private RelativeLayout r1;
	// private PullDownView mPullDownView;
	private String mediaPath;
	private boolean isUploading;
	private boolean isDeleting;
	protected static final int REFRESH_DATA = 0x00000002;
	protected static final int WHAT_DID_LOAD_DATA = 0;
	protected static final int WHAT_DID_REFRESH = 1;
	protected static final int WHAT_DID_REMOVE = 3;
	protected static final int WHAT_DID_MORE = 5;
	protected static final int WHAT_USER_CALLBACK = 6;
	private Handler mHandler = new Handler() {

		@Override
		public void handleMessage(android.os.Message msg) {
			if (msg.what == 1001) {
				int rs = Integer.valueOf((String) msg.obj);
				Toast.makeText(context, rs, Toast.LENGTH_SHORT).show();
			}
			else if (msg.what == WHAT_DID_REFRESH) {
				adapter.notifyDataSetChanged();
				reloadAlbum();
			}
			else if(msg.what==WHAT_DID_REMOVE)
			{
				int rs = Integer.valueOf((String) msg.obj);
				removeAtAlbum(rs);
				//albumItems.remove(rs);
				adapter.notifyDataSetChanged();
				isDeleting=false;

			}
		};
	};

	// C
	private void closeFragment() {
		if (this.parent != null) {
			this.fragmentManager.beginTransaction().remove(this).commit();
			this.fragmentManager.beginTransaction().show(this.parent).commit();
			showActionbar();
		}
	}

	private void callCameraActivity(String so) {
		CameraActivity activity = new CameraActivity();
		Bundle bundle = new Bundle();
		bundle.putString("so", so);
		activity.parent = this;
		activity.fragmentManager = getFragmentManager();
		Fragment fragment = activity;
		fragment.setArguments(bundle);
		fragment.setRetainInstance(true);
		activity.setParent(this);
		if (this.fragmentManager.findFragmentByTag("camera") != null) {
			this.fragmentManager.beginTransaction()
					.remove(this.fragmentManager.findFragmentByTag("camera"))
					.commit();
		}
		this.fragmentManager.beginTransaction()
				.add(R.id.content_frame, fragment, "camera").commit();
		this.fragmentManager.beginTransaction().hide(this).commit();
		hideActionbar();
		this.fragmentManager.beginTransaction().show(fragment).commit();
	}

	private void callPreShippingActivity() {
		PreShippingActivity activity = new PreShippingActivity();
		activity.parent = this;
		activity.fragmentManager = getFragmentManager();
		Fragment fragment = activity;
		fragment.setRetainInstance(true);
		activity.setParent(this);
		if (this.fragmentManager.findFragmentByTag("preshipping") != null) {
			this.fragmentManager
					.beginTransaction()
					.remove(this.fragmentManager
							.findFragmentByTag("preshipping")).commit();
		}
		this.fragmentManager.beginTransaction()
				.add(R.id.content_frame, fragment, "preshipping").commit();
		this.fragmentManager.beginTransaction().hide(this).commit();
		hideActionbar();
		this.fragmentManager.beginTransaction().show(fragment).commit();

	}

	// H
	public void hideActionbar() {
		ActionBar mActionBar = getActivity().getActionBar();
		if (mActionBar.isShowing())
			mActionBar.hide();

	}

	// I
	private View initView(LayoutInflater inflater, ViewGroup container) {
		View view = inflater.inflate(R.layout.actalbumlist, container, false);
		context = view.getContext();
		hideActionbar();
		initUI(view);
		return view;
	}

	private void initPullDownView(View view) {
		lstAlbum = (ListView) view.findViewById(R.id.albumlistview);
		lstAlbum.setOnItemClickListener(this);
		lstAlbum.setDividerHeight(0);
		lstAlbum.setHeaderDividersEnabled(true);
		albumItems = new ArrayList<AlbumItem>();
		adapter = new AlbumListAdapter(context, albumItems);
		adapter.onShutterClickListener = new OnClickListener() {
			@Override
			public void onClick(View v) {
				String pos = String.valueOf(v.getTag());
				String so = albumItems.get(Integer.valueOf(pos)).getName();
				callCameraActivity(so);
			}
		};
		adapter.onDeleteClickListener = new OnClickListener() {
			@Override
			public void onClick(View v) {
				final String pos = String.valueOf(v.getTag());
				new AlertDialog.Builder(getActivity())
						.setTitle("Confirm")
						.setMessage("Do you really want to delete?")
						.setIcon(android.R.drawable.ic_dialog_alert)
						.setPositiveButton(android.R.string.yes,
								new DialogInterface.OnClickListener() {
									public void onClick(DialogInterface dialog,
											int whichButton) {
										Message msg = mHandler.obtainMessage(WHAT_DID_REMOVE);
										msg.obj =String.valueOf(pos);
										msg.sendToTarget();
										//removeAtAlbum(Integer.valueOf(pos));
										//albumItems.remove(pos);
										//adapter.notifyDataSetChanged();
									}
								}).setNegativeButton(android.R.string.no, null)
						.show();

			}
		};
		adapter.onUploadClickListener = new OnClickListener() {
			@Override
			public void onClick(View v) {
				String pos = String.valueOf(v.getTag());
				String so = albumItems.get(Integer.valueOf(pos)).getName();
				uploadFiles(Integer.valueOf(pos), so);
			}
		};
		lstAlbum.setAdapter(adapter);
	}

	private void initUI(View v) {
		hideActionbar();
		btn_back = (Button) v.findViewById(R.id.btn_albumlist_back);
		btn_upload = (ImageButton) v.findViewById(R.id.btn_upload);
		btn_delall = (ImageButton) v.findViewById(R.id.btn_delall);
		btn_preshipping = (ImageButton) v.findViewById(R.id.btn_preshipping);
		r1 = (RelativeLayout) v.findViewById(R.id.album_actionbar2);
		btn_back.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				if(parent!=null) {
					closeFragment();
				}
				else{
					((MainActivity)getActivity()).returnInventory(null);
				}
			}
		});
		btn_upload.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				new Thread() {
					@Override
					public void run() {
						try {
							for (int i = adapter.getCount() - 1; i >= 0; i--) {
								AlbumItem item = (AlbumItem) adapter.getItem(i);
								isUploading = true;
								uploadFiles(i, item.getName());
								while (isUploading) {
									Thread.sleep(1000);
								}
							}
							getActivity().runOnUiThread(new Runnable() {
								public void run() {
									reloadAlbum();
								}
							});
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					}
				}.start();
			}
		});
		btn_delall.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				new AlertDialog.Builder(getActivity())
						.setTitle("Confirm")
						.setMessage("Do you really want to delete all album?")
						.setIcon(android.R.drawable.ic_dialog_alert)
						.setPositiveButton(android.R.string.yes,
								new DialogInterface.OnClickListener() {
									public void onClick(DialogInterface dialog,
											int whichButton) {
										new Thread() {
											@Override
											public void run() {
												try {
													for (int i = adapter
															.getCount() - 1; i >= 0; i--) {
														isDeleting = true;
														Message msg = mHandler.obtainMessage(WHAT_DID_REMOVE);
														msg.obj =String.valueOf(i);
														msg.sendToTarget();

														while (isDeleting) {
															Thread.sleep(1000);
														}
													}
													/*getActivity().runOnUiThread(new Runnable() {
																		public void run() {
																			reloadAlbum();
																		}
																	});*/
													Message msg = mHandler.obtainMessage(WHAT_DID_REFRESH);
													msg.obj ="";
													msg.sendToTarget();
												} catch (Exception e) {
													// TODO Auto-generated catch
													// block
													e.printStackTrace();
												}

											}
										}.start();

									}
								}).setNegativeButton(android.R.string.no, null)
						.show();

			}
		});
		btn_preshipping.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				callPreShippingActivity();
			}
		});
		mediaPath = FileUtil.getMidaPath();
		initPullDownView(v);

		// mPullDownView.notifyDidLoad();
	}

	// L

	// O
	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		/*
		 * if(r1.getVisibility()==View.GONE){
		 * 
		 * }
		 */
		Toast.makeText(
				context,
				"left:"
						+ view.getLeft()
						+ ",top:"
						+ String.valueOf(view.getTop() + (position + 1)
								* view.getHeight()), Toast.LENGTH_SHORT).show();
	}

	/*
	 * @Override public void onRefresh() {
	 * 
	 * }
	 * 
	 * @Override public void onMore() {
	 * 
	 * 
	 * }
	 */

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
		// sm.unregisterListener(listener);
	}

	@Override
	public void onPause() {
		super.onPause();
	}

	@Override
	public void onResume() {
		super.onResume();
		hideActionbar();
		albumItems.clear();
		setAlbumItems();
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

	// U
	public void uploadFiles(final int index, final String so) {
		final boolean confirmStatus = false;
		final String filePath = FileUtil.getMidaPath() + "/" + so;
		final List<String> flist = FileUtil.getAlbumImageList(filePath);
		if (flist.size() == 0)
			return;
		String title = so;
		String[] tmp = so.split("_");
		if (tmp.length == 2) {
			title = tmp[1];
		}
		final String prjName = title;

		new Thread() {
			@Override
			public void run() {
				showProgressDialog(flist.size());
			}
		}.start();
		new Thread() {
			@Override
			public void run() {
				try {
					List<String> flist2 = FileUtil.getAlbumImageList(filePath);

					for (int i = 0; i < flist2.size(); i++) {

						final int pos = i;
						final String fileName = flist2.get(pos).toString();
						// new Thread() {
						// @Override
						// public void run() {
						SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddd");
						Date currentDate = new Date(System.currentTimeMillis());
						ImageUploaderTask uploader = new ImageUploaderTask();
						HashMap<String, String> datas = new HashMap<String, String>();
						datas.put("userid", getLoginUser());
						datas.put("SONO", prjName);
						datas.put("WWID", "13145774WWGlobalshippingfiles999");
						datas.put(
								"fileName",
								String.format("%s%02d-",
										sdf.format(currentDate), i + 1)
										+ fileName);
						HashMap<String, String> files = new HashMap<String, String>();
						files.put("files" + String.valueOf(pos + 1), filePath
								+ "/" + fileName);
						isUploadFile = true;
						uploader.execute(getActivity().getResources()
								.getString(R.string.uploadFileUrl2), datas,
								files);
						// }
						// }.start();
						updateProgressDialog((i * 100) / flist2.size());
						while (isUploadFile) {
							Thread.sleep(1000);
						}

					}
					hideProgressDialog();
					getActivity().runOnUiThread(new Runnable() {
						@Override
						public void run() {
							if (!confirmStatus) {
								showConfirmDeleteDialog(
								"Do you want to delete files??",
										new DialogInterface.OnClickListener() {
											public void onClick(
													DialogInterface dialog,
													int id) {
												//removeAtAlbum(index);
												Message msg = mHandler.obtainMessage(WHAT_DID_REMOVE);
												msg.obj =String.valueOf(index);
												msg.sendToTarget();
												isUploading = false;
											}
										},
										new DialogInterface.OnClickListener() {
											public void onClick(
													DialogInterface dialog,
													int id) {
												isUploading = false;
											}
										});
							}
							else {
								//removeAtAlbum(index);
								isUploading = false;
								Message msg = mHandler.obtainMessage(WHAT_DID_REMOVE);
								msg.obj =index;
								msg.sendToTarget();
							}
						}
					});

				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}.start();
		// this.hideProgressDialog();

	}

	// Function S
	public void showActionbar() {
		ActionBar mActionBar = getActivity().getActionBar();
		if (mActionBar.isShowing() == false)
			mActionBar.show();

	}

	private void setAlbumItems() {

		List<String> list = FileUtil.getAlbumList(mediaPath);
		String so = "";
		for (int i = 0; i < list.size(); i++) {
			so = list.get(i);
			albumItems.add(new AlbumItem(so, mediaPath + "/" + so));

			// albumItems.add(new AlbumItem(so,mediaPath+"/"+so));

		}
		adapter.notifyDataSetChanged();

	}

	// R
	public void reloadAlbum() {
		albumItems.clear();
		setAlbumItems();

	}

	private void removeAtAlbum(int pos) {
		final String so = albumItems.get(Integer.valueOf(pos)).getName();
		albumItems.remove(pos);
		new Thread() {
			public void run() {
				FileUtil.removeAblum(so);
				isDeleting = false;


			}
		}.start();

		// adapter.notifyDataSetChanged();

	}

}
