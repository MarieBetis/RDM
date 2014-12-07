/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rdm.servlets;

import com.rdm.DAO.implementation.ChambreDAO;
import com.rdm.DAO.implementation.ReservationDAO;
import com.rdm.modele.Chambre;
import com.rdm.modele.Hotelier;
import com.rdm.util.Connexion;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author kamizushi
 */
public class SupprimerChambre extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //on verifie que l'utilisateur est connecté en temps qu'hotelier
        if(request.getSession(false).getAttribute("connecte")==null
           ||request.getSession(false).getAttribute("connecte").getClass().toString().toLowerCase().equals("hotelier")){
            request.setAttribute("message", "Vous devez être connecté en tant qu'hotelier.");
            request.getRequestDispatcher("/index.jsp").forward(request, response);return;
        } 
        Hotelier hotelier =(Hotelier)(request.getSession(false).getAttribute("connecte"));
        
        //On verifie que le parametre chambreid est présent
        String  strchambreid=request.getParameter("chambreid");
        
        if(strchambreid==null
                ||strchambreid.trim().equals("")){
            request.setAttribute("message", "Paramètre chambreid introuvable.");
            request.getRequestDispatcher("/index.jsp").forward(request, response);return;
        }
        
        //on tente de tranformer chambreid en integer
        Integer chambreId;
        try{
            chambreId=Integer.parseInt(strchambreid);
        }
        catch(IllegalArgumentException e){
            request.setAttribute("message", "Le format du paramètre chambreid est invalide.");
            request.getRequestDispatcher("/index.jsp").forward(request, response);return;
        }
        

        try{
        //On tente de trouver la chambre
        ChambreDAO chambreDAO=new ChambreDAO();
        Chambre chambre = chambreDAO.read(chambreId);
        if (chambre==null){
            request.setAttribute("message", "Chambre introuvable.");
            request.getRequestDispatcher("/index.jsp").forward(request, response);return;
        }        
        //On verifie que la chambre appartient bien à l'hotelier
        if(hotelier.getHotelierId().equals(chambre.getHotelierId())){
            request.setAttribute("message", "Vous ne pouvez supprimer la chambre d'un autre hotelier.");
            request.getRequestDispatcher("/index.jsp").forward(request, response);return;
        }
        
        
        List listDeReservation=new ReservationDAO().findByChambre(chambre);

        if(!listDeReservation.isEmpty())//et si au moins une reservation est affecté par le changement
        {
            request.setAttribute("message", "Cette chambre ne peut être supprimée car "+
                    ((listDeReservation.size()==1)?
                            "une réservation lui est rattachée.":
                            "des réservations lui sont rattachées."
                    )
            );
            request.getRequestDispatcher("/index.jsp").forward(request, response);return;
        }
        
        
        //enfin, on efface la chambre;
        if (chambreDAO.delete(chambre)){
            request.setAttribute("message", "Chambre supprimée avec succes.");
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }else{
            request.setAttribute("message", "Une erreur inconnue empèche la suppression de la chambre.");
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }
        
            }
        catch(ClassNotFoundException ex){
           request.setAttribute("message", "Impossible de se connceter à la base de données.");
            request.getRequestDispatcher("/index.jsp").forward(request, response);
       
        }
        
        
        
        
      
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
