/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.rdm.servlets;

import com.rdm.DAO.implementation.ChambreDAO;
import com.rdm.modele.Chambre;
import com.rdm.modele.Membre;
import com.rdm.util.Connexion;
import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author usager
 */
@WebServlet(name = "CreerChambre", urlPatterns = {"/CreerChambre"})
public class CreerChambre extends HttpServlet {

    /**
        Parrametres essentiel de la requète utilisés: 
                * datedebut
                * datefin
                * titre
                * description
                * prix
                * capacite
                * numerodechambre
                * image
                * ville
                * adresse
        L'attribut "connecte" de la session doit contenir un Hotelier
        Attributs modifiés:dans la requète
                * message
                * chambre
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
                
        Integer hotelierId;
        Membre connecte = (Membre)request.getSession(false).getAttribute("connecte");
        //on verifie que l'utilisateur est connecté en temps qu'hotelier
        if(connecte==null
           ||!connecte.getType().equals("Hotelier")){
            request.setAttribute("message", "Vous devez être connecté en tant qu'hotelier.");
            request.getRequestDispatcher("/index.jsp").forward(request, response);return;
        } 

        String  strdatedebut = request.getParameter("datedebut"),
                strdatefin = request.getParameter("datefin"),
                titre = request.getParameter("titre"),
                description = request.getParameter("description"),
                strprix = request.getParameter("prix"),
                strcapacite = request.getParameter("capacite"),
                numeroDeChambre = request.getParameter("numerodechambre"),
                image = request.getParameter("image"),
                ville = request.getParameter("ville"),
                rue = request.getParameter("rue"),
                province = request.getParameter("province"),
                codepostale = request.getParameter("codepostale"),
                pays = request.getParameter("pays");


        //Verification qu'aucun parametre est a nul.
        for (String parametre:
                new String[]{
                    strdatedebut, 
                    strdatefin,
                    titre,
                    description,
                    strprix,
                    strcapacite,
                    numeroDeChambre,
                    image,
                    ville,
                    rue,
                    province,
                    codepostale,
                    pays,
                }
        ) if (parametre==null){
            request.setAttribute("message", "Un parametre obligatoire n'est pas définit.");
            request.getRequestDispatcher("/index.jsp").forward(request, response);return;
        }

        //On transforme le type des attributs lorsque nécéssaire;
        Date dateDebut;
        Date dateFin;
        Integer prix;
        Integer capacite;
        SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy");
        try{
            dateDebut=new Date(sdf.parse(strdatedebut).getTime());
        }
        catch(ParseException  e){
            request.setAttribute("message", "La date de debut doit avoir le format dd/MM/yyyy.");
            request.getRequestDispatcher("/index.jsp").forward(request, response);return;
        }

        try{
            dateFin=new Date(sdf.parse(strdatefin).getTime());
        }
        catch(ParseException  e){
            request.setAttribute("message", "La date de fin doit avoir le format dd/MM/yyyy.");
            request.getRequestDispatcher("/index.jsp").forward(request, response);return;
        }

        try{
                prix=Integer.parseInt(strprix);
        }
        catch(NumberFormatException  e){
            request.setAttribute("message", "Format de prix invalide.");
            request.getRequestDispatcher("/index.jsp").forward(request, response);return;
        }

        try{
                capacite=Integer.parseInt(strcapacite);
        }
        catch(NumberFormatException  e){
            request.setAttribute("message", "La capacité doit être un nombre entier.");
            request.getRequestDispatcher("/index.jsp").forward(request, response);return;
        }
        try{
        String adresse = rue+" "+ville+" "+province+" "+pays+" "+codepostale;
        ChambreDAO chambreDAO = new ChambreDAO();
        Chambre chambre = new Chambre (
                    dateDebut, 
                    dateFin, 
                    titre, 
                    description, 
                    prix, 
                    capacite, 
                    numeroDeChambre, 
                    image, 
                    ville, 
                    adresse, 
                    connecte.getId()
        );
        
         if(chambreDAO.create(chambre)){
            request.setAttribute("chambre", chambre);
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }else {
            request.setAttribute("message", "Une erreur inconnue empeche la création de la chambre.");
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
