/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rdm.servlets;

import com.rdm.DAO.implementation.HotelierDAO;
import com.rdm.DAO.implementation.ParticulierDAO;
import com.rdm.DAO.implementation.ReservationDAO;
import com.rdm.modele.Hotelier;
import com.rdm.modele.Membre;
import com.rdm.modele.Particulier;
import com.rdm.modele.Reservation;
import com.rdm.util.Connexion;
import java.io.IOException;
import static java.sql.Types.NULL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




/**
 *
 * @author admin
 */
public class Modifier_RPH extends HttpServlet {

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
        
    try {
             Class.forName(this.getServletContext().getInitParameter("piloteJdbc"));
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Modifier_RPH.class.getName()).log(Level.SEVERE, null, ex);
        }
 Connexion.setUrl(this.getServletContext().getInitParameter("urlBD"));  
       

        
           
/*
///////////////////////////////////////////////////////////////////////////////////////////////////////////////  
                                    Modification Compte Particulier
///////////////////////////////////////////////////////////////////////////////////////////////////////////////  
*/     
        
        if (request.getParameter("modifierParticulier")!=null){
         String nom = request.getParameter("nom").trim(),
               prenom = request.getParameter("prenom").trim(),
                email = request.getParameter("email").trim(),
                password = request.getParameter("password").trim(),
                password2 = request.getParameter("password2").trim(),
                noRue = request.getParameter("noRue").trim(),
               rue = request.getParameter("rue").trim(),
                ville = request.getParameter("ville").trim(),
                codePostal = request.getParameter("codePostal").trim(),
                province = request.getParameter("province").trim(),
                pays = request.getParameter("pays").trim();

        if (nom == null || nom.equalsIgnoreCase("")) {
            request.setAttribute("message", "Le nom du particulier est obligatoire.");
            request.getRequestDispatcher("/index.jsp?afficherPage=modificationCompteParticulier").forward(request, response);
            return;
        }
        if (prenom == null || prenom.equalsIgnoreCase("")) {
            request.setAttribute("message", "Le prénom du particulier est obligatoire.");
            request.getRequestDispatcher("/index.jsp?afficherPage=modificationCompteParticulier").forward(request, response);
            return;
        }
        if (email == null || email.equalsIgnoreCase("")) {
            request.setAttribute("message", "Le courriel du particulier est obligatoire.");
            request.getRequestDispatcher("/index.jsp?afficherPage=modificationCompteParticulier").forward(request, response);
            return;
        }
        if (password == null || password.equalsIgnoreCase("")) {
            request.setAttribute("message", "Le mot de passe du particulier est obligatoire.");
            request.getRequestDispatcher("/index.jsp?afficherPage=modificationCompteParticulier").forward(request, response);
            return;
        }
        if (password2 == null || password2.equalsIgnoreCase("")) {
            request.setAttribute("message", "La confirmation du mot de passe du particulier est obligatoire.");
            request.getRequestDispatcher("/index.jsp?afficherPage=modificationCompteParticulier").forward(request, response);
            return;
        }
        if (!password2.equals(password)) {
            request.setAttribute("message", "Les deux mots de passe doivent être identiques.");
            request.getRequestDispatcher("/index.jsp?afficherPage=modificationCompteParticulier").forward(request, response);
            return;
        }
        if (noRue == null || noRue.equalsIgnoreCase("")) {
            request.setAttribute("message", "Le numéro de la rue du particulier est obligatoire.");
            request.getRequestDispatcher("/index.jsp?afficherPage=modificationCompteParticulier").forward(request, response);
            return;
        }
        Integer numeroRue;
        try{
                numeroRue=Integer.parseInt(noRue);
        }
        catch(NumberFormatException  e){
            request.setAttribute("message", "Le numéro de la rue est invalide.");
            request.getRequestDispatcher("/index.jsp").forward(request, response);return;
        }
        if (rue == null || rue.equalsIgnoreCase("")) {
            request.setAttribute("message", "Le nom de la rue du particulier est obligatoire.");
            request.getRequestDispatcher("/index.jsp?afficherPage=modificationCompteParticulier").forward(request, response);
            return;
        }
        if (ville == null || ville.equalsIgnoreCase("")) {
            request.setAttribute("message", "Le ville du particulier est obligatoire.");
            request.getRequestDispatcher("/index.jsp?afficherPage=modificationCompteParticulier").forward(request, response);
            return;
        }
        if (codePostal == null || codePostal.equalsIgnoreCase("")) {
            request.setAttribute("message", "Le code postal du particulier est obligatoire.");
            request.getRequestDispatcher("/index.jsp?afficherPage=modificationCompteParticulier").forward(request, response);
            return;
        }
        if (province == null || province.equalsIgnoreCase("")) {
            request.setAttribute("message", "La province du particulier est obligatoire.");
            request.getRequestDispatcher("/index.jsp?afficherPage=modificationCompteParticulier").forward(request, response);
            return;
        }
        if (pays == null || pays.equalsIgnoreCase("")) {
            request.setAttribute("message", "Le pays du particulier est obligatoire.");
            request.getRequestDispatcher("/index.jsp?afficherPage=modificationCompteParticulier").forward(request, response);
            return;
        }
        String adresse = noRue+" "+rue+", "+ville+", "+codePostal+", "+province+", "+pays;
        try {
            ParticulierDAO particulierDAO = new ParticulierDAO();
             Particulier particulier = particulierDAO.read(((Membre) request.getSession().getAttribute("connecte")).getEmail());
            Particulier particulierInfos = new Particulier(particulier.getParticulierId(), email, password, nom, prenom, particulier.getTitre(), adresse);
           
            if (particulierDAO.update(particulierInfos)) {
                request.setAttribute("message", "La modification du compte est effectuée avec succès.");
                request.getRequestDispatcher("/index.jsp?afficherPage=modificationCompteParticulier").forward(request, response);
                return;
            } else {
                request.setAttribute("message", "La modification du compte a échoué. Le couriel choisi existe peut-être déjà.");
                request.getRequestDispatcher("/index.jsp?afficherPage=modificationCompteParticulier").forward(request, response);
                return;
            }
        } catch (Exception ex) {
            request.setAttribute("message", "Une erreur empêche la modification du compte.");
            request.getRequestDispatcher("/index.jsp?afficherPage=modificationCompteParticulier").forward(request, response);
            return;
        }
      }
        
        
