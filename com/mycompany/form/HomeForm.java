/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.form;

import com.codename1.ui.Button;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BoxLayout;
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
    
    public HomeForm() {
       current=this;
        setTitle("Home");
        setLayout(BoxLayout.y());

        add(new Label("Choose an option"));
        
        Button btnAdd = new Button("Front Pharmacie");
        
        Button btnAdd2 = new Button("Back Pharamcie");

        

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

       // btnLisRt.addActionListener(e -> new ListGymForm(current).show());
        
        addAll(btnAdd).add(btnAdd2);

    }

   

}
    

