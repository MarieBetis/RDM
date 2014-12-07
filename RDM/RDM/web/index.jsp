
<%-- 
    Document   : index
    Created on : 2014-10-07, 13:16:46
    Author     : usager
--%>

<%@page import="com.rdm.modele.Particulier"%>
<%@page import="com.rdm.DAO.implementation.HotelierDAO"%>
<%@page import="com.rdm.DAO.implementation.ParticulierDAO"%>
<%@page import="com.rdm.DAO.implementation.MembreDAO"%>
<%@page import="com.rdm.util.Connexion"%>
<%@page import="com.rdm.modele.Membre"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>RDM - Accueil</title>
        <link rel="stylesheet" href="style/jquery_popup.css" />
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
        <script src="jquery_popup.js"></script>
        <link rel="stylesheet" href="//code.jquery.com/ui/1.11.1/themes/smoothness/jquery-ui.css">

        <script src="//code.jquery.com/jquery-1.10.2.js"></script>
        <script src="//code.jquery.com/ui/1.11.1/jquery-ui.js"></script>
        <script>
            $(function() {
                $(".datearrivee").datepicker();
                $(".datedepart").datepicker();
            });
        </script>
        
              
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<!-- <link href="./style/inscription.css" rel="stylesheet" type="text/css" /> -->
<script language="javascript" src="./js/jquery-1.9.1.min.js">
</script>
        <script language="javascript">
            $(document).ready(function() {
                $('#hotelier').click(function() {
                    $('.particulier').hide();
                    $('.idSiteweb').show();
                });

                $('#particulier').click(function() {
                    $('.particulier').show();
                    $('.idSiteweb').hide();
                });
            });
        </script>



    </head>
    <body>

        <div id="main"> 
            <header> 
                <span id = "ti"> 
                    <span id = "titre" > <a class = "retour" href ="index.jsp?afficherPage=accueil"><img src="images/1.png" height="45" width="45"/>RDM</a></span> 
                    <span> Réservation dès maintenant </span>
                </span>

                <span id = "button">
                    <%--  <a href=" " id="onclick">Connexion</a> --%>
                    <%
                        if (session.getAttribute("connecte") != null) {

                            out.println("<span class=\"resultat\">" + ((Membre) request.getSession().getAttribute("connecte")).toString()
                                    + "</span>    <a href=\"logout.do?action=logout\">Déconnexion</a>");

                            if (((Membre) request.getSession().getAttribute("connecte")).getType().equalsIgnoreCase("Hotelier")) {

                    %>

                    <a href="index.jsp?afficherPage=publierAnnonce"><input type="submit" class ="b" value = "Publier une annonce"/></a>
                    <a href="index.jsp?afficherPage=profilHotelier"><input type="submit" class ="b" value = "Votre profil"/></a>
                        <%                        }

                            if (((Membre) request.getSession().getAttribute("connecte")).getType().equalsIgnoreCase("Particulier")) {

                        %> 
                    <a href="index.jsp?afficherPage=profilParticulier"><input type="submit" class ="b" value = "Votre profil"/></a>

                    <%                        }
                    } else {
                    %>

                    <input class ="b" id="onclick" type="submit" value = "Connexion"/>
                    <a href="index.jsp?afficherPage=inscription"><input type="submit" class ="b" value = "Inscription"/></a>


                    <% }%>
                </span>
            </header>

            <div id ="recherche">
                <form action="rechercher.do" method="POST">
                    <input type="text" id = "dest" name="ville" placeholder="ville" value="${param.ville}"> 
                    <%--   <select name="ville" value="${param.ville}">
                           <option value="">Ville</option>
                      </select>--%> 
                    <input type="text" class ="datearrivee" placeholder="Date d'arrivée"   name="datedebut" value="${param.datedebut}">
                    <input type="text" class ="datedepart" placeholder="Départ" name="datefin" value="${param.datefin}">

                    <select name="capacitemin" value="${param.capacitemin}">
                        <option value="1">1 voyageur</option>
                        <option value="2">2 voyageurs</option>
                        <option value="3">3 voyageurs</option>
                        <option value="4">4 voyageurs</option>
                        <option value="5">5 et+ voyageurs</option>
                    </select> 
                    <%--<input class ="b" type="submit" value="Rechercher"> 
                    <input type="hidden" name="action" value="resultat" />
                    <a class = "b" href="index.jsp?afficherPage=afficherResultat">Rechercher</a>--%>
                    <input type="hidden" name="action" value="rechercher" />
                    <input class ="b" type="submit" value="Rechercher">
                </form> 
                <%
                    if (request.getAttribute("message") != null) {
                        out.println("<label class=\"errorMessage\">" + request.getAttribute("message") + "</label>");
                    }
                %>
            </div>

            <%--                             Pop up Login               --%>
            <div id="logindiv">
                <form class="form" method="POST"  id="login">
                    <img src="./images/fermer.png" class="img" id="cancel" height="35" width="35"/>
                    <h3>Connexion</h3>
                    <%--   <select id ="typeConnection" name="typeConnection" > 
                               <option value="Type de Connexion">Type de Connexion</option>
                               <option value="Consommateur">Consommateur</option>
                               <option value="">Hôtelier</option>
                           <option value="">Administrateur</option>  
                       </select> 
                       </br>--%>
                    <%--  <%
                     if (request.getAttribute("message")!=null)
                     {
                         out.println("<label class=\"errorMessage\">"+request.getAttribute("message")+"</label>");
                     }
                     %><%--  --%>
                    <label>E-mail : </label>
                    <input type="text" id="username" name = "email" placeholder="ex@ex.com"/>
                    <label>Mot de passe : </label>
                    <input type="password" id="password" name = "motdepasse" placeholder="************"/>
                    <input type="submit" name="bOk" id="loginbtn" value="Connexion"/>
                    <input type="button" id="cancel" value="Annuler"/>
                    <input type="hidden" name="action" value="login" />
                </form>
            </div>
            <%--                           Fin Pop up Login               --%>



            <div id="centre">
                <%
                    if (request.getParameter("afficherPage") == null) {
                %>
                <jsp:include page="accueil.jsp" />
                <%
                } else {
                    String afficherPage = (String) request.getParameter("afficherPage");
                    if ("accueil".equals(afficherPage)) {
                %>
                <jsp:include page="accueil.jsp" />
                <%
                    }
                    if ("inscription".equals(afficherPage)) {
                %>
                <jsp:include page="inscription.jsp" />
                <%
                    }
                    if ("afficherResultat".equals(afficherPage)) {
                %>
                <jsp:include page="afficherResultat.jsp" />
                <%
                    }
                    if ("publierAnnonce".equals(afficherPage)) {
                %>
                <jsp:include page="publierAnnonce.jsp" />
                <%
                    }
                    if ("afficherUneAnnonce".equals(afficherPage)) {
                %>
                <jsp:include page="afficherUneAnnonce.jsp" />
                <%
                    }

                    if ("pageReservation".equals(afficherPage)) {
                %>
                <jsp:include page="pageReservation.jsp" />
                <%
                    }

                    if ("profilHotelier".equals(afficherPage)) {
                %>
                <jsp:include page="profilHotelier.jsp" />
                <%
                    }
                    if ("profilParticulier".equals(afficherPage)) {
                %>
                <jsp:include page="profilParticulier.jsp" />
                <%
                    }
                    if ("modificationCompteParticulier".equals(afficherPage)) {
                %>
                <jsp:include page="modificationCompteParticulier.jsp" />
                <%
                    }
                    if ("modificationCompteHotelier".equals(afficherPage)) {
                %>
                <jsp:include page="modificationCompteHotelier.jsp" />
                <%
                    }
                    if ("modificationAnnonce".equals(afficherPage)) {
                %>
                <jsp:include page="modificationAnnonce.jsp" />
                <%
                    }
                    if ("modificationReservation".equals(afficherPage)) {
                %>
                <jsp:include page="modificationReservation.jsp" />
                <%
                        }

                    }
                %>
            </div>
            <div id="footer">
                &copy; 2014 David Bruno-Renaud Beauchemin-Mohamed Bouguedoura-Marie Betis. Tous droits réservés.
            </div>
        </div>
        <!-- Script pour pop up -->
        <script type="text/javascript">
            $(document).ready(function() {
                //setTimeout(popup, 3000);
                function popup() {
                    $("#logindiv").css("display", "block");
                }

                $("#login #cancel").click(function() {
                    $(this).parent().parent().hide();
                });

                $("#onclick").click(function() {
                    $("#logindiv").css("display", "block");
                });

                $("#contact #cancel").click(function() {
                    $(this).parent().parent().hide();
                });



                // Contact form popup send-button click event.
                $("#send").click(function() {
                    var name = $("#name").val();
                    var email = $("#email").val();
                    var contact = $("#contactno").val();
                    var message = $("#message").val();
                    if (name == "" || email == "" || contactno == "" || message == "") {
                        alert("Please Fill All Fields");
                    } else {
                        if (validateEmail(email)) {
                            $("#contactdiv").css("display", "none");
                        } else {
                            alert('Invalid Email Address');
                        }
                        function validateEmail(email) {
                            var filter = /^[\w\-\.\+]+\@[a-zA-Z0-9\.\-]+\.[a-zA-z0-9]{2,4}$/;
                            if (filter.test(email)) {
                                return true;
                            } else {
                                return false;
                            }
                        }
                    }
                });
                // Login form popup login-button click event.
                $("#loginbtn").click(function() {
                    var name = $("#username").val();
                    // var typeConnection = $("#typeConnection").val();
                    var password = $("#password").val();
                    var msg = $(".errorMessage").val();
                    if (name == "" || password == "") {
                        alert("E-mail ou mot de passe invalide");
                    }
                    /*Vérification du type de compte  if (typeConnection == "Type de Connexion"){
                     alert("Type de Connexion invalide");
                     }*/
                    else {

                        var elementsWithClass = document.getElementsByClassName('form');
                        elementsWithClass[0].action = "login.do";



                    }
                });
            });
        </script>

    </body>
</html>
