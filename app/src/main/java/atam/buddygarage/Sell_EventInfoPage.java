package atam.buddygarage;

import android.content.Context;
import android.location.Location;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class Sell_EventInfoPage extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ScrollView scroll;
    private ImageView transparent;
    private double currentLat, currentLng;
    protected Context context;
    private GpsTool gpsTool;
    private LatLng location;
    private Marker marker;



    public void addressEditBtnCLick(View view) {
        //getCurrentLocation();
        System.out.println("MAP LOCATION***************************************************************************************************"+currentLat+" "+currentLng);
        goToMapLocation(currentLat, currentLng);
    }// for address button

    private void goToMapLocation(double lat, double lng) {
        location = new LatLng(lat, lng);
        marker = mMap.addMarker(new MarkerOptions().position(location).title("Click marker to navigate"));
        marker.showInfoWindow();
        mMap.moveCamera(CameraUpdateFactory.newLatLng(location));
        mMap.animateCamera(CameraUpdateFactory.newLatLng(location));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(13.0f)); // zoom
        //Toast.makeText(this, "Unable to fetch location", Toast.LENGTH_SHORT).show();
    }// function to pan map & camera location

    private void mapScrollBetter() {
        scroll = (ScrollView) findViewById(R.id.scroll);
        transparent = (ImageView) findViewById(R.id.imagetrans);
        transparent.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int action = event.getAction();
                switch (action) {
                    case MotionEvent.ACTION_DOWN:
                        // Disallow ScrollView to intercept touch events.
                        scroll.requestDisallowInterceptTouchEvent(true);
                        // Disable touch on transparent view
                        return false;
                    case MotionEvent.ACTION_UP:
                        // Allow ScrollView to intercept touch events.
                        scroll.requestDisallowInterceptTouchEvent(false);
                        return true;
                    case MotionEvent.ACTION_MOVE:
                        scroll.requestDisallowInterceptTouchEvent(true);
                        return false;

                    default:
                        return true;
                }
            }
        });
    } // use transparent image to make scroll better

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sell__event_info_page);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        mapScrollBetter();
        runGPS();
    } // main for Sell_EventInfoPage


    /**
     **** Sub Functions for GPS and to find current location****
     */
    private void runGPS(){
        if (gpsTool == null) {
            gpsTool = new GpsTool(this) {
                @Override
                public void onGpsLocationChanged(Location location) {
                    super.onGpsLocationChanged(location);
                    currentLng = location.getLongitude();
                    currentLat = location.getLatitude();
                }
            };
        }
    }// run by the getCurrentLocation method

    @Override
    protected void onPause() {
        super.onPause();
        gpsTool.stopGpsUpdate();
    }
    @Override
    protected void onResume() {
        super.onResume();
        gpsTool.startGpsUpdate();
    }
    /**
     ************************************************************
     */



    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        goToMapLocation(22.396428, 114.109497); //hard coded event on Map
    }// run when map initialized
}
