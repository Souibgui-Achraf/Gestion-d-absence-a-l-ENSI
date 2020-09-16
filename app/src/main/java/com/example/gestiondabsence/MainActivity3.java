package com.example.gestiondabsence;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity3 extends AppCompatActivity {
    Button buttona,buttonb,buttonc,buttond,buttone,buttonf;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        buttona=(Button)findViewById(R.id.buttona);
        buttonb=(Button)findViewById(R.id.buttonb);
        buttonc=(Button)findViewById(R.id.buttonc);
        buttond=(Button)findViewById(R.id.buttond);
        buttone=(Button)findViewById(R.id.buttone);
        buttonf=(Button)findViewById(R.id.buttonf);
        nextActivity();
    }
    public void nextActivity(){
        buttona.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent =new Intent (view.getContext(),MainActivity4.class);
                        startActivity(intent);
                    }
                }
        );
    }
}