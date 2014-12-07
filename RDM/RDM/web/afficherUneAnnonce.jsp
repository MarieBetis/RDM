<%-- 
    Document   : afficherUneAnnonce
    Created on : 2014-11-21, 09:46:03
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
        <a class = "retour" href ="index.jsp?afficherPage=accueil">&larr; Retour </a><h2>Titre de l'annonce &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span> --$ par nuit</span> </h2> 
        <a href="index.jsp?afficherPage=modificationAnnonce">Modifier l'annonce</a>
        <table class = "uneAnnonce"> 
            <tr>
                <td id ='left' > <h1 class = "p"></h1> </td>
                <td>
                    <h3> Capacité d'acceuil </h3>
                    <p> Lorem ipsum dolor sit amet, consectetur adipiscing elit. </p>
                    <h3> Adresse </h3>
                    <p> Lorem ipsum dolor sit amet, consectetur adipiscing elit. </p>
                    <h3> Description </h3>
                    <p> Lorem ipsum dolor sit amet, consectetur adipiscing elit. 
                        Sed non risus. Suspendisse lectus tortor, dignissim sit amet, adipiscing nec, 
                        ultricies sed, dolor. Cras elementum ultrices diam. Maecenas ligula massa, 
                        varius a, semper congue, euismod non, mi. Proin porttitor, orci nec nonummy 
                        molestie, enim est eleifend mi, non fermentum diam nisl sit amet erat. 
                        Duis semper. Duis arcu massa, scelerisque vitae, consequat in, pretium a, enim. 
                        Pellentesque congue. Ut in risus volutpat libero pharetra tempor. 
                    </p> 
                </td>
                
            </tr>
        </table>
        <a href="ctrl.do?action=reservation" class ="b2"> Réservez </a>
       
       
    </body>
</html>
