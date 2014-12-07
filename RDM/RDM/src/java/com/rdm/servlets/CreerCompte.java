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
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 *
 * @author usager
 */
@WebServlet(name = "CreerCompte", urlPatterns = {"/CreerCompte"})
public class CreerCompte extends HttpServlet {
    /*
        Parrametres essentiel de la requète utilisés: 
                -email*
                -type*
                -motdepasse*
                -motdepasse2*
                -siteweb,//si hotelier *
                -nomentreprise,//si hotelier
                -nom,//si particulier *
                -prenom,//si particulier
                -titre,//si particulier*
                -adresse,//si particulier
        Attributs modifiés:
            dans la session
                 -connecte
            dans la requète
                -message
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //On verifie le parametre email existe
        String email = request.getParameter("email");
        if (email ==null){
            request.setAttribute("message", "Le email n'est pas spécifié.");
            request.getRequestDispatcher("/index.jsp").forward(request, response);return;
        }
        

        try
        {//On s'assure qu'il n'existe pas de compte avec ce nom
        for(MembreDAO dao:new MembreDAO[]{
                new HotelierDAO(), new ParticulierDAO(),
            }
        ) if(dao.read(email)!=null){
            request.setAttribute("message", "Il existe déjà un compte qui utilise de courriel.");
            request.getRequestDispatcher("/index.jsp").forward(request, response);return;
        }    }
        catch(ClassNotFoundException ex){
           request.setAttribute("message", "Impossible de se connceter à la base de données.");
            request.getRequestDispatcher("/index.jsp").forward(request, response);
       
        }
        
        
        
        
        
        String type = request.getParameter("type");
        if(type ==null){
            request.setAttribute("message", "Le type de compte à creer n'est pas spécifié.");
            request.getRequestDispatcher("/index.jsp").forward(request, response);return;
        }
        type=type.toLowerCase();
        Membre membre;
        if(type.equals("hotelier"))
            try{
                membre = this.createHotelier(request);
            }
            catch(Exception e){
                request.setAttribute("message", e.getMessage());
                request.getRequestDispatcher("/index.jsp").forward(request, response);return;
            }
        else if (type.equals("particulier")){
            try{
                membre = this.createParticulier(request);
            }
            catch(Exception e){
                request.setAttribute("message", e.getMessage());
                request.getRequestDispatcher("/index.jsp").forward(request, response);return;
            }
        } else{
                request.setAttribute("message", "Ce type de compte n'existe pas.");
                request.getRequestDispatcher("/index.jsp").forward(request, response);return;
        }
        request.getSession().setAttribute("connecte", membre);
        request.getSession().setAttribute("typecompte", type);
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
    
    private Hotelier createHotelier(HttpServletRequest request) throws Exception{
        String  email = request.getParameter("email"),
                motDePasse = request.getParameter("motdepasse"),
                motDePasse2 = request.getParameter("motdepasse2"),
                siteweb = request.getParameter("siteweb"),
                nomEntreprise = request.getParameter("nomentreprise");
                
        //Verification qu'aucun parametre est a nul.
        for (String parametre:
                new String[]{
                    email.trim(),
                    motDePasse2,
                    motDePasse,
                    siteweb,
                    nomEntreprise,
                }
        ) if (parametre==null)
            throw new Exception("Un parametre obligatoire n'est pas définit.");

        if(!motDePasse.equals(motDePasse2))
                throw new Exception("Le mot de passe de confirmation est différent du mot de passe.");
        
        Hotelier hotelier = new Hotelier(email.trim(), motDePasse, siteweb.trim(), nomEntreprise);
        HotelierDAO hotelierDAO = new HotelierDAO();
        if(!hotelierDAO.create(hotelier))
                throw new Exception("Une erreur inconnue empeche la création du compte.");
        return hotelier;
    }
    
    
    
    private Particulier createParticulier(HttpServletRequest request) throws Exception{
        String  email = request.getParameter("email"),
                motDePasse = request.getParameter("motdepasse"),
                motDePasse2 = request.getParameter("motdepasse2"),
                nom = request.getParameter("nom"),
                prenom = request.getParameter("prenom"),
                titre = request.getParameter("titre"),
                rue = request.getParameter("rue"),
                ville = request.getParameter("ville"),
                province = request.getParameter("province"),
                codepostale = request.getParameter("codepostale"),
                pays = request.getParameter("pays");
        
        //Verification qu'aucun parametre est a nul.
        for (String parametre:
                new String[]{
                    email.trim(),
                    motDePasse,
                    motDePasse2,
                    nom,
                    prenom,
                    titre,
                    rue,
                    ville,
                    province,
                    codepostale,
                    pays,
                    
                }
        ) if (parametre==null)
            throw new Exception("Un parametre obligatoire n'est pas définit.");
        
        if(!motDePasse.equals(motDePasse2))
                throw new Exception("Le mot de passe de confirmation est différent du mot de passe.");
        
        String adresse = rue+" "+ville+" "+province+" "+pays+" "+codepostale;
        Particulier particulier = new Particulier(email.trim(), motDePasse, nom, prenom, titre, adresse);
        ParticulierDAO particulierDAO = new ParticulierDAO();
        if(!particulierDAO.create(particulier))
                throw new Exception("Une erreur inconnue empeche la création du compte.");
        return particulier;
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