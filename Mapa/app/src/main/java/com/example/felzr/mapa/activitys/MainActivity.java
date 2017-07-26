package com.example.felzr.mapa.activitys;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.felzr.mapa.R;
import com.example.felzr.mapa.adapter.LocalAdapter;
import com.example.felzr.mapa.firebase.FirebaseControle;
import com.example.felzr.mapa.model.Local;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private LocalAdapter localAdapter;
    private List<Local> locais;
    private ListView listView;
    private DatabaseReference firebase;
    private ImageButton btAdd;
    private TextView textLocal;
    private String posicao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.lista);
        btAdd = (ImageButton) findViewById(R.id.btAdd);
        textLocal = (TextView) findViewById(R.id.textlocal);

        firebase = FirebaseControle.getFirebase();
        locais = new ArrayList<Local>();
        localAdapter = new LocalAdapter(getLayoutInflater(),locais);
        listView.setAdapter(localAdapter);

        firebase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Iterable<DataSnapshot> snap = dataSnapshot.getChildren();
                for(DataSnapshot dataSnapshot1: snap){
                    Local local = dataSnapshot1.getValue(Local.class);
                    locais.add(local);
                    localAdapter.notifyDataSetChanged();

                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        //Seleciona Local especifico
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, MapaActivity.class);
                Local local = locais.get(position);
                intent.putExtra("nome", local.getNome());
                intent.putExtra("latitude", local.getLatitude());
                intent.putExtra("longitude", local.getLongitude());
                startActivity(intent);
            }
        });

        //chama fragmento de mapa para adicionar locais
        btAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MapsActivity.class);
                startActivity(intent);
            }
        });
    }


}