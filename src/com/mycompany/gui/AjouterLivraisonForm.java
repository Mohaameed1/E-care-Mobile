/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;


import com.mycompany.entities.Livraison;
import com.mycompany.services.ServiceLivraison;








import com.codename1.components.InfiniteProgress;
import com.codename1.components.ScaleImageLabel;
import com.codename1.components.SpanLabel;
import com.codename1.components.ToastBar;

import com.codename1.ui.Button;
import com.codename1.ui.ButtonGroup;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Graphics;
import com.codename1.ui.Image;
;
import com.codename1.ui.Label;
import com.codename1.ui.RadioButton;
import com.codename1.ui.Tabs;

import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.layouts.LayeredLayout;
import com.codename1.ui.plaf.Style;

import com.codename1.ui.util.Resources;
import com.mycompany.services.mailing;



/**
 *
 * @author achra
 */
public class AjouterLivraisonForm extends BaseForm{
    
      Form current;
    
    public AjouterLivraisonForm(Resources res){
      
  super("Newsfeed",BoxLayout.y());
        Toolbar tb= new Toolbar(true);
        current=this;
        setToolbar(tb);
        getTitleArea().setUIID("Container");
        setTitle("ajout commentaire");
        getContentPane().setScrollVisible(false);
        
        
      
        tb.addSearchCommand((e)-> {
        
    });
        
        Tabs swipe=new Tabs();
        Label s1 =new  Label();
         Label s2 =new  Label();
      
   addTab(swipe,s1, res.getImage("dog.jpg"),"","",res);
    
    
    

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
     //   RadioButton[] rbs = new RadioButton[swipe.getTabCount()];
        FlowLayout flow = new FlowLayout(CENTER);
        flow.setValign(BOTTOM);
        Container radioContainer = new Container(flow);
        /*
        for (int iter = 0; iter < rbs.length; iter++) {
            rbs[iter] = RadioButton.createToggle(unselectedWalkthru, bg);
            rbs[iter].setPressedIcon(selectedWalkthru);
            rbs[iter].setUIID("Label");
            radioContainer.add(rbs[iter]);
        }

      rbs[0].setSelected(true);
        swipe.addSelectionListener((i, ii) -> {
            if (!rbs[ii].isSelected()) {
                rbs[ii].setSelected(true);
            }
        });
        */
        
        Component.setSameSize(radioContainer, s1, s2);
        add(LayeredLayout.encloseIn(swipe, radioContainer));

        ButtonGroup barGroup = new ButtonGroup();
        RadioButton mesListes = RadioButton.createToggle("Mes livraison", barGroup);
        mesListes.setUIID("SelectBar");
        RadioButton liste = RadioButton.createToggle("List Panier", barGroup);
        liste.setUIID("SelectBar");
        RadioButton partage = RadioButton.createToggle("livrer", barGroup);
        partage.setUIID("SelectBar");
        Label arrow = new Label(res.getImage("news-tab-down-arrow.png"), "Container");
liste.addActionListener(l->{
            new ListPanierForm(res).show();




});

        mesListes.addActionListener((e) -> {
               InfiniteProgress ip = new InfiniteProgress();
        final Dialog ipDlg = ip.showInifiniteBlocking();
        
        //  ListReclamationForm a = new ListReclamationForm(res);
          //  a.show();
            new ListLivraisonForm(res).show();
        });

        add(LayeredLayout.encloseIn(
                GridLayout.encloseIn(3, mesListes, liste, partage),
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
        // special case for rotation
        addOrientationListener(e -> {
            updateArrowPosition(barGroup.getRadioButton(barGroup.getSelectedIndex()), arrow);
        });

       
        
        
        
        //
        TextField nom=new TextField("","entrer nom");
        nom.setUIID("TexetFieldBlack");
        addStringValue("nom",nom);
        
           TextField adresse=new TextField("","entrer adresse");
        adresse.setUIID("TexetFieldBlack");
        addStringValue("adresse",adresse);
        
        
           TextField numero=new TextField("","entrer numero");
        numero.setUIID("TexetFieldBlack");
        addStringValue("numero",numero);
        
        
           TextField mail=new TextField("","entrer mail");
        mail.setUIID("TexetFieldBlack");
        addStringValue("mail",mail);
        
        
         TextField message=new TextField("","entrer message");
        message.setUIID("TexetFieldBlack");
        addStringValue("message",message);
        
        Button btnAjouter=new Button("Ajouter");
        addStringValue("",btnAjouter);
        
        btnAjouter.addActionListener((e) ->{
            try{
                if ((nom.getText().length()==0)||(adresse.getText().length()==0)||(numero.getText().length()==0)||(mail.getText().length()==0)||(message.getText().length()==0))
                {  Dialog.show("Veillez verifier les donneesu","", "Annuler", "OK");
                
            }
                else{
                    InfiniteProgress ip =new InfiniteProgress();;
                final Dialog iDialog= ip.showInfiniteBlocking();
                Livraison r=new Livraison(String.valueOf(nom.getText())
                .toString(),
                String.valueOf(adresse.getText()).toString(),
                       String.valueOf(numero.getText()).toString(),
                               String.valueOf(mail.getText()).toString(),
                                       String.valueOf(message.getText()).toString());
                    System.out.println("data livraison=="+r);
                    ServiceLivraison.getInstance().addTask(r);
                iDialog.dispose();
                    mailing.sendEmail(mail.getText(),"Service Contact ","Panier ajoutee : ");
                ToastBar.showMessage("Votre commande est confirmer", FontImage.MATERIAL_ACCESS_TIME);
                
                new ListLivraisonForm(res).show();
                
                
                
                refreshTheme();}
        }catch(Exception ex){
        ex.printStackTrace();}
        });
        
}
private void addStringValue(String s,Component v){
add(BorderLayout.west(new Label(s,"PaddedLabel"))
        .add(BorderLayout.CENTER,v));
add(createLineSeparator(0xeeeeee));
}
private void addTab(Tabs swipe, Label spacer, Image image, String string, String text, Resources res) {
         int size = Math.min(Display.getInstance().getDisplayWidth(),Display.getInstance().getDisplayHeight());
      
        if( image.getHeight() < size)
        {
            image=image.scaledHeight(size);
        }
        if(image.getHeight() > Display.getInstance().getDisplayHeight() / 2)
        {
            image=image.scaledHeight(Display.getInstance().getDisplayHeight() / 2);
        }
    
        
         ScaleImageLabel imageScale=new  ScaleImageLabel(image);
         imageScale.setUIID("Container");
         imageScale.setBackgroundType(Style.BACKGROUND_IMAGE_SCALED_FILL);
         
         Label overLay = new Label("","ImageOverlay");
         
        Container page1; 
        page1 = LayeredLayout.encloseIn( 
                imageScale
                ,overLay
                ,BorderLayout.south
                (BoxLayout.encloseY(
                        new SpanLabel(text,"LargeWhiteText"),
                        
                        spacer
                )
                )
                
        );
                 swipe.addTab("",res.getImage("dog.jpg"),page1);

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

 

   
 

}
