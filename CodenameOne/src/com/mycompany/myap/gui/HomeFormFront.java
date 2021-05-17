/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myap.gui;

import com.codename1.ui.Form;
import com.codename1.ui.Button;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BoxLayout;

/**
 *
 * @author Siwar Boutaleb
 */
public class HomeFormFront extends Form{
 Form current;
    public HomeFormFront(){
        current = this;
        setTitle("Accueil");
        setLayout(BoxLayout.y());

        add(new Label("Choisir une option"));
        Button btnddAddTask = new Button("Liste Cliniques ");
        
        Button btnddsAddTask = new Button("Ajouter patient ");
       Button btndddAddTask = new Button("Liste Patients ");
      

        
        btnddAddTask.addActionListener(e -> new ListeCliniqueFront(current).show());
        btnddsAddTask.addActionListener(e -> new AddPatientForm(current).show());
        
        btndddAddTask.addActionListener(e -> new ListePatientForm(current).show());
    
        addAll(btnddAddTask,btndddAddTask);
    }   
}
