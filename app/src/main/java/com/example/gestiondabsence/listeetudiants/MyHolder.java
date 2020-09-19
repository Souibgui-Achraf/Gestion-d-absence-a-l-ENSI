package com.example.gestiondabsence.listeetudiants;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gestiondabsence.R;

public class MyHolder extends RecyclerView.ViewHolder {
    TextView textViewNom,textViewPrenom ;
    public MyHolder(@NonNull View itemView) {
        super(itemView);
        this.textViewNom =(TextView) itemView.findViewById(R.id.textViewNom);
        this.textViewPrenom =(TextView) itemView.findViewById(R.id.textViewPrenom);
    }
}
