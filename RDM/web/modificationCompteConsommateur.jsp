          
<%--                             Pop up modification du compte du consommateur               
            
            <%        
                    if (session.getAttribute("connecte")!=null) //En faisant ainsi, il faut d�terminer si c'est consommateur qui est connect�
                    {                                           //Mais avec (session.getAttribute("consommateurConnecte")!=null), on sait imm�diatement qui c'est un consommateur
                       

                    %>
           --%>
           <div id="main">
                <form  class="form2"  method="POST" action="modificationConsommateur.do">
                    <span> <a class = "retour" href ="index.jsp?afficherPage=profilParticulier">&larr; Retour </a> </span>
                    <h2>Modification du compte</h2>
                    
                  <%--  <label>E-mail : </label>
                    <input type="text" id="username" name = "username" placeholder="ex@ex.com"/> --%>
                  <table>
                    <tr>
                            <td><label>Nom : </label></td>
                            <td><input type="text" id="nom" name = "nom" placeholder="Jacques"/></td> <td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
                            <td><label>Pr�nom : </label></td>
                             <td><input type="text" id="prenom" name = "prenom" placeholder="David"/></td> <td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
                        </tr>
                        <tr> 
                            <td><label>E-mail : </label></td>
                           <td> <input type="email" id="username" name = "email" placeholder="ex@ex.com"/></td>
                        </tr>
                        <tr>                            
                            <td><label>Mot de passe : </label></td>
                           <td> <input type="password" id="password" name = "password" placeholder="************"/></td> <td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
                           <td><label>Confirmez : </label></td>
                            <td> <input type="password" id="password2" name = "password2" placeholder="************"/></td>
                    </tr>
                     <tr> 
                            <td><label>Rue : </label </td>
                            <td><input type="text" id="rue" name = "rue" placeholder="Li�bert"/> </td> <td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
                            <td><label>Ville : </label></td>
                            <td><input type="text" id="ville" name = "ville" placeholder="Montr�al" /></td> <td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
                            <td><label>Code postal : </label></td>
                            <td><input type="text" id="codePostal" name = "codePostal" placeholder="L0L0L0"/></td>
                      </tr> 
                    <tr> 
                        <td><label>Province : </label></td>
                        <td><input type="text" id="province" name = "province" placeholder="Qu�bec"/></td> <td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
                        <td><label>Pays : </label></td>
                        <td> <input type="text" id="pays" name = "pays" placeholder="Canada"/></td>
                    </tr> 
                </table>
                    <input type="submit" name="bOk" id="modificationCompteConsommateur" value="Modifier"/>
                    <input type="hidden" name="action" value="modificationCompteConsommateur" />
                </form>
            </div>
            
        <%--     <%
                    }
                %> --%>