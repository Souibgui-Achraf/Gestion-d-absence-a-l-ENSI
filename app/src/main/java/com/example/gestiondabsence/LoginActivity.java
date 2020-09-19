package com.example.gestiondabsence;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoginActivity extends AppCompatActivity {
    Button buttonLogin ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        buttonLogin =(Button)findViewById(R.id.buttonLogin);
        buttonLogin.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(view.getContext(), AnneeActivity.class);
                        startActivity(intent);
                    }
                }
        );

    }
    public void login(){
        Intent intent = new Intent(this, AnneeActivity.class);
        startActivity(intent);
    }
}