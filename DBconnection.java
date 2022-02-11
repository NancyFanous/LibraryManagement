package librarymanagment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnection {
	
	private static String url = "jdbc:mysql://localhost:3306/booksdb"; /*mysql connection class*/
	private static String username = "root";
	private static String password = "1234";
	
	public static Connection getConnection() {
		
		Connection con = null;
		try {
			con = DriverManager.getConnection(url,username,password);
			System.out.println("YES");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return con;
	}

}
