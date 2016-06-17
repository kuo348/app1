package com.winway.wwapp2;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnTouchListener;
import android.view.inputmethod.InputMethodManager;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.view.MotionEvent;
import android.content.DialogInterface;

public class FaeAdvSearchActivity extends BaseFragment
{
  protected static final int REFRESH_DATA = 2;
  private static final int WHAT_DID_LOAD_DATA = 0;
  private static final int WHAT_DID_MORE = 5;
  private static final int WHAT_DID_REFRESH = 1;
  private int ACTION_MESSAGE;
  private EditText apqpno;
  private Button btnAdvSearch;
  private Button btnRetrunFaeList;
  private Context context;
  private EditText customer;
  private List<Map<String, Object>> items;
  private String[] mApqpType;
  private View mView;
  private int page;
  private SimpleAdapter simpleAdapter;
  private EditText fae001,fae006;
  private EditText fae008,fae012;
  private EditText fae017;
  private EditText fae022,fae023;
  private List<String> mFaeUsersKey = new ArrayList<String>();
  private List<String> mFaeUsersValue = new ArrayList<String>();
  private List<String> mSalesKey = new ArrayList<String>();
  private List<String> mSalesValue = new ArrayList<String>();
  private Button btnBack=null;
  public FaeAdvSearchActivity()
  {
    String[] arrayOfString = new String[6];
    arrayOfString[0] = "Socket";
    arrayOfString[1] = "ATC";
    arrayOfString[2] = "WLCSP0";
    arrayOfString[3] = "FinePitch";
    arrayOfString[4] = "Chg Ket";
    arrayOfString[5] = "E-Flux";
    this.mApqpType = arrayOfString;
    this.items = new ArrayList();
    this.page = 1;
  }
  public void showFaeUsersDialog(final View view)
	 {
	
	  	//System.out.println("==>"+new Throwable().getStackTrace()[0].getClassName()+" > "+new Throwable().getStackTrace()[0].getMethodName());
		//System.out.println("===>Line number: "+new Throwable().getStackTrace()[0].getLineNumber()); 
 		
	   AlertDialog.Builder dialog= new AlertDialog.Builder(getActivity());
		 dialog.setTitle("Fae Users").setIcon( android.R.drawable.ic_dialog_info);
		 DialogInterface.OnClickListener okListener=new DialogInterface.OnClickListener() {
			 @Override
			   public void onClick(DialogInterface d, int which) {
				       		((EditText)view).setText(mFaeUsersKey.get(which));
				       		((EditText)view).setHint(mFaeUsersValue.get(which));
				       		d.dismiss();
				       		view.clearFocus();
				       		d=null;
			 			}
		 };
		 DialogInterface.OnClickListener cancelListener=new DialogInterface.OnClickListener() {
			 @Override
	           public void onClick(DialogInterface d, int which) {
				 d.dismiss();
				 d=null;
			 	}
		 };
		 String []mString=new String[mFaeUsersKey.size()];
		 for(int i=0;i<mFaeUsersKey.size();i++)
		 {
			mString[i]= mFaeUsersKey.get(i);
			 
		 }
		  dialog.setSingleChoiceItems(mString, 0,  okListener); 
	      dialog.setNegativeButton("Cancel", cancelListener);
	      dialog.show();
		
	 }
  private void loadFaeUsers()
  {
	  
	  	//System.out.println("==>"+new Throwable().getStackTrace()[0].getClassName()+" > "+new Throwable().getStackTrace()[0].getMethodName());
		//System.out.println("===>Line number: "+new Throwable().getStackTrace()[0].getLineNumber()); 
 		
	     JSONObject jsonObject = new JSONObject();
	     JSONObject data=new JSONObject();
	     try {
	    	  
	    	   data.accumulate("type", "respFAEList");
			   jsonObject.accumulate("userid",super.getLoginUser());
			   jsonObject.accumulate("WWID", "13145774WWGlobal999988faeList999");
			   jsonObject.accumulate("data", data);
			   queryData((String)super.getWebServiceUrl()+"faeList",jsonObject,
					      new IDataReceiveListener(){
				            public void onReceiveData(Object obj){
				            	try {
									JSONObject jsonObject=new JSONObject((String)obj).getJSONObject("data");
									JSONArray text=jsonObject.getJSONArray("text");
									JSONArray value=jsonObject.getJSONArray("value");
									for(int i=0;i<text.length();i++){
										mFaeUsersKey.add(text.getString(i));
										mFaeUsersValue.add(value.getString(i));
									}
									//showApplicationDialog(mView);
									loadSales();
								} catch (JSONException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
				            }
				   
			   });
	     } catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
	     }
	  
  }
  public void showSalesDialog(final View view)
	 {
	
	  
	  	//System.out.println("==>"+new Throwable().getStackTrace()[0].getClassName()+" > "+new Throwable().getStackTrace()[0].getMethodName());
		//System.out.println("===>Line number: "+new Throwable().getStackTrace()[0].getLineNumber()); 
 		
		
	   AlertDialog.Builder dialog= new AlertDialog.Builder(getActivity());
		 dialog.setTitle("Sales").setIcon( android.R.drawable.ic_dialog_info);
		 DialogInterface.OnClickListener okListener=new DialogInterface.OnClickListener() {
			 @Override
			   public void onClick(DialogInterface d, int which) {
				       		((EditText)view).setText(mSalesKey.get(which));
				       		((EditText)view).setHint(mSalesValue.get(which));
				       		d.dismiss();
				       		d=null;
			 			}
		 };
		 DialogInterface.OnClickListener cancelListener=new DialogInterface.OnClickListener() {
			 @Override
	           public void onClick(DialogInterface d, int which) {
				 d.dismiss();
				 d=null;
			 	}
		 };
		 String []mString=new String[mSalesKey.size()];
		 for(int i=0;i<mSalesKey.size();i++)
		 {
			mString[i]= mSalesKey.get(i);
			 
		 }
		  dialog.setSingleChoiceItems(mString, 0,  okListener); 
	      dialog.setNegativeButton("Cancel", cancelListener);
	      dialog.show();
		
	 }
  private void loadSales()
  {
	  
	  	//System.out.println("==>"+new Throwable().getStackTrace()[0].getClassName()+" > "+new Throwable().getStackTrace()[0].getMethodName());
		//System.out.println("===>Line number: "+new Throwable().getStackTrace()[0].getLineNumber()); 
 		
	     JSONObject jsonObject = new JSONObject();
	     JSONObject data=new JSONObject();
	     try {
	    	  
	    	   data.accumulate("type", "wwSalesList");
			   jsonObject.accumulate("userid",getLoginUser());
			   jsonObject.accumulate("WWID", "13145774WWGlobal999988faeList999");
			   jsonObject.accumulate("data", data);
			   queryData((String)super.getWebServiceUrl()+"faeList",jsonObject,
					      new IDataReceiveListener(){
				            public void onReceiveData(Object obj){
				            	try {
									JSONObject jsonObject=new JSONObject((String)obj).getJSONObject("data");
									JSONArray text=jsonObject.getJSONArray("text");
									JSONArray value=jsonObject.getJSONArray("value");
									for(int i=0;i<text.length();i++){
										mSalesKey.add(text.getString(i));
										mSalesValue.add(value.getString(i));
									}
									//showApplicationDialog(mView);
								} catch (JSONException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
				            }
				   
			   });
	     } catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
	     }
	  
  }
  private void queryData(String url,JSONObject jsonObject,IDataReceiveListener dataListener)
	{
	  
	  	//System.out.println("==>"+new Throwable().getStackTrace()[0].getClassName()+" > "+new Throwable().getStackTrace()[0].getMethodName());
		//System.out.println("===>Line number: "+new Throwable().getStackTrace()[0].getLineNumber()); 
 		
			super.postRequest(url,jsonObject,dataListener);
	}
  private void closeFragment()
  {
	  
	  	//System.out.println("==>"+new Throwable().getStackTrace()[0].getClassName()+" > "+new Throwable().getStackTrace()[0].getMethodName());
		//System.out.println("===>Line number: "+new Throwable().getStackTrace()[0].getLineNumber()); 
 		
    FragmentManager fragmentManager= getFragmentManager();
    fragmentManager.beginTransaction().remove(fragmentManager.findFragmentByTag("fae_adv_search")).commit();
    fragmentManager.popBackStack();
    fragmentManager.beginTransaction().show(this.parent).commit();
  }

