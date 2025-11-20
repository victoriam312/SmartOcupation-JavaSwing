package modelo;

public class Vivienda {
    // --- 1. ATRIBUTOS (Variables) ---
    private int idVivienda;
    private String codigoReferencia;
    private String ubicacion;
    private int metros;
    private int habitaciones;
    private int banos;
    private double precioAlquiler;
    
    // --- 2. CONSTRUCTORES ---
    //2.1.Constructor vacío 
    public Vivienda() { 
    }
    
    //2.2.Constructor completo
    public Vivienda(int idVivienda, String codigoReferencia, String ubicacion, int metros, int habitaciones, int banos, double precioAlquiler) {
        this.idVivienda = idVivienda;
        this.codigoReferencia = codigoReferencia;
        this.ubicacion = ubicacion;
        this.metros = metros;
        this.habitaciones = habitaciones;
        this.banos = banos;
        this.precioAlquiler = precioAlquiler;
    }
    
    // --- 3. GETTERS Y SETTERS ---
    public int getIdVivienda() {
        return idVivienda;
    }
    public void setIdVivienda(int idVivienda) {
        this.idVivienda = idVivienda;
    }

    public String getCodigoReferencia() {
        return codigoReferencia;
    }
    public void setCodigoReferencia(String codigoReferencia) {
        this.codigoReferencia = codigoReferencia;
    }

    public String getUbicacion() {
        return ubicacion;
    }
    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public int getMetros() {
        return metros;
    }
    public void setMetros(int metros) {
        this.metros = metros;
    }

    public int getHabitaciones() {
        return habitaciones;
    }
    public void setHabitaciones(int habitaciones) {
        this.habitaciones = habitaciones;
    }

    public int getBanos() {
        return banos;
    }
    public void setBanos(int banos) {
        this.banos = banos;
    }

    public double getPrecioAlquiler() {
        return precioAlquiler;
    }
    public void setPrecioAlquiler(double precioAlquiler) {
        this.precioAlquiler = precioAlquiler;
    }
    
    
}
