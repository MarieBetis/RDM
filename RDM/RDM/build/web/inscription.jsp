<form class="form2" method="POST" action="Inscription.do">
    <span> <a class = "retour" href ="index.jsp?afficherPage=accueil">&larr; Retour </a> </span>
    <h2>Inscription</h2>
    <table>
        <%
            if (request.getAttribute("message") != null) {
                out.println("<span class=\"errorMessage\">" + request.getAttribute("message") + "</span>");
            }
        %>
        <select id="type"  name="type" > 
            <option value="* Type de compte *">* Type de compte *</option>
            <option value="particulier" id="particulier" >Particulier</option>
            <option value="hotelier" id="hotelier" >Hôtelier</option>
        </select> 

        <tr> 
            <td class='particulier'> 
                <select id="titre" name="titre" > 
                    <option value="mr">Mr</option>
                    <option value="mme" >Mme</option>
                </select> 
            </td> 
        </tr>
        <tr>
            <td><label>Nom : </label></td>
            <td><input type="text" id="nom" name = "nom" placeholder="Jacques"/></td> <td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
        <td><label class='particulier'>Prénom : </label></td>
            <td><input type="text" id="prenom" name = "prenom" placeholder="David" class='particulier'/></td> <td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
        </tr>
        <tr> 
            <td><label>E-mail : </label></td>
            <td> <input type="email" id="username" name = "email" placeholder="ex@ex.com"/></td>
        </tr>
        <tr>                            
            <td><label>Mot de passe : </label></td>
            <td> <input type="password" id="password" name = "motdepasse" placeholder="************"/></td> <td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
            <td><label>Confirmez : </label></td>
            <td> <input type="password" id="password2" name = "motdepasse2" placeholder="************"/></td>
        </tr>
        <tr>
            <td><label class='idSiteweb' >Site web : </label></td>
            <td> <input type="text" name = "siteweb" class='idSiteweb' placeholder="www.exemple.com"/></td>
        </tr>
        <tr> 
            <td><label class='particulier' >Rue : </label </td>
            <td><input type="text" id="rue" name = "rue" placeholder="Liébert" class='particulier'/> </td> <td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
            <td><label class='particulier'>Ville : </label></td>
            <td><input type="text" id="ville" name = "ville" placeholder="Montréal" class='particulier'/></td> <td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
            <td><label class='particulier'>Code postal : </label></td>
            <td><input type="text" id="codePostal" name = "codePostal" placeholder="L0L0L0" class='particulier'/></td>
        </tr> 
        <tr> 
            <td><label class='particulier'>Province : </label></td>
            <td><input type="text" id="province" name = "province" placeholder="Québec" class='particulier'/></td> <td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
            <td><label class='particulier'>Pays : </label></td>
            <td> <input type="text" id="pays" name = "pays" placeholder="Canada" class='particulier'/></td>
        </tr> 

        <tr>

            <td><input type="submit" name="bOk" id="inscriptionbtn" value="S'inscrire"/> </td>
                <%-- <td><input type="reset" id="annuler" value="Annuler"/></td> --%>
        </tr>
    </table>
    <input type="hidden" name="action" value="inscription" />
</form>
