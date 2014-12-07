<%-- 
    Document   : profilParticulier
    Created on : 2014-11-25, 12:44:22
    Author     : usager
--%>

<%@page import="com.rdm.modele.Particulier"%>
<%@page import="com.rdm.DAO.implementation.ParticulierDAO"%>
<%@page import="com.rdm.util.Connexion"%>
<%@page import="com.rdm.modele.Membre"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

        <%
            ParticulierDAO pDAO = new ParticulierDAO();
            Particulier particulier = pDAO.read(((Membre)request.getSession().getAttribute("connecte")).getEmail());
                 
        %>
    
  
        <span> <a class = "retour" href ="index.jsp?afficherPage=accueil">&larr; Retour </a> </span>
        <a href="index.jsp?afficherPage=modificationCompteParticulier">Modifier votre compte</a>
        <fieldset>
            <h1 id = "profilP"> </h1>
            <table> 
                <tr>
                    <td>Nom :</td>
                    <td><%=particulier.getNom()%></td>
                </tr>
                <tr>
                    <td>Prenom :</td>
                    <td><%=particulier.getPrenom()%></td>
                </tr>
                <tr>
                    <td>Email:</td>
                    <td><%=particulier.getEmail()%></td>
                </tr>
                <tr>
                    <td>Adresse :</td>
                    <td><%=particulier.getAdresse()%></td>
                </tr>
                <%--  <tr>
                    <td>Ville :</td>
                    <td>--</td>
                </tr> --%>
            </table>
             <div classe ="blocs">
                   <div id="annonces" align="center">
                <h2>Vos réservations</h2>
                <div classe ="blocs">
                    <div classe = "annonces">
                        <figure class="dessin">
                            <a href="ctrl.do?action=afficherUneAnnonce"><img src="./images/chambre.jpg" alt="" height="200" width="200"/></a>
                            <a href="ctrl.do?action=afficherUneAnnonce"><figcaption>Légende associée</figcaption></a>
                            <a href="index.jsp?afficherPage=modificationReservation"><figcaption>Modifier</figcaption></a>
                         </figure>
                        <figure class="dessin">
                             <a href="ctrl.do?action=afficherUneAnnonce"><img src="./images/chamb.jpg" alt="" height="200" width="200"/></a>
                            <a href="ctrl.do?action=afficherUneAnnonce"><figcaption>Légende associée</figcaption></a>
                         </figure>
                        <figure class="dessin">
                             <a href="ctrl.do?action=afficherUneAnnonce"><img src="./images/ch.jpg" alt="" height="200" width="200"/></a>
                            <a href="ctrl.do?action=afficherUneAnnonce"><figcaption>Légende associée</figcaption></a>
                         </figure>
                    </div>
                </div>
            </div>
        </fieldset>
