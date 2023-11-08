package musicpack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class Player {
	
	private String url = "jdbc:mysql://127.0.0.1/music_player";
	private String username = "root";
	private String password = "12345678";
	
	Scanner console = new Scanner(System.in);
	
	public static void AccessCol (String input) {
		 String url = "jdbc:mysql://127.0.0.1/music_player";
		 String username = "root";
		 String password = "12345678";
		try {
			
			Connection connection = DriverManager.getConnection(url, username, password);
			//System.out.println("You are Connected to the music database!");
			Statement stat = connection.createStatement();
			ResultSet rs = stat.executeQuery("select SongName from music_player where SongName = " + input  );
			
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
	
	public static void AccessRow () {
		 String url = "jdbc:mysql://127.0.0.1/music_player";
		 String username = "root";
		 String password = "12345678";
		try {
			
			Connection connection = DriverManager.getConnection(url, username, password);
			//System.out.println("You are Connected to the World database!");
			Statement stat = connection.createStatement();
			ResultSet rs = stat.executeQuery("select * from music_player.songs");
			ResultSetMetaData rsmd = rs.getMetaData();
			int columnsNumber = rsmd.getColumnCount();
			while (rs.next()) {
			    for(int i = 1; i <= columnsNumber; i++) {
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
	
	public static void AccessRow1 (int SongID) {
		 String url = "jdbc:mysql://127.0.0.1/music_player";
		 String username = "root";
		 String password = "12345678";
		try {
			
			Connection connection = DriverManager.getConnection(url, username, password);
			//System.out.println("You are Connected to the World database!");
			Statement stat = connection.createStatement();
			ResultSet rs = stat.executeQuery("select * from music_player.songs where SongID = " + SongID);
			ResultSetMetaData rsmd = rs.getMetaData();
			int columnsNumber = rsmd.getColumnCount();
			while (rs.next()) {
			    for(int i = 1; i <= columnsNumber; i++) {
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
	
	
	
	public static void DeleteRow(int songID) {
		 String url = "jdbc:mysql://127.0.0.1/music_player";
		 String username = "root";
		 String password = "12345678";
		try {
			
			  Connection connection = DriverManager.getConnection(url, username, password);
			  //System.out.println("You are Connected to the stock_market database!");
			  // the mysql insert statement
		      String query = "delete from songs where SongID = ?";

		      // create the mysql insert preparedstatement
		      PreparedStatement preparedStmt = connection.prepareStatement(query);
		      preparedStmt.setInt(1, songID);
		      

		      // execute the preparedstatement
		      preparedStmt.execute();
		      
		      connection.close();
		    }
		    catch (Exception e)
		    {
		      System.err.println("Got an exception!");
		      System.err.println(e.getMessage());
		    }
  
	}
	
	public static void insertRow (String SongName, String artist, String album, String duration) {
		 String url = "jdbc:mysql://127.0.0.1/music_player";
		 String username = "root";
		 String password = "12345678";
		try {
			
			  Connection connection = DriverManager.getConnection(url, username, password);
			  //System.out.println("You are Connected to the music_player database!");
			  // the mysql insert statement
		      String query = " insert into songs (SongName, Artist, Album, Duration)"
		        + " values (?, ?, ?, ?)";

		      // create the mysql insert preparedstatement
		      PreparedStatement preparedStmt = connection.prepareStatement(query);
		      //preparedStmt.setInt(1, 2);
		      preparedStmt.setString(1, SongName);
		      preparedStmt.setString(2, artist);
		      preparedStmt.setString(3, album);
		      preparedStmt.setString(4, duration);

		      // execute the preparedstatement
		      preparedStmt.execute();
		      
		      connection.close();
		    }
		    catch (Exception e)
		    {
		      System.err.println("Got an exception!");
		      System.err.println(e.getMessage());
		    }
	}
	
	public static void UpdateRow() {
		 String url = "jdbc:mysql://127.0.0.1/music_player";
		 String username = "root";
		 String password = "12345678";
		try {
			
			  Connection connection = DriverManager.getConnection(url, username, password);
			// System.out.println("You are Connected to the stock_market database!");
			  // the mysql insert statement
		      String query = "update stock set numShares = ? where stockID = ?";

		      // create the mysql insert preparedstatement
		      PreparedStatement preparedStmt = connection.prepareStatement(query);
		      preparedStmt.setInt(1, 200);
		      preparedStmt.setInt(2, 1);
		      

		      // execute the preparedstatement
		      preparedStmt.execute();
		      
		      connection.close();
		    }
		    catch (Exception e)
		    {
		      System.err.println("Got an exception!");
		      System.err.println(e.getMessage());
		    }
	}
	

	public static void main (String[] args) {
			
			Scanner console = new Scanner(System.in);
			System.out.println(" \n Welcome to Raoify Music Playlist  \n\n You can enter the songs you want to listen to into \n the playlist!! \n The song name, song duration, artist name, album name, and duration length will all be stored. ");			
			System.out.println(" \n Choose an option: \n 1: Add a new song to the playlist \n 2: Remove a song from the playlist \n 3: to return a song in a certain index number \n 4: to print out the whole playlist");
			boolean run = true;
			
			while (run) {
				System.out.print(" enter number:  ");
				int inputCommand = console.nextInt();
				System.out.println();
				
				if (inputCommand == 1) {
					System.out.print(" enter Song Name:  ");
					String songName = console.next();
					System.out.print(" enter Artist Name:  ");
					String artist = console.next();
					System.out.print(" enter Album Name:  ");
					String albumName = console.next();
					System.out.print(" enter Duration length:  ");
					String songDuration = console.next();
					insertRow( songName, artist, albumName, songDuration);
					System.out.println();
				}
				
				if (inputCommand == 2) {
					System.out.print(" which row do you want to delete:  ");
					int deleteRow = console.nextInt();
					DeleteRow(deleteRow);
					System.out.println();
				}
				
				if (inputCommand == 3) {
					System.out.print(" which row do you want to access:  ");
					int SongID = console.nextInt();
					System.out.println();
					AccessRow1(SongID);
					System.out.println();
				}
				
				if (inputCommand == 4) {
					System.out.println();
					AccessRow();
					System.out.println();
				}
				
			}		
	}

}



