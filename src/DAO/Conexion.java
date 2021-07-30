package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author koke
 */
public class Conexion {
    
    Connection con;
    String url = "jdbc:mysql://localhost/bd_ventas";
    String user = "root";
    String pass = "";
    
    public Connection Conectar(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, user, pass);
            System.out.println("Successful database connection");
        } catch (ClassNotFoundException e) {
            System.out.println("Error connecting to DB");
        } catch(SQLException r){
            System.out.println("Error with DB ");
        }
        return con;
    }
    
}
