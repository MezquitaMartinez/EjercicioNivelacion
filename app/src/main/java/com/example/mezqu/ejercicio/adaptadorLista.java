package com.example.mezqu.ejercicio;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class adaptadorLista extends BaseAdapter {

    public static DatosLista[] lista = new DatosLista[3];
    private Context contextoPrincipal;


    public adaptadorLista(Context contexto) {
        this.contextoPrincipal = contexto;
    }

    @Override
    public int getCount() {
        return lista.length;
    }

    @Override
    public Object getItem(int position) {
        return lista[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //Validar que la vista este vacia
        if (convertView == null) {
            LayoutInflater creadorLayout = (LayoutInflater) this.contextoPrincipal.getSystemService(this.contextoPrincipal.LAYOUT_INFLATER_SERVICE);
            convertView = creadorLayout.inflate(R.layout.plantilla_puntaje, null);
            //convertView = creadorLayout.inflate(this.idPlantillaPuntaje, null);

            TextView txtNombreLista = (TextView) convertView.findViewById(R.id.txtNombre);
            TextView txtPuntaje = (TextView) convertView.findViewById(R.id.txtPuntaje);


            if (lista[position] != null) {
                //Se crean los textView
                DatosLista nuevoItem = lista[position];
                txtNombreLista.setText(nuevoItem.getNombreJugador());
                txtPuntaje.setText(Integer.toString(nuevoItem.getPuntaje()));       //sino lo convierto a string me da problemas por que no acepta el tipo int asi que eso es necesario
            } else {
                txtNombreLista.setText("");
                txtPuntaje.setText("");
            }
        }

            return convertView;
        }
}



