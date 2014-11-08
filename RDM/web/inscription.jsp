<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>RDM : Inscription</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<link href="./style/inscription.css" rel="stylesheet" type="text/css" />
<script language="javascript" src="./js/jquery-1.9.1.min.js">
</script>
<script language="javascript">
	$(document).ready(function() {         
                 $('#h').click(function() { 
                    $('.particulier').hide();
		});
                
                $('#c').click(function() { 
                    $('.particulier').show()  ;
		});
         });
</script>

</head>
<body>
<div id="main">
    <div id="inscription">
                <form class="form" method="POST" action="inscription.do">
                   <h3>Inscription</h3>
                    <select name="typeConnection" > 
                            <option value="">Type de Connexion</option>
                            <option value="" id="c" >Consommateur</option>
                            <option value="" id="h" >Hôtelier</option>
                       <%-- <option value="">Administrateur</option>  --%>
                    </select> 
                    <table>
                        <tr>
                            <td><label class='particulier'>Nom : </label></td>
                            <td><input type="text" id="nom" name = "nom" placeholder="Jacques" class='particulier'/></td>
                        </tr>
                         <tr>
                             <td><label class='particulier'>Prénom : </label></td>
                             <td><input type="text" id="prenom" name = "prenom" placeholder="David" class='particulier'/></td>
                         </tr>
                        <tr>
                             <td><label class='particulier'>Sexe : </label> </td>
                            <td> <input type="text" id="sexe" name = "sexe" placeholder="Masculin" class='particulier'/> </td>
                        </tr>
                        <tr>
                            <td><label>E-mail : </label></td>
                           <td> <input type="text" id="username" name = "username" placeholder="ex@ex.com"/></td>
                        </tr>
                        <tr>                            
                            <td><label>Mot de passe : </label></td>
                           <td> <input type="password" id="password" name = "password" placeholder="************"/></td>
                        </tr>
                         <tr>    
                             <td><label>Réentrez le mot de passe : </label></td>
                            <td> <input type="password" id="password2" name = "password2" placeholder="************"/></td>
                        </tr> 
                        <tr>
                            <td><label>Site web : </label></td>
                           <td> <input type="text" id="siteWeb" name = "siteWeb" placeholder="www.exemple.com"/></td>
                        </tr>
                         <tr>   
                             <td><label>Code postal : </label></td>
                            <td><input type="text" id="codePostal" name = "codePostal" placeholder="L0L0L0"/></td>
                        </tr>
                          <tr> 
                               <td><label>Rue : </label </td>
                                 <td><input type="text" id="rue" name = "rue" placeholder="Liébert"/> </td>
                          </tr> 
                         <tr> 
                             <td><label>Ville : </label></td>
                            <td><input type="text" id="ville" name = "ville" placeholder="Montréal"/></td>
                         </tr> 
                        <tr> 
                            <td><label>Province : </label></td>
                            <td><input type="text" id="province" name = "province" placeholder="Québec"/></td>
                        </tr> 
                        <tr> 
                            <td><label>Pays : </label></td>
                            <td> <input type="text" id="pays" name = "pays" placeholder="Canada"/></td>
                        </tr> 
                         
                          <tr>
                             <td><input type="hidden" name="action" value="inscription" /> </td>
                             <td><input type="reset" id="annuler" value="Annuler"/></td>
                          </tr>
                        <tr>
                             <td> </td>
                               <td><input type="submit" name="bOk" id="inscriptionbtn" value="S'inscrire"/> </td>
                         </tr>
                        
                        </table>
                
                </form>
            </div>
            
 

</div>
</body>
</html>

