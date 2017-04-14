<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="fr">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Gestionnaire de contacts</title>
</head>
<body>
	<h1>Gestionnaire de contacts</h1>
	<h2>Ajouter un contact</h2>
	<form method="post" action="AjouterContactAdresse">
		<fieldset>
			<legend>Informations personnelles</legend>
			<label for="nom">Nom</label>
			<input type="text" name="nom" required/>
			<label for="prenom">Prénom</label>
			<input type="text" name="prenom" />
			<label for="email">Email</label>
			<input type="text" name="email" />
		</fieldset>
		<fieldset>
			<legend>Adresse</legend>
				<label for="rue">Rue</label>
				<input type="text" name="rue" />
				<label for="ville">Ville</label>
				<input type="text" name="ville" />
				<label for="email">Code postal</label>
				<input type="text" name="codepostal" />
		</fieldset>
		<button type="submit">Ajouter</button>
	</form>
</body>
</html>