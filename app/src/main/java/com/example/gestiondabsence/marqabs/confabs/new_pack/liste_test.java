package com.example.gestiondabsence.marqabs.confabs.new_pack;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import com.example.gestiondabsence.Etudiant;
import com.example.gestiondabsence.R;
import com.example.gestiondabsence.database.Extras;
import com.example.gestiondabsence.listeetudiants.ListeEtudiantActivity;
import com.example.gestiondabsence.listeetudiants.MyAdapter;

import java.util.ArrayList;

public class liste_test extends AppCompatActivity {
    RecyclerView myRecyclerView;
    MyAdapter4 myAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_test);

        myRecyclerView = findViewById(R.id.recyclerView3);

/*

    /*private ArrayList<Etudiant> getList() {
        ArrayList<Etudiant> etudiants = new ArrayList<>();
        etudiants.add(new Etudiant("Ben gabsia", "Mohamed fawzi", "1", "d"));
        etudiants.add(new Etudiant("Ahmed", "Souibgui", "1", "d"));
        return etudiants;
    }*/

        ArrayList<Etudiant> etudiants = new ArrayList<>();

        String annee = Extras.getAnnee();
        String classe = Extras.getClasse();

        //Toast.makeText(ListeEtudiantActivity.this,annee,Toast.LENGTH_LONG).show();



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