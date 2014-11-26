<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>RDM : Inscription</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<!-- <link href="./style/inscription.css" rel="stylesheet" type="text/css" /> -->
<script language="javascript" src="./js/jquery-1.9.1.min.js">
</script>
<script language="javascript">
	$(document).ready(function() {         
                 $('#hotelier').click(function() { 
                    $('.particulier').hide();
		});
                
                $('#consommmateur').click(function() { 
                    $('.particulier').show()  ;
		});
         });
</script>

</head>
<body>
<div id="main">
    	
                <form class="form2" method="POST" action="Inscription.do">
                    <span> <a class = "retour" href ="index.jsp?afficherPage=accueil">&larr; Retour </a> </span>
                   <h2>Inscription</h2>
                    <table>
                        <%
                    if (request.getAttribute("message")!=null)
                    {
                        out.println("<span class=\"errorMessage\">"+request.getAttribute("message")+"</span>");
                    }
                    %>
                    <select id="type"  name="typeCompte" > 
                            <option value="* Type de compte *">* Type de compte *</option>
                            <option value="Consommateur" id="consommateur" >Consommateur</option>
                            <option value="Hôtelier" id="hotelier" >Hôtelier</option>
                       <%-- <option value="">Administrateur</option>  --%>
                    </select> 
                    
                        <tr> 
                             <td class='particulier'> 
                            <select id="titreC" name="titre" > 
                                <option value="mr">Mr</option>
                                <option value="mme" >Mme</option>
                            </select> 
                            </td> 
                        </tr>
                        <tr>
                            <td><label>Nom : </label></td>
                            <td><input type="text" id="nom" name = "nom" placeholder="Jacques"/></td> <td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
                            <!--<td><label >Nom de l'entreprise: </label></td>
                            <td><input type="text" id="nom" name = "nomEntreprise" placeholder="Jacques"/></td> <td>&nbsp;&nbsp;&nbsp;&nbsp;</td> -->
                            <td><label class='particulier'>Prénom : </label></td>
                             <td><input type="text" id="prenom" name = "prenom" placeholder="David" class='particulier'/></td> <td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
                        </tr>
                        <tr> 
                            <td><label>E-mail : </label></td>
                           <td> <input type="email" id="username" name = "email" placeholder="ex@ex.com"/></td>
                        </tr>
                        <tr>                            
                            <td><label>Mot de passe : </label></td>
                           <td> <input type="password" id="password" name = "password" placeholder="************"/></td> <td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
                           <td><label>Confirmez : </label></td>
                            <td> <input type="password" id="password2" name = "password2" placeholder="************"/></td>
                        </tr>
                        <tr>
                            <td><label>Site web : </label></td>
                           <td> <input type="text" id="siteWeb" name = "siteWeb" placeholder="www.exemple.com"/></td>
                        </tr>
                          <tr> 
                                <td><label class='particulier' >Rue : </label </td>
                                <td><input type="text" id="rue" name = "rue" placeholder="Liébert" class='particulier'/> </td> <td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
                                <td><label class='particulier'>Ville : </label></td>
                                <td><input type="text" id="ville" name = "ville" placeholder="Montréal" class='particulier'/></td> <td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
                                <td><label class='particulier'>Code postal : </label></td>
                                <td><input type="text" id="codePostal" name = "codePostal" placeholder="L0L0L0" class='particulier'/></td>
                          </tr> 
                        <tr> 
                            <td><label class='particulier'>Province : </label></td>
                            <td><input type="text" id="province" name = "province" placeholder="Québec" class='particulier'/></td> <td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
                            <td><label class='particulier'>Pays : </label></td>
                            <td> <input type="text" id="pays" name = "pays" placeholder="Canada" class='particulier'/></td>
                        </tr> 
                         
                          <tr>
                             
                             <td><input type="submit" name="bOk" id="inscriptionbtn" value="S'inscrire"/> </td>
                             <%-- <td><input type="reset" id="annuler" value="Annuler"/></td> --%>
                          </tr>
                        </table>
                    <input type="hidden" name="action" value="inscription" />
                </form>
         
</div>
</body>
</html>