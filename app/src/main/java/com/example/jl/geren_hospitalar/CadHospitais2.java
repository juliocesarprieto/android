package com.example.jl.geren_hospitalar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class CadHospitais2 extends AppCompatActivity {

    public void home(View view){

        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }

    public void atualhospital(View view){

        Intent intent = new Intent(getApplicationContext(), AtualizarHospitais.class);
        startActivity(intent);
    }

    public void cadhospital(View view){

        Intent intent = new Intent(getApplicationContext(), CadHospitais.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cad_hospitais2);
    }
}
