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
import com.mycompany.entities.Panier;
import com.mycompany.services.ServicePanier;

/**
 *
 * @author achra
 */
public class ModifierPanierForm extends BaseForm{
      
    public ModifierPanierForm(Resources res,Panier r){
   super("Newsfeed", BoxLayout.y());
        Toolbar tb = new Toolbar(true);
        setToolbar(tb);
        getTitleArea().setUIID("Container");
        setTitle("Newsfeed");
        getContentPane().setScrollVisible(false);
        
        super.addSideMenu(res);
      TextField Code=new TextField(r.getCode_panier(),"Code panier",20,TextField.ANY);
        Code.setUIID("NewsTopLine");
        
        
        TextField Produit=new TextField(r.getProduits(),"Produit",20,TextField.ANY);
        Produit.setUIID("NewsTopLine");
        
        
    
        

        

       

      
        

        

        
        
        
      
        
        Code.setSingleLineTextArea(true);
        Produit.setSingleLineTextArea(true);

      
        
        Button btnModifier=new Button("Modifier");
        btnModifier.setUIID("Button");
        
        //Event onclick modif
     btnModifier.addPointerPressedListener(l->{
     
     r.setCode_panier(Code.getText());
      r.setProduits(Produit.getText());
    
         //appel funct modif m service
         
         if(ServicePanier.getInstance().updatePanier(r)){
         
         new ListPanierForm(res).show();
         
         }});
         Button btnAnnuler =new Button("Annuler");
         btnAnnuler.addActionListener(e-> {
         
         new ListPanierForm(res).show();
         
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
                 new FloatingHint(Code),
                 createLineSeparator(),
                 new FloatingHint(Produit),
              createLineSeparator(),
               
                 createLineSeparator(),
                   createLineSeparator(),
                
                 btnModifier,
                 btnAnnuler
                 
                 
                 );
         
         add(content);
         show();
                 
     
     
     
  
     
     
     
     
     
    }
    
}
