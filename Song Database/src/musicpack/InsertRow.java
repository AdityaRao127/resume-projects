package musicpack;

import java.sql.*;
public class InsertRow {

	public static void main(String[] args) {
		
			String url = "jdbc:mysql://127.0.0.1/stock_market";
			String username = "root";
			String password = "12345678";
			
			try {
		
				  Connection connection = DriverManager.getConnection(url, username, password);
				  System.out.println("You are Connected to the stock_market database!");
				  // the mysql insert statement
			      String query = " insert into stock (symbol, market, company, numShares, price)"
			        + " values (?, ?, ?, ?, ?)";

			      // create the mysql insert preparedstatement
			      PreparedStatement preparedStmt = connection.prepareStatement(query);
			      //preparedStmt.setInt(1, 2);
			      preparedStmt.setString(1, "aapl");
			      preparedStmt.setString(2, "nasdaq");
			      preparedStmt.setString(3, "Apple");
			      preparedStmt.setInt(4, 100);
			      preparedStmt.setDouble(5, 150.00);

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
	}
			
