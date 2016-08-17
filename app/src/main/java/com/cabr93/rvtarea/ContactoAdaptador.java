package com.cabr93.rvtarea;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Carlos on 16/05/16.
 */
public class ContactoAdaptador extends RecyclerView.Adapter<ContactoAdaptador.ContactoViewHolder>{

    ArrayList<Mascota> mascotas;
    Activity activity;
    private int [] lik = new  int[5];
    MainActivity c = new MainActivity();


    public ContactoAdaptador(ArrayList<Mascota> mascotas,Activity activity){
        this.mascotas = mascotas;
        this.activity = activity;
    }

    @Override
    public ContactoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota,parent,false);
        lik = c.getLikes();
        return new ContactoViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ContactoViewHolder contactoViewHolder, final int position) {
        final Mascota mascota = mascotas.get(position);
        contactoViewHolder.imgFoto.setImageResource(mascota.getFoto());
        contactoViewHolder.tvNombre.setText(mascota.getNombre());
        contactoViewHolder.tvLikes.setText(String.valueOf(lik[position]));
        contactoViewHolder.imgLikes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lik = c.getLikes();
                lik[position] = lik[position]+1;
                c.setLikes(lik);
                contactoViewHolder.tvLikes.setText(String.valueOf(lik[position]));


            }
        });
    }

    @Override
    public int getItemCount() {// cantidad de elementos que contiene mi lista de contactos
        return mascotas.size();
    }

    public static class ContactoViewHolder extends RecyclerView.ViewHolder{


        private ImageView imgFoto;
        private TextView tvNombre;
        private TextView tvLikes;
        private ImageView imgLikes;


        public ContactoViewHolder(View itemView) {
            super(itemView);
            imgFoto     = (ImageView) itemView.findViewById(R.id.imgMascota) ;
            tvNombre    = (TextView) itemView.findViewById(R.id.nombre);
            tvLikes     = (TextView) itemView.findViewById(R.id.cantidaLike);
            imgLikes    = (ImageView) itemView.findViewById(R.id.cantidaLike2);
        }
    }
}
