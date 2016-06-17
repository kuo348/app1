package com.winway.wwapp2;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class OrderInfoActivity extends BaseFragment {
	private Context context;
	private Button btnReturnSale;
	private ImageView imgWIP;
	private TextView wip_title;
	private OnClickListener onWIPClick = new OnClickListener() {
		public void onClick(View v) {
			callWIPActivity();
		}
	};

	// C
	private void callWIPActivity() {
		if (this.fragmentManager == null) {
			this.fragmentManager = getFragmentManager();
		}
		WIPListActivity activity = new WIPListActivity();
		activity.parent = this;
		activity.fragmentManager = getFragmentManager();
		Fragment fragment = activity;
		fragment.setRetainInstance(true);
		activity.setParent(this);
		if (this.fragmentManager.findFragmentByTag("wiplist") != null) {
			this.fragmentManager.beginTransaction()
					.remove(this.fragmentManager.findFragmentByTag("wiplist"))
					.commit();
		}
		this.fragmentManager.beginTransaction()
				.add(R.id.content_frame, fragment, "wiplist").commit();
		this.fragmentManager.beginTransaction().hide(this).commit();
		this.fragmentManager.beginTransaction().show(fragment).commit();

	}

	private void closeFragment() {
		if (this.parent != null) {
			this.fragmentManager.beginTransaction().remove(this).commit();
			this.fragmentManager.beginTransaction().show(this.parent).commit();
		}
		else{
			((MainActivity) getActivity()).returnSale(null);			
		}
	}

	// H
	public void hideActionbar() {
		ActionBar mActionBar = getActivity().getActionBar();
		if (mActionBar.isShowing())
			mActionBar.hide();
	}

	// I
	private View initView(LayoutInflater inflater, ViewGroup container) {
		View view = inflater.inflate(R.layout.actorderinfo, container, false);
		context = view.getContext();
		initUI(view);
		return view;

	}

	private void initUI(View v) {
		btnReturnSale = (Button) v.findViewById(R.id.btnReturnSale);
		imgWIP = (ImageView) v.findViewById(R.id.imgWIP);
		wip_title = (TextView) v.findViewById(R.id.wip_title);
		btnReturnSale.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				closeFragment();
			}
		});
		imgWIP.setOnClickListener(onWIPClick);
		wip_title.setOnClickListener(onWIPClick);
	}

	// O
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

}
