package com.rachid_abbad.rachid_abbad_examen.classes;

import java.io.Serializable;

public class Prof_Rachid implements Serializable {
    private String cin;
    private String nom;
    private String specialite;

    public Prof_Rachid(String cin, String nom, String specialite) {
        this.cin = cin;
        this.nom = nom;
        this.specialite = specialite;
    }

    public Prof_Rachid() {
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }
}