/*
///////////////////////////////////////////////////////////////////////////////////////////////////////////////  
                                    Modification Compte Hotelier
///////////////////////////////////////////////////////////////////////////////////////////////////////////////  
*/       
       
                
                
        if (request.getParameter("modifierHotelier")!=null){
           
            String email = request.getParameter("email").trim(),
                password = request.getParameter("password").trim(),
                password2 = request.getParameter("password2").trim(),
                siteWeb = request.getParameter("siteWeb").trim(),
                nomEntreprise = request.getParameter("nom").trim();
            
            if (nomEntreprise == null || nomEntreprise.equalsIgnoreCase("")) {
            request.setAttribute("message", "Le nom de l'entreprise est obligatoire.");
            request.getRequestDispatcher("/index.jsp?afficherPage=modificationCompteHotelier").forward(request, response);
            return;
        }

        if (email == null || email.equalsIgnoreCase("")) {
            request.setAttribute("message", "Le courriel est obligatoire.");
            request.getRequestDispatcher("/index.jsp?afficherPage=modificationCompteHotelier").forward(request, response);
            return;
        }

        if (password == null || password.equalsIgnoreCase("")) {
            request.setAttribute("message", "Le mot de passe obligatoire.");
            request.getRequestDispatcher("/index.jsp?afficherPage=modificationCompteHotelier").forward(request, response);
            return;
        }
        if (password2 == null || password2.equalsIgnoreCase("")) {
            request.setAttribute("message", "La confirmation du mot de passe est obligatoire.");
            request.getRequestDispatcher("/index.jsp?afficherPage=modificationCompteHotelier").forward(request, response);
            return;
        }
        if (!password.equals(password2)) {
            request.setAttribute("message", "Les deux mots de passe doivent être identiques.");
            request.getRequestDispatcher("/index.jsp?afficherPage=modificationCompteHotelier").forward(request, response);
            return;
        }
        if (siteWeb == null || siteWeb.equalsIgnoreCase("")) {
            request.setAttribute("message", "Le site web est obligatoire.");
            request.getRequestDispatcher("/index.jsp?afficherPage=modificationCompteHotelier").forward(request, response);
            return;
        }
       try {
            HotelierDAO hotelierDAO = new HotelierDAO();
             Hotelier hotelier = hotelierDAO.read(((Membre) request.getSession().getAttribute("connecte")).getEmail());
            Hotelier hotelierInfos = new Hotelier(hotelier.getHotelierId(), email, password, siteWeb, nomEntreprise);
            if (hotelierDAO.update(hotelierInfos)) {
                request.setAttribute("message", "La modification du compte est effectuée avec succès.");
                request.getRequestDispatcher("/index.jsp?afficherPage=modificationCompteHotelier").forward(request, response);
                return;
            } else {
                request.setAttribute("message", "La modification du compte a échoué. Le couriel choisi existe peut-être déjà.");
                request.getRequestDispatcher("/index.jsp?afficherPage=modificationCompteHotelier").forward(request, response);
                return;
            }
        } catch (Exception ex) {
            request.setAttribute("message", "Une erreur empêche la modification du compte.");
            request.getRequestDispatcher("/index.jsp?afficherPage=modificationCompteHotelier").forward(request, response);
            return;
        }    
    }
        
       
        
        
         
/*
///////////////////////////////////////////////////////////////////////////////////////////////////////////////  
                                    Modification Réservation
///////////////////////////////////////////////////////////////////////////////////////////////////////////////  
*/       
       
        
        
        
        
        /*
        if (request.getParameter("modificationReservation")!=null){
            
            
            DateFormat formatter ; 
            formatter = new SimpleDateFormat("dd-MM-yyyy");
            Date dateDebut = formatter.parse(request.getParameter("date_debut"));
            Date dateFin = formatter.parse(request.getParameter("date_fin"));
            int num_personnes = Integer.parseInt(request.getParameter(""));
            int prix = Integer.parseInt(request.getParameter("prix"));
            int total = num_personnes * prix;
                     
            ReservationDAO reservationDAO = new ReservationDAO(Connexion.getInstance()); 
           
            // Pas sûr des paramètres du consctructeur
            Reservation hotelierInfos =  new Reservation();
            reservationDAO.update(hotelierInfos);  
        }
        
        */
        
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
