package musicpack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class AccessRow {

	public static void main(String[] args) {
		
		//String url = "jdbc:mysql://localhost3306/mysql";
		String url = "jdbc:mysql://127.0.0.1/world";
		String username = "root";
		String password = "12345678";
		
		try {
	
			Connection connection = DriverManager.getConnection(url, username, password);
			System.out.println("You are Connected to the World database!");
			Statement stat = connection.createStatement();
			ResultSet rs = stat.executeQuery("select * from city where countrycode = \"AFG\" ");
			ResultSetMetaData rsmd = rs.getMetaData();
			int columnsNumber = rsmd.getColumnCount();
			while (rs.next()) {
			    for(int i = 1; i < columnsNumber; i++) {
			        System.out.print(rs.getString(i) + " ");
			    }
			    System.out.println();
			}
			
			
			connection.close();
		} catch (SQLException e) {			
			System.out.println("Oops, error!");
			e.printStackTrace();
			
		}
	}
}