  private void hideFragment()
  {
	  
	  	//System.out.println("==>"+new Throwable().getStackTrace()[0].getClassName()+" > "+new Throwable().getStackTrace()[0].getMethodName());
		//System.out.println("===>Line number: "+new Throwable().getStackTrace()[0].getLineNumber()); 
 		
    FragmentManager fragmentManager= getFragmentManager();
    if (fragmentManager.findFragmentByTag("fae_adv_search") != null)
      fragmentManager.beginTransaction().hide(fragmentManager.findFragmentByTag("fae_adv_search")).commit();
  }

  private void initUI(View view)
  {
	  
	  	//System.out.println("==>"+new Throwable().getStackTrace()[0].getClassName()+" > "+new Throwable().getStackTrace()[0].getMethodName());
		//System.out.println("===>Line number: "+new Throwable().getStackTrace()[0].getLineNumber()); 
 		
    this.fae001 = ((EditText)view.findViewById(R.id.fae001));//faeno
    this.fae006 = ((EditText)view.findViewById(R.id.fae006));//customer
    this.fae008 = ((EditText)view.findViewById(R.id.fae008));//end cusstomer
    this.fae012 = ((EditText)view.findViewById(R.id.fae012));//respnsible fae
    this.fae017= ((EditText)view.findViewById(R.id.fae017));//Winway Sale
    this.fae022 = ((EditText)view.findViewById(R.id.fae022));//device
    this.fae023=((EditText)view.findViewById(R.id.fae023));//PN
	this.fae006.setOnTouchListener(new OnTouchListener() {
		   @SuppressLint("ClickableViewAccessibility")
		@Override
        public boolean onTouch(View v, MotionEvent event) {
		   fae006.setInputType(InputType.TYPE_NULL); // 關閉軟鍵盤
		   return false;
		   }

		   });
    this.fae006.setOnFocusChangeListener(new OnFocusChangeListener(){
    	   @Override
    	   public void onFocusChange(View v, boolean hasFocus) {
	            if(hasFocus){
	            	InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE); 
	            	imm.hideSoftInputFromWindow(fae006.getWindowToken(), 0);	   
	            	 showCustDialog(v);
	            }
	        }    	
    });
    this.fae008.setOnTouchListener(new OnTouchListener() {
		   @Override
     public boolean onTouch(View v, MotionEvent event) {
			   
			//System.out.println("==>"+new Throwable().getStackTrace()[0].getClassName()+" > "+new Throwable().getStackTrace()[0].getMethodName());
			//System.out.println("===>Line number: "+new Throwable().getStackTrace()[0].getLineNumber()); 
		   		
		   fae008.setInputType(InputType.TYPE_NULL); // 關閉軟鍵盤
		   return false;
		   }

		   });
 this.fae008.setOnFocusChangeListener(new OnFocusChangeListener(){
 	   @Override
 	   public void onFocusChange(View v, boolean hasFocus) {
 		   
 		   //System.out.println("==>"+new Throwable().getStackTrace()[0].getClassName()+" > "+new Throwable().getStackTrace()[0].getMethodName());
 		   //System.out.println("===>Line number: "+new Throwable().getStackTrace()[0].getLineNumber()); 
 	   		
	            if(hasFocus){
	            	InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE); 
	            	imm.hideSoftInputFromWindow(fae008.getWindowToken(), 0);	
	            	 showEndCustDialog(v);
	            }
	        }    	
 });
    this.fae008.clearFocus();
    this.fae012.setOnTouchListener(new OnTouchListener() {
		   @Override
     public boolean onTouch(View v, MotionEvent event) {
			   
			//System.out.println("==>"+new Throwable().getStackTrace()[0].getClassName()+" > "+new Throwable().getStackTrace()[0].getMethodName());
			//System.out.println("===>Line number: "+new Throwable().getStackTrace()[0].getLineNumber()); 
		   		
		   fae012.setInputType(InputType.TYPE_NULL); // 關閉軟鍵盤
		   return false;
		   }

		   });
 this.fae012.setOnFocusChangeListener(new OnFocusChangeListener(){
 	   @Override
 	   public void onFocusChange(View v, boolean hasFocus) {
 		   
 		   //System.out.println("==>"+new Throwable().getStackTrace()[0].getClassName()+" > "+new Throwable().getStackTrace()[0].getMethodName());
 		   //System.out.println("===>Line number: "+new Throwable().getStackTrace()[0].getLineNumber()); 
 	   		
	            if(hasFocus){
	            	InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE); 
	            	imm.hideSoftInputFromWindow(fae012.getWindowToken(), 0);	
	            	showFaeUsersDialog(v);
	            }
	        }    	
 });
 this.fae017.setOnTouchListener(new OnTouchListener() {
	   @Override
  public boolean onTouch(View v, MotionEvent event) {
		   
		//System.out.println("==>"+new Throwable().getStackTrace()[0].getClassName()+" > "+new Throwable().getStackTrace()[0].getMethodName());
		//System.out.println("===>Line number: "+new Throwable().getStackTrace()[0].getLineNumber()); 
	   		
	   fae017.setInputType(InputType.TYPE_NULL); // 關閉軟鍵盤
	   return false;
	   }

	   });
