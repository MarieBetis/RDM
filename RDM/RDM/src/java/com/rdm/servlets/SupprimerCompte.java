/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rdm.servlets;

import com.rdm.DAO.implementation.ChambreDAO;
import com.rdm.DAO.implementation.HotelierDAO;
import com.rdm.DAO.implementation.MembreDAO;
import com.rdm.DAO.implementation.ParticulierDAO;
import com.rdm.DAO.implementation.ReservationDAO;
import com.rdm.modele.Hotelier;
import com.rdm.modele.Membre;
import com.rdm.modele.Particulier;
import com.rdm.util.Connexion;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author kamizushi
 */
@WebServlet(name = "SupprimerCompte", urlPatterns = {"/SupprimerCompte"})
public class SupprimerCompte extends HttpServlet {

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
        String  strid = request.getParameter("id");
        if (strid==null){
            request.setAttribute("message", "Le parametre id n'est pas specifié.");
            request.getRequestDispatcher("/index.jsp").forward(request, response);return;
        }
        
        Integer id;
        try{
            id=Integer.parseInt(strid);
        }
        catch(IllegalArgumentException e){
            request.setAttribute("message", "Le format du paramètre id est invalide.");
            request.getRequestDispatcher("/index.jsp").forward(request, response);return;
        }
        
        Membre connecte = (Membre)request.getSession().getAttribute("connecte");
        if(connecte==null){
            request.setAttribute("message", "Vous devez être connecté pour faire cette operation.");
            request.getRequestDispatcher("/index.jsp").forward(request, response);return;
        }
        
        if(!connecte.getId().equals(id)){
            request.setAttribute("message", "Vous ne pouvez supprimer que votre propre compte.");
            request.getRequestDispatcher("/index.jsp").forward(request, response);return;
        }
        
        
        try{
        MembreDAO dao;
        
        if(connecte.getType().equals("Particulier")){
            
            ReservationDAO reservationDAO =new ReservationDAO();
            dao = new ParticulierDAO();
            
            //on vérifie que le particulier n'a pas de réservation
            if  (!reservationDAO.findByParticulier(
                                    (Particulier)dao.
                                        read(id)
                                ).isEmpty()
            ){
            request.setAttribute("message", "Vous devez d'abort effacer tous vos réservations.");
            request.getRequestDispatcher("/index.jsp").forward(request, response);return;
            }
            
        }else if(connecte.getType().equals("Hotelier")){
            ChambreDAO chambreDAO =new ChambreDAO();
            dao = new HotelierDAO();
            
            //on vérifie que l'hotelier n'a pas de chambre
            if  (!chambreDAO.findByHotelier(
                                    (Hotelier)dao.
                                        read(id)
                                ).isEmpty()
            ){
            request.setAttribute("message", "Vous devez d'abort effacer tous vos chambres.");
            request.getRequestDispatcher("/index.jsp").forward(request, response);return;
            }
        }else{
            request.setAttribute("message", "Le type de votre compte est inconnu.");
            request.getRequestDispatcher("/index.jsp").forward(request, response);return;
        }
        
        
        dao.delete(id);
        request.getSession().removeAttribute("connecte");
        
        request.getRequestDispatcher("/index.jsp").forward(request, response);
        
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
