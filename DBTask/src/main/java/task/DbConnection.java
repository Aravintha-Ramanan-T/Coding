package task;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
	
	public static Connection dbConnection() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/login";
		String userName = "root";
		String passWord = "root";
		
		Connection con = DriverManager.getConnection(url,userName,passWord);
		return con;
	}

}
