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
import com.mycompany.entities.Commentaire;
import com.mycompany.services.ServiceCommentaire;

/**
 *
 * @author achra
 */
public class ModifierCommentaireForm extends BaseForm{
      
    public ModifierCommentaireForm(Resources res,Commentaire r){
   super("Newsfeed", BoxLayout.y());
        Toolbar tb = new Toolbar(true);
        setToolbar(tb);
        getTitleArea().setUIID("Container");
        
        getContentPane().setScrollVisible(false);
        
        super.addSideMenu(res);
      TextField nom=new TextField(r.getPseudo(),"pseudo",20,TextField.ANY);
        nom.setUIID("NewsTopLine");
        
        
TextField adresse=new TextField(r.getSujet(),"sujet",20,TextField.ANY);
        adresse.setUIID("NewsTopLine");
      
        
        
TextField numero=new TextField(r.getQuestion(),"question",20,TextField.ANY);
        numero.setUIID("NewsTopLine");
       
        
        
TextField mail=new TextField(r.getMedecin(),"medecin",20,TextField.ANY);
        mail.setUIID("NewsTopLine");
     
        
        

        
        
        
      
        
        nom.setSingleLineTextArea(true);
        adresse.setSingleLineTextArea(true);
        numero.setSingleLineTextArea(true);
        mail.setSingleLineTextArea(true);
       
        
        Button btnModifier=new Button("Modifier");
        btnModifier.setUIID("Button");
        
        //Event onclick modif
     btnModifier.addPointerPressedListener(l->{
     
     r.setPseudo(nom.getText());
      r.setSujet(adresse.getText());
       r.setQuestion(numero.getText());
        r.setMedecin(mail.getText());
         
         //appel funct modif m service
         
         if(ServiceCommentaire.getInstance().updateCommentaire(r)){
         
         new ListCommentaireForm(res).show();
         
         }});
         Button btnAnnuler =new Button("Annuler");
         btnAnnuler.addActionListener(e-> {
         
         new ListCommentaireForm(res).show();
         
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
            
                   createLineSeparator(),
                
                 btnModifier,
                 btnAnnuler
                 
                 
                 );
         
         add(content);
         show();
                 
     
     
     
  
     
     
     
     
     
    }
    
}
