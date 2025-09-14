package gestioninventario.modelo;

import java.util.HashMap;

public class Inventario {
    private HashMap<String, Producto> productos;

    public Inventario() {
        this.productos = new HashMap<>();
    }

    public HashMap<String, Producto> getProductos() {
        return productos;
    }

    public void setProductos(HashMap<String, Producto> productos) {
        this.productos = productos;
    }
    
    public void agregarProducto(Producto producto) {
        productos.put(producto.getCodigo(), producto);
    }
    
    public Producto buscarProducto(String codigo) {
        return productos.get(codigo);
    }
    
    public void mostrarInventario() {
        for (String codigo : productos.keySet()) {
            buscarProducto(codigo).descripcionProducto();
        }
    }
    
}
