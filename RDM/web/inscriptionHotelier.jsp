           <%--                             Pop up Inscription de l'hôtelier               --%>
            <div id="inscriptionHotelierDiv">
                <form class="form" method="POST" action="inscription.do">
                    <img src="./images/fermer.png" class="img" id="cancel" height="35" width="35"/>
                    <h3>Inscription de l'hotelier</h3>
                    <label>E-mail : </label>
                    <input type="text" id="username" name = "username" placeholder="ex@ex.com"/>
                    <label>Mot de passe : </label>
                    <input type="password" id="password" name = "password" placeholder="************"/>
                    <label>R�entrez le mot de passe : </label>
                    <input type="password" id="password2" name = "password2" placeholder="************"/>
                    <label>Site web : </label>
                    <input type="text" id="siteWeb" name = "siteWeb" placeholder="www.exemple.com"/>
                    <label>Code postal : </label>
                    <input type="text" id="codePostal" name = "codePostal" placeholder="L0L0L0"/>
                    <label>Rue : </label>
                    <input type="text" id="rue" name = "rue" placeholder="Li�bert"/>
                    <label>Ville : </label>
                    <input type="text" id="ville" name = "ville" placeholder="Montr�al"/>
                    <label>Province : </label>
                    <input type="text" id="province" name = "province" placeholder="Qu�bec"/>
                    <label>Pays : </label>
                    <input type="text" id="pays" name = "pays" placeholder="Canada"/>
                    <input type="submit" name="bOk" id="inscriptionbtn" value="S'inscrire"/>
                    <input type="reset" id="cancel" value="Annuler"/>
                    <input type="hidden" name="action" value="InscriptionHotelier" />
                </form>
            </div>
            
            