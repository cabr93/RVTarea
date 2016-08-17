package com.cabr93.rvtarea;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class FavoritoMascota extends AppCompatActivity {

    ArrayList<Mascota> mascotas;
    private RecyclerView listaContactos;
    private static int [] likes2 = new  int[5];

    public int[] getLikes2() {
        return likes2;
    }

    public void setLikes2(int[] likes2) {
        this.likes2 = likes2;
    }

    private int [] likes = new  int[5];
    private  String [] nombres = new String[5];
    private  int [] fotos = new int[5];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorito_mascota);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        listaContactos = (RecyclerView) findViewById(R.id.rvmascotas);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaContactos.setLayoutManager(llm);

        inicializarLista();

        inicializarAdaptador();
    }

    public void inicializarAdaptador(){
        ContactoAdaptador2 adaptador = new ContactoAdaptador2(mascotas,this);
        listaContactos.setAdapter(adaptador);

    }
    public void inicializarLista(){
        mascotas = new ArrayList<Mascota>();
        MainActivity c = new MainActivity();
        likes = c.getLikes();
        likes2 = Arrays.copyOf(likes, likes.length);


        nombres[0] = "Yorkshire";
        nombres[1] = "Beagle";
        nombres[2] = "Pug";
        nombres[3] = "Chow chow";
        nombres[4] = "Bulldog Terrier";
        fotos[0] = R.drawable.p1;
        fotos[1] = R.drawable.p2;
        fotos[2] = R.drawable.p3;
        fotos[3] = R.drawable.p4;
        fotos[4] = R.drawable.mascota1;

        Log.i("bbb", Arrays.toString(likes));

        for(int i=0;i<(likes2.length-1);i++){
            for(int j=i+1;j<likes2.length;j++){
                if(likes2[i]<likes2[j]){
                    int variableauxiliar=likes2[i];
                    likes2[i]=likes2[j];
                    likes2[j]=variableauxiliar;
                    String variableauxiliar2 = nombres[i];
                    nombres[i]=nombres[j];
                    nombres[j]=variableauxiliar2;
                    int variableauxiliar3= fotos[i];
                    fotos[i]=fotos[j];
                    fotos[j]=variableauxiliar3;

                }
            }
        }
        Log.i("bb", Arrays.toString(likes));
        Log.i("bb", Arrays.toString(likes2));



        for (int i = 0; i < (nombres.length); i++){
            mascotas.add(new Mascota(nombres[i],String.valueOf(likes2[i]), fotos[i]));
        }


    }
}
