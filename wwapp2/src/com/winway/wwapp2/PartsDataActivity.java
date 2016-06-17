package com.winway.wwapp2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.winway.widget.WWTextView;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.AlertDialog;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.text.ClipboardManager;

public class PartsDataActivity extends BaseFragment {
	private TextView lb_partno, lb_qty, lb_unit, lb_instock, lb_material;
	private TextView lb_cancel;
	private EditText lb_partname, lb_spec;
	private Context context;
	private Bundle bundle;

	// Function C
	private void closeFragment() {
		if (this.parent != null) {
			this.fragmentManager.beginTransaction().remove(this).commit();
			this.fragmentManager.beginTransaction().show(this.parent).commit();
		}

	}

	public void callStockActivity(String content) {
		StockActivity activity = new StockActivity();
		activity.parent = this;
		if (this.fragmentManager == null) {
			this.fragmentManager = getFragmentManager();
		}
		activity.fragmentManager = this.fragmentManager;
		Bundle b = new Bundle();
		b.putInt("frg_id", this.getId());
		b.putString("ima01", content);
		activity.setArguments(b);
		activity.setParent(this);
		if (this.fragmentManager.findFragmentById(activity.getId()) == null) {
			this.fragmentManager.beginTransaction()
					.add(R.id.content_frame, activity, "stockdata").commit();
		}
		this.fragmentManager.beginTransaction().hide(this).commit();
		this.fragmentManager.beginTransaction().show(activity).commit();

	}
	public void callProjectFindActivity(String content) {
		ProjectFindActivity activity = new ProjectFindActivity();
		activity.setParent(this);
		if (this.fragmentManager == null) {
			this.fragmentManager = getFragmentManager();
		}
		activity.fragmentManager = this.fragmentManager;
		Bundle b = new Bundle();
		b.putInt("frg_id", this.getId());
		b.putString("ima01", content);
		b.putString("return_title","");
		activity.setArguments(b);
		activity.setParent(this);
		if (this.fragmentManager.findFragmentById(activity.getId()) == null) {
			this.fragmentManager.beginTransaction()
					.add(R.id.content_frame, activity, "stockdata").commit();
		}
		this.fragmentManager.beginTransaction().hide(this).commit();
		this.fragmentManager.beginTransaction().show(activity).commit();

	}
	// Function L
	@Override
	public void loadData(Object result) {

		try {
			JSONObject jsonObject = new JSONObject((String) result);
			if (jsonObject.getString("success").equals("true")
					&& jsonObject.getJSONArray("data") != null) {
				JSONArray data = jsonObject.getJSONArray("data");
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Function I
	private View initView(LayoutInflater inflater, ViewGroup container) {
		View view = inflater.inflate(R.layout.actpartsdata, container, false);
		context = view.getContext();
		initUI(view);
		// queryData();
		return view;
	}

	private void initUI(View v) {
		bundle = this.getArguments();
		lb_partno = (TextView) v.findViewById(R.id.lb_partno);
		lb_partname = (EditText) v.findViewById(R.id.lb_partname);
		lb_material = (TextView) v.findViewById(R.id.lb_material);
		lb_spec = (EditText) v.findViewById(R.id.lb_spec);
		lb_unit = (TextView) v.findViewById(R.id.lb_unit);
		lb_qty = (TextView) v.findViewById(R.id.lb_qty);
		lb_instock = (TextView) v.findViewById(R.id.lb_instock);
		lb_cancel = (TextView) v.findViewById(R.id.lb_parts_cancel);

		lb_partno.setText(bundle.getString("partno"));
		lb_partname.setText(bundle.getString("partname").toString());
		lb_spec.setText(bundle.getString("spec"));
		lb_material.setText(bundle.getString("material"));
		lb_unit.setText(bundle.getString("unit"));
		lb_qty.setText(bundle.getString("qty"));
		lb_instock.setText(bundle.getString("instock"));
		lb_cancel.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				closeFragment();
			}

		});
		lb_partno.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				ClipboardManager cm = (ClipboardManager) context
						.getSystemService(Context.CLIPBOARD_SERVICE);
				cm.setText(lb_partno.getText());
				Toast.makeText(context, "Copied to clipboard",
						Toast.LENGTH_SHORT).show();
			}
		});
		lb_partno.setOnLongClickListener(new OnLongClickListener() {
			@Override
			public boolean onLongClick(View v) {
				TextView view = (TextView) v;

				/*try {
					String part = view.getText().toString().replace("(替)", "")
							.trim();
					callStockActivity(part);
				} catch (Exception ex) {

				}*/
				showActionDialg();
				return false;
			}
		});
	}

	// Function O
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return initView(inflater, container);
	}

	// Function Q
	public void queryData() {

	}
	//Function S
	protected void showActionDialg()
	{
		String actions[]={"Copy","Stock Query","Project Search"};
		AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity());
		dialog.setTitle("Action").setIcon(
				android.R.drawable.ic_dialog_info);
		DialogInterface.OnClickListener okListener = new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface d, int which) {
				ListView lv = ((AlertDialog) d).getListView();
				Integer selected =0;
				if(lv.getTag()!=null&&lv.getTag().toString().equals("")==false)
				selected = Integer.parseInt(lv.getTag().toString());
				if(selected==1){
					String part=lb_partno.getText().toString();
					callStockActivity(part.replace("(替)", "").trim());
				}
				else if(selected==2){
					String part=lb_partno.getText().toString();
					callProjectFindActivity(part.replace("(替)", "").trim());
				}
				else {
					ClipboardManager cm = (ClipboardManager) context
							.getSystemService(Context.CLIPBOARD_SERVICE);
					cm.setText(lb_partno.getText());
					Toast.makeText(context, "Copied to clipboard",
							Toast.LENGTH_SHORT).show();
					
				}
				d.dismiss();
				d = null;
			}
		};
		DialogInterface.OnClickListener cancelListener = new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface d, int which) {				
				d.dismiss();
				d = null;
			}
		};
	dialog.setSingleChoiceItems(actions, 0,
				new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface d, int which) {
						ListView lv = ((AlertDialog) d).getListView();
						lv.setTag(String.valueOf(which));
					}
				});
		dialog.setPositiveButton("Ok", okListener);
		dialog.setNegativeButton("Cancel", cancelListener);
		dialog.show();
		
	}
}
