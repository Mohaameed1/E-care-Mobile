/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myap.gui;

import com.codename1.components.ToastBar;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Component;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;


/**
 *
 * @author siwar boutaleb
 */
public class Addmail extends Form{

    public Addmail(Form previous) {
        
    
        setTitle("Envoyer un Email");
        setLayout(BoxLayout.y());
        
   TextField adress=new TextField("","Veuillez entrer l'adresse mail du destinataire  ");
        adress.setUIID("TextFieldBlack");
         addStringValue("Adress :",adress);
    TextField object=new TextField("","Veuillez enter l'objet de l'Email ");
        object.setUIID("TextFieldBlack");
         addStringValue("Objet :",object);
    TextField mail=new TextField("","Veuillez enter le text ");
        mail.setUIID("TextFieldBlack");
    addStringValue("Mail:",mail);
        
           Button btnAjouter=new Button("Envoyer");
           
        addStringValue("",btnAjouter);
         
        btnAjouter.addActionListener(new ActionListener()
         
           
        {
           
            
            @Override
            public void actionPerformed(ActionEvent evt) {
                if ((mail.getText().length()==0))
                    Dialog.show("Alerte", "Veuillez remplir tous les champs", new Command("OK"));
                else
                {   try {
                    mailUtil.sendMail(adress.getText(), "boutaleb.siwar@esprit.tn","203JFT1134",object.getText(), mail.getText());
                    } catch (Exception ex) {
                       
                    }
                       }
                    ToastBar.showMessage("Votre mail est bien envoyé", FontImage.MATERIAL_ACCESS_TIME);
                     new HomeForm().show();
                }
                
                
           
        });
   
    
                 getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK
                , e-> previous.showBack()); // Revenir vers l'interface précédente
                
    }

    private void addStringValue(String s ,Component v) {
         add(BorderLayout.west  (new Label(s,"PaddedLabel")).add(BorderLayout.CENTER,v));
          
    }
    
   
}