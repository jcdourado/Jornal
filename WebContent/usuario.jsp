<%@page import="model.Usuario"%>
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
<%
	Usuario u = new Usuario();
	if(session.getAttribute("usuarioLogado") != null){
		u = (Usuario) session.getAttribute("usuarioLogado");
	}

 %>

	<form action="UsuarioController" method="post">
		<table>
			<tr>
				<td>Usuário: </td>
				<td><input type="text" size="10" maxlength="20" name="usuario"
					<% if(u.getUsuario() != null) { %>
					value="<%=u.getUsuario() %>"
					disabled
					<% } %>
				></td>
			</tr>
		
			<tr>
				<td>Senha: </td>
				<td><input type="password" size="10" maxlength="20" name="password"
					<% if(u.getPassword() != null) { %>
					value="<%=u.getPassword() %>"
					<% } %>
				></td>
			</tr>
			
			<tr>
				<td>Nome: </td>
				<td><input type="text" size="20" maxlength="50" name="nome"
					<% if(u.getNome() != null) { %>
					value="<%=u.getNome() %>"
					<% } %>
				></td>
			</tr>
			
			<tr>
				<td>Email: </td>
				<td><input type="email" size="20" maxlength="50" name="email"
					<% if(u.getEmail() != null) { %>
					value="<%=u.getEmail() %>"
					<% } %>
				></td>
			</tr>
			
			<tr>
				<td>Telefone: </td>
				<td><input type="number" size="10" maxlength="20" name="telefone"
					<% if(u.getTelefone() != null) { %>
					value="<%=u.getTelefone() %>"
					<% } %>
				></td>
			</tr>
		</table>
		
		<% if(u.getNome() == null){ %>
		<input type="submit" name="cmd" value="Cadastrar">
		<input type="submit" name="cmd" value="Cancelar">
		<% } else{  %>
		<input type="submit" name="cmd" value="Alterar">
		<input type="submit" name="cmd" value="Voltar">
		<% } %>
		
	</form>
	<% if(session.getAttribute("msgAcao") != null){ %>
		<p><%=(String)session.getAttribute("msgAcao") %>
	<% } session.setAttribute("msgAcao",null); %>

</body>
</html>