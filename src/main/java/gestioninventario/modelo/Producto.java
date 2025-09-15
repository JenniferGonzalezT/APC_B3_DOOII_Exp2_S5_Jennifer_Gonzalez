package gestioninventario.modelo;

import gestioninventario.util.FormatoMoneda;

public class Producto {
    private String codigo;
    private String nombre;
    private String descripcion;
    private double precio;
    private int stock;

    public Producto(String codigo, String nombre, String descripcion, double precio, int stock) {
        this.codigo = validarStringObligatorio(codigo.toUpperCase(), "Código");
        this.nombre = validarStringObligatorio(nombre, "Nombre");
        this.descripcion = validarDescripcion(descripcion);
        this.precio = validarPrecio(precio);
        this.stock = validarIntPositivo(stock, "Stock");
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = validarStringObligatorio(codigo.toUpperCase(), "Código");
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = validarStringObligatorio(nombre, "Nombre");
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = validarDescripcion(descripcion);
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = validarPrecio(precio);
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = validarIntPositivo(stock, "Stock");
    }
    
    public void actualizarPrecio(double nuevoPrecio) {
        this.precio = validarPrecio(nuevoPrecio);
    }
    
    public String informacionProducto() {
        return "Producto #" + codigo +
               " - Nombre: " + nombre +
               " - Descripción: " + descripcion +
               " - Precio: " + FormatoMoneda.CLP(precio) +
               " - Stock: " + stock;
    }
    
    // Métodos privados para validaciones
    private String validarStringObligatorio(String campo, String nombreCampo) {
        if (campo == null || campo.isBlank()) {
            throw new IllegalArgumentException(nombreCampo + " no puede estar vacío.");
        }
        return campo.trim();
    }
    
    private double validarPrecio(double precio) {
        if (precio <= 0) {
            throw new IllegalArgumentException("El precio no puede ser negativo ni cero.");
        }
        return precio;
    }
    
    private int validarIntPositivo(int numero, String nombreNumero) {
        if (numero < 0) {
            throw new IllegalArgumentException(nombreNumero + " no puede ser negativo.");
        }
        return numero;
    }
    
    private String validarDescripcion(String descripcion) {
        return (descripcion == null || descripcion.isBlank()) ? "Sin descripción" : descripcion.trim();
    }
}
