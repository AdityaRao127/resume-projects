package musicpack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class AccessCol {

	public static void main(String[] args) {
		
		//String url = "jdbc:mysql://localhost3306/mysql";
		String url = "jdbc:mysql://127.0.0.1/music_player";
		String username = "root";
		String password = "12345678";
		Scanner console = new Scanner(System.in);
		
		try {
	
			Connection connection = DriverManager.getConnection(url, username, password);
			System.out.println("You are Connected to the music database!");
			Statement stat = connection.createStatement();
			ResultSet rs = stat.executeQuery("select SongName from music_player where SongName equals" );
			
			while(rs.next()) {
				String SongName = rs.getString("SongName");
				System.out.println("Song Name: " + SongName);
			} 

			connection.close();
		
		} catch (SQLException e) {			
			System.out.println("Oops, error!");
			e.printStackTrace();
			
		}
	}
}
