package com.example.mezqu.ejercicio;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Puntaje extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_puntaje);
        setListAdapter(new adaptadorLista(Puntaje.this));
    }
}

