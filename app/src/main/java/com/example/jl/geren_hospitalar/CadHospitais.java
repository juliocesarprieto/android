package com.example.jl.geren_hospitalar;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.math.BigInteger;

import model.Clientes;
import model.Hospitais;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import services.ClientesService;
import services.HospitaisService;

public class CadHospitais extends AppCompatActivity {

    private EditText txtRazaoHosp;
    private EditText txtCnpjHosp;
    private EditText txtEndHosp;
    private EditText txtTelHosp;

    private Button btnCadastrarHosp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cad_hospitais);

        txtRazaoHosp = findViewById(R.id.txtRazaoHosp);
        txtCnpjHosp = findViewById(R.id.txtCnpjHosp);
        txtEndHosp = findViewById(R.id.txtEndHosp);
        txtTelHosp = findViewById(R.id.txtTelHosp);

        btnCadastrarHosp = findViewById(R.id.btnCadastrarHosp);

        btnCadastrarHosp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Retrofit retrofit = ConfigRetrofit.config();

                HospitaisService hospitaisService = retrofit.create(HospitaisService.class);

                Call<Hospitais> resp = hospitaisService.inserirNovoHospitais(new Hospitais(
                            0,
                            txtRazaoHosp.getText().toString(),
                            new BigInteger(txtCnpjHosp.getText().toString()),
                            txtEndHosp.getText().toString(),
                            Integer.parseInt(txtTelHosp.getText().toString())
                ));

                resp.enqueue(new Callback<Hospitais>() {
                    @Override
                    public void onResponse(Call<Hospitais> call, Response<Hospitais> response) {

                        txtRazaoHosp.setText("");
                        txtCnpjHosp.setText("");
                        txtEndHosp.setText("");
                        txtTelHosp.setText("");

                        Toast.makeText(getApplicationContext(), "Guardado com sucesso!", Toast.LENGTH_SHORT).show();
                        CadHospitais.this.finish();
                    }

                    @Override
                    public void onFailure(Call<Hospitais> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), "Erro! "+t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}
