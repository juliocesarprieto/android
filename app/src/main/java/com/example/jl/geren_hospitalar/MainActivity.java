package com.example.jl.geren_hospitalar;

import android.app.Activity;
import android.content.Intent;
//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView imgHospital;
    private ImageView imgClientes;
    private ImageView imgConsultas;
    private ImageView imgExame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        imgHospital = findViewById(R.id.imgHospitais);
        imgClientes = findViewById(R.id.imgClientes);
        imgConsultas = findViewById(R.id.imgMarcarConsulta);
        imgExame = findViewById(R.id.imgMarcarExame);

        //Evento click no menu imagem hospitais
        imgHospital.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, CadHospitais2.class));
            }
        });

        //Evento click no menu imagem clientes
        imgClientes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, CadClientes.class));
            }
        });

        //Evento click no menu imagem consultas
        imgConsultas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, MarcarConsulta2.class));
            }
        });

        //Evento click no menu imagem Exame
        imgExame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, MarcarExame.class));
            }
        });
    }
}
