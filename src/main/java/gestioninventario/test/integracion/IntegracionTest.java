package gestioninventario.test.integracion;

import gestioninventario.modelo.Inventario;
import gestioninventario.modelo.Producto;

/**
 * Pruebas de integración entre Producto e Inventario
 */

public class IntegracionTest {
    public static void main(String[] args) {
        System.out.println("PRUEBAS DE INTEGRACION: PRODUCTO - INVENTARIO");
        
        // Crear un inventario
        System.out.println("\nCreando un inventario...");
        Inventario inventario = new Inventario();
        
        // Agregar productos al inventario
        System.out.println("\nAgregando productos al inventario...");
        inventario.agregarProducto(new Producto("TEC031", "Teclado", "Teclado gamer violeta con luces", 92000, 10));
        inventario.agregarProducto(new Producto("TEC032", "Teclado", "Teclado inalámbrico grafito", 39990, 5));
        inventario.agregarProducto(new Producto("MOU017", "Mouse", "Mouse ergonomico negro", 49990, 7));
        
        // Mostrar inventario
        // generarInventario() devuelve un ArrayList con los datos
        System.out.println("\nMostrando inventario:");
        for (String texto : inventario.generarInventario()) {
            System.out.println(texto);
        }
        
        // Buscar productos en el inventario
        // buscarProducto() devuelve un objeto Producto por lo que se debe
        // utilizar informacionProducto() para poder verlo por consola
        System.out.println("\nBuscar producto código #MOU017:");
        System.out.println(inventario.buscarProducto("MOU017").informacionProducto());
        System.out.println("\nBuscar producto código #TEC031:");
        System.out.println(inventario.buscarProducto("TEC031").informacionProducto());
        
        // Eliminar productos del inventario
        System.out.println("\nEliminando producto del inventario código #MOU017...");
        inventario.eliminarProducto("MOU017");
        
        // Mostrar inventario
        System.out.println("\nMostrando inventario:");
        for (String texto : inventario.generarInventario()) {
            System.out.println(texto);
        }
    }
}
