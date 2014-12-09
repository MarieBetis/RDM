<%-- 
    Document   : modificationAnnonce
    Created on : 2014-11-25, 13:18:35
    Author     : usager
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.rdm.modele.Chambre"%>
<%@page import="com.rdm.DAO.implementation.ChambreDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script type="text/javascript">
            //<![CDATA[

            function valider(){
             
                alert("Modification effectuÃ©e avec succÃ¨s");
                
                return false;
              }
            

            //]]>
        </script>
    </head>
    <body>
        
        <% 
            int chambre = Integer.parseInt(request.getParameter("idChambre")); 
            ChambreDAO cDao = new ChambreDAO(); 
            Chambre c = cDao.read(chambre);
        %> 
        <div >
                
           <form class="form2" method="post" action="modifier.do" accept-charset="ISO-8859-1" > 
                      
                      <span> <a class = "retour" href ="index.jsp?afficherPage=afficherUneAnnonce">&larr; Retour </a> </span>
                      <h2>Modifiez votre annonce</h2>  
                       <%
                    if (request.getAttribute("message2")!=null)
                    {
                        out.println("<label class=\"validMessage\">"+request.getAttribute("message2")+"</label>");
                    }
                    if (request.getAttribute("message3")!=null)
                    {
                        out.println("<label class=\"errorMessage\">"+request.getAttribute("message3")+"</label>");
                    }
                    %>
                    <table>
                        <input type="hidden" name="chambreId" value="<%=chambre%>"/>
			<tr>
                            <td>Titre de l'annonce : </td><td><input type="text" name="titre" value="<%=c.getTitre()%>"/></td>
                        </tr>
                        <tr>
                            <td>Contenu : </td><td>
                        <textarea type="text" name="description"> <%=c.getDescription()%> </textarea></td>
                        </tr>
                         <tr>
                             <% SimpleDateFormat sdf= new SimpleDateFormat("MM/dd/yyyy"); %>
                             <td>Date dÃ©but : </td><td><input type="text" class="datearrivee" name="date_debut" value="<%= sdf.format(c.getDateDebut()) %>"/></td> <td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
                            <td>Date fin : </td><td><input type="text" class ="datedepart" name="date_fin" value="<%=sdf.format(c.getDateFin()) %>"/></td>
                         </tr>
                       
                        <tr>
                            <td>NumÃ©ro de chambre : </td><td><input type="text" name="numero" value="<%=c.getNumeroDeChambre() %>"/></td>
                        </tr>
                         <tr>
                            <td>Adresse : </td><td><input type="text" name="adresse" value="<%=c.getAdresse() %>"/></td><td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
                        <td>ville : </td><td><input type="text" name="ville" value="<%=c.getVille() %>"/></td>
                           
                        </tr>
                        <tr>
                            <td>Prix : </td><td><input type="text" name="prix" value="<%=c.getPrix() %>" /></td>
                            
                        </tr>
                        <tr>
                            <td>Joindre image : </td><td><input type="file" name="file" id="file" disabled="true" /> </td><td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
                            <td>CapacitÃ© d'accueil : </td><td><input type="text" name="capacite" value="<%=c.getCapacite()%>"/></td>
                        </tr>
                         <tr>
                          
                            <td><input type="submit" value="Modifier" name="bOk"/></td>
                            <input type="hidden" name="action" value="modifier" />
                        </tr>
                    </table>
                </form>                
            </div> 
    </body>
</html>
