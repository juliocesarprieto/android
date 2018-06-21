package com.example.jl.geren_hospitalar;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import model.Hospitais;

public class MyAdapterHospital extends RecyclerView.Adapter<LineHospitalHolder> {

    private List<Hospitais> hospitais;


    public MyAdapterHospital(List<Hospitais> hospitais) {
        this.hospitais = hospitais;
    }

//    public static class ViewHolder extends RecyclerView.ViewHolder{
//
//        public TextView mTextView;
//        public ViewHolder(TextView v) {
//            super(v);
//            mTextView = v;
//        }
//    }

    @NonNull
    @Override
    public LineHospitalHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        new LineHolder(LayoutInflater.from(parent.getContext())
//                .inflate(R.layout.main_line_view, parent, false))
        return new LineHospitalHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.line_view_hospital, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull LineHospitalHolder holder, int position) {
        holder.title.setText(hospitais.get(position).getHospNome());
//        holder.subtitle.setText(hospitais.get(position).getHospTel());
        holder.atualizarUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), AtualizarHospitais.class);
                intent.putExtra("object", hospitais.get(position));
                view.getContext().startActivity(intent);
                //Toast.makeText(view.getContext(), hosp, Toast.LENGTH_SHORT ).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return hospitais.size();
    }


}
