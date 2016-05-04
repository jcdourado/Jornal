<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="author" content="Julio Cezar Dourado">
<meta name="viewport" content="width=device-width">
<title>Login</title>
</head>
<body>
	<form action="LoginController" method="post">
		<table>
			<tr>
				<td>Usuário: </td>
				<td><input type="text" size="10" maxlength="20" name="usuario"></td>
			</tr>
		
			<tr>
				<td>Senha: </td>
				<td><input type="password" size="10" maxlength="20" name="password"></td>
			</tr>
		</table>
		
		<input type="submit" name="cmd" value="Entrar">
		<input type="submit" name="cmd" value="Registrar">
		
	</form>
	<% if(session.getAttribute("msgAcao") != null){ %>
		<p><%=(String)session.getAttribute("msgAcao") %>
	<% } session.setAttribute("msgAcao",null); %>
</body>
</html>