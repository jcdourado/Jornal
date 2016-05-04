package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Noticia;

public class NoticiaDAO {

	public void adicionar(Noticia n) throws ClassNotFoundException, SQLException{
		Connection con = DBUtil.getDBUtil().getConnection();
		String sql = "INSERT INTO NOTICIAS(TITULO,TIPO,JORNALISTA,DESCRICAO,DATA_CRIACAO,APROVADOR_ID,APROVADOR_DATA) VALUES (?,?,?,?,?,?,?)";
		PreparedStatement pS = con.prepareStatement(sql);
		pS.setString(1, n.getTitulo());
		pS.setString(2, n.getTipo());
		pS.setString(3, n.getJornalista());
		pS.setString(4, n.getDescricao());
		Date sd = new Date(n.getDataCriacao().getTime());
		pS.setDate(5, sd);
		pS.setString(6, n.getAprovador_id());
		sd = new Date(n.getAprovador_data().getTime());
		pS.setDate(7, sd);
		pS.execute();
	}
}
