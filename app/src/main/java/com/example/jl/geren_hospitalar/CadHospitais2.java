package com.example.jl.geren_hospitalar;

import android.app.Activity;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.List;

import model.Hospitais;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import services.HospitaisService;

public class CadHospitais2 extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private FloatingActionButton btnfloatingAdicionarHosp;

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

        btnfloatingAdicionarHosp = findViewById(R.id.btnfloatingAdicionarHosp);
        btnfloatingAdicionarHosp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), CadHospitais.class));
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        // The activity is about to become visible.
        mRecyclerView = findViewById(R.id.myRecyclerViewHosp);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        Retrofit retrofit = ConfigRetrofit.config();

        HospitaisService hospitaisService = retrofit.create(HospitaisService.class);

        Call<List<Hospitais>> hospitaisResp = hospitaisService.listarHospitais();

        hospitaisResp.enqueue(new Callback<List<Hospitais>>() {
            @Override
            public void onResponse(Call<List<Hospitais>> call, Response<List<Hospitais>> response) {
                mAdapter = new MyAdapterHospital(response.body());
                mRecyclerView.setAdapter(mAdapter);

               // Toast.makeText(getApplicationContext(), "Dados carregados!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<List<Hospitais>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Erro ao carregar Dados!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
