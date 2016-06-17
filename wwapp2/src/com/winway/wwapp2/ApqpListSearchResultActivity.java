package com.winway.wwapp2;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ApqpListSearchResultActivity extends BaseFragment implements
		PullDownView.OnPullDownListener, AdapterView.OnItemClickListener {
	protected static final int REFRESH_DATA = 2;
	private static final int WHAT_DID_LOAD_DATA = 0;
	private static final int WHAT_DID_MORE = 5;
	private static final int WHAT_DID_REFRESH = 1;
	private int ACTION_MESSAGE;
	private ApqpListAdapter adapter2;
	private ArrayList<ApqpItem> apqpItems;
	private Button btnReturnApqpSearch;
	private Bundle bundle;
	private Context context;
	private ListView lstApqp;
	private PullDownView mPullDownView;
	private List<Map<String, String>> mStrings = new ArrayList();
	private TypedArray navMenuIcons;
	private TypedArray navMenuIcons2;
	private int page = 1;

	private void closeFragment() {

		this.fragmentManager = getFragmentManager();
		this.fragmentManager.beginTransaction().remove(this).commit();
		this.fragmentManager.popBackStack();
		this.fragmentManager.beginTransaction().show(this.parent).commit();
	}

	private void hideFragment() {

		this.fragmentManager = getFragmentManager();
		this.fragmentManager.beginTransaction().hide(this).commit();
	}

	private void initPullDownView(View view) {

		this.mPullDownView = ((PullDownView) view
				.findViewById(R.id.apqplistview));
		mPullDownView.setOnPullDownListener(this);
		lstApqp = mPullDownView.getListView();
		lstApqp.setOnItemClickListener(this);
		ColorDrawable cd = new ColorDrawable(R.color.list_divider);
		lstApqp.setDivider(cd);
		lstApqp.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
		lstApqp.setDividerHeight(1);
		lstApqp.setHeaderDividersEnabled(true);
		// adapter2 = new
		// SimpleAdapter(context,mStrings,R.layout.pulldown_item,new
		// String[]{"title","content"},new int[]
		// {R.id.msg_title2,R.id.msg_content} );
		apqpItems = new ArrayList<ApqpItem>();
		adapter2 = new ApqpListAdapter(context, apqpItems);
		lstApqp.setAdapter(adapter2);
		mPullDownView.enableAutoFetchMore(true, 1);
	}

	private View initView(LayoutInflater layoutInflater, ViewGroup viewGroup) {

		View view = layoutInflater.inflate(R.layout.actapqplist_search_result,
				viewGroup, false);
		this.context = view.getContext();
		this.bundle = getArguments();
		initPullDownView(view);
		this.btnReturnApqpSearch = ((Button) view
				.findViewById(R.id.btnReturnApqpSearch));
		this.btnReturnApqpSearch.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {

				// 回到Apqp搜尋主畫面
				closeFragment();
			}
		});
		this.ACTION_MESSAGE = 0;
		this.page = 1;
		queryData(0);
		return view;
	}

	private void queryData(int Message) {

		String url = super.getWebServiceUrl() + "queryAPQP";
		JSONObject jsonObject = new JSONObject();
		JSONObject data = new JSONObject();
		try {
			if (this.bundle == null || this.bundle.size() == 0) {
				data.accumulate("apqpno", "");
				data.accumulate("customer", "");
			} else {
				Iterator iterator = this.bundle.keySet().iterator();
				while (iterator.hasNext()) {
					String key = (String) iterator.next();
					data.accumulate(key, this.bundle.get(key));
				}
				jsonObject.accumulate("userid", super.getLoginUser());
				jsonObject.accumulate("WWID",
						"13145774WWGlobal999988apqpquery999");
				jsonObject.accumulate("data", data);
				jsonObject.accumulate("page", Integer.toString(this.page));

			}
			super.postRequest(url, jsonObject, Message);

		} catch (JSONException jsonException) {
			jsonException.printStackTrace();
		}
	}

	private void setApqpItems(JSONObject object) throws JSONException {

		JSONArray array = object.getJSONArray("data");
		navMenuIcons = getResources().obtainTypedArray(R.array.qpqp_list_icons);
		int icon;
		String apqpno,status;
		// 如果回傳資料大於零，而且頁數仍是1，則清空舊資料
		if (array.length() > 0 && page == 1) {
			apqpItems.clear();
		}
		// msgItems = new ArrayList<MsgItem>();
		for (int i = 0; i < array.length(); i++) {
			JSONObject jsonObject = array.getJSONObject(i);
			 apqpno = String.format("%s-%s",
					jsonObject.getString("xa001"),
					jsonObject.getString("xa002"));
			if (jsonObject.getString("xa068").equals("Y"))
				icon = navMenuIcons.getResourceId(0, -1);
			else
				icon = navMenuIcons.getResourceId(1, -1);
			 status=jsonObject.getString("status");
			apqpItems.add(new ApqpItem(apqpno,
					jsonObject.getString("customer"), icon,jsonObject.getString("status"),jsonObject.getString("xa593")));
		}
		// Recycle the typed array
		navMenuIcons.recycle();
	}

	public View onCreateView(LayoutInflater paramLayoutInflater,
			ViewGroup paramViewGroup, Bundle paramBundle) {

		return initView(paramLayoutInflater, paramViewGroup);
	}

	public void onItemClick(AdapterView<?> paramAdapterView, View paramView,
			int paramInt, long paramLong) {

		ApqpItem apqpItem = (ApqpItem) this.apqpItems.get(paramInt);
		Bundle bundle = new Bundle();
		bundle.putString("apqpno", apqpItem.getApqpNo());
		//((MainActivity) getActivity()).callApqpDataActivity(bundle);
		showApqpDataDialog(bundle);
	}
   private void showApqpDataDialog(Bundle b)
   {
	   ApqpDataActivity activity=new ApqpDataActivity();
	   if(this.fragmentManager==null)
	   {
		   this.fragmentManager=getFragmentManager();
	   }
	   activity.parent=this;
	   activity.fragmentManager=this.fragmentManager;
	   activity.setArguments(b);
	   Fragment f=activity;
	   fragmentManager.beginTransaction()
		.add(R.id.content_frame, f, "apqpdata2").commit();
        fragmentManager.beginTransaction()
						.hide(this).commit();
		fragmentManager.beginTransaction().show(f).commit();
	   
   }
	@Override
	public void loadData(Object obj) {

		try {
			setApqpItems(new JSONObject((String) obj));
			if (apqpItems.size() == 0 && page > 1)
				page--;
			adapter2.notifyDataSetChanged();
			mPullDownView.notifyDidLoad();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 載入更多資料
	@Override
	public void loadMoreData(Object obj) {

		try {
			setApqpItems(new JSONObject((String) obj));
			if (apqpItems.size() == 0 && page > 1)
				page--;
			adapter2.notifyDataSetChanged();
			mPullDownView.notifyDidMore();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 更新為最新資料
	@Override
	public void loadRefreshData(Object obj) {
		try {
			setApqpItems(new JSONObject((String) obj));
			if (apqpItems.size() == 0 && page > 1)
				page--;
			adapter2.notifyDataSetChanged();
			mPullDownView.notifyDidRefresh();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onRefresh() {
		// TODO Auto-generated method stub
		new Thread(new Runnable() {
			@Override
			public void run() {
				String result = "";
				ACTION_MESSAGE = WHAT_DID_REFRESH;
				queryData(ACTION_MESSAGE);

			}
		}).start();
	}

	@Override
	public void onMore() {
		// TODO Auto-generated method stub
		new Thread(new Runnable() {

			@Override
			public void run() {

				String result = "";
				page += 1;
				ACTION_MESSAGE = WHAT_DID_MORE;
				queryData(ACTION_MESSAGE);

			}
		}).start();
	}

	public void setTitle(CharSequence paramCharSequence) {

		getActivity().getActionBar().setTitle(paramCharSequence);
	}

	public void showActionbar() {

		ActionBar actionBar = getActivity().getActionBar();
		if (actionBar != null && (!actionBar.isShowing()))
			actionBar.show();
	}

	public void showSearchResult(String result) {

		try {
			setApqpItems(new JSONObject(result));
		} catch (JSONException jsonException) {
			jsonException.printStackTrace();
		}
	}
}