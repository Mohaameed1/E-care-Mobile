/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.entities;

import java.util.Date;

/**
 *
 * @author Mohamed
 */
public class Reponse {
    private  Integer id;
   private  String pseudo;
   private  String rep;  
   private  String date_rep;
   private String question;

    public Reponse(Integer id, String pseudo, String rep, String date_rep) {
        this.id = id;
        this.pseudo = pseudo;
        this.rep = rep;
        this.date_rep = date_rep;
    }

    public Reponse(String pseudo, String rep) {
        this.pseudo = pseudo;
        this.rep = rep;
    }

    public Reponse(String pseudo, String rep, String date_rep) {
        this.pseudo = pseudo;
        this.rep = rep;
        this.date_rep = date_rep;
    }

    public Reponse(String pseudo, String rep, String date_rep, String question) {
        this.pseudo = pseudo;
        this.rep = rep;
        this.date_rep = date_rep;
        this.question = question;
    }

    public Reponse(Integer id, String pseudo, String rep, String date_rep, String question) {
        this.id = id;
        this.pseudo = pseudo;
        this.rep = rep;
        this.date_rep = date_rep;
        this.question = question;
    }
    

    public Reponse() {
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

    public String getRep() {
        return rep;
    }

    public void setRep(String rep) {
        this.rep = rep;
    }

    public String getDate_rep() {
        return date_rep;
    }

    public void setDate_rep(String date_rep) {
        this.date_rep = date_rep;
    }

    @Override
    public String toString() {
        return "Reponse{" + "id=" + id + ", pseudo=" + pseudo + ", rep=" + rep + ", date_rep=" + date_rep + ", question=" + question + '}';
    }

    

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    
   

    
   
}
