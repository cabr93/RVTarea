package com.cabr93.rvtarea;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Carlos on 16/08/16.
 */
public class ContactoAdaptador2 extends RecyclerView.Adapter<ContactoAdaptador2.ContactoViewHolder>{

    ArrayList<Mascota> mascotas;
    Activity activity;
    private int [] lik = new  int[5];
    FavoritoMascota c = new FavoritoMascota();


    public ContactoAdaptador2(ArrayList<Mascota> mascotas,Activity activity){
        this.mascotas = mascotas;
        this.activity = activity;
    }

    @Override
    public ContactoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota,parent,false);
        lik = c.getLikes2();
        Log.i("bbba", Arrays.toString(lik));
        return new ContactoViewHolder(v);
    }
    @Override
    public int getItemCount() {// cantidad de elementos que contiene mi lista de contactos
        return mascotas.size();
    }

    @Override
    public void onBindViewHolder(final ContactoViewHolder contactoViewHolder, final int position) {
        final Mascota mascota = mascotas.get(position);
        contactoViewHolder.imgFoto.setImageResource(mascota.getFoto());
        contactoViewHolder.tvNombre.setText(mascota.getNombre());
        contactoViewHolder.tvLikes.setText(String.valueOf(lik[position]));
    }
    public static class ContactoViewHolder extends RecyclerView.ViewHolder{


        private ImageView imgFoto;
        private TextView tvNombre;
        private TextView tvLikes;


        public ContactoViewHolder(View itemView) {
            super(itemView);
            imgFoto     = (ImageView) itemView.findViewById(R.id.imgMascota) ;
            tvNombre    = (TextView) itemView.findViewById(R.id.nombre);
            tvLikes     = (TextView) itemView.findViewById(R.id.cantidaLike);
        }
    }
}
