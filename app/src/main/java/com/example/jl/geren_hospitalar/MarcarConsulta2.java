package com.example.jl.geren_hospitalar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MarcarConsulta2 extends AppCompatActivity {


    public void home(View view){
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }

    public void listconsulta(View view){
        Intent intent = new Intent(getApplicationContext(), ListarConsultas.class);
        startActivity(intent);
    }

    public void cancelconusulta(View view){
        Intent intent = new Intent(getApplicationContext(), CancelarConsultas.class);
        startActivity(intent);
    }

    public void marcarconsulta(View view){
        Intent intent = new Intent(getApplicationContext(), MarcarConsulta.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marcar_consulta2);
    }
}
