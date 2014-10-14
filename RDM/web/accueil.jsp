<%-- 
    Document   : accueil
    Created on : 2014-10-13, 13:24:16
    Author     : Marie
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <div id="main"> 
            <div id ="recherche">
                <form action="" method="get">
                    <input type="text" name="destination" placeholder="Destination">
                    <input type="text" id="datearrivee" placeholder="Arrivée">
                    <input type="text" id="datedepart" placeholder="Depart">
                    <select>
                        <option value="un">1 voyageur</option>
                        <option value="deux">2 voyageur</option>
                        <option value="trois">3 voyageur</option>
                        <option value="quatres">4 voyageur</option>
                        <option value="cinq">5 et+ voyageur</option>
                    </select> 
                    <input type="submit" value="Rechercher">
                </form> 
            </div>
            <div id="annonces" align="center">
                <h2>Annonces disponibles</h2>
                <div classe ="blocs">
                    <div classe = "annonces">
                        <figure class="dessin">
                            <img src="../images/interrogation.png" alt="" />
                            <figcaption>Légende associée</figcaption>
                         </figure>
                        <figure class="dessin">
                            <img src="../images/interrogation.png" alt="" />
                            <figcaption>Légende associée</figcaption>
                         </figure>
                        <figure class="dessin">
                            <img src="../images/interrogation.png" alt="" />
                            <figcaption>Légende associée</figcaption>
                         </figure>
                    </div>
                    <div classe = "annonces">
                        <figure class="dessin2">
                            <img src="../images/interrogation.png" alt="" />
                            <figcaption>Légende associée</figcaption>
                         </figure>
                        <figure class="dessin2">
                            <img src="../images/interrogation.png" alt="" />
                            <figcaption>Légende associée</figcaption>
                         </figure>
                        <figure class="dessin2">
                            <img src="../images/interrogation.png" alt="" />
                            <figcaption>Légende associée</figcaption>
                         </figure>
                    </div> 
                </div>
            </div>
         
           
        </div>
</html>
