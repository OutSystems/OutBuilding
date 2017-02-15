package com.outsystems.outbuilding;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.LinearLayout;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private String[] mPeople = {"Cesar Afonso", "Bruno Grácio", "João Ferreira", "Carlos Simões", "Calhau", "Calhordas", "CaCenas"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        // Get a reference to the AutoCompleteTextView in the layout
        AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView);

        // Create the adapter and set it to the AutoCompleteTextView
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mPeople);

        // Add adapter to AutoCompleteTextView
        autoCompleteTextView.setAdapter(adapter);

        autoCompleteTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("AUTO_COMPLETE", "Click");

                LinearLayout linearLayout = (LinearLayout) findViewById(R.id.blackBackground);
                linearLayout.setVisibility(View.VISIBLE);
            }
        });

        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                Log.d("AUTO_COMPLETE", "Item position: " + position);
                Log.d("AUTO_COMPLETE", "Item Value: " + parent.getItemAtPosition(position));

                LinearLayout linearLayout = (LinearLayout) findViewById(R.id.blackBackground);
                linearLayout.setVisibility(View.INVISIBLE);
            }
        });
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Linda-a-Velha, Portugal.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Linda-a-Velha and move the camera
        LatLng lav = new LatLng(38.717212, -9.238582);
        mMap.addMarker(new MarkerOptions().position(lav).title("Marker in Linda-a-Velha"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(lav));
    }
}
