package com.example.gestiondabsence;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.gestiondabsence.listeetudiants.ListeEtudiantActivity;
import com.example.gestiondabsence.marqabs.AbsenceActivity;
import com.example.gestiondabsence.modifierliste.ModifierActivity;

public class L_A_MActivity extends AppCompatActivity {
    public static final String EXTRA_DATA="com.example.gestiondabsence.EXTRA_DATA";
    Button buttonListe ,buttonAbsence,buttonModifier;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_l_a_m);
        buttonListe = (Button)findViewById(R.id.buttonListe);
        buttonAbsence = (Button)findViewById(R.id.buttonAbsence);
        buttonModifier = (Button)findViewById(R.id.buttonModifier);
        //Toast.makeText(L_A_MActivity.this,getIntent().getExtras().getStringArray(ClasseActivity.EXTRA_CLASSE)[0],Toast.LENGTH_LONG).show();
        nextActivity();
    }
    public void nextActivity(){
        buttonListe.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent =new Intent (view.getContext(), ListeEtudiantActivity.class);
                        startActivity(intent);
                    }
                }
        );
        buttonAbsence.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent =new Intent (view.getContext(), AbsenceActivity.class);
                        startActivity(intent);
                    }
                }
        );
        buttonModifier.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent =new Intent (view.getContext(), ModifierActivity.class);
                        startActivity(intent);
                    }
                }
        );
    }
}