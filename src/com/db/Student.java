package com.db;

public class Student {
    private  String nume;
    private  String prenume;
    private  String email;
    private  int credite;
    private  float medie;

    public Student() {

    }

    public Student(String nume, String prenume, String email, int credite, float medie) {
        this.nume = nume;
        this.prenume = prenume;
        this.email = email;
        this.credite = credite;
        this.medie = medie;
    }

    public String getNume() {
        return nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public String getEmail() {
        return email;
    }

    public int getCredite() {
        return credite;
    }

    public float getMedie() {
        return medie;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCredite(int credite) {
        this.credite = credite;
    }

    public void setMedie(float medie) {
        this.medie = medie;
    }

    @Override
    public String toString() {
        return  nume + ',' +
                    prenume + ',' +
                    email + ',' +
                    credite + ',' +
                    medie;
    }

}
