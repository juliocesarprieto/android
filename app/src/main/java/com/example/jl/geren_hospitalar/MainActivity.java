package com.example.jl.geren_hospitalar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {



    public void clientes(View view){

        Intent intent = new Intent(getApplicationContext(), CadClientes.class);
        startActivity(intent);
    }

    public void hospitais2(View view){

        Intent intent = new Intent(getApplicationContext(), CadHospitais2.class);
        startActivity(intent);
    }


    public void exame(View view){

        Intent intent = new Intent(getApplicationContext(), MarcarExame.class);
        startActivity(intent);
    }

    public void consultas2(View view){

        Intent intent = new Intent(getApplicationContext(), MarcarConsulta2.class);
        startActivity(intent);
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
}
