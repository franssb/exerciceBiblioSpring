<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
	a{
		color:blue;
	}
</style>
</head>
<body>
<h2>Gestion de bibliothèque</h2>
<c:set var="auteurs" value="${requestScope['mesAuteurs']}" />
<fieldset >
	<legend><h3>Liste des auteurs</h3></legend>
	<c:forEach var="a" items="${auteurs}">
	<form action="${pageContext.request.contextPath}/spring/delauteur" method="post">
		<c:out value="${a.prenom}"/>		
		<c:out value="${a.nom}"/>
		<input type="hidden" value="${a.id}" name="codeDel"/>		
		<input type="submit" value="delete" name="collectionInputs"/><br/>
	</form>
	</c:forEach>
</fieldset>

<fieldset >
	<legend><h3>Ajout d'une nouvel auteur</h3></legend>
	<form action="${pageContext.request.contextPath}/spring/addauteur" method="post">
			<label>prenom:</label>
			<input type="text" name="prenomAuteur" value=""/><br/>
			<label>nom:</label>
			<input type="text" name="nomAuteur" value=""/><br/>
			<input type="hidden" value="ajouter"/>		
			<input type="submit" value="ajouter" name="collectionInputs"/><br/>
		</form>
</fieldset>

<a href="${pageContext.request.contextPath}/spring/index">index</a>
</body>
</html>