package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	private static final String driver = "com.mysql.jdbc.Driver";
	private static final String user = "root";
	private static final String senha = "";
	private static final String url = "jdbc:mysql://localhost:3306/jornal";
	private Connection con;
	private static DBUtil util;
	
	private DBUtil() throws ClassNotFoundException, SQLException{
		Class.forName(driver);
		con = DriverManager.getConnection(url,user,senha);
	}
	
	public static DBUtil getDBUtil() throws ClassNotFoundException, SQLException{
		if(util == null){
			util = new DBUtil();
		}
		return util;
	}
	
	public Connection getConnection(){
		return this.con;
	}
}
