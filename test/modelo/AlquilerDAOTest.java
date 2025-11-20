/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package modelo;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import javax.swing.table.DefaultTableModel;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class AlquilerDAOTest {
    
    public AlquilerDAOTest() {
    }
    
    @Test
    void testObtenerAlquileres_CargaInicial() throws SQLException{
        System.out.println("Probando carga inicial de alquileres (sin filtros)...");
        AlquilerDAO instance = new AlquilerDAO();
        DefaultTableModel result = instance.obtenerAlquileres();
        
        assertTrue(result.getRowCount() >=4, "Debe haber al menos 4 filas de datos en la tabla ");
        assertEquals(6, result.getColumnCount(), "Debe haber 6 columnas en el modelo de la tabla "); 
    }
    
    @Test
    void testObtenerAlquileres_FiltroAnual(){
        System.out.println("Probando filtro de alquileres por rango de fechas ");
        AlquilerDAO instance = new AlquilerDAO();
        
        Calendar cal = Calendar.getInstance();
        cal.set(2024, Calendar.JANUARY, 1);
        Date fechaInicio = cal.getTime();
        
        cal.set(2024, Calendar.DECEMBER, 31);
        Date fechaFin = cal.getTime();
        
        DefaultTableModel result = instance.obtenerAlquileres(fechaInicio, fechaFin);
        
        assertEquals(2, result.getRowCount(), "El filtro para 2024 debe devolver exactamente dos alquileres");
        
    }
    
}