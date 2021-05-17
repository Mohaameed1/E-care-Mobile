/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myap.gui;

import com.codename1.components.InfiniteProgress;
import com.codename1.components.ToastBar;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.mycompany.myap.Services.ServiceClinique;
import com.mycompany.myap.entities.Clinique;

/**
 *
 * @author Siwar Boutaleb
 */
public class AddCliniqueForm extends Form {
    public AddCliniqueForm(Form previous) {
        setTitle("Ajouter une clinique");
       
        TextField tfnomcl = new TextField("","Nom clinique");   
        TextField tfadressecl = new TextField("","Adresse clinique");
        TextField tfnumerocl = new TextField("","Numéro de téléphone");
        
        TextField tfdesccl = new TextField("","Description ");
     
     
         
      
        
        Button B = new Button("Ajouter");
        
        B.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                
                if ((tfnomcl.getText().length()==0)||(tfadressecl.getText().length()==0)||(tfnumerocl.getText().length()>8)||(tfnumerocl.getText().length()<8)||(tfdesccl.getText().length()==0))
                { Dialog.show("Alerte", "Veuillez vérifier les champs!", new Command("OK"));}
                else{
            InfiniteProgress ip = new InfiniteProgress();
            final Dialog idialog = ip.showInfiniteBlocking();
            Clinique s = new Clinique(String.valueOf(tfnomcl.getText()
                    .toString()).toString(),String.valueOf(tfadressecl.getText()
                    .toString()).toString()
                    ,Integer.parseInt(tfnumerocl.getText().toString())
            ,String.valueOf(tfdesccl.getText().toString()).toString());
                    System.err.println("data stade=="+s);
                     ServiceClinique.getInstance().addStade(s);
                    idialog.dispose();
                     ToastBar.showMessage("Votre clinique est ajoutée", FontImage.MATERIAL_ACCESS_TIME); 
            
                   
            }
                
        }

           
        });
        addAll(tfnomcl,tfadressecl,tfnumerocl,tfdesccl,B);
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e->previous.showBack());
    }

  
}
