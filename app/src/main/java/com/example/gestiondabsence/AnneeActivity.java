package com.example.gestiondabsence;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.gestiondabsence.database.Extras;

public class AnneeActivity extends AppCompatActivity {
    public static final String EXTRA_ANNEE="com.example.gestiondabsence.EXTRA_ANNEE" ;
    Button button1annee,button2annee,button3annee;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_annee);
        button1annee = (Button)findViewById(R.id.button1annee);
        button2annee = (Button)findViewById(R.id.button2annee);
        button3annee = (Button)findViewById(R.id.button3annee);
        nextActivity();
    }
    public void nextActivity(){
        Extras extra = new Extras();
        button1annee.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent =new Intent(view.getContext(), ClasseActivity.class);
                        Extras.setAnnee("1");
                        startActivity(intent);
                    }
                }
        );
        button2annee.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent =new Intent(view.getContext(), ClasseActivity.class);
                        Extras.setAnnee("2");
                        startActivity(intent);
                    }
                }
        );
        button3annee.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent =new Intent(view.getContext(), ClasseActivity.class);
                        Extras.setAnnee("3");
                        startActivity(intent);
                    }
                }
        );
    }
}