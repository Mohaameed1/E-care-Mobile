/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myap.Services;


import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;

import com.codename1.ui.events.ActionListener;
import com.mycompany.myap.entities.Clinique;
import com.mycompany.myap.utils.Statics;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/**
 *
 * @author Siwar Boutaleb
 */
public class ServiceClinique {

   
    public ArrayList<Clinique> clinique;
    public static ServiceClinique instance = null;
    public static boolean resultOK =true ;
    private ConnectionRequest req;
    
    
    public static ServiceClinique getInstance(){
        if(instance==null)
            instance = new ServiceClinique();
         return instance;
        
    }
    
    
    public ServiceClinique(){
        req = new ConnectionRequest();
    }
    public void addStade(Clinique clinique){
        String url = Statics.BASE_URL+"/addcl?nomcl="+clinique.getNomcl()+"&adressecl="+clinique.getAdressecl()+"&numerocl="+clinique.getNumerocl()+"&desccl="+clinique.getDesccl();
        req.setUrl(url);
        req.addResponseListener(a->{
            String str = new String(req.getResponseData());
            System.err.println("data=="+str);
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        
    }
    public ArrayList<Clinique> parseCours(String jsonText){
        try {
            clinique=new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String,Object> tasksListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            List<Map<String,Object>> list = (List<Map<String,Object>>)tasksListJson.get("root");
            for(Map<String,Object> obj : list){
                Clinique u = new Clinique();
               u.setId((int) Float.parseFloat(obj.get("id").toString()));
                u.setNomcl(obj.get("nomcl").toString());
                u.setAdressecl(obj.get("adressecl").toString());
                u.setNumerocl((int) Double.parseDouble(obj.get("numerocl").toString()));
                
                
                u.setDesccl(obj.get("desccl").toString());
               
             
       
                clinique.add(u);
                System.out.println(obj.get("nomcl").toString());
            }
                     
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return clinique;
    }
        
        
    public ArrayList<Clinique> getAllCours(){
        ArrayList<Clinique> result =new ArrayList<>();
        
        String url = Statics.BASE_URL+"/listecliniqe";
        req.setUrl(url);
        
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                clinique = parseCours(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return clinique;
    }
    public boolean DeleteReclamation(int id )
    {
        String url = Statics.BASE_URL+"/deleteclinique?"+id;
         req.setUrl(url);
        
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                req.removeResponseCodeListener(this);
                      }
            
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
    }
    public boolean deleteStade(int id){
        String url = Statics.BASE_URL+"/deleteclinique?id="+id;
        req.setUrl(url);
         req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
               req.removeResponseCodeListener(this);
            }
        });
         NetworkManager.getInstance().addToQueueAndWait(req);
         return resultOK;
    }
    public boolean modifierClinique(Clinique clinique){
        String url = Statics.BASE_URL+"/updateclinique?id="+clinique.getId()+"&nomcl="+clinique.getNomcl()+"&adressecl="+clinique.getAdressecl()+"&numerocl="+clinique.getNumerocl()+"&desccl="+clinique.getDesccl();
        req.setUrl(url);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
              resultOK=req.getResponseCode() == 200;
              req.removeResponseListener(this);
            }
        });
         NetworkManager.getInstance().addToQueueAndWait(req);
         return resultOK;
    }

   
}
/*


*/