/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.entities;

/**
 *
 * @author achra
 */
public class Panier {
   private Integer id ;
private String   code_panier;
private Integer   quantite;
private Float   prix_tot;
private String   produits;

    public Panier() {
       
    }

    public Panier(Integer id, String code_panier, Integer quantite, String produits) {
        this.id = id;
        this.code_panier = code_panier;
        this.quantite = quantite;
        this.produits = produits;
    }

    public Panier(Integer id, String code_panier) {
        this.id = id;
        this.code_panier = code_panier;
    }

    public Panier(Integer id, Integer quantite) {
        this.id = id;
        this.quantite = quantite;
    }
    

    public Panier(Integer id, String code_panier, Integer quantite, Float prix_tot, String produits) {
        this.id = id;
        this.code_panier = code_panier;
        this.quantite = quantite;
        this.prix_tot = prix_tot;
        this.produits = produits;
    }

    public Panier(String code_panier, Integer quantite, String produits) {
        this.code_panier = code_panier;
        this.quantite = quantite;
        this.produits = produits;
    }
    

    public Panier( String produits,Integer quantite, Float prix_tot) {
        this.quantite = quantite;
        this.prix_tot = prix_tot;
        this.produits = produits;
    }

    public Panier(String code_panier, Integer quantite, Float prix_tot, String produits) {
        this.code_panier = code_panier;
        this.quantite = quantite;
        this.prix_tot = prix_tot;
        this.produits = produits;
    }

    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode_panier() {
        return code_panier;
    }

    public void setCode_panier(String code_panier) {
        this.code_panier = code_panier;
    }

    public Integer getQuantite() {
        return quantite;
    }

    public void setQuantite(Integer quantite) {
        this.quantite = quantite;
    }

    public Float getPrix_tot() {
        return prix_tot;
    }

    public void setPrix_tot(Float prix_tot) {
        this.prix_tot = prix_tot;
    }

    public String getProduits() {
        return produits;
    }

    public void setProduits(String produits) {
        this.produits = produits;
    }

    public Panier(String code_panier, String produits) {
        this.code_panier = code_panier;
        this.produits = produits;
    }

    public Panier(Integer id) {
        this.id = id;
    }

    
    
   

    @Override
    public String toString() {
        return  "\n  code produit=  " + code_panier + "\n quantite=  " + quantite + "\n prix=  " + prix_tot + "\n produits=  " + produits + "";
    }

  

   
    
}
