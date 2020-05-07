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
<%
List<CagePOJO> zanimaux = null;
zanimaux = (List<CagePOJO>) request.getAttribute("listZanimaux");
String texte = null;
%>
<img  alt="mon zoo" src="images/plan.gif">
<% for(int i=0; i<zanimaux.size(); i++){
	texte = String.join("", "<div id=\"animal",Integer.toString(i),"\" style=\"position:absolute;top:",
	Integer.toString(zanimaux.get(i).getY()),"px;left:",Integer.toString(zanimaux.get(i).getX()),"px\">");
	out.print(texte);
	texte = String.join("", "<img alt=\"\" src=\"",zanimaux.get(i).getImage(),"\" class=\"animal\"/>");
	out.print(texte);
	texte = String.join("", "<div class=\"afficheAnimal\" >",zanimaux.get(i).getPancarte(),"</div>");
	out.print(texte);
	
	texte = String.join("", "<div class=\"radio-mangeur\"><input type=\"radio\" id=\"mangeur",Integer.toString(i),"\" value=\"",Integer.toString(i),"\" name=\"mangeur\"><label for=\"mangeur",Integer.toString(i),"\">Mangeur</label></div>");
	out.print(texte);
	texte = String.join("", "<div class=\"radio-mange\"><input type=\"radio\" id=\"mange",Integer.toString(i),"\" value=\"",Integer.toString(i),"\" name=\"mange\"><label for=\"mange",Integer.toString(i),"\">Mange</label></div></div>");
	out.print(texte);	
}
%>
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
            <td><input type="text" name="typeAnimal"></td>
        </tr>
        <tr>
            <td>nom</td>
            <td><input type="text" name="nom"></td>
        </tr>
		<tr>
            <td>age</td>
            <td><input type="text" name="age"></td>
        </tr>
		<tr>
            <td>poids</td>
            <td><input type="text" name="poids" placeholder="double ou entier"></td>
        </tr>
        <tr>
            <td>longueur cornes</td>
            <td><input type="text" name="corne" placeholder="entier"></td>
        </tr>
		<tr>
            <td>Cage X</td>
            <td><input type="text" name="cageX" placeholder="entier"></td>
        </tr>
        <tr>
            <td>Cage Y</td>
            <td><input type="text" name="cageY" placeholder="entier"></td>
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
<% 
if(session.getAttribute("etat") != null)
{
	//out.print(session.getAttribute("etat"));
	out.print(session.getAttribute("etat"));
	session.removeAttribute("etat");
}
%>
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
