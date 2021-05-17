/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myap.gui;

import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.mycompany.myap.Services.ServiceClinique; 
import com.mycompany.myap.entities.Clinique; 
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Siwar Boutaleb
 */


public class ListeCliniqueFront extends Form{
Form current;
     public  ListeCliniqueFront(Form previous)  {

      
       setTitle("Liste des cliniques");
         
   
 
        
      
        ServiceClinique es = new ServiceClinique();
        ArrayList<Clinique> list = es.getAllCours();

        {
           
            for (Clinique r : list) {

          
 
        Button btnAddTask = new Button("Demander secours!");
                Container c3 = new Container(BoxLayout.y());
                SpanLabel typereclamation= new SpanLabel("Type Reclamation:" + r.getNomcl());
                
                SpanLabel id= new SpanLabel("L'id du clinique:" + r.getId());

        btnAddTask.addActionListener(e -> new AddPatientForm(current).show());
        SpanLabel nom= new SpanLabel("Nom clinique:" + r.getNomcl()); 
        SpanLabel adresse= new SpanLabel("Adresse clinique:" + r.getAdressecl());
SpanLabel numerocl= new SpanLabel("Numéro de téléphone :" + r.getNumerocl());
SpanLabel typereclamations= new SpanLabel("Description:" + r.getDesccl());

               
               
                  Button supp = new Button("Supprimer");
                  Button modif = new Button("Modifier");
                  
                  Button ajout = new Button("Patient");
        
//        supp.addActionListener(new ActionListener(){
//        @Override
//        public void actionPerformed(ActionEvent evt) {
//            ServiceAbonnement.getInstance().deleteAbonnement(ab);
//            Dialog.show("Success", "Memory Deleted Successfully.", "OK", "Cancel");
//        }
//        });
supp.addActionListener(new ActionListener(){
        @Override
       public void actionPerformed(ActionEvent evt) {
            ServiceClinique.getInstance().deleteStade(r.getId()); 
            Dialog.show("Success", "Stade hDeleted Successfully.", "OK", "Cancel");
            new HomeForm().show();
       }

            
       });
         modif.addActionListener(new ActionListener(){
        @Override
       public void actionPerformed(ActionEvent evt) {
             
            new ModifCliniqueForm(r);
       }
       });
          ajout.addActionListener(new ActionListener(){
        @Override
       public void actionPerformed(ActionEvent evt) {
             
            new AddPatientForm().show();
       }
       });
      
          c3.add(id);
          c3.add(nom);
          c3.add(typereclamations);
          
          c3.add(numerocl);
           c3.add(adresse);
           c3.add(btnAddTask);
          
          
          
                      
           
                        
           System.out.println("");
              
  add(c3);
              
            
          getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK
                , e-> previous.showBack()); // Revenir vers l'interface précédente
                
            }
          
        }
     
    }

 
}
