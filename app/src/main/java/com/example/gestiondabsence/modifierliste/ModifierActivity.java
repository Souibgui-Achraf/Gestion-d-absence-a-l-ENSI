package com.example.gestiondabsence.modifierliste;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.gestiondabsence.modifierliste.tools.EditEtudiant;
import com.example.gestiondabsence.Etudiant;
import com.example.gestiondabsence.R;
import com.example.gestiondabsence.database.EtudiantDatabase;
import com.example.gestiondabsence.database.Extras;
import com.example.gestiondabsence.modifierliste.tools.AddEtudiant;

import java.util.ArrayList;

public class ModifierActivity extends AppCompatActivity {
    RecyclerView myRecyclerView;
    MyAdapter2 myAdapter;
    EtudiantDatabase myDb;
    Button buttonAdd ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modifier);
        myDb = new EtudiantDatabase(this);
        myRecyclerView = findViewById(R.id.recyclerView1);
        buttonAdd=(Button)findViewById(R.id.buttonAdd);

        final ArrayList<Etudiant> etudiants = new ArrayList<>();
        String annee = Extras.getAnnee();
        String classe = Extras.getClasse();

       // Toast.makeText(ListeEtudiantActivity.this,annee,Toast.LENGTH_LONG).show();
        Cursor res = myDb.getListEtudiants(annee, classe);

        if (res.getCount() == 0) {
            //show message
            //showMessage("Error ","Nothing found");
            Toast.makeText(ModifierActivity.this,"vide",Toast.LENGTH_LONG).show();
            //finish();
        } else {
            String nom, prenom;
            while (res.moveToNext()) {
                nom = res.getString(1);
                prenom = res.getString(2);
                etudiants.add(new Etudiant(nom, prenom, annee, classe));
            }
            myRecyclerView.setLayoutManager(new LinearLayoutManager(this));
            myAdapter = new MyAdapter2(this, etudiants);
            myRecyclerView.setAdapter(myAdapter);
            myAdapter.setOnItemClickListener(new MyAdapter2.OnItemClickListener() {
                /*@Override
                public void onItemClick(int position) {

                }*/

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

                @Override
                public void onModifyClick(int position) {
                    Intent intent =new Intent(ModifierActivity.this, EditEtudiant.class) ;
                    Extras.setEtudiant(etudiants.get(position));
                    startActivity(intent);
                }
            });
        }

        startActivity();
    }
    @Override
    public void onBackPressed() {
    }

    public void startActivity(){
        buttonAdd.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        finish();
                        Intent intent =new Intent (view.getContext(), AddEtudiant.class);
                        startActivity(intent);
                    }
                }
        );
    }
}