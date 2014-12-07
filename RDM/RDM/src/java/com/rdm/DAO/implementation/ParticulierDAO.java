/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rdm.DAO.implementation;
import com.rdm.modele.Particulier;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
/**
 *
 * @author kamizushi
 */



public class ParticulierDAO extends MembreDAO<Particulier>{

	public ParticulierDAO() throws ClassNotFoundException 
	{
		super();
	}
        
	@Override
	public boolean create(Particulier x) 
	{
          
                String req = "INSERT INTO particulier ( email, motdepasse, nom, prenom, titre, adresse)\n" 
                        +"select \""+x.getEmail()+"\", \""+x.getMotDePasse()+"\", \""+x.getNom()+"\", \""+x.getPrenom()+"\", \""+x.getTitre()+"\", \""+x.getAdresse()+"\" from dual\n" 
                        +"where not exists (select * from particulier where email = \""+x.getEmail()+"\")"
                        +"and not exists (select * from hotelier where email = \""+x.getEmail()+"\")";
		Statement stm = null;
		try 
		{
			stm = cnx.createStatement(); 
			int n= stm.executeUpdate(req,Statement.RETURN_GENERATED_KEYS);
			if (n>0)
			{
                                x.setParticulierId(n);
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
				e.printStackTrace();
			}			
		}

		return false;
	}

        @Override
	public Particulier read(Integer id){

		try 
		{
			Statement stm = cnx.createStatement(); 
			ResultSet r = stm.executeQuery("SELECT * FROM particulier WHERE id = '"+id+"'");
			if (r.next())
			{
				Particulier c = new Particulier(
                                        r.getInt("particulierid"),
                                        r.getString("email"),
                                        r.getString("motdepasse"),
                                        r.getString("nom"),
                                        r.getString("prenom"),
                                        r.getString("titre"),
                                        r.getString("adresse")
                                );						
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
	public Particulier read(String email){

		try
		{
                    
			Statement stm = cnx.createStatement(); 
                        ResultSet r = stm.executeQuery(
                                "SELECT * FROM particulier "
                                +" where upper(email) = \""+email.toUpperCase()+"\" "
                        );
			if (r.next())
			{
				Particulier c = new Particulier(
                                        r.getInt("particulierid"),
                                        r.getString("email"),
                                        r.getString("motdepasse"),
                                        r.getString("nom"),
                                        r.getString("prenom"),
                                        r.getString("titre"),
                                        r.getString("adresse")
                                );						
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
	public Particulier connecter(String email, String motDePasse){

		try
		{
                    
			Statement stm = cnx.createStatement(); 
                        String s="SELECT * FROM particulier "
                                +" where upper(email) = \""+email.toUpperCase()+"\" "
                                +" and motdepasse = \""+motDePasse+"\" ";
                        ResultSet r = stm.executeQuery(s);
			if (r.next())
			{
				Particulier c = new Particulier(
                                        r.getInt("particulierid"),
                                        r.getString("email"),
                                        r.getString("motdepasse"),
                                        r.getString("nom"),
                                        r.getString("prenom"),
                                        r.getString("titre"),
                                        r.getString("adresse")
                                );						
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
	public boolean update(Particulier x) 
	{
		Statement stm = null;
		try 
		{
			String req = "UPDATE particulier SET \n" +
                            "email=\""+x.getEmail()+"\",\n" +
                            "motdepasse=\""+x.getMotDePasse()+"\",\n" +
                            "nom=\""+x.getNom()+"\",\n" +
                            "prenom=\""+x.getPrenom()+"\",\n" +
                            "titre=\""+x.getTitre()+"\",\n" +
                            "adresse=\""+x.getAdresse()+"\"\n" +
                            "WHERE particulierid="+x.getParticulierId()+"\n" +
                            //Les  conditions suivantes empechent la requète de donner un email qui serait déjà utilisé par un autre membre (hotelier ou particulier)
                            //Notez que MySQL ne permet pas de selectionner directement la table que l'on modifie pendant un update
                            //c'est pourquoi les selections ont un niveau de profondeur additionnel.
                            "and not exists ( select * from (select * from hotelier \n" +
                            "                                where email = \""+x.getEmail()+"\"\n" +
                            "                               )temphotelier)\n" +
                            "and not exists ( select * from (select * from particulier \n" +
                            "                                where email = \""+x.getEmail()+"\"\n" +
                            "                                and particulierid<>"+x.getParticulierId()+"\n" +
                            "                               )tempparticulier)";
			if (cnx.createStatement().executeUpdate(req)>0)
			{
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
	public boolean delete(Particulier x) 
	{Statement stm = null;
	try 
	{
		stm = cnx.createStatement(); 
		int n= stm.executeUpdate("DELETE FROM particulier WHERE id='"+x.getParticulierId()+"'");
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
		} catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			
	}
	return false;
	}

    @Override
	public List<Particulier> findAll() {
            List<Particulier> liste = new LinkedList<Particulier>();
            try 
            {
                Statement stm = cnx.createStatement(); 
                ResultSet r = stm.executeQuery(
                        "select * from particulier"
                );
                while (r.next())
                {
                        liste.add(
                                    new Particulier(
                                        r.getInt("particulierid"),
                                        r.getString("email"),
                                        r.getString("motdepasse"),
                                        r.getString("nom"),
                                        r.getString("prenom"),
                                        r.getString("titre"),
                                        r.getString("adresse")
                                )
                        );
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
