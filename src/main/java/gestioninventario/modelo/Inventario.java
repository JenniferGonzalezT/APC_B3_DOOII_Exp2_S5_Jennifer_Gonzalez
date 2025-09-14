package gestioninventario.modelo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
    
    public void eliminarProducto(String codigo) {
        productos.remove(codigo);
    }
    
    public Producto buscarProducto(String codigo) {
        return productos.get(codigo);
    }
    
    public List<String> mostrarInventario() {
        List<String> inventario = new ArrayList<>();
        
        if (productos.isEmpty()) {
            inventario.add("El inventario está vacío.");
            return inventario;
        }
        
        for (Producto producto : productos.values()) {
            inventario.add(producto.informacionProducto());
        }
        return inventario;
    }
}
