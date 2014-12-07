/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rdm.DAO.implementation;
import com.rdm.modele.Hotelier;
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



public class HotelierDAO extends MembreDAO<Hotelier>{

	public HotelierDAO() throws ClassNotFoundException 
	{
		super();
	}
        
	@Override
	public boolean create(Hotelier x) 
	{
          
                String req = "INSERT INTO hotelier ( email, motdepasse, siteweb, nomentreprise)\n" 
                    +"select \""+x.getEmail()+"\", \""+x.getMotDePasse()+"\", \""+x.getSiteweb()+"\", \""+x.getNomEntreprise()+"\" from dual\n" 
                    +"where not exists (select * from particulier where email = \""+x.getEmail()+"\")\n" 
                    +"and not exists (select * from hotelier where email = \""+x.getEmail()+"\")";
		Statement stm = null;
		try 
		{
			stm = cnx.createStatement(); 
			int n= stm.executeUpdate(req,Statement.RETURN_GENERATED_KEYS);
			if (n>0)
			{
                                x.setHotelierId(n);
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
	public Hotelier read(Integer id){

		try 
		{
			Statement stm = cnx.createStatement(); 
			ResultSet r = stm.executeQuery("SELECT * FROM hotelier WHERE id = '"+id+"'");
			if (r.next())
			{
				Hotelier c = new Hotelier(
                                        r.getInt("hotelierid"),
                                        r.getString("email"),
                                        r.getString("motdepasse"),
                                        r.getString("siteweb"),
                                        r.getString("nomentreprise")
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
	public Hotelier read(String email){

		try
		{
                    
			Statement stm = cnx.createStatement(); 
                        ResultSet r = stm.executeQuery(
                                "SELECT * FROM hotelier "
                                +" where upper(email) = \""+email.toUpperCase()+"\" "
                        );
			if (r.next())
			{
				Hotelier c = new Hotelier(
                                        r.getInt("hotelierid"),
                                        r.getString("email"),
                                        r.getString("motdepasse"),
                                        r.getString("siteweb"),
                                        r.getString("nomentreprise")
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
	public Hotelier connecter(String email, String motDePasse){

		try
		{
                    
			Statement stm = cnx.createStatement(); 
                        String s="SELECT * FROM hotelier "
                                +" where upper(email) = \""+email.toUpperCase()+"\" "
                                +" and motdepasse = \""+motDePasse+"\" ";
                        ResultSet r = stm.executeQuery(s);
			if (r.next())
			{
				Hotelier c = new Hotelier(
                                        r.getInt("hotelierid"),
                                        r.getString("email"),
                                        r.getString("motdepasse"),
                                        r.getString("siteweb"),
                                        r.getString("nomentreprise")
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
	public boolean update(Hotelier x) 
	{
		Statement stm = null;
		try 
		{
                        String req = "UPDATE hotelier SET \n" +
                            "email=\""+x.getEmail()+"\",\n" +
                            "motdepasse=\""+x.getMotDePasse()+"\",\n" +
                            "siteweb=\""+x.getSiteweb()+"\",\n" +
                            "nomentreprise=\""+x.getNomEntreprise()+"\"\n" +
                            "WHERE hotelierid="+x.getHotelierId()+"\n" +
                            //Les  conditions suivantes empechent la requète de donner un email qui serait déjà utilisé par un autre membre (hotelier ou particulier)
                            //Notez que MySQL ne permet pas de selectionner directement la table que l'on modifie pendant un update
                            //c'est pourquoi les selections ont un niveau de profondeur additionnel.
                            "and not exists ( select * from (select * from hotelier \n" +
                            "                                where email = \""+x.getEmail()+"\"\n" +
                            "                                and hotelierid<>"+x.getHotelierId()+"\n" +
                            "                               )temphotelier)\n" +
                            "and not exists ( select * from (select * from particulier \n" +
                            "                                where email = \""+x.getEmail()+"\"\n" +
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
	public boolean delete(Hotelier x) 
	{Statement stm = null;
	try 
	{
		stm = cnx.createStatement(); 
		int n= stm.executeUpdate("DELETE FROM hotelier WHERE id='"+x.getHotelierId()+"'");
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
	public List<Hotelier> findAll() {
            List<Hotelier> liste = new LinkedList<Hotelier>();
            try 
            {
                Statement stm = cnx.createStatement(); 
                ResultSet r = stm.executeQuery(
                        "select * from hotelier"
                );
                while (r.next())
                {
                        liste.add(
                                    new Hotelier(
                                        r.getInt("hotelierid"),
                                        r.getString("email"),
                                        r.getString("motdepasse"),
                                        r.getString("siteweb"),
                                        r.getString("nomentreprise")
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
