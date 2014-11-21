/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.rdm.DAO.implementation;

import com.rdm.modele.Moderateur;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import com.rdm.DAO.Dao;

public class ModerateurDAO extends Dao<Moderateur> {

    public ModerateurDAO(Connection c) {
        super(c);
    }

    @Override
    public boolean create(Moderateur x) {
        // TODO Auto-generated method stub

        String req = "INSERT INTO moderateur (`login` , `motDePasse`) "
                + "VALUES ('" + x.getLogin() + "','" + x.getMotDePasse() + "')";
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
    public boolean delete(Moderateur x) {
        // TODO Auto-generated method stub
        Statement stm = null;
        try {
            stm = cnx.createStatement();
            int n = stm.executeUpdate("DELETE FROM moderateur WHERE moderateur_id='" + x.getModerateur_id()+ "'");
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

    
    public Moderateur readLogin(String login) {
        // TODO Auto-generated method stub
        try {
            Statement stm = cnx.createStatement();
            ResultSet r = stm.executeQuery("SELECT * FROM moderateur WHERE login = '" + login + "'");
            if (r.next()) {
                Moderateur m = new Moderateur(r.getInt("moderateur_id"),                       
                        r.getString("login"),
                        r.getString("motDePasse"));
                r.close();
                stm.close();
                return m;
            }
        } catch (SQLException exp) {
        }
        return null;
    }

    @Override
    public Moderateur read(String id) {
        // TODO Auto-generated method stub
        try {
            Statement stm = cnx.createStatement();
            ResultSet r = stm.executeQuery("SELECT * FROM moderateur WHERE moderateur_id = '" + id + "'");
            if (r.next()) {
                    Moderateur m = new Moderateur(r.getInt("moderateur_id"),                       
                        r.getString("login"),
                        r.getString("motDePasse"));
                r.close();
                stm.close();
                return m;
            }
        } catch (SQLException exp) {
        }
        return null;
    }
    
    public Moderateur read(int id) {
        // TODO Auto-generated method stub
        try {
            Statement stm = cnx.createStatement();
            ResultSet r = stm.executeQuery("SELECT * FROM moderateur WHERE moderateur_id = '" + id + "'");
            if (r.next()) {
                    Moderateur m = new Moderateur(r.getInt("moderateur_id"),                       
                        r.getString("login"),
                        r.getString("motDePasse"));
                r.close();
                stm.close();
                return m;
            }
        } catch (SQLException exp) {
        }
        return null;
    }
 
    @Override
    public boolean update(Moderateur x) {
        // TODO Auto-generated method stub
        Statement stm = null;
        try {
                 
          String req = "UPDATE moderateur SET login = '"+x.getLogin()+ "', motDePasse = '"+x.getMotDePasse()+"'" + " WHERE moderateur_id = '"+x.getModerateur_id() +"'"; 
          
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

    //Changement juste dans le login
      public boolean updateLogin(Moderateur x) {
        // TODO Auto-generated method stub
        Statement stm = null;
        try {
                 
            String req = "UPDATE moderateur SET login = '"+x.getLogin()+"' WHERE moderateur_id = '"+x.getModerateur_id()  +"'";
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
    
    //Changement juste dans le mot de passe
      public boolean updateMotDePasse(Moderateur x) {
        // TODO Auto-generated method stub
        Statement stm = null;
        try {
                 
            String req = "UPDATE moderateur SET motDePasse = '"+x.getMotDePasse()+"' WHERE moderateur_id = '"+x.getModerateur_id()+"'";
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
    public List<Moderateur> findAll() {
        // TODO Auto-generated method stub
        List<Moderateur> liste = new LinkedList<Moderateur>();
        try {
            Statement stm = cnx.createStatement();
            ResultSet r = stm.executeQuery("SELECT * FROM moderateur");
            while (r.next()) {
                 Moderateur m = new Moderateur(r.getInt("moderateur_id"),                       
                        r.getString("login"),
                        r.getString("motDePasse"));
                liste.add(m);
            }
            r.close();
            stm.close();
        } catch (SQLException exp) {
        }
        return liste;
    }
  
}
