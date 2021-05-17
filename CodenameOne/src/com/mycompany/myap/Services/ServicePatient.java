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
import com.mycompany.myap.entities.Patient;
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
public class ServicePatient {

   
    public ArrayList<Patient> patient;
    public static ServicePatient instance = null;
    public static boolean resultOK =true ;
    private ConnectionRequest req;
    
    
    public static ServicePatient getInstance(){
        if(instance==null)
            instance = new ServicePatient();
         return instance;
        
    }
    
    
    public ServicePatient(){
        req = new ConnectionRequest();
    }
    public void addStade(Patient patient){
        String url = Statics.BASE_URL+"/addp?clinique_id="+patient.getClinique_id()+"&name="+patient.getName()+"&email="+patient.getEmail()+"&phone="+patient.getPhone()+"&adresse="+patient.getAdresse();
        String url2 = Statics.BASE_URL+"/addp?clinique_id=5&name="+patient.getName()+"&email="+patient.getEmail()+"&phone="+patient.getPhone()+"&adresse="+patient.getAdresse();
        String url1 = Statics.BASE_URL+"/addp?clinique_id=majd&email=majd&phone=444&name=majd&adresse=kef";
        req.setUrl(url);
        req.addResponseListener(a->{
            String str = new String(req.getResponseData());
            System.err.println("data=="+str);
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        
    }
    public ArrayList<Patient> parseCours(String jsonText){
        try {
            patient=new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String,Object> tasksListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            List<Map<String,Object>> list = (List<Map<String,Object>>)tasksListJson.get("root");
            for(Map<String,Object> obj : list){
                Patient u = new Patient();
               u.setId((int) Float.parseFloat(obj.get("id").toString()));
               u.setClinique_id((int) Double.parseDouble(obj.get("clinique").toString()));
                u.setName(obj.get("name").toString());
                u.setEmail(obj.get("email").toString());
                u.setPhone((int) Double.parseDouble(obj.get("phone").toString()));
                
                
                u.setAdresse(obj.get("adresse").toString());
               
             
       
                patient.add(u);
                
            }
                     
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return patient;
    }
        
        
    public ArrayList<Patient> getAllCours(){
        ArrayList<Patient> result =new ArrayList<>();
        
        String url = Statics.BASE_URL+"/listepatient";
        req.setUrl(url);
        
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                patient = parseCours(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return patient;
    }
    public boolean DeleteReclamation(int id )
    {
        String url = Statics.BASE_URL+"/deletepatient?"+id;
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
    public boolean deletepatient(int id){
        String url = Statics.BASE_URL+"/deletepatient?id="+id;
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
    public boolean modifierpatient(Patient patient){
        String url = Statics.BASE_URL+"/updatepatient?id="+patient.getId()+"&clinique_id="+patient.getClinique_id()+"&name="+patient.getName()+"&email="+patient.getEmail()+"&phone="+patient.getPhone()+"&adresse="+patient.getAdresse();
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