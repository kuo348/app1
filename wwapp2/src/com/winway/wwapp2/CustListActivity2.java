package com.winway.wwapp2;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnKeyListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.SearchView;

import com.winway.wwapp2.PullDownView.OnPullDownListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class CustListActivity2 extends BaseFragment implements OnPullDownListener, OnItemClickListener,SearchView.OnQueryTextListener  {
	private Context context ;
	private Bundle bundle;
	private View mView=null;
	private int ACTION_MESSAGE;
	private CustListAdapter2 adapter2;
	private ArrayList<CustItem2> custItems;
	private PullDownView mPullDownView;
	protected static final int REFRESH_DATA = 0x00000002;
	private static final int WHAT_DID_LOAD_DATA = 0;
	private static final int WHAT_DID_REFRESH = 1;
	private static final int WHAT_DID_MORE = 5;
	private Button btnCancel=null;
	private Button btnCancel2=null;
	private int page=1;
	private ListView lstCust;
	private SearchView sv ;
	private String strSearchText="";
	private EditText searchEdit;
	private RelativeLayout r1;
	private RelativeLayout r2;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

		//System.out.println("==>"+new Throwable().getStackTrace()[0].getClassName()+" > "+new Throwable().getStackTrace()[0].getMethodName());
		//System.out.println("===>Line number: "+new Throwable().getStackTrace()[0].getLineNumber());

		return initView(inflater, container);
	}

	private View initView(LayoutInflater inflater, ViewGroup container) {

		//System.out.println("==>"+new Throwable().getStackTrace()[0].getClassName()+" > "+new Throwable().getStackTrace()[0].getMethodName());
		//System.out.println("===>Line number: "+new Throwable().getStackTrace()[0].getLineNumber());

		View view = inflater.inflate(R.layout.actcustlist2, container, false);

		context = view.getContext();
		mView=view;
		btnCancel=(Button)view.findViewById(R.id.btn_cancel);
		btnCancel2=(Button)view.findViewById(R.id.btn_cancel2);
		r1=(RelativeLayout)view.findViewById(R.id.cust_r1);
		r2=(RelativeLayout)view.findViewById(R.id.cust_r2);
		searchEdit=(EditText)view.findViewById(R.id.search_text);
		btnCancel.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v){

				//System.out.println("==>"+new Throwable().getStackTrace()[0].getClassName()+" > "+new Throwable().getStackTrace()[0].getMethodName());
				//System.out.println("===>Line number: "+new Throwable().getStackTrace()[0].getLineNumber());

				closeFragment();
			}
		});
		btnCancel2.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v){

				//System.out.println("==>"+new Throwable().getStackTrace()[0].getClassName()+" > "+new Throwable().getStackTrace()[0].getMethodName());
				//System.out.println("===>Line number: "+new Throwable().getStackTrace()[0].getLineNumber());

				if(r1.getVisibility()!=View.VISIBLE)
				{
					r1.setVisibility(View.VISIBLE);
				}
				if(btnCancel2.getVisibility()==View.VISIBLE)
				{
					btnCancel2.setVisibility(View.GONE);
					searchEdit.setFocusable(false);
					searchEdit.setFocusableInTouchMode(false);
					searchEdit.setClickable(false);
				}
			}
		});
		searchEdit.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v){
				
				//System.out.println("==>"+new Throwable().getStackTrace()[0].getClassName()+" > "+new Throwable().getStackTrace()[0].getMethodName());
				//System.out.println("===>Line number: "+new Throwable().getStackTrace()[0].getLineNumber()); 
		   		
				if(btnCancel2.getVisibility()!=View.VISIBLE)
				{
					btnCancel2.setVisibility(View.VISIBLE);	
					//searchEdit.setFocusable(true);
					//searchEdit.setFocusableInTouchMode(true);
					//searchEdit.setClickable(true);
				}
				if(r1.getVisibility()==View.VISIBLE)
				{
					r1.setVisibility(View.GONE);					
				}
			}
		});
		searchEdit.setOnTouchListener(new OnTouchListener() {
		    @Override
		    public boolean onTouch(View v, MotionEvent event) {
		    	
		    	//System.out.println("==>"+new Throwable().getStackTrace()[0].getClassName()+" > "+new Throwable().getStackTrace()[0].getMethodName());
				//System.out.println("===>Line number: "+new Throwable().getStackTrace()[0].getLineNumber()); 
		   		
				
		        if (event.getAction() == MotionEvent.ACTION_UP) {
		            
		        }
		        return false;
		    }
		});

		searchEdit.setOnFocusChangeListener(new OnFocusChangeListener() {

		    @Override
		    public void onFocusChange(View v, boolean hasFocus) {
		    	
		    	//System.out.println("==>"+new Throwable().getStackTrace()[0].getClassName()+" > "+new Throwable().getStackTrace()[0].getMethodName());
				//System.out.println("===>Line number: "+new Throwable().getStackTrace()[0].getLineNumber()); 
		   		
		        if (hasFocus) {
		           
		        } else {
		           
		        }
		    }
		});
		searchEdit.setOnKeyListener(new OnKeyListener() {
		    public boolean onKey(View v, int keyCode, KeyEvent event) {
		    	
		    	//System.out.println("==>"+new Throwable().getStackTrace()[0].getClassName()+" > "+new Throwable().getStackTrace()[0].getMethodName());
				//System.out.println("===>Line number: "+new Throwable().getStackTrace()[0].getLineNumber()); 
		   		
		        // If the event is a key-down event on the "enter" button
		    	if ((event.getAction() == 0) && (keyCode== 66))
				{
		          // Perform action on key press
		        	page=1;
			        strSearchText=searchEdit.getText().toString();
			    	queryData(WHAT_DID_LOAD_DATA);
		        // return true;
		        }
		        return false;
		    }
		});
		/*
		    sv = (SearchView) view.findViewById(R.id.search_custview);
		   //設置該SearchView默認是否自動縮小為圖標
	        sv.setIconifiedByDefault(false);
	        //為該SearchView組件設置事件監聽器
	        sv.setOnQueryTextListener(this);
	        //設置該SearchView顯示搜索按鈕
	        sv.setSubmitButtonEnabled(true);
	        //設置該SearchView內默認顯示的提示文本
	        sv.setQueryHint("search");
	        int searchSrcTextId = getResources().getIdentifier("android:id/search_src_text", null, null);  
	        EditText searchEditText = (EditText) sv.findViewById(searchSrcTextId);  
	        searchEditText.setTextColor(Color.BLACK);  
	        searchEditText.setHintTextColor(Color.LTGRAY);  
		   // searchEditText.setBackgroundColor(Color.LTGRAY);
		    int searchImgId = getResources().getIdentifier("android:id/search_mag_icon", null, null);
		    ImageView v = (ImageView)sv.findViewById(searchImgId);
		    v.setImageResource(R.drawable.ic_action_search); */
		   
		initPullDownView(view);
		queryData(WHAT_DID_LOAD_DATA);
 
		return view;
	}
	/*private String getLoginUser()
	{
		return super.getConfig(getActivity(),"Config","LoginUser","");		
	}*/

	private void queryData(int Message)
	{
		
		//System.out.println("==>"+new Throwable().getStackTrace()[0].getClassName()+" > "+new Throwable().getStackTrace()[0].getMethodName());
		//System.out.println("===>Line number: "+new Throwable().getStackTrace()[0].getLineNumber()); 
   		
		 String json="";		
		   //  String url="http://59.125.146.7:8080/APQPService/GetMsgList?USERID=mis&PAGE="+Integer.toString(page)+"&WWID=13145774WWGlobal999988msg";
			 String url="http://59.125.146.7:8080/APQPService/openWindow2CustNo";
		     JSONObject jsonObject = new JSONObject();
		     JSONObject data=new JSONObject();
	         try {
	        	   
	        	   if(strSearchText.isEmpty()==false){
	        		   data.accumulate("condition", strSearchText);
	        	   }
	        	   else {
	        		   data.accumulate("condition", "");  
	        	   }
				   jsonObject.accumulate("userid",this.getLoginUser());
				   jsonObject.accumulate("WWID", "13145774WWGlobal999988owquery2999");
				   jsonObject.accumulate("data", data);
				   jsonObject.accumulate("page", page);
				   super.postRequest(url, jsonObject, Message);
				   
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	@Override
	  public void loadData(Object result)
	  {
		
		//System.out.println("==>"+new Throwable().getStackTrace()[0].getClassName()+" > "+new Throwable().getStackTrace()[0].getMethodName());
		//System.out.println("===>Line number: "+new Throwable().getStackTrace()[0].getLineNumber()); 
   		
		try {
			custItems.clear();
			JSONObject jsonObject=new JSONObject((String)result);
			setCustItem(jsonObject);
			mPullDownView.notifyDidLoad();
			}
		catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			  
	  }
	@Override
	  public void loadRefreshData(Object result)
	  {
		
		//System.out.println("==>"+new Throwable().getStackTrace()[0].getClassName()+" > "+new Throwable().getStackTrace()[0].getMethodName());
		//System.out.println("===>Line number: "+new Throwable().getStackTrace()[0].getLineNumber()); 
   		
		try {
			JSONObject jsonObject=new JSONObject((String)result);
			custItems.clear();
			setCustItem(jsonObject);
			page=1;
			mPullDownView.notifyDidRefresh();
			}
		catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			  
	  }	
	@Override
	  public void loadMoreData(Object result)
	  {
		
		//System.out.println("==>"+new Throwable().getStackTrace()[0].getClassName()+" > "+new Throwable().getStackTrace()[0].getMethodName());
		//System.out.println("===>Line number: "+new Throwable().getStackTrace()[0].getLineNumber()); 
   		
			try {
				JSONObject jsonObject=new JSONObject((String)result);
				setCustItem(jsonObject);
				JSONArray array=jsonObject.getJSONArray("data");
				if(array.length()==0){
					page=page-1;		
				}
				mPullDownView.notifyDidMore();
				}
			catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			  
	  }
	private void setCustItem(JSONObject jsonObject)
	{
		
		//System.out.println("==>"+new Throwable().getStackTrace()[0].getClassName()+" > "+new Throwable().getStackTrace()[0].getMethodName());
		//System.out.println("===>Line number: "+new Throwable().getStackTrace()[0].getLineNumber()); 
   		
		try {
			JSONArray array=jsonObject.getJSONArray("data");
			if(array.length()>0){
			for(int i=0;i<array.length() ;i++){
				JSONObject obj;
				obj = array.getJSONObject(i);
				custItems.add(new CustItem2(obj.getString("OCC01"),//cust no
						obj.getString("OCC02"),//cust name
						obj.getString("OCC29"),//contact
						"",//area code
						obj.getString("OCC261"),//phone
						"",//ext
						"",//fax area code
						obj.getString("OCC271" ),//fax
						obj.getString("OCC262" ),//mobile
						obj.getString("OCC241" ),//address
						obj.getString("OCCUD04"),//email
						obj.getString("XD003"  ),//region name
						obj.getString("OCC42"  ) //Currency
						,obj.getString("OCC44"  ) //Price Term
						,obj.getString("OCC44_X") //Price Term desc
						,obj.getString("OCC45"  ) //Paymeny Term
						,obj.getString("OCC45_X") //Paymeny Term desc
						,obj.getString("OCC47"  ) //Shipping Via
						,obj.getString("OCC47_X") //Shipping Via desc
						,obj.getString("OCC41_X") //Tax Type
						,obj.getString("OCC41_Y") //Tax Type desc
                        ,obj.getString("TA_OCC02_X") //Payment Type
                        ,obj.getString("TA_OCC02_Y") //Payment Type desc

				));


				//------------------------
//				custItems.add(new CustItem(obj.getString("OCC01"),//cust no
//						obj.getString("OCC02"),//cust name
//						obj.getString("OCC29"),//contact
//						"",//area code
//						obj.getString("OCC261"),//phone
//						"",//ext
//						"",//fax area code
//						obj.getString("OCC271"),//fax
//						obj.getString("OCC262"),//mobile
//						obj.getString("OCC241"),//address
//						obj.getString("OCCUD04")//email
//				));

				//------------------------
		      }
			adapter2.notifyDataSetChanged();
			}
		   } catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	  @Override
		public void onRefresh() {
		  
		//System.out.println("==>"+new Throwable().getStackTrace()[0].getClassName()+" > "+new Throwable().getStackTrace()[0].getMethodName());
		//System.out.println("===>Line number: "+new Throwable().getStackTrace()[0].getLineNumber()); 
	   		
			// TODO Auto-generated method stub
	new Thread(new Runnable() {
				@Override
				public void run() {
					
					//System.out.println("==>"+new Throwable().getStackTrace()[0].getClassName()+" > "+new Throwable().getStackTrace()[0].getMethodName());
					//System.out.println("===>Line number: "+new Throwable().getStackTrace()[0].getLineNumber()); 
			   		
					//String result="";				
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
					//System.out.println("==>"+new Throwable().getStackTrace()[0].getClassName()+" > "+new Throwable().getStackTrace()[0].getMethodName());
					//System.out.println("===>Line number: "+new Throwable().getStackTrace()[0].getLineNumber()); 
			   		
					//String result="";
					page+=1;
					queryData(WHAT_DID_MORE);    
			      	     
					
				}
			}).start();
			
		}
		private void initPullDownView(View view)
		{
			
			//System.out.println("==>"+new Throwable().getStackTrace()[0].getClassName()+" > "+new Throwable().getStackTrace()[0].getMethodName());
			//System.out.println("===>Line number: "+new Throwable().getStackTrace()[0].getLineNumber()); 
	   		
			/*
			 * 1.使用PullDownView
			 * 2.設置OnPullDownListener
			 * 3.從mPullDownView里面獲取ListView
			 */
		
			mPullDownView = (PullDownView) view.findViewById(R.id.custlistview);
			if(mPullDownView==null) return ;
			mPullDownView.setOnPullDownListener(this);
			lstCust = mPullDownView.getListView();		
			lstCust.setOnItemClickListener(this);
			/*ColorDrawable cd=new ColorDrawable(R.color.red);
			lstCust.setDivider(cd);
			lstCust.setChoiceMode(ListView.CHOICE_MODE_SINGLE);*/
			lstCust.setDividerHeight(0);
			lstCust.setHeaderDividersEnabled(true);
			//adapter2 = new SimpleAdapter(context,mStrings,R.layout.pulldown_item,new String[]{"title","content"},new int[] {R.id.msg_title2,R.id.msg_content} );
		     custItems = new ArrayList<CustItem2>();
			 adapter2 = new CustListAdapter2(context,custItems);
			 lstCust.setAdapter(adapter2);
		     mPullDownView.enableAutoFetchMore(true, 1);
			
		}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
							long id) {

		//System.out.println("==>"+new Throwable().getStackTrace()[0].getClassName()+" > "+new Throwable().getStackTrace()[0].getMethodName());
		//System.out.println("===>Line number: "+new Throwable().getStackTrace()[0].getLineNumber());

		Bundle args;
		args = this.getArguments();

		final CustItem2 item = (CustItem2 ) custItems.get(position);
		if(this.parent!=null){
			Bundle bundle=new Bundle();
			bundle.putString("custId",item.getCustId());
			bundle.putString("custName", item.getCustName());
			this.doWork((Object)bundle);

		} else {

			if (args.getString("parentId")=="qtdata") {
				FragmentManager fm=getFragmentManager();
				Fragment fragment=fm.findFragmentByTag("qtdata");
				EditText CUST_NO         = (EditText)fragment.getView().findViewById(R.id.ed_CUST_NO     );//CUST_NO
				EditText CUST_NO_X       = (EditText)fragment.getView().findViewById(R.id.ed_CUST_NO_X   );//cust name
				EditText CUST_CONTACT    = (EditText)fragment.getView().findViewById(R.id.ed_CUST_CONTACT);//contact
				EditText TEL_NO          = (EditText)fragment.getView().findViewById(R.id.ed_TEL_NO     );//phone
				//EditText xa008         = (EditText)fragment.getView().findViewById(R.id.xa008);//fax
				//EditText xa009         = (EditText)fragment.getView().findViewById(R.id.xa009);//mobile
				EditText SHIPPING_TO     = (EditText)fragment.getView().findViewById(R.id.ed_SHIPPING_TO);//address
				//EditText xa012           = (EditText)fragment.getView().findViewById(R.id.xa012);//email
				//EditText xa551           = (EditText )fraagment.getView().findViewById(R.id.xa551);//end cust
				//EditText xa057           = (EditText )fraagment.getView().findViewById(R.id.xa057);
				EditText CUST_NO_Y      = (EditText)fragment.getView().findViewById(R.id.ed_CUST_NO_Y);//address
				EditText CURRENCY       = (EditText)fragment.getView().findViewById(R.id.ed_CURRENCY);//
				EditText SHIPPING_VIA   = (EditText)fragment.getView().findViewById(R.id.ed_SHIPPING_VIA);//ed_SHIPPING_VIA
				EditText TERMS_OF_TRADE = (EditText)fragment.getView().findViewById(R.id.ed_TERMS_OF_TRADE);//ed_TERMS_OF_TRADE
				EditText PAYMENT_COND   = (EditText)fragment.getView().findViewById(R.id.ed_PAYMENT_COND);//ed_PAYMENT_COND
				EditText TAX_TYPE       = (EditText)fragment.getView().findViewById(R.id.ed_TAX_TYPE);//ed_TAX_TYPE
                EditText PAYMENT_TYPE   = (EditText)fragment.getView().findViewById(R.id.ed_PAYMENT_TYPE);//ed_PAYMENT_TYPE

				if(CUST_NO      != null) CUST_NO     .setText(item.getCustId  () );
				if(CUST_NO_X    != null) CUST_NO_X   .setText(item.getCustName() );
				if(CUST_CONTACT != null) CUST_CONTACT.setText(item.getContact () );
				if(TEL_NO       != null) TEL_NO      .setText(item.getPhone   () );
				//if(xa008!=null)	xa008.setText(item.getFax());
				//if(xa009!=null)	xa009.setText(item.getMobile());
				if(SHIPPING_TO  != null) SHIPPING_TO .setText(item.getAddress () );
				//if(xa010!=null)	xa010.setText(item.getEmail());
				//if(xa551!=null)	xa551.setText(item.getCustId());
				//if(xa057!=null)	xa057.setText(item.getCustName());
				if(CUST_NO_Y    != null) CUST_NO_Y   .setText(item.getXD003 () );
				if(CURRENCY     != null) CURRENCY    .setText(item.getOCC42 () );

				if(TERMS_OF_TRADE     != null) {
					TERMS_OF_TRADE    .setTag (item.getOCC44   () );
					TERMS_OF_TRADE    .setText(item.getOCC44_X () );
				}

				if(PAYMENT_COND     != null) {
					PAYMENT_COND    .setTag (item.getOCC45   () );
					PAYMENT_COND    .setText(item.getOCC45_X () );
				}

				if(SHIPPING_VIA     != null) {
					SHIPPING_VIA    .setTag (item.getOCC47   () );
					SHIPPING_VIA    .setText(item.getOCC47_X () );
				}

				if(TAX_TYPE     != null) {
					TAX_TYPE    .setTag (item.getOCC41_X () );
					TAX_TYPE    .setText(item.getOCC41_Y () );
				}

                if(PAYMENT_TYPE     != null) {
                    PAYMENT_TYPE    .setTag (item.getTA_OCC02_X () );
                    PAYMENT_TYPE    .setText(item.getTA_OCC02_Y () );
                }

            }
			else
			{

				FragmentManager fm=getFragmentManager();
				Fragment fraagment=fm.findFragmentByTag("apqpdata");
				EditText xa004=(EditText)fraagment.getView().findViewById(R.id.xa004);
				EditText xa004text=(EditText)fraagment.getView().findViewById(R.id.xa004text);
				EditText xa005=(EditText)fraagment.getView().findViewById(R.id.xa005);//contact
				EditText xa006=(EditText)fraagment.getView().findViewById(R.id.xa006);//phone
				EditText xa008=(EditText)fraagment.getView().findViewById(R.id.xa008);//fax
				EditText xa009=(EditText)fraagment.getView().findViewById(R.id.xa009);//mobile
				EditText xa010=(EditText)fraagment.getView().findViewById(R.id.xa010);//address
				EditText xa012=(EditText)fraagment.getView().findViewById(R.id.xa012);//email
				EditText xa551=(EditText )fraagment.getView().findViewById(R.id.xa551);//end cust
				EditText xa057=(EditText )fraagment.getView().findViewById(R.id.xa057);
				if(xa004!=null){
					xa004.setText(item.getCustId());
				}
				if(xa004text!=null){
					xa004text.setText(item.getCustName());
				}
				if(xa005!=null){
					xa005.setText(item.getContact());
				}
				if(xa006!=null){
					xa006.setText(item.getPhone());
				}
				if(xa008!=null){
					xa008.setText(item.getFax());
				}
				if(xa009!=null){
					xa009.setText(item.getMobile());
				}
				if(xa010!=null){
					xa010.setText(item.getEmail());
				}
				if(xa012!=null){
					xa012.setText(item.getAddress());
				}
				if(xa551!=null){
					xa551.setText(item.getCustId());
				}
				if(xa057!=null){
					xa057.setText(item.getCustName());
				}
			}
		}

		closeFragment();

		// Bundle bundle = new Bundle();
		//bundle.putString("xa517", item.getEmpNo());
		//((MainActivity) getActivity()).callApqpDataActivity(bundle);

	}
		private void closeFragment()
		{
			
			//System.out.println("==>"+new Throwable().getStackTrace()[0].getClassName()+" > "+new Throwable().getStackTrace()[0].getMethodName());
			//System.out.println("===>Line number: "+new Throwable().getStackTrace()[0].getLineNumber()); 
            Bundle args;
            args = this.getArguments();
		
		    FragmentManager fm=getFragmentManager();
            fm.beginTransaction().remove(fm.findFragmentByTag("Cust")).commit();
            fm.popBackStack();
            if(this.parent!=null){
        		fm.beginTransaction().show(this.parent).commit();
        	}else {
                if (args.getString("parentId")=="qtdata") {

                    fm.beginTransaction().show(fm.findFragmentByTag("qtdata")).commit();

                } else {

                    fm.beginTransaction().show(fm.findFragmentByTag("apqpdata")).commit();

                }
        	}
			
		}
		
	    @Override
	    public boolean onQueryTextChange(String newText) {
	        // TODO Auto-generated method stub
	    	
	    	//System.out.println("==>"+new Throwable().getStackTrace()[0].getClassName()+" > "+new Throwable().getStackTrace()[0].getMethodName());
			//System.out.println("===>Line number: "+new Throwable().getStackTrace()[0].getLineNumber()); 
	   		
	        return true;
	    }
	     //
	    @Override
	    public boolean onQueryTextSubmit(String query) {
	    	
	    	//System.out.println("==>"+new Throwable().getStackTrace()[0].getClassName()+" > "+new Throwable().getStackTrace()[0].getMethodName());
			//System.out.println("===>Line number: "+new Throwable().getStackTrace()[0].getLineNumber()); 
	   		
	        // TODO Auto-generated method stub
	    	page=1;
	    	 strSearchText=query;
	    	queryData(WHAT_DID_LOAD_DATA);
	    	InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE); 
	        imm.hideSoftInputFromWindow(sv.getWindowToken(), 0);
	        searchEdit.clearFocus();
	        return true;
	    }

		

		

}
