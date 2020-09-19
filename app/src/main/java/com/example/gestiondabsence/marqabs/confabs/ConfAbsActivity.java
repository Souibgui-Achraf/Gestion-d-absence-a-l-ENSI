package com.example.gestiondabsence.marqabs.confabs;

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
import com.example.gestiondabsence.marqabs.MyAdapter3;
import com.example.gestiondabsence.modifierliste.tools.AddEtudiant;

import java.util.ArrayList;

public class ConfAbsActivity extends AppCompatActivity {
    RecyclerView myRecyclerView;
    MyAdapter4 myAdapter;
    EtudiantDatabase myDb;
    Button buttonConfirmerAbs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conf_abs);

        myDb = new EtudiantDatabase(this);
        myRecyclerView = findViewById(R.id.recyclerView3);
        buttonConfirmerAbs = (Button) findViewById(R.id.buttonConfirmerAbs);
        myRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        ArrayList<Etudiant> etudiantsAbsents = new ArrayList<>();
        etudiantsAbsents = Extras.getEtudiantsAbsents();
        myAdapter = new MyAdapter4(this, etudiantsAbsents);
        myRecyclerView.setAdapter(myAdapter);


        startActivity();
    }



    @Override
    public void onBackPressed() {
    }

    public void startActivity() {
        buttonConfirmerAbs.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(view.getContext(), AddEtudiant.class);
                        startActivity(intent);
                    }
                }
        );
    }
}