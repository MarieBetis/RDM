/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.rdm.servlets;

import com.rdm.DAO.implementation.HotelierDAO;
import com.rdm.DAO.implementation.ParticulierDAO;
import com.rdm.modele.Hotelier;
import com.rdm.modele.Particulier;
import com.rdm.util.Connexion;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author usager
 */
public class Inscription extends HttpServlet {

    /**
        Parrametres essentiel de la requète utilisés: 
                *email
                *password
                *type
                *siteweb
                * nomentreprise
        Attributs modifiés:
               dans la session
                  -connecte
               dans la requète
                  -message
        Modification au niveau du modele:
               Ajout d'un Hotelier dans la bd.
     * @param request
     * @param response
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String type = request.getParameter("type");
        
        if(type!= null){
        
           if(request.getParameter("type").equalsIgnoreCase("particulier")){
           String titre= request.getParameter("titre"),
                   nom= request.getParameter("nom"),
                   prenom= request.getParameter("prenom"),
                   email= request.getParameter("email"),
                   motdepasse= request.getParameter("motdepasse"),
                   rue= request.getParameter("rue"),
                   ville= request.getParameter("ville"),
                   codePostal= request.getParameter("codePostal"),
                   province= request.getParameter("province"),
                   pays= request.getParameter("pays");
                   
                   String adresse = ("Ville :"+ville+", Code postal:"+codePostal+", Province:"+province+", Pays:"+pays);
               
             for (String parametre:
                        new String[]{
                            titre,
                            nom,
                            prenom,
                            email,
                            motdepasse,
                            rue,
                            ville,
                            codePostal,
                            province,
                            pays,
                        }
                ) if (parametre==null){
                    request.setAttribute("message", "Un parametre obligatoire n'est pas définit.");
                    request.getRequestDispatcher("/index.jsp").forward(request, response);
                    return;
                }   
           
              Particulier particulier = new Particulier(email.trim(), motdepasse,nom,prenom,titre,adresse);
                
              
              try
              {ParticulierDAO particulierDAO = new ParticulierDAO();
                if(particulierDAO.create(particulier)){
                    request.getSession().setAttribute("connecte", particulier);
                    request.getRequestDispatcher("/index.jsp").forward(request, response);
                }
                else if(particulierDAO.read(email)!=null){
                    request.setAttribute("message", "Il existe déjà un compte particulier qui utilise ce courriel.");
                    request.getRequestDispatcher("/index.jsp").forward(request, response);
                }else{
                    request.setAttribute("message", "Une erreur inconnue empeche la création du compte hotelier.");
                    request.getRequestDispatcher("/index.jsp").forward(request, response);
                }
                    }
        catch(ClassNotFoundException ex){
           request.setAttribute("message", "Impossible de se connceter à la base de données.");
            request.getRequestDispatcher("/index.jsp").forward(request, response);
       
        }
        
             
             
       
               
           }
           
           
           
                   
       /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////       
             
           
         
           if(request.getParameter("type").equalsIgnoreCase("hotelier")){
                     
                String  email = request.getParameter("email"),
                motDePasse = request.getParameter("motdepasse"),
                siteweb = request.getParameter("siteweb"),
                nomEntreprise = "david";
                
                //Verification qu'aucun parametre est a nul.
                for (String parametre:
                        new String[]{
                            email,
                            motDePasse,
                            siteweb,
                        }
                ) if (parametre==null){
                    request.setAttribute("message", "Un parametre obligatoire n'est pas définit.");
                    request.getRequestDispatcher("/index.jsp").forward(request, response);
                    return;
                }
                
                
                Hotelier hotelier = new Hotelier(email.trim(), motDePasse, siteweb.trim(), nomEntreprise);
                try
                {
                HotelierDAO hotelierDAO = new HotelierDAO();
                if(hotelierDAO.create(hotelier)){
                    request.getSession().setAttribute("connecte", hotelier);
                    request.getRequestDispatcher("/index.jsp").forward(request, response);
                }
                else if(hotelierDAO.read(email)!=null){
                    request.setAttribute("message", "Il existe déjà un compte hotelier qui utilise ce courriel.");
                    request.getRequestDispatcher("/index.jsp").forward(request, response);
                }else{
                    request.setAttribute("message", "Une erreur inconnue empeche la création du compte hotelier.");
                    request.getRequestDispatcher("/index.jsp").forward(request, response);
                }
                    }
        catch(ClassNotFoundException ex){
           request.setAttribute("message", "Impossible de se connceter à la base de données.");
            request.getRequestDispatcher("/index.jsp").forward(request, response);
       
        }
        
                
                
           }
        
        
        
        
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
