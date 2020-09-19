package com.example.gestiondabsence.marqabs;

import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gestiondabsence.R;
import com.example.gestiondabsence.modifierliste.MyAdapter2;

public class MyHolder3 extends RecyclerView.ViewHolder{
    TextView textViewNom, textViewPrenom;
    CheckBox checkabs;

    public MyHolder3(@NonNull View itemView, final MyAdapter3.OnItemClickListener listener) {
        super(itemView);
        this.textViewNom = (TextView) itemView.findViewById(R.id.textViewNom);
        this.textViewPrenom = (TextView) itemView.findViewById(R.id.textViewPrenom);
        this.checkabs = (CheckBox) itemView.findViewById(R.id.checkBox);

        /*itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(listener !=null){
                    int position = getAdapterPosition() ;
                    if(position != RecyclerView.NO_POSITION){
                        listener.onItemClick(position);
                    }
                }
            }
        });*/
        checkabs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(listener !=null){
                    int position = getAdapterPosition() ;
                    if(position != RecyclerView.NO_POSITION){
                        listener.onAbsenceClick(position,checkabs.isSelected());
                    }
                }
            }
        });

    }
}
