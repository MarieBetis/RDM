<%-- 
    Document   : publierAnnonce
    Created on : 2014-10-13, 12:00:14
    Author     : Usager
--%>


<%
   // if (session.getAttribute("connecte")==null)// (session.getAttribute("hotelierConnecte")==null)
    {
%>
      <%--    <jsp:forward page="login.jsp" />  vaut mieux avoir une page login différente pour chaque utilisateur  <jsp:forward page="loginHotelier.jsp" />       --%>
<%
    }
%>



<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" media="screen,projection" type="text/css" href="style/accueil.css" /> 
        <link rel="stylesheet" href="//code.jquery.com/ui/1.11.1/themes/smoothness/jquery-ui.css">
        <link href="./style/publierAnnonce.css" rel="stylesheet" type="text/css" />
        <script src="//code.jquery.com/jquery-1.10.2.js"></script>
        <script src="//code.jquery.com/ui/1.11.1/jquery-ui.js"></script>
        <link rel="stylesheet" href="/resources/demos/style.css">
        <script>
        $(function() {
        $( "#dateDebut" ).datepicker();
        $( "#dateFin" ).datepicker();
        });
        </script>
        <title>Publication d'annonce</title>
    </head>
    <body>
      <div class="main">
            <div class="publication">
                <h1>Publiez votre annonce</h1>  
                <form method="post" action="controleur.do" enctype="multipart/form-data">
                    <table>
			<tr>
                            <td>Titre de la chambre : </td><td><input type="text" name="titreChambre"/></td>
                        </tr>
                         <tr>
                            <td>Date début : </td><td><input type="text" id="dateDebut" placeholder="Date début" /></td>
                        </tr>
                        <tr>
                            <td>Date fin : </td><td><input type="text" id="dateFin" placeholder="Date de fin" /></td>
                        </tr>
                        <tr>
                            <td>Codre de l'offre : </td><td><input type="text" name="codeOffre"/></td>
                        </tr>
                        <tr>
                            <td>Capacité d'accueil : </td><td><input type="text" name="capaciteAccueil"/></td>
                        </tr>
                        <tr>
                            <td>Prix : </td><td><input type="text" name="prix"/></td>
                        </tr>
                        <tr>
                            <td>Joindre image : </td><td><input type="file" name="file" id="file" /> </td>
                        </tr>
                         <tr>
                            <td></td><td><input type="submit" value="Appliquer" name="boutonAppliquer"/></td>
                        </tr>
                    </table>
                <form>                
            </div> 
        </div>
    </body>
</html>
