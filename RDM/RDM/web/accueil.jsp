<%-- 
    Document   : accueil
    Created on : 2014-10-13, 13:24:16
    Author     : 
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
      <body>
    <div id="main"> 
            
           
                <div classe ="blocs">
                   <div id="annonces" align="center">
                        <h2>Annonces disponibles</h2>
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
                </div>
        </div>
        </body>
</html>
