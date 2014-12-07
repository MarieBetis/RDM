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
public class Hotelier extends Membre{
    private String siteweb;
    private String nomEntreprise;
    //contructeur pour le DAO
    public Hotelier(Integer hotelierId, String email, String motDePasse, String siteweb, String nomEntreprise) {
        super(hotelierId,email,motDePasse,"Hotelier");
        this.siteweb = siteweb;
        this.nomEntreprise = nomEntreprise;
    }
    //constructeur inicial
    public Hotelier(String email, String motDePasse, String siteweb, String nomEntreprise) {
        super(email,motDePasse,"Hotelier");
        this.siteweb = siteweb;
        this.nomEntreprise = nomEntreprise;

    }

    public Integer getHotelierId() {
        return this.getId();
    }

    public void setHotelierId(Integer hotelierId) {
        this.setId(hotelierId);
    }

    public String getSiteweb() {
        return siteweb;
    }

    public void setSiteweb(String siteweb) {
        this.siteweb = siteweb;
    }

    public String getNomEntreprise() {
        return nomEntreprise;
    }

    public void setNomEntreprise(String nomEntreprise) {
        this.nomEntreprise = nomEntreprise;
    }
    
    @Override
    public String toString() {
        return this.nomEntreprise;
    }
}
