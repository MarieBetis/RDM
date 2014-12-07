

<div >

    <form class="form2" method="post" action="controleur.do" enctype="multipart/form-data">
        <h2>Publiez votre annonce</h2> 
        <table>
            <tr>
                <td>Titre de l'annonce : </td><td><input type="text" name="titre"/></td>
            </tr>
            <tr>
                <td>Date début : </td><td> <input type="text" class="datedepart" placeholder="date début" id="startDate1" ></td> <td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
                <td>Date fin : </td><td> <input type="text" class="datearrivee" placeholder="date fin"  id="endDate1" ></td>
            </tr>
            <tr>
                <td>Capacité d'accueil : </td><td> <select name="capacitemin">
                        <option value="1">1 voyageur</option>
                        <option value="2">2 voyageurs</option>
                        <option value="3">3 voyageurs</option>
                        <option value="4">4 voyageurs</option>
                        <option value="5">5 et+ voyageurs</option>
                    </select> </td>
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

