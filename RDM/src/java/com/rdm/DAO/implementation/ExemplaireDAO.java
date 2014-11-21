/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rdm.DAO.implementation;

import com.rdm.modele.Exemplaire;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import com.rdm.DAO.Dao;

public class ExemplaireDAO extends Dao<Exemplaire> {

    public ExemplaireDAO(Connection c) {
        super(c);
    }

    @Override
    public boolean create(Exemplaire x) {
        // TODO Auto-generated method stub
        String req = "INSERT INTO exemplaire (`chambre_id` , `prix`, `capacite`, `numero_chambre`, `reservation_id`, `adresse_id`) "
                + "VALUES ('" + x.getChambre_id() + "','" + x.getPrix() + "','" + x.getCapacite() + "','" + x.getNumero_chambre() + "','" + x.getReservation_id() + "','" + x.getAdresse_id() + "')";
        Statement stm = null;
        try {
            stm = cnx.createStatement();
            int n = stm.executeUpdate(req);
            if (n > 0) {
                stm.close();
                return true;
            }
        } catch (SQLException exp) {
        } finally {
            if (stm != null) {
                try {
                    stm.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }

        return false;
    }


    @Override
    public boolean delete(Exemplaire x) {
        // TODO Auto-generated method stub
        Statement stm = null;
        try {
            stm = cnx.createStatement();
            int n = stm.executeUpdate("DELETE FROM exemplaire WHERE exemplaire_id='" + x.getExemplaire_id() + "'");
            if (n > 0) {
                stm.close();
                return true;
            }
        } catch (SQLException exp) {
        } finally {
            if (stm != null) {
                try {
                    stm.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        return false;
    }

      @Override
    public Exemplaire read(String id) {
         // TODO Auto-generated method stub
        try {
            Statement stm = cnx.createStatement();
            ResultSet r = stm.executeQuery("SELECT * FROM exemplaire WHERE exemplaire_id = '" + id + "'");
            if (r.next()) {
             Exemplaire m = new Exemplaire(r.getInt("exemplaire_id"),
                        r.getInt("chambre_id"),
                        r.getInt("prix"),
                        r.getInt("capacite"),
                        r.getInt("numero_chambre"),
                        r.getInt("reservation_id"),
                        r.getInt("adresse_id"));
                r.close();
                stm.close();
                return m;
            }
        } catch (SQLException exp) {
        }
        return null;
    }
    public Exemplaire read(int id) {
        // TODO Auto-generated method stub
        try {
            Statement stm = cnx.createStatement();
            ResultSet r = stm.executeQuery("SELECT * FROM exemplaire WHERE exemplaire_id = '" + id + "'");
            if (r.next()) {
             Exemplaire m = new Exemplaire(r.getInt("exemplaire_id"),
                        r.getInt("chambre_id"),
                        r.getInt("prix"),
                        r.getInt("capacite"),
                        r.getInt("numero_chambre"),
                        r.getInt("reservation_id"),
                        r.getInt("adresse_id"));
                r.close();
                stm.close();
                return m;
            }
        } catch (SQLException exp) {
        }
        return null;
    }

    @Override
    public boolean update(Exemplaire x) {
        // TODO Auto-generated method stub
        Statement stm = null;
        try {
      String req = "UPDATE exemplaire SET chambre_id = '" + x.getChambre_id() + "', prix = '" + x.getPrix() + "', capacite = '" + x.getCapacite() + "', numero_chambre = '" + x.getNumero_chambre() + "', reservation_id = '" + x.getReservation_id() + "', adresse_id = '" + x.getAdresse_id() + "'  " + " WHERE exemplaire_id = '" + x.getExemplaire_id() + "'";

            stm = cnx.createStatement();
            int n = stm.executeUpdate(req);
            if (n > 0) {
                stm.close();
                return true;
            }
        } catch (SQLException exp) {
        } finally {
            if (stm != null) {
                try {
                    stm.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        return false;
    }

    //Changement juste dans le prix
    public boolean updatePrix(Exemplaire x) {
        // TODO Auto-generated method stub
        Statement stm = null;
        try {

            String req = "UPDATE exemplaire SET prix = '" + x.getPrix() + "' WHERE exemplaire_id = '" + x.getExemplaire_id() + "'";
            stm = cnx.createStatement();
            int n = stm.executeUpdate(req);
            if (n > 0) {
                stm.close();
                return true;
            }
        } catch (SQLException exp) {
        } finally {
            if (stm != null) {
                try {
                    stm.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        return false;
    }

    //Changement juste de capacité
     public boolean updateCapacite(Exemplaire x) {
        // TODO Auto-generated method stub
        Statement stm = null;
        try {

            String req = "UPDATE exemplaire SET capacite = '" + x.getCapacite() + "' WHERE exemplaire_id = '" + x.getExemplaire_id() + "'";
            stm = cnx.createStatement();
            int n = stm.executeUpdate(req);
            if (n > 0) {
                stm.close();
                return true;
            }
        } catch (SQLException exp) {
        } finally {
            if (stm != null) {
                try {
                    stm.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        return false;
    }
     
     
    @Override
    public List<Exemplaire> findAll() {
        // TODO Auto-generated method stub
        List<Exemplaire> liste = new LinkedList<Exemplaire>();
        try {
            Statement stm = cnx.createStatement();
            ResultSet r = stm.executeQuery("SELECT * FROM exemplaire");
            while (r.next()) {
                   Exemplaire m = new Exemplaire(r.getInt("exemplaire_id"),
                        r.getInt("chambre_id"),
                        r.getInt("prix"),
                        r.getInt("capacite"),
                        r.getInt("numero_chambre"),
                        r.getInt("reservation_id"),
                        r.getInt("adresse_id"));
                liste.add(m);
            }
            r.close();
            stm.close();
        } catch (SQLException exp) {
        }
        return liste;
    }

    public List<Exemplaire> findAllByPrix(int prix) { //doit être double
        // TODO Auto-generated method stub
        List<Exemplaire> liste = new LinkedList<Exemplaire>();
        try {
            Statement stm = cnx.createStatement();
            ResultSet r = stm.executeQuery("SELECT * FROM exemplaire WHERE prix = '" + prix + "'");
            while (r.next()) {
                Exemplaire m = new Exemplaire(r.getInt("exemplaire_id"),
                        r.getInt("chambre_id"),
                        r.getInt("prix"),
                        r.getInt("capacite"),
                        r.getInt("numero_chambre"),
                        r.getInt("reservation_id"),
                        r.getInt("adresse_id"));
                liste.add(m);
            }
            r.close();
            stm.close();
        } catch (SQLException exp) {
        }
        return liste;
    }
    
    public List<Exemplaire> findAllByCapacite(int capacite) { 
        // TODO Auto-generated method stub
        List<Exemplaire> liste = new LinkedList<Exemplaire>();
        try {
            Statement stm = cnx.createStatement();
            ResultSet r = stm.executeQuery("SELECT * FROM exemplaire WHERE prix = '" + capacite + "'");
            while (r.next()) {
                Exemplaire m = new Exemplaire(r.getInt("exemplaire_id"),
                        r.getInt("chambre_id"),
                        r.getInt("prix"),
                        r.getInt("capacite"),
                        r.getInt("numero_chambre"),
                        r.getInt("reservation_id"),
                        r.getInt("adresse_id"));
                liste.add(m);
            }
            r.close();
            stm.close();
        } catch (SQLException exp) {
        }
        return liste;
    }

  
    
}
