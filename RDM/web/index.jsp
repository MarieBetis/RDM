<%-- 
    Document   : index
    Created on : 2014-10-07, 13:16:46
    Author     : usager
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        $( "#datearrivee" ).datepicker();
        $( "#datedepart" ).datepicker();
        });
        </script>
    </head>
    <body>
         
        <div id="main"> 
            <header> 
                <span id = "ti"> 
                    <span id = "titre" > <img src="images/1.png" height="45" width="45">RDM</span> 
                    <span> Réservation dès maintenant </span>
                </span>
               
                <span id = "button">
                   <%--  <a href=" " id="onclick">Connexion</a> --%>
                   <%        
                    if (session.getAttribute("connecte")!=null)
                    {
                        out.println("<span class=\"resultat\">"+session.getAttribute("connecte")+
                                    "</span>    <a href=\"logout.do?action=logout\">Déconnexion</a>");

                    %>
                     <%
                    if (request.getAttribute("message")!=null)
                    {
                        out.println("<span class=\"errorMessage\">"+request.getAttribute("message")+"</span>");
                    }
                    String  us1 = request.getParameter("username");
                    if (us1==null) us1="";
                           else us1 = us1.trim();
                    %>
                    
                    <input type="submit" class ="b" value = "Publier une annonce"/>
                    <%
                          }  
                    else
                    {
                    %>
                    
                    <input class ="b" id="onclick" type="submit" value = "Connexion"/>
                    <% }%>
                </span>
            </header>
            
            <%--                             Pop up Login               --%>
            <div id="logindiv">
                <form class="form" method="POST" action="login.do" id="login">
                    <img src="./images/fermer.png" class="img" id="cancel" height="35" width="35"/>
                    <h3>Connexion</h3>
                    <select name="typeConnection" > 
                            <option value="">Type de Connexion</option>
                            <option value="">Consommateur</option>
                            <option value="">Hôtelier</option>
                       <%-- <option value="">Administrateur</option>  --%>
                    </select> 
                    </br>
                    <label>E-mail : </label>
                    <input type="text" id="username" name = "username" placeholder="ex@ex.com"/>
                    <label>Mot de passe : </label>
                    <input type="password" id="password" name = "password" placeholder="************"/>
                    <input type="submit" name="bOk" id="loginbtn" value="Connexion"/>
                    <input type="button" id="cancel" value="Annuler"/>
                    <input type="hidden" name="action" value="login" />
                </form>
            </div>
            <%--                           Fin Pop up Login               --%>
            
            
            <div id="centre">
                <%
                    String vue = request.getParameter("vue");
                    if (vue != null) 
                    {
                        vue = vue+".jsp";
                %>
                <jsp:include page="<%=vue%>" />
                <%                    
                    }
                    else
                    {
                %>
                <div id ="recherche">
                <form action="" method="get">
                    <input type="text" id = "dest" name="destination" placeholder="Destination">
                    <input type="text" id="datearrivee" placeholder="Arrivée">
                    <input type="text" id="datedepart" placeholder="Depart">
                    <select>
                        <option value="un">1 voyageur</option>
                        <option value="deux">2 voyageurs</option>
                        <option value="trois">3 voyageurs</option>
                        <option value="quatres">4 voyageurs</option>
                        <option value="cinq">5 et+ voyageurs</option>
                    </select> 
                    <input class ="b" type="submit" value="Rechercher">
                </form> 
            </div>
            <div id="annonces" align="center">
                <h2>Annonces disponibles</h2>
                <div classe ="blocs">
                    <div classe = "annonces">
                        <figure class="dessin">
                            <img src="./images/chambre.jpg" alt="" height="200" width="200"/>
                            <figcaption>Légende associée</figcaption>
                         </figure>
                        <figure class="dessin">
                             <img src="./images/chamb.jpg" alt="" height="200" width="200"/>
                            <figcaption>Légende associée</figcaption>
                         </figure>
                        <figure class="dessin">
                             <img src="./images/ch.jpg" alt="" height="200" width="200"/>
                            <figcaption>Légende associée</figcaption>
                         </figure>
                    </div>
                    <div classe = "annonces">
                        <figure class="dessin2">
                            <img src="./images/chamb.jpg" alt="" height="200" width="200"/>
                            <figcaption>Légende associée</figcaption>
                         </figure>
                        <figure class="dessin2">
                             <img src="./images/chambre.jpg" alt="" height="200" width="200"/>
                            <figcaption>Légende associée</figcaption>
                         </figure>
                        <figure class="dessin2">
                             <img src="./images/cham.jpg" alt="" height="200" width="200"/>
                            <figcaption>Légende associée</figcaption>
                         </figure>
                    </div> 
                </div>
            </div>
                <%
                    }
                %>
            </div>
            <div id="footer">
                &copy; 2014 David Bruno-Renaud Beauchemin-Mohamed Bouguedoura-Marie Betis. Tous droits réservés.
            </div>
        </div>
            
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
                    if (name == "" || email == "" || contactno == "" || message == ""){
                    alert("Please Fill All Fields");
                    }else{
                        if (validateEmail(email)) {
                        $("#contactdiv").css("display", "none");
                        }else {
                        alert('Invalid Email Address');
                        }
                        function validateEmail(email) {
                        var filter = /^[\w\-\.\+]+\@[a-zA-Z0-9\.\-]+\.[a-zA-z0-9]{2,4}$/;
                        if (filter.test(email)) {
                        return true;
                        }else {
                        return false;
                        }
                        }
                        }
                });
            // Login form popup login-button click event.
                $("#loginbtn").click(function() {
                var name = $("#username").val();
                var password = $("#password").val();
                if (username == "" || password == ""){
                alert("E-mail ou mot de passe invalide");
                }else{
                $("#logindiv").css("display", "none");
                }
                });
            });
        </script>
            
    </body>
</html>
