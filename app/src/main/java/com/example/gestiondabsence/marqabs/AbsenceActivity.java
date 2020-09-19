package com.example.gestiondabsence.marqabs;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.gestiondabsence.Etudiant;
import com.example.gestiondabsence.R;
import com.example.gestiondabsence.database.EtudiantDatabase;
import com.example.gestiondabsence.database.Extras;
import com.example.gestiondabsence.marqabs.confabs.ConfAbsActivity;
import com.example.gestiondabsence.modifierliste.ModifierActivity;
import com.example.gestiondabsence.modifierliste.MyAdapter2;
import com.example.gestiondabsence.modifierliste.tools.AddEtudiant;
import com.example.gestiondabsence.modifierliste.tools.EditEtudiant;

import java.util.ArrayList;

public class AbsenceActivity extends AppCompatActivity {
    RecyclerView myRecyclerView;
    MyAdapter3 myAdapter;
    EtudiantDatabase myDb;
    Button buttonConfAbs ;
    ArrayList<Etudiant> etudiantsAbsents = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_absence);

        myDb = new EtudiantDatabase(this);
        myRecyclerView = findViewById(R.id.recyclerView2);
        buttonConfAbs=(Button)findViewById(R.id.buttonConfAbs);
        final ArrayList<Etudiant> etudiants = new ArrayList<>();
        String annee = Extras.getAnnee();
        String classe = Extras.getClasse();

        // Toast.makeText(ListeEtudiantActivity.this,annee,Toast.LENGTH_LONG).show();
        Cursor res = myDb.getListEtudiants(annee, classe);

        if (res.getCount() == 0) {
            //show message
            //showMessage("Error ","Nothing found");
            //Toast.makeText(ModifierActivity.this,"vide",Toast.LENGTH_LONG).show();
            //finish();
        } else {
            String nom, prenom;
            while (res.moveToNext()) {
                nom = res.getString(1);
                prenom = res.getString(2);
                etudiants.add(new Etudiant(nom, prenom, annee, classe));
            }
            myRecyclerView.setLayoutManager(new LinearLayoutManager(this));
            myAdapter = new MyAdapter3(this, etudiants);
            myRecyclerView.setAdapter(myAdapter);
            myAdapter.setOnItemClickListener(new MyAdapter3.OnItemClickListener() {
                /*@Override
                public void onItemClick(int position) {

                }

                @Override
                public void onDeleteClick(int position) {
                    //remove
                    Integer deletedRows = myDb.deleteEtudiant(etudiants.get(position).getNom(),etudiants.get(position).getPrenom());
                    if(deletedRows>0) {
                        Toast.makeText(ModifierActivity.this, "data deleted", Toast.LENGTH_LONG).show();
                        etudiants.remove(position);
                        myAdapter.notifyDataSetChanged();
                    }
                }
                */
                @Override
                public void onAbsenceClick(int position,boolean isChecked) {
                    if(etudiantsAbsents.contains(etudiants.get(position))){
                        etudiantsAbsents.remove(etudiants.get(position));
                    }
                    else {
                        etudiantsAbsents.add(etudiants.get(position));
                    }

                    /*if(isChecked){
                        etudiantsAbsents.add(etudiants.get(position));
                    }else{
                        etudiantsAbsents.remove(etudiants.get(position));
                    }*/
                }


            });
        }

        startActivity();
    }
    @Override
    public void onBackPressed() {
    }

    public void startActivity(){
        buttonConfAbs.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent =new Intent (view.getContext(), ConfAbsActivity.class);
                            Extras.setEtudiantsAbsents(etudiantsAbsents);
                        startActivity(intent);
                    }
                }
        );
    }

}