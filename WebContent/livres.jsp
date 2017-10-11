<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
	label{
		display:block;
		width:150px;
		float:left;
	}
	.listLivres{
		display:block;
		width:350px;
		float:left;
	}
	.reservInfo{
		color:grey;
	}
	a{
		color:blue;
	}
</style>
</head>
<body>

<h2>Gestion de bibliothèque</h2>
<c:set var="livres" value="${requestScope['mesLivres']}" />
<div>
<h3>Liste des livres</h3>
	<c:forEach var="l" items="${livres}">
	<form action="${pageContext.request.contextPath}/spring/dellivre" method="get">
		<div class="listLivres">
			<c:out value="${l.titre}"/>		
			<span>chez </span><c:out value="${l.collection.nom}"/>
		</div>
			<c:choose>
				<c:when test="${l.reserve}">
					<a href="${pageContext.request.contextPath}/spring/dellivre?codeDel=${l.code}">delete</a>
				</c:when>
				<c:otherwise>
					<span class="reservInfo">reserved</span>
				</c:otherwise>
			
			</c:choose>
	</form>
	</c:forEach>
</div>
<div>
	<h3>Ajout d'une nouveau livre</h3>
	<form action="${pageContext.request.contextPath}/spring/addlivre" method="post">
			<label>titre:</label>
			<input type="text" name="titreLivre" value=""/><br/>
			<label>n° édition:</label>
			<input type="text" name="editionLivre" value=""/><br/>
			<label>date de parution:</label>
			<input type="text" name="ddpLivre" value="" placeholder="dd-mm-aaaa"/><br/>
			<label>nombre de pages:</label>
			<input type="text" name="nbpgLivre" value=""/><br/>
			<label>collection:</label>
			<select name="collLivre">
				<c:forEach var="col" items="${requestScope['mesCollections']}">
					<option value="${col.id}"><c:out value="${col.nom}"/></option>
				</c:forEach>					
			</select><br/>
			<label>auteurs:</label>
			<select multiple name="autLivre">
				<option value="aucun">aucun</option>
				<c:forEach var="aut" items="${requestScope['mesAuteurs']}">
					<option value="${aut.id}">
						<c:out value="${aut.prenom}"/>&nbsp;
						<c:out value="${aut.nom}"/>
					</option>
				</c:forEach>					
			</select><br/>
			<input type="hidden" value="ajouter"/>		
			<input type="submit" value="ajouter" name="livreInputs"/><br/>
		</form>
</div>
<a href="${pageContext.request.contextPath}/spring/index">index</a>
</body>
</html>