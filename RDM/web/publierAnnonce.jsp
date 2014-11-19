
            <div class="publication">
                <h2>Publiez votre annonce</h2>  
                  <form method="post" action="controleur.do" enctype="multipart/form-data">
                    <table>
			<tr>
                            <td>Titre de la chambre : </td><td><input type="text" name="titre"/></td>
                        </tr>
                         <tr>
                            <td>Date début : </td><td><input type="text" id="dateDebut" placeholder="Date dÃ©but" name="date_debut" /></td>
                        </tr>
                        <tr>
                            <td>Date fin : </td><td><input type="text" id="dateFin" placeholder="Date de fin" name="date_fin" /></td>
                        </tr>
                        <tr>
                            <td>Capacité d'accueil : </td><td><input type="text" name="capacite"/></td>
                        </tr>
                        <tr>
                            <td>Prix : </td><td><input type="text" name="prix"/></td>
                        </tr>
                        <tr>
                            <td>Joindre image : </td><td><input type="file" name="file" id="file" /> </td>
                        </tr>
                         <tr>
                            <td><input type="hidden" name="action" value="publierAnnonce" /></td><td><input type="submit" value="Appliquer" name="boutonAppliquer"/></td>
                        </tr>
                    </table>
                <form>                
            </div> 
  
 