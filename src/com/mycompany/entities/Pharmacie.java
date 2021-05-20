/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.entities;

/**
 *
 * @author Rzouga
 */
public class Pharmacie {
    
        int id , numtel ;
        String nom,adresse;

    public void setId(int id) {
        this.id = id;
    }

    public void setNumtel(int numtel) {
        this.numtel = numtel;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public int getId() {
        return id;
    }

    public int getNumtel() {
        return numtel;
    }

    public String getNom() {
        return nom;
    }

    public String getAdresse() {
        return adresse;
    }

    @Override
    public String toString() {
        return "Pharmacie{" + "id=" + id + ", numtel=" + numtel + ", nom=" + nom + ", adresse=" + adresse + '}';
    }

    public Pharmacie() {
    }

    public Pharmacie(int id, int numtel, String nom, String adresse) {
        this.id = id;
        this.numtel = numtel;
        this.nom = nom;
        this.adresse = adresse;
    }

    public Pharmacie(int numtel, String nom, String adresse) {
        this.numtel = numtel;
        this.nom = nom;
        this.adresse = adresse;
    }
    
        
        
        
        
    
}
