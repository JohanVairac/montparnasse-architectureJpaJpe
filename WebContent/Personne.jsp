<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="./css/bootstrap.css" />
<link rel="stylesheet" href="./css/main.css" />

<meta charset="UTF-8">
<title>Formulaire</title>

</head>
<body>
	<div>
		<section class="container">
			<h1>Formulaire</h1>
			<div>
			<input type="hidden" name="id" value="${id}"/>
				<form action="ServletPersonne" method="POST" id="form-contact">

					<div class="form-group row">
						<input type="hidden" name="id" value="${id}"/>
						<label for="nom">Nom</label> <input id="nom" class="form-control"
							placeholder="Saisir votre nom" type="text" name="nom" value="${nom}" required />
					</div>

					<div class="form-group row">
						<label for="prenom">Prenom</label> <input id="prenom"
							class="form-control" placeholder="Saisir votre Prenom"
							type="text" name="prenom" value="${prenom}" required />
					</div>

					<div class="form-group row">
						<label for="age">Age</label> <input id="age" class="form-control"
							placeholder="Saisir votre Age" type="number" name="age" value="${age}" required />
					</div>
					
					<div class="form-group row">
						<label for="login">Login</label> <input id="login" class="form-control"
							placeholder="Saisir votre login" type="text" name="login" value="${login}" required />
					</div>
					
					<div class="form-group row">
						<label for="mdp">Password</label> <input id="password" class="form-control"
							placeholder="Saisir votre Mot de Passe" type="password" name="mdp" value="${mdp}" required />
					</div>

				Adresse: <br/><select name= "idAdresse">
				  <optgroup>
					  <option value="0">---</option> 
					<c:if test="${! empty adresses}">
						<c:forEach items="${adresses}" var="a">
							<option value="${a.idAdresse}"><c:out value="${a.nomRue}, ${a.numRue}, ${a.ville}, ${a.cp}"></c:out></option>
						</c:forEach>
						</c:if>
				</optgroup>
				</select>
					<div>
						<button type="submit" name="ajouter" value="Ajouter">Ajouter</button>
					</div>
					
					<div>
						<button type="submit" name="modifier" value="Modifier">Modifier</button>
					</div>
					<div class= "clearfix">
					</div>

				</form>
			</div>

		</section>
		
		
		
			
			
		<section class="container">
		   <h1>Liste des personnes de la BDD</h1>
			<table class="table">
				<thead>
					<tr>
						<th>ID</th>
						<th>Nom</th>
						<th>Prenom</th>
						<th>Age</th>
						<th>Login</th>
						<th>Mot de Passe</th>
						<th>Supprimer</th>
						<th>Modifier</th>
						
					</tr>

				</thead>
				<tbody>
					<c:if test="${! empty personnes}">
						<c:forEach items="${personnes}" var="x">
							<tr>
								<td><c:out value="${x.id}" /></td>
								<td><c:out value="${x.nom}" /></td>
								<td><c:out value="${x.prenom}" /></td>
								<td><c:out value="${x.age}" /></td>
								<td><c:out value="${x.connexion.login}" /></td>
								<td><c:out value="${x.connexion.mdp}" /></td>
								<td><a href="SupprimerPersonne?id=${x.id}">supprimer</a></td>
								<td><a href="ModifierPersonne?id=${x.id}">modifier</a></td>
							</tr>
						</c:forEach>

					</c:if>


				</tbody>
			</table>
		</section>
	</div>
	
</body>
</html>