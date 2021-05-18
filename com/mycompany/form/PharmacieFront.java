/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.form;

import com.codename1.ui.AutoCompleteTextField;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.Font;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.Slider;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.Border;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.mycompany.Entity.AvisClient;
import com.mycompany.Entity.Pharmacie;
import com.mycompany.Service.PharmacieService;
import java.io.IOException;
import java.util.Date;

/**
 *
 * @author Rzouga
 */
public class PharmacieFront  extends Form{
    
          Resources theme;

               public PharmacieFront(Form previous) throws IOException {
               super("Les Pharmacie",BoxLayout.y());
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
        Label nomt=new Label(e.getNom());
       
        Label telt=new Label(String.valueOf(e.getNumtel()));
        Label adresset=new Label(e.getAdresse());
                
        
                       Label lib_nom = new Label("Nom");
              
      
              Label lib_adresse = new Label("Adresse");
   
 

   Label lib_nbr_tel = new Label("Telephone : ");
             
                        TextField des = new TextField("", "Description", 20, TextArea.TEXT_CURSOR);
                                Slider rate = createStarRankSlider();
             Container CR = new Container(new BoxLayout(BoxLayout.Y_AXIS));
            Button bou = new Button("Donner une note");
            CR.add(FlowLayout.encloseCenter(rate));
            CR.add(FlowLayout.encloseCenter(bou));
         
            bou.addActionListener(ev->{
                int avis = rate.getProgress() / 2;
                PharmacieService vs = new PharmacieService();
                AvisClient a = new AvisClient();
                a.setNote(des.getText());
                vs.addRate(e.getId(), avis,a);
                System.out.println(avis);
            try {
                new PharmacieFront(this).show();
            } catch (Exception ex) {
            }

            });
            f2.add(lib_nom).add(nomt).add(lib_nbr_tel).add(telt).add(lib_adresse).add(adresset).add(des).add(CR);
            f2.show();
    
                });
                        cn1.setLeadComponent(btn);

                                return cn1;

                
    
}




  private void initStarRankStyle(Style s, Image star) {
        s.setBackgroundType(Style.BACKGROUND_IMAGE_TILE_BOTH);
        s.setBorder(Border.createEmpty());
        s.setBgImage(star);
        s.setBgTransparency(0);
    }
     private Slider createStarRankSlider() {
        Slider starRank = new Slider();
        starRank.setEditable(true);
        starRank.setMinValue(0);
        starRank.setMaxValue(10);
         Font fnt = Font.createTrueTypeFont("native:MainLight", "native:MainLight").
                derive(Display.getInstance().convertToPixels(5, true), Font.STYLE_PLAIN);
         Style s = new Style(0xffff33, 0, fnt, (byte) 0);
        Image fullStar = FontImage.createMaterial(FontImage.MATERIAL_STAR, s).toImage();
        s.setOpacity(100);
        s.setFgColor(0);
        Image emptyStar = FontImage.createMaterial(FontImage.MATERIAL_STAR, s).toImage();
        initStarRankStyle(starRank.getSliderEmptySelectedStyle(), emptyStar);
        initStarRankStyle(starRank.getSliderEmptyUnselectedStyle(), emptyStar);
        initStarRankStyle(starRank.getSliderFullSelectedStyle(), fullStar);
        initStarRankStyle(starRank.getSliderFullUnselectedStyle(), fullStar);
        starRank.setPreferredSize(new Dimension(fullStar.getWidth() * 5, fullStar.getHeight()));
        return starRank;
    }

}
