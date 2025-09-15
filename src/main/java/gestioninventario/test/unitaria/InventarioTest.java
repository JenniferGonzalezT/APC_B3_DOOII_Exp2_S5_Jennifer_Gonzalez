package gestioninventario.test.unitaria;

import gestioninventario.modelo.Inventario;
import gestioninventario.modelo.Producto;

public class InventarioTest {
    public static void main(String[] args) {
        System.out.println("PRUEBAS INVENTARIO");
        
        // Producto de prueba
        Producto producto = new Producto("MON088", "Monitor", "Monitor curvo 24 pulgadas", 82900, 8);
        
        // Crear un inventario
        System.out.println("\nCreando un inventario...");
        Inventario inventario = new Inventario();
        
        // Agregar producto al inventario
        System.out.println("\nAgregando producto al inventario...");
        inventario.agregarProducto(producto);
        
        // Verificar que el inventario contenga el producto
        System.out.println("Mostrar inventario:" + inventario.generarInventario());
        
        // Agregar un producto nulo
        // Esto lanzará un excepción que debemos manejar
        System.out.println("\nIntentando agregar un producto nulo...");
        try {
            inventario.agregarProducto(null);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        
        // Buscar producto
        // El método buscarProducto() devuelve un objeto Producto por lo que se
        // debe utilizar informacionProducto() para poder verlo por consola
        System.out.println("\nBuscar producto por código (MON088):");
        System.out.println(inventario.buscarProducto("MON088").informacionProducto());
        
        // Buscar producto inexistente
        // Esto lanzará una excepción que se debe manejar
        System.out.println("\nBuscar producto por código inexistente (MON008):");
        try {
            System.out.println(inventario.buscarProducto("MON008").informacionProducto());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        
        // Eliminar producto del inventario
        System.out.println("\nEliminando producto del inventario por código (MON088)...");
        inventario.eliminarProducto("MON088");
        
        // Verificar la eliminación del producto
        System.out.println("Mostrar inventario:" + inventario.generarInventario());
        
        // Eliminar un producto inexistente
        // Esto lanzará una excepción que se debe manejar
        System.out.println("\nIntentando eliminar producto por código inexistente (MON018)...");
        try {
            inventario.eliminarProducto("MON018");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
