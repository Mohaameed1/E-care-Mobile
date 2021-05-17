/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myap.gui;

import com.codename1.components.InfiniteProgress;
import com.codename1.components.ToastBar;
import com.codename1.notifications.LocalNotification;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.mycompany.myap.Services.ServiceClinique;
import com.mycompany.myap.Services.ServicePatient;
import com.mycompany.myap.entities.Clinique;
import com.mycompany.myap.entities.Patient;

/**
 *
 * @author Siwar Boutaleb
 */
public class AddPatientForm extends Form {
     LocalNotification ln = new LocalNotification();
        
    public AddPatientForm(Form previous) {
        setTitle("Ajouter patient");
       
        TextField tfclinique_id = new TextField("","L'id du clinique");     
        TextField tfname = new TextField("","Nom et prénom");
        TextField tfemail = new TextField("XXXXX@yyyyy.fr","Adresse mail", 20, TextField.EMAILADDR);
        
        TextField tfphone = new TextField("","Numéro de téléphone ");
        TextField tfadresse = new TextField("","Adresse");
        
     
     
         
      
        
        Button B = new Button("Ajouter");
        
        B.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                
                if ((tfclinique_id.getText().length()==0)||(tfemail.getText().length()==0)||(tfphone.getText().length()>8)||(tfphone.getText().length()<8))
                { Dialog.show("Alerte", "Veuillez vérifier les champs!", new Command("OK"));}
                else{
            InfiniteProgress ip = new InfiniteProgress();
            final Dialog idialog = ip.showInfiniteBlocking();
            Patient s = new Patient(
                    Integer.parseInt(tfclinique_id.getText().toString()),String.valueOf(tfname.getText().toString()).toString(), 
                    String.valueOf(tfemail.getText().toString()).toString(),
                    
                    Integer.parseInt(tfphone.getText().toString()),
            String.valueOf(tfadresse.getText()
                    .toString()).toString());
                    System.err.println("data stade=="+s);
                     ServicePatient.getInstance().addStade(s);
                    idialog.dispose();
                      ToastBar.showMessage("Bien ajouté", FontImage.MATERIAL_ACCESS_TIME); 
            
                   new HomeFormFront().show();
            }
           
             
        }

           
        });
        addAll(tfclinique_id,tfname,tfemail,tfphone,tfadresse,B);
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e->previous.showBack());
    }

    AddPatientForm() {
        }

  public void onEntered() {
        if(Display.getInstance().isMinimized()) {
            Display.getInstance().callSerially(() -> {
                Dialog.show("Welcome", "Thanks for arriving", "OK", null);
            });
        } else {
            ln.setId("LnMessage");
            ln.setAlertTitle("Welcome");
            ln.setAlertBody("Thanks for arriving!");
            Display.getInstance().scheduleLocalNotification(ln, 10, LocalNotification.REPEAT_NONE);
        }
    }    
}
