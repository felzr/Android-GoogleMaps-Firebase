package com.example.felzr.mapa.model;

import com.google.firebase.database.Exclude;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by felzr on 06/07/2017.
 */

public class Local {
    private String nome;
    private Double latitude;
    private Double longitude;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }
    @Exclude
    public Map<String, Object> toMap() {
        HashMap<String, Object> obj = new HashMap<>();
        obj.put("nome", nome);
        obj.put("latitude", latitude);
        obj.put("longitude", longitude);

        return obj;
    }
}
