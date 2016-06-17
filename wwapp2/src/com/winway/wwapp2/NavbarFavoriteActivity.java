package com.winway.wwapp2;import java.io.BufferedReader;import java.io.IOException;import java.io.InputStream;import java.io.InputStreamReader;import java.util.ArrayList;import org.apache.http.HttpResponse;import org.apache.http.client.HttpClient;import org.apache.http.client.methods.HttpGet;import org.apache.http.impl.client.DefaultHttpClient;import org.json.JSONArray;import org.json.JSONException;import org.json.JSONObject;import android.app.ActionBar;import android.app.Activity;import android.app.AlertDialog;import android.app.Fragment;import android.app.FragmentManager;import android.content.Context;import android.content.DialogInterface;import android.content.res.TypedArray;import android.graphics.Color;import android.os.AsyncTask;import android.os.Bundle;import android.util.LayoutDirection;import android.util.Log;import android.view.Display;import android.view.Gravity;import android.view.LayoutInflater;import android.view.View;import android.view.ViewGroup;import android.widget.Button;import android.widget.TableLayout;import android.widget.LinearLayout;import android.widget.ListView;import android.widget.RelativeLayout;import android.widget.TableRow;import android.widget.TextView;import android.widget.Toast;import android.widget.ListAdapter;import android.widget.ArrayAdapter;import com.winway.camera.DisplayUtil;public class NavbarFavoriteActivity extends BaseFragment  {		private Context context ;	private Button btnMsg;	private Button btnAdd,btnSearch;	private String apps="000000000";	private boolean []isApplicationSel;	private TableLayout table1;	public View.OnClickListener onLayoutClick;	public void callApqpActivity()	{		ApqpListActivity activity = new ApqpListActivity();        showActivity("apqplist", activity);	}	public void callQtActivity()	{		QtListActivity activity = new QtListActivity();        showActivity("qtlist", activity);	}	public void callCustActivity()	{		CustomerListActivity activity = new CustomerListActivity();        showActivity("customerlist", activity);	}	public void callWipActivity()	{        WIPListActivity activity = new WIPListActivity();        showActivity("customerlist",activity);	}	public void callStockActivity()	{        StockActivity activity = new StockActivity();        showActivity("stock",activity);	}	public void callFaeActivity()	{        FaeListActivity activity = new FaeListActivity();        showActivity("fae",activity);	}	public void callBomActivity()	{        BomActivity activity = new BomActivity();        showActivity("bom",activity);	}	public void callProjectSearchActivity()	{        ProjectFindActivity activity = new ProjectFindActivity();        showActivity("projectsearch",activity);	}	public void callGoodsPicActivity()	{        AlbumListActivity activity = new AlbumListActivity();        showActivity("goods",activity);	}	public boolean[]getApplicationSel(String apps)	{		boolean []sel={false,false,false,false,false		,false,false,false,false		};		for(int i=0;i<apps.length();i++) {			String isShow = apps.substring(i, i + 1);			if (isShow.equals("1"))				sel[i]=true;		}		return sel;	}    protected String gettApplication()    {        String apps=getConfig(context,"config","favorite","00000000");        return apps;    }    //H    public void hideActionbar()    {        ActionBar mActionBar=getActivity().getActionBar();        if(mActionBar.isShowing()==true)mActionBar.hide();        btnAdd.setVisibility(View.GONE);    }    ///I    protected  void initUI(View view)	{		btnAdd          =(Button)getActivity().findViewById(R.id.btn_favorite_add);		btnSearch       =(Button)getActivity().findViewById(R.id.btn_search);		if(btnSearch!=null)		{			btnSearch.setVisibility(View.GONE);		}		if(btnAdd!=null) {			//if(btnAdd.getVisibility()!= View.VISIBLE)			btnAdd.setVisibility(View.VISIBLE);			btnAdd.setOnClickListener(new View.OnClickListener() {				@Override				public void onClick(View v) {					showApplicationDialog(v);				}			});		}		table1        =(TableLayout) view.findViewById(R.id.table1);        onLayoutClick=new View.OnClickListener() {            @Override            public void onClick(View view)            {                LinearLayout layout=(LinearLayout)view;                int tag=(int )layout.getTag();                switch(tag)                {                    case 0:                        setTitle("Sale");                        callApqpActivity();                        break;                    case 1:                        setTitle("Sale");                        callQtActivity();                        break;                    case 2:                        setTitle("Sale");                        callCustActivity();                        break;                    case 3:                        setTitle("Sale");                        callWipActivity();                        break;                    case 4:                        setTitle("Sale");                        callStockActivity();                        break;                    case 5:                        setTitle("Sale");                        callProjectSearchActivity();                        break;                    case 6:setTitle("Inventory");                        callBomActivity();                        break;                    case 7:                        setTitle("Inventory");                        callGoodsPicActivity();                        break;                    case 8:                        setTitle("FAE");                        callFaeActivity();                        break;                }            }        };		/*faelayout    =(RelativeLayout) view.findViewById(R.id.faelayout);		stocklayout  =(RelativeLayout) view.findViewById(R.id.stocklayout);		qtlayout     =(RelativeLayout) view.findViewById(R.id.qtlayout);		bomlayout    =(RelativeLayout) view.findViewById(R.id.bomlayout);		goodslayout  =(RelativeLayout) view.findViewById(R.id.goodslayout);		projectlayout=(RelativeLayout) view.findViewById(R.id.projectlayout);		wiplayout    =(RelativeLayout) view.findViewById(R.id.wiplayout);		custlayout   =(RelativeLayout) view.findViewById(R.id.custlayout);*/		apps=getConfig(context,"config","favorite","000000000");		showApplication(apps);	}	private View initView(LayoutInflater inflater, ViewGroup container) {				//System.out.println("==>"+new Throwable().getStackTrace()[0].getClassName()+" > "+new Throwable().getStackTrace()[0].getMethodName());		//System.out.println("===>Line number: "+new Throwable().getStackTrace()[0].getLineNumber()); 				View view = inflater.inflate(R.layout.actnavbarfavorite, container, false);		context = view.getContext();		 showActionbar();		 initUI(view);		 btnMsg = ((Button)view.findViewById(R.id.btnMsg));		queryData(super.getWebServiceUrl() + "GetMSGUnreadCount?USERID=" + super.getLoginUser() + "&WWID=13145774WWGlobal999988msg", new IDataReceiveListener() {			@Override			public void onReceiveData(Object result) {				//System.out.println("==>"+new Throwable().getStackTrace()[0].getClassName()+" > "+new Throwable().getStackTrace()[0].getMethodName());				//System.out.println("===>Line number: "+new Throwable().getStackTrace()[0].getLineNumber());				try {					int cc = Integer.parseInt(new JSONObject((String) result).getString("GetMSGUnreadCountResult"));					initBadge(btnMsg, cc);				} catch (JSONException e) {					e.printStackTrace();				}			}		    });		    setTitle("Favorite");		return view;	}	 private void initBadge(Button button, int count)	  {	    if (button != null)	    {	    	if(count>0){	    		   BadgeView badge1 = new BadgeView(this.getActivity(), button);// 創建一個BadgeView物件，view為你需要顯示提醒的控制項	    			badge1.setText(Integer.toString(count)); // 需要顯示的提醒類容	    			badge1.setBadgePosition(BadgeView.POSITION_TOP_RIGHT);// 顯示的位置.右上角,BadgeView.POSITION_BOTTOM_LEFT,下左，還有其他幾個屬性	    			badge1.setTextColor(Color.WHITE); // 文本顏色	    			badge1.setBadgeBackgroundColor(Color.GRAY); //提醒資訊的背景顏色，自己設置	    			badge1.setTextSize(18); // 文本大小	    			badge1.setBadgeMargin(60, 5); // 水準和豎直方向的間距	    			//badge1.setBadgeMargin(30); //各邊間隔	    			// badge1.toggle(); //顯示效果，如果已經顯示，則隱藏，如果隱藏，則顯示	    			badge1.show();// 只有顯示	    	}	    }	  }    //Q	public void queryData(String url, IDataReceiveListener DataReceiveListener)	{	   super.getRequest(url, DataReceiveListener);	}//O@Overridepublic View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {    return initView(inflater, container);}@Overridepublic void onDestroyView() {	super.onDestroyView();}	@Override	public void onDestroy() {		super.onDestroy();	}	@Override	public void onDetach() {		super.onDetach();	}	@Override	public void onPause() {		super.onPause();	}	@Override	public void onResume() {		super.onResume();         showActionbar();	}	@Override	public void onStart() {		super.onStart();	}	@Override	public void onStop() {		super.onStop();	}	@Override	public void onAttach(Activity activity) {		super.onAttach(activity);	}    //S    public void showActionbar()    {        ActionBar mActionBar=getActivity().getActionBar();        if(mActionBar.isShowing()==false)mActionBar.show();        if(btnAdd!=null)btnAdd.setVisibility(View.VISIBLE);    }    public void setTitle(CharSequence title) {        getActivity().getActionBar().setTitle(title);    }    protected void showApplication(String apps)    {        table1.removeAllViews();        int cc=0;        TableRow tableRow=null;        for(int i=0;i<apps.length();i++)        {            String  isShow=apps.substring(i, i + 1);            LinearLayout layout=null;            if(tableRow==null)            {                tableRow = new TableRow(context);                tableRow.setLayoutParams(new TableRow.LayoutParams(                        TableRow.LayoutParams.MATCH_PARENT,                        TableRow.LayoutParams.WRAP_CONTENT));            }            if(isShow.equals("1")) {                if (i == 0) {                    cc++;                    FavoriteItem item = new FavoriteItem("APQP", R.drawable.sale_apqp);                    layout = item.getLayout(context);                    layout.setTag(i);                } else if (i == 1) {                    cc++;                    FavoriteItem item = new FavoriteItem("QT", R.drawable.sale_qt);                    layout = item.getLayout(context);                    layout.setTag(i);                } else if (i == 2) {                    cc++;                    FavoriteItem item = new FavoriteItem("Customer", R.drawable.sale_customer);                    layout = item.getLayout(context);                    layout.setTag(i);                } else if (i == 3) {                    cc++;                    FavoriteItem item = new FavoriteItem("WIP", R.drawable.index_wip);                    layout = item.getLayout(context);                    layout.setTag(i);                } else if (i == 4) {                    cc++;                    FavoriteItem item = new FavoriteItem("Stock", R.drawable.inventory_pin);                    layout = item.getLayout(context);                    layout.setTag(i);                } else if (i == 5) {                    cc++;                    FavoriteItem item = new FavoriteItem("Project Search", R.drawable.search_origin_index);                    layout = item.getLayout(context);                    layout.setTag(i);                } else if (i == 6) {                    cc++;                    FavoriteItem item = new FavoriteItem("BOM", R.drawable.inventory_icon);                    layout = item.getLayout(context);                    layout.setTag(i);                } else if (i == 7) {                    cc++;                    FavoriteItem item = new FavoriteItem("Goods", R.drawable.goods_icon);                    layout = item.getLayout(context);                    layout.setTag(i);                } else if (i == 8) {                    cc++;                    FavoriteItem item = new FavoriteItem("FAE", R.drawable.fae);                    layout = item.getLayout(context);                    layout.setTag(i);                }                if (layout != null) {                    layout.setClickable(true);                    layout.setOnClickListener(onLayoutClick);                    layout.setGravity(Gravity.CENTER_HORIZONTAL);                    layout.setLayoutParams(new TableRow.LayoutParams(                            0,                            TableRow.LayoutParams.WRAP_CONTENT,1f));                    tableRow.addView(layout);                   if(cc%2==0) {                       table1.addView(tableRow, new TableLayout.LayoutParams(                               TableLayout.LayoutParams.MATCH_PARENT,                               TableLayout.LayoutParams.MATCH_PARENT));                      tableRow=null;                   }                }// end if            }//end if        }//end for        if(tableRow!=null)        {            //add Empty Layout            FavoriteItem item = new FavoriteItem("", 0);            LinearLayout layout = item.getLayout(context);            layout.setGravity(Gravity.CENTER_HORIZONTAL);            layout.setLayoutParams(new TableRow.LayoutParams(                    0,                    TableRow.LayoutParams.WRAP_CONTENT,1f));            tableRow.addView(layout);            table1.addView(tableRow, new TableLayout.LayoutParams(                    TableLayout.LayoutParams.MATCH_PARENT,                    TableLayout.LayoutParams.MATCH_PARENT));            tableRow=null;        }    }    public void showApplicationDialog(View v)	{		apps=gettApplication();        isApplicationSel=getApplicationSel(apps);		AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity());		dialog.setTitle("Application").setIcon(android.R.drawable.ic_dialog_info);		DialogInterface.OnMultiChoiceClickListener multiListener = new DialogInterface.OnMultiChoiceClickListener() {			@Override			public void onClick(DialogInterface d, int which, boolean isChecked) {				isApplicationSel[which]=isChecked;			}		};		DialogInterface.OnClickListener okListener = new DialogInterface.OnClickListener() {			@Override			public void onClick(DialogInterface d, int which) {			    apps = "";				for (int i = 0; i < isApplicationSel.length;i++)				{					if(isApplicationSel[i]==true)					   apps+="1";					 else						apps+="0";				}				showApplication(apps);				setConfig(context,"config","favorite",apps);				d.dismiss();				d = null;			}		};		DialogInterface.OnClickListener cancelListener = new DialogInterface.OnClickListener() {			@Override			public void onClick(DialogInterface d, int which) {				d.dismiss();				d = null;			}		};		String[] mApplication = {"APQP","QT","Customer","WIP","Stock","Project Search","BOM","Goods","FAE"};		dialog.setMultiChoiceItems(mApplication, isApplicationSel, multiListener);		dialog.setNegativeButton("Cancel", cancelListener);		dialog.setPositiveButton("Ok", okListener);		dialog.show();	}    public void showActivity(String tagName,BaseFragment activity)    {        hideActionbar();        Fragment fragment = null;        if(this.fragmentManager==null)        {            this.fragmentManager=getActivity().getFragmentManager();        }        if(fragmentManager.findFragmentByTag(tagName) != null) {            fragmentManager.beginTransaction().remove(fragmentManager.findFragmentByTag(tagName)).commit();        }        activity.setFragmentManager(this.fragmentManager) ;        fragment = (Fragment) activity;        fragment.setRetainInstance(true);        ((MainActivity)getActivity()).clearFragments();        fragmentManager.beginTransaction().replace(R.id.content_frame,                activity,tagName).commit();    }}