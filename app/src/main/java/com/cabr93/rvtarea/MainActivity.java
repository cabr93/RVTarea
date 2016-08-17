package com.cabr93.rvtarea;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Mascota> mascotas;
    private RecyclerView listaContactos;
    protected static int [] likes = new  int[] {0,0,0,0,0};

    public int[] getLikes() {
        return likes;
    }

    public void setLikes(int[] likes) {
        this.likes = likes;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);

        listaContactos = (RecyclerView) findViewById(R.id.rvmascotas);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaContactos.setLayoutManager(llm);

        inicializarLista();

        inicializarAdaptador();


    }
    public void inicializarAdaptador(){
        ContactoAdaptador adaptador = new ContactoAdaptador(mascotas,this);
        listaContactos.setAdapter(adaptador);

    }
    public void inicializarLista(){
        mascotas = new ArrayList<Mascota>();

        mascotas.add(new Mascota("Yorkshire",String.valueOf(likes[0]),R.drawable.p1));
        mascotas.add(new Mascota("Beagle",String.valueOf(likes[1]),R.drawable.p2));
        mascotas.add(new Mascota("Pug",String.valueOf(likes[2]),R.drawable.p3));
        mascotas.add(new Mascota("Chow chow",String.valueOf(likes[3]),R.drawable.p4));
        mascotas.add(new Mascota("Bulldog Terrier",String.valueOf(likes[4]),R.drawable.mascota1));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent i = new Intent(this,FavoritoMascota.class);
        startActivity(i);
        return super.onOptionsItemSelected(item);
    }

}