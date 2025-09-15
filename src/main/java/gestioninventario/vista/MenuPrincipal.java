package gestioninventario.vista;

import gestioninventario.modelo.Inventario;
import gestioninventario.modelo.Producto;
import java.util.Scanner;

public class MenuPrincipal {
    private final Scanner scanner;
    private final Inventario inventario;

    public MenuPrincipal(Inventario inventario) {
        this.scanner = new Scanner(System.in);
        this.inventario = inventario;
    }
    
    private void mostrarMenu() {
        System.out.println("\n===================== MENÚ ====================");
        System.out.println("(1) Agregar producto");
        System.out.println("(2) Eliminar producto");
        System.out.println("(3) Buscar producto por código");
        System.out.println("(4) Mostrar inventario");
        System.out.println("(0) Salir");
    }
    
    private int opcionMenu() {
        final int OPCION_MIN = 0;
        final int OPCION_MAX = 4;
        
        int opcion = 0;
        boolean opcionValida = false;
        String mensajeOpciones = "\nRecuerde ingresar un número de " + OPCION_MIN + " a " + OPCION_MAX;
        
        while (!opcionValida) {
            System.out.print("\nIngrese el número correspondiente a su opción: ");
            try {
                String entrada = scanner.nextLine().trim();
                opcion = Integer.parseInt(entrada);
                if (opcion >= OPCION_MIN && opcion <= OPCION_MAX) {
                    opcionValida = true;
                } else {
                    System.out.println("El número ingresado no es válido." + mensajeOpciones);
                }
            } catch (NumberFormatException e) {
                System.out.println("La entrada no es válida." + mensajeOpciones);
            }
        }
        return opcion;
    }
    
    public void accionMenu() {
        int opcion;
        do {
            mostrarMenu();
            opcion = opcionMenu();
            switch (opcion) {
                case 0:
                    System.out.println("\n==================== SALIR ====================");
                    System.out.println("Saliendo...\n¡Muchas gracias por su visita!");
                    break;
                case 1:
                    agregarProducto();
                    break;
                case 2:
                    eliminarProducto();
                    break;
                case 3:
                    buscarProducto();
                    break;
                case 4:
                    mostrarInventario();
                    break;
            }
        } while (opcion != 0);
        
        scanner.close();
    }
    
    private void agregarProducto() {
        System.out.println("\n=============== AGREGAR PRODUCTO ==============");
        
        
        String codigo = "";
        boolean codigoValido = false;
        while(!codigoValido) {
            codigo = leerCodigo();
            if (codigo.isBlank()) {
                System.out.println("El código no puede estar vacío. Intente nuevamente.");
            } else {
                codigoValido = true;
            }
        }
        
        String nombre = "";
        boolean nombreValido = false;
        while(!nombreValido) {
            System.out.print("\nIngrese el nombre del producto: ");
            nombre = scanner.nextLine().trim();
            if (nombre.isBlank()) {
                System.out.println("El nombre no puede estar vacío. Intente nuevamente.");
            } else {
                nombreValido = true;
            }
        }
        
        System.out.print("\nIngrese la descripción del producto: ");
        String descripcion = scanner.nextLine().trim();
        
        double precio = 0;
        boolean precioValido = false;
        while (!precioValido) {
            System.out.print("\nIngrese el precio del producto: $");
            try {
                String entrada = scanner.nextLine().trim();
                precio = Double.parseDouble(entrada);
                if (precio <= 0) {
                    System.out.println("El precio no es válido, debe ser mayor a 0. Intente nuevamente.");
                } else {
                    precioValido = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("La entrada no es válida, recuerde ingresar un número. Intente nuevamente.");
            }
        }
        
        int stock = 0;
        boolean stockValido = false;
        while (!stockValido) {
            System.out.print("\nIngrese el stock del producto: ");
            try {
                String entrada = scanner.nextLine().trim();
                stock = Integer.parseInt(entrada);
                if (stock < 0) {
                    System.out.println("El stock no es válido, debe ser mayor o igual a 0. Intente nuevamente.");
                } else {
                    stockValido = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("La entrada no es válida. Recuerde ingresar un número entero.");
            }
        }
        
        try {
            inventario.agregarProducto(new Producto(codigo, nombre, descripcion, precio, stock));
            System.out.println("Producto #" + codigo + " agregado.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
    
    private void eliminarProducto() {
        System.out.println("\n=============== ELIMINAR PRODUCTO =============");
        String codigo = leerCodigo();
        try {
            inventario.eliminarProducto(codigo);
            System.out.println("Producto #" + codigo + " eliminado.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
    
    private void buscarProducto() {
        System.out.println("\n================ BUSCAR PRODUCTO ==============");
        String codigo = leerCodigo();
        try {
            Producto producto = inventario.buscarProducto(codigo);
            System.out.println(producto.informacionProducto());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
    
    private void mostrarInventario() {
        System.out.println("\n=============== MOSTRAR INVENTARIO ============");
        for (String texto : inventario.generarInventario()) {
            System.out.println(texto);
        }
    }
    
    private String leerCodigo() {
        System.out.print("Ingrese el código del producto: #");
        return scanner.nextLine().trim().toUpperCase();
    }
}
