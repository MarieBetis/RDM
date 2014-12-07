/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rdm.servlets;

import com.rdm.DAO.implementation.ChambreDAO;
import com.rdm.modele.Chambre;
import com.rdm.util.Connexion;
import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author kamizushi
 */
public class Rechercher extends HttpServlet {

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

        String  strdatedebut = request.getParameter("datedebut"),
                  strdatefin = request.getParameter("datefin"),
                  strprixmin = request.getParameter("prixmin"),
                  strprixmax = request.getParameter("prixmax"),
                  strcapacitemax = request.getParameter("capacitemax"),
                  strcapacitemin = request.getParameter("capacitemin"),
                  ville = request.getParameter("ville"),
                  strhotelierid = request.getParameter("hotelierid")
                  ;
        
        if (ville==null
                ||ville.trim().equals("")){
            request.setAttribute("message", "La ville est obligatoire.");
            request.getRequestDispatcher("/index.jsp").forward(request, response);return;
        }
        
        
        //les attributs datedebut et datefin doivent être présent
        if (strdatedebut==null
                ||strdatedebut.trim().equals("")){
            request.setAttribute("message", "La date de debut est obligatoire.");
            request.getRequestDispatcher("/index.jsp").forward(request, response);return;
        }
        if (strdatefin==null
           ||strdatefin.trim().equals("")){
            request.setAttribute("message", "La date de fin est obligatoire.");
            request.getRequestDispatcher("/index.jsp").forward(request, response);return;
        }
        
        
        SimpleDateFormat sdf= new SimpleDateFormat("MM/dd/yyyy");
        Date dateDebut;
        Date dateFin;
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

        //On tente de transformer les attributs prixmin,prixmax,capacitemin, capacitemax et hotelierid si ils sont presents
        Integer prixMin=null;
        if (strprixmin!=null
                &&!strprixmin.trim().equals(""))
            try{
                prixMin=Integer.parseInt(strprixmin);
            }
            catch(NumberFormatException e){
                request.setAttribute("message", "Le format du prix minimal est invalide.");
                request.getRequestDispatcher("/index.jsp").forward(request, response);return;
            }
        Integer prixMax=null;
        if (strprixmax!=null
                &&!strprixmax.trim().equals(""))
            try{
                prixMax=Integer.parseInt(strprixmax);
            }
            catch(NumberFormatException e){
                request.setAttribute("message", "Le format du prix maximal est invalide.");
                request.getRequestDispatcher("/index.jsp").forward(request, response);return;
            }
        Integer capaciteMin=null;
        if (strcapacitemin!=null
                &&!strcapacitemin.trim().equals(""))
            try{
                capaciteMin=Integer.parseInt(strcapacitemin);
            }
            catch(NumberFormatException e){
                request.setAttribute("message", "Le format de la capacité minimale est invalide.");
                request.getRequestDispatcher("/index.jsp").forward(request, response);return;
            }                
        Integer capaciteMax=null;
        if (strcapacitemax!=null
                &&!strcapacitemax.trim().equals(""))
            try{
                capaciteMax=Integer.parseInt(strcapacitemax);
            }
            catch(NumberFormatException e){
                request.setAttribute("message", "Le format de la capacité maximale est invalide.");
                request.getRequestDispatcher("/index.jsp").forward(request, response);return;
            }
        Integer hotelierId=null;
        if (strhotelierid!=null
                &&!strhotelierid.trim().equals(""))
            try{
                hotelierId=Integer.parseInt(strhotelierid);
            }
            catch(NumberFormatException e){
                request.setAttribute("message", "Le format de hotelierid est invalide.");
                request.getRequestDispatcher("/index.jsp").forward(request, response);return;
            }
        
        try{
        List<Chambre> listeChambre = (new ChambreDAO()).recherche(dateDebut, dateFin, null, prixMin, prixMax, capaciteMin, capaciteMax, ville, hotelierId);
        //on fait la recherche et on retourne le resultat
        request.setAttribute("listechambre", listeChambre);
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
