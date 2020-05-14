<%@taglib uri="/WEB-INF/tld/c.tld" prefix="c" %>
<%@page import="org.formation.zoo.service.CagePOJO"%>
<%@page import="java.util.List"%>
<%@ page import="org.formation.zoo.controleur.Manager" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		
		<title>Bienvenue DANS le ZOO</title>
		<link rel="stylesheet" type="text/css" href="style.css"></link>
	</head>
	
	<body>
		<header>
			<img class="logoGauche" alt="" src="images/logo.png"/>
			<img class="logoDroit" alt="" src="images/logo.png"/><p>Le zoo en folie</p>
		</header>

		<form id="forme" name="fzoo" action="devorer" method="GET">
			<nav>
				<ul class="m">
					<li class="m"><a href="manger">TOUT le monde mange (defaut)</a></li>
					<li class="m"><a href="#" onClick="fzoo.submit();">FAIRE manger les animaux selectionnes</a></li>
					<li class="m"><a href="#">Ajouter un animal</a></li>
					<li class="m">
						<input type="text" name="nomAnimal" placeholder="nom de l'animal">
						<button id="btn_suppr">Supprimer un animal</button>
					</li>
				</ul>
			</nav>
			
			<article>
				<img  alt="mon zoo" src="images/plan.gif">
				<c:forEach var="zanimaux" items="${listZanimaux}" varStatus="loop">
					<div id="animal${loop.index}" style="position:absolute;top:${zanimaux.getY()}px;left:${zanimaux.getX()}px">
						<img alt="" src="${zanimaux.getImage()}" class="animal"/>
						<div class="afficheAnimal">${zanimaux.getPancarte()}</div>
	
						<div class="radio-mangeur">
							<input type="radio" id="mangeur${loop.index}" value="${loop.index}" name="mangeur">
							<label for="mangeur${loop.index}">Mangeur</label>
						</div>
						<div class="radio-mange">
							<input type="radio" id="mange${loop.index}" value="${loop.index}" name="mange">
							<label for="mange${loop.index}">Mange</label>
						</div>
					</div>	
				</c:forEach>

			</article>
		</form>

		<form name="fzoo_creer" action="creer" method="GET">
			<table>
    			<thead>
					<tr>
       				     <th colspan="2">Ajouter animal</th>
					</tr>
   				</thead>
    			<tbody>
       				 <tr>
            			<td>type d'animal</td>
            			<td><input type="text" name="typeAnimal" required="required" placeholder="?	  ex: Gazelle	 "></td>
        			</tr>
        			<tr>
            			<td>nom</td>
            			<td><input type="text" name="nom" required="required" placeholder="?	  !!!! "></td>
       				</tr>
					<tr>
            			<td>age</td>
           				<td><input type="number" name="age" required="required" placeholder="?	  ииииии "></td>
       				</tr>
					<tr>
            			<td>poids</td>
            			<td><input type="number" step="0.01" name="poids" required="required" placeholder="? votre choix "></td>
        			</tr>
        			<tr>
            			<td>longueur cornes</td>
            			<td><input type="number" name="corne" required="required" placeholder="?	    ......."></td>
        			</tr>
					<tr>
            			<td>Cage X</td>
            			<td><input type="number" name="cageX" required="required" placeholder="?	  -------- "></td>
        			</tr>
        			<tr>
            			<td>Cage Y</td>
            			<td><input type="number" name="cageY" required="required" placeholder="?	  @@@ "></td>
        			</tr>
        			<tr>
        				<td><button id="btn_creer" onClick="fzoo_creer.submit();">creer</button></td>
        			</tr>
    			</tbody>
			</table>
		</form>

		<footer>
			Etat en temps reel:
			<span id="etat-txt">
			<c:if test="${etat != null}">
				${etat}
				<c:remove var="etat"/>
			</c:if>
			</span>
		</footer>
		<script type="text/javascript">
			const btn = document.getElementById('btn_suppr');
			btn.addEventListener('click', function(e) {
			e.preventDefault(); // annule l'action normale de submit
			document.getElementById('forme').setAttribute("action", "supprimer");
			document.forms["fzoo"].submit();
			});
		</script>
	</body>
</html>
