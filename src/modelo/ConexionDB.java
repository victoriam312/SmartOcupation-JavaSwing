package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {
    private static final String URL = "jdbc:mysql://localhost:3306/smart_ocupation_db?serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASS = "Malagacf.25"; //Contraseña de MySQL
    
    public static Connection conectar(){
        Connection con = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(URL, USER, PASS);
            System.out.println("Conexión establecida con éxito");
        }catch (SQLException e){
            System.out.println("Error al conectar con la base de datos");
            e.printStackTrace();
        } catch (ClassNotFoundException e){
            System.out.println("Error: No se encuentra el driver de MySQL");
            e.printStackTrace();
        }
        return con;
    }
    
    public static void main (String[] args){
        conectar(); //Prueba rápida
    }
    
}
