package gestioninventario.vista;

import java.util.Scanner;

public class MenuPrincipal {
    private final Scanner scanner;

    public MenuPrincipal() {
        this.scanner = new Scanner(System.in);
    }
    
    public void mostrarMenu() {
        System.out.println("\n===================== MENÚ ====================");
        System.out.println("(1) Agregar producto");
        System.out.println("(2) Eliminar producto");
        System.out.println("(3) Buscar producto por código");
        System.out.println("(4) Mostrar inventario");
        System.out.println("(0) Salir");
    }
    
    public int opcionMenu() {
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
        
    }
    
    private void eliminarProducto() {
        
    }
    
    private void buscarProducto() {
        
    }
    
    private void mostrarInventario() {
        
    }
    
    
}
