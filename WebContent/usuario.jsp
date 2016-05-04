<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="author" content="Julio Cezar Dourado">
<meta name="viewport" content="width=device-width">
<title>Usuário</title>
</head>
<body>
	<form action="UsuarioController" method="post">
		<table>
			<tr>
				<td>Usuário: </td>
				<td><input type="text" size="10" maxlength="20" name="usuario"></td>
			</tr>
		
			<tr>
				<td>Senha: </td>
				<td><input type="password" size="10" maxlength="20" name="password"></td>
			</tr>
			
			<tr>
				<td>Nome: </td>
				<td><input type="text" size="20" maxlength="50" name="nome"></td>
			</tr>
			
			<tr>
				<td>Email: </td>
				<td><input type="email" size="20" maxlength="50" name="email"></td>
			</tr>
			
			<tr>
				<td>Telefone: </td>
				<td><input type="number" size="10" maxlength="20" name="telefone"></td>
			</tr>
		</table>
		
		<input type="submit" name="cmd" value="Cadastrar">
		<input type="submit" name="cmd" value="Cancelar">
		
	</form>
	<% if(session.getAttribute("msgAcao") != null){ %>
		<p><%=(String)session.getAttribute("msgAcao") %>
	<% } session.setAttribute("msgAcao",null); %>

</body>
</html>