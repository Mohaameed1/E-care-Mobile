/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Entity;

/**
 *
 * @author Rzouga
 */
public class AvisClient {
    
   private int id , patientId ,pharmacieId , rate ;
   private String note ;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public int getPharmacieId() {
        return pharmacieId;
    }

    public void setPharmacieId(int pharmacieId) {
        this.pharmacieId = pharmacieId;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public AvisClient() {
    }

    @Override
    public String toString() {
        return "AvisClient{" + "id=" + id + ", patientId=" + patientId + ", pharmacieId=" + pharmacieId + ", rate=" + rate + ", note=" + note + '}';
    }
   
   
    
}
