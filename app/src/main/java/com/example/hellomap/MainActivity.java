package com.example.hellomap;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import com.google.android.gms.maps.model.BitmapDescriptorFactory;


import com.google.android.gms.maps.model.GroundOverlayOptions;




public class MainActivity extends FragmentActivity {
    private GoogleMap mMap;



Beacon beacon1= new Beacon(43.587000,13.587000 );



@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        setUpMapIfNeeded();

        LatLng ANCONA =new LatLng(43.586807, 13.516488);
        CameraPosition camera =new CameraPosition.Builder().target(ANCONA).zoom(15).build();

        GoogleMap map;
        map = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map)).getMap();
        map.moveCamera(CameraUpdateFactory.newCameraPosition(camera));
        map.addMarker(new MarkerOptions()
                .position(new LatLng(43.586807, 13.516488))
                .title("UNIVPM"));


    map.addMarker(new MarkerOptions()
            .position(new LatLng(beacon1.latitude, beacon1.longitude))
            .title("beacon1"));

            LatLng UNIVPM = new LatLng(43.586807, 13.516488);
        GroundOverlayOptions Map;
        Map = new GroundOverlayOptions()
                .image(BitmapDescriptorFactory.fromResource(R.drawable.quota))
                .position(UNIVPM, 160f, 160f)
                .transparency(0.5f)
               .bearing(-70);
        map.addGroundOverlay(Map);


    }

    @Override
    protected void onResume() {
        super.onResume();
        setUpMapIfNeeded();
    }





    private void setUpMapIfNeeded() {
        if (mMap != null) {
            return;
        }
        mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map)).getMap();
        if (mMap == null) {
            return;
        }
        // Initialize map options. For example:
         mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
    }
}
