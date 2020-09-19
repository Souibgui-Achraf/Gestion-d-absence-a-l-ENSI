package com.example.gestiondabsence.marqabs.confabs.new_pack;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gestiondabsence.R;

public class MyHolder4 extends RecyclerView.ViewHolder {
    TextView textViewNom,textViewPrenom ,textViewAnnee , textViewClasse;
    public MyHolder4(@NonNull View itemView) {
        super(itemView);
        this.textViewNom =(TextView) itemView.findViewById(R.id.textViewNom);
        this.textViewPrenom =(TextView) itemView.findViewById(R.id.textViewPrenom);
        this.textViewAnnee =(TextView) itemView.findViewById(R.id.textViewanneetest);
        this.textViewClasse =(TextView) itemView.findViewById(R.id.textViewclassetest);
    }
}

