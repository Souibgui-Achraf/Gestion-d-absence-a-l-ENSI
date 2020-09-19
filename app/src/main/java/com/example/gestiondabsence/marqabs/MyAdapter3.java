package com.example.gestiondabsence.marqabs;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gestiondabsence.Etudiant;
import com.example.gestiondabsence.R;
import com.example.gestiondabsence.modifierliste.MyAdapter2;
import com.example.gestiondabsence.modifierliste.MyHolder2;

import java.util.ArrayList;

public class MyAdapter3 extends RecyclerView.Adapter<MyHolder3>{
    Context c;
    ArrayList<Etudiant> etudiants ;
    private MyAdapter3.OnItemClickListener myListener ;
    public interface OnItemClickListener{
        void onAbsenceClick(int position,boolean isChecked) ;
    }
    public void setOnItemClickListener(MyAdapter3.OnItemClickListener listener){
        myListener = listener ;
    }
    public MyAdapter3(Context c, ArrayList<Etudiant> etudiants) {
        this.c = c;
        this.etudiants = etudiants;
    }

    @NonNull
    @Override
    public MyHolder3 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.ligne_abs,null,false);
        view.setLayoutParams(new RecyclerView.LayoutParams(
                RecyclerView.LayoutParams.MATCH_PARENT,
                RecyclerView.LayoutParams.WRAP_CONTENT
        ));
        return new MyHolder3(view,myListener);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder3 holder, int position) {
        holder.textViewNom.setText(etudiants.get(position).getNom());
        holder.textViewPrenom.setText(etudiants.get(position).getPrenom());
    }

    @Override
    public int getItemCount() {
        return etudiants.size();
    }
}
