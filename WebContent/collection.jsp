<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
	.collList{
		display: block;
		float:left;
		width: 300px;
	}
	a{
		color:blue;
	}
</style>
</head>
<body>
<h2>Gestion de bibliothèque</h2>
<c:set var="collection" value="${requestScope['laCollection']}" />
<fieldset >
	<legend><h3>Liste des collections</h3></legend>
	<c:forEach var="c" items="${collection}">
	<form action="${pageContext.request.contextPath}/spring/delcoll" method="post">
		<div class="collList">		
			<c:out value="${c.nom}"/>
		</div>
		<c:if test="${!(c.nbrLivre > 0)}">
			<input type="hidden" value="${c.id}" name="codeDel"/>		
			<input type="submit" value="delete" name="collectionInputs"/>
		</c:if><br/>
	</form>
	</c:forEach>
</fieldset>
<fieldset >
	<legend><h3>Ajout d'une nouvelle collection</h3></legend>
	<form action="${pageContext.request.contextPath}/spring/addcoll" method="post">
			<label>nom:</label>
			<input type="text" name="nomCollection" value=""/><br/>
			<input type="hidden" value="ajouter"/>		
			<input type="submit" value="ajouter" name="collectionInputs"/><br/>
		</form>
</fieldset>
<a href="${pageContext.request.contextPath}/spring/index">index</a>
</body>
</html>