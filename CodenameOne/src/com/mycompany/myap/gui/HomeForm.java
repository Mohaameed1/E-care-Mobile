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
public class HomeForm extends Form{
 Form current;
    public HomeForm(){
        current = this;
        setTitle("Accueil");
        setLayout(BoxLayout.y());

        add(new Label("Choisir une option"));
        Button btnAddTask = new Button("Ajouter une clinique");
        Button btnddAddTask = new Button("Liste cliniques ");
       Button btndddAddTask = new Button("Liste patients ");
       Button btnmail = new Button("Envoyer un email");
     

         btnmail.addActionListener(e -> new Addmail(current).show());
        btnAddTask.addActionListener(e -> new AddCliniqueForm(current).show());
        btnddAddTask.addActionListener(e -> new ListeCliniqueForm(current).show());
        
        btndddAddTask.addActionListener(e -> new ListePatientForm(current).show());
    
        addAll(btnAddTask,btnddAddTask,btndddAddTask,btnmail);
    }   
}
