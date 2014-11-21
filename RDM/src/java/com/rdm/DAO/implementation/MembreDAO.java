/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.rdm.DAO.implementation;

import com.rdm.modele.Membre;
import com.rdm.DAO.Dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Autre compte
 */
public class MembreDAO extends Dao<Membre> {
    
    public MembreDAO(Connection c) {
		super(c);
	}
    @Override
    public boolean create(Membre x) {
    String req = "INSERT INTO membre (`email` , `mdp` ) "+
				"VALUES ('"+x.getEmail()+"','"+x.getMdp()+"')";
		Statement stm = null;
		try 
		{
			stm = cnx.createStatement(); 
			int n= stm.executeUpdate(req);
			if (n>0)
			{
				stm.close();
				return true;
			}
		}
		catch (SQLException exp)
		{
		}
		finally
		{
			if (stm!=null)
			try {
				stm.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}

		return false;
    }

    @Override
    public Membre read(String x) 
	{
            try 
            {
                Statement stm = cnx.createStatement(); 
                ResultSet r = stm.executeQuery("SELECT * FROM membre WHERE email = '"+x+"'");
                if (r.next())
                {
                       Membre c = new Membre(   r.getString("email"),
						r.getString("mdp"));
                        r.close();
                        stm.close();
                        return c;
                }
            }
            catch (SQLException exp)
            {
            }
            return null;
	}

    @Override
    public boolean update(Membre x) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Membre x) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Membre> findAll() {
    List<Membre> liste = new LinkedList<Membre>();
		try 
		{
			Statement stm = cnx.createStatement(); 
			ResultSet r = stm.executeQuery("SELECT * FROM membre");
			while (r.next())
			{
				Membre c = new Membre(r.getString("email"),
						r.getString("mdp"));
				liste.add(c);
			}
			r.close();
			stm.close();
		}
		catch (SQLException exp)
		{
		}
		return liste;
		}
}
    

