/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.entities;

import java.util.ArrayList;

/**
 *
 * @author Mohamed
 */
public class Commentaire {
    private  Integer id;
   private  String pseudo;
   private  String sujet;
   private  String medecin;  
   private  String question;
   

    public Commentaire(Integer id, String pseudo, String sujet, String medecin, String question) {
        this.id = id;
        this.pseudo = pseudo;
        this.sujet = sujet;
        this.medecin = medecin;
        this.question = question;
    }

    public Commentaire(String pseudo, String sujet, String medecin, String question) {
        this.pseudo = pseudo;
        this.sujet = sujet;
        this.medecin = medecin;
        this.question = question;
    }

 
    public Commentaire() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getSujet() {
        return sujet;
    }

    public void setSujet(String sujet) {
        this.sujet = sujet;
    }

    public String getMedecin() {
        return medecin;
    }

    public void setMedecin(String medecin) {
        this.medecin = medecin;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    @Override
    public String toString() {
        return "Task{" + "id=" + id + ", pseudo=" + pseudo + ", sujet=" + sujet + ", medecin=" + medecin + ", question=" + question + '}';
    }

    public boolean addCommentaire(Commentaire t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public ArrayList<Commentaire> getAllTasks() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
}
   