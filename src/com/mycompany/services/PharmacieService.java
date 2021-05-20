/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.services;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Dialog;
import com.codename1.ui.events.ActionListener;
import com.mycompany.entities.AvisClient;
import com.mycompany.entities.Pharmacie;
import com.mycompany.utils.Statics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Rzouga
 */
public class PharmacieService {
    
       public ArrayList<Pharmacie> pharmacies;
    
    public static PharmacieService instance=null;
    public boolean resultOK;
    private ConnectionRequest req;

    public PharmacieService() {
         req = new ConnectionRequest();
    }

    public static PharmacieService getInstance() {
        if (instance == null) {
            instance = new PharmacieService();
        }
        return instance;
    }

    
    
            public ArrayList<Pharmacie> parseFeature(String jsonText){
        try {
           // tasks=new ArrayList<>();
            pharmacies=new ArrayList<>();
            
            JSONParser j = new JSONParser();
            Map<String,Object> tasksListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            
            List<Map<String,Object>> list = (List<Map<String,Object>>)tasksListJson.get("root");
            System.out.println("gahahahahhahaahhah"+list);
            for(Map<String,Object> obj : list){
              //  Task t = new Task();
                 Pharmacie f = new Pharmacie();
                
                float id = Float.parseFloat(obj.get("id").toString());
                f.setId((int)id);
                //pb.(((int)Float.parseFloat(obj.get("status").toString())));
               // t.setNom_theme(jsonText); e(obj.get("nom_theme").toString());
                
                float numtel = Float.parseFloat(obj.get("telephone").toString());
                f.setNumtel((int)numtel);
                
                
             
                f.setNom(obj.get("nom").toString());              
                f.setAdresse(obj.get("adresse").toString());

                pharmacies.add(f);
            }
            
            
        } catch (IOException ex) {
            
        }
        return pharmacies;
    }
    
    
   public ArrayList<Pharmacie> getAllPharmacie  (){
     //   String url = Statics.BASE_URL+"/tasks/";
        String url = Statics.BASE_URL +"/AfficheAllpharmacie" ;
        
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                pharmacies = parseFeature(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return pharmacies;

    
    
}
   
   
   
          public boolean addPharmacie(Pharmacie p) {
     
        String url = Statics.BASE_URL + "/newPharmacies?nom=" + p.getNom()+ "&adresse=" + p.getAdresse()+ "&telephone=" + p.getNumtel();
        req.setUrl(url);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200; // Code HTTP 200 OK
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);

        return resultOK;
    }
          
          
  public boolean DeletePharmacie(int id) {
     
        String url = Statics.BASE_URL + "/deletePharmacies/"+id;

        req.setUrl(url);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200; // Code HTTP 200 OK
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);

        return resultOK;
    }
  
  
         public boolean ModifierPharmacie(Pharmacie p) {
     
        String url = Statics.BASE_URL + "/updatePharmacie?nom=" + p.getNom()+ "&adresse=" + p.getAdresse()+ "&telephone=" + p.getNumtel()+"&id="+p.getId();
       
        
        req.setUrl(url);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200; // Code HTTP 200 OK
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);

        return resultOK;
    }
    
    
         public void addRate(int event , int Note, AvisClient a){
        
        String url = Statics.BASE_URL +"/giveAvis/"+event+"?description="+ a.getNote()+"&rate=" +Note;
        ConnectionRequest con = new ConnectionRequest();
        
    
    
     con.setUrl(url);
     con.addRequestHeader("X-Requested-With", "XMLHttpRequest");
     
     //con.addArgument("rate", Note+"");
//     con.addArgument("user", MyApplication.iduser+"");
     
     con.setPost(true);
     System.out.println(url);
     con.addResponseListener(new ActionListener<NetworkEvent>() {

                    @Override
                    public void actionPerformed(NetworkEvent evt) {
                        
                        byte[] data = (byte[]) evt.getMetaData();
                        String s = new String(data);
                        System.out.println(s);
                        if (s.equals("Done")) {
                            Dialog.show("Confirmation", "success", "Ok", null);
                        } else {
                            Dialog.show("Erreur", "Vous avez déja ajouté votre avis", "Ok", null);
                        }
                    }
                });
      
        NetworkManager.getInstance().addToQueueAndWait(con);
    }
         
         
         
}
