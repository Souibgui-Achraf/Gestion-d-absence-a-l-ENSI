package com.example.gestiondabsence.modifierliste.tools;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.gestiondabsence.R;
import com.example.gestiondabsence.database.EtudiantDatabase;
import com.example.gestiondabsence.database.Extras;
import com.example.gestiondabsence.modifierliste.ModifierActivity;

public class AddEtudiant extends AppCompatActivity {
    EditText editTextNom,editTextPrenom ;
    Button buttonAjouter ;
    EtudiantDatabase myDb ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_etudiant);
        myDb = new EtudiantDatabase(this);
        editTextNom =(EditText)findViewById(R.id.editTextAjoutNom);
        editTextPrenom =(EditText)findViewById(R.id.editTextAjoutPrenom);
        buttonAjouter=(Button)findViewById(R.id.buttonAjouter);
        ajoutEtudiant();
    }
    @Override
    public void onBackPressed() {

    }
    public void ajoutEtudiant(){
        buttonAjouter.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String nom = editTextNom.getText().toString().trim();
                        String prenom =editTextPrenom.getText().toString().trim();
                        boolean isInserted =myDb.insertData(nom,prenom, Extras.getAnnee(),Extras.getClasse());
                        if(isInserted){
                            Toast.makeText(AddEtudiant.this,"data inserted",Toast.LENGTH_LONG).show();
                            Intent intent =new Intent (view.getContext(), ModifierActivity.class);
                            startActivity(intent);
                        }
                        else
                            Toast.makeText(AddEtudiant.this,"data not inserted",Toast.LENGTH_LONG).show();
                    }
                }
        );
    }
}