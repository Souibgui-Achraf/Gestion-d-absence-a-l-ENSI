package com.example.gestiondabsence.database;

import com.example.gestiondabsence.Etudiant;

import java.util.ArrayList;

public class Extras {
    public static String annee , classe ;
    public static Etudiant etudiant;
    public static ArrayList<Etudiant> etudiantsAbsents ;

    public static ArrayList<Etudiant> getEtudiantsAbsents() {
        return etudiantsAbsents;
    }

    public static void setEtudiantsAbsents(ArrayList<Etudiant> etudiantsAbsents) {
        Extras.etudiantsAbsents = etudiantsAbsents;
    }

    public static Etudiant getEtudiant() {
        return etudiant;
    }

    public static void setEtudiant(Etudiant etudiant) {
        Extras.etudiant = etudiant;
    }

    public static String getAnnee() {
        return annee;
    }

    public static void setAnnee(String annee) {
        Extras.annee = annee;
    }

    public static String getClasse() {
        return classe;
    }

    public static void setClasse(String classe) {
        Extras.classe = classe;
    }
}
