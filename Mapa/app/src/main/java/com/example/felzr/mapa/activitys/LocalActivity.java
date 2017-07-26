package com.example.felzr.mapa.activitys;

import android.content.Intent;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.example.felzr.mapa.R;

public class LocalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_local);

        Intent intent = getIntent();
        TextView texto = (TextView) findViewById(R.id.textView2);
        String titulo = intent.getStringExtra("nomeLugar");
        texto.setText(titulo);


    }

}
