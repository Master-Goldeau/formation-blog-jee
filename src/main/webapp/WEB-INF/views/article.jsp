<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Gestion des articles :</h1>
	<div>
		<h2>Créer un nouvel article</h2>
		<form method="post">
			<div>
				<label for="title">Titre :</label>
				<input id="title" name="title" />
			</div>
			<div>
				<label for="descr">Description :</label>
				<input id="descr" name="descr" />
			</div>
			<button>Valider</button>
		</form>
	</div>
</body>
</html>