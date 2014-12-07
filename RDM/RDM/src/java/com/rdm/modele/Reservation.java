/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rdm.modele;

import java.sql.Date;

/**
 *
 * @author kamizushi
 */
public class Reservation {
    private Integer reservationId;
    private Date dateDebut;
    private Date dateFin;
    private Integer particulierId;
    private Integer chambreId;
    //constructeur du DAO
    public Reservation(Integer reservationId, Date dateDebut, Date dateFin, Integer particulierId, Integer chambreId) {
        this.reservationId = reservationId;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.particulierId = particulierId;
        this.chambreId = chambreId;
    }
    //constructeur inicial
    public Reservation(Date dateDebut, Date dateFin, Integer particulierId, Integer chambreId) {
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.particulierId = particulierId;
        this.chambreId = chambreId;
    }



    public Integer getReservationId() {
        return reservationId;
    }

    public void setReservationId(Integer reservationId) {
        this.reservationId = reservationId;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public Integer getParticulierId() {
        return particulierId;
    }

    public void setParticulierId(Integer particulierId) {
        this.particulierId = particulierId;
    }

    public Integer getChambreId() {
        return chambreId;
    }

    public void setChambreId(Integer chambreId) {
        this.chambreId = chambreId;
    }
    
    
}
