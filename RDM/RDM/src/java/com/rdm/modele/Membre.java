/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.rdm.modele;

/**
 *
 * @author usager
 */
public abstract class Membre {
    private Integer id;
    private String email;
    private String motDePasse;
    private String type;

    public Membre(Integer id, String email, String motDePasse, String type) {
        this.id = id;
        this.email = email;
        this.motDePasse = motDePasse;
        this.type = type;
    }

    public Membre(String email, String motDePasse, String type) {
        this.email = email;
        this.motDePasse = motDePasse;
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motdepasse) {
        this.motDePasse = motdepasse;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
