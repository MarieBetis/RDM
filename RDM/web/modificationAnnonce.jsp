<%-- 
    Document   : modificationAnnonce
    Created on : 2014-11-25, 13:18:35
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
        <div >
                
                  <form class="form2" method="post" action="controleur.do" enctype="multipart/form-data">
                      <span> <a class = "retour" href ="index.jsp?afficherPage=afficherUneAnnonce">&larr; Retour </a> </span>
                      <h2>Modifiez votre annonce</h2>  
                    <table>
			<tr>
                            <td>Titre de l'annonce : </td><td><input type="text" name="titre"/></td>
                        </tr>
                        <tr>
                            <td>Contenu : </td><td>
                        <textarea type="text" name="titre"> </textarea></td>
                        </tr>
                         <tr>
                             <td>Date début : </td><td><input type="text" class="datearrivee" name="date_debut" /></td> <td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
                            <td>Date fin : </td><td><input type="text" class ="datedepart" name="date_fin" /></td>
                         </tr>
                       
                        <tr>
                            <td>Capacité d'accueil : </td><td><input type="text" name="capacite"/></td>
                        </tr>
                        <tr>
                            <td>Prix : </td><td><input type="text" name="prix"/></td>
                        </tr>
                        <tr>
                            <td>Joindre image : </td><td><input type="file" name="file" id="file" /> </td>
                        </tr>
                         <tr>
                            <td><input type="hidden" name="action" value="publierAnnonce" /></td><td><input type="submit" value="Appliquer" name="boutonAppliquer"/></td>
                        </tr>
                    </table>
                </form>                
            </div> 
    </body>
</html>
