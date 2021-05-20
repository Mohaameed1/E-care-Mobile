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
import com.codename1.ui.events.ActionListener;
import com.mycompany.entities.Medecin;
import com.mycompany.utils.Statics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static jdk.nashorn.internal.objects.NativeArray.map;
/**
 *
 * @author alaaa
 */
public class MedecinService {
    public static MedecinService instance = null;
    
        public boolean resultOK;

    private ConnectionRequest req;
    
    public static MedecinService getInstance() {
        if (instance == null )
            instance = new MedecinService();
    return instance;
    } 
    
    
    
    
    public MedecinService() {
        req = new ConnectionRequest();
      
    }
    
    public void ajoutMed (Medecin med){
        String url= Statics.BASE_URL+"/medecin/addMedecinJSON/new?nom="+med.getNom()+"&prenom="+med.getPrenom()+"&specialite="+med.getSpecialite()+"&adresse="+med.getAdresse()+"&sexe="+med.getSexe()+"&num="+med.getNum_tel()+"&cin="+med.getCin();
        req.setUrl(url);
        req.addResponseListener((e) -> { 
                String str = new String(req.getResponseData());
        System.out.println("data == "+str );
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        
   
}
    
    public ArrayList<Medecin>affichageMedecin()
    { ArrayList<Medecin> result = new ArrayList <> ();
    String url = Statics.BASE_URL+"/medecin/medecin/All";
    req.setUrl(url);
    req.addResponseListener(new ActionListener<NetworkEvent>() {
    @Override
    public void actionPerformed(NetworkEvent evt) {
JSONParser jsonp;
jsonp= new JSONParser();
try {
Map<String,Object>mapMedecin = jsonp.parseJSON(new CharArrayReader(new String(req.getResponseData()).toCharArray()));
List<Map<String,Object>> listOfMaps=(List<Map<String,Object>>) mapMedecin.get("root");

for (Map<String,Object> obj: listOfMaps) {
    Medecin med= new Medecin();
     float id =Float.parseFloat(obj.get("id").toString());
                med.setId((int)id);
    String nom = obj.get("nom").toString();
        String prenom = obj.get("prenom").toString();
            String specialite = obj.get("specialite").toString();
                String adresse = obj.get("adresse").toString();
                    String sexe = obj.get("sexe").toString();
                                
                                med.setNom(nom);
                                med.setPrenom(prenom);
                                med.setSpecialite(specialite);
                                med.setAdresse(adresse);
                                med.setSexe(sexe);
result.add(med);
}
}catch (Exception ex) {
   ex.printStackTrace();
}
    }
    });
    NetworkManager.getInstance().addToQueueAndWait(req);
    return result;
  }

public Medecin detailMedecin(int id, Medecin medecin) {
    String url=Statics.BASE_URL+"/medecin/medecin/All/?"+id;
    req.setUrl(url);
    String str=new String(req.getResponseData());
    req.addResponseListener(((evt) -> {
      JSONParser jsonp;
jsonp= new JSONParser();
try {
    Map<String,Object>obj = jsonp.parseJSON(new CharArrayReader(new String(req.getResponseData()).toCharArray()));
    medecin.setNom(obj.get("nom").toString());
    medecin.setPrenom(obj.get("prenom").toString());
    medecin.setSpecialite(obj.get("specialite").toString());
    medecin.setAdresse(obj.get("adresse").toString());
    medecin.setSexe(obj.get("sexe").toString());
    medecin.setNum_tel(obj.get("num_tel").toString());
    medecin.setCin(obj.get("cin").toString());
    medecin.setPassword(obj.get("password").toString());

    
} catch (IOException ex ){
    System.out.print("error sql" + ex.getMessage());
}
System.out.println("data =="+str);
    }));
        NetworkManager.getInstance().addToQueueAndWait(req);
return medecin;
    
}
public boolean deleteMed(int id){
   String url = Statics.BASE_URL + "/medecin/deleteMedecinJSON/"+id ; 
       req.setPost(false); // Insertion de l'URL de notre demande de connexion

         req.setUrl(url);
     req.addResponseListener(new ActionListener<NetworkEvent>() {
       @Override
       public void actionPerformed(NetworkEvent evt) {
      req.removeResponseListener(this);
       }
   });
       NetworkManager.getInstance().addToQueueAndWait(req);
       return resultOK;
        
        
        
}

 public boolean updateMed(Medecin t) {
      String url = Statics.BASE_URL + "/medecin/updateMedecinJSON/"+t.getId()+"?&nom="+ t.getNom()+ "&prenom=" + t.getPrenom()+ "&special="+t.getSpecialite() + "&adresse=" + t.getAdresse()+ "&sexe=" + t.getSexe()+ "&num="+t.getNum_tel()+"&cin="+t.getCin();
        //création de l'URL
        req.setUrl(url);
    req.setPost(false); // Insertion de l'URL de notre demande de connexion
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200; //Code HTTP 200 OK
                req.removeResponseListener(this); //Supprimer cet actionListener
                /* une fois que nous avons terminé de l'utiliser.
                La ConnectionRequest req est unique pour tous les appels de 
                n'importe quelle méthode du Service task, donc si on ne supprime
                pas l'ActionListener il sera enregistré et donc éxécuté même si 
                la réponse reçue correspond à une autre URL(get par exemple)*/
                
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
    }
}



