/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.rdm.controleur;

import com.rdm.util.Connexion;
import java.io.IOException;
import java.sql.DriverManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Autre compte
 */
public class ControleurFrontal extends HttpServlet {

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
        Connexion.setUrl("jdbc:mysql://localhost/rdm?user=root");
        try {
            //Chargement du pilote :
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            request.setAttribute("message", "Impossible de charger le pilote");
            RequestDispatcher r = this.getServletContext().getRequestDispatcher("/login.jsp");
            r.forward(request, response);
        }
        
        String action = request.getParameter("action");
        if(Connexion.getInstance()==null){
            request.setAttribute("message", DriverManager.getDrivers() + "pas de connection");
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }
       
       
        if (action !=null){
            //On redirige les requete a partir d'un array contenant le nom des servlets disponible
            action = action.toLowerCase();
            for(String requestName: 
                    new String[]{
                            "rechercher",
                            "login",
                            "logout",
                            "inscription",
                            "creerreservation",
                            "creerchambre",
                            "supprimerreservation",
                            "supprimerchambre",
                            "modifierreservation",
                            "modifierchambre",
                            "creercompte",
                            "modifiercompte",
                            "supprimercompte",
                             "modifier_rph"}
            )if (requestName.equals(action))
                request.getRequestDispatcher("/"+requestName).forward(request, response);
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
