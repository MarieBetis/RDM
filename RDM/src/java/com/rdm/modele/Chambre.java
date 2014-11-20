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


public class Chambre{
    private int chambre_id, annonce_id;
    private String titre, description;
    public Chambre(int chambre_id, String titre, String description, 
                   int annonce_id){
        this.chambre_id = chambre_id;
        this.titre = titre;
        this.description = description;
        this.annonce_id = annonce_id;
    }
    public Chambre(String titre, String description, 
                   int annonce_id){
        this.titre = titre;
        this.description = description;
        this.annonce_id = annonce_id;
    }
    public int getChambre_id(){
        return chambre_id;
    }
    public String getTitre(){
        return titre;
    }
    public String getDescription(){
        return description;
    }
    public int getAnnonce_id(){
        return annonce_id;
    }
    public void setChambre_id_id(int chambre_id){
        this.chambre_id = chambre_id;
    }
    public void setTitre(String titre){
        this.titre = titre;
    }
    public void setMotDePasse(String description){
          this.description = description;
    }
    public void setAnnonce_id(int annonce_id){
           this.annonce_id = annonce_id;
    }
    
    @Override
    public String toString() {
        return "" + this.chambre_id + ", " + this.titre + 
             ", " + this.getDescription()+ ", " + this.annonce_id;
    }
    
    
}