this.fae017.setOnFocusChangeListener(new OnFocusChangeListener(){
	   @Override
	   public void onFocusChange(View v, boolean hasFocus) {
		   
		   //System.out.println("==>"+new Throwable().getStackTrace()[0].getClassName()+" > "+new Throwable().getStackTrace()[0].getMethodName());
		   //System.out.println("===>Line number: "+new Throwable().getStackTrace()[0].getLineNumber()); 
	   		
			
          if(hasFocus){
          	InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE); 
          	imm.hideSoftInputFromWindow(fae017.getWindowToken(), 0);	
          	showSalesDialog(v);
          }
      }    	
});
    this.btnAdvSearch = ((Button)view.findViewById(R.id.btnAdvSearch));
    this.btnAdvSearch.setOnClickListener(new OnClickListener(){
    	@Override
    	public void onClick(View v)
    	  {
    		
    		//System.out.println("==>"+new Throwable().getStackTrace()[0].getClassName()+" > "+new Throwable().getStackTrace()[0].getMethodName());
    		//System.out.println("===>Line number: "+new Throwable().getStackTrace()[0].getLineNumber()); 
       		
    		ACTION_MESSAGE=WHAT_DID_LOAD_DATA;
    		queryData(ACTION_MESSAGE);    	
    	  }
    });
    this.btnRetrunFaeList = ((Button)view.findViewById(R.id.btnReturnFaeList));
   this.btnRetrunFaeList.setOnClickListener( new OnClickListener(){
   	@Override
   	public void onClick(View v)
   	  {
   		//System.out.println("==>"+new Throwable().getStackTrace()[0].getClassName()+" > "+new Throwable().getStackTrace()[0].getMethodName());
		//System.out.println("===>Line number: "+new Throwable().getStackTrace()[0].getLineNumber()); 
   		
   		closeFragment();
   	  }
   });
  }
  public void showCustDialog(View view)
	 {
	  
	  	//System.out.println("==>"+new Throwable().getStackTrace()[0].getClassName()+" > "+new Throwable().getStackTrace()[0].getMethodName());
		//System.out.println("===>Line number: "+new Throwable().getStackTrace()[0].getLineNumber()); 
 		
		 Fragment fragment= new CustListActivity();
		 ((CustListActivity)fragment).setParent((Fragment)this);
		 ((BaseFragment)fragment).setCallback(new BaseFragment.ICallback(){
			 @Override
			 public void doWork(Object object){
				 Bundle b=(Bundle)object;	
				 fae006.setText(b.getString("custId")+" " +b.getString("custName"));
				 fae006.setHint(b.getString("custId"));
			 }
			 
		 });
		 openDialog(fragment,"Cust");
	 }
  public void showEndCustDialog(View view)
	 {
	  
	  	//System.out.println("==>"+new Throwable().getStackTrace()[0].getClassName()+" > "+new Throwable().getStackTrace()[0].getMethodName());
		//System.out.println("===>Line number: "+new Throwable().getStackTrace()[0].getLineNumber()); 
 		
		 Fragment fragment= new CustListActivity();
		 ((CustListActivity)fragment).setParent((Fragment)this);
		 ((BaseFragment)fragment).setCallback(new BaseFragment.ICallback(){
			 @Override
			 public void doWork(Object object){
				 Bundle b=(Bundle)object;	
				 fae008.setText(b.getString("custId")+" " +b.getString("custName"));
				 fae008.setHint(b.getString("custId"));
			 }
			 
		 });
		 openDialog(fragment,"Cust");
	 }
  private void openDialog(Fragment fragment,String tagName)
	 {
	  	//System.out.println("==>"+new Throwable().getStackTrace()[0].getClassName()+" > "+new Throwable().getStackTrace()[0].getMethodName());
		//System.out.println("===>Line number: "+new Throwable().getStackTrace()[0].getLineNumber()); 
 		
		 //Fragment fragment= new CustListActivity();
		 FragmentManager fragmentManager = getFragmentManager();
		 fragmentManager.beginTransaction().hide(fragmentManager.findFragmentById(this.getId())).commit();
		 fragmentManager.beginTransaction().add(R.id.content_frame, fragment,tagName).commit();
		 fragmentManager.beginTransaction().addToBackStack(null);
		 fragmentManager.beginTransaction().show(fragment).commit();
		 
	 }
  private View initView(LayoutInflater inflater, ViewGroup container)
  {
	  
	  	//System.out.println("==>"+new Throwable().getStackTrace()[0].getClassName()+" > "+new Throwable().getStackTrace()[0].getMethodName());
	  	//System.out.println("===>Line number: "+new Throwable().getStackTrace()[0].getLineNumber()); 
 		
    View view =  inflater.inflate(R.layout.actfae_adv_search, container, false);
    this.context =view.getContext();
    initUI(view);
    loadFaeUsers();
    
    return view;
  }

  private void queryData(int Message)
  {
	  
	  	//System.out.println("==>"+new Throwable().getStackTrace()[0].getClassName()+" > "+new Throwable().getStackTrace()[0].getMethodName());
		//System.out.println("===>Line number: "+new Throwable().getStackTrace()[0].getLineNumber()); 
 		
		
    String str = super.getWebServiceUrl() + "queryFAE";
    JSONObject jsonObject = new JSONObject();
    JSONObject data= new JSONObject();
    try
    {
      if(this.fae001.getText().length() > 0){
    	  data.accumulate("fae001", this.fae001.getText().toString());
      }
      if(this.fae006.getText().length() > 0){
    	  data.accumulate("fae006", this.fae006.getHint().toString());
      }
      if(this.fae008.getText().length() > 0){
    	  data.accumulate("fae008", this.fae008.getHint().toString());
      }
      if(this.fae012.getText().length() > 0){
    	  data.accumulate("fae012", this.fae012.getHint().toString());
      }
      if(this.fae017.getText().length() > 0){
    	  data.accumulate("fae017", this.fae017.getHint().toString());
      }
      if(this.fae022.getText().length() > 0){
    	  data.accumulate("fae022", this.fae022.getText().toString());
      }
      if(this.fae023.getText().length() > 0){
    	  data.accumulate("fae023", this.fae023.getText().toString());
      }
      jsonObject.accumulate("userid", super.getLoginUser());
      jsonObject.accumulate("WWID", "13145774WWGlobal999988faequery999");
      jsonObject.accumulate("data", data);
      jsonObject.accumulate("page", Integer.toString(this.page));
      super.postRequest(str, jsonObject, Message);
    }
    catch (JSONException e)
    {    
        e.printStackTrace();
    }
  }

  public void loadData(Object result)
  {
	  
	  //System.out.println("==>"+new Throwable().getStackTrace()[0].getClassName()+" > "+new Throwable().getStackTrace()[0].getMethodName());
	  //System.out.println("===>Line number: "+new Throwable().getStackTrace()[0].getLineNumber()); 
 		
    try
    {
      if (new JSONObject((String)result).getJSONArray("data").length() == 0)
      {
        super.showDialog("找不到資料");
      }
      else
      {
        FragmentManager fragmentManager= getFragmentManager();
        Bundle bundle= new Bundle();
        if(this.fae001.getText().length() > 0){
        	bundle.putString("fae001", this.fae001.getText().toString());
        }
        if(this.fae006.getText().length() > 0){
        	bundle.putString("fae006", this.fae006.getHint().toString());
        }
        if(this.fae008.getText().length() > 0){
        	bundle.putString("fae008", this.fae008.getHint().toString());
        }
        if(this.fae012.getText().length() > 0){
        	bundle.putString("fae012", this.fae012.getHint().toString()); 
        }
        if(this.fae017.getText().length() > 0){
        	bundle.putString("fae017", this.fae017.getHint().toString());
        }
        if(this.fae022.getText().length() > 0){
        	bundle.putString("fae022", this.fae022.getText().toString());
        }
        if(this.fae023.getText().length() > 0){
        	bundle.putString("fae023", this.fae023.getText().toString());
        }
      
       FaeListSearchResultActivity activity = new FaeListSearchResultActivity();
       activity.setParent(this);
       activity.setArguments(bundle);
        if (fragmentManager.findFragmentById(activity.getId()) == null){
          fragmentManager.beginTransaction().add(R.id.content_frame, activity, "fae_search_result").commit();
        }
          hideFragment();
        fragmentManager.beginTransaction().show(activity).commit();
      }
    }
    catch (JSONException e)
    {
      e.printStackTrace();
    }
  }

  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle paramBundle)
  {
	  
	  //System.out.println("==>"+new Throwable().getStackTrace()[0].getClassName()+" > "+new Throwable().getStackTrace()[0].getMethodName());
	  //System.out.println("===>Line number: "+new Throwable().getStackTrace()[0].getLineNumber()); 
 		
    return initView(inflater, container);
  }
 
  
  
}