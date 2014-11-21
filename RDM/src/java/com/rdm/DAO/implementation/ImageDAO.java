/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.rdm.DAO.implementation;

import com.rdm.modele.Image;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import com.rdm.DAO.Dao;

public class ImageDAO extends Dao<Image> {

    public ImageDAO(Connection c) {
        super(c);
    }

    @Override
    public boolean create(Image x) {
        // TODO Auto-generated method stub

        String req = "INSERT INTO image (`nom` , `exemplaire_id`) "
                + "VALUES ('" + x.getNom() + "','" + x.getExemplaire_id() + "')";
        Statement stm = null;
        try {
            stm = cnx.createStatement();
            int n = stm.executeUpdate(req);
            if (n > 0) {
                stm.close();
                return true;
            }
        } 
        catch (SQLException exp) {
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
    public boolean delete(Image x) {
        // TODO Auto-generated method stub
        Statement stm = null;
        try {
            stm = cnx.createStatement();
            int n = stm.executeUpdate("DELETE FROM Image WHERE image_id ='" + x.getImage_id()+ "'");
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

    
    public Image readNom(String nom) {
        // TODO Auto-generated method stub
        try {
            Statement stm = cnx.createStatement();
            ResultSet r = stm.executeQuery("SELECT * FROM image WHERE nom = '" + nom + "'");
            if (r.next()) {
                Image m = new Image(r.getInt("image_id"),                       
                        r.getString("nom"),
                        r.getInt("exemplaire_id"));
                r.close();
                stm.close();
                return m;
            }
        } catch (SQLException exp) {
        }
        return null;
    }

    @Override
    public Image read(String id) {
        // TODO Auto-generated method stub
        try {
            Statement stm = cnx.createStatement();
            ResultSet r = stm.executeQuery("SELECT * FROM image WHERE image_id = '" + id + "'");
            if (r.next()) {
                   Image m = new Image(r.getInt("image_id"),                       
                        r.getString("nom"),
                        r.getInt("exemplaire_id"));
                r.close();
                stm.close();
                return m;
            }
        } catch (SQLException exp) {
        }
        return null;
    }
    
    public Image read(int id) {
        // TODO Auto-generated method stub
        try {
            Statement stm = cnx.createStatement();
            ResultSet r = stm.executeQuery("SELECT * FROM image WHERE image_id = '" + id + "'");
            if (r.next()) {
                    Image m = new Image(r.getInt("image_id"),                       
                        r.getString("nom"),
                        r.getInt("exemplaire_id"));
                r.close();
                stm.close();
                return m;
            }
        } catch (SQLException exp) {
        }
        return null;
    }
 
    @Override
    public boolean update(Image x) {
        // TODO Auto-generated method stub
        Statement stm = null;
        try {
                 
          String req = "UPDATE image SET nom = '"+x.getNom()+ "', exemplaire_id = '"+x.getExemplaire_id()+"'" + " WHERE image_id = '"+x.getImage_id() +"'"; 
          
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

    //Changement juste dans le nom
      public boolean updateNom(Image x) {
        // TODO Auto-generated method stub
        Statement stm = null;
        try {
                 
            String req = "UPDATE Image SET nom = '"+x.getNom()+"' WHERE image_id = '"+x.getImage_id()+"'";
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
    
    //Changement juste dans exemplaire_id
      public boolean updateExemplaire_id(Image x) {
        // TODO Auto-generated method stub
        Statement stm = null;
        try {
                 
            String req = "UPDATE image SET exemplaire_id = '"+x.getExemplaire_id()+"' WHERE image_id = '"+x.getImage_id()+"'";
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
    public List<Image> findAll() {
        // TODO Auto-generated method stub
        List<Image> liste = new LinkedList<Image>();
        try {
            Statement stm = cnx.createStatement();
            ResultSet r = stm.executeQuery("SELECT * FROM image");
            while (r.next()) {
                 Image m = new Image(r.getInt("image_id"),                       
                        r.getString("nom"),
                        r.getInt("exemplaire_id"));
                liste.add(m);
            }
            r.close();
            stm.close();
        } catch (SQLException exp) {
        }
        return liste;
    }
  
    
     public List<Image> findAllByExemplaire_id(int exemplaire_id) {
        // TODO Auto-generated method stub
        List<Image> liste = new LinkedList<Image>();
        try {
            Statement stm = cnx.createStatement();
            ResultSet r = stm.executeQuery("SELECT * FROM image WHERE exemplaire_id = '" + exemplaire_id + "'");
            while (r.next()) {
                 Image m = new Image(r.getInt("image_id"),                       
                        r.getString("nom"),
                        r.getInt("exemplaire_id"));
                liste.add(m);
            }
            r.close();
            stm.close();
        } catch (SQLException exp) {
        }
        return liste;
    }
}
