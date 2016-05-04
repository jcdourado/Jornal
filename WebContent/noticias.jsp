<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="author" content="Julio Cezar Dourado">
<meta name="viewport" content="width=device-width">
<title>Notícias</title>
</head>
<body>

<% if(session.getAttribute("usuarioLogado") != null){ %>
	<form action="UsuarioController" method="post">
		<input type="submit" name="cmd" value="Ver Conta">
		<input type="submit" name="cmd" value="Deletar Conta">
	</form>
	<%-- Aqui vem as coisas que são visiveis aos usuario logados --%>
<%} %>
	<%-- Aqui vem as coisas que são visiveis á todos --%>

	

	
</body>
</html>