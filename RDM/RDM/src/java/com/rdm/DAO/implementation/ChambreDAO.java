/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rdm.DAO.implementation;
import com.rdm.DAO.DAO;
import com.rdm.modele.Chambre;
import com.rdm.modele.Hotelier;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
/**
 *
 * @author kamizushi
 */



public class ChambreDAO extends DAO<Chambre>{


	public ChambreDAO() throws ClassNotFoundException
	{
		super();
	}
	@Override
	public boolean create(Chambre x) 
	{
                String req = "INSERT INTO `chambre`("
                        + "`datedebut`, "
                        + "`datefin`, "
                        + "`titre`, "
                        + "`description`, "
                        + "`prix`, "
                        + "`capacite`, "
                        + "`numerodechambre`, "
                        + "`image`, "
                        + "`ville`, "
                        + "`adresse`,"
                        + "`hotelierid`"
                        + ") "
                        + "VALUES ("
                        +"\""+x.getDateDebut()+"\","
                        +"\""+x.getDateFin()+"\","
                        +"\""+x.getTitre()+"\","
                        +"\""+x.getDescription()+"\","
                        +x.getPrix()+","
                        +x.getCapacite()+","
                        +"\""+x.getNumeroDeChambre()+"\","
                        +"\""+x.getImage()+"\","
                        +"\""+x.getVille()+"\","
                        +"\""+x.getAdresse()+"\","
                        +x.getHotelierId()
                        +")";
		Statement stm = null;
		try 
		{
			stm = cnx.createStatement(); 
			int n= stm.executeUpdate(req,Statement.RETURN_GENERATED_KEYS);
			if (n>0)
			{
                                x.setChambreId(n);
				stm.close();
				return true;
			}
		}
		catch (SQLException exp)
		{
                    System.out.print(exp);
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
	public Chambre read(Integer id){

		try 
		{
			Statement stm = cnx.createStatement(); 
			ResultSet r = stm.executeQuery("SELECT * FROM chambre WHERE chambreid = '"+id+"'");
			if (r.next())
			{
				Chambre c = new Chambre(
                                        r.getInt("chambreid"),
                                        r.getDate("datedebut"),
                                        r.getDate("datefin"),
                                        r.getString("titre"),
                                        r.getString("description"),
                                        r.getInt("prix"),
                                        r.getInt("capacite"),
                                        r.getString("numerodechambre"),
                                        r.getString("image"),
                                        r.getString("ville"),
                                        r.getString("adresse"),
                                        r.getInt("hotelierid")
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
	public boolean update(Chambre x) 
	{
		Statement stm = null;
		try 
		{
			String req = "UPDATE chambre +SET datedebut = \""+x.getDateDebut()+"\""+
							",datefin = \""+x.getDateFin()+"\""+
                                                        ",titre = \""+x.getTitre()+"\""+
                                                        ",description = \""+x.getDescription()+"\""+
                                                        ",prix = "+x.getPrix()+
							",capacite = "+x.getCapacite()+
                                                        ",numerodechambre = \""+x.getNumeroDeChambre()+"\""+
                                                        ",image = \""+x.getImage()+"\""+
                                                        ",ville = \""+x.getVille()+"\""+
                                                        ",adresse = \""+x.getAdresse()+"\""+
                                                        ",hotelierid = "+x.getHotelierId()+
							" WHERE chambreid = "+x.getChambreId()+"";		
                        
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
	public boolean delete(Chambre x) 
	{
                Statement stm = null;
                try 
                {
                        stm = cnx.createStatement(); 
                        int n= stm.executeUpdate("DELETE FROM chambre WHERE chambreid='"+x.getChambreId()+"'");
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
	public List<Chambre> findAll() {
            List<Chambre> liste = new LinkedList<Chambre>();
            try 
            {
                Statement stm = cnx.createStatement(); 
                ResultSet r = stm.executeQuery(
                        "select * from chambre"
                );
                while (r.next())
                {
                        liste.add(
                                    new Chambre(
                                        r.getInt("chambreid"),
                                        r.getDate("datedebut"),
                                        r.getDate("datefin"),
                                        r.getString("titre"),
                                        r.getString("description"),
                                        r.getInt("prix"),
                                        r.getInt("capacite"),
                                        r.getString("numerodechambre"),
                                        r.getString("image"),
                                        r.getString("ville"),
                                        r.getString("adresse"),
                                        r.getInt("hotelierid")
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
        
        
        

	public List<Chambre> recherche(
                Date dateDebut, // obligatoire
                Date dateFin, // obligatoire
                Integer ignoredReservationId,//peut être null. Utilisé lors de modification de reservation
                Integer prixMin, //peut être null
                Integer prixMax, //peut être null
                Integer capaciteMin, //peut être null
                Integer capaciteMax, //peut être null
                String ville, //peut être null
                Integer hotelierId//peut être null. 
        ) {
            List<Chambre> liste = new LinkedList<Chambre>();
            try 
            {
                Statement stm = cnx.createStatement(); 
                String req = "select * from chambre "
                                
                                //La chambre doit être disponible pendant toute la période demandée
                                +" where datedebut <= \""+dateDebut +"\""
                                + " AND datefin >= \""+dateFin+"\""
                                
                                //On enleve toutes les chambres ou une reservation entre
                                // en conflit avec la periode demandée
                                + " AND chambreid NOT IN ( "
                                    + " SELECT chambreid FROM reservation "
                                    //Il y a un conflit si la reservation commence au milieu de la periode
                                    + " WHERE  ("
                                            + " datedebut> \""+dateDebut+"\""
                                            + " AND datedebut< \""+dateFin+"\""
                                        //ou si elle finit au millieu
                                        + " OR  "
                                            + " datefin> \""+dateDebut+"\""
                                            + " AND datefin< \""+dateFin+"\""
                                        //ou si la periode est entierement incluse dans le temps de la reservation
                                        + " OR  "
                                            + " datedebut <= \""+dateDebut+"\""
                                            + " AND dateFin >= \""+dateFin+"\""
                                    + "  )"
                                    //on ignore une reservation si specifié
                                    +(((ignoredReservationId==null))?"":
                                            " and reservationid <> "+ignoredReservationId+" ")
                                + " )"
                                +(((prixMin==null))?"":
                                            " and prix >= "+prixMin+" ")
                                +(((prixMax==null))?"":
                                            " and prix <= "+prixMax+" ")
                                +(((capaciteMin==null))?"":
                                            " and capacite >= "+capaciteMin+" ")
                                +(((capaciteMax==null))?"":
                                            " and capacite <= "+capaciteMax+" ")
                                +(((ville==null))?"":
                                            " and upper(ville) = \""+ville.toUpperCase()+"\" ")
                                +(((hotelierId==null))?"":
                                            " and hotelierid = "+hotelierId+" ");
                ResultSet r = stm.executeQuery(req);
                while (r.next())
                {
                        liste.add(
                                new Chambre(
                                        r.getInt("chambreid"),
                                        r.getDate("datedebut"),
                                        r.getDate("datefin"),
                                        r.getString("titre"),
                                        r.getString("description"),
                                        r.getInt("prix"),
                                        r.getInt("capacite"),
                                        r.getString("numerodechambre"),
                                        r.getString("image"),
                                        r.getString("ville"),
                                        r.getString("adresse"),
                                        r.getInt("hotelierid")
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
        
	public List<Chambre> findByHotelier(Hotelier hotelier) {
            List<Chambre> liste = new LinkedList<Chambre>();
            try 
            {
                Statement stm = cnx.createStatement(); 
                ResultSet r = stm.executeQuery(
                        "select * from chambre where hotelierid = "+hotelier.getHotelierId()
                );
                
                while (r.next())
                {
                        liste.add(
                                    new Chambre(
                                        r.getInt("chambreid"),
                                        r.getDate("datedebut"),
                                        r.getDate("datefin"),
                                        r.getString("titre"),
                                        r.getString("description"),
                                        r.getInt("prix"),
                                        r.getInt("capacite"),
                                        r.getString("numerodechambre"),
                                        r.getString("image"),
                                        r.getString("ville"),
                                        r.getString("adresse"),
                                        r.getInt("hotelierid")
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
    public List<String> getListeDeVille(){
            List<String> liste = new LinkedList<String>();
            try 
            {
                Statement stm = cnx.createStatement(); 
                ResultSet r = stm.executeQuery(
                        "SELECT distinct ville FROM (\n" +
                        "    select count(ville) nombre, ville from chambre\n" +
                        ") temp\n" +
                        "order by nombre desc"
                );
                
                while (r.next())
                {
                        liste.add(r.getString("ville"));
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
