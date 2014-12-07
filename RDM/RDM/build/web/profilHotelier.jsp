<%-- 
    Document   : profilHotelier
    Created on : 2014-11-25, 12:24:07
    Author     : usager
--%>

<%@page import="com.rdm.modele.Hotelier"%>
<%@page import="com.rdm.modele.Membre"%>
<%@page import="com.rdm.DAO.implementation.HotelierDAO"%>
<%@page import="com.rdm.util.Connexion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%  HotelierDAO hDAO = new HotelierDAO();
    Hotelier hotelier = hDAO.read(((Membre) request.getSession().getAttribute("connecte")).getEmail());
%>


<span> <a class = "retour" href ="index.jsp?afficherPage=accueil">&larr; Retour </a> </span>
<a href="index.jsp?afficherPage=modificationCompteHotelier">Modifier votre compte</a>
<fieldset>
    <h1 id = "profilH"> </h1>
    <table> 
        <tr>
            <td>Nom de l'hôtel :</td>
            <td><%=hotelier.getNomEntreprise()%></td>
        </tr>
        <tr>
            <td>Email:</td>
            <td><%=hotelier.getEmail()%></td>
        </tr>
        <tr>
            <td>Site Web :</td>
            <td><%=hotelier.getSiteweb()%></td>
        </tr>
    </table>
    <div classe ="blocs">
        <div id="annonces" align="center">
            <h2>Annonces publiées</h2>
            <div classe ="blocs">
                <div classe = "annonces">
                    <figure class="dessin">
                        <a href="ctrl.do?action=afficherUneAnnonce"><img src="./images/chambre.jpg" alt="" height="200" width="200"/></a>
                        <a href="ctrl.do?action=afficherUneAnnonce"><figcaption>Légende associée</figcaption></a>
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
