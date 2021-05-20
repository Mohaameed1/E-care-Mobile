/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.services;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkManager;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Dialog;
import com.codename1.ui.TextField;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.mycompany.gui.HomeForm;
import com.mycompany.gui.SignInForm;
import com.mycompany.utils.Statics;

import java.util.Map;
import java.util.Vector;

/**
 *
 * @author tpc
 */
public class ServiceUtilisateur {
   
    
    public static ServiceUtilisateur instance =null;
    public static boolean resultOK = true;
    public String json;
    
    private ConnectionRequest req;
    public static ServiceUtilisateur getInstance(){
        if(instance== null)
            instance = new ServiceUtilisateur();
        return instance;
    }
   
    
    public ServiceUtilisateur(){
        req = new ConnectionRequest();
    }
    
    //signup
    public void signup(TextField sexe ,TextField nom ,TextField num  ,TextField prenom ,TextField email ,TextField password ,TextField login ,TextField adresse ,TextField cin ,Resources rs){
     
        Vector<String> vectorRole;
        vectorRole = new Vector();
        vectorRole.add("user");
        
        ComboBox<String>roles = new ComboBox<>(vectorRole);
        
        String url = Statics.BASE_URL+"/api/signup?login="+login.getText()+"&email="+email.getText()+"&password="+password.getText()+"&cin="+cin.getText()+"&sexe="+sexe.getText()+"&nom="+nom.getText()+"&prenom="+prenom.getText()+"&adresse="+adresse.getText()+"&num_tel="+num.getText();
             req=new ConnectionRequest(url, false);

     req.setUrl(url);
     
        if (nom.getText().equals("")){
            Dialog.show("erreur", "veuillez remplir les champs", "ok",null);
        }
        else{
        
        req.addResponseListener ((e)-> {
            byte[]data =(byte[]) e.getMetaData();
            String responseData = new String(data);
            System.out.println("data ===>"+responseData);
            new SignInForm(rs).show();
            
        }
        );
        
        
      NetworkManager.getInstance().addToQueueAndWait(req);
        
        
    }
    }
      private Resources theme;
 public void signin(TextField login ,TextField password ){
     String url = Statics.BASE_URL+"/api/signin?login="+login.getText()+"&password="+password.getText();
     
     req=new ConnectionRequest(url, false);
     req.setUrl(url);
     req.addResponseListener((e) ->{
         JSONParser j = new JSONParser();
         
         String json = new String(req.getResponseData())+"";
         try{
             if(json.equals("failed") || (login.getText().length()==0))   {
                 Dialog.show("Echec d'authentification","Username ou mot de passe éronné","ok",null);
             }
             else {
                 System.out.println("data =="+json);
                 Map<String,Object> user = j.parseJSON(new CharArrayReader(json.toCharArray()));
               theme = UIManager.initFirstTheme("/theme");
            
             //if(user.size()>0)
                 new HomeForm(theme).show();
             
             }
             
         }catch(Exception ex){
             ex.printStackTrace();
         }
     });
     NetworkManager.getInstance().addToQueueAndWait(req);
 }   
   
public String getPasswordByEmail(String email ,Resources res ){
   
   
     String url = Statics.BASE_URL+"api/getmdpByEmail?email="+email;
     System.err.println(email);
     req=new ConnectionRequest(url, false);
     req.setUrl(url);
     req.addResponseListener((e) ->{
         JSONParser j = new JSONParser();
         
        String json = new String(req.getResponseData())+"";
    
         try{
            
             if(json.equals("user not found")){
                 Dialog.show("Echec ","email non valide","ok",null);
             }
             else {
                 System.out.println("data =="+json);
                
//                Map<String,Object> user = j.parseJSON(new CharArrayReader(json.toCharArray()));
            
             //if(user.size()>0)
                 new SignInForm(theme).show();
             }
             
             
         }catch(Exception ex){
             ex.printStackTrace();
         }
     });
   NetworkManager.getInstance().addToQueueAndWait(req);
   
     return json;
 }    
}
    
    
    
    
    
    
    

