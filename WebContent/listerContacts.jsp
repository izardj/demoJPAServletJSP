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
	<h2>Liste des contacts</h2>
	<c:if test="${! empty contacts}">
		<div class="table-responsive">
			<table class="table table-striped">
				<thead>
					<tr>
						<th>ID</th>
						<th>NOM</th>
						<th>PRENOM</th>
						<th>EMAIL</th>
						<th>RUE</th>
						<th>VILLE</th>
						<th>CODE POSTAL</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="c" items="${contacts}">
						<tr>
							<td><c:out value="${c.id}"></c:out></td>
							<td><c:out value="${c.nom}"></c:out></td>
							<td><c:out value="${c.prenom}"></c:out></td>
							<td><c:out value="${c.email}"></c:out></td>
							<td><c:out value="${c.adresse.numRue}"></c:out></td>
							<td><c:out value="${c.adresse.ville}"></c:out></td>
							<td><c:out value="${c.adresse.codePostal}"></c:out></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</c:if>
	<c:if test="${empty contacts}">
	<p>Aucun contact</p>
	</c:if>
</body>
</html>