/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.components.InfiniteProgress;
import com.codename1.ui.Button;
import com.codename1.ui.Component;
import com.codename1.ui.Dialog;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
import com.mycompany.entities.Medecin;
import com.mycompany.services.MedecinService;

/**
 *
 * @author alaaa
 */
public class AjoutMedForm extends BaseForm {
    Form current;
    public AjoutMedForm(Resources res) {
        super("NewsFeed", BoxLayout.y());
        Toolbar tb = new Toolbar(true);
        current = this;
        setToolbar(tb);
        getTitleArea().setUIID("Container");
        setTitle("Ajouter Medecin");
        getContentPane().setScrollVisible(false);
        
        
        
        
        TextField nom = new TextField("","Entrez nom");
        nom.setUIID("TextFieldBlack");
        addStringValue("nom",nom);
        
        TextField prenom = new TextField("","Entrez prenom");
        prenom.setUIID("TextFieldBlack");
        addStringValue("prenom",prenom);
        
        TextField specialite = new TextField("","Entrez la spécialité");
        specialite.setUIID("TextFieldBlack");
        addStringValue("specialite",specialite);
        
         TextField adresse = new TextField("","Entrez adresse");
        adresse.setUIID("TextFieldBlack");
        addStringValue("adresse",adresse);
        
         TextField sexe = new TextField("","Entrez le sexe");
        sexe.setUIID("TextFieldBlack");
        addStringValue("sexe",sexe);
        
         TextField num_tel = new TextField("","Entrez le num");
        num_tel.setUIID("TextFieldBlack");
        addStringValue("num",num_tel);
        
              TextField cin = new TextField("","Entrez  cin");
        cin.setUIID("TextFieldBlack");
        addStringValue("cin",cin);
        
        Button btnAjouter = new Button("Ajouter");
        addStringValue("",btnAjouter);
        
        
      
        
        btnAjouter.addActionListener((e) -> {
            try {
                if (nom.getText() =="" || prenom.getText()=="" || specialite.getText() == "" || num_tel.getText()=="") {
                    Dialog.show("Veuillez verifier les données","","Annuler","OK");
                }
                else {
                    InfiniteProgress ip = new InfiniteProgress();
                    final Dialog iDialog=ip.showInfiniteBlocking();
                    
                    Medecin med = new Medecin (String.valueOf(nom.getText()).toString()
                            ,String.valueOf(prenom.getText()).toString()
                            ,String.valueOf(specialite.getText()).toString(),String.valueOf(adresse.getText()).toString(),
                                    String.valueOf(sexe.getText()).toString(),String.valueOf(num_tel.getText()).toString(),String.valueOf(cin.getText()).toString() ) ;
                                    
                            
                    System.out.println("data medecin == " +med);
                    MedecinService.getInstance().ajoutMed(med);
                    
                    iDialog.dispose();
                    refreshTheme();
                    new ListMedecinForm(res).show();
                }
            } catch (Exception ex ) {
                ex.printStackTrace();
            }
        });
        
        
        
        
        
    }

    private void addStringValue(String s, Component v) {
add(BorderLayout.west(new Label(s,"PaddedLabel"))
        .add(BorderLayout.CENTER,v));
add(createLineSeparator(0xeeeeee));        
    }
}
