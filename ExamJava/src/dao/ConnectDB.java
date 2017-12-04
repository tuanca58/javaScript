package dao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Descaption create connection Database.
 * 
 * @author User Create time Nov 28, 2017+9:22:00 AM
 */
public class ConnectDB {
	static final String DRIVER="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	/**
	 * Descaption create connection Database. User
	 * 
	 * @return
	 * @throws Exception
	 *           Nov 28, 2017
	 */
	public static Connection getConnection() throws Exception {
		Class.forName(DRIVER);
		return DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Candidate;", "sa", "123456");
	}
	
}
