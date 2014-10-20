
            <div class="publication">
                <h2>Publiez votre annonce</h2>  
                <form method="post" action="controleur.do" enctype="multipart/form-data">
                    <table>
			<tr>
                            <td>Titre de la chambre : </td><td><input type="text" name="titreChambre"/></td>
                        </tr>
                         <tr>
                            <td>Date début : </td><td><input type="text" id="dateDebut" placeholder="Date début" /></td>
                        </tr>
                        <tr>
                            <td>Date fin : </td><td><input type="text" id="dateFin" placeholder="Date de fin" /></td>
                        </tr> 
                        <tr>
                            <td>Codre de l'offre : </td><td><input type="text" name="codeOffre"/></td>
                        </tr>
                        <tr>
                            <td>Capacité d'accueil : </td><td><input type="text" name="capaciteAccueil"/></td>
                        </tr>
                        <tr>
                            <td>Prix : </td><td><input type="text" name="prix"/></td>
                        </tr>
                        <tr>
                            <td>Joindre image : </td><td><input type="file" name="file" id="file" /> </td>
                        </tr>
                         <tr>
                            <td></td><td><input type="submit" value="Appliquer" name="boutonAppliquer"/></td>
                        </tr>
                    </table>
                <form>                
            </div> 
 