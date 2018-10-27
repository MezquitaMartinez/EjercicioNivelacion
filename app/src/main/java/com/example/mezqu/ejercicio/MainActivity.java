package com.example.mezqu.ejercicio;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btnNuevo,btnInicia,btnPuntaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickButton(View view){
        if(view.getId()==R.id.btnNuevo){
            Intent Nuevo = new Intent(this, Nuevo.class);
            startActivity(Nuevo);

        }else if(view.getId()==R.id.btnInicia){
            Intent Inicia = new Intent(this, Inicia.class);
            startActivity(Inicia);

        } else if(view.getId()==R.id.btnPuntaje){
            Intent Puntaje = new Intent(this, Puntaje.class);
            startActivity(Puntaje);
        }
    }

    }
