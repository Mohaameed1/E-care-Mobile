/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.components.InfiniteProgress;
import com.codename1.components.ScaleImageLabel;
import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.ButtonGroup;
import com.codename1.ui.Component;
import static com.codename1.ui.Component.BOTTOM;
import static com.codename1.ui.Component.CENTER;
import static com.codename1.ui.Component.LEFT;
import static com.codename1.ui.Component.RIGHT;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Graphics;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.RadioButton;
import com.codename1.ui.Tabs;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.URLImage;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.layouts.LayeredLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.util.Resources;
import com.mycompany.entities.Panier;
import com.mycompany.entities.Pharmacie;
import com.mycompany.services.PharmacieService;
import com.mycompany.services.ServicePanier;
import java.io.IOException;
import java.util.ArrayList;


/**
 *
 * @author achra
 */
public class ListPanierForm extends BaseForm{
      Form current;
       private TextField recherche;
      

    public ListPanierForm(Resources res) {
        
        
    
    
    super("Newsfeed", BoxLayout.y());
        Toolbar tb = new Toolbar(true);
        current = this ;
        setToolbar(tb);
        getTitleArea().setUIID("Container");
        setTitle("Newsfeed");
        getContentPane().setScrollVisible(false);
        
        tb.addSearchCommand(e-> {
        });
        
        Tabs swipe =new Tabs();
        Label s1 =new Label();
                Label s2 =new Label();
                        
        addTab(swipe,s1,res.getImage("back-logo.jpeg"),"","",res);
             recherche = new TextField("", "Recherche");
           // recherche.addActionListener(a -> trier());
            add(recherche);
        //
        
          swipe.setUIID("Container");
        swipe.getContentPane().setUIID("Container");
        swipe.hideTabs();

        ButtonGroup bg = new ButtonGroup();
        int size = Display.getInstance().convertToPixels(1);
        Image unselectedWalkthru = Image.createImage(size, size, 0);
        Graphics g = unselectedWalkthru.getGraphics();
        g.setColor(0xffffff);
        g.setAlpha(100);
        g.setAntiAliased(true);
        g.fillArc(0, 0, size, size, 0, 360);
        Image selectedWalkthru = Image.createImage(size, size, 0);
        g = selectedWalkthru.getGraphics();
        g.setColor(0xffffff);
        g.setAntiAliased(true);
        g.fillArc(0, 0, size, size, 0, 360);
        RadioButton[] rbs = new RadioButton[swipe.getTabCount()];
        FlowLayout flow = new FlowLayout(CENTER);
        flow.setValign(BOTTOM);
        Container radioContainer = new Container(flow);
        for (int iter = 0; iter < rbs.length; iter++) {
            rbs[iter] = RadioButton.createToggle(unselectedWalkthru, bg);
            rbs[iter].setPressedIcon(selectedWalkthru);
            rbs[iter].setUIID("Label");
            radioContainer.add(rbs[iter]);
        }

       // rbs[0].setSelected(false);
        swipe.addSelectionListener((i, ii) -> {
            if (!rbs[ii].isSelected()) {
                rbs[ii].setSelected(true);
            }
        });

        Component.setSameSize(radioContainer, s1, s2);
        add(LayeredLayout.encloseIn(swipe, radioContainer));

        ButtonGroup barGroup = new ButtonGroup();
        RadioButton mesListes = RadioButton.createToggle("acht", barGroup);
        mesListes.setUIID("SelectBar");
        RadioButton liste = RadioButton.createToggle("list livraison", barGroup);
        liste.setUIID("SelectBar");
         RadioButton comnt = RadioButton.createToggle("list commentaire", barGroup);
        comnt.setUIID("SelectBar");
         RadioButton rep = RadioButton.createToggle("list reponse", barGroup);
        rep.setUIID("SelectBar");
        RadioButton siri1 = RadioButton.createToggle("add pharmacie", barGroup);
        siri1.setUIID("SelectBar");
        RadioButton partage = RadioButton.createToggle("Mes paniers", barGroup);
        partage.setUIID("SelectBar");
              RadioButton siri = RadioButton.createToggle("Mes pharmacies", barGroup);
        siri.setUIID("SelectBar");
        Label arrow = new Label(res.getImage("news-tab-down-arrow.png"), "Container");
       siri.addActionListener(e -> {
           try {
               new PharmacieFront(current).show();
           } catch (IOException ex) {
           }
       });
         siri1.addActionListener(e -> {
           try {
               new addPharmacie(current).show();
           } catch (IOException ex) {
           }
       });
         comnt.addActionListener(l->{
            new ListCommentaireForm(res).show();




});
         rep.addActionListener(l->{
            new ListReponseForm(res).show();




});
liste.addActionListener(l->{
            new ListLivraisonForm(res).show();




});
        mesListes.addActionListener((e) -> {
               InfiniteProgress ip = new InfiniteProgress();
        final Dialog ipDlg = ip.showInifiniteBlocking();
        
        //  ListReclamationForm a = new ListReclamationForm(res);
          //  a.show();
            new AjouterPanierForm(res).show();
        });

        add(LayeredLayout.encloseIn(
                GridLayout.encloseIn(3, mesListes, liste, partage,siri,siri1,comnt,rep),
                FlowLayout.encloseBottom(arrow)
        ));

        partage.setSelected(true);
        arrow.setVisible(false);
        addShowListener(e -> {
            arrow.setVisible(true);
            updateArrowPosition(partage, arrow);
        });
        bindButtonSlection(mesListes, arrow);
        bindButtonSlection(liste, arrow);
        bindButtonSlection(partage, arrow);
         bindButtonSlection(siri, arrow);
          bindButtonSlection(siri1, arrow);
            bindButtonSlection(comnt, arrow);
          bindButtonSlection(rep, arrow);
        // special case for rotation
        addOrientationListener(e -> {
            updateArrowPosition(barGroup.getRadioButton(barGroup.getSelectedIndex()), arrow);
        });
     
        ArrayList<Panier>list = ServicePanier.getInstance().getAllTasks();
        
        for (Panier  rec : list){
        String urlImage="back-logo.jpeg";
        Image placeHolder =Image.createImage(120,190);
        EncodedImage enc = EncodedImage.createFromImage(placeHolder,false);
        URLImage urlim =URLImage.createToStorage(enc, urlImage, urlImage, URLImage.RESIZE_SCALE);
        addButton(urlim,rec,res);
        
        
        ScaleImageLabel image =new ScaleImageLabel(urlim);
        Container containerImg =new Container();
        image.setBackgroundType(Style.BACKGROUND_IMAGE_SCALED_FILL);
        
        }
        
    
    }

   




    
    
    
    
