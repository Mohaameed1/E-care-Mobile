/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.entities;

/**
 *
 * @author bhk
 */
public class Livraison {
    private Integer id ;
private String   nom;
private String   adresse;
private String   numero;
private String   mail;
private String   message;

private Integer   commande_id;
private String   commande_code_panier;

    public Livraison(Integer id, String nom, String adresse, String numero, String mail, String message, Integer commande_id) {
        this.id = id;
        this.nom = nom;
        this.adresse = adresse;
        this.numero = numero;
        this.mail = mail;
        this.message = message;
        this.commande_id = commande_id;
    }

    public Livraison(Integer id, String nom, String adresse, String numero, String mail, String message,  String commande_code_panier) {
        this.id = id;
        this.nom = nom;
        this.adresse = adresse;
        this.numero = numero;
        this.mail = mail;
        this.message = message;
        this.commande_code_panier = commande_code_panier;
    }

    public Livraison(String nom, String adresse, String numero, String mail, String message, String commande_code_panier) {
        this.nom = nom;
        this.adresse = adresse;
        this.numero = numero;
        this.mail = mail;
        this.message = message;
        this.commande_code_panier = commande_code_panier;
    }

    

    public Livraison(String nom, String adresse, String numero, String mail, String message) {
        this.nom = nom;
        this.adresse = adresse;
        this.numero = numero;
        this.mail = mail;
        this.message = message;
    }

    public Livraison(Integer id, String nom, String adresse, String numero, String mail, String message) {
        this.id = id;
        this.nom = nom;
        this.adresse = adresse;
        this.numero = numero;
        this.mail = mail;
        this.message = message;
    }
    

    public Livraison() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getCommande_id() {
        return commande_id;
    }

    public void setCommande_id(Integer commande_id) {
        this.commande_id = commande_id;
    }

    public String getCommande_code_panier() {
        return commande_code_panier;
    }

    public void setCommande_code_panier(String commande_code_panier) {
        this.commande_code_panier = commande_code_panier;
    }

   
  

 

    @Override
    public String toString() {
        return  "\n nom = " + nom + "\n adresse = " + adresse + "\n numero = " + numero + "\n mail = " + mail + "\n message = " + message +  "\n commande_code_panier = " + commande_code_panier + "\n\n";
    }

   
    
}
