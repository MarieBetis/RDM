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


public class Image{
    private int image_id, exemplaire_id;
    private String nom;
    public Image(int image_id, String nom, int exemplaire_id){
        this.image_id = image_id;
        this.nom = nom;
        this.exemplaire_id = exemplaire_id;
    }
    public Image(String nom, int exemplaire_id){
        this.nom = nom;
        this.exemplaire_id = exemplaire_id;
    }
    public int getImage_id(){
        return image_id;
    }
    public String getNom(){
        return nom;
    }
    public int getExemplaire_id(){
        return exemplaire_id;
    }
    public void setImage_id(int image_id){
        this.image_id = image_id;
    }
    public void setNom(String nom){
        this.nom = nom;
    }
    public void setExemplaire_id(int exemplaire_id){
         this.exemplaire_id = exemplaire_id;
    }
    
    @Override
    public String toString() {
        return "" + this.image_id + ", " + this.nom + 
             ", " + this.exemplaire_id;
    }
    
    
}