/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.components.FloatingHint;
import com.codename1.components.ToastBar;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.FontImage;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
import com.mycompany.entities.Medecin;
import com.mycompany.services.MedecinService;

/**
 *
 * @author achra
 */
public class ModifierMedForm extends BaseForm{
      
    public ModifierMedForm(Resources res,Medecin r){
   super("Newsfeed", BoxLayout.y());
        Toolbar tb = new Toolbar(true);
        setToolbar(tb);
        getTitleArea().setUIID("Container");
        
        getContentPane().setScrollVisible(false);
        
        super.addSideMenu(res);
      TextField nom=new TextField(r.getNom(),"nom",20,TextField.ANY);
        nom.setUIID("NewsTopLine");
        
        
TextField prenom=new TextField(r.getPrenom(),"prenom",20,TextField.ANY);
        prenom.setUIID("NewsTopLine");
      
        
        
TextField specialite=new TextField(r.getSpecialite(),"specialité",20,TextField.ANY);
        specialite.setUIID("NewsTopLine");
       
        
        
TextField adresse=new TextField(r.getAdresse(),"adresse",20,TextField.ANY);
        adresse.setUIID("NewsTopLine");
                
TextField sexe=new TextField(r.getSexe(),"sexe",20,TextField.ANY);
        sexe.setUIID("NewsTopLine");
             
                
TextField num_tel=new TextField(r.getNum_tel(),"num",20,TextField.ANY);
        num_tel.setUIID("NewsTopLine");
TextField cin=new TextField(r.getCin(),"cin",20,TextField.ANY);
        cin.setUIID("NewsTopLine");
        
        

        
        
        
      
        
        nom.setSingleLineTextArea(true);
                prenom.setSingleLineTextArea(true);
        specialite.setSingleLineTextArea(true);

        adresse.setSingleLineTextArea(true);
        sexe.setSingleLineTextArea(true);
        num_tel.setSingleLineTextArea(true);
                cin.setSingleLineTextArea(true);

       
        
        Button btnModifier=new Button("Modifier");
        btnModifier.setUIID("Button");
        
        //Event onclick modif
     btnModifier.addPointerPressedListener(l->{
     
     r.setNom(nom.getText());
      r.setPrenom(prenom.getText());
       r.setSpecialite(specialite.getText());
        r.setAdresse(adresse.getText());
                r.setSexe(sexe.getText());
                        r.setNum_tel(num_tel.getText());
                                r.setCin(cin.getText());



         
         //appel funct modif m service
         
         if(MedecinService.getInstance().updateMed(r)){
         
         new ListMedecinForm(res).show();
         
         }});
         Button btnAnnuler =new Button("Annuler");
         btnAnnuler.addActionListener(e-> {
         
         new ListMedecinForm(res).show();
         
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
                 new FloatingHint(prenom),
                 createLineSeparator(),
                  new FloatingHint(specialite),
                 createLineSeparator(),
                  new FloatingHint(adresse),
                 createLineSeparator(),
                 new FloatingHint(sexe),
                 createLineSeparator(),
                 
                 new FloatingHint(num_tel),
                 createLineSeparator(),
                 new FloatingHint(cin),
                 createLineSeparator(),
            
                   createLineSeparator(),
                
                 btnModifier,
                 btnAnnuler
                 
                 
                 );
         
         add(content);
         show();
             
     
     
     
  
     
     
     
     
     
    }
    
}
