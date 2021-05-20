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
public class User {
    private int id;
    private String login,roles,password,cin,sexe,nom,prenom,adresse,num_tel,email;
    private boolean is_verified;

    public User() {
    }

    public User(int id, String login, String roles, String password, String cin, String sexe, String nom, String prenom, String adresse, String num_tel, String email, boolean is_verified) {
        this.id = id;
        this.login = login;
        this.roles = roles;
        this.password = password;
        this.cin = cin;
        this.sexe = sexe;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.num_tel = num_tel;
        this.email = email;
        this.is_verified = is_verified;
    }

    public User(String login, String roles, String password, String cin, String sexe, String nom, String prenom, String adresse, String num_tel, String email, boolean is_verified) {
        this.login = login;
        this.roles = roles;
        this.password = password;
        this.cin = cin;
        this.sexe = sexe;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.num_tel = num_tel;
        this.email = email;
        this.is_verified = is_verified;
    }

    
    public User(String login, String roles, String password, String cin, String sexe, String nom, String prenom, String adresse, String num_tel, String email) {
        this.login = login;
        this.roles = roles;
        this.password = password;
        this.cin = cin;
        this.sexe = sexe;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.num_tel = num_tel;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
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

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getNum_tel() {
        return num_tel;
    }

    public void setNum_tel(String num_tel) {
        this.num_tel = num_tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isIs_verified() {
        return is_verified;
    }

    public void setIs_verified(boolean is_verified) {
        this.is_verified = is_verified;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", login=" + login + ", roles=" + roles + ", password=" + password + ", cin=" + cin + ", sexe=" + sexe + ", nom=" + nom + ", prenom=" + prenom + ", adresse=" + adresse + ", num_tel=" + num_tel + ", email=" + email + ", is_verified=" + is_verified + '}';
    }
    
    
    
}
