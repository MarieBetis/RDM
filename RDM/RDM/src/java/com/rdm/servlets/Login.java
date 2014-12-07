/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.rdm.servlets;


import com.rdm.DAO.implementation.HotelierDAO;
import com.rdm.DAO.implementation.MembreDAO;
import com.rdm.DAO.implementation.ParticulierDAO;
import com.rdm.modele.Hotelier;
import com.rdm.modele.Membre;
import com.rdm.modele.Particulier;
import com.rdm.util.Connexion;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Autre compte
 */
public class Login extends HttpServlet {

    /*
        Parrametres essentiel de la requète utilisés: 
                -email
                -motdepasse
        Attributs modifiés:
               dans la session
                  -connecte
               dans la requète
                  -message
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String  email = request.getParameter("email"),
                motDePasse = request.getParameter("motdepasse");
        
        if (email==null || email.trim().equalsIgnoreCase(""))
        {
            //Utilisateur inexistant
            request.setAttribute("message", "Courriel obligatoire");
            request.getRequestDispatcher("/index.jsp").forward(request, response);return;
        }

        try {
            Class.forName(this.getServletContext().getInitParameter("piloteJdbc"));
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
 
        Connexion.setUrl(this.getServletContext().getInitParameter("urlBd"));
        
        // on tente de trouver un compte particulier ou un compte hotelier avec ces informations
        
        try{
        for(MembreDAO dao:new MembreDAO[]{
                new ParticulierDAO(),
                new HotelierDAO()
            }
        ){
            Membre membre = (Membre)dao.connecter(email.trim(),motDePasse);
            if (membre!=null){
                request.getSession(true).setAttribute("connecte", membre);
                request.getRequestDispatcher("/index.jsp").forward(request, response);return;
            }
        }
            }
        catch(ClassNotFoundException ex){
           request.setAttribute("message", "Impossible de se connceter à la base de données.");
            request.getRequestDispatcher("/index.jsp").forward(request, response);
       
        }
        
        
       
        //Pas de résultat dans la bd
        request.setAttribute("message", "Le courriel ou le mot de passe est incorrect.");
        request.getRequestDispatcher("/index.jsp").forward(request, response);
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
