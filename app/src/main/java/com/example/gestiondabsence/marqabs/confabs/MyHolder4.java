package com.example.gestiondabsence.marqabs.confabs;

import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gestiondabsence.R;
import com.example.gestiondabsence.marqabs.MyAdapter3;

public class MyHolder4 extends RecyclerView.ViewHolder{
    TextView textViewNom, textViewPrenom;

    public MyHolder4(@NonNull View itemView) {
        super(itemView);
        this.textViewNom = (TextView) itemView.findViewById(R.id.textViewNom);
        this.textViewPrenom = (TextView) itemView.findViewById(R.id.textViewPrenom);

    }
}
