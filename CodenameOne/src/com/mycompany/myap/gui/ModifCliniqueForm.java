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
import com.mycompany.myap.Services.ServiceClinique; 
import com.mycompany.myap.entities.Clinique; 


/**
 *
 * @author Siwar Boutaleb
 */
public class ModifCliniqueForm extends Form{
    Form current;
    public ModifCliniqueForm(Clinique clinique){
         setTitle("Modifier les cliniques");
       
        TextField tfid = new TextField(clinique.getId());
        TextField tfnomcl = new TextField(String.valueOf(clinique.getNomcl()),"Nom clinique");
        
        TextField tfadressecl = new TextField(clinique.getAdressecl(),"Adresse clinique");
        
        TextField tfnumerocl = new TextField(String.valueOf(clinique.getNumerocl()),"Numéro de téléphone");
        TextField tfdesccl = new TextField(clinique.getDesccl(),"Description");
         
       
        
        Button btnU = new Button("Modifier");
        btnU.setUIID("Button");
     btnU.addPointerPressedListener(l->{
         
         clinique.setNomcl(tfnomcl.getText().toString());
         clinique.setAdressecl(tfadressecl.getText().toString());
       clinique.setNumerocl(Integer.parseInt( tfnumerocl.getText().toString()));
         clinique.setDesccl(tfdesccl.getText().toString());
        
     
     
     if(ServiceClinique.getInstance().modifierClinique(clinique)){
         Dialog.show("Succes", "Clinique modifiée avec succès.", new Command("OK"));
         new HomeForm().show();
     }
     
     });
       
        Label l1= new Label();
        Label l2= new Label();
        Label l3= new Label();
        Label l4= new Label();
        Label l5= new Label();
        
        Container content = BoxLayout.encloseY(
                l1,l2,l3,l4,l5,
                
                new FloatingHint(tfnomcl),
                new FloatingHint(tfadressecl),
                new FloatingHint(tfnumerocl),
                new FloatingHint(tfdesccl),
               
                btnU
        );
                
        
        
        
        add(content);
        show();
        
       
       
    }

   
    }