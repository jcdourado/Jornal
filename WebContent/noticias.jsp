<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<%@page import="model.Noticia"%>
<%@page import="controller.NoticiasController"%>
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
	
	<a href="login.jsp">Logar</a>
	
	<% if (session.getAttribute("noticias") == null){
		NoticiasController ctr = new NoticiasController();
		ctr.pegarTodas(request,response);
	}
	
	 %>
	<form action="NoticiasController" method="post">
		<input type="submit" name="cmd" value="Adicionar uma noticia">
		<input type="text" name="busca">
		<input type="submit" name="cmd" value="Pesquisar">
		
		<table>
		<%SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); %>
			<% for(Noticia n : (List<Noticia>) session.getAttribute("noticias")){ %>
				<tr><td><%=n.getTitulo() %></td></tr>
				<tr><td><%=n.getTipo() %></td></tr>
				<tr><td><%=n.getJornalista() %></td></tr>
				<tr><td> <%=n.getDescricao() %></td></tr>
				<tr><td><%=sdf.format(n.getDataCriacao()) %></td></tr>
			<% } %>
		</table>
	</form>
</body>
</html>