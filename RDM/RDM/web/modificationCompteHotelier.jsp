           
<%@page import="com.rdm.modele.Hotelier"%>
<%@page import="com.rdm.modele.Membre"%>
<%@page import="com.rdm.DAO.implementation.HotelierDAO"%>
<%--                             Modification du compte de l'hôtelier               --%>



<div id="formulaire">
    <form class="form2" method="POST" action="modificationHotelier.do">
 <span> <a class = "retour" href ="index.jsp?afficherPage=profilHotelier">&larr; Retour </a> </span>
        <h2>Modification du compte</h2>
       <table>
              <tr>
                <td><label>          <%
    HotelierDAO hDAO = new HotelierDAO();
    Hotelier hotelier = hDAO.read(((Membre) request.getSession().getAttribute("connecte")).getEmail());
%>
       </label></td>
                <td></td> <td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
            </tr>
            <tr>
                <td><label>Nom d'entreprise: </label></td>
                <td><input type="text" id="nom" name = "nom"  value="<%=hotelier.getNomEntreprise()%>" /></td> <td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
            </tr>
            <tr> 
                <td><label>E-mail : </label></td>
                <td> <input type="email" id="username" name = "email"  value="<%=hotelier.getEmail()%>"/></td>
            </tr>
            <tr>                            
                <td><label>Mot de passe : </label></td>
                <td> <input type="password" id="password" name = "password" placeholder="************"/></td> <td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
                <td><label>Confirmez le mot de passe: </label></td>
                <td> <input type="password" id="password2" name = "password2" placeholder="************"/></td>
            </tr>
            <tr>
                <td><label>Site web : </label></td>
                <td> <input type="text" id="siteWeb" name = "siteWeb"  value="<%=hotelier.getSiteweb()%>"/></td>
            </tr>
        </table>
        <input type="submit" name="bOk" value="Modifier"/>
        <input type="hidden" name="action" value="modifier_rph" />
        <input type="hidden" name="modifierHotelier" value="modifierHotelier" />
    </form>
</div>
