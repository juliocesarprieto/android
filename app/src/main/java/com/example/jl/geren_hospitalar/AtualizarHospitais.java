package com.example.jl.geren_hospitalar;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.math.BigInteger;

import model.Hospitais;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import services.HospitaisService;

public class AtualizarHospitais extends AppCompatActivity {

    private Hospitais hospitais;

    private EditText txtRazao;
    private EditText txtCnpj;
    private EditText txtEndHosp;
    private EditText txtTel;

    private Button btnAtualizarHosp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atualizar_hospitais);

        btnAtualizarHosp = findViewById(R.id.bntAtualizarHosp);

        txtRazao = findViewById(R.id.txtRazao);
        txtCnpj = findViewById(R.id.txtCnpj);
        txtEndHosp = findViewById(R.id.txtEndHosp);
        txtTel = findViewById(R.id.txtTel);

        Intent intent = getIntent();
        hospitais = (Hospitais) intent.getSerializableExtra("object");

        if(hospitais !=null){
            txtRazao.setText(hospitais.getHospNome());
            txtCnpj.setText(hospitais.getHospCnpj().toString());
            txtEndHosp.setText(hospitais.getHospEndereco());
            txtTel.setText(hospitais.getHospTel().toString());
        }

        btnAtualizarHosp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                hospitais.setHospNome(txtRazao.getText().toString());
                hospitais.setHospCnpj(new BigInteger(txtCnpj.getText().toString()));
                hospitais.setHospEndereco(txtEndHosp.getText().toString());
                hospitais.setHospTel(Integer.parseInt(txtTel.getText().toString()));

                Retrofit retrofit = ConfigRetrofit.config();
                HospitaisService hospitaisService = retrofit.create(HospitaisService.class);
                Call<Hospitais> hospitaisResp = hospitaisService.atualizarHospitais(hospitais);

                hospitaisResp.enqueue(new Callback<Hospitais>() {
                    @Override
                    public void onResponse(Call<Hospitais> call, Response<Hospitais> response) {
                        txtRazao.setText("");
                        txtCnpj.setText("");
                        txtEndHosp.setText("");
                        txtTel.setText("");
                        Toast.makeText(getApplicationContext(), "Atualização com sucesso!", Toast.LENGTH_SHORT).show();
                        AtualizarHospitais.this.finish();
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
