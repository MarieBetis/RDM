           
<%--                             Pop up modification du compte l'hôtelier              
                   <%        
                    if (session.getAttribute("connecte")!=null)   
                    {  

                    %> --%>
           
           
           
            <div id="formulaire">
                <form class="form2" method="POST" action="modificationHotelier.do">
                    <span> <a class = "retour" href ="index.jsp?afficherPage=profilHotelier">&larr; Retour </a> </span>
                    <h2>Modification du compte</h2>
                    <table>
                    <tr>
                            <td><label>Nom : </label></td>
                            <td><input type="text" id="nom" name = "nom" placeholder="Jacques"/></td> <td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
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
                        <td><label>Site web : </label></td>
                       <td> <input type="text" id="siteWeb" name = "siteWeb" placeholder="www.exemple.com"/></td>
                    </tr>
                    </table>
                    <input type="submit" name="bOk" value="Modifier"/>
                    <input type="hidden" name="action" value="modificationCompteHotelier" />
                </form>
            </div>
            
           <%--    <%
                    }
                %> --%>