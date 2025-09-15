package gestioninventario.test.unitaria;

import gestioninventario.modelo.Producto;

public class ProductoTest {
    public static void main(String[] args) {
        System.out.println("PRUEBAS PRODUCTO");
        
        // Crear un producto
        System.out.println("\nCreando un producto...");
        Producto producto = new Producto("MON088", "Monitor", "Monitor curvo 24 pulgadas", 82900, 8);
        
        // Comprobar valores del producto creado
        System.out.println("Producto creado: " + producto.informacionProducto());
        
        // Actualización de atributos con setters
        producto.setCodigo("MON090");
        producto.setNombre("Monitor curvo");
        producto.setDescripcion("Monitor curvo de 24 pulgadas con altavoces");
        producto.setPrecio(85900);
        producto.setStock(7);
        System.out.println("\nProducto actualizado: " + producto.informacionProducto());
        
        // Cambiar y verificar el precio
        System.out.println("\nActualización precio");
        System.out.println("Precio original: " + producto.getPrecio());
        producto.actualizarPrecio(90000);
        System.out.println("Precio actualizado: " + producto.getPrecio());
        
        // Actualizar precio inválido
        System.out.println("\nIntentando actualizar precio con un valor no válido...");
        try {
            producto.actualizarPrecio(-100);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
