          
<%--                             Pop up modification du compte du consommateur     
--%>

<%@page import="com.rdm.modele.Particulier"%>
<%@page import="com.rdm.DAO.implementation.ParticulierDAO"%>
<%@page import="com.rdm.util.Connexion"%>
<%@page import="com.rdm.modele.Membre"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    ParticulierDAO pDAO = new ParticulierDAO();
    Particulier particulier = pDAO.read(((Membre) request.getSession().getAttribute("connecte")).getEmail());

%>



<div id="main">
    <form  class="form2"  method="POST" action="modificationParticulier.do">
        <span> <a class = "retour" href ="index.jsp?afficherPage=profilParticulier">&larr; Retour </a> </span>
        <h2>Modification du compte</h2>

        <table>
            <tr>
                <td><label>Nom : </label></td>
                <td><input type="text" id="nom" name = "nom" value="<%=particulier.getNom()%>"/></td> <td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
                <td><label>Prénom : </label></td>
                <td><input type="text" id="prenom" name = "prenom" value="<%=particulier.getPrenom()%>"/></td> <td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
            </tr>
            <tr> 
                <td><label>E-mail : </label></td>
                <td> <input type="email" id="username" name = "email" value="<%=particulier.getEmail()%>"/></td>
            </tr>
            <tr>                            
                <td><label>Mot de passe : </label></td>
                <td> <input type="password" id="password" name = "password" placeholder="************"/></td> <td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
                <td><label>Confirmez : </label></td>
                <td> <input type="password" id="password2" name = "password2" placeholder="************"/></td>
            </tr>
            <tr> 
                <td><label>Adresse actuelle: <%=particulier.getAdresse()%></label></td>
                <td></td>
            </tr>
            <tr> 
                <td><label>Nouvelle adresse</label></td>
                <td></td>
            </tr>
            <tr> 
                <td><label>Numéro de la rue : </label </td>
                <td><input type="text" id="noRue" name = "noRue" value="${param.noRue}"/> </td> <td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
                <td><label>Rue : </label </td>
                <td><input type="text" id="rue" name = "rue" value="${param.rue}"/> </td> <td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
            </tr> 
            <tr> 
                <td><label>Ville : </label></td>
                <td><input type="text" id="ville" name = "ville" value="${param.ville}"/></td> <td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
                <td><label>Code postal : </label></td>
                <td><input type="text" id="codePostal" name = "codePostal" value="${param.codePostal}"/></td>
            </tr> 
            <tr>
                <td><label>Province : </label></td>
                <td><input type="text" id="province" name = "province" value="${param.province}"/></td> <td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
                <td><label>Pays : </label></td>
                <td> <input type="text" id="pays" name = "pays" value="${param.pays}"/></td>
            </tr> 
        </table>
        <input type="submit" name="bOk" id="modificationCompteParticulier" value="Modifier"/>
        <input type="hidden" name="action" value="modifier_rph" />
        <input type="hidden" name="modifierParticulier" value="modifierParticulier" />
    </form>
</div>

