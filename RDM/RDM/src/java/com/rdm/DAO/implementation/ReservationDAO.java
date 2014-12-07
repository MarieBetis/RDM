/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rdm.DAO.implementation;
import com.rdm.DAO.DAO;
import com.rdm.modele.Chambre;
import com.rdm.modele.Particulier;
import com.rdm.modele.Reservation;
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



public class ReservationDAO extends DAO<Reservation>{
	public ReservationDAO() throws ClassNotFoundException 
	{
		super();
	}
	@Override
	public boolean create(Reservation x) 
	{
                String req = "INSERT INTO `reservation`("
                        + "`datedebut`, "
                        + "`datefin`, "
                        + "`particulierid`, "
                        + "`chambreid`"
                        + ") "
                        + "select "
                        +"\""+x.getDateDebut()+"\","
                        +"\""+x.getDateFin()+"\","
                        +x.getParticulierId()+","
                        +x.getChambreId() +" from dual "
                        
                        //On  insert pas si il y a un conflit avec une autre reservation.
                        +" where not exist("
                                    + " SELECT * FROM reservation "
                                    //Il y a un conflit si la reservation commence au milieu de la periode
                                    + " WHERE  ("
                                            + " datedebut> "+x.getDateDebut()
                                            + " AND datedebut< "+x.getDateFin()
                                        //ou si elle finit au millieu
                                        + " OR  "
                                            + " datefin> "+x.getDateDebut()
                                            + " AND datefin< "+x.getDateFin()
                                        //ou si la periode est entierement incluse dans le temps de la reservation
                                        + " OR  "
                                            + " datedebut <= "+x.getDateDebut()
                                            + " AND dateFin >= "+x.getDateFin()
                        + ")";
	Statement stm = null;
		try 
		{
			stm = cnx.createStatement(); 
			int n= stm.executeUpdate(req,Statement.RETURN_GENERATED_KEYS);
			if (n>0)
			{
                                x.setReservationId(n);
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
	public Reservation read(Integer id){

		try 
		{
			ResultSet r = cnx.createStatement().executeQuery(
                                "SELECT * FROM reservation WHERE id = '"+id+"'"
                        );
			if (r.next())
			{
				Reservation c = new Reservation(
                                        r.getInt("reservationid"),
                                        r.getDate("datedebut"),
                                        r.getDate("datefin"),
                                        r.getInt("particulierid"),
                                        r.getInt("chambreid")
                                );						
				r.close();
				return c;
			}
		}
		catch (SQLException exp)
		{
		}
		return null;
	}
	@Override
	public boolean update(Reservation x) 
	{
		Statement stm = null;
		try 
		{
			String req = "UPDATE reservation SET \n" +
                            "datedebut=\""+x.getDateDebut()+"\",\n" +
                            "datefin=\""+x.getDateFin()+"\",\n" +
                            "particulierid="+x.getParticulierId()+",\n" +
                            "chambreid="+x.getChambreId()+" \n" +
                            "WHERE reservationid = "+x.getReservationId()+"\n" +
                            //les lignes suivantes s'assurent qu'aucun conflit n'est créé avec une autre réservation
                            //Notez que MySQL ne permet pas de selectionner directement la table que l'on modifie pendant un update
                            //c'est pourquoi les selections ont un niveau de profondeur additionnel.
                            "and not exists ( select * from (select * from reservation \n" +
                            "                  where (datedebut > \""+x.getDateDebut()+"\"\n" +
                            "                  	and datefin < \""+x.getDateFin()+"\"\n" +
                            "                  or datedebut >\""+x.getDateDebut()+"1\"\n" +
                            "                  	and datefin < \""+x.getDateFin()+"\"\n" +
                            "                  or datedebut <= \""+x.getDateDebut()+"\"\n" +
                            "                  	and datefin >= \""+x.getDateFin()+"\"\n" +
                            "                  )\n" +
                            "                  and reservationid <> "+x.getReservationId()+"\n" +
                            "                  )tempreservation)";		
                        
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
	public boolean delete(Reservation x) 
	{
                Statement stm = null;
                try 
                {
                        stm = cnx.createStatement(); 
                        int n= stm.executeUpdate("DELETE FROM reservation WHERE reservationid='"+x.getReservationId()+"'");
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
	public List<Reservation> findAll() {
            List<Reservation> liste = new LinkedList<Reservation>();
            try 
            {
                Statement stm = cnx.createStatement(); 
                ResultSet r = stm.executeQuery(
                        "select * from reservation"
                );
                while (r.next())
                {
                        liste.add(
                                    new Reservation(
                                        r.getInt("reservationid"),
                                        r.getDate("datedebut"),
                                        r.getDate("datefin"),
                                        r.getInt("particulierid"),
                                        r.getInt("chambreid")
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
        
	public List<Reservation> detectConflitChangementChambre(Chambre chambre) {
            List<Reservation> liste = new LinkedList<Reservation>();
            try 
            {
                Statement stm = cnx.createStatement(); 
                ResultSet r = stm.executeQuery(
                        "select * from reservation "
                        +" where chambreid="+chambre.getChambreId()
                        +" and ("
                                +" datedebut<\""+chambre.getDateDebut()+"\""
                                +" or datefin<\""+chambre.getDateFin()+"\""
                        + ")"
                            
                );
                while (r.next())
                {
                        liste.add(
                                    new Reservation(
                                        r.getInt("reservationid"),
                                        r.getDate("datedebut"),
                                        r.getDate("datefin"),
                                        r.getInt("particulierid"),
                                        r.getInt("chambreid")
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
        
	public List<Reservation> findByChambre(Chambre chambre) {
            List<Reservation> liste = new LinkedList<Reservation>();
            try 
            {
                Statement stm = cnx.createStatement(); 
                ResultSet r = stm.executeQuery(
                        "select * from reservation "
                        +" where chambreid="+chambre.getChambreId()
                            
                );
                while (r.next())
                {
                        liste.add(
                                    new Reservation(
                                        r.getInt("reservationid"),
                                        r.getDate("datedebut"),
                                        r.getDate("datefin"),
                                        r.getInt("particulierid"),
                                        r.getInt("chambreid")
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
        
	public List<Reservation> findByParticulier(Particulier particulier) {
            List<Reservation> liste = new LinkedList<Reservation>();
            try 
            {
                Statement stm = cnx.createStatement(); 
                ResultSet r = stm.executeQuery(
                        "select * from reservation "
                        +" where particulierid="+particulier.getParticulierId()
                            
                );
                while (r.next())
                {
                        liste.add(
                                    new Reservation(
                                        r.getInt("reservationid"),
                                        r.getDate("datedebut"),
                                        r.getDate("datefin"),
                                        r.getInt("particulierid"),
                                        r.getInt("chambreid")
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
