package com.example.mezqu.ejercicio;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Nuevo extends AppCompatActivity {
    EditText Nick;
    Button btnAceptar;
    public static String NickHumano = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo);

        this.Nick = (EditText) findViewById(R.id.txtNick);
        this.btnAceptar = (Button) findViewById(R.id.btnAceptar);

        this.btnAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent jugadorNom = new Intent(Nuevo.this, Inicia.class);
                NickHumano = Nick.getText().toString();
                jugadorNom.putExtra("NickJugador", NickHumano);
                Toast.makeText(Nuevo.this, "Jugador guardado", Toast.LENGTH_LONG).show();
                startActivity(jugadorNom);
            }
        });
    }
}