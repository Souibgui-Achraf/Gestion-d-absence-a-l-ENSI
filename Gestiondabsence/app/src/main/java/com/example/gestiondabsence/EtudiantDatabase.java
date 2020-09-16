package com.example.gestiondabsence;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class EtudiantDatabase extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "etudiant.db";
    public static final String TABLE_NAME = "etudiant_table";
    public static final String COL_0 = "ID";
    public static final String COL_1 = "NOM";
    public static final String COL_2 = "PRENOM";
    public static final String COL_3 = "ANNEE";
    public static final String COL_4 = "CLASSE";

    public EtudiantDatabase(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "NOM TEXT , PRENOM TEXT, ANNEE TEXT , CLASSE TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String nom, String prenom, String annee, String classe) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1, nom);
        contentValues.put(COL_2, prenom);
        contentValues.put(COL_3, annee);
        contentValues.put(COL_4, classe);
        long result = db.insert(TABLE_NAME, null, contentValues);
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }
    public Cursor getListEtudiants(String annee,String classe){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res =db.rawQuery("select * from "+TABLE_NAME+" WHERE ANNEE= ? AND CLASSE = ?",new String[] {annee , classe} );
        return res ;
    }
    public boolean updateEtudiant (String exnom , String exprenom ,String exannee ,String exclasse
    ,String nom,String prenom , String annee,String classe){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1, nom);
        contentValues.put(COL_2, prenom);
        contentValues.put(COL_3, annee);
        contentValues.put(COL_4, classe);
        db.update(TABLE_NAME,contentValues,"NOM = ? AND PRENOM = ? ",new String[] { exnom,exprenom });
        return true;
    }
    public Integer deleteEtudiant (String nom , String prenom){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME,"NOM = ? AND PRENOM = ?",new String[] {nom , prenom});
    }
}