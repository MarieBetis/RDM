/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rdm.servlets;

import com.rdm.DAO.implementation.ReservationDAO;
import com.rdm.modele.Particulier;
import com.rdm.modele.Reservation;
import com.rdm.util.Connexion;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author kamizushi
 */
@WebServlet(name = "SupprimerReservation", urlPatterns = {"/SupprimerReservation"})
public class SupprimerReservation extends HttpServlet {

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
        
        //on verifie que l'utilisateur est connecté en temps que particulier
        if(request.getSession(false).getAttribute("connecte")==null
           ||request.getSession(false).getAttribute("connecte").getClass().toString().toLowerCase().equals("particulier")){
            request.setAttribute("message", "Vous devez être connecté en tant que particulier.");
            request.getRequestDispatcher("/index.jsp").forward(request, response);return;
        } 
        Particulier particulier =(Particulier)(request.getSession(false).getAttribute("connecte"));
        
        //On verifie que le parametre reservationid est présent
        String  strreservationid=request.getParameter("reservationid"),
                force=request.getParameter("force");
        
        if(strreservationid==null
                ||strreservationid.trim().equals("")){
            request.setAttribute("message", "Paramètre reservationid introuvable.");
            request.getRequestDispatcher("/index.jsp").forward(request, response);return;
        }
        
        //on tente de tranformer reservationid en integer
        Integer reservationId;
        try{
            reservationId=Integer.parseInt(strreservationid);
        }
        catch(IllegalArgumentException e){
            request.setAttribute("message", "Le format du paramètre reservationid est invalide.");
            request.getRequestDispatcher("/index.jsp").forward(request, response);return;
        }
        
        try{
        //On tente de trouver la reservation
        ReservationDAO reservationDAO=new ReservationDAO();
        Reservation reservation = reservationDAO.read(reservationId);
        if (reservation==null){
            request.setAttribute("message", "Reservation introuvable.");
            request.getRequestDispatcher("/index.jsp").forward(request, response);return;
        }
        
        //On verifie que la reservation appartient bien au particulier.
        if(particulier.getParticulierId().equals(reservation.getParticulierId())){
            request.setAttribute("message", "Vous ne pouvez supprimer la reservation d'un autre particulier.");
            request.getRequestDispatcher("/index.jsp").forward(request, response);return;
        }
        
        
        //enfin, on efface la reservation;
        if (reservationDAO.delete(reservation)){
            request.setAttribute("message", "Reservation supprimée avec succes.");
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }else{
            request.setAttribute("message", "Une erreur inconnue empèche la suppression de la reservation.");
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
