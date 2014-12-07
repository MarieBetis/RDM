<%-- 
    Document   : pageReservation
    Created on : 2014-11-21, 10:40:09
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
        <h2>Recapitulatif de votre reservation</h2>
        <table class = "uneAnnonce">
            <tr>
                <td>
                    <label> Destination : </label>
                </td>
                <td>
                    <label> ---- </label>
                </td>
            </tr>
            <tr>
                <td>
                    <label> Hotel (adresse): </label>
                </td>
                <td>
                    <label> ---</label>
                </td>
            </tr>
            <tr>
                <td>
                    <label> Date d'arrivée :</label>
                </td>
                <td>
                    <label> ---</label>
                </td>
            </tr>
            <tr>
                <td>
                    <label> Date de départ :</label>
                </td>
                <td>
                    <label> ---</label>
                </td>
            </tr>
            <tr>
                <td>
                    <label> Nombre de personnes :</label>
                </td>
                <td>
                    <label> ---</label>
                </td>
            </tr>
            <tr>
                <td>
                    <label> Prix par personnes :</label>
                </td>
                <td>
                    <label> ---</label>
                </td>
            </tr>
            <tr>
                <td>
                    <label> Total :</label>
                </td>
                <td>
                    <label> ---</label>
                </td>
            </tr>
        </table>
        <a href="ctrl.do?action=reservation" class ="b2"> Confirmez </a>
        <input type="reset" value="Annuler"/>
    </body>
</html>
