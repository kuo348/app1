package com.winway.wwapp2;

import android.app.ActionBar;
import android.app.Fragment;
import android.content.Context;
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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class QtListSearchResultActivity extends BaseFragment implements
		PullDownView.OnPullDownListener, OnItemClickListener {
	protected static final int REFRESH_DATA = 2;
	private static final int WHAT_DID_LOAD_DATA = 0;
	private static final int WHAT_DID_MORE = 5;
	private static final int WHAT_DID_REFRESH = 1;
	private int ACTION_MESSAGE;
	private QtListAdapter adapter2;
	private ArrayList<QtItem> qtItems;
	private Button btnReturnQtSearch;
	private Bundle bundle;
	private Context context;
	private ListView lstQt;
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
				.findViewById(R.id.qtlistview));
		mPullDownView.setOnPullDownListener(this);
		lstQt = mPullDownView.getListView();
		lstQt.setOnItemClickListener(this);
		ColorDrawable cd = new ColorDrawable(R.color.list_divider);
		lstQt.setDivider(cd);
		lstQt.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
		lstQt.setDividerHeight(1);
		lstQt.setHeaderDividersEnabled(true);
		// adapter2 = new
		// SimpleAdapter(context,mStrings,R.layout.pulldown_item,new
		// String[]{"title","content"},new int[]
		// {R.id.msg_title2,R.id.msg_content} );
		qtItems = new ArrayList<QtItem>();
		adapter2 = new QtListAdapter(context, qtItems);
		lstQt.setAdapter(adapter2);
		mPullDownView.enableAutoFetchMore(true, 1);
	}

	private View initView(LayoutInflater layoutInflater, ViewGroup viewGroup) {

		View view = layoutInflater.inflate(R.layout.actqtlist_search_result,
				viewGroup, false);
		this.context = view.getContext();
		this.bundle = getArguments();
		initPullDownView(view);
		this.btnReturnQtSearch = ((Button) view
				.findViewById(R.id.btnReturnQtSearch));
		this.btnReturnQtSearch.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {

				// 回到Qt搜尋主畫面
				closeFragment();
			}
		});
		this.ACTION_MESSAGE = 0;
		this.page = 1;
		queryData(0);
		return view;
	}

	private void queryData(int Message) {

		String url = super.getWebServiceUrl() + "queryQT";
		JSONObject jsonObject = new JSONObject();
		JSONObject data = new JSONObject();

		try {
			if (this.bundle == null || this.bundle.size() == 0) {
				data.accumulate("qtno", "");
				data.accumulate("customer", "");
			} else {
				Iterator iterator = this.bundle.keySet().iterator();
				while (iterator.hasNext()) {
					String key = (String) iterator.next();
					data.accumulate(key, this.bundle.get(key));
				}
				jsonObject.accumulate("userid", super.getLoginUser());
				jsonObject.accumulate("WWID",
						"13145774WWGlobal999988qtquery999");
				jsonObject.accumulate("data", data);
				jsonObject.accumulate("page", Integer.toString(this.page));

			}
			super.postRequest(url, jsonObject, Message);

		} catch (JSONException jsonException) {
			jsonException.printStackTrace();
		}
	}

	private void setQtItems(JSONObject object) throws JSONException {

		JSONArray array = object.getJSONArray("data");
		navMenuIcons = getResources().obtainTypedArray(R.array.qpqp_list_icons);
		int icon;
		String qtno;
		//String status;//20151112 不使用
		// 如果回傳資料大於零，而且頁數仍是1，則清空舊資料
		if (array.length() > 0 && page == 1) {
			qtItems.clear();
		}
		// msgItems = new ArrayList<MsgItem>();
		for (int i = 0; i < array.length(); i++) {
			JSONObject jsonObject = array.getJSONObject(i);
			 qtno = String.format("%s-%s",
					jsonObject.getString("xa001"),
					jsonObject.getString("xa002"));
			if (jsonObject.getString("xa068").equals("Y"))
				icon = navMenuIcons.getResourceId(0, -1);
			else
				icon = navMenuIcons.getResourceId(1, -1);
			//status=jsonObject.getString("status");
			qtItems.add(new QtItem(qtno,
					               jsonObject.getString("customer"),
					               icon
					              )
			           );
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

		QtItem qtItem = (QtItem) this.qtItems.get(paramInt);
		Bundle bundle = new Bundle();
		bundle.putString("qtno", qtItem.getQtNo());
		//((MainActivity) getActivity()).callQtDataActivity(bundle);
		showQtDataDialog(bundle);
	}
   private void showQtDataDialog(Bundle b)
   {
	   QtDataActivity activity=new QtDataActivity();
	   if(this.fragmentManager==null)
	   {
		   this.fragmentManager=getFragmentManager();
	   }
	   activity.parent=this;
	   activity.fragmentManager=this.fragmentManager;
	   activity.setArguments(b);
	   Fragment f=activity;
	   fragmentManager.beginTransaction()
		.add(R.id.content_frame, f, "qtdata2").commit();
        fragmentManager.beginTransaction()
						.hide(this).commit();
		fragmentManager.beginTransaction().show(f).commit();
	   
   }
	@Override
	public void loadData(Object obj) {

		try {
			setQtItems(new JSONObject((String) obj));
			if (qtItems.size() == 0 && page > 1)
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
			setQtItems(new JSONObject((String) obj));
			if (qtItems.size() == 0 && page > 1)
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
			setQtItems(new JSONObject((String) obj));
			if (qtItems.size() == 0 && page > 1)
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
			setQtItems(new JSONObject(result));
		} catch (JSONException jsonException) {
			jsonException.printStackTrace();
		}
	}
}