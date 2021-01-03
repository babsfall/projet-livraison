
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:h="http://xmlns.jcp.org/jsf/html"
      xmlns:ui="http://xmlns.jcp.org/jsf/facelets">
<div class="navbar navbar-nav navbar-fixed-top" style="background-color:  whitesmoke;">
<!--    <a class="navbar-brand "  href="./" style=""> <img src="listestrap/res/log.png" class="img-circle" alt="logo" height="28" /></a>-->
    <div class="container" style="background-color: #111; margin-top: 10px;  border-radius: 10px" >

        <button type="button"  class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </button>
        <a class="navbar-brand "  href="#" style=""> 
            <img src="listestrap/res/LOGO.png" class="" alt="logo" width="70" height="26" />
        </a>
        <div class="navbar-collapse collapse">

<!--            <ul class="nav navbar-nav">
                <li><a href="./index.jsp" title="Accueil"> <samp class="glyphicon glyphicon-home"> </samp> Accueil</a></li> 

            </ul> -->
 

           <ul class="nav navbar-nav navbar-right">
                <li class="dropdown">
                  <a  href="#" class="dropdown-toggle" style="color: white" data-toggle="dropdown">  <b class="caret"></b></a>
                  <ul class="dropdown-menu">
                      <li>
                          
                          <a href="./view/action/deconnexion.jsp">Deconnexion</a></li>
                      <li><a href="./Index.xhtml">Changer mon mot de passe</a></li>
                  </ul>
                </li>
             
              
                  
                <li class="dropdown">
                  <a  href="#" class="dropdown-toggle" style="color: white" data-toggle="dropdown"> <span class="glyphicon glyphicon-file"></span>  Contrat <b class="caret"></b></a>
                  <ul class="dropdown-menu">
                      <li><a href="./IndexContrats.jsp"> Nouveau Contrat </a></li>
                      <li><a href="./IndexListeContrat.jsp">Liste contrats</a></li>
                               
                  </ul>
                </li>
                <li class="dropdown">
                  <a  href="#" class="dropdown-toggle" style="color: white" data-toggle="dropdown"> <span class="glyphicon glyphicon-cog"> </span> Suivi <b class="caret"></b></a>
                  <ul class="dropdown-menu">
                        <li><a href="./IndexSuivi.jsp"> Nouvel approvisionnement </a></li>
                        <li><a href="./IndexListeSuivi.jsp"> Suivi Clients </a></li>
                        <li><a href="./IndexListeSolde.jsp"> Soldes Clients </a></li>
                        <li><a href="./IndexListeRappels.jsp"> Rappels </a></li>
                        
                 
                  </ul>
                </li>
               <script>
               function showMenu(){
			PF('tieredMenu').show();
		}
		function hideMenu(){
			PF('tieredMenu').hide();
		}
                </script>
               
                 <li class="dropdown" >
                  <a  href="#" class="dropdown-toggle" style="color: white" data-toggle="dropdown"> <span class="glyphicon glyphicon-cog"> </span> Administration <b class="caret"></b></a>
                  <ul class="dropdown-menu">
                        <li><a href="./IndexAjoutUtilisateur.jsp"> Nouvel utilisateur </a></li>
                        <li><a href="./IndexListeUtilisateur.jsp"> Liste utilisateurs </a></li>
                        <!--<li><a href="./IndexListeSolde.jsp"> Soldes Clients </a></li>-->
                 
                  </ul>
                </li>
                <li class="dropdown">
                    <!--<a  href="#" class="dropdown-toggle" style="color: white" data-toggle="dropdown"> <span class="glyphicon glyphicon-user img-circle"> </span> DAKI Barrigah <b class="caret"></b></a> -->
                  <form style="max-width: 250px; margin-top: 12px" method="POST" action="./index.jsp">
                            
                        </form>
                                    
                </li>                
                
                
              
                
            </ul> 
            
          
        </div>
    </div> 

</div>  
       </html>