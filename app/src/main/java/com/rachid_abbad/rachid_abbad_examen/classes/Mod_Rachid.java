package com.rachid_abbad.rachid_abbad_examen.classes;

import java.io.Serializable;

public class Mod_Rachid implements Serializable {
    private int idModule;
    private String intitule;
    private int env_h;
    private String cin;

    public Mod_Rachid() {
    }

    public Mod_Rachid(int idModule, String intitule, int env_h, String cin) {
        this.idModule = idModule;
        this.intitule = intitule;
        this.env_h = env_h;
        this.cin = cin;
    }


    public int getIdModule() {
        return idModule;
    }

    public void setIdModule(int idModule) {
        this.idModule = idModule;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public int getEnv_h() {
        return env_h;
    }

    public void setEnv_h(int env_h) {
        this.env_h = env_h;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }
}