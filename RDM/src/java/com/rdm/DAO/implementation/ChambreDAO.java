/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rdm.DAO.implementation;

import com.rdm.modele.Chambre;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import com.rdm.DAO.Dao;

public class ChambreDAO extends Dao<Chambre> {

    public ChambreDAO(Connection c) {
        super(c);
    }

    @Override
    public boolean create(Chambre x) {
        // TODO Auto-generated method stub

        String req = "INSERT INTO chambre (`titre` , `description`, `annonce_id`) "
                + "VALUES ('" + x.getTitre() + "','" + x.getDescription() + "','" + x.getAnnonce_id() + "')";
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

    public boolean createWithoutAnnonce_id(Chambre x) {
        // TODO Auto-generated method stub

        String req = "INSERT INTO chambre (`titre` , `description`) "
                + "VALUES ('" + x.getTitre() + "','" + x.getDescription() + "')";
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
    public boolean delete(Chambre x) {
        // TODO Auto-generated method stub
        Statement stm = null;
        try {
            stm = cnx.createStatement();
            int n = stm.executeUpdate("DELETE FROM chambre WHERE chambre_id='" + x.getChambre_id() + "'");
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

    public Chambre readTitre(String titre) {
        // TODO Auto-generated method stub
        try {
            Statement stm = cnx.createStatement();
            ResultSet r = stm.executeQuery("SELECT * FROM chambre WHERE titre = '" + titre + "'");
            if (r.next()) {
                Chambre m = new Chambre(r.getInt("chambre_id"),
                        r.getString("titre"),
                        r.getString("description"),
                        r.getInt("annonce_id"));
                r.close();
                stm.close();
                return m;
            }
        } catch (SQLException exp) {
        }
        return null;
    }

    @Override
    public Chambre read(String id) {
        // TODO Auto-generated method stub
        try {
            Statement stm = cnx.createStatement();
            ResultSet r = stm.executeQuery("SELECT * FROM chambre WHERE chambre_id = '" + id + "'");
            if (r.next()) {
                Chambre m = new Chambre(r.getInt("chambre_id"),
                        r.getString("titre"),
                        r.getString("description"),
                        r.getInt("annonce_id"));
                r.close();
                stm.close();
                return m;
            }
        } catch (SQLException exp) {
        }
        return null;
    }

    public Chambre read(int id) {
        // TODO Auto-generated method stub
        try {
            Statement stm = cnx.createStatement();
            ResultSet r = stm.executeQuery("SELECT * FROM chambre WHERE chambre_id = '" + id + "'");
            if (r.next()) {
                Chambre m = new Chambre(r.getInt("chambre_id"),
                        r.getString("titre"),
                        r.getString("description"),
                        r.getInt("annonce_id"));
                r.close();
                stm.close();
                return m;
            }
        } catch (SQLException exp) {
        }
        return null;
    }

    @Override
    public boolean update(Chambre x) {
        // TODO Auto-generated method stub
        Statement stm = null;
        try {

            String req = "UPDATE chambre SET titre = '" + x.getTitre() + "', description = '" + x.getDescription() + "', annonce_id = '" + x.getAnnonce_id() + "'" + " WHERE chambre_id = '" + x.getChambre_id() + "'";

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

    //Changement juste dans le titre
    public boolean updateTitre(Chambre x) {
        // TODO Auto-generated method stub
        Statement stm = null;
        try {

            String req = "UPDATE chambre SET titre = '" + x.getTitre() + "' WHERE chambre_id = '" + x.getChambre_id() + "'";
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

    //Changement juste dans le desctiption
    public boolean updateDescription(Chambre x) {
        // TODO Auto-generated method stub
        Statement stm = null;
        try {

            String req = "UPDATE chambre SET description = '" + x.getDescription() + "' WHERE chambre_id = '" + x.getChambre_id() + "'";
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
    public List<Chambre> findAll() {
        // TODO Auto-generated method stub
        List<Chambre> liste = new LinkedList<Chambre>();
        try {
            Statement stm = cnx.createStatement();
            ResultSet r = stm.executeQuery("SELECT * FROM chambre");
            while (r.next()) {
                Chambre m = new Chambre(r.getInt("chambre_id"),
                        r.getString("titre"),
                        r.getString("description"),
                        r.getInt("annonce_id"));
                liste.add(m);
            }
            r.close();
            stm.close();
        } catch (SQLException exp) {
        }
        return liste;
    }

    public List<Chambre> findAllByAnnonce_id(int id) {
        // TODO Auto-generated method stub
        List<Chambre> liste = new LinkedList<Chambre>();
        try {
            Statement stm = cnx.createStatement();
            ResultSet r = stm.executeQuery("SELECT * FROM chambre WHERE annonce_id = '" + id + "'");
            while (r.next()) {
                Chambre m = new Chambre(r.getInt("chambre_id"),
                        r.getString("titre"),
                        r.getString("description"),
                        r.getInt("annonce_id"));
                liste.add(m);
            }
            r.close();
            stm.close();
        } catch (SQLException exp) {
        }
        return liste;
    }

}
