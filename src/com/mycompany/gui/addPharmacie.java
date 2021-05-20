/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;


import com.codename1.ui.AutoCompleteTextField;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
import com.mycompany.entities.Pharmacie;
import com.mycompany.services.PharmacieService;
import java.io.IOException;
import java.util.Date;

/**
 *
 * @author Rzouga
 */
public class addPharmacie extends Form {
    
          Resources theme;

               public addPharmacie(Form previous) throws IOException {
             super("Les Pharmacie",BoxLayout.y());

    
   
        this.getToolbar().addCommandToOverflowMenu("Add Pharmacie", null, ev->{
        Form addEvent = new Form("Ajouter Pharmacie",BoxLayout.y());
        Label AJOUT = new Label("ADD Pharmacie");
        AJOUT.setUIID("login");
        addEvent.add(AJOUT);
        TextField Nom = new TextField("", "Nom", 20, TextArea.TEXT_CURSOR);
        Nom.setUIID("txtn");
        TextField Adresse = new TextField("", "Adresse", 20, TextArea.TEXT_CURSOR);
        Adresse.setUIID("txtn");

        TextField NumTel = new TextField("", "Numéro de Téléphone", 20, TextArea.NUMERIC); 
        NumTel.setUIID("txtn");
      //  Button upload = new Button("Upload Image");
      //  upload.setUIID("vtnvalid");
        Button save = new Button("Ajouter");
        save.setUIID("vtnvalid");
        addEvent.add("Titre : ").add(Nom);
        addEvent.add("Lieu : ").add(Adresse);
        addEvent.add("Nombre De Place : ").add(NumTel);

 
        addEvent.add(save);
        
        save.addActionListener(l
                                -> {

                            if (Nom.getText().equals("")) {
                                Dialog.show("Erreur", "Champ vide de firstname ", "OK", null);

                            }  else if (Adresse.getText().equals("")) {
                                Dialog.show("Erreur", "Champ vide de lastname ", "OK", null);

                            } else if (NumTel.getText().equals("")) {
                                Dialog.show("Erreur", "Champ vide de email ", "OK", null);

                            } 
                       else {
                           
                                Date datedebut = new Date();
                                Date datefin = new Date();
                                Pharmacie p = new Pharmacie();
                                p.setNom(Nom.getText());
                                p.setAdresse(Adresse.getText());
                                p.setNumtel(Integer.valueOf(NumTel.getText()));
                                System.out.println("forms.addEvet.addItem()"+p);
                                if (new PharmacieService().addPharmacie(p) == true) {
                                    Dialog.show("Ajouter Pharmacie", "Ajouter Pharmacie aves success ", "OK", null);
                                    
                                    
                                } else {
                                    Dialog.show("Erreur", " Erreur d'ajout ", "OK", null);
                                }

                            }

                        }
                        );

        
        addEvent.show();
 });
              for(Pharmacie c:new PharmacieService().getAllPharmacie()){
           
 
          this.add(addItem(c));    
     
 
        }

     
     }
               
public Container addItem(Pharmacie e) throws IOException{
            
        Container cn1=new Container(new BorderLayout());
        Container cn2=new Container(BoxLayout.y());
        Container cn3 = new Container(BoxLayout.y());
        Label nom=new Label(e.getNom());
          Label libelle_nom = new Label("Nom");
        Label tel=new Label(String.valueOf(e.getNumtel()));
        Label libelle_tel = new Label("Telephone");

        Label adresse=new Label(e.getAdresse());
        Label libelle_adresse = new Label("adresse");


       

        Button btn=new Button("Details");

        cn2.add(libelle_nom).add(nom);
        
        cn2.add(libelle_adresse).add(adresse);
   
        cn2.add(libelle_tel).add(tel);
 
        cn3.add(btn);
        cn2.add(cn3);
        cn1.add(BorderLayout.WEST, cn2);
      
                btn.addActionListener(e1->{
        
        Form  f2=new Form("Details",BoxLayout.y());
        Label titrem=new Label(e.getNom());
       
        Label nbrparticipantm=new Label(String.valueOf(e.getNumtel()));
        Label lieum=new Label(e.getAdresse());

        

       


     Button Modifier = new Button("Modifier");
     Button Supprimer = new Button("Supprimer");
     Button map = new Button("check location");
             map.addActionListener(new ActionListener(){
        @Override
       public void actionPerformed(ActionEvent evt) {
             
            new Map().start(e);
       }
       });

     Modifier.addActionListener(mod -> 
     
     {
         
         Form fmodifier = new Form("Modifier Pharmacie", BoxLayout.y());

         Button submit = new Button("Submit");
         AutoCompleteTextField nom2 =  new AutoCompleteTextField(e.getNom());
          
         nom2.setMinimumElementsShownInPopup(1);
         nom2.setUIID("txtn");
         AutoCompleteTextField adresse2=  new AutoCompleteTextField(e.getAdresse());
         adresse2.setMinimumElementsShownInPopup(1);
         adresse2.setUIID("txtn");

         AutoCompleteTextField numtel=  new AutoCompleteTextField(String.valueOf(e.getNumtel()));
         
         numtel.setMinimumElementsShownInPopup(1);
           numtel.setUIID("txtn");

          Label lib_nom = new Label("Nom");
                lib_nom.setUIID("pass");
         fmodifier.add(lib_nom).add(nom2);
              Label lib_adresse = new Label("Adresse");
                lib_adresse.setUIID("pass");
         fmodifier.add(lib_adresse).add(adresse2);
     Label lib_numtel = new Label("Numéro de téléphone : ");
                lib_numtel.setUIID("pass");
         fmodifier.add(lib_numtel).add(numtel);

         fmodifier.add(submit);
         

         submit.addActionListener(sub ->
                 
         {
             try {
                 Pharmacie es = new Pharmacie();

                 es.setId(e.getId());
                 es.setNom(nom2.getText());
                 es.setAdresse(adresse2.getText());
                 es.setNumtel(Integer.valueOf(numtel.getText()));

                 System.out.println("forms.addEvet.addItem()"+es);
                 
                 
                                    if ( new PharmacieService().ModifierPharmacie(es) == true) {
                                        Dialog.show("Modifier Pharmacie", "Pharmacie Modifier aves success ", "OK", null);
                                        
                                        
                                    } else {
                                        Dialog.show("Erreur", " Erreur d'ajout ", "OK", null);
                                    }
                 
                 new addPharmacie(this).show();
             } catch (IOException ex) {
             }
             
         }
                 
         );
         fmodifier.show();
     } 
     );
     
       Supprimer.addActionListener(sup ->  
       
       {
           
            if (new PharmacieService().DeletePharmacie(e.getId())) {
                                        Dialog.show("Supprimer Evenemet", "Evenement Supprimer aves success ", "OK", null);
                                        
                                             try {
                new addPharmacie(this).show();
            } catch (IOException ex) {
            }
                                    } else {
                                        Dialog.show("Erreur", " Erreur de suppression ", "OK", null);
                                    }
           
           
           
         
       
       
       }
       
       );
         
     
               Label lib_nom = new Label("Nom");
      
              Label lib_adresse = new Label("Adresse");
   
 

   Label lib_nbr_tel = new Label("Nombre de Participant : ");


                
            f2.add(lib_nom).add(titrem).add(lib_nbr_tel).add(nbrparticipantm).add(lib_adresse).add(lieum).add(Modifier).add(Supprimer).add(map);
            f2.show();
         
        });
        
        
        
        

        cn1.setLeadComponent(btn);
        return cn1;
                
    }
    

    
}
