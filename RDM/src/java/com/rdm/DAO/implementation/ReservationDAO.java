/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rdm.DAO.implementation;

import com.rdm.modele.Reservation;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import com.rdm.DAO.Dao;

public class ReservationDAO extends Dao<Reservation> {

    public ReservationDAO(Connection c) {
        super(c);
    }

    @Override
    public boolean create(Reservation x) {
        // TODO Auto-generated method stub
        String req = "INSERT INTO reservation (`particulier_id` , `date_debut_reservation`, `date_fin_reservation`) "
                + "VALUES ('" + x.getParticulier_id() + "','" + x.getDate_debut_reservation() + "','" + x.getDate_fin_reservation() + "')";
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
    public boolean delete(Reservation x) {
        // TODO Auto-generated method stub
        Statement stm = null;
        try {
            stm = cnx.createStatement();
            int n = stm.executeUpdate("DELETE FROM reservation WHERE reservation_id = '" + x.getReservation_id() + "'");
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
    
      public boolean deleteByIdParticulier(Reservation x) {
        // TODO Auto-generated method stub
        Statement stm = null;
        try {
            stm = cnx.createStatement();
            int n = stm.executeUpdate("DELETE FROM reservation WHERE particulier_id = '" + x.getParticulier_id() + "'");
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
    
    public Reservation readParticulier_id(int particulier_id) {
        // TODO Auto-generated method stub
        try {
            Statement stm = cnx.createStatement();
            ResultSet r = stm.executeQuery("SELECT * FROM reservation WHERE particulier_id = '" + particulier_id + "'");
            if (r.next()) {
                Reservation m = new Reservation(r.getInt("reservation_id"),
                        r.getDate("date_debut_reservation"),
                        r.getDate("date_fin_reservation"),
                        r.getInt("particulier_id"));
                r.close();
                stm.close();
                return m;
            }
        } catch (SQLException exp) {
        }
        return null;
    }

    @Override
    public Reservation read(String id) {
        // TODO Auto-generated method stub
        try {
            Statement stm = cnx.createStatement();
            ResultSet r = stm.executeQuery("SELECT * FROM reservation WHERE reservation_id = '" + id + "'");
            if (r.next()) {
                Reservation m = new Reservation(r.getInt("reservation_id"),
                        r.getDate("date_debut_reservation"),
                        r.getDate("date_fin_reservation"),
                        r.getInt("particulier_id"));
                r.close();
                stm.close();
                return m;
            }
        } catch (SQLException exp) {
        }
        return null;
    }
    
      public Reservation read(int id) {
        // TODO Auto-generated method stub
        try {
            Statement stm = cnx.createStatement();
            ResultSet r = stm.executeQuery("SELECT * FROM reservation WHERE reservation_id = '" + id + "'");
            if (r.next()) {
                Reservation m = new Reservation(r.getInt("reservation_id"),
                        r.getDate("date_debut_reservation"),
                        r.getDate("date_fin_reservation"),
                        r.getInt("particulier_id"));
                r.close();
                stm.close();
                return m;
            }
        } catch (SQLException exp) {
        }
        return null;
    }
    
    @Override
    public boolean update(Reservation x) {
        // TODO Auto-generated method stub
        Statement stm = null;
        try {

            String req = "UPDATE reservation SET date_debut_reservation = '" + x.getDate_debut_reservation() + "', date_fin_reservation = '" + x.getDate_fin_reservation() + "'" + " WHERE reservation_id = '" + x.getReservation_id() + "'";

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

     public boolean updateByParticulier_id(Reservation x) {
        // TODO Auto-generated method stub
        Statement stm = null;
        try {

            String req = "UPDATE reservation SET date_debut_reservation = '" + x.getDate_debut_reservation() + "', date_fin_reservation = '" + x.getDate_fin_reservation() + "'" + " WHERE particulier_id = '" + x.getParticulier_id() + "'";

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
    public List<Reservation> findAll() {
        // TODO Auto-generated method stub
        List<Reservation> liste = new LinkedList<Reservation>();
        try {
            Statement stm = cnx.createStatement();
            ResultSet r = stm.executeQuery("SELECT * FROM reservation");
            while (r.next()) {
                Reservation m = new Reservation(r.getInt("reservation_id"),
                        r.getDate("date_debut_reservation"),
                        r.getDate("date_fin_reservation"),
                        r.getInt("particulier_id"));
                liste.add(m);
            }
            r.close();
            stm.close();
        } catch (SQLException exp) {
        }
        return liste;
    }

    public List<Reservation> findAllByParticulier_id(int id) {
        // TODO Auto-generated method stub
        List<Reservation> liste = new LinkedList<Reservation>();
        try {
            Statement stm = cnx.createStatement();
            ResultSet r = stm.executeQuery("SELECT * FROM reservation WHERE particulier_id = '" + id + "'");
            while (r.next()) {
                 Reservation m = new Reservation(r.getInt("reservation_id"),
                        r.getDate("date_debut_reservation"),
                        r.getDate("date_fin_reservation"),
                        r.getInt("particulier_id"));
                liste.add(m);
            }
            r.close();
            stm.close();
        } catch (SQLException exp) {
        }
        return liste;
    }

}
