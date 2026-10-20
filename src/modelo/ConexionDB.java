package modelo;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Conexión a MySQL. Las credenciales NO están en el código: se leen del
 * archivo db.properties (en la raíz del proyecto, ignorado por Git) o de las
 * variables de entorno DB_URL, DB_USER y DB_PASSWORD.
 * Plantilla: db.properties.example
 */
public class ConexionDB {
    private static final String CONFIG_FILE = "db.properties";
    private static final String DEFAULT_URL = "jdbc:mysql://localhost:3306/smart_ocupation_db?serverTimezone=UTC";

    private static final Properties CONFIG = cargarConfig();

    private static Properties cargarConfig() {
        Properties props = new Properties();
        try (InputStream in = new FileInputStream(CONFIG_FILE)) {
            props.load(in);
        } catch (IOException e) {
            System.out.println("Aviso: no se encontró " + CONFIG_FILE + ", se usarán variables de entorno");
        }
        return props;
    }

    private static String valor(String clave, String porDefecto) {
        String env = System.getenv(clave);
        if (env != null && !env.isEmpty()) {
            return env;
        }
        return CONFIG.getProperty(clave, porDefecto);
    }

    public static Connection conectar(){
        Connection con = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(
                    valor("DB_URL", DEFAULT_URL),
                    valor("DB_USER", ""),
                    valor("DB_PASSWORD", ""));
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
