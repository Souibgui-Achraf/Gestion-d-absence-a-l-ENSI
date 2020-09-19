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

public class EditEtudiant extends AppCompatActivity {
    EditText edittextNom, edittextPrenom, edittextAnnee, edittextClasse;
    Button buttonConfirmer;
    EtudiantDatabase myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_etudiant);
        myDb = new EtudiantDatabase(this);
        edittextNom = (EditText) findViewById(R.id.edittextNom);
        edittextPrenom = (EditText) findViewById(R.id.edittextPrenom);
        edittextAnnee = (EditText) findViewById(R.id.edittextAnnee);
        edittextClasse = (EditText) findViewById(R.id.edittextClasse);
        buttonConfirmer = (Button) findViewById(R.id.buttonConfirmer);
        edittextNom.setText(Extras.getEtudiant().getNom());
        edittextPrenom.setText(Extras.getEtudiant().getPrenom());
        edittextAnnee.setText(Extras.getEtudiant().getAnnee());
        edittextClasse.setText(Extras.getEtudiant().getClasse());
        buttonConfirmer.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String nom = edittextNom.getText().toString().trim();
                        String prenom = edittextPrenom.getText().toString().trim();
                        String annee = edittextAnnee.getText().toString().trim();
                        String classe = edittextClasse.getText().toString().trim();
                        if (nom.isEmpty() && prenom.isEmpty() && annee.isEmpty() && classe.isEmpty()) {
                            Toast.makeText(EditEtudiant.this, "Remplir l'un des champs !", Toast.LENGTH_LONG).show();
                        } else {
                            if (nom.isEmpty()) nom = Extras.getEtudiant().getNom();
                            if (prenom.isEmpty()) prenom = Extras.getEtudiant().getPrenom();
                            if (annee.isEmpty()) annee = Extras.getEtudiant().getAnnee();
                            if (classe.isEmpty()) classe = Extras.getEtudiant().getClasse();

                            boolean isUpdated = myDb.updateEtudiant(Extras.getEtudiant().getNom()
                                    , Extras.getEtudiant().getPrenom()
                                    , nom, prenom, annee, classe);

                            if (isUpdated){
                                Toast.makeText(EditEtudiant.this, "data updated", Toast.LENGTH_LONG).show();
                            }
                            else
                                Toast.makeText(EditEtudiant.this, "data not updated", Toast.LENGTH_LONG).show();
                            Intent intent =new Intent (view.getContext(), ModifierActivity.class);
                            startActivity(intent);
                        }
                    }
                }
        );
    }
    @Override
    public void onBackPressed() {

    }
}