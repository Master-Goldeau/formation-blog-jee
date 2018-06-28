<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- Import de la librairie de tags JSTL core --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<%-- Ce fichier index.jsp est placé à la racine de l'application Web (== dans src/main/webapp).
Lorsque l'URL racine de l'application est demandée (http://localhost:8080/blog/), c'est cette
page JSP qui sera choisie pour répondre à la requête. --%>
<html>
	<%
		// TODO: Replace with real login page.
		request.getSession().setAttribute("auth", "guest");
	%>
	<%-- Tag redirect permettant de rediriger une requête HTTP vers un autre point
	d'entrée dans l'application (ici on redirige vers une Servlet). --%>
	<c:redirect url="/articles" />
</html>