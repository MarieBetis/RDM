<%-- 
    Document   : loginHotelier
    Created on : 2014-10-13, 17:04:53
    Author     : Usager
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="./style/connexion.css" rel="stylesheet" type="text/css" />
        <title>Connexion du consommateur</title>
    </head>
    <body>
<div class="main">
<%
    if (session.getAttribute("hotelierConnecte") != null) 
    {
%>
<jsp:forward page="index.jsp" />
<%
    }
     if (request.getAttribute("message")!=null)
        {
            out.println("<span class=\"errorMessage\">"+request.getAttribute("message")+"</span>");
        }
%>


<div class="login">
    <h2>Connexion de l'hôtelier</h2>
    <form action="controleur.do" method="post">
        <table>
            <tr>
                <td>Adresse e-mail : </td><td><input type="text" name="userEmail" /></td>
            </tr>
            <tr>
                <td>Mot de passe : </label></td><td><input type="password" name="password" /></td>
            </tr>
            <tr>
                <td><input type="hidden" name="action" value="loginHotelier" /></td><td><input type="submit" value="Connexion" /></td>
            <tr>
        </table>
    </form>
</div>
</div>    
    </body>
</html>