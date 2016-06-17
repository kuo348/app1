package com.winway.wwapp2;

import android.app.ActionBar;
import android.app.Activity;
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

public class FaeListSearchResultActivity extends BaseFragment
  implements PullDownView.OnPullDownListener, AdapterView.OnItemClickListener
{
  protected static final int REFRESH_DATA = 2;
  private static final int WHAT_DID_LOAD_DATA = 0;
  private static final int WHAT_DID_MORE = 5;
  private static final int WHAT_DID_REFRESH = 1;
  private int ACTION_MESSAGE;
  private FaeListAdapter adapter2;
  private ArrayList<FaeItem> faeItems;
  private Button btnReturnFaeSearch;
  private Bundle bundle;
  private Context context;
  private ListView lstFae;
  private PullDownView mPullDownView;
  private List<Map<String, String>> mStrings = new ArrayList();
  private TypedArray navMenuIcons;
  private TypedArray navMenuIcons2;
  private int page = 1;

  private void closeFragment()
  {
    this.fragmentManager = getFragmentManager();
    this.fragmentManager.beginTransaction().remove(this).commit();
    this.fragmentManager.popBackStack();
    this.fragmentManager.beginTransaction().show(this.parent).commit();
  }

  private void hideFragment()
  {
   this.fragmentManager= getFragmentManager();
   this.fragmentManager.beginTransaction().hide(this).commit();
  }

  private void initPullDownView(View view)
  {
    this.mPullDownView = ((PullDownView)view.findViewById(R.id.faelistview));
      this.mPullDownView.setOnPullDownListener(this);
      this.lstFae = this.mPullDownView.getListView();
      this.lstFae.setOnItemClickListener(this);
      ColorDrawable localColorDrawable = new ColorDrawable(R.color.list_divider);
      this.lstFae.setDivider(localColorDrawable);
      this.lstFae.setChoiceMode(1);
      this.lstFae.setDividerHeight(1);
      this.lstFae.setHeaderDividersEnabled(true);
      this.faeItems =new ArrayList<FaeItem>();
      this.adapter2 = new FaeListAdapter(this.context, this.faeItems);
      this.lstFae.setAdapter(this.adapter2);
      this.mPullDownView.enableAutoFetchMore(true, 1);
   
  }

  private View initView(LayoutInflater layoutInflater, ViewGroup container)
  {
    View view = layoutInflater.inflate(R.layout.actfaelist_search_result, container, false);
    this.context = view.getContext();
    this.bundle = getArguments();
    initPullDownView(view);
    this.btnReturnFaeSearch = ((Button)view.findViewById(R.id.btnReturnFaeSearch));
    this.btnReturnFaeSearch.setOnClickListener(new OnClickListener(){
    	@Override
    	public void onClick(View view)
    	{
    		//回到Fae搜尋主畫面
    		closeFragment();
    	}    	
    });
    this.ACTION_MESSAGE = WHAT_DID_LOAD_DATA;
    this.page = 1;
    queryData(this.ACTION_MESSAGE);
    return view;
  }

  private void queryData(int Message)
  {
    String url = super.getWebServiceUrl() + "queryFAE";
    JSONObject jsonObject = new JSONObject();
    JSONObject data = new JSONObject();
    try
    {
      if (this.bundle.size() == 0)
      {
       return ;
      }
      else
      {
    	  Iterator iterator = this.bundle.keySet().iterator();
          while (iterator.hasNext())
          {
            String key = (String)iterator.next();
            data.accumulate(key, this.bundle.get(key));
          }
    	  jsonObject .accumulate("userid", super.getLoginUser());
    	  jsonObject .accumulate("WWID", "13145774WWGlobal999988faequery999");
    	  jsonObject .accumulate("data",data);
    	  jsonObject .accumulate("page", Integer.toString(this.page));
       
      }
      super.postRequest(url,  jsonObject , Message);
        
    }
    catch (JSONException  e)
    {
    	 e.printStackTrace();
    }
  }

  private void setFaeItems(JSONObject  object) throws JSONException
	{
		JSONArray array=object.getJSONArray("data");
		navMenuIcons = getResources().obtainTypedArray(R.array.fae_list_icons);
		int icon;
		//如果回傳資料大於零，而且頁數仍是1，則清空舊資料
		if(array.length()>0&&page==1){
			faeItems.clear();
		}
		//msgItems = new ArrayList<MsgItem>();
		for(int i=0;i<array.length() ;i++){
			JSONObject jsonObject=array.getJSONObject(i);
			String fae001= jsonObject.getString("fae001");
			String fae006=(jsonObject.getString("fae006").length()>12) ?String.format("%s...",jsonObject.getString("fae006").substring(0,12)):jsonObject.getString("fae006"); 
			String fae012=(jsonObject.getString("fae012").length()>12) ?String.format("%s...",jsonObject.getString("fae012").substring(0,12)):jsonObject.getString("fae012"); 
			String fae022=(jsonObject.getString("fae022").length()>12) ? String.format("%s...",jsonObject.getString("fae022").substring(0,12)):jsonObject.getString("fae022"); 
     if(jsonObject.getString("fae029").equals("RB01")){
      	 icon=navMenuIcons.getResourceId(0, -1);	
     }
      else   if(jsonObject.getString("fae029").equals("RB02")){
          	 icon=navMenuIcons.getResourceId(1, -1);	               
		}
		else {
			 icon=navMenuIcons.getResourceId(2, -1);	               
			
		}
		faeItems.add(new FaeItem(fae001,fae006,fae012,fae022,icon));	
		}
		// Recycle the typed array
		navMenuIcons.recycle();		
	}
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle bundle)
  {
    return initView( inflater, container);
  }
  @Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		// TODO Auto-generated method stub
		 final FaeItem item= (FaeItem) faeItems.get(position);
		    Bundle bundle = new Bundle();
		//	bundle.putString("apqpno", item.getApqpNo());

    //  ((MainActivity) getActivity()).callApqpDataActivity(bundle);
    
		   
	}
  @Override
	public void loadData(Object obj)
	{
		try {   
  	    setFaeItems(new JSONObject((String)obj));
  		 if(faeItems.size()==0&&page>1)page--;
  		 adapter2.notifyDataSetChanged();
  		 mPullDownView.notifyDidLoad();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();	
		}		
	}
	@Override
	public void loadMoreData(Object obj){
		try {    	
  	    setFaeItems(new JSONObject((String)obj));
  		 if(faeItems.size()==0&&page>1)page--;
  		 adapter2.notifyDataSetChanged();
  			mPullDownView.notifyDidMore();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();		
		}	
	}
	@Override
	public void loadRefreshData(Object obj){
		try {    	
  	    setFaeItems(new JSONObject((String)obj));
  		 if(faeItems.size()==0&&page>1)page--;
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
				String result="";				
		        ACTION_MESSAGE=WHAT_DID_REFRESH;
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
				String result="";
				page+=1;
		        ACTION_MESSAGE=WHAT_DID_MORE;
			    queryData(ACTION_MESSAGE);
		      	     
				
			}
		}).start();		
	}	
  public void setTitle(CharSequence paramCharSequence)
  {
    getActivity().getActionBar().setTitle(paramCharSequence);
  }

  public void showActionbar()
  {
    ActionBar actionBar = getActivity().getActionBar();
    if (actionBar != null && (!actionBar.isShowing()))
      actionBar.show();
  }

  public void showSearchResult(String result)
  {
    try
    {
      setFaeItems(new JSONObject(result));
    }
    catch (JSONException e)
    {
    	 e.printStackTrace();
    }
  }
}