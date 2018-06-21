package com.example.jl.geren_hospitalar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.List;

import model.MarcarConsulta;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import services.MarcarConsultasService;

public class MarcarConsulta2 extends AppCompatActivity {


    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

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
        Intent intent = new Intent(getApplicationContext(), MarcarConsultaActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marcar_consulta2);
    }

    @Override
    protected void onStart() {
        super.onStart();

        // The activity is about to become visible.
        mRecyclerView = findViewById(R.id.MyRecyclerViewConsultas);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        Retrofit retrofit = ConfigRetrofit.config();

        MarcarConsultasService marcarConsultasService = retrofit.create(MarcarConsultasService.class);
        Call<List<MarcarConsulta>> consultasCall = marcarConsultasService.listarConsultas();
        consultasCall.enqueue(new Callback<List<MarcarConsulta>>() {
            @Override
            public void onResponse(Call<List<MarcarConsulta>> call, Response<List<MarcarConsulta>> response) {
                mAdapter = new MyAdapterConsulta(response.body());
                mRecyclerView.setAdapter(mAdapter);
                Toast.makeText(getApplicationContext(), "Consultas carregadass!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<List<MarcarConsulta>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Erro "+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}
