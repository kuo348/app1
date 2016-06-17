package com.winway.wwapp2;

import java.util.List;

import android.app.Activity;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapActivity extends BaseFragment {
	private MapView mapView;
    private GoogleMap map;
    private Bundle bundle;
    private Button btn_return_detail2_address;
    public void closeFragment()
    {
    	if(parent!=null){
    		this.fragmentManager.beginTransaction().remove(this).commit();
			this.fragmentManager.beginTransaction().show(parent).commit();    		
    	}
    	
    }
    private View initView(LayoutInflater inflater, ViewGroup container) {
    	View rootView = inflater.inflate(R.layout.actmap, container, false);        
		initUI(rootView);

		return rootView;

	}
    private void initUI(View v)
    {
    	btn_return_detail2_address=(Button) v.findViewById(R.id.btn_return_detail2_address);
    	btn_return_detail2_address.setOnClickListener(new OnClickListener(){
    		@Override
    		public void onClick(View v){
    			closeFragment();    			
    		}
    	});
    	bundle=this.getArguments();
       
        mapView = (MapView) v.findViewById(R.id.map);        
      
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
    	
    	View rootView=initView(inflater, container);
    	  mapView.onCreate(savedInstanceState);
    	  mapView.onResume();// needed to get the map to display immediately
          MapsInitializer.initialize(getActivity());
          map = mapView.getMap();
          try {
          final LatLng lng=getLocationFromAddress(bundle.getString("address"));
          Marker mker = map.addMarker(new MarkerOptions().position(lng).title(bundle.getString("address")).snippet(bundle.getString("company")));
          map.moveCamera(CameraUpdateFactory.newLatLngZoom(lng , 16));
          mker.showInfoWindow();
          }
          catch(Exception ex)
          {
        	  this.showDialog("error",ex.getMessage());        	  
          }
    	return rootView;

    }
    
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        
    }

    @Override
    public void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }
 
public LatLng getLocationFromAddress(String strAddress) {

    Geocoder coder = new Geocoder(getActivity());
    List<Address> address;
    LatLng p1 = null;

    try {
        address = coder.getFromLocationName(strAddress, 5);
        if (address == null) {
            return null;
        }
        Address location = address.get(0);
        location.getLatitude();
        location.getLongitude();

        p1 = new LatLng(location.getLatitude(), location.getLongitude() );

    } catch (Exception ex) {

        ex.printStackTrace();
    }

    return p1;
}
}
