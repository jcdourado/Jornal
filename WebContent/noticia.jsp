<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="author" content="Julio Cezar Dourado">
<meta name="viewport" content="width=device-width">
<title>Noticia</title>
</head>
<body>
	<form action="NoticiasController" method="post">
		<table>
			<tr>
				<td>Titulo: </td>
				<td><input type="text" size="20" maxlength="50" name="titulo"></td>
			</tr>
		
			<tr>
				<td>Jornalista: </td>
				<td><input type="text" size="20" maxlength="20" name="jornalista">
				</td>
			</tr>
			
			<tr>
				<td>Tipo: </td>
				<td><input type="text" size="20" maxlength="20" name="tipo">
				</td>
			</tr>
			
			<tr>
				<td>Descrição: </td>
				<td><textarea name="descricao" rows="4" cols="20"></textarea> </td>
			</tr>
			
			<tr>
				<td>Data de criação: </td>
				<td><input type="date" name="dataCriacao"></td>
			</tr>
		</table>
		
		<input type="submit" name="cmd" value="Cadastrar">
		<input type="submit" name="cmd" value="Voltar">
	</form>
	<% if(session.getAttribute("msgAcao") != null){ %>
		<p><%=(String)session.getAttribute("msgAcao") %></p>
	<% } session.setAttribute("msgAcao", null); %>
	
</body>
</html>