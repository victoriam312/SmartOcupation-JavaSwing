package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import java.util.Date;

public class AlquilerDAO {
    public DefaultTableModel obtenerAlquileres() throws SQLException{
        //1. Definimos las columnas que verá el usuario
        String[] columnas = {"ID", "Expediente", "Cliente", "Ref.Vivienda", "Fecha Entrada", "Estado"};
        DefaultTableModel modelo = new DefaultTableModel(null, columnas);
        
        //2. Preparamos la consulta SQL con JOIN para traer nombres en vez de IDs
        String sql = "SELECT a.id_alquiler, a.num_expediente, c.nombre_cliente, v.codigo_referencia, a.fecha_entrada, a.estado_cobros " +
                     "FROM Alquiler a " +
                     "INNER JOIN Cliente c ON a.id_cliente_fk = c.id_cliente " +
                     "INNER JOIN Vivienda v ON a.id_vivienda_fk = v.id_vivienda";
        
        try (Connection con = ConexionDB.conectar();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()){
            
            //3. Recorremos los resultados y los añadimos fila a fila
                while (rs.next()){
                    Object [] fila = new Object[6];
                    fila[0] = rs.getInt("id_alquiler");
                    fila[1] = rs.getString("num_expediente");
                    fila[2] = rs.getString("nombre_cliente");
                    fila[3] = rs.getString("codigo_referencia");
                    fila[4] = rs.getDate("fecha_entrada");
                    fila[5] = rs.getString("estado_cobros");
                
                    modelo.addRow(fila);
                }
            }catch (Exception e){
                System.err.println("Error al listar todos alquileres: " + e.getMessage());
            }
            return modelo;
    }

    public DefaultTableModel obtenerAlquileres(Date fechaInicio, Date fechaFin){
        String[] columnas = {"ID", "Expediente", "Cliente", "Ref.Vivienda", "Fecha Entrada", "Estado"};
        DefaultTableModel modelo = new DefaultTableModel(null, columnas);
        
        //2. Preparamos la consulta SQL con JOIN para traer nombres en vez de IDs
        String sql = "SELECT a.id_alquiler, a.num_expediente, c.nombre_cliente, v.codigo_referencia, a.fecha_entrada, a.estado_cobros " +
                     "FROM Alquiler a " +
                     "INNER JOIN Cliente c ON a.id_cliente_fk = c.id_cliente " +
                     "INNER JOIN Vivienda v ON a.id_vivienda_fk = v.id_vivienda" +
                     "WHERE a.fecha_entrada BETWEEN ? AND ?";
        try (Connection con = ConexionDB.conectar();
            PreparedStatement ps = con.prepareStatement(sql)){
            
            java.sql.Date sqlFechaInicio = new java.sql.Date(fechaInicio.getTime());
            java.sql.Date sqlFechaFin = new java.sql.Date(fechaFin.getTime());
            
            ps.setDate(1, sqlFechaInicio);
            ps.setDate(2, sqlFechaFin);
            
            try (ResultSet rs = ps.executeQuery()){
                while (rs.next()){
                    Object [] fila = new Object[6];
                    fila[0] = rs.getInt("id_alquiler");
                    fila[1] = rs.getString("num_expediente");
                    fila[2] = rs.getString("nombre_cliente");
                    fila[3] = rs.getString("codigo_referencia");
                    fila[4] = rs.getDate("fecha_entrada");
                    fila[5] = rs.getString("estado_cobros");
                    modelo.addRow(fila);
                }
            }
        }catch (Exception e){
            System.err.println("Error al listar alquileres filtrados " + e.getMessage());
        }
        return modelo;
    }
}
