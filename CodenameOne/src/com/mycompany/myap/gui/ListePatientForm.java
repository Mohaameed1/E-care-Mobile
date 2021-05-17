/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myap.gui;

import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.mycompany.myap.Services.ServiceClinique;
import com.mycompany.myap.Services.ServicePatient; 
import com.mycompany.myap.entities.Clinique;
import com.mycompany.myap.entities.Patient; 
import java.util.ArrayList;

/**
 *
 * @author Siwar Boutaleb
 */
public class ListePatientForm extends Form {
    Form current;
ArrayList<Patient> data = new ArrayList<>();

public ListePatientForm(Form previous) {
    setTitle("Listes des patients");
    data = ServicePatient.getInstance().getAllCours();
    Container y = new Container(new BoxLayout(BoxLayout.Y_AXIS));

    for (int i=0;i<data.size();i++){
        Container x = new Container(new BoxLayout(BoxLayout.X_AXIS));
        Container xx = new Container(new BoxLayout(BoxLayout.X_AXIS));
        Patient u = new Patient();
        u.setId(data.get(i).getId());
        
        
        u.setClinique_id(data.get(i).getClinique_id());
        u.setName(data.get(i).getName());
        u.setEmail(data.get(i).getEmail());
        u.setPhone(data.get(i).getPhone());
        u.setAdresse(data.get(i).getAdresse());
      
        Label separation = new Label("----------------------------");
        Label cliniqueid = new Label("idclinique : " + data.get(i).getClinique_id());
        
        Label nom = new Label("Nom et prénom : " + data.get(i).getName());
        Label adresse = new Label("Adresse mail : "+ data.get(i).getEmail());
        Label prix  = new Label("Numéro de téléphone: "+ data.get(i).getPhone());
        Label contact = new Label("Adresse : "+ data.get(i).getAdresse());
    
    
        
                
            System.out.println(data.get(i).getClinique_id());
//        Button modif = new Button("Modifier");
//        Button supp = new Button("Supprimer");
        //CheckBox box = new CheckBox();
        Button modif = new Button("Modifier");
       Button supp = new Button("Supprimer");
        
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
            ServicePatient.getInstance().deletepatient(u.getId()); 
            Dialog.show("Alerte", "Etes-vous sur de supprimer ?", "OUI", "NON");
              new HomeFormFront().show();
       }

            
       });

         modif.addActionListener(new ActionListener(){
        @Override
       public void actionPerformed(ActionEvent evt) {
             
            new ModifPatientForm(u);
       }
       });
        
        x.addAll( cliniqueid,nom,supp , modif);
        
        //xx.addAll(supp,modif);
        y.addAll(x,xx,separation);
    }
    
    
    
    
    addAll(y);
    getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK
                , e-> previous.showBack()); // Revenir vers l'interface précédente
}

    
    
}
