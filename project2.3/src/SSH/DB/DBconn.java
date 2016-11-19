package SSH.DB;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBconn {
	private static Connection conn = null;
	private static String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private static String user = "SCOTT";
	private static String password = "TIGER";
	
	public Connection getConn() throws Exception{
		if((conn == null) || conn.isClosed()){
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, user, password);
		}
		
		return conn;
	}
}