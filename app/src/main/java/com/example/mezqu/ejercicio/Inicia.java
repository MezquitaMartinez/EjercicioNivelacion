package com.example.mezqu.ejercicio;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class Inicia extends AppCompatActivity {
    TextView txtPuntosT, txtPuntosEmpatados, txtPuntosPerdedor,txtPuntosGanador, txtplayer;
    Button btnFin, btnCPU, btnPiedra, btnPapel,btnTijera;

    //public static int Pganados, Pempatados, Pperdidos, PuntosT = 0;
    int Pganados, Pempatados, Pperdidos, PuntosT = 0;
    public static String eleccionPC, eleccionHumano, Nick;
    int eleccionMaquina = 0;
    Random Maquina;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicia);

        this.txtPuntosT = findViewById(R.id.txtPuntos);
        this.txtPuntosEmpatados = findViewById(R.id.txtEmpatados);
        this.txtPuntosGanador = findViewById(R.id.txtGanado);
        this.txtPuntosPerdedor = findViewById(R.id.txtPerdedor);
        this.txtplayer = findViewById(R.id.txtPlayer);
        this.btnFin = findViewById(R.id.btnFin);
        this.btnCPU = findViewById(R.id.btnCPU);
        this.btnPiedra = findViewById(R.id.btnPiedra);
        this.btnPapel = findViewById(R.id.btnPapel);
        this.btnTijera = findViewById(R.id.btnTIjera);


        Bundle datos = this.getIntent().getExtras();

        Nick = datos.getString("NickJugador");

        txtplayer.setText(Nick);

        //EleccionMaquina();  ////////////////////////////////////////

        this.btnFin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatosLista nuevoJugador = new DatosLista();
                nuevoJugador.setNombreJugador(txtplayer.getText().toString());                          //para obtener lo que trae la caja de texto en este caso el nombre
                nuevoJugador.setPuntaje(Integer.parseInt(txtPuntosT.getText().toString()));             //para obtener el puntaje del jugador
                //Validacion de la posicion en la que se encontrara
                if (adaptadorLista.lista[0] != null){
                    if (nuevoJugador.getPuntaje() > adaptadorLista.lista[0].getPuntaje()){
                        //Movemos posiciones de los tres jugadores con sun respectivo puntaje
                        adaptadorLista.lista[2] = adaptadorLista.lista[1];
                        adaptadorLista.lista[1] = adaptadorLista.lista[0];
                        adaptadorLista.lista[0] = nuevoJugador;
                    }else {
                        if (adaptadorLista.lista[1] != null){
                            if (nuevoJugador.getPuntaje() > adaptadorLista.lista[1].getPuntaje()){
                                //Movemos posiciones de los dos ultimos jugadores
                                adaptadorLista.lista[2] = adaptadorLista.lista[1];
                                adaptadorLista.lista[1] =  nuevoJugador;
                            }else{
                                if (adaptadorLista.lista[2] != null){
                                    if (nuevoJugador.getPuntaje() > adaptadorLista.lista[2].getPuntaje()){
                                        //Movemos al ultimo jugador
                                        adaptadorLista.lista[2] = nuevoJugador;
                                    }
                                }else{
                                    adaptadorLista.lista[2] = nuevoJugador;
                                }
                            }
                        }else{
                            adaptadorLista.lista[1] = nuevoJugador;
                        }
                    }
                }else{
                    adaptadorLista.lista[0] = nuevoJugador;
                }
                Toast.makeText(Inicia.this, "Fin del Juego", Toast.LENGTH_LONG).show();          //**********************
                finish();
            }
        });

        this.btnTijera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eleccionHumano = "X";
                EleccionMaquina();
                InicioJuego(eleccionHumano, eleccionPC);
            }
        });

        this.btnPapel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eleccionHumano = "[_]";
                EleccionMaquina();
                InicioJuego(eleccionHumano, eleccionPC);
            }
        });

        this.btnPiedra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eleccionHumano = "O";
                EleccionMaquina();
                InicioJuego(eleccionHumano, eleccionPC);
            }
        });
    }

    public void EleccionMaquina(){
        Maquina = new Random();
        eleccionMaquina = Maquina.nextInt(3);
        switch (eleccionMaquina){
            case 0 : this.eleccionPC = "O";
                break;
            case 1 : this.eleccionPC = "[_]";
                break;
            case 2 : this.eleccionPC = "X";
                break;
        }
    }

    public void InicioJuego(String eleccion1, String eleccion2){
        this.btnCPU.setText(eleccionPC);

        if (eleccion1 == eleccion2){
            Toast.makeText(Inicia.this, "Ha obtenido un Empate!!! " + Nick, Toast.LENGTH_LONG).show();                                //**********
            Pempatados++;
            PuntosT++;
        }else if ((eleccion1=="[_]" && eleccion2=="O")|(eleccion1=="X" && eleccion2=="[_]")|(eleccion1=="O" && eleccion2=="X")){
            Toast.makeText(Inicia.this, "Usted ha sido el vencedor!! " + Nick, Toast.LENGTH_LONG).show();                             //************
            Pganados++;
            PuntosT += 6;
        }else{
            Toast.makeText(Inicia.this, "Usted ha perdido, La Maquina ha sido la ganadora!! " + Nick, Toast.LENGTH_LONG).show();      //*************
            Pperdidos++;
            PuntosT -= 3;
        }
        txtPuntosGanador.setText(String.valueOf(Pganados));
        txtPuntosEmpatados.setText(String.valueOf(Pempatados));
        txtPuntosPerdedor.setText(String.valueOf(Pperdidos));
        txtPuntosT.setText(String.valueOf(PuntosT));
    }
}

