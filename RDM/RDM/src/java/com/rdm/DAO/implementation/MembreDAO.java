/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rdm.DAO.implementation;

import com.rdm.DAO.DAO;
import com.rdm.modele.Membre;
import java.sql.Connection;

/**
 *
 * @author kamizushi
 * @param <Membre>
 */
public abstract class MembreDAO<Membre> extends DAO<Membre>{

    public MembreDAO() throws ClassNotFoundException {
        super();
    }
    public abstract Membre read(String email);
    public abstract Membre connecter(String email, String motDePasse);
}
