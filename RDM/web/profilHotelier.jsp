<%-- 
    Document   : profilHotelier
    Created on : 2014-11-25, 12:24:07
    Author     : usager
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <span> <a class = "retour" href ="index.jsp?afficherPage=accueil">&larr; Retour </a> </span>
        <a href="index.jsp?afficherPage=modificationCompteHotelier">Modifier votre compte</a>
        <fieldset>
            <h1 id = "profilH"> </h1>
            <table> 
                <tr>
                    <td>Nom :</td>
                    <td>--</td>
                </tr>
                <tr>
                    <td>Email:</td>
                    <td>--</td>
                </tr>
                <tr>
                    <td>Site Web :</td>
                    <td>--</td>
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
    </body>
</html>
