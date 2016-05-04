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

@WebServlet("/LoginController")
public class LoginController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UsuarioDAO dao = new UsuarioDAO();

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String cmd = req.getParameter("cmd");
		if("Entrar".equals(cmd)){
			Usuario u = new Usuario();
			u.setUsuario(req.getParameter("usuario"));
			u.setPassword(req.getParameter("password"));
			try {
				u = dao.consultar(u);
				if(u != null){
					req.getSession().setAttribute("usuarioLogado", u);
					resp.sendRedirect("noticias.jsp");
				}
				else{
					req.getSession().setAttribute("msgAcao", "Usuário não foi encontrado!");
					resp.sendRedirect("login.jsp");
				}
			} catch (ClassNotFoundException | SQLException e) {
				req.getSession().setAttribute("msgAcao", "Usuário não foi encontrado!");
				resp.sendRedirect("login.jsp");
				e.printStackTrace();
			} 
		}
		else{
			req.getSession().setAttribute("acao", "registrar");
			resp.sendRedirect("usuario.jsp");
		}
	}
}
