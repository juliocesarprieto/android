package com.example.jl.geren_hospitalar;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class LineHospitalHolder  extends RecyclerView.ViewHolder{

        public TextView title;
        public TextView subtitle;
        public ImageButton atualizarUpdate;

        public LineHospitalHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.main_line_title_hosp);
            //subtitle = (TextView) itemView.findViewById(R.id.main_subline_title_hosp);
            atualizarUpdate = (ImageButton) itemView.findViewById(R.id.main_line_btnAtualizar_hosp);

        }
}

