package atam.buddygarage;

import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.Toast;

import com.google.android.gms.location.LocationListener;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class Sell_EventInfoPage extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ScrollView scroll;
    private ImageView transparent;
    private double currentLat, currentLng, lat, lng;
    // private LocationManager locationManager;
    //  private LocationListener locationListener;


    public void addressEditBtnCLick(View view) {
        getCurrentLocation();
    }// for address button

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

    private void goToMapLocation(double lat, double lng) {
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        LatLng location = new LatLng(lat, lng);
        Marker marker = mMap.addMarker(new MarkerOptions().position(location).title("Click marker to navigate"));
        marker.showInfoWindow();
        mMap.moveCamera(CameraUpdateFactory.newLatLng(location));
        mMap.animateCamera(CameraUpdateFactory.newLatLng(location));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(13.0f)); // zoom
        //Toast.makeText(this, "Unable to fetch location", Toast.LENGTH_SHORT).show();
    }// function to pan map & camera location




    private void getCurrentLocation() {
//  currently working on

//        Location myLocation  = mMap.getMyLocation();
//        if(myLocation!=null) {
//            currentLat = myLocation.getLatitude();
//            currentLng = myLocation.getLongitude();
//            goToMapLocation(currentLat, currentLng);
//
//        }else{
//            Toast.makeText(this, "Unable to fetch the current location", Toast.LENGTH_SHORT).show();
//        }
    }//find my location

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sell__event_info_page);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        mapScrollBetter();
    } // main for Sell_EventInfoPage

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
        currentLat= 51.162680;  //hard coded
        currentLng= -114.095018; ////hard coded
        goToMapLocation(currentLat, currentLng);
    }// run when map initialized
}
