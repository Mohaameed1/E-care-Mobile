/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myap.gui;

import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.mycompany.myap.Services.ServiceClinique;
import com.mycompany.myap.entities.Clinique; 
import java.util.ArrayList;

/**
 *
 * @author Siwar Boutaleb
 */
public class ListeCliniqueForm extends Form {
    Form current;
ArrayList<Clinique> data = new ArrayList<>();

public ListeCliniqueForm(Form previous) {
    setTitle("Listes des cliniques");
    data = ServiceClinique.getInstance().getAllCours();
    Container y = new Container(new BoxLayout(BoxLayout.Y_AXIS));

    for (int i=0;i<data.size();i++){
        Container x = new Container(new BoxLayout(BoxLayout.X_AXIS));
        Container xx = new Container(new BoxLayout(BoxLayout.X_AXIS));
        Clinique u = new Clinique();
        u.setId(data.get(i).getId());
        
        
        u.setNomcl(data.get(i).getNomcl());
        u.setAdressecl(data.get(i).getAdressecl());
        u.setNumerocl(data.get(i).getNumerocl());
        u.setDesccl(data.get(i).getDesccl());
      
        Label separation = new Label("----------------------------");
        Label nom = new Label("Nom clinique : " + data.get(i).getNomcl());
        Label adresse = new Label("Adresse clinique : "+ data.get(i).getAdressecl());
        Label prix  = new Label("Numérode téléphone: "+ data.get(i).getNumerocl());
        Label contact = new Label("Description  : "+ data.get(i).getDesccl());
    
    //search   tbadel 3onwen tool bar   
  //prepare field
        TextField searchField;
        searchField = new TextField("", "Liste des cliniques"); 
        searchField.getHintLabel().setUIID("Title");
        searchField.setUIID("Title");
        getToolbar().setTitleComponent(searchField);

        //if field content changed
        searchField.addDataChangeListener((i1, i2) -> { 
            String t = searchField.getText();
            if(t.length() < 1) {
                for(Component cmp : getContentPane()) {
                    cmp.setHidden(false);
                    cmp.setVisible(true);
                }
            } else {
                t = t.toLowerCase();
                for(Component cmp: getContentPane()) {
               //tekhou el val ta3 el champ : champ li 3malt 3lih el recherche type span label (emplacement : container->container->spanlabel ) 
                    String val = ((SpanLabel) ((Container)((Container) cmp).getComponentAt(0)).getComponentAt(0)).getText();
                    System.out.println( val    );
                    boolean show = val != null && val.toLowerCase().indexOf(t) > -1;
                    cmp.setHidden(!show);
                    cmp.setVisible(show);
                }
            }
            getContentPane().animateLayout(250);
        });
        
//        Button modif = new Button("Modifier");
//        Button supp = new Button("Supprimer");
        //CheckBox box = new CheckBox();
        Button modif = new Button("Modifier");
       Button supp = new Button("Supprimer");
        
//        supp.addActionListener(new ActionListener(){
//        @Override
//        public void actionPerformed(ActionEvent evt) {
//            ServiceAbonnement.getInstance().deleteAbonnement(ab);
//            Dialog.show("Success", "Memory Deleted Successfully.", "OK", "Cancel");
//        }
//        });
supp.addActionListener(new ActionListener(){
        @Override
       public void actionPerformed(ActionEvent evt) {
            ServiceClinique.getInstance().deleteStade(u.getId()); 
            Dialog.show("Alerte", "Voulez-vous vraiment supprimer cette clinique ?", "OK", "Cancel");
            new HomeForm().show();
       }

            
       });
         modif.addActionListener(new ActionListener(){
        @Override
       public void actionPerformed(ActionEvent evt) {
             
            new ModifCliniqueForm(u);
       }
       });
        
        x.addAll(nom,adresse,supp , modif);
        
        //xx.addAll(supp,modif);
        y.addAll(x,xx,separation);
    }
    
    
    
    
    addAll(y);
    getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK
                , e-> previous.showBack()); // Revenir vers l'interface précédente
}

    
    
}
