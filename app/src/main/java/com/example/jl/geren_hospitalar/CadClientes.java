package com.example.jl.geren_hospitalar;

import android.annotation.TargetApi;
import android.app.DatePickerDialog;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import model.Clientes;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import services.ClientesService;

import static java.time.format.DateTimeFormatter.ofPattern;

public class CadClientes extends AppCompatActivity {

    private Button btnCadClientes;
    private EditText txtNome;
    private EditText txtCpf;
    private EditText txtEndereco;
    private EditText txtTelefone;
    private EditText txtDtNasc;

    Calendar myCalendar = Calendar.getInstance();

    DatePickerDialog.OnDateSetListener  date = new DatePickerDialog.OnDateSetListener() {

        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear,
                              int dayOfMonth) {
            myCalendar.set(Calendar.YEAR, year);
            myCalendar.set(Calendar.MONTH, monthOfYear);
            myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            updateLabel();
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cad_clientes);

        txtNome = findViewById(R.id.txtNomeCliente);
        txtCpf = findViewById(R.id.txtCpfCliente);
        txtEndereco = findViewById(R.id.txtEndCliente);
        txtTelefone = findViewById(R.id.txtTelCliente);
        txtDtNasc = findViewById(R.id.txtDtNascCliente);
        txtDtNasc.setInputType(InputType.TYPE_NULL);

        txtDtNasc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(CadClientes.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }

        });

        btnCadClientes = findViewById(R.id.btnCadCliente);

        btnCadClientes.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.O)
            @Override
            public void onClick(View view) {
                Clientes cliente = new Clientes();
                cliente.setCliCpf(Integer.parseInt(txtCpf.getText().toString()));
                cliente.setCliNome(txtNome.getText().toString());
                cliente.setCliEnd(txtEndereco.getText().toString());
                cliente.setCliTel(Integer.parseInt(txtTelefone.getText().toString()));


                String myFormat = "dd/MM/yyyy"; //In which you need put here
                SimpleDateFormat sdf = new SimpleDateFormat(myFormat, new Locale("pt","BR"));

                try {
                    Date date = sdf.parse(txtDtNasc.getText().toString());
                    cliente.setCliDtNasc(date.getYear()+"-"+date.getMonth()+"-"+date.getDay());
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                Retrofit retrofit = ConfigRetrofit.config();
                ClientesService clientesService = retrofit.create(ClientesService.class);

                Call<Clientes> resp = clientesService.inserirNovoCliente(cliente);
                resp.enqueue(new Callback<Clientes>() {
                    @Override
                    public void onResponse(Call<Clientes> call, Response<Clientes> response) {
                        txtNome.setText("");
                        txtNome.requestFocus();
                        txtCpf.setText("");
                        txtEndereco.setText("");
                        txtTelefone.setText("");
                        txtDtNasc.setText("");
                        txtDtNasc.setText("");
                        Toast.makeText(getApplicationContext(), "Guardado com sucesso", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<Clientes> call, Throwable t) {

                        Toast.makeText(getApplicationContext(), "Error "+t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }

    private void updateLabel() {

        String myFormat = "dd/MM/yyyy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, new Locale("pt","BR"));

        txtDtNasc.setText(sdf.format(myCalendar.getTime()));
        txtDtNasc.setInputType(InputType.TYPE_NULL);
    }
}
