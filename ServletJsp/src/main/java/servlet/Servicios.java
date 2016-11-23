package servlet;

import java.io.File;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Servicios {
	static File archivo = Paths.get(".").toAbsolutePath().normalize().toFile();
	static String ruta = "./src/main/resources/";

    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "org.h2.Driver"; //org.h2.Driver
    static final String DB_URL = "jdbc:h2:file:" + ruta + "DBtest2";

    //  Database credentials
    static final String USER = "sa";
    static final String PASS = "";

    public static void main (String[] args) {
    	
    }
    
    public static void BorrarTabla(String nombre){
    	Connection conn = null;
        Statement stmt = null;

        try {
            //STEP 2: Register JDBC driver
            Class.forName("org.h2.Driver");

            //STEP 3: Open a connection
            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected database successfully...");

            //STEP 4: Execute a query
            System.out.println("Creating table in given database...");
            stmt = conn.createStatement();

            String sql = "DELETE FROM Paises WHERE first = '" + nombre + "'";
                   ;

            stmt.executeUpdate(sql);

        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            closeStm(conn, stmt);
            closeCon(conn);
        } // end try
	} // end JDBCExample

	private static void closeCon(Connection conn) {
		try {
		    if (conn!= null)
		        conn.close();
		} catch (SQLException se) {
		    se.printStackTrace();
		} // end finally try
	}

	private static void closeStm(Connection conn, Statement stmt) {
		try {
		    if (stmt!=null)
		        conn.close();
		} catch (SQLException se) {
			se.printStackTrace();
		} // do nothing
	}
    
    public static List listar(){
    	Connection conn = null;
    	List<User> listUsers= new ArrayList<User>();
		ResultSet resultSet = null;
		PreparedStatement prepareStatement = null;
		Statement stmt = null;

        try {
            //STEP 2: Register JDBC driver
            Class.forName("org.h2.Driver");

            //STEP 3: Open a connection
            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected database successfully...");

            //STEP 4: Execute a query
            System.out.println("Creating table in given database...");
             stmt = conn.createStatement();
    		
    			prepareStatement = conn.prepareStatement("SELECT * FROM Paises");
    			resultSet = prepareStatement.executeQuery();
    			while(resultSet.next()){
    				User userInDatabase = new User();
    				userInDatabase.setNombre(resultSet.getString(1));
    				userInDatabase.setidioma(resultSet.getString(2));
    				userInDatabase.setidioma2(resultSet.getString(3));
    				
    				listUsers.add(userInDatabase);
    			}

        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            closeStm(conn, stmt);
            closeCon(conn);
            closeRs(resultSet);
        } // end try
        return listUsers;
   }

	private static void closeRs(ResultSet resultSet) {
		try {
			resultSet.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
    
   public static void insertarTabla(String nombre, String idioma, String idioma2){
    	Connection conn = null;
        Statement stmt = null;

        try {
            //STEP 2: Register JDBC driver
            Class.forName("org.h2.Driver");

            //STEP 3: Open a connection
            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected database successfully...");

            //STEP 4: Execute a query
            System.out.println("Creating table in given database...");
            stmt = conn.createStatement();

            String sql = "REPLACE INTO Paises (nombre,idioma,idioma2) VALUES ('" + nombre + "', '" + idioma + "', '" + idioma2 + "')";
            
            ;
                   
            stmt.executeUpdate(sql);
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            closeStm(conn, stmt);
            closeCon(conn);
        } // end try
       
    }
   
   public static void crearTabla(){
   	Connection conn = null;
       Statement stmt = null;

       try {
           //STEP 2: Register JDBC driver
           Class.forName("org.h2.Driver");

           //STEP 3: Open a connection
           System.out.println("Connecting to a selected database...");
           conn = DriverManager.getConnection(DB_URL, USER, PASS);
           System.out.println("Connected database successfully...");

           //STEP 4: Execute a query
           System.out.println("Creating table in given database...");
           stmt = conn.createStatement();

           String sql = "CREATE TABLE IF NOT EXISTS Paises " +
                   " (nombre VARCHAR(255), " +
                   " idioma VARCHAR(255), " +
                   " idioma2 VARCHAR(255), PRIMARY KEY (nombre))";

           stmt.executeUpdate(sql);
           System.out.println("Created table in given database...");
       } catch (SQLException se) {
           //Handle errors for JDBC
           se.printStackTrace();
       } catch (Exception e) {
           //Handle errors for Class.forName
           e.printStackTrace();
       } finally {
           //finally block used to close resources
    	   closeStm(conn, stmt);
           closeCon(conn);
       } // end try
   }

}
