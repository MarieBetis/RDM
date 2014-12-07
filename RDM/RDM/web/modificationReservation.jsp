<%-- 
    Document   : modificationReservation
    Created on : 2014-11-25, 13:53:56
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
       <form class="form2" method="post" action="controleur.do" enctype="multipart/form-data">
            <span> <a class = "retour" href ="index.jsp?afficherPage=profilParticulier">&larr; Retour </a> </span>
            <h2>Modifiez votre réservation</h2>  
          <table>
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
                    <td>Date début : </td><td><input type="text" class="datearrivee" name="date_debut" /></td> <td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
                   <td>Date fin : </td><td><input type="text" class ="datedepart" name="date_fin" /></td>
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
            <input type="submit" name="bOk" value="Modifier"/>
            <input type="hidden" name="action" value="modificationReservation" />
      </form>            
    </body>
</html>
