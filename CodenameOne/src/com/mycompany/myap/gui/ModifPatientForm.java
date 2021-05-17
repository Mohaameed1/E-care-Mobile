/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myap.gui;

import com.codename1.components.FloatingHint;
import com.codename1.components.InfiniteProgress;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
import com.mycompany.myap.Services.ServicePatient; 
import com.mycompany.myap.entities.Patient;


/**
 *
 * @author Siwar Boutaleb
 */
public class ModifPatientForm extends Form{
    Form current;
    public ModifPatientForm(Patient patient){
         setTitle("Modifier les patients");
       
        TextField tfid = new TextField(patient.getId());
        TextField tfclinique_id = new TextField(String.valueOf(patient.getClinique_id()),"L'id du clinique");
        
        
        TextField tfname = new TextField(patient.getName(),"Nom et prénom");
        
        TextField tfemail = new TextField(patient.getEmail(),"Adresse mail");
        TextField tfphone = new TextField(String.valueOf(patient.getPhone()),"Numéro de téléphone");
         
        TextField tfadresse = new TextField(patient.getAdresse(),"Adresse");
        
        Button btnU = new Button("Modifier");
        btnU.setUIID("Button");
     btnU.addPointerPressedListener(l->{
         
         patient.setClinique_id( Integer.parseInt(tfclinique_id.getText().toString()));
         patient.setName(tfname.getText().toString());
       patient.setEmail(tfemail.getText().toString());
         patient.setPhone( Integer.parseInt(tfphone.getText().toString()));
         patient.setAdresse(tfadresse.getText().toString());
     
     
     if(ServicePatient.getInstance().modifierpatient(patient)){
         Dialog.show("Succes", "Patient modifié avec succès.", new Command("OK"));
         new HomeFormFront().show();
     }
     
     });
       
        Label l1= new Label();
        Label l2= new Label();
        Label l3= new Label();
        Label l4= new Label();
        Label l5= new Label();
        
        Container content = BoxLayout.encloseY(
                l1,l2,l3,l4,l5,
                
                new FloatingHint(tfclinique_id),
                new FloatingHint(tfname),
                new FloatingHint(tfemail),
                new FloatingHint(tfphone),
                new FloatingHint(tfadresse),
                btnU
        );
                
        
        
        
        add(content);
        show();
        
       
       
    }
    }