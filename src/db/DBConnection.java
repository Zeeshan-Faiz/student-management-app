package db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

	static Connection connection;
	
	public static Connection createConnection() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String user = "root";
			String password = "password";
			String url = "jdbc:mysql://localhost:3306/student?autoReconnect=true&useSSL=false";
			
			connection = DriverManager.getConnection(url,user,password);
			
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		
		return connection;
	}
}
