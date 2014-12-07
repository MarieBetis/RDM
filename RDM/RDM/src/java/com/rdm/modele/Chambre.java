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
public class Chambre {
 
    
    private Integer chambreId;
    private Date dateDebut;
    private Date dateFin;
    private String titre;
    private String description;
    private Integer prix;//prix en $
    private Integer capacite;
    private String numeroDeChambre;
    private String image;
    private String ville;
    private String adresse;
    private Integer hotelierId;

    //contructeur de la DAO
    public Chambre(Integer chambreId, Date dateDebut, Date datefin, String titre, String description, Integer prix, Integer capacite, String numeroDeChambre, String image, String ville, String adresse, Integer hotelierId) {
        this.chambreId = chambreId;
        this.dateDebut = dateDebut;
        this.dateFin = datefin;
        this.titre = titre;
        this.description = description;
        this.prix = prix;
        this.capacite = capacite;
        this.numeroDeChambre = numeroDeChambre;
        this.image = image;
        this.ville = ville;
        this.adresse = adresse;
        this.hotelierId = hotelierId;
    }



    //Constructeur initial
    public Chambre(Date dateDebut, Date datefin, String titre, String description, Integer prix, Integer capacite, String numeroDeChambre, String image, String ville, String adresse, Integer hotelierId) {
        this.dateDebut = dateDebut;
        this.dateFin = datefin;
        this.titre = titre;
        this.description = description;
        this.prix = prix;
        this.capacite = capacite;
        this.numeroDeChambre = numeroDeChambre;
        this.image = image;
        this.ville = ville;
        this.adresse = adresse;
        this.hotelierId = hotelierId;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public Integer getHotelierId() {
        return hotelierId;
    }

    public void setHotelierId(Integer hotelierId) {
        this.hotelierId = hotelierId;
    }

    public Integer getChambreId() {
        return chambreId;
    }

    public void setChambreId(Integer chambreId) {
        this.chambreId = chambreId;
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

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPrix() {
        return prix;
    }

    public void setPrix(Integer prix) {
        this.prix = prix;
    }

    public Integer getCapacite() {
        return capacite;
    }

    public void setCapacite(Integer capacite) {
        this.capacite = capacite;
    }

    public String getNumeroDeChambre() {
        return numeroDeChambre;
    }

    public void setNumeroDeChambre(String numeroDeChambre) {
        this.numeroDeChambre = numeroDeChambre;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
    
    
}
