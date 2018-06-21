package com.example.jl.geren_hospitalar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import model.Clientes;
import model.Hospitais;
import model.Medicos;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import services.ClientesService;
import services.HospitaisService;
import services.MedicosService;

public class MarcarConsultaActivity extends AppCompatActivity {

    private Spinner spinnerHosp = null;
    private Spinner spinnerCli = null;
    private Spinner spinnerMed = null;

    private Button btnMarcarConsulta;

    private Hospitais hospitais;
    private Clientes clientes;
    private Medicos medicos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marcar_consulta);

        spinnerHosp = findViewById(R.id.spinnerHosp);


        spinnerCli = findViewById(R.id.spinnerCli);


        spinnerMed = findViewById(R.id.spinnerMed);

        Retrofit retrofit = ConfigRetrofit.config();

        carregarDadosHospitais(retrofit);
        carregarDadosClientes(retrofit);
        carregarDadosMedicos(retrofit);


       btnMarcarConsulta = (Button) findViewById(R.id.bntMarcarConsulta);
        btnMarcarConsulta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Hospitais hosp = (Hospitais) spinnerHosp.getSelectedItem();
                    Log.i("jdsjdkajd", hospitais.getHospNome());
            }
        });

    }

    public void carregarDadosHospitais(Retrofit retrofit){
        HospitaisService hospitaisService = retrofit.create(HospitaisService.class);
        Call<List<Hospitais>> hospitaisCall = hospitaisService.listarHospitais();

        hospitaisCall.enqueue(new Callback<List<Hospitais>>() {
            @Override
            public void onResponse(Call<List<Hospitais>> call, Response<List<Hospitais>> response) {

                setDataSpinnerHospitais(response.body());

            }
            @Override
            public void onFailure(Call<List<Hospitais>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Error "+t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }

    public void carregarDadosClientes(Retrofit retrofit){
        ClientesService clientesService = retrofit.create(ClientesService.class);
        Call<List<Clientes>> clienteCall = clientesService.listClientes();

        clienteCall.enqueue(new Callback<List<Clientes>>() {
            @Override
            public void onResponse(Call<List<Clientes>> call, Response<List<Clientes>> response) {

                setDataSpinnerClientes(response.body());

            }
            @Override
            public void onFailure(Call<List<Clientes>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Error "+t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }

    public void carregarDadosMedicos(Retrofit retrofit){
        MedicosService medicosService = retrofit.create(MedicosService.class);
        Call<List<Medicos>> mediListCall = medicosService.listMedicos();

        mediListCall.enqueue(new Callback<List<Medicos>>() {
            @Override
            public void onResponse(Call<List<Medicos>> call, Response<List<Medicos>> response) {

                setDataSpinnerMedicos(response.body());

            }
            @Override
            public void onFailure(Call<List<Medicos>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Error "+t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }

    public void setDataSpinnerHospitais(List<Hospitais> hosp) {
        ArrayAdapter<Hospitais> adapterHosp = new ArrayAdapter<Hospitais>(this, R.layout.support_simple_spinner_dropdown_item, hosp);
        spinnerHosp.setAdapter(adapterHosp);

    }

    public void setDataSpinnerClientes(List<Clientes> clientes) {
        ArrayAdapter<Clientes> adapterCli = new ArrayAdapter<Clientes>(this, R.layout.support_simple_spinner_dropdown_item, clientes);
        spinnerCli.setAdapter(adapterCli);
    }

    public void setDataSpinnerMedicos(List<Medicos> medicos) {
        ArrayAdapter<Medicos> adapterMed= new ArrayAdapter<Medicos>(this, R.layout.support_simple_spinner_dropdown_item, medicos);
        spinnerMed.setAdapter(adapterMed);
    }
}