    private void addTab(Tabs swipe,Label spacer, Image image, String string, String text, Resources res) {
   int   size=Math.min(Display.getInstance().getDisplayWidth(),Display.getInstance().getDisplayHeight());
if(image.getHeight()<size){
image =image.scaledHeight(size);}

if(image.getHeight()>Display.getInstance().getDisplayHeight()/2){
       image = image.scaledHeight(Display.getInstance().getDisplayHeight()/2);
       ScaleImageLabel imageScale=new ScaleImageLabel(image);
       imageScale.setUIID("Container");
       imageScale.setBackgroundType(Style.BACKGROUND_IMAGE_SCALED_FILL);
       Label overLay = new Label("","ImageOverlay");
       Container page1=
               LayeredLayout.encloseIn(
                       imageScale,
                       overLay,
                       BorderLayout.south(
                       BoxLayout.encloseY(
                               new SpanLabel(text, "LargeWhiteText"),
                    
                               spacer
                       )
                       )
               );
       swipe.addTab("",res.getImage("back-logo.jpeg"),page1);
}
}
 public void bindButtonSlection(Button btn ,Label l){
     
     btn.addActionListener(e-> {
       if(btn.isSelected())
           updateArrowPosition(btn ,l);
     
     
     
     }
     
     
     
     
     
     
     
     );



}

    private void updateArrowPosition(Button btn, Label l) {
    l.getUnselectedStyle().setMargin(LEFT,btn.getX() +btn.getWidth() /2 - l.getWidth() /2 );
    l.getParent().repaint();
    }
    /*
      private void trier() {
       

        String rechercheTexte = recherche.getText().toLowerCase().trim();
        int catId = -1;
    ArrayList<Panier>rec = ServicePanier.getInstance().getAllTasks();
        for (Panier p : rec) {
            if (p.getCode_panier().toLowerCase().trim().contains(rechercheTexte)) {
                ServicePanier.getInstance().getAllTasks();
            }
        }
    }*/
    private void addButton(Image img,Panier rec,Resources res) {
       
        
       int Height =Display.getInstance().convertToPixels(11.5f);
       int Width =Display.getInstance().convertToPixels(14f);
       
       Button image =new Button(img.fill(Width, Height));
       image.setUIID("Label");
       Container cnt=BorderLayout.west(image) ;
       
       
       //
         createLineSeparator();
           createLineSeparator();
             createLineSeparator();
        Label nomtxt= new Label("code Panier :"+rec.getCode_panier(),"NEWTopLine2");
       Label adressetxt= new Label("produits :"+rec.getProduits(),"NEWTopLine2");
      
       Label mailtxt= new Label("quantite :"+rec.getQuantite(),"NEWTopLine2");
     
    
            
            createLineSeparator();
              createLineSeparator();
          // supprm
        
        Label lSupprimer =new Label(" ");
        lSupprimer.setUIID("NewTopLine");
        Style supprimerStyle =new Style(lSupprimer.getUnselectedStyle());
        supprimerStyle.setFgColor(0xf21f1f);
        FontImage supprimerImage = FontImage.createMaterial (FontImage.MATERIAL_DELETE, supprimerStyle);
        lSupprimer.setIcon(supprimerImage);
        lSupprimer.setTextPosition(RIGHT);
        
        //click delete icon
        lSupprimer.addPointerPressedListener(l->{
        
        
        Dialog dig=new Dialog("Suppression");
        if(dig.show("Suppression","Vous voulez supprimer ce reclamation ?","Annuler","oui")){
        
        dig.dispose();
         refreshTheme();
        }
        else{
        dig.dispose();
        
        //n3aytou l supprm men service
        if(ServicePanier.getInstance().deletePanier(rec.getId()));
        new ListPanierForm(res).show();
        }
        }
        );
        //update icon
         Label lModifier =new Label(" ");
        lSupprimer.setUIID("NewTopLine");
        Style modifierStyle =new Style(lModifier.getUnselectedStyle());
        supprimerStyle.setFgColor(0xf7ad02);
                FontImage mFrontImage = FontImage.createMaterial (FontImage.MATERIAL_MODE_EDIT, modifierStyle);
                
                lModifier.setIcon(mFrontImage);
                lModifier.setTextPosition(LEFT );
                lModifier.addPointerPressedListener(l->{
                    //System.out.println("hello update");
                    
                   new ModifierPanierForm(res,rec ).show();
                
                
                
                
                
                
                });

        
         
        
        
        
        
        
       
        cnt.add(BorderLayout.CENTER,BoxLayout.encloseY(
                BoxLayout.encloseX(nomtxt),
                BoxLayout.encloseX(adressetxt)
                 
                
                
               , BoxLayout.encloseX(mailtxt,lModifier,lSupprimer)));
        
        
        
        add(cnt);
       
         }








}