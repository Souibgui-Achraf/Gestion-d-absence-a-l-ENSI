package com.example.gestiondabsence;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity2 extends AppCompatActivity {
    Button button1annee,button2annee,button3annee;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        button1annee = (Button)findViewById(R.id.button1annee);
        button2annee = (Button)findViewById(R.id.button2annee);
        button3annee = (Button)findViewById(R.id.button3annee);
        nextActivity();
    }
    public void nextActivity(){
        button1annee.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent =new Intent(view.getContext(),MainActivity3.class);
                        startActivity(intent);
                    }
                }
        );
        button2annee.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent =new Intent(view.getContext(),MainActivity3.class);
                        startActivity(intent);
                    }
                }
        );
        button3annee.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent =new Intent(view.getContext(),MainActivity3.class);
                        startActivity(intent);
                    }
                }
        );
    }
}