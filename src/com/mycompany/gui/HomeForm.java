/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.ui.Button;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
import java.io.IOException;

/**
 *
 * @author fatma
 */
public class HomeForm extends Form {

    Form current;
 
    /*Garder traçe de la Form en cours pour la passer en paramètres 
    aux interfaces suivantes pour pouvoir y revenir plus tard en utilisant
    la méthode showBack*/
    
    public HomeForm(Resources res) {
       current=this;
        setTitle("Home");
        setLayout(BoxLayout.y());

        add(new Label("Choose an option"));
            Button btnAdd4 = new Button("list Livraison");
               Button btnAdd5 = new Button("list panier");
        Button btnAdd = new Button("Add Pharmacie");
         Button btnAdd2 = new Button("Pharmacie front");
        
        Button btnAdd6 = new Button("Q/R");
                Button btnAdd7 = new Button("Medecins");


            
  

        

        btnAdd.addActionListener(e -> {
           try {
               new PharmacieFront(current).show();
           } catch (IOException ex) {
           }
       });
        
                btnAdd2.addActionListener(e -> {
           try {
               new addPharmacie(current).show();
           } catch (IOException ex) {
           }
       });
    btnAdd4.addActionListener(e -> {
        new ListLivraisonForm(res).show();
       });
        btnAdd5.addActionListener(e -> {
           
        
               new ListPanierForm(res).show();
       
       });
           btnAdd6.addActionListener(e -> {
        new ListCommentaireForm(res).show();
       });
            btnAdd7.addActionListener(e -> {
        new ListMedecinForm(res).show();
       });
      
       // btnLisRt.addActionListener(e -> new ListGymForm(current).show());
        
        addAll(btnAdd).add(btnAdd2).add(btnAdd4).add(btnAdd5).add(btnAdd6).add(btnAdd7);

    }

   

}
    

