<%-- 
    Document   : index
    Created on : 2014-10-07, 13:16:46
    Author     : usager
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>RDM - Accueil</title>
        <link rel="stylesheet" media="screen,projection" type="text/css" href="style/accueil.css" /> 
        <link rel="stylesheet" href="//code.jquery.com/ui/1.11.1/themes/smoothness/jquery-ui.css">
        <script src="//code.jquery.com/jquery-1.10.2.js"></script>
        <script src="//code.jquery.com/ui/1.11.1/jquery-ui.js"></script>
        <link rel="stylesheet" href="/resources/demos/style.css">
        <script>
        $(function() {
        $( "#datearrivee" ).datepicker();
        $( "#datedepart" ).datepicker();
        });
        </script>
    </head>
    <body>
        <div id="main"> 
            
            <header> 
                <span id = "ti"> <span id = "titre" >RDM</span> Réservation dès maintenant </span>
                <span id = "button">
                    <input type="submit" value = "Connexion"/>
                    <input type="submit" value = "Publier une annonce"/>
                </span>
            </header>
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
                        <figure>
  <img src="../images/interrogation.png" alt="" />
  <figcaption>Légende associée</figcaption>
</figure>
                        <div class="dessin"></div> <span> sdf </span>
                        <div class="dessin"></div> <span> sdf </span>  
                    </div>
                    <div classe = "annonces">
                        <div class="dessin2"></div>
                        <div class="dessin2"></div>
                        <div class="dessin2"></div>
                    </div> 
                </div>
            </div>
         
           
        </div>
    </body>
</html>
