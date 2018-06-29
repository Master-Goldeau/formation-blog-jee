<%-- Configuration d'une page JSP avec la syntaxe "<%@ ... %>" --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" session="true" %>
<%-- Import de la librairie de tags JSTL core. --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Première page JSP</title>
<%-- Utilisation de l'API EL (Expression Language) qui permet d'évaluer du code Java. --%>
<%-- Utilisation de la syntaxe "<%= ... %>" pour affecter le résultat de l'expression
au contenu HTML généré en sortie. --%>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/index.css" />
</head>
<body>
	<h1>Bienvenue sur mon blog !</h1>
	<h2>
		<c:url value="/manage.html" var="manageUrl" />
		<a href="${manageUrl}">Créer un nouvel article</a>
	</h2>
	<div class="main">
		<c:url value="/delete.html?id=" var="deleteUrl" />
		<%-- Utilisation du tag forEach pour parcourir une collection (== Iterable)
		Java. Cela permet de dupliquer les éléments HTML à l'intérieur du tag. --%>
		<c:forEach var="article" items="${listArticle}">
			<div class="article">
				<%-- Accès à la propriété d'un POJO -> on écrit "article.title" mais
				en réalité l'expression qui sera évaluée est 'article.getTitle(). --%>
				<h2>
					${article.title}&nbsp;
					<a href="${deleteUrl}${article.id}">X</a>
				</h2>
				<p>${article.description}</p>
			</div>
		</c:forEach>
	</div>
</body>
</html>