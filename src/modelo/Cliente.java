package modelo;

public class Cliente {
    private int idCliente;
    private String nombreCliente;
    private String datosPersonales;
    private String datosFacturacion;

    public Cliente() {
    }

    public Cliente(int idCliente, String nombreCliente, String datosPersonales, String datosFacturacion) {
        this.idCliente = idCliente;
        this.nombreCliente = nombreCliente;
        this.datosPersonales = datosPersonales;
        this.datosFacturacion = datosFacturacion;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getDatosPersonales() {
        return datosPersonales;
    }

    public void setDatosPersonales(String datosPersonales) {
        this.datosPersonales = datosPersonales;
    }

    public String getDatosFacturacion() {
        return datosFacturacion;
    }

    public void setDatosFacturacion(String datosFacturacion) {
        this.datosFacturacion = datosFacturacion;
    }
    
    
    
}
