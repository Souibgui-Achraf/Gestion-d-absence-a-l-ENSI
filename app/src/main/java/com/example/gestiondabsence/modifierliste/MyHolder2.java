package com.example.gestiondabsence.modifierliste;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gestiondabsence.R;

public class MyHolder2 extends RecyclerView.ViewHolder {

    TextView textViewNom, textViewPrenom;
    Button buttonEdit, buttonDelete;

    public MyHolder2(@NonNull View itemView, final MyAdapter2.OnItemClickListener listener) {
        super(itemView);
        this.textViewNom = (TextView) itemView.findViewById(R.id.textViewNom);
        this.textViewPrenom = (TextView) itemView.findViewById(R.id.textViewPrenom);
        this.buttonEdit = (Button) itemView.findViewById(R.id.buttonEdit);
        this.buttonDelete = (Button) itemView.findViewById(R.id.buttonDelete);

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
        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(listener !=null){
                    int position = getAdapterPosition() ;
                    if(position != RecyclerView.NO_POSITION){
                        listener.onDeleteClick(position);
                    }
                }
            }
        });
        buttonEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(listener !=null){
                    int position = getAdapterPosition() ;
                    if(position != RecyclerView.NO_POSITION){
                        listener.onModifyClick(position);
                    }
                }
            }
        });
    }
}
