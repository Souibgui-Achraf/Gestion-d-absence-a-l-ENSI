package com.example.gestiondabsence.marqabs.confabs.new_pack;

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

public class MyAdapter4 extends RecyclerView.Adapter<MyHolder4> {
    Context c;
    ArrayList<Etudiant> etudiants ;

    public MyAdapter4(Context c, ArrayList<Etudiant> etudiants) {
        this.c = c;
        this.etudiants = etudiants;
    }

    @NonNull
    @Override
    public MyHolder4 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.ligne_test,null,false);
        view.setLayoutParams(new RecyclerView.LayoutParams(
                RecyclerView.LayoutParams.MATCH_PARENT,
                RecyclerView.LayoutParams.WRAP_CONTENT
        ));
        return new MyHolder4(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder4 holder, int position) {
        holder.textViewNom.setText(etudiants.get(position).getNom());
        holder.textViewPrenom.setText(etudiants.get(position).getPrenom());
        holder.textViewAnnee.setText(etudiants.get(position).getAnnee());
        holder.textViewClasse.setText(etudiants.get(position).getClasse());
    }

    @Override
    public int getItemCount() {
        return etudiants.size();
    }
}
