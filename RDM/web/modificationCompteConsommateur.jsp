           <%--                             Pop up modification du compte du consommateur               --%>
            
            <%        
                    if (session.getAttribute("connecte")!=null) //En faisant ainsi, il faut déterminer si c'est consommateur qui est connecté
                    {                                           //Mais avec (session.getAttribute("consommateurConnecte")!=null), on sait immédiatement qui c'est un consommateur
                       

                    %>
           
           <div id="formulaire">
                <form class="form" method="POST" action="modificationConsommateur.do">
                    <img src="./images/fermer.png" class="img" id="cancel" height="35" width="35"/>
                    <h3>Modification du compte du consommateur</h3>
                    <p>Entrez les nouvelles informations</p>
                    <label>E-mail : </label>
                    <input type="text" id="username" name = "username" placeholder="ex@ex.com"/>
                    <label>Mot de passe : </label>
                    <input type="password" id="password" name = "password" placeholder="************"/>
                    <label>Réentrez le mot de passe : </label>
                    <input type="password" id="password2" name = "password2" placeholder="************"/>
                    <label>Site web : </label>
                    <input type="text" id="siteWeb" name = "siteWeb" placeholder="www.ex.com"/>
                    <label>Code postal : </label>
                    <input type="text" id="codePostal" name = "codePostal" placeholder="L0L0L0"/>
                    <label>Rue : </label>
                    <input type="text" id="rue" name = "rue" placeholder="LiÃ©bert"/>
                    <label>Ville : </label>
                    <input type="text" id="ville" name = "ville" placeholder="MontrÃ©al"/>
                    <label>Province : </label>
                    <input type="text" id="province" name = "province" placeholder="QuÃ©bec"/>
                    <label>Pays : </label>
                    <input type="text" id="pays" name = "pays" placeholder="Canada"/>
                    <input type="submit" name="bOk" id="modificationCompteConsommateur" value="Modifier"/>
                    <input type="reset" name="cancel" value="Annuler"/>
                    <input type="hidden" name="action" value="modificationCompteConsommateur" />
                </form>
            </div>
            
             <%
                    }
                %> 