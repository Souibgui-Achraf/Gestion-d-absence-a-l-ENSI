package com.example.gestiondabsence.listeetudiants;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import com.example.gestiondabsence.Etudiant;
import com.example.gestiondabsence.database.EtudiantDatabase;
import com.example.gestiondabsence.database.Extras;
import com.example.gestiondabsence.R;

import java.util.ArrayList;

public class ListeEtudiantActivity extends AppCompatActivity {
    RecyclerView myRecyclerView;
    MyAdapter myAdapter;
    EtudiantDatabase myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_etudiant);
        myDb = new EtudiantDatabase(this);
        myRecyclerView = findViewById(R.id.recyclerView);

/*

    /*private ArrayList<Etudiant> getList() {
        ArrayList<Etudiant> etudiants = new ArrayList<>();
        etudiants.add(new Etudiant("Ben gabsia", "Mohamed fawzi", "1", "d"));
        etudiants.add(new Etudiant("Ahmed", "Souibgui", "1", "d"));
        return etudiants;
    }*/

        ArrayList<Etudiant> etudiants = new ArrayList<>();
        //Intent intent = getIntent();
        String annee = Extras.getAnnee();
        String classe = Extras.getClasse();

        Toast.makeText(ListeEtudiantActivity.this,annee,Toast.LENGTH_LONG).show();
       Cursor res = myDb.getListEtudiants(annee, classe);

        if (res.getCount() == 0) {
            //show message
            //showMessage("Error ","Nothing found");
            Toast.makeText(ListeEtudiantActivity.this,"vide",Toast.LENGTH_LONG).show();
            //finish();
        } else {
            String nom, prenom;
            while (res.moveToNext()) {
                nom = res.getString(1);
                prenom = res.getString(2);
                etudiants.add(new Etudiant(nom, prenom, annee, classe));
            }
            myRecyclerView.setLayoutManager(new LinearLayoutManager(this));
            myAdapter = new MyAdapter(this, etudiants);
            myRecyclerView.setAdapter(myAdapter);
        }
    }
}