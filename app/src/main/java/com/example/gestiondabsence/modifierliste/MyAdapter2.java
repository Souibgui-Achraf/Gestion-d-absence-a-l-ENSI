package com.example.gestiondabsence.modifierliste;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gestiondabsence.Etudiant;
import com.example.gestiondabsence.R;
import com.example.gestiondabsence.listeetudiants.MyHolder;

import java.util.ArrayList;

public class MyAdapter2 extends RecyclerView.Adapter<MyHolder2>{
    Context c;
    ArrayList<Etudiant> etudiants ;
    private OnItemClickListener myListener ;
    public interface OnItemClickListener{
        //void onItemClick(int position);
        void onDeleteClick(int position) ;
        void onModifyClick(int position);
    }
    public void setOnItemClickListener(OnItemClickListener listener){
        myListener = listener ;
    }
    public MyAdapter2(Context c, ArrayList<Etudiant> etudiants) {
        this.c = c;
        this.etudiants = etudiants;
    }

    @NonNull
    @Override
    public MyHolder2 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.ligne_modifier,null,false);
        view.setLayoutParams(new RecyclerView.LayoutParams(
                RecyclerView.LayoutParams.MATCH_PARENT,
                RecyclerView.LayoutParams.WRAP_CONTENT
        ));
        return new MyHolder2(view,myListener);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder2 holder, int position) {
        holder.textViewNom.setText(etudiants.get(position).getNom());
        holder.textViewPrenom.setText(etudiants.get(position).getPrenom());
    }

    @Override
    public int getItemCount() {
        return etudiants.size();
    }
}
