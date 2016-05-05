package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Noticia;

public class NoticiaDAO {

	public void adicionar(Noticia n) throws ClassNotFoundException, SQLException{
		Connection con = DBUtil.getDBUtil().getConnection();
		String sql = "INSERT INTO NOTICIAS(TITULO,TIPO,JORNALISTA,DESCRICAO,DATA_CRIACAO) VALUES (?,?,?,?,?)";
		PreparedStatement pS = con.prepareStatement(sql);
		pS.setString(1, n.getTitulo());
		pS.setString(2, n.getTipo());
		pS.setString(3, n.getJornalista());
		pS.setString(4, n.getDescricao());
		Date sd = new Date(n.getDataCriacao().getTime());
		pS.setDate(5, sd);
		pS.execute();
	}
	
	public void remover(String noticia) throws ClassNotFoundException, SQLException{
		Connection con = DBUtil.getDBUtil().getConnection();
		String sql = "DELETE FROM NOTICIAS WHERE TITULO = ?";
		PreparedStatement pS = con.prepareStatement(sql);
		pS.setString(1, noticia);
		pS.executeUpdate();
	}
	
	public void aceitar(Noticia n) throws ClassNotFoundException, SQLException{
		Connection con = DBUtil.getDBUtil().getConnection();
		String sql = "UPDATE NOTICIAS SET APROVADOR_ID = ? , APROVADOR_DATA = ?  WHERE TITULO = ?";
		PreparedStatement pS = con.prepareStatement(sql);
		pS.setString(1, n.getAprovador_id());
		Date sd = new Date(n.getAprovador_data().getTime());
		pS.setDate(2, sd);
		pS.setString(3, n.getTitulo());
		pS.executeUpdate();
	}
	
	public Noticia consultar(String noticias) throws ClassNotFoundException, SQLException{
		Connection con = DBUtil.getDBUtil().getConnection();
		String sql = "SELECT * FROM NOTICIAS WHERE TITULO = ?";
		PreparedStatement pS = con.prepareStatement(sql);
		pS.setString(1, noticias);
		ResultSet rS = pS.executeQuery();
		if(rS.next()){
			Noticia n = new Noticia();
			n.setTitulo(noticias);
			n.setTipo(rS.getString("tipo"));
			n.setJornalista(rS.getString("jornalista"));
			n.setDescricao(rS.getString("descricao"));
			java.util.Date ds = new Date(rS.getDate("DATA_CRIACAO").getTime());
			n.setDataCriacao(ds);
			n.setAprovador_id(rS.getString("aprovador_id"));
			ds = new Date(rS.getDate("APROVADOR_DATA").getTime());
			n.setAprovador_data(ds);
			return n;
		}
		return null;
	}
	
	public List<Noticia> consultarUma(String NOME) throws ClassNotFoundException, SQLException{
		Connection con = DBUtil.getDBUtil().getConnection();
		String sql = "SELECT * FROM NOTICIAS WHERE TITULO LIKE ? AND APROVADOR_ID IS NOT NULL";
		PreparedStatement pS = con.prepareStatement(sql);
		pS.setString(1, "%"+NOME+"%");
		ResultSet rS = pS.executeQuery();
		List<Noticia> noticias= new ArrayList<Noticia>();
		while(rS.next()){
			Noticia n = new Noticia();
			n.setTitulo(rS.getString("titulo"));
			n.setTipo(rS.getString("tipo"));
			n.setJornalista(rS.getString("jornalista"));
			n.setDescricao(rS.getString("descricao"));
			java.util.Date ds = new Date(rS.getDate("DATA_CRIACAO").getTime());
			n.setDataCriacao(ds);
			n.setAprovador_id(rS.getString("aprovador_id"));
			ds = new Date(rS.getDate("APROVADOR_DATA").getTime());
			n.setAprovador_data(ds);
			noticias.add(n);
		}
		return noticias;
	}
	
	public List<Noticia> pegaTodas() throws ClassNotFoundException, SQLException{
		Connection con = DBUtil.getDBUtil().getConnection();
		String sql = "SELECT * FROM NOTICIAS WHERE APROVADOR_ID IS NOT NULL";
		PreparedStatement pS = con.prepareStatement(sql);
		ResultSet rS = pS.executeQuery();
		List<Noticia> noticias= new ArrayList<Noticia>();
		while(rS.next()){
			Noticia n = new Noticia();
			n.setTitulo(rS.getString("titulo"));
			n.setTipo(rS.getString("tipo"));
			n.setJornalista(rS.getString("jornalista"));
			n.setDescricao(rS.getString("descricao"));
			java.util.Date ds = new Date(rS.getDate("DATA_CRIACAO").getTime());
			n.setDataCriacao(ds);
			n.setAprovador_id(rS.getString("aprovador_id"));
			ds = new Date(rS.getDate("APROVADOR_DATA").getTime());
			n.setAprovador_data(ds);
			noticias.add(n);
		}
		return noticias;
	}
}
