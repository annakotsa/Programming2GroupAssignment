package JavaDevs;

//@authors Anna Kotsa, Ioanna Kalogeropoulou, Aristi Syriou

import java.io.*;
import java.text.*;
import java.util.*;
import java.sql.*;

public class SQL {
	
	public void Sql(String url, String dbname) throws SQLException {
	
		Connection conn;
		Statement stmt;
		ResultSet rs;
		
		conn = DriverManager.getConnection(url);
		stmt = conn.createStatement();
		try {
			String Query = "select name, surname, am, telephone from " + dbname + ".SQLDataBase";
			
		    rs = stmt.executeQuery(Query);
		    	while (rs.next()) {
		        	String name = rs.getString("name");
		        	String surname = rs.getString("surname");
		            int am = rs.getInt("AM");
		            int telephone = rs.getInt("telephone");
		            System.out.println(name + "\t" + surname +
		                               "\t" + am + "\t" + telephone);
		    	}
		    } catch (SQLException e ) {
		    	System.out.println("SQLException: ");
				System.out.println(e.getMessage());
		    } finally {
		        if (stmt != null) { stmt.close(); }
		    }
		}
			
	}

