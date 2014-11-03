           <%--                             Pop up Inscription du cosommateur              --%>
            <div id="formulaire">
                <form class="form" method="POST" action="inscription.do">
                    <img src="./images/fermer.png" class="img" id="cancel" height="35" width="35"/>
                    <h3>Inscription du consommateur</h3>
                    <label>E-mail : </label>
                    <input type="text" id="username" name = "username" placeholder="ex@ex.com"/>
                    <label>Mot de passe : </label>
                    <input type="password" id="password" name = "password" placeholder="************"/>
                    <label>Réentrez le mot de passe : </label>
                    <input type="password" id="password2" name = "password2" placeholder="************"/>
                    <label>Nom : </label>
                    <input type="text" id="nom" name = "nom" placeholder="Bruno"/>
                    <label>Prénom : </label>
                    <input type="text" id="prenom" name = "prenom" placeholder="David"/>
                    <label>Sexe : </label>
                    <input type="text" id="sexe" name = "sexe" placeholder="Masculin"/>
				    <label>Rue : </label>
                    <input type="text" id="rue" name = "rue" placeholder="LiÃ©bert"/>
                    <label>Ville : </label>
                    <input type="text" id="ville" name = "ville" placeholder="MontrÃ©al"/>
                    <label>Province : </label>
                    <input type="text" id="province" name = "province" placeholder="QuÃ©bec"/>
                    <label>Pays : </label>
                    <input type="text" id="pays" name = "pays" placeholder="Canada"/>
                    <input type="submit" name="bOk" id="inscriptionbtn" value="S'inscrire"/>
                    <input type="reset" id="cancel" value="Annuler"/>
                    <input type="hidden" name="action" value="InscriptionConsommateur" />
                </form>
            </div>
            
            