<%-- 
    Document   : login
    Created on : 2014-10-10, 19:20:53
    Author     : David
--%>


<%
    if ((session.getAttribute("hotelierConnecte")!=null) || (session.getAttribute("consommateurConnecte")!=null)) //hôtelier ou cosommateur est déjà connecté
    {
%>
        <jsp:forward page="index.jsp" />
<%
    }
     if (request.getAttribute("message")!=null)
        {
            out.println("<span class=\"errorMessage\">"+request.getAttribute("message")+"</span>");
        }
        String  us1 = request.getParameter("userEmail");
        if (us1==null) us1="";
        else us1 = us1.trim();
        %>


<div class="login">
    <h1>Connexion</h1>
    <form action="controleur.do" method="post">
        <table>
            <tr>
                <td>
                    
                </td>
                <td><label>
                        <select name="typeConnection"> 
                            <option value="">Type de Connexion</option>
                            <option value="">Consommateur</option>
                            <option value="">Hôtelier</option>
                       <%-- <option value="">Administrateur</option>  --%>
                        </select>
                    </label></td>
            </tr>
            <tr>
                <td><label>Adresse e-mail : </label></td><td><input type="text" name="userEmail" value="<%=us1%>" /></td>
            </tr>
            <tr>
                <td><label>Mot de passe : </label></td><td><input type="password" name="password" /></td>
            </tr>
            <tr>
                <td><input type="hidden" name="action" value="login" /></td><td><input type="submit" value="Connexion" /></td>
            <tr>
        </table>
    </form>
</div>
