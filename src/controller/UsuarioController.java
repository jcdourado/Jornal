package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UsuarioDAO;
import model.Usuario;

@WebServlet("/UsuarioController")
public class UsuarioController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	UsuarioDAO dao = new UsuarioDAO();
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String cmd = req.getParameter("cmd");
		if("Cadastrar".equals(cmd)){
			Usuario u = new Usuario();
			u.setUsuario(req.getParameter("usuario"));
			u.setPassword(req.getParameter("password"));
			u.setNome(req.getParameter("nome"));
			u.setEmail(req.getParameter("email"));
			u.setTelefone(req.getParameter("telefone"));
			try {
				dao.adicionar(u);
				req.getSession().setAttribute("msgAcao", "Usuário cadastrado com sucesso!");
				resp.sendRedirect("login.jsp");
			} catch (ClassNotFoundException | SQLException e) {
				req.getSession().setAttribute("msgAcao", "Usuário não foi cadastrado!");
				resp.sendRedirect("usuario.jsp");
				e.printStackTrace();
			}
		}
		else if("Cancelar".equals(cmd)){
			req.getSession().setAttribute("msgAcao", null);
			resp.sendRedirect("login.jsp");
		}
		else if("Ver Conta".equals(cmd)){
			resp.sendRedirect("usuario.jsp");
		}
		else if("Deletar Conta".equals(cmd)){
			try {
				dao.remover(((Usuario) req.getSession().getAttribute("usuarioLogado")).getUsuario());
				req.getSession().setAttribute("usuarioLogado", null);
				resp.sendRedirect("login.jsp");
			} catch (ClassNotFoundException | SQLException e) {
				req.getSession().setAttribute("msgAcao", "Não foi possível excluir o usuário!");
				resp.sendRedirect("noticias.jsp");
				e.printStackTrace();
			}
		}
		else if("Alterar".equals(cmd)){
			Usuario u = new Usuario();
			u.setUsuario(((Usuario) req.getSession().getAttribute("usuarioLogado")).getUsuario());
			u.setPassword(req.getParameter("password"));
			u.setNome(req.getParameter("nome"));
			u.setEmail(req.getParameter("email"));
			u.setTelefone(req.getParameter("telefone"));
			try {
				dao.alterar(u);
				req.getSession().setAttribute("usuarioLogado", u);
				req.getSession().setAttribute("msgAcao", "Usuário alterado com sucesso!");
				resp.sendRedirect("usuario.jsp");
			} catch (ClassNotFoundException | SQLException e) {
				req.getSession().setAttribute("msgAcao", "Usuário não foi alterado!");
				resp.sendRedirect("usuario.jsp");
				e.printStackTrace();
			}
		}
		else if("Voltar".equals(cmd)){
			resp.sendRedirect("noticias.jsp");
		}
	}

}
