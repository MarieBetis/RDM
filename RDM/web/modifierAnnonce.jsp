
            <div class="publication">
                <h2>Modification d'annonce</h2>  
                <form method="post" action="controleur.do" enctype="multipart/form-data">
                    <table>
			<tr>
                            <td>Nouveau titre de la chambre : </td><td><input type="text" name="titre"/></td>
                        </tr>
                         <tr>
                            <td>Nouvelle date début : </td><td><input type="text" id="dateDebut" placeholder="Date dÃ©but" name="date_debut" /></td>
                        </tr>
                        <tr>
                            <td>Nouvelle date fin : </td><td><input type="text" id="dateFin" placeholder="Date de fin" name="date_fin" /></td>
                        </tr>
                        <tr>
                            <td>Nouvelle capacité d'accueil : </td><td><input type="text" name="capacite"/></td>
                        </tr>
                        <tr>
                            <td>Nouveau prix : </td><td><input type="text" name="prix"/></td>
                        </tr>
                        <tr>
                            <td>Joindre une nouvelle image : </td><td><input type="file" name="file" id="file" /> </td>
                        </tr>
                         <tr>
                            <td><input type="hidden" name="action" value="modifierAnnonce" /></td><td><input type="submit" value="Modifier" name="boutonAppliquer"/></td>
                        </tr>
                    </table>
                <form>                
            </div> 
 