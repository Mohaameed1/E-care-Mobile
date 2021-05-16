/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.components.FloatingHint;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
import com.mycompany.entities.Livraison;
import com.mycompany.services.ServiceLivraison;

/**
 *
 * @author achra
 */
public class ModifierLivraisonForm extends BaseForm{
      
    public ModifierLivraisonForm(Resources res,Livraison r){
   super("Newsfeed", BoxLayout.y());
        Toolbar tb = new Toolbar(true);
        setToolbar(tb);
        getTitleArea().setUIID("Container");
        setTitle("Newsfeed");
        getContentPane().setScrollVisible(false);
        
        super.addSideMenu(res);
      TextField nom=new TextField(r.getNom(),"nom",20,TextField.ANY);
        nom.setUIID("NewsTopLine");
        
        
TextField adresse=new TextField(r.getAdresse(),"adresse",20,TextField.ANY);
        adresse.setUIID("NewsTopLine");
      
        
        
TextField numero=new TextField(r.getNumero(),"numero",20,TextField.ANY);
        numero.setUIID("NewsTopLine");
       
        
        
TextField mail=new TextField(r.getMail(),"mail",20,TextField.ANY);
        mail.setUIID("NewsTopLine");
     
        
        
TextField message=new TextField(r.getMessage(),"message",20,TextField.ANY);
        message.setUIID("NewsTopLine");
        
        
        
      
        
        nom.setSingleLineTextArea(true);
        adresse.setSingleLineTextArea(true);
        numero.setSingleLineTextArea(true);
        mail.setSingleLineTextArea(true);
        message.setSingleLineTextArea(true);
        
        Button btnModifier=new Button("Modifier");
        btnModifier.setUIID("Button");
        
        //Event onclick modif
     btnModifier.addPointerPressedListener(l->{
     
     r.setNom(nom.getText());
      r.setAdresse(adresse.getText());
       r.setNumero(numero.getText());
        r.setMail(mail.getText());
         r.setMessage(message.getText());
         //appel funct modif m service
         
         if(ServiceLivraison.getInstance().updateLivraison(r)){
         
         new ListLivraisonForm(res).show();
         
         }});
         Button btnAnnuler =new Button("Annuler");
         btnAnnuler.addActionListener(e-> {
         
         new ListLivraisonForm(res).show();
         
         });
     
         
         Label l2=new Label("");
         
         Label l3=new Label("");
         
         Label l4=new Label("");
         
         Label l5=new Label("");
         
         Label l6=new Label("");
         Label l7=new Label("");
         
         Label l1=new Label();
         
         Container content=BoxLayout.encloseY(
                 l1,l2,l3,l4,l5,
                 new FloatingHint(nom),
                 createLineSeparator(),
                 new FloatingHint(adresse),
                 createLineSeparator(),
                  new FloatingHint(numero),
                 createLineSeparator(),
                  new FloatingHint(mail),
                 createLineSeparator(),
                  new FloatingHint(message),
                 createLineSeparator(),
                   createLineSeparator(),
                
                 btnModifier,
                 btnAnnuler
                 
                 
                 );
         
         add(content);
         show();
                 
     
     
     
  
     
     
     
     
     
    }
    
}
