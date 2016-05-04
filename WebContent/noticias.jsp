<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="author" content="Julio Cezar Dourado">
<meta name="viewport" content="width=device-width">
<title>Notícias</title>
<% if(session.getAttribute("usuarioLogado") == null){ %>
	<meta http-equiv="refresh" content=0;url="login.jsp">
<%} %>
</head>
<body>

	<form action="UsuarioController" method="post">
		<input type="submit" name="cmd" value="Ver Conta">
		<input type="submit" name="cmd" value="Deletar Conta">
	</form>

	
</body>
</html>