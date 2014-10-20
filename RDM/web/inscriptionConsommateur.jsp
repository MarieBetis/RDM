           <%--                             Pop up Inscription du cosommateur              --%>
            <div id="inscriptionCosommateurDiv">
                <form class="form" method="POST" action="inscription.do" id="inscription">
                    <img src="./images/fermer.png" class="img" id="cancel" height="35" width="35"/>
                    <h3>Inscription du consommateur</h3>
                    <label>E-mail : </label>
                    <input type="text" id="username" name = "username" placeholder="ex@ex.com"/>
                    <label>Mot de passe : </label>
                    <input type="password" id="password" name = "password" placeholder="************"/>
                    <label>Nom : </label>
                    <input type="text" id="nom" name = "nom" placeholder="Bruno"/>
                    <label>Prénom : </label>
                    <input type="text" id="prenom" name = "prenom" placeholder="David"/>
                    <label>Sexe : </label>
                    <input type="text" id="sexe" name = "sexe" placeholder="Masculin"/>
				    <label>Rue : </label>
                    <input type="text" id="rue" name = "rue" placeholder="Liébert"/>
                    <label>Ville : </label>
                    <input type="text" id="ville" name = "ville" placeholder="Montréal"/>
                    <label>Province : </label>
                    <input type="text" id="province" name = "province" placeholder="Québec"/>
                    <label>Pays : </label>
                    <input type="text" id="pays" name = "pays" placeholder="Canada"/>
                    <input type="submit" name="bOk" id="inscriptionbtn" value="Inscription"/>
                    <input type="button" id="cancel" value="Annuler"/>
                    <input type="hidden" name="action" value="InscriptionConsommateur" />
                </form>
            </div>
            
            