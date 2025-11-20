package modelo;

import java.sql.Date;

public class Alquiler {
    private int idAlquiler;
    private String numExpediente;
    private java.sql.Date fechaEntrada; // Importante: Date de SQL
    private String tiempoEstimado;
    private String estadoCobros;
    private int idClienteFk; // Guardamos solo el ID del cliente
    private int idViviendaFk; // Guardamos solo el ID de la vivienda

    public Alquiler() {
    }

    public Alquiler(int idAlquiler, String numExpediente, Date fechaEntrada, String tiempoEstimado, String estadoCobros, int idClienteFk, int idViviendaFk) {
        this.idAlquiler = idAlquiler;
        this.numExpediente = numExpediente;
        this.fechaEntrada = fechaEntrada;
        this.tiempoEstimado = tiempoEstimado;
        this.estadoCobros = estadoCobros;
        this.idClienteFk = idClienteFk;
        this.idViviendaFk = idViviendaFk;
    }

    public int getIdAlquiler() {
        return idAlquiler;
    }

    public void setIdAlquiler(int idAlquiler) {
        this.idAlquiler = idAlquiler;
    }

    public String getNumExpediente() {
        return numExpediente;
    }

    public void setNumExpediente(String numExpediente) {
        this.numExpediente = numExpediente;
    }

    public Date getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(Date fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public String getTiempoEstimado() {
        return tiempoEstimado;
    }

    public void setTiempoEstimado(String tiempoEstimado) {
        this.tiempoEstimado = tiempoEstimado;
    }

    public String getEstadoCobros() {
        return estadoCobros;
    }

    public void setEstadoCobros(String estadoCobros) {
        this.estadoCobros = estadoCobros;
    }

    public int getIdClienteFk() {
        return idClienteFk;
    }

    public void setIdClienteFk(int idClienteFk) {
        this.idClienteFk = idClienteFk;
    }

    public int getIdViviendaFk() {
        return idViviendaFk;
    }

    public void setIdViviendaFk(int idViviendaFk) {
        this.idViviendaFk = idViviendaFk;
    }
    
    
}
