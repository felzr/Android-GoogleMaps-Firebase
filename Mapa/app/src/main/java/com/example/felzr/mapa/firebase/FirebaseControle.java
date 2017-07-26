package com.example.felzr.mapa.firebase;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by felzr on 06/07/2017.
 */

public class FirebaseControle {
    private static DatabaseReference referenciaFirebase;
    public static DatabaseReference getFirebase(){

        if( referenciaFirebase == null ){
            referenciaFirebase = FirebaseDatabase.getInstance().getReference("locais");
        }

        return referenciaFirebase;
    }

}
