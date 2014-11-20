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


public class Exemplaire{
    private int exemplaire_id, chambre_id,
            prix,//-->prix doit-être double ici et dans la BD
            capacite,
            numero_chambre, reservation_id, adresse_id;
    
    public Exemplaire(int exemplaire_id, int chambre_id,
            int prix,//-->prix doit-être double ici et dans la BD
            int capacite,
            int numero_chambre, int reservation_id, int adresse_id){
        this.exemplaire_id = exemplaire_id;
        this.chambre_id = chambre_id;
        this.prix = prix;
        this.capacite = capacite;
        this.numero_chambre = numero_chambre;
        this.reservation_id = reservation_id;
        this.adresse_id = adresse_id;
    }
    public Exemplaire(int chambre_id,
            int prix,//-->prix doit-être double ici et dans la BD
            int capacite,
            int numero_chambre, int reservation_id, int adresse_id){
        this.chambre_id = chambre_id;
        this.prix = prix;
        this.capacite = capacite;
        this.numero_chambre = numero_chambre;
        this.reservation_id = reservation_id;
        this.adresse_id = adresse_id;
    }
    public int getExemplaire_id(){
        return exemplaire_id;
    }
    public int getChambre_id(){
        return chambre_id;
    }
    public int getPrix(){
        return prix;
    }
    public int getCapacite(){
        return capacite;
    }
    public int getNumero_chambre(){
        return numero_chambre;
    }
    public int getReservation_id(){
        return reservation_id;
    }
    public int getAdresse_id(){
        return adresse_id;
    }
        
    public void setExemplaire_id(int exemplaire_id){
        this.exemplaire_id = exemplaire_id;
    }
    public void setChambre(int chambre_id){
        this.chambre_id = chambre_id;
    }
    public void setPrix(int prix){
        this.prix = prix;
    }
    public void setCapacite(int capacite){
        this.capacite = capacite;
    }
    public void setNumero_chambre(int numero_chambre){
        this.numero_chambre = numero_chambre;
    }
    public void setReservation_id(int reservation_id){
        this.reservation_id = reservation_id;
    }
    public void setAdresse_id(int adresse_id){
        this.adresse_id = adresse_id;
    }
    
  
    
    @Override
    public String toString() {
        return "" + this.exemplaire_id + ", " + this.chambre_id + 
             ", " + this.prix + ", " + this.capacite + 
             ", " + this.numero_chambre + ", " + this.reservation_id +
             ", " + this.adresse_id;
    }
    
    
}