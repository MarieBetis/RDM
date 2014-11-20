/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.rdm.modele;

import java.util.Date;

/**
 *
 * @author 
 */

public class Reservation{
    private int reservation_id, particulier_id;
    private Date date_debut_reservation, date_fin_reservation;
    public Reservation(int reservation_id, Date date_debut_reservation,
                       Date date_fin_reservation, int particulier_id){
        this.reservation_id = reservation_id;      
        this.date_debut_reservation = date_debut_reservation;
        this.date_fin_reservation = date_fin_reservation; 
        this.particulier_id = particulier_id;        
    }
    public Reservation(Date date_debut_reservation,
                       Date date_fin_reservation, int particulier_id){    
        this.date_debut_reservation = date_debut_reservation;
        this.date_fin_reservation = date_fin_reservation; 
        this.particulier_id = particulier_id;        
    }
    public int getReservation_id(){
        return reservation_id;
    }
    public Date getDate_debut_reservation(){
        return date_debut_reservation;
    }
    public Date getDate_fin_reservation(){
        return date_fin_reservation;
    }
    public int getParticulier_id(){
        return particulier_id;
    }
    
    public void setReservation_id(int reservation_id){
         this.reservation_id = reservation_id;  
    }
    public void setDate_debut_reservation(Date date_debut_reservation){
         this.date_debut_reservation = date_debut_reservation;
    }
    public void setDate_fin_reservation(Date date_fin_reservation){
         this.date_fin_reservation = date_fin_reservation;
    }
      @Override
    public String toString() {
        return "" + this.reservation_id + ", " + this.date_debut_reservation + 
             ", " + this.date_fin_reservation + ", " + this.particulier_id;
    }
    
    
}
