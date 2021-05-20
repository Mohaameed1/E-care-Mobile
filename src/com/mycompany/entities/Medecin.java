/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.entities;

/**
 *
 * @author alaaa
 */
public class Medecin {
    private int id;
    private String nom,prenom,specialite,adresse,sexe,num_tel,cin,password;

    public Medecin() {
    }

    public Medecin(String nom, String prenom, String specialite, String adresse, String sexe, String num_tel) {
        this.nom = nom;
        this.prenom = prenom;
        this.specialite = specialite;
        this.adresse = adresse;
        this.sexe = sexe;
        this.num_tel = num_tel;
    }

    
    public Medecin(int id, String nom, String prenom, String specialite, String adresse, String sexe, String num_tel, String cin, String password) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.specialite = specialite;
        this.adresse = adresse;
        this.sexe = sexe;
        this.num_tel = num_tel;
        this.cin = cin;
        this.password = password;
    }

    public Medecin(String nom, String prenom, String specialite) {
        this.nom = nom;
        this.prenom = prenom;
        this.specialite = specialite;
    }
    

    public Medecin(String nom, String prenom, String specialite, String adresse, String sexe, String num_tel, String cin) {
        this.nom = nom;
        this.prenom = prenom;
        this.specialite = specialite;
        this.adresse = adresse;
        this.sexe = sexe;
        this.num_tel = num_tel;
        this.cin = cin;
    }
    

    public Medecin(String nom, String prenom, String specialite, String adresse, String sexe, String num_tel, String cin, String password) {
        this.nom = nom;
        this.prenom = prenom;
        this.specialite = specialite;
        this.adresse = adresse;
        this.sexe = sexe;
        this.num_tel = num_tel;
        this.cin = cin;
        this.password = password;
    }

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public String getNum_tel() {
        return num_tel;
    }

    public void setNum_tel(String num_tel) {
        this.num_tel = num_tel;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
    
    
}
