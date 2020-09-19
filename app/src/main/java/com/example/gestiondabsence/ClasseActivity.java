package com.example.gestiondabsence;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.gestiondabsence.database.Extras;

public class ClasseActivity extends AppCompatActivity {
    public static final String EXTRA_CLASSE="com.example.gestiondabsence.EXTRA_CLASSE";
    Button buttona,buttonb,buttonc,buttond,buttone,buttonf;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classe);
        buttona=(Button)findViewById(R.id.buttona);
        buttonb=(Button)findViewById(R.id.buttonb);
        buttonc=(Button)findViewById(R.id.buttonc);
        buttond=(Button)findViewById(R.id.buttond);
        buttone=(Button)findViewById(R.id.buttone);
        buttonf=(Button)findViewById(R.id.buttonf);
        /*Intent intent =getIntent() ;
        String text=intent.getStringExtra(AnneeActivity.EXTRA_ANNEE);
        Toast.makeText(ClasseActivity.this,text,Toast.LENGTH_LONG).show();*/
        nextActivity();
    }
    public void nextActivity(){
        Extras extra =new Extras();
        buttona.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent =new Intent (view.getContext(), L_A_MActivity.class);
                        Extras.setClasse("a");
                        startActivity(intent);
                    }
                }
        );
        buttonb.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent =new Intent (view.getContext(), L_A_MActivity.class);
                        Extras.setClasse("b");
                        startActivity(intent);
                    }
                }
        );
        buttonc.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent =new Intent (view.getContext(), L_A_MActivity.class);
                        Extras.setClasse("c");
                        startActivity(intent);
                    }
                }
        );
        buttond.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent =new Intent (view.getContext(), L_A_MActivity.class);
                        Extras.setClasse("d");
                        startActivity(intent);
                    }
                }
        );
        buttone.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent =new Intent (view.getContext(), L_A_MActivity.class);
                        Extras.setClasse("e");
                        startActivity(intent);
                    }
                }
        );
        buttonf.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent =new Intent (view.getContext(), L_A_MActivity.class);
                        Extras.setClasse("f");
                        startActivity(intent);
                    }
                }
        );
    }
}