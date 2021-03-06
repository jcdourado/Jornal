package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Usuario;

public class UsuarioDAO {
	
	public void adicionar(Usuario u) throws SQLException, ClassNotFoundException{
		Connection con = DBUtil.getDBUtil().getConnection();
		String sql = "INSERT INTO USUARIO(USUARIO,NOME,EMAIL,TELEFONE,PASSWORD) VALUES (?,?,?,?,?)";
		PreparedStatement pS = con.prepareStatement(sql);
		pS.setString(1, u.getUsuario());
		pS.setString(2, u.getNome());
		pS.setString(3, u.getEmail());
		pS.setString(4, u.getTelefone());
		pS.setString(5, u.getPassword());
		pS.executeUpdate();
	}
	
	public void remover(String usuario) throws ClassNotFoundException, SQLException{
		Connection con = DBUtil.getDBUtil().getConnection();
		String sql = "DELETE FROM USUARIO WHERE USUARIO = ?";
		PreparedStatement pS = con.prepareStatement(sql);
		pS.setString(1, usuario);
		pS.executeUpdate();
	}
	
	public void alterar(Usuario usuario) throws ClassNotFoundException, SQLException{
		Connection con = DBUtil.getDBUtil().getConnection();
		String sql = "UPDATE USUARIO SET NOME = ?, EMAIL = ?, TELEFONE = ?, PASSWORD = ? WHERE USUARIO = ?";
		PreparedStatement pS = con.prepareStatement(sql);
		pS.setString(1, usuario.getNome());
		pS.setString(2, usuario.getEmail());
		pS.setString(3, usuario.getTelefone());
		pS.setString(4, usuario.getPassword());
		pS.setString(5, usuario.getUsuario());
		pS.executeUpdate();
	}
	
	public Usuario consultar(Usuario usuarioLogar) throws ClassNotFoundException, SQLException{
		Connection con = DBUtil.getDBUtil().getConnection();
		String sql = "SELECT * FROM USUARIO WHERE USUARIO = ? AND PASSWORD = ?";
		PreparedStatement pS = con.prepareStatement(sql);
		pS.setString(1, usuarioLogar.getUsuario());
		pS.setString(2, usuarioLogar.getPassword());
		ResultSet rS = pS.executeQuery();
		if(rS.next()){
			usuarioLogar.setEmail(rS.getString("email"));
			usuarioLogar.setNome(rS.getString("nome"));
			usuarioLogar.setTelefone(rS.getString("telefone"));
			return usuarioLogar;
		}
		return null;
	}
}
