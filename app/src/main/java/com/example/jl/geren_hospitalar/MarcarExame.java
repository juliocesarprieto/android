package com.example.jl.geren_hospitalar;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class MarcarExame extends AppCompatActivity {

    private Spinner spinnerExNome = null;
    private Spinner spinnerExHosp = null;
    private Spinner spinnerExCli = null;
    private Spinner spinnerExMed = null;
    private Spinner spinnerExData = null;
    private Spinner spinnerExHora = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marcar_exame);

        spinnerExNome = (Spinner) findViewById(R.id.spinnerExNome);
        spinnerExHosp = (Spinner) findViewById(R.id.spinnerExHosp);
        spinnerExCli = (Spinner) findViewById(R.id.spinnerExCli);
        spinnerExMed = (Spinner) findViewById(R.id.spinnerExMed);
        spinnerExData = (Spinner) findViewById(R.id.spinnerExData);
        spinnerExHora = (Spinner) findViewById(R.id.spinnerExHora);

        ArrayAdapter<CharSequence> adapter_exnome = ArrayAdapter.createFromResource(this, R.array.app_exnome,
                android.R.layout.simple_spinner_item);

        ArrayAdapter<CharSequence> adapter_exhosp = ArrayAdapter.createFromResource(this, R.array.app_exhospital,
                android.R.layout.simple_spinner_item);

        ArrayAdapter<CharSequence> adapter_excli = ArrayAdapter.createFromResource(this, R.array.app_excliente,
                android.R.layout.simple_spinner_item);

        ArrayAdapter<CharSequence> adapter_exmed = ArrayAdapter.createFromResource(this, R.array.app_exmedico,
                android.R.layout.simple_spinner_item);

        ArrayAdapter<CharSequence> adapter_exdata = ArrayAdapter.createFromResource(this, R.array.app_exdataa,
                android.R.layout.simple_spinner_item);

        ArrayAdapter<CharSequence> adapter_exhora = ArrayAdapter.createFromResource(this, R.array.app_exhoraa,
                android.R.layout.simple_spinner_item);

        adapter_exnome.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter_exhosp.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter_excli.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter_exmed.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter_exdata.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter_exhora.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerExNome.setAdapter(adapter_exnome);
        spinnerExHosp.setAdapter(adapter_exhosp);
        spinnerExCli.setAdapter(adapter_excli);
        spinnerExMed.setAdapter(adapter_exmed);
        spinnerExData.setAdapter(adapter_exdata);
        spinnerExHora.setAdapter(adapter_exhora);

        Button enviar = (Button) findViewById(R.id.bntMarcarExame);
        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MarcarExame.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
