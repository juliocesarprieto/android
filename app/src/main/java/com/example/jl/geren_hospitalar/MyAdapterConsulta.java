package com.example.jl.geren_hospitalar;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import services.MarcarConsultasService;

public class MyAdapterConsulta extends RecyclerView.Adapter<LineConsultasHolder> {

    private List<model.MarcarConsulta> consultas;

    public MyAdapterConsulta(List<model.MarcarConsulta> consultas){
        this.consultas = consultas;
    }

    @NonNull
    @Override
    public LineConsultasHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new LineConsultasHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.line_consultas, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull LineConsultasHolder holder, int position) {


        holder.txtTitleConsulta.setText(consultas.get(position).getCliente().getCliNome());

        holder.btnDeleteConsulta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Retrofit retrofit = ConfigRetrofit.config();
                MarcarConsultasService marcarConsultasService = retrofit.create(MarcarConsultasService.class);
                Call<Void> consultaCall = marcarConsultasService.deleteConsulta(consultas.get(position).getMconsId());
                consultaCall.enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {
                            consultas.remove(position);
                            Toast.makeText(view.getContext(), "Removido com sucesso!", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {
                        Toast.makeText(view.getContext(), "Erro "+t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }

    @Override
    public int getItemCount() {
        return consultas.size();
    }
}
