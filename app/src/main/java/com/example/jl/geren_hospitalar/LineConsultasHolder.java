package com.example.jl.geren_hospitalar;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class LineConsultasHolder extends RecyclerView.ViewHolder {

    public TextView txtTitleConsulta;
    public ImageButton btnDeleteConsulta;

    public LineConsultasHolder(View itemView) {
        super(itemView);
        txtTitleConsulta = (TextView) itemView.findViewById(R.id.txtTitleConsulta);
        btnDeleteConsulta = (ImageButton) itemView.findViewById(R.id.btnDeleteConsulta);
    }
}
