
            <div >
                 
                  <form class="form2" method="post" action="controleur.do" enctype="multipart/form-data">
                      <h2>Publiez votre annonce</h2> 
                    <table>
			<tr>
                            <td>Titre de l'annonce : </td><td><input type="text" name="titre"/></td>
                        </tr>
                         <tr>
                             <td>Date d�but : </td><td><input type="text" class="datearrivee" name="date_debut" /></td> <td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
                            <td>Date fin : </td><td><input type="text" class ="datedepart" name="date_fin" /></td>
                         </tr>
                        <tr>
                            <td>Capacit� d'accueil : </td><td><input type="text" name="capacite"/></td>
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
                </form>                
            </div> 
  
 