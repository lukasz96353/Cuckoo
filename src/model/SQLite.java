package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLite {

	   
	    public static void connectTest() {
	        Connection conn = null;
	        try {
	            // db parameters
	            String url = "jdbc:sqlite:db/main.db";
	            // create a connection to the database
	            conn = DriverManager.getConnection(url);
	            
	            System.out.println("Connection to SQLite has been established.");
	            
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        } finally {
	            try {
	                if (conn != null) {
	                    conn.close();
	                }
	            } catch (SQLException ex) {
	                System.out.println(ex.getMessage());
	            }
	        }
	    }
	    
	    public static void connectTest(String dbName) {
	        Connection conn = null;
	        try {
	            // db parameters
	            String url = dbName;
	            // create a connection to the database
	            conn = DriverManager.getConnection(url);
	            
	            System.out.println("Connection to SQLite has been established.");
	            
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        } finally {
	            try {
	                if (conn != null) {
	                    conn.close();
	                }
	            } catch (SQLException ex) {
	                System.out.println(ex.getMessage());
	            }
	        }
	    }
	  
	    public Connection connect() {
	        // SQLite connection string
	        String url = "jdbc:sqlite:src/resources/db/main.db";
	        Connection conn = null;
	        try {
	            conn = DriverManager.getConnection(url);
	            System.out.println("Conected to DB");
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	            System.out.println("Not conected to DB");
	        }
	        return conn;
	    }
	    
//	    public Connection connect(String dbName) {
//	        // SQLite connection string
//	        String url = dbName;
//	        Connection conn = null;
//	        try {
//	            conn = DriverManager.getConnection(url);
//	            System.out.println("Conected to DB " + dbName);
//	        } catch (SQLException e) {
//	            System.out.println(e.getMessage());
//	            System.out.println("Not conected to DB");
//	        }
//	        return conn;
//	    }
	    
	    
	    
	    
	    // FUNKCJE
	    
	    public void selectAll(){
	        String sql = "SELECT ID, PL, ENG, BASKET FROM main_table";
	        
	        try (Connection conn = this.connect();
	             Statement stmt  = conn.createStatement();
	             ResultSet rs    = stmt.executeQuery(sql)){
	            
	            // loop through the result set
	            while (rs.next()) {
	                System.out.println(rs.getInt("ID") +  "\t" + 
	                                   rs.getString("PL") + "\t" +
	                                   rs.getString("ENG") + "\t" +
	                                   rs.getInt("BASKET"));
	            }
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());        
	        }
	    
	    }
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
//	    public static void main(String[] args) {
//			// TODO Auto-generated method stub
//				
//			SQLite get = new SQLite(); 
//			get.connect();
//			
//			
//		}
	    
	    
	    
}
	
	
	
	

