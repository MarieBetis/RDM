/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rdm.modele;

/**
 *
 * @author kamizushi
 */
public class Particulier extends Membre{
    private String nom;
    private String prenom;
    private String titre;
    private String adresse;
    
    //constructeur du DAO
    public Particulier(int particulierId, String email, String motDePasse, String nom, String prenom, String titre, String adresse) {
        super(particulierId,email,motDePasse,"Particulier");
        this.nom = nom;
        this.prenom = prenom;
        this.titre = titre;
        this.adresse = adresse;
    }
    //constructeur initial
    public Particulier(String email, String motDePasse, String nom, String prenom, String titre, String adresse) {
        super(email,motDePasse,"Particulier");
        this.nom = nom;
        this.prenom = prenom;
        this.titre = titre;
        this.adresse = adresse;
    }

    public Integer getParticulierId() {
        return this.getId();
    }

    public void setParticulierId(Integer particulierId) {
        this.setId(particulierId);
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

 

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    @Override
    public String toString() {
        return this.titre+" "+this.nom+" "+this.prenom;
    }
    
}
