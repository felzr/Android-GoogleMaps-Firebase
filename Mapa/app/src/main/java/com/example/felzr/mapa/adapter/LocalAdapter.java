package com.example.felzr.mapa.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.felzr.mapa.R;
import com.example.felzr.mapa.model.Local;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by felzr on 10/07/2017.
 */
public class LocalAdapter extends BaseAdapter{
    private List<Local> locais;
    private LayoutInflater inflater;

    public LocalAdapter(LayoutInflater inflater, List<Local> lista) {
        this.inflater = inflater;
        this.locais = lista;
    }

    @Override
    public int getCount() {
        return locais.size();
    }

    @Override
    public Object getItem(int position) {
        return locais.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = inflater.inflate(R.layout.itemlocal,null);
        TextView lat, longi, nome;
        nome = (TextView) convertView.findViewById(R.id.textlocal);
        lat = (TextView) convertView.findViewById(R.id.textLat);
        longi =  (TextView) convertView.findViewById(R.id.textLong);
        Local local = locais.get(position);
        String Slat = String.valueOf(local.getLatitude());
        String Slongi = String.valueOf(local.getLongitude());
        nome.setText(local.getNome().toString());
        lat.setText(Slat);
        longi.setText(Slongi);

        return convertView;
    }
}
