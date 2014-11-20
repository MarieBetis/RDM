/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rdm.modele;



/**
 *
 * @author 
 */


public class Moderateur{
    private int moderateur_id;
    private String login, motDePasse;
    public Moderateur(int moderateur_id, String login, String motDePasse){
        this.moderateur_id = moderateur_id;
        this.login = login;
        this.motDePasse = motDePasse;
    }
    public Moderateur(String login, String motDePasse){
        this.login = login;
        this.motDePasse = motDePasse;
    }
    public int getModerateur_id(){
        return moderateur_id;
    }
    public String getLogin(){
        return login;
    }
    public String motDePasse(){
        return motDePasse;
    }
    public void setModerateur_id(int moderateur_id){
        this.moderateur_id = moderateur_id;
    }
    public void setLogin(String login){
        this.login = login;
    }
    public void setMotDePasse(String motDePasse){
         this.motDePasse = motDePasse;
    }
    
    @Override
    public String toString() {
        return "" + this.moderateur_id + ", " + this.login + 
             ", " + this.motDePasse;
    }
    
    
}