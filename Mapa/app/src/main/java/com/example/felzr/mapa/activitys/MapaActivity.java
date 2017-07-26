package com.example.felzr.mapa.activitys;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.example.felzr.mapa.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapaActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private String nome;
    private double lat, longi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapa);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        Intent i = getIntent();
        nome = i.getStringExtra("nome");
        lat = i.getDoubleExtra("latitude", -1);
        longi = i.getDoubleExtra("longitude",-1);

        mMap = googleMap;
        LatLng local = new LatLng(lat, longi);
        mMap.addMarker(new MarkerOptions().position(local).title(nome));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(lat, longi), 13));
        mMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
            @Override
            public void onInfoWindowClick(Marker marker) {
                Intent intent = new Intent(MapaActivity.this, LocalActivity.class);
                intent.putExtra("nomeLugar", marker.getTitle());
                startActivity(intent);
            }
        });
    }

}
