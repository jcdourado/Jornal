package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.NoticiaDAO;
import model.Noticia;
import model.Usuario;

@WebServlet("/NoticiasController")
public class NoticiasController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	NoticiaDAO dao = new NoticiaDAO();
	List<Noticia> noticias = null;
	List<Noticia> noticiasNaoAprovadas = null;
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String cmd = req.getParameter("cmd");
		if("Adicionar uma noticia".equals(cmd)){
			resp.sendRedirect("noticia.jsp");
		} else if("Pesquisar".equals(cmd)){
			try {
				noticias = dao.consultarUma(req.getParameter("busca"));
				req.getSession().setAttribute("noticias", noticias);
				resp.sendRedirect("noticias.jsp");
			} catch (ClassNotFoundException | SQLException e) {
				req.getSession().setAttribute("noticias", noticias);
				resp.sendRedirect("noticias.jsp");
				e.printStackTrace();
			}
		} else if("Cadastrar".equals(cmd)){
			Noticia n = new Noticia();
			n.setTitulo(req.getParameter("titulo"));
			n.setJornalista(req.getParameter("jornalista"));
			n.setDescricao(req.getParameter("descricao"));
			n.setTipo(req.getParameter("tipo"));
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date d;
			try {
				d = sdf.parse(req.getParameter("dataCriacao"));
			} catch (ParseException e1) {
				d = new Date();
				e1.printStackTrace();
			}
			n.setDataCriacao(d);
			try {
				dao.adicionar(n);
				req.getSession().setAttribute("msgAcao", "Noticia cadastrada com sucesso!");
				resp.sendRedirect("noticia.jsp");
			} catch (ClassNotFoundException | SQLException e) {
				req.getSession().setAttribute("msgAcao", "Noticia não foi cadastrada!");
				resp.sendRedirect("noticias.jsp");
				e.printStackTrace();
			}
			
		} else if("Voltar".equals(cmd)){
			req.getSession().setAttribute("noticiasNaoAprovadas", null);
			resp.sendRedirect("noticias.jsp");
		}
	}
	
	public void pegarTodas(HttpServletRequest req, HttpServletResponse resp) throws ClassNotFoundException, SQLException, IOException{
		noticias = dao.pegaTodas();
		req.getSession().setAttribute("noticias", noticias);
	}
	
	public void pegarTodasNaoAprovadas(HttpServletRequest req, HttpServletResponse resp) throws ClassNotFoundException, SQLException, IOException{
		noticiasNaoAprovadas = dao.consultar();
		req.getSession().setAttribute("noticiasNaoAprovadas", noticiasNaoAprovadas);
	}
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String decisao = req.getParameter("acc");
		if("Aprovar".equals(decisao)){
			Noticia n;
			try {
				n = dao.consultar(req.getParameter("tit"));
				Usuario u = (Usuario)req.getSession().getAttribute("usuarioLogado");
				n.setAprovador_id(u.getUsuario());
				n.setAprovador_data(new Date());
				dao.aceitar(n);
				req.getSession().setAttribute("noticiasNaoAprovadas", null);
				req.getSession().setAttribute("noticias", null);
				resp.sendRedirect("noticias.jsp");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else{
			Noticia n;
			try {
				dao.remover(req.getParameter("tit"));
				req.getSession().setAttribute("noticiasNaoAprovadas", null);
				req.getSession().setAttribute("noticias", null);
				resp.sendRedirect("noticias.jsp");
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			
			
		}
	}
}
