package fly.speedmeter.grub;

import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import com.melnykov.fab.FloatingActionButton;

import java.util.ArrayList;

public class MapsViewActivity extends FragmentActivity implements OnMapReadyCallback {
    private FloatingActionButton fab;
    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps_view);
       //toolbar = (Toolbar) findViewById(R.id.toolbar);
//        fab = (FloatingActionButton) findViewById(R.id.mapbutton);
//        fab.setVisibility(View.INVISIBLE);
//        fab. setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent1=new Intent(MapsViewActivity.this, MainActivity.class);
//                startActivity(intent1);
//            }
//        });
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

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

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));

        Intent intent = getIntent();

        double [] lats= intent.getDoubleArrayExtra("lats");
        double [] lngs= intent.getDoubleArrayExtra("lngs");
        if(lats.length>0 && lngs.length>0) {
            PolylineOptions polylineOptions=new PolylineOptions();
            for (int i = 0; i < lats.length; i++) {
                polylineOptions.add(new LatLng(lats[i], lngs[i]));
            }
            googleMap.addPolyline(polylineOptions);
            polylineOptions.color(ContextCompat.getColor(this, R.color.polyline_color));
            googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(lats[0], lngs[0]),16 ));
        }
    }


}
