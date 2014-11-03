           <%--                             Pop up modification du compte l'hôtelier               --%>
                   <%        
                    if (session.getAttribute("connecte")!=null)   
                    {  

                    %>
           
           
           
            <div id="formulaire">
                <form class="form" method="POST" action="modificationHotelier.do">
                    <img src="./images/fermer.png" class="img" id="cancel" height="35" width="35"/>
                    <h3>Modification du compte de l'hôtelier</h3>
                    <p>Entrez les nouvelles informations</p>
                    <label>E-mail : </label>
                    <input type="text" id="username" name = "username" placeholder="ex@ex.com"/>
                    <label>Mot de passe : </label>
                    <input type="password" id="password" name = "password" placeholder="************"/>
                    <label>Réentrez le mot de passe : </label>
                    <input type="password" id="password2" name = "password2" placeholder="************"/>
                    <label>Site web : </label>
                    <input type="text" id="siteWeb" name = "siteWeb" placeholder="www.exemple.com"/>
                    <label>Code postal : </label>
                    <input type="text" id="codePostal" name = "codePostal" placeholder="L0L0L0"/>
                    <label>Rue : </label>
                    <input type="text" id="rue" name = "rue" placeholder="Liébert"/>
                    <label>Ville : </label>
                    <input type="text" id="ville" name = "ville" placeholder="Montréal"/>
                    <label>Province : </label>
                    <input type="text" id="province" name = "province" placeholder="Québec"/>
                    <label>Pays : </label>
                    <input type="text" id="pays" name = "pays" placeholder="Canada"/>
                    <input type="submit" name="bOk" value="Modifier"/>
                    <input type="reset" name="cancel" value="Annuler"/>
                    <input type="hidden" name="action" value="modificationCompteHotelier" />
                </form>
            </div>
            
              <%
                    }
                